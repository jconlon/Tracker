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

import com.verticon.tracker.EventType;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Tag#isUsainNumberUsed() <em>Usain Number Used</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Tag#canContain(com.verticon.tracker.EventType, java.lang.String) <em>Can Contain</em>}</li>
 *   <li>{@link com.verticon.tracker.Tag#findOCD(java.lang.String) <em>Find OCD</em>}</li>
 *   <li>{@link com.verticon.tracker.Tag#findOCDs() <em>Find OC Ds</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TagTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Tag test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Tag fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TagTest.class);
	}

	/**
	 * Constructs a new Tag test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Tag test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Tag fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Tag test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Tag getFixture() {
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
		setFixture(TrackerFactory.eINSTANCE.createTag());
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
	 * Tests the '{@link com.verticon.tracker.Tag#isUsainNumberUsed() <em>Usain Number Used</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Tag#isUsainNumberUsed()
	 * @generated NOT
	 */
	public void testIsUsainNumberUsed() {
		Tag tag = getFixture();
		assertNotNull(tag);
		assertEquals("", tag.getId());
		tag.setId("123456789012345");
		assertFalse(tag.isUsainNumberUsed());
		tag.setId("840456789012345");
		assertTrue(tag.isUsainNumberUsed());
		
		//idNumber>840200000000000L && idNumber<843000000000000L
		tag.setId("840003001374447");
		assertTrue(tag.isUsainNumberUsed());
		
		tag.setId("840003001374300");
		assertTrue(tag.isUsainNumberUsed());
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Tag#canContain(com.verticon.tracker.EventType, java.lang.String) <em>Can Contain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Tag#canContain(com.verticon.tracker.EventType, java.lang.String)
	 * @generated NOT
	 */
	public void testCanContain__EventType_String() {
		assertTrue(getFixture().canContain(EventType.ANIMAL_MISSING, null));
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Tag#findOCD(java.lang.String) <em>Find OCD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Tag#findOCD(java.lang.String)
	 * @generated NOT
	 */
	public void testFindOCD__String() {
		assertNull(getFixture().findOCD("nothing"));
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Tag#findOCDs() <em>Find OCDs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Tag#findOCDs()
	 * @generated NOT
	 */
	public void testFindOCDs() {
		assertNotNull(getFixture().findOCDs());
		assertTrue(getFixture().findOCDs().isEmpty());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Tag#getId() <em>Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * Overridden by subclasses
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Tag#getId()
	 * @generated NOT
	 */
	public void testGetId() {
		Tag tag = getFixture();
		assertNotNull(tag);
		tag.setId("123456789012345");
		assertEquals("Test with no tag", "123456789012345", tag.getId());
		
		tag.setId("840456789012345");
		assertEquals("Test with no tag", "840456789012345", tag.getId());
	}
	
	public void testIdentity() {
		assertNotNull("Tag must have an identitiy attribute", getFixture().eClass().getEIDAttribute());
		assertTrue("Tag id must be an identitiy attribute", getFixture().eClass().getEIDAttribute().getName().equals("id"));
	}

} //TagTest
