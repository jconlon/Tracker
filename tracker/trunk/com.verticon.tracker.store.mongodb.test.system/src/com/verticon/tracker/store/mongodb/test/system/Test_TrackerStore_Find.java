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
import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.isValidObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.Icon;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.store.ITrackerFind;

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
public class Test_TrackerStore_Find extends TestCase {

	private static final String TAG_ID_1 = "1234567890";
	private static final String TAG_ID_WITH_GENERIC_EVENT = "840456789012341";
	private static final String TAG_ID_WITH_SIRE_AND_DAM = "840456789012343";
	static final String DOC_PREMISES = "example.premises";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerStore_Find.class);

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

		Premises premises = Test_TrackerStore.trackerStore
				.retrievePremises(PREMISES_URI);

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

		Premises premises = Test_TrackerStore.trackerStore
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
	public void test_TrackerFind_RetrievePremises_Dates() throws IOException {

		Premises premises = Test_TrackerStore.trackerStore.retrievePremises(
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
	public void test_TrackerFind_RetrievePremises_Point() throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-77.037852,38.898556,0");
		// position.setLatitude(38.898556);
		// position.setLongitude(-77.037852);
		Premises premises = Test_TrackerStore.trackerStore
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
	}

	private static final String FROMDATE = "2010-03-01";
	private static final String TODATE = "2011-05-01";

	@Test
	public void test_TrackerFind_RetrievePremises_Point2() throws IOException {
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				"-90.95048182270057,43.47622307339506,0");
		// List<String> pointList = point.toList();
		// assertThat(pointList.get(0), is(-90.95048182270057));
		Premises premises = Test_TrackerStore.trackerStore
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
		Premises premises = Test_TrackerStore.trackerStore.retrievePremises(
				point, FROMDATE, TODATE);

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
		Animal animal = Test_TrackerStore.trackerStore.retrieveAnimal(TAG_ID_1);

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
		Animal animal = Test_TrackerStore.trackerStore
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
		Animal animal = Test_TrackerStore.trackerStore
				.retrieveAnimal(TAG_ID_WITH_SIRE_AND_DAM);

		assertThat("Animal should not be null", animal, is(notNullValue()));

		assertThat("Animal should be a beef", animal.getType(),
				is(AnimalType.BOVINE_BEEF));
		assertThat("Animal should have 1 tag", animal.getTags().size(), is(1));
		assertThat("Animal should have id", animal.getId(),
				is(TAG_ID_WITH_SIRE_AND_DAM));
	}

}
