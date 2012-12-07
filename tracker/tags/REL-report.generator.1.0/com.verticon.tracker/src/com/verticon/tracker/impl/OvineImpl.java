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
import com.verticon.tracker.Ovine;
import com.verticon.tracker.SheepBreed;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.Species;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ovine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.OvineImpl#getSheepBreed <em>Sheep Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.OvineImpl#getScrapieTag <em>Scrapie Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OvineImpl extends AnimalImpl implements Ovine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	
	/**
	 * The default value of the '{@link #getSheepBreed() <em>Sheep Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheepBreed()
	 * @generated
	 * @ordered
	 */
	protected static final SheepBreed SHEEP_BREED_EDEFAULT = SheepBreed.CD_LITERAL;

	/**
	 * The cached value of the '{@link #getSheepBreed() <em>Sheep Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheepBreed()
	 * @generated
	 * @ordered
	 */
	protected SheepBreed sheepBreed = SHEEP_BREED_EDEFAULT;

	/**
	 * The default value of the '{@link #getScrapieTag() <em>Scrapie Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScrapieTag()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRAPIE_TAG_EDEFAULT = null;


	/**
	 * The cached value of the '{@link #getScrapieTag() <em>Scrapie Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScrapieTag()
	 * @generated
	 * @ordered
	 */
	protected String scrapieTag = SCRAPIE_TAG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OvineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.OVINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Species getSpeciesEnum() {
		return Species.OVI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SheepBreed getSheepBreed() {
		return sheepBreed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSheepBreed(SheepBreed newSheepBreed) {
		SheepBreed oldSheepBreed = sheepBreed;
		sheepBreed = newSheepBreed == null ? SHEEP_BREED_EDEFAULT : newSheepBreed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.OVINE__SHEEP_BREED, oldSheepBreed, sheepBreed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScrapieTag() {
		return scrapieTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Added notification for 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setScrapieTag(String newScrapieTag) {
		String oldScrapieTag = scrapieTag;
		scrapieTag = newScrapieTag;
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.OVINE__SCRAPIE_TAG, oldScrapieTag, scrapieTag));
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__ALTERNATIVE_ID, oldScrapieTag, scrapieTag));
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
			case TrackerPackage.OVINE__SHEEP_BREED:
				return getSheepBreed();
			case TrackerPackage.OVINE__SCRAPIE_TAG:
				return getScrapieTag();
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
			case TrackerPackage.OVINE__SHEEP_BREED:
				setSheepBreed((SheepBreed)newValue);
				return;
			case TrackerPackage.OVINE__SCRAPIE_TAG:
				setScrapieTag((String)newValue);
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
			case TrackerPackage.OVINE__SHEEP_BREED:
				setSheepBreed(SHEEP_BREED_EDEFAULT);
				return;
			case TrackerPackage.OVINE__SCRAPIE_TAG:
				setScrapieTag(SCRAPIE_TAG_EDEFAULT);
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
			case TrackerPackage.OVINE__SHEEP_BREED:
				return sheepBreed != SHEEP_BREED_EDEFAULT;
			case TrackerPackage.OVINE__SCRAPIE_TAG:
				return SCRAPIE_TAG_EDEFAULT == null ? scrapieTag != null : !SCRAPIE_TAG_EDEFAULT.equals(scrapieTag);
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
		result.append(" (sheepBreed: ");
		result.append(sheepBreed);
		result.append(", scrapieTag: ");
		result.append(scrapieTag);
		result.append(')');
		return result.toString();
	}

	/**
	 * @NOT
	 */
	@Override
	public String getBreed() {
		if(getSheepBreed()==SheepBreed.UNSPECIFIED_LITERAL){
			return "";
		}

		return getSheepBreed().getName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AnimalType getType() {
		return AnimalType.OVINE;
	}

	/**
	 * Sheep scrapieTags are an alternative official
	 * Identification.  
	 */
	@Override
	public String getAlternativeID() {
		return this.getScrapieTag();
	}
	
	

} //OvineImpl