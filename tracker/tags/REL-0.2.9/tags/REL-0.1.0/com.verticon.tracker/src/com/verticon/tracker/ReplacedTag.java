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
 *   <li>{@link com.verticon.tracker.ReplacedTag#getOldAin <em>Old Ain</em>}</li>
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
	 * Returns the value of the '<em><b>Old Ain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Ain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tracker.ecore is the metaModel for Tracker, a NAIS base animal event management framework.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Old Ain</em>' attribute.
	 * @see #setOldAin(String)
	 * @see com.verticon.tracker.TrackerPackage#getReplacedTag_OldAin()
	 * @model dataType="com.verticon.tracker.AnimialIdNumber" required="true"
	 *        annotation="http://www.topcased.org/documentation documentation='Tracker.ecore is the metaModel for Tracker, a NAIS base animal event management framework.'"
	 * @generated
	 */
	String getOldAin();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.ReplacedTag#getOldAin <em>Old Ain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Ain</em>' attribute.
	 * @see #getOldAin()
	 * @generated
	 */
	void setOldAin(String value);

} // ReplacedTag