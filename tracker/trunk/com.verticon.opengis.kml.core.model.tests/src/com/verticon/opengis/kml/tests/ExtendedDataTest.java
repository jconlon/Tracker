/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.opengis.kml.tests;

import com.verticon.opengis.kml.ExtendedData;
import com.verticon.opengis.kml.KmlFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Extended Data</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtendedDataTest extends TestCase {

	/**
	 * The fixture for this Extended Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedData fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExtendedDataTest.class);
	}

	/**
	 * Constructs a new Extended Data test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedDataTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Extended Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ExtendedData fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Extended Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedData getFixture() {
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
		setFixture(KmlFactory.eINSTANCE.createExtendedData());
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

} //ExtendedDataTest
