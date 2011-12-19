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
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.WeighIn#previousWeighIn() <em>Previous Weigh In</em>}</li>
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
		WeighIn we1 = TrackerFactory.eINSTANCE.createWeighIn();
		we1.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we1.setDateTime(
				firstWeighInDate.getTime());
		we1.setWeight(100d);
		tag.getEvents().add(we1);
		
		//Second weighIn today 250 lbs
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				secondWeighInDate.getTime());
		we2.setWeight(250d);
		tag.getEvents().add(we2);
		
		WeighInImpl weImpl = (WeighInImpl)we1;
		assertTrue("First event should not show any other events", 
				weImpl.getPreviousWeighInEvents().isEmpty());
		
		
//		assertEquals("First event should show nothing", 0, we.getWeightGainPerDay());
		assertNull("First event should show nothing",  we1.getWeightGainPerDay());
		
		WeighInImpl weImpl2 = (WeighInImpl)we2;
		assertEquals("Second event should have one previous event",1, 
				weImpl2.getPreviousWeighInEvents().size());
		assertEquals("Second event should find only the first event",we1, 
				weImpl2.getPreviousWeighInEvents().iterator().next());
		assertEquals("15 lbs per day", new Double(15.0), we2.getWeightGainPerDay());
		
		
		//Third weighIn today 250 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Third");
		we3.setWeight(350d);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we3.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we3);
		
		
		assertTrue("First event should not show any other events", 
				weImpl.getPreviousWeighInEvents().isEmpty());
		assertNull("First event should show nothing",  we1.getWeightGainPerDay());
		
		assertEquals("Second event should have one previous event",1, 
				weImpl2.getPreviousWeighInEvents().size());
		
		assertEquals("Second event should find only the first event",we1, 
				weImpl2.getPreviousWeighInEvents().iterator().next());
		assertEquals("15 lbs per day", new Double(15.0), we2.getWeightGainPerDay());
		
		
		WeighInImpl weImpl3 = (WeighInImpl)we3;
		assertEquals("Third event should have two previous events",2, 
				weImpl3.getPreviousWeighInEvents().size());
		assertEquals("Third event should find only the second event",we2, 
				weImpl3.previousWeighIn());
		assertEquals("10 lbs per day", new Double(10.0), we3.getWeightGainPerDay());
		
		
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.WeighIn#previousWeighIn() <em>Previous Weigh In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.WeighIn#previousWeighIn()
	 * @generated NOT
	 */
	public void testPreviousWeighIn() {
		//Create an animal, a tag and a couple of weighIn Events
		Animal animal = TrackerFactory.eINSTANCE.createBovineBeef();
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		
		//First weighIn 10 days ago and 100 lbs
		WeighIn we1 = TrackerFactory.eINSTANCE.createWeighIn();
		we1.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we1.setDateTime(
				firstWeighInDate.getTime());
		we1.setWeight(100d);
		tag.getEvents().add(we1);
		
		//Second weighIn today 250 lbs
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				secondWeighInDate.getTime());
		we2.setWeight(250d);
		tag.getEvents().add(we2);
		
		WeighInImpl weImpl1 = (WeighInImpl)we1;
		assertTrue("First event should not show any other events", 
				weImpl1.getPreviousWeighInEvents().isEmpty());
		
		assertNull("First event should show nothing",  we1.getWeightGainPerDay());
		
		WeighInImpl weImpl2 = (WeighInImpl)we2;
		assertNotNull("Second event should have a previous event",
				weImpl2.previousWeighIn());
		assertEquals("Second event should equal a previous event",we1, 
				weImpl2.previousWeighIn());
		
	}
	
	/**
	 * Test getWeightPerDay method with multiple weighIn events
	 * some of which have a null weight. 
	 */
	public void testGetWeightGainPerDayWithNulls() {
		Animal animal = TrackerFactory.eINSTANCE.createBovineBeef();
		assertNull("Should have no weight on animal", animal.getWeight());
		
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		animal.getTags().add(tag);
		//First weighIn 10 days ago and 100 lbs
		WeighIn we1 = TrackerFactory.eINSTANCE.createWeighIn();
		we1.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we1.setDateTime(
				firstWeighInDate.getTime());
		we1.setWeight(100d);
		tag.getEvents().add(we1);
		
		assertNull( we1.getWeightGainPerDay());
		
		//Second weighIn today with no weight set
		WeighIn we2 = TrackerFactory.eINSTANCE.createWeighIn();
		we2.setComments("Null weight on weighIn");
		Calendar knullWeighInDate = Calendar.getInstance();
		we2.setDateTime(
				knullWeighInDate.getTime());
		tag.getEvents().add(we2);
		assertNull( we2.getWeightGainPerDay());
		
		
		//Third weighIn today 250 lbs
		WeighIn we3 = TrackerFactory.eINSTANCE.createWeighIn();
		we3.setComments("Second");
		Calendar secondWeighInDate = Calendar.getInstance();
		we3.setDateTime(
				secondWeighInDate.getTime());
		we3.setWeight(250d);
		tag.getEvents().add(we3);
		assertEquals(new Double(15.0), we3.getWeightGainPerDay());
		
		//Fourth weighIn today 350 lbs
		WeighIn we4 = TrackerFactory.eINSTANCE.createWeighIn();
		we4.setComments("Third");
		we4.setWeight(350d);
		Calendar thirdWeighInDate = Calendar.getInstance();
		thirdWeighInDate.add(Calendar.DAY_OF_MONTH, 10);
		we4.setDateTime(
				thirdWeighInDate.getTime());
		tag.getEvents().add(we4);
		assertEquals(new Double(10.0), animal.getWeightGainPerDay());
	}

	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(WeighIn.EVENT_CODE, getFixture().getEventCode());
	}
	
	@Override
	public void testValues() {
		String value = "12345";
		Tag t = TrackerFactory.eINSTANCE.createTag();
		t.setId(value);
		
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = getFixture();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		t.getEvents().add(we);
		
		assertEquals("weight: 100.0, " +
				"unit: pound", we.values());
	}

} //WeighInTest
