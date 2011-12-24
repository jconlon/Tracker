/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.osgi.metatype.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Metatype</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetatypeAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new MetatypeAllTests("Metatype Tests");
		suite.addTest(MetatypeTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetatypeAllTests(String name) {
		super(name);
	}

} //MetatypeAllTests
