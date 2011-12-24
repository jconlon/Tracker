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
 * A test suite for the '<em><b>metatype</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetatypeTests extends TestSuite {

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
	 * @generated NOT
	 */
	public static Test suite() {
		TestSuite suite = new MetatypeTests("metatype Tests");
		suite.addTestSuite(ADTest.class);
//		suite.addTestSuite(DocumentRootTest.class);
		suite.addTestSuite(MetaDataTest.class);
		suite.addTestSuite(OCDTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetatypeTests(String name) {
		super(name);
	}

} //MetatypeTests
