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
package com.verticon.tracker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.USSwineGrading;
import com.verticon.tracker.USSwineQualityGrade;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>US Swine Grading</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.USSwineGradingImpl#getQualityGrade <em>Quality Grade</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class USSwineGradingImpl extends EventImpl implements USSwineGrading {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getQualityGrade() <em>Quality Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityGrade()
	 * @generated
	 * @ordered
	 */
	protected static final USSwineQualityGrade QUALITY_GRADE_EDEFAULT = USSwineQualityGrade.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getQualityGrade() <em>Quality Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityGrade()
	 * @generated
	 * @ordered
	 */
	protected USSwineQualityGrade qualityGrade = QUALITY_GRADE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected USSwineGradingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.US_SWINE_GRADING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USSwineQualityGrade getQualityGrade() {
		return qualityGrade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityGrade(USSwineQualityGrade newQualityGrade) {
		USSwineQualityGrade oldQualityGrade = qualityGrade;
		qualityGrade = newQualityGrade == null ? QUALITY_GRADE_EDEFAULT : newQualityGrade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.US_SWINE_GRADING__QUALITY_GRADE, oldQualityGrade, qualityGrade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.US_SWINE_GRADING__QUALITY_GRADE:
				return getQualityGrade();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.US_SWINE_GRADING__QUALITY_GRADE:
				setQualityGrade((USSwineQualityGrade)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.US_SWINE_GRADING__QUALITY_GRADE:
				setQualityGrade(QUALITY_GRADE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.US_SWINE_GRADING__QUALITY_GRADE:
				return qualityGrade != QUALITY_GRADE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qualityGrade: ");
		result.append(qualityGrade);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public int getEventCode() {
		return EVENT_CODE;
	}

} //USSwineGradingImpl
