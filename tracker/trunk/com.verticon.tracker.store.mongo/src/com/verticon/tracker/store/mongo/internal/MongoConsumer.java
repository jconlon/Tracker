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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.verticon.tracker.store.mongo.internal.Element.ANIMAL;
import static com.verticon.tracker.store.mongo.internal.Element.OCD;
import static com.verticon.tracker.store.mongo.internal.Element.TAG;
import static com.verticon.tracker.store.mongo.internal.Utils.bundleMarker;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.mongodb.DB;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.irouter.premises.common.api.EventCreationException;
import com.verticon.tracker.irouter.premises.common.api.IOCDFinder;
import com.verticon.tracker.irouter.premises.common.api.PremisesIRouterUtils;

public class MongoConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MongoConsumer.class);
	private final MongoStatusMonitor statusMonitor;

	private Integer DEFAULT_ANIMAL_KEY;
	private ResourceSetFactoryContext resourceFactory;
	private DB db;

	MongoConsumer(MongoStatusMonitor statusMonitor) {
		super();
		this.statusMonitor = statusMonitor;
	}

	@Override
	public void updated(Wire wire, Object in) {
		if (in instanceof Envelope) {
			statusMonitor.incrementTotalProductsConsumed();
			Envelope envelope = (Envelope) in;
			logger.debug(bundleMarker, "Consuming value={}",
					envelope.getValue());
			if (envelope.getValue() != null) {
				if (envelope.getValue() instanceof Tag) {
					handle((Tag) envelope.getValue(), null);
				} else if (envelope.getValue() instanceof Animal) {
					Animal animal = (Animal) envelope.getValue();
					handle(animal.getTags().get(0), animal);
				} else {
					handle(envelope);
				}
			}
		} else {
			logger.error(bundleMarker,
					"Unknown object={} was received from wire scope={}", in,
					Arrays.toString(wire.getScope()));

		}

	}

	/**
	 * 
	 * @param envelope
	 * @throws IOException
	 * @throws EventCreationException
	 */
	private void handle(final Envelope envelope) {
		logger.debug(bundleMarker, "Handling value={}", envelope.getValue());
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		String id = (String) envelope.getIdentification();
		tag.setId(id);
		try {
			Event event = PremisesIRouterUtils.createEvent(new IOCDFinder() {
				@Override
				public OCD find() {
					return (OCD) resourceFactory.query(OCD, envelope.getScope());
				}
			}, envelope);
			tag.getEvents().add(event);
			handle(tag, null);
			statusMonitor.addTotalAnimalsProcessed(1);
		} catch (Exception e) {
			logger.error(bundleMarker, "Failed to update envelope id=" + id
					+ " scope=" + envelope.getScope(), e);

		}

	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "Invoked producerConnected with wires={}",
				Arrays.toString(wires));
		statusMonitor.setProducersConnected(wires != null ? wires.length : 0);
	}

	void activate(Integer dEFAULT_ANIMAL_KEY,
			ResourceSetFactoryContext resourceFactory, DB db) {
		logger.debug(bundleMarker, "Activating");
		DEFAULT_ANIMAL_KEY = dEFAULT_ANIMAL_KEY;
		this.resourceFactory = resourceFactory;
		this.db = db;
		logger.debug(bundleMarker, "Activated");
	}

	void deactivate() {
		DEFAULT_ANIMAL_KEY = null;
		this.resourceFactory = null;
		this.db = null;
		logger.debug(bundleMarker, "Deactivated");
	}

	/**
	 * Add all new OCD from the events
	 * 
	 * @param newerEventsToAdd
	 * @throws IOException
	 */
	void addNewOCDs(Collection<Event> newerEventsToAdd) throws IOException {
		// Get all the NEW OCDs from the genericEvents
		for (Event event : newerEventsToAdd) {
			if (event.getEventCode() == 200) {
				OCD ocd = ((GenericEvent) event).getOcd();
				if (!Utils.isPersisted(ocd, db)) { // IT still may have been
													// persisted
					save(ocd);
				}
			}
		}
	}

	void save(OCD ocd) throws IOException {
		// Register the animal
		// Utils.registerResource(MetatypePackage.Literals.OCD, ocd,
		// getHostName(), getPort(), null);
		resourceFactory.add(ocd, OCD);
		resourceFactory.save(ocd, OCD);
	}

	void save(Animal animal) throws IOException {
		logger.debug(bundleMarker, "Saving animal {}", animal.getId());
		// Register the animal
		// resourceSet = Utils.registerResource(TrackerPackage.Literals.ANIMAL,
		// animal, getHostName(), getPort(), resourceSet);
		resourceFactory.add(animal, ANIMAL);
		// Register all tags
		for (Tag tag : animal.getTags()) {
			// Utils.registerResource(TrackerPackage.Literals.TAG, tag,
			// getHostName(), getPort(), resourceSet);
			resourceFactory.add(tag, TAG);
		}
		// Get all the OCDs from the genericEvents
		for (Event event : animal.eventHistory()) {
			if (event.getEventCode() == 200) {
				OCD ocd = ((GenericEvent) event).getOcd();
				if (!Utils.isPersisted(ocd, db)) {
					save(ocd);
				}
			}
		}
		// Store the animal
		
		resourceFactory.save(animal, ANIMAL);
		

		// Store all tags
		for (Tag tag : animal.getTags()) {
			resourceFactory.save(tag, TAG);
		}
		// Store the animal
		resourceFactory.save(animal, ANIMAL);
		statusMonitor.incrementTotalAnimalsAdded();
		logger.debug(bundleMarker, "Saved animal={} and tags", animal.getId());

	}

	/**
	 * Primary entry point for saving a tag. Saves the tag as in the default
	 * animal if it is a new tag id. Saves the latest events if the tag is
	 * already persisted. Saves the tag in an existing animal if this tag
	 * contains a replacedTag event.
	 * 
	 * 
	 * @param tag
	 *            must not be null
	 * @param animal
	 *            that is non null must have only one tag
	 */
	private void handle(Tag tag, Animal animal) {
		checkNotNull(tag, "Tag must not be null.");
		checkNotNull(Strings.emptyToNull(tag.getId()),
				"Tag id must not be null.");
		if (animal != null) {
			checkArgument(animal.getTags().size() == 1,
					"Animal must have only one tag.");
		}
		// get a persisted tag
		logger.debug(bundleMarker, "Handling tag {} with {} events, animal={}", 
				new Object[] {tag!=null?tag.getId():"null", tag!=null?tag.getEvents().size():"null", animal});
		Tag persistedTag = (Tag) resourceFactory.query(TAG, tag.getId());
		if(persistedTag!=null){
			Collection<Event> newerEventsToAdd = NewerEvents.getNewerEvents(tag, persistedTag);
			if (newerEventsToAdd.isEmpty()) {
				return;// Tag is already persisted with all the events
			}
			try {
				update(persistedTag, newerEventsToAdd);
			} catch (IOException e) {
				logger.error(bundleMarker, "Failed to update " + tag, e);
			}
			return;
		}

		// There may be a replace tag event indicating the animal may be
		// persisted under another tag
		Collection<Event> replaceTags = Collections2.filter(tag.getEvents(),
				Predicates.instanceOf(ReplacedTag.class));
		if (replaceTags.size() > 0) {
			ReplacedTag rt = (ReplacedTag) replaceTags.iterator().next();
			Animal persitedAnimal = (Animal) resourceFactory.query(ANIMAL, rt
					.getOldTag().getId());
			if (persitedAnimal != null) {
				try {
					replace(tag, persitedAnimal);
				} catch (IOException e) {
					logger.error(bundleMarker, "Failed to replace " + tag, e);
				}
				return;
			}
		}
		// No persisted tag or old replaced tag - consider this a new animal, if
		// there is a default animal save it
		try {
			if (animal == null) {
				animal = createDefaultAnimal(tag);
			}
			add(animal);
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to add " + tag, e);
		}

	}

	private Animal createDefaultAnimal(Tag tag) throws IOException {
		Animal animal = Utils.createDefaultAnimal(DEFAULT_ANIMAL_KEY);
		animal.getTags().add(tag);
		return animal;
	}

	/**
	 * Add a tag with a default animal
	 * 
	 * @param tag
	 * @throws IOException
	 */
	private void add(Animal animal) throws IOException {

		save(animal);
		statusMonitor.addTotalAnimalsProcessed(1);
	}

	/**
	 * Replace the tag from the presistedAnimal with a new one.
	 * 
	 * @param tag
	 * @param persitedAnimal
	 * @throws IOException
	 */
	private void replace(Tag tag, Animal persitedAnimal) throws IOException {
		resourceFactory.add(tag, TAG);
		persitedAnimal.getTags().add(tag);
		logger.debug(bundleMarker, "Saving tag {}", tag.eResource().getURI());
		resourceFactory.save(tag, TAG);
		resourceFactory.save(persitedAnimal, ANIMAL);
		logger.debug(bundleMarker, "Updating animal {}", persitedAnimal
				.eResource().getURI());
		resourceFactory.save(tag, TAG);
		statusMonitor.incrementTotalAnimalsUpdated();

	}

	/**
	 * Tag is persisted and there are newer events
	 * 
	 * @param tag
	 * @param persistedTag
	 * @param newerEvents
	 * @param newerEventsToAdd
	 * @throws IOException
	 */
	private void update(Tag persistedTag,
			Collection<Event> newerEventsToAdd) throws IOException {

		addNewOCDs(newerEventsToAdd);
		addNewEvents( persistedTag, newerEventsToAdd);
	}

	
	private void addNewEvents(Tag persistedTag,
			Collection<Event> eventsToAdd) throws IOException {
		persistedTag.getEvents().addAll(eventsToAdd);
		resourceFactory.save(persistedTag, TAG);
		statusMonitor.incrementTotalAnimalsUpdated();
	}

}
