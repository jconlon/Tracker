/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store.mongodb.test.system;

import java.util.concurrent.TimeUnit;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTests extends TestSuite {

	public static final String copyright = "Copyright 2013 Verticon, Inc. All Rights Reserved.";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		Metrics.reporter.start(1, TimeUnit.SECONDS);
		TestRunner.run(suite());
		Metrics.reporter.stop();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new AllTests("TrackerStore Mongodb System Tests");
		suite.addTestSuite(Test_TrackerStore_Authorization.class);
		suite.addTestSuite(Test_TrackerUpdateAndFind.class);

		suite.addTestSuite(Test_TrackerStore.class);
		suite.addTestSuite(Test_TrackerStore_Updates.class);
		suite.addTestSuite(Test_MongoDB_Consumer.class);
		suite.addTestSuite(WaitTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AllTests(String name) {
		super(name);
	}

} // TrackerTests
