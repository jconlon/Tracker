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

package com.verticon.mongo.emf.json.query.test.system;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.mongo.emf.IQueryEngine;
import org.json.MongoQueryStandaloneSetupGenerated;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * 
 * Basic testing of the QueryEngine in the com.verticon.mongo.emf.json.query
 * feature component that builds MongoEMF queries to retrieve documents from a
 * MongoDB.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>IQueryEngine</li>
 * </ol>
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the ITrackerStore. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * 
 * @author jconlon
 * 
 */
public class Test_Query extends TestCase {

	static String PLUGIN_ID = "com.verticon.mongo.emf.json.query.test.system";

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
	private final Logger logger = LoggerFactory.getLogger(Test_Query.class);

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
	 * Injected services
	 */
	static IQueryEngine queryEngine;

	/**
	 * Injected by ds
	 * 
	 * @param queryEngine
	 */
	public void setQueryEngine(IQueryEngine queryEngine) {
		logger.debug(bundleMarker, "DS injecting the queryEngine");
		Test_Query.queryEngine = queryEngine;
	}

	/**
	 * 
	 * Called by the test framework to setup the test case. This method will
	 * block at a startupGate waiting for the ITrackerStore service under test
	 * to be injected by DS.
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		startUpGate.await();// wait for startUp to finish
		// Register the XText injector infrastructure
		new MongoQueryStandaloneSetupGenerated()
				.createInjectorAndDoEMFRegistration();
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
	 */
	public void startup() {
		startUpGate.countDown();

	}

	@Test
	public void testContext() throws InterruptedException {
		logger.debug(bundleMarker, "startTest");
		assertThat("queryEngine must be setup", queryEngine, is(notNullValue()));
	}

	/**
	 * Top of the Tree
	 */
	@Test
	public void testSelector() {
		logger.debug(bundleMarker, "startTest");
		String s = " { 'last_name' : 'Smith' } , { 'test' : 0, 'fish':1 }";
		URI query = encode(s);
		// ObjectFilter
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));
		assertThat("must contain a field called last_name",
				result.containsField("last_name"), is(true));
		assertThat("must have a value of Smith", result.get("last_name")
				.toString(), is("Smith"));

		// FieldFilter
		result = queryEngine.buildDBObjectQuery(query).getFieldFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));
		assertThat("must contain a field called test",
				result.containsField("test"), is(true));
		assertThat("must have a value of 0", result.get("test"),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 0", (Integer) result.get("test"),
				is(0));

		assertThat("must contain a field called fish",
				result.containsField("fish"), is(true));
		assertThat("must have a value of 1", result.get("fish"),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 1", (Integer) result.get("fish"),
				is(1));
	}

	@Test
	public void testBadSelector() {
		logger.debug(bundleMarker, "startTest");
		String s = "id=='985152001389613'";

		URI query;
		try {
			query = encode(s);
			queryEngine.buildDBObjectQuery(query);
			fail("Should have thrown an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {

		}

	}
	
	/**
	 * Top of the Tree
	 */
	@Test
	public void testSelectorWithDouble() {
		logger.debug(bundleMarker, "startTest");
		String s = " { 'test' : -90.95674265545253} ";
		URI query = encode(s);
		// ObjectFilter
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));
		assertThat("must contain a field called test",
				result.containsField("test"), is(true));
		assertThat("must have a double", result.get("test"), 
				is(instanceOf(Double.class)));
		assertThat("must have a value of -90.95674265545253", (Double) result.get("test"),
				is(-90.95674265545253d));
	}
	
	/**
	 * Top of the Tree
	 */
	@Test
	public void testSelectorWithInt() {
		logger.debug(bundleMarker, "startTest");
		String s = " { 'last_name' : 10} ";
		URI query = encode(s);
		// ObjectFilter
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));
		assertThat("must contain a field called last_name",
				result.containsField("last_name"), is(true));
		assertThat("must have a value of 10", result.get("last_name"), 
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 1", (Integer) result.get("last_name"),
				is(10));
	}

	@Test
	public void testQuery_GT() {
		logger.debug(bundleMarker, "startTest");
		String s = "{'a': {$gt: 10}}";
		URI query = encode(s);
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));

		assertThat("must contain a field called a", result.containsField("a"),
				is(true));
		assertThat("must have a value of DBObject", result.get("a"),
				is(instanceOf(DBObject.class)));
		result = (DBObject) result.get("a");
		assertThat("must contain a field called $gt",
				result.containsField("$gt"), is(true));
		assertThat("must have a integer", result.get("$gt"),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 10", (Integer) result.get("$gt"),
				is(10));
	}

	@Test
	public void testQuery_IN_Array() {
		logger.debug(bundleMarker, "startTest");
		String s = "{'a': {$in: [10, 'hello']}}";
		URI query = encode(s);
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));

		assertThat("must contain a field called a", result.containsField("a"),
				is(true));
		assertThat("must have a value of DBObject", result.get("a"),
				is(instanceOf(DBObject.class)));
		result = (DBObject) result.get("a");
		assertThat("must contain a field called $in",
				result.containsField("$in"), is(true));
		assertThat("must have a collection", result.get("$in"),
				is(instanceOf(List.class)));
		List<?> list = (List<?>) result.get("$in");
		assertThat("list must have a size of two", list.size(), is(2));
		assertThat("must be Integer", list.get(0),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 10", (Integer) list.get(0), is(10));
		assertThat("must be String", list.get(1), is(instanceOf(String.class)));
		assertThat("must have a value of hello", (String) list.get(1),
				is("hello"));

	}

	@Test
	public void testQuery_EXISTS_AND_IN_Array() {
		logger.debug(bundleMarker, "startTest");
		String s = "{ a : { $exists : true }, b : {$in: [10, 'hello']}  }";
		URI query = encode(s);
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));
		// a
		assertThat("must contain a field called a", result.containsField("a"),
				is(true));
		assertThat("must have a value of DBObject", result.get("a"),
				is(instanceOf(DBObject.class)));
		DBObject resulta = (DBObject) result.get("a");
		assertThat("must contain a field called $exists",
				resulta.containsField("$exists"), is(true));
		assertThat("must have a collection", resulta.get("$exists").toString(),
				is("true"));

		// b
		assertThat("must contain a field called b", result.containsField("b"),
				is(true));
		assertThat("must have a value of DBObject", result.get("b"),
				is(instanceOf(DBObject.class)));
		DBObject resultb = (DBObject) result.get("b");
		assertThat("must contain a field called $in",
				resultb.containsField("$in"), is(true));
		assertThat("must have a collection", resultb.get("$in"),
				is(instanceOf(List.class)));
		List<?> list = (List<?>) resultb.get("$in");
		assertThat("list must have a size of two", list.size(), is(2));
		assertThat("must be Integer", list.get(0),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 10", (Integer) list.get(0), is(10));
		assertThat("must be String", list.get(1), is(instanceOf(String.class)));
		assertThat("must have a value of hello", (String) list.get(1),
				is("hello"));
	}

	@Test
	public void testDBObject_Between() {
		logger.debug(bundleMarker, "Testing Between DBObject");
		DBObject result = new BasicDBObject();
		result.put("a", new BasicDBObject("$gt", 10).append("$lt", 30));
		logger.debug(bundleMarker, "Result {}", result);

		assertThat("must contain a field called a", result.containsField("a"),
				is(true));
		assertThat("must have a value of DBObject", result.get("a"),
				is(instanceOf(DBObject.class)));
		result = (DBObject) result.get("a");
		// gt
		assertThat("must contain a field called $gt",
				result.containsField("$gt"), is(true));
		assertThat("must have a integer", result.get("$gt"),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 10", (Integer) result.get("$gt"),
				is(10));
		// lt
		assertThat("must contain a field called $lt",
				result.containsField("$lt"), is(true));
		assertThat("must have a integer", result.get("$lt"),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 30", (Integer) result.get("$lt"),
				is(30));

	}

	@Test
	public void testQuery_BETWEEN() {
		logger.debug(bundleMarker, "Testing Between int range");
		String s = "{'a': {$gt: 10, $lt: 30}}";
		URI query = encode(s);
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));

		assertThat("must contain a field called a", result.containsField("a"),
				is(true));
		assertThat("must have a value of DBObject", result.get("a"),
				is(instanceOf(DBObject.class)));
		result = (DBObject) result.get("a");
		// gt
		assertThat("must contain a field called $gt",
				result.containsField("$gt"), is(true));
		assertThat("must have a integer", result.get("$gt"),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 10", (Integer) result.get("$gt"),
				is(10));
		// lt
		assertThat("must contain a field called $lt",
				result.containsField("$lt"), is(true));
		assertThat("must have a integer", result.get("$lt"),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 30", (Integer) result.get("$lt"),
				is(30));

	}

	/**
	 * {'events.dateTime' : {$gte :new Date(2010, 02, 01), $lt : new Date(2011,
	 * 04, 01)}}
	 */
	public void testQuery_BetweenDates() {
		logger.debug(bundleMarker, "Testing between date range");
		String s = "{'events.dateTime' : {$gte :new Date(2010, 02, 01), $lt : new Date(2011, 04, 01)}}";
		URI query = encode(s);
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));
		// $gte
		assertThat("must contain a field called events.dateTime",
				result.containsField("events.dateTime"), is(true));
		assertThat("must have a value of DBObject",
				result.get("events.dateTime"), is(instanceOf(DBObject.class)));
		DBObject resulta = (DBObject) result.get("events.dateTime");

		assertThat("must contain a field called $gte",
				resulta.containsField("$gte"), is(true));
		assertThat("must have a Date", resulta.get("$gte"),
				is(instanceOf(Date.class)));
		Date date = (Date) resulta.get("$gte");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		assertThat("Year must be 2010", c.get(Calendar.YEAR), is(2010));

		// $lt
		assertThat("must contain a field called $lt",
				resulta.containsField("$lt"), is(true));
		assertThat("must have a value of date", resulta.get("$lt"),
				is(instanceOf(Date.class)));
		date = (Date) resulta.get("$lt");
		c.setTime(date);
		assertThat("Year must be 2011", c.get(Calendar.YEAR), is(2011));
	}

	/**
	 * {'events.loc' :[45, 45]}
	 */
	@Test
	public void testGeoLocations() {
		logger.debug(bundleMarker, "startTest");
		String s = "{'events.loc' :[45, 45]}";
		URI query = encode(s);
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));

		// b
		assertThat("must contain a field called events.loc",
				result.containsField("events.loc"), is(true));

		assertThat("must have a collection", result.get("events.loc"),
				is(instanceOf(List.class)));
		List<?> list = (List<?>) result.get("events.loc");
		assertThat("list must have a size of two", list.size(), is(2));
		assertThat("must be Integer", list.get(0),
				is(instanceOf(Integer.class)));
		assertThat("must have a value of 45", (Integer) list.get(0), is(45));
		assertThat("must be String", list.get(1), is(instanceOf(Integer.class)));
		assertThat("must have a value of 45", (Integer) list.get(1), is(45));
	}
	
	/**
	 * {'events.loc' :[45, 45]}
	 */
	@Test
	public void testGeoLocations_Doubles() {
		logger.debug(bundleMarker, "startTest");
//		String s = "{'events.loc' :[45, 45]}";
		String s = "{'loc' :[-90.95674265545253, 43.47493314332049]}";
		URI query = encode(s);
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));

		// b
		assertThat("must contain a field called loc",
				result.containsField("loc"), is(true));

		assertThat("must have a collection", result.get("loc"),
				is(instanceOf(List.class)));
		List<?> list = (List<?>) result.get("loc");
		assertThat("list must have a size of two", list.size(), is(2));
		assertThat("must be Double", list.get(0),
				is(instanceOf(Double.class)));
		assertThat("must have a value of -90.95674265545253", (Double) list.get(0), is(-90.95674265545253));
		assertThat("must be String", list.get(1), is(instanceOf(Double.class)));
		assertThat("must have a value of 43.47493314332049", (Double) list.get(1), is(43.47493314332049));
	}

	private URI encode(String value) {
		URI uri = URI.createURI("dummy:/example.mongoQuery");
		String query = URI.encodeQuery(value, true);
		return uri.appendQuery(query);
	}

}
