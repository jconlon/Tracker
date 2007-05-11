/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.Exported;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exported</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExportedTest extends EventTest {
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
		TestRunner.run(ExportedTest.class);
	}

	/**
	 * Constructs a new Exported test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Exported test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Exported getFixture() {
		return (Exported)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createExported());
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
		assertEquals(Exported.EVENT_CODE, getFixture().getEventCode());
	}

} //ExportedTest
