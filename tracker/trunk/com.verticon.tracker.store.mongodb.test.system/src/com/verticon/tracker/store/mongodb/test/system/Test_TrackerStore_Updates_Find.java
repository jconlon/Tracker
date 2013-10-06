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

import static com.verticon.tracker.store.mongodb.test.system.Configurator.PREMISES_URI_003ALKMN;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.saveXMIResource;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;

/**
 * Complement of the Test_TrackerStore_Updates TestCase that confirms data was
 * saved.
 * 
 * @author jconlon
 * 
 */
public class Test_TrackerStore_Updates_Find extends TestCase {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerStore_Updates_Find.class);



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

	public void testRetrievePremises_4_11() throws IOException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_4_11, DATE_4_12);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + PREMISES_URI_003ALKMN, premises,
				is(notNullValue()));
		assertThat("Premises must have 72 animals", premises.getAnimals()
				.size(), is(72));
		// Tracker shows 72 animals, shell says 73 Tags (023 tag is in the shell
		// but not in tracker)
		saveXMIResource("out_4_11.premises", premises);

		// Events go beyond the dates because the animals are the ones that are
		// targeted. They then most likely have dates beyond the range
		assertThat("Premises must have all events for all animals", premises
				.eventHistory().size(), is(422));

	}

	public void testRetrievePremises_4_12() throws IOException {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_4_12, DATE_4_13);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + PREMISES_URI_003ALKMN, premises,
				is(notNullValue()));
		assertThat("Premises must have 37 animalsl", premises.getAnimals()
				.size(), is(37));
		// Events go beyond the dates because the animals are the ones that are
		// targeted. They then most likely have dates beyond the range
		assertThat("Premises must have all events for all animals", premises
				.eventHistory().size(), is(218));
	}

	public void testRetrievePremises_5_16() throws Exception {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_5_16, DATE_5_17);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + PREMISES_URI_003ALKMN, premises,
				is(notNullValue()));
		assertThat("Premises must have 94 animalsl", premises.getAnimals()
				.size(), is(94));
		// Events go beyond the dates because the animals are the ones that are
		// targeted. They then most likely have dates beyond the range
		assertThat("Premises must have all events for all animals", premises
				.eventHistory().size(), is(571));
	}

	public void testRetrievePremises_5_17() throws Exception {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_5_17, DATE_5_18);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + PREMISES_URI_003ALKMN, premises,
				is(notNullValue()));
		assertThat("Premises must have 123 animalsl", premises.getAnimals()
				.size(), is(123));
		// Events go beyond the dates because the animals are the ones that are
		// targeted. They then most likely have dates beyond the range
		assertThat("Premises must have all events for all animals", premises
				.eventHistory().size(), is(737));

	}

	public void testRetrievePremises_9_10() throws Exception {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_9_10, DATE_9_11);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + PREMISES_URI_003ALKMN, premises,
				is(notNullValue()));
		assertThat("Premises must have 213 animals", premises.getAnimals()
				.size(), is(213));
		// Events go beyond the dates because the animals are the ones that are
		// targeted. They then most likely have dates beyond the range
		assertThat("Premises must have all events for all animals", premises
				.eventHistory().size(), is(1494));
	}

	public void testSavePremises_9_10() throws ParseException, IOException {
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_9_10, DATE_9_11);
		saveXMIResource("out_9_10.premises", premises);
	}

	public void testRetrievePremises_9_14() throws Exception {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_9_14, DATE_9_15);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + PREMISES_URI_003ALKMN, premises,
				is(notNullValue()));
		assertThat("Premises must have 180 animalsl", premises.getAnimals()
				.size(), is(180));
		// Events go beyond the dates because the animals are the ones that are
		// targeted. They then most likely have dates beyond the range
		assertThat("Premises must have all events for all animals", premises
				.eventHistory().size(), is(1259));
	}

	public void testSavePremises_9_14() throws Exception, IOException {
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_9_14, DATE_9_15);
		saveXMIResource("out_9_14.premises", premises);
	}

	public void testRetrievePremises_9_15() throws Exception {
		logger.debug(bundleMarker,
				"starting testRetrievePremisesFromUpdateLocation");
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_9_15, DATE_9_16);
		assertThat("Could not retrieve the premises", premises,
				is(notNullValue()));
		// assertThat("Not a valid premises", TestUtils.isValidObject(premises),
		// is(true));
		assertThat("Premises with uri " + PREMISES_URI_003ALKMN, premises,
				is(notNullValue()));
		assertThat("Premises must have 35 animalsl", premises.getAnimals()
				.size(), is(35));
		// Events go beyond the dates because the animals are the ones that are
		// targeted. They then most likely have dates beyond the range
		assertThat("Premises must have all events for all animals", premises
				.eventHistory().size(), is(245));

	}

	public void testSavePremises_9_15() throws Exception, IOException {
		Premises premises = Test_TrackerStore_Updates.trackerStore
				.retrievePremises(PREMISES_URI_003ALKMN, DATE_9_15, DATE_9_16);
		saveXMIResource("out_9_15.premises", premises);
	}

}
