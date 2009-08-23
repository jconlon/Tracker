/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import com.verticon.tracker.Level;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.USBeefGrading;
import com.verticon.tracker.USQualityGrade;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>US Beef Grading</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class USBeefGradingTest extends EventTest {

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
		TestRunner.run(USBeefGradingTest.class);
	}

	/**
	 * Constructs a new US Beef Grading test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USBeefGradingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this US Beef Grading test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected USBeefGrading getFixture() {
		return (USBeefGrading)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createUSBeefGrading());
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
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(109, getFixture().getEventCode());
	}
	
	
	public void testGrading(){
		getFixture().setQualityGrade(USQualityGrade.PRIME);
		assertEquals(USQualityGrade.PRIME, getFixture().getQualityGrade());
		getFixture().setQualityGradeLevel(Level.HIGH);
		assertEquals(Level.HIGH, getFixture().getQualityGradeLevel());
	}

} //USBeefGradingTest
