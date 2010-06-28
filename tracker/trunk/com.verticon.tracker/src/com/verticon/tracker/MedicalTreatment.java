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
 * A representation of the model object '<em><b>Medical Treatment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.MedicalTreatment#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.MedicalTreatment#getProduct <em>Product</em>}</li>
 *   <li>{@link com.verticon.tracker.MedicalTreatment#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link com.verticon.tracker.MedicalTreatment#getLot <em>Lot</em>}</li>
 *   <li>{@link com.verticon.tracker.MedicalTreatment#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.verticon.tracker.MedicalTreatment#getTreatment <em>Treatment</em>}</li>
 *   <li>{@link com.verticon.tracker.MedicalTreatment#getMethod <em>Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getMedicalTreatment()
 * @model
 * @generated
 */
public interface MedicalTreatment extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 104;
	
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
	 * @see com.verticon.tracker.TrackerPackage#getMedicalTreatment_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MedicalTreatment#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' attribute.
	 * @see #setProduct(String)
	 * @see com.verticon.tracker.TrackerPackage#getMedicalTreatment_Product()
	 * @model
	 * @generated
	 */
	String getProduct();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MedicalTreatment#getProduct <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product</em>' attribute.
	 * @see #getProduct()
	 * @generated
	 */
	void setProduct(String value);

	/**
	 * Returns the value of the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manufacturer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manufacturer</em>' attribute.
	 * @see #setManufacturer(String)
	 * @see com.verticon.tracker.TrackerPackage#getMedicalTreatment_Manufacturer()
	 * @model
	 * @generated
	 */
	String getManufacturer();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MedicalTreatment#getManufacturer <em>Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manufacturer</em>' attribute.
	 * @see #getManufacturer()
	 * @generated
	 */
	void setManufacturer(String value);

	/**
	 * Returns the value of the '<em><b>Lot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lot</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lot</em>' attribute.
	 * @see #setLot(String)
	 * @see com.verticon.tracker.TrackerPackage#getMedicalTreatment_Lot()
	 * @model
	 * @generated
	 */
	String getLot();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MedicalTreatment#getLot <em>Lot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lot</em>' attribute.
	 * @see #getLot()
	 * @generated
	 */
	void setLot(String value);

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(String)
	 * @see com.verticon.tracker.TrackerPackage#getMedicalTreatment_Quantity()
	 * @model
	 * @generated
	 */
	String getQuantity();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MedicalTreatment#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(String value);

	/**
	 * Returns the value of the '<em><b>Treatment</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.Treatment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Treatment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Treatment</em>' attribute.
	 * @see com.verticon.tracker.Treatment
	 * @see #setTreatment(Treatment)
	 * @see com.verticon.tracker.TrackerPackage#getMedicalTreatment_Treatment()
	 * @model
	 * @generated
	 */
	Treatment getTreatment();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MedicalTreatment#getTreatment <em>Treatment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Treatment</em>' attribute.
	 * @see com.verticon.tracker.Treatment
	 * @see #getTreatment()
	 * @generated
	 */
	void setTreatment(Treatment value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.TreatmentMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see com.verticon.tracker.TreatmentMethod
	 * @see #setMethod(TreatmentMethod)
	 * @see com.verticon.tracker.TrackerPackage#getMedicalTreatment_Method()
	 * @model
	 * @generated
	 */
	TreatmentMethod getMethod();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MedicalTreatment#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see com.verticon.tracker.TreatmentMethod
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(TreatmentMethod value);

} // MedicalTreatment
