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

package com.verticon.tracker.irouter.premises.event.test.system.internal;

import static com.verticon.tracker.irouter.premises.event.test.system.internal.Configuator.ANIMAL_SCOPE;
import static com.verticon.tracker.irouter.premises.event.test.system.internal.Configuator.ANIMAL_WEIGHT_SCOPE;
import static com.verticon.tracker.irouter.premises.event.test.system.internal.Configuator.METTLER_WEIGHT_SCOPE;
import static com.verticon.tracker.irouter.premises.event.test.system.internal.Configuator.POSITION_SCOPE;
import static com.verticon.tracker.irouter.premises.event.test.system.internal.Configuator.RAW_ANIMAL_WEIGHT_SCOPE;
import static com.verticon.tracker.irouter.premises.event.test.system.internal.Configuator.RAW_METTLER_WEIGHT_SCOPE;
import static com.verticon.tracker.irouter.premises.event.test.system.internal.Configuator.RAW_POSITION_SCOPE;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

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
public class Test_PremisesEventProducer extends TestCase {

	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String LAST_ID = "consumer.Last_Identification";
	private static final String LAST_SCOPE = "consumer.Last_Scope";
	private static final String LAST_EVENT_SENT = "consumer.Last_Event";
	private static final String TOTAL_EVENTS_SENT = "consumer.Total_Events_Sent";

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
			.getLogger(Test_PremisesEventProducer.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations, this latch will wait for
	 * 1. this bundles startup method to be called which means that the
	 * ITrackerStore and Monitorable services injected from the class under test
	 * TrackerStoreImpl 2. For the wireadmin to connect the Producer service
	 * offered by this class to the Consumer service offered by the
	 * TrackerStoreImpl.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);

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
		Test_PremisesEventProducer.catcher = catcher;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	public void setMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_PremisesEventProducer.monitorable = monitorable;
	}

	/**
	 * Injected by ds
	 * 
	 * @param controller
	 */
	public void setController(IController controller) {
		logger.debug(bundleMarker, "DS injecting the controller");
		Test_PremisesEventProducer.controller = controller;
	}

	/**
	 * 
	 * Called by the test framework to setup the test case. This method will
	 * block at a startupGate waiting for the ITrackerStore service under test
	 * to be injected by DS.
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
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
		Test_PremisesEventProducer.context = context;
		startUpGate.countDown();

	}

	@Test
	public void testContext() {
		assertThat("BundleContext was not setup", context, is(notNullValue()));
		assertThat("Catcher was not setup", catcher, is(notNullValue()));
		assertThat("Catcher must have one connection",
				catcher.getNumberOfConnections() == 1, is(true));
		assertThat("Monitorable was not setup", monitorable, is(notNullValue()));
		assertThat("Controller was not setup", controller, is(notNullValue()));
		assertThat("Controller must have wires", controller.hasWires(),
				is(true));
		monitorable.resetStatusVariable(TOTAL_EVENTS_SENT);
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
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_EVENTS_SENT);
		assertThat(TOTAL_EVENTS_SENT + " must be 0", sv.getInteger(), is(0));

		sv = monitorable.getStatusVariable(LAST_EVENT_SENT);
		assertThat(LAST_EVENT_SENT + " must be blank", sv.getString(), is(""));

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
	public void testTransactionConsumer_AnimalWeight() {
		sendAnimalWeight(100);
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_EVENTS_SENT);
		assertThat(TOTAL_EVENTS_SENT + " must be 0", sv.getInteger(), is(0));

		sv = monitorable.getStatusVariable(LAST_EVENT_SENT);
		assertThat(LAST_EVENT_SENT + " must be blank", sv.getString(), is(""));

		sv = monitorable.getStatusVariable(LAST_SCOPE);
		assertThat(LAST_SCOPE + " must be blank", sv.getString(), is(""));

		sv = monitorable.getStatusVariable(LAST_ID);
		assertThat(LAST_ID + " must be blank", sv.getString(), is(""));
		assertThat("Catcher must not have received any events",
				catcher.getLastEnvelope(), is(nullValue()));

		sendEID(FIRST_ANIMAL_ID);
		sv = monitorable.getStatusVariable(TOTAL_EVENTS_SENT);
		assertThat(TOTAL_EVENTS_SENT + " must be 1", sv.getInteger(), is(1));

		sv = monitorable.getStatusVariable(LAST_EVENT_SENT);
		assertThat(LAST_EVENT_SENT + " must be 100.0 kg", sv.getString(),
				is("100.0 kg"));

		sv = monitorable.getStatusVariable(LAST_SCOPE);
		assertThat(LAST_SCOPE + " must be animal.weight", sv.getString(),
				is(ANIMAL_WEIGHT_SCOPE));

		sv = monitorable.getStatusVariable(LAST_ID);
		assertThat(LAST_ID + " must be " + FIRST_ANIMAL_ID, sv.getString(),
				is(FIRST_ANIMAL_ID.toString()));

		assertThat("Catcher must have received an envelope",
				catcher.getLastEnvelope(), is(notNullValue()));

		assertThat("Catcher must have received an envelope Measurement",
				catcher.getLastEnvelope().getValue(),
				instanceOf(Measurement.class));

		assertThat(
				"Catcher must have received an envelope Measurement of 100",
				((Measurement) catcher.getLastEnvelope().getValue()).getValue(),
				is(100d));

		assertThat("Catcher must have received an envelope id",
				(String) catcher.getLastEnvelope().getIdentification(),
				is(FIRST_ANIMAL_ID.toString()));
		assertThat("Catcher must scope must be set", catcher.getLastEnvelope()
				.getScope(), is(ANIMAL_WEIGHT_SCOPE));
	}

	@Test
	public void testTransactionConsumer_Position() {
		monitorable.resetStatusVariable(TOTAL_EVENTS_SENT);
		sendPosition(Math.toRadians(45), Math.toRadians(70));
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_EVENTS_SENT);
		assertThat(TOTAL_EVENTS_SENT + " must be 0", sv.getInteger(), is(0));

		sendEID(FIRST_ANIMAL_ID);
		sv = monitorable.getStatusVariable(TOTAL_EVENTS_SENT);
		assertThat(TOTAL_EVENTS_SENT + " must be 1", sv.getInteger(), is(1));

		sv = monitorable.getStatusVariable(LAST_SCOPE);
		assertThat(LAST_SCOPE + " must be set", sv.getString(),
				is(POSITION_SCOPE));

		sv = monitorable.getStatusVariable(LAST_ID);
		assertThat(LAST_ID + " must be " + FIRST_ANIMAL_ID, sv.getString(),
				is(FIRST_ANIMAL_ID.toString()));

		assertThat("Catcher must have received an envelope",
				catcher.getLastEnvelope(), is(notNullValue()));

		assertThat("Catcher must have received an envelope Position", catcher
				.getLastEnvelope().getValue(), instanceOf(Position.class));

		assertThat("Catcher must have received an envelope Position of 11 lat",
				((Position) catcher.getLastEnvelope().getValue()).getLatitude()
						.getValue(), is(Math.toRadians(45)));

		assertThat("Catcher must have received an envelope id",
				(String) catcher.getLastEnvelope().getIdentification(),
				is(FIRST_ANIMAL_ID.toString()));
		assertThat("Catcher must scope must be set", catcher.getLastEnvelope()
				.getScope(), is(POSITION_SCOPE));

	}

	@Test
	public void testTransactionConsumer_GenericEvent() {
		monitorable.resetStatusVariable(TOTAL_EVENTS_SENT);
		sendGenericEvent(100);
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_EVENTS_SENT);
		assertThat(TOTAL_EVENTS_SENT + " must be 0", sv.getInteger(), is(0));

		sendEID(FIRST_ANIMAL_ID);
		sv = monitorable.getStatusVariable(TOTAL_EVENTS_SENT);
		assertThat(TOTAL_EVENTS_SENT + " must be 1", sv.getInteger(), is(1));

		sv = monitorable.getStatusVariable(LAST_EVENT_SENT);
		assertThat(LAST_EVENT_SENT + " must be 100.0 kg", sv.getString(),
				is("100.0 kg"));

		sv = monitorable.getStatusVariable(LAST_SCOPE);
		assertThat(LAST_SCOPE + " must be set", sv.getString(),
				is(METTLER_WEIGHT_SCOPE));

		sv = monitorable.getStatusVariable(LAST_ID);
		assertThat(LAST_ID + " must be " + FIRST_ANIMAL_ID, sv.getString(),
				is(FIRST_ANIMAL_ID.toString()));

		assertThat("Catcher must have received an envelope",
				catcher.getLastEnvelope(), is(notNullValue()));

		assertThat("Catcher must have received an envelope Measurement",
				catcher.getLastEnvelope().getValue(),
				instanceOf(Measurement.class));

		assertThat(
				"Catcher must have received an envelope Measurement of 100",
				((Measurement) catcher.getLastEnvelope().getValue()).getValue(),
				is(100d));

		assertThat("Catcher must have received an envelope id",
				(String) catcher.getLastEnvelope().getIdentification(),
				is(FIRST_ANIMAL_ID.toString()));

		assertThat("Catcher must scope must be set", catcher.getLastEnvelope()
				.getScope(), is(METTLER_WEIGHT_SCOPE));

	}

	private void sendEID(Long eid) {
		Envelope envelope = new BasicEnvelope(eid, "xx", ANIMAL_SCOPE);
		controller.send(envelope);
	}

	private void sendAnimalWeight(double d) {
		Measurement m = new Measurement(d, Unit.kg);
		Envelope envelope = new BasicEnvelope(m, "xx", RAW_ANIMAL_WEIGHT_SCOPE);
		controller.send(envelope);
	}

	private void sendGenericEvent(double d) {
		Measurement m = new Measurement(d, Unit.kg);
		Envelope envelope = new BasicEnvelope(m, "xx", RAW_METTLER_WEIGHT_SCOPE);
		controller.send(envelope);
	}

	private void sendPosition(double lat, double lon) {
		Measurement latM = new Measurement(lat, Unit.rad);
		Measurement lonM = new Measurement(lon, Unit.rad);
		Position m = new Position(latM, lonM, null, null, null);
		Envelope envelope = new BasicEnvelope(m, "xx", RAW_POSITION_SCOPE);
		controller.send(envelope);
	}

}
