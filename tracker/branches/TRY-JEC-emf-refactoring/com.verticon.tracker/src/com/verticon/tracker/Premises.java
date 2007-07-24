/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Premises</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Premises#getPremisesId <em>Premises Id</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getEmailContact <em>Email Contact</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getAnimals <em>Animals</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getEventHistory <em>Event History</em>}</li>
 *   <li>{@link com.verticon.tracker.Premises#getUnAppliedTags <em>Un Applied Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getPremises()
 * @model
 * @generated
 */
public interface Premises extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Premises Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Premises Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Premises Id</em>' attribute.
	 * @see #setPremisesId(String)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_PremisesId()
	 * @model dataType="com.verticon.tracker.PremisesIdNumber" required="true"
	 * @generated
	 */
	String getPremisesId();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getPremisesId <em>Premises Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premises Id</em>' attribute.
	 * @see #getPremisesId()
	 * @generated
	 */
	void setPremisesId(String value);

	/**
	 * Returns the value of the '<em><b>Email Contact</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email Contact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email Contact</em>' attribute.
	 * @see #setEmailContact(String)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_EmailContact()
	 * @model default="" dataType="com.verticon.tracker.Email" required="true"
	 * @generated
	 */
	String getEmailContact();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getEmailContact <em>Email Contact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email Contact</em>' attribute.
	 * @see #getEmailContact()
	 * @generated
	 */
	void setEmailContact(String value);

	/**
	 * Returns the value of the '<em><b>Animals</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animals</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animals</em>' containment reference.
	 * @see #setAnimals(Animals)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_Animals()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Animals getAnimals();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getAnimals <em>Animals</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Animals</em>' containment reference.
	 * @see #getAnimals()
	 * @generated
	 */
	void setAnimals(Animals value);

	/**
	 * Returns the value of the '<em><b>Event History</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event History</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event History</em>' containment reference.
	 * @see #setEventHistory(EventHistory)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_EventHistory()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EventHistory getEventHistory();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getEventHistory <em>Event History</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event History</em>' containment reference.
	 * @see #getEventHistory()
	 * @generated
	 */
	void setEventHistory(EventHistory value);

	/**
	 * Returns the value of the '<em><b>Un Applied Tags</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Un Applied Tags</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Un Applied Tags</em>' containment reference.
	 * @see #setUnAppliedTags(UnAppliedTags)
	 * @see com.verticon.tracker.TrackerPackage#getPremises_UnAppliedTags()
	 * @model containment="true"
	 * @generated
	 */
	UnAppliedTags getUnAppliedTags();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Premises#getUnAppliedTags <em>Un Applied Tags</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Un Applied Tags</em>' containment reference.
	 * @see #getUnAppliedTags()
	 * @generated
	 */
	void setUnAppliedTags(UnAppliedTags value);

} // Premises