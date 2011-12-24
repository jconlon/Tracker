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
package com.verticon.tracker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.tracker.MedicalTreatment;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.Treatment;
import com.verticon.tracker.TreatmentMethod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Medical Treatment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.MedicalTreatmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MedicalTreatmentImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MedicalTreatmentImpl#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MedicalTreatmentImpl#getLot <em>Lot</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MedicalTreatmentImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MedicalTreatmentImpl#getTreatment <em>Treatment</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MedicalTreatmentImpl#getMethod <em>Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MedicalTreatmentImpl extends EventImpl implements MedicalTreatment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected String product = PRODUCT_EDEFAULT;

	/**
	 * The default value of the '{@link #getManufacturer() <em>Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManufacturer()
	 * @generated
	 * @ordered
	 */
	protected static final String MANUFACTURER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManufacturer() <em>Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManufacturer()
	 * @generated
	 * @ordered
	 */
	protected String manufacturer = MANUFACTURER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLot() <em>Lot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLot()
	 * @generated
	 * @ordered
	 */
	protected static final String LOT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLot() <em>Lot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLot()
	 * @generated
	 * @ordered
	 */
	protected String lot = LOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final String QUANTITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected String quantity = QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTreatment() <em>Treatment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTreatment()
	 * @generated
	 * @ordered
	 */
	protected static final Treatment TREATMENT_EDEFAULT = Treatment.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getTreatment() <em>Treatment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTreatment()
	 * @generated
	 * @ordered
	 */
	protected Treatment treatment = TREATMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected static final TreatmentMethod METHOD_EDEFAULT = TreatmentMethod.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected TreatmentMethod method = METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MedicalTreatmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.MEDICAL_TREATMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MEDICAL_TREATMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(String newProduct) {
		String oldProduct = product;
		product = newProduct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MEDICAL_TREATMENT__PRODUCT, oldProduct, product));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManufacturer(String newManufacturer) {
		String oldManufacturer = manufacturer;
		manufacturer = newManufacturer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MEDICAL_TREATMENT__MANUFACTURER, oldManufacturer, manufacturer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLot() {
		return lot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLot(String newLot) {
		String oldLot = lot;
		lot = newLot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MEDICAL_TREATMENT__LOT, oldLot, lot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantity(String newQuantity) {
		String oldQuantity = quantity;
		quantity = newQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MEDICAL_TREATMENT__QUANTITY, oldQuantity, quantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Treatment getTreatment() {
		return treatment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTreatment(Treatment newTreatment) {
		Treatment oldTreatment = treatment;
		treatment = newTreatment == null ? TREATMENT_EDEFAULT : newTreatment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MEDICAL_TREATMENT__TREATMENT, oldTreatment, treatment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreatmentMethod getMethod() {
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethod(TreatmentMethod newMethod) {
		TreatmentMethod oldMethod = method;
		method = newMethod == null ? METHOD_EDEFAULT : newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MEDICAL_TREATMENT__METHOD, oldMethod, method));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.MEDICAL_TREATMENT__NAME:
				return getName();
			case TrackerPackage.MEDICAL_TREATMENT__PRODUCT:
				return getProduct();
			case TrackerPackage.MEDICAL_TREATMENT__MANUFACTURER:
				return getManufacturer();
			case TrackerPackage.MEDICAL_TREATMENT__LOT:
				return getLot();
			case TrackerPackage.MEDICAL_TREATMENT__QUANTITY:
				return getQuantity();
			case TrackerPackage.MEDICAL_TREATMENT__TREATMENT:
				return getTreatment();
			case TrackerPackage.MEDICAL_TREATMENT__METHOD:
				return getMethod();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.MEDICAL_TREATMENT__NAME:
				setName((String)newValue);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__PRODUCT:
				setProduct((String)newValue);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__MANUFACTURER:
				setManufacturer((String)newValue);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__LOT:
				setLot((String)newValue);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__QUANTITY:
				setQuantity((String)newValue);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__TREATMENT:
				setTreatment((Treatment)newValue);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__METHOD:
				setMethod((TreatmentMethod)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.MEDICAL_TREATMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__MANUFACTURER:
				setManufacturer(MANUFACTURER_EDEFAULT);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__LOT:
				setLot(LOT_EDEFAULT);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__QUANTITY:
				setQuantity(QUANTITY_EDEFAULT);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__TREATMENT:
				setTreatment(TREATMENT_EDEFAULT);
				return;
			case TrackerPackage.MEDICAL_TREATMENT__METHOD:
				setMethod(METHOD_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.MEDICAL_TREATMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TrackerPackage.MEDICAL_TREATMENT__PRODUCT:
				return PRODUCT_EDEFAULT == null ? product != null : !PRODUCT_EDEFAULT.equals(product);
			case TrackerPackage.MEDICAL_TREATMENT__MANUFACTURER:
				return MANUFACTURER_EDEFAULT == null ? manufacturer != null : !MANUFACTURER_EDEFAULT.equals(manufacturer);
			case TrackerPackage.MEDICAL_TREATMENT__LOT:
				return LOT_EDEFAULT == null ? lot != null : !LOT_EDEFAULT.equals(lot);
			case TrackerPackage.MEDICAL_TREATMENT__QUANTITY:
				return QUANTITY_EDEFAULT == null ? quantity != null : !QUANTITY_EDEFAULT.equals(quantity);
			case TrackerPackage.MEDICAL_TREATMENT__TREATMENT:
				return treatment != TREATMENT_EDEFAULT;
			case TrackerPackage.MEDICAL_TREATMENT__METHOD:
				return method != METHOD_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", product: ");
		result.append(product);
		result.append(", manufacturer: ");
		result.append(manufacturer);
		result.append(", lot: ");
		result.append(lot);
		result.append(", quantity: ");
		result.append(quantity);
		result.append(", treatment: ");
		result.append(treatment);
		result.append(", method: ");
		result.append(method);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getEventCode() {
		return EVENT_CODE;
	}

} //MedicalTreatmentImpl
