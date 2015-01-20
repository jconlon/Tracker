/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Air</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Air#getK <em>K</em>}</li>
 *   <li>{@link com.verticon.tracker.Air#getFarenheit <em>Farenheit</em>}</li>
 *   <li>{@link com.verticon.tracker.Air#getCelsius <em>Celsius</em>}</li>
 *   <li>{@link com.verticon.tracker.Air#getPa <em>Pa</em>}</li>
 *   <li>{@link com.verticon.tracker.Air#getIncheOfMercury <em>Inche Of Mercury</em>}</li>
 *   <li>{@link com.verticon.tracker.Air#getRh <em>Rh</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getAir()
 * @model
 * @generated
 */
public interface Air extends SensorEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>K</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K</em>' attribute.
	 * @see #setK(double)
	 * @see com.verticon.tracker.TrackerPackage#getAir_K()
	 * @model required="true"
	 * @generated
	 */
	double getK();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Air#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K</em>' attribute.
	 * @see #getK()
	 * @generated
	 */
	void setK(double value);

	/**
	 * Returns the value of the '<em><b>Farenheit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Farenheit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Farenheit</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAir_Farenheit()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getFarenheit();

	/**
	 * Returns the value of the '<em><b>Celsius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Celsius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Celsius</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAir_Celsius()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getCelsius();

	/**
	 * Returns the value of the '<em><b>Pa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pa</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pa</em>' attribute.
	 * @see #setPa(double)
	 * @see com.verticon.tracker.TrackerPackage#getAir_Pa()
	 * @model required="true"
	 * @generated
	 */
	double getPa();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Air#getPa <em>Pa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pa</em>' attribute.
	 * @see #getPa()
	 * @generated
	 */
	void setPa(double value);

	/**
	 * Returns the value of the '<em><b>Inche Of Mercury</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inche Of Mercury</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inche Of Mercury</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAir_IncheOfMercury()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getIncheOfMercury();

	/**
	 * Returns the value of the '<em><b>Rh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rh</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rh</em>' attribute.
	 * @see #setRh(double)
	 * @see com.verticon.tracker.TrackerPackage#getAir_Rh()
	 * @model
	 * @generated
	 */
	double getRh();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Air#getRh <em>Rh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rh</em>' attribute.
	 * @see #getRh()
	 * @generated
	 */
	void setRh(double value);

} // Air
