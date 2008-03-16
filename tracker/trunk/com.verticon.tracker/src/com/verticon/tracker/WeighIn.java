/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Weigh In</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.WeighIn#getWeight <em>Weight</em>}</li>
 *   <li>{@link com.verticon.tracker.WeighIn#getWeightGainPerDay <em>Weight Gain Per Day</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getWeighIn()
 * @model
 * @generated
 */
public interface WeighIn extends Event {
	
	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 102;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(Integer)
	 * @see com.verticon.tracker.TrackerPackage#getWeighIn_Weight()
	 * @model required="true"
	 * @generated
	 */
	Integer getWeight();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.WeighIn#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(Integer value);

	/**
	 * Returns the value of the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight Gain Per Day</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight Gain Per Day</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getWeighIn_WeightGainPerDay()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Integer getWeightGainPerDay();

} // WeighIn