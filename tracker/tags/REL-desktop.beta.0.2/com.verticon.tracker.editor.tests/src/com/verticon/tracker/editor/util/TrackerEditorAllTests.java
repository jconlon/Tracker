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
