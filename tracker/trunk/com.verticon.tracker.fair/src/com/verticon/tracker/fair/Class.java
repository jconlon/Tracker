/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Class#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Class#getLot <em>Lot</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Class#getJudge <em>Judge</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.fair.FairPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends EObject {
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
	 * @see com.verticon.tracker.fair.FairPackage#getClass_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Class#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Lot</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Lot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lot</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lot</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getClass_Lot()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Lot> getLot();

	/**
	 * Returns the value of the '<em><b>Judge</b></em>' reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Judge</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Judge</em>' reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getClass_Judge()
	 * @model required="true"
	 * @generated
	 */
	EList<Person> getJudge();

} // Class
