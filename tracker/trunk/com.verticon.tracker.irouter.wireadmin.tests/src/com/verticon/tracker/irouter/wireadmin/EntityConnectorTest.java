/**
 * 
 */
package com.verticon.tracker.irouter.wireadmin;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Constants;
import org.osgi.service.wireadmin.WireAdminEvent;
import org.osgi.service.wireadmin.WireConstants;

import com.verticon.tracker.irouter.wireadmin.GroupConnector;
import com.verticon.tracker.irouter.wireadmin.IWireCreator;
import com.verticon.tracker.irouter.wireadmin.WireParameters;

/**
 * @author jconlon
 *
 */
public class EntityConnectorTest {

	private Map<String, Object> propertiesProducer1 = null;
	private static final String[] SCOPE_PRODUCER_1 = {"b", "d","e","f"};
	private Map<String, Object> propertiesConsumer1 = null;
	private static final String[] SCOPE_CONSUMER_1 = {"a", "b", "c", "d"};
	
	private GroupConnector instance = null;
	private String entity = "test";
	
	
	private MockWireCreator wireCreator  = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		wireCreator = new MockWireCreator();
		instance = new GroupConnector(entity,wireCreator);
		propertiesProducer1 = new HashMap<String,Object>();
		propertiesProducer1.put(Constants.SERVICE_PID, "producer.pid.1");
		propertiesProducer1.put(WireConstants.WIREADMIN_PRODUCER_SCOPE, SCOPE_CONSUMER_1);
		
		propertiesConsumer1 = new HashMap<String,Object>();
		propertiesConsumer1.put(Constants.SERVICE_PID, "consumer.pid.1");
		propertiesConsumer1.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, SCOPE_PRODUCER_1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		instance = null;
		wireCreator = null;
	}

	@Test
	public void testFilter(){
		Integer mask = new Integer( WireAdminEvent.WIRE_CREATED
				|WireAdminEvent.CONSUMER_EXCEPTION
				|WireAdminEvent.PRODUCER_EXCEPTION
				   | WireAdminEvent.WIRE_CONNECTED
				   | WireAdminEvent.WIRE_DISCONNECTED );
		
		assertEquals(new Integer(103),mask);

	}
	
	@Test
	public void testFilter2(){
		Integer mask = new Integer( WireAdminEvent.WIRE_CREATED
				|WireAdminEvent.CONSUMER_EXCEPTION
				|WireAdminEvent.PRODUCER_EXCEPTION
				   | WireAdminEvent.WIRE_CONNECTED
				   | WireAdminEvent.WIRE_DISCONNECTED 
				   | WireAdminEvent.WIRE_UPDATED);
		
		assertEquals(new Integer(111),mask);

	}
	
	
	@Test
	public void testSetSingleProducer() {
		instance.setProducer(propertiesProducer1);
		assertNull(wireCreator.wireParameters);
	}

	
	@Test
	public void testSetSingleConsumer() {
		instance.setConsumer(propertiesConsumer1);
		assertNull(wireCreator.wireParameters);
	}

	
	@Test
	public void testSetProducer() {
		//First add a consumer
		instance.setConsumer(propertiesConsumer1);
		assertNull(wireCreator.wireParameters);
		
		//Now add a producer
		instance.setProducer(propertiesProducer1);
		assertNotNull(wireCreator.wireParameters);
		
		//Add the producer again
		wireCreator.wireParameters = null;
		instance.setProducer(propertiesProducer1);
		assertNull(wireCreator.wireParameters);
		
		//Add the consumer again
		wireCreator.wireParameters = null;
		instance.setConsumer(propertiesConsumer1);
		assertNull(wireCreator.wireParameters);
	}
	
	
	@Test
	public void testSetConsumer() {
		//First add a producer
		instance.setProducer(propertiesProducer1);
		assertNull(wireCreator.wireParameters);
		
		//Now the consumer
		instance.setConsumer(propertiesConsumer1);
		assertNotNull(wireCreator.wireParameters);
		
		//Add the consumer again
		wireCreator.wireParameters = null;
		instance.setConsumer(propertiesConsumer1);
		assertNull(wireCreator.wireParameters);
		
		//Add the producer again
		wireCreator.wireParameters = null;
		instance.setProducer(propertiesProducer1);
		assertNull(wireCreator.wireParameters);
		
		
	}
	/**
	 * Test method for {@link com.verticon.tracker.irouter.wireadmin.GroupConnector#scopeIntersection(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	public void testScopeIntersection() {
		String[] array1 = SCOPE_CONSUMER_1;
		String[] array2 = SCOPE_PRODUCER_1;
		String[] result = GroupConnector.scopeIntersection(array1, array2);
		String[] expected = new String[]{"b", "d"};
		Arrays.sort(result);
		Arrays.sort(expected);
		assertArrayEquals(Arrays.toString(expected)+" but was"+Arrays.toString(result),
				expected, result);
	}

	
	static class MockWireCreator implements IWireCreator{
		WireParameters wireParameters;
		@Override
		public boolean createWire(WireParameters wireParameters) {
			this.wireParameters =wireParameters;
			return true;
		}
		
	}
}
