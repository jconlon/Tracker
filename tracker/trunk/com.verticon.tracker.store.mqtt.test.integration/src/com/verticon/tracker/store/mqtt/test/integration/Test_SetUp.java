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

package com.verticon.tracker.store.mqtt.test.integration;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * 
 * Basic testing of an com.verticon.tracker.store.mongodb service and its
 * dependent services.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>IMongoClientProvider</li>
 * <li>IFunctionProvider</li>
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
public class Test_SetUp extends TestCase {

	static final String DOC_PREMISES = "example.premises";

	private MongoClient mongoClient = null;
	private DB database = null;

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Test_SetUp.class);


	/**
	 * 
	 * Called by the test framework to setup the test case. This method will
	 * block at a startupGate waiting for the ITrackerStore service under test
	 * to be injected by DS.
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String host = Configurator.localProps
				.getProperty("mongo.connection.uri");
		String db = Configurator.localProps.getProperty("dbname");
		mongoClient = new MongoClient(host);
		database = mongoClient.getDB(db);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		database = null;
		mongoClient.close();
		mongoClient = null;
	}



	

	@Test
	public void testRemoveDocsFromCollections() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		DBObject find = new BasicDBObject();
		DBCollection coll = database.getCollection("Animal");
		coll.remove(find);
		coll = database.getCollection("Premises");
		coll.remove(find);
		coll = database.getCollection("OCD");
		coll.remove(find);
		coll = database.getCollection("Tag");
		coll.remove(find);
		coll = database.getCollection("Updates");
		coll.remove(find);
		// Insert an update
		Calendar cal1 = new GregorianCalendar(2008, 01, 01);
		DBObject dbo = new BasicDBObject("update", cal1.getTime()).append(
				"uri", "12345");
		coll.insert(dbo);
	}



}
