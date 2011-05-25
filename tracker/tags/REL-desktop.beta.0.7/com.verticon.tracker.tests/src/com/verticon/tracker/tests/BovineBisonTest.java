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

import com.verticon.tracker.BisonBreed;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.util.Species;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Bovine Bison</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BovineBisonTest extends BovineTest {
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
		TestRunner.run(BovineBisonTest.class);
	}

	/**
	 * Constructs a new Bovine Bison test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BovineBisonTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Bovine Bison test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected BovineBison getFixture() {
		return (BovineBison)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		BovineBison animal = TrackerFactory.eINSTANCE.createBovineBison();
		animal.setBuffaloBreed(BisonBreed.WO_LITERAL);
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
		assertEquals(BisonBreed.get(BisonBreed.WO).getName(), getFixture().getBreed());
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

} //BovineBisonTest
