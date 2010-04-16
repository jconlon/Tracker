/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.osgi.metatype.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.OCD;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.osgi.metatype.MetaData#getLocales() <em>Get Locales</em>}</li>
 *   <li>{@link com.verticon.osgi.metatype.MetaData#getObjectClassDefinition(java.lang.String, java.lang.String) <em>Get Object Class Definition</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class MetaDataTest extends TestCase {

	/**
	 * The fixture for this Meta Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaData fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MetaDataTest.class);
	}

	/**
	 * Constructs a new Meta Data test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaDataTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Meta Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MetaData fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Meta Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaData getFixture() {
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
		setFixture(MetatypeFactory.eINSTANCE.createMetaData());
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
	 * Tests the '{@link com.verticon.osgi.metatype.MetaData#getLocales() <em>Get Locales</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.osgi.metatype.MetaData#getLocales()
	 * @generated NOT
	 */
	public void testGetLocales() {
		assertNull(fixture.getLocales());
	}

	/**
	 * Tests the '{@link com.verticon.osgi.metatype.MetaData#getObjectClassDefinition(java.lang.String, java.lang.String) <em>Get Object Class Definition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.osgi.metatype.MetaData#getObjectClassDefinition(java.lang.String, java.lang.String)
	 * @generated NOT
	 */
	public void testGetObjectClassDefinition__String_String() {
		assertNull(fixture.getObjectClassDefinition("test", null));
		
		OCD ocd1 = MetatypeFactory.eINSTANCE.createOCD();
		ocd1.setID("one");
		fixture.getOCD().add(ocd1);
		assertNull(fixture.getObjectClassDefinition("test", null));
		assertNotNull(fixture.getObjectClassDefinition("one", null));
		
		
	}

} //MetaDataTest
