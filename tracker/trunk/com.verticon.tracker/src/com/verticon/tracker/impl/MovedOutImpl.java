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

import com.verticon.tracker.MovedOut;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.TrackerPlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Moved Out</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.MovedOutImpl#getDestinationPin <em>Destination Pin</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MovedOutImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MovedOutImpl#getDestinationName <em>Destination Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MovedOutImpl extends EventImpl implements MovedOut {
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getDestinationPin() <em>Destination Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPin()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_PIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestinationPin() <em>Destination Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPin()
	 * @generated
	 * @ordered
	 */
	protected String destinationPin = DESTINATION_PIN_EDEFAULT;

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
	 * The default value of the '{@link #getDestinationName() <em>Destination Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationName()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovedOutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.MOVED_OUT;
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
	public String getDestinationPin() {
		return destinationPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinationPin(String newDestinationPin) {
		String oldDestinationPin = destinationPin;
		destinationPin = newDestinationPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MOVED_OUT__DESTINATION_PIN, oldDestinationPin, destinationPin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MOVED_OUT__URI, oldUri, uri));
	}


	private String resolvedDestinationName = null;
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDestinationName() {
		return resolvedDestinationName;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.impl.EventImpl#findPublisherName()
	 */
	@Override
	public String findPublisherName() {
		findDestinationName();
		return super.findPublisherName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Finds the name of the Destination Premises with the LocationService
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String findDestinationName() {
		String oldDestinationName = resolvedDestinationName;
		if(getUri()!=null && getUri().trim().length()>0){
			resolvedDestinationName=TrackerPlugin.getDefault().name(getUri());
		} else if(getDestinationPin()!=null){
			StringBuffer buf = new StringBuffer("urn:pin:");
			buf.append( getDestinationPin());
			resolvedDestinationName = TrackerPlugin.getDefault().name(buf.toString());
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this, Notification.SET, TrackerPackage.MOVED_OUT__DESTINATION_NAME, oldDestinationName, resolvedDestinationName));
		return resolvedDestinationName;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.MOVED_OUT__DESTINATION_PIN:
				return getDestinationPin();
			case TrackerPackage.MOVED_OUT__URI:
				return getUri();
			case TrackerPackage.MOVED_OUT__DESTINATION_NAME:
				return getDestinationName();
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
			case TrackerPackage.MOVED_OUT__DESTINATION_PIN:
				setDestinationPin((String)newValue);
				return;
			case TrackerPackage.MOVED_OUT__URI:
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
			case TrackerPackage.MOVED_OUT__DESTINATION_PIN:
				setDestinationPin(DESTINATION_PIN_EDEFAULT);
				return;
			case TrackerPackage.MOVED_OUT__URI:
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
			case TrackerPackage.MOVED_OUT__DESTINATION_PIN:
				return DESTINATION_PIN_EDEFAULT == null ? destinationPin != null : !DESTINATION_PIN_EDEFAULT.equals(destinationPin);
			case TrackerPackage.MOVED_OUT__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case TrackerPackage.MOVED_OUT__DESTINATION_NAME:
				return DESTINATION_NAME_EDEFAULT == null ? getDestinationName() != null : !DESTINATION_NAME_EDEFAULT.equals(getDestinationName());
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
		result.append(" (destinationPin: ");
		result.append(destinationPin);
		result.append(", uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //MovedOutImpl