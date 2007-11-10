/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair;

import com.verticon.tracker.Premises;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Fair#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getExhibitors <em>Exhibitors</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getClubs <em>Clubs</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getDivisions <em>Divisions</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getPremises <em>Premises</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.fair.FairPackage#getFair()
 * @model
 * @generated
 */
public interface Fair extends EObject {
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
	 * @see com.verticon.tracker.fair.FairPackage#getFair_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Fair#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Exhibitors</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Exhibitor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exhibitors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exhibitors</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getFair_Exhibitors()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Exhibitor> getExhibitors();

	/**
	 * Returns the value of the '<em><b>Clubs</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.YouthClub}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clubs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clubs</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getFair_Clubs()
	 * @model containment="true"
	 * @generated
	 */
	EList<YouthClub> getClubs();

	/**
	 * Returns the value of the '<em><b>Divisions</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Division}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Divisions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Divisions</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getFair_Divisions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Division> getDivisions();

	/**
	 * Returns the value of the '<em><b>Premises</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Premises</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Premises</em>' reference.
	 * @see #setPremises(Premises)
	 * @see com.verticon.tracker.fair.FairPackage#getFair_Premises()
	 * @model required="true"
	 * @generated
	 */
	Premises getPremises();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Fair#getPremises <em>Premises</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premises</em>' reference.
	 * @see #getPremises()
	 * @generated
	 */
	void setPremises(Premises value);

} // Fair
