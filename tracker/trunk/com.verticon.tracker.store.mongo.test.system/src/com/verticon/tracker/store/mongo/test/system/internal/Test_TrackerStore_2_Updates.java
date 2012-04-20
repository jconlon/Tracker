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

package com.verticon.tracker.store.mongo.test.system.internal;

import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.tracker.store.mongo.test.system.internal.TestUtils.getXMIResource;
import static com.verticon.tracker.store.mongo.test.system.internal.TestUtils.removeLastModificationTimesOnAllResources;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.DOC_AGRI_VALID;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.PLUGIN_ID;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.BundleContext;
import org.osgi.service.monitor.Monitorable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.verticon.agriculture.Agriculture;
import com.verticon.agriculture.Location;
import com.verticon.opengis.kml.Container;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.ITrackerStore;

/**
 * Advanced testing of periodic updating and retrieval functionality of the the 
 * com.verticon.tracker.store.mongo component and its primary class TrackerStore.  
 * The c.v.t.store.mongo.TrackerStore provides Tracker Desktop
 * users the functionality to save and retrieve Tracker elements to/from a MongoDB.
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
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * 
 * @author jconlon
 * 
 */
public class Test_TrackerStore_2_Updates extends TestCase {

	/**
	 * The first animal in the serialized test documents. This animal contains:
	 * <ul>
	 * <li>
	 * a generic event at index(7)</li>
	 * <li>
	 * a position event at index(6)
	 * 
	 * 
	 */
//	private static final String FIRST_ANIMAL_ID = "840456789012341";

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
			.getLogger(Test_TrackerStore_2_Updates.class);

	private static BundleContext context;
	/**
	 * To synchronize the DS and JUnit initializations, this latch will wait for
	 * 1. this bundles startup method to be called which means that the
	 * ITrackerStore and Monitorable services injected from the class under test
	 * TrackerStoreImpl 2. For the wireadmin to connect the Producer service
	 * offered by this class to the Consumer service offered by the
	 * TrackerStoreImpl.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);

	/**
	 * Injected services
	 */
	static ITrackerStore store;
	static Monitorable monitorable;
	// static IController controller;

	/**
	 * Set of tag ids that will be assigned to Premises animals persisted to
	 * MongoDB
	 * 
	 */
	static final String AIN_1 = "tag1";
	static final String AIN_2 = "tag2";
	static final String PIN = "urn:pin:H89234X";
	private static final String DOC_PREMISES_4_11 = "4-11-2008-test.data.premises";
	private static final String DOC_PREMISES_4_12 = "4-12-2008-test.data.premises";
	private static final String DOC_PREMISES_5_16 = "5-16-2008-test.data.premises";
	private static final String DOC_PREMISES_5_17 = "5-17-2008-test.data.premises";
	private static final String DOC_PREMISES_9_10 = "9-10-2008-test.data.premises";
	private static final String DOC_PREMISES_9_14 = "9-14-2008-test.data.premises";
	private static final String DOC_PREMISES_9_15 = "9-15-2008-test.data.premises";
	private static final String DATE_4_11 = "2008-04-11";
	private static final String DATE_4_12 = "2008-04-12";
	private static final String DATE_4_13 = "2008-04-13";

	private static final String DATE_5_16 = "2008-05-16";
	private static final String DATE_5_17 = "2008-05-17";
	private static final String DATE_5_18 = "2008-05-18";

	private static final String DATE_9_10 = "2008-09-10";
	private static final String DATE_9_11 = "2008-09-11";
	private static final String DATE_9_14 = "2008-09-14";
	private static final String DATE_9_15 = "2008-09-15";
	private static final String DATE_9_16 = "2008-09-16";

	DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");

	static ITrackerStore getTrackerStore() throws InterruptedException {
		startUpGate.await();// wait for startUp to finish
		return store;
	}

	/**
	 * Injected by ds
	 * 
	 * @param trackerStore
	 */
	public void setTrackerStore(ITrackerStore trackerStore) {
		logger.debug(bundleMarker, "DS injecting the trackerStore");
		Test_TrackerStore_2_Updates.store = trackerStore;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	public void setMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_TrackerStore_2_Updates.monitorable = monitorable;
	}

	/**
	 * Injected by ds
	 * 
	 * @param controller
	 */
	public void setController(IController controller) {
		logger.debug(bundleMarker, "DS injecting the controller");
		// Test_TrackerStore_2_Base.controller = controller;
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
		// System.out.println(this + ": startup and setUp finished.");
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
		Test_TrackerStore_2_Updates.context = context;
		startUpGate.countDown();

	}

	// Tests
	public void testContext() throws InterruptedException {
		assertThat("BundleContext was not setup", context, is(notNullValue()));
		assertThat("TrackerStore was not setup", store, is(notNullValue()));
		assertThat("Monitorable was not setup", monitorable, is(notNullValue()));
	}

	public void testMongoDB_InitialStateOfCollections()
			throws UnknownHostException, MongoException {
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertThat(db, is(notNullValue()));

		// Animals
		DBCollection coll = db.getCollection(TrackerPackage.Literals.ANIMAL
				.getName());
		assertThat("Animals collection should exist.",
				db.collectionExists(TrackerPackage.Literals.ANIMAL.getName()),
				is(true));
		assertThat(
				"Has index for Animal",
				TestUtils.hasIndexedIDAttribute(
						TrackerPackage.Literals.ANIMAL.getName(), db, "id_1"),
				is(true));
		assertThat("Must have 9 animals", coll.find().count(), is(9));

		// TAGs
		coll = db.getCollection(TrackerPackage.Literals.TAG.getName());
		assertThat("Tag collection should exist.",
				db.collectionExists(TrackerPackage.Literals.TAG.getName()),
				is(true));
		assertThat(
				"Has index for TAG",
				TestUtils.hasIndexedIDAttribute(
						TrackerPackage.Literals.TAG.getName(), db, "id_1"),
				is(true));
		assertThat("Must be 10 tags", coll.find().count(), is(10));

		// Premises
		coll = db.getCollection(TrackerPackage.Literals.PREMISES.getName());
		assertThat(
				"PREMISES collection must exist.",
				db.collectionExists(TrackerPackage.Literals.PREMISES.getName()),
				is(true));
		assertThat("Must have index for PREMISES", TestUtils.hasIndexedIDAttribute(
				TrackerPackage.Literals.PREMISES.getName(), db, "uri_1"),
				is(true));
		assertThat("Must have only one Premises saved", coll.find().count(), is(1));

		// OCDs
		coll = db.getCollection(MetatypePackage.Literals.OCD.getName());
		assertThat("Ocd collection must exist.",
				db.collectionExists(MetatypePackage.Literals.OCD.getName()),
				is(true));
		assertThat(
				"Must have index for OCD",
				TestUtils.hasIndexedIDAttribute(
						MetatypePackage.Literals.OCD.getName(), db, "iD_1"),
				is(true));
		assertThat("Must have only 1 OCD", coll.find().count(), is(1));

	}

	public void testRemoveMembersUpdate() throws UnknownHostException,
			MongoException {
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);
		removeLastModificationTimesOnAllResources(db);
	}

	public void testMonitorable_ResetStatus() {
		resetStatusVariables();
		assertThat("Must be connected",
				monitorable.getStatusVariable(Variables.STATUS.statusVarID)
						.getString(), startsWith("Connected"));
		assertThat(
				"Must have processed animals.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(0));
		assertThat(
				"Must have added animals.",
				monitorable.getStatusVariable(
						Variables.NEW_ANIMALS_ADDED.statusVarID).getInteger(),
				is(0));
		assertThat("Must have not updated animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));
	}

	private void resetStatusVariables() {
		monitorable
				.resetStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID);
		monitorable.resetStatusVariable(Variables.UPDATED_ANIMALS.statusVarID);
		monitorable
				.resetStatusVariable(Variables.TOTAL_ANIMALS_PROCESSED.statusVarID);
	}

	public void testRegister() throws IOException, ParseException {
		logger.debug(bundleMarker, "starting testUpdateLocation");
		Resource resource = getXMIResource(DOC_AGRI_VALID, "updateTests");
		Location location = (Location) resource.getContents().get(0);
		assertThat("Not a valid location", TestUtils.isValidObject(location),
				is(true));
		Premises premises = location.getLivestock();
		assertThat("Premises must have 72 animalsl", premises.getAnimals()
				.size(), is(72));
		assertThat("Premises not enough events",
				premises.eventHistory().size(), is(289));

		Container container = location.getGeography();
		assertThat("Container cannot be null.", container, is(notNullValue()));

		logger.debug(
				bundleMarker,
				"First event Date={}; DateKey={}; DateTime={}",
				new String[] { premises.eventHistory().get(0).getDate(),
						premises.eventHistory().get(0).getDateKey(),
						premises.eventHistory().get(0).getDateTime().toString() });
		URI locationURI = location.eResource().getURI();
		URI premisesURI = premises.eResource().getURI();
		URI containerURI = location.getGeography().eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		store.register(location);
		assertThat("Must not have changed the uri of the location", location
				.eResource().getURI(), is(locationURI));
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Must not have changed the uri of the container", location
				.getGeography().eResource().getURI(), is(containerURI));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));
		assertThat(
				"Must have processed 0 animals.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(0));

		assertThat("Premises must still have 72 animalsl", premises
				.getAnimals().size(), is(72));

		Location retrievedLocation = store.retrieveLocation(location.getUri());
		assertThat("Retrieved Location must not be null.", retrievedLocation,
				is(notNullValue()));
		assertThat("Retrieved Premises must not be null.",
				retrievedLocation.getLivestock(), is(notNullValue()));
		assertThat("Retrieved Geography must not be null.",
				retrievedLocation.getGeography(), is(notNullValue()));

		Premises retrievedPremises = store.retrievePremises(location.getUri(),
				null, null);
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
		store.recordAnimals(premises);
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 72 animalsl", premises
				.getAnimals().size(), is(72));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat("Must have not updated any animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));

		assertThat(
				"Must have processed 72 animals.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(72));
		assertThat("Must have added 72 animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(72));
		
		countEvents(289);
	}

	/**
	 * 72 existing plus 37 animals more = 109 animals
	 * 
	 * @throws IOException
	 */
	public void testRecord_4_12() throws IOException {
		resetStatusVariables();

		Resource resource = getXMIResource(DOC_PREMISES_4_12, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 109 animalsl", premises.getAnimals()
				.size(), is(109));
		assertThat("Premises must have 438 events", premises.eventHistory()
				.size(), is(438));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		store.recordAnimals(premises);
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 109 animalsl", premises
				.getAnimals().size(), is(109));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed 109 -72 = 37 animals. ",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(37));

		assertThat("Must have not updated any animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));

		assertThat("Must have added 109 -72 = 37 animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(37));

		countEvents(438);

	}

	/**
	 * 109 existing animals + 94 more = 203
	 * 
	 * @throws IOException
	 */
	public void testRecord_5_16() throws IOException {
		resetStatusVariables();

		Resource resource = getXMIResource(DOC_PREMISES_5_16, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 203 animalsl", premises.getAnimals()
				.size(), is(203));
		assertThat("Premises must have 814 events", premises.eventHistory()
				.size(), is(814));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		store.recordAnimals(premises);
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 203 animalsl", premises
				.getAnimals().size(), is(203));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed 203 - 109 = 94 animals. ",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(203 - 109));

		assertThat("Must have not updated any animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));

		assertThat("Must have added 203 - 109 = 94 animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(94));

		countEvents(814);

	}



	/**
	 * 203 existing + 123
	 * 
	 * @throws IOException
	 */
	public void testRecord_5_17() throws IOException {
		resetStatusVariables();

		Resource resource = getXMIResource(DOC_PREMISES_5_17, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 326 animalsl", premises.getAnimals()
				.size(), is(326));
		assertThat("Premises must have 1306 events", premises.eventHistory()
				.size(), is(1306));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		store.recordAnimals(premises);
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 326 animalsl", premises
				.getAnimals().size(), is(326));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed 326 - 203 = 123 animals. ",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(123));

		assertThat("Must have not updated any animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));

		assertThat("Must have added 326 - 203 = 123 animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(123));

		countEvents(1306);

	}

	public void testRecord_9_10() throws IOException {
		resetStatusVariables();

		Resource resource = getXMIResource(DOC_PREMISES_9_10, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 326 animalsl", premises.getAnimals()
				.size(), is(326));
		assertThat("Premises must have 1733 events", premises.eventHistory()
				.size(), is(1733));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		store.recordAnimals(premises);
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 326 animalsl", premises
				.getAnimals().size(), is(326));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed out of 326 previous animals 213 animals. ",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(213));

		assertThat("Must have updated 213 animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(213));

		assertThat("Must have added no animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));

		countEvents(1733);

	}

	public void testRecord_9_14() throws IOException {
		resetStatusVariables();

		Resource resource = getXMIResource(DOC_PREMISES_9_14, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 326 animalsl", premises.getAnimals()
				.size(), is(326));
		assertThat("Premises must have 1913 events", premises.eventHistory()
				.size(), is(1913));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		store.recordAnimals(premises);
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 326 animalsl", premises
				.getAnimals().size(), is(326));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed out of 326 previous animals 180 animals. ",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(180));

		assertThat("Must have updated 180 animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(180));

		assertThat("Must have added no animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));

		countEvents(1913);
	}

	public void testRecord_9_15() throws IOException {
		resetStatusVariables();

		Resource resource = getXMIResource(DOC_PREMISES_9_15, "updateTests");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("Premises must have 326 animalsl", premises.getAnimals()
				.size(), is(326));
		assertThat("Premises must have 1948 events", premises.eventHistory()
				.size(), is(1948));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		store.recordAnimals(premises);
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 326 animalsl", premises
				.getAnimals().size(), is(326));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have processed out of 326 previous animals 180 animals. ",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(35));

		assertThat("Must have updated 35 animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(35));

		assertThat("Must have added no animals.", monitorable
				.getStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID)
				.getInteger(), is(0));

		countEvents(1948);

	}

	public void testRetrievePremises_4_11() throws ParseException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_4_11,
				DATE_4_12);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + Member.THREE.uri, premises,
				is(notNullValue()));
		assertThat("Premises must have 72 animalsl", premises.getAnimals()
				.size(), is(72));
		// Tracker shows 72 animals, shell says 73 Tags (023 tag is in the shell
		// but not in tracker)

	}

	public void testQuery_DB_driver_4_11() throws ParseException,
			UnknownHostException, MongoException {
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);
		Date fromDate = dfm.parse(DATE_4_11);
		Date toDate = dfm.parse(DATE_4_12);

		BasicDBObject dateMatch = new BasicDBObject();
		dateMatch.put("dateTime",
				new BasicDBObject("$gte", fromDate).append("$lt", toDate));

		BasicDBObject elementMatch = new BasicDBObject();
		elementMatch.put("$elemMatch",
				dateMatch.append("pid", Member.THREE.uri));
		BasicDBObject queryd = new BasicDBObject("events", elementMatch);

		BasicDBObject keys = new BasicDBObject();
		keys.put("animal._eProxyURI", 1);

		logger.info(bundleMarker, "query: {}", queryd);

		// From shell
		/*
		 * db.Tag.findOne( { events: {$elemMatch: {dateTime: {$gte: start, $lt:
		 * end},pid: 'urn:pin:H89234X'}} }, { 'animal._eProxyURI':1} )
		 * 
		 * Returns -> { "_id" : "840456789012341", "animal" : { "_eProxyURI" :
		 * "../Animal/4f5e45f0a8d622e410fbfe1a#840456789012341" } }
		 */
		Set<String> animals = new HashSet<String>();
		DBCursor cur = db.getCollection("Tag").find(queryd, keys);
		while (cur.hasNext()) {
			DBObject result = cur.next();
			// "../Animal/4f5e3604a8d60b3072b2e919#840003002956464"
			DBObject subResult = (DBObject) result.get("animal");
			String proxy = (String) subResult.get("_eProxyURI");
			animals.add(proxy);

			// System.out.println(proxy);
		}

		assertThat("Result must be 72 animals", animals.size(), is(72));
	}

	public void testRetrievePremises_4_12() throws ParseException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_4_12,
				DATE_4_13);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + Member.THREE.uri, premises,
				is(notNullValue()));
		assertThat("Premises must have 37 animalsl", premises.getAnimals()
				.size(), is(37));
		// Tracker with an ocl query shows 37,
		// Current query is showing a Result is 80 and
		// and the shell says 81 with:
		// db.Tag.find({'events.dateTime': {$gte: start, $lt: end}}).count() =
		// 81
		// This is return all tags that have events less greater than 4-12 and
		// le than the 4-13
		// not just tags with 4-12 events meets these criteria tags that have
		// events earlier than
		// 4-12 and later than 4-12
		// in other words events that surround the time period - which from an
		// application point of view
		// the animal is in the premises for the time period
		// but....
		// if the query is changed to:
		// db.Tag.find({events: {$elemMatch: {dateTime: {$gte: start, $lt:
		// end}}}}).count()
		// it shows 38
		// Should change the query to
		// db.Tag.find({events: {$elemMatch: {dateTime: {$gte: start, $lt:
		// end},pid: 'urn:pin:003ALKM'}} })
		// All animals that generated events within the time period at the given
		// premises
	}

	public void testQuery_DB_driver_4_12() throws ParseException,
			UnknownHostException, MongoException {
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);

		Date fromDate = dfm.parse(DATE_4_12);
		Date toDate = dfm.parse(DATE_4_13);

		BasicDBObject dateMatch = new BasicDBObject();
		dateMatch.put("dateTime",
				new BasicDBObject("$gte", fromDate).append("$lt", toDate));

		BasicDBObject elementMatch = new BasicDBObject();
		elementMatch.put("$elemMatch",
				dateMatch.append("pid", Member.THREE.uri));
		BasicDBObject queryd = new BasicDBObject("events", elementMatch);

		BasicDBObject keys = new BasicDBObject();
		keys.put("animal._eProxyURI", 1);

		logger.info(bundleMarker, "query: {}", queryd);

		Set<String> animals = new HashSet<String>();
		DBCursor cur = db.getCollection("Tag").find(queryd, keys);
		while (cur.hasNext()) {
			DBObject result = cur.next();
			// "../Animal/4f5e3604a8d60b3072b2e919#840003002956464"
			DBObject subResult = (DBObject) result.get("animal");
			String proxy = (String) subResult.get("_eProxyURI");
			animals.add(proxy);

			// System.out.println(proxy);
		}

		assertThat("Result must be 37 animals", animals.size(), is(37));
	}

	public void testRetrievePremises_5_16() throws ParseException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_5_16,
				DATE_5_17);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + Member.THREE.uri, premises,
				is(notNullValue()));
		assertThat("Premises must have 94 animalsl", premises.getAnimals()
				.size(), is(94));

	}

	public void testQuery_DB_driver_5_16() throws ParseException,
			UnknownHostException, MongoException {
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);

		Date fromDate = dfm.parse(DATE_5_16);
		Date toDate = dfm.parse(DATE_5_17);

		BasicDBObject dateMatch = new BasicDBObject();
		dateMatch.put("dateTime",
				new BasicDBObject("$gte", fromDate).append("$lt", toDate));

		BasicDBObject elementMatch = new BasicDBObject();
		elementMatch.put("$elemMatch",
				dateMatch.append("pid", Member.THREE.uri));
		BasicDBObject queryd = new BasicDBObject("events", elementMatch);

		BasicDBObject keys = new BasicDBObject();
		keys.put("animal._eProxyURI", 1);

		logger.info(bundleMarker, "query: {}", queryd);

		Set<String> animals = new HashSet<String>();
		DBCursor cur = db.getCollection("Tag").find(queryd, keys);
		while (cur.hasNext()) {
			DBObject result = cur.next();
			// "../Animal/4f5e3604a8d60b3072b2e919#840003002956464"
			DBObject subResult = (DBObject) result.get("animal");
			String proxy = (String) subResult.get("_eProxyURI");
			animals.add(proxy);

			// System.out.println(proxy);
		}

		assertThat("Result must be 94 animals", animals.size(), is(94));
	}

	public void testRetrievePremises_5_17() throws ParseException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_5_17,
				DATE_5_18);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + Member.THREE.uri, premises,
				is(notNullValue()));
		assertThat("Premises must have 123 animalsl", premises.getAnimals()
				.size(), is(123));

	}

	public void testRetrievePremises_9_10() throws ParseException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_9_10,
				DATE_9_11);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + Member.THREE.uri, premises,
				is(notNullValue()));
		assertThat("Premises must have 213 animals", premises.getAnimals()
				.size(), is(213));
	}

	public void testSavePremises_9_10() throws ParseException, IOException {
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_9_10,
				DATE_9_11);
		TestUtils.saveXMIResource("out_9_10.premises", premises);
	}

	public void testRetrievePremises_9_14() throws ParseException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_9_14,
				DATE_9_15);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + Member.THREE.uri, premises,
				is(notNullValue()));
		assertThat("Premises must have 180 animalsl", premises.getAnimals()
				.size(), is(180));

	}

	public void testSavePremises_9_14() throws ParseException, IOException {
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_9_14,
				DATE_9_15);
		TestUtils.saveXMIResource("out_9_14.premises", premises);
	}

	public void testRetrievePremises_9_15() throws ParseException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_9_15,
				DATE_9_16);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + Member.THREE.uri, premises,
				is(notNullValue()));
		assertThat("Premises must have 35 animalsl", premises.getAnimals()
				.size(), is(35));

	}
	
	public void testRetrieveLocations(){
		Set<String> uris = newHashSet();
		uris.add(Member.ONE.uri);
		uris.add(Member.THREE.uri);
		Agriculture ag = store.retrieveLocations(uris);
		assertThat("Must have two locations.", ag.getLocation().size(), is(2));
	}

	public void testSavePremises_9_15() throws ParseException, IOException {
		Premises premises = store.retrievePremises(Member.THREE.uri, DATE_9_15,
				DATE_9_16);
		TestUtils.saveXMIResource("out_9_15.premises", premises);
	}
	
	private void countEvents(int count) throws UnknownHostException {
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertThat(db, is(notNullValue()));
		int events = TestUtils.eventCount(db, Member.THREE.uri);
		assertThat(events, is(count));
	}
}
