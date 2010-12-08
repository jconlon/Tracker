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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.Premises;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Fair#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getYouthClubs <em>Youth Clubs</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getDivisions <em>Divisions</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getPremises <em>Premises</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getPeople <em>People</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Fair#getComments <em>Comments</em>}</li>
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
	 * Returns the value of the '<em><b>Youth Clubs</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.YouthClub}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Youth Clubs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Youth Clubs</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getFair_YouthClubs()
	 * @model containment="true"
	 * @generated
	 */
	EList<YouthClub> getYouthClubs();

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

	/**
	 * Returns the value of the '<em><b>People</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>People</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>People</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getFair_People()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getPeople();

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
	 * @see com.verticon.tracker.fair.FairPackage#getFair_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Fair#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Exhibit> exhibits();

} // Fair
