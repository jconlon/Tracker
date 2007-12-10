/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link com.verticon.tracker.Premises#findAnimal(java.lang.String) <em>Find Animal</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#addTemplate(org.eclipse.emf.common.util.EList, com.verticon.tracker.Animal) <em>Add Template</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PremisesTest extends TestCase {
	
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
	public void testEventHistory() {
		assertNotNull(getFixture().eventHistory());
		assertNotNull(getFixture().eventHistory().isEmpty());

		//Add one animal with two tags
		Animal animal1 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag1 = TrackerFactory.eINSTANCE.createTag();
		tag1.setId(AIN_1);
		animal1.getTags().add(tag1);
		Event event1 = TrackerFactory.eINSTANCE.createTagApplied();
		tag1.getEvents().add(event1);
		getFixture().getAnimals().add(animal1);
		assertEquals(1, getFixture().eventHistory().size());
		assertTrue(getFixture().eventHistory().contains(event1));
		
		Tag tag2 = TrackerFactory.eINSTANCE.createTag();
		animal1.getTags().add(tag2);
		tag2.setId(AIN_2);
		
		Event event2 = TrackerFactory.eINSTANCE.createReplacedTag();
		tag2.getEvents().add(event2);
		
		assertEquals(2, getFixture().eventHistory().size());
		assertTrue(getFixture().eventHistory().contains(event2));
		
		
		//Add second animal with two tags
		Animal animal2 = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag3 = TrackerFactory.eINSTANCE.createTag();
		tag3.setId(AIN_1);
		animal2.getTags().add(tag3);
		Event event3 = TrackerFactory.eINSTANCE.createTagApplied();
		tag3.getEvents().add(event3);
		getFixture().getAnimals().add(animal2);
		assertEquals(3, getFixture().eventHistory().size());
		assertTrue(getFixture().eventHistory().contains(event3));
		
		
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Premises#findAnimal(java.lang.String) <em>Find Animal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Premises#findAnimal(long)
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

	public void testGetPremises() {
		assertNotNull(getFixture());
		assertTrue( getFixture().getAnimals().isEmpty());
		
	}
	

} //PremisesTest
