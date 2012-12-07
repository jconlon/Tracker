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

import java.util.Date;
import java.util.TimeZone;

import net.sourceforge.calendardate.CalendarDate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.tracker.HerdTest;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Herd Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.HerdTestImpl#isPregnant <em>Pregnant</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.HerdTestImpl#getDaysSinceBredEstimate <em>Days Since Bred Estimate</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.HerdTestImpl#getBredDateEstimate <em>Bred Date Estimate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HerdTestImpl extends EventImpl implements HerdTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #isPregnant() <em>Pregnant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPregnant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PREGNANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPregnant() <em>Pregnant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPregnant()
	 * @generated
	 * @ordered
	 */
	protected boolean pregnant = PREGNANT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDaysSinceBredEstimate() <em>Days Since Bred Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaysSinceBredEstimate()
	 * @generated
	 * @ordered
	 */
	protected static final int DAYS_SINCE_BRED_ESTIMATE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDaysSinceBredEstimate() <em>Days Since Bred Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaysSinceBredEstimate()
	 * @generated
	 * @ordered
	 */
	protected int daysSinceBredEstimate = DAYS_SINCE_BRED_ESTIMATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBredDateEstimate() <em>Bred Date Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBredDateEstimate()
	 * @generated
	 * @ordered
	 */
	protected static final Date BRED_DATE_ESTIMATE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HerdTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.HERD_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPregnant() {
		return pregnant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPregnant(boolean newPregnant) {
		boolean oldPregnant = pregnant;
		pregnant = newPregnant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.HERD_TEST__PREGNANT, oldPregnant, pregnant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDaysSinceBredEstimate() {
		return daysSinceBredEstimate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDaysSinceBredEstimate(int newDaysSinceBredEstimate) {
		int oldDaysSinceBredEstimate = daysSinceBredEstimate;
		daysSinceBredEstimate = newDaysSinceBredEstimate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.HERD_TEST__DAYS_SINCE_BRED_ESTIMATE, oldDaysSinceBredEstimate, daysSinceBredEstimate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Date getBredDateEstimate() {
		if((!isPregnant()) || this.getDateTime()==null|| daysSinceBredEstimate==0){
			return null;
		}
		CalendarDate dateOfEvent = new CalendarDate (TimeZone.getDefault(),getDateTime());
		return dateOfEvent.addDays(-daysSinceBredEstimate).toDate(TimeZone.getDefault());
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.HERD_TEST__PREGNANT:
				return isPregnant();
			case TrackerPackage.HERD_TEST__DAYS_SINCE_BRED_ESTIMATE:
				return getDaysSinceBredEstimate();
			case TrackerPackage.HERD_TEST__BRED_DATE_ESTIMATE:
				return getBredDateEstimate();
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
			case TrackerPackage.HERD_TEST__PREGNANT:
				setPregnant((Boolean)newValue);
				return;
			case TrackerPackage.HERD_TEST__DAYS_SINCE_BRED_ESTIMATE:
				setDaysSinceBredEstimate((Integer)newValue);
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
			case TrackerPackage.HERD_TEST__PREGNANT:
				setPregnant(PREGNANT_EDEFAULT);
				return;
			case TrackerPackage.HERD_TEST__DAYS_SINCE_BRED_ESTIMATE:
				setDaysSinceBredEstimate(DAYS_SINCE_BRED_ESTIMATE_EDEFAULT);
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
			case TrackerPackage.HERD_TEST__PREGNANT:
				return pregnant != PREGNANT_EDEFAULT;
			case TrackerPackage.HERD_TEST__DAYS_SINCE_BRED_ESTIMATE:
				return daysSinceBredEstimate != DAYS_SINCE_BRED_ESTIMATE_EDEFAULT;
			case TrackerPackage.HERD_TEST__BRED_DATE_ESTIMATE:
				return BRED_DATE_ESTIMATE_EDEFAULT == null ? getBredDateEstimate() != null : !BRED_DATE_ESTIMATE_EDEFAULT.equals(getBredDateEstimate());
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
		result.append(" (pregnant: ");
		result.append(pregnant);
		result.append(", daysSinceBredEstimate: ");
		result.append(daysSinceBredEstimate);
		result.append(')');
		return result.toString();
	}

	@Override
	public int getEventCode() {
		return EVENT_CODE;
	}

} //HerdTestImpl
