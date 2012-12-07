/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>kmlgx</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class KmlgxTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new KmlgxTests("kmlgx Tests");
		suite.addTestSuite(AnimatedUpdateTest.class);
		suite.addTestSuite(DocumentRootTest.class);
		suite.addTestSuite(FlyToTest.class);
		suite.addTestSuite(LatLonQuadTest.class);
		suite.addTestSuite(MultiTrackTest.class);
		suite.addTestSuite(PlaylistTest.class);
		suite.addTestSuite(SimpleArrayDataTest.class);
		suite.addTestSuite(SimpleArrayFieldTest.class);
		suite.addTestSuite(SoundCueTest.class);
		suite.addTestSuite(TourTest.class);
		suite.addTestSuite(TourControlTest.class);
		suite.addTestSuite(TourPrimitiveTest.class);
		suite.addTestSuite(TrackTest.class);
		suite.addTestSuite(ViewerOptionsTest.class);
		suite.addTestSuite(WaitTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KmlgxTests(String name) {
		super(name);
	}

} //KmlgxTests
