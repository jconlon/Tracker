/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.tests;

import junit.textui.TestRunner;

import com.verticon.google.kmlgx.KmlgxFactory;
import com.verticon.google.kmlgx.SoundCue;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sound Cue</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SoundCueTest extends TourPrimitiveTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SoundCueTest.class);
	}

	/**
	 * Constructs a new Sound Cue test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoundCueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sound Cue test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SoundCue getFixture() {
		return (SoundCue)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KmlgxFactory.eINSTANCE.createSoundCue());
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

} //SoundCueTest
