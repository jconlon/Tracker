/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import com.verticon.tracker.Swine;
import com.verticon.tracker.SwineBreed;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.util.Species;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Swine</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SwineTest extends AnimalTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SwineTest.class);
	}

	/**
	 * Constructs a new Swine test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwineTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Swine test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Swine getFixture() {
		return (Swine)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		Swine animal = TrackerFactory.eINSTANCE.createSwine();
		animal.setSwineBreed(SwineBreed.BK_LITERAL);
		setFixture(animal);
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
	
	@Override
	public void testGetBreed() {
		assertNotNull(getFixture().getBreed());
		assertEquals(SwineBreed.get(SwineBreed.BK).getName(), getFixture().getBreed());
	}

	@Override
	public void testGetSpecies() {
		assertNotNull(getFixture().getSpecies());
		assertEquals(Species.POR.literal(), getFixture().getSpecies());
	}

	@Override
	public void testGetSpeciesCode() {
		assertNotNull(getFixture().getSpeciesCode());
		assertEquals(Species.POR.name(), getFixture().getSpeciesCode());
	}

} //SwineTest
