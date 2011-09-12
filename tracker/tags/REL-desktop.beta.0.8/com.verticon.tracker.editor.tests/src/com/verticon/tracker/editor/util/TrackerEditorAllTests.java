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
package com.verticon.tracker.editor.util;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TrackerEditorAllTests extends TestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tracker Editor Tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(AnimalTemplateBeanTest.class);
		//$JUnit-END$
		return suite;
	}

}
