/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.irouter.measurement.trigger.file.test.system.internal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.measurement.trigger.file.StatusVar;

/**
 * 
 * Basic testing of the com.verticon.tracker.irouter.ohaus component.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>ITrackerStore</li>
 * <li>ConfigurationAdmin</li>
 * </ol>
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the ITrackerStore. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * 
 * If a comm port is use a valid port needs to be set as a system property
 * -Dgnu.io.rxtx.SerialPorts=/dev/ttyS0:/dev/rfcomm0 is a valid configuration
 * 
 * @author jconlon
 * 
 */
public class Test_Measurement_Trigger_File extends TestCase {


	static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.trigger.file.test.system";
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
			.getLogger(Test_Measurement_Trigger_File.class);


	private static BundleContext context;
	/**
	 * This class is a JUnit class and a DS component. There needs to be a
	 * synchronization between the DS and JUnit initializations. This is done
	 * with a java.util.concurrent.CountDownLatch.
	 * 
	 * In the JUnit setUp() method the startUpGate.await() will be called which
	 * will block until all DS services are injected. When all services are
	 * injected and DS calls the startup() method startUpGate.countDown() is
	 * called unblocking the thread waiting in the setUp(). Once tripped the
	 * latch lets subsequent calls through.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);

	/**
	 * Injected services implement by
	 * com.verticon.tracker.store.mongo.internal.Component
	 */
	static Monitorable monitorable;
	static Consumer consumer;

	/**
	 * Injected service implemented by the test framework
	 */
	static IController controller;

	
	

	/**
	 * Injected by ds
	 * 
	 * @param consumer
	 */
	public void setConsumer(Consumer consumer) {
		logger.debug(bundleMarker, "DS injecting the Producer");
		Test_Measurement_Trigger_File.consumer = consumer;
	}


	/**
	 * Injected by ds
	 * 
	 * @param consumer
	 */
	public void unsetConsumer(Consumer consumer) {
		logger.debug(bundleMarker, "DS nulling the Producer");
		Test_Measurement_Trigger_File.consumer = null;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	public void setMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_Measurement_Trigger_File.monitorable = monitorable;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	public void unsetMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS nulling the monitorable");
		Test_Measurement_Trigger_File.monitorable = null;
	}

	/**
	 * Injected by ds
	 * 
	 * @param controller
	 */
	public void setController(IController controller) {
		logger.debug(bundleMarker, "DS injecting the controller");
		Test_Measurement_Trigger_File.controller = controller;
	}

	/**
	 * Injected by ds
	 * 
	 * @param controller
	 */
	public void unsetController(IController controller) {
		logger.debug(bundleMarker, "DS nulling the controller");
		Test_Measurement_Trigger_File.controller = null;
	}

	/**
	 * 
	 * Called by the test framework to setup the test case. This method will
	 * block at a startupGate waiting for the ITrackerStore service under test
	 * to be injected by DS.
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		startUpGate.await();// wait for startUp to finish
		// System.out.println(this + ": startup and setUp finished.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * On activation of this component this method is called.
	 * 
	 * @param context
	 */
	public void startup(BundleContext context) {
		logger.debug(bundleMarker, "Activating");
		Test_Measurement_Trigger_File.context = context;
		startUpGate.countDown();
	}

	protected void deactivate() {
		logger.debug(bundleMarker, "DEActivating");
	}

	//Tests
	/**
	 * This is mostly redundant all of these should be there to get this far.
	 */
	@Test
	public void testContext() {
		assertThat("BundleContext was not setup", context, is(notNullValue()));
		StatusVariable var = monitorable
				.getStatusVariable(StatusVar.WIRES_COUNT.id);
		assertThat("Must have one wire connected", var.getInteger(), is(1));
	}

	/**
	 * 
	 * {'events.dateTime' : {$gte :new Date(2010, 02, 01), $lt : new Date(2011,
	 * 04, 01)}}
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testSendMeasurements() throws InterruptedException {
		StatusVariable var = monitorable
				.getStatusVariable(StatusVar.WIRES_COUNT.id);
		assertThat("Must have one wire connected", var.getInteger(), is(1));

		var = monitorable
				.getStatusVariable(StatusVar.MEASUREMENT_COUNT.id);
		assertThat("Must be 0", var.getInteger(), is(0));

		var = monitorable.getStatusVariable(StatusVar.LAST_FILE_NAME.id);
		assertThat("Must be blank", var.getString(), is(""));

		var = monitorable
				.getStatusVariable(StatusVar.LAST_MEASUREMENT_VALUE.id);
		assertThat("Must be blank", var.getString(), is(""));

		var = monitorable.getStatusVariable(StatusVar.LAST_MEASUREMENT_TIME.id);
		assertThat("Must be blank", var.getString(), is(""));

		TimeUnit.SECONDS.sleep(1);

		long t = sendMeasurement(100, .0001);
		TimeUnit.SECONDS.sleep(1);
		var = monitorable
				.getStatusVariable(StatusVar.MEASUREMENT_COUNT.id);
		assertThat("Must be Admin", var.getInteger(), is(1));

		var = monitorable.getStatusVariable(StatusVar.LAST_FILE_NAME.id);
		assertThat("FileName is incorrect, was: " + var.getString(), var
				.getString().matches("/tmp/measurement-\\d.*.txt"), is(true));

		var = monitorable
				.getStatusVariable(StatusVar.LAST_MEASUREMENT_VALUE.id);

		assertThat("Values incorrect was: " + var.getString(),
				var.getString().matches("\\d.*,POUNDS,220.462,2.20462E-4"),
				is(true));

		var = monitorable.getStatusVariable(StatusVar.LAST_MEASUREMENT_TIME.id);
		assertThat("Time of event is wrong", var.getString(),
				is(String.format("%tT", t)));

		// TimeUnit.SECONDS.sleep(100);

		// assertThat("Output file must exist.", , is(notNullValue()));

	}

	private long sendMeasurement(double d, double e) {
		Measurement m = new Measurement(d, e, Unit.kg,
				System.currentTimeMillis());
		Envelope envelope = new BasicEnvelope(m, "xx",
				Configurator.OHAUS_WEIGHT);
		controller.send(envelope);
		return m.getTime();
	}

	@SuppressWarnings("unused")
	private Date parseDate(String date, String format) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(date);
	}

}
