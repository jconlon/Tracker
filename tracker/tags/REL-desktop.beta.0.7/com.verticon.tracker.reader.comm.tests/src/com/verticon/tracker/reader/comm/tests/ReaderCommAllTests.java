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
package com.verticon.tracker.reader.comm.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ReaderCommAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tracker Reader Comm Tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(ConnectionFactoryImplTest.class);
		suite.addTestSuite(SerialPortParmsBeanTest.class);
		//$JUnit-END$
		return suite;
	}

}
