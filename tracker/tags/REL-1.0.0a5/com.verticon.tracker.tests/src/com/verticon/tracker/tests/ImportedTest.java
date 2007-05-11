/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.Imported;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Imported</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImportedTest extends EventTest {
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
		TestRunner.run(ImportedTest.class);
	}

	/**
	 * Constructs a new Imported test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportedTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Imported test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Imported getFixture() {
		return (Imported)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createImported());
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
		assertEquals(7, getFixture().getEventCode());
	}

} //ImportedTest
