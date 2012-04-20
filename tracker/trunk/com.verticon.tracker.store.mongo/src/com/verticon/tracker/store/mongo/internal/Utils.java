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
import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.tracker.store.mongo.internal.StatusAndConfigVariables.LAST_UPDATE_TIME;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.StoreLogonException;
import com.verticon.tracker.store.ValidationException;
import com.verticon.tracker.util.CollectionFilter;
import com.verticon.tracker.util.FilterCriteria;
import com.verticon.tracker.util.TrackerUtils;

/**
 * @author jconlon
 * 
 */
public class Utils {

	private static final String URI = "uri";
	private static final String UPDATES_COL_NAME = "Updates";
	
	static String PLUGIN_ID = "com.verticon.tracker.store.mongo";
	/**
	 * slf4j Marker to keep track of bundle
	 */
    static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		Utils.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	static void validateObject(EObject eObject) throws ValidationException {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					throw new ValidationException(eObject,
							childDiagnostic.getMessage());
				}
			}

		}

	}

	static boolean isPersisted(OCD ocd, DB db) {
		DBObject doc = new BasicDBObject(Element.OCD.getIndexKey(), ocd.getID());
		// doc.put();
		DBCollection collection = db.getCollection(MetatypePackage.Literals.OCD
				.getName());
		return collection.find(doc).size() > 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws StoreLogonException
	 * 
	 * @generated
	 */
	static List<Event> filterEvents(List<Event> eventHistory, Date update) {
		List<Event> result = null;
		if (update == null) {
			result = eventHistory;
		} else if (!eventHistory.isEmpty()) {
			CollectionFilter<Event> eventsProducer = new CollectionFilter<Event>();
			eventsProducer.addFilter(Utils.createEventFilterCriteria(update));
			result = new ArrayList<Event>(
					eventsProducer.filterCopy(eventHistory));
			if (!result.isEmpty()) {
				Collections.sort(result, TrackerUtils.DATE_COMPARATOR);
			} else {
				result = eventHistory;
			}
		}
		return result;
	}

	static FilterCriteria<Event> createEventFilterCriteria(final Date update) {

		return new FilterCriteria<Event>() {

			@Override
			public boolean passes(Event event) {
				if (event.getDateTime().after(update)) {
					return true;
				}
				return false;

			}

		};
	}

	/**
	 * 
	 * @return the most current event associated with this animal
	 */
	static Date findMostCurrentEvent(List<Event> events) {
		List<Event> eventsByDate = new LinkedList<Event>(events);
		// Sort events according to date
		Collections.sort(eventsByDate, new Comparator<Event>() {
			public int compare(Event event1, Event event2) {
				return event2.getDateTime().compareTo(event1.getDateTime());
			}
		});
		return eventsByDate.get(0).getDateTime();
	}

	static boolean isAnimalPersisted(String ain, DB db) {
		DBObject doc = new BasicDBObject(Element.ANIMAL.getIndexKey(), ain);
		DBCollection collection = db
				.getCollection(TrackerPackage.Literals.ANIMAL.getName());
		return collection.find(doc).size() > 0;
	}

	@SuppressWarnings("unused")
	private static final Comparator<Tag> OLD_TO_NEW_TAG_COMPARATOR = Collections
			.reverseOrder(Utils.NEW_TO_OLD_TAG_COMPARATOR);
	static final Comparator<Tag> NEW_TO_OLD_TAG_COMPARATOR = new Comparator<Tag>() {
		public int compare(Tag a, Tag b) {
			Date d1 = findMostCurrentEvent(a.getEvents());
			Date d2 = findMostCurrentEvent(b.getEvents());
			return d1.compareTo(d2);
		}

	};

	static Set<String> intersection(List<Tag> list1, List<Tag> list2) {
		Collection<String> ids1 = transform(list1, new Function<Tag, String>() {
			@Override
			public String apply(Tag input) {
				checkNotNull(input);
				return input.getId();
			}
		});

		Collection<String> ids2 = transform(list2, new Function<Tag, String>() {
			@Override
			public String apply(Tag input) {
				checkNotNull(input);
				return input.getId();
			}
		});

		return Sets.intersection(Sets.newHashSet(ids1), newHashSet(ids2));
	}

	/**
	 * Logs on to service and retrieves the last update event
	 * 
	 * @param uri
	 * @param password
	 * @return
	 * @throws StoreLogonException
	 */
	static Date getLastUpdate(String uri,  DB db)
			throws StoreLogonException {
		DBObject update = getUpdate(uri, db);
		return update == null? null:(Date) update.get("update");
	}
	
	static void setLastUpdate(DB db, Date date, MongoStatusMonitor statusMonitor, String premisesURI) {
			DBCollection collection = db.getCollection(UPDATES_COL_NAME);
			DBObject searchQuery = new BasicDBObject(URI, premisesURI);
			BasicDBObject newValues = new BasicDBObject("update", date);
			BasicDBObject set = new BasicDBObject("$set", newValues);
			collection.update(searchQuery, set,true,false);//create it if it does not exist
			
			statusMonitor.setLastUpdate(date.getTime());
			statusMonitor.update(statusMonitor
					.getStatusVariable(LAST_UPDATE_TIME.statusVarID));
		}

	static List<Animal> filterAnimalsToRecord(List<Animal> animalsToUpdate,
			Date update) {
		List<Animal> result = null;
		if (update == null) {
			result = animalsToUpdate;
		} else {
			if (!animalsToUpdate.isEmpty()) {
				CollectionFilter<Animal> animalsProducer = new CollectionFilter<Animal>();
				animalsProducer.addFilter(createAnimalFilterCriteria(update));
				result = new ArrayList<Animal>(
						animalsProducer.filterCopy(animalsToUpdate));

			} else {
				result = animalsToUpdate;
			}

		}
		return result;
	}

	static FilterCriteria<Animal> createAnimalFilterCriteria(final Date update) {

		return new FilterCriteria<Animal>() {

			@Override
			public boolean passes(Animal animal) {
				if (animal.getLastEventDateTime().after(update)) {
					return true;
				}
				return false;

			}

		};
	}

	static Tag getTag(Animal animal, String id) {
		checkNotNull(animal);
		checkNotNull(id);
		for (Tag tag : animal.getTags()) {
			if (tag.getId().equals(id)) {
				return tag;
			}
		}
		return null;
	}

	/**
	 * @param uri
	 * @param password
	 * @return
	 * @throws StoreLogonException
	 */
	private static DBObject getUpdate(String uri,  DB db)
			throws StoreLogonException {
		if (Strings.isNullOrEmpty(uri)) {
			throw new StoreLogonException("The uri must not be null or empty."
					+ uri);

		}
		
		DBCollection collection = db.getCollection(UPDATES_COL_NAME);
		DBObject query = new BasicDBObject(URI, uri);

		DBObject member = collection.findOne(query);
		return member;
	}

	
//	private final Predicate<Animal> animalsInPremises = new Predicate<Animal>(){
//
//		@Override
//		public boolean apply(Animal input) {
//			
//			return false;
//		}
//		
//	};
//	
//	private static List<Animal> fromTags(List<EObject> eObjects){
//		Set<Animal> animals = newHashSet();
//		
//		for (EObject eo : eObjects) {
//			if(TrackerPackage.Literals.TAG.equals(eo.eClass())){
//				animals.add(((Tag)eo).getAnimal());
//			}
//		}
//		return newArrayList(animals);
//	}
	
//	private static class EventBefore implements Predicate<Event>{
//		private final Date when;
//		
//		EventBefore(Date when) {
//			super();
//			this.when = when;
//		}
//
//
//		@Override
//		public boolean apply(Event input) {
//			return input.getDateTime().before(when);
//		}
//		
//	}
	
//	private static class EventAfter implements Predicate<Event>{
//		private final Date when;
//		
//		EventAfter(Date when) {
//			super();
//			this.when = when;
//		}
//
//
//		@Override
//		public boolean apply(Event input) {
//			return input.getDateTime().after(when);
//		}
//	}
	
//	private List<Animal> getPremisesAnimals(String pin, Date in, Date out, List<Event> events ){
//		Collection<Event> filteredEvents = Collections2.filter(events, Predicates.and( new EventAfter(in), new EventBefore(out) ));
//		Set<Animal> animals = newHashSet();
//		
//		for (Event event : filteredEvents) {
//			animals.add(event.getTag().getAnimal());
//		}
//		return newArrayList(animals);
//	}

	static Integer getConfigurationInteger(Object o) {
		Integer result = null;
		if(o instanceof Integer){
			result = (Integer) o;
		}else if (o instanceof String){
			result = Integer.parseInt((String) o);
		}
		return result;
	}

	static Animal createDefaultAnimal(Integer key) {
		switch (key) {
		case TrackerPackage.BOVINE_BEEF:
			return TrackerFactory.eINSTANCE.createBovineBeef();
		case TrackerPackage.BOVINE_BISON:
			return TrackerFactory.eINSTANCE.createBovineBison();
		case TrackerPackage.BOVINE_DAIRY:
			return TrackerFactory.eINSTANCE.createBovineDairy();
		case TrackerPackage.CAPRINE:
			return TrackerFactory.eINSTANCE.createCaprine();
		case TrackerPackage.EQUINE:
			return TrackerFactory.eINSTANCE.createEquine();
		case TrackerPackage.OVINE:
			return TrackerFactory.eINSTANCE.createOvine();
		case TrackerPackage.SWINE:
			return TrackerFactory.eINSTANCE.createSwine();
		default:
			throw new IllegalArgumentException("unknown animal id: "
					+ key);
		}
	
	}
	
	

	
	
}
