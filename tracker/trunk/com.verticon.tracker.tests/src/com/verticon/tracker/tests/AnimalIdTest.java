/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.tracker.AnimalId;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Animal Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.AnimalId#isUsainNumberUsed() <em>Usain Number Used</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class AnimalIdTest extends TestCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Animal Id test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalId fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AnimalIdTest.class);
	}

	/**
	 * Constructs a new Animal Id test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalIdTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Animal Id test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AnimalId fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Animal Id test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalId getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createAnimalId());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link com.verticon.tracker.AnimalId#isUsainNumberUsed() <em>Usain Number Used</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.AnimalId#isUsainNumberUsed()
	 * @generated NOT
	 */
	public void testIsUsainNumberUsed() {
		AnimalId animalId = getFixture();
		assertNotNull(animalId);
		assertNull(animalId.getIdNumber());
		animalId.setIdNumber("123456789012345");
		assertFalse(animalId.isUsainNumberUsed());
		animalId.setIdNumber("840456789012345");
		assertTrue(animalId.isUsainNumberUsed());
		
	}
	


} //AnimalIdTest
