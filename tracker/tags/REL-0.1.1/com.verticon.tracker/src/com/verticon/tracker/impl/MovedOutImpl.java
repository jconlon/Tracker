/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.tracker.MovedOut;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Moved Out</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.MovedOutImpl#getDestinationPin <em>Destination Pin</em>}</li>
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.MOVED_OUT__DESTINATION_PIN:
				return getDestinationPin();
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
		result.append(')');
		return result.toString();
	}

} //MovedOutImpl