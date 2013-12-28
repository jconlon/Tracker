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

package org.usaha.ecvi.store.mongodb.test.system;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.usaha.ecvi.store.mongodb.test.system.Configurator.bundleMarker;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.BundleContext;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usaha.ecvi.DocumentRoot;
import org.usaha.ecvi.Ecvi;

import com.mongodb.DBCollection;
import com.verticon.tracker.irouter.test.utilities.IConsumerListener;
import com.verticon.tracker.irouter.test.utilities.IProducerConsumer;

/**
 * iRouter testing of the
 * org.usaha.ecvi.store.mongodb.internal.irouter.EcviMongoRouterComponent.
 * 
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>IProducerConsumer</li>
 * <li>Monitorable</li>
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
public class Test_EcviMongoIRouterComponent extends TestCase implements
		IConsumerListener {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_EcviMongoIRouterComponent.class);

	private static final String ECVI_SCOPE = "agriculture.ecvi";
	private static final String RESPONSE_SCOPE_KEY = "[agriculture.ecvi.response]";

	//
	private static final String STATUS = "consumer.Connection_Status";
	//
	private static final String ECVIS_RECORDED = "consumer.Ecvis_Recorded";
	//
	private static final String PRODUCTS_CONSUMED = "consumer.Products_Consumed";
	private static final String EXCEPTIONS = "consumer.Exception_Count";

	private static final CyclicBarrier mockProductConsumedBarrier = new CyclicBarrier(
			2);

	/**
	 * Injected service
	 */
	private static IProducerConsumer producerConsumer;
	private static Monitorable monitorable;
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
		producerConsumer.clearSendCount();
		resetStatus();
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
	void activate(BundleContext context) {
		logger.debug(bundleMarker, "Activating");
		startUpGate.countDown();

	}

	void deactivate() {
		logger.debug(bundleMarker, "DEActivating");

	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	void setMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_EcviMongoIRouterComponent.monitorable = monitorable;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	void unsetMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_EcviMongoIRouterComponent.monitorable = null;
	}

	/**
	 * Injected by ds
	 * 
	 * @param producerConsumer
	 */
	void setController(IProducerConsumer producerConsumer) {
		logger.debug(bundleMarker, "DS injecting the producerConsumer");
		Test_EcviMongoIRouterComponent.producerConsumer = producerConsumer;
		producerConsumer.setName(Configurator.PLUGIN_ID);
		producerConsumer.setListener(this);
	}

	/**
	 * Injected by ds
	 * 
	 * @param producerConsumer
	 */
	void unsetController(IProducerConsumer producerConsumer) {
		logger.debug(bundleMarker, "DS injecting the producerConsumer");
		Test_EcviMongoIRouterComponent.producerConsumer = null;
		producerConsumer.setListener(null);
	}

	public void test_EcviMongoIRouterComponent() throws InterruptedException,
			BrokenBarrierException, IOException {
		logger.debug(bundleMarker, "testEcviMongoIRouterComponent");
		DBCollection coll = Test_EcviStore.getCollection();
		assertThat("Must have only 1 Ecvi documents", coll.find().count(),
				is(1));

		assertThat("Controller must have wires", producerConsumer.hasWires(),
				is(true));

		assertThat("Must have a status", monitorable.getStatusVariable(STATUS)
				.getString(), is(notNullValue()));

		assertThat("Must be Activated  status",
				monitorable.getStatusVariable(STATUS).getString(),
				is(startsWith("Activated ")));

		// Create a Ecvi and send it
		Resource resource = Test_EcviStore.getXMIResource("Example1.ecvi", "");
		DocumentRoot documentRoot = (DocumentRoot) resource.getContents()
				.get(0);
		Ecvi ecvi = documentRoot.getECVI();
		ecvi.setCviNumber("testEcviMongoIRouterComponent@" + new Date());

		Envelope envelope = new BasicEnvelope(ecvi, "topicTBD", ECVI_SCOPE);

		producerConsumer.send(envelope);
		logger.debug(bundleMarker, "Waiting for product");
		try {
			mockProductConsumedBarrier.await(3, TimeUnit.SECONDS);
			mockProductConsumedBarrier.reset();
		} catch (TimeoutException e) {
			fail("Timed out wait for product.");
		}

		assertThat("Controller must have sent the envelope",
				producerConsumer.sentCount(), is(1));

		assertThat("Wrong number of products consumed.", monitorable
				.getStatusVariable(PRODUCTS_CONSUMED).getInteger(), is(1));

		assertThat(
				"Must have no exceptions: "
						+ monitorable.getStatusVariable(STATUS).getString(),
				monitorable.getStatusVariable(EXCEPTIONS).getInteger(), is(0));

		assertThat("Wrong number of Ecvis recorded.", monitorable
				.getStatusVariable(ECVIS_RECORDED).getInteger(), is(1));

		assertThat("The MockProducerConsumer must have one consumed product",
				producerConsumer.getConsumedProducts().size(), is(1));

		String key = producerConsumer.getConsumedProducts().keySet().iterator()
				.next();
		assertThat("agriculture.ecvi.response", key,
				is("[agriculture.ecvi.response]"));

		Object o = producerConsumer.getConsumedProducts().get(
				RESPONSE_SCOPE_KEY);
		assertThat("There must be a agriculture.ecvi.response ", o,
				is(notNullValue()));

		assertThat("There must be a Envelope in the response ",
				o instanceof Envelope, is(true));

		assertThat("There must be a byte array in the envelope value ",
				((Envelope) o).getValue() instanceof byte[], is(true));

		byte[] response = (byte[]) ((Envelope) o).getValue();
		String resp = new String(response);
		assertThat("Response should be OK", resp, is("OK"));
		assertThat("Must have only 2 Ecvi documents", coll.find().count(),
				is(2));
	}

	private void resetStatus() {
		monitorable.resetStatusVariable(ECVIS_RECORDED);
		monitorable.resetStatusVariable(PRODUCTS_CONSUMED);

	}

	@Override
	public void productConsumed() {
		logger.debug(bundleMarker,
				"Product consumed by the MockProducerConsumer");
		try {
			mockProductConsumedBarrier.await();
		} catch (Exception e) {
			logger.error(bundleMarker, "Barrier problem.", e);
		}

	}
}
