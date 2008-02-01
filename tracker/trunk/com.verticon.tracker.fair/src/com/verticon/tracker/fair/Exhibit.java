/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair;

import com.verticon.tracker.Animal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exhibit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getNumber <em>Number</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getAnimal <em>Animal</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getExhibitor <em>Exhibitor</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.fair.FairPackage#getExhibit()
 * @model
 * @generated
 */
public interface Exhibit extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

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
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

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
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Animal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal</em>' reference.
	 * @see #setAnimal(Animal)
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Animal()
	 * @model required="true"
	 * @generated
	 */
	Animal getAnimal();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getAnimal <em>Animal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Animal</em>' reference.
	 * @see #getAnimal()
	 * @generated
	 */
	void setAnimal(Animal value);

	/**
	 * Returns the value of the '<em><b>Exhibitor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exhibitor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exhibitor</em>' reference.
	 * @see #setExhibitor(Person)
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Exhibitor()
	 * @model required="true"
	 * @generated
	 */
	Person getExhibitor();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getExhibitor <em>Exhibitor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exhibitor</em>' reference.
	 * @see #getExhibitor()
	 * @generated
	 */
	void setExhibitor(Person value);

} // Exhibit
