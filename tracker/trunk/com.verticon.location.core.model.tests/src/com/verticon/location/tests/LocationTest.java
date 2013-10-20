/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EObject;

import com.verticon.location.Area;
import com.verticon.location.Location;
import com.verticon.location.LocationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.location.Location#getCoordinates() <em>Get Coordinates</em>}</li>
 *   <li>{@link com.verticon.location.Location#getAddress() <em>Get Address</em>}</li>
 *   <li>{@link com.verticon.location.Location#containsPoint(java.lang.String) <em>Contains Point</em>}</li>
 *   <li>{@link com.verticon.location.Location#locate(java.lang.String) <em>Locate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class LocationTest extends TestCase {

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
		setFixture(LocationFactory.eINSTANCE.createLocation());
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
	 * Tests the '{@link com.verticon.location.Location#getCoordinates() <em>Get Coordinates</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.Location#getCoordinates()
	 * @generated NOT
	 */
	public void testGetCoordinates() {
		getFixture().setLongitude(-90.89322601925117);
		getFixture().setLatitude(43.55460596065134);
		getFixture().setAltitude(1);
		assertThat("Must have coordinates", getFixture().getCoordinates(), is(AreaTest.BASEBALL_FIELD_POINT));
	}

	/**
	 * Tests the '{@link com.verticon.location.Location#getAddress() <em>Get Address</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.Location#getAddress()
	 * @generated NOT
	 */
	public void testGetAddress() {
		getFixture().setName("test");
		getFixture().setDescription("test");
		getFixture().setStreet("street");
		getFixture().setCity("city");
		getFixture().setState("state");
		getFixture().setPostalCode("postal");
		assertThat("Must have address", getFixture().getAddress(), is("street city, state postal"));
	}

	/**
	 * Tests the '{@link com.verticon.location.Location#containsPoint(java.lang.String) <em>Contains Point</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.Location#containsPoint(java.lang.String)
	 * @generated NOT
	 */
	public void testContainsPoint__String() {
        assertThat("SouthFairgrounds must not be in the NW area",getFixture().containsPoint(AreaTest.SOUTH_FAIRGROUNDS_POINT),
        		is(false));
		Area area = LocationFactory.eINSTANCE.createArea();
		area.setBoundary(AreaTest.GOOD_S_POLYGON_COORDS);
		area.setName("testArea");
		getFixture().getAreas().add(area);
		assertThat("SouthFairgrounds must not be in the South area",
				getFixture().containsPoint(AreaTest.SOUTH_FAIRGROUNDS_POINT),is(false));
		assertThat("Baseball field must be in the South area",getFixture().containsPoint(AreaTest.BASEBALL_FIELD_POINT),
				is(true));
		
	}

	/**
	 * Tests the '{@link com.verticon.location.Location#locate(java.lang.String) <em>Locate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.Location#locate(java.lang.String)
	 * @generated NOT
	 */
	public void testLocate__String() {
		assertThat("SouthFairgrounds must not be in the NW area",
				getFixture().locate(AreaTest.SOUTH_FAIRGROUNDS_POINT),
        		is(nullValue()));
		Area area = LocationFactory.eINSTANCE.createArea();
		area.setBoundary(AreaTest.GOOD_S_POLYGON_COORDS);
		area.setName("testArea");
		getFixture().getAreas().add(area);
		assertThat("SouthFairgrounds must not be in the South area",
				getFixture().locate(AreaTest.SOUTH_FAIRGROUNDS_POINT),is(nullValue()));
		assertThat("Baseball field must be in the South area",
				getFixture().locate(AreaTest.BASEBALL_FIELD_POINT),
				is("testArea"));
		
	}
	
	
	public void testValidation() {
		assertFalse(isValidObject(getFixture()));// Still needs name...
		getFixture().setName("test");
		getFixture().setDescription("test");
		getFixture().setStreet("test");
		getFixture().setCity("test");
		getFixture().setState("test");
		getFixture().setPostalCode("test");
		assertFalse(isValidObject(getFixture()));// Still needs...
		getFixture().setLongitude(111);
		getFixture().setLatitude(-111);
		getFixture().setAltitude(999);
		getFixture().setPhoneNumber("test");
		
		String validationMessage = AreaTest.validateObject(getFixture());
		assertThat("Location failed validation. ", validationMessage, is(nullValue()));
	}
	
	private static boolean isValidObject(EObject eObject){
		return AreaTest.validateObject(eObject)==null;
	}

} //LocationTest
