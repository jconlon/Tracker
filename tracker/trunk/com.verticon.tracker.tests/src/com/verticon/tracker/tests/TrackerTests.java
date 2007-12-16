/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>tracker</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrackerTests extends TestSuite {
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
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new TrackerTests("tracker Tests");
		suite.addTestSuite(TagTest.class);
		suite.addTestSuite(TagAllocatedTest.class);
		suite.addTestSuite(PremisesTest.class);
		suite.addTestSuite(BovineBeefTest.class);
		suite.addTestSuite(OvineTest.class);
		suite.addTestSuite(BovineBisonTest.class);
		suite.addTestSuite(BovineDairyTest.class);
		suite.addTestSuite(TagAppliedTest.class);
		suite.addTestSuite(MovedInTest.class);
		suite.addTestSuite(MovedOutTest.class);
		suite.addTestSuite(LostTagTest.class);
		suite.addTestSuite(ReplacedTagTest.class);
		suite.addTestSuite(ImportedTest.class);
		suite.addTestSuite(ExportedTest.class);
		suite.addTestSuite(SightingTest.class);
		suite.addTestSuite(SlaughteredTest.class);
		suite.addTestSuite(DiedTest.class);
		suite.addTestSuite(TagRetiredTest.class);
		suite.addTestSuite(AnimalMissingTest.class);
		suite.addTestSuite(ICVITest.class);
		suite.addTestSuite(FairRegistrationTest.class);
		suite.addTestSuite(WeighInTest.class);
		suite.addTestSuite(SwineTest.class);
		suite.addTestSuite(EquineTest.class);
		suite.addTestSuite(CaprineTest.class);
		suite.addTestSuite(MedicalConditionTest.class);
		suite.addTestSuite(MedicalTreatmentTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerTests(String name) {
		super(name);
	}

} //TrackerTests
