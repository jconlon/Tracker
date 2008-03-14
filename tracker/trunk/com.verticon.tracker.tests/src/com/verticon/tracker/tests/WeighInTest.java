/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import java.util.Calendar;

import junit.textui.TestRunner;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.impl.WeighInImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Weigh In</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.WeighIn#getWeightGainPerDay() <em>Weight Gain Per Day</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class WeighInTest extends EventTest {
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
		TestRunner.run(WeighInTest.class);
	}

	/**
	 * Constructs a new Weigh In test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeighInTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Weigh In test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected WeighIn getFixture() {
		return (WeighIn)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createWeighIn());
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
	 * Tests the '{@link com.verticon.tracker.WeighIn#getWeightGainPerDay() <em>Weight Gain Per Day</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.WeighIn#getWeightGainPerDay()
	 * @generated NOT
	 */
	public void testGetWeightGainPerDay() {
		//Create an animal, a tag and a couple of weighIn Events
		Animal animal = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100);
		tag.getEvents().add(we);
		
		//Second weighIn today 250 lbs
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				secondWeighInDate.getTime());
		we2.setWeight(250);
		tag.getEvents().add(we2);
		
		WeighInImpl weImpl = (WeighInImpl)we;
		assertTrue("First event should not show any other events", 
				weImpl.getPreviousWeighInEvents().isEmpty());
		
		
		assertEquals("First event should show nothing", 0, we.getWeightGainPerDay());
		
		WeighInImpl weImpl2 = (WeighInImpl)we2;
		assertEquals("Second event should have one previous event",1, 
				weImpl2.getPreviousWeighInEvents().size());
		assertEquals("Second event should find only the first event",we, 
				weImpl2.getPreviousWeighInEvents().iterator().next());
		assertEquals("15 lbs per day", 15, we2.getWeightGainPerDay());
		
		
		//Third weighIn today 250 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Third");
		we3.setWeight(350);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we3.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we3);
		
		
		assertTrue("First event should not show any other events", 
				weImpl.getPreviousWeighInEvents().isEmpty());
		assertEquals("First event should show nothing", 0, we.getWeightGainPerDay());
		assertEquals("Second event should have one previous event",1, 
				weImpl2.getPreviousWeighInEvents().size());
		assertEquals("Second event should find only the first event",we, 
				weImpl2.getPreviousWeighInEvents().iterator().next());
		assertEquals("15 lbs per day", 15, we2.getWeightGainPerDay());
		
		
		WeighInImpl weImpl3 = (WeighInImpl)we3;
		assertEquals("Third event should have one previous event",2, 
				weImpl3.getPreviousWeighInEvents().size());
		assertEquals("Third event should find only the second event",we2, 
				weImpl3.getPreviousWeighIn());
		assertEquals("10 lbs per day", 10, we3.getWeightGainPerDay());
		
		
		
	}

	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(WeighIn.EVENT_CODE, getFixture().getEventCode());
	}

} //WeighInTest
