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
package com.verticon.tracker.fair.tests;

import com.verticon.tracker.fair.editor.tests.DivisionProcreatorTest;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Fair</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class FairAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * Added non-generated tests
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Test suite() {
		TestSuite suite = new FairAllTests("Tracker Fair Tests");
		suite.addTest(FairTests.suite());
		suite.addTestSuite(ClassTest.class);
		suite.addTestSuite(DepartmentTest.class);
		suite.addTestSuite(DivisionTest.class);
		suite.addTestSuite(LotTest.class);
		suite.addTestSuite(YouthClubTest.class);
		suite.addTestSuite(DivisionProcreatorTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FairAllTests(String name) {
		super(name);
	}

} //FairAllTests
