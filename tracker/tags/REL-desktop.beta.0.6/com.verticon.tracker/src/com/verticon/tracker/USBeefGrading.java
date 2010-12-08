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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>US Beef Grading</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.USBeefGrading#getQualityGrade <em>Quality Grade</em>}</li>
 *   <li>{@link com.verticon.tracker.USBeefGrading#getQualityGradeLevel <em>Quality Grade Level</em>}</li>
 *   <li>{@link com.verticon.tracker.USBeefGrading#getYieldGrade <em>Yield Grade</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getUSBeefGrading()
 * @model
 * @generated
 */
public interface USBeefGrading extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Quality Grade</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.USQualityGrade}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Grade</em>' attribute.
	 * @see com.verticon.tracker.USQualityGrade
	 * @see #setQualityGrade(USQualityGrade)
	 * @see com.verticon.tracker.TrackerPackage#getUSBeefGrading_QualityGrade()
	 * @model
	 * @generated
	 */
	USQualityGrade getQualityGrade();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.USBeefGrading#getQualityGrade <em>Quality Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Grade</em>' attribute.
	 * @see com.verticon.tracker.USQualityGrade
	 * @see #getQualityGrade()
	 * @generated
	 */
	void setQualityGrade(USQualityGrade value);

	/**
	 * Returns the value of the '<em><b>Quality Grade Level</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.Level}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Grade Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Grade Level</em>' attribute.
	 * @see com.verticon.tracker.Level
	 * @see #setQualityGradeLevel(Level)
	 * @see com.verticon.tracker.TrackerPackage#getUSBeefGrading_QualityGradeLevel()
	 * @model
	 * @generated
	 */
	Level getQualityGradeLevel();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.USBeefGrading#getQualityGradeLevel <em>Quality Grade Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Grade Level</em>' attribute.
	 * @see com.verticon.tracker.Level
	 * @see #getQualityGradeLevel()
	 * @generated
	 */
	void setQualityGradeLevel(Level value);

	/**
	 * Returns the value of the '<em><b>Yield Grade</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.USBeefYieldGrade}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yield Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yield Grade</em>' attribute.
	 * @see com.verticon.tracker.USBeefYieldGrade
	 * @see #setYieldGrade(USBeefYieldGrade)
	 * @see com.verticon.tracker.TrackerPackage#getUSBeefGrading_YieldGrade()
	 * @model
	 * @generated
	 */
	USBeefYieldGrade getYieldGrade();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.USBeefGrading#getYieldGrade <em>Yield Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Yield Grade</em>' attribute.
	 * @see com.verticon.tracker.USBeefYieldGrade
	 * @see #getYieldGrade()
	 * @generated
	 */
	void setYieldGrade(USBeefYieldGrade value);
	
	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 109;

} // USBeefGrading
