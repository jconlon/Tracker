package com.verticon.tracker.irouter.mettler.test.system.internal;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ManagedServiceFactory;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.TrackerConstants;
import com.verticon.tracker.irouter.dev.IDeviceListener;

/**
 * The Mettler Balance component registers a WireAdmin Producer Service 
 * that sends Weight Measurement objects encapsulated in Envelopes to registered 
 * WireAdmin consumers. The component registers the Producer Service when it
 * successfully connects to a Mettler Balance. 
 * 
 * This system test is a JUnit Plugin test that uses a Fake Mettler Balance 
 * attached to a network socket of the localhost and a MockConsumer that collects
 * all received Measurements.
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services 
 * specification to inject the MockConsumer.  Use of both of these frameworks require
 * synchronization of the initialization of the injected services and the test setup. 
 * To accomplish this a CountDownLatch is used.
 * 
 * @author jconlon
 *
 */
public class MettlerBalanceSystemTest extends TestCase {
	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.mettler.test.system";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker= MarkerFactory.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MettlerBalanceSystemTest.class);
	
	private static BundleContext context;
	private static IDeviceListener listener;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static MockConsumer consumer;

	public void setListener(IDeviceListener value) {
		logger.info(bundleMarker,"DS injecting the Fake Balance");
		MettlerBalanceSystemTest.listener = value;
	}

	public void setConsumer(Consumer value) {
		logger.info(bundleMarker,"DS injecting the Mock Consumer");
		MettlerBalanceSystemTest.consumer = (MockConsumer) value;
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
		logger.info(bundleMarker,"Waiting for declarative services activation startup method to finish");
		startUpGate.await();//wait for startUp to finish
		logger.info(bundleMarker,"startup and setUp finished.");
	}

	public void startup(BundleContext context) {
		MettlerBalanceSystemTest.context = context;
		startUpGate.countDown();
	}
	
	public void testContext() {
		assertNotNull("BundleContext was not setup",context);
		assertNotNull("Fake Balance was not setup",listener);
	}

	public void testBalanceComponent() throws Exception {
		String pidValues = "com.verticon.tracker.irouter.mettler.balancefactory";
		ServiceReference[] refs = context.getServiceReferences(
				ManagedServiceFactory.class.getName(), "(service.pid="
						+ pidValues + ")");
		assertTrue("No Balance ManagedFactoryService", refs.length == 1);

		ServiceReference ref = context
				.getServiceReference(IDeviceListener.class.getName());
		assertTrue("No Fake Mettler Device service available", ref != null);

		ServiceReference msfRef = refs[0];
		ManagedServiceFactory msf = (ManagedServiceFactory) context
				.getService(msfRef);
		Properties props = new Properties();
		props.put(TrackerConstants.CONNECTION_URI, "socket://localhost:2345");
		props.put(TrackerConstants.TRACKER_WIRE_GROUP_NAME, "test");
		msf.updated("someNewPid", props);
		TimeUnit.SECONDS.sleep(3);
		refs = context.getServiceReferences(Monitorable.class.getName(),
				"(service.pid=someNewPid)");

		assertTrue("No Balance Monitorable service found", refs.length == 1);
		ServiceReference monRef = refs[0];
		Object o = monRef.getProperty(WireConstants.WIREADMIN_PRODUCER_SCOPE);
		assertNotNull(o);
		assertTrue(o.getClass().isArray());
		String[] scope = (String[]) o;
		assertEquals(1, scope.length);
		assertEquals("mettler.weight.measurement", scope[0]);
		
		Monitorable monitorable = (Monitorable) context.getService(monRef);
		String id = "producer.Connected_Consumers";
		StatusVariable sv = monitorable.getStatusVariable(id);
		assertEquals("Should only be one connected wire", 1, sv.getInteger());

		logger.debug(bundleMarker,"Sleeping to wait for connection to the fake indicator...");
		
		TimeUnit.SECONDS.sleep(30);
		assertTrue("Did not consume any measurements.",
				!consumer.measurements.isEmpty());
		assertTrue(
				"The MockConsumer should have received 164 or more measurements from the Producer",
				consumer.measurements.size() > 163);

	}
}
