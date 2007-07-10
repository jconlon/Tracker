/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.UnAppliedTags;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Un Applied Tags</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnAppliedTagsTest extends TestCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Un Applied Tags test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnAppliedTags fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UnAppliedTagsTest.class);
	}

	/**
	 * Constructs a new Un Applied Tags test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnAppliedTagsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Un Applied Tags test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(UnAppliedTags fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Un Applied Tags test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private UnAppliedTags getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createUnAppliedTags());
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

	public void testGetUnAppliedTags() {
		assertNotNull(getFixture());
		assertTrue( getFixture().getAin().isEmpty());
		AnimalId ain = TrackerFactory.eINSTANCE.createAnimalId();
		getFixture().getAin().add(ain);
		
		assertEquals(1, getFixture().getAin().size());
	}
} //UnAppliedTagsTest
