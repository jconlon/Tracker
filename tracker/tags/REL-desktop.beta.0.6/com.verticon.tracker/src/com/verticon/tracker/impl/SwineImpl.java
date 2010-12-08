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

import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Swine;
import com.verticon.tracker.SwineBreed;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.Species;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Swine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.SwineImpl#getSwineBreed <em>Swine Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.SwineImpl#getRightEarNotching <em>Right Ear Notching</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.SwineImpl#getLeftEarNotching <em>Left Ear Notching</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwineImpl extends AnimalImpl implements Swine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getSwineBreed() <em>Swine Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwineBreed()
	 * @generated
	 * @ordered
	 */
	protected static final SwineBreed SWINE_BREED_EDEFAULT = SwineBreed.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getSwineBreed() <em>Swine Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwineBreed()
	 * @generated
	 * @ordered
	 */
	protected SwineBreed swineBreed = SWINE_BREED_EDEFAULT;

	/**
	 * The default value of the '{@link #getRightEarNotching() <em>Right Ear Notching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightEarNotching()
	 * @generated
	 * @ordered
	 */
	protected static final int RIGHT_EAR_NOTCHING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRightEarNotching() <em>Right Ear Notching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightEarNotching()
	 * @generated
	 * @ordered
	 */
	protected int rightEarNotching = RIGHT_EAR_NOTCHING_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeftEarNotching() <em>Left Ear Notching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftEarNotching()
	 * @generated
	 * @ordered
	 */
	protected static final int LEFT_EAR_NOTCHING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLeftEarNotching() <em>Left Ear Notching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftEarNotching()
	 * @generated
	 * @ordered
	 */
	protected int leftEarNotching = LEFT_EAR_NOTCHING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.SWINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwineBreed getSwineBreed() {
		return swineBreed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwineBreed(SwineBreed newSwineBreed) {
		SwineBreed oldSwineBreed = swineBreed;
		swineBreed = newSwineBreed == null ? SWINE_BREED_EDEFAULT : newSwineBreed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.SWINE__SWINE_BREED, oldSwineBreed, swineBreed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRightEarNotching() {
		return rightEarNotching;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRightEarNotching(int newRightEarNotching) {
		int oldRightEarNotching = rightEarNotching;
		rightEarNotching = newRightEarNotching;
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.SWINE__RIGHT_EAR_NOTCHING, oldRightEarNotching, rightEarNotching));
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.SWINE__ALTERNATIVE_ID, formatAlternativeID(oldRightEarNotching, leftEarNotching), getAlternativeID()));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLeftEarNotching() {
		return leftEarNotching;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLeftEarNotching(int newLeftEarNotching) {
		int oldLeftEarNotching = leftEarNotching;
		leftEarNotching = newLeftEarNotching;
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.SWINE__LEFT_EAR_NOTCHING, oldLeftEarNotching, leftEarNotching));
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.SWINE__ALTERNATIVE_ID, formatAlternativeID(rightEarNotching, oldLeftEarNotching), getAlternativeID()));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.SWINE__SWINE_BREED:
				return getSwineBreed();
			case TrackerPackage.SWINE__RIGHT_EAR_NOTCHING:
				return getRightEarNotching();
			case TrackerPackage.SWINE__LEFT_EAR_NOTCHING:
				return getLeftEarNotching();
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
			case TrackerPackage.SWINE__SWINE_BREED:
				setSwineBreed((SwineBreed)newValue);
				return;
			case TrackerPackage.SWINE__RIGHT_EAR_NOTCHING:
				setRightEarNotching((Integer)newValue);
				return;
			case TrackerPackage.SWINE__LEFT_EAR_NOTCHING:
				setLeftEarNotching((Integer)newValue);
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
			case TrackerPackage.SWINE__SWINE_BREED:
				setSwineBreed(SWINE_BREED_EDEFAULT);
				return;
			case TrackerPackage.SWINE__RIGHT_EAR_NOTCHING:
				setRightEarNotching(RIGHT_EAR_NOTCHING_EDEFAULT);
				return;
			case TrackerPackage.SWINE__LEFT_EAR_NOTCHING:
				setLeftEarNotching(LEFT_EAR_NOTCHING_EDEFAULT);
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
			case TrackerPackage.SWINE__SWINE_BREED:
				return swineBreed != SWINE_BREED_EDEFAULT;
			case TrackerPackage.SWINE__RIGHT_EAR_NOTCHING:
				return rightEarNotching != RIGHT_EAR_NOTCHING_EDEFAULT;
			case TrackerPackage.SWINE__LEFT_EAR_NOTCHING:
				return leftEarNotching != LEFT_EAR_NOTCHING_EDEFAULT;
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
		result.append(" (swineBreed: ");
		result.append(swineBreed);
		result.append(", rightEarNotching: ");
		result.append(rightEarNotching);
		result.append(", leftEarNotching: ");
		result.append(leftEarNotching);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT
	 */
	public Species getSpeciesEnum() {
		return Species.POR;
	}
	
	/**
	 * @NOT
	 */
	@Override
	public String getBreed() {
		if(getSwineBreed()==SwineBreed.UNSPECIFIED_LITERAL){
			return "";
		}

		return getSwineBreed().getName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AnimalType getType() {
		return AnimalType.SWINE;
	}

	@Override
	public String getAlternativeID() {
		return formatAlternativeID(rightEarNotching,leftEarNotching);
	}
	
	private String formatAlternativeID(int rightNotch, int leftNotch){
		StringBuilder sb = new StringBuilder();
		sb.append(rightNotch);
		sb.append('-');
		sb.append(leftNotch);
		return sb.toString();
	}
	

} //SwineImpl