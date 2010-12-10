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

import com.verticon.tracker.MovedIn;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Moved In</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.MovedInImpl#getSourcePin <em>Source Pin</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MovedInImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MovedInImpl extends EventImpl implements MovedIn {
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getSourcePin() <em>Source Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePin()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_PIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourcePin() <em>Source Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePin()
	 * @generated
	 * @ordered
	 */
	protected String sourcePin = SOURCE_PIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovedInImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.MOVED_IN;
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
	 * @generated
	 */
	public String getSourcePin() {
		return sourcePin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePin(String newSourcePin) {
		String oldSourcePin = sourcePin;
		sourcePin = newSourcePin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MOVED_IN__SOURCE_PIN, oldSourcePin, sourcePin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MOVED_IN__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.MOVED_IN__SOURCE_PIN:
				return getSourcePin();
			case TrackerPackage.MOVED_IN__URI:
				return getUri();
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
			case TrackerPackage.MOVED_IN__SOURCE_PIN:
				setSourcePin((String)newValue);
				return;
			case TrackerPackage.MOVED_IN__URI:
				setUri((String)newValue);
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
			case TrackerPackage.MOVED_IN__SOURCE_PIN:
				setSourcePin(SOURCE_PIN_EDEFAULT);
				return;
			case TrackerPackage.MOVED_IN__URI:
				setUri(URI_EDEFAULT);
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
			case TrackerPackage.MOVED_IN__SOURCE_PIN:
				return SOURCE_PIN_EDEFAULT == null ? sourcePin != null : !SOURCE_PIN_EDEFAULT.equals(sourcePin);
			case TrackerPackage.MOVED_IN__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
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
		result.append(" (sourcePin: ");
		result.append(sourcePin);
		result.append(", uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //MovedInImpl