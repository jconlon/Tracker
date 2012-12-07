package com.verticon.tracker.irouter.flow.terminator.test.system.internal;

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
 * FlowTerminator is a Information flow control service, that terminates flow of
 * information based on state received on the control scope..
 * 
 * This system test is a JUnit Plugin test that uses a Mock Producer to generate
 * states, and a Mock Consumer to receive adapted receivedObjects.
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
public class FlowTerminatorSystemTest extends TestCase {
	private static final String SERVICE_TAG_VALUE = "instance";

	private static final String SERVICE_TAG = "trutest.alarm.adapter.test";

	private static final String MY_TERMINATOR_STATE_NAME = "my.alarm.state";

	private static final int WAIT_TIME_MILI = 200;

	private static final String OUTPUT_INFORMATION = "flow.controlled.information";

	private static final String INPUT_CONTROL_STATE = "input.control";
	private static final String INPUT_INFORMATION = "input.information";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.alarm.adapter.test.system";

	private static final String TERMINATOR_SCOPE_MAP = "terminator.scope.map";
	private static final String TERMINATOR_STATE_NAME = "terminator.state.name";
	private static final String TERMINATOR_STATE_VALUE = "terminator.state.value";

	// private static final String TIME_OF_LAST_TERMINATION =
	// "producer.Last_Termination";
	private static final String TOTAL_TERMINATIONS = "producer.Total_Terminations";

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
			.getLogger(FlowTerminatorSystemTest.class);

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
		FlowTerminatorSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		FlowTerminatorSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		FlowTerminatorSystemTest.mockConsumer = (MockConsumer) value;
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
		FlowTerminatorSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testStateAdaption() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.flow.terminator";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[] {
				INPUT_CONTROL_STATE, INPUT_INFORMATION });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { OUTPUT_INFORMATION });

		props.put(TERMINATOR_STATE_VALUE, 1);
		props.put(TERMINATOR_SCOPE_MAP, 
				new String[] {INPUT_INFORMATION+':'+OUTPUT_INFORMATION});
		props.put(TERMINATOR_STATE_NAME, MY_TERMINATOR_STATE_NAME);

		// Add a tag to find the service
		props.put(SERVICE_TAG, SERVICE_TAG_VALUE);

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(), "(" + SERVICE_TAG + "="
						+ SERVICE_TAG_VALUE + ")");
		assertNotNull("No FlowTerminator Monitorable service found", refs);
		assertTrue("No FlowTerminator Monitorable service found",
				refs.length == 1);
		ServiceReference monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send a state to terminate the flow
		State state = new State(1, MY_TERMINATOR_STATE_NAME,
				System.currentTimeMillis());
		Envelope envelope = new BasicEnvelope(state, "xx", INPUT_CONTROL_STATE);
		mockProducer.send(envelope);

		// Consumer has a latch, set it to go off after receiving 1 object
		mockConsumer.setUpLatch(1);
		mockProducer.send("Hi there can you hear me?");
		// wait at it for 2 seconds
		boolean consumerReceivedObjects = mockConsumer.latch.await(1,
				TimeUnit.SECONDS);
		assertFalse("Consumer should not have received any objects",
				consumerReceivedObjects);

		StatusVariable sv = monitorable.getStatusVariable(TOTAL_TERMINATIONS);
		assertEquals("Should be one termination", 1, sv.getInteger());
		assertEquals("Should be zero consumed receivedObjects", 0,
				mockConsumer.receivedObjects.size());

		// Clear the termination
		state = new State(1, "not.my.alarm.state", System.currentTimeMillis());
		envelope = new BasicEnvelope(state, "xx", INPUT_CONTROL_STATE);
		mockProducer.send(envelope);
		// Consumer has a latch, set it to go off after receiving one single
		// command
		mockConsumer.setUpLatch(1);
		mockProducer.send("Hi can you hear me now?");
		// wait at it for 2 seconds
		consumerReceivedObjects = mockConsumer.latch.await(2, TimeUnit.SECONDS);
		assertFalse("Should not forward non Envelope objects to consumer",
				consumerReceivedObjects);
		
		
		mockProducer.send(new BasicEnvelope("Hi can you hear me now?","id",INPUT_INFORMATION ));
		// wait at it for 2 seconds
		consumerReceivedObjects = mockConsumer.latch.await(2, TimeUnit.SECONDS);
		assertTrue("Failed to forward objects to consumer",
				consumerReceivedObjects);

		sv = monitorable.getStatusVariable(TOTAL_TERMINATIONS);
		assertEquals("Should still be one termination", 1, sv.getInteger());
		assertEquals("Should be one consumed received Objects", 1,
				mockConsumer.receivedObjects.size());
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
		id = TOTAL_TERMINATIONS;
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no alarms sent", 0, sv.getInteger());

	}
}
