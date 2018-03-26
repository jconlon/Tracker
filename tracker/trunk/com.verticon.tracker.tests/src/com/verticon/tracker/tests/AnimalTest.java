/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.tests;
import static com.verticon.tracker.tests.Constants.bundleMarker;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.Sex;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.util.Age;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Animal#getSpecies() <em>Species</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getBreed() <em>Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSexCode() <em>Sex Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSpeciesCode() <em>Species Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getId() <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getLastEventDateTime() <em>Last Event Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getWeight() <em>Weight</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getWeightGainPerDay() <em>Weight Gain Per Day</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getType() <em>Type</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getAgeInDays() <em>Age In Days</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getAlternativeID() <em>Alternative ID</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getLocation() <em>Location</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Animal#allEvents() <em>All Events</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#addTemplate(org.eclipse.emf.common.util.EList) <em>Add Template</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#activeTag() <em>Active Tag</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#eventHistory() <em>Event History</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#lastWeighIn() <em>Last Weigh In</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getAge() <em>Get Age</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#canContain(com.verticon.tracker.EventType, java.lang.String) <em>Can Contain</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#lastEvent(com.verticon.tracker.EventType, java.lang.String) <em>Last Event</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#findLocationName() <em>Find Location Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class AnimalTest extends TestCase {
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(AnimalTest.class);
	private static final String AIN_1 = "123456789012341";
	private static final String AIN_2 = "123456789012342";
	private static final String AIN_3 = "123456789012343";
	
	private static final Date ANIMAL_BIRTHDAY = 
		(new GregorianCalendar(2000, Calendar.JANUARY, 1,1,5)).getTime();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Animal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Animal fixture = null;

	/**
	 * Constructs a new Animal test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Animal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void setFixture(Animal fixture) {
		this.fixture = fixture;
		if(fixture !=null){
			assertNull(fixture.getBirthDate());
			fixture.setSex(Sex.M_LITERAL);
			Tag tag = TrackerFactory.eINSTANCE.createTag();
			tag.setId(AIN_1);
			fixture.getTags().add(tag);
			fixture.setBirthDate(ANIMAL_BIRTHDAY);
			
		}
	}

	/**
	 * Returns the fixture for this Animal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Animal getFixture() {
		return fixture;
	}
	

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getSpecies() <em>Species</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * Overridden in subclasses
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getSpecies()
	 * @generated NOT
	 */
	public void testGetSpecies() {
		fail();
	}

	

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getBreed() <em>Breed</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * Overriden in subclasses.
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getBreed()
	 * @generated NOT
	 */
	public void testGetBreed() {
		fail();
	}

	 /**
	 * Tests the '{@link com.verticon.tracker.Animal#getAge() <em>Age</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.verticon.tracker.Animal#getAge()
	 * @generated NOT
	 */
	public void testGetAge() {
		assertNotNull(getFixture());
		assertNotNull(getFixture().getAge());
		assertEquals(new Age(ANIMAL_BIRTHDAY), getFixture().getAge());

		Calendar someBirthday = Calendar.getInstance();
		// FIXME Fix this test
		// someBirthday.add(Calendar.DAY_OF_MONTH, -5);
		// getFixture().setBirthDate(someBirthday.getTime());
		// assertEquals("D05", getFixture().getAge().toRoundedString());
		// assertEquals("5 days old", getFixture().getAge().toString());

		someBirthday.add(Calendar.MONTH, -7);
		getFixture().setBirthDate(someBirthday.getTime());
		assertEquals("M07", getFixture().getAge().toRoundedString());

		someBirthday.add(Calendar.YEAR, -3);
		getFixture().setBirthDate(someBirthday.getTime());
		assertEquals("Y03", getFixture().getAge().toRoundedString());
	}
	

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#canContain(com.verticon.tracker.EventType, java.lang.String) <em>Can Contain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#canContain(com.verticon.tracker.EventType, java.lang.String)
	 * @generated NOT
	 */
	public void testCanContain__EventType_String() {
		assertNotNull(getFixture());
		assertTrue(getFixture().canContain(EventType.ANIMAL_MISSING, null));
	}

		/**
	 * Tests the '{@link com.verticon.tracker.Animal#lastEvent(com.verticon.tracker.EventType, java.lang.String) <em>Last Event</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#lastEvent(com.verticon.tracker.EventType, java.lang.String)
	 * @generated NOT
	 */
	public void testLastEvent__EventType_String() {
		assertNotNull(getFixture());
		
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		Date date = new Date();
		event1.setDateTime(date);
		getFixture().activeTag().getEvents().add(event1);
		assertNotNull(getFixture().lastEvent(EventType.TAG_APPLIED, null));
		assertEquals(event1,getFixture().lastEvent(EventType.TAG_APPLIED, null));
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#findLocationName() <em>Find Location Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#findLocationName()
	 * @generated
	 */
	public void testFindLocationName() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getSexCode() <em>Sex Code</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getSexCode()
	 * @generated NOT
	 */
	public void testGetSexCode() {
		assertNotNull(getFixture());
		assertNotNull(getFixture().getSexCode());
		assertEquals("M", getFixture().getSexCode());
	}

//	/**
//	 * Tests the '{@link com.verticon.tracker.Animal#isSetSexCode() <em>isSetSexCode()</em>}' method.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see com.verticon.tracker.Animal#isSetSexCode()
//	 * @generated NOT
//	 */
//	public void testIsSetSexCode() {
//		assertNotNull(getFixture());
//		assertTrue(getFixture().isSetSexCode());
//	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getSpeciesCode() <em>Species Code</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * Overridden by subclasses
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getSpeciesCode()
	 * @generated NOT
	 */
	public void testGetSpeciesCode() {
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getId() <em>Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * Overridden by subclasses
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getId()
	 * @generated NOT
	 */
	public void testGetId() {
		//Test animal with one tag that has a number
		assertNotNull("Test with one tag that has a number", getFixture());
		assertEquals(AIN_1, getFixture().getId());
		
		//Test animal with no tag
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		assertEquals("Test with no tag", "", animal2.getId());
		
		//Test animal with one tag that has no idNumber
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		animal2.getTags().add(tag2);
		assertEquals("Test with no tag", "", animal2.getId());
		
		//Test animal with two tags that have no numbers
		Tag tag3 = TrackerFactory.eINSTANCE.createTag();
		animal2.getTags().add(tag3);
		assertEquals("Test with no tag", "", animal2.getId());
		
		//Test animal with two tags one with an IdNumber the other without
		tag2.setId(AIN_1);
		assertEquals("Test with no tag", AIN_1, animal2.getId());
		
		//Test animal with two tags one with an event
		tag2.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		assertEquals("Test with no tag", AIN_1, animal2.getId());
		
		//Find the tag with the most current event timestamp.
		tag3.setId(AIN_2);
		try {
	        long numMillisecondsToSleep = 500; // 5 seconds
	        Thread.sleep(numMillisecondsToSleep);
	    } catch (InterruptedException e) {
	    }
		tag3.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		assertEquals(AIN_2, animal2.getId());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#setId(java.lang.String) <em>Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * setId is a derived value but it is the ID attribute for an Animal,
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#setId(java.lang.String)
	 * @generated NOT
	 */
	public void testSetId() {
		//NOOP 
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getLastEventDateTime() <em>Last Event Date Time</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getLastEventDateTime()
	 * @generated NOT
	 */
	public void testGetLastEventDateTime() {
		assertNotNull(getFixture().eventHistory());
		assertTrue(getFixture().eventHistory().isEmpty());

		//Test animal with no tag
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.setId(AIN_1);
		animal2.getTags().add(tag2);
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		Date date = new Date();
		event1.setDateTime(date);
		tag2.getEvents().add(event1);
		assertEquals(1, animal2.eventHistory().size());
		assertTrue(animal2.eventHistory().contains(event1));
		assertEquals(date, animal2.getLastEventDateTime());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getWeight() <em>Weight</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getWeight()
	 * @generated NOT
	 */
	public void testGetWeight() {
		 //Need to see a notification that there is a change of activeTag
		DebugAdapter debugAdapter = 
	    
	    		new DebugAdapter(){
					@Override
					public void notifyChanged(Notification notification) {
						switch (notification.getFeatureID(Event.class)) {
						case TrackerPackage.ANIMAL__LAST_EVENT_DATE_TIME:
							break;
						case TrackerPackage.ANIMAL__WEIGHT:
							counter++;
							break;
						case TrackerPackage.ANIMAL__WEIGHT_GAIN_PER_DAY:
							break;
						default:
							break;
						}
					}
	    };

	    getFixture().eAdapters().add(debugAdapter);
		Animal animal = getFixture();
		assertNull("No weight on animal", animal.getWeight());
		assertEquals("No notifications",0, debugAdapter.counter);
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		tag.getEvents().add(we);
		
		assertEquals(new Double(100), animal.getWeight());
		assertEquals("Should have one notification",1, debugAdapter.counter);
		
		//Second weighIn today 250 lbs
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				secondWeighInDate.getTime());
		we2.setWeight(250d);
		tag.getEvents().add(we2);
		assertEquals(new Double(250), animal.getWeight());
		assertEquals("Should have a second notification",2, debugAdapter.counter);
		
		
		//Third weighIn today 350 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Third");
		we3.setWeight(350d);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we3.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we3);
		assertEquals(new Double(350), animal.getWeight());
		assertEquals("Should have a third notification",3, debugAdapter.counter);
		
		
		//Reset the last event to a different weight
		we3.setWeight(333d);
		assertEquals(new Double(333), animal.getWeight());
		assertEquals("Should have a forth notification",4, debugAdapter.counter);

	}


	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getWeightGainPerDay() <em>Weight Gain Per Day</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getWeightGainPerDay()
	 * @generated NOT
	 */
	public void testGetWeightGainPerDay() {
		DebugAdapter debugAdapter = 
		    
    		new DebugAdapter(){
				@Override
				public void notifyChanged(Notification notification) {
					switch (notification.getFeatureID(Event.class)) {
					case TrackerPackage.ANIMAL__LAST_EVENT_DATE_TIME:
						break;
					case TrackerPackage.ANIMAL__WEIGHT:
						break;
					case TrackerPackage.ANIMAL__WEIGHT_GAIN_PER_DAY:
						counter++;
						break;
					default:
						break;
					}
				}
    };

    getFixture().eAdapters().add(debugAdapter);
		Animal animal = getFixture();
		assertNull("No weight on animal", animal.getWeight());
		assertEquals("No notifications",0, debugAdapter.counter);
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		tag.getEvents().add(we);
		
		assertNull("should be null but was "+ animal.getWeightGainPerDay(),animal.getWeightGainPerDay());
		assertEquals("One notifications",1, debugAdapter.counter);
		
		
		//Second weighIn today 250 lbs
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				secondWeighInDate.getTime());
		we2.setWeight(250d);
		tag.getEvents().add(we2);
		assertEquals(new Double(15.0), animal.getWeightGainPerDay());
		assertEquals("Two notifications",2, debugAdapter.counter);
		
		
		//Third weighIn today 350 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Third");
		we3.setWeight(350d);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we3.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we3);
		assertEquals(new Double(10.0), animal.getWeightGainPerDay());
		assertEquals("Three notifications",3, debugAdapter.counter);
		
		//Reset the last event to a different weight
		we3.setWeight(333d);
		assertEquals(new Double(333), animal.getWeight());
		assertEquals("Should have a forth notification",4, debugAdapter.counter);

		
	}
	
	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getType() <em>Type</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getType()
	 * @generated NOT
	 */
	public void testGetType() {
		Animal animal = getFixture();
		assertNotNull(animal.getType());
		assertTrue(animal.getClass().getSimpleName()+" "+animal.getType().getLiteral(), animal.getClass().getSimpleName().startsWith(animal.getType().getLiteral()));
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getAgeInDays() <em>Age In Days</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getAgeInDays()
	 * @generated NOT
	 */
	public void testGetAgeInDays() {
		assertNotNull(getFixture());
		assertNotNull(getFixture().getAge());
		assertEquals(new Age(ANIMAL_BIRTHDAY), getFixture().getAge());

		Calendar someBirthday = Calendar.getInstance();
		 someBirthday.add(Calendar.DAY_OF_MONTH, -5);
		 getFixture().setBirthDate(someBirthday.getTime());
		 assertEquals(5, getFixture().getAgeInDays());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getAlternativeID() <em>Alternative ID</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getAlternativeID()
	 * @generated NOT
	 */
	public void testGetAlternativeID() {
		assertNull(getFixture().getAlternativeID());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getLocation() <em>Location</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getLocation()
	 * @generated
	 */
	public void testGetLocation() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Test getWeightPerDay method with multiple weighIn events
	 * some of which have a null weight
	 */
	public void testGetWeightGainPerDayWithNulls() {
		Animal animal = getFixture();
		assertNull("Should have no weight on animal", animal.getWeight());
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		
		//First weighIn 10 days ago and 100 lbs
		WeighIn we1 = TrackerFactory.eINSTANCE.createWeighIn();
		we1.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we1.setDateTime(
				firstWeighInDate.getTime());
		we1.setWeight(100d);
		tag.getEvents().add(we1);
		
		assertNull( animal.getWeightGainPerDay());
		
		//Second weighIn today with no weight set
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Null weight on weighIn");
		Calendar knullWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				knullWeighInDate.getTime());
		tag.getEvents().add(we2);
		assertNull( animal.getWeightGainPerDay());
		
		
		//Third weighIn today 250 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we3.setDateTime(
				secondWeighInDate.getTime());
		we3.setWeight(250d);
		tag.getEvents().add(we3);
		assertEquals(new Double(15.0), we3.getWeightGainPerDay());
		
		assertEquals("Wrong Event as lastEvent",we3.getDateTime(), animal.getLastEventDateTime());
		assertEquals(new Double(15.0), animal.getWeightGainPerDay());
		
		//Fourth weighIn today 350 lbs
		WeighIn we4 = TrackerFactory.eINSTANCE.createWeighIn();
		we4.setComments("Fourth");
		we4.setWeight(350d);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we4.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we4);
		assertEquals(new Double(10.0), animal.getWeightGainPerDay());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#allEvents() <em>All Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#allEvents()
	 * @generated NOT
	 */
	public void testAllEventsEmpty() {
		assertNotNull("Cant get a list",getFixture().eventHistory());
		
		assertTrue("Events should be empty", getFixture().eventHistory().isEmpty());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#allEvents() <em>All Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#eventHistory()
	 * @generated NOT
	 */
	public void testAllEvents() {
		
		//Animal2 add a tag1
		logger.info(bundleMarker, "Animal2 add a tag1");
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.setId(AIN_1);
		animal2.getTags().add(tag1);
		
		//Add event1 to tag1 on animal2
		logger.info(bundleMarker,"Add event1 to tag1 on animal2");
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		tag1.getEvents().add(event1);
		assertEquals("Animal2 should have one event",1, animal2.eventHistory().size());
		assertTrue("Animald2 should contain the event1", animal2.eventHistory().contains(event1));
		
		//Add a second event to tag1
		logger.info(bundleMarker,"Add a second event to tag1");
		Event event2 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag1.getEvents().add(event2);
		assertEquals("Animal2 should have two events",2, animal2.eventHistory().size());
		assertTrue("Animald2 should contain event2",animal2.eventHistory().contains(event2));
		
		
		//Create a second tag and add it to animal2
		logger.info(bundleMarker,"Create a second tag and add it to animal2");
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		animal2.getTags().add(tag2);
		tag2.setId(AIN_2);
		
		//Create an event and add it to tag2 
		logger.info(bundleMarker,"Create an event and add it to tag2");
		Event event3 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag2.getEvents().add(event3);
		assertEquals("Animal2 should have three events (tag1==2, tag2==1)",3, animal2.eventHistory().size());
		assertTrue("Animald2 should contain event3",animal2.eventHistory().contains(event3));
		
		//Create another event and add it to tag2
		logger.info(bundleMarker,"Create another event and add it to tag2");
		Event event4 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag2.getEvents().add(event4);
		
		assertEquals("Animal2 should have three events (tag1==2, tag2==2) ",4, animal2.eventHistory().size());
		assertTrue("Animald2 should contain event3",animal2.eventHistory().contains(event4));
		
		//Delete an event
		logger.info(bundleMarker,"Deleting an event");
		tag2.getEvents().remove(event3);
		assertEquals("Animal2 should have two events (tag1==2, tag2==1) ",3, animal2.eventHistory().size());
		assertFalse("Animald2 should NOT contain event3",animal2.eventHistory().contains(event3));
		assertTrue("Animald2 should Still contain event4",animal2.eventHistory().contains(event4));
		
		//Delete a tag
		logger.info(bundleMarker,"Deleting a tag");
		animal2.getTags().remove(tag2);
		assertFalse("Animald2 should NOT contain event4",animal2.eventHistory().contains(event4));
		assertEquals("Animal2 should have two events (tag1==2) ",2, animal2.eventHistory().size());
		
		//Create a third tag add two events to it then add it to animal2
		logger.info(bundleMarker,"Create a third tag add events to it then add it to animal2");
		Tag tag3 = TrackerFactory.eINSTANCE.createTag();
		tag3.setId(AIN_3);
		Event event5 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag3.getEvents().add(event5);
		Event event6 = TrackerFactory.eINSTANCE.createTagApplied();
		tag3.getEvents().add(event6);
		animal2.getTags().add(tag3);
		assertEquals("Animal2 should have four events (tag1==2, tag3==4) ",4, animal2.eventHistory().size());
		assertTrue("Animald2 should contain event5",animal2.eventHistory().contains(event5));
		assertTrue("Animald2 should Still contain event6",animal2.eventHistory().contains(event6));
		
	}
	
	
//	public void testListener() {
//		Animal animal = getFixture();
//		
//		EList<Tag> tags = animal.getTags();
//		
//		
//	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#addTemplate(org.eclipse.emf.common.util.EList) <em>Add Template</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#addTemplate(org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testAddTemplate__EList() {
		Animal animal1 = TrackerFactory.eINSTANCE.createSwine();
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.setId(AIN_1);
		tag1.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		tag1.getEvents().add(TrackerFactory.eINSTANCE.createSighting());
		tag1.getEvents().add(TrackerFactory.eINSTANCE.createSlaughtered());
		animal1.getTags().add(tag1);
		
		//The animal fixture does have a tag on it but without any events
		//Since Ticket#552 an animal with no events but with a tag
		//will be consider to have at least one activetag (the first one
		//returned from the tags EList
		
		//There is no activeTag so don't accept the events
		getFixture().addTemplate(animal1.activeTag().getEvents());
		assertEquals("Should be three events on the fixture",3, getFixture().eventHistory().size());
		
		//Add an activeTag 
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.setId(AIN_2);
		tag2.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		getFixture().getTags().add(tag2);//Fixture now has a new tag that should be the active one
		assertEquals("Should be four events on the fixture",4, getFixture().eventHistory().size());
		
		//There is now an activeTag so accept the events
		getFixture().addTemplate(animal1.activeTag().getEvents());
		assertEquals("Should be seven events on the fixture",7, getFixture().eventHistory().size());
		
		

		//Create an animal without a tag and try and add events
		//There is no activeTag so don't accept the events
		Animal animal = TrackerFactory.eINSTANCE.createBovineBeef();
		animal.addTemplate(animal1.activeTag().getEvents());
		assertEquals(0, animal.eventHistory().size());
		
		animal.getTags().add(tag2);//Animal now has a new tag that should be the active one
		assertEquals(1, animal.eventHistory().size());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#activeTag() <em>Active Tag</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#activeTag()
	 * @generated NOT
	 */
	public void testActiveTag() {
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		
		//Wait 1 second then create a second tag
		try {
	        long numMillisecondsToSleep = 1000; // 1 second
	        Thread.sleep(numMillisecondsToSleep);
	    } catch (InterruptedException e) {
	    }
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
				
		assertTrue(tag1.getEvents().get(0).getDateTime().before(tag2.getEvents().get(0).getDateTime()));
		assertEquals(-1, tag1.getEvents().get(0).getDateTime().compareTo(tag2.getEvents().get(0).getDateTime()));
		
		getFixture().getTags().add(tag1);
		getFixture().getTags().add(tag2);
		assertEquals("Tag2 should have been the active tag",tag2, getFixture().activeTag());
		
		//Wait 1 second then add an event to the first tag
		try {
	        long numMillisecondsToSleep = 1000; // 1 second
	        Thread.sleep(numMillisecondsToSleep);
	    } catch (InterruptedException e) {
	    }
		
	    tag1.getEvents().add(TrackerFactory.eINSTANCE.createBirthing());
	    assertEquals("Tag1 should have been the active tag",tag1, getFixture().activeTag());
	    
	   
	    getFixture().setComments("Testing");
	    
	  //Wait 1 second then add an event to the second tag
		try {
	        long numMillisecondsToSleep = 1000; // 1 second
	        Thread.sleep(numMillisecondsToSleep);
	    } catch (InterruptedException e) {
	    }
	    
	    tag2.getEvents().add(TrackerFactory.eINSTANCE.createAnimalMissing());
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#eventHistory() <em>Event History</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#eventHistory()
	 * @generated NOT
	 */
	public void testEventHistory() {
		testAllEvents();
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#lastWeighIn() <em>Last Weigh In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#lastWeighIn()
	 * @generated NOT
	 */
	public void testLastWeighIn() {
		Animal animal = getFixture();
		assertNull("Should have no weight on animal", animal.getWeight());
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		tag.getEvents().add(we);
		
		assertNotNull( animal.lastWeighIn());
		
		assertEquals(we, animal.lastWeighIn());
	}

	/**
	 * Ticket 280 Tests serializing and de serializing an animal EObject
	 */
	public void testSerializing() {
		TrackerPackage.eINSTANCE.eClass();
		Animal animal = getFixture();
		assertNull("Should have no weight on animal", animal.getWeight());
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		tag.getEvents().add(we);
		
		assertNotNull( animal.lastWeighIn());
		
		assertEquals(we, animal.lastWeighIn());
		String serializedAnimal = null;
		try {
			serializedAnimal = serialiaze(animal);
//			System.out.println("Here it is:: " + serializedAnimal);
		} catch (Exception e) {
			fail("Failed to serialize animal");
		}
		if (serializedAnimal == null)
			fail("serializedAnimal is null");
		Animal aninimalAfterLoad = load(serializedAnimal);
		assertNotNull(aninimalAfterLoad);
		assertNotNull(aninimalAfterLoad.lastWeighIn());

		assertEquals(we.getDateTime(), aninimalAfterLoad.lastWeighIn()
				.getDateTime());
	}
	
	/**
	 * Ticket 558 Tests findingLastEvent by EventType
	 */
	public void testLastEvent(){
		Animal animal = getFixture();
		assertNull("Should have no weight on animal", animal.getWeight());
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		tag.getEvents().add(we);
		assertNotNull( animal.lastEvent(EventType.WEIGH_IN, null));
		assertEquals(we, animal.lastEvent(EventType.WEIGH_IN, null));
		
		
		we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		secondWeighInDate.add(Calendar.DAY_OF_MONTH, -5);
		we.setDateTime(
				secondWeighInDate.getTime());
		we.setWeight(100d);
		tag.getEvents().add(we);
		assertEquals(we, animal.lastEvent(EventType.WEIGH_IN, null));
		
		
		Event e = TrackerFactory.eINSTANCE.createGenericEvent();
		e.setComments("Third");
		Calendar thirdDate = Calendar.getInstance();
		thirdDate.add(Calendar.DAY_OF_MONTH, -5);
		e.setDateTime(
				thirdDate.getTime());
		
		tag.getEvents().add(e);
		assertEquals(e, animal.lastEvent(EventType.GENERIC_EVENT, null));
		
		
	}
	
	public void testIdentity() {
		assertNotNull("Animal must have an identitiy attribute", getFixture().eClass().getEIDAttribute());
		assertTrue("Animal id must be an identitiy attribute", getFixture().eClass().getEIDAttribute().getName().equals("id"));
	}
	
	private String serialiaze(EObject root) throws Exception {
		String returnStr = null;
		XMLResource xmlResource = new XMLResourceImpl();
		// xmlResource.setURI(URI.createURI("dummy"));
		XMLHelperImpl xmlHelper = new XMLHelperImpl(xmlResource);
		ArrayList<EObject> arrayList = new ArrayList<EObject>();
		arrayList.add(root);
		try {
		    returnStr = XMLHelperImpl.saveString(new HashMap<Object, Object>(),arrayList, "UTF-8",
		xmlHelper);
		}
		catch (Exception ex) {
		    logger.error(bundleMarker, "Failed to serialize", ex);
			throw ex;
		}
		return returnStr;
	}
	
	private Animal load(String root) {
		XMLResource xmlResource = new XMLResourceImpl();
		xmlResource.setXMLVersion("2.0");// needs this to prevent a
											// "Error: Feature 'version' not found."
		// xmlResource.setURI(URI.createURI("dummy"));
		// XMLHelperImpl xmlHelper = new XMLHelperImpl(xmlResource);
		Animal esmML = null;
		ByteArrayInputStream bais = new ByteArrayInputStream(root.getBytes());
		try {
			xmlResource.load(bais, new HashMap<Object, Object>());
		
		} catch (Resource.IOWrappedException ex) {// FeatureNotFoundException
//			Throwable t = ex.getCause(); // ex) {
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		esmML = (Animal) xmlResource.getContents().get(0);
		xmlResource.getContents().clear();
		return esmML;
	}
	
	class DebugAdapter implements Adapter{
		Notifier target = null;
	
		int counter = 0;
		
		
		public Notifier getTarget() {
			return target;
		}

		
		public boolean isAdapterForType(Object type) {
			return false;
		}

		
		public void notifyChanged(Notification notification) {
			System.out.println("Notification feature: "+notification);
			
		}

		
		public void setTarget(Notifier newTarget) {
			this.target=newTarget;
		}
	}
		
		
		
		
	
} //AnimalTest
