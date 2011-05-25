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

import com.verticon.tracker.Location;
import com.verticon.tracker.TrackerFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Location#getLongitude() <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.tracker.Location#getLatitude() <em>Latitude</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class LocationTest extends TestCase {

	private static final double LONG_RAD = -1.586305516;

	private static final double LAT_RAD = 0.760212093;

	private static final double LONG_ERROR = .002;

	private static final double LAT_ERROR = .001;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Location test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Location fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LocationTest.class);
	}

	/**
	 * Constructs a new Location test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Location test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Location fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Location test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Location getFixture() {
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
		setFixture(TrackerFactory.eINSTANCE.createLocation());
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
	 * Tests the '{@link com.verticon.tracker.Location#getLongitude() <em>Longitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Location#getLongitude()
	 * @generated NOT
	 */
	public void testGetLongitude() {
		getFixture().setLongitudeError(LONG_ERROR);
		getFixture().setLongitudeInRadians(LONG_RAD);
		assertEquals(-90.88861108512228,getFixture().getLongitude());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Location#getLatitude() <em>Latitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Location#getLatitude()
	 * @generated NOT
	 */
	public void testGetLatitude() {
		getFixture().setLatitudeError(LAT_ERROR);
		getFixture().setLatitudeInRadians(LAT_RAD);
		assertEquals(43.556944463706834,getFixture().getLatitude());
	}

	public void testGetName() {
		assertNotNull(fixture);
		assertNull(fixture.getName());
		fixture.setName("SomeName");
		assertEquals("SomeName", fixture.getName());
	}

} //LocationTest
