/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Orientation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Orientation#getAz <em>Az</em>}</li>
 *   <li>{@link com.verticon.tracker.Orientation#getPitch <em>Pitch</em>}</li>
 *   <li>{@link com.verticon.tracker.Orientation#getRoll <em>Roll</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getOrientation()
 * @model
 * @generated
 */
public interface Orientation extends SensorEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Az</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Az</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Az</em>' attribute.
	 * @see #setAz(double)
	 * @see com.verticon.tracker.TrackerPackage#getOrientation_Az()
	 * @model required="true"
	 * @generated
	 */
	double getAz();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Orientation#getAz <em>Az</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Az</em>' attribute.
	 * @see #getAz()
	 * @generated
	 */
	void setAz(double value);

	/**
	 * Returns the value of the '<em><b>Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pitch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch</em>' attribute.
	 * @see #setPitch(double)
	 * @see com.verticon.tracker.TrackerPackage#getOrientation_Pitch()
	 * @model required="true"
	 * @generated
	 */
	double getPitch();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Orientation#getPitch <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch</em>' attribute.
	 * @see #getPitch()
	 * @generated
	 */
	void setPitch(double value);

	/**
	 * Returns the value of the '<em><b>Roll</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roll</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roll</em>' attribute.
	 * @see #setRoll(double)
	 * @see com.verticon.tracker.TrackerPackage#getOrientation_Roll()
	 * @model required="true"
	 * @generated
	 */
	double getRoll();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Orientation#getRoll <em>Roll</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Roll</em>' attribute.
	 * @see #getRoll()
	 * @generated
	 */
	void setRoll(double value);

} // Orientation
