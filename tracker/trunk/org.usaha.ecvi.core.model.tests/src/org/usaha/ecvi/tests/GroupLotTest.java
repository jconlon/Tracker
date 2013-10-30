/**
 */
package org.usaha.ecvi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.usaha.ecvi.EcviFactory;
import org.usaha.ecvi.GroupLot;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Group Lot</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GroupLotTest extends TestCase {

	/**
	 * The fixture for this Group Lot test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupLot fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GroupLotTest.class);
	}

	/**
	 * Constructs a new Group Lot test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupLotTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Group Lot test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(GroupLot fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Group Lot test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupLot getFixture() {
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
		setFixture(EcviFactory.eINSTANCE.createGroupLot());
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

} //GroupLotTest
