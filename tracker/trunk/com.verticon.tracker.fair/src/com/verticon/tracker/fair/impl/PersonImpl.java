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
package com.verticon.tracker.fair.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getPhone <em>Phone</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getCity <em>City</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getState <em>State</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getZipCode <em>Zip Code</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getPin <em>Pin</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getSalesOrder <em>Sales Order</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getExhibitorNumber <em>Exhibitor Number</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.PersonImpl#getEmail <em>Email</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends MinimalEObjectImpl.Container implements Person {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected String lastName = LAST_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected String street = STREET_EDEFAULT;

	/**
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected static final String CITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected String city = CITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected String state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getZipCode() <em>Zip Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZipCode()
	 * @generated
	 * @ordered
	 */
	protected static final String ZIP_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZipCode() <em>Zip Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZipCode()
	 * @generated
	 * @ordered
	 */
	protected String zipCode = ZIP_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected String comments = COMMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPin() <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPin()
	 * @generated
	 * @ordered
	 */
	protected static final String PIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPin() <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPin()
	 * @generated
	 * @ordered
	 */
	protected String pin = PIN_EDEFAULT;

	/**
	 * This is true if the Pin attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean pinESet;

	/**
	 * The default value of the '{@link #getSalesOrder() <em>Sales Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalesOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int SALES_ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSalesOrder() <em>Sales Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalesOrder()
	 * @generated
	 * @ordered
	 */
	protected int salesOrder = SALES_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getExhibitorNumber() <em>Exhibitor Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExhibitorNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int EXHIBITOR_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getExhibitorNumber() <em>Exhibitor Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExhibitorNumber()
	 * @generated
	 * @ordered
	 */
	protected int exhibitorNumber = EXHIBITOR_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FairPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastName(String newLastName) {
		String oldLastName = lastName;
		lastName = newLastName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__LAST_NAME, oldLastName, lastName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__PHONE, oldPhone, phone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__STREET, oldStreet, street));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCity(String newCity) {
		String oldCity = city;
		city = newCity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__CITY, oldCity, city));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(String newState) {
		String oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZipCode(String newZipCode) {
		String oldZipCode = zipCode;
		zipCode = newZipCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__ZIP_CODE, oldZipCode, zipCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Concatination of firstName and lastName
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		String name = "";
		if(firstName == null && lastName == null){
			name = "Unspecified";
		}else{
			if(firstName !=null){
				name = firstName;
				if(lastName !=null){
					name = lastName+','+name;
				}
			}else{
				name = lastName;
			}
			
		}
			
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Name is an ID that will be used to reference Person from other resources, 
	 * but it is also derived.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(String newName) {
		//NOOP
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(String newComments) {
		String oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPin(String newPin) {
		String oldPin = pin;
		pin = newPin;
		boolean oldPinESet = pinESet;
		pinESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__PIN, oldPin, pin, !oldPinESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPin() {
		String oldPin = pin;
		boolean oldPinESet = pinESet;
		pin = PIN_EDEFAULT;
		pinESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FairPackage.PERSON__PIN, oldPin, PIN_EDEFAULT, oldPinESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPin() {
		return pinESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSalesOrder() {
		return salesOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalesOrder(int newSalesOrder) {
		int oldSalesOrder = salesOrder;
		salesOrder = newSalesOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__SALES_ORDER, oldSalesOrder, salesOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getExhibitorNumber() {
		return exhibitorNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExhibitorNumber(int newExhibitorNumber) {
		int oldExhibitorNumber = exhibitorNumber;
		exhibitorNumber = newExhibitorNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__EXHIBITOR_NUMBER, oldExhibitorNumber, exhibitorNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.PERSON__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FairPackage.PERSON__FIRST_NAME:
				return getFirstName();
			case FairPackage.PERSON__LAST_NAME:
				return getLastName();
			case FairPackage.PERSON__PHONE:
				return getPhone();
			case FairPackage.PERSON__STREET:
				return getStreet();
			case FairPackage.PERSON__CITY:
				return getCity();
			case FairPackage.PERSON__STATE:
				return getState();
			case FairPackage.PERSON__ZIP_CODE:
				return getZipCode();
			case FairPackage.PERSON__NAME:
				return getName();
			case FairPackage.PERSON__COMMENTS:
				return getComments();
			case FairPackage.PERSON__PIN:
				return getPin();
			case FairPackage.PERSON__SALES_ORDER:
				return getSalesOrder();
			case FairPackage.PERSON__EXHIBITOR_NUMBER:
				return getExhibitorNumber();
			case FairPackage.PERSON__EMAIL:
				return getEmail();
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
			case FairPackage.PERSON__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case FairPackage.PERSON__LAST_NAME:
				setLastName((String)newValue);
				return;
			case FairPackage.PERSON__PHONE:
				setPhone((String)newValue);
				return;
			case FairPackage.PERSON__STREET:
				setStreet((String)newValue);
				return;
			case FairPackage.PERSON__CITY:
				setCity((String)newValue);
				return;
			case FairPackage.PERSON__STATE:
				setState((String)newValue);
				return;
			case FairPackage.PERSON__ZIP_CODE:
				setZipCode((String)newValue);
				return;
			case FairPackage.PERSON__NAME:
				setName((String)newValue);
				return;
			case FairPackage.PERSON__COMMENTS:
				setComments((String)newValue);
				return;
			case FairPackage.PERSON__PIN:
				setPin((String)newValue);
				return;
			case FairPackage.PERSON__SALES_ORDER:
				setSalesOrder((Integer)newValue);
				return;
			case FairPackage.PERSON__EXHIBITOR_NUMBER:
				setExhibitorNumber((Integer)newValue);
				return;
			case FairPackage.PERSON__EMAIL:
				setEmail((String)newValue);
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
			case FairPackage.PERSON__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case FairPackage.PERSON__LAST_NAME:
				setLastName(LAST_NAME_EDEFAULT);
				return;
			case FairPackage.PERSON__PHONE:
				setPhone(PHONE_EDEFAULT);
				return;
			case FairPackage.PERSON__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case FairPackage.PERSON__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case FairPackage.PERSON__STATE:
				setState(STATE_EDEFAULT);
				return;
			case FairPackage.PERSON__ZIP_CODE:
				setZipCode(ZIP_CODE_EDEFAULT);
				return;
			case FairPackage.PERSON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FairPackage.PERSON__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case FairPackage.PERSON__PIN:
				unsetPin();
				return;
			case FairPackage.PERSON__SALES_ORDER:
				setSalesOrder(SALES_ORDER_EDEFAULT);
				return;
			case FairPackage.PERSON__EXHIBITOR_NUMBER:
				setExhibitorNumber(EXHIBITOR_NUMBER_EDEFAULT);
				return;
			case FairPackage.PERSON__EMAIL:
				setEmail(EMAIL_EDEFAULT);
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
			case FairPackage.PERSON__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case FairPackage.PERSON__LAST_NAME:
				return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
			case FairPackage.PERSON__PHONE:
				return PHONE_EDEFAULT == null ? phone != null : !PHONE_EDEFAULT.equals(phone);
			case FairPackage.PERSON__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case FairPackage.PERSON__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case FairPackage.PERSON__STATE:
				return STATE_EDEFAULT == null ? state != null : !STATE_EDEFAULT.equals(state);
			case FairPackage.PERSON__ZIP_CODE:
				return ZIP_CODE_EDEFAULT == null ? zipCode != null : !ZIP_CODE_EDEFAULT.equals(zipCode);
			case FairPackage.PERSON__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case FairPackage.PERSON__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case FairPackage.PERSON__PIN:
				return isSetPin();
			case FairPackage.PERSON__SALES_ORDER:
				return salesOrder != SALES_ORDER_EDEFAULT;
			case FairPackage.PERSON__EXHIBITOR_NUMBER:
				return exhibitorNumber != EXHIBITOR_NUMBER_EDEFAULT;
			case FairPackage.PERSON__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
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
		result.append(" (firstName: ");
		result.append(firstName);
		result.append(", lastName: ");
		result.append(lastName);
		result.append(", phone: ");
		result.append(phone);
		result.append(", street: ");
		result.append(street);
		result.append(", city: ");
		result.append(city);
		result.append(", state: ");
		result.append(state);
		result.append(", zipCode: ");
		result.append(zipCode);
		result.append(", comments: ");
		result.append(comments);
		result.append(", pin: ");
		if (pinESet) result.append(pin); else result.append("<unset>");
		result.append(", salesOrder: ");
		result.append(salesOrder);
		result.append(", exhibitorNumber: ");
		result.append(exhibitorNumber);
		result.append(", email: ");
		result.append(email);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
