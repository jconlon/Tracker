/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.tests;

import junit.textui.TestRunner;

import com.verticon.google.kmlgx.KmlgxFactory;
import com.verticon.google.kmlgx.Wait;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Wait</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WaitTest extends TourPrimitiveTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(WaitTest.class);
	}

	/**
	 * Constructs a new Wait test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Wait test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Wait getFixture() {
		return (Wait)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KmlgxFactory.eINSTANCE.createWait());
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

} //WaitTest
