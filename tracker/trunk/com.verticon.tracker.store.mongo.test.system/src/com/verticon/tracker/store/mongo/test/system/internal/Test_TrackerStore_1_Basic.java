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

import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_BI;
import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_REGISTRANT;
import static com.verticon.tracker.store.mongo.test.system.TestUtils.getXMIResource;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.json.MongoQueryStandaloneSetupGenerated;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;
import com.verticon.location.Location;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Position;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.ValidationException;
import com.verticon.tracker.store.mongo.test.system.IMockAuthenticatorController;
import com.verticon.tracker.store.mongo.test.system.Member;
import com.verticon.tracker.store.mongo.test.system.TestUtils;
import com.verticon.tracker.store.mongo.test.system.Variables;
import com.verticon.tracker.util.TrackerValidator;

/**
 * 
 * Basic testing of the com.verticon.tracker.store.mongo component and its
 * primary class TrackerStore. The c.v.t.store.mongo.TrackerStore saves and
 * retrieves Tracker elements to a MongoDB.
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
public class Test_TrackerStore_1_Basic extends TestCase {

	// private static final String DOC_AGRI_INVALID_LOCATION = "badDoc.agri";
	static final String DOC_INVALID_PREMISES_NO_LOCATION = "noLocationExample.premises";
	static final String DOC_INVALID_PREMISES_LOCATION = "invalidExample.premises";
	static final String DOC_PREMISES = "example.premises";
	// static final String DOC_AGRI_VALID = "doc.agri";
	static final String DOC_ADMIN = "doc.admin";

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
	static final String FIRST_ANIMAL_ID = "840456789012341";

	private static final int POSTION_EVENT = 6;
	private static final int GENERIC_EVENT = 7;

	private static final String EVENTS_DATE_TIME = "events.dateTime";
	private static final String FROMDATE = "2010-03-01";
	private static final String TODATE = "2011-05-01";

	private static final String FROMDATE_JSON = "new Date(2010, 02, 01)";// "2010-03-01";
	private static final String TODATE_JSON = "new Date(2011, 04, 01)"; // "2011-05-01";

	static String PLUGIN_ID = "com.verticon.tracker.store.mongo.test.system";
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
			.getLogger(Test_TrackerStore_1_Basic.class);

//	// Registration elapsed time in milliseconds and invocations per second.
//	private final Timer registrationTimer = MongoTrackerStoreMonitor
//			.getMetricsregistry()
//			.newTimer(
//Test_TrackerStore_1_Basic.class,
//					"Premises-Registration-Time");
//	// Animal store elapsed time in milliseconds and invocations per second.
//	private final Timer storeTimer = MongoTrackerStoreMonitor
//			.getMetricsregistry().newTimer(
//			Test_TrackerStore_1_Basic.class, "Animal-Store-Time");
//	// Animal query elapsed time in milliseconds and invocations per second.
//	private final Timer animalQueryTimer = MongoTrackerStoreMonitor
//			.getMetricsregistry()
//			.newTimer(Test_TrackerStore_1_Basic.class, "Animal-Query-Time");
//
//	private final Counter processedAnimalCounter = MongoTrackerStoreMonitor
//			.getMetricsregistry().newCounter(Test_TrackerStore_1_Basic.class,
//					"Processed-animals");

	private static BundleContext context;
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
	 * Injected services implement by
	 * com.verticon.tracker.store.mongo.internal.Component
	 */
	static ITrackerStore store;
	static Monitorable monitorable;
	// static ITrackerStoreAdmin trackerStoreAdmin;

	/**
	 * Injected service implemented by the test framework
	 */
	static IController controller;
	static IMockAuthenticatorController mockAuthenticatorController;

	/**
	 * Set of tag ids that will be assigned to Premises animals persisted to
	 * MongoDB
	 * 
	 */
	static final String AIN_1 = "tag1";
	static final String AIN_2 = "tag2";
	static final String AIN_3 = "tag3";

	static final String PIN = "urn:pin:H89234X";

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
		Test_TrackerStore_1_Basic.store = trackerStore;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	public void setMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_TrackerStore_1_Basic.monitorable = monitorable;
	}

	/**
	 * Injected by ds
	 * 
	 * @param controller
	 */
	public void setController(IController controller) {
		logger.debug(bundleMarker, "DS injecting the controller");
		Test_TrackerStore_1_Basic.controller = controller;
	}

	// public void setAdminLoader(ITrackerStoreAdmin loader) {
	// logger.debug(bundleMarker, "DS injecting the loader");
	// Test_TrackerStore_1_Basic.trackerStoreAdmin = loader;
	// }

	void setMockAuthenticatorController(
			IMockAuthenticatorController mockAuthenticatorController) {
		Test_TrackerStore_1_Basic.mockAuthenticatorController = mockAuthenticatorController;
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
		// System.out.println(this + ": startup and setUp finished.");

		// Setup the Mongo JSON query environment
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
	 * @param context
	 */
	public void startup(BundleContext context) {
		logger.debug(bundleMarker, "Activating");
		Test_TrackerStore_1_Basic.context = context;
		startUpGate.countDown();
	}

	protected void deactivate() {
		logger.debug(bundleMarker, "DEActivating");
	}

	//Tests
	/**
	 * This is mostly redundant all of these should be there to get this far.
	 */
	@Test
	public void testContext() {
		assertThat("BundleContext was not setup", context, is(notNullValue()));
		assertThat("TrackerStore was not setup", store, is(notNullValue()));
		assertThat("Monitorable was not setup", monitorable, is(notNullValue()));
		assertThat("Controller was not setup", controller, is(notNullValue()));
		assertThat("Controller must have wires", controller.hasWires(),
				is(true));
		// assertThat("Loader must be setup", trackerStoreAdmin,
		// is(notNullValue()));

	}

	@Test
	public void testMongo() throws UnknownHostException {
		MongoURI uri = Configuator.getMongoURI();
		List<String> hosts = uri.getHosts();
		assertThat("One host", hosts.size(), is(1));

		DB db = Configuator.getTrackerDB();
		assertThat("Wrong db", db.getName(), is("tracker"));
		DBCollection collection = db.getCollection("test");
		collection.drop();
		DBObject dbObject = new BasicDBObject("key1", "value1");
		collection.insert(dbObject);
		assertThat("Wrong number of collectons", collection.count(), is(1l));

	}

	/**
	 * Clear the MongoDB
	 * 
	 * @throws UnknownHostException
	 * @throws MongoException
	 * @throws InterruptedException
	 */
	@Test
	public void testClearMongoDB() throws UnknownHostException, MongoException,
			InterruptedException {
		TestUtils.clearTrackerDB();
		// monitorable
		// .resetStatusVariable(Variables.MONGO_ADMIN_LOADED.statusVarID);

		TimeUnit.SECONDS.sleep(2);

	}
	
	/**
	 * Check all the collections are there and there indexes
	 * 
	 * @throws MongoException
	 * @throws UnknownHostException
	 * 
	 */
	@Test
	public void testMongoDB_InitialStateOfCollections()
			throws UnknownHostException, MongoException {
		DB db = Configuator.getTrackerDB();
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
		assertThat("No docs", coll.find().count(), is(0));

		// TAGs
		coll = db.getCollection(TrackerPackage.Literals.TAG.getName());
		assertThat("Tag collection should exist.",
				db.collectionExists(TrackerPackage.Literals.TAG.getName()),
				is(true));
		assertThat(
				"Must have index for TAG",
				TestUtils.hasIndexedIDAttribute(
						TrackerPackage.Literals.TAG.getName(), db, "id_1"),
				is(true));
		assertThat("Must have index on Tag for geolocation",
				TestUtils.hasIndexedIDAttribute(
						TrackerPackage.Literals.TAG.getName(), db,
						"events.loc_2d"), is(true));
		assertThat("No docs", coll.find().count(), is(0));

		// Premises
		coll = db.getCollection(TrackerPackage.Literals.PREMISES.getName());
		assertThat(
				"PREMISES collection should exist.",
				db.collectionExists(TrackerPackage.Literals.PREMISES.getName()),
				is(true));
		assertThat("Has index for PREMISES", TestUtils.hasIndexedIDAttribute(
				TrackerPackage.Literals.PREMISES.getName(), db, "uri_1"),
				is(true));
		assertThat("Must have index on Premises for geolocation",
				TestUtils.hasIndexedIDAttribute(
						TrackerPackage.Literals.PREMISES.getName(), db,
						"location.loc_2d"), is(true));
		assertThat("No docs", coll.find().count(), is(0));

		// OCDs
		coll = db.getCollection(MetatypePackage.Literals.OCD.getName());
		assertThat("Ocd collection should exist.",
				db.collectionExists(MetatypePackage.Literals.OCD.getName()),
				is(true));
		assertThat(
				"Has index for OCD",
				TestUtils.hasIndexedIDAttribute(
						MetatypePackage.Literals.OCD.getName(), db, "iD_1"),
				is(true));
		assertThat("No docs", coll.find().count(), is(0));

	}

	/**
	 * Test that all the status variables are visible in monitorable
	 */
	@Test
	public void testMonitorable_StatusVariables_Presence() {
		logger.debug(bundleMarker,
				"starting testMonitorable_StatusVariables_Presence");
		String[] varNames = monitorable.getStatusVariableNames();
		assertNotNull("Monitorable was not setup", varNames);

		assertThat("Must have all the StatusVariableNames",
				monitorable.getStatusVariableNames().length,
				is(Variables.values().length - 1));// One of them is not a
													// status variable

		for (Variables var : Variables.values()) {
			StatusVariable sv = null;
			if (var.statusVarID == null) {
				continue;
			}
			try {
				sv = monitorable.getStatusVariable(var.statusVarID);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				throw e;
				// fail(var.statusVarID+" "+e);
			}
			assertThat(var.statusVarID + " must not be null", sv,
					is(notNullValue()));

		}
	}

	/**
	 * Test Connected and Animal status variables before adding animals.
	 */
	@Test
	public void testMonitorable_Get_StatusVariables() {
		assertThat("Variable Status must be Connected", monitorable
				.getStatusVariable(Variables.STATUS.statusVarID).getString(),
				startsWith("Connected"));
		assertThat(
				"Must have processed NO animals.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(0));
		assertThat(
				"Must have added NO animals.",
				monitorable.getStatusVariable(
						Variables.NEW_ANIMALS_ADDED.statusVarID).getInteger(),
				is(0));
		assertThat("Must have not updated animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));
	}
	
	/**
	 * Insure Premises registration fails with a null.
	 */
	@Test
	public void testRegister_NullAgrument() {

		try {
			store.register(null);
			fail("Should throw an illegal argument exception.");
		} catch (NullPointerException e) {
			assertThat("Premises must not be null.", e.getMessage(),
					is("Premises must not be null."));
		} catch (IOException e) {
			fail("Should throw an illegal argument exception.");
		}
	}

	/**
	 * TODO Validating EObjects with com.verticon.tracker.util.TrackerValidator
	 * Remove? should this be moved?
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testValidation_Uri() throws InterruptedException {
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri("jc://www.verticon");
		TrackerValidator validator = TrackerValidator.INSTANCE;
		assertThat("Premises must not validate",
				validator.validate(premises, null, null), is(false));
		premises.setUri("ok");
		assertThat("Premises must validate",
				validator.validate(premises, null, null), is(true));
	}

	/**
	 * TODO Validating EObjects. Remove? Test local validation method
	 * 
	 * @throws ValidationException
	 */
	@Test
	public void testValidation_Service_Uri() throws ValidationException {
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri("jc://www.verticon");

		try {
			validateObject(premises);
			fail("Validation must throw an exception.");
		} catch (Exception e) {
			// expected
		}

		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.getEvents().add(TrackerFactory.eINSTANCE.createAnimalMissing());
		tag.setId("jec://www.");
		Animal animal = TrackerFactory.eINSTANCE.createBovineBeef();
		animal.getTags().add(tag);

		try {
			validateObject(animal);
			fail("Validation must throw an exception.");
		} catch (Exception e) {
			// expected
		}
		premises.setUri("normal");
		assertThat("Premises must validate.", validateObject(premises),
				is(true));
		animal.activeTag().setId("good");
		assertThat("Animal must validate.", validateObject(animal), is(true));
	}

	/**
	 * TODO Validating EObjects. Remove?
	 * 
	 * @param eObject
	 * @return
	 * @throws ValidationException
	 */
	private static boolean validateObject(EObject eObject)
			throws ValidationException {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					throw new ValidationException(eObject,
							childDiagnostic.getMessage());
				}
			}
		}
		return true;
	}

	/**
	 * Test registering invalid premises
	 */
	@Test
	public void testRegister_Authorization() {
		logger.debug(bundleMarker, "starting testRegister_Authorization");
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("URI must be urn:pin:H89234X", premises.getUri(),
				is(Member.ONE.uri));
		try {
			store.register(premises);
			fail("Should throw an Security exception.");
		} catch (SecurityException e) {
			assertThat("Failed to detect no authenticated user.",
					e.getMessage(), is("User is not authenticated."));
		} catch (Exception e) {
			fail("Should throw a Security exception.");
		}

		try {
			store.recordAnimals(premises);
			fail("Should throw an Security exception.");
		} catch (SecurityException e) {
			assertThat("Failed to detect no authenticated user.",
					e.getMessage(), is("User is not authenticated."));
		} catch (Exception e) {
			fail("Should throw a Security exception.");
		}

		try {
			store.retrievePremises(Member.ONE.uri);
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
			store.retrievePremises(Member.ONE.uri);
			// fail("Should throw an Security exception.");
		} catch (SecurityException e) {
			assertThat("User has no authority to retrieve this premises.",
					e.getMessage(),
					is("User has no authority to retrieve this premises."));
		} catch (Exception e) {
			fail("Should throw a Security exception.");
		}

		// Set the mock roles
		mockAuthenticatorController.setRoles(Arrays
				.asList(Member.ONE.uri, Member.TWO.uri, Member.THREE.uri,
 TRACKER_STORE_REGISTRANT,
				TRACKER_STORE_BI));
	}

	/**
	 * Test registering invalid premises
	 */
	@Test
	public void testRegister_InvalidPremises() {
		logger.debug(bundleMarker, "starting testRegister_InvalidPremises");
		Resource resource = getXMIResource(DOC_INVALID_PREMISES_NO_LOCATION, "");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("URI must be urn:pin:H89234X", premises.getUri(),
				is(Member.ONE.uri));
		try {
			store.register(premises);
			fail("Should throw an null pointer argument exception.");
		} catch (NullPointerException e) {
			assertThat("Premises location must not be null.", e.getMessage(),
					is("Premises location must not be null."));
		} catch (IOException e) {
			fail("Should throw an illegal argument exception.");
		}

		resource = getXMIResource(DOC_INVALID_PREMISES_LOCATION, "");
		premises = (Premises) resource.getContents().get(0);

		try {
			store.register(premises);
			fail("Must throw a ValidationException.");
		} catch (IOException e) {
			assertThat(
					"Update must throw a ValidationException",
					e.getMessage(),
					startsWith("Premises is not valid. The required feature 'street' of "));
		}

	}

	/**
	 * Registers a valid Premises with urn:pin:H89234X
	 * 
	 * @throws IOException
	 */
	@Test
	public void testRegister_ValidPremises() throws IOException {
		logger.debug(bundleMarker, "starting testRegister");
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("URI must be urn:pin:H89234X", premises.getUri(), is(Member.ONE.uri));
		assertThat("Premises must have 7 animalsl", premises.getAnimals()
				.size(), is(7));
		assertThat("Premises must have 30 events",
				premises.eventHistory().size(), is(30));

		Location location = premises.getLocation();

		assertThat(
				"Logitude is -90.95674265545253,43.47493314332049,338.8866674272697",
				location.getLongitude(), is(-90.95674265545253));

		assertThat("Latitude is 43.47493314332049", location.getLatitude(),
				is(43.47493314332049));

		assertThat("Altitude is 338.8866674272697", location.getAltitude(),
				is(338.8866674272697));

		logger.debug(
				bundleMarker,
				"First event Date={}; DateKey={}; DateTime={}",
				new String[] { premises.eventHistory().get(0).getDate(),
						premises.eventHistory().get(0).getDateKey(),
						premises.eventHistory().get(0).getDateTime().toString() });
		URI locationURI = location.eResource().getURI();
		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();


		store.register(premises);

		assertThat("Must not have changed the uri of the location", location
				.eResource().getURI(), is(locationURI));
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));

		// assertThat("Must not have changed the uri of the placemark",location.getPlace().eResource().getURI(),
		// is(placemarkURI) );
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));
		assertThat(
				"Must have processed 0 animals.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(0));

		assertThat("Premises must have 7 animalsl", premises.getAnimals()
				.size(), is(7));
	}

	@Test
	public void testRecordAnimals() throws IOException {
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);

		assertThat("Premises must have 7 animalsl", premises.getAnimals()
				.size(), is(7));
		assertThat("Premises not enough events",
				premises.eventHistory().size(), is(30));

		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();

		// Now add the animals from the premises
		int totalAnimalsProcessed = store.recordAnimals(premises);

		assertThat("Must have processed 7 animals.", totalAnimalsProcessed,
				is(7));
		assertThat("Must not have changed the uri of the premises", premises
				.eResource().getURI(), is(premisesURI));
		assertThat("Premises must still have 7 animalsl", premises.getAnimals()
				.size(), is(7));
		assertThat("Must not have changed the uri of the first animal",
				premises.getAnimals().get(0).eResource().getURI(),
				is(firstAnimalURI));

		assertThat(
				"Must have added 7 animals.",
				monitorable.getStatusVariable(
						Variables.NEW_ANIMALS_ADDED.statusVarID).getInteger(),
				is(7));
		assertThat("Must have not updated any animals.", monitorable
				.getStatusVariable(Variables.UPDATED_ANIMALS.statusVarID)
				.getInteger(), is(0));

		assertThat(
				"Must have processed 7 animals.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(7));

		assertThat("Must have a last update time.", monitorable
				.getStatusVariable(Variables.LAST_UPDATE_TIME.statusVarID)
				.getString(), is("Thu May 12 16:48:22 CDT 2011"));

	}

	@Test
	public void testMonitorable_ResetStatus() {
		monitorable
				.resetStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID);
		monitorable.resetStatusVariable(Variables.UPDATED_ANIMALS.statusVarID);
		monitorable
				.resetStatusVariable(Variables.TOTAL_ANIMALS_PROCESSED.statusVarID);
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

	@Test
	public void testRetrievePremises_NoDates() throws IOException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.ONE.uri, null, null);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		assertThat("Not a valid premises", TestUtils.isValidObject(premises),
				is(true));
		assertThat("Premises with uri " + Member.ONE.uri, premises,
				is(notNullValue()));
		assertThat("Premises URI is null - " + premises, premises.getUri(),
				is(notNullValue()));
		assertThat("Premises must have 0 animalsl", premises.getAnimals()
				.size(), is(0));

		// logger.debug(bundleMarker,
		// "Retrieve - First event Date={}; DateKey={}; DateTime={}",new
		// String[]{premises.eventHistory().get(0).getDate(),
		// premises.eventHistory().get(0).getDateKey(),premises.eventHistory().get(0).getDateTime().toString()});
	}

	@Test
	public void testRetrievePremises_WithDates() throws ParseException,
			IOException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.ONE.uri, FROMDATE,
				TODATE);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		assertThat("Not a valid premises", TestUtils.isValidObject(premises),
				is(true));
		assertThat("Premises with uri " + Member.ONE.uri, premises,
				is(notNullValue()));
		assertThat("Premises URI must not be null.", premises.getUri(),
				is(notNullValue()));
		assertThat("Premises must have 5 animalsl", premises.getAnimals()
				.size(), is(5));

		Animal firstnimal = null;
		for (Animal animal : premises.getAnimals()) {
			if (animal.getId().equals(FIRST_ANIMAL_ID)) {
				firstnimal = animal;
			}
			logger.debug(bundleMarker, "Animal {} ", animal.getId());
		}

		assertThat("First animal was not found between " + FROMDATE + " and "
				+ TODATE, firstnimal, is(notNullValue()));
		assertThat("First animal must have 8 events.", firstnimal
				.eventHistory().size(), is(8));
		for (Event event : premises.getAnimals().get(0).eventHistory()) {
			assertThat("First animal events must have pid set.",
					event.getPid(), is("urn:pin:H89234X"));
		}

		TestUtils.saveXMIResource("out.premises", premises);

		// logger.debug(bundleMarker,
		// "Retrieve - First event Date={}; DateKey={}; DateTime={}",new
		// String[]{premises.eventHistory().get(0).getDate(),
		// premises.eventHistory().get(0).getDateKey(),premises.eventHistory().get(0).getDateTime().toString()});
	}

	/**
	 * Retrieve the first Animal and test it's container and its children
	 */
	@Test
	public void testRetrieveAnimal_Id() throws IOException,
			InterruptedException {
		Animal animal = store.retrieveAnimal(FIRST_ANIMAL_ID);

		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There should be one tag and one events", animal.getTags()
				.size(), is(1));
		assertThat("There should be eight events",
				animal.eventHistory().size(), is(8));

		// Tag
		Tag tag = animal.activeTag();
		assertThat("Tag should be a proxy to Animal", tag.eResource(),
				is(not(animal.eResource())));

		// Event
		assertThat("Event should be in the same resource as Tag", tag
				.getEvents().get(0).eResource(), is(tag.eResource()));

	}

	/**
	 * Animal -> Tag
	 */
	@Test
	public void testRetrieveAnimal_Normalization() {
		Animal animal = store.retrieveAnimal(FIRST_ANIMAL_ID);

		assertThat("Animal must have id: " + FIRST_ANIMAL_ID, animal.getId(),
				is(FIRST_ANIMAL_ID));
		assertThat("Animal must be a Beef", animal,
				is(instanceOf(BovineBeef.class)));
		assertThat("Not in mongo", animal.eResource().getURI().toString(),
				startsWith("mongodb://"));
		// assertThat(
		// "Animal should be a proxy and not a subdocument in Premises",
		// animal.eResource(), is(not(premises.eResource())));
		assertThat("Animal should NOT have a container", animal.eContainer(),
				is(nullValue()));
		// assertThat("Animal should have same container as location",
		// (Premises) animal.eContainer(), is(premises));

		// Tag
		Tag tag = animal.activeTag();
		assertThat("Not in mongo", tag.eResource().getURI().toString(),
				startsWith("mongodb://"));
		assertThat("Tag should be a proxy to Animal", tag.eResource(),
				is(not(animal.eResource())));

		// Event
		assertThat("Event should be in the same resource as Tag", tag
				.getEvents().get(0).eResource(), is(tag.eResource()));

		// Generic Event
		Event e = animal.eventHistory().get(GENERIC_EVENT);
		assertThat(e, is(instanceOf(GenericEvent.class)));
		GenericEvent ge = (GenericEvent) e;
		OCD ocd = ge.getOcd();
		assertThat("OCD is not null", ocd, is(notNullValue()));
		assertThat("Not in mongo", ocd.eResource().getURI().toString(),
				startsWith("mongodb://"));
		assertThat("OCD should be a proxy to Tag", ocd.eResource(),
				is(not(tag.eResource())));
	}

	/**
	 * Retrieves the first animal in the store and tests its generic event.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testRetrieveAnimal_GenericEvent() throws IOException,
			InterruptedException {
		Animal animal = store.retrieveAnimal(FIRST_ANIMAL_ID);

		Event e = animal.eventHistory().get(GENERIC_EVENT);
		assertThat(e, is(instanceOf(GenericEvent.class)));
		GenericEvent ge = (GenericEvent) e;
		OCD ocd = ge.getOcd();
		assertThat("OCD is not null", ocd, is(notNullValue()));

		assertThat("OCD is a Blood Extraction", ocd.getName(),
				is("Blood Extraction"));
		assertThat("Should have correct value for Blood Weight",
				(Double) ge.value("Blood Weight"), is(.521));
		assertThat("Should have correct value for Measurement Precision",
				(Double) ge.value("Measurement Precision"), is(.001));
		assertThat("Should have correct value for Measurement Unit",
				(String) ge.value("Measurement Unit"), is("kilogram"));
		assertThat("Should have correct value for Percent PCV",
				(Integer) ge.value("Percent PCV"), is(44));

	}

	/**
	 * Retrieves first animal in the store and tests its position event
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testRetrieveAnimal_PositionEvent() throws IOException,
			InterruptedException {
		Animal animal = store.retrieveAnimal(FIRST_ANIMAL_ID);

		Event e = animal.eventHistory().get(POSTION_EVENT);
		assertThat(e, is(instanceOf(Position.class)));
		Position position = (Position) e;

		assertThat("Longitude value is wrong",
				position.getLongitude(), is(-90.95048182270057));
		assertThat("Latitude value is wrong", position.getLatitude(),
				is(43.47622307339506));
	}

	/*
	 * In the shell var start = new Date(2010, 3, 1); var end = new Date(2011,
	 * 5, 1); db.Tag.find( {'events.dateTime': {$gte: start, $lt: end}});
	 */
	@Test
	public void testQuery_DB_driver_BetweenDates() throws UnknownHostException,
			MongoException, ParseException {
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = dfm.parse(FROMDATE);
		Date toDate = dfm.parse(TODATE);
		BasicDBObject query = new BasicDBObject();
		query.put(EVENTS_DATE_TIME,
				new BasicDBObject("$gt", fromDate).append("$lt", toDate));
		int count = db.getCollection("Tag").find(query).count();
		assertThat("Result must be five tags", count, is(5));
	}

	@Test
	public void testQuery_DB_driver_BetweenDates2() throws ParseException,
			UnknownHostException, MongoException {
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = dfm.parse(FROMDATE);
		Date toDate = dfm.parse(TODATE);
		// BasicDBObject query = new BasicDBObject();
		// query.put(EVENTS_DATE_TIME, new BasicDBObject("$gt",
		// fromDate).append("$lt", toDate));
		//
		// Should change the query to use an $elemMatch
		// db.Tag.find({events: {$elemMatch: {dateTime: {$gte: start, $lt:
		// end},pid: 'urn:pin:003ALKM'}} })

		BasicDBObject dateMatch = new BasicDBObject();
		dateMatch.put("dateTime",
				new BasicDBObject("$gte", fromDate).append("$lt", toDate));

		BasicDBObject elementMatch = new BasicDBObject();
		elementMatch.put("$elemMatch", dateMatch.append("pid", Member.ONE.uri));
		BasicDBObject queryd = new BasicDBObject("events", elementMatch);

		logger.info(bundleMarker, "query: {}", queryd);

		// From shell
		// db.Tag.find(
		// {events: {$elemMatch:
		// {
		// dateTime: {$gte: start, $lt: end},
		// pid: 'urn:pin:H89234X'
		// }
		// }
		// }
		// ).count()
		int count = db.getCollection("Tag").find(queryd).count();
		assertThat("Result must be five tags", count, is(5));
	}

	/**
	 * 
	 */
	@Test
	public void testQuery_Tag_Id() {
		@SuppressWarnings("unused")
		String simple_query = "id=='" + FIRST_ANIMAL_ID + "'";
		String query = "{'id' : '" + FIRST_ANIMAL_ID + "'}";
		List<EObject> eo = store.query(TrackerPackage.Literals.TAG, query);
		assertThat("Result must not be null.", eo, is(notNullValue()));
		assertThat("Result must not be empty.", eo.isEmpty(), is(false));
		assertThat("Result must be one tag", eo.size(), is(1));
		assertThat("Result must be a Tag", eo.get(0), is(instanceOf(Tag.class)));

	}

	/**
	 * Works QUERY {'events.dateTime' : {$gt : new Date(2010, 02, 01)}}
	 */
	@Test
	public void testQuery_Tag_FromDate() {
		// String simpleQuery =EVENTS_DATE_TIME+" > "+FROMDATE;
		String query = "{'" + EVENTS_DATE_TIME + "' : {$gt : " + FROMDATE_JSON
				+ "}}";
		List<EObject> eo = store.query(TrackerPackage.Literals.TAG, query);
		assertThat("Result must not be null.", eo, is(notNullValue()));
		assertThat("Result must not be empty.", eo.isEmpty(), is(false));
		assertThat("Result must be seven tags", eo.size(), is(7));
		assertThat("Result must be a Tag", eo.get(0), is(instanceOf(Tag.class)));
	}

	/**
	 * 
	 * {'events.dateTime' : {$lt : new Date(2011, 04, 01)}} expects 5 tags
	 */
	@Test
	public void testQuery_Tag_ToDate() {
		// String simplequery =EVENTS_DATE_TIME+" < "+TODATE;
		String query = "{'" + EVENTS_DATE_TIME + "' : {$lt : " + TODATE_JSON
				+ "}}";
		List<EObject> eo = store.query(TrackerPackage.Literals.TAG, query);
		assertThat("Result must not be null.", eo, is(notNullValue()));
		assertThat("Result must not be empty.", eo.isEmpty(), is(false));
		assertThat("Result must be five tags", eo.size(), is(5));
		assertThat("Result must be a Tag", eo.get(0), is(instanceOf(Tag.class)));
	}

	/**
	 * 
	 * {'events.dateTime' : {$gte :new Date(2010, 02, 01), $lt : new Date(2011,
	 * 04, 01)}}
	 */
	@Test
	public void testQuery_Tag_BetweenDates() {
		// String query = '('+EVENTS_DATE_TIME+" > "+FROMDATE
		// +") && ("+EVENTS_DATE_TIME+" < "+TODATE+')';
		String query = "{'" + EVENTS_DATE_TIME + "' : {$gte :" + FROMDATE_JSON
				+ ", $lt : " + TODATE_JSON + "}}";
		List<EObject> eo = store.query(TrackerPackage.Literals.TAG, query);
		assertThat("Result must not be null.", eo, is(notNullValue()));
		assertThat("Result must not be empty.", eo.isEmpty(), is(false));
		assertThat("Result must be one tag", eo.size(), is(5));
		assertThat("Result must be a Tag", eo.get(0), is(instanceOf(Tag.class)));
	}

}
