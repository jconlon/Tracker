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
import static com.verticon.tracker.tests.Constants.bundleMarker;

import java.util.Collection;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Premises</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Premises#eventHistory() <em>Event History</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#findAnimal(java.lang.String) <em>Find Animal</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#addTemplate(org.eclipse.emf.common.util.EList, com.verticon.tracker.Animal) <em>Add Template</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#canContain(com.verticon.tracker.EventType, java.lang.String, com.verticon.tracker.AnimalType) <em>Can Contain</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PremisesTest extends TestCase {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(PremisesTest.class);
	
	private static final String AIN_4 = "123456789012344";
	private static final String AIN_3 = "123456789012343";
	private static final String AIN_2 = "123456789012342";
	private static final String AIN_1 = "123456789012341";
	
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
	public void testEventHistoryEmpty() {
		assertNotNull(getFixture().eventHistory());
		assertNotNull(getFixture().eventHistory().isEmpty());
	}


	/**
	 * Tests the '{@link com.verticon.tracker.Premises#eventHistory() <em>Event History</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Premises#eventHistory()
	 * @generated NOT
	 */
	public void testEventHistory() {
		logger.info(bundleMarker, "Setting up an anima1l with tag1 and event1");
		//Add one animal with two tags
		Animal animal1 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.setId(AIN_1);
		animal1.getTags().add(tag1);
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		tag1.getEvents().add(event1);
		logger.info(bundleMarker,"Adding the animal with one tag and one event");
		getFixture().getAnimals().add(animal1);
		assertEquals("EventHistory should have one event (animal1=tag1=1)", 1, getFixture().eventHistory().size());
		assertTrue("EventHistory should contain event1", getFixture().eventHistory().contains(event1));
		
		// Experiment with ItemPropertyDescriptor
		Collection<EObject> col = ItemPropertyDescriptor
				.getReachableObjectsOfType(getFixture(),
						TrackerPackage.Literals.EVENT);
		assertEquals("Col should have one event (animal1=tag1=1)", 1, col
				.size());
		assertTrue("Col should contain event1", col.contains(event1));
		
		
		logger.info(bundleMarker,"Adding a tag2 to animal1 with tag2 and event2");
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		animal1.getTags().add(tag2);
		tag2.setId(AIN_2);
		Event event2 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag2.getEvents().add(event2);
		
		assertEquals("EventHistory should have two events (animal1=tag1=1)+(animal1=tag2=1)=2",2, getFixture().eventHistory().size());
		assertTrue("EventHistory should contain event2", getFixture().eventHistory().contains(event2));
		
		
		//Add second animal with two tags
		logger.info(bundleMarker,"Setting up a animal2 with tag3 and event 3");
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag3 = TrackerFactory.eINSTANCE.createTag();
		tag3.setId(AIN_1);
		animal2.getTags().add(tag3);
		Event event3 = TrackerFactory.eINSTANCE.createTagApplied();
		tag3.getEvents().add(event3);
		logger.info(bundleMarker,"Add animal2 with tag3 and event 3");
		getFixture().getAnimals().add(animal2);
		
		assertEquals("EventHistory should have three events (animal1=tag1=1)+(animal1=tag2=1)=2",
				3, getFixture().eventHistory().size());
		assertTrue("EventHistory should contain event3", getFixture().eventHistory().contains(event3));
		
		
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Premises#findAnimal(java.lang.String) <em>Find Animal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Premises#findAnimal(String)
	 * @generated NOT
	 */
	public void testFindAnimal__String() {
		Animal animal1 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.setId(AIN_1);
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		tag1.getEvents().add(event1);
		animal1.getTags().add(tag1);
		getFixture().getAnimals().add(animal1);
		assertEquals(AIN_1, animal1.getId());
		
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		tag2.setId(AIN_2);
		Event event2 = TrackerFactory.eINSTANCE.createTagApplied();
		tag2.getEvents().add(event2);
		animal2.getTags().add(tag2);
		getFixture().getAnimals().add(animal2);
		
		Animal animal3 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag3 = TrackerFactory.eINSTANCE.createTag();
		tag3.setId(AIN_3);
		Event event3 = TrackerFactory.eINSTANCE.createTagApplied();
		tag3.getEvents().add(event3);
		animal3.getTags().add(tag3);
		getFixture().getAnimals().add(animal3);
		
		assertEquals(animal1, getFixture().findAnimal(AIN_1));
		assertEquals(animal2, getFixture().findAnimal(AIN_2));
		assertEquals(animal3, getFixture().findAnimal(AIN_3));
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Premises#addTemplate(org.eclipse.emf.common.util.EList, com.verticon.tracker.Animal) <em>Add Template</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Premises#addTemplate(org.eclipse.emf.common.util.EList, com.verticon.tracker.Animal)
	 * @generated NOT
	 */
	public void testAddTemplate__EList_Animal() {
		Animal animal1 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.setId(AIN_1);
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		tag1.getEvents().add(event1);
		animal1.getTags().add(tag1);
		
		
		EList<String> ains = new BasicEList<String>();
		ains.add(AIN_1);
		ains.add(AIN_2);
		ains.add(AIN_3);
		ains.add(AIN_4);
		
		assertEquals(0, getFixture().eventHistory().size());
		
		getFixture().addTemplate(ains, animal1);
		assertEquals(4, getFixture().getAnimals().size());
		assertEquals(4, getFixture().eventHistory().size());
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Premises#canContain(com.verticon.tracker.EventType, java.lang.String, com.verticon.tracker.AnimalType) <em>Can Contain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Premises#canContain(com.verticon.tracker.EventType, java.lang.String, com.verticon.tracker.AnimalType)
	 * @generated NOT
	 */
	public void testCanContain__EventType_String_AnimalType() {
		assertNotNull(getFixture());
		assertTrue(getFixture().canContain(EventType.ANIMAL_MISSING, null, AnimalType.BOVINE_BEEF));
		
	}

	public void testGetPremises() {
		assertNotNull(getFixture());
		assertTrue( getFixture().getAnimals().isEmpty());
		
	}
	

} //PremisesTest
