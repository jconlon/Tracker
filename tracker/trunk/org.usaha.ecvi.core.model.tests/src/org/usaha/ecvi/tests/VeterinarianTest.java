/**
 */
package org.usaha.ecvi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.usaha.ecvi.EcviFactory;
import org.usaha.ecvi.Veterinarian;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Veterinarian</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VeterinarianTest extends TestCase {

	/**
	 * The fixture for this Veterinarian test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Veterinarian fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VeterinarianTest.class);
	}

	/**
	 * Constructs a new Veterinarian test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VeterinarianTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Veterinarian test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Veterinarian fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Veterinarian test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Veterinarian getFixture() {
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
		setFixture(EcviFactory.eINSTANCE.createVeterinarian());
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

} //VeterinarianTest
