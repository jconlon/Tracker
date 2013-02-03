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

package com.verticon.tracker.irouter.ohaus.test.system.internal;

import static com.verticon.tracker.irouter.ohaus.test.system.internal.Configurator.bundleMarker;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Basic testing of the com.verticon.tracker.irouter.ohaus component.
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
 * If a comm port is use a valid port needs to be set as a system property
 * -Dgnu.io.rxtx.SerialPorts=/dev/ttyS0:/dev/rfcomm0 is a valid configuration
 * 
 * @author jconlon
 * 
 */
public class Test_Ohaus_Proxy extends TestCase {


	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_Ohaus_Proxy.class);


	private static BundleContext context;
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
	 * Injected services implement by
	 * com.verticon.tracker.store.mongo.internal.Component
	 */
	static Monitorable monitorable;
	static Producer producer;

	static MockConsumer consumer;
	


	public void setProducer(Producer producer) {
		logger.debug(bundleMarker, "DS injecting the Producer");
		Test_Ohaus_Proxy.producer = producer;
	}



	public void unsetProducer(Producer producer) {
		logger.debug(bundleMarker, "DS nulling the Producer");
		Test_Ohaus_Proxy.producer = null;
	}

	public void setConsumer(Consumer consumer) {
		logger.debug(bundleMarker, "DS injecting the consumer");
		Test_Ohaus_Proxy.consumer = (MockConsumer) consumer;
	}

	public void unsetConsumer(Consumer consumer) {
		logger.debug(bundleMarker, "DS nulling the consumer");
		Test_Ohaus_Proxy.consumer = null;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	public void setMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_Ohaus_Proxy.monitorable = monitorable;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	public void unsetMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS nulling the monitorable");
		Test_Ohaus_Proxy.monitorable = null;
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
		// System.out.println(this + ": startup and setUp finished.");
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
		logger.debug(bundleMarker, "Activating");
		Test_Ohaus_Proxy.context = context;
		startUpGate.countDown();
	}

	protected void deactivate() {
		logger.debug(bundleMarker, "DEActivating");
	}

	//Tests
	/**
	 * This is mostly redundant all of these should be there to get this far.
	 */
	@Test
	public void testContext() {
		assertThat("BundleContext was not setup", context, is(notNullValue()));

	}

	/**
	 * 
	 * {'events.dateTime' : {$gte :new Date(2010, 02, 01), $lt : new Date(2011,
	 * 04, 01)}}
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testPause() throws InterruptedException {
		// TimeUnit.SECONDS.sleep(100);
		logger.debug(bundleMarker, "Sleeping for 5 minutes");
		TimeUnit.MINUTES.sleep(2);
		assertThat("Consumer must have received one or more weights",
				consumer.getCount(), is(greaterThan(0)));
//		assertThat("Result must not be null.", eo, is(notNullValue()));
//		assertThat("Result must not be empty.", eo.isEmpty(), is(false));
//		assertThat("Result must be one tag", eo.size(), is(5));
//		assertThat("Result must be a Tag", eo.get(0), is(instanceOf(Tag.class)));
	}

}
