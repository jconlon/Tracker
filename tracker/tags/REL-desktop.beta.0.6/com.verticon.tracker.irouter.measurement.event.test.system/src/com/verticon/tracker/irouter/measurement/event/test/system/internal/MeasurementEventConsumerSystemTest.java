package com.verticon.tracker.irouter.measurement.event.test.system.internal;


import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.event.Event;
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
	private static final String IROUTER_PAYLOAD = "com.verticon.tracker.irouter.payload";
	
	private static final String METTLER_WEIGHT_MEASUREMENT = "mettler.weight";
	private static final String ANIMAL_TAG_NUMBER = "animal.eid";
	private static final String TRANSACTION_STATE = "transaction.state";
	private static final String ANIMAL_WEIGHT_MEASUREMENT = "animal.weight";
	private static final String EVENT_COM_VERTICON_TRACKER_READER = "event://com/verticon/tracker/reader";

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

	public void testMeasurementEventComponent() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.measurement.event";
		Configuration config = configAdmin.getConfiguration(pid);

		Properties props = new Properties();

		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		String scopes[] = { METTLER_WEIGHT_MEASUREMENT,
				ANIMAL_WEIGHT_MEASUREMENT, TRANSACTION_STATE, ANIMAL_TAG_NUMBER };

		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, scopes);
		props.put("connection.uri", EVENT_COM_VERTICON_TRACKER_READER);

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
		
		sv = monitorable.getStatusVariable("consumer.Connection_URI");
		assertEquals(EVENT_COM_VERTICON_TRACKER_READER, sv.getString());
		

		logger.debug(bundleMarker,
				"Sleeping to wait for connection to the fake indicator...");

		id = "consumer.Total_Measurements_Sent";
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

		// Send a animal.weight.measurement
		Measurement animalWeight = new Measurement(
				100, .01, Unit.kg, System.currentTimeMillis());
		Envelope value = new BasicEnvelope(animalWeight, "", ANIMAL_WEIGHT_MEASUREMENT);
		mockProducer.send(value);
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

		// Send a animal.tag.number
		Long tagNumber = 123456789012345L;
		value = new BasicEnvelope(tagNumber, "xx", ANIMAL_TAG_NUMBER);
		mockProducer.send(value);
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

		// Send a mettler.weight.measurement
		Measurement mettlerWeight = new Measurement(
				.3, .0001, Unit.kg, System.currentTimeMillis());
		value = new BasicEnvelope(mettlerWeight, tagNumber.toString(), METTLER_WEIGHT_MEASUREMENT);
		mockProducer.send(value);
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no measurements sent", 0, sv.getInteger());

		//No events received at this time
		assertTrue(mockEventHandler.events.isEmpty());
		
		// Send a transaction.state
		State s = new State(1, TRANSACTION_STATE);
		value = new BasicEnvelope(s, "xy", TRANSACTION_STATE);
		mockProducer.send(value);
		TimeUnit.MILLISECONDS.sleep(100);
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be two measurements sent", 2, sv.getInteger());
		//Test the event admin side to make sure an event was really 
		//received by an EventHandler
		assertEquals(2, mockEventHandler.events.size());
		
		//Validate the events
		
		//First Event
		Event firstEvent = mockEventHandler.events.get(0);
		//table.put(IROUTER_PAYLOAD.toProp(),envelope);
		Object payload = firstEvent.getProperty(IROUTER_PAYLOAD);
		assertNotNull("The first event payload is null", payload);
		assertTrue("The first event payload is not an Envelope", payload instanceof Envelope);
		Envelope envelopeReceived = (Envelope)payload;
		assertEquals("The first event scope bad",ANIMAL_WEIGHT_MEASUREMENT, envelopeReceived.getScope());
		assertEquals("The first event id bad",tagNumber.toString(), envelopeReceived.getIdentification());
		assertEquals("The first event value bad",animalWeight, envelopeReceived.getValue());
		
	
		//Second Event
		firstEvent = mockEventHandler.events.get(1);
		payload = firstEvent.getProperty(IROUTER_PAYLOAD);
		assertNotNull("The second event payload is null", payload);
		assertTrue("The second event payload is not an Envelope", payload instanceof Envelope);
		envelopeReceived = (Envelope)payload;
		assertEquals("The second event scope bad",METTLER_WEIGHT_MEASUREMENT, envelopeReceived.getScope());
		assertEquals("The second event id bad",tagNumber.toString(), envelopeReceived.getIdentification());
		assertEquals("The second event value bad",mettlerWeight, envelopeReceived.getValue());
	}
}
