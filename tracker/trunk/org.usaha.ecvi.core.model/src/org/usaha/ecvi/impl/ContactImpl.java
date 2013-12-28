/**
 */
package org.usaha.ecvi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.usaha.ecvi.Address;
import org.usaha.ecvi.Contact;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.Person;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.ContactImpl#getPremId <em>Prem Id</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.ContactImpl#getPremName <em>Prem Name</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.ContactImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.ContactImpl#getPerson <em>Person</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContactImpl extends MinimalEObjectImpl.Container implements Contact {
	/**
	 * The default value of the '{@link #getPremId() <em>Prem Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremId()
	 * @generated
	 * @ordered
	 */
	protected static final String PREM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremId() <em>Prem Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremId()
	 * @generated
	 * @ordered
	 */
	protected String premId = PREM_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPremName() <em>Prem Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremName()
	 * @generated
	 * @ordered
	 */
	protected static final String PREM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremName() <em>Prem Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremName()
	 * @generated
	 * @ordered
	 */
	protected String premName = PREM_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected Address address;

	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> person;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.CONTACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPremId() {
		return premId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremId(String newPremId) {
		String oldPremId = premId;
		premId = newPremId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.CONTACT__PREM_ID, oldPremId, premId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPremName() {
		return premName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremName(String newPremName) {
		String oldPremName = premName;
		premName = newPremName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.CONTACT__PREM_NAME, oldPremName, premName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddress(Address newAddress, NotificationChain msgs) {
		Address oldAddress = address;
		address = newAddress;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.CONTACT__ADDRESS, oldAddress, newAddress);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(Address newAddress) {
		if (newAddress != address) {
			NotificationChain msgs = null;
			if (address != null)
				msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.CONTACT__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject)newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.CONTACT__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.CONTACT__ADDRESS, newAddress, newAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getPerson() {
		if (person == null) {
			person = new EObjectContainmentEList<Person>(Person.class, this, EcviPackage.CONTACT__PERSON);
		}
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcviPackage.CONTACT__ADDRESS:
				return basicSetAddress(null, msgs);
			case EcviPackage.CONTACT__PERSON:
				return ((InternalEList<?>)getPerson()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcviPackage.CONTACT__PREM_ID:
				return getPremId();
			case EcviPackage.CONTACT__PREM_NAME:
				return getPremName();
			case EcviPackage.CONTACT__ADDRESS:
				return getAddress();
			case EcviPackage.CONTACT__PERSON:
				return getPerson();
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
			case EcviPackage.CONTACT__PREM_ID:
				setPremId((String)newValue);
				return;
			case EcviPackage.CONTACT__PREM_NAME:
				setPremName((String)newValue);
				return;
			case EcviPackage.CONTACT__ADDRESS:
				setAddress((Address)newValue);
				return;
			case EcviPackage.CONTACT__PERSON:
				getPerson().clear();
				getPerson().addAll((Collection<? extends Person>)newValue);
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
			case EcviPackage.CONTACT__PREM_ID:
				setPremId(PREM_ID_EDEFAULT);
				return;
			case EcviPackage.CONTACT__PREM_NAME:
				setPremName(PREM_NAME_EDEFAULT);
				return;
			case EcviPackage.CONTACT__ADDRESS:
				setAddress((Address)null);
				return;
			case EcviPackage.CONTACT__PERSON:
				getPerson().clear();
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
			case EcviPackage.CONTACT__PREM_ID:
				return PREM_ID_EDEFAULT == null ? premId != null : !PREM_ID_EDEFAULT.equals(premId);
			case EcviPackage.CONTACT__PREM_NAME:
				return PREM_NAME_EDEFAULT == null ? premName != null : !PREM_NAME_EDEFAULT.equals(premName);
			case EcviPackage.CONTACT__ADDRESS:
				return address != null;
			case EcviPackage.CONTACT__PERSON:
				return person != null && !person.isEmpty();
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
		result.append(" (premId: ");
		result.append(premId);
		result.append(", premName: ");
		result.append(premName);
		result.append(')');
		return result.toString();
	}

} //ContactImpl
