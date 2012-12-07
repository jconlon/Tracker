package com.verticon.tracker.irouter.trutest.alarm.adapter.test.system.internal;

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
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.WireConstants;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.TrackerConstants;

/**
 * AlarmAdapter is a State Consumer and a TruTest Command producer.
 * 
 * This system test is a JUnit Plugin test that uses a Mock Producer to generate
 * states, and a Mock Consumer to receive adapted commands.
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
public class AlarmAdapterSystemTest extends TestCase {
	private static final int WAIT_TIME_MILI = 200;

	private static final String ADAPTED_COMMANDS = "adapted.commands";
	private static final String INPUT_STATE = "input.state";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.alarm.adapter.test.system";

	private static final String ALARM_DURATION = "alarm.duration";
	private static final String ALARM_INTERVAL = "alarm.interval";
	private static final String ALARM_STATE_NAME = "alarm.state.name";
	private static final String ALARM_STATE_VALUE = "alarm.state.value";

	// private static final String TIME_OF_LAST_ALARM =
	// "producer.Last_Alarm_Sent";
	private static final String TOTAL_ALARMS_SENT = "producer.Total_Alarms_Sent";

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
			.getLogger(AlarmAdapterSystemTest.class);

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
		AlarmAdapterSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		AlarmAdapterSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		AlarmAdapterSystemTest.mockConsumer = (MockConsumer) value;
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
		AlarmAdapterSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testStateAdaption() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.trutest.alarm.adapter";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { INPUT_STATE });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { ADAPTED_COMMANDS });

		props.put(ALARM_STATE_VALUE, 1);
		props.put(ALARM_INTERVAL, 1);
		props.put(ALARM_DURATION, 100);
		props.put(ALARM_STATE_NAME, "my.alarm.state");

		// Add a tag to find the service
		props.put("trutest.alarm.adapter.test", "instance");

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(),
				"(trutest.alarm.adapter.test=instance)");
		assertNotNull("No AlarmAdapter Monitorable service found", refs);
		assertTrue("No MeasureAdapter Monitorable service found",
				refs.length == 1);
		ServiceReference monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send a state to turn on the alarm
		State state = new State(1, "my.alarm.state", System.currentTimeMillis());
		Envelope envelope = new BasicEnvelope(state, "xx", INPUT_STATE);
		mockProducer.send(envelope);

		// Consumer has a latch, set it to go off after receiving 2 commands
		mockConsumer.setUpLatch(2);
		// wait at it for 3 seconds
		boolean receivedCommands = mockConsumer.receivedCommands.await(3,
				TimeUnit.SECONDS);
		assertTrue("Alarm failed to fire after 3 seconds", receivedCommands);
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_ALARMS_SENT);
		assertEquals("Should be one alarm sent", 1, sv.getInteger());
		assertEquals("Should be two consumed alarm commands", 2,
				mockConsumer.commands.size());
		assertNotNull(mockConsumer.commands.get(0));

		assertEquals("Failed 1st alarm", "{SABP100}\r\n",
				mockConsumer.commands.get(0));

		// Turn off the alarm
		state = new State(1, "not.my.alarm.state", System.currentTimeMillis());
		envelope = new BasicEnvelope(state, "xx", INPUT_STATE);
		mockProducer.send(envelope);
		// Consumer has a latch, set it to go off after receiving one single
		// command
		mockConsumer.setUpLatch(1);
		// wait at it for 2 seconds
		receivedCommands = mockConsumer.receivedCommands.await(3,
				TimeUnit.SECONDS);
		assertFalse(
				"Alarm kept firing, failed to stop it with a unknown state",
				receivedCommands);

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
		id = TOTAL_ALARMS_SENT;
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no alarms sent", 0, sv.getInteger());

	}
}
