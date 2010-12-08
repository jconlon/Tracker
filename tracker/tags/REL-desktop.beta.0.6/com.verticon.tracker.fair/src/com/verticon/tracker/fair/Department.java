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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Department#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Department#getClasses <em>Classes</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Department#getSuperintendents <em>Superintendents</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Department#getDivision <em>Division</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Department#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Department#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.fair.FairPackage#getDepartment()
 * @model
 * @generated
 */
public interface Department extends EObject {
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
	 * @see com.verticon.tracker.fair.FairPackage#getDepartment_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Department#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Class}.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.fair.Class#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getDepartment_Classes()
	 * @see com.verticon.tracker.fair.Class#getDepartment
	 * @model opposite="department" containment="true" required="true"
	 * @generated
	 */
	EList<com.verticon.tracker.fair.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Superintendents</b></em>' reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Superintendents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Superintendents</em>' reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getDepartment_Superintendents()
	 * @model
	 * @generated
	 */
	EList<Person> getSuperintendents();

	/**
	 * Returns the value of the '<em><b>Division</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.fair.Division#getDepartments <em>Departments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Division</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Division</em>' container reference.
	 * @see #setDivision(Division)
	 * @see com.verticon.tracker.fair.FairPackage#getDepartment_Division()
	 * @see com.verticon.tracker.fair.Division#getDepartments
	 * @model opposite="departments" required="true" transient="false"
	 * @generated
	 */
	Division getDivision();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Department#getDivision <em>Division</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Division</em>' container reference.
	 * @see #getDivision()
	 * @generated
	 */
	void setDivision(Division value);

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
	 * @see com.verticon.tracker.fair.FairPackage#getDepartment_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Department#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

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
	 * @see com.verticon.tracker.fair.FairPackage#getDepartment_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Department#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Department
