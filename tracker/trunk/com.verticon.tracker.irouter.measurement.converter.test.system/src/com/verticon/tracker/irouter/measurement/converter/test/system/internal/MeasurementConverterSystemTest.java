package com.verticon.tracker.irouter.measurement.converter.test.system.internal;

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
 * MeasurementConverter is a WireAdmin Arithmetic Measurement converter.
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
public class MeasurementConverterSystemTest extends TestCase {
	private static final int WAIT_TIME_MILI = 100;
	private static final String PRODUCER_TOTAL_MEASUREMENTS_SENT = "producer.Total_Measurements_Sent";
	private static final String TRANSFORMED_MEASUREMENT = "transformed.measurement";
	private static final String INPUT_MEASUREMENT = "input.measurement";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.converter.test.system";
	private static final String OPERAND = "operation.value";
	private static final String OPERATION = "operation.type";
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
			.getLogger(MeasurementConverterSystemTest.class);

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
		MeasurementConverterSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementConverterSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementConverterSystemTest.mockConsumer = (MockConsumer) value;
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
		MeasurementConverterSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testAdd() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.measurement.converter";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { INPUT_MEASUREMENT });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { TRANSFORMED_MEASUREMENT });

		// Operation
		props.put(OPERATION, "add");

		// Operand
		props.put(OPERAND, 2.0d);

		// Add a tag to find the service
		props.put("measurement.converter.test", "instance");

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(),
				"(measurement.converter.test=instance)");
		assertNotNull("No MeasurementConverter Monitorable service found", refs);
		assertTrue("No MeasurementConverter Monitorable service found",
				refs.length == 1);
		ServiceReference monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send a measurement
		Measurement m = new Measurement(100, Unit.kg);
		Envelope value = new BasicEnvelope(m, "xx", INPUT_MEASUREMENT);
		mockProducer.send(value);
		TimeUnit.SECONDS.sleep(1);
		StatusVariable sv = monitorable
				.getStatusVariable(PRODUCER_TOTAL_MEASUREMENTS_SENT);
		assertEquals("Should be one measurement sent", 1, sv.getInteger());
		assertEquals("Should be one consumed measurement", 1,
				mockConsumer.envelopes.size());
		assertNotNull(mockConsumer.envelopes.get(0));
		assertTrue(mockConsumer.envelopes.get(0).getValue() instanceof Measurement);

		m = (Measurement) mockConsumer.envelopes.get(0).getValue();
		assertEquals(Unit.kg, m.getUnit());
		assertEquals(new Double(102), m.getValue());

		// Subtract
		// Don't create a new instance, use the old instance instead,
		// but change the operation
		// Clear the consumer first
		mockConsumer.envelopes.clear();
		m = initializeAndSendMessage(pid, "subtract");
		assertEquals(Unit.kg, m.getUnit());
		assertEquals(new Double(98), m.getValue());

		// Multiply
		// Don't create a new instance, use the old instance instead,
		// but change the operation
		// Clear the consumer first
		mockConsumer.envelopes.clear();
		m = initializeAndSendMessage(pid, "multiply");
		assertEquals(Unit.kg, m.getUnit());
		assertEquals(new Double(200), m.getValue());

		// Divide
		// Don't create a new instance, use the old instance instead,
		// but change the operation
		// Clear the consumer first
		mockConsumer.envelopes.clear();
		m = initializeAndSendMessage(pid, "divide");
		assertEquals(Unit.kg, m.getUnit());
		assertEquals(new Double(50), m.getValue());
	}

	@SuppressWarnings("unchecked")
	private Measurement initializeAndSendMessage(String pid, String operation)
			throws IOException, InterruptedException, InvalidSyntaxException {
		Configuration config;

		ServiceReference[] refs;
		ServiceReference monRef;
		Monitorable monitorable;
		Measurement m;
		Envelope value;
		StatusVariable sv;
		config = configAdmin.getConfiguration(pid);
		assertNotNull(config);
		Dictionary<String, Object> props = config.getProperties();// new
																	// Properties();

		// Operation
		props.put(OPERATION, operation);

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		refs = context.getServiceReferences(Monitorable.class.getName(),
				"(measurement.converter.test=instance)");
		assertNotNull("No MeasurementConverter Monitorable service found", refs);
		assertTrue("No MeasurementConverter Monitorable service found",
				refs.length == 1);
		monRef = refs[0];
		monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send a measurement
		m = new Measurement(100, Unit.kg);
		value = new BasicEnvelope(m, "xx", INPUT_MEASUREMENT);
		mockProducer.send(value);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);
		sv = monitorable.getStatusVariable(PRODUCER_TOTAL_MEASUREMENTS_SENT);
		assertEquals("Should be one measurement sent", 1, sv.getInteger());
		// Consumer will be sent two messages on from the add instance and one
		// from the subtract
		assertEquals("Should be one consumed measurement", 1,
				mockConsumer.envelopes.size());
		assertNotNull(mockConsumer.envelopes.get(0));
		assertTrue(mockConsumer.envelopes.get(0).getValue() instanceof Measurement);

		m = (Measurement) mockConsumer.envelopes.get(0).getValue();
		return m;
	}

	private String testInitialization(Monitorable monitorable) {
		// Test for number of producers connected
		String id = "consumer.Connected_Producers";
		StatusVariable sv = monitorable.getStatusVariable(id);
		assertEquals("Should be one connected mockproducer", 1, sv.getInteger());

		// Test for number of consumers connected
		id = "producer.Connected_Consumers";
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should only be one connected mockconsumer", 1,
				sv.getInteger());

		// Just starting so there should be no measurements sent
		id = PRODUCER_TOTAL_MEASUREMENTS_SENT;
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());
		//Note: instance will be deactivated when new properties are sent, which will 
		//create a totally new object with reset statusvars
		return id;
	}
}
