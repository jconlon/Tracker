/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker.tests;

import com.verticon.tracker.EventType;
import com.verticon.tracker.Policy;
import com.verticon.tracker.TrackerFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Policy#canContain(com.verticon.tracker.EventType, java.lang.String, com.verticon.tracker.AnimalType) <em>Can Contain</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PolicyTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Policy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Policy fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PolicyTest.class);
	}

	/**
	 * Constructs a new Policy test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Policy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Policy fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Policy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Policy getFixture() {
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
		setFixture(TrackerFactory.eINSTANCE.createPolicy());
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
	 * Tests the '{@link com.verticon.tracker.Policy#canContain(com.verticon.tracker.EventType, java.lang.String, com.verticon.tracker.AnimalType) <em>Can Contain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Policy#canContain(com.verticon.tracker.EventType, java.lang.String, com.verticon.tracker.AnimalType)
	 * @generated NOT
	 */
	public void testCanContain__EventType_String_AnimalType() {
		assertTrue(getFixture().canContain(EventType.ANIMAL_MISSING, null, null));
		
	}

} //PolicyTest
