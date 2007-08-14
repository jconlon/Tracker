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
		assertEquals(0, tag.getIdNumber());
		tag.setIdNumber(123456789012345L);
		assertFalse(tag.isUsainNumberUsed());
		tag.setIdNumber(840456789012345L);
		assertTrue(tag.isUsainNumberUsed());
	}

} //TagTest
