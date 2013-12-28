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

package org.usaha.ecvi.store.mqtt.test.system;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.usaha.ecvi.store.mqtt.test.system.Configurator.bundleMarker;
import static org.usaha.ecvi.store.mqtt.test.system.Configurator.getXMIResource;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usaha.ecvi.DocumentRoot;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.store.IEcviStore;

import com.verticon.mqtt.test.utilities.ISubscriberListener;
import com.verticon.mqtt.test.utilities.ISubscriberPublisher;

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
public class Test_MqttEcviStoreComponent_1 extends TestCase implements
		ISubscriberListener {
	// private static final String ECVI_COLLECTION_NAME = "Ecvi";


	private static final String EXAMPLE1_ECVI = "Example1.ecvi";
	private static final Map<String, MqttMessage> messages = new ConcurrentHashMap<String, MqttMessage>();
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_MqttEcviStoreComponent_1.class);

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
	private static final CyclicBarrier messageReceivedBarrier = new CyclicBarrier(
			2);

	/**
	 * Injected services
	 */
	static IEcviStore ecviStore;
	static ISubscriberPublisher subscriber;

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void setEcviStore(IEcviStore ecviStore) {
		logger.debug(bundleMarker, "DS injecting the ecviStore");
		Test_MqttEcviStoreComponent_1.ecviStore = ecviStore;
	}

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void unsetEcviStore(IEcviStore ecviStore) {
		logger.debug(bundleMarker, "DS injecting the ecviStore");
		Test_MqttEcviStoreComponent_1.ecviStore = null;
	}

	void setSubscriber(ISubscriberPublisher subscriber) {
		Test_MqttEcviStoreComponent_1.subscriber = subscriber;
		subscriber.setListener(this);
	}

	void unsetSubscriber(ISubscriberPublisher subscriber) {
		logger.debug(bundleMarker, "DS removing the subscriber");
		subscriber.setListener(null);
		Test_MqttEcviStoreComponent_1.subscriber = null;

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
	public void test_MqttEcviStoreComponent() throws IOException {
		Resource resource = getXMIResource(EXAMPLE1_ECVI, "");
		DocumentRoot documentRoot = (DocumentRoot) resource.getContents()
				.get(0);
		Ecvi ecvi = documentRoot.getECVI();
		ecvi.setCviNumber("testEcviMongoComponent@" + new Date());

		String uri = ecviStore.getURIs().iterator().next();
		System.out.println("URI for provider: " + uri);
		assertThat("URI cannot be null or empty", !isNullOrEmpty(uri));

		ecviStore.record(ecvi, uri);

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) {
		logger.debug(bundleMarker, "Message arrived in testcase for topic {}",
				topic);
		if (topic.endsWith("Response")) {
			logger.info(bundleMarker, "Response topic {}", topic);
			messages.put(topic, message);
			try {
				messageReceivedBarrier.await();
			} catch (Exception e) {
				logger.error(bundleMarker, "Barrier problem.", e);
			}

		} else if (topic.endsWith("Ecvi/EMF")) {
			try {
				handleEcviRecord(topic, message);
			} catch (Exception e) {
				logger.error(bundleMarker, "Failed to handle Ecvi/EMF topic", e);
				fail(e.getLocalizedMessage());
			}
		}
	}

	private void handleEcviRecord(String topic, MqttMessage message)
			throws MqttPersistenceException, MqttException {
		logger.info(bundleMarker, "Registration arrived on topic {}", topic);
		String responseTopic = topic.replace("Ecvi/EMF", "EcviResponse");
		subscriber.publish(responseTopic, "OK".getBytes());
	}

}
