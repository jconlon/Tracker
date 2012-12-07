/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.opengis.kml.tests;

import java.util.ArrayList;
import java.util.List;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import com.verticon.opengis.kml.KmlFactory;
import com.verticon.opengis.kml.KmlPackage;
import com.verticon.opengis.kml.Placemark;
import com.verticon.opengis.kml.Point;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Placemark</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.opengis.kml.Placemark#getAbstractGeometryGroup() <em>Abstract Geometry Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.Placemark#getPlacemarkSimpleExtensionGroup() <em>Placemark Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.Placemark#getPlacemarkObjectExtensionGroup() <em>Placemark Object Extension Group</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PlacemarkTest extends FeatureTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PlacemarkTest.class);
	}

	/**
	 * Constructs a new Placemark test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacemarkTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Placemark test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Placemark getFixture() {
		return (Placemark)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KmlFactory.eINSTANCE.createPlacemark());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.Placemark#getAbstractGeometryGroup() <em>Abstract Geometry Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * Shows how to add a placemark and the effects
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.Placemark#getAbstractGeometryGroup()
	 * @generated NOT
	 */
	public void testGetAbstractGeometryGroup() {
		assertNull(getFixture().getAbstractGeometryGroup());
		
		Placemark placemark = getFixture();
		Object o = placemark.eGet(placemark.eClass().getEStructuralFeature(
				KmlPackage.PLACEMARK__ABSTRACT_GEOMETRY_GROUP_GROUP), true);
		
		//System.out.println("FeatureMap = "+o.toString());
		assertNotNull("There shoula always be a featureMap", o);
		assertTrue(o instanceof FeatureMap);
		FeatureMap fm = (FeatureMap)o;
		
		assertEquals("It will be empty, unless something is added", 0,fm.size());
		EStructuralFeature f = KmlPackage.eINSTANCE
		.getPlacemark_AbstractGeometryGroupGroup();
		//Add a point
		EStructuralFeature documentRootPointFeature = KmlPackage.eINSTANCE.getDocumentRoot_Point();
		Point point = KmlFactory.eINSTANCE.createPoint();
		String coord = "-90.779724, 43.394554";
		List<String> coordinates = new ArrayList<String>();
		coordinates.add(coord);
		point.setCoordinates(coordinates);
		fm.add(f, FeatureMapUtil.createEntry(documentRootPointFeature, point));
		
		//Now the AbstractGeometryGroup 
		Object geo = getFixture().getAbstractGeometryGroup();
		assertNotNull(geo);
		assertEquals(point, geo);
		
	}

	
	/**
	 * Tests the '{@link com.verticon.opengis.kml.Placemark#getPlacemarkSimpleExtensionGroup() <em>Placemark Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.Placemark#getPlacemarkSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetPlacemarkSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.Placemark#getPlacemarkObjectExtensionGroup() <em>Placemark Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.Placemark#getPlacemarkObjectExtensionGroup()
	 * @generated
	 */
	public void testGetPlacemarkObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //PlacemarkTest
