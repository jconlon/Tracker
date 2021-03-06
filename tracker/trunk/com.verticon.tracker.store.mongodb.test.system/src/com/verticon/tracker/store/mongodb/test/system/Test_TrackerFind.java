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

import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.FILE_TMP_OUT_PREMISES2;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI_003ALKMN;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.TAG_ID_1;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.TAG_ID_WITH_GENERIC_EVENT;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.TAG_ID_WITH_SIRE_AND_DAM;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.saveXMIResource;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.bson.BSONObject;
import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.Icon;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.Query;

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
public class Test_TrackerFind extends TestCase {

	private final static DateFormat DATE_FORMAT = new SimpleDateFormat(
			ITrackerFind.DATE_PATTERN);
	private static final String TAG_ID_2 = "abcd";
	private static final String DATE_2010_03_01 = "2010-03-01";
	private static final String DATE_2011_05_01 = "2011-05-01";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerFind.class);

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

	@Test
	public void test_TrackerFind_RetrievePremises() throws IOException {

		Premises premises = Test_TrackerUpdateAndFind.trackerFind
				.retrievePremises(PREMISES_URI);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Premises should have name", premises.getName(),
				is("Jack Condor"));
		assertThat("Premises should have no Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));

	}

	@Test
	public void test_TrackerFind_RetrievePremises_Dates_Simple()
			throws IOException {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		Premises premises = Test_TrackerUpdateAndFind.trackerFind
				.retrievePremises(PREMISES_URI, DATE_2010_03_01,
						DATE_FORMAT.format(c.getTime()));
		assertThat("Premises should not be null", premises, is(notNullValue()));
		saveXMIResource("simple_retrieved.premises", premises);

		assertThat("Premises should have name", premises.getName(),
				is("Jack Condor"));
		assertThat("Premises should have 1 Animals", premises.getAnimals()
				.size(), is(1));
		// Animal animal = premises.getAnimals().get(0);

		assertThat("Premises should have 3 events", premises.eventHistory()
				.size(), is(3));

	}

	@Test
	public void test_TrackerFind_RetrievePremises_WithLocation()
			throws IOException {

		Premises premises = Test_TrackerUpdateAndFind.trackerFind
				.retrievePremises(PREMISES_URI_H89234X);

		assertThat("Premises should not be null", premises, is(notNullValue()));
		assertThat("Premises should have name", premises.getName(),
				is("East Farm"));
		assertThat("Premises should have no Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));

	}

	@Test
	public void test_TrackerFind_RetrievePremises_Dates() throws IOException {

		Premises premises = Test_TrackerUpdateAndFind.trackerFind
				.retrievePremises(PREMISES_URI_H89234X, DATE_2010_03_01,
						DATE_2011_05_01);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + PREMISES_URI_H89234X, premises,
				is(notNullValue()));
		assertThat("Premises URI must not be null.", premises.getUri(),
				is(notNullValue()));
		assertThat("Premises must have 5 animalsl", premises.getAnimals()
				.size(), is(5));

		Animal firstAnimal = premises.getAnimals().get(0);
		String id = "";
		for (Animal animal : premises.getAnimals()) {
			assertThat(true, is(animal.getId().compareTo(id) > 0));
			id = animal.getId();
			logger.debug(bundleMarker, "Animal {} ", animal.getId());
		}

		assertThat("First animal was not found between " + DATE_2010_03_01
				+ " and " + DATE_2011_05_01, firstAnimal.getId(),
				is("840456789012341"));
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
	public void test_TrackerFind_RetrievePremises_Point() throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-77.037852,38.898556,0");
		// position.setLatitude(38.898556);
		// position.setLongitude(-77.037852);
		Premises premises = Test_TrackerUpdateAndFind.trackerFind
				.retrievePremises(point);

		assertThat("Premises should not be null", premises, is(notNullValue()));

		assertThat("Premises should have uri", premises.getUri(),
				is(PREMISES_URI));
		assertThat("Premises should have name", premises.getName(),
				is("Jack Condor"));
		assertThat("Premises should have no Animals", premises.getAnimals()
				.size(), is(0));
		assertThat("Premises should have no unassignedTags", premises
				.getUnAppliedTags().size(), is(0));

		point = new ITrackerFind.LongLatPoint(
				"-90.95048182270057,43.47622307339506,0");
		// List<String> pointList = point.toList();
		// assertThat(pointList.get(0), is(-90.95048182270057));
		premises = Test_TrackerUpdateAndFind.trackerFind
				.retrievePremises(point);

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
	public void test_TrackerFind_RetrievePremises_Point2() throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-90.95048182270057,43.47622307339506,0");
		// List<String> pointList = point.toList();
		// assertThat(pointList.get(0), is(-90.95048182270057));
		Premises premises = Test_TrackerUpdateAndFind.trackerFind
				.retrievePremises(point);

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
		Premises premises = Test_TrackerUpdateAndFind.trackerFind
				.retrievePremises(point, DATE_2010_03_01, DATE_2011_05_01);

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

	@Test
	public void test_Raw_Find_Tag() throws IOException {
		File file = new File(FILE_TMP_OUT_PREMISES2);
		file.delete();
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("file:" + FILE_TMP_OUT_PREMISES2);
		Resource resource = resourceSet.createResource(uri);
		DBCollection coll = Test_TrackerUpdateAndFind
				.getCollection(Configurator.TAG_COLLECTION);

		DBObject q = new BasicDBObject("_id", "840456789012341");
		DBObject dbObject = coll.findOne(q);

		assertThat("Tag dbObject should not be null", dbObject,
				is(notNullValue()));

		assertThat("Tag dbObject should have a ref to Animal",
				dbObject.get("animal"), is(notNullValue()));

		assertThat("Tag dbObject should have an animal ref that is a ObjectId",
				dbObject.get("animal"), is(instanceOf(ObjectId.class)));

		Function<DBObject, EObject> builder = Test_TrackerUpdateAndFind.functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		Tag tag = (Tag) builder.apply(dbObject);

		assertThat("Tag should not be null", tag, is(notNullValue()));

		assertThat("Tag must have 8 events.", tag.getEvents().size(), is(8));
		for (Event event : tag.getEvents()) {
			logger.debug(bundleMarker, "Event pid= {} ", event.getPid());
			assertThat("Event must have pid set.  " + event, event.getPid(),
					is(notNullValue()));
		}

	}

	@Test
	public void test_Raw_Find_OCD() throws IOException {

		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("");
		Resource resource = resourceSet.createResource(uri);
		DBCollection coll = Test_TrackerUpdateAndFind
				.getCollection(Configurator.OCD_COLLECTION);
		DBObject q = new BasicDBObject("_id", "mettler.weight");
		DBObject dbObject = coll.findOne(q);

		assertThat("OCD dbObject should not be null", dbObject,
				is(notNullValue()));

		Object o = dbObject.get("aD");
		assertThat("OCD dbObject should have a list of AD", o,
				is(instanceOf(List.class)));
		@SuppressWarnings("unchecked")
		List<AD> adList = (List<AD>) o;

		assertThat("OCD dbObject should have a 4 AD", adList.size(), is(4));

		Function<DBObject, EObject> builder = Test_TrackerUpdateAndFind.functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		OCD ocd = (OCD) builder.apply(dbObject);

		assertThat("OCD should not be null", ocd, is(notNullValue()));
		assertThat("OCD should have an iD ", ocd.getID(), is("mettler.weight"));
		assertThat("OCD should have an icon", ocd.getIcon(), is(notNullValue()));
	}

	public void test_Raw_Find_Animal() throws IOException {
		File file = new File(FILE_TMP_OUT_PREMISES2);
		file.delete();
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("file:" + FILE_TMP_OUT_PREMISES2);
		Resource resource = resourceSet.createResource(uri);

		// Find a tag first
		DBCollection coll = Test_TrackerUpdateAndFind
				.getCollection(Configurator.ANIMAL_COLLECTION);
		DBObject q = new BasicDBObject("tags", TAG_ID_1);
		DBObject animalDbObject = coll.findOne(q);
		assertThat("Animal should not be null", animalDbObject,
				is(notNullValue()));

		Function<DBObject, EObject> builder = Test_TrackerUpdateAndFind.functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		Animal animal = (Animal) builder.apply(animalDbObject);

		assertThat("Animal should not be null", animal, is(notNullValue()));

		assertThat("Animal should be a swine", animal.getType(),
				is(AnimalType.SWINE));

		assertThat("Animal should have one tag", animal.getTags().size(), is(2));

		assertThat("Animal should have id", animal.activeTag(),
				is(notNullValue()));

		assertThat("Animal should have id", animal.activeTag().getId(),
				is(TAG_ID_2));

		String id = animal.getId();
		assertThat("Animal should have id", id, is(TAG_ID_2));

		Tag tag = animal.activeTag();
		assertThat("Tag should have an event", tag.getEvents().size(), is(1));

		Event event = tag.getEvents().get(0);
		assertThat("Event should be  is an Died ", event.getEventCode(), is(11));
		assertThat("Event should have pid set ", event.getPid(),
				is(notNullValue()));

		assertThat("Resource should have Animal in it.", resource.getContents()
				.size(), is(1));
		assertThat("Animal should have a resource.", animal.eResource(),
				is(notNullValue()));

		resource.save(null);
		assertThat("Did not save the resource", file.exists(), is(true));
	}

	public void test_TrackerFind_RetrieveAnimal() throws IOException {
		Animal animal = Test_TrackerUpdateAndFind.trackerFind
				.retrieveAnimal(TAG_ID_1);

		assertThat("Animal should not be null", animal, is(notNullValue()));

		assertThat("Animal should be a swine", animal.getType(),
				is(AnimalType.SWINE));

		assertThat("Animal should have 2 tag", animal.getTags().size(), is(2));
		assertThat("Animal should have id", animal.getId(), is(TAG_ID_2));
		assertThat("Animal should have 3 events", animal.eventHistory().size(),
				is(3));

		Tag tag = animal.activeTag();
		assertThat("Tag should have an event", tag.getEvents().size(), is(1));

		Event event = tag.getEvents().get(0);
		assertThat("Event should be  is an Died ", event.getEventCode(), is(11));

	}

	public void test_Raw_Find_Animal_WITH_GENERIC_EVENT() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI("");
		Resource resource = resourceSet.createResource(uri);

		DBObject q = new BasicDBObject("tags", TAG_ID_WITH_GENERIC_EVENT);

		// Find the animal
		DBCollection coll = Test_TrackerUpdateAndFind
				.getCollection(Configurator.ANIMAL_COLLECTION);

		DBObject animalDbObject = coll.findOne(q);
		assertThat("Animal should not be null", animalDbObject,
				is(notNullValue()));

		Function<DBObject, EObject> builder = Test_TrackerUpdateAndFind.functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		Animal animal = (Animal) builder.apply(animalDbObject);

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
		assertThat("OCD must have 4 ADs", ocd.getAD().size(), is(4));

	}

	public void test_TrackerFind_RetrieveAnimal_WITH_GENERIC_EVENT()
			throws IOException {
		Animal animal = Test_TrackerUpdateAndFind.trackerFind
				.retrieveAnimal(TAG_ID_WITH_GENERIC_EVENT);

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
		Animal animal = Test_TrackerUpdateAndFind.trackerFind
				.retrieveAnimal(TAG_ID_WITH_SIRE_AND_DAM);

		assertThat("Animal should not be null", animal, is(notNullValue()));

		assertThat("Animal should be a beef", animal.getType(),
				is(AnimalType.BOVINE_BEEF));
		assertThat("Animal should have 1 tag", animal.getTags().size(), is(1));
		assertThat("Animal should have id", animal.getId(),
				is(TAG_ID_WITH_SIRE_AND_DAM));
	}

	@Test
	public void test_getPremisesNames() throws InterruptedException {
		Set<String> uris = newHashSet(PREMISES_URI_H89234X,
				PREMISES_URI_003ALKMN, PREMISES_URI);
		Map<String, String> nameMap = Test_TrackerUpdateAndFind.trackerFind
				.getPremisesNames(uris);
		assertThat("Should have 2 entries", nameMap.size(), is(2));
		String name = nameMap.get(PREMISES_URI);
		assertThat("Should not be null", name, is(notNullValue()));
		assertThat("Should be", name, is("Jack Condor"));

		name = nameMap.get(PREMISES_URI_H89234X);
		assertThat("Should not be null", name, is(notNullValue()));
		assertThat("Should be", name, is("East Farm"));
	}

	@Test
	public void test_Query() throws IOException {
		String result = Test_TrackerUpdateAndFind.trackerFind
				.query(Query.LAST_PUB_QUERY_TEMPLATE.replace("jc:www.verticon"));
		assertThat("Result must not be null.", result, is(notNullValue()));
		BSONObject response = (BSONObject) JSON.parse(result);
		logger.debug(bundleMarker, "Response is: {}", result);
		List<?> list = (List<?>) response.get("result");
		assertThat("Result list must be one", list.size(), is(1));
		assertThat("Wrong type", ((BSONObject) list.get(0)).get("update"),
				is(instanceOf(Date.class)));

		// Try with a empty result
		result = Test_TrackerUpdateAndFind.trackerFind
				.query(Query.LAST_PUB_QUERY_TEMPLATE.replace("notThere"));

		assertThat("Result must not be null.", result, is(notNullValue()));
		response = (BSONObject) JSON.parse(result);
		logger.debug(bundleMarker, "Response is: {}", result);
		list = (List<?>) response.get("result");
		assertThat("Result list must be empty", list.size(), is(0));

	}

}
