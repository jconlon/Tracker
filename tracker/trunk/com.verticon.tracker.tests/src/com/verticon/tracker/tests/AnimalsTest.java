/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Animals;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.Sex;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Animals</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimalsTest extends TestCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Animals test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Animals fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AnimalsTest.class);
	}

	/**
	 * Constructs a new Animals test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Animals test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Animals fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Animals test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Animals getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createAnimals());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	public void testGetAnimals() {
		assertNotNull(getFixture());
		assertTrue( getFixture().getAnimal().isEmpty());
	
		Animal beef = TrackerFactory.eINSTANCE.createBovineBeef();
		getFixture().getAnimal().add(beef);
		assertEquals(1, getFixture().getAnimal().size());
	}
	

	/**
	 * @return
	 */
	public static Animals getAnimalsForTesting() {
		Animals animals = TrackerFactory.eINSTANCE.createAnimals();
		 
		//Add a steer
		 Animal beef = TrackerFactory.eINSTANCE.createBovineBeef();
		 beef.setSex(Sex.F_LITERAL);
		 DateFormat df = DateFormat.getDateInstance();
		 Date date = null;
		 try {
		    date = df.parse("Sep 11, 2001");
		} catch (ParseException e) {
			fail(e.getLocalizedMessage());
		}
		 beef.setBirthDate(date);
		 animals.getAnimal().add(beef);
		 
		 //Add a swine
		 Animal swine = TrackerFactory.eINSTANCE.createSwine();
		 swine.setSex(Sex.F_LITERAL);
		 try {
		    date = df.parse("Sep 11, 2001");
		} catch (ParseException e) {
			fail(e.getLocalizedMessage());
		}
		 swine.setBirthDate(date);
		 animals.getAnimal().add(swine);
		return animals;
	}
	
	
	
	

} //AnimalsTest
