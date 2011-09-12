package com.verticon.tracker.irouter.measurement.logger.test.system.internal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
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
 * MeasurementLoggerConsumer is a gateway Component Factory that creates
 * services to log transactions of measurements and animal ids.
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
public class MeasurementLoggerConsumerSystemTest extends TestCase {
	private static final String AGGREGATED_LOG_FILE = "aggregated.log";
	private static final String NORMALIZED_LOG_FILE = "transaction.log";
	private static final String AGGREGATED_LOGGER_NAME = "aggregated";
	private static final String NORMALIZED_LOGGER_NAME = "transaction";
	private static final int AGREGATED_LOGGER = 1;
	private static final int NORMALIZED_LOGGER = 0;
	private static final String TRANSACTION_STATE_VALUE = "transaction.state.name";
	private static final String PROP_TRANSACTION_STATE_NAME = "consumer.transaction.state";
	private static final String PROP_TRANSACTION_STATE_VALUE = "consumer.transaction.state.value";
	
	private static final String LOGGER_NAME = "logger.name";
	private static final String SERVICE_TAG_VALUE = "instance";
	private static final String SERVICE_TAG = "measurement.trigger.test";
	private static final int WAIT_TIME_MILI = 200;
	private static final String INPUT_INFORMATION = "input.information";
	private static final String INPUT_INFORMATION_TWO = "input.information.two";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.measurement.trigger.test.system";
//	private static final String TIME_OF_LAST_TRIGGER = "producer.Last_Trigger";
	private static final String TOTAL_LOG_ENTRIES_SENT = "consumer.Log_Entries_Sent";

	
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
			.getLogger(MeasurementLoggerConsumerSystemTest.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static MockProducer mockProducer;
	private static MockProducer mockProducerTwo;
	private static ConfigurationAdmin configAdmin;

	public void setProducer(Producer value) {
		logger.info(bundleMarker, "DS injecting the Mock Producer");
		MeasurementLoggerConsumerSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		MeasurementLoggerConsumerSystemTest.configAdmin = value;
	}

	public void setProducerTwo(Producer value) {
		logger.info(bundleMarker, "DS injecting the Mock ProducerTwo");
		MeasurementLoggerConsumerSystemTest.mockProducerTwo = (MockProducer) value;
	}

	private static String pid;
	
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
		boolean started = startUpGate.await(5, TimeUnit.SECONDS);// wait for startUp to finish
		if(!started){
			throw new IllegalStateException("Failed to inject services.");
		}
		logger.info(bundleMarker, "startup and setUp finished.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
//		mockConsumer.receivedObjects.clear();
		super.tearDown();
	}

	public void startup(BundleContext context) {
		File file = new File(NORMALIZED_LOG_FILE);
		if(file.exists()){
			try {
				FileOutputStream erasor = new FileOutputStream(file);
				erasor.write("".getBytes());
				erasor.close();
			} catch (FileNotFoundException e) {
				logger.error(bundleMarker, "Failed startup",e);
			} catch (IOException e) {
				logger.error(bundleMarker, "Failed startup",e);
			}
		}
	    file = new File(AGGREGATED_LOG_FILE);
		if(file.exists()){
			try {
				FileOutputStream erasor = new FileOutputStream(file);
				erasor.write("".getBytes());
				erasor.close();
			} catch (IOException e) {
				logger.error(bundleMarker, "Failed startup",e);
			}
		}
		MeasurementLoggerConsumerSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testAgregatedLogger() throws Exception {	
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.measurement.logger";
		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = new Properties();
		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { INPUT_INFORMATION, INPUT_INFORMATION_TWO});

		//Name of the Control State" 
		props.put(PROP_TRANSACTION_STATE_NAME,TRANSACTION_STATE_VALUE);
	
		//Value of the Control State" 
		props.put(PROP_TRANSACTION_STATE_VALUE, 1);
	
		//"Type of logger" 
		props.put("logger.type",AGREGATED_LOGGER); 
		//Normalized" value="0"/>
		//Aggregated" value="1"/>

		//"Logger name"  
		props.put(LOGGER_NAME, AGGREGATED_LOGGER_NAME);
		
		//Monitor node 
		props.put("tracker.monitor.label", "myName");
		
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
		MeasurementLoggerConsumerSystemTest.pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);
		// just sending measurements which will not log
		for (int i = 0; i < 3; i++) {
			sendMeasurementFromScopeOne(100d + i);
		}
		//Multiple measurements sent with the same scope should only record as one measurement.
		evaluate(monitorable,0,1,Long.valueOf(0));
		
		//Send from a different scope
		sendMeasurementFromScopeTwo(100d);
		evaluate(monitorable,0,2,0l);
		
		sendEID(123456789012345l);
		evaluate(monitorable,0,2,123456789012345l);
		
		//Send the state
		State state = new State(1,TRANSACTION_STATE_VALUE);
		mockProducer.send(new BasicEnvelope(state,"xx",INPUT_INFORMATION));
		evaluate(monitorable,1,0,0l);
		
		File file = new File(AGGREGATED_LOG_FILE);
		assertTrue(file.exists());
		List<String> lines = getLines( file);
		assertEquals(2,lines.size());
		
		String line = lines.get(0);
		assertTrue(line.equals(
			"type='measurement',dateTime='1969-12-31 18:00:00',id='123456789012345',scope='input.information',value='102.0000',error='0.0000',unit='kg'"));
		
	    line = lines.get(1);
	    assertTrue(line.equals(
	    	"type='measurement',dateTime='1969-12-31 18:00:00',id='123456789012345',scope='input.information.two',value='100.0000',error='0.0000',unit='kg'"));	
	}
	
	public void testNormalizedLogger() throws Exception {
		Monitorable monitorable = initializeNormalizedLogger( pid);
		// just sending measurements which will not log
		for (int i = 0; i < 3; i++) {
			sendMeasurementFromScopeOne(100d + i);
		}
		//Multiple measurements sent with the same scope should only record as one measurement.
		evaluate(monitorable,0,1,Long.valueOf(0));
		
		//Send from a different scope
		sendMeasurementFromScopeTwo(100d);
		evaluate(monitorable,0,2,0l);
		
		sendEID(123456789012345l);
		evaluate(monitorable,0,2,123456789012345l);
		
		//Send the state
		State state = new State(1,TRANSACTION_STATE_VALUE);
		mockProducer.send(new BasicEnvelope(state,"xx",INPUT_INFORMATION));
		evaluate(monitorable,1,0,0l);
		File file = new File(NORMALIZED_LOG_FILE);
		assertTrue(file.exists());
		List<String> lines = getLines( file);
		assertEquals(1,lines.size());
		String line = lines.get(0);
		//2010-10-25 20:20:04,123456789012345,test,102.0,100.0
		assertTrue(line.contains(",123456789012345,test,102.0,100.0"));
	}
	
	private List<String> getLines(File file) throws IOException{
		List<String> lines = new ArrayList<String>();
		IOException io = null;
		DataInputStream in = null;
		BufferedReader br = null;
		try {
			FileInputStream fstream = new FileInputStream(file);
		    in = new DataInputStream(fstream);
		    br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			
				while ((strLine = br.readLine()) != null)   {
					lines.add(strLine);
				}
				
			} catch (IOException e) {
				io = e;
			} finally{
				//Close the input stream
				if(br!=null){
					br.close();
				}
				if(in!=null)
					in.close();
			}
			if(io!=null){
				throw io;
			}
		
		return lines;
	}

	private void evaluate(Monitorable monitorable, int logsSent, 
			int measurementInQueue, Long eid)
			throws InterruptedException {
		StatusVariable sv = monitorable.getStatusVariable("consumer.Log_Entries_Sent");
		assertEquals( logsSent, sv.getInteger());
		sv = monitorable.getStatusVariable("consumer.Measurements_In_Queue");
		assertEquals( measurementInQueue, sv.getInteger());
		sv = monitorable.getStatusVariable("consumer.Current_EID");
		assertEquals( new Float(eid), sv.getFloat());
	}
	
	
	private void sendEID(Long eid) {
		Envelope envelope = new BasicEnvelope(eid, "xx", INPUT_INFORMATION);
		mockProducer.send(envelope);
	}
	
	private void sendMeasurementFromScopeOne(double d) {
		Measurement m = new Measurement(d, Unit.kg);
		Envelope envelope = new BasicEnvelope(m, "xx", INPUT_INFORMATION);
		mockProducer.send(envelope);
	}
	
	private void sendMeasurementFromScopeTwo(double d) {
		Measurement m = new Measurement(d, Unit.kg);
		Envelope envelope = new BasicEnvelope(m, "xx", INPUT_INFORMATION_TWO);
		mockProducerTwo.send(envelope);
	}

	@SuppressWarnings("unchecked")
	private Monitorable initializeNormalizedLogger(String pid) throws InterruptedException,
			IOException, InvalidSyntaxException {
		Configuration config;

		ServiceReference[] refs;
		ServiceReference monRef;
		Monitorable monitorable;
		config = configAdmin.getConfiguration(pid);
		assertNotNull(config);
		Dictionary<String, Object> props = config.getProperties();
		props.put("logger.type",NORMALIZED_LOGGER); 
		
		//"Logger name"  
		props.put(LOGGER_NAME, NORMALIZED_LOGGER_NAME);
		
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
		assertEquals("Should be one connected mockproducer", 2, sv.getInteger());

		// Just starting so there should be no measurements sent
		id = TOTAL_LOG_ENTRIES_SENT;
		sv = monitorable.getStatusVariable(id);
		assertEquals("Should be no transactions sent", 0, sv.getInteger());

	}
}
