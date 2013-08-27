package com.verticon.tracker.store.mongodb.internal;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newLinkedList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.tracker.store.mongodb.internal.Utils.ANIMAL;
import static com.verticon.tracker.store.mongodb.internal.Utils.ID_KEY;
import static com.verticon.tracker.store.mongodb.internal.Utils.OCD;
import static com.verticon.tracker.store.mongodb.internal.Utils.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.internal.Utils.TAG;
import static com.verticon.tracker.store.mongodb.internal.Utils.UPDATES;
import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;
import static java.util.Collections.emptyList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Tag;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.StoreLogonException;
import com.verticon.tracker.store.TrackerStoreUtils;
import com.verticon.tracker.store.UpdateStats;

public class AnimalRecorder {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(AnimalRecorder.class);

	private static final String $SET = "$set";
	private static final String UPDATE_KEY = "update";
	private static final String EVENTS_KEY = "events";
	private static final String $PUSH = "$push";
	private static final String ANIMAL_KEY = "animal";
	private static final String $ADD_TO_SET = "$addToSet";
	private static final String $EACH = "$each";
	private static final String TAGS_KEY = "tags";
	private final Function<EObject, DBObject> eToDB;
	private final UpdateAndFind updateAndFind;

	AnimalRecorder(UpdateAndFind updateAndFind) {
		this.updateAndFind = updateAndFind;
		this.eToDB = updateAndFind.getFunctionProvider()
				.getEObjectToDBObjectFunction();
	}

	IUpdateStats record(Premises premises) throws StoreLogonException {
		String uri = premises.getUri();
		List<Animal> animals = premises.getAnimals();
		return record(uri, animals);
	}

	/**
	 * Records all the new Animals, Tags and Events.
	 * 
	 * @param uri
	 * @param animals
	 * @return status
	 * @throws StoreLogonException
	 */
	IUpdateStats record(String uri, List<Animal> animals)
			throws StoreLogonException {
		// Find out the latest update
		Date lastUpdate = getLastUpdate(uri);
		logger.debug(bundleMarker, "Last Animal recording {}", lastUpdate);
		// Get all the animals that need to be processed
		Iterable<Animal> animalsWithNewAndUnpublishedEvents = Iterables.filter(
				animals,
				new TrackerStoreUtils.AnimalsWithNewAndUnpublishedEvents(
						lastUpdate));

		if (Iterables.isEmpty(animalsWithNewAndUnpublishedEvents)) {
			String message = String
					.format("There are no new animal events since last publish date: %s",
							lastUpdate);
			logger.debug(bundleMarker, message);
			UpdateStats result = new UpdateStats();
			result.setComment(message);
			return result;
		}

		List<AnimalUpdate> allUpdates = newArrayList(Iterables.transform(
				animalsWithNewAndUnpublishedEvents,
				new Utils.AnimalsToAnimalUpdates(lastUpdate, uri)));

		readTags(allUpdates);

		for (AnimalUpdate animalUpdate : allUpdates) {
			animalUpdate.validate();
		}

		insertAnimals(allUpdates);

		Set<OCD> ocdToUpdate = newHashSet();

		Iterable<OCD> ocds = insertTags(allUpdates);
		Iterables.addAll(ocdToUpdate, ocds);

		updateAnimalsWithTagIds(allUpdates);

		ocds = processEvents(allUpdates);
		Iterables.addAll(ocdToUpdate, ocds);

		insertNewOCDs(ocdToUpdate);

		UpdateStats updateStats = new UpdateStats();

		for (AnimalUpdate animalUpdate : allUpdates) {
			animalUpdate.finish(updateStats);
		}
		Date mostCurrentEvent = findMostCurrentEvent(animals);

		setUpdate(mostCurrentEvent, uri);

		updateStats.setAnimalsProcessed(allUpdates.size());
		return updateStats;
	}

	private void updateAnimalsWithTagIds(List<AnimalUpdate> allUpdates) {
		// Find all updates for states Tag and EventsTag
		Iterable<AnimalUpdate> createdNewTags = Iterables.filter(allUpdates,
				Utils.createdNewTags);
		if (Iterables.size(createdNewTags) == 0) {
			return;
		}

		for (AnimalUpdate animalUpdate : createdNewTags) {
			List<String> targetTagIDs = newArrayList(Iterables.transform(
					animalUpdate.getTags(), Utils.tagToId));
			ObjectId animal = animalUpdate.getAnimalOID();
			DBObject listItem = new BasicDBObject(TAGS_KEY, new BasicDBObject(
					$EACH, targetTagIDs));
			DBObject update = new BasicDBObject($ADD_TO_SET, listItem);
			DBCollection coll = updateAndFind.getCollection(ANIMAL);
			coll.update(new BasicDBObject(ID_KEY, animal), update);

		}
	}

	/**
	 * Creates a list of all the tag ids in the updates and use it to create a
	 * single query to find all the persisted tags and add them to each entry.
	 * 
	 * 
	 * @param allUpdates
	 */
	private void readTags(Iterable<AnimalUpdate> allUpdates) {

		Map<String, AnimalUpdate> updateMap = newHashMap();

		for (AnimalUpdate animalUpdate : allUpdates) {
			Animal animal = animalUpdate.getAnimal();
			// For every tag id there will be a map to the animal update
			// For animals with multiple tags there will be multiple keys to the
			// same animalUpdate
			for (Tag tag : animal.getTags()) {
				updateMap.put(tag.getId(), animalUpdate);
				processReplacedTags(tag.getEvents(), updateMap, animalUpdate);
			}
		}

		List<String> tagIds = newArrayList(updateMap.keySet());

		BasicDBObject q = new BasicDBObject();
		q.put(ID_KEY, new BasicDBObject(QueryOperators.IN, tagIds));
		DBCollection coll = updateAndFind.getCollection(TAG);
		DBObject f = new BasicDBObject(ANIMAL_KEY, 1);

		// Query for all the tagIds and retrieving only the animal ObjectId
		// Save the Animal ObjectId reference in each AnimalUpdate
		DBCursor cursor = coll.find(q, f);
		for (DBObject dbObject : cursor) {
			AnimalUpdate animalUpdate = updateMap.get(dbObject.get(ID_KEY));
			animalUpdate.addPersistedTag(dbObject.toMap());
		}
	}

	private void processReplacedTags(Iterable<Event> events,
			Map<String, AnimalUpdate> updateMap, AnimalUpdate animalUpdate) {
		for (Event event : events) {
			if (event instanceof ReplacedTag) {
				ReplacedTag replacedTag = (ReplacedTag) event;
				updateMap.put(replacedTag.getOldId(), animalUpdate);
			}
		}
	}

	/**
	 * Inserts new OCDs
	 * 
	 * @param ocds
	 */
	private void insertNewOCDs(Iterable<OCD> ocds) {

		DBCollection coll = updateAndFind.getCollection(OCD);

		for (OCD ocd : ocds) {
			OCD result = updateAndFind.find(ocd.getID());
			if (result == null) {
				DBObject dbo = eToDB.apply(ocd);
				coll.insert(dbo);
			}
		}

	}

	/**
	 * Get all the animals and does a bulk insert to the Animal table
	 * 
	 * @param allUpdates
	 */
	private void insertAnimals(Iterable<AnimalUpdate> allUpdates) {
		Iterable<AnimalUpdate> animalUpdates = Iterables.filter(allUpdates,
				Utils.animalUpdates);
		if (Iterables.size(animalUpdates) == 0) {
			return;
		}
		List<DBObject> dboList = Lists.newArrayList();

		for (AnimalUpdate animalUpdate : animalUpdates) {
			Animal animal = animalUpdate.getAnimal();
			Animal copy = EcoreUtil.copy(animal);
			Iterable<String> tagIds = Iterables.transform(animal.getTags(),
					Utils.tagToId);
			copy.getTags().clear();
			BasicDBObject animalDBObject = (BasicDBObject) eToDB.apply(copy);
			BasicDBList list = new BasicDBList();
			Iterables.addAll(list, tagIds);
			animalDBObject.put(TAGS_KEY, list);
			animalUpdate.setAnimalDBObject(animalDBObject);
			dboList.add(animalDBObject);
		}
		DBCollection coll = updateAndFind.getCollection(ANIMAL);

		// Inserting the list will create ObjectIds for all the dbos
		// of animals. Each DBObject is referenced by the AnimalUpdate
		// so that this reference can be used for building Tags
		coll.insert(dboList);

	}

	private Set<OCD> processEvents(Iterable<AnimalUpdate> allUpdates) {
		Iterable<AnimalUpdate> eventUpdates = Iterables.filter(allUpdates,
				Utils.eventUpdates);
		if (Iterables.size(eventUpdates) == 0) {
			return Collections.emptySet();
		}
		// Go through each update and do a bulk insert of events into a Tag
		Set<OCD> ocds = newHashSet();
		for (AnimalUpdate eventUpdate : eventUpdates) {
			Multimap<String, Event> events = eventUpdate.getEvents();
			for (String tagId : events.keySet()) {
				Iterable<OCD> updatedOcds = updateTag(tagId, events.get(tagId));
				Iterables.addAll(ocds, updatedOcds);
			}

		}
		return ocds;
	}

	/**
	 * Get all the tags and do a bulk insert to the Tag table Must add
	 * animal:ObjectId reference to each tag.
	 * 
	 * @param allUpdates
	 */
	private Set<OCD> insertTags(Iterable<AnimalUpdate> allUpdates) {
		Iterable<AnimalUpdate> tagUpdates = Iterables.filter(allUpdates,
				Utils.tagUpdates);
		if (Iterables.size(tagUpdates) == 0) {
			return Collections.emptySet();
		}
		List<DBObject> dbos = newArrayList();
		Set<OCD> result = newHashSet();
		for (AnimalUpdate animalUpdate : tagUpdates) {
			ObjectId animalOid = animalUpdate.getAnimalOID();
			for (Tag tag : animalUpdate.getTags()) {
				BasicDBObject dbo = (BasicDBObject) eToDB.apply(tag);
				dbo.put(ANIMAL_KEY, animalOid);
				dbos.add(dbo);
				Iterable<Event> ges = Iterables.filter(tag.getEvents(),
						Predicates.instanceOf(GenericEvent.class));
				Iterable<OCD> ocds = Iterables.transform(ges, Utils.eventToOCD);
				Iterables.addAll(result, ocds);
			}
		}
		DBCollection coll = updateAndFind.getCollection(TAG);
		coll.insert(Lists.newArrayList(dbos));
		return result;
	}

	/**
	 * Update Tag with a list of events
	 * 
	 * @param tagId
	 * @param events
	 * @return
	 */
	private Iterable<OCD> updateTag(String tagId, Iterable<Event> events) {
		Iterable<DBObject> dbos = Iterables.transform(events, eToDB);
		DBCollection coll = updateAndFind.getCollection(TAG);
		BasicDBList dbList = new BasicDBList();
		Iterables.addAll(dbList, dbos);

		DBObject update = pushAll(dbList);
		// DBObject update = push(dbList);

		coll.update(new BasicDBObject(ID_KEY, tagId), update);

		Iterable<Event> ges = Iterables.filter(events,
				Predicates.instanceOf(GenericEvent.class));
		// If the generic events cannot find a reference to the OCD
		// because for example the ocd reference is broken
		// filter these out.
		if (!Iterables.isEmpty(ges)) {
			GenericEvent res = (GenericEvent) Iterables.get(ges, 0);
			if (res.getOcd() == null || res.getOcd().getID() == null) {
				return emptyList();
			}
		}
		return Iterables.transform(ges, Utils.eventToOCD);
	}

	/**
	 * This is the newer way to push all the elements of the list into an array.
	 * 
	 * @param dbList
	 * @return
	 */
	@SuppressWarnings("unused")
	private DBObject push(BasicDBList dbList) {
		// db.collection.update( { field: value }, { $push: { field1: { $each: [
		// value1, value2, value3 ] } } } )
		DBObject listItem = new BasicDBObject(EVENTS_KEY, new BasicDBObject(
				$EACH, dbList));
		DBObject update = new BasicDBObject($PUSH, listItem);
		return update;
	}

	/**
	 * @deprecated in Mongo 2.4 use push
	 * @param dbList
	 * @return
	 */
	@Deprecated
	private DBObject pushAll(BasicDBList dbList) {
		// db.collection.update( { field: value }, { $pushAll: { field1: [
		// value1, value2, value3 ] } } );
		DBObject listItem = new BasicDBObject(EVENTS_KEY, dbList);
		DBObject update = new BasicDBObject("$pushAll", listItem);
		return update;
	}

	/**
	 * Logs on to service and retrieves the last update event
	 * 
	 * @param uri
	 * @param password
	 * @return
	 * @throws StoreLogonException
	 */
	private Date getLastUpdate(String uri) throws StoreLogonException {
		DBCollection collection = updateAndFind.getCollection(UPDATES);
		DBObject query = new BasicDBObject(PREMISES_URI, uri);
		DBObject update = collection.findOne(query);
		return update == null ? null : (Date) update.get(UPDATE_KEY);
	}

	private void setUpdate(Date date, String premisesURI) {
		DBCollection collection = updateAndFind.getCollection(UPDATES);
		DBObject searchQuery = new BasicDBObject(PREMISES_URI, premisesURI);
		BasicDBObject newValues = new BasicDBObject(UPDATE_KEY, date);
		BasicDBObject set = new BasicDBObject($SET, newValues);
		collection.update(searchQuery, set, true, false);// create it if it does
															// not exist
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
