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

package com.verticon.tracker.store.mongodb.internal;

import java.util.Date;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.mongodb.DBObject;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.ValidationException;

/**
 * @author jconlon
 * 
 */
public class Utils {

	static final String PREMISES_URI = "uri";
	/**
	 * MongoDB ID field identifier.
	 */
	static final String ID_KEY = "_id";
	static final String ANIMAL = "Animal";
	static final String PREMISES = "Premises";
	static final String UPDATES = "Updates";
	static final String TAG = "Tag";
	static final String OCD = "OCD";


	private static String PLUGIN_ID = "com.verticon.tracker.store.update.mongo";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		Utils.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * Pass only animals with new events after the update date and the PID is
	 * empty
	 * 
	 * @author jconlon
	 * 
	 */
	static class AnimalsWithNewAndUnpublishedEvents implements
			Predicate<Animal> {
		private final Date update;

		AnimalsWithNewAndUnpublishedEvents(Date update) {
			super();
			this.update = update;
		}

		@Override
		public boolean apply(Animal animal) {

			return (update == null || animal.getLastEventDateTime().after(
					update));
			// && Iterables.any(animal.activeTag().getEvents(),
			// unAcknowledgedPublishedEvents
			// );
		}
	}

	/**
	 * Transform an animal to an AnimalUpdate
	 * 
	 * @author jconlon
	 * 
	 */
	static final class AnimalsToAnimalUpdates implements
			Function<Animal, AnimalUpdate> {
		private final Date update;
		private final String premisesURI;

		AnimalsToAnimalUpdates(Date update, String premiseURI) {
			super();
			this.update = update;
			this.premisesURI = premiseURI;
		}

		@Override
		public AnimalUpdate apply(Animal animal) {
			return new AnimalUpdate(animal, update, premisesURI);
		}
	}

	static final Predicate<AnimalUpdate> animalUpdates = new Predicate<AnimalUpdate>() {
		@Override
		public boolean apply(AnimalUpdate animalUpdate) {
			return animalUpdate.getState() == AnimalUpdate.State.ANIMAL;
		}
	};

	static final Predicate<AnimalUpdate> tagUpdates = new Predicate<AnimalUpdate>() {
		@Override
		public boolean apply(AnimalUpdate animalUpdate) {
			switch (animalUpdate.getState()) {
			case ANIMAL:
			case EVENTS_AND_TAG:
			case EVENTS:
			case TAGS:
				return true;
			default:
				return false;
			}
		}
	};

	static final Predicate<AnimalUpdate> createdNewTags = new Predicate<AnimalUpdate>() {
		@Override
		public boolean apply(AnimalUpdate animalUpdate) {
			switch (animalUpdate.getState()) {

			case EVENTS_AND_TAG:

			case TAGS:
				return true;
			default:
				return false;
			}
		}
	};

	static final Predicate<AnimalUpdate> eventUpdates = new Predicate<AnimalUpdate>() {
		@Override
		public boolean apply(AnimalUpdate animalUpdate) {
			return animalUpdate.getState() == AnimalUpdate.State.EVENTS
					|| animalUpdate.getState() == AnimalUpdate.State.EVENTS_AND_TAG;
		}
	};

	static final Function<Event, OCD> eventToOCD = new Function<Event, OCD>() {
		@Override
		public OCD apply(Event event) {
			if (event instanceof GenericEvent) {
				return ((GenericEvent) event).getOcd();
			} else {
				return null;
			}
		}
	};

	static final Function<Tag, String> tagToId = new Function<Tag, String>() {
		@Override
		public String apply(Tag tag) {
			return tag.getId();
		}
	};

	static final Function<DBObject, String> dbToId = new Function<DBObject, String>() {
		@Override
		public String apply(DBObject dbo) {
			return dbo.get("_id").toString();
		}
	};

	static final Function<DBObject, ObjectId> tagAnimalDbToOId = new Function<DBObject, ObjectId>() {
		@Override
		public ObjectId apply(DBObject dbo) {
			return (ObjectId) dbo.get("animal");
		}
	};

	static Resource createResourceWithEmptyURI() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("");
		Resource resource = resourceSet.createResource(uri);
		return resource;
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

	public static Integer getConfigurationInteger(Object o) {
		Integer result = null;
		if(o instanceof Integer){
			result = (Integer) o;
		}else if (o instanceof String){
			result = Integer.parseInt((String) o);
		}
		return result;
	}

	public static Animal createDefaultAnimal(Integer key) {
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
			throw new IllegalArgumentException("unknown animal id: " + key);
		}
	
	}

	public static EClass getAnimalEClass(Integer key) {
		switch (key) {
		case TrackerPackage.BOVINE_BEEF:
			return TrackerPackage.eINSTANCE.getBovineBeef();
		case TrackerPackage.BOVINE_BISON:
			return TrackerPackage.eINSTANCE.getBovineBeef();
		case TrackerPackage.BOVINE_DAIRY:
			return TrackerPackage.eINSTANCE.getBovineBeef();
		case TrackerPackage.CAPRINE:
			return TrackerPackage.eINSTANCE.getBovineBeef();
		case TrackerPackage.EQUINE:
			return TrackerPackage.eINSTANCE.getEquine();
		case TrackerPackage.OVINE:
			return TrackerPackage.eINSTANCE.getOvine();
		case TrackerPackage.SWINE:
			return TrackerPackage.eINSTANCE.getSwine();
		default:
			throw new IllegalArgumentException("unknown animal id: " + key);
		}
	
	}
}
