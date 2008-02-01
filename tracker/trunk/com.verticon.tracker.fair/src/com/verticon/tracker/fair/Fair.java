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
 *   <li>{@link com.verticon.tracker.fair.Fair#getYouthClub <em>Youth Club</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getDivision <em>Division</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getPremises <em>Premises</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getPeople <em>People</em>}</li>
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
	 * Returns the value of the '<em><b>Youth Club</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.YouthClub}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Youth Club</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Youth Club</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getFair_YouthClub()
	 * @model containment="true"
	 * @generated
	 */
	EList<YouthClub> getYouthClub();

	/**
	 * Returns the value of the '<em><b>Division</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Division}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Division</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Division</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getFair_Division()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Division> getDivision();

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

	/**
	 * Returns the value of the '<em><b>People</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>People</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>People</em>' containment reference.
	 * @see #setPeople(People)
	 * @see com.verticon.tracker.fair.FairPackage#getFair_People()
	 * @model containment="true"
	 * @generated
	 */
	People getPeople();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Fair#getPeople <em>People</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>People</em>' containment reference.
	 * @see #getPeople()
	 * @generated
	 */
	void setPeople(People value);

} // Fair
