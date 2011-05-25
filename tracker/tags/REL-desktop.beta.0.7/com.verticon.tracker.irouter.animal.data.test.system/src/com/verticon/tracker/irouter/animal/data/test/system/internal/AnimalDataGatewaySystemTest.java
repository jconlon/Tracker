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
package com.verticon.tracker.irouter.animal.data.test.system.internal;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.verticon.tracker.irouter.common.TrackerConstants;

/**
 * AnimalDataGateway is a Premises model specific Component Factory that creates
 * services that produce a list of animal life data records extracted from a
 * specified Premises model file.
 * 
 * This system test is a JUnit Plugin test called by a DS component. It creates a 
 * AnimalDataGateway configuration and submits it to the configuration admin service
 * for the creation of an iRouter Animal Data Gateway factory instance.
 * 
 * The component references the ConfigAdmin and Consumer Services.  The Consumer Service is
 * a simple MockConsumer that is used to save consumed objects.
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the MockConsumer. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * 
 * @author jconlon
 * 
 */
public class AnimalDataGatewaySystemTest extends TestCase {

	private static final String PLATFORM_RESOURCE_URI = "platform:/plugin/com.verticon.tracker.irouter.animal.data.test.system/example.premises";
	private static final String SERVICE_TAG_VALUE = "instance";
	private static final String SERVICE_TAG = "animal.data.test";
	private static final String OUTPUT_INFORMATION = "animal.data";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.animal.data.test.system";

	// Configuration
	private static final String MAPPER = "animal.life.data.mapping"; // Optional
	private static final String CONNECTION_URI = "connection.uri"; // Required
	private static final String SERVICE_PID = "service.pid"; // Required
	private static final String REFRESH_SECONDS = "refresh.seconds"; // Optional
	private static final String FIELDS = "animal.life.data.fields"; // Optional

	// Status Variables
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String TIME_OF_LAST_UPDATE = "producer.Last_Data_Update";
	private static final String TOTAL_RECORDS_SENT = "producer.Total_Records_Sent";
	private static final String CONNECTION_URI_STATUS_VAR = "producer.Connection_URI";
	private static final String UPLOAD_EXCEPTION = "producer.Upload_Exception";

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
			.getLogger(AnimalDataGatewaySystemTest.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static MockConsumer mockConsumer;
	private static ConfigurationAdmin configAdmin;

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		AnimalDataGatewaySystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		AnimalDataGatewaySystemTest.mockConsumer = (MockConsumer) value;
	}

	/**
	 * 
	 * Called by the test framework to setup the test case.
	 * 
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		logger.info(bundleMarker,
				"Waiting for declarative services activation startup method to finish");
		startUpGate.await();// wait for startUp to finish
		logger.info(bundleMarker, "startup and setUp finished.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		mockConsumer.receivedObject = null;
		super.tearDown();
	}

	public void startup(BundleContext context) {
		AnimalDataGatewaySystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testAnimalDataGateway() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.animal.data";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary<String, Object> conf = new Hashtable<String, Object>();
		conf.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { OUTPUT_INFORMATION });
		conf.put(CONNECTION_URI, PLATFORM_RESOURCE_URI); // Required
		conf.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		// Add a tag to find the service
		conf.put(SERVICE_TAG, SERVICE_TAG_VALUE);
		conf.put(SERVICE_PID, "myservice.pid");
		conf.put(REFRESH_SECONDS, Integer.valueOf(33));
		conf.put(FIELDS, new String[] { "id", "speciesCode", "sexCode" });
		conf.put(MAPPER, new String[] { "speciesCode|BOV|fish",
				"sexCode|M|bull", "sexCode|F|cow", "STATIC|1|ONE",
				"sexCode|F|cow", "STATIC|3|THREE", });

		// Consumer has a latch, set it to go off after receiving 1 object
		mockConsumer.setUpLatch(1);

		//Create the instance
		config.update((Dictionary) conf);

		boolean receivedRecords = mockConsumer.latch
				.await(10, TimeUnit.SECONDS);
		assertTrue("Timeout waiting to receive product", receivedRecords);

		// Get the configured service using the tag
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(), "(" + SERVICE_TAG + "="
						+ SERVICE_TAG_VALUE + ")");
		assertNotNull("No Monitorable service found", refs);
		assertTrue("No Monitorable service found", refs.length == 1);
		ServiceReference monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		StatusVariable sv = monitorable
				.getStatusVariable(CONNECTED_CONSUMERS_COUNT);
		assertEquals("Should one connected mockconsumer", 1, sv.getInteger());

		sv = monitorable.getStatusVariable(TOTAL_RECORDS_SENT);
		assertEquals("Should be five records sent", 5, sv.getInteger());

		sv = monitorable.getStatusVariable(CONNECTION_URI_STATUS_VAR);
		assertEquals("Should be the connection URI", PLATFORM_RESOURCE_URI,
				sv.getString());

		sv = monitorable.getStatusVariable(TIME_OF_LAST_UPDATE);
		assertNotNull("Should be a date", sv.getString());
		assertFalse("Should be a date", isNullOrEmpty(sv.getString()));
		System.out.println(sv.getString());
		logger.info(bundleMarker, "time of last update {}.", sv.getString());

		sv = monitorable.getStatusVariable(UPLOAD_EXCEPTION);
		assertEquals("Should be an empty string", "", sv.getString());
		logger.info(bundleMarker, "time of last update {}.", sv.getString());

		assertNotNull(mockConsumer.receivedObject);
		assertTrue(mockConsumer.receivedObject instanceof ImmutableList);
		ImmutableList<String> records = (ImmutableList<String>) mockConsumer.receivedObject;
		assertEquals(5, records.size());
		assertEquals(5,
				Iterables.size((Splitter.on(',').split(records.get(0)))));
		assertEquals("ONE,840456789012341,THREE,fish,bull", records.get(0));
		assertEquals("ONE,840456789012342,THREE,fish,cow", records.get(1));
		assertEquals("ONE,840456789012343,THREE,fish,bull", records.get(2));
		assertEquals("ONE,840456789012344,THREE,fish,C", records.get(3));
		assertEquals("ONE,840456789012345,THREE,fish,C", records.get(4));

	}
}
