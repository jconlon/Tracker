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

import com.verticon.tracker.Birthing;
import com.verticon.tracker.OneToTen;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Birthing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.BirthingImpl#isViability <em>Viability</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.BirthingImpl#isAssisted <em>Assisted</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.BirthingImpl#getDifficulty <em>Difficulty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BirthingImpl extends EventImpl implements Birthing {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #isViability() <em>Viability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isViability()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VIABILITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isViability() <em>Viability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isViability()
	 * @generated
	 * @ordered
	 */
	protected boolean viability = VIABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isAssisted() <em>Assisted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssisted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ASSISTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAssisted() <em>Assisted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssisted()
	 * @generated
	 * @ordered
	 */
	protected boolean assisted = ASSISTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDifficulty() <em>Difficulty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDifficulty()
	 * @generated
	 * @ordered
	 */
	protected static final OneToTen DIFFICULTY_EDEFAULT = OneToTen.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getDifficulty() <em>Difficulty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDifficulty()
	 * @generated
	 * @ordered
	 */
	protected OneToTen difficulty = DIFFICULTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BirthingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.BIRTHING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isViability() {
		return viability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViability(boolean newViability) {
		boolean oldViability = viability;
		viability = newViability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.BIRTHING__VIABILITY, oldViability, viability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssisted() {
		return assisted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssisted(boolean newAssisted) {
		boolean oldAssisted = assisted;
		assisted = newAssisted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.BIRTHING__ASSISTED, oldAssisted, assisted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OneToTen getDifficulty() {
		return difficulty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDifficulty(OneToTen newDifficulty) {
		OneToTen oldDifficulty = difficulty;
		difficulty = newDifficulty == null ? DIFFICULTY_EDEFAULT : newDifficulty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.BIRTHING__DIFFICULTY, oldDifficulty, difficulty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.BIRTHING__VIABILITY:
				return isViability();
			case TrackerPackage.BIRTHING__ASSISTED:
				return isAssisted();
			case TrackerPackage.BIRTHING__DIFFICULTY:
				return getDifficulty();
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
			case TrackerPackage.BIRTHING__VIABILITY:
				setViability((Boolean)newValue);
				return;
			case TrackerPackage.BIRTHING__ASSISTED:
				setAssisted((Boolean)newValue);
				return;
			case TrackerPackage.BIRTHING__DIFFICULTY:
				setDifficulty((OneToTen)newValue);
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
			case TrackerPackage.BIRTHING__VIABILITY:
				setViability(VIABILITY_EDEFAULT);
				return;
			case TrackerPackage.BIRTHING__ASSISTED:
				setAssisted(ASSISTED_EDEFAULT);
				return;
			case TrackerPackage.BIRTHING__DIFFICULTY:
				setDifficulty(DIFFICULTY_EDEFAULT);
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
			case TrackerPackage.BIRTHING__VIABILITY:
				return viability != VIABILITY_EDEFAULT;
			case TrackerPackage.BIRTHING__ASSISTED:
				return assisted != ASSISTED_EDEFAULT;
			case TrackerPackage.BIRTHING__DIFFICULTY:
				return difficulty != DIFFICULTY_EDEFAULT;
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
		result.append(" (viability: ");
		result.append(viability);
		result.append(", assisted: ");
		result.append(assisted);
		result.append(", difficulty: ");
		result.append(difficulty);
		result.append(')');
		return result.toString();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getEventCode() {
		return EVENT_CODE;
	}

} //BirthingImpl
