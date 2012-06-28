/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.agriculture.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.agriculture.AgricultureFactory;
import com.verticon.agriculture.Association;

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

} //AssociationTest
