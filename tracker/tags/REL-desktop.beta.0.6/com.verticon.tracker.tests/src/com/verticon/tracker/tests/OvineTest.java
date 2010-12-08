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

import com.verticon.tracker.Ovine;
import com.verticon.tracker.SheepBreed;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.util.Species;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ovine</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OvineTest extends AnimalTest {
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
		TestRunner.run(OvineTest.class);
	}

	/**
	 * Constructs a new Ovine test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OvineTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ovine test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Ovine getFixture() {
		return (Ovine)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		Ovine animal = TrackerFactory.eINSTANCE.createOvine();
		animal.setSheepBreed(SheepBreed.BC_LITERAL);
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
		assertEquals(SheepBreed.get(SheepBreed.BC).getName(), getFixture().getBreed());
	}

	@Override
	public void testGetSpecies() {
		assertNotNull(getFixture().getSpecies());
		assertEquals(Species.OVI.literal(), getFixture().getSpecies());
	}

	@Override
	public void testGetSpeciesCode() {
		assertNotNull(getFixture().getSpeciesCode());
		assertEquals(Species.OVI.name(), getFixture().getSpeciesCode());
	}
	
	@Override
	public void testGetAlternativeID() {
		assertNull(getFixture().getAlternativeID());
		
		getFixture().setScrapieTag("some value");
		assertEquals("some value",getFixture().getAlternativeID());
		
	}

} //OvineTest
