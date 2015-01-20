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
import com.verticon.tracker.BeefBreed;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bovine Beef</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.BovineBeefImpl#getBeefBreed <em>Beef Breed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BovineBeefImpl extends BovineImpl implements BovineBeef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getBeefBreed() <em>Beef Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeefBreed()
	 * @generated
	 * @ordered
	 */
	protected static final BeefBreed BEEF_BREED_EDEFAULT = BeefBreed.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getBeefBreed() <em>Beef Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeefBreed()
	 * @generated
	 * @ordered
	 */
	protected BeefBreed beefBreed = BEEF_BREED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BovineBeefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.BOVINE_BEEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeefBreed getBeefBreed() {
		return beefBreed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeefBreed(BeefBreed newBeefBreed) {
		BeefBreed oldBeefBreed = beefBreed;
		beefBreed = newBeefBreed == null ? BEEF_BREED_EDEFAULT : newBeefBreed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.BOVINE_BEEF__BEEF_BREED, oldBeefBreed, beefBreed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.BOVINE_BEEF__BEEF_BREED:
				return getBeefBreed();
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
			case TrackerPackage.BOVINE_BEEF__BEEF_BREED:
				setBeefBreed((BeefBreed)newValue);
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
			case TrackerPackage.BOVINE_BEEF__BEEF_BREED:
				setBeefBreed(BEEF_BREED_EDEFAULT);
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
			case TrackerPackage.BOVINE_BEEF__BEEF_BREED:
				return beefBreed != BEEF_BREED_EDEFAULT;
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
		result.append(" (beefBreed: ");
		result.append(beefBreed);
		result.append(')');
		return result.toString();
	}

	/**
	 * @NOT
	 */
	@Override
	public String getBreed() {
				if(getBeefBreed()==BeefBreed.UNSPECIFIED_LITERAL){
			return "";
		}
		return getBeefBreed().getName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AnimalType getType() {
		return AnimalType.BOVINE_BEEF;
	}

} //BovineBeefImpl