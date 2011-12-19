/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.tests;

import com.verticon.tracker.Level;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.USBeefGrading;
import com.verticon.tracker.USBeefYieldGrade;
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
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.tests.EventTest#testValues()
	 */
	@Override
	public void testValues() {
		USBeefGrading e = getFixture();
		assertEquals("qualityGrade: , qualityGradeLevel: , yieldGrade: ", e.values());
		e.setQualityGrade(USQualityGrade.CHOICE);
		e.setQualityGradeLevel(Level.HIGH);
		e.setYieldGrade(USBeefYieldGrade.FIVE);
		assertEquals("qualityGrade: Choice, qualityGradeLevel: High, yieldGrade: 5", e.values());
		
	}


} //USBeefGradingTest
