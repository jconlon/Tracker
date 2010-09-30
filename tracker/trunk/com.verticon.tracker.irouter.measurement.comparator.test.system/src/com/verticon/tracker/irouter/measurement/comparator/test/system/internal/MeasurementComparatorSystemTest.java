package com.verticon.tracker.irouter.measurement.comparator.test.system.internal;

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
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.TrackerConstants;

/**
 * MeasurementConverter is a WireAdmin Measurement comparator.
 * 
 * This system test is a JUnit Plugin test that uses a Mock Producer to generate
 * measurements, ahd a Mock Consumer to receive transformed measurements.
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the MockProducer. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * The MeasurementConverterConsumer is a DS component that requires a
 * configuration, thus it acts like a org.osgi.service.cm.ManagedServiceFactory
 * even though it is just defined as a DS component.
 * 
 * @author jconlon
 * 
 */
public class MeasurementComparatorSystemTest extends TestCase {
	private static final int WAIT_TIME_MILI = 100;
	private static final String PRODUCER_TOTAL_STATES_SENT = "producer.Total_States_Sent";
	private static final String OUTPUT_STATE = "output.state";
	private static final String INPUT_MEASUREMENT_ONE = "input.measurement.one";
	private static final String INPUT_MEASUREMENT_TWO = "input.measurement.two";

	static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.comparator.test.system";
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
			.getLogger(MeasurementComparatorSystemTest.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static MockProducer mockProducerOne;
	private static MockProducer mockProducerTwo;
	private static MockConsumer mockConsumer;
	private static ConfigurationAdmin configAdmin;

	public void setProducerOne(Producer value) {
		logger.info(bundleMarker, "DS injecting the Mock Producer1");
		MeasurementComparatorSystemTest.mockProducerOne = (MockProducer) value;
	}

	public void setProducerTwo(Producer value) {
		logger.info(bundleMarker, "DS injecting the Mock Producer2");
		MeasurementComparatorSystemTest.mockProducerTwo = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementComparatorSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementComparatorSystemTest.mockConsumer = (MockConsumer) value;
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
		mockConsumer.envelopes.clear();
		super.tearDown();
	}

	public void startup(BundleContext context) {
		MeasurementComparatorSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testCompare() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.measurement.comparator";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");

		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[] {
				INPUT_MEASUREMENT_ONE, INPUT_MEASUREMENT_TWO });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { OUTPUT_STATE });

		// Add a tag to find the service
		props.put("measurement.comparator.test", "instance");

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(),
				"(measurement.comparator.test=instance)");
		assertNotNull("No MeasurementComparator Monitorable service found",
				refs);
		assertTrue("No MeasurementComparator Monitorable service found",
				refs.length == 1);
		ServiceReference monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send first measurement
		Measurement m = new Measurement(100, Unit.kg);
		Envelope value = new BasicEnvelope(m, "xx", INPUT_MEASUREMENT_ONE);
		mockProducerOne.send(value);

		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);
		StatusVariable sv = monitorable
				.getStatusVariable(PRODUCER_TOTAL_STATES_SENT);
		assertEquals("Should be one state sent", 1, sv.getInteger());
		assertEquals("Should be one consumed state", 1,
				mockConsumer.envelopes.size());
		assertNotNull(mockConsumer.envelopes.get(0));
		assertTrue(mockConsumer.envelopes.get(0).getValue() instanceof State);

		State s = (State) mockConsumer.envelopes.get(0).getValue();
		assertNotNull(s);
		assertEquals(
				"The second measurement is still null, and the value should be the MIN Integer value",
				Integer.MIN_VALUE, s.getValue());

		// Send the same measurement out the second scope
		m = new Measurement(100, Unit.kg);
		value = new BasicEnvelope(m, "xx", INPUT_MEASUREMENT_TWO);
		mockProducerTwo.send(value);

		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);
		sv = monitorable.getStatusVariable(PRODUCER_TOTAL_STATES_SENT);
		assertEquals("Should be 2 states sent", 2, sv.getInteger());
		assertEquals("Should be 2 consumed state", 2,
				mockConsumer.envelopes.size());
		assertNotNull(mockConsumer.envelopes.get(1));
		assertTrue(mockConsumer.envelopes.get(1).getValue() instanceof State);

		s = (State) mockConsumer.envelopes.get(1).getValue();
		assertNotNull(s);
		assertEquals(
				"The same measurement was sent to both, and the value should be 0",
				0, s.getValue());

		// Send a lower measurement out the second scope
		m = new Measurement(50, Unit.kg);
		value = new BasicEnvelope(m, "xx", INPUT_MEASUREMENT_TWO);
		mockProducerTwo.send(value);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);
		sv = monitorable.getStatusVariable(PRODUCER_TOTAL_STATES_SENT);
		assertEquals("Should be 3 states sent", 3, sv.getInteger());
		assertEquals("Should be 3 consumed state", 3,
				mockConsumer.envelopes.size());
		assertNotNull(mockConsumer.envelopes.get(2));
		assertTrue(mockConsumer.envelopes.get(2).getValue() instanceof State);

		s = (State) mockConsumer.envelopes.get(2).getValue();
		assertNotNull(s);
		assertEquals(
				"The lower measurement was sent to two, and the value should be 1",
				1, s.getValue());

		// Send a higher measurement out the second scope
		m = new Measurement(500, Unit.kg);
		value = new BasicEnvelope(m, "xx", INPUT_MEASUREMENT_TWO);
		mockProducerTwo.send(value);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);
		sv = monitorable.getStatusVariable(PRODUCER_TOTAL_STATES_SENT);
		assertEquals("Should be 4 states sent", 4, sv.getInteger());
		assertEquals("Should be 4 consumed state", 4,
				mockConsumer.envelopes.size());
		assertNotNull(mockConsumer.envelopes.get(3));
		assertTrue(mockConsumer.envelopes.get(3).getValue() instanceof State);

		s = (State) mockConsumer.envelopes.get(3).getValue();
		assertNotNull(s);
		assertEquals(
				"The same measurement was sent to both, and the value should be 0",
				-1, s.getValue());

	}

	private String testInitialization(Monitorable monitorable) {
		// Test for number of producers connected
		String id = "consumer.Connected_Producers";
		StatusVariable sv = monitorable.getStatusVariable(id);
		assertEquals("Should be one connected mockproducer", 2, sv.getInteger());

		// Test for number of consumers connected
		id = "producer.Connected_Consumers";
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should only be one connected mockconsumer", 1,
				sv.getInteger());

		// Just starting so there should be no measurements sent
		id = PRODUCER_TOTAL_STATES_SENT;
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());
		return id;
	}
}
