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

package org.usaha.ecvi.store.mqtt.test.integration;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.usaha.ecvi.store.mqtt.test.integration.Configurator.bundleMarker;
import static org.usaha.ecvi.store.mqtt.test.integration.Configurator.getXMIResource;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usaha.ecvi.DocumentRoot;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.store.IEcviStore;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.verticon.mongo.IMongoClientProvider;

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
public class Test_MqttEcviStoreComponent_1 extends TestCase {
	private static final String ECVI_COLLECTION_NAME = "Ecvi";


	private static final String EXAMPLE1_ECVI = "Example1.ecvi";
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_MqttEcviStoreComponent_1.class);

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
	static IEcviStore ecviStore;

	static IMongoClientProvider iMongoClientProvider;

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_MqttEcviStoreComponent_1.iMongoClientProvider = iMongoClientProvider;

	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_MqttEcviStoreComponent_1.iMongoClientProvider = null;
	}

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void setEcviStore(IEcviStore ecviStore) {
		logger.debug(bundleMarker, "DS injecting the ecviStore");
		Test_MqttEcviStoreComponent_1.ecviStore = ecviStore;
	}

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void unsetEcviStore(IEcviStore ecviStore) {
		logger.debug(bundleMarker, "DS injecting the ecviStore");
		Test_MqttEcviStoreComponent_1.ecviStore = null;
	}


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
		startUpGate.await();// wait for startUp to finish
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
	void activate() {
		startUpGate.countDown();
		logger.debug(bundleMarker, "Activate.");
	}

	void deactivate() {
		logger.debug(bundleMarker, "DeActivated.");
	}

	@Test
	public void test_MqttEcviStoreComponent() throws IOException,
			InterruptedException {
		DBCollection coll = getCollection();
		assertThat("Must have no Ecvi documents", coll.find().count(), is(0));

		// TimeUnit.MINUTES.sleep(4);
		Resource resource = getXMIResource(EXAMPLE1_ECVI, "");
		DocumentRoot documentRoot = (DocumentRoot) resource.getContents()
				.get(0);
		Ecvi ecvi = documentRoot.getECVI();
		ecvi.setCviNumber("testEcviMongoComponent@" + new Date());

		String uri = ecviStore.getURIs().iterator().next();
		System.out.println("URI for provider: " + uri);
		assertThat("URI cannot be null or empty", !isNullOrEmpty(uri));

		ecviStore.record(ecvi, uri);
		assertThat("Must have only 1 Ecvi documents", coll.find().count(),
				is(1));
	}

	private static DBCollection getCollection() {
		MongoClient mongoClient = iMongoClientProvider.getMongoClient();
		DB db = mongoClient.getDB(iMongoClientProvider.getDatabaseName());
		return db.getCollection(ECVI_COLLECTION_NAME);
	}

}
