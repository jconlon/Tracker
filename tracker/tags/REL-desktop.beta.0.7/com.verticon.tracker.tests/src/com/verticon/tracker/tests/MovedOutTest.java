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

import com.verticon.tracker.MovedOut;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Moved Out</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MovedOutTest extends EventTest {
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
		TestRunner.run(MovedOutTest.class);
	}

	/**
	 * Constructs a new Moved Out test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovedOutTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Moved Out test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MovedOut getFixture() {
		return (MovedOut)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createMovedOut());
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

	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(MovedOut.EVENT_CODE, getFixture().getEventCode());
	}
	
	/**
	 * Tests the '{@link com.verticon.tracker.MovedOut#setUri(String) <em>setURI</em>}' operation.
	 * Anything not value 
	 * @see com.verticon.tracker.MovedOut#setUri(String)
	 * @see com.verticon.tracker.MovedOut#getUri()
	 * @generated NOT
	 */
	public void testSetGetURI(){
		getFixture().setUri("test");
		assertEquals("test", getFixture().getUri());
	}

} //MovedOutTest
