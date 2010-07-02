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
package com.verticon.tracker.fair;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Person#getFirstName <em>First Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getLastName <em>Last Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getPhone <em>Phone</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getStreet <em>Street</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getCity <em>City</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getState <em>State</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getZipCode <em>Zip Code</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getPin <em>Pin</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getSalesOrder <em>Sales Order</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getExhibitorNumber <em>Exhibitor Number</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Person#getEmail <em>Email</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.fair.FairPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_FirstName()
	 * @model required="true"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_LastName()
	 * @model required="true"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone</em>' attribute.
	 * @see #setPhone(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_Phone()
	 * @model dataType="com.verticon.tracker.fair.USTelephoneNumber"
	 * @generated
	 */
	String getPhone();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getPhone <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone</em>' attribute.
	 * @see #getPhone()
	 * @generated
	 */
	void setPhone(String value);

	/**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Street</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Street</em>' attribute.
	 * @see #setStreet(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_Street()
	 * @model
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #getStreet()
	 * @generated
	 */
	void setStreet(String value);

	/**
	 * Returns the value of the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>City</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>City</em>' attribute.
	 * @see #setCity(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_City()
	 * @model required="true"
	 * @generated
	 */
	String getCity();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @see #getCity()
	 * @generated
	 */
	void setCity(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #setState(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_State()
	 * @model required="true"
	 * @generated
	 */
	String getState();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #getState()
	 * @generated
	 */
	void setState(String value);

	/**
	 * Returns the value of the '<em><b>Zip Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zip Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zip Code</em>' attribute.
	 * @see #setZipCode(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_ZipCode()
	 * @model dataType="com.verticon.tracker.fair.ZipCode"
	 * @generated
	 */
	String getZipCode();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getZipCode <em>Zip Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zip Code</em>' attribute.
	 * @see #getZipCode()
	 * @generated
	 */
	void setZipCode(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_Name()
	 * @model id="true" required="true" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pin</em>' attribute.
	 * @see #isSetPin()
	 * @see #unsetPin()
	 * @see #setPin(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_Pin()
	 * @model unsettable="true" dataType="com.verticon.tracker.PremisesIdNumber"
	 * @generated
	 */
	String getPin();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getPin <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pin</em>' attribute.
	 * @see #isSetPin()
	 * @see #unsetPin()
	 * @see #getPin()
	 * @generated
	 */
	void setPin(String value);

	/**
	 * Unsets the value of the '{@link com.verticon.tracker.fair.Person#getPin <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPin()
	 * @see #getPin()
	 * @see #setPin(String)
	 * @generated
	 */
	void unsetPin();

	/**
	 * Returns whether the value of the '{@link com.verticon.tracker.fair.Person#getPin <em>Pin</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pin</em>' attribute is set.
	 * @see #unsetPin()
	 * @see #getPin()
	 * @see #setPin(String)
	 * @generated
	 */
	boolean isSetPin();

	/**
	 * Returns the value of the '<em><b>Sales Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sales Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sales Order</em>' attribute.
	 * @see #setSalesOrder(int)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_SalesOrder()
	 * @model
	 * @generated
	 */
	int getSalesOrder();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getSalesOrder <em>Sales Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sales Order</em>' attribute.
	 * @see #getSalesOrder()
	 * @generated
	 */
	void setSalesOrder(int value);

	/**
	 * Returns the value of the '<em><b>Exhibitor Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exhibitor Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exhibitor Number</em>' attribute.
	 * @see #setExhibitorNumber(int)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_ExhibitorNumber()
	 * @model
	 * @generated
	 */
	int getExhibitorNumber();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getExhibitorNumber <em>Exhibitor Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exhibitor Number</em>' attribute.
	 * @see #getExhibitorNumber()
	 * @generated
	 */
	void setExhibitorNumber(int value);

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see com.verticon.tracker.fair.FairPackage#getPerson_Email()
	 * @model dataType="com.verticon.tracker.Email"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Person#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

} // Person
