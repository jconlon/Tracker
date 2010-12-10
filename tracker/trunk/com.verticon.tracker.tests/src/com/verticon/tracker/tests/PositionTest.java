/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker.tests;

import com.verticon.tracker.Position;
import com.verticon.tracker.TrackerFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Position#getLongitude() <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.tracker.Position#getLatitude() <em>Latitude</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PositionTest extends EventTest {
	
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PositionTest.class);
	}

	/**
	 * Constructs a new Position test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Position test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Position getFixture() {
		return (Position)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createPosition());
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
		assertEquals(15, getFixture().getEventCode());
	}
	
	
	/**
	 * Tests the '{@link com.verticon.tracker.Position#getLongitude() <em>Longitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Position#getLongitude()
	 * @generated NOT
	 */
	public void testGetLongitude() {
		getFixture().setLongitudeError(LONG_ERROR);
		getFixture().setLongitudeInRadians(LONG_RAD);
		assertEquals(-90.88861108512228,getFixture().getLongitude());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Position#getLatitude() <em>Latitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Position#getLatitude()
	 * @generated NOT
	 */
	public void testGetLatitude() {
		getFixture().setLatitudeError(LAT_ERROR);
		getFixture().setLatitudeInRadians(LAT_RAD);
		assertEquals(43.556944463706834,getFixture().getLatitude());
	}

} //PositionTest
