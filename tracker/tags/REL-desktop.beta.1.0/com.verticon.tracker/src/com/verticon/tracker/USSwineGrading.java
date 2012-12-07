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
 * A representation of the model object '<em><b>US Swine Grading</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.USSwineGrading#getQualityGrade <em>Quality Grade</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getUSSwineGrading()
 * @model
 * @generated
 */
public interface USSwineGrading extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 110;

	/**
	 * Returns the value of the '<em><b>Quality Grade</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.USSwineQualityGrade}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Grade</em>' attribute.
	 * @see com.verticon.tracker.USSwineQualityGrade
	 * @see #setQualityGrade(USSwineQualityGrade)
	 * @see com.verticon.tracker.TrackerPackage#getUSSwineGrading_QualityGrade()
	 * @model
	 * @generated
	 */
	USSwineQualityGrade getQualityGrade();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.USSwineGrading#getQualityGrade <em>Quality Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Grade</em>' attribute.
	 * @see com.verticon.tracker.USSwineQualityGrade
	 * @see #getQualityGrade()
	 * @generated
	 */
	void setQualityGrade(USSwineQualityGrade value);

} // USSwineGrading
