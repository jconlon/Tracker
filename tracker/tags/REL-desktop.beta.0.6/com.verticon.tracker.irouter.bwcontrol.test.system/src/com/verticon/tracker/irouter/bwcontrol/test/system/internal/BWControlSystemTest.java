/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.bwcontrol.test.system.internal;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.Dictionary;
import java.util.Hashtable;
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
import com.verticon.tracker.irouter.common.Utils;

/**
 * Component is a factory for creating custom business logic controllers
 * that integrate a Blood weight measurements with a TruTest scale indicator.
 * 
 * Consumer services will consume:
 * <ol>
 * <li>blood.weight scoped measurements</li>
 * <li>animal.weight scoped measurements (From the TruTest indicator)</li>
 * <li>transaction.state scoped measurements (From the TruTest indicator)</li>
 * </ol>
 * and produce TruTest commands on the scope trutest.commands to
 * <ol>
 * <li>display a calculated blood weight in a text field on the TruTest
 * indicator</li>
 * <li>display an actual blood weight in a text field on the TruTest indicator</li>
 * <li>turn on and off the TruTest audible alarm based on percentage of
 * calculated to actual blood weight</li>
 * </ol>
 * 
 * Tests will create a com.verticon.tracker.irouter.bwcontrol connect it to a
 * mockProducer that mocks
 * <ol>
 * <li>a TruTest scale producing animal.weight measurements</li>
 * <li>a blood balance producing blood.weight measurements</li>
 * </ol>
 * 
 * and a mockConsumer that mocks a TruTest scale consuming trutest.commonds that
 * <ol>
 * <li>display calculated blood weight measurements</li>
 * <li>display actual blood weight measurements</li>
 * <li>turn on and off alarms</li>
 * </ol>
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
public class BWControlSystemTest extends TestCase {
	private static final String TRANSACTION_STATE = "transaction.state";
	static final String CALC_BW_FIELD = "{SXD18}%13%%10%{SXC16}%13%";
	static final String BLOOD_WEIGHT_FIELD = "{SXD19}%13%%10%{SXC16}%13%";
	private static final String EID = "123456789012345";
	private static final String BLOOD_WEIGHT = "blood.weight";
	private static final String ANIMAL_WEIGHT = "animal.weight";
	private static final String BEEP_COMMAND = "trutest.beepCommand";
	private static final String BW_MULT = "abbott.bwmult";
	private static final String BW_ALARM_TRIGGER = "abbott.bwalarm.trigger";
	private static final String BW_ALARM_SECONDS = "abbott.bwalarm.period";
	private static final String ACT_BW_ID = "trutest.actbw.field";
	private static final String CAL_BW_ID = "trutest.calbw.field";
	private static final String DISPLAY_UNITS = "trutest.field.units";
	private static final String DISABLE_PRODUCTION_AFTER_RECORD = "abbott.stop.production.after.record";
	// private static final Integer DISPLAY_UNITS_GRAMS = 0;
	private static final Integer DISPLAY_UNITS_KILOGRAMS = 1;
	private static final String CALCULATION_THRESHOLD = "abbott.calbw.threashold";

	private static final String NODE_LABEL = "tracker.monitor.label";
	private static final String NODE_LABEL_DEFAULT = "BW Control";

	private static final String ANIMAL_WEIGHT_SCOPE = ANIMAL_WEIGHT;
	private static final String BLOOD_WEIGHT_SCOPE = BLOOD_WEIGHT;

	private static final String SERVICE_TAG_VALUE = "instance";
	private static final String SERVICE_TAG = "bwcontrol.test";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.bwcontrol.test.system";

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
			.getLogger(BWControlSystemTest.class);

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
		BWControlSystemTest.mockProducer = (MockProducer) value;
	}

	public void setConfigAdmin(ConfigurationAdmin value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		BWControlSystemTest.configAdmin = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker, "DS injecting the ConfigAdmin");
		BWControlSystemTest.mockConsumer = (MockConsumer) value;
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
		BWControlSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testBWComponent() throws Exception {
		// Configure the instance
		String pid = "com.verticon.tracker.irouter.bwcontrol";

		Configuration config = configAdmin.createFactoryConfiguration(pid);

		Dictionary props = getDefaults();

		// Add a tag to find the service
		props.put(SERVICE_TAG, SERVICE_TAG_VALUE);
		config.update(props);

		logger.debug(bundleMarker,
				"Submitted configuration, waiting for service activation.");

		boolean consumerConnected = mockConsumer.latch.await(5,
				TimeUnit.SECONDS);
		assertTrue(consumerConnected);

		boolean producerConnected = mockProducer.latch.await(5,
				TimeUnit.SECONDS);
		assertTrue(producerConnected);

		// Get the monitorable service
		ServiceReference refs[] = context.getServiceReferences(
				Monitorable.class.getName(), "(" + SERVICE_TAG + '='
						+ SERVICE_TAG_VALUE + ")");

		assertNotNull("No Monitorable service found", refs);
		assertTrue("No Monitorable service found", refs.length == 1);
		ServiceReference monRef = refs[0];
		pid = (String) monRef.getProperty("service.pid");
		assertNotNull(pid);
		Monitorable monitorable = (Monitorable) context.getService(monRef);

		testInitialization(monitorable);

		// Send an animal weight and check the calculated bw displayed
		mockConsumer.setUpLatch(1);
		sendAnimalMeasurement(200d);
		boolean gotMeasurement = mockConsumer.latch.await(5, TimeUnit.SECONDS);
		assertTrue(gotMeasurement);

		StatusVariable sv = monitorable
				.getStatusVariable("producer.Total_Commands_Sent");
		assertEquals("Should be one commands", 1, sv.getInteger());

		sv = monitorable.getStatusVariable("producer.Last_Command_Sent");
		assertFalse(isNullOrEmpty(sv.getString()));
		assertEquals("Should be one measurement sent to the calcbw field", 1,
				mockConsumer.calcbwFieldValues.size());

		String result = mockConsumer.calcbwFieldValues.get(0);
		assertEquals(
				Utils.toAscii(result) + " vs " + Utils.toAscii("2.0000\r\n"),
				"2.0000\r\n", result);

		// Send an actual Blood Weight that is half the calculated bw and check
		// the display
		mockConsumer.setUpLatch(1);
		sendBWMeasurement(1d);
		gotMeasurement = mockConsumer.latch.await(5, TimeUnit.SECONDS);
		assertTrue(gotMeasurement);

		sv = monitorable.getStatusVariable("producer.Total_Commands_Sent");
		assertEquals("Should be two commands", 2, sv.getInteger());

		sv = monitorable.getStatusVariable("producer.Last_Command_Sent");
		assertFalse(isNullOrEmpty(sv.getString()));
		assertEquals("Should be one measurement sent to the bw field", 1,
				mockConsumer.bwFieldValues.size());

		result = mockConsumer.bwFieldValues.get(0);
		assertEquals(
				Utils.toAscii(result) + " vs " + Utils.toAscii("1.0000\r\n"),
				"1.0000\r\n", result);

		// Since it was half make sure there are no alarms sent - default is 1
		// second an alarm
		TimeUnit.SECONDS.sleep(3);
		// Should still be only two sent
		sv = monitorable.getStatusVariable("producer.Total_Commands_Sent");
		assertEquals("Should be two commands", 2, sv.getInteger());

		// Send an actual Blood Weight that is over the alarm threashold of the
		// calculated bw and check the display
		mockConsumer.setUpLatch(3);
		sendBWMeasurement(1.6d);
		gotMeasurement = mockConsumer.latch.await(5, TimeUnit.SECONDS);
		assertTrue(gotMeasurement);

		sv = monitorable.getStatusVariable("producer.Total_Commands_Sent");
		assertEquals("Should be five commands, three displays and two alarms",
				5, sv.getInteger());

		assertEquals("Should be one measurement sent to the bw field", 2,
				mockConsumer.bwFieldValues.size());

		result = mockConsumer.bwFieldValues.get(1);
		assertEquals(
				Utils.toAscii(result) + " vs " + Utils.toAscii("1.6000\r\n"),
				"1.6000\r\n", result);
		assertEquals("Should be two alarms sent to the alarm", 2,
				mockConsumer.alarmCommands.size());

		result = mockConsumer.alarmCommands.get(1);
		assertEquals(
				Utils.toAscii(result) + " vs " + Utils.toAscii("{SABP500}\r"),
				"{SABP500}\r", result);

		// Turn off alarm by sending a transaction
		sendTransaction(TRANSACTION_STATE, EID);
		TimeUnit.SECONDS.sleep(3);
		// Should still be only two sent
		sv = monitorable.getStatusVariable("producer.Total_Commands_Sent");
		assertEquals("Should still be five commands", 5, sv.getInteger());

	}

	/**
	 * Mocks a Blood weight sensor sending out measurements on the blood.weight
	 * scope
	 * 
	 * @param d
	 */
	private void sendBWMeasurement(double d) {
		sendMeasurement(d, BLOOD_WEIGHT, EID);
	}

	/**
	 * Mocks a TruTest weight sensor sending out measurements on the
	 * animal.weight scope
	 * 
	 * @param d
	 */
	private void sendAnimalMeasurement(double d) {
		sendMeasurement(d, ANIMAL_WEIGHT, EID);
	}

	/**
	 * Mocks a TruTest weight sensor sending out key press on the
	 * transaction.state scope
	 * 
	 * @param d
	 */
	private void sendTransaction(String scope, String id) {
		State state = new State(1, "dontcare");
		Envelope envelope = new BasicEnvelope(state, id, scope);
		mockProducer.send(envelope);
	}

	private void sendMeasurement(double d, String scope, String id) {
		Measurement m = new Measurement(d, Unit.kg);
		Envelope envelope = new BasicEnvelope(m, id, scope);
		mockProducer.send(envelope);
	}

	private void testInitialization(Monitorable monitorable) {
		logger.debug(bundleMarker, "{} Testing initialization", this);
		// Test for number of consumers connected
		StatusVariable sv = monitorable
				.getStatusVariable("producer.Connected_Consumers");
		assertEquals("Should one connected mockconsumer", 1, sv.getInteger());

		// Test for number of producers connected
		sv = monitorable.getStatusVariable("consumer.Connected_Producers");
		assertEquals("Should be one connected mockproducer", 1, sv.getInteger());

		// Just starting so there should be no commands sent
		sv = monitorable.getStatusVariable("producer.Total_Commands_Sent");
		assertEquals("Should be no alarms sent", 0, sv.getInteger());

	}

	private Dictionary<String, Object> getDefaults() {
		Dictionary<String, Object> defaults = new Hashtable<String, Object>();
		defaults.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		defaults.put(BEEP_COMMAND, "{SABP500}%13%");
		/*
		 * To write actual and calculated data to the display, the ports fields,
		 * and the minimum number of characters must be specified. Change the
		 * defaults if the indicator is reconfigured changing field locations.
		 * SXD1 is Com Port 1, 8 is the first data field, 9 the second. SXC1 is
		 * Com Port 1 and 6 is the number of characters.
		 */
		defaults.put(ACT_BW_ID, BLOOD_WEIGHT_FIELD);
		defaults.put(CAL_BW_ID, CALC_BW_FIELD);
		defaults.put(BW_MULT, ".01");
		defaults.put(BW_ALARM_TRIGGER, ".75");
		defaults.put(BW_ALARM_SECONDS, "1");
		defaults.put(DISPLAY_UNITS, DISPLAY_UNITS_KILOGRAMS);
		defaults.put(CALCULATION_THRESHOLD, "5");
		defaults.put(DISABLE_PRODUCTION_AFTER_RECORD, Boolean.TRUE);
		defaults.put(NODE_LABEL, NODE_LABEL_DEFAULT);

		// <AD name="Consumable scope" id="wireadmin.consumer.scope"
		// required="true"
		// type="String"
		// default="animal.weight,mettler.weight,transaction.state"
		// cardinality="3"
		// description="The consumable scopes carrying the animal weight, blood weight, and transaction state. (Use full scope names)"
		// />

		defaults.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[] {
				ANIMAL_WEIGHT, BLOOD_WEIGHT, TRANSACTION_STATE });

		// <AD name="Animal Weight scope" id="animal.weight"
		// required="true"
		// type="String"
		// default="animal.weight"
		// description="The consumable scopes (from the list of consumable scopes) carrying the animal weight. (Use full scope names)"
		// />
		defaults.put(ANIMAL_WEIGHT_SCOPE, ANIMAL_WEIGHT);

		// <AD name="Blood Weight scope" id="blood.weight"
		// required="true"
		// type="String"
		// default="mettler.weight"
		// description="The consumable scope (from the list of consumable scopes) carrying the blood weight. (Use full scope names)"
		// />
		//
		defaults.put(BLOOD_WEIGHT_SCOPE, BLOOD_WEIGHT);

		// <AD name="Producer scope" id="wireadmin.producer.scope"
		// type="String"
		// cardinality="1"
		// required="true"
		// default="trutest.commands"
		// description="The producer scope to send the adapted TruTest commands. (Use full scope names)"
		// />
		defaults.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { "trutest.commands" });

		return defaults;
	}
}
