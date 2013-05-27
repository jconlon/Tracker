/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store.mongo.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newLinkedList;
import static com.verticon.tracker.store.mongo.internal.Element.ANIMAL;
import static com.verticon.tracker.store.mongo.internal.Element.PREMISES;
import static com.verticon.tracker.store.mongo.internal.Element.TAG;
import static com.verticon.tracker.store.mongo.internal.Utils.bundleMarker;
import static com.verticon.tracker.store.mongo.internal.Utils.getLastUpdate;
import static com.verticon.tracker.store.mongo.internal.Utils.getTag;
import static com.verticon.tracker.store.mongo.internal.Utils.intersection;
import static com.verticon.tracker.store.mongo.internal.Utils.validateObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mongo.emf.ext.ECollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;
import com.verticon.location.Location;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.StoreAccessException;

/**
 * TrackerStrore for saves and queries Agriculture Location and Animal event
 * histories to and from a Utils database.
 * 
 * Saving premises is only done at registration time and for updates. Don't
 * bother with incremental changes just save the whole thing.
 * 
 * 
 * @author jconlon
 * 
 */
public class TrackerStore implements ITrackerStore {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(TrackerStore.class);
	private final MongoConsumer tagConsumer;
	private final MongoStatusMonitor statusMonitor;
	private final DateFormat dfm = new SimpleDateFormat(DATE_PATTERN);

	private ResourceSetFactoryContext resourceFactory;
	private String premisesURI;
	private DB db;
	private MergeListener mergeListener;
	private Predicate<Event> eventFilterByAuthority;

	TrackerStore(MongoStatusMonitor monitor, MongoConsumer tagConsumer) {
		super();
		this.statusMonitor = monitor;
		this.tagConsumer = tagConsumer;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#retrieveAnimal(java.lang.String)
	 */
	@Override
	public Animal retrieveAnimal(String ain) {
		return (Animal) resourceFactory.query(ANIMAL, ain);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#retrievePremises(java.lang.String
	 * , java.util.Date, java.util.Date)
	 */
	@Override
	public Premises retrievePremises(String uri, String fromDate, String toDate)
			throws IOException {
		Premises result = (Premises) resourceFactory.query(PREMISES, uri);
		findAndAddAnimalsToPremises(result, fromDate, toDate);
		return result;
	}

	private void findAndAddAnimalsToPremises(Premises premises, String fromDate, String toDate)
			throws IOException {
		if (Strings.isNullOrEmpty(fromDate) || Strings.isNullOrEmpty(toDate)) {
			// Do nothing to the result
		} else {
			// Add animals to the result
			List<Animal> animals;
			try {
				animals = getAnimals(db, resourceFactory, premises.getUri(),
						dfm.parse(fromDate), dfm.parse(toDate),
						eventFilterByAuthority);
			} catch (ParseException e) {
				throw new IOException(e);
			}
			logger.debug(bundleMarker,
					"Found {} animals in premises from {} to {}", new Object[] {
							animals.size(), fromDate, toDate });
			Collections.sort(animals, new Comparator<Animal>() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see java.util.Comparator#compare(java.lang.Object,
				 * java.lang.Object)
				 */
				@Override
				public int compare(Animal a1, Animal a2) {
					return a1.getId().compareTo(a2.getId());
				}
			});
			premises.getAnimals().addAll(animals);

		}
	}

/**
	 * 
	 * Get Animals that have events with dates between the time frames. Filter out events
	 * that this premises is not authorized to access.
	 * 
	 * Using Mongo-EMF queries like
	 * String query = '('+ EVENTS_PID +" = "+uri + ") && 
	 *  ("+EVENTS_DATE_TIME+" > "+fromDate +") && ("+EVENTS_DATE_TIME+" < "+toDate+')';
	 * Restrict one to get only the complete Tag element back and generate a queries like:
	 *  db.Tag.find({'events.dateTime': {$gte: start, $lt: end}})
	 *  
	 *  This will return all animals with tags that have events greater than 4-12 and le than the 4-13
	 *  not just tags with 4-12 events meets these criteria tags that have events earlier than
	 *  4-12 and later than 4-12
	 *  In other words events that surround the time period - which from an application point of view is wrong
	 *  
	 * Instead use DBObjects directly and query Tags to return only the _eProxyURI attribute and with 
	 * a query that uses the $elemnMatch to insure that each of the events.dateTime elements
	 * are evaluated against all the attributes parameters - pid and dateTime from and dateTime to.
	 * 
	 * Then from the returned _eProxyURI get the Animals.
	 * 
	 * @param db
	 * @param resourceFactory
	 * @param uri
	 * @param fromDate
	 * @param toDate
	 * @return animals 
	 */
	private static List<Animal> getAnimals(DB db,
			ResourceSetFactoryContext resourceFactory, String uri,
			Date fromDate, Date toDate, Predicate<Event> canRead) {
		List<Animal> result = new ArrayList<Animal>();

		BasicDBObject dateMatch = new BasicDBObject();
		dateMatch.put("dateTime", new BasicDBObject(QueryOperators.GTE,
				fromDate).append(QueryOperators.LT, toDate));
		// {dateTime:{$gte:fromDate,$lt:toDate}}

		BasicDBObject elementMatch = new BasicDBObject();
		elementMatch.put("$elemMatch", dateMatch.append("pid", uri));
		BasicDBObject query = new BasicDBObject("events", elementMatch);

		BasicDBObject keysToReturn = new BasicDBObject();
		keysToReturn.put("animal._eProxyURI", 1);

		// logger.info(bundleMarker, "query: {}",query);

		Set<String> mongoIDs = new HashSet<String>();
		DBCursor cur = db.getCollection("Tag").find(query, keysToReturn);
		while (cur.hasNext()) {
			DBObject response = cur.next();

			DBObject subResult = (DBObject) response.get("animal");
			String proxy = (String) subResult.get("_eProxyURI");
			// "../Animal/4f5e3604a8d60b3072b2e919#840003002956464"
			// | |
			String mongoID = proxy.substring(proxy.lastIndexOf('/') + 1,
					proxy.lastIndexOf('#'));
			mongoIDs.add(mongoID);
		}
		for (String mongoID : mongoIDs) {
			Resource resource = resourceFactory.getResource(ANIMAL, mongoID);
			if (resource != null && resource.getAllContents().hasNext()) {

				result.add((Animal) resource.getContents().get(0));
			}
		}
		if (!result.isEmpty()) {
			result = (List<Animal>) EcoreUtil.copyAll(result);

			// remove all events that are not authorized to be read by this
			// premises
			for (Animal animal : result) {
				for (Tag tag : animal.getTags()) {
					Collection<Event> accessibleEvents = Collections2.filter(
							tag.getEvents(), canRead);
					tag.getEvents().retainAll(accessibleEvents);
				}
			}

		}
		return result;
	}

	@Override
	public EList<EObject> query(EClass eClass, String query) {
		ECollection result = resourceFactory.query(eClass, query);
		return result.getValues();
	}


	/**
	 * Primary entry method for Tracker Desktop clients. Does NOT save animals,
	 * events, and tags.
	 * 
	 * Premises are saved in the Premises collection but they do not contain
	 * proxies to the animals, but events are tagged with an _pid to indicate
	 * which Premises uri saved them to the store.
	 * 
	 * Animals are saved with Tag proxies and Tags contain actual events. Events
	 * do not have their own Collection.
	 */
	@Override
	public void register(Premises premises) throws IOException {
		checkNotNull(premises, "Premises must not be null.");
		Location location = premises.getLocation();
		checkNotNull(location, "Premises location must not be null.");
		validateObject(premises);

		// if (!trackerStoreAdmin.isCurrentUserAdmin()) {
		// throw new StoreAccessException(
		// "Attempt to save premises with out administration privelages.");
		// }

		// if (!trackerStoreAdmin.isValidUri(premises.getUri())) {
		// throw new StoreAccessException(
		// "Attempt to save premises with a foriegn uri on the Premises that is not set up in the Administration access control.");
		// }

		// Premises
		Premises targetPremises = EcoreUtil.copy(premises);
		Premises persistedPremises = retrievePremises(premises.getUri(), null,
				null);
		resourceFactory.add(targetPremises, Element.PREMISES);
		recordChangesAndNoAnimals(targetPremises, persistedPremises);
		assert (targetPremises.eResource().getURI().toString()
				.startsWith("mongo://"));
	}

	@Override
	public IUpdateStats recordAnimals(Premises premises) throws IOException {
		checkNotNull(premises, "Premises must not be null.");
		validateObject(premises);
		String uri = premises.getUri();
		List<Animal> animals = premises.getAnimals();
		return record(uri, animals);
	}

	@Override
	public IUpdateStats record(String uri, List<Animal> animals)
			throws IOException {
		if (!uri.equals(premisesURI)) {
			throw new StoreAccessException(
					"Attempt to save animals from a premises with a foriegn uri.");
		}

		int start = statusMonitor.getStatusVariable(
				StatusAndConfigVariables.TOTAL_ANIMALS_PROCESSED.statusVarID)
				.getInteger();

		logger.debug(bundleMarker, "Recording {} animals", animals.size());
		List<Animal> animalsToProcess = Utils.filterAnimalsToRecord(
animals,
				getLastUpdate(premisesURI, db));

		for (Animal animal : animalsToProcess) {
			recordAnimal(animal);
		}
		if (!animalsToProcess.isEmpty()) {
			Date mostCurrentEvent = findMostCurrentEvent(animals);
			Utils.setLastUpdate(db, mostCurrentEvent, statusMonitor,
					premisesURI);
			statusMonitor.addTotalAnimalsProcessed(animalsToProcess.size());
		}
		int finish = statusMonitor.getStatusVariable(
				StatusAndConfigVariables.TOTAL_ANIMALS_PROCESSED.statusVarID)
				.getInteger();
		return new UpdateStats(finish - start, 0, 0);
	}



	@Override
	public Premises retrievePremises(String uri) throws IOException {
		return retrievePremises(uri, null, null);
	}

	@Override
	public Premises retrievePremises(LongLatPoint point) throws IOException {
		return retrievePremises(point, null, null);
	}

	@Override
	public Premises retrievePremises(LongLatPoint point, String fromDate,
			String toDate) throws IOException {
		Premises result = null;
		String query = "{'location.loc' : {$near : [" + point.getLongLat()
				+ "]}}";
		List<EObject> eo = query(TrackerPackage.Literals.PREMISES, query);

		for (EObject eObject : eo) {
			if (eObject instanceof Premises) {
				Premises premises = (Premises) eObject;
				if (premises.getLocation() != null
						&& premises.getLocation().containsPoint(
								point.toString())) {
					result = premises;
					break;
				}
			}
		}

		this.findAndAddAnimalsToPremises(result, fromDate, toDate);
		return result;

	}
	
	@Override
	public String uri() {
		return resourceFactory != null ? resourceFactory.getMongoBaseURI()
				: null;
	}

	void activate(ResourceSetFactoryContext resourceFactory,
			String premisesURI, DB db, Predicate<Event> eventFilterByAuthority) {
		logger.debug(bundleMarker, "Activating");
		this.resourceFactory = resourceFactory;
		this.premisesURI = premisesURI;
		this.db = db;
		this.eventFilterByAuthority = eventFilterByAuthority;
		// TODO need mergelisteners??
		mergeListener = new MergeListener(db);
		MergeService.addMergeListener(mergeListener);
		logger.debug(bundleMarker, "Activated");
	}

	void deactivate() {
		MergeService.removeMergeListener(mergeListener);
		resourceFactory = null;
		premisesURI = null;
		db = null;
		eventFilterByAuthority = null;
		mergeListener = null;
		logger.debug(bundleMarker, "Deactivated");
	}

	// /**
	// *
	// * @param copiedContainer
	// * @param persistedContainer
	// * may be null
	// * @param resourceSet
	// * @return
	// * @throws IOException
	// */
	// private boolean recordChanges(Container copiedContainer,
	// Container persistedContainer) throws IOException {
	// resourceFactory.add(copiedContainer, CONTAINER);
	// if (persistedContainer != null) {
	// copiedContainer.eResource().setURI(
	// persistedContainer.eResource().getURI());
	//
	// }
	// assert (copiedContainer.eResource().getURI().toString()
	// .startsWith("mongo://"));
	// resourceFactory.save(copiedContainer, CONTAINER);
	// return true;
	// }

	// private boolean recordChanges(Placemark copiedPlacemark,
	// Placemark persistedPlacemark) throws IOException {
	// resourceFactory.add(copiedPlacemark, PLACEMARK);
	// if (persistedPlacemark != null) {
	// copiedPlacemark.eResource().setURI(
	// persistedPlacemark.eResource().getURI());
	//
	// }
	// assert (copiedPlacemark.eResource().getURI().toString()
	// .startsWith("mongo://"));
	// resourceFactory.save(copiedPlacemark, PLACEMARK);
	// return true;
	// }

	/**
	 * Animals need to be saved to the Animal collection
	 * 
	 * @param copiedPremises
	 * @param persistedPremises
	 *            may be null
	 * @param resourceSet
	 * @return
	 * @throws IOException
	 */
	private boolean recordChangesAndNoAnimals(Premises copiedPremises,
			Premises persistedPremises) throws IOException {

		Premises targetPremises = null;

		// Clean up the copy.
		copiedPremises.getUnAppliedTags().clear();
		// Remove the animals
		copiedPremises.getAnimals().clear();
		resourceFactory.add(copiedPremises, PREMISES);

		if (persistedPremises != null) {
			copiedPremises.eResource().setURI(
					persistedPremises.eResource().getURI());
			try {
				DiffModel diff = getDiff(copiedPremises, persistedPremises);
				final List<DiffElement> differences = new ArrayList<DiffElement>(
						diff.getDifferences());
				if (differences.isEmpty()) {
					return false;// nothing has changed
				} else {
					mergeListener.setException(null);
					MergeService.merge(differences, true);// Merge leftToRight
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new IOException(e.getMessage());
			}
			if (mergeListener.getException() != null) {
				throw mergeListener.getException();
			}
			// TODO Update all Premises attributes
			targetPremises = persistedPremises;

		} else {
			// New premises
			targetPremises = copiedPremises;
		}
		resourceFactory.save(targetPremises, PREMISES);
		assert (targetPremises.eResource().getURI().toString()
				.startsWith("mongo://"));

		return true;
	}

	private static DiffModel getDiff(EObject v1, EObject v2) throws Exception {
		MatchModel match = new GenericMatchEngine().contentMatch(v1, v2,
				Collections.<String, Object> emptyMap());
		DiffModel diff = new GenericDiffEngine().doDiff(match);
		return diff;
	}

	/**
	 * Primary entry for saving animals
	 * 
	 * @param animalIn
	 * @throws IOException
	 */
	private void recordAnimal(Animal animal) throws IOException {
		checkNotNull("Animal must not be null.", animal);
		checkNotNull("Animal id must not be null.", animal.getId());

		Animal presistedAnimal = retrieveAnimal(animal.getId());
		if (presistedAnimal != null) {
			// Animal is persisted with the same id
			saveEventsToPersistedAnimal(animal, presistedAnimal);
			return;
		}

		if (animal.getTags().size() > 1) {
			// Animal is not persisted with its current id
			Animal persistedAnimalWithOldTag = findPersistedAnimalWithOldID(animal);
			if (persistedAnimalWithOldTag != null) {
				// Animal is persisted with an old id
				saveTagEventsToPresistedAnimalWithOldID(animal,
						persistedAnimalWithOldTag);
				statusMonitor.incrementTotalAnimalsUpdated();

			} else {
				// Just a new animal with multiple tags
				tagConsumer.save(EcoreUtil.copy(animal));
			}
			return;
		}

		// new animal save it
		tagConsumer.save(EcoreUtil.copy(animal));
		return;

	}

	/**
	 * Saves events and Tags to a persistent animal when the source animal has
	 * one or more new tags and may have events in some of the older tags.
	 * 
	 * @param sourceAnimal
	 * @param persistedAnimalWithOldTag
	 * @throws IOException
	 */
	private void saveTagEventsToPresistedAnimalWithOldID(Animal sourceAnimal,
			Animal persistedAnimalWithOldTag) throws IOException {

		Set<String> intersection = intersection(
				persistedAnimalWithOldTag.getTags(), sourceAnimal.getTags());
		for (String id : intersection) {
			// Same tag on persisted and target
			Tag persistedTag = Utils.getTag(persistedAnimalWithOldTag, id);

			Tag tag = Utils.getTag(sourceAnimal, id);
			if (persistedTag != null) {
				Collection<Event> newerEventsToAdd = NewerEvents
						.getNewerEvents(tag, persistedTag);

				// Optional<NewerEvents> newerEvents = NewerEvents
				// .isNewer(persistedTag);
				// if (newerEvents.isPresent()) {
				// // There are newer events on the target
				// // add them to the persisted tag
				// Collection<Event> newerEventsToAdd = Collections2.filter(
				// tag.getEvents(), newerEvents.get());
				if (!newerEventsToAdd.isEmpty()) {
					tagConsumer.addNewOCDs(newerEventsToAdd);
					persistedTag.getEvents().addAll(
							EcoreUtil.copyAll(newerEventsToAdd));
					resourceFactory.save(persistedTag, TAG);

				}
			}
		}
		// There will be newer tags to add to the old animal
		List<Tag> tagsNotInAnimal = tagsNotInAnimal(sourceAnimal.getTags(),
				persistedAnimalWithOldTag);
		if (!tagsNotInAnimal.isEmpty()) {
			Collection<Tag> tags = EcoreUtil.copyAll(tagsNotInAnimal);
			for (Tag tag : tags) {
				resourceFactory.add(tag, TAG);
				persistedAnimalWithOldTag.getTags().add(tag);
				resourceFactory.save(tag, TAG);

			}

			// have to save the animal again
			resourceFactory.save(persistedAnimalWithOldTag, ANIMAL);
			// and save all the new tags a second time
			for (Tag tag : tags) {
				resourceFactory.save(tag, TAG);
			}

		}
	}

	/**
	 * Saves events from a source animal to a persisted animal
	 * 
	 * @param sourceAnimal
	 * @param presistedAnimal
	 * @throws IOException
	 */
	private void saveEventsToPersistedAnimal(Animal sourceAnimal,
			Animal presistedAnimal) throws IOException {
		// The latest tag is the active one
		// Optional<NewerEvents> newerEvents =
		// NewerEvents.isNewer(presistedAnimal
		// .activeTag());
		// if (newerEvents.isPresent()) {
		// Collection<Event> newerEventsToAdd = Collections2.filter(
		// sourceAnimal.activeTag().getEvents(), newerEvents.get());
		if (presistedAnimal.activeTag() != null) {
			Collection<Event> newerEventsToAdd = NewerEvents.getNewerEvents(
					sourceAnimal.activeTag(), presistedAnimal.activeTag());

			if (newerEventsToAdd.isEmpty()) {
				// Tag is already persisted with all the events
			} else {
				Collection<Event> copiedEvents = EcoreUtil
						.copyAll(newerEventsToAdd);
				// Add all new events to the active tag

				tagConsumer.addNewOCDs(copiedEvents);
				presistedAnimal.activeTag().getEvents().addAll(copiedEvents);
				resourceFactory.save(presistedAnimal.activeTag(), TAG);
				// if (synchedLifeData(animal, presistedAnimal)) {
				// resourceFactory.save(presistedAnimal, ANIMAL);
				// }
				statusMonitor.incrementTotalAnimalsUpdated();

			}
		}
	}

	private static List<Tag> tagsNotInAnimal(List<Tag> list1, Animal animal) {
		List<Tag> result = newArrayList();
		for (Tag tag : list1) {
			// is tag the animal
			if (getTag(animal, tag.getId()) == null) {
				result.add(tag);
			}
		}

		return result;
	}

	private Animal findPersistedAnimalWithOldID(Animal animal) {
		Animal result = null;
		for (Tag tag : animal.getTags()) {
			result = retrieveAnimal(tag.getId());
			if (result != null) {
				break;
			}
		}

		return result;
	}

	
	/**
	 * 
	 * @return the most current event associated with this animal
	 */
	private static Date findMostCurrentEvent(Iterable<Animal> animals) {
		List<Event> eventsByDate = newLinkedList();
		for (Animal animal : animals) {
			eventsByDate.addAll(animal.eventHistory());
		}
		// Sort events according to date
		return findMostCurrentEvent(eventsByDate);
	}

	private static Date findMostCurrentEvent(List<Event> eventsByDate) {
		Collections.sort(eventsByDate, new Comparator<Event>() {
			@Override
			public int compare(Event event1, Event event2) {
				return event2.getDateTime().compareTo(event1.getDateTime());
			}
		});
		return eventsByDate.get(0).getDateTime();
	}


}
