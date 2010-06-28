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

import com.verticon.tracker.Equine;
import com.verticon.tracker.HorseBreed;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.util.Species;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Equine</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EquineTest extends AnimalTest {

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
		TestRunner.run(EquineTest.class);
	}

	/**
	 * Constructs a new Equine test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquineTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Equine test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Equine getFixture() {
		return (Equine)fixture;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		Equine animal = TrackerFactory.eINSTANCE.createEquine();
		animal.setHorseBreed(HorseBreed.AP);
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
	public void testGetSpecies() {
		assertNotNull(getFixture().getSpecies());
		assertEquals(Species.EQU.literal(), getFixture().getSpecies());
	}
	
	@Override
	public void testGetBreed() {
		assertNotNull(getFixture().getBreed());
		assertEquals(HorseBreed.get(HorseBreed.AP_VALUE).getName(), getFixture().getBreed());
	}
	
	@Override
	public void testGetSpeciesCode() {
		assertNotNull(getFixture().getSpeciesCode());
		assertEquals(Species.EQU.name(), getFixture().getSpeciesCode());
	}

} //EquineTest
