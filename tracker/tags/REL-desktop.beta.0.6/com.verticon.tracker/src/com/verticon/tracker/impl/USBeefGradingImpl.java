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

import com.verticon.tracker.Level;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.USBeefGrading;
import com.verticon.tracker.USBeefYieldGrade;
import com.verticon.tracker.USQualityGrade;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>US Beef Grading</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.USBeefGradingImpl#getQualityGrade <em>Quality Grade</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.USBeefGradingImpl#getQualityGradeLevel <em>Quality Grade Level</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.USBeefGradingImpl#getYieldGrade <em>Yield Grade</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class USBeefGradingImpl extends EventImpl implements USBeefGrading {
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
	protected static final USQualityGrade QUALITY_GRADE_EDEFAULT = USQualityGrade.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getQualityGrade() <em>Quality Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityGrade()
	 * @generated
	 * @ordered
	 */
	protected USQualityGrade qualityGrade = QUALITY_GRADE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualityGradeLevel() <em>Quality Grade Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityGradeLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Level QUALITY_GRADE_LEVEL_EDEFAULT = Level.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getQualityGradeLevel() <em>Quality Grade Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityGradeLevel()
	 * @generated
	 * @ordered
	 */
	protected Level qualityGradeLevel = QUALITY_GRADE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getYieldGrade() <em>Yield Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYieldGrade()
	 * @generated
	 * @ordered
	 */
	protected static final USBeefYieldGrade YIELD_GRADE_EDEFAULT = USBeefYieldGrade.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getYieldGrade() <em>Yield Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYieldGrade()
	 * @generated
	 * @ordered
	 */
	protected USBeefYieldGrade yieldGrade = YIELD_GRADE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected USBeefGradingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.US_BEEF_GRADING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USQualityGrade getQualityGrade() {
		return qualityGrade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityGrade(USQualityGrade newQualityGrade) {
		USQualityGrade oldQualityGrade = qualityGrade;
		qualityGrade = newQualityGrade == null ? QUALITY_GRADE_EDEFAULT : newQualityGrade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE, oldQualityGrade, qualityGrade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getQualityGradeLevel() {
		return qualityGradeLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityGradeLevel(Level newQualityGradeLevel) {
		Level oldQualityGradeLevel = qualityGradeLevel;
		qualityGradeLevel = newQualityGradeLevel == null ? QUALITY_GRADE_LEVEL_EDEFAULT : newQualityGradeLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE_LEVEL, oldQualityGradeLevel, qualityGradeLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USBeefYieldGrade getYieldGrade() {
		return yieldGrade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYieldGrade(USBeefYieldGrade newYieldGrade) {
		USBeefYieldGrade oldYieldGrade = yieldGrade;
		yieldGrade = newYieldGrade == null ? YIELD_GRADE_EDEFAULT : newYieldGrade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.US_BEEF_GRADING__YIELD_GRADE, oldYieldGrade, yieldGrade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE:
				return getQualityGrade();
			case TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE_LEVEL:
				return getQualityGradeLevel();
			case TrackerPackage.US_BEEF_GRADING__YIELD_GRADE:
				return getYieldGrade();
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
			case TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE:
				setQualityGrade((USQualityGrade)newValue);
				return;
			case TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE_LEVEL:
				setQualityGradeLevel((Level)newValue);
				return;
			case TrackerPackage.US_BEEF_GRADING__YIELD_GRADE:
				setYieldGrade((USBeefYieldGrade)newValue);
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
			case TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE:
				setQualityGrade(QUALITY_GRADE_EDEFAULT);
				return;
			case TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE_LEVEL:
				setQualityGradeLevel(QUALITY_GRADE_LEVEL_EDEFAULT);
				return;
			case TrackerPackage.US_BEEF_GRADING__YIELD_GRADE:
				setYieldGrade(YIELD_GRADE_EDEFAULT);
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
			case TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE:
				return qualityGrade != QUALITY_GRADE_EDEFAULT;
			case TrackerPackage.US_BEEF_GRADING__QUALITY_GRADE_LEVEL:
				return qualityGradeLevel != QUALITY_GRADE_LEVEL_EDEFAULT;
			case TrackerPackage.US_BEEF_GRADING__YIELD_GRADE:
				return yieldGrade != YIELD_GRADE_EDEFAULT;
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
		result.append(", qualityGradeLevel: ");
		result.append(qualityGradeLevel);
		result.append(", yieldGrade: ");
		result.append(yieldGrade);
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

} //USBeefGradingImpl
