/*******************************************************************************
 * 
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.mongo.emf.test.system;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.IDatabaseLocator;
import org.eclipselabs.mongo.emf.IDBObjectBuilderFactory;
import org.eclipselabs.mongo.emf.IEObjectBuilderFactory;
import org.eclipselabs.mongo.emf.ext.*;
import org.eclipselabs.mongo.emf.IInputStreamFactory;
import org.eclipselabs.mongo.emf.IOutputStreamFactory;
import org.eclipselabs.mongo.emf.IQueryEngine;
import org.json.MongoQueryStandaloneSetupGenerated;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.verticon.mongo.emf.api.IResourceSetFactory;
import com.verticon.mongo.emf.api.SingleMongoLocator;
import com.verticon.tracker.Tag;

/**
 * 
 * Basic testing of an com.verticon.mongo.emf.api.IResourceSetFactory service
 * and its dependent services. The IResourceSetFactory is the primary access to
 * the MongoEMF infrastructure.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>IQueryEngine - created by the com.verticon.mongo.emf.json.query plugin</li>
 * <li>IMongoLocator - depends on a IMongoProvider which is created by this test
 * plugin</li>
 * <li>IDBObjectBuilder / IEObjectBuilder - created by the
 * com.verticon.mongo.emf plugin</li>
 * <li>IResourceSetFactory - depends on the above services</li>
 * <li>more</li>
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
public class Test_MongoEMF_Minimum_Services extends TestCase {

	static String PLUGIN_ID = "com.verticon.mongo.emf.test.system";

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
			.getLogger(Test_MongoEMF_Minimum_Services.class);

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

	private IDatabaseLocator mongoDatabaseLocator = null;
	/**
	 * Injected services that are not needed by user application
	 */
	static IQueryEngine queryEngine;
	static IDBObjectBuilderFactory dbObjectBuilderFactory;
	static IEObjectBuilderFactory eObjectBuilderFactory;
	static IInputStreamFactory inputStreamFactory;
	static IOutputStreamFactory outputStreamFactory;

	// DS injected service needed by user app
	static IResourceSetFactory resourceSetFactory;

	/**
	 * Injected by ds
	 * 
	 * @param queryEngine
	 */
	public void setQueryEngine(IQueryEngine queryEngine) {
		logger.debug(bundleMarker, "DS injecting the queryEngine");
		Test_MongoEMF_Minimum_Services.queryEngine = queryEngine;
	}

	/**
	 * Injected by ds
	 * 
	 */
	public void setResourceSetFactory(IResourceSetFactory resourceSetFactory) {
		logger.debug(bundleMarker, "DS injecting the resourceSetFactory");
		Test_MongoEMF_Minimum_Services.resourceSetFactory = resourceSetFactory;
	}

	/**
	 * Injected by ds
	 * 
	 */
	public void setDBObjectBuilderFactory(
			IDBObjectBuilderFactory dbObjectBuilderFactory) {
		logger.debug(bundleMarker, "DS injecting the dbObjectBuilderFactory");
		Test_MongoEMF_Minimum_Services.dbObjectBuilderFactory = dbObjectBuilderFactory;
	}

	/**
	 * Injected by ds
	 * 
	 */
	public void setEObjectBuilderFactory(
			IEObjectBuilderFactory eObjectBuilderFactory) {
		logger.debug(bundleMarker, "DS injecting the eObjectBuilderFactory");
		Test_MongoEMF_Minimum_Services.eObjectBuilderFactory = eObjectBuilderFactory;
	}

	/**
	 * Injected by ds
	 * 
	 */
	public void setInputStreamFactory(IInputStreamFactory inputStreamFactory) {
		logger.debug(bundleMarker, "DS injecting the inputStreamFactory");
		Test_MongoEMF_Minimum_Services.inputStreamFactory = inputStreamFactory;
	}

	/**
	 * Injected by ds
	 * 
	 */
	public void setOutputStreamFactory(IOutputStreamFactory outputStreamFactory) {
		logger.debug(bundleMarker, "DS injecting the outputStreamFactory");
		Test_MongoEMF_Minimum_Services.outputStreamFactory = outputStreamFactory;
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
		// logger.debug(
		// bundleMarker,
		// "waiting for declarative services activation startup method to finish");
		startUpGate.await();// wait for startUp to finish

		mongoDatabaseLocator = new SingleMongoLocator("mongodb://localhost", null, null);
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
		// System.out.println(this + ": startup and setUp finished.");
		new MongoQueryStandaloneSetupGenerated()
				.createInjectorAndDoEMFRegistration();
	}

	@Test
	public void testContext() throws InterruptedException {
		logger.debug(bundleMarker, "startTest");
		assertThat("queryEngine must be setup", queryEngine, is(notNullValue()));
	}

	@Test
	public void testDatabaseLocator() throws MongoException, UnknownHostException,
			URISyntaxException {
		logger.debug(bundleMarker, "startTest");

		assertThat("locator  must not be null.", mongoDatabaseLocator,
				is(notNullValue()));
		assertThat("db  must not be null.",
				mongoDatabaseLocator.getDatabase("mongodb://localhost/tracker/"),
				is(notNullValue()));
//		assertThat("mongo  must not be null.",
//				mongoDatabaseLocator.getMongo("mongodb://localhost/tracker/"),
//				is(notNullValue()));

	}

	@Test
	public void testQueryEngine() throws InterruptedException {
		logger.debug(bundleMarker, "startTest");
		String s = "{ 'last_name' : 'Smith' } , { 'test' : 0 }";
		URI query = encode(s);
		DBObject result = queryEngine.buildDBObjectQuery(query)
				.getObjectFilter();
		assertThat("query result must not be null.", result, is(notNullValue()));
		assertThat("must contain a field called last_name",
				result.containsField("last_name"), is(true));
		assertThat("must have a value of Smith", result.get("last_name")
				.toString(), is("Smith"));
	}

	@Test
	public void testGetResource_Tag() {
		logger.debug(bundleMarker, "startTest");
		assertThat("resourceSetFactory  must not be null.", resourceSetFactory,
				is(notNullValue()));
		ResourceSet resourceSet = resourceSetFactory
				.createResourceSet(mongoDatabaseLocator);
		assertThat("resourceSet  must not be null.", resourceSet,
				is(notNullValue()));
		Resource resource = resourceSet.getResource(URI
				.createURI("mongodb://localhost/tracker/Tag/840456789012341"),
				true);

		Tag tag = (Tag) resource.getContents().get(0);
		assertThat("tag  must not be null.", tag, is(notNullValue()));
		assertThat("tag must have correct id", tag.getId(),
				is("840456789012341"));

	}

	@Test
	public void testQuery_Tag() {
		logger.debug(bundleMarker, "startTest");
		assertThat("resourceSetFactory  must not be null.", resourceSetFactory,
				is(notNullValue()));

		ResourceSet resourceSet = resourceSetFactory
				.createResourceSet(mongoDatabaseLocator);
		assertThat("resourceSet  must not be null.", resourceSet,
				is(notNullValue()));

		URI uri = URI.createURI("mongodb://localhost/tracker/Tag/");
		String query = "{ '_id' : '840456789012341' }";
		uri = uri.appendQuery(query);
		Resource resource = resourceSet.getResource(uri, true);
		Object object = resource.getContents().get(0);
		assertThat("object must not be null.", object, is(notNullValue()));
		assertThat("object must be a Result.", object,
				is(instanceOf(ECollection.class)));
		ECollection result = (ECollection) object;

		assertThat("result must have one tag.", result.getValues().size(),
				is(1));
		assertThat("result must be a Tag.", result.getValues().get(0),
				is(instanceOf(Tag.class)));

		Tag tag = (Tag) result.getValues().get(0);
		assertThat("tag  must not be null.", tag, is(notNullValue()));
		assertThat("tag must have correct id", tag.getId(),
				is("840456789012341"));
	}
	
	
	

	// /**
	// * Top of the Tree
	// */
	// @Test
	// public void testSelector() {
	// logger.debug(bundleMarker, "startTest");
	// String s = " { 'last_name' : 'Smith' } , { 'test' : 0 }";
	// URI query = encode(s);
	// DBObject result =
	// queryEngine.buildDBObjectQuery(query).getObjectFilter();
	// assertThat("query result must not be null.", result, is(notNullValue()));
	// assertThat("must contain a field called last_name",
	// result.containsField("last_name"),is(true));
	// assertThat("must have a value of Smith",
	// result.get("last_name").toString(), is("Smith"));
	// }
	//
	//
	// @Test
	// public void testBadSelector() {
	// logger.debug(bundleMarker, "startTest");
	// String s = "id=='985152001389613'";
	//
	// URI query;
	// try {
	// query = encode(s);
	// queryEngine.buildDBObjectQuery(query);
	// fail("Should have thrown an IllegalArgumentException.");
	// } catch (IllegalArgumentException e) {
	//
	// }
	//
	// }
	//
	// @Test
	// public void testQuery_GT() {
	// logger.debug(bundleMarker, "startTest");
	// String s = "{'a': {$gt: 10}}";
	// URI query = encode(s);
	// DBObject result =
	// queryEngine.buildDBObjectQuery(query).getObjectFilter();
	// assertThat("query result must not be null.", result, is(notNullValue()));
	//
	// assertThat("must contain a field called a",
	// result.containsField("a"),is(true));
	// assertThat("must have a value of DBObject", result.get("a"),
	// is(instanceOf(DBObject.class)));
	// result = (DBObject) result.get("a");
	// assertThat("must contain a field called $gt",
	// result.containsField("$gt"),is(true));
	// assertThat("must have a integer", result.get("$gt"),
	// is(instanceOf(Integer.class)));
	// assertThat("must have a value of 10", (Integer) result.get("$gt"),
	// is(10));
	// }
	//
	//
	//
	// @Test
	// public void testQuery_IN_Array() {
	// logger.debug(bundleMarker, "startTest");
	// String s = "{'a': {$in: [10, 'hello']}}";
	// URI query = encode(s);
	// DBObject result =
	// queryEngine.buildDBObjectQuery(query).getObjectFilter();
	// assertThat("query result must not be null.", result, is(notNullValue()));
	//
	// assertThat("must contain a field called a",
	// result.containsField("a"),is(true));
	// assertThat("must have a value of DBObject", result.get("a"),
	// is(instanceOf(DBObject.class)));
	// result = (DBObject) result.get("a");
	// assertThat("must contain a field called $in",
	// result.containsField("$in"),is(true));
	// assertThat("must have a collection", result.get("$in"),
	// is(instanceOf(List.class)));
	// List<?> list = (List<?>)result.get("$in");
	// assertThat("list must have a size of two",list.size(), is(2));
	// assertThat("must be Integer",list.get(0), is(instanceOf(Integer.class)));
	// assertThat("must have a value of 10", (Integer) list.get(0), is(10));
	// assertThat("must be String",list.get(1), is(instanceOf(String.class)));
	// assertThat("must have a value of hello", (String) list.get(1),
	// is("hello"));
	//
	//
	//
	// }
	//
	// @Test
	// public void testQuery_EXISTS_AND_IN_Array() {
	// logger.debug(bundleMarker, "startTest");
	// String s = "{ a : { $exists : true }, b : {$in: [10, 'hello']}  }";
	// URI query = encode(s);
	// DBObject result =
	// queryEngine.buildDBObjectQuery(query).getObjectFilter();
	// assertThat("query result must not be null.", result, is(notNullValue()));
	// //a
	// assertThat("must contain a field called a",
	// result.containsField("a"),is(true));
	// assertThat("must have a value of DBObject", result.get("a"),
	// is(instanceOf(DBObject.class)));
	// DBObject resulta = (DBObject) result.get("a");
	// assertThat("must contain a field called $exists",
	// resulta.containsField("$exists"),is(true));
	// assertThat("must have a collection", resulta.get("$exists").toString(),
	// is("true"));
	//
	// //b
	// assertThat("must contain a field called b",
	// result.containsField("b"),is(true));
	// assertThat("must have a value of DBObject", result.get("b"),
	// is(instanceOf(DBObject.class)));
	// DBObject resultb = (DBObject) result.get("b");
	// assertThat("must contain a field called $in",
	// resultb.containsField("$in"),is(true));
	// assertThat("must have a collection", resultb.get("$in"),
	// is(instanceOf(List.class)));
	// List<?> list = (List<?>)resultb.get("$in");
	// assertThat("list must have a size of two",list.size(), is(2));
	// assertThat("must be Integer",list.get(0), is(instanceOf(Integer.class)));
	// assertThat("must have a value of 10", (Integer) list.get(0), is(10));
	// assertThat("must be String",list.get(1), is(instanceOf(String.class)));
	// assertThat("must have a value of hello", (String) list.get(1),
	// is("hello"));
	// }
	//
	// @Test
	// public void testDBObject_Between(){
	// logger.debug(bundleMarker, "Testing Between DBObject");
	// DBObject result = new BasicDBObject();
	// result.put("a", new BasicDBObject("$gt", 10).append("$lt", 30));
	// logger.debug(bundleMarker, "Result {}",result);
	//
	// assertThat("must contain a field called a",
	// result.containsField("a"),is(true));
	// assertThat("must have a value of DBObject", result.get("a"),
	// is(instanceOf(DBObject.class)));
	// result = (DBObject) result.get("a");
	// //gt
	// assertThat("must contain a field called $gt",
	// result.containsField("$gt"),is(true));
	// assertThat("must have a integer", result.get("$gt"),
	// is(instanceOf(Integer.class)));
	// assertThat("must have a value of 10", (Integer) result.get("$gt"),
	// is(10));
	// //lt
	// assertThat("must contain a field called $lt",
	// result.containsField("$lt"),is(true));
	// assertThat("must have a integer", result.get("$lt"),
	// is(instanceOf(Integer.class)));
	// assertThat("must have a value of 30", (Integer) result.get("$lt"),
	// is(30));
	//
	// }
	//
	// @Test
	// public void testQuery_BETWEEN() {
	// logger.debug(bundleMarker, "Testing Between int range");
	// String s = "{'a': {$gt: 10, $lt: 30}}";
	// URI query = encode(s);
	// DBObject result =
	// queryEngine.buildDBObjectQuery(query).getObjectFilter();
	// assertThat("query result must not be null.", result, is(notNullValue()));
	//
	// assertThat("must contain a field called a",
	// result.containsField("a"),is(true));
	// assertThat("must have a value of DBObject", result.get("a"),
	// is(instanceOf(DBObject.class)));
	// result = (DBObject) result.get("a");
	// //gt
	// assertThat("must contain a field called $gt",
	// result.containsField("$gt"),is(true));
	// assertThat("must have a integer", result.get("$gt"),
	// is(instanceOf(Integer.class)));
	// assertThat("must have a value of 10", (Integer) result.get("$gt"),
	// is(10));
	// //lt
	// assertThat("must contain a field called $lt",
	// result.containsField("$lt"),is(true));
	// assertThat("must have a integer", result.get("$lt"),
	// is(instanceOf(Integer.class)));
	// assertThat("must have a value of 30", (Integer) result.get("$lt"),
	// is(30));
	//
	//
	//
	// }
	//
	// /**
	// * {'events.dateTime' : {$gte :new Date(2010, 02, 01), $lt : new
	// Date(2011, 04, 01)}}
	// */
	// public void testQuery_BetweenDates() {
	// logger.debug(bundleMarker, "Testing between date range");
	// String s =
	// "{'events.dateTime' : {$gte :new Date(2010, 02, 01), $lt : new Date(2011, 04, 01)}}";
	// URI query = encode(s);
	// DBObject result =
	// queryEngine.buildDBObjectQuery(query).getObjectFilter();
	// assertThat("query result must not be null.", result, is(notNullValue()));
	// //$gte
	// assertThat("must contain a field called events.dateTime",
	// result.containsField("events.dateTime"),is(true));
	// assertThat("must have a value of DBObject",
	// result.get("events.dateTime"), is(instanceOf(DBObject.class)));
	// DBObject resulta = (DBObject) result.get("events.dateTime");
	//
	// assertThat("must contain a field called $gte",
	// resulta.containsField("$gte"),is(true));
	// assertThat("must have a Date", resulta.get("$gte"),
	// is(instanceOf(Date.class)));
	// Date date = (Date) resulta.get("$gte");
	//
	// //$lt
	// assertThat("must contain a field called $lt",
	// resulta.containsField("$lt"),is(true));
	// assertThat("must have a value of DBObject", resulta.get("$lt"),
	// is(instanceOf(Date.class)));
	// date = (Date) result.get("$lt");
	//
	//
	// }
	// /**
	// * {'events.loc' :[45, 45]}
	// */
	// @Test
	// public void testGeoLocations(){
	// logger.debug(bundleMarker, "startTest");
	// String s = "{'events.loc' :[45, 45]}";
	// URI query = encode(s);
	// DBObject result =
	// queryEngine.buildDBObjectQuery(query).getObjectFilter();
	// assertThat("query result must not be null.", result, is(notNullValue()));
	//
	//
	// //b
	// assertThat("must contain a field called events.loc",
	// result.containsField("events.loc"),is(true));
	//
	// assertThat("must have a collection", result.get("events.loc"),
	// is(instanceOf(List.class)));
	// List<?> list = (List<?>)result.get("events.loc");
	// assertThat("list must have a size of two",list.size(), is(2));
	// assertThat("must be Integer",list.get(0), is(instanceOf(Integer.class)));
	// assertThat("must have a value of 45", (Integer) list.get(0), is(45));
	// assertThat("must be String",list.get(1), is(instanceOf(Integer.class)));
	// assertThat("must have a value of 45", (Integer) list.get(1), is(45));
	// }
	// /**
	// * Top of the Tree
	// */
	// @Test
	// public void Selector() {
	// testParserRule("{'last_name': 'Smith'}");
	// testParserRule("{last_name: 'Smith'}, {'ssn': 1}");
	// testParserRule("{}, {'thumbnail':0}");
	// testParserRule("{ x : 3, y : 'foo' }");
	// testParserRule("{j: {$ne: 3}, k: {$gt: 10} }");
	// testParserRule("{colors : {$ne : 'red'}}");
	// testParserRule("{ 'field' : { $lte: 'value' } } ");
	// testParserRule("{ 'field' : { $gt: 'value1', $lt: 'value2' } }");
	// testParserRule(" { a: { $all: [ 2, 3 ] } } ");
	// testParserRule("{ a : { $exists : true } }");
	// testParserRule("{ a : { $exists : false } }");
	// testParserRule("{ a : { $mod : [ 2, 10 ] } }");
	// testParserRule("{$or: [{a: 4},{a: 2 }]},{'a.b':1}");
	// }

	private URI encode(String value) {
		URI uri = URI.createURI("dummy:/example.mongoQuery");
		String query = URI.encodeQuery(value, true);
		return uri.appendQuery(query);
	}

}
