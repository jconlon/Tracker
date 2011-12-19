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
 *   <li>{@link com.verticon.tracker.Position#getCoordinates() <em>Coordinates</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PositionTest extends EventTest {
	
	private static final double LONG = -122.084583;

	private static final double LAT = 37.42227;

	private static final String COORDINATES = "-122.084583,37.42227,0";

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

	/**
	 * Tests the '{@link com.verticon.tracker.Position#getCoordinates() <em>Coordinates</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Position#getCoordinates()
	 * @generated NOT
	 */
	public void testGetCoordinates() {
		getFixture().setLongitude(LONG);
		getFixture().setLatitude(LAT);
		String result = getFixture().getCoordinates();
		assertEquals(result,COORDINATES,result);
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
		getFixture().setLongitude(LONG);
		assertEquals(LONG,getFixture().getLongitude());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Position#getLatitude() <em>Latitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Position#getLatitude()
	 * @generated NOT
	 */
	public void testGetLatitude() {
		getFixture().setLatitude(LAT);
		assertEquals(LAT,getFixture().getLatitude());
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.tests.EventTest#testValues()
	 */
	@Override
	public void testValues() {
		assertEquals("longitude: 0.0, latitude: 0.0", getFixture().values());
	}

} //PositionTest
