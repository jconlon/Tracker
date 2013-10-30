/**
 */
package org.usaha.ecvi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.usaha.ecvi.EcviFactory;
import org.usaha.ecvi.GeoPoint;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Geo Point</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeoPointTest extends TestCase {

	/**
	 * The fixture for this Geo Point test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeoPoint fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GeoPointTest.class);
	}

	/**
	 * Constructs a new Geo Point test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoPointTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Geo Point test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(GeoPoint fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Geo Point test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeoPoint getFixture() {
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
		setFixture(EcviFactory.eINSTANCE.createGeoPoint());
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

} //GeoPointTest
