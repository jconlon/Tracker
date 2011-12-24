/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.tests;

import junit.textui.TestRunner;

import com.verticon.google.kmlgx.AnimatedUpdate;
import com.verticon.google.kmlgx.KmlgxFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Animated Update</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimatedUpdateTest extends TourPrimitiveTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AnimatedUpdateTest.class);
	}

	/**
	 * Constructs a new Animated Update test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimatedUpdateTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Animated Update test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AnimatedUpdate getFixture() {
		return (AnimatedUpdate)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KmlgxFactory.eINSTANCE.createAnimatedUpdate());
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

} //AnimatedUpdateTest
