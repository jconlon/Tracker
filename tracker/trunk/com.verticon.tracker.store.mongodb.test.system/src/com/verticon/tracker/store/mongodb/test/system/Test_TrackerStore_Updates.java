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

package com.verticon.tracker.store.mongodb.test.system;

import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_BI;
import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_REGISTRANT;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI_003ALKMN;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.TAG_COLLECTION;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.UPDATES_COLLECTION;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.eventCount;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.getXMIResource;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.removeLastModificationTimesOnAllResources;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoException;
import com.verticon.location.Location;
import com.verticon.mongo.IMongoClientProvider;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;
import com.yammer.metrics.Timer;

/**
 * Advanced testing of periodic updating and retrieval functionality of the the
 * com.verticon.tracker.store.mongo component and its primary class
 * TrackerStore. The c.v.t.store.mongo.TrackerStore provides Tracker Desktop
 * users the functionality to save and retrieve Tracker elements to/from a
 * MongoDB.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>ITrackerStore</li>
 * <li>ConfigurationAdmin</li>
 * </ol>
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the ITrackerStore. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used. Pizza Amore
 * 
 * @author jconlon
 * 
 */
public class Test_TrackerStore_Updates extends TestCase {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerStore_Updates.class);

	/**
	 * To synchronize the DS and JUnit initializations, this latch will wait for
	 * 1. this bundles startup method to be called which means that the
	 * ITrackerStore and Monitorable services injected from the class under test
	 * TrackerStoreImpl 2. For the wireadmin to connect the Producer service
	 * offered by this class to the Consumer service offered by the
	 * TrackerStoreImpl.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private static boolean initializedCollections = false;
	/**
	 * Injected services
	 */
	static ITrackerStore trackerStore;
	static IMongoClientProvider iMongoClientProvider;
	static IMockAuthenticatorController mockAuthenticatorController;

	/**
	 * Set of tag ids that will be assigned to Premises animals persisted to
	 * MongoDB
	 * 
	 */
	static final String AIN_1 = "tag1";
	static final String AIN_2 = "tag2";
	private static final String DOC_PREMISES_4_11 = "4-11-2008-test.data.premises";
	private static final String DOC_PREMISES_4_12 = "4-12-2008-test.data.premises";
	private static final String DOC_PREMISES_5_16 = "5-16-2008-test.data.premises";
	private static final String DOC_PREMISES_5_17 = "5-17-2008-test.data.premises";
	private static final String DOC_PREMISES_9_10 = "9-10-2008-test.data.premises";
	private static final String DOC_PREMISES_9_14 = "9-14-2008-test.data.premises";
	private static final String DOC_PREMISES_9_15 = "9-15-2008-test.data.premises";

	DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void unsetTrackerStore(ITrackerStore trackerStore) {
		logger.debug(bundleMarker, "DS injecting the trackerStore");
		Test_TrackerStore.trackerStore = null;
	}

	/**
	 * Injected by ds
	 * 
	 * @param trackerStore
	 */
	public void setTrackerStore(ITrackerStore trackerStore) {
		logger.debug(bundleMarker, "DS injecting the trackerStore");
		Test_TrackerStore_Updates.trackerStore = trackerStore;
	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_TrackerStore_Updates.iMongoClientProvider = iMongoClientProvider;

	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_TrackerStore_Updates.iMongoClientProvider = null;

	}

	void setMockAuthenticatorController(
			IMockAuthenticatorController mockAuthenticatorController) {
		Test_TrackerStore_Updates.mockAuthenticatorController = mockAuthenticatorController;
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
					.removeDocsFromCollections(false);
			// insureIndexes();
			register_Authorization();
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
	 * @param context
	 */
	public void startup(BundleContext context) {

		startUpGate.countDown();

	}

	/**
	 * On activation of this component this method is called.
	 * 
	 */
	void activate() {
		startUpGate.countDown();
		Metrics.activate();

	}

	void deactivate() {
		Metrics.deactivate();
	}

	public void testRemoveMembersUpdate() throws UnknownHostException,
			MongoException {
		removeLastModificationTimesOnAllResources(Test_TrackerUpdateAndFind
				.getCollection(UPDATES_COLLECTION));
		// // Set the mock user
		// mockAuthenticatorController.setAuthenticatedUser(true);
		// mockAuthenticatorController.setRoles(Arrays.asList(
		// PREMISES_URI_H89234X, PREMISES_URI_003ALKMN, SERVER,
		// TRACKER_STORE_REGISTRANT, TRACKER_STORE_BI));
	}

	public void testRegister() throws IOException {
		logger.debug(bundleMarker, "starting testRegister");
		Resource resource = getXMIResource(DOC_PREMISES_4_11, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);

		assertThat("URI must be " + PREMISES_URI_003ALKMN, premises.getUri(),
				is(PREMISES_URI_003ALKMN));

		assertThat("Premises must have 72 animalsl", premises.getAnimals()
				.size(), is(72));
		assertThat("Premises not enough events",
				premises.eventHistory().size(), is(289));

		Location location = premises.getLocation();

		assertThat("Logitude is -90.887591", location.getLongitude(),
				is(-90.887591));

		assertThat("Latitude is 43.565265", location.getLatitude(),
				is(43.565265));

		assertThat("Altitude is 0.1", location.getAltitude(), is(0.1));

		register(premises);

		Premises retrievedPremises = trackerStore.retrievePremises(
				PREMISES_URI_003ALKMN, null, null);
		assertThat("Retrieved Premises must not be null.", retrievedPremises,
				is(notNullValue()));
		assertThat("Premises eventHistory must be empty", retrievedPremises
				.eventHistory().isEmpty(), is(true));
	}

	/**
	 * Add 72 animals
	 * 
	 * @throws IOException
	 */
	public void testRecord_4_11() throws IOException {
		Resource resource = getXMIResource(DOC_PREMISES_4_11, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 72 animalsl", premises.getAnimals()
				.size(), is(72));
		assertThat("Premises must have 289 events", premises.eventHistory()
				.size(), is(289));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		IUpdateStats stats = recordAnimals(premises);

		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 72 animalsl", premises
				.getAnimals().size(), is(72));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat("Must have processed all 72 animals.",
				stats.getAnimalsProcessed(), is(premises.getAnimals().size()));

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));

		assertThat("Must have added all the animals.", stats.getAnimalsAdded(),
				is(premises.getAnimals().size()));

		int tags = 0;
		for (Animal animal : premises.getAnimals()) {
			tags = tags + animal.getTags().size();
		}

		assertThat("Must have added all the tags.", stats.getTagsAdded(),
				is(tags));
		assertThat("Must have added same  events.", stats.getEventsAdded(),
				is(289));

		countEvents(289);
	}

	/**
	 * 72 existing plus 37 animals more = 109 animals
	 * 
	 * @throws IOException
	 */
	public void testRecord_4_12() throws IOException {

		Resource resource = getXMIResource(DOC_PREMISES_4_12, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 109 animalsl", premises.getAnimals()
				.size(), is(109));
		assertThat("Premises must have 438 events", premises.eventHistory()
				.size(), is(438));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		IUpdateStats stats = recordAnimals(premises);

		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 109 animalsl", premises
				.getAnimals().size(), is(109));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat("Must have processed 109 -72 = 37 animals. ",
				stats.getAnimalsProcessed(), is(37));

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));

		assertThat("Must have added 109 -72 = 37 animals.",
				stats.getAnimalsAdded(), is(37));

		assertThat("Must have added all the tags plus one.",
				stats.getTagsAdded(), is(38));
		assertThat("Must have added 438  events.", stats.getEventsAdded(),
				is(438 - 289));

		countEvents(438);

	}

	/**
	 * 109 existing animals + 94 more = 203
	 * 
	 * @throws IOException
	 */
	public void testRecord_5_16() throws IOException {

		Resource resource = getXMIResource(DOC_PREMISES_5_16, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 203 animalsl", premises.getAnimals()
				.size(), is(203));
		assertThat("Premises must have 814 events", premises.eventHistory()
				.size(), is(814));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		IUpdateStats stats = recordAnimals(premises);

		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 203 animalsl", premises
				.getAnimals().size(), is(203));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat("Must have processed 203 - 109 = 94 animals. ",
				stats.getAnimalsProcessed(), is(203 - 109));

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));

		assertThat("Must have added 203 - 109 = 94 animals.",
				stats.getAnimalsAdded(), is(94));
		assertThat("Must have added " + (814 - 438) + "  events.",
				stats.getEventsAdded(), is(814 - 438));
		countEvents(814);

	}

	/**
	 * 203 existing + 123
	 * 
	 * @throws IOException
	 */
	public void testRecord_5_17() throws IOException {
		Resource resource = getXMIResource(DOC_PREMISES_5_17, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 326 animalsl", premises.getAnimals()
				.size(), is(326));
		assertThat("Premises must have 1306 events", premises.eventHistory()
				.size(), is(1306));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		IUpdateStats stats = recordAnimals(premises);

		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 326 animalsl", premises
				.getAnimals().size(), is(326));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat("Must have processed 326 - 203 = 123 animals. ",
				stats.getAnimalsProcessed(), is(123));

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));

		assertThat("Must have added 326 - 203 = 123 animals.",
				stats.getAnimalsAdded(), is(123));
		assertThat("Must have added " + (1306 - 814) + "  events.",
				stats.getEventsAdded(), is(1306 - 814));
		countEvents(1306);

	}

	public void testRecord_9_10() throws IOException, InterruptedException {

		Resource resource = getXMIResource(DOC_PREMISES_9_10, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 326 animalsl", premises.getAnimals()
				.size(), is(326));
		assertThat("Premises must have 1733 events", premises.eventHistory()
				.size(), is(1733));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		IUpdateStats stats = recordAnimals(premises);

		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 326 animalsl", premises
				.getAnimals().size(), is(326));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed out of 326 previous animals 213 animals. ",
				stats.getAnimalsProcessed(), is(213));

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));

		assertThat("Must have added no animals.", stats.getAnimalsAdded(),
				is(0));

		assertThat("Must have added 5 tag.", stats.getTagsAdded(), is(5));

		assertThat("Must have added " + 427 + "  events.",
				stats.getEventsAdded(), is(427));

		countEvents(1733);

	}

	public void testRecord_9_14() throws IOException {

		Resource resource = getXMIResource(DOC_PREMISES_9_14, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 326 animalsl", premises.getAnimals()
				.size(), is(326));
		assertThat("Premises must have 1913 events", premises.eventHistory()
				.size(), is(1913));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		IUpdateStats stats = recordAnimals(premises);

		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 326 animalsl", premises
				.getAnimals().size(), is(326));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed out of 326 previous animals 180 animals. ",
				stats.getAnimalsProcessed(), is(180));

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));

		assertThat("Must have added no animals.", stats.getAnimalsAdded(),
				is(0));

		countEvents(1913);
	}

	public void testRecord_9_15() throws IOException {

		Resource resource = getXMIResource(DOC_PREMISES_9_15, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 326 animalsl", premises.getAnimals()
				.size(), is(326));
		assertThat("Premises must have 1948 events", premises.eventHistory()
				.size(), is(1948));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		IUpdateStats stats = recordAnimals(premises);

		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 326 animalsl", premises
				.getAnimals().size(), is(326));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed out of 326 previous animals 180 animals. ",
				stats.getAnimalsProcessed(), is(35));

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));

		assertThat("Must have added no animals.", stats.getAnimalsAdded(),
				is(0));

		countEvents(1948);

	}

	private void countEvents(int count) throws UnknownHostException {

		int events = eventCount(
				Test_TrackerUpdateAndFind.getCollection(TAG_COLLECTION),
				PREMISES_URI_003ALKMN);
		assertThat(events, is(count));
	}

	private void register_Authorization() {

		// Set the mock user
		mockAuthenticatorController.setAuthenticatedUser(true);

		// Set the mock roles
		mockAuthenticatorController.setRoles(Arrays.asList(
				PREMISES_URI_H89234X, PREMISES_URI_003ALKMN, PREMISES_URI,
				TRACKER_STORE_REGISTRANT, TRACKER_STORE_BI));
	}

	private void register(Premises premises) throws IOException {

		final Timer.Context context = Metrics.registrationTimer.time();
		try {
			trackerStore.register(premises);
		} finally {
			context.stop();
		}
	}

	private IUpdateStats recordAnimals(Premises premises) throws IOException {
		IUpdateStats result = null;
		final Timer.Context context = Metrics.recordTimer.time();
		try {
			result = trackerStore.recordAnimals(premises);
		} finally {
			context.stop();
		}

		return result;
	}

}
