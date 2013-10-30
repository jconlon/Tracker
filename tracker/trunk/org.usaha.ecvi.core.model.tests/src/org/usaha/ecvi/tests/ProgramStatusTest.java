/**
 */
package org.usaha.ecvi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.usaha.ecvi.EcviFactory;
import org.usaha.ecvi.ProgramStatus;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Program Status</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProgramStatusTest extends TestCase {

	/**
	 * The fixture for this Program Status test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramStatus fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ProgramStatusTest.class);
	}

	/**
	 * Constructs a new Program Status test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramStatusTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Program Status test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ProgramStatus fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Program Status test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramStatus getFixture() {
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
		setFixture(EcviFactory.eINSTANCE.createProgramStatus());
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

} //ProgramStatusTest
