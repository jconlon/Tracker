/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import com.verticon.tracker.MovedIn;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Moved In</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.MovedIn#getSourceName() <em>Source Name</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.MovedIn#findSourceName() <em>Find Source Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class MovedInTest extends EventTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MovedInTest.class);
	}

	/**
	 * Constructs a new Moved In test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovedInTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Moved In test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MovedIn getFixture() {
		return (MovedIn)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createMovedIn());
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
	 * Tests the '{@link com.verticon.tracker.MovedIn#getSourceName() <em>Source Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.MovedIn#getSourceName()
	 * @generated
	 */
	public void testGetSourceName() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.tracker.MovedIn#findSourceName() <em>Find Source Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.MovedIn#findSourceName()
	 * @generated
	 */
	public void testFindSourceName() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(MovedIn.EVENT_CODE, getFixture().getEventCode());
	}
	
	/**
	 * Tests the '{@link com.verticon.tracker.MovedIn#setUri(String) <em>setURI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.MovedIn#setUri(String)
	 * @see com.verticon.tracker.MovedIn#getUri()
	 * @generated NOT
	 */
	public void testSetGetURI(){
		getFixture().setUri("test");
		assertEquals("test", getFixture().getUri());
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.tests.EventTest#testValues()
	 */
	@Override
	public void testValues() {
		assertEquals("sourcePin: null, uri: null", getFixture().values());
	}
	
	
} //MovedInTest
