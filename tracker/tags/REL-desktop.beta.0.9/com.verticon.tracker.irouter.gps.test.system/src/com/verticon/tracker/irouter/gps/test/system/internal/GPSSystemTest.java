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
package com.verticon.tracker.irouter.gps.test.system.internal;

import java.util.Dictionary;
import java.util.Properties;
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

import com.verticon.tracker.irouter.dev.IDeviceListener;


/**
 * 
 * GPSProducer manages connections to a gps device with a GPSProxy 
 * to produce Position objects.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>ConnectorService</li>
 * <li>MonitorListener</li>
 * </ol>
 *  
 * Depends on a GPS device running on the TARGET_SERVER.  
 * 
 * Test currently using the fake gps simulator 
 * (by adding the plugin com.verticon.tracker.irouter.gps.dev.fake to the launcher configuration.)
 * 
 * Alternatively it can be:
 * <ol>
 * <li>a real gps</li>
 * <li> the GPS web simulator: com.verticon.tracker.irouter.gps.dev.sim running
 * within the simulator product</li>
 * </ol>
 * 
 * This system test is a JUnit Plugin test that uses a real or a Mock device connect to
 * and a Mock Consumer to receive Position products.
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
public class GPSSystemTest extends TestCase {
	private static final String SERVICE_TAG_VALUE = "instance";
	private static final String SERVICE_TAG = "gps.test";
	
	
	// config
	private static final String TRACKER_WIRE_GROUP_NAME = "tracker.wiring.group.name";
	private static final String CONNECTION_RETRY_DELAY = "connection.retry.seconds";
	private static final String PRODUCT_OUTPUT_RATE = "product.output.rate";
	private static final String LAT_ERROR = "latitude.error";
	private static final String LON_ERROR = "longitude.error";
	private static final String ALT_ERROR = "altitude.error";
	private static final String CONNECTION_URI = "connection.uri";
	private static final String PRODUCER_SCOPE_VALUE = "gps.position";
	

//	private final static String TARGET_SERVER = 
//		"btspp://001C881333D6:1;authenticate=false;encrypt=false;master=false";
	private final static String TARGET_SERVER = "socket://localhost:2343";
	
	
	// stats
	private static final String CONNECTED_CONSUMERS = "producer.Connected_Consumers";
	private static final String LAST_POSITION = "producer.Last_Position";
	private static final String TOTAL_POSITION_SENT = "producer.Total_Positions_Sent";
	private static final String CONNECTION_URI_STATUS_VAR = "producer.Connection_URI";
	private static final String LAST_POSITION_TIME = "producer.Last_Position_Time";
	private static final String CONNECTED = "producer.Is_Connected";
	
	
	
	
	private static IDeviceListener listener;
	
	static String PLUGIN_ID = "com.verticon.tracker.irouter.gps.test.system";
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
			.getLogger(GPSSystemTest.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	
	private static MockConsumer mockConsumer;
	private static ConfigurationAdmin configAdmin;

	
	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		GPSSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the Consumer");
		GPSSystemTest.mockConsumer = (MockConsumer) value;
	}
	
	public void setListener(IDeviceListener value) {
		logger.info(bundleMarker,"DS injecting the Fake GPS");
		GPSSystemTest.listener = value;
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
		mockConsumer.receivedObjects.clear();
		super.tearDown();
	}

	public void startup(BundleContext context) {
		GPSSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
		assertNotNull("Fake Device was not setup",listener);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testGPSProxy() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.gps";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();

		props.put(TRACKER_WIRE_GROUP_NAME, "test");
		props.put(LAT_ERROR, 10d);
		props.put(LON_ERROR, 100d);
		props.put(ALT_ERROR, 50d);
		props.put(CONNECTION_RETRY_DELAY, 7l);
		props.put(PRODUCT_OUTPUT_RATE, 1l);
		
		
		
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { PRODUCER_SCOPE_VALUE });
		props.put(CONNECTION_URI, TARGET_SERVER);
		

		// Add a tag to find the service
		props.put(SERVICE_TAG, SERVICE_TAG_VALUE);

		config.update(props);
		boolean consumerConnected = mockConsumer.latch.await(5, TimeUnit.SECONDS);
		assertTrue("MockConsumer was not connected to the Producer under test", consumerConnected);
		
//		boolean block = mockConsumer.latch.await(30, TimeUnit.SECONDS);//BLOCK for troubleshooting
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
		
		testInitialization(monitorable,1, 0);

		// Consumer has a latch, set it to go off after receiving 1 object
		mockConsumer.setUpLatch(5);
		boolean consumerReceivedMessages = mockConsumer.latch.await(30, TimeUnit.SECONDS);
		StatusVariable sv = monitorable.getStatusVariable(CONNECTED);
		assertTrue("GPS Device is Not connected to "+TARGET_SERVER, sv.getBoolean());
		assertTrue("Only received "+mockConsumer.receivedObjects.size(), consumerReceivedMessages);
		testInitialization(monitorable, 1, 5);
		
		
		sv = monitorable.getStatusVariable(LAST_POSITION);
		assertNotNull(sv);
		logger.info(bundleMarker, "{}: last position is {}", this, sv.getString());
		
		sv = monitorable.getStatusVariable(CONNECTION_URI_STATUS_VAR);
		assertNotNull(sv);
		logger.info(bundleMarker, "{}: connection uri is {}", this, sv.getString());
		
		sv = monitorable.getStatusVariable(LAST_POSITION_TIME);
		assertNotNull(sv);
		logger.info(bundleMarker, "{}: last position time is {}", this, sv.getString());
		
		//terminate
		config.delete();
		TimeUnit.MILLISECONDS.sleep(4);
	}


	private void testInitialization(Monitorable monitorable, int consumers, int expectedPositions) {
		// Test for number of consumers connected
		StatusVariable sv = monitorable.getStatusVariable(CONNECTED_CONSUMERS);
		assertEquals("Should be one connected mockconsumer", consumers, sv.getInteger());
		sv = monitorable.getStatusVariable(TOTAL_POSITION_SENT);
		assertEquals("Wrong number of positions sent", expectedPositions, sv.getInteger());
		
	}
}
