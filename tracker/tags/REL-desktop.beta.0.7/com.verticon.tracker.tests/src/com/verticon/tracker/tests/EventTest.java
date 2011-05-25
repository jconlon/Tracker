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

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.util.TrackerConstants;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Event#getEventCode() <em>Event Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#getId() <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#getDate() <em>Date</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#getDateKey() <em>Date Key</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Event#dateEvent(com.verticon.tracker.EventType, java.lang.String) <em>Date Event</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#dateEvents() <em>Date Events</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class EventTest extends TestCase {
	private static final String JANUARY_6_1972 = "January 6, 1972";

	private static final String TAG_ID = "123456789012345";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Event test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Event fixture = null;

	/**
	 * Constructs a new Event test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Event test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Event fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Event test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Event getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Event#getEventCode() <em>Event Code</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Event#getEventCode()
	 * @generated NOT
	 */
	public void testGetEventCode() {
		fail("Must override in subclasses");
	}

	
	
	
	/**
	 * Tests the '{@link com.verticon.tracker.Event#getId() <em>Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Event#getId()
	 * @generated NOT
	 */
	public void testGetId() {
		assertNotNull(getFixture());
		assertEquals("",getFixture().getId());
		
		Tag ain = TrackerFactory.eINSTANCE.createTag();
		ain.setId(TAG_ID);
		ain.getEvents().add(getFixture());
		
		assertEquals("123456789012345", getFixture().getId());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Event#getDate() <em>Date</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Event#getDate()
	 * @generated NOT
	 */
	@SuppressWarnings("deprecation")
	public void testGetDate() {
		assertNotNull(getFixture().getDate());
		Date date = null;
		try {
			 date = TrackerConstants.DAY_FORMAT.parse(JANUARY_6_1972);
			
		} catch (ParseException e) {
			fail(e.toString());
		}
		
		getFixture().setDateTime(date);
		assertEquals(JANUARY_6_1972, getFixture().getDate());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Event#getDateKey() <em>Date Key</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Event#getDateKey()
	 * @generated NOT
	 */
	public void testGetDateKey() {
		testGetDate();
		assertEquals(JANUARY_6_1972+'|', getFixture().getDateKey());
		String value = "12345";
		Tag t = TrackerFactory.eINSTANCE.createTag();
		t.setId(value);
		t.getEvents().add(getFixture());
		assertEquals(JANUARY_6_1972+'|'+value, getFixture().getDateKey());	
	}

	/**
	 * Tests the '{@link com.verticon.tracker.Event#dateEvent(com.verticon.tracker.EventType, java.lang.String) <em>Date Event</em>}' operation.
	 * <!-- begin-user-doc -->
	 * Finds the most recent event that matches a type (and a name if it is a genericEvent)
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Event#dateEvent(com.verticon.tracker.EventType, java.lang.String)
	 * @generated NOT
	 */
	public void testDateEvent__EventType_String() {
		testDateEvents();
		EventType type = EventType.getByName(getFixture().eClass().getName());
		assertNotNull(getFixture().eClass().getName(),type);
		assertNotNull(fixture.dateEvent(type, null));
	}

	public void testGetComments(){
		assertNotNull(getFixture());
		getFixture().setComments("Hi World");
		assertEquals("Hi World", getFixture().getComments());
	}
	
	public void testIsCorrection(){
		assertFalse(getFixture().isCorrection());
		getFixture().setCorrection(true);
		assertTrue(getFixture().isCorrection());
	}
	
	public void testDateTime(){
		assertNotNull(getFixture().getDateTime());
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		Date date = null;
		try {
			 date = df.parse("5/14/07");
			
		} catch (ParseException e) {
			fail(e.toString());
		}
		
		getFixture().setDateTime(date);
		assertEquals(date, getFixture().getDateTime());
		
	}
	
//	public void testDate(){
//		
//		assertNotNull(getFixture().getDate());
//		Date date = null;
//		try {
//			 date = TrackerConstants.DAY_FORMAT.parse(JANUARY_6_1972);
//			
//		} catch (ParseException e) {
//			fail(e.toString());
//		}
//		
//		getFixture().setDateTime(date);
//		assertEquals(JANUARY_6_1972, getFixture().getDate());
//		
//	}
	
//	public void testDateKey(){
//		testDate();
//		assertEquals(JANUARY_6_1972+'|', getFixture().getDateKey());
//		String value = "12345";
//		Tag t = TrackerFactory.eINSTANCE.createTag();
//		t.setId(value);
//		t.getEvents().add(getFixture());
//		assertEquals(JANUARY_6_1972+'|'+value, getFixture().getDateKey());
//		
//	}
	
	public void testDateEvents(){
		String value = "12345";
		Tag t = TrackerFactory.eINSTANCE.createTag();
		t.setId(value);
		t.getEvents().add(getFixture());
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		t.getEvents().add(we);
		
	    we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("Second");
	    firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		t.getEvents().add(we);
		
		Sighting s = TrackerFactory.eINSTANCE.createSighting();
		firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		s.setDateTime(
				firstWeighInDate.getTime());
		t.getEvents().add(s);
		
		assertEquals(1, getFixture().dateEvents().size());
		
		assertEquals(3, we.dateEvents().size());
		
	}
	
	public void testDateType(){
		String value = "12345";
		Tag t = TrackerFactory.eINSTANCE.createTag();
		t.setId(value);
		t.getEvents().add(getFixture());
		//First weighIn 10 days ago and 100 lbs
		WeighIn we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("First");
		Calendar firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		t.getEvents().add(we);
		
	    we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("Second");
	    firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		we.setDateTime(
				firstWeighInDate.getTime());
		we.setWeight(100d);
		t.getEvents().add(we);
		
		Sighting s = TrackerFactory.eINSTANCE.createSighting();
		firstWeighInDate = Calendar.getInstance();
		firstWeighInDate.add(Calendar.DAY_OF_MONTH, -10);
		s.setDateTime(
				firstWeighInDate.getTime());
		t.getEvents().add(s);
		
		
		
		assertEquals(s, we.dateEvent(EventType.SIGHTING, null));
		
	}

} //EventTest
