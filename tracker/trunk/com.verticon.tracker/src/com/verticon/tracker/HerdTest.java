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
package com.verticon.tracker;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Herd Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.HerdTest#isPregnant <em>Pregnant</em>}</li>
 *   <li>{@link com.verticon.tracker.HerdTest#getDaysSinceBredEstimate <em>Days Since Bred Estimate</em>}</li>
 *   <li>{@link com.verticon.tracker.HerdTest#getBredDateEstimate <em>Bred Date Estimate</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getHerdTest()
 * @model
 * @generated
 */
public interface HerdTest extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";
	
	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 108;

	/**
	 * Returns the value of the '<em><b>Pregnant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pregnant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pregnant</em>' attribute.
	 * @see #setPregnant(boolean)
	 * @see com.verticon.tracker.TrackerPackage#getHerdTest_Pregnant()
	 * @model
	 * @generated
	 */
	boolean isPregnant();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.HerdTest#isPregnant <em>Pregnant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pregnant</em>' attribute.
	 * @see #isPregnant()
	 * @generated
	 */
	void setPregnant(boolean value);

	/**
	 * Returns the value of the '<em><b>Days Since Bred Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Days Since Bred Estimate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Days Since Bred Estimate</em>' attribute.
	 * @see #setDaysSinceBredEstimate(int)
	 * @see com.verticon.tracker.TrackerPackage#getHerdTest_DaysSinceBredEstimate()
	 * @model
	 * @generated
	 */
	int getDaysSinceBredEstimate();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.HerdTest#getDaysSinceBredEstimate <em>Days Since Bred Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Days Since Bred Estimate</em>' attribute.
	 * @see #getDaysSinceBredEstimate()
	 * @generated
	 */
	void setDaysSinceBredEstimate(int value);

	/**
	 * Returns the value of the '<em><b>Bred Date Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bred Date Estimate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bred Date Estimate</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getHerdTest_BredDateEstimate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Date getBredDateEstimate();

} // HerdTest
