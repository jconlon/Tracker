package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class WiredNodeTest extends TestCase {

	
	private static final Long SERVICE_ID = new Long(45);
	private static final String[] SCOPE = new String[]{"one","two"};
	private static final String SOME_LABEL = "Some Label";
	ConsumerWiredNode consumer = null;
	ProducerWiredNode producer = null;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		Map<String, Object> sr = new HashMap<String, Object>();
		
		sr.put("tracker.wiring.group.name", "test");
		sr.put("service.pid", "some.pid"); 
		sr.put("wireadmin.consumer.scope", SCOPE);
		sr.put("service.id", SERVICE_ID);
		sr.put("tracker.monitor.label", SOME_LABEL);
		consumer = new ConsumerWiredNode(sr);
		
		sr.remove("wireadmin.consumer.scope");
		sr.put("wireadmin.producer.scope", SCOPE);
		producer = new ProducerWiredNode(sr);
		
	}

	protected void tearDown() throws Exception {
		producer=null;
		consumer=null;
		super.tearDown();
	}

	public final void testHashCode() {
		assertNotSame(producer.hashCode(),consumer.hashCode());
	}

	public final void testNodeText() {
		assertEquals(SOME_LABEL, consumer.getComponentLabel());
		assertEquals(SOME_LABEL, producer.getComponentLabel());
	}

	public final void testEqualsObject() {
		assertFalse(producer.equals(consumer));
		assertFalse(consumer.equals(producer));
	}

	public final void testGetGroup() {
		assertEquals("test", consumer.getGroup());
		assertEquals("test", producer.getGroup());
	}

	public final void testGetPid() {
		assertEquals("some.pid", consumer.getPid());
		assertEquals("some.pid", producer.getPid());
	}

	public final void testGetScope() {
		assertEquals(Arrays.toString(SCOPE), consumer.getScope());
		assertEquals(Arrays.toString(SCOPE), producer.getScope());
	}

	public final void testGetService_id() {
		assertEquals(SERVICE_ID, consumer.getService_id());
		assertEquals(SERVICE_ID, producer.getService_id());
	}

	public final void testGetComponentLabel() {
		assertEquals(SOME_LABEL, consumer.getComponentLabel());
		assertEquals(SOME_LABEL, producer.getComponentLabel());
	}

}
