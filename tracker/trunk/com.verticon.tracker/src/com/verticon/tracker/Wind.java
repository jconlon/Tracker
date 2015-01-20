/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Wind#getM_s <em>Ms</em>}</li>
 *   <li>{@link com.verticon.tracker.Wind#getMph <em>Mph</em>}</li>
 *   <li>{@link com.verticon.tracker.Wind#getR <em>R</em>}</li>
 *   <li>{@link com.verticon.tracker.Wind#getDegrees <em>Degrees</em>}</li>
 *   <li>{@link com.verticon.tracker.Wind#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getWind()
 * @model
 * @generated
 */
public interface Wind extends SensorEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ms</em>' attribute.
	 * @see #setM_s(double)
	 * @see com.verticon.tracker.TrackerPackage#getWind_M_s()
	 * @model required="true"
	 * @generated
	 */
	double getM_s();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Wind#getM_s <em>Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ms</em>' attribute.
	 * @see #getM_s()
	 * @generated
	 */
	void setM_s(double value);

	/**
	 * Returns the value of the '<em><b>Mph</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mph</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mph</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getWind_Mph()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getMph();

	/**
	 * Returns the value of the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>R</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>R</em>' attribute.
	 * @see #setR(double)
	 * @see com.verticon.tracker.TrackerPackage#getWind_R()
	 * @model
	 * @generated
	 */
	double getR();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Wind#getR <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' attribute.
	 * @see #getR()
	 * @generated
	 */
	void setR(double value);

	/**
	 * Returns the value of the '<em><b>Degrees</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degrees</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degrees</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getWind_Degrees()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getDegrees();

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getWind_Direction()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getDirection();

} // Wind
