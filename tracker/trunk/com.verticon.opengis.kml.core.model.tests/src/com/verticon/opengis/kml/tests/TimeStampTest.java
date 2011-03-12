/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.opengis.kml.tests;

import com.verticon.opengis.kml.KmlFactory;
import com.verticon.opengis.kml.TimeStamp;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Time Stamp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.opengis.kml.TimeStamp#getTimeStampSimpleExtensionGroup() <em>Time Stamp Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.TimeStamp#getTimeStampObjectExtensionGroup() <em>Time Stamp Object Extension Group</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TimeStampTest extends TimePrimitiveTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TimeStampTest.class);
	}

	/**
	 * Constructs a new Time Stamp test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeStampTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Time Stamp test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TimeStamp getFixture() {
		return (TimeStamp)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KmlFactory.eINSTANCE.createTimeStamp());
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
	 * Tests the '{@link com.verticon.opengis.kml.TimeStamp#getTimeStampSimpleExtensionGroup() <em>Time Stamp Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.TimeStamp#getTimeStampSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetTimeStampSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.TimeStamp#getTimeStampObjectExtensionGroup() <em>Time Stamp Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.TimeStamp#getTimeStampObjectExtensionGroup()
	 * @generated
	 */
	public void testGetTimeStampObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //TimeStampTest
