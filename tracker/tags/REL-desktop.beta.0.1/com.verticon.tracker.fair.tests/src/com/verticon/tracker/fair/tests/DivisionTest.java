/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.FairFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Division</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DivisionTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Division test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Division fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DivisionTest.class);
	}

	/**
	 * Constructs a new Division test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivisionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Division test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Division fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Division test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Division getFixture() {
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
		setFixture(FairFactory.eINSTANCE.createDivision());
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
	 *
	 * @generated NOT
	 */
	public void testName() {
		assertNotNull(getFixture());
		assertNull(getFixture().getName());
		getFixture().setName("TEST");
		assertEquals("TEST", getFixture().getName());
		
	}

} //DivisionTest
