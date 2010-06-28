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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replaced Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.ReplacedTagImpl#getOldId <em>Old Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.ReplacedTagImpl#isUsainNumberUsedForOldId <em>Usain Number Used For Old Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.ReplacedTagImpl#getOldTag <em>Old Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplacedTagImpl extends EventImpl implements ReplacedTag {
	private static final int EVENT_CODE = 6;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getOldId() <em>Old Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * Modified from null to a empty string
	 * <!-- end-user-doc -->
	 * @see #getOldId()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String OLD_ID_EDEFAULT = "";

	/**
	 * The default value of the '{@link #isUsainNumberUsedForOldId() <em>Usain Number Used For Old Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsainNumberUsedForOldId()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USAIN_NUMBER_USED_FOR_OLD_ID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getOldTag() <em>Old Tag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldTag()
	 * @generated
	 * @ordered
	 */
	protected Tag oldTag;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplacedTagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.REPLACED_TAG;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getEventCode() {
		return EVENT_CODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getOldId() {
		return oldTag==null?OLD_ID_EDEFAULT:oldTag.getId();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isUsainNumberUsedForOldId() {
		return oldTag==null?false:oldTag.isUsainNumberUsed();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag getOldTag() {
		if (oldTag != null && oldTag.eIsProxy()) {
			InternalEObject oldOldTag = (InternalEObject)oldTag;
			oldTag = (Tag)eResolveProxy(oldOldTag);
			if (oldTag != oldOldTag) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.REPLACED_TAG__OLD_TAG, oldOldTag, oldTag));
			}
		}
		return oldTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag basicGetOldTag() {
		return oldTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldTag(Tag newOldTag) {
		Tag oldOldTag = oldTag;
		oldTag = newOldTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.REPLACED_TAG__OLD_TAG, oldOldTag, oldTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.REPLACED_TAG__OLD_ID:
				return getOldId();
			case TrackerPackage.REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID:
				return isUsainNumberUsedForOldId();
			case TrackerPackage.REPLACED_TAG__OLD_TAG:
				if (resolve) return getOldTag();
				return basicGetOldTag();
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
			case TrackerPackage.REPLACED_TAG__OLD_TAG:
				setOldTag((Tag)newValue);
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
			case TrackerPackage.REPLACED_TAG__OLD_TAG:
				setOldTag((Tag)null);
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
			case TrackerPackage.REPLACED_TAG__OLD_ID:
				return OLD_ID_EDEFAULT == null ? getOldId() != null : !OLD_ID_EDEFAULT.equals(getOldId());
			case TrackerPackage.REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID:
				return isUsainNumberUsedForOldId() != USAIN_NUMBER_USED_FOR_OLD_ID_EDEFAULT;
			case TrackerPackage.REPLACED_TAG__OLD_TAG:
				return oldTag != null;
		}
		return super.eIsSet(featureID);
	}

} //ReplacedTagImpl