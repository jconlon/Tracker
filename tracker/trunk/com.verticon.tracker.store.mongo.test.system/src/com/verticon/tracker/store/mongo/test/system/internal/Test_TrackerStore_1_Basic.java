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

import static com.verticon.tracker.store.mongo.test.system.internal.Configuator.MONGO_LOCALHOST;
import static com.verticon.tracker.store.mongo.test.system.internal.TestUtils.getXMIResource;
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
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.verticon.agriculture.Agriculture;
import com.verticon.agriculture.AgricultureFactory;
import com.verticon.agriculture.AgriculturePackage;
import com.verticon.agriculture.Location;
import com.verticon.opengis.kml.Container;
import com.verticon.opengis.kml.Folder;
import com.verticon.opengis.kml.KmlFactory;
import com.verticon.opengis.kml.KmlPackage;
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
import com.verticon.tracker.store.StoreAccessException;
import com.verticon.tracker.store.ValidationException;
import com.verticon.tracker.store.admin.Admin;
import com.verticon.tracker.store.admin.AdminPackage;
import com.verticon.tracker.store.admin.api.ITrackerStoreAdmin;
import com.verticon.tracker.util.TrackerValidator;

/**
 * 
 * Basic testing of the com.verticon.tracker.store.mongo component and its primary
 * class TrackerStore.  The c.v.t.store.mongo.TrackerStore
 * saves and retrieves Tracker elements to a MongoDB.
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

	private static final String DOC_AGRI_INVALID_LOCATION = "badDoc.agri";

	 static final String DOC_AGRI_VALID = "doc.agri";
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
	
	private static final String FROMDATE_JSON = "new Date(2010, 02, 01)";//"2010-03-01";
	private static final String TODATE_JSON = "new Date(2011, 04, 01)"; //"2011-05-01";
	

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

	private static BundleContext context;
	/**
	 * This class is a JUnit class and a DS component. There needs to be 
	 * a synchronization between the DS and JUnit initializations. 
	 * This is done with a java.util.concurrent.CountDownLatch. 
	 * 
	 * In the JUnit setUp() method the startUpGate.await() will be called 
	 * which will block until all DS services are injected.  When all services 
	 * are injected and DS calls the startup() method startUpGate.countDown() is 
	 * called unblocking the thread waiting in the setUp().  Once tripped the latch
	 * lets subsequent calls through.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);

	/**
	 * Injected services
	 */
	 static ITrackerStore store;
	 static Monitorable monitorable;
	 static IController controller;
	 static ITrackerStoreAdmin loader;


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

	public void setAdminLoader(ITrackerStoreAdmin loader){
		logger.debug(bundleMarker, "DS injecting the loader");
		Test_TrackerStore_1_Basic.loader = loader;
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
		// System.out.println(this + ": startup and setUp finished.");
		
		//Setup the Mongo JSON query environment
		new MongoQueryStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
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
		Test_TrackerStore_1_Basic.context = context;
		startUpGate.countDown();
		
	}

	@Test
	public void testContext() throws InterruptedException, UnknownHostException, MongoException {
		assertThat("BundleContext was not setup", context, is(notNullValue()));
		assertThat("TrackerStore was not setup", store, is(notNullValue()));
		assertThat("Monitorable was not setup", monitorable, is(notNullValue()));
		assertThat("Controller was not setup", controller, is(notNullValue()));
		assertThat("Controller must have wires", controller.hasWires(), is(true));
		assertThat("Loader must be setup", loader, is(notNullValue()));

		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);
		TestUtils.clearDB(db);
		monitorable.resetStatusVariable(Variables.MONGO_ADMIN_LOADED.statusVarID);

		TimeUnit.SECONDS.sleep(2);
		
	}

	/**
	 * @throws MongoException
	 * @throws UnknownHostException
	 * 
	 */
	@Test
	public void testMongoDB_InitialStateOfCollections() throws UnknownHostException,
			MongoException {
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
		assertThat(
				"Must have index on Tag for geolocation",
				TestUtils.hasIndexedIDAttribute(TrackerPackage.Literals.TAG.getName(), db, "events.loc_2d"),
				is(true));
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
		
		//Admin
		coll = db.getCollection(AdminPackage.Literals.ADMIN.getName());
		assertThat("Admin collection must exist.",
				db.collectionExists(AdminPackage.Literals.ADMIN.getName()),
				is(true));
		assertThat("No docs", coll.find().count(), is(0));
		
		// Location
		assertThat("Location collection must exist.",
				db.collectionExists(AgriculturePackage.Literals.LOCATION.getName()),
				is(true));
		assertThat(
				"Must have loc as an index in Location for geolocation",
				TestUtils.hasIndexedIDAttribute(AgriculturePackage.Literals.LOCATION.getName(), db, "loc_2d"),
				is(true));
		coll = db.getCollection(AgriculturePackage.Literals.LOCATION.getName());
		assertThat("No docs", coll.find().count(), is(0));
				
		
		//Container
		coll = db.getCollection(KmlPackage.eINSTANCE.getContainer().getName());
		assertThat("Admin collection must exist.",
				db.collectionExists(KmlPackage.eINSTANCE.getContainer().getName()),
				is(true));
		assertThat("No docs", coll.find().count(), is(0));
		
		//Placemark is now deprecated
		assertThat("Placemark collection must NOT exist.",
				db.collectionExists(KmlPackage.eINSTANCE.getPlacemark().getName()),
				is(false));
		
		

	}
	
	public void testPreLoaderState(){
		StatusVariable isAdmin = monitorable.getStatusVariable(Variables.IS_ADMINISTRATOR.statusVarID);
		assertThat("Must be Admin", isAdmin.getBoolean(), is(true));
		
		StatusVariable isPub = monitorable.getStatusVariable(Variables.IS_PUBLISHER.statusVarID);
		assertThat("Must be Publisher", isPub.getBoolean(), is(true));
		
		StatusVariable isLoaded = monitorable.getStatusVariable(Variables.MONGO_ADMIN_LOADED.statusVarID);
		assertThat("Must not have loaded admin", isLoaded.getBoolean(), is(false));
	}
	
	public void testLoader() throws IOException, InterruptedException{
		logger.debug(bundleMarker, "starting testLoader");
		Resource resource = getXMIResource(DOC_ADMIN,"");
		Admin admin = (Admin) resource.getContents().get(0);
		assertNotNull("Admin doc was not loaded from the file.", admin);
		logger.debug(bundleMarker, "loading admin");
		boolean isLoaded = loader.load(admin);
		logger.debug(bundleMarker, "loaded admin");
		assertThat("Must have loaded admin", isLoaded, is(true));

	}
	
	public void testPostLoaderState(){
		logger.debug(bundleMarker, "starting testPostLoaderState");
		StatusVariable isAdmin = monitorable.getStatusVariable(Variables.IS_ADMINISTRATOR.statusVarID);
		assertThat("Must be Admin", isAdmin.getBoolean(), is(true));
		
		StatusVariable isPub = monitorable.getStatusVariable(Variables.IS_PUBLISHER.statusVarID);
		assertThat("Must be Publisher", isPub.getBoolean(), is(true));
		
		StatusVariable isLoaded = monitorable.getStatusVariable(Variables.MONGO_ADMIN_LOADED.statusVarID);
		assertThat("Must have loaded admin", isLoaded.getBoolean(), is(true));
	}
	
	@Test
	public void testMonitorable_StatusVariables_Presence() {
		logger.debug(bundleMarker, "starting testMonitorable_StatusVariables_Presence");
		String[] varNames = monitorable.getStatusVariableNames();
		assertNotNull("Monitorable was not setup", varNames);
		
		assertThat("Must have all the StatusVariableNames",
				monitorable.getStatusVariableNames().length,
				is(Variables.values().length));

		// assertThat("First var should have description",
		// monitorable.getStatusVariable("external.Name"),
		// is(notNullValue()));

		// assertThat("Port should have a var",
		// monitorable.getStatusVariable(Variables.PORT.statusVarID),
		// is(notNullValue()));

		for (Variables var : Variables.values()) {
			StatusVariable sv = null;
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
	@Test
	public void testMonitorable_Get_StatusVariables() {
		assertThat("Variable Status must be Connected",
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
	


	/**
	 * What happens when recording a null.
	 */
	@Test
	public void testRegister_NullAgrument() {
		try {
			store.register(null);
			fail("Should throw an illegal argument exception.");
		} catch (NullPointerException e) {
			assertThat("Location must not be null.", e.getMessage(),
					is("Location must not be null."));
		} catch (IOException e) {
			fail("Should throw an illegal argument exception.");
		}
	}

	/**
	 * Location must have a geography and a Premises with a
	 * URI
	 */
	@Test
	public void testRegister_NullGeographyAndLivestock() {
		Location location = AgricultureFactory.eINSTANCE.createLocation();
		try {
			store.register(location);
			fail("Should throw an validation exception.");
		} catch (ValidationException e){
			//expected
		} catch (IOException e) {
			fail("Should throw an validation exception.");
		}
	}

	/**
	 * Location must have a geography but does not need to have a Premises or a
	 * URI
	 */
	@Test
	public void testRegister_WithForiegnPremisesUri() {
		Location location = AgricultureFactory.eINSTANCE.createLocation();
		Folder folder = KmlFactory.eINSTANCE.createFolder();
//		Placemark placemark = KmlFactory.eINSTANCE.createPlacemark();
//		placemark.setId(Member.TWO.uri.replace(':', '.'));
//		placemark.setName("name");
//		placemark.setAddress("E6055 Cina Rd.");
//		Point point = createPoint(placemark);
//		List<String> coordinates = new ArrayList<String>();
//		coordinates.add("-90.95674265545253,43.47493314332049,338.8866674272697");
//		point.setCoordinates(coordinates);
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri(Member.TWO.uri);// Should be
										// premises.setPremisesId(Member.ONE.pin);
		location.setLivestock(premises);
		location.setGeography(folder);
		location.setName("test");
		location.setDescription("test");
		location.setStreet("test");
		location.setCity("test");
		location.setState("test");
		location.setPostalCode("test");
		location.setLongitude(111);
		location.setLatitude(-111);
		location.setAltitude(999);
		location.setPhoneNumber("test");

		
		try {
			store.register(location);
			fail("Should throw an StoreAccessException.");
		} catch (StoreAccessException e) {
			assertThat(
					"should have a error for uri, but got: " + e.getMessage(),
					e.getMessage(),
					startsWith("Attempt to save location with a foriegn uri on the "));
		} catch (IOException e) {
			fail("Should throw a StoreAccessException, but was: "
					+ e.getMessage());
		}
		
	}
	
//	private Point createPoint(Placemark placemark) {
//		EStructuralFeature documentRootPointFeature = KmlPackage.eINSTANCE
//				.getDocumentRoot_Point();
//		Point point = KmlFactory.eINSTANCE.createPoint();
//
//		EStructuralFeature f = KmlPackage.eINSTANCE
//				.getPlacemark_AbstractGeometryGroupGroup();
//
//		placemark.getAbstractGeometryGroupGroup().add(f,
//				FeatureMapUtil.createEntry(documentRootPointFeature, point));
//		return point;
//
//	}

//	@Test
//	public void testRegister_WithNullPlace() {
//		Location location = AgricultureFactory.eINSTANCE.createLocation();
//		Premises premises = TrackerFactory.eINSTANCE.createPremises();
//		premises.setUri(Member.ONE.uri);
//		location.setLivestock(premises);
//		try {
//			store.register(location);
//			fail("Should throw an validation exception.");
//		} catch (ValidationException e) {
//			assertThat(
//					"should have a error for geography, but got: "
//							+ e.getMessage(),
//					e.getMessage()
//							.contains(
//									"Location is not valid. The required feature 'place' of 'com.verticon.agriculture.impl.LocationImpl"),
//					is(true));
//			assertThat("should have a error for geography", e.getMessage()
//					.contains("must be set"), is(true));
//		} catch (IOException e) {
//			logger.error(bundleMarker, this + ": failed test", e);
//			fail("Should throw an validation exception, but was: "
//					+ e.getMessage());
//		}
//
//	}
	@Test
	public void testValidation_Uri() throws InterruptedException{
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri("jc://www.verticon");
		TrackerValidator validator = TrackerValidator.INSTANCE;
		assertThat("Premises must not validate", validator.validate(premises, null, null), is(false));
		premises.setUri("ok");
		assertThat("Premises must validate", validator.validate(premises, null, null), is(true));
	}
	
	@Test
	public void testValidation_Service_Uri() throws ValidationException{
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri("jc://www.verticon");

		try {
			validateObject(premises);
			fail("Validation must throw an exception.");
		} catch (Exception e) {
			//expected
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
			//expected
		}
		premises.setUri("normal");
		assertThat("Premises must validate.", validateObject(premises), is(true));
		animal.activeTag().setId("good");
		assertThat("Animal must validate.", validateObject(animal), is(true));
	}
	
	static boolean validateObject(EObject eObject) throws ValidationException {
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
	@Test
	public void testRegister_InvalidLocation()  {
		logger.debug(bundleMarker, "starting testUpdateLocation");
		Resource resource = getXMIResource(DOC_AGRI_INVALID_LOCATION,"");
		Agriculture agri = (Agriculture) resource.getContents().get(0);
		Location location = agri.getLocation().get(0);
		try {
			store.register(location);
			fail("Must throw a ValidationException.");
		} catch (IOException e) {
			assertThat("Update must throw a ValidationException",e.getMessage(), 
					startsWith("Location is not valid. The required feature 'uri' of "));
		}

	}
	@Test
	public void testRegister() throws IOException {
		logger.debug(bundleMarker, "starting testUpdateLocation");
		Resource resource = getXMIResource(DOC_AGRI_VALID,"");
		Agriculture agri = (Agriculture) resource.getContents().get(0);
		assertTrue("Agriculture doc must be valid",
				TestUtils.isValidObject(agri));
		assertThat(agri, is(notNullValue()));
		Location location = agri.getLocation().get(0);
		assertThat("Not a valid location", TestUtils.isValidObject(location),
				is(true));
		Premises premises = location.getLivestock();
		assertThat("Premises must have 7 animalsl",
				premises.getAnimals().size(), is(7));
		assertThat("Premises not enough events",
				premises.eventHistory().size(), is(30));
		
		Container container = location.getGeography();
		assertThat("Container cannot be null.", container, is(notNullValue()));
		

		assertThat("Logitude is -90.95674265545253,43.47493314332049,338.8866674272697",location.getLongitude(),
				is(-90.95674265545253));
		
		assertThat("Latitude is 43.47493314332049",location.getLatitude(),
				is(43.47493314332049));
		
		assertThat("Altitude is 338.8866674272697",location.getAltitude(),
				is(338.8866674272697));
		

		logger.debug(bundleMarker, "First event Date={}; DateKey={}; DateTime={}",new String[]{premises.eventHistory().get(0).getDate(),
				premises.eventHistory().get(0).getDateKey(),premises.eventHistory().get(0).getDateTime().toString()});
		URI locationURI = location.eResource().getURI();
		URI premisesURI = premises.eResource().getURI();
		URI containerURI = location.getGeography().eResource().getURI();
//		URI placemarkURI = location.getPlace().eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();
		
		store.register(location);
		assertThat("Must not have changed the uri of the location",location.eResource().getURI(), is(locationURI) );
		assertThat("Must not have changed the uri of the premises",premises.eResource().getURI(), is(premisesURI) );
		assertThat("Must not have changed the uri of the container",location.getGeography().eResource().getURI(), 
				is(containerURI) );
//		assertThat("Must not have changed the uri of the placemark",location.getPlace().eResource().getURI(), 
//				is(placemarkURI) );
		assertThat("Must not have changed the uri of the first animal",premises.getAnimals().get(0).eResource().getURI(), 
				is(firstAnimalURI) );
		assertThat(
				"Must have processed 0 animals.",
				monitorable.getStatusVariable(
						Variables.TOTAL_ANIMALS_PROCESSED.statusVarID)
						.getInteger(), is(0));
		
		assertThat("Premises must have 7 animalsl",
				premises.getAnimals().size(), is(7));
	}

	@Test
	public void testRecordAnimals() throws IOException {
		
		Resource resource = getXMIResource(DOC_AGRI_VALID,"");
		Agriculture agri = (Agriculture) resource.getContents().get(0);
		assertTrue("Agriculture doc must be valid",
				TestUtils.isValidObject(agri));
		assertThat(agri, is(notNullValue()));
		Location location = agri.getLocation().get(0);
		assertThat("Not a valid location", TestUtils.isValidObject(location),
				is(true));
		Premises premises = location.getLivestock();
		assertThat("Premises must have 7 animalsl",
				premises.getAnimals().size(), is(7));
		assertThat("Premises not enough events",
				premises.eventHistory().size(), is(30));
		
		
		URI premisesURI = premises.eResource().getURI();
		URI firstAnimalURI = premises.getAnimals().get(0).eResource().getURI();
		
		
		
		//Now add the animals from the premises
		int totalAnimalsProcessed = store.recordAnimals(premises);
		assertThat(
				"Must have processed 7 animals.",
				totalAnimalsProcessed, is(7));
		assertThat("Must not have changed the uri of the premises",premises.eResource().getURI(), is(premisesURI) );
		assertThat("Premises must still have 7 animalsl",
				premises.getAnimals().size(), is(7));
		assertThat("Must not have changed the uri of the first animal",premises.getAnimals().get(0).eResource().getURI(), 
				is(firstAnimalURI) );
		
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

		
		assertThat(
				"Must have a last update time.",
				monitorable.getStatusVariable(
						Variables.LAST_UPDATE_TIME.statusVarID)
						.getString(), is("Thu May 12 16:48:22 CDT 2011"));

	}
	
	
	@Test
	public void testMonitorable_ResetStatus() {
		monitorable.resetStatusVariable(Variables.NEW_ANIMALS_ADDED.statusVarID);
		monitorable.resetStatusVariable(Variables.UPDATED_ANIMALS.statusVarID);
		monitorable.resetStatusVariable(Variables.TOTAL_ANIMALS_PROCESSED.statusVarID);
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
	public void testRetrievePremises_NoDates() throws ParseException {
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
		assertThat("Premises must have 0 animalsl",
				premises.getAnimals().size(), is(0));
		
//		logger.debug(bundleMarker, "Retrieve - First event Date={}; DateKey={}; DateTime={}",new String[]{premises.eventHistory().get(0).getDate(),
//				premises.eventHistory().get(0).getDateKey(),premises.eventHistory().get(0).getDateTime().toString()});
	}
	@Test
	public void testRetrievePremises_WithDates() throws ParseException, IOException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = store.retrievePremises(Member.ONE.uri, FROMDATE, TODATE);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		assertThat("Not a valid premises", TestUtils.isValidObject(premises),
				is(true));
		assertThat("Premises with uri " + Member.ONE.uri, premises,
				is(notNullValue()));
		assertThat("Premises URI must not be null.", premises.getUri(),
				is(notNullValue()));
		assertThat("Premises must have 5 animalsl",
				premises.getAnimals().size(), is(5));
		
		Animal firstnimal =null;
		for (Animal animal : premises.getAnimals()) {
			if(animal.getId().equals(FIRST_ANIMAL_ID)){
				firstnimal=animal;
			}
			logger.debug(bundleMarker,"Animal {} ",animal.getId());
		}
		
		assertThat("First animal was not found between "+FROMDATE+" and "+TODATE,firstnimal,is(notNullValue()));
		assertThat("First animal must have 8 events.",
				firstnimal.eventHistory().size(), is(8));
		for (Event event : premises.getAnimals().get(0).eventHistory()) {
			assertThat("First animal events must have pid set.",
					event.getPid(), is("urn:pin:H89234X"));
		}
		
		
		TestUtils.saveXMIResource("out.premises", premises);
		
//		logger.debug(bundleMarker, "Retrieve - First event Date={}; DateKey={}; DateTime={}",new String[]{premises.eventHistory().get(0).getDate(),
//				premises.eventHistory().get(0).getDateKey(),premises.eventHistory().get(0).getDateTime().toString()});
	}

	@Test
	public void testRetrieveLocation_Uri() throws IOException {
		Location location = store.retrieveLocation(Member.ONE.uri);
		assertThat("Could not retrieve the location", location,
				is(notNullValue()));
		assertThat("Not in mongo localhost tracker Location collection", location.eResource().getURI().toString(),
				startsWith(MONGO_LOCALHOST+"/tracker/Location"));
		assertThat("Not a valid location", TestUtils.isValidObject(location),
				is(true));
		
		assertThat("Logitude is -90.95674265545253,43.47493314332049,338.8866674272697",location.getLongitude(),
				is(-90.95674265545253));
		
		assertThat("Latitude is 43.47493314332049",location.getLatitude(),
				is(43.47493314332049));
		
		assertThat("Altitude is 338.8866674272697",location.getAltitude(),
				is(338.8866674272697));

		//Livestock
		Premises premises = location.getLivestock();
		assertThat("Not in mongo localhost tracker Premises collection", premises.eResource().getURI().toString(),
				startsWith(MONGO_LOCALHOST+"/tracker/Premises"));
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		assertThat("Not a valid premises", TestUtils.isValidObject(premises),
				is(true));
		assertThat("Premises with uri " + Member.ONE.uri, premises,
				is(notNullValue()));
		assertThat("Premises URI is null - " + premises, premises.getUri(),
				is(notNullValue()));
		assertThat("Premises should have no animalsl",
				premises.getAnimals().size(), is(0));
		
		//Geography
		Container container = location.getGeography();
		assertThat("Could not retrieve the container", container,
				is(notNullValue()));
		assertThat("Not in mongo localhost tracker Container collection", container.eResource().getURI().toString(),
				startsWith(MONGO_LOCALHOST+"/tracker/Container"));
		assertThat("Not a valid container", TestUtils.isValidObject(container),
				is(true));
		assertThat("Premises with uri " + Member.ONE.uri, premises,
				is(notNullValue()));
		assertThat("Premises URI is null - " + premises, premises.getUri(),
				is(notNullValue()));
		
		
//		//Placemark
//		Placemark placemark = location.getPlace();
//		assertThat("Could not retrieve the placemark", placemark,
//				is(notNullValue()));
//		assertThat("Not in mongo localhost tracker placemark ", placemark.eResource().getURI().toString(),
//				startsWith(MONGO_LOCALHOST+"/tracker/Placemark"));
//		assertThat("Not a valid placemark", TestUtils.isValidObject(placemark),
//				is(true));
//		assertThat("Geometry must not be null",placemark.getAbstractGeometryGroup(), is(notNullValue()));
//		assertThat("Geometry must be a Point",placemark.getAbstractGeometryGroup(), is(instanceOf(Point.class)));
//		Point point = (Point)placemark.getAbstractGeometryGroup();
//
//		String coordinates = getCoordinates(point);
//		assertThat("Coordinates are -90.95674265545253,43.47493314332049,338.8866674272697",coordinates,
//				is("-90.95674265545253,43.47493314332049,338.8866674272697"));
		
	}

	/**
	 * Location -> Container Location -> Premises -> Animal -> Tag
	 */
	@Test
	public void testRetrieveLocation_Normalization() {
		Location location = store.retrieveLocation(Member.ONE.uri);
		assertThat("Could not retrieve the location", location,
				is(notNullValue()));
		assertThat("Not a valid location", TestUtils.isValidObject(location),
				is(true));
		// Container
		assertThat("Container should be a proxy to Location",
				location.eResource(), is(not(location.getGeography()
						.eResource())));
		assertThat("Not in mongo localhost tracker Container collection", location.getGeography().eResource().getURI().toString(),
				startsWith(MONGO_LOCALHOST+"/tracker/Container"));
		
//		// Placemark
//		assertThat("Placemark should be a proxy to Location",
//						location.eResource(), is(not(location.getPlace()
//								.eResource())));
//				assertThat("Not in mongo localhost tracker Placemark collection", 
//						location.getPlace().eResource().getURI().toString(),
//						startsWith(MONGO_LOCALHOST+"/tracker/Placemark"));

		// Premises
		Premises premises = location.getLivestock();
		assertThat("Premises should be a proxy to Location",
				location.eResource(), is(not(premises.eResource())));
		assertThat("Not in mongo localhost tracker Premises collection", premises.eResource().getURI().toString(),
				startsWith(MONGO_LOCALHOST+"/tracker/Premises"));
		
		
	}

	/**
	 * Retrieve the first Animal and test it's container and its children
	 */
	@Test
	public void testRetrieveAnimal_Id() throws IOException, InterruptedException {
		Animal animal = store.retrieveAnimal(FIRST_ANIMAL_ID);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There should be one tag and one events", animal.getTags()
				.size(), is(1));
		assertThat("There should be eight events",
				animal.eventHistory().size(), is(8));

		Location location = store.retrieveLocation(Member.ONE.uri);
		assertThat("Could not retrieve the location", location,
				is(notNullValue()));

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
		assertThat("Animal must have id: "+FIRST_ANIMAL_ID,animal.getId(),is(FIRST_ANIMAL_ID));
		assertThat("Animal must be a Beef",animal, is(instanceOf(BovineBeef.class)));
		assertThat("Not in mongo", animal.eResource().getURI().toString(),
				startsWith("mongodb://"));
//		assertThat(
//				"Animal should be a proxy and not a subdocument in Premises",
//				animal.eResource(), is(not(premises.eResource())));
		assertThat("Animal should NOT have a container", animal.eContainer(),
				is(nullValue()));
//		assertThat("Animal should have same container as location",
//				(Premises) animal.eContainer(), is(premises));
		

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
				(Double) position.getLongitude(), is(-90.95048182270057));
		assertThat("Latitude value is wrong", (Double) position.getLatitude(),
				is(43.47622307339506));
	}

	/*
	 * In the shell
	 * var start = new Date(2010, 3, 1);
	 * var end = new Date(2011, 5, 1);
	 * db.Tag.find( {'events.dateTime': {$gte: start, $lt: end}});
	 */
	@Test
	public void testQuery_DB_driver_BetweenDates() throws UnknownHostException, MongoException, ParseException{
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = dfm.parse(FROMDATE);
		Date toDate = dfm.parse(TODATE);
		BasicDBObject query = new BasicDBObject();
		query.put(EVENTS_DATE_TIME,  new BasicDBObject("$gt", fromDate).append("$lt", toDate));
		int count = db.getCollection("Tag").find(query).count();
		assertThat("Result must be five tags", count, is(5));
	}
	
	@Test
	public void testQuery_DB_driver_BetweenDates2() throws ParseException, UnknownHostException, MongoException{
		Mongo m = new Mongo();
		DB db = m.getDB("tracker");
		assertNotNull(db);
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = dfm.parse(FROMDATE);
		Date toDate = dfm.parse(TODATE);
//		BasicDBObject query = new BasicDBObject();
//		query.put(EVENTS_DATE_TIME,  new BasicDBObject("$gt", fromDate).append("$lt", toDate));
//		
		//Should change the query to use an $elemMatch
		// db.Tag.find({events: {$elemMatch: {dateTime: {$gte: start, $lt: end},pid: 'urn:pin:003ALKM'}} })
	
		
		BasicDBObject dateMatch = new BasicDBObject();
		dateMatch.put("dateTime",new BasicDBObject("$gte",fromDate).append("$lt", toDate));
		
		BasicDBObject elementMatch = new BasicDBObject();
		elementMatch.put("$elemMatch", dateMatch.append("pid", Member.ONE.uri));
		BasicDBObject queryd = new BasicDBObject("events",elementMatch);

		logger.info(bundleMarker, "query: {}",queryd);
		
		// From shell
		// db.Tag.find(
		//       {events: {$elemMatch: 
		//                  {
		//                       dateTime: {$gte: start, $lt: end},
		//                       pid: 'urn:pin:H89234X'
		//                  }
		//                 } 
		//        }
		//).count()
		
		int count = db.getCollection("Tag").find(queryd).count();
		assertThat("Result must be five tags", count, is(5));
	}

	/**
	 * 
	 */
	@Test
	public void testQuery_Tag_Id(){
		@SuppressWarnings("unused")
		String simple_query = "id=='"+FIRST_ANIMAL_ID+"'";
		String query="{'id' : '"+FIRST_ANIMAL_ID+"'}";
		List<EObject> eo = store.query(TrackerPackage.Literals.TAG, query);
		assertThat("Result must not be null.", eo, is(notNullValue()));
		assertThat("Result must not be empty.",eo.isEmpty(), is(false));
		assertThat("Result must be one tag", eo.size(), is(1));
		assertThat("Result must be a Tag",eo.get(0), is(instanceOf(Tag.class)));
		
	}
	
	/**
	 * Works 
	 * QUERY {'events.dateTime' : {$gt : new Date(2010, 02, 01)}} 
	 */
	@Test
	public void testQuery_Tag_FromDate(){
//		String simpleQuery =EVENTS_DATE_TIME+" > "+FROMDATE;
		String query ="{'"+EVENTS_DATE_TIME+"' : {$gt : "+FROMDATE_JSON+"}}";
		List<EObject> eo = store.query(TrackerPackage.Literals.TAG, query);
		assertThat("Result must not be null.", eo, is(notNullValue()));
		assertThat("Result must not be empty.",eo.isEmpty(), is(false));
		assertThat("Result must be seven tags", eo.size(), is(7));
		assertThat("Result must be a Tag",eo.get(0), is(instanceOf(Tag.class)));
	}
	
	/**
	 * 
	 * {'events.dateTime' : {$lt : new Date(2011, 04, 01)}} 
	 * expects 5 tags 
	 */
	@Test
	public void testQuery_Tag_ToDate(){
//		String simplequery =EVENTS_DATE_TIME+" < "+TODATE;
		String query = "{'"+EVENTS_DATE_TIME+"' : {$lt : "+TODATE_JSON+"}}";
		List<EObject> eo = store.query(TrackerPackage.Literals.TAG, query);
		assertThat("Result must not be null.", eo, is(notNullValue()));
		assertThat("Result must not be empty.",eo.isEmpty(), is(false));
		assertThat("Result must be five tags", eo.size(), is(5));
		assertThat("Result must be a Tag",eo.get(0), is(instanceOf(Tag.class)));
	}
	

	/**
	 * 
	 * {'events.dateTime' : {$gte :new Date(2010, 02, 01), $lt : new Date(2011, 04, 01)}} 
	 */
	@Test
	public void testQuery_Tag_BetweenDates(){
//		String query = '('+EVENTS_DATE_TIME+" > "+FROMDATE +") && ("+EVENTS_DATE_TIME+" < "+TODATE+')';
		String query = "{'"+EVENTS_DATE_TIME+"' : {$gte :"+FROMDATE_JSON +", $lt : "+TODATE_JSON+"}}";
		List<EObject> eo = store.query(TrackerPackage.Literals.TAG, query);
		assertThat("Result must not be null.", eo, is(notNullValue()));
		assertThat("Result must not be empty.",eo.isEmpty(), is(false));
		assertThat("Result must be one tag", eo.size(), is(5));
		assertThat("Result must be a Tag",eo.get(0), is(instanceOf(Tag.class)));
	}
	
	

}
