/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event Attribute</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventAttributeTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Event Attribute test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, String> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EventAttributeTest.class);
	}

	/**
	 * Constructs a new Event Attribute test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventAttributeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Event Attribute test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<String, String> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Event Attribute test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, String> getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setUp() throws Exception {
		setFixture((Map.Entry<String, String>)TrackerFactory.eINSTANCE.create(TrackerPackage.Literals.EVENT_ATTRIBUTE));
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
	
	public void testInstance() {
		assertNotNull(fixture);
	}

} //EventAttributeTest
