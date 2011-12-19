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

import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.USSwineGrading;
import com.verticon.tracker.USSwineQualityGrade;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>US Swine Grading</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class USSwineGradingTest extends EventTest {

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
		TestRunner.run(USSwineGradingTest.class);
	}

	/**
	 * Constructs a new US Swine Grading test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USSwineGradingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this US Swine Grading test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected USSwineGrading getFixture() {
		return (USSwineGrading)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createUSSwineGrading());
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
		assertEquals(110, getFixture().getEventCode());
	}
	
	
	public void testGrading(){
		getFixture().setQualityGrade(USSwineQualityGrade.FOUR);
		assertEquals(USSwineQualityGrade.FOUR, getFixture().getQualityGrade());
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.tests.EventTest#testValues()
	 */
	@Override
	public void testValues() {
		assertEquals("qualityGrade: ", getFixture().values());
	}

} //USSwineGradingTest
