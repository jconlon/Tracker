/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
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
		suite.addTestSuite(WeighInTest.class);
		suite.addTestSuite(SwineTest.class);
		suite.addTestSuite(EquineTest.class);
		suite.addTestSuite(CaprineTest.class);
		suite.addTestSuite(MedicalConditionTest.class);
		suite.addTestSuite(MedicalTreatmentTest.class);
		suite.addTestSuite(BirthingTest.class);
		suite.addTestSuite(CalvingTest.class);
		suite.addTestSuite(BirthDefectTest.class);
		suite.addTestSuite(MastitisTest.class);
		suite.addTestSuite(MilkTestTest.class);
		suite.addTestSuite(HerdTestTest.class);
		suite.addTestSuite(GenericEventTest.class);
		suite.addTestSuite(USBeefGradingTest.class);
		suite.addTestSuite(USOvineGradingTest.class);
		suite.addTestSuite(USSwineGradingTest.class);
		suite.addTestSuite(PolicyTest.class);
		suite.addTestSuite(PositionTest.class);
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
