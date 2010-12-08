package com.verticon.tracker.irouter.monitor.view.internal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExternalNodeTest {

	Map<String, Object> sr = null;
	
	@Before
	public void setUp() throws Exception {
		sr = new HashMap<String, Object>();
		sr.put("service.factoryPid","com.verticon.tracker.irouter.monitor.external");
		sr.put("component.name","com.verticon.tracker.irouter.monitor.external");
		sr.put("tracker.wiring.group.name","test");
		sr.put("objectClass","[Ljava.lang.String;@39da8a");
		sr.put("tracker.monitor.label","Measurement Trigger");
		sr.put("external.name","Mettler Balance");
		sr.put("external.location","Here");
		sr.put("service.pid",
				"com.verticon.tracker.irouter.monitor.external-1288636163493-0");
		sr.put("external.descritpion","Description of device or service.");
		sr.put("external.service.type","sensor");
		sr.put("service.id",98l);
		sr.put("external.connection.uri","socket://localhost:2345");
		sr.put("component.id",6);
	}

	@After
	public void tearDown() throws Exception {
		sr.clear();
		sr = null;
	}

	@Test
	public final void testGetInstance() {
		IExternalNode ex = ExternalNodeUtils.getInstance(sr);
		assertNotNull(ex);
		
	}

	@Test
	public final void testGetParent() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetSimpleName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetImage() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDispose() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetConnectionURI() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetText() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetGroup() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetPid() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetService_id() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testEquals() {
		fail("Not yet implemented"); // TODO
	}

}
