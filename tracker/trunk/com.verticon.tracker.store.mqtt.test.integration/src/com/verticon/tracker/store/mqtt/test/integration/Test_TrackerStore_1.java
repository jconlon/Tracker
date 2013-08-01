/*******************************************************************************
 * 
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.store.mqtt.test.integration;


import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.tracker.store.mqtt.test.integration.Configurator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.mqtt.test.integration.Configurator.bundleMarker;
import static com.verticon.tracker.store.mqtt.test.integration.Configurator.getXMIResource;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import junit.framework.TestCase;

import org.bson.BSONObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.mongodb.util.JSON;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.Query;

/**
 * 
 * Basic testing of an com.verticon.tracker.store.mongodb service and its
 * dependent services.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>IMongoClientProvider</li>
 * <li>IFunctionProvider</li>
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
public class Test_TrackerStore_1 extends TestCase implements
		ISubscriberListener {

	private final static DateFormat DATE_FORMAT = new SimpleDateFormat(
			ITrackerFind.DATE_PATTERN);

	private static final int NUMBER_OF_ITERATIONS = 100;

	private static final String DATE_START = "2011-01-01";
	private static final String DATE_2011_05_01 = "2011-05-01";

	static final String DOC_PREMISES = "example.premises";
	private static final String TAG_ID_2 = "abcd";
	static final String TAG_ID_1 = "1234567890";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerStore_1.class);

	/**
	 * This class is a JUnit class and a DS component. There needs to be a
	 * synchronization between the DS and JUnit initializations. This is done
	 * with a java.util.concurrent.CountDownLatch.
	 * 
	 * In the JUnit setUp() method the startUpGate.await() will be called which
	 * will block until all DS services are injected. When all services are
	 * injected and DS calls the startup() method startUpGate.countDown() is
	 * called unblocking the thread waiting in the setUp(). Once tripped the
	 * latch lets subsequent calls through.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);

	// private static final CountDownLatch messageReceivedGate = new
	// CountDownLatch(
	// 1);

	private static final CyclicBarrier messageReceivedBarrier = new CyclicBarrier(
			2);

	/**
	 * Injected services
	 */
	static ITrackerStore trackerStore;
	static ISubscriber subscriber;

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void setTrackerStore(ITrackerStore trackerStore) {
		Test_TrackerStore_1.trackerStore = trackerStore;
	}

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void unsetTrackerStore(ITrackerStore trackerStore) {
		Test_TrackerStore_1.trackerStore = null;
	}

	void setSubscriber(ISubscriber subscriber) {
		Test_TrackerStore_1.subscriber = subscriber;
		subscriber.setListener(this);
	}

	void unsetSubscriber(ISubscriber subscriber) {
		logger.debug(bundleMarker, "DS removing the subscriber");
		subscriber.setListener(null);
		Test_TrackerStore_1.subscriber = null;

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
		startUpGate.await();// wait for startUp to finish
		logger.info(bundleMarker, "START TEST");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		logger.info(bundleMarker, "END TEST");
	}

	/**
	 * On activation of this component this method is called.
	 * 
	 */
	void activate() {
		startUpGate.countDown();
		logger.debug(bundleMarker, "Activate.");
	}

	void deactivate() {
		logger.debug(bundleMarker, "DeActivated.");
	}

	@Test
	public void test_Store() {
		assertThat("Store must have a uri", trackerStore.uri(),
				is(notNullValue()));
		assertThat("Store must have a uri", trackerStore.uri(),
		// is("tcp://m2m.eclipse.org:1883"));
				is("tcp://tuna:1883"));
	}
	/**
	 * Test authorization and set it
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws BrokenBarrierException
	 */
	@Test
	public void test_Register() throws IOException, InterruptedException,
			BrokenBarrierException {
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("URI must be urn:pin:H89234X", premises.getUri(),
				is(PREMISES_URI_H89234X));
		assertThat("Should have five areas", premises.getLocation().getAreas()
				.size(), is(5));
		logger.debug(bundleMarker, "Registering premises {}", premises.getUri());
		trackerStore.register(premises);
		logger.debug(bundleMarker, "Waiting for message");
		try {
			messageReceivedBarrier.await(3, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			fail("Timed out wait for message.");
		}

		assertThat("Must have one message", subscriber.messages().size(), is(1));
		Entry<String, MqttMessage> messageEntry = Iterables.get(subscriber
				.messages().entrySet(), 0);
		String topicName = messageEntry.getKey();
		MqttMessage message = messageEntry.getValue();
		byte[] payload = message.getPayload();
		List<EObject> eObjects = toEObject(payload);
		assertThat("Must have one eObject", eObjects.size(), is(1));
		assertThat("Must be a premises", eObjects.get(0),
				is(instanceOf(Premises.class)));

		assertThat("Topic name is wrong", topicName,
				is("Agriculture/Premises/urn:pin:H89234X/Register/EMF"));
	}

	@Test
	public void test_TrackerFind_RetrievePremises() throws IOException {

		Premises premises = trackerStore.retrievePremises(PREMISES_URI_H89234X);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Premises should have name", premises.getName(),
				is("East Farm"));
		assertThat("Premises should have no Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));
		assertThat("URI must be urn:pin:H89234X", premises.getUri(),
				is(PREMISES_URI_H89234X));
		assertThat("Should have five areas", premises.getLocation().getAreas()
				.size(), is(5));
	}



	@Test
	public void test_QueryForLastPub() throws IOException {
		String result = trackerStore.query(Query.LAST_PUB_QUERY_TEMPLATE
				.replace("12345"));
		assertThat("Result must not be null.", result, is(notNullValue()));
		BSONObject response = (BSONObject) JSON.parse(result);
		logger.debug(bundleMarker, "Response is: {}", result);
		List<?> list = (List<?>) response.get("result");
		assertThat("Result list must be one", list.size(), is(1));
		assertThat("Wrong type", ((BSONObject) list.get(0)).get("update"),
				is(instanceOf(Date.class)));
	}

	@Test
	public void test_RecordAnimal() throws IOException, InterruptedException,
			BrokenBarrierException {
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);

		assertThat("Premises has wrong number of animals", premises
				.getAnimals().size(), is(7));

		logger.debug(bundleMarker, "Recording events premises {}",
				premises.getUri());

		IUpdateStats stats = trackerStore.recordAnimals(premises);

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));
		assertThat("Incorrect number of animals processed. ",
				stats.getAnimalsProcessed(), is(7));

		assertThat("Incorrect number of animals", stats.getAnimalsAdded(),
				is(7));
		assertThat("Incorrect number of tags", stats.getTagsAdded(), is(7));
		assertThat("Incorrect number of events", stats.getEventsAdded(),
				is(premises.eventHistory().size()));
	}

	@Test
	public void test_RetrieveAnimal() throws IOException, InterruptedException,
			BrokenBarrierException {
		Animal animal = trackerStore.retrieveAnimal("840456789012341");

		assertThat("Animal should not be null", animal, is(notNullValue()));

		assertThat("Animal should be a swine", animal.getType(),
				is(AnimalType.BOVINE_BEEF));

		assertThat("Animal should have 1 tag", animal.getTags().size(), is(1));
		assertThat("Animal should have id", animal.getId(),
				is("840456789012341"));
		assertThat("Animal should have 8 events", animal.eventHistory().size(),
				is(8));

	}

	@Test
	public void test_TrackerFind_RetrievePremises_Dates_Simple()
			throws IOException {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		Premises premises = trackerStore.retrievePremises(PREMISES_URI_H89234X,
				DATE_START, DATE_FORMAT.format(c.getTime()));
		assertThat("Premises should not be null", premises, is(notNullValue()));

		assertThat("Premises should have name", premises.getName(),
				is("East Farm"));
		assertThat("Premises should have 3 Animals", premises.getAnimals()
				.size(), is(3));
		// Animal animal = premises.getAnimals().get(0);

		assertThat("Premises should have 3 events", premises.eventHistory()
				.size(), is(10));

	}

	/**
	 * db.Premises.find( { "location.loc" : { $near :
	 * [-90.95048182270057,43.47622307339506,0 ] , $maxDistance : 1 } } )
	 * 
	 * @throws IOException
	 */
	@Test
	public void test_TrackerFind_RetrievePremises_Point() throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-77.037852,38.898556,0");
		// position.setLatitude(38.898556);
		// position.setLongitude(-77.037852);
		Premises premises = trackerStore.retrievePremises(point);

		assertThat("Premises should not be null", premises, is(notNullValue()));

		assertThat("Premises should have uri", premises.getUri(),
				is(PREMISES_URI_H89234X));
		assertThat("Premises should have name", premises.getName(),
				is("East Farm"));
		assertThat("Premises should have no Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));
	}

	@Test
	public void test_TrackerFind_RetrievePremises_Point_Dates()
			throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-90.95048182270057,43.47622307339506,0");
		Premises premises = trackerStore.retrievePremises(point, DATE_START,
				DATE_2011_05_01);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Premises should have uri", premises.getUri(),
				is(PREMISES_URI_H89234X));
		assertThat("Premises should have name", premises.getName(),
				is("East Farm"));
		assertThat("Premises should have 1 Animals", premises.getAnimals()
				.size(), is(1));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));
	}

	@Test
	public void test_getPremisesNames() throws InterruptedException {
		Set<String> uris = newHashSet(PREMISES_URI_H89234X, "xyz", "abc");
		Map<String, String> nameMap = trackerStore.getPremisesNames(uris);
		assertThat("Should not be null", nameMap, is(notNullValue()));
		assertThat("Should have 1 entries", nameMap.size(), is(1));
		// System.out.println("******" + nameMap);
		// String name = nameMap.get(PREMISES_URI);
		// assertThat("Should not be null", name, is(notNullValue()));
		// assertThat("Should be", name, is("Jack Condor"));

		String name = nameMap.get(PREMISES_URI_H89234X);
		assertThat("Should not be null", name, is(notNullValue()));
		assertThat("Should be", name, is("East Farm"));
	}

	@Override
	public void messageArrived() {
		logger.debug(bundleMarker, "Message arrived in testcase");
		try {
			messageReceivedBarrier.await();
		} catch (Exception e) {
			logger.error(bundleMarker, "Barrier problem.", e);
		}

	}

	private final List<EObject> toEObject(byte[] payload) throws IOException {
		ByteArrayInputStream ba = new ByteArrayInputStream(payload);
		Resource resource = new BinaryResourceImpl();
		resource.load(ba, null);
		return resource.getContents();
	}

}
