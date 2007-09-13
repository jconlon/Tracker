/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fair Registration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.FairRegistration#getParticipant <em>Participant</em>}</li>
 *   <li>{@link com.verticon.tracker.FairRegistration#getAddress <em>Address</em>}</li>
 *   <li>{@link com.verticon.tracker.FairRegistration#getPhone <em>Phone</em>}</li>
 *   <li>{@link com.verticon.tracker.FairRegistration#getParent <em>Parent</em>}</li>
 *   <li>{@link com.verticon.tracker.FairRegistration#getClub <em>Club</em>}</li>
 *   <li>{@link com.verticon.tracker.FairRegistration#getSaleOrder <em>Sale Order</em>}</li>
 *   <li>{@link com.verticon.tracker.FairRegistration#getExhibit <em>Exhibit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getFairRegistration()
 * @model
 * @generated
 */
public interface FairRegistration extends Event {
	
	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 101;
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Participant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant</em>' attribute.
	 * @see #setParticipant(String)
	 * @see com.verticon.tracker.TrackerPackage#getFairRegistration_Participant()
	 * @model required="true"
	 * @generated
	 */
	String getParticipant();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.FairRegistration#getParticipant <em>Participant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Participant</em>' attribute.
	 * @see #getParticipant()
	 * @generated
	 */
	void setParticipant(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see com.verticon.tracker.TrackerPackage#getFairRegistration_Address()
	 * @model required="true"
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.FairRegistration#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

	/**
	 * Returns the value of the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone</em>' attribute.
	 * @see #setPhone(String)
	 * @see com.verticon.tracker.TrackerPackage#getFairRegistration_Phone()
	 * @model dataType="com.verticon.tracker.USPhoneNumber" required="true"
	 * @generated
	 */
	String getPhone();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.FairRegistration#getPhone <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone</em>' attribute.
	 * @see #getPhone()
	 * @generated
	 */
	void setPhone(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' attribute.
	 * @see #setParent(String)
	 * @see com.verticon.tracker.TrackerPackage#getFairRegistration_Parent()
	 * @model
	 * @generated
	 */
	String getParent();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.FairRegistration#getParent <em>Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' attribute.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(String value);

	/**
	 * Returns the value of the '<em><b>Club</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Club</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Club</em>' attribute.
	 * @see #setClub(String)
	 * @see com.verticon.tracker.TrackerPackage#getFairRegistration_Club()
	 * @model
	 * @generated
	 */
	String getClub();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.FairRegistration#getClub <em>Club</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Club</em>' attribute.
	 * @see #getClub()
	 * @generated
	 */
	void setClub(String value);

	/**
	 * Returns the value of the '<em><b>Sale Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sale Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sale Order</em>' attribute.
	 * @see #setSaleOrder(int)
	 * @see com.verticon.tracker.TrackerPackage#getFairRegistration_SaleOrder()
	 * @model
	 * @generated
	 */
	int getSaleOrder();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.FairRegistration#getSaleOrder <em>Sale Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sale Order</em>' attribute.
	 * @see #getSaleOrder()
	 * @generated
	 */
	void setSaleOrder(int value);

	/**
	 * Returns the value of the '<em><b>Exhibit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exhibit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exhibit</em>' attribute.
	 * @see #setExhibit(int)
	 * @see com.verticon.tracker.TrackerPackage#getFairRegistration_Exhibit()
	 * @model
	 * @generated
	 */
	int getExhibit();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.FairRegistration#getExhibit <em>Exhibit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exhibit</em>' attribute.
	 * @see #getExhibit()
	 * @generated
	 */
	void setExhibit(int value);

} // FairRegistration