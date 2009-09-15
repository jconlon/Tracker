package com.verticon.tracker.ocl.query.viewer;

import junit.framework.Test;
import junit.framework.TestSuite;

public class QueryViewerAllPlugInTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.verticon.tracker.ocl.query.viewer");
		//$JUnit-BEGIN$
		suite.addTestSuite(OclQueryTest.class);
		//$JUnit-END$
		return suite;
	}

}
