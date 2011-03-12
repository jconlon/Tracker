/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.google.kmlgx.KmlgxFactory;
import com.verticon.google.kmlgx.Tour;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Tour</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TourTest extends TestCase {

	/**
	 * The fixture for this Tour test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Tour fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TourTest.class);
	}

	/**
	 * Constructs a new Tour test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TourTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Tour test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Tour fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Tour test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Tour getFixture() {
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
		setFixture(KmlgxFactory.eINSTANCE.createTour());
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

} //TourTest
