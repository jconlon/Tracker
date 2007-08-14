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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.verticon.tracker.AnimalId;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Animal Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.AnimalIdImpl#getIdNumber <em>Id Number</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalIdImpl#isUsainNumberUsed <em>Usain Number Used</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnimalIdImpl extends EObjectImpl implements AnimalId {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getIdNumber() <em>Id Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdNumber() <em>Id Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNumber()
	 * @generated
	 * @ordered
	 */
	protected String idNumber = ID_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #isUsainNumberUsed() <em>Usain Number Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsainNumberUsed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USAIN_NUMBER_USED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalIdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.ANIMAL_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdNumber(String newIdNumber) {
		String oldIdNumber = idNumber;
		idNumber = newIdNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL_ID__ID_NUMBER, oldIdNumber, idNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 3 Numeric 840
	 * 12 Numeric 123, 456,789,012 Start number > 2,000,000,000
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isUsainNumberUsed() {
		if(idNumber==null){
			return false;
		}
		if(!idNumber.startsWith("840")){
			return false;
		}
		long lastPart = Long.parseLong(idNumber.substring(3));
		
		return lastPart > 2000000000;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.ANIMAL_ID__ID_NUMBER:
				return getIdNumber();
			case TrackerPackage.ANIMAL_ID__USAIN_NUMBER_USED:
				return isUsainNumberUsed() ? Boolean.TRUE : Boolean.FALSE;
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
			case TrackerPackage.ANIMAL_ID__ID_NUMBER:
				setIdNumber((String)newValue);
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
			case TrackerPackage.ANIMAL_ID__ID_NUMBER:
				setIdNumber(ID_NUMBER_EDEFAULT);
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
			case TrackerPackage.ANIMAL_ID__ID_NUMBER:
				return ID_NUMBER_EDEFAULT == null ? idNumber != null : !ID_NUMBER_EDEFAULT.equals(idNumber);
			case TrackerPackage.ANIMAL_ID__USAIN_NUMBER_USED:
				return isUsainNumberUsed() != USAIN_NUMBER_USED_EDEFAULT;
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
		result.append(" (idNumber: ");
		result.append(idNumber);
		result.append(')');
		return result.toString();
	}

} //AnimalIdImpl