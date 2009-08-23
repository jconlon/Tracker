package com.verticon.tracker.ocl.query.viewer;

import junit.framework.Test;
import junit.framework.TestSuite;

public class QueryViewerAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tracker QueryViewer Tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(OCLViewerFilterTest.class);
		//$JUnit-END$
		return suite;
	}

}
