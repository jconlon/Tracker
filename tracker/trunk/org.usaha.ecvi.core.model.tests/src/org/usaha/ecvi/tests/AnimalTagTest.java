/**
 */
package org.usaha.ecvi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.usaha.ecvi.AnimalTag;
import org.usaha.ecvi.EcviFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Animal Tag</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimalTagTest extends TestCase {

	/**
	 * The fixture for this Animal Tag test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalTag fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AnimalTagTest.class);
	}

	/**
	 * Constructs a new Animal Tag test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalTagTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Animal Tag test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AnimalTag fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Animal Tag test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalTag getFixture() {
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
		setFixture(EcviFactory.eINSTANCE.createAnimalTag());
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

} //AnimalTagTest
