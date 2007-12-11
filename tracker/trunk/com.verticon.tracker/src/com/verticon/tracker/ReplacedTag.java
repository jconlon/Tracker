/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replaced Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.ReplacedTag#getOldId <em>Old Id</em>}</li>
 *   <li>{@link com.verticon.tracker.ReplacedTag#isUsainNumberUsedForOldId <em>Usain Number Used For Old Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getReplacedTag()
 * @model
 * @generated
 */
public interface ReplacedTag extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Old Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Id</em>' attribute.
	 * @see #setOldId(String)
	 * @see com.verticon.tracker.TrackerPackage#getReplacedTag_OldId()
	 * @model required="true"
	 * @generated
	 */
	String getOldId();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.ReplacedTag#getOldId <em>Old Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Id</em>' attribute.
	 * @see #getOldId()
	 * @generated
	 */
	void setOldId(String value);

	/**
	 * Returns the value of the '<em><b>Usain Number Used For Old Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usain Number Used For Old Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usain Number Used For Old Id</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getReplacedTag_UsainNumberUsedForOldId()
	 * @model required="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isUsainNumberUsedForOldId();

} // ReplacedTag