package com.verticon.tracker.irouter.wireadmin.test.system.internal;

import java.util.Dictionary;
import java.util.Hashtable;
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
	
	
	public void testCreatingSecondProducer()throws InterruptedException{
		Dictionary<String, Object> properties = new Hashtable<String, Object>();
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
		
		//Unregister the second producer, change the scope and register it.
		sr.unregister();
		TimeUnit.SECONDS.sleep(1);
		assertEquals("After unregister, consumer should be connected to only 1 producer",1,consumer.wires.length);
		
		//Reregister with a different producer scope. 
		properties.put("wireadmin.producer.scope", new String[]{"mock.string.somethingelse"});
	    sr = context.registerService(
				Producer.class.getName(), 
				secondMockProducer, 
				properties);
		assertNotNull(sr);
		
		TimeUnit.SECONDS.sleep(1);
		
		//There should NOT be a second wire connected. 
		//Because the newly re-registered Producer no longer has a scope that matches the consumer. 
		assertEquals("Should be connected to only 1 producer",1,consumer.wires.length);

	}
	
	/**
	 * When a Consumer service that has a connected Producer is stopped and restarted with a 
	 * different scope, the previous Producer with an incompatible scope is incorrectly connected.
	 * 
	 * See Ticket#651
	 * @throws InterruptedException 
	 */
	public void testReconnectingConsumer() throws InterruptedException{
		
		//Create a Consumer
		Dictionary<String, Object> consumerProperties = new Hashtable<String, Object>();
		consumerProperties.put("tracker.wiring.group.name", "test2");
		consumerProperties.put("wireadmin.consumer.scope", new String[]{"scope1"});
		consumerProperties.put("service.pid", "wireadmin.mockConsumer1");
		MockConsumer consumer = new MockConsumer();
		ServiceRegistration consumerServiceReg = context.registerService(
				Consumer.class.getName(), 
				consumer, 
				consumerProperties);
		assertNotNull(consumerServiceReg);
		consumer.setUpConnectionLatch(1);
		
		
		//Create a Producer
		Dictionary<String, Object>  properties = new Hashtable<String, Object>();
		properties.put("tracker.wiring.group.name", "test2");
		properties.put("wireadmin.producer.scope", new String[]{"scope1"});
		properties.put("service.pid", "wireadmin.mockProducer1");
		MockProducer producer = new MockProducer();
		ServiceRegistration sr = context.registerService(
				Producer.class.getName(), 
				producer, 
				properties);
		assertNotNull(sr);
		
		//Wait at latch
		boolean connected = consumer.connectionLatch.await(2, TimeUnit.SECONDS);
		assertTrue(connected);
		
		//Shutdown the Consumer
		producer.setUpDisconnectionLatch(1);
		logger.debug(bundleMarker, "Unregistering the consumer");
		consumerServiceReg.unregister();
		//Wait at latch
		boolean disconnected = producer.disconnectionLatch.await(2, TimeUnit.SECONDS);
		assertTrue("Should have disconnected", disconnected);
		
		//Change the scope and re-register the consumer
		//Wires are persisted and the race to delete a wire before it makes a connection
		//may cause the consumer to connect and then to disconnect
//		consumer.setUpConnectionLatch(1);//because of the above a simple connection latch does not work
		consumerProperties.put("wireadmin.consumer.scope", new String[]{"scopeXXX"});
		logger.debug(bundleMarker, "Re - registering the consumer");
		consumerServiceReg = context.registerService(
				Consumer.class.getName(), 
				consumer, 
				consumerProperties);
		assertNotNull(consumerServiceReg);
		
		//Wait at latch
		//But the scopes are not compatible so there should be no connection and this should time out
		//  not necessarily see note above
//	    connected = consumer.connectionLatch.await(2, TimeUnit.SECONDS);
//		assertFalse(connected);
		
		TimeUnit.SECONDS.sleep(1);
		//The consumer should have no wires connected
		assertNull(consumer.wires);
		
	}
	
}
