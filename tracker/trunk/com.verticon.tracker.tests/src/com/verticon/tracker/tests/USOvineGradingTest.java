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

import junit.textui.TestRunner;

import com.verticon.tracker.Level;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.USOvineGrading;
import com.verticon.tracker.USQualityGrade;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>US Ovine Grading</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class USOvineGradingTest extends EventTest {

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
		TestRunner.run(USOvineGradingTest.class);
	}

	/**
	 * Constructs a new US Ovine Grading test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USOvineGradingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this US Ovine Grading test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected USOvineGrading getFixture() {
		return (USOvineGrading)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createUSOvineGrading());
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
		assertEquals(111, getFixture().getEventCode());
	}
	
	
	public void testGrading(){
		getFixture().setQualityGrade(USQualityGrade.PRIME);
		assertEquals(USQualityGrade.PRIME, getFixture().getQualityGrade());
		getFixture().setQualityGradeLevel(Level.HIGH);
		assertEquals(Level.HIGH, getFixture().getQualityGradeLevel());
	}

} //USOvineGradingTest
