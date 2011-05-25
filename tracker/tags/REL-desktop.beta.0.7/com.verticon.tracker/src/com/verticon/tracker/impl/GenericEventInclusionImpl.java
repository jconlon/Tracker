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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.GenericEventInclusion;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Event Inclusion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.GenericEventInclusionImpl#getSpecies <em>Species</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.GenericEventInclusionImpl#getOcd <em>Ocd</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericEventInclusionImpl extends MinimalEObjectImpl.Container implements GenericEventInclusion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The cached value of the '{@link #getSpecies() <em>Species</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecies()
	 * @generated
	 * @ordered
	 */
	protected EList<AnimalType> species;

	/**
	 * The cached value of the '{@link #getOcd() <em>Ocd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcd()
	 * @generated
	 * @ordered
	 */
	protected OCD ocd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericEventInclusionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.GENERIC_EVENT_INCLUSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnimalType> getSpecies() {
		if (species == null) {
			species = new EDataTypeUniqueEList<AnimalType>(AnimalType.class, this, TrackerPackage.GENERIC_EVENT_INCLUSION__SPECIES);
		}
		return species;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCD getOcd() {
		if (ocd != null && ocd.eIsProxy()) {
			InternalEObject oldOcd = (InternalEObject)ocd;
			ocd = (OCD)eResolveProxy(oldOcd);
			if (ocd != oldOcd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.GENERIC_EVENT_INCLUSION__OCD, oldOcd, ocd));
			}
		}
		return ocd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCD basicGetOcd() {
		return ocd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOcd(OCD newOcd) {
		OCD oldOcd = ocd;
		ocd = newOcd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.GENERIC_EVENT_INCLUSION__OCD, oldOcd, ocd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.GENERIC_EVENT_INCLUSION__SPECIES:
				return getSpecies();
			case TrackerPackage.GENERIC_EVENT_INCLUSION__OCD:
				if (resolve) return getOcd();
				return basicGetOcd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.GENERIC_EVENT_INCLUSION__SPECIES:
				getSpecies().clear();
				getSpecies().addAll((Collection<? extends AnimalType>)newValue);
				return;
			case TrackerPackage.GENERIC_EVENT_INCLUSION__OCD:
				setOcd((OCD)newValue);
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
			case TrackerPackage.GENERIC_EVENT_INCLUSION__SPECIES:
				getSpecies().clear();
				return;
			case TrackerPackage.GENERIC_EVENT_INCLUSION__OCD:
				setOcd((OCD)null);
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
			case TrackerPackage.GENERIC_EVENT_INCLUSION__SPECIES:
				return species != null && !species.isEmpty();
			case TrackerPackage.GENERIC_EVENT_INCLUSION__OCD:
				return ocd != null;
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
		result.append(" (species: ");
		result.append(species);
		result.append(')');
		return result.toString();
	}

} //GenericEventInclusionImpl
