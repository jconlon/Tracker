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
 *   <li>{@link com.verticon.tracker.fair.Class#getLots <em>Lots</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Class#getJudges <em>Judges</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Class#getDepartment <em>Department</em>}</li>
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
	 * Returns the value of the '<em><b>Lots</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Lot}.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.fair.Lot#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lots</em>' containment reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getClass_Lots()
	 * @see com.verticon.tracker.fair.Lot#getClass_
	 * @model opposite="class" containment="true" required="true"
	 * @generated
	 */
	EList<Lot> getLots();

	/**
	 * Returns the value of the '<em><b>Judges</b></em>' reference list.
	 * The list contents are of type {@link com.verticon.tracker.fair.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Judges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Judges</em>' reference list.
	 * @see com.verticon.tracker.fair.FairPackage#getClass_Judges()
	 * @model required="true"
	 * @generated
	 */
	EList<Person> getJudges();

	/**
	 * Returns the value of the '<em><b>Department</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.fair.Department#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Department</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Department</em>' container reference.
	 * @see #setDepartment(Department)
	 * @see com.verticon.tracker.fair.FairPackage#getClass_Department()
	 * @see com.verticon.tracker.fair.Department#getClasses
	 * @model opposite="classes" required="true" transient="false"
	 * @generated
	 */
	Department getDepartment();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Class#getDepartment <em>Department</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department</em>' container reference.
	 * @see #getDepartment()
	 * @generated
	 */
	void setDepartment(Department value);

} // Class
