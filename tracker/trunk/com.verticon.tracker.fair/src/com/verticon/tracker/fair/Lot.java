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
 * A representation of the model object '<em><b>Lot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Lot#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Lot#getExhibits <em>Exhibits</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Lot#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.fair.FairPackage#getLot()
 * @model
 * @generated
 */
public interface Lot extends EObject {
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
	 * @see com.verticon.tracker.fair.FairPackage#getLot_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Lot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Exhibits</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Exhibit}.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.fair.Exhibit#getLot <em>Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exhibits</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exhibits</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getLot_Exhibits()
	 * @see com.verticon.tracker.fair.Exhibit#getLot
	 * @model opposite="lot" containment="true" required="true"
	 * @generated
	 */
	EList<Exhibit> getExhibits();

	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.fair.Class#getLots <em>Lots</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass(com.verticon.tracker.fair.Class)
	 * @see com.verticon.tracker.fair.FairPackage#getLot_Class()
	 * @see com.verticon.tracker.fair.Class#getLots
	 * @model opposite="lots" required="true" transient="false"
	 * @generated
	 */
	com.verticon.tracker.fair.Class getClass_();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Lot#getClass_ <em>Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(com.verticon.tracker.fair.Class value);

} // Lot
