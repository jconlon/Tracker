/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.osgi.metatype.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.MetatypeFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Designate</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DesignateTest extends TestCase {

	/**
	 * The fixture for this Designate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Designate fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DesignateTest.class);
	}

	/**
	 * Constructs a new Designate test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesignateTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Designate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Designate fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Designate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Designate getFixture() {
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
		setFixture(MetatypeFactory.eINSTANCE.createDesignate());
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
	
	public void testEquality() {
		Designate desCopy1 = (Designate) EcoreUtil.copy(getFixture());
		assertTrue(EcoreUtil.equals(getFixture(), desCopy1));
		desCopy1.setPid("xxx");
		assertFalse(EcoreUtil.equals(getFixture(), desCopy1));
		getFixture().setPid("xxx");
		assertTrue(EcoreUtil.equals(getFixture(), desCopy1));
		
		com.verticon.osgi.metatype.Object o = MetatypeFactory.eINSTANCE.createObject();
		getFixture().setObject(o);
		assertFalse(EcoreUtil.equals(getFixture(), desCopy1));
		
		desCopy1 = (Designate) EcoreUtil.copy(getFixture());
		assertTrue(EcoreUtil.equals(getFixture(), desCopy1));
		
		getFixture().getObject().setOcdref("xxyy");
		assertFalse(EcoreUtil.equals(getFixture(), desCopy1));
		
		
	}

} //DesignateTest
