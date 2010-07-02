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
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.Lot;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Fair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Fair#exhibits() <em>Exhibits</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class FairTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Fair test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Fair fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FairTest.class);
	}

	/**
	 * Constructs a new Fair test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FairTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Fair test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Fair fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Fair test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Fair getFixture() {
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
		setFixture(FairFactory.eINSTANCE.createFair());
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
	 * Tests the '{@link com.verticon.tracker.fair.Fair#exhibits() <em>Exhibits</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.Fair#exhibits()
	 * @generated NOT
	 */
	public void testExhibits() {
		assertNotNull(fixture.exhibits());
		assertTrue(fixture.exhibits().isEmpty());
		
		Division division = FairFactory.eINSTANCE.createDivision();
		fixture.getDivisions().add(division);
		
		Department department = FairFactory.eINSTANCE.createDepartment();
		division.getDepartments().add(department);
		
		com.verticon.tracker.fair.Class clazz = FairFactory.eINSTANCE.createClass();
		department.getClasses().add(clazz);
		
		Lot lot = FairFactory.eINSTANCE.createLot();
		clazz.getLots().add(lot);
		
		assertTrue("Should be still empty",fixture.exhibits().isEmpty());
		
		//Add an exhibit
		Exhibit exhibit1 = FairFactory.eINSTANCE.createExhibit();
		lot.getExhibits().add(exhibit1);
		
		assertEquals("Should be one", 1, fixture.exhibits().size());
		assertEquals("Should be equal", exhibit1, fixture.exhibits().get(0));
		
		//Add a second exhibit
		Exhibit exhibit2 = FairFactory.eINSTANCE.createExhibit();
		lot.getExhibits().add(exhibit2);
		assertEquals("Should be two", 2, fixture.exhibits().size());
	}

} //FairTest
