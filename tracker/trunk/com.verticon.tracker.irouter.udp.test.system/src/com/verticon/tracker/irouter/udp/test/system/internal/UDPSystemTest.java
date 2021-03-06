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
package com.verticon.tracker.irouter.udp.test.system.internal;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.dev.IDeviceListener;

/**
 * 
 * GPSProducer manages connections to a gps device with a GPSProxy to produce
 * Position objects.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>ConnectorService</li>
 * <li>MonitorListener</li>
 * </ol>
 * 
 * Depends on a GPS device running on the TARGET_SERVER.
 * 
 * Test currently using the fake gps simulator (by adding the plugin
 * com.verticon.tracker.irouter.gps.dev.fake to the launcher configuration.)
 * 
 * Alternatively it can be:
 * <ol>
 * <li>a real gps</li>
 * <li>the GPS web simulator: com.verticon.tracker.irouter.gps.dev.sim running
 * within the simulator product</li>
 * </ol>
 * 
 * This system test is a JUnit Plugin test that uses a real or a Mock device
 * connect to and a Mock Consumer to receive Position products.
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the MockProducer. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * 
 * @author jconlon
 * 
 */
public class UDPSystemTest extends TestCase {
	private static final String GPS_SERVICE_TAG_VALUE = "gpsProxyProducer";
	private static final String UDP_SERVICE_TAG_VALUE = "udpGateway";
	private static final String SERVICE_TAG = "udp.test";

	// config
	private static final String TRACKER_WIRE_GROUP_NAME = "tracker.wiring.group.name";
	private static final String CONNECTION_RETRY_DELAY = "connection.retry.seconds";
	private static final String PRODUCT_OUTPUT_RATE = "product.output.rate";
	private static final String LAT_ERROR = "latitude.error";
	private static final String LON_ERROR = "longitude.error";
	private static final String ALT_ERROR = "altitude.error";
	private static final String CONNECTION_URI = "connection.uri";
	private static final String PRODUCER_SCOPE_VALUE = "gps.position";
	private static final String PRODUCT_CONSOLIDATE_MESSAGE = "product.output.consolidate";

	private final static String TARGET_SERVER = "socket://localhost:2343";

	// stats
	private static final String CONNECTED_CONSUMERS = "producer.Connected_Consumers";
	private static final String LAST_POSITION = "producer.Last_Position";
	private static final String TOTAL_POSITION_SENT = "producer.Total_Positions_Sent";
	private static final String CONNECTION_URI_STATUS_VAR = "producer.Connection_URI";
	private static final String LAST_POSITION_TIME = "producer.Last_Position_Time";
	private static final String CONNECTED = "producer.Is_Connected";

	private static final String LAST_WEATHER = "producer.Last_Weather";
	private static final String TOTAL_WEATHER_SENT = "producer.Total_Weathers_Sent";
	private static final String LAST_WEATHER_TIME = "producer.Last_Weather_Time";

	private static final String LAST_ORIENTATION = "producer.Last_Orientation";
	private static final String TOTAL_ORIENTATION_SENT = "producer.Total_Orientations_Sent";
	private static final String LAST_ORIENTATION_TIME = "producer.Last_Orientation_Time";

	private static IDeviceListener listener;

	static String PLUGIN_ID = "com.verticon.tracker.irouter.udp.test.system";
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
	private final Logger logger = LoggerFactory.getLogger(UDPSystemTest.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);


	private static UDPServer uDPServer = new UDPServer();
	private static ConfigurationAdmin configAdmin;

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.debug(bundleMarker, "DS injecting the ConfigAdmin");
		UDPSystemTest.configAdmin = value;
	}

	// public void setConsumer(Consumer value) {
	// logger.debug(bundleMarker, "DS injecting the Consumer");
	// UDPSystemTest.uDPServer = (UDPServer) value;
	// }
	//
	public void setListener(IDeviceListener value) {
		logger.debug(bundleMarker, "DS injecting the Fake GPS");
		UDPSystemTest.listener = value;
	}

	/**
	 * 
	 * Called by the test framework to setup the test case.
	 * 
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		logger.debug(bundleMarker,
				"Waiting for declarative services activation startup method to finish");
		startUpGate.await();// wait for startUp to finish
		logger.debug(bundleMarker, "startup and setUp finished.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		uDPServer.receivedPositions.clear();
		super.tearDown();
	}

	public void startup(BundleContext context) {
		UDPSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
		assertNotNull("Fake Device was not setup", listener);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testUDPGateway() throws Exception {
		// Configure the GPS Proxy and the Producer to connect to the Fake GPS
		// server
		Configuration configGpsProxyProducer = configureIrouterGpsProxyProducer();
		int port = 18494;
		uDPServer.port = port;
		ExecutorService exec = Executors.newSingleThreadExecutor();
		exec.submit(uDPServer);
		Configuration configUDPGateway = configureIrouterUdpConsumer(port);
		
		// Server has a latch, set it to go off after receiving 15 products
		boolean consumerReceivedProducts = uDPServer.latch.await(30,
				TimeUnit.SECONDS);
		assertTrue(
				"Timeout after 30 seconds. Failed to receive enough products.  Only "
						+ uDPServer.receivedMessages, consumerReceivedProducts);

		assertEquals("Did not receive correct number of Position products.", 5,
				uDPServer.receivedPositions.size());
		assertEquals("Did not receive correct number of Weather products.", 5,
				uDPServer.receivedWeathers.size());
		assertEquals("Did not receive correct number of Orientation products.",
				5, uDPServer.receivedOrientations.size());
		assertEquals(
				"Did not receive correct number of HeadingAndGroundSpeed products.",
				5, uDPServer.receivedHeadingAndGroundSpeeds.size());

		// Get the configured GPS service
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(), "(" + SERVICE_TAG + "="
						+ GPS_SERVICE_TAG_VALUE + ")");

		assertNotNull("No Monitorable service found", refs);
		assertTrue("No Monitorable service found", refs.length == 1);
		ServiceReference monRef = refs[0];
		String pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		StatusVariable sv = monitorable.getStatusVariable(CONNECTED);
		assertTrue("GPS Device is Not connected to " + TARGET_SERVER,
				sv.getBoolean());

		testConnectedConsumers(monitorable, 1);

		// Let the proxy catch up
		TimeUnit.SECONDS.sleep(1);


		testProductsSent(monitorable, TOTAL_POSITION_SENT, 5);
		testProductsSent(monitorable, TOTAL_WEATHER_SENT, 5);
		testProductsSent(monitorable, TOTAL_ORIENTATION_SENT, 5);

		sv = monitorable.getStatusVariable(CONNECTION_URI_STATUS_VAR);
		assertNotNull(sv);
		String value = sv.getString();
		logger.info(bundleMarker, "{}: connection uri is {}", this, value);
		// System.out.println("connection uri is: " + value);
		assertEquals("socket://localhost:2343", value);

		sv = monitorable.getStatusVariable(LAST_POSITION);
		assertNotNull(sv);
		value = sv.getString();
		logger.info(bundleMarker, "{}: last position is {}", this, value);
		// System.out.println("last position is: " + value);
		// assertEquals("lat=43.47619 degrees, lon=-5211.15414 degrees, alt=344.1 meters",
		// value);

		sv = monitorable.getStatusVariable(LAST_POSITION_TIME);
		assertNotNull(sv);
		value = sv.getString();
		// logger.info(bundleMarker, "{}: last position time is {}", this,
		// value);
		// System.out.println("last position time is: " + value);
		assertTrue("Time is empty ", value != null && value.trim().length() > 0);

		// Orientation
		sv = monitorable.getStatusVariable(LAST_ORIENTATION);
		assertNotNull(sv);
		value = sv.getString();
		// logger.info(bundleMarker, "{}: last orientation is {}", this, value);
		// System.out.println("last orientation is: " + value);
		// assertEquals("lat=43.47619 degrees, lon=-5211.15414 degrees, alt=344.1 meters",
		// value);

		sv = monitorable.getStatusVariable(LAST_ORIENTATION_TIME);
		assertNotNull(sv);
		value = sv.getString();
		// logger.info(bundleMarker, "{}: last position time is {}", this,
		// value);
		// System.out.println("last orientation time is: " + value);
		assertTrue("Time is empty ", value != null && value.trim().length() > 0);

		// Weather
		sv = monitorable.getStatusVariable(LAST_WEATHER);
		assertNotNull(sv);
		value = sv.getString();
		// logger.info(bundleMarker, "{}: last orientation is {}", this, value);
		// System.out.println("last weather is: " + value);

		sv = monitorable.getStatusVariable(LAST_WEATHER_TIME);
		assertNotNull(sv);
		value = sv.getString();
		// logger.info(bundleMarker, "{}: last position time is {}", this,
		// value);
		// System.out.println("last weather time is: " + value);
		assertTrue("Time is empty ", value != null && value.trim().length() > 0);

		// Get the configured UDP Gateway Service
		refs = context.getServiceReferences(Monitorable.class.getName(), "("
				+ SERVICE_TAG + "=" + UDP_SERVICE_TAG_VALUE + ")");

		assertNotNull("No Monitorable service found", refs);
		assertTrue("No Monitorable service found", refs.length == 1);
		monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		monitorable = (Monitorable) context.getService(monRef);

		sv = monitorable.getStatusVariable("consumer.Connected_Wires");
		assertNotNull(sv);
		assertEquals("Wrong number of wires", 1, sv.getInteger());
		sv = monitorable.getStatusVariable("consumer.Last_Message");
		assertNotNull(sv);
		sv = monitorable.getStatusVariable("consumer.Last_Time_Sent");
		assertNotNull(sv);
		sv = monitorable.getStatusVariable("consumer.Connection_URI");
		assertNotNull(sv);
		sv = monitorable.getStatusVariable("consumer.Total_Messages_Sent");
		assertNotNull(sv);

		TimeUnit.MILLISECONDS.sleep(2000);

		// terminate
		configGpsProxyProducer.delete();
		configUDPGateway.delete();
		exec.shutdownNow();
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Configuration configureIrouterGpsProxyProducer() throws IOException {
		String pid = "com.verticon.tracker.irouter.gps";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		
		Dictionary props = new Properties();

		props.put(TRACKER_WIRE_GROUP_NAME, "test");
		props.put(LAT_ERROR, 10d);
		props.put(LON_ERROR, 100d);
		props.put(ALT_ERROR, 50d);
		props.put(CONNECTION_RETRY_DELAY, 7l);
		props.put(PRODUCT_OUTPUT_RATE, 1l);

		props.put(PRODUCT_CONSOLIDATE_MESSAGE, Boolean.FALSE);
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { PRODUCER_SCOPE_VALUE });
		props.put(CONNECTION_URI, TARGET_SERVER);

		// Add a tag to find the service
		props.put(SERVICE_TAG, GPS_SERVICE_TAG_VALUE);

		config.update(props);
		logger.warn(" updated pid " + config.getPid() + " factoryPid "
				+ config.getFactoryPid());
		return config;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Configuration configureIrouterUdpConsumer(int port)
			throws IOException {
		String pid = "com.verticon.tracker.irouter.udp";
		Configuration config = configAdmin.createFactoryConfiguration(pid);
		Dictionary props = new Properties();
		props.put(TRACKER_WIRE_GROUP_NAME, "test");
		props.put("udp.message.prefix",
				"cik=fff51d1a260b4b258fefffd9a9313c433e419fff");
		props.put("udp.message.delimiter", "&");
		props.put(CONNECTION_URI, "localhost:" + port);


		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { PRODUCER_SCOPE_VALUE });
		

		// Add a tag to find the service
		props.put(SERVICE_TAG, UDP_SERVICE_TAG_VALUE);


		config.update(props);
		logger.warn(" updated pid " + config.getPid() + " factoryPid "
				+ config.getFactoryPid());

		return config;
	}

	private void testConnectedConsumers(Monitorable monitorable, int consumers) {
		// Test for number of consumers connected
		StatusVariable sv = monitorable.getStatusVariable(CONNECTED_CONSUMERS);
		assertEquals("Should be one connected mockconsumer", consumers,
				sv.getInteger());

	}

	private void testProductsSent(Monitorable monitorable, String var,
			int expectedProducts) {
		// Test for number of consumers connected
		StatusVariable sv = monitorable.getStatusVariable(var);
		assertTrue(
				"Wrong number of positions sent",
				expectedProducts == sv.getInteger()
						|| expectedProducts < sv.getInteger());

	}
}
