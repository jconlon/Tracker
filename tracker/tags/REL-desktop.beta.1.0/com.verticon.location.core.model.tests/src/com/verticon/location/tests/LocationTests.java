/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>location</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocationTests extends TestSuite {

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
		TestSuite suite = new LocationTests("location Tests");
		suite.addTestSuite(LocationTest.class);
		suite.addTestSuite(AreaTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationTests(String name) {
		super(name);
	}

} //LocationTests
