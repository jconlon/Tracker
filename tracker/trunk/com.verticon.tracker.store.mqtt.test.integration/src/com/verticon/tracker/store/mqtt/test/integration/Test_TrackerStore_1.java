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

import static com.verticon.tracker.store.mqtt.test.integration.Configurator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.mqtt.test.integration.Configurator.bundleMarker;
import static com.verticon.tracker.store.mqtt.test.integration.Configurator.getXMIResource;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.verticon.mqtt.test.utilities.ISubscriberListener;
import com.verticon.mqtt.test.utilities.ISubscriberPublisher;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;

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

	static final String DOC_PREMISES = "example.premises";
	static final String TAG_ID_1 = "1234567890";

	private static final Map<String, MqttMessage> messages = new ConcurrentHashMap<String, MqttMessage>();

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
	static ISubscriberPublisher subscriber;

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

	void setSubscriber(ISubscriberPublisher subscriber) {
		Test_TrackerStore_1.subscriber = subscriber;
		subscriber.setListener(this);
	}

	void unsetSubscriber(ISubscriberPublisher subscriber) {
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
		messageReceivedBarrier.reset();
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

		assertThat("Must have one message", messages.size(), is(1));
		Entry<String, MqttMessage> messageEntry = Iterables.get(
				messages.entrySet(), 0);
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

	@Override
	public void messageArrived(String topic, MqttMessage message) {
		if (topic.endsWith("Query")) {
			handleQuery(topic, message);
		} else if (topic.endsWith("Response")) {
			logger.info(bundleMarker, "Ignoring topic {}", topic);

		} else {
			logger.info(bundleMarker, "Message arrived on topic {}", topic);
			try {
				messages.put(topic, message);
				messageReceivedBarrier.await();
			} catch (Exception e) {
				logger.error(bundleMarker, "Barrier problem.", e);
			}
		}

	}

	@SuppressWarnings("unused")
	private void handleQuery(String topic, MqttMessage message) {
		logger.info(bundleMarker, "Query arrived on topic {}", topic);
		String query = new String(message.getPayload());
		byte[] payload;
		try {
			if (query.startsWith("{trackerStore")) {
				// payload = handleTrackerStoreQuery(topic, query);
			} else if (query.startsWith("{aggregate")) {
				logger.debug(bundleMarker, "Received update query: " + query);
				// String response = "{'result' : [{"
				// + "'update' : '2012-10-08T22:36:39.046Z'"//
				// ISODate('2012-10-08T22:36:39.046Z')"
				// + "}],'ok' : 1}";
				// payload = response.getBytes();
			} else {
				logger.debug(bundleMarker, "Unknown query {}", query);
				return;
			}
			// String responseTopic = topic.replace("Query", "Response");
			// client.publish(responseTopic, payload, 2, false);
		} catch (Exception e) {
			logger.error(bundleMarker, "Failed to handle query " + query, e);

		}

	}

	private final List<EObject> toEObject(byte[] payload) throws IOException {
		ByteArrayInputStream ba = new ByteArrayInputStream(payload);
		Resource resource = new BinaryResourceImpl();
		resource.load(ba, null);
		return resource.getContents();
	}

}
