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

package com.verticon.tracker.store.mongo.test.system.internal;

import static com.verticon.tracker.store.mongo.test.system.internal.Configuator.ANIMAL_SCOPE;
import static com.verticon.tracker.store.mongo.test.system.internal.Configuator.ANIMAL_WEIGHT_SCOPE;
import static com.verticon.tracker.store.mongo.test.system.internal.Configuator.METTLER_WEIGHT_SCOPE;
import static com.verticon.tracker.store.mongo.test.system.internal.Configuator.POSITION_SCOPE;
import static com.verticon.tracker.store.mongo.test.system.internal.Configuator.TAG_SCOPE;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.AIN_1;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.AIN_2;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.AIN_3;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.bundleMarker;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.controller;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.monitorable;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.Caprine;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.mongo.test.system.Variables;

/**
 * iRouter testing of the com.verticon.tracker.store.mongo component and its primary
 * class for delievering that functionality the MongoConsumer.  
 * 
 * This class tests functionality of the WireAdmin Consumer service implemented by 
 * c.v.t.store.mongo.MongoConsumer.  MongoConsumer consumes Envelopes containing Animals,
 * Tags, Measurement, and Position payloads.
 * 
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>ITrackerStore</li>
 * <li>ConfigurationAdmin</li>
 * </ol>
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the ITrackerStore. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * Tests a mock Producer sending Tags to the Consumer implemented by the
 * TrackerStoreImpl
 * 
 * @author jconlon
 * 
 */
public class Test_TrackerStore_1_Consumer extends TestCase {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerStore_1_Consumer.class);

	/**
	 * Injected service
	 */
	private static ITrackerStore store;

	/**
	 * 
	 * Called by the test framework to setup the test case. This method will
	 * block at a startupGate waiting for the ITrackerStore service under test
	 * to be injected by DS.
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		if (store == null) {
			logger.debug(bundleMarker, "Starting...");
			store = Test_TrackerStore_1_Basic.getTrackerStore();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testConsumer_Animal_Sighting_ForNewAnimal()
			throws InterruptedException {
		assertThat("Controller must have wires", controller.hasWires(),
				is(true));
		resetStatus();
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(AIN_3);
		tag.getEvents().add(TrackerFactory.eINSTANCE.createSighting());
		Animal animalNew = TrackerFactory.eINSTANCE.createCaprine();
		animalNew.getTags().add(tag);
		
		Envelope envelope = new BasicEnvelope(animalNew,AIN_1,ANIMAL_SCOPE);
		controller.send(envelope);

		assertThat("Must have added one animal.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(1));
		assertThat("Must have not updated any animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));

		assertThat(
				"Must have processed one animal.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(1));

		Animal animal = store.retrieveAnimal(AIN_3);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be one tag", animal.getTags().size(), is(1));
		assertThat("There must be one event", animal.eventHistory().size(),
				is(1));
		assertThat("Animal must be a Caprine", animal,
				is(instanceOf(Caprine.class)));

	}

	public void testConsumer_Tag_Sighting_ForNewAnimal()
			throws InterruptedException {
		assertThat("Controller must have wires", controller.hasWires(),
				is(true));
		resetStatus();
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(AIN_1);
		tag.getEvents().add(TrackerFactory.eINSTANCE.createSighting());
		Envelope envelope = new BasicEnvelope(tag,AIN_1,TAG_SCOPE);
		controller.send(envelope);

		assertThat("Must have added one animal.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(1));
		assertThat("Must have not updated any animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));

		assertThat(
				"Must have processed one animal.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(1));

		Animal animal = store.retrieveAnimal(AIN_1);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be one tag", animal.getTags().size(), is(1));
		assertThat("There must be one event", animal.eventHistory().size(),
				is(1));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

	}

	public void testConsumer_Tag_Position_ForExistingAnimal()
			throws InterruptedException {
		assertThat("Controller must have wires", controller.hasWires(),
				is(true));
		monitorable
				.resetStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID);
		monitorable.resetStatusVariable(Variables.UPDATED_ANIMALS.statusVarID);
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(AIN_1);
		tag.getEvents().add(TrackerFactory.eINSTANCE.createPosition());
		Envelope envelope = new BasicEnvelope(tag,AIN_1,TAG_SCOPE);
		controller.send(envelope);
		assertThat(
				"Must have processed one animal.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(1));
		assertThat("Must have added no animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));
		assertThat("Must have updated one animal.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(1));

		Animal animal = store.retrieveAnimal(AIN_1);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be one tag", animal.getTags().size(), is(1));
		assertThat("There must be two events", animal.eventHistory().size(),
				is(2));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

	}

	public void testConsumer_Tag_ReplaceTag()
			throws InterruptedException {
		assertThat("Controller must be connected to the consumer.",
				controller.hasWires(), is(true));
		monitorable
				.resetStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID);
		monitorable.resetStatusVariable(Variables.UPDATED_ANIMALS.statusVarID);
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(AIN_2);
		ReplacedTag rt = TrackerFactory.eINSTANCE.createReplacedTag();
		Tag tagOld = TrackerFactory.eINSTANCE.createTag();
		tagOld.setId(AIN_1);
		rt.setOldTag(tagOld);
		tag.getEvents().add(rt);
		Envelope envelope = new BasicEnvelope(tag,AIN_2,TAG_SCOPE);
		controller.send(envelope);
		assertThat(
				"Must have processed one animal after the reset.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(1));
		assertThat("Must have not added as a new animal.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));
		assertThat("Must have updated an existing animal.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(1));

	}

	public void testConsumer_RetrieveOldAnimalWithTwoTags()
			throws InterruptedException {
		assertThat("Controller must be connected to the consumer.",
				controller.hasWires(), is(true));
		monitorable
				.resetStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID);
		monitorable.resetStatusVariable(Variables.UPDATED_ANIMALS.statusVarID);
		Animal animal = store.retrieveAnimal(AIN_2);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There should be one tag and one events", animal.getTags()
				.size(), is(2));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));
		assertThat("Old animal must not be persisted.",
				store.retrieveAnimal(AIN_1), is(nullValue()));

		assertThat("Not in mongo", animal.eResource().getURI().toString(),
				startsWith("mongodb://"));

		assertThat("Animal should NOT have a container", animal.eContainer(),
				is(nullValue()));

	}

	public void testConsumer_MultipleRetrieves() {
		Animal animal = store.retrieveAnimal(AIN_2);
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));
		assertThat("Old animal must not be persisted.",
				store.retrieveAnimal(AIN_1), is(nullValue()));
		assertThat("Not in mongo", animal.eResource().getURI().toString(),
				startsWith("mongodb://"));
		assertThat("Animal should NOT have a container", animal.eContainer(),
				is(nullValue()));

	}

	public void testConsumer_Tag_ExistingEventsl()
			throws InterruptedException {
		assertThat("Controller must be connected to the consumer.",
				controller.hasWires(), is(true));
		resetStatus();

		Animal animal = store.retrieveAnimal(AIN_2);
		assertThat("Animal must not be null", animal, is(notNullValue()));
		assertThat("Animal must have 2 tags", animal.getTags().size(), is(2));
		// Retrieve the tag and copy it
		Tag tag = animal.activeTag();
		tag = EcoreUtil.copy(tag);
		Envelope envelope = new BasicEnvelope(tag,AIN_2,TAG_SCOPE);
		controller.send(envelope);
		assertThat(
				"Must have NOT processed an animal after the reset.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(0));
		assertThat("Must have not added as a new animal.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));
		assertThat("Must have NOT updated an existing animal.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));

	}

	//Envelope tests follow

	/**
	 *  Measurement Envelopes with scopes of animal.weight will be added as
	 *  WeighIn events
	 * @throws InterruptedException
	 */
	public void testConsumer_Measurement_WeighIn()
			throws InterruptedException {
		resetStatus();
		Measurement value = new Measurement(100, .1, Unit.kg,
				new Date().getTime());
		Envelope envelope = new BasicEnvelope(value, AIN_2, ANIMAL_WEIGHT_SCOPE);

		assertThat("Controller must have wires", controller.hasWires(),
				is(true));

		controller.send(envelope);

		assertThat("Must have added NO animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));
		assertThat("Must have updated one animal.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(1));

		assertThat(
				"Must have processed one animal.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(1));

		Animal animal = store.retrieveAnimal(AIN_2);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be two tag", animal.getTags().size(), is(2));
		assertThat("There must be four events", animal.eventHistory().size(),
				is(4));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

		assertThat("Last event must be a WeighIn",
				animal.eventHistory().get(3), is(instanceOf(WeighIn.class)));
		WeighIn wi = (WeighIn) animal.eventHistory().get(3);
		assertThat("Weight must be 100", wi.getWeight(), is(100d));

	}

	/**
	 * Position Envelopes are sent as Position events
	 * Envelope scope is gps.position
	 * 
	 * @throws InterruptedException
	 */
	public void testConsumer_Position()
			throws InterruptedException {
		resetStatus();
		
		Measurement lat = new Measurement(Math.toRadians(45), .1, Unit.rad,
				new Date().getTime());
		Measurement longi = new Measurement(Math.toRadians(45), .1, Unit.rad,
				new Date().getTime());
		Position position = new Position(lat, longi, null, null, null);

		Envelope envelope = new BasicEnvelope(position, AIN_2, 
				POSITION_SCOPE);//TODO

		assertThat("Controller must have wires", controller.hasWires(),
				is(true));

		controller.send(envelope);

		assertThat("Must have added NO animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));
		assertThat("Must have updated one animal.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(1));

		assertThat(
				"Must have processed one animal.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(1));

		Animal animal = store.retrieveAnimal(AIN_2);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be two tag", animal.getTags().size(), is(2));
		assertThat("There must be five events", animal.eventHistory().size(),
				is(5));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

		assertThat("Last event must be a Position",
				animal.eventHistory().get(4), is(instanceOf(com.verticon.tracker.Position.class)));
		com.verticon.tracker.Position posi= (com.verticon.tracker.Position) animal.eventHistory().get(4);
		double degrees = 45;//Math.toDegrees(44);
		assertThat("Latitude must be 45", posi.getLatitude(), is(degrees));

	}

	/**
	 * Measurements Envelopes are sent as GenericEvent events
	 * with scope equal to the id of the OCD
	 * @throws InterruptedException
	 */
	public void testConsumer_Measurement_GenericEvent()
			throws InterruptedException {
		resetStatus();

		Measurement value = new Measurement(100, .1, Unit.kg,
				new Date().getTime());
		Envelope envelope = new BasicEnvelope(value, AIN_2, METTLER_WEIGHT_SCOPE);

		assertThat("Controller must have wires", controller.hasWires(),
				is(true));

		controller.send(envelope);

		assertThat("Must have added NO animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));
		assertThat("Must have updated one animal.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(1));

		assertThat(
				"Must have processed one animal.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(1));

		Animal animal = store.retrieveAnimal(AIN_2);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be two tag", animal.getTags().size(), is(2));
		assertThat("There must be six events", animal.eventHistory().size(),
				is(6));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

		assertThat("Last event must be a GenericEvent",
				animal.eventHistory().get(5), is(instanceOf(GenericEvent.class)));
		GenericEvent ge = (GenericEvent) animal.eventHistory().get(5);
		assertThat("",ge.getOcd(), is(notNullValue()));
		assertThat("",ge.getOcd().getID(), is(METTLER_WEIGHT_SCOPE));

	}

	// public void testRetrieveRoute() {
	// Agriculture agri = store.retrieveRoute(FIRST_ANIMAL_ID);
	// assertThat("Could not retrieve the route", agri, is(notNullValue()));
	// }
	//
	// public void testRetrieveHerd() {
	// Date in = null;
	// Date out = null;
	// Premises agri = store.retrieveHerd(in, out);
	// }

	private void resetStatus() {
		monitorable
				.resetStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID);
		monitorable.resetStatusVariable(Variables.UPDATED_ANIMALS.statusVarID);
		monitorable
				.resetStatusVariable(Variables.TOTAL_ANIMALS_PROCESSED.statusVarID);
	}
}
