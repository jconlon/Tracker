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

import com.verticon.tracker.Animal;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.Person;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exhibit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getName() <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getNumber() <em>Number</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getSalesOrder() <em>Sales Order</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ExhibitTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Exhibit test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Exhibit fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExhibitTest.class);
	}

	/**
	 * Constructs a new Exhibit test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExhibitTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Exhibit test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Exhibit fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Exhibit test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Exhibit getFixture() {
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
		setFixture(FairFactory.eINSTANCE.createExhibit());
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
	 * Tests the '{@link com.verticon.tracker.fair.Exhibit#getName() <em>Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.Exhibit#getName()
	 * @generated NOT
	 */
	public void testGetName() {
		Exhibit exhibit = getFixture();
		assertNotNull(exhibit);
		assertEquals(0, exhibit.getSalesOrder());
		
		Person person = FairFactory.eINSTANCE.createPerson();
		person.setFirstName("Jack");
		person.setLastName("Condor");
		exhibit.setExhibitor(person);
		assertEquals("Jack Condor", exhibit.getName());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.fair.Exhibit#getNumber() <em>Number</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.Exhibit#getNumber()
	 * @generated NOT
	 */
	public void testGetNumber() {
		Exhibit exhibit = getFixture();
		assertNotNull(exhibit);
		assertEquals(0, exhibit.getSalesOrder());
		
		Person person = FairFactory.eINSTANCE.createPerson();
		person.setExhibitorNumber(5);
		exhibit.setExhibitor(person);
		assertEquals(5, exhibit.getNumber());
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.fair.Exhibit#getSalesOrder() <em>Sales Order</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.Exhibit#getSalesOrder()
	 * @generated NOT
	 */
	public void testGetSalesOrder() {
		Exhibit exhibit = getFixture();
		assertNotNull(exhibit);
		assertEquals(0, exhibit.getSalesOrder());
		
		Person person = FairFactory.eINSTANCE.createPerson();
		person.setSalesOrder(5);
		exhibit.setExhibitor(person);
		assertEquals(0, exhibit.getSalesOrder());
		
		Animal animal = TrackerFactory.eINSTANCE.createBovineBeef();
		exhibit.setAnimal(animal);
		assertEquals(0, exhibit.getSalesOrder());
		
		exhibit.setInAuction(true);
		assertEquals(5, exhibit.getSalesOrder());
		exhibit.setInAuction(false);
		assertEquals(0, exhibit.getSalesOrder());
		
	}

} //ExhibitTest
