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
 *   <li>{@link com.verticon.tracker.WeighIn#getUnit <em>Unit</em>}</li>
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
	 * @see #setWeight(Double)
	 * @see com.verticon.tracker.TrackerPackage#getWeighIn_Weight()
	 * @model required="true"
	 * @generated
	 */
	Double getWeight();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.WeighIn#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(Double value);

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
	Double getWeightGainPerDay();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The default value is <code>"pound"</code>.
	 * The literals are from the enumeration {@link com.verticon.tracker.WeightMeasurementUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see com.verticon.tracker.WeightMeasurementUnit
	 * @see #setUnit(WeightMeasurementUnit)
	 * @see com.verticon.tracker.TrackerPackage#getWeighIn_Unit()
	 * @model default="pound"
	 * @generated
	 */
	WeightMeasurementUnit getUnit();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.WeighIn#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see com.verticon.tracker.WeightMeasurementUnit
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(WeightMeasurementUnit value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The previous WeighIn event for the same animal.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='Collection<Event> weighIns = getPreviousWeighInEvents();\t\t\t\n\t\tWeighIn lastWeighIn = getPreviousWeighInEvent(weighIns);\n\t\treturn lastWeighIn;'"
	 * @generated
	 */
	WeighIn previousWeighIn();

} // WeighIn