/**
 */
package org.usaha.ecvi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.usaha.ecvi.EcviFactory;
import org.usaha.ecvi.MovementPurposes;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Movement Purposes</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MovementPurposesTest extends TestCase {

	/**
	 * The fixture for this Movement Purposes test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovementPurposes fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MovementPurposesTest.class);
	}

	/**
	 * Constructs a new Movement Purposes test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovementPurposesTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Movement Purposes test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MovementPurposes fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Movement Purposes test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovementPurposes getFixture() {
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
		setFixture(EcviFactory.eINSTANCE.createMovementPurposes());
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

} //MovementPurposesTest
