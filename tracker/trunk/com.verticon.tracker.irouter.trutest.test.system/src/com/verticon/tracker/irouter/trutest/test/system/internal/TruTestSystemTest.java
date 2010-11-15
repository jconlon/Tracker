package com.verticon.tracker.irouter.trutest.test.system.internal;

import java.io.File;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.equinoxosgi.util.PropertyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ManagedServiceFactory;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Producer;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.TrackerConstants;
import com.verticon.tracker.irouter.dev.IDeviceListener;
import com.verticon.tracker.irouter.trutest.dev.ITruTestIndicator;

/**
 * The TruTest Indicator component registers a WireAdmin Producer Service that
 * sends Weight Measurement objects, Tag Identifications, and State encapsulated
 * in Envelopes to registered WireAdmin Consumers. The component registers the
 * Producer Service when it successfully connects to a TruTest scale head.
 * 
 * The TruTest Indicator component also registers a WireAdmin Consumer Service
 * that recieves TruTest commands from registered WireAdmin Producers. The
 * component registers the Consumer Service when it successfully connects to a
 * TruTest scale head.
 * 
 * This system test is a JUnit Plugin test that uses a Fake TruTest Indicator
 * Balance attached to a network socket of the localhost and a MockConsumer that
 * collects all received Envelopes.
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the MockConsumer. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * @author jconlon
 * 
 */
public class TruTestSystemTest extends TestCase {

	private static final Double WEIGHT = new Double(100);
	private static final Long EID = new Long(123456789012345l);
	// Indicator statusVars
	private static final String DOWNLOAD_RECORDS_COUNT = "producer.Downloaded_Records";
	private static final String UPLOAD_RECORDS_COUNT = "producer.Uploaded_Records";
	private static final String CONNECTED = "producer.Is_Connected";
	// Producer statusVars
	private static final String LAST_WEIGHT = "producer.Last_Weight_Sent";
	private static final String LAST_EID = "producer.Last_EID_Sent";
	private static final String CONSUMERS_CONNECTED_TO_PRODUCER = "producer.Connected_Consumers";
	private static final String PRODUCERS_CONNECTED_TO_CONSUMER = "consumer.Connected_Producers";

	private static final String DATA_SYNCHRONIZATION_DIRECTORY = "data.synchronization.directory";
	private static final String INITIALIZATION_CONSUMER_TIMEOUT = "data.synchronization.timeout.seconds";
	private static final String INITIALIZATION_CONSUMER_SCOPE = "data.synchronization.scope";

	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.test.system";

	private File downloadedFile = null;

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
			.getLogger(TruTestSystemTest.class);

	private static BundleContext context;
	private static IDeviceListener listener;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static MockConsumer consumer;
	private static MockProducer producer;
	private static MockProducer dataSyncProducer;

	public void setListener(IDeviceListener value) {
		logger.debug(bundleMarker, "DS injecting the Fake Indicator");
		TruTestSystemTest.listener = value;
	}

	public void setConsumer(Consumer value) {
		logger.debug(bundleMarker, "DS injecting the MockConsumer");
		TruTestSystemTest.consumer = (MockConsumer) value;
	}

	public void setProducer(Producer value) {
		logger.debug(bundleMarker, "DS injecting the MockProducer");
		TruTestSystemTest.producer = (MockProducer) value;
	}
				
	public void setDataSyncProducer(Producer value){
		logger.debug(bundleMarker, "DS injecting the MockProducer");
		TruTestSystemTest.dataSyncProducer = (MockProducer) value;
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
		logger.debug(bundleMarker, "Waiting at startUpGate");
		startUpGate.await();// wait for startUp to finish
		logger.debug(bundleMarker, "setUp finished.");

		String dataDirectory = PropertyManager.getProperty(
				DATA_SYNCHRONIZATION_DIRECTORY, "/tmp");
		
		downloadedFile = new File(dataDirectory,
				"animalLifeDataDownload-test.txt");
		if (downloadedFile.exists()) {
			downloadedFile.delete();
		}
		// if(upLoadFile.exists()){
		// downloadedFile.delete();
		// }

	}

	protected void tearDown() {
		// if(upLoadFile.exists()){
		// upLoadFile.delete();
		// }
	}

	public void startup(BundleContext context) {
		TruTestSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
		assertNotNull("Fake ScaleHead was not setup", listener);
	}

	public void testIndicatorComponent() throws Exception {
		String pidValues = "com.verticon.tracker.irouter.trutest.indicatorfactory";
		ServiceReference[] refs = context.getServiceReferences(
				ManagedServiceFactory.class.getName(), "(service.pid="
						+ pidValues + ")");
		assertNotNull("No TruTest Indicator ManagedFactoryService",
				refs);
		assertTrue("No TruTest Indicator ManagedFactoryService",
				refs.length == 1);

		ServiceReference msfRef = refs[0];
		ManagedServiceFactory msf = (ManagedServiceFactory) context
				.getService(msfRef);
		Properties props = new Properties();
		props.put(TrackerConstants.CONNECTION_URI, "socket://localhost:2344");
		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		props.put("producer.scope.eid", "animal.tag.number");
		props.put(INITIALIZATION_CONSUMER_TIMEOUT, "5");
		props.put(INITIALIZATION_CONSUMER_SCOPE, "trutest.upload.ready");
		
		
		String dataDirectory = PropertyManager.getProperty(
				DATA_SYNCHRONIZATION_DIRECTORY, "/tmp");
		props.put(DATA_SYNCHRONIZATION_DIRECTORY, dataDirectory);
		msf.updated("someNewPid", props);
		logger.debug(bundleMarker,
				"Submitted configuration, waiting for service activation.");

		// Updated should create an instance and connect it to the fake
		// indicator
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(dataSyncProducer.wires);
		dataSyncProducer.send(new State(1,"FIRE"));

		// Get the monitorable service
		refs = context.getServiceReferences(Monitorable.class.getName(),
				"(service.pid=someNewPid)");
		assertNotNull("No Indicator Monitorable service found", refs);
		assertEquals("Should only be one Monitorable service found", 1, refs.length);
		ServiceReference monRef = refs[0];
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		// Check the connection
		StatusVariable sv = monitorable.getStatusVariable(CONNECTED);
		assertTrue("Should be connected", sv.getBoolean());

		TimeUnit.SECONDS.sleep(10);
		// Check the number of downloaded records
		sv = monitorable.getStatusVariable(DOWNLOAD_RECORDS_COUNT);
		assertEquals("Wrong number of Downloaded records", 37, sv.getInteger());

		// Check the download file
		assertTrue("Download file should exist", downloadedFile.exists());
		assertEquals("Wrong size of fileDownload", 1006,
				downloadedFile.length());

		TimeUnit.SECONDS.sleep(10);
		// Check the number of uploaded records
		sv = monitorable.getStatusVariable(UPLOAD_RECORDS_COUNT);
		assertEquals("Wrong number of uploaded records", 26, sv.getInteger());

		// Check the number of connected consumers
		sv = monitorable.getStatusVariable(CONSUMERS_CONNECTED_TO_PRODUCER);
		assertEquals("Should be one consumer connected to the indicator", 1,
				sv.getInteger());

		// Check the number of connected producers
		sv = monitorable.getStatusVariable(PRODUCERS_CONNECTED_TO_CONSUMER);
		assertEquals("Should be only one producer connected to the indicator", 1,
				sv.getInteger());

		assertTrue(listener instanceof ITruTestIndicator);
		ITruTestIndicator indicator = (ITruTestIndicator) listener;

		// Read a tag, weigh and animal, push record on the fake indicator
		logger.debug(bundleMarker, "Send EID from the indicator.");
		indicator.readEIDTag(EID);
		logger.debug(bundleMarker,
				"Wait for the indicator to process the commands");
		TimeUnit.MILLISECONDS.sleep(500);
		assertEquals(
				"The MockConsumer should have received 1 Long from the Producer. " +
				"Check that there is NOT a Tracker running, that may be interfering " +
				"with the test.",
				1, consumer.longs.size());
		assertEquals(EID, consumer.longs.get(0));
		sv = monitorable.getStatusVariable(LAST_EID);
		assertEquals("Should be the EID just sent", EID.toString(), sv.getString());

		logger.debug(bundleMarker, "Send WEIGHT from the indicator.");
		indicator.setWeight(WEIGHT);
		logger.debug(bundleMarker,
				"Wait for the indicator to process the commands");
		TimeUnit.MILLISECONDS.sleep(500);
		assertEquals(
				"The MockConsumer should have received 1 Messurements from the Producer",
				1, consumer.measurements.size());
		assertEquals(new Measurement(WEIGHT, 0.01d, Unit.kg),
				consumer.measurements.get(0));
		sv = monitorable.getStatusVariable(LAST_WEIGHT);
		assertEquals("Should be Weight just sent", new Float(WEIGHT),
				sv.getFloat());

		logger.debug(bundleMarker, "Send RECORD from the indicator.");
		indicator.pressRecordKey();// This will also cause the weight to be sent
									// again.
		logger.debug(bundleMarker,
				"Wait for the indicator to process the commands");
		TimeUnit.MILLISECONDS.sleep(500);
		assertEquals(
				"The MockConsumer should have received 2 Messurements from the Producer",
				2, consumer.measurements.size());

		assertEquals(
				"The MockConsumer should have received 1 State from the Producer",
				1, consumer.states.size());

		// Test Sending Display commands from the mock producer to the
		// Consumer and on to the fake device
		logger.debug(bundleMarker, "Send display commands from the Producer.");
		// "{SXD28}\r\n{SXC26}\r\n333.11\r\n";
		producer.send("{SXD28}\r\n{SXC26}\r\n333.11\r\n");
		TimeUnit.SECONDS.sleep(2);
		Map<String, String> values = indicator.getValues();
		assertFalse("no values set on the indicator", values.isEmpty());
		assertEquals("D28C26", values.keySet().iterator().next());
		assertEquals("333.11", values.get("D28C26"));

		// Test the beeper "{SABP500}%13%"
		for (int i = 0; i < 3; i++) {
			values.clear();
			producer.send("{SABP500}\r\n");
			TimeUnit.SECONDS.sleep(2);
			assertEquals("500", values.get("BEEP"));
		}
	}

}
