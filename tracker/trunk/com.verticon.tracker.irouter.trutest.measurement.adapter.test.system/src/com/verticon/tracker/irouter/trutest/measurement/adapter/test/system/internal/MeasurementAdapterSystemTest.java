package com.verticon.tracker.irouter.trutest.measurement.adapter.test.system.internal;

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
public class MeasurementAdapterSystemTest extends TestCase {
	private static final int WAIT_TIME_MILI = 200;
	private static final String TOTAL_COMMANDS_SENT = "producer.Total_Commands_Sent";

	private static final String ADAPTED_COMMANDS = "adapted.commands";
	private static final String INPUT_MEASUREMENT = "input.measurement";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.measurement.adapter.test.system";

	private static final String MIN_CHARACTERS = "minimuim.characters";
	private static final String PRESENTATION_UNITS = "presentation.units";
	private static final String DECIMAL_PLACES = "decimal.places";

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
			.getLogger(MeasurementAdapterSystemTest.class);

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
		MeasurementAdapterSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementAdapterSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementAdapterSystemTest.mockConsumer = (MockConsumer) value;
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
		MeasurementAdapterSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testMeasurementAdaption() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.trutest.measurement.adapter";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { INPUT_MEASUREMENT });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { ADAPTED_COMMANDS });

		props.put(DESTINATIN_PORT, 1);
		props.put(DESTINATION_FIELD, 8);
		props.put(MIN_CHARACTERS, 6);
		props.put(PRESENTATION_UNITS, "NATIVE");
		props.put(DECIMAL_PLACES, 4);

		// Add a tag to find the service
		props.put("trutest.measurement.adapter.test", "instance");

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(),
				"(trutest.measurement.adapter.test=instance)");
		assertNotNull("No MeasurementAdapter Monitorable service found", refs);
		assertTrue("No MeasurementAdapter Monitorable service found",
				refs.length == 1);
		ServiceReference monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send a measurement
		Measurement m = new Measurement(.0123, Unit.kg);
		Envelope value = new BasicEnvelope(m, "xx", INPUT_MEASUREMENT);
		mockProducer.send(value);
		TimeUnit.SECONDS.sleep(1);
		StatusVariable sv = monitorable.getStatusVariable(TOTAL_COMMANDS_SENT);
		assertEquals("Should be one measurement sent", 1, sv.getInteger());
		assertEquals("Should be one consumed measurement", 1,
				mockConsumer.commands.size());
		assertNotNull(mockConsumer.commands.get(0));

		assertEquals("Failed 1st measurement - 6/4",
				"{SXD18}\r\n{SXC16}\r\n0.0123\r\n",
				mockConsumer.commands.get(0));

		// 2 Pounds conversion
		mockConsumer.commands.clear();
		initializeAndSendMeasurement(pid, 2,// port,
				8,// field,
				5,// minCharacters,
				"POUNDS",// presentationUnits,
				3,// decimalPlaces,
				50,// valueToSend,
				Unit.kg// unitToSend
		);
		assertEquals("Failed 2nd measurement with pound conversion - 5/3",
				"{SXD28}\r\n{SXC25}\r\n110.230\r\n",
				mockConsumer.commands.get(0));

		// 3 Small number
		mockConsumer.commands.clear();
		initializeAndSendMeasurement(pid, 2,// port,
				8,// field,
				5,// minCharacters,
				"NATIVE",// presentationUnits,
				3,// decimalPlaces,
				.01,// valueToSend,
				Unit.kg// unitToSend
		);
		assertEquals("Failed 3rd measurement - 5/3",
				"{SXD28}\r\n{SXC25}\r\n0.010\r\n", mockConsumer.commands.get(0));

		// 4 Smaller number conversion
		mockConsumer.commands.clear();
		initializeAndSendMeasurement(pid, 2,// port,
				8,// field,
				5,// minCharacters,
				"NATIVE",// presentationUnits,
				2,// decimalPlaces,
				.001,// valueToSend,
				Unit.kg// unitToSend
		);
		assertEquals("Failed 4th measurement 5/2",
				"{SXD28}\r\n{SXC25}\r\n00.00\r\n", mockConsumer.commands.get(0));

		// 5 Smallest number with more padding
		mockConsumer.commands.clear();
		initializeAndSendMeasurement(pid, 2,// port,
				8,// field,
				6,// minCharacters,
				"NATIVE",// presentationUnits,
				2,// decimalPlaces,
				.001,// valueToSend,
				Unit.kg// unitToSend
		);
		assertEquals("Failed 5th measurement 6/2",
				"{SXD28}\r\n{SXC26}\r\n000.00\r\n",
				mockConsumer.commands.get(0));

		// 6 Smallest number with no padding
		mockConsumer.commands.clear();
		initializeAndSendMeasurement(pid, 2,// port,
				8,// field,
				3,// minCharacters,
				"NATIVE",// presentationUnits,
				2,// decimalPlaces,
				.001,// valueToSend,
				Unit.kg// unitToSend
		);
		// (!decimalPlaces+1 < min)
		assertEquals("Failed smallest measurement 3/2",
				"{SXD28}\r\n{SXC23}\r\n.00\r\n", mockConsumer.commands.get(0));

	}

	@SuppressWarnings("unchecked")
	private String initializeAndSendMeasurement(String pid, int port,
			int field, int minCharacters, String presentationUnits,
			int decimalPlaces, double valueToSend, Unit unitToSend)
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
		Dictionary<String, Object> props = config.getProperties();

		props.put(DESTINATIN_PORT, port);
		props.put(DESTINATION_FIELD, field);
		props.put(MIN_CHARACTERS, minCharacters);
		props.put(PRESENTATION_UNITS, presentationUnits);
		props.put(DECIMAL_PLACES, decimalPlaces);

		config.update(props);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);

		// Get the configured service using the tag
		refs = context.getServiceReferences(Monitorable.class.getName(),
				"(trutest.measurement.adapter.test=instance)");
		assertNotNull("No MeasurementConverter Monitorable service found", refs);
		assertTrue("No MeasurementConverter Monitorable service found",
				refs.length == 1);
		monRef = refs[0];
		monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send a measurement
		m = new Measurement(valueToSend, unitToSend);
		value = new BasicEnvelope(m, "xx", INPUT_MEASUREMENT);
		mockProducer.send(value);
		TimeUnit.MILLISECONDS.sleep(WAIT_TIME_MILI);
		sv = monitorable.getStatusVariable(TOTAL_COMMANDS_SENT);
		assertEquals("Should be one measurement sent", 1, sv.getInteger());
		// Consumer will be sent two messages on from the add instance and one
		// from the subtract
		assertEquals("Should be one consumed measurement", 1,
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
		id = TOTAL_COMMANDS_SENT;
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

	}
}
