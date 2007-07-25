/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animal Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.AnimalId#getIdNumber <em>Id Number</em>}</li>
 *   <li>{@link com.verticon.tracker.AnimalId#isUsainNumberUsed <em>Usain Number Used</em>}</li>
 *   <li>{@link com.verticon.tracker.AnimalId#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getAnimalId()
 * @model
 * @generated
 */
public interface AnimalId extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Id Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Number</em>' attribute.
	 * @see #setIdNumber(String)
	 * @see com.verticon.tracker.TrackerPackage#getAnimalId_IdNumber()
	 * @model id="true" dataType="com.verticon.tracker.AnimialIdNumber" required="true"
	 * @generated
	 */
	String getIdNumber();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.AnimalId#getIdNumber <em>Id Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Number</em>' attribute.
	 * @see #getIdNumber()
	 * @generated
	 */
	void setIdNumber(String value);

	/**
	 * Returns the value of the '<em><b>Usain Number Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usain Number Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usain Number Used</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimalId_UsainNumberUsed()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isUsainNumberUsed();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.Event}.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.Event#getAnimalId <em>Animal Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getAnimalId_Events()
	 * @see com.verticon.tracker.Event#getAnimalId
	 * @model opposite="animalId" containment="true" required="true"
	 * @generated
	 */
	EList<Event> getEvents();

} // AnimalId