/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.agriculture.tests;


import static com.verticon.agriculture.tests.Utils.getResoureSet;
import static com.verticon.agriculture.tests.Utils.getXMIResource;
import static com.verticon.agriculture.tests.Utils.isValidObject;
import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.verticon.agriculture.Agriculture;
import com.verticon.agriculture.AgricultureFactory;
import com.verticon.agriculture.Location;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Agriculture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.agriculture.Agriculture#getName() <em>Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class AgricultureTest extends TestCase {

	/**
	 * The fixture for this Agriculture test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Agriculture fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AgricultureTest.class);
	}

	/**
	 * Constructs a new Agriculture test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgricultureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Agriculture test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Agriculture fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Agriculture test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Agriculture getFixture() {
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
		setFixture(AgricultureFactory.eINSTANCE.createAgriculture());
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
	 * Tests the '{@link com.verticon.agriculture.Agriculture#getAssociation() <em>Assocation</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.agriculture.Agriculture#getAssociation()
	 * @generated NOT
	 */
	public void testGetAssociation() {
		getFixture().setAssociation("test");
		assertEquals("test", getFixture().getAssociation());
	}
	
	/**
	 * 
	 */
	public void testValidation(){
		ResourceSet resourceSet = getResoureSet();
		Resource resource = getXMIResource( "doc.agri",  resourceSet);
		assertNotNull(resource);
		assertEquals(resource.getContents().size(),1);
		Agriculture agri = (Agriculture)resource.getContents().get(0);
		Location location = agri.getLocation().get(0);
		assertNotNull(location);
		assertNotNull(location.getLivestock());
		assertNotNull(location.getGeography());
		assertFalse(isValidObject(agri));
		location.setId("test");
		assertTrue(isValidObject(agri));
		
	}

} //AgricultureTest
