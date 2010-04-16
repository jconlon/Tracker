/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import com.verticon.tracker.Location;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sighting</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SightingTest extends EventTest {
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
		TestRunner.run(SightingTest.class);
	}

	/**
	 * Constructs a new Sighting test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SightingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sighting test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Sighting getFixture() {
		return (Sighting)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createSighting());
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
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(Sighting.EVENT_CODE, getFixture().getEventCode());
	}
	
	
	public void testGetLocation(){
		assertNotNull(getFixture());
		assertNull(getFixture().getLocation());
		Location location = TrackerFactory.eINSTANCE.createLocation();
		location.setName("FishHouse");
		getFixture().setLocation(location);
		assertEquals("FishHouse",getFixture().getLocation().getName());
	}

} //SightingTest
