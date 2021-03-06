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

package com.verticon.tracker.store.mongodb.test.system;

import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_BI;
import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_REGISTRANT;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI_003ALKMN;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.getXMIResource;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.mongo.IMongoClientProvider;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;

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
public class Test_TrackerStore_Authorization extends TestCase {

	static final String DOC_PREMISES = "example.premises";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerStore_Authorization.class);

	private boolean initializedCollections;

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
	static ITrackerStore trackerStore;
	static IMongoClientProvider iMongoClientProvider;
	static IMockAuthenticatorController mockAuthenticatorController;

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void setTrackerStore(ITrackerStore trackerStore) {
		logger.debug(bundleMarker, "DS injecting the trackerStore");
		Test_TrackerStore_Authorization.trackerStore = trackerStore;
	}

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void unsetTrackerStore(ITrackerStore trackerStore) {
		logger.debug(bundleMarker, "DS injecting the trackerStore");
		Test_TrackerStore_Authorization.trackerStore = null;
	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_TrackerStore_Authorization.iMongoClientProvider = iMongoClientProvider;

	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_TrackerStore_Authorization.iMongoClientProvider = null;

	}

	void setMockAuthenticatorController(
			IMockAuthenticatorController mockAuthenticatorController) {
		Test_TrackerStore_Authorization.mockAuthenticatorController = mockAuthenticatorController;
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
		if (!initializedCollections) {
			initializedCollections = Test_TrackerUpdateAndFind
					.removeDocsFromCollections(true);
		}
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
	}

	void deactivate() {

	}

	/**
	 * Test authorization and set it
	 */
	@Test
	public void test_Register_Authorization() {
		logger.debug(bundleMarker, "starting testRegister_Authorization");
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("URI must be urn:pin:H89234X", premises.getUri(),
				is(PREMISES_URI_H89234X));
		try {
			trackerStore.register(premises);
			fail("Should throw an Security exception.");
		} catch (SecurityException e) {
			assertThat("Failed to detect no authenticated user.",// mockAuthenticatorController.setRoles(Arrays.asList(
					// PREMISES_URI_H89234X, PREMISES_URI_003ALKMN,
					// SERVER,
					// T
					e.getMessage(), is("User is not authenticated."));
		} catch (Exception e) {
			fail("Should throw a Security exception.");
		}

		try {
			trackerStore.recordAnimals(premises);
			fail("Should throw an Security exception.");
		} catch (SecurityException e) {
			assertThat("Failed to detect no authenticated user.",
					e.getMessage(), is("User is not authenticated."));
		} catch (Exception e) {
			fail("Should throw a Security exception.");
		}

		try {
			trackerStore.retrievePremises(PREMISES_URI_H89234X);
			fail("Should throw an Security exception.");
		} catch (SecurityException e) {
			assertThat("Failed to detect no authenticated user.",
					e.getMessage(), is("User is not authenticated."));
		} catch (Exception e) {
			fail("Should throw a Security exception.");
		}
		// Set the mock user
		mockAuthenticatorController.setAuthenticatedUser(true);

		try {
			trackerStore.retrievePremises(PREMISES_URI_H89234X);
			fail("Should throw an Security exception.");
		} catch (SecurityException e) {
			assertThat("User has no authority to retrieve this premises.",
					e.getMessage(),
					is("User has no association authority to access "
							+ PREMISES_URI_H89234X + " premises."));
		} catch (Exception e) {
			fail("Should throw a Security exception.");
		}

		// Set the mock roles
		mockAuthenticatorController.setRoles(Arrays.asList(
				PREMISES_URI_H89234X, PREMISES_URI_003ALKMN, PREMISES_URI,
				TRACKER_STORE_REGISTRANT, TRACKER_STORE_BI));
	}
}
