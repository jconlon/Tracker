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
import java.util.Map;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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


	private static String PLUGIN_ID = "com.verticon.tracker.store.mongodb";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		Utils.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
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

	static final Function<Map<String, ?>, String> dbToId = new Function<Map<String, ?>, String>() {
		@Override
		public String apply(Map<String, ?> dbo) {
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
}
