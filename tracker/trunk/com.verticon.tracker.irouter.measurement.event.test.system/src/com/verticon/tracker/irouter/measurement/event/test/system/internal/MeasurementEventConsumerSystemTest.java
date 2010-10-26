package com.verticon.tracker.irouter.measurement.event.test.system.internal;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.event.EventHandler;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
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
 * The MeasurementEventConsumer component will cache multiple measurements, and
 * an id until a 'transaction.state' triggers the transmission of a
 * MeasurementTransaction for each of these measurements to the EventAdmin.
 * 
 * This system test is a JUnit Plugin test that uses a Mock Producer to generate
 * measurements, id and state.
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the MockProducer. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * The MeasurementEventConsumer is a DS component that requires a configuration,
 * thus it acts like a org.osgi.service.cm.ManagedServiceFactory even though it
 * is just defined as a DS component.
 * 
 * @author jconlon
 * 
 */
public class MeasurementEventConsumerSystemTest extends TestCase {
	private static final String METTLER_WEIGHT_MEASUREMENT = "mettler.weight.measurement";

	private static final String ANIMAL_TAG_NUMBER = "animal.tag.number";

	private static final String TRANSACTION_STATE = "transaction.state";

	private static final String ANIMAL_WEIGHT_MEASUREMENT = "animal.weight.measurement";

	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.event.test.system";

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
			.getLogger(MeasurementEventConsumerSystemTest.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static MockProducer mockProducer;
	private static ConfigurationAdmin configAdmin;
	private static MockEventHandler mockEventHandler;

	public void setProducer(Producer value) {
		logger.info(bundleMarker, "DS injecting the Mock Producer");
		MeasurementEventConsumerSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementEventConsumerSystemTest.configAdmin = value;
	}
	
	public void setEventHandler(EventHandler value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementEventConsumerSystemTest.mockEventHandler = (MockEventHandler) value;
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

	public void startup(BundleContext context) {
		MeasurementEventConsumerSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);

	}

	public void testBalanceComponent() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.measurement.event";
		Configuration config = configAdmin.getConfiguration(pid);

		Properties props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		String scopes[] = { METTLER_WEIGHT_MEASUREMENT,
				ANIMAL_WEIGHT_MEASUREMENT, TRANSACTION_STATE, ANIMAL_TAG_NUMBER };

		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, scopes);
//		props.put("trigger.scope", TRANSACTION_STATE);
//		props.put("animal.id.scope", ANIMAL_TAG_NUMBER);
		props.put("consumer.transaction.state", TRANSACTION_STATE);
		props.put("consumer.transaction.state.value", 1);
		props.put("measurement.event.test", "instance");
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, scopes);
		config.update(props);
		TimeUnit.SECONDS.sleep(1);

		// Get the configured service
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(),
				"(measurement.event.test=instance)");
		assertNotNull("No MeasurementEvent Monitorable service found", refs);
		assertTrue("No MeasurementEvent Monitorable service found",
				refs.length == 1);
		ServiceReference monRef = refs[0];
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		String id = "consumer.Connected_Wires";
		StatusVariable sv = monitorable.getStatusVariable(id);
		assertEquals("Should only be one connected wire", 1, sv.getInteger());

		logger.debug(bundleMarker,
				"Sleeping to wait for connection to the fake indicator...");

		id = "consumer.Total_Measurements_Sent";
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

		// Send a animal.weight.measurement
		Measurement m = new Measurement(100, Unit.kg);
		Envelope value = new BasicEnvelope(m, "xx", ANIMAL_WEIGHT_MEASUREMENT);
		mockProducer.send(value);
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

		// Send a animal.tag.number
		Long l = 123456789012345L;
		value = new BasicEnvelope(l, "xx", ANIMAL_TAG_NUMBER);
		mockProducer.send(value);
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

		// Send a mettler.weight.measurement
		m = new Measurement(100, Unit.kg);
		value = new BasicEnvelope(m, "xy", METTLER_WEIGHT_MEASUREMENT);
		mockProducer.send(value);
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

		//No events received at this time
		assertTrue(mockEventHandler.events.isEmpty());
		
		// Send a transaction.state
		State s = new State(1, TRANSACTION_STATE);
		value = new BasicEnvelope(s, "xy", TRANSACTION_STATE);
		mockProducer.send(value);
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be two measurements sent", 2, sv.getInteger());
		//Test the event admin side to make sure an event was really 
		//received by an EventHandler
		assertEquals(2, mockEventHandler.events.size());

	}
}
