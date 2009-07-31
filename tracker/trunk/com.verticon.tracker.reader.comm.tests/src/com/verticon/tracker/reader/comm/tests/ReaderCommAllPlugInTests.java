package com.verticon.tracker.reader.comm.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ReaderCommAllPlugInTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tracker Reader Comm Plug-In Tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(ConnectorServiceTest.class);
		suite.addTestSuite(SerialPortReaderTest.class);
		//$JUnit-END$
		return suite;
	}

}
