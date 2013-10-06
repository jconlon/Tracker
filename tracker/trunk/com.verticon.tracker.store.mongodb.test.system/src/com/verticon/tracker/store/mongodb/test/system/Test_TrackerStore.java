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

import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.UPDATES_COLLECTION;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.getXMIResource;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.verticon.location.Location;
import com.verticon.location.LocationFactory;
import com.verticon.mongo.IMongoClientProvider;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;
import com.yammer.metrics.Timer;

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
public class Test_TrackerStore extends TestCase {

	private static final int NUMBER_OF_ITERATIONS = 1;

	private static final String TAG_ID_1 = "1234567890";

	static final String DOC_PREMISES = "example.premises";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerStore.class);

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

	private static boolean initializedCollections = false;
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
		Test_TrackerStore.trackerStore = trackerStore;
	}

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
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_TrackerStore.iMongoClientProvider = iMongoClientProvider;

	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_TrackerStore.iMongoClientProvider = null;

	}

	void setMockAuthenticatorController(
			IMockAuthenticatorController mockAuthenticatorController) {
		Test_TrackerStore.mockAuthenticatorController = mockAuthenticatorController;
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
			removeDocsFromCollections();
			// insureIndexes();
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
		Metrics.activate();
	}

	void deactivate() {
		Metrics.deactivate();
	}

	@Test
	public void test_TrackerUpdate_RegisterPremises_withSimpleDocument()
			throws IOException {
		Premises premises = createPremises();
		premises.setName("Jack Condor");
		Animal animal = createAnimal();
		premises.getAnimals().add(animal);
		register(premises);
	}

	@Test
	public void test_TrackerUpdate__Register_withComplexDocument()
			throws IOException, InterruptedException {
		logger.debug(bundleMarker, "starting");
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		register(premises);
		logger.debug("done");
	}

	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void test_TrackerUpdate__RegisterMultiplePremises()
			throws IOException, InterruptedException {
		logger.debug(bundleMarker, "starting testRegister");

		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);

		// logger.info(bundleMarker, "Registering {}", premises);

		String uri = premises.getUri() + '_';
		for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
			premises.setUri(uri + i);
			premises.getLocation().setLatitude(
					premises.getLocation().getLatitude() + i + 1);
			register(premises);
		}
		TimeUnit.SECONDS.sleep(3);
		logger.debug("done");
	}

	@Test
	public void test_TrackerUpdate_recordAnimals_Simple() throws IOException {
		Premises premises = createPremises();
		premises.setName("Jack Sprat");
		Animal animal = createAnimal();
		premises.getAnimals().add(animal);
		IUpdateStats stats = recordAnimals(premises);

		assertThat("Must have processed  one animal  animals. ",
				stats.getAnimalsProcessed(), is(1));

		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));

		assertThat("Must have added 1 animals.", stats.getAnimalsAdded(), is(1));
		assertThat("Incorrect number of tags", stats.getTagsAdded(), is(1));
		assertThat("Incorrect number of events", stats.getTagsAdded(), is(1));

		DBCollection coll = getCollection(UPDATES_COLLECTION);
		assertThat("Must have only 1 Updates",
				coll.find(new BasicDBObject("uri", premises.getUri())).count(),
				is(1));
	}

	@Test
	public void test_TrackerUpdate_recordAnimals() throws IOException,
			InterruptedException {
		logger.debug(bundleMarker, "starting");
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);

		IUpdateStats stats = recordAnimals(premises);
		assertThat("Incorrect number of animals", stats.getAnimalsProcessed(),
				is(7));
		assertThat(
				"Must have no exceptions. But got these: "
						+ stats.getExceptions(), stats.getExceptions().size(),
				is(0));
		assertThat("Incorrect number of animals", stats.getAnimalsAdded(),
				is(7));
		assertThat("Incorrect number of tags", stats.getTagsAdded(), is(7));
		assertThat("Incorrect number of events", stats.getEventsAdded(),
				is(premises.eventHistory().size()));

	}

	static Premises createPremises() {
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri(PREMISES_URI);
		Location location = LocationFactory.eINSTANCE.createLocation();
		location.setName("bobos");
		location.setDescription("Test location");
		location.setState("CA");
		location.setStreet("77 Sunset Strip");
		location.setCity("Hollywood");
		location.setPostalCode("54665");
		location.setLatitude(38.898556);
		location.setLongitude(-77.037852);
		location.setAltitude(0);
		premises.setLocation(location);
		return premises;
	}

	private Animal createAnimal() {
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.getEvents().add(TrackerFactory.eINSTANCE.createAnimalMissing());

		tag.getEvents().add(TrackerFactory.eINSTANCE.createPosition());
		Animal animal = TrackerFactory.eINSTANCE.createSwine();
		animal.getTags().add(tag);
		animal.activeTag().setId(TAG_ID_1);
		return animal;
	}

	private DBCollection getCollection(String name) {
		MongoClient mongoClient = iMongoClientProvider.getMongoClient();
		DB db = mongoClient.getDB(iMongoClientProvider.getDatabaseName());
		return db.getCollection(name);
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

	private void removeDocsFromCollections() throws InterruptedException {
		// TimeUnit.SECONDS.sleep(1);
		DBObject find = new BasicDBObject();
		DBCollection coll = getCollection(Configurator.ANIMAL_COLLECTION);
		coll.remove(find);
		coll = getCollection(Configurator.PREMISES_COLLECTION);
		coll.remove(find);
		coll = getCollection(Configurator.OCD_COLLECTION);
		coll.remove(find);
		coll = getCollection(Configurator.TAG_COLLECTION);
		coll.remove(find);
		coll = getCollection(Configurator.UPDATES_COLLECTION);
		coll.remove(find);
		initializedCollections = true;
	}
}
