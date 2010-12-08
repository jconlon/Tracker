/**
 * 
 */
package com.verticon.tracker.irouter.wireadmin.internal;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Constants;
import org.osgi.service.wireadmin.WireAdminEvent;
import org.osgi.service.wireadmin.WireConstants;

/**
 * 
 * iRouter Producers and Consumers contain properties that aid in the 
 * creation of wires between them.  WireGroup, Consumer_Scope, and Producer_Scope.
 * When WireGroups match and there is a common name between the Consumer 
 * Producer Scopes, then a connection is made.
 * 
 * @author jconlon
 *
 */

public class GroupConnectorTest {

	private Map<String, Object> propertiesProducer1 = null;
	private static final String[] SCOPE_PRODUCER_1 = {"b", "d","e","f"};
	private Map<String, Object> propertiesConsumer1 = null;
	private static final String[] SCOPE_CONSUMER_1 = {"a", "b", "c", "d"};
	
	private GroupConnector instance = null;
	private String wireGroupName = "test";
	
	
	private IWireCreator wireCreator  = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		wireCreator = createMock(IWireCreator.class);//new MockWireCreator();

		instance = new GroupConnector(wireGroupName,wireCreator);
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
	
	/**
	 * Adding a set of producer properties to the GroupConnector
	 * without corresponding consumer properties
	 * the WireCreator will not create any wireParameters
	 */
	@Test
	public void testSetSingleProducer() {
		replay(wireCreator);
		instance.setProducer(propertiesProducer1);
	}

	/**
	 * Adding a consumer to the GroupConnector
	 * by itself the WireCreator will not create
	 * any wireParameters
	 */
	@Test
	public void testSetSingleConsumer() {
		replay(wireCreator);
		instance.setConsumer(propertiesConsumer1);
	}

	
	@Test
	public void testSetProducer() {
		expect(wireCreator.handleWire(isA(WireParameters.class))).andReturn(true);
		replay(wireCreator);

		//First add a consumer
		instance.setConsumer(propertiesConsumer1);
		
		//Now add a producer
		instance.setProducer(propertiesProducer1);
		
		//Add the producer again
		instance.setProducer(propertiesProducer1);
		
		//Add the consumer again
		instance.setConsumer(propertiesConsumer1);
		verify(wireCreator);
	}
	
	
	@Test
	public void testSetConsumer() {
		expect(wireCreator.handleWire(isA(WireParameters.class))).andReturn(true);
		replay(wireCreator);
		//First add a producer
		instance.setProducer(propertiesProducer1);
		
		//Now the consumer
		instance.setConsumer(propertiesConsumer1);
		
		//Add the consumer again
		instance.setConsumer(propertiesConsumer1);
		
		//Add the producer again
		instance.setProducer(propertiesProducer1);
		verify(wireCreator);
	}
	/**
	 * Test method for {@link com.verticon.tracker.irouter.wireadmin.internal.GroupConnector#scopeIntersection(java.lang.String[], java.lang.String[])}.
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

	
//	private static class MockWireCreator implements IWireCreator{
//		WireParameters wireParameters;
//		@Override
//		public boolean createWire(WireParameters wireParameters) {
//			this.wireParameters =wireParameters;
//			return true;
//		}
//		
//	}
}
