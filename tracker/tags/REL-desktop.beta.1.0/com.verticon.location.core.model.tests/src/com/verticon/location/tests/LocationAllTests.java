/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Location</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocationAllTests extends TestSuite {

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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new LocationAllTests("Location Tests");
		suite.addTest(LocationTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationAllTests(String name) {
		super(name);
	}

} //LocationAllTests
