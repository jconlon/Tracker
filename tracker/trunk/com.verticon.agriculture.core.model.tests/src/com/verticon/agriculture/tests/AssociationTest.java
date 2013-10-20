/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.agriculture.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.verticon.agriculture.AgricultureFactory;
import com.verticon.agriculture.AgriculturePackage;
import com.verticon.agriculture.Association;
import com.verticon.agriculture.util.AgricultureResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssociationTest extends TestCase {

	/**
	 * The fixture for this Association test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Association fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AssociationTest.class);
	}

	/**
	 * Constructs a new Association test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Association test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Association fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Association test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Association getFixture() {
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
		setFixture(AgricultureFactory.eINSTANCE.createAssociation());
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
	
	
	public void testInstance(){
	    assertThat("Association must not be null", getFixture(), is(notNullValue()));
	}

	public void testAgriculturePackageInstantiation() {

		AgriculturePackage agrpac = AgriculturePackage.eINSTANCE;
		assertThat("AgriculturePackage must not be null", agrpac,
				is(notNullValue()));
	}
	public void testAgriculturePackageRegistration() {

		// }
		//
		// private Resource load() {
		// // Read the file
		// // Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();
		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new AgricultureResourceFactoryImpl());
		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(AgriculturePackage.eNS_URI,
				AgriculturePackage.eINSTANCE);

		// URI uri = createURI(getProject());
		// logger.debug(bundleMarker, "{} loading {}", this, uri);
		//
		// return resourceSet.getResource(uri, true);

	}

} //AssociationTest
