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
package com.verticon.tracker;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Premises</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Premises#getPremisesId <em>Premises Id</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getEmailContact <em>Email Contact</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getAnimals <em>Animals</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getUnAppliedTags <em>Un Applied Tags</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getUri <em>Uri</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getPolicy <em>Policy</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getAdministrator <em>Administrator</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getPremises()
 * @model
 * @generated
 */
public interface Premises extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Premises Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Premises Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Premises Id</em>' attribute.
	 * @see #setPremisesId(String)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_PremisesId()
	 * @model dataType="com.verticon.tracker.PremisesIdNumber"
	 * @generated
	 */
	String getPremisesId();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getPremisesId <em>Premises Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premises Id</em>' attribute.
	 * @see #getPremisesId()
	 * @generated
	 */
	void setPremisesId(String value);

	/**
	 * Returns the value of the '<em><b>Email Contact</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email Contact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email Contact</em>' attribute.
	 * @see #setEmailContact(String)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_EmailContact()
	 * @model default="" dataType="com.verticon.tracker.Email" required="true"
	 * @generated
	 */
	String getEmailContact();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getEmailContact <em>Email Contact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email Contact</em>' attribute.
	 * @see #getEmailContact()
	 * @generated
	 */
	void setEmailContact(String value);

	/**
	 * Returns the value of the '<em><b>Animals</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.Animal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animals</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animals</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getPremises_Animals()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Animal> getAnimals();

	/**
	 * Returns the value of the '<em><b>Un Applied Tags</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.Tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Un Applied Tags</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Un Applied Tags</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getPremises_UnAppliedTags()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Tag> getUnAppliedTags();

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_Uri()
	 * @model id="true" dataType="com.verticon.tracker.URI" required="true"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

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
	 * @see com.verticon.tracker.TrackerPackage#getPremises_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Number</em>' attribute.
	 * @see #setPhoneNumber(String)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_PhoneNumber()
	 * @model dataType="com.verticon.tracker.USPhoneNumber"
	 * @generated
	 */
	String getPhoneNumber();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getPhoneNumber <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone Number</em>' attribute.
	 * @see #getPhoneNumber()
	 * @generated
	 */
	void setPhoneNumber(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getPremises_Address()
	 * @model default="" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getAddress();

	/**
	 * Returns the value of the '<em><b>Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy</em>' containment reference.
	 * @see #setPolicy(Policy)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_Policy()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Policy getPolicy();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getPolicy <em>Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy</em>' containment reference.
	 * @see #getPolicy()
	 * @generated
	 */
	void setPolicy(Policy value);

	/**
	 * Returns the value of the '<em><b>Administrator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Administrator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Administrator</em>' attribute.
	 * @see #setAdministrator(String)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_Administrator()
	 * @model
	 * @generated
	 */
	String getAdministrator();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getAdministrator <em>Administrator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Administrator</em>' attribute.
	 * @see #getAdministrator()
	 * @generated
	 */
	void setAdministrator(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Event> eventHistory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Animal findAnimal(String id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ainsMany="false"
	 * @generated
	 */
	void addTemplate(EList<String> ains, Animal animalTemplate);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" ocdIdDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(getPolicy()!=null){\n\treturn getPolicy().canContain( eventType,  ocdId,  animalType);\n}\nreturn Boolean.TRUE;'"
	 * @generated
	 */
	boolean canContain(EventType eventType, String ocdId, AnimalType animalType);

} // Premises