package com.verticon.tracker.alltests;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.verticon.tracker.ocl.query.viewer.QueryViewerAllPlugInTests;
import com.verticon.tracker.reader.comm.tests.ReaderCommAllPlugInTests;

public class AllPlugInTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tracker ALL Non Plugin Tests");
		//$JUnit-BEGIN$
		suite.addTest(ReaderCommAllPlugInTests.suite());
		suite.addTest(QueryViewerAllPlugInTests.suite());
		//$JUnit-END$
		return suite;
	}

}
