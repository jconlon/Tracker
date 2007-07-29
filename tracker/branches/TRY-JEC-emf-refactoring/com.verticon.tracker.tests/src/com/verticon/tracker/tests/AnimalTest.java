/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Sex;
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
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Animal#allEvents() <em>All Events</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class AnimalTest extends TestCase {
	private static final String AIN = "123456789012345";
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
			AnimalId ain = TrackerFactory.eINSTANCE.createAnimalId();
			ain.setIdNumber(AIN);
			fixture.getAins().add(ain);
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
	 * @generated
	 */
	public void testGetSpecies() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getIdNumber() <em>Id Number</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * FIXME Add more tests
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getIdNumber()
	 * @generated NOT
	 */
	public void testGetIdNumber() {
		assertNotNull(getFixture());
		assertEquals(AIN, getFixture().getIdNumber().toString());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#getBreed() <em>Breed</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#getBreed()
	 * @generated
	 */
	public void testGetBreed() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
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
	 * @generated
	 */
	public void testGetSpeciesCode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Animal#allEvents() <em>All Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * FIXME Add more tests
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Animal#allEvents()
	 * @generated NOT
	 */
	public void testAllEvents() {
		assertNotNull(getFixture().allEvents());
//		fail("Add more tests");
	}

} //AnimalTest
