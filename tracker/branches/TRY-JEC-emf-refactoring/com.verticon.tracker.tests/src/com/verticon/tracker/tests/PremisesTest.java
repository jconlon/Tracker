/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Premises</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Premises#eventHistory() <em>Event History</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PremisesTest extends TestCase {
	
	private static final long AIN = 123456789012345L;
	private static final long AIN2 = 123456789012343L;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Premises test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Premises fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PremisesTest.class);
	}

	/**
	 * Constructs a new Premises test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremisesTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Premises test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Premises fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Premises test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Premises getFixture() {
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
		setFixture(TrackerFactory.eINSTANCE.createPremises());
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
	 * Tests the '{@link com.verticon.tracker.Premises#eventHistory() <em>Event History</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Premises#eventHistory()
	 * @generated NOT
	 */
	public void testEventHistory() {
		assertNotNull(getFixture().eventHistory());
		assertNotNull(getFixture().eventHistory().isEmpty());

		//Add one animal with two tags
		Animal animal1 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.setIdNumber(AIN);
		animal1.getTags().add(tag1);
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		tag1.getEvents().add(event1);
		getFixture().getAnimals().add(animal1);
		assertEquals(1, getFixture().eventHistory().size());
		assertTrue(getFixture().eventHistory().contains(event1));
		
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		animal1.getTags().add(tag2);
		tag2.setIdNumber(AIN2);
		
		Event event2 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag2.getEvents().add(event2);
		
		assertEquals(2, getFixture().eventHistory().size());
		assertTrue(getFixture().eventHistory().contains(event2));
		
		
		//Add second animal with two tags
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag3 = TrackerFactory.eINSTANCE.createTag();
		tag3.setIdNumber(AIN);
		animal2.getTags().add(tag3);
		Event event3 = TrackerFactory.eINSTANCE.createTagApplied();
		tag3.getEvents().add(event3);
		getFixture().getAnimals().add(animal2);
		assertEquals(3, getFixture().eventHistory().size());
		assertTrue(getFixture().eventHistory().contains(event3));
		
		
		
	}

	public void testGetPremises() {
		assertNotNull(getFixture());
		assertTrue( getFixture().getAnimals().isEmpty());
		
	}
	

} //PremisesTest
