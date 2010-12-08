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

import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.DairyBreed;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.util.Species;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Bovine Dairy</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BovineDairyTest extends BovineTest {
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
		TestRunner.run(BovineDairyTest.class);
	}

	/**
	 * Constructs a new Bovine Dairy test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BovineDairyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Bovine Dairy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected BovineDairy getFixture() {
		return (BovineDairy)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		
		BovineDairy animal = TrackerFactory.eINSTANCE.createBovineDairy();
		animal.setDairyBreed(DairyBreed.GU_LITERAL);
		setFixture(animal);
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
	public void testGetBreed() {
		assertNotNull(getFixture().getBreed());
		assertEquals(DairyBreed.get(DairyBreed.GU).getName(), getFixture().getBreed());
	}

	@Override
	public void testGetSpecies() {
		assertNotNull(getFixture().getSpecies());
		assertEquals(Species.BOV.literal(), getFixture().getSpecies());
	}

	@Override
	public void testGetSpeciesCode() {
		assertNotNull(getFixture().getSpeciesCode());
		assertEquals(Species.BOV.name(), getFixture().getSpeciesCode());
	}
} //BovineDairyTest
