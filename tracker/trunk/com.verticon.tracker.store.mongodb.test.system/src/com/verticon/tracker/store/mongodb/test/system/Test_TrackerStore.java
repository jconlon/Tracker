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
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.UPDATES_COLLECTION;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.getXMIResource;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.isValidObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

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
import com.verticon.osgi.metatype.Icon;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.store.ITrackerFind;
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

	private static final String TAG_ID_WITH_GENERIC_EVENT = "840456789012341";

	private static final String FILE_TMP_OUT_PREMISES1 = "/tmp/out1.premises";

	private static final String FILE_TMP_OUT_PREMISES2 = "/tmp/out2.premises";

	private static final String TAG_ID_WITH_SIRE_AND_DAM = "840456789012343";

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
	// private static final MetricRegistry metricsRegistry = new MetricRegistry(
	// "MongoEMFMinimum");
	//
	// // Registration elapsed time in milliseconds and invocations per second.
	// // private final Timer responses =
	// // metricsRegistry.timer(RequestHandler.class, "responses");
	//
	// private static final Timer registrationTimer =
	// metricsRegistry.timer(name(
	// Test_TrackerStore.class, PREMISES_COLLECTION,
	// "registration"));
	// static final Timer recordTimer = metricsRegistry.timer(name(
	// Test_TrackerStore.class, "Animal", "record"));
	//
	// private static final Slf4jReporter reporter = Slf4jReporter
	// .forRegistry(metricsRegistry)
	// .outputTo(
	// LoggerFactory
	// .getLogger("com.verticon.tracker.store.mongodb.test.system.Test_TrackerStore"))
	// .convertRatesTo(TimeUnit.SECONDS)
	// .convertDurationsTo(TimeUnit.MILLISECONDS).build();

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
	 * TODO move this to perf
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void test_TrackerUpdate__RegisterMultiplePremises()
			throws IOException,
			InterruptedException {
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

		assertThat("Must have added 1 animals.", stats.getAnimalsAdded(),
				is(1));
		assertThat("Incorrect number of tags", stats.getTagsAdded(), is(1));
		assertThat("Incorrect number of events", stats.getTagsAdded(),
				is(1));

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

	@Test
	public void test_TrackerFind_RetrievePremises() throws IOException {

		Premises premises = trackerStore.retrievePremises(PREMISES_URI);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Not a valid premises", isValidObject(premises), is(true));
		assertThat("Premises should have name", premises.getName(),
				is("Jack Condor"));
		assertThat("Premises should have no Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));


	}

	@Test
	public void test_TrackerFind_RetrievePremises_WithLocation()
			throws IOException {

		Premises premises = trackerStore
				.retrievePremises(PREMISES_URI_H89234X);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Not a valid premises", isValidObject(premises), is(true));
		assertThat("Premises should have name", premises.getName(),
				is("East Farm"));
		assertThat("Premises should have no Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));

	}


	@Test
	public void test_TrackerFind_RetrievePremises_Dates()
			throws IOException {

		Premises premises = trackerStore.retrievePremises(
				PREMISES_URI_H89234X, FROMDATE, TODATE);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		assertThat("Not a valid premises", isValidObject(premises), is(true));
		assertThat("Premises with uri " + PREMISES_URI_H89234X, premises,
				is(notNullValue()));
		assertThat("Premises URI must not be null.", premises.getUri(),
				is(notNullValue()));
		assertThat("Premises must have 5 animalsl", premises.getAnimals()
				.size(), is(5));

		Animal firstAnimal = premises.getAnimals().get(0);
		String id = "";
		for (Animal animal : premises.getAnimals()) {
			assertThat(animal.getId(), is(greaterThan(id)));
			id = animal.getId();
			logger.debug(bundleMarker, "Animal {} ", animal.getId());
		}

		assertThat("First animal was not found between " + FROMDATE + " and "
				+ TODATE, firstAnimal.getId(), is("840456789012341"));
		assertThat("First animal must have 8 events.", firstAnimal
				.eventHistory().size(), is(8));
		for (Event event : firstAnimal.eventHistory()) {
			logger.debug(bundleMarker, "Event {} ", event);
			assertThat("First animal events must have pid set. " + event,
					event.getPid(), is(PREMISES_URI_H89234X));
		}
	}

	/**
	 * db.Premises.find( { "location.loc" : { $near :
	 * [-90.95048182270057,43.47622307339506,0 ] , $maxDistance : 1 } } )
	 * 
	 * @throws IOException
	 */
	@Test
	public void test_TrackerFind_RetrievePremises_Point()
			throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-77.037852,38.898556,0");
		// position.setLatitude(38.898556);
		// position.setLongitude(-77.037852);
		Premises premises = trackerStore.retrievePremises(point);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		
		assertThat("Premises should have uri", premises.getUri(),
				is(PREMISES_URI));
		assertThat("Premises should have name", premises.getName(),
				is("Jack Condor"));
		assertThat("Premises should have no Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));
	}

	private static final String FROMDATE = "2010-03-01";
	private static final String TODATE = "2011-05-01";

	@Test
	public void test_TrackerFind_RetrievePremises_Point2() throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-90.95048182270057,43.47622307339506,0");
		// List<String> pointList = point.toList();
		// assertThat(pointList.get(0), is(-90.95048182270057));
		Premises premises = trackerStore.retrievePremises(point);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Premises should have uri", premises.getUri(),
				is(PREMISES_URI_H89234X));
		assertThat("Premises should have name", premises.getName(),
				is("East Farm"));
		assertThat("Premises should have 0 Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));
	}

	@Test
	public void test_TrackerFind_RetrievePremises_Point_Dates()
			throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-90.95048182270057,43.47622307339506,0");
		Premises premises = trackerStore.retrievePremises(point, FROMDATE,
				TODATE);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Premises should have uri", premises.getUri(),
				is(PREMISES_URI_H89234X));
		assertThat("Premises should have name", premises.getName(),
				is("East Farm"));
		assertThat("Premises should have 5 Animals", premises.getAnimals()
				.size(), is(5));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));
	}


	public void test_TrackerFind_RetrieveAnimal() throws IOException {
		Animal animal = trackerStore.retrieveAnimal(TAG_ID_1);

		assertThat("Animal should not be null", animal, is(notNullValue()));

		assertThat("Animal should be a swine", animal.getType(),
				is(AnimalType.SWINE));

		assertThat("Animal should have one tag", animal.getTags().size(), is(1));
		assertThat("Animal should have id", animal.getId(), is(TAG_ID_1));

		Tag tag = animal.activeTag();
		assertThat("Tag should have an event", tag.getEvents().size(), is(2));

		Event event = tag.getEvents().get(0);
		assertThat("Event should be  is an AnimalMissing ",
				event.getEventCode(), is(13));

	}



	public void test_TrackerFind_RetrieveAnimal_WITH_GENERIC_EVENT()
			throws IOException {
		Animal animal = trackerStore.retrieveAnimal(TAG_ID_WITH_GENERIC_EVENT);

		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("Animal should have id", animal.getId(),
				is(TAG_ID_WITH_GENERIC_EVENT));
		assertThat("Animal should be a beef", animal.getType(),
				is(AnimalType.BOVINE_BEEF));
		assertThat("Animal should have 1 tag", animal.getTags().size(), is(1));

		Tag tag = animal.activeTag();
		assertThat("Tag should have 8 events", tag.getEvents().size(), is(8));

		Event event = tag.getEvents().get(0);
		assertThat("Event should be  is a TagAppliend EventCode 2",
				event.getEventCode(), is(2));

		event = tag.getEvents().get(7);
		assertThat("Event should be  is a GenericEvent EventCode 200",
				event.getEventCode(), is(200));
		GenericEvent ge = (GenericEvent) event;
		assertThat("Generic Event should not be null", ge, is(notNullValue()));
		OCD ocd = ge.getOcd();
		assertThat("OCD should not be null", ocd, is(notNullValue()));
		String id = ocd.getID();
		assertThat("OCD id should be mettler.weight", id, is("mettler.weight"));
		// The icon resource is stored raw there needs to be one at the location
		Icon icon = ocd.getIcon();
		assertThat("OCD icon should not be null", icon, is(notNullValue()));
		assertThat("OCD icon resource should not be null", icon.getResource(),
				is("platform:/resource/com.verticon.tracker.example/blood.gif"));
		assertThat("OCD must have 4 ADs", ocd.getAD().size(), is(4));
	}

	@Test
	public void testAnimal_Read_With_SireAndDam() {
		Animal animal = trackerStore.retrieveAnimal(TAG_ID_WITH_SIRE_AND_DAM);

		assertThat("Animal should not be null", animal, is(notNullValue()));

		assertThat("Animal should be a beef", animal.getType(),
				is(AnimalType.BOVINE_BEEF));
		assertThat("Animal should have 1 tag", animal.getTags().size(), is(1));
		assertThat("Animal should have id", animal.getId(),
				is(TAG_ID_WITH_SIRE_AND_DAM));
	}


	// @Test
	// public void test_Wait() throws InterruptedException {
	// TimeUnit.SECONDS.sleep(2);
	// logger.debug("done");
	// }



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
		DBCollection coll = getCollection(
				Configurator.ANIMAL_COLLECTION);
		coll.remove(find);
		coll = getCollection(
				Configurator.PREMISES_COLLECTION);
		coll.remove(find);
		coll = getCollection(Configurator.OCD_COLLECTION);
		coll.remove(find);
		coll = getCollection(Configurator.TAG_COLLECTION);
		coll.remove(find);
		coll = getCollection(
				Configurator.UPDATES_COLLECTION);
		coll.remove(find);
		initializedCollections = true;
	}
}
