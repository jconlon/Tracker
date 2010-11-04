package com.verticon.tracker.irouter.eid.event.test.system.internal;

import java.util.Dictionary;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.TrackerConstants;
import com.verticon.tracker.irouter.eid.event.test.system.Publisher;

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
public class EIDEventProducerSystemTest extends TestCase {
	private static final String EVENT_COM_VERTICON_TRACKER_READER = "event://com/verticon/tracker/reader";

	public static final String EVENT_ADMIN_TOPIC_READER = "com/verticon/tracker/reader";

	private static final String SERVICE_TAG_VALUE = "instance";
	private static final String SERVICE_TAG = "eid.event.test";
	private static final int WAIT_TIME_MILI = 1000;
	private static final String OUTPUT_INFORMATION = "animal.id.number";
	private static final String TOTAL_EID = "producer.Total_EIDs";

	static String PLUGIN_ID = "com.verticon.tracker.irouter.eid.event.test.system";

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
			.getLogger(EIDEventProducerSystemTest.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static Publisher mockGenerator;
	private static MockConsumer mockConsumer;
	private static ConfigurationAdmin configAdmin;

	public void setPublisher(Publisher value) {
		logger.info(bundleMarker, "DS injecting the Mock Producer");
		EIDEventProducerSystemTest.mockGenerator = (MockEventGenerator) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		EIDEventProducerSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		EIDEventProducerSystemTest.mockConsumer = (MockConsumer) value;
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
		mockConsumer.receivedTags.clear();
		super.tearDown();
	}

	public void startup(BundleContext context) {
		EIDEventProducerSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testEIDEvent() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.eid.event";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();
		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");

		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { OUTPUT_INFORMATION });

		props.put(EventConstants.EVENT_FILTER,
				"(com.verticon.tracker.reader.name=*)");
		props.put(EventConstants.EVENT_TOPIC, EVENT_ADMIN_TOPIC_READER);
		props.put("connection.uri", EVENT_COM_VERTICON_TRACKER_READER);

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
		mockConsumer.setUpLatch(1);
		// Send a long
		Long tag = 123456789012345l;
		mockGenerator.publish(tag, "something");
		boolean receivedEID = mockConsumer.latch.await(1, TimeUnit.SECONDS);
		assertTrue(receivedEID);
		assertEquals(tag, mockConsumer.receivedTags.get(0));
	}

	private void testInitialization(Monitorable monitorable) {
		// Test for number of consumers connected
		
		StatusVariable sv = monitorable.getStatusVariable("producer.Connected_Consumers");
		assertEquals("Should one connected mockconsumer", 1, sv.getInteger());

		sv = monitorable.getStatusVariable("producer.Connection_URI");
		assertEquals(EVENT_COM_VERTICON_TRACKER_READER, sv.getString());
		
		// Just starting so there should be no measurements sent
		sv = monitorable.getStatusVariable(TOTAL_EID);
		assertEquals("Should be no alarms sent", 0, sv.getInteger());

	}
}
