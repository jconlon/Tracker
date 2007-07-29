/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import junit.framework.TestCase;

import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.Event#getEventCode() <em>Event Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#getId() <em>Id</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class EventTest extends TestCase {
	private static final String _123456789012345 = "123456789012345";

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
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Event#getId()
	 * @generated NOT
	 */
	public void testGetId() {
		assertNotNull(getFixture());
		assertEquals(0,getFixture().getId());
		
		AnimalId ain = TrackerFactory.eINSTANCE.createAnimalId();
		ain.setIdNumber(_123456789012345);
		ain.getEvents().add(getFixture());
		
		assertEquals(Long.parseLong(_123456789012345), getFixture().getId());
		
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

} //EventTest
