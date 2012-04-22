/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.irouter.premises.animal.test.system.internal;

import static com.verticon.tracker.irouter.premises.animal.test.system.internal.Configuator.ANIMAL_SCOPE;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.BovineBison;
import com.verticon.tracker.Event;

/**
 * 
 * MongoTrackerStore manages persistence of Tracker elements to a MongoDB.
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
 * 
 * @author jconlon
 * 
 */
public class Test_PremisesAnimalProducer extends TestCase {

	private static final String PREMISES_ANIMAL_SCOPE = "premises.animal";
	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String LAST_ID = "consumer.Last_Identification";
	private static final String LAST_SCOPE = "consumer.Last_Scope";
	private static final String LAST_ANIMAL_SENT = "consumer.Last_Animal";
	private static final String TOTAL_ANIMALS_SENT = "consumer.Total_Animals_Sent";

	/**
	 * The first animal in the serialized test documents. This animal contains:
	 * <ul>
	 * <li>
	 * a generic event at index(7)</li>
	 * <li>
	 * a position event at index(6)
	 * 
	 * 
	 */
	private static final Long FIRST_ANIMAL_ID = 840456789012341L;

	static String PLUGIN_ID = "com.verticon.tracker.store.mongo.test.system";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_PremisesAnimalProducer.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations, this latch will wait for
	 * 1. this bundles startup method to be called which means that the
	 * ITrackerStore and Monitorable services injected from the class under test
	 * TrackerStoreImpl 2. For the wireadmin to connect the Producer service
	 * offered by this class to the Consumer service offered by the
	 * TrackerStoreImpl.
	 * 
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);// one
																			// for
																			// set
																			// up
																			// one
																			// for
																			// wire
																			// to
																			// producer,
																			// and
																			// one
																			// for
																			// catcher

	/**
	 * Injected services
	 */
	static ICatcher catcher;
	static Monitorable monitorable;
	static IController controller;

	/**
	 * Injected by ds
	 * 
	 * @param catcher
	 */
	public void setCatcher(ICatcher catcher) {
		logger.debug(bundleMarker, "DS injecting the catcher");
		Test_PremisesAnimalProducer.catcher = catcher;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	public void setMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_PremisesAnimalProducer.monitorable = monitorable;
	}

	/**
	 * Injected by ds
	 * 
	 * @param controller
	 */
	public void setController(IController controller) {
		logger.debug(bundleMarker, "DS injecting the controller");
		Test_PremisesAnimalProducer.controller = controller;
	}

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
		logger.debug(bundleMarker,
				"waiting for declarative services activation startup method to finish");
		startUpGate.await();// wait for startUp to finish
		System.out.println(this + ": startup and setUp finished.");
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

	/**
	 * On activation of this component this method is called.
	 * 
	 * @param context
	 */
	public void startup(BundleContext context) {
		Test_PremisesAnimalProducer.context = context;
		startUpGate.countDown();

	}

	@Test
	public void testContext() {
		assertThat("BundleContext was not setup", context, is(notNullValue()));
		assertThat("Catcher was not setup", catcher, is(notNullValue()));
		assertThat("Catcher must have one connection",
				catcher.getNumberOfConnections(), is(1));
		assertThat("Monitorable was not setup", monitorable, is(notNullValue()));
		assertThat("Controller was not setup", controller, is(notNullValue()));
		assertThat("Controller must have wires", controller.hasWires(),
				is(true));
		monitorable.resetStatusVariable(TOTAL_ANIMALS_SENT);
	}

	@Test
	public void testMonitorable_StatusVariables_Presence() {
		logger.debug(bundleMarker,
				"starting testMonitorable_StatusVariables_Presence");
		String[] varNames = monitorable.getStatusVariableNames();
		assertNotNull("Monitorable was not setup", varNames);

		assertThat("Must have all the StatusVariableNames",
				monitorable.getStatusVariableNames().length, is(6));

		for (String name : monitorable.getStatusVariableNames()) {
			StatusVariable sv = monitorable.getStatusVariable(name);
			assertThat(name + " must not be null", sv, is(notNullValue()));
		}
	}

	@Test
	public void testMonitorable_Get_StatusVariables() {
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_ANIMALS_SENT);
		assertThat(TOTAL_ANIMALS_SENT + " must be 0", sv.getInteger(), is(0));

		sv = monitorable.getStatusVariable(LAST_ANIMAL_SENT);
		assertThat(LAST_ANIMAL_SENT + " must be blank", sv.getString(), is(""));

		sv = monitorable.getStatusVariable(CONNECTED_PRODUCERS_COUNT);
		assertThat(CONNECTED_PRODUCERS_COUNT + " must be 1", sv.getInteger(),
				is(1));

		sv = monitorable.getStatusVariable(CONNECTED_CONSUMERS_COUNT);
		assertThat(CONNECTED_CONSUMERS_COUNT + " must be 1", sv.getInteger(),
				is(1));

		sv = monitorable.getStatusVariable(LAST_SCOPE);
		assertThat(LAST_SCOPE + " must be blank", sv.getString(), is(""));

		sv = monitorable.getStatusVariable(LAST_ID);
		assertThat(LAST_ID + " must be blank", sv.getString(), is(""));
	}

	@Test
	public void testAnimalProducer() {

		StatusVariable sv = null;
		Date beforeDate = new Date();
		sendEID(FIRST_ANIMAL_ID);
		sv = monitorable.getStatusVariable(TOTAL_ANIMALS_SENT);
		assertThat(TOTAL_ANIMALS_SENT + " must be 1", sv.getInteger(), is(1));

		sv = monitorable.getStatusVariable(LAST_ANIMAL_SENT);
		assertThat(LAST_ANIMAL_SENT + " must be BovineBison", sv.getString(),
				is("BovineBison"));

		sv = monitorable.getStatusVariable(LAST_SCOPE);
		assertThat(LAST_SCOPE + " must be " + PREMISES_ANIMAL_SCOPE,
				sv.getString(), is(PREMISES_ANIMAL_SCOPE));

		sv = monitorable.getStatusVariable(LAST_ID);
		assertThat(LAST_ID + " must be " + FIRST_ANIMAL_ID, sv.getString(),
				is(FIRST_ANIMAL_ID.toString()));

		Envelope catcherLastEnvelope = catcher.getLastEnvelope();
		assertThat("Catcher must have received an envelope",
				catcherLastEnvelope, is(notNullValue()));

		assertThat("Catcher must have received an envelope id",
				(String) catcherLastEnvelope.getIdentification(),
				is(FIRST_ANIMAL_ID.toString()));

		assertThat("Catcher scope must be set", catcherLastEnvelope.getScope(),
				is(PREMISES_ANIMAL_SCOPE));

		assertThat("Catcher must have received a Bison",
				catcherLastEnvelope.getValue(), instanceOf(BovineBison.class));

		BovineBison animal = (BovineBison) catcherLastEnvelope.getValue();

		assertThat("Tag must be set", animal.getId(),
				is(FIRST_ANIMAL_ID.toString()));
		assertThat("Must have one tag", animal.getTags().size(), is(1));
		assertThat("Must have one event",
				animal.activeTag().getEvents().size(), is(1));
		Event event = animal.activeTag().getEvents().get(0);
		assertThat(
				"Event date must have timestamp after the start of this test",
				event.getDateTime().after(beforeDate), is(true));
		assertThat(
				"Event date must have timestamp before the start of this test",
				event.getDateTime().before(new Date()), is(true));

	}

	private void sendEID(Long eid) {
		Envelope envelope = new BasicEnvelope(eid, "xx", ANIMAL_SCOPE);
		controller.send(envelope);
	}

}
