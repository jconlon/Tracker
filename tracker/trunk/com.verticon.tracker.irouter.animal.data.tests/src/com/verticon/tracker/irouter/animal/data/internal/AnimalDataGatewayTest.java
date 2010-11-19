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
package com.verticon.tracker.irouter.animal.data.internal;

import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.irouter.animal.data.internal.AnimalDataGateway.CONNECTION_URI;
import static com.verticon.tracker.irouter.animal.data.internal.AnimalDataGateway.FIELDS;
import static com.verticon.tracker.irouter.animal.data.internal.AnimalDataGateway.MAPPER;
import static com.verticon.tracker.irouter.animal.data.internal.AnimalDataGateway.REFRESH_SECONDS;
import static com.verticon.tracker.irouter.animal.data.internal.AnimalDataGateway.SERVICE_PID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.io.Resources;

public class AnimalDataGatewayTest {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AnimalDataGatewayTest.class);


	private static final String PLATFORM_RESOURCE_URI = "platform:/resource/com.verticon.tracker.irouter.animal.data.tests/example.premises";
	AnimalDataGateway instance = null;
	MyWire wire = null;
	public static final URL url = Resources.getResource("example.premises");
	public static final ImmutableMap<String, Object> GOOD_CONFIG;

	static {

		GOOD_CONFIG = new ImmutableMap.Builder<String, Object>()
				.put(CONNECTION_URI, url.toString())
				.put(SERVICE_PID, "some.pid")
				.put(REFRESH_SECONDS, Integer.valueOf(33))
				.put(FIELDS, new String[] { "id", "speciesCode" }).build();
	}

	public static final ImmutableMap<String, Object> NULL_URI_CONFIG = new ImmutableMap.Builder<String, Object>()
			// .put(CONNECTION_URI,
			// "platform:/plugin/com.verticon.tracker.irouter.animal.data.tests/example.premises")
			.put(SERVICE_PID, "some.pid")
			.put(REFRESH_SECONDS, Integer.valueOf(33))
			.put(FIELDS, new String[] { "one", "two" }).build();

	public static final ImmutableMap<String, Object> BAD_METADATA_CONFIG = new ImmutableMap.Builder<String, Object>()
			.put(CONNECTION_URI, PLATFORM_RESOURCE_URI)
			.put(SERVICE_PID, "some.pid")
			.put(REFRESH_SECONDS, Integer.valueOf(33)).put(FIELDS, "two")
			.build();

	@Before
	public void setUp() throws Exception {
		instance = new AnimalDataGateway();
		wire = new MyWire();//createMock(Wire.class);
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		wire = null;
	}

	@Test
	public final void testActivateWithGoodConfig() {
		instance.activate(GOOD_CONFIG);
	}

	@Test
	public final void testActivateWithBadConfig() {
		try {
			instance.activate(NULL_URI_CONFIG);
			fail("Should throw exception");
		} catch (IllegalStateException e) {
			assertEquals("connection.uri attribute can not be null or empty",
					e.getMessage());
		}

		try {
			instance.activate(BAD_METADATA_CONFIG);
			fail("Should throw exception");
		} catch (IllegalStateException e) {
			assertEquals("animal.life.data.fields attribute must be an array",
					e.getMessage());
		}
	}

	@Test
	public final void testCallWithoutTransform() throws Exception {
		instance.activate(GOOD_CONFIG);
		List<String> records = instance.call();
		assertNotNull(records);
		assertEquals(5, records.size());
		assertEquals(2,
				Iterables.size((Splitter.on(',').split(records.get(0)))));
		assertEquals("840456789012345,BOV", records.get(4));
	}

	@Test
	public final void testCallWithTransform() throws Exception {
		Map<String, Object> conf = newHashMap();
		conf.put(CONNECTION_URI, url.toString());
		conf.put(SERVICE_PID, "some.pid");
		conf.put(REFRESH_SECONDS, Integer.valueOf(33));
		conf.put(FIELDS, new String[] { "id", "speciesCode", "sexCode" });
		conf.put(MAPPER, new String[] { 
				"speciesCode|BOV|fish",
				"sexCode|M|bull", 
				"sexCode|F|cow" 
		});

		instance.activate(conf);
		List<String> records = instance.call();
		assertNotNull(records);
		assertEquals(5, records.size());
		assertEquals(3,
				Iterables.size((Splitter.on(',').split(records.get(0)))));
		assertEquals("840456789012341,fish,bull", records.get(0));
		assertEquals("840456789012342,fish,cow", records.get(1));
		assertEquals("840456789012343,fish,bull", records.get(2));
		assertEquals("840456789012344,fish,C", records.get(3));
		assertEquals("840456789012345,fish,C", records.get(4));
	}
	
	@Test
	public final void testCallWithTransformAndStatics() throws Exception {
		Map<String, Object> conf = newHashMap();
		conf.put(CONNECTION_URI, url.toString());
		conf.put(SERVICE_PID, "some.pid");
		conf.put(REFRESH_SECONDS, Integer.valueOf(33));
		conf.put(FIELDS, new String[] { "id", "speciesCode", "sexCode" });
		conf.put(MAPPER, new String[] { 
				"speciesCode|BOV|fish",
				"sexCode|M|bull", 
				"sexCode|F|cow",
				"STATIC|1|ONE", 
				"sexCode|F|cow",
				"STATIC|3|THREE",
		});

		instance.activate(conf);
		List<String> records = instance.call();
		assertNotNull(records);
		assertEquals(5, records.size());
		assertEquals(5,
				Iterables.size((Splitter.on(',').split(records.get(0)))));
		assertEquals("ONE,840456789012341,THREE,fish,bull", records.get(0));
		assertEquals("ONE,840456789012342,THREE,fish,cow", records.get(1));
		assertEquals("ONE,840456789012343,THREE,fish,bull", records.get(2));
		assertEquals("ONE,840456789012344,THREE,fish,C", records.get(3));
		assertEquals("ONE,840456789012345,THREE,fish,C", records.get(4));
	}

	@Test
	public final void testConsumersConnectedWithNoWires() throws InterruptedException{
		logger.debug("...............testConsumersConnectedWithNoWires()............");
		instance.activate(GOOD_CONFIG);
		instance.consumersConnected(new Wire[]{});
		Object result = instance.polled(null);
		assertNotNull(result);
		assertTrue(result instanceof List);
		@SuppressWarnings("unchecked")
		List<String> records = (List<String>) result;
		assertTrue(records.isEmpty());
		
		
		
	}
	
	@Test
	public final void testConsumersConnectedWithMock() throws InterruptedException{
		logger.debug("...............testConsumersConnectedWithMock()............");
		instance.activate(GOOD_CONFIG);
		
		instance.consumersConnected(new Wire[]{wire});
		boolean hasValue = wire.latch.await(25, TimeUnit.SECONDS);
		assertTrue("Timed out waiting for the gateway to set a value on the mock wire", hasValue);
		Object  result = wire.value;
		assertNotNull(result);
		assertTrue("Not a list but "+result.getClass().getName(), result instanceof List);
		@SuppressWarnings("unchecked")
		List<String> records = (List<String>) result;
		assertTrue(!records.isEmpty());
		assertEquals(5, records.size());
		assertEquals(2,
				Iterables.size((Splitter.on(',').split(records.get(0)))));
		assertEquals("840456789012345,BOV", records.get(4));
	}
	
	
	@Test
	public final void testURI() {
		URI one = URI.createURI(PLATFORM_RESOURCE_URI);
		URI two = URI.createPlatformResourceURI(
				"com.verticon.tracker.irouter.animal.data.tests", true);
		two = two.appendSegment("example.premises");
		assertEquals(one, two);
	}
	
	
	private static class MyWire implements Wire{
		private static Dictionary<String,String> props = new Hashtable<String, String>();
		static{
			props.put(WireConstants.WIREADMIN_CONSUMER_PID, "mockWire");
		}
		Object value = null;
		CountDownLatch latch = new CountDownLatch(1);
		
		@Override
		public boolean isValid() {
			return false;
		}

		@Override
		public boolean isConnected() {
			return false;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Class[] getFlavors() {
			return null;
		}

		@Override
		public void update(Object value) {
			this.value = value;
//			System.out.println(value);
			latch.countDown();
		}

		@Override
		public Object poll() {
			return null;
		}

		@Override
		public Object getLastValue() {
				return null;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Dictionary getProperties() {
			return props;
		}

		@Override
		public String[] getScope() {
			return null;
		}

		@Override
		public boolean hasScope(String name) {
			return false;
		}
		
	}
}
