package com.verticon.tracker.irouter.measurement.trigger.test.system.internal;

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
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.TrackerConstants;

/**
 * MeasurementTrigger is a generic business logic Component Factory that creates
 * services to inspect measurements for conditions and produce a state if
 * specific conditions are met. 
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
public class MeasurementTriggerSystemTest extends TestCase {
	private static final String SERVICE_TAG_VALUE = "instance";
	private static final String SERVICE_TAG = "measurement.trigger.test";
	private static final int WAIT_TIME_MILI = 200;
	private static final String OUTPUT_INFORMATION = "flow.control";
	private static final String INPUT_INFORMATION = "input.information";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.measurement.trigger.test.system";
//	private static final String TIME_OF_LAST_TRIGGER = "producer.Last_Trigger";
	private static final String TOTAL_TRIGGER = "producer.Total_Triggers";

	private static final String LOW_VALUE = "value.low";
	private static final String HIGH_VALUE = "value.high";
	private static final String OPERATION_TYPE = "operation.type";

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
			.getLogger(MeasurementTriggerSystemTest.class);

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
		MeasurementTriggerSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementTriggerSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementTriggerSystemTest.mockConsumer = (MockConsumer) value;
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
		MeasurementTriggerSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testMeasurementTrigger() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.measurement.trigger";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { INPUT_INFORMATION });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { OUTPUT_INFORMATION });

		props.put(LOW_VALUE, 10d);
		props.put(HIGH_VALUE, 100d);
		props.put(OPERATION_TYPE, "rising");

		// Add a tag to find the service
		props.put(SERVICE_TAG, SERVICE_TAG_VALUE);

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

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

		testInitialization(monitorable);

		// Consumer has a latch, set it to go off after receiving 1 object
		mockConsumer.setUpLatch(1);
		// Test rising with low 10 and high 100
		// just sending a 100 measurements which will not set the trigger
		for (int i = 0; i < 100; i++) {
			sendMeasurement(100d + i);
		}
		evaluatedNothingWasFired(monitorable);

		// Test rising with low 10 and high 100
		// just sending a 94 measurements which will set the low threashold but
		// still not
		// set the trigger
		for (int i = 0; i < 94; i++) {
			sendMeasurement(100d - i);
		}
		evaluatedNothingWasFired(monitorable);

		// Test rising with low 10 and high 100
		// sending a 100 measurements will now set the trigger
		for (int i = 0; i < 100; i++) {
			sendMeasurement(40d + i);
		}

		// wait at it for 1 seconds
		boolean consumerReceivedObjects = mockConsumer.latch.await(1,
				TimeUnit.SECONDS);
		assertTrue("Consumer should have received one states",
				consumerReceivedObjects);
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_TRIGGER);
		assertEquals("Should be 1 trigger", 1, sv.getInteger());
		assertEquals("Should be 1 consumed state", 1,
				mockConsumer.receivedObjects.size());

		// Set up a falling State machine
		monitorable = initialize(pid, 50, 100, "falling");

		// Consumer has a latch, set it to go off after receiving 1 object
		mockConsumer.setUpLatch(1);
		mockConsumer.receivedObjects.clear();
		// Test falling with low 50 and high 100
		// just sending a 100 measurements which will not set the trigger
		for (int i = 0; i < 100; i++) {
			sendMeasurement(-2d + i);
		}
		evaluatedNothingWasFired(monitorable);

		// Test falling with low 50 and high 100
		// just sending a 100 measurements which will set the high threshold but
		// still not
		// set the trigger
		for (int i = 0; i < 100; i++) {
			sendMeasurement(190d - i);
		}
		evaluatedNothingWasFired(monitorable);

		// Test falling with low 50 and high 100
		// sending a 50 measurements will now set the trigger
		for (int i = 0; i < 50; i++) {
			sendMeasurement(90d - i);
		}

		// wait at it for 1 seconds
		consumerReceivedObjects = mockConsumer.latch.await(1, TimeUnit.SECONDS);
		assertTrue("Consumer should have received one states",
				consumerReceivedObjects);
		sv = monitorable.getStatusVariable(TOTAL_TRIGGER);
		assertEquals("Should be 1 trigger", 1, sv.getInteger());
		assertEquals("Should be 1 consumed state", 1,
				mockConsumer.receivedObjects.size());
	}

	private void evaluatedNothingWasFired(Monitorable monitorable)
			throws InterruptedException {
		// wait at it for 1 seconds
		boolean consumerReceivedObjects = mockConsumer.latch.await(1,
				TimeUnit.SECONDS);
		assertFalse("Consumer should not have received any states",
				consumerReceivedObjects);
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_TRIGGER);
		assertEquals("Should be zero triggers", 0, sv.getInteger());
		assertEquals("Should be zero consumed states", 0,
				mockConsumer.receivedObjects.size());
	}

	private void sendMeasurement(double d) {
		Measurement m = new Measurement(d, Unit.kg);
		Envelope envelope = new BasicEnvelope(m, "xx", INPUT_INFORMATION);
		mockProducer.send(envelope);
	}

	@SuppressWarnings("unchecked")
	private Monitorable initialize(String pid, double lowValue,
			double highValue, String type) throws InterruptedException,
			IOException, InvalidSyntaxException {
		Configuration config;

		ServiceReference[] refs;
		ServiceReference monRef;
		Monitorable monitorable;
		config = configAdmin.getConfiguration(pid);
		assertNotNull(config);
		Dictionary<String, Object> props = config.getProperties();

		props.put(LOW_VALUE, lowValue);
		props.put(HIGH_VALUE, highValue);
		props.put(OPERATION_TYPE, type);

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		refs = context.getServiceReferences(Monitorable.class.getName(), "("
				+ SERVICE_TAG + "=" + SERVICE_TAG_VALUE + ")");
		assertNotNull("No Monitorable service found", refs);
		assertTrue("No Monitorable service found", refs.length == 1);
		monRef = refs[0];
		monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);
		return monitorable;
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
		id = TOTAL_TRIGGER;
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no alarms sent", 0, sv.getInteger());

	}
}
