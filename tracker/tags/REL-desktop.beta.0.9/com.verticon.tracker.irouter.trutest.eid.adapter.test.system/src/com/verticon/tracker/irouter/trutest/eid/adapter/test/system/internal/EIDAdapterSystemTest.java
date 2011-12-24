package com.verticon.tracker.irouter.trutest.eid.adapter.test.system.internal;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.TrackerConstants;

/**
 * MeasurementAdapter is a Measurement Consumer and a TruTest Command producer.
 * 
 * This system test is a JUnit Plugin test that uses a Mock Producer to generate
 * measurements, and a Mock Consumer to receive adapted commands.
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
public class EIDAdapterSystemTest extends TestCase {
	private static final int WAIT_TIME_MILI = 200;
	private static final String TOTAL_EIDS_SENT = "producer.Total_EIDs_Sent";

	private static final String ADAPTED_COMMANDS = "adapted.commands";
	private static final String INPUT_ANIMAL_ID = "input.id";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.eid.adapter.test.system";

	private static final String DESTINATION_FIELD = "destination.field";
	private static final String DESTINATIN_PORT = "destination.port";
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
			.getLogger(EIDAdapterSystemTest.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static MockProducer mockProducer;
	private static MockConsumer mockConsumer;
	private static ConfigurationAdmin configAdmin;

	public void setProducer(Producer value) {
		logger.info(bundleMarker, "DS injecting the Mock Producer");
		EIDAdapterSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		EIDAdapterSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		EIDAdapterSystemTest.mockConsumer = (MockConsumer) value;
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
		mockConsumer.commands.clear();
		super.tearDown();
	}

	public void startup(BundleContext context) {
		EIDAdapterSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testEIDAdaption() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.trutest.eid.adapter";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { INPUT_ANIMAL_ID });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { ADAPTED_COMMANDS });

		props.put(DESTINATIN_PORT, 1);
		props.put(DESTINATION_FIELD, 8);

		// Add a tag to find the service
		props.put("trutest.eid.adapter.test", "instance");

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(),
				"(trutest.eid.adapter.test=instance)");
		assertNotNull("No Monitorable service found", refs);
		assertTrue("No Monitorable service found", refs.length == 1);
		ServiceReference monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send a id
		Long id = new Long(123456789012345l);
		Envelope value = new BasicEnvelope(id, "xx", INPUT_ANIMAL_ID);
		mockConsumer.setUpLatch(1);
		mockProducer.send(value);
		boolean receivedCommands = mockConsumer.latch
				.await(1, TimeUnit.SECONDS);
		assertTrue(receivedCommands);
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_EIDS_SENT);
		assertEquals("Should be one eid sent", 1, sv.getInteger());
		assertEquals("Should be one consumed eid", 1,
				mockConsumer.commands.size());
		assertNotNull(mockConsumer.commands.get(0));

		assertEquals("Failed 1st id",
				"{SXD18}\r\n{SXC115}\r\n123456789012345\r\n",
				mockConsumer.commands.get(0));

		// 2
		mockConsumer.commands.clear();
		initializeAndSendEID(pid, 2,// port,
				8,// field,
				234567890123456l// valueToSend
		);
		assertEquals("Failed 2nd id",
				"{SXD28}\r\n{SXC215}\r\n234567890123456\r\n",
				mockConsumer.commands.get(0));

	}

	@SuppressWarnings("unchecked")
	private String initializeAndSendEID(String pid, int port, int field,
			long valueToSend) throws IOException, InterruptedException,
			InvalidSyntaxException {
		Configuration config;

		ServiceReference[] refs;
		ServiceReference monRef;
		Monitorable monitorable;

		StatusVariable sv;
		config = configAdmin.getConfiguration(pid);
		assertNotNull(config);
		Dictionary<String, Object> props = config.getProperties();

		props.put(DESTINATIN_PORT, port);
		props.put(DESTINATION_FIELD, field);

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		refs = context.getServiceReferences(Monitorable.class.getName(),
				"(trutest.eid.adapter.test=instance)");
		assertNotNull("No Monitorable service found", refs);
		assertTrue("No Monitorable service found", refs.length == 1);
		monRef = refs[0];
		monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		mockConsumer.setUpLatch(1);
		mockProducer.send(valueToSend);
		boolean receivedCommands = mockConsumer.latch
				.await(2, TimeUnit.SECONDS);
		assertTrue("Failed to receive eid", receivedCommands);
		sv = monitorable.getStatusVariable(TOTAL_EIDS_SENT);
		assertEquals("Should be one eid sent", 1, sv.getInteger());
		// Consumer will be sent two messages on from the add instance and one
		// from the subtract
		assertEquals("Should be one consumed eid", 1,
				mockConsumer.commands.size());
		assertNotNull(mockConsumer.commands.get(0));
		return mockConsumer.commands.get(0);
	}

	private void testInitialization(Monitorable monitorable) {
		// Test for number of producers connected
		String id = "consumer.Connected_Producers";
		StatusVariable sv = monitorable.getStatusVariable(id);
		assertEquals("Should be one connected mockproducer", 1, sv.getInteger());

		// Test for number of consumers connected
		id = "producer.Connected_Consumers";
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should one connected mockconsumer", 1, sv.getInteger());

		// Just starting so there should be no measurements sent
		id = TOTAL_EIDS_SENT;
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

	}
}
