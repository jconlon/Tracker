/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.opengis.kml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>kml</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class KmlTests extends TestSuite {

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
		TestSuite suite = new KmlTests("kml Tests");
		suite.addTestSuite(AliasTest.class);
		suite.addTestSuite(BalloonStyleTest.class);
		suite.addTestSuite(BasicLinkTest.class);
		suite.addTestSuite(BoundaryTest.class);
		suite.addTestSuite(CameraTest.class);
		suite.addTestSuite(ChangeTest.class);
		suite.addTestSuite(CreateTest.class);
		suite.addTestSuite(DataTest.class);
		suite.addTestSuite(DeleteTest.class);
		suite.addTestSuite(DocumentTest.class);
		suite.addTestSuite(DocumentRootTest.class);
		suite.addTestSuite(FolderTest.class);
		suite.addTestSuite(GroundOverlayTest.class);
		suite.addTestSuite(IconStyleTest.class);
		suite.addTestSuite(ImagePyramidTest.class);
		suite.addTestSuite(ItemIconTest.class);
		suite.addTestSuite(KmlTest.class);
		suite.addTestSuite(LabelStyleTest.class);
		suite.addTestSuite(LatLonAltBoxTest.class);
		suite.addTestSuite(LatLonBoxTest.class);
		suite.addTestSuite(LinearRingTest.class);
		suite.addTestSuite(LineStringTest.class);
		suite.addTestSuite(LineStyleTest.class);
		suite.addTestSuite(LinkTest.class);
		suite.addTestSuite(ListStyleTest.class);
		suite.addTestSuite(LocationTest.class);
		suite.addTestSuite(LodTest.class);
		suite.addTestSuite(LookAtTest.class);
		suite.addTestSuite(ModelTest.class);
		suite.addTestSuite(MultiGeometryTest.class);
		suite.addTestSuite(NetworkLinkTest.class);
		suite.addTestSuite(NetworkLinkControlTest.class);
		suite.addTestSuite(OrientationTest.class);
		suite.addTestSuite(PairTest.class);
		suite.addTestSuite(PhotoOverlayTest.class);
		suite.addTestSuite(PlacemarkTest.class);
		suite.addTestSuite(PointTest.class);
		suite.addTestSuite(PolygonTest.class);
		suite.addTestSuite(PolyStyleTest.class);
		suite.addTestSuite(RegionTest.class);
		suite.addTestSuite(ResourceMapTest.class);
		suite.addTestSuite(ScaleTest.class);
		suite.addTestSuite(SchemaTest.class);
		suite.addTestSuite(SchemaDataTest.class);
		suite.addTestSuite(ScreenOverlayTest.class);
		suite.addTestSuite(SimpleFieldTest.class);
		suite.addTestSuite(StyleTest.class);
		suite.addTestSuite(StyleMapTest.class);
		suite.addTestSuite(TimeSpanTest.class);
		suite.addTestSuite(TimeStampTest.class);
		suite.addTestSuite(UpdateTest.class);
		suite.addTestSuite(ViewVolumeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KmlTests(String name) {
		super(name);
	}

} //KmlTests
