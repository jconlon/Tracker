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

package com.verticon.mongo.emf.transform.test.system;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.mongo.emf.transform.test.system.Configuator.bundleMarker;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.verticon.mongo.IMongoClientProvider;
import com.verticon.mongo.emf.transform.IFunctionProvider;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;

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
public class Test_Mongo_EMF_FunctionProvider extends TestCase {

	private static final int NUMBER_OF_ITERATIONS = 1;

	private static final String ANIMAL_COLLECTION = "Animal";

	private static final String TAG_COLLECTION = "Tag";

	private static final String PREMISES_COLLECTION = "Premises";

	private static final String OCD_COLLECTION = "OCD";

	private static final String DB_NAME = "test_functionProvider";

	private static final String TAG_ID_1 = "1234567890";

	private static final String TAG_ID_WITH_GENERIC_EVENT = "840456789012341";

	private static final String FILE_TMP_OUT_PREMISES1 = "/tmp/out1.premises";

	private static final String FILE_TMP_OUT_PREMISES2 = "/tmp/out2.premises";

	private static final String FILE_TMP_OUT_PREMISES3 = "/tmp/out3.premises";

	private static final String PREMISES_URI = "jc://www.verticon";
	static final String DOC_PREMISES = "example.premises";



	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_Mongo_EMF_FunctionProvider.class);

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
	static IFunctionProvider functionProvider;
	static IMongoClientProvider iMongoClientProvider;

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void setFunctionProvider(IFunctionProvider functionProvider) {
		logger.debug(bundleMarker, "DS injecting the functionProvider");
		Test_Mongo_EMF_FunctionProvider.functionProvider = functionProvider;
	}

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void unsetFunctionProvider(IFunctionProvider functionProvider) {
		logger.debug(bundleMarker, "DS injecting the functionProvider");
		Test_Mongo_EMF_FunctionProvider.functionProvider = null;
	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_Mongo_EMF_FunctionProvider.iMongoClientProvider = iMongoClientProvider;

	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_Mongo_EMF_FunctionProvider.iMongoClientProvider = null;

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

	}

	void deactivate() {

	}

	@Test
	public void testRemoveDocsFromCollections() throws InterruptedException {
		// TimeUnit.SECONDS.sleep(1);
		DBCollection coll = getCollection(DB_NAME, ANIMAL_COLLECTION);
		DBObject find = new BasicDBObject();
		coll.remove(find);
		coll = getCollection(DB_NAME, PREMISES_COLLECTION);
		coll.remove(find);
		coll = getCollection(DB_NAME, OCD_COLLECTION);
		coll.remove(find);
		coll = getCollection(DB_NAME, TAG_COLLECTION);
		coll.remove(find);
	}

	@Test
	public void test_Premises_Transform() throws UnknownHostException {
		Premises premisesIn = createPremises();
		premisesIn.setName("Jack Condor");
		Function<EObject, DBObject> eTod = functionProvider
				.getEObjectToDBObjectFunction();
		DBObject dbObject = eTod.apply(premisesIn);

		//
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(""));

		Function<DBObject, EObject> builder = functionProvider
				.getDBObjectToEObjectFunction(null, resource);

		Premises premisesOut = (Premises) builder.apply(dbObject);

		assertThat("Premises should not be null", premisesOut,
				is(notNullValue()));
		assertThat("Premises should have name", premisesOut.getName(),
				is("Jack Condor"));
		assertThat("Resource should have premises in it.", resource
				.getContents().size(), is(1));
		assertThat("Premises should have a resource.", premisesOut.eResource(),
				is(notNullValue()));

	}

	@Test
	public void test_Animal_Transform() throws UnknownHostException {
		Animal animalIn = createAnimal();
		assertThat("Animal should have id", animalIn.getId(), is(TAG_ID_1));
		animalIn.getTags().clear();
		assertThat("Animal should have No id", animalIn.getId(), is(""));

		Function<EObject, DBObject> eTod = functionProvider
				.getEObjectToDBObjectFunction();
		DBObject dbObject = eTod.apply(animalIn);
		assertThat("Animal should not be null", dbObject, is(notNullValue()));

		//
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(""));

		Function<DBObject, EObject> builder = functionProvider
				.getDBObjectToEObjectFunction(null, resource);


		Animal animal = (Animal) builder.apply(dbObject);

		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("Animal should have No id", animalIn.getId(), is(""));
		assertThat("Animal should be a swine", animal.getType(),
				is(AnimalType.SWINE));
		assertThat("Animal should have no tag", animal.getTags().size(), is(0));

	}

	@Test
	public void test_Premises_Upsert() throws UnknownHostException {
		Premises premises = createPremises();
		premises.setName("Jack Condor");
		upsert(premises);
	}

	@Test
	public void test_Premises_Upsert_Multiple() throws IOException,
			InterruptedException {
		logger.debug(bundleMarker, "starting testRegister");

		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		premises.getAnimals().clear();

		// logger.info(bundleMarker, "Registering {}", premises);

		String uri = premises.getUri() + '_';
		for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
			premises.setUri(uri + i);
			upsert(premises);
		}
		// TimeUnit.SECONDS.sleep(3);
		logger.debug("done");
	}

	@Test
	public void test_Animal_Upsert() throws UnknownHostException {
		Animal animal = createAnimal();
		upsert(animal);
	}



	@Test
	public void test_Animals_Unsert() throws IOException, InterruptedException {
		logger.debug(bundleMarker, "starting");

		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		Set<OCD> ocds = newHashSet();
		for (Animal animal : premises.getAnimals()) {
			upsert(animal);
			for (Event event : animal.eventHistory()) {
				if (event instanceof GenericEvent) {
					ocds.add(((GenericEvent) event).getOcd());
				}
			}
		}
		process(ocds);
	}



	@Test
	public void testPremises_Read() throws IOException {
		File file = new File(FILE_TMP_OUT_PREMISES1);
		file.delete();
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("file:" + FILE_TMP_OUT_PREMISES1);
		Resource resource = resourceSet.createResource(uri);
		DBCollection coll = getCollection(DB_NAME, PREMISES_COLLECTION);
		DBObject dbObject = coll
				.findOne(new BasicDBObject("uri", PREMISES_URI));

		Function<DBObject, EObject> builder = functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		Premises premises = (Premises) builder.apply(dbObject);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Premises should have name", premises.getName(),
				is("Jack Condor"));
		assertThat("Resource should have premises in it.", resource
				.getContents().size(), is(1));
		assertThat("Premises should have a resource.", premises.eResource(),
				is(notNullValue()));

		resource.save(null);
		assertThat("Did not save the resource", file.exists(), is(true));
	}

	@Test
	public void testAnimal_Read1() throws IOException {
		File file = new File(FILE_TMP_OUT_PREMISES2);
		file.delete();
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("file:" + FILE_TMP_OUT_PREMISES2);
		Resource resource = resourceSet.createResource(uri);
		DBCollection coll = getCollection(DB_NAME, ANIMAL_COLLECTION);
		DBObject q = new BasicDBObject("tags", TAG_ID_1);
		DBObject dbObject = coll.findOne(q);

		assertThat("Animal should not be null", dbObject, is(notNullValue()));


		Function<DBObject, EObject> builder = functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		Animal animal = (Animal) builder.apply(dbObject);

		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("Animal should have id", animal.getId(), is(TAG_ID_1));
		assertThat("Animal should be a swine", animal.getType(),
				is(AnimalType.SWINE));
		assertThat("Animal should have a tag", animal.getTags().size(), is(1));

		Tag tag = animal.activeTag();
		assertThat("Tag should have an event", tag.getEvents().size(), is(1));

		Event event = tag.getEvents().get(0);
		assertThat("Event should be  is an AnimalMissing",
				event.getEventCode(), is(13));

		assertThat("Resource should have Animal in it.", resource.getContents()
				.size(), is(1));
		assertThat("Animal should have a resource.", animal.eResource(),
				is(notNullValue()));


		
		resource.save(null);
		assertThat("Did not save the resource", file.exists(), is(true));
	}

	@Test
	public void test_Tag_Upsert() throws UnknownHostException {
		DBCollection coll = getCollection(DB_NAME, TAG_COLLECTION);

		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.getEvents().add(TrackerFactory.eINSTANCE.createBirthDefect());
		tag1.setId("12");

		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.getEvents().add(TrackerFactory.eINSTANCE.createCalving());// 105
		tag2.setId("13");

		final ImmutableList<Tag> tags = ImmutableList.of(tag1, tag2);
		Function<EObject, DBObject> eTod = functionProvider
				.getEObjectToDBObjectFunction();
		Iterable<DBObject> dbos = Iterables.transform(tags, eTod);

		List<DBObject> dbList = newArrayList(dbos);
		for (DBObject dbObject : dbList) {
			dbObject.put("animal", "xxx");
		}
		coll.insert(dbList);
	}

	public void testTag_Read() throws IOException {
		File file = new File(FILE_TMP_OUT_PREMISES2);
		file.delete();
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("file:" + FILE_TMP_OUT_PREMISES2);
		Resource resource = resourceSet.createResource(uri);
		DBCollection coll = getCollection(DB_NAME, TAG_COLLECTION);
		DBObject q = new BasicDBObject("_id", "13");
		DBObject dbObject = coll.findOne(q);

		assertThat("Tag should not be null", dbObject, is(notNullValue()));


		Function<DBObject, EObject> builder = functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		Tag tag = (Tag) builder.apply(dbObject);

		assertThat("Animal should not be null", tag, is(notNullValue()));
		assertThat("Animal should have id", tag.getId(), is("13"));

		assertThat("Tag should have an event", tag.getEvents().size(), is(1));

		Event event = tag.getEvents().get(0);
		assertThat("Event should be  is an Calving (Birthing)",
				event.getEventCode(),
				is(105));


	}

	public void testAnimal_Read_WITH_GENERIC_EVENT() throws IOException {
		File file = new File(FILE_TMP_OUT_PREMISES3);
		file.delete();
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("file:" + FILE_TMP_OUT_PREMISES2);
		Resource resource = resourceSet.createResource(uri);
		DBCollection coll = getCollection(DB_NAME, ANIMAL_COLLECTION);
		DBObject q = new BasicDBObject("tags", TAG_ID_WITH_GENERIC_EVENT);
		DBObject dbObject = coll.findOne(q);

		assertThat("Animal should not be null", dbObject, is(notNullValue()));


		Function<DBObject, EObject> builder = functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		Animal animal = (Animal) builder.apply(dbObject);

		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("Animal should have id", animal.getId(),
				is(TAG_ID_WITH_GENERIC_EVENT));
		assertThat("Animal should be a swine", animal.getType(),
				is(AnimalType.BOVINE_BEEF));
		assertThat("Animal should have 1 tag", animal.getTags().size(), is(1));

		Tag tag = animal.activeTag();
		assertThat("Tag should have 8 events", tag.getEvents().size(), is(8));

		Event event = tag.getEvents().get(0);
		assertThat("Event should be  is a TagAppliend EventCode 2",
				event.getEventCode(),
				is(2));

		event = tag.getEvents().get(7);
		assertThat("Event should be  is a GenericEvent EventCode 200",
				event.getEventCode(), is(200));
		GenericEvent ge = (GenericEvent) event;
		assertThat("Generic Event should not be null", ge, is(notNullValue()));
		OCD ocd = ge.getOcd();
		assertThat("OCD should not be null", ocd, is(notNullValue()));

		assertThat("Resource should have Animal in it.", resource.getContents()
				.size(), is(1));
		assertThat("Animal should have a resource.", animal.eResource(),
				is(notNullValue()));

	}

	@Test
	public void test_Wait() throws InterruptedException {
		// TimeUnit.SECONDS.sleep(2);
		logger.debug("done");
	}

	private void upsert(Premises premises) {
			Function<EObject, DBObject> eTod = functionProvider
					.getEObjectToDBObjectFunction();
			DBObject dbObject = eTod.apply(premises);
			DBCollection coll = getCollection(DB_NAME, PREMISES_COLLECTION);
			dbObject.put("_id", premises.getUri());
			coll.update(new BasicDBObject("uri", premises.getUri()), dbObject,
					true, false);
	}

	private void process(Set<OCD> ocds) {
		Function<EObject, DBObject> eTod = functionProvider
				.getEObjectToDBObjectFunction();
		Iterable<DBObject> dbos = Iterables.transform(ocds, eTod);
		DBCollection coll = getCollection(DB_NAME, OCD_COLLECTION);
		coll.insert(Lists.newArrayList(dbos));
	}
	private void upsert(Animal animal) {
		// First insert all the tags
		List<String> ids = upsert(animal.getTags());
		animal.getTags().clear();
		upsert(animal, ids);
	}

	private void upsert(Animal animal, List<String> ids) {
		Function<EObject, DBObject> eTod = functionProvider
				.getEObjectToDBObjectFunction();
		DBObject dbObject = eTod.apply(animal);
		dbObject.put("tags", ids);

		DBCollection coll = getCollection(DB_NAME, ANIMAL_COLLECTION);
		coll.update(new BasicDBObject("_id", animal.getId()), dbObject, true,
				false);
	}

	private List<String> upsert(List<Tag> tags) {
		Function<EObject, DBObject> eTod = functionProvider
				.getEObjectToDBObjectFunction();

		Iterable<DBObject> dbos = Iterables.transform(tags, eTod);

		List<DBObject> dboList = newArrayList(dbos);
		for (DBObject dbObject : dboList) {
			// The OID of the Animal should go here. This is done in the
			// the com.verticon.tracker.store.mongodb component using an
			// intermediate component AnimalUpdate to hold the Animal OID.
			// For this test just put something in it so the transform
			// can infer that it is a Tag class from the minimal attributes. (
			dbObject.put("animal", "xxx");
		}
		DBCollection coll = getCollection(DB_NAME, TAG_COLLECTION);
		coll.insert(dboList);
		List<String> ids = newArrayList();
		for (Tag tag : tags) {
			ids.add(tag.getId());

		}

		return ids;
	}

	private Premises createPremises() {
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri(PREMISES_URI);
		return premises;
	}

	private Animal createAnimal() {
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.getEvents().add(TrackerFactory.eINSTANCE.createAnimalMissing());
		Animal animal = TrackerFactory.eINSTANCE.createSwine();
		animal.getTags().add(tag);
		animal.activeTag().setId(TAG_ID_1);
		return animal;
	}

	private DBCollection getCollection(String dbName, String name) {
		MongoClient mongoClient = iMongoClientProvider.getMongoClient();
		DB db = mongoClient.getDB(dbName);
		return db.getCollection(name);
	}

	private static Resource getXMIResource(String fileName, String segment) {
		String pluginID = "com.verticon.mongo.emf.transform.test.system";
		return getXMIResource(pluginID, fileName, segment);
	}

	private static Resource getXMIResource(String pluginID, String fileName,
			String segment) {
		URI uri = URI.createPlatformPluginURI(pluginID, true);

		if (Strings.isNullOrEmpty(segment)) {
			uri = uri.appendSegments(new String[] { "resources", fileName });
		} else {
			uri = uri.appendSegments(new String[] { "resources", segment,
					fileName });
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		return resource;
	}
}
