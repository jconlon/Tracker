/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.agriculture.tests;

import static com.verticon.agriculture.tests.Utils.createXMIResource;
import static com.verticon.agriculture.tests.Utils.getResoureSet;
import static com.verticon.agriculture.tests.Utils.isValidObject;

import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry.Internal;

import com.verticon.agriculture.AgricultureFactory;
import com.verticon.agriculture.Location;
import com.verticon.opengis.kml.Document;
import com.verticon.opengis.kml.Folder;
import com.verticon.opengis.kml.KmlFactory;
import com.verticon.opengis.kml.KmlPackage;
import com.verticon.opengis.kml.Placemark;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.agriculture.Location#getUri() <em>Uri</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class LocationTest extends TestCase {

	private static final String MYURI = "myuri";
	/**
	 * The fixture for this Location test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Location fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LocationTest.class);
	}

	/**
	 * Constructs a new Location test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Location test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Location fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Location test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Location getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AgricultureFactory.eINSTANCE.createLocation());
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
	 * Tests the '{@link com.verticon.agriculture.Location#getUri() <em>Uri</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.agriculture.Location#getUri()
	 * @generated NOT
	 */
	public void testGetUri() {
		
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri(MYURI);
		getFixture().setLivestock(premises);
		assertNotNull((getFixture().getUri()));
		assertEquals(MYURI, getFixture().getUri());
	}
	
	/**
	 * Test options for Timestamps p638 model book
	 * @throws IOException
	 */
	public void testPersistLocation() throws IOException{
		ResourceSet resourceSet = getResoureSet();
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri(MYURI);
		getFixture().setLivestock(premises);
//		getFixture().setId("test");
		
		Resource resource = createXMIResource("test.premises",resourceSet);
		resource.getContents().add(premises);
		resource.save(null);
		
		
	    resource = createXMIResource("test.agri",resourceSet);
		resource.getContents().add(getFixture());
		resource.save(null);
	
	}
	
	public void testValidation(){
		assertFalse(isValidObject(getFixture()));
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		getFixture().setLivestock(premises);
		assertFalse(isValidObject(getFixture()));
		premises.setUri("test");
//		getFixture().setId("test");
		assertFalse(isValidObject(getFixture()));//Still needs geography
		
		//Create a KML Document
		Document document = KmlFactory.eINSTANCE.createDocument();
		document.setDescription("Doc level");
		getFixture().setGeography(document);
		assertFalse(isValidObject(getFixture()));//Still needs placemark
		
		
		//Add a Folder to the Document
		Folder folder = KmlFactory.eINSTANCE.createFolder();
		folder.setName("MyFolder");
		folder.setDescription("The first folder");
		EStructuralFeature f = KmlPackage.eINSTANCE.getDocumentRoot_Folder();
	    document.getAbstractFeatureGroupGroup().add(f,folder);
				
		//Add a Placemark to the folder
		Placemark placemark =  KmlFactory.eINSTANCE.createPlacemark();
		placemark.setName("MyPlacemark");
		placemark.setId("12345");
		f = KmlPackage.eINSTANCE.getDocumentRoot_Placemark();
		folder.getAbstractFeatureGroupGroup().add(f,placemark);
		
		
		getFixture().setPlace(placemark);
		assertTrue(isValidObject(getFixture()));//Still needs placemark
		
//		//Change the id of the location
//		getFixture().setId("ggg://###");
//		assertFalse(isValidObject(getFixture()));//Bad id
//		//Fix it
//		getFixture().setId("ggg:");
//		assertTrue(isValidObject(getFixture()));
		
	}
	
	
	
	 
	
	


} //LocationTest
