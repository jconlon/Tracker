/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.TagApplied;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Tag Applied</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TagAppliedTest extends EventTest {
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
		TestRunner.run(TagAppliedTest.class);
	}

	/**
	 * Constructs a new Tag Applied test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagAppliedTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Tag Applied test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TagApplied getFixture() {
		return (TagApplied)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createTagApplied());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(TagApplied.EVENT_CODE, getFixture().getEventCode());
	}

} //TagAppliedTest
