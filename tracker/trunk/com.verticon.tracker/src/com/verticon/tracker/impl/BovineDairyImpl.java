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

import com.verticon.tracker.AnimalType;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.DairyBreed;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bovine Dairy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.BovineDairyImpl#getDairyBreed <em>Dairy Breed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BovineDairyImpl extends BovineImpl implements BovineDairy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getDairyBreed() <em>Dairy Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDairyBreed()
	 * @generated
	 * @ordered
	 */
	protected static final DairyBreed DAIRY_BREED_EDEFAULT = DairyBreed.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getDairyBreed() <em>Dairy Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDairyBreed()
	 * @generated
	 * @ordered
	 */
	protected DairyBreed dairyBreed = DAIRY_BREED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BovineDairyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.BOVINE_DAIRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyBreed getDairyBreed() {
		return dairyBreed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDairyBreed(DairyBreed newDairyBreed) {
		DairyBreed oldDairyBreed = dairyBreed;
		dairyBreed = newDairyBreed == null ? DAIRY_BREED_EDEFAULT : newDairyBreed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.BOVINE_DAIRY__DAIRY_BREED, oldDairyBreed, dairyBreed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.BOVINE_DAIRY__DAIRY_BREED:
				return getDairyBreed();
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
			case TrackerPackage.BOVINE_DAIRY__DAIRY_BREED:
				setDairyBreed((DairyBreed)newValue);
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
			case TrackerPackage.BOVINE_DAIRY__DAIRY_BREED:
				setDairyBreed(DAIRY_BREED_EDEFAULT);
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
			case TrackerPackage.BOVINE_DAIRY__DAIRY_BREED:
				return dairyBreed != DAIRY_BREED_EDEFAULT;
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
		result.append(" (dairyBreed: ");
		result.append(dairyBreed);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public String getBreed() {
		if(getDairyBreed()==DairyBreed.UNSPECIFIED_LITERAL){
			return "";
		}
		return getDairyBreed().getName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AnimalType getType() {
		return AnimalType.BOVINE_DAIRY;
	}

} //BovineDairyImpl