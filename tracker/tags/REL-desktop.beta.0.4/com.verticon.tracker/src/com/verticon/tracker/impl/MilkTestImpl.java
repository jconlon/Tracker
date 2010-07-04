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

import com.verticon.tracker.MilkTest;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Milk Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.MilkTestImpl#getPoundsProduced <em>Pounds Produced</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MilkTestImpl#getPercentButterFat <em>Percent Butter Fat</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MilkTestImpl#getPercentProtein <em>Percent Protein</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MilkTestImpl#getSomaticCellCounts <em>Somatic Cell Counts</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.MilkTestImpl#getOtherSolids <em>Other Solids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MilkTestImpl extends EventImpl implements MilkTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getPoundsProduced() <em>Pounds Produced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoundsProduced()
	 * @generated
	 * @ordered
	 */
	protected static final double POUNDS_PRODUCED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPoundsProduced() <em>Pounds Produced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoundsProduced()
	 * @generated
	 * @ordered
	 */
	protected double poundsProduced = POUNDS_PRODUCED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPercentButterFat() <em>Percent Butter Fat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentButterFat()
	 * @generated
	 * @ordered
	 */
	protected static final double PERCENT_BUTTER_FAT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPercentButterFat() <em>Percent Butter Fat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentButterFat()
	 * @generated
	 * @ordered
	 */
	protected double percentButterFat = PERCENT_BUTTER_FAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPercentProtein() <em>Percent Protein</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentProtein()
	 * @generated
	 * @ordered
	 */
	protected static final double PERCENT_PROTEIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPercentProtein() <em>Percent Protein</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentProtein()
	 * @generated
	 * @ordered
	 */
	protected double percentProtein = PERCENT_PROTEIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSomaticCellCounts() <em>Somatic Cell Counts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSomaticCellCounts()
	 * @generated
	 * @ordered
	 */
	protected static final int SOMATIC_CELL_COUNTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSomaticCellCounts() <em>Somatic Cell Counts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSomaticCellCounts()
	 * @generated
	 * @ordered
	 */
	protected int somaticCellCounts = SOMATIC_CELL_COUNTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOtherSolids() <em>Other Solids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherSolids()
	 * @generated
	 * @ordered
	 */
	protected static final double OTHER_SOLIDS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getOtherSolids() <em>Other Solids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherSolids()
	 * @generated
	 * @ordered
	 */
	protected double otherSolids = OTHER_SOLIDS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MilkTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.MILK_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPoundsProduced() {
		return poundsProduced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoundsProduced(double newPoundsProduced) {
		double oldPoundsProduced = poundsProduced;
		poundsProduced = newPoundsProduced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MILK_TEST__POUNDS_PRODUCED, oldPoundsProduced, poundsProduced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPercentButterFat() {
		return percentButterFat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentButterFat(double newPercentButterFat) {
		double oldPercentButterFat = percentButterFat;
		percentButterFat = newPercentButterFat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MILK_TEST__PERCENT_BUTTER_FAT, oldPercentButterFat, percentButterFat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPercentProtein() {
		return percentProtein;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentProtein(double newPercentProtein) {
		double oldPercentProtein = percentProtein;
		percentProtein = newPercentProtein;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MILK_TEST__PERCENT_PROTEIN, oldPercentProtein, percentProtein));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSomaticCellCounts() {
		return somaticCellCounts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSomaticCellCounts(int newSomaticCellCounts) {
		int oldSomaticCellCounts = somaticCellCounts;
		somaticCellCounts = newSomaticCellCounts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MILK_TEST__SOMATIC_CELL_COUNTS, oldSomaticCellCounts, somaticCellCounts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getOtherSolids() {
		return otherSolids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherSolids(double newOtherSolids) {
		double oldOtherSolids = otherSolids;
		otherSolids = newOtherSolids;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.MILK_TEST__OTHER_SOLIDS, oldOtherSolids, otherSolids));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.MILK_TEST__POUNDS_PRODUCED:
				return getPoundsProduced();
			case TrackerPackage.MILK_TEST__PERCENT_BUTTER_FAT:
				return getPercentButterFat();
			case TrackerPackage.MILK_TEST__PERCENT_PROTEIN:
				return getPercentProtein();
			case TrackerPackage.MILK_TEST__SOMATIC_CELL_COUNTS:
				return getSomaticCellCounts();
			case TrackerPackage.MILK_TEST__OTHER_SOLIDS:
				return getOtherSolids();
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
			case TrackerPackage.MILK_TEST__POUNDS_PRODUCED:
				setPoundsProduced((Double)newValue);
				return;
			case TrackerPackage.MILK_TEST__PERCENT_BUTTER_FAT:
				setPercentButterFat((Double)newValue);
				return;
			case TrackerPackage.MILK_TEST__PERCENT_PROTEIN:
				setPercentProtein((Double)newValue);
				return;
			case TrackerPackage.MILK_TEST__SOMATIC_CELL_COUNTS:
				setSomaticCellCounts((Integer)newValue);
				return;
			case TrackerPackage.MILK_TEST__OTHER_SOLIDS:
				setOtherSolids((Double)newValue);
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
			case TrackerPackage.MILK_TEST__POUNDS_PRODUCED:
				setPoundsProduced(POUNDS_PRODUCED_EDEFAULT);
				return;
			case TrackerPackage.MILK_TEST__PERCENT_BUTTER_FAT:
				setPercentButterFat(PERCENT_BUTTER_FAT_EDEFAULT);
				return;
			case TrackerPackage.MILK_TEST__PERCENT_PROTEIN:
				setPercentProtein(PERCENT_PROTEIN_EDEFAULT);
				return;
			case TrackerPackage.MILK_TEST__SOMATIC_CELL_COUNTS:
				setSomaticCellCounts(SOMATIC_CELL_COUNTS_EDEFAULT);
				return;
			case TrackerPackage.MILK_TEST__OTHER_SOLIDS:
				setOtherSolids(OTHER_SOLIDS_EDEFAULT);
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
			case TrackerPackage.MILK_TEST__POUNDS_PRODUCED:
				return poundsProduced != POUNDS_PRODUCED_EDEFAULT;
			case TrackerPackage.MILK_TEST__PERCENT_BUTTER_FAT:
				return percentButterFat != PERCENT_BUTTER_FAT_EDEFAULT;
			case TrackerPackage.MILK_TEST__PERCENT_PROTEIN:
				return percentProtein != PERCENT_PROTEIN_EDEFAULT;
			case TrackerPackage.MILK_TEST__SOMATIC_CELL_COUNTS:
				return somaticCellCounts != SOMATIC_CELL_COUNTS_EDEFAULT;
			case TrackerPackage.MILK_TEST__OTHER_SOLIDS:
				return otherSolids != OTHER_SOLIDS_EDEFAULT;
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
		result.append(" (poundsProduced: ");
		result.append(poundsProduced);
		result.append(", percentButterFat: ");
		result.append(percentButterFat);
		result.append(", percentProtein: ");
		result.append(percentProtein);
		result.append(", somaticCellCounts: ");
		result.append(somaticCellCounts);
		result.append(", otherSolids: ");
		result.append(otherSolids);
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

} //MilkTestImpl
