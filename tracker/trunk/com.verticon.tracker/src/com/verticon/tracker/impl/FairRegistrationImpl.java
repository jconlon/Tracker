/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.TrackerPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fair Registration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.FairRegistrationImpl#getParticipant <em>Participant</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.FairRegistrationImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.FairRegistrationImpl#getPhone <em>Phone</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.FairRegistrationImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.FairRegistrationImpl#getClub <em>Club</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FairRegistrationImpl extends EventImpl implements FairRegistration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getParticipant() <em>Participant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipant()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTICIPANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParticipant() <em>Participant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipant()
	 * @generated
	 * @ordered
	 */
	protected String participant = PARTICIPANT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhone() <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhone()
	 * @generated
	 * @ordered
	 */
	protected static final String PHONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhone() <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhone()
	 * @generated
	 * @ordered
	 */
	protected String phone = PHONE_EDEFAULT;

	/**
	 * The default value of the '{@link #getParent() <em>Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected String parent = PARENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getClub() <em>Club</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClub()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClub() <em>Club</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClub()
	 * @generated
	 * @ordered
	 */
	protected String club = CLUB_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FairRegistrationImpl() {
		super();
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
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.FAIR_REGISTRATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParticipant() {
		return participant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParticipant(String newParticipant) {
		String oldParticipant = participant;
		participant = newParticipant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.FAIR_REGISTRATION__PARTICIPANT, oldParticipant, participant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.FAIR_REGISTRATION__ADDRESS, oldAddress, address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhone(String newPhone) {
		String oldPhone = phone;
		phone = newPhone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.FAIR_REGISTRATION__PHONE, oldPhone, phone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(String newParent) {
		String oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.FAIR_REGISTRATION__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClub() {
		return club;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClub(String newClub) {
		String oldClub = club;
		club = newClub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.FAIR_REGISTRATION__CLUB, oldClub, club));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.FAIR_REGISTRATION__PARTICIPANT:
				return getParticipant();
			case TrackerPackage.FAIR_REGISTRATION__ADDRESS:
				return getAddress();
			case TrackerPackage.FAIR_REGISTRATION__PHONE:
				return getPhone();
			case TrackerPackage.FAIR_REGISTRATION__PARENT:
				return getParent();
			case TrackerPackage.FAIR_REGISTRATION__CLUB:
				return getClub();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.FAIR_REGISTRATION__PARTICIPANT:
				setParticipant((String)newValue);
				return;
			case TrackerPackage.FAIR_REGISTRATION__ADDRESS:
				setAddress((String)newValue);
				return;
			case TrackerPackage.FAIR_REGISTRATION__PHONE:
				setPhone((String)newValue);
				return;
			case TrackerPackage.FAIR_REGISTRATION__PARENT:
				setParent((String)newValue);
				return;
			case TrackerPackage.FAIR_REGISTRATION__CLUB:
				setClub((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.FAIR_REGISTRATION__PARTICIPANT:
				setParticipant(PARTICIPANT_EDEFAULT);
				return;
			case TrackerPackage.FAIR_REGISTRATION__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case TrackerPackage.FAIR_REGISTRATION__PHONE:
				setPhone(PHONE_EDEFAULT);
				return;
			case TrackerPackage.FAIR_REGISTRATION__PARENT:
				setParent(PARENT_EDEFAULT);
				return;
			case TrackerPackage.FAIR_REGISTRATION__CLUB:
				setClub(CLUB_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.FAIR_REGISTRATION__PARTICIPANT:
				return PARTICIPANT_EDEFAULT == null ? participant != null : !PARTICIPANT_EDEFAULT.equals(participant);
			case TrackerPackage.FAIR_REGISTRATION__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case TrackerPackage.FAIR_REGISTRATION__PHONE:
				return PHONE_EDEFAULT == null ? phone != null : !PHONE_EDEFAULT.equals(phone);
			case TrackerPackage.FAIR_REGISTRATION__PARENT:
				return PARENT_EDEFAULT == null ? parent != null : !PARENT_EDEFAULT.equals(parent);
			case TrackerPackage.FAIR_REGISTRATION__CLUB:
				return CLUB_EDEFAULT == null ? club != null : !CLUB_EDEFAULT.equals(club);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (participant: ");
		result.append(participant);
		result.append(", address: ");
		result.append(address);
		result.append(", phone: ");
		result.append(phone);
		result.append(", parent: ");
		result.append(parent);
		result.append(", club: ");
		result.append(club);
		result.append(')');
		return result.toString();
	}

} //FairRegistrationImpl