/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.opengis.kml.tests;

import com.verticon.opengis.kml.Data;
import com.verticon.opengis.kml.KmlFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.opengis.kml.Data#getDataExtension() <em>Data Extension</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class DataTest extends AbstractObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DataTest.class);
	}

	/**
	 * Constructs a new Data test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Data getFixture() {
		return (Data)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KmlFactory.eINSTANCE.createData());
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
	 * Tests the '{@link com.verticon.opengis.kml.Data#getDataExtension() <em>Data Extension</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.Data#getDataExtension()
	 * @generated
	 */
	public void testGetDataExtension() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //DataTest
