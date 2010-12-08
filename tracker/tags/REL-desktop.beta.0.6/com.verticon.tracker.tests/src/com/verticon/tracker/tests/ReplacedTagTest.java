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

import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Replaced Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.ReplacedTag#getOldId() <em>Old Id</em>}</li>
 *   <li>{@link com.verticon.tracker.ReplacedTag#isUsainNumberUsedForOldId() <em>Usain Number Used For Old Id</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ReplacedTagTest extends EventTest {
	private static final String _123456789012345 = "123456789012345";
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
		TestRunner.run(ReplacedTagTest.class);
	}

	/**
	 * Constructs a new Replaced Tag test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacedTagTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Replaced Tag test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ReplacedTag getFixture() {
		return (ReplacedTag)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createReplacedTag());
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
	 * Tests the '{@link com.verticon.tracker.ReplacedTag#getOldId() <em>Old Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.ReplacedTag#getOldId()
	 * @generated NOT
	 */
	public void testGetOldId() {
		ReplacedTag replacedTagEvent = getFixture();
		assertNotNull(replacedTagEvent);
		assertEquals("", replacedTagEvent.getId());
		
		assertEquals("", replacedTagEvent.getOldId());
		
		//Create an old tag
		Tag oldTagToReplace = TrackerFactory.eINSTANCE.createTag();
		oldTagToReplace.setId(_123456789012345);
		
		replacedTagEvent.setOldTag(oldTagToReplace);
		assertEquals(_123456789012345, replacedTagEvent.getOldId());
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.ReplacedTag#isUsainNumberUsedForOldId() <em>Usain Number Used For Old Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.ReplacedTag#isUsainNumberUsedForOldId()
	 * @generated NOT
	 */
	public void testIsUsainNumberUsedForOldId() {
		ReplacedTag replacedTagEvent = getFixture();
		assertNotNull(replacedTagEvent);
		assertEquals("", replacedTagEvent.getId());
		
		//Create an old tag
		Tag oldTagToReplace = TrackerFactory.eINSTANCE.createTag();
		oldTagToReplace.setId(_123456789012345);
		
		replacedTagEvent.setOldTag(oldTagToReplace);
		assertFalse(replacedTagEvent.isUsainNumberUsedForOldId());
		oldTagToReplace.setId("840456789012345");
		assertTrue(replacedTagEvent.isUsainNumberUsedForOldId());
		
		//idNumber>840200000000000L && idNumber<843000000000000L
		oldTagToReplace.setId("840003001374447");
		assertTrue(replacedTagEvent.isUsainNumberUsedForOldId());
		
		oldTagToReplace.setId("840003001374300");
		assertTrue(replacedTagEvent.isUsainNumberUsedForOldId());
	}

	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(6, getFixture().getEventCode());
	}

} //ReplacedTagTest
