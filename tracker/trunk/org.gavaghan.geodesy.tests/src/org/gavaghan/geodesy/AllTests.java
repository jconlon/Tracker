package org.gavaghan.geodesy;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.gavaghan.geodesy.internal.EllipsoidAgitarTest;
import org.gavaghan.geodesy.internal.GeodeticCalculatorAgitarTest;
import org.gavaghan.geodesy.internal.GlobalCoordinatesAgitarTest;
import org.gavaghan.geodesy.internal.GlobalPositionAgitarTest;

import com.verticon.tracker.irouter.gps.calculator.internal.GeodeticCalculator2Test;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(GeodeticCalculator2Test.class);
		
		suite.addTestSuite(GeodeticCalculatorAgitarTest.class);
		suite.addTestSuite(EllipsoidAgitarTest.class);
		suite.addTestSuite(GlobalCoordinatesAgitarTest.class);
		suite.addTestSuite(GlobalPositionAgitarTest.class);
		
		suite.addTestSuite(GeodeticMeasurementAgitarTest.class);
		suite.addTestSuite(GeodeticCurveAgitarTest.class);
		//$JUnit-END$
		return suite;
	}

}
