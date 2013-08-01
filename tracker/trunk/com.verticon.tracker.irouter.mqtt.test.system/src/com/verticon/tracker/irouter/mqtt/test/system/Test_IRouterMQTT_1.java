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

package com.verticon.tracker.irouter.mqtt.test.system;


import static com.verticon.tracker.irouter.mqtt.test.system.Configurator.PREMISES_URI_H89234X;
import static com.verticon.tracker.irouter.mqtt.test.system.Configurator.bundleMarker;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import junit.framework.TestCase;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.junit.Test;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.verticon.tracker.irouter.mqtt.Utils;

/**
 * 
 * Basic testing of an com.verticon.tracker.store.mongodb service and its
 * dependent services.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>IMongoClientProvider</li>Test_MongoDB_Consumer
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
public class Test_IRouterMQTT_1 extends TestCase implements
		ISubscriberListener, IConsumerListener {

	static final String DOC_PREMISES = "example.premises";
	private static final String TAG_ID_2 = "abcd";
	static final String TAG_ID_1 = "1234567890";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_IRouterMQTT_1.class);

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

	private static final CyclicBarrier mockSubscriberMessageReceivedBarrier = new CyclicBarrier(
			2);

	private static final CyclicBarrier mockProductConsumedBarrier = new CyclicBarrier(
			2);

	/**
	 * Injected services
	 */
	static ISubscriberPublisher subscriberPublisher;
	static IProducerConsumer producerConsumer;

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void setProducerConsumer(IProducerConsumer producerConsumer) {
		Test_IRouterMQTT_1.producerConsumer = producerConsumer;
		producerConsumer.setListener(this);
	}

	void unsetProducerConsumer(IProducerConsumer producerConsumer) {
		Test_IRouterMQTT_1.producerConsumer = null;
		producerConsumer.setListener(null);
	}

	void setSubscriberPublisher(ISubscriberPublisher subscriberPublisher) {
		Test_IRouterMQTT_1.subscriberPublisher = subscriberPublisher;
		subscriberPublisher.setListener(this);
	}

	void unsetSubscriberPublisher(ISubscriberPublisher subscriberPublisher) {
		logger.debug(bundleMarker, "DS removing the subscriberPublisher");
		subscriberPublisher.setListener(null);
		Test_IRouterMQTT_1.subscriberPublisher = null;

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
	 */
	void activate() {
		startUpGate.countDown();
		logger.debug(bundleMarker, "Activate.");
	}

	void deactivate() {
		logger.debug(bundleMarker, "DeActivated.");
	}

	@Test
	public void test_Utils() {
		boolean match = Utils.matches("Agriculture/Premises/"
				+ PREMISES_URI_H89234X
				+ "/Response", "Agriculture/Premises/+/Query");
		assertThat("Should not match", match, is(false));

		match = Utils.matches("Agriculture/Premises/xxxx/Query",
				"Agriculture/Premises/+/Query");

		assertThat("Should match", match, is(true));

		match = Utils.matches("Agriculture/Premises/xxxx/Query",
				"Agriculture/Premises/#");

		assertThat("Should match", match, is(true));
	}

	/**
	 * Send a payload to the MockProducerConsumer which will update the consumer
	 * side of the Component. The component will publish it to MQTT which will
	 * be received by the MockSubscriberPublisher
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws BrokenBarrierException
	 */
	@Test
	public void test_iRouterToMqtt() throws IOException, InterruptedException,
			BrokenBarrierException {
		// TimeUnit.SECONDS.sleep(60);
		logger.debug(bundleMarker, "Start test_iRouterToMqtt");
		// Have the mock producer create a product that will be consumed
		// by the MqttBridgeComponent Consumer then published
		producerConsumer.produce("agriculture.premises.response",
				"Agriculture/Premises/" + PREMISES_URI_H89234X + "/Response",
				"Hi There".getBytes());

		logger.debug(bundleMarker, "Waiting for message");
		try {
			mockSubscriberMessageReceivedBarrier.await(3, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			fail("Timed out wait for message.");
		}

		assertThat("Must have one message", subscriberPublisher.messages().size(), is(1));
		Entry<String, MqttMessage> messageEntry = Iterables.get(subscriberPublisher
				.messages().entrySet(), 0);
		String topicName = messageEntry.getKey();
		assertThat(
				"Wrong topicName for received message",
				topicName,
				is("Agriculture/Premises/" + PREMISES_URI_H89234X + "/Response"));

		MqttMessage message = messageEntry.getValue();
		byte[] payload = message.getPayload();
		String value = new String(payload);
		assertThat("Must have one eObject", value, is("Hi There"));

	}

	/**
	 * 
	 * <table>
	 * <col width="25%"/> <col width="25%"/> <col width="30%"/> <col
	 * width="25%"/> <thead>
	 * <tr>
	 * <th>Component</th>
	 * <th>Scopes producer</th>
	 * <th>Scope consumer</th>
	 * <th>Subscribe Topic</th>
	 * </tr>
	 * <thead> <tbody>
	 * <tr>
	 * <td>MockProducerConsumer</td>
	 * <td>agriculture.premises.query</td>
	 * <td>agriculture.premises.response</td>
	 * <td></td>
	 * 
	 * </tr>
	 * <tr>
	 * <td>MqttBridgeComponent</td>
	 * <td>agriculture.premises.response</td>
	 * <td>agriculture.premises.query</td>
	 * <td>Agriculture/Premises/+/Query</td>
	 * </tr>
	 * <tr>
	 * <td>MockSubscriberPublisher</td>
	 * <td></td>
	 * <td></td>
	 * <td>Agriculture/Premises/+/Response</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * <br>
	 * 
	 * 
	 * Publish a payload from the MockPublisher to mqtt the component will
	 * receive it on a topic that the component is subscribed to. Component
	 * should update the iRouter consumer wired to it.
	 * 
	 * @throws MqttPersistenceException
	 * @throws MqttException
	 * @throws BrokenBarrierException
	 * @throws InterruptedException
	 */
	@Test
	public void test_MqttToIRouter() throws MqttPersistenceException,
			MqttException, InterruptedException, BrokenBarrierException {
		logger.debug(bundleMarker, "Start test_MqttToIRouter");
		producerConsumer.getConsumedProducts().clear();
		subscriberPublisher.publish("Agriculture/Premises/"
				+ PREMISES_URI_H89234X + "/Query", "Hi There".getBytes());
		logger.debug(bundleMarker, "Waiting for product");
		try {
			mockProductConsumedBarrier.await(3, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			fail("Timed out wait for product.");
		}

		assertThat("Must have one message", producerConsumer
				.getConsumedProducts().size(), is(1));
		Entry<String, Object> productEntry = Iterables.get(producerConsumer
				.getConsumedProducts().entrySet(), 0);
		String scopes = productEntry.getKey();
		assertThat("Wrong scopes for received message", scopes,
				is("[agriculture.premises.query]"));

		Envelope envelope = (Envelope) productEntry.getValue();
		assertEquals(
				"Wrong id for consumed",
				envelope.getIdentification(),
				"Agriculture/Premises/" + PREMISES_URI_H89234X + "/Query");
		byte[] payload = (byte[]) envelope.getValue();

		String value = new String(payload);
		assertThat("Must have a string", value, is("Hi There"));
	}



	@Override
	public void messageArrived() {
		logger.debug(bundleMarker, "Message arrived in MockSubscriber");
		try {
			mockSubscriberMessageReceivedBarrier.await();
		} catch (Exception e) {
			logger.error(bundleMarker, "Barrier problem.", e);
		}

	}

	@Override
	public void productConsumed() {
		logger.debug(bundleMarker, "Product consumed by MockConsumer");
		try {
			mockProductConsumedBarrier.await();
		} catch (Exception e) {
			logger.error(bundleMarker, "Barrier problem.", e);
		}

	}


}
