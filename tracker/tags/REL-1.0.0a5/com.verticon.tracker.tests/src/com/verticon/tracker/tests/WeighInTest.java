/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Weigh In</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WeighInTest extends EventTest {
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
		TestRunner.run(WeighInTest.class);
	}

	/**
	 * Constructs a new Weigh In test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeighInTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Weigh In test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private WeighIn getFixture() {
		return (WeighIn)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createWeighIn());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(WeighIn.EVENT_CODE, getFixture().getEventCode());
	}

} //WeighInTest
