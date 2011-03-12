/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.opengis.kml.tests;

import com.verticon.opengis.kml.KmlFactory;
import com.verticon.opengis.kml.Region;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.opengis.kml.Region#getRegionSimpleExtensionGroup() <em>Region Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.Region#getRegionObjectExtensionGroup() <em>Region Object Extension Group</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class RegionTest extends AbstractObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RegionTest.class);
	}

	/**
	 * Constructs a new Region test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Region test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Region getFixture() {
		return (Region)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KmlFactory.eINSTANCE.createRegion());
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
	 * Tests the '{@link com.verticon.opengis.kml.Region#getRegionSimpleExtensionGroup() <em>Region Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.Region#getRegionSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetRegionSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.Region#getRegionObjectExtensionGroup() <em>Region Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.Region#getRegionObjectExtensionGroup()
	 * @generated
	 */
	public void testGetRegionObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //RegionTest
