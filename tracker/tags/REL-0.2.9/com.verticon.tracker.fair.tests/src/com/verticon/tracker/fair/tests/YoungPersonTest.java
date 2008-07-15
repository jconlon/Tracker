/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair.tests;

import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.YoungPerson;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Young Person</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class YoungPersonTest extends PersonTest {

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
		TestRunner.run(YoungPersonTest.class);
	}

	/**
	 * Constructs a new Young Person test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YoungPersonTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Young Person test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected YoungPerson getFixture() {
		return (YoungPerson)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(FairFactory.eINSTANCE.createYoungPerson());
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

} //YoungPersonTest
