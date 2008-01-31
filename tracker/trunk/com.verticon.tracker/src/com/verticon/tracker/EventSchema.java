/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.EventSchema#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.EventSchema#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.tracker.EventSchema#getAnimalType <em>Animal Type</em>}</li>
 *   <li>{@link com.verticon.tracker.EventSchema#getEventAttributes <em>Event Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getEventSchema()
 * @model
 * @generated
 */
public interface EventSchema extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

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
	 * @see com.verticon.tracker.TrackerPackage#getEventSchema_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.EventSchema#getName <em>Name</em>}' attribute.
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
	 * @see com.verticon.tracker.TrackerPackage#getEventSchema_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.EventSchema#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Animal Type</b></em>' attribute list.
	 * The list contents are of type {@link com.verticon.tracker.AnimalType}.
	 * The literals are from the enumeration {@link com.verticon.tracker.AnimalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal Type</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal Type</em>' attribute list.
	 * @see com.verticon.tracker.AnimalType
	 * @see com.verticon.tracker.TrackerPackage#getEventSchema_AnimalType()
	 * @model
	 * @generated
	 */
	EList<AnimalType> getAnimalType();

	/**
	 * Returns the value of the '<em><b>Event Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.EventAttributeSchema}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Attributes</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getEventSchema_EventAttributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EventAttributeSchema> getEventAttributes();

} // EventSchema
