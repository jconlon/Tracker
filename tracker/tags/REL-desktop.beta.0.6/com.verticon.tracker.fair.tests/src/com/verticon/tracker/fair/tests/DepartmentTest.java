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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.FairFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DepartmentTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Department test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Department fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DepartmentTest.class);
	}

	/**
	 * Constructs a new Department test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepartmentTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Department test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Department fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Department test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Department getFixture() {
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
		setFixture(FairFactory.eINSTANCE.createDepartment());
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
	 *
	 * @generated NOT
	 */
	public void testName() {
		assertNotNull(getFixture());
		assertNull(getFixture().getName());
		getFixture().setName("TEST");
		assertEquals("TEST", getFixture().getName());
		
	}
} //DepartmentTest
