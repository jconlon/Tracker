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
import com.verticon.tracker.BisonBreed;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bovine Bison</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.BovineBisonImpl#getBuffaloBreed <em>Buffalo Breed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BovineBisonImpl extends BovineImpl implements BovineBison {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getBuffaloBreed() <em>Buffalo Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffaloBreed()
	 * @generated
	 * @ordered
	 */
	protected static final BisonBreed BUFFALO_BREED_EDEFAULT = BisonBreed.WO_LITERAL;

	/**
	 * The cached value of the '{@link #getBuffaloBreed() <em>Buffalo Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffaloBreed()
	 * @generated
	 * @ordered
	 */
	protected BisonBreed buffaloBreed = BUFFALO_BREED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BovineBisonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.BOVINE_BISON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BisonBreed getBuffaloBreed() {
		return buffaloBreed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuffaloBreed(BisonBreed newBuffaloBreed) {
		BisonBreed oldBuffaloBreed = buffaloBreed;
		buffaloBreed = newBuffaloBreed == null ? BUFFALO_BREED_EDEFAULT : newBuffaloBreed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.BOVINE_BISON__BUFFALO_BREED, oldBuffaloBreed, buffaloBreed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.BOVINE_BISON__BUFFALO_BREED:
				return getBuffaloBreed();
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
			case TrackerPackage.BOVINE_BISON__BUFFALO_BREED:
				setBuffaloBreed((BisonBreed)newValue);
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
			case TrackerPackage.BOVINE_BISON__BUFFALO_BREED:
				setBuffaloBreed(BUFFALO_BREED_EDEFAULT);
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
			case TrackerPackage.BOVINE_BISON__BUFFALO_BREED:
				return buffaloBreed != BUFFALO_BREED_EDEFAULT;
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
		result.append(" (buffaloBreed: ");
		result.append(buffaloBreed);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getBreed() {
		if(getBuffaloBreed()==BisonBreed.UNSPECIFIED_LITERAL){
			return "";
		}
		return getBuffaloBreed().getName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AnimalType getType() {
		return AnimalType.BOVINE_BISON;
	}
} //BovineBisonImpl