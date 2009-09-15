package com.verticon.tracker.alltests;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.verticon.tracker.editor.util.TrackerEditorAllTests;
import com.verticon.tracker.fair.tests.FairAllTests;
import com.verticon.tracker.ocl.query.viewer.QueryViewerAllTests;
import com.verticon.tracker.reader.comm.tests.ReaderCommAllTests;
import com.verticon.tracker.tests.TrackerReportAllTests;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tracker ALL Non Plugin Tests");
		//$JUnit-BEGIN$
		suite.addTest(TrackerReportAllTests.suite());
		suite.addTest(TrackerEditorAllTests.suite());
		suite.addTest(FairAllTests.suite());
		suite.addTest(QueryViewerAllTests.suite());
		suite.addTest(ReaderCommAllTests.suite());
		//$JUnit-END$
		return suite;
	}

}
