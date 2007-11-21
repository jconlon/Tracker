/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;


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
	protected static final SheepBreed SHEEP_BREED_EDEFAULT = SheepBreed.UNSPECIFIED_LITERAL;

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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.OVINE__SHEEP_BREED:
				return getSheepBreed();
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
		result.append(')');
		return result.toString();
	}

	/**
	 * @NOT
	 */
	@Override
	public String getBreed() {
		if(getSheepBreed()==SheepBreed.UNSPECIFIED_LITERAL){
			return null;
		}

		return getSheepBreed().getName();
	}

} //OvineImpl