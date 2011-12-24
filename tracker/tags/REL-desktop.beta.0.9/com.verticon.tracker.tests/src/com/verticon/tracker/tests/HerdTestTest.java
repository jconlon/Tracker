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

import java.util.Date;
import java.util.TimeZone;

import junit.textui.TestRunner;
import net.sourceforge.calendardate.CalendarDate;

import com.verticon.tracker.HerdTest;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Herd Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.HerdTest#getBredDateEstimate() <em>Bred Date Estimate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class HerdTestTest extends EventTest {

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
		TestRunner.run(HerdTestTest.class);
	}

	/**
	 * Constructs a new Herd Test test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HerdTestTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Herd Test test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected HerdTest getFixture() {
		return (HerdTest)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createHerdTest());
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
	 * Tests the '{@link com.verticon.tracker.HerdTest#getBredDateEstimate() <em>Bred Date Estimate</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.HerdTest#getBredDateEstimate()
	 * @generated NOT
	 */
	public void testGetBredDateEstimate() {
		assertNotNull(getFixture());
		assertNull(getFixture().getBredDateEstimate());
		TimeZone tz= TimeZone.getDefault();
		
		
		CalendarDate dateOfEvent = new CalendarDate (tz, new Date());
		getFixture().setDateTime(dateOfEvent.toDate(tz));
		
		//Set the days Since Bred Estimate
		getFixture().setDaysSinceBredEstimate(5);
		assertNull("BredDateEstimate should return null because pregnant is false",getFixture().getBredDateEstimate());
		
		getFixture().setPregnant(true);
		assertNotNull("BredDateEstimate should return Non Null because pregnant is true",getFixture().getBredDateEstimate());
		
		CalendarDate shouldBe = dateOfEvent.addDays(-5);
		assertEquals(shouldBe.toDate(tz), getFixture().getBredDateEstimate());
	}
	
	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(HerdTest.EVENT_CODE, getFixture().getEventCode());
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.tests.EventTest#testValues()
	 */
	@Override
	public void testValues() {
		assertEquals("pregnant: false, daysSinceBredEstimate: 0", getFixture().values());
	}


} //HerdTestTest
