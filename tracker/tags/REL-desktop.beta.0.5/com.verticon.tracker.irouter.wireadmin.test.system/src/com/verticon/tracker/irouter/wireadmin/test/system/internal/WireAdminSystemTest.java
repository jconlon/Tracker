package com.verticon.tracker.irouter.wireadmin.test.system.internal;

import java.util.Dictionary;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * iRouter Producers and Consumers contain certain properties that aid in the 
 * creation of wires between them.  WireGroup, Consumer_Scope, and Producer_Scope.
 * For the WireGroup must match and there must be a common name between the Consumer 
 * Producer Scopes.
 * 
 * As Producers and Consumers are injected by DS, the WireAdmin Component will add 
 * their properties to a map of GroupConnector objects. The GroupConnector
 * will call back this Component for the creation of appropriate wires.
 * 
 * This system test DS creates a Consumer and a Producer.
 * 
 * The Consumer "wireadmin.consumer.scope" is:
 * animal.weight.measurement
 * transaction.state
 * animal.tag.number
 * mock.string
 * 
 * The Producer "wireadmin.producer.scope" is:
 * mock.string
 * 
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the MockConsumer. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * @author jconlon
 * 
 */
public class WireAdminSystemTest extends TestCase {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(WireAdminSystemTest.class);
	protected static String PLUGIN_ID = 
		"com.verticon.tracker.irouter.wireadmin.test.system";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static MockConsumer consumer;
	private static MockProducer producer;

	public void setConsumer(Consumer value) {
		logger.debug(bundleMarker, "DS injecting the MockConsumer");
		WireAdminSystemTest.consumer = (MockConsumer) value;
	}

	public void setProducer(Producer value) {
		logger.debug(bundleMarker, "DS injecting the MockProducer");
		WireAdminSystemTest.producer = (MockProducer) value;
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

	}

	protected void tearDown() {
		if(consumer.strings!=null){
			consumer.strings.clear();
		}
	}

	public void startup(BundleContext context) {
		WireAdminSystemTest.context = context;
		startUpGate.countDown();
	}

	public void testContext() {
		assertNotNull("BundleContext was not setup", context);
	}

	public void testConsumerConnection() throws InterruptedException{
		TimeUnit.SECONDS.sleep(1);
		assertNotNull("Consumer not connected to Producer",consumer.wires);
		assertEquals(1,consumer.wires.length);
		assertTrue(consumer.wires[0].isConnected());
		assertNotNull(consumer.wires[0].getProperties());
		logger.debug(bundleMarker, "Consumer props={}",
				consumer.wires[0].getProperties());
	}
	
	public void testProducerConnection(){
		assertNotNull("Producer not connected to Consumer",producer.wires);
		assertEquals(1,producer.wires.length);
		assertTrue(producer.wires[0].isConnected());
		assertNotNull(producer.wires[0].getProperties());
		logger.debug(bundleMarker, "Producer props={}",
				producer.wires[0].getProperties());
	}
	
	public void testSending() throws InterruptedException{
		producer.send("HI");
		TimeUnit.SECONDS.sleep(1);
		assertNotNull(consumer.strings);
		assertEquals(1, consumer.strings.size());
		assertEquals("HI", consumer.strings.get(0));
	}
	
	@SuppressWarnings("unchecked")
	public void testCreatingSecondProducer()throws InterruptedException{
		
		
		@SuppressWarnings("rawtypes")
		Dictionary properties = new Properties();
		properties.put("tracker.wiring.group.name", "test");
		properties.put("wireadmin.producer.scope", new String[]{"mock.string"});
		properties.put("service.pid", "wireadmin.mockProducer");
		MockProducer secondMockProducer = new MockProducer();
		ServiceRegistration sr = context.registerService(
				Producer.class.getName(), 
				secondMockProducer, 
				properties);
		assertNotNull(sr);
		
		TimeUnit.SECONDS.sleep(1);
		
		assertNotNull("Consumer not connected to any Producers",consumer.wires);
		assertEquals("Should be connected to 2 producers",2,consumer.wires.length);
		assertTrue(consumer.wires[0].isConnected());
		assertTrue(consumer.wires[1].isConnected());
		assertNotNull(consumer.wires[0].getProperties());
		assertNotNull(consumer.wires[1].getProperties());
		
		producer.send("HI");
		TimeUnit.SECONDS.sleep(1);
		assertNotNull(consumer.strings);
		assertEquals(1, consumer.strings.size());
		assertEquals("HI", consumer.strings.get(0));
		
		secondMockProducer.send("HI From Me Too");
		TimeUnit.SECONDS.sleep(1);
		assertNotNull(consumer.strings);
		assertEquals(2, consumer.strings.size());
		assertEquals("HI", consumer.strings.get(0));
		assertEquals("HI From Me Too", consumer.strings.get(1));
		
	}
	
	

}
