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
