/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.tests;

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

} //TagTest
