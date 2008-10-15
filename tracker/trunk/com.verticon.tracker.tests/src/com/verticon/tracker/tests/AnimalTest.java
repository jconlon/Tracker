/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Sex;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
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
		Animal animal = getFixture();
		assertNull("No weight on animal", animal.getWeight());
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100);
		tag.getEvents().add(we);
		
		assertEquals(new Integer(100), animal.getWeight());
		
		//Second weighIn today 250 lbs
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				secondWeighInDate.getTime());
		we2.setWeight(250);
		tag.getEvents().add(we2);
		assertEquals(new Integer(250), animal.getWeight());
		
		//Third weighIn today 350 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Third");
		we3.setWeight(350);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we3.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we3);
		assertEquals(new Integer(350), animal.getWeight());
		
		
	}


	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getWeightGainPerDay() <em>Weight Gain Per Day</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getWeightGainPerDay()
	 * @generated NOT
	 */
	public void testGetWeightGainPerDay() {
		Animal animal = getFixture();
		assertNull("No weight on animal", animal.getWeight());
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100);
		tag.getEvents().add(we);
		
		assertNull( animal.getWeightGainPerDay());
		
		//Second weighIn today 250 lbs
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				secondWeighInDate.getTime());
		we2.setWeight(250);
		tag.getEvents().add(we2);
		assertEquals(new Double(15.0), animal.getWeightGainPerDay());
		
		//Third weighIn today 350 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Third");
		we3.setWeight(350);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we3.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we3);
		assertEquals(new Double(10.0), animal.getWeightGainPerDay());
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
	 * @generated
	 */
	public void testGetAgeInDays() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	public void testGetWeightGainPerDayWithNulls() {
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
		we.setWeight(100);
		tag.getEvents().add(we);
		
		assertNull( animal.getWeightGainPerDay());
		
		//Second weighIn today 250 lbs
		WeighIn we1 = TrackerFactory.eINSTANCE.createWeighIn();
		we1.setComments("Null added");
		Calendar knullWeighInDate = Calendar.getInstance();
		we1.setDateTime(
				knullWeighInDate.getTime());
		tag.getEvents().add(we1);
		assertNull( animal.getWeightGainPerDay());
		
		
		//Second weighIn today 250 lbs
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				secondWeighInDate.getTime());
		we2.setWeight(250);
		tag.getEvents().add(we2);
		assertEquals(new Double(15.0), animal.getWeightGainPerDay());
		
		//Third weighIn today 350 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Third");
		we3.setWeight(350);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we3.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we3);
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
		logger.info("Animal2 add a tag1");
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.setId(AIN_1);
		animal2.getTags().add(tag1);
		
		//Add event1 to tag1 on animal2
		logger.info("Add event1 to tag1 on animal2");
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		tag1.getEvents().add(event1);
		assertEquals("Animal2 should have one event",1, animal2.eventHistory().size());
		assertTrue("Animald2 should contain the event1", animal2.eventHistory().contains(event1));
		
		//Add a second event to tag1
		logger.info("Add a second event to tag1");
		Event event2 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag1.getEvents().add(event2);
		assertEquals("Animal2 should have two events",2, animal2.eventHistory().size());
		assertTrue("Animald2 should contain event2",animal2.eventHistory().contains(event2));
		
		
		//Create a second tag and add it to animal2
		logger.info("Create a second tag and add it to animal2");
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		animal2.getTags().add(tag2);
		tag2.setId(AIN_2);
		
		//Create an event and add it to tag2 
		logger.info("Create an event and add it to tag2");
		Event event3 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag2.getEvents().add(event3);
		assertEquals("Animal2 should have three events (tag1==2, tag2==1)",3, animal2.eventHistory().size());
		assertTrue("Animald2 should contain event3",animal2.eventHistory().contains(event3));
		
		//Create another event and add it to tag2
		logger.info("Create another event and add it to tag2");
		Event event4 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag2.getEvents().add(event4);
		
		assertEquals("Animal2 should have three events (tag1==2, tag2==2) ",4, animal2.eventHistory().size());
		assertTrue("Animald2 should contain event3",animal2.eventHistory().contains(event4));
		
		//Delete an event
		logger.info("Deleting an event");
		tag2.getEvents().remove(event3);
		assertEquals("Animal2 should have two events (tag1==2, tag2==1) ",3, animal2.eventHistory().size());
		assertFalse("Animald2 should NOT contain event3",animal2.eventHistory().contains(event3));
		assertTrue("Animald2 should Still contain event4",animal2.eventHistory().contains(event4));
		
		//Delete a tag
		logger.info("Deleting a tag");
		animal2.getTags().remove(tag2);
		assertFalse("Animald2 should NOT contain event4",animal2.eventHistory().contains(event4));
		assertEquals("Animal2 should have two events (tag1==2) ",2, animal2.eventHistory().size());
		
		//Create a third tag add two events to it then add it to animal2
		logger.info("Create a third tag add events to it then add it to animal2");
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
		
		//There is no activeTag so don't accept the events
		getFixture().addTemplate(animal1.activeTag().getEvents());
		assertEquals(0, getFixture().eventHistory().size());
		
		//Add an activeTag 
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.setId(AIN_2);
		tag2.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		getFixture().getTags().add(tag2);
		assertEquals(1, getFixture().eventHistory().size());
		
		//There is now an activeTag so accept the events
		getFixture().addTemplate(animal1.activeTag().getEvents());
		assertEquals(4, getFixture().eventHistory().size());
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
		try {
	        long numMillisecondsToSleep = 1000; // 5 seconds
	        Thread.sleep(numMillisecondsToSleep);
	    } catch (InterruptedException e) {
	    }
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
				
		assertTrue(tag1.getEvents().get(0).getDateTime().before(tag2.getEvents().get(0).getDateTime()));
		assertEquals(-1, tag1.getEvents().get(0).getDateTime().compareTo(tag2.getEvents().get(0).getDateTime()));
		
		getFixture().getTags().add(tag1);
		getFixture().getTags().add(tag2);
		assertEquals(tag2, getFixture().activeTag());
		
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
		we.setWeight(100);
		tag.getEvents().add(we);
		
		assertNotNull( animal.lastWeighIn());
		
		assertEquals(we, animal.lastWeighIn());
	}


} //AnimalTest
