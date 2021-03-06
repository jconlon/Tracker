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

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Sex;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.util.Age;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Animal#getSpecies() <em>Species</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getIdNumber() <em>Id Number</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getBreed() <em>Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getAge() <em>Age</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSexCode() <em>Sex Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSpeciesCode() <em>Species Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getId() <em>Id</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Animal#allEvents() <em>All Events</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#addTemplate(org.eclipse.emf.common.util.EList) <em>Add Template</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#activeTag() <em>Active Tag</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class AnimalTest extends TestCase {
	private static final long AIN_2 = 123456789012342L;
	private static final long AIN_1 = 123456789012341L;
	
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
			tag.setIdNumber(AIN_1);
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
	 * Tests the '{@link com.verticon.tracker.Animal#getIdNumber() <em>Id Number</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * 
	 * AnimalIdNumber is derived from the IdNumber of the current Tag
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getIdNumber()
	 * @generated NOT
	 */
	public void testGetIdNumber() {
		//Test animal with one tag that has a number
		assertNotNull("Test with one tag that has a number", getFixture());
		assertEquals(0, getFixture().getIdNumber());
		
		//Test animal with no tag
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		assertEquals("Test with no tag", 0, animal2.getIdNumber());
		
		//Test animal with one tag that has no idNumber
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		animal2.getTags().add(tag2);
		assertEquals("Test with no tag", 0, animal2.getIdNumber());
		
		//Test animal with two tags that have no numbers
		Tag tag3 = TrackerFactory.eINSTANCE.createTag();
		animal2.getTags().add(tag3);
		assertEquals("Test with no tag", 0, animal2.getIdNumber());
		
		//Test animal with two tags one with an IdNumber the other without
		tag2.setIdNumber(AIN_1);
		assertEquals("Test with no tag", 0, animal2.getIdNumber());
		
		//Test animal with two tags one with an event
		tag2.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		assertEquals("Test with no tag", AIN_1, animal2.getIdNumber());
		
		//Find the tag with the most current event timestamp.
		tag3.setIdNumber(AIN_2);
		try {
	        long numMillisecondsToSleep = 500; // 5 seconds
	        Thread.sleep(numMillisecondsToSleep);
	    } catch (InterruptedException e) {
	    }
		tag3.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		assertEquals( AIN_2, animal2.getIdNumber());

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
	 * Tests the '{@link com.verticon.tracker.Animal#getAge() <em>Age</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getAge()
	 * @generated NOT
	 */
	public void testGetAge() {
		assertNotNull(getFixture());
		assertNotNull(getFixture().getAge());
		assertEquals(new Age(ANIMAL_BIRTHDAY), getFixture().getAge());
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

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#isSetSexCode() <em>isSetSexCode()</em>}' method.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#isSetSexCode()
	 * @generated NOT
	 */
	public void testIsSetSexCode() {
		assertNotNull(getFixture());
		assertTrue(getFixture().isSetSexCode());
	}

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
	 * @generated
	 */
	public void testGetId() {
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#allEvents() <em>All Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#allEvents()
	 * @generated NOT
	 */
	public void testAllEvents() {
		assertNotNull(getFixture().allEvents());
		
		assertTrue(getFixture().allEvents().isEmpty());

		//Test animal with no tag
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.setIdNumber(AIN_1);
		animal2.getTags().add(tag2);
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		tag2.getEvents().add(event1);
		assertEquals(1, animal2.allEvents().size());
		assertTrue(animal2.allEvents().contains(event1));
		
		Tag tag3 = TrackerFactory.eINSTANCE.createTag();
		animal2.getTags().add(tag3);
		tag3.setIdNumber(AIN_2);
		
		Event event2 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag3.getEvents().add(event2);
		
		assertEquals(2, animal2.allEvents().size());
		assertTrue(animal2.allEvents().contains(event2));
	}

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
		tag1.setIdNumber(AIN_1);
		tag1.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		tag1.getEvents().add(TrackerFactory.eINSTANCE.createSighting());
		tag1.getEvents().add(TrackerFactory.eINSTANCE.createSlaughtered());
		animal1.getTags().add(tag1);
		
		//There is no activeTag so don't accept the events
		getFixture().addTemplate(animal1.activeTag().getEvents());
		assertEquals(0, getFixture().allEvents().size());
		
		//Add an activeTag 
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.setIdNumber(AIN_2);
		tag2.getEvents().add(TrackerFactory.eINSTANCE.createTagApplied());
		getFixture().getTags().add(tag2);
		assertEquals(1, getFixture().allEvents().size());
		
		//There is now an activeTag so accept the events
		getFixture().addTemplate(animal1.activeTag().getEvents());
		assertEquals(4, getFixture().allEvents().size());
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

} //AnimalTest
