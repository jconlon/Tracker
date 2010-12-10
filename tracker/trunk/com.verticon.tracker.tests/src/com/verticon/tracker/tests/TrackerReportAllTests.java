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

import com.verticon.osgi.metatype.tests.MetatypeTests;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import com.verticon.tracker.util.CalendarDateDurationTest;
import com.verticon.tracker.util.test.CheckEmailTest;
import com.verticon.tracker.util.test.CheckISO7064Mod37_36Test;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>TrackerReport</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrackerReportAllTests extends TestSuite {
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
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * Added non-generated tests
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Test suite() {
		TestSuite suite = new TrackerReportAllTests("Tracker Core Tests");
		suite.addTest(TrackerTests.suite());
		
		
		suite.addTestSuite(EventAttributeTest.class);
		suite.addTestSuite(EventHistoryAdapterFactoryTest.class);
		
		suite.addTestSuite(LocationTest.class);
		
		suite.addTestSuite(TrackerFactoryTest.class);
		
		suite.addTestSuite(CalendarDateDurationTest.class);
		suite.addTestSuite(CheckEmailTest.class);
		suite.addTestSuite(CheckISO7064Mod37_36Test.class);
				
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerReportAllTests(String name) {
		super(name);
	}

} //TrackerReportAllTests
