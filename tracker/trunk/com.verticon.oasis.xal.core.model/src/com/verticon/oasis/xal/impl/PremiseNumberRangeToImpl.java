/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.PremiseNumber;
import com.verticon.oasis.xal.PremiseNumberPrefix;
import com.verticon.oasis.xal.PremiseNumberRangeTo;
import com.verticon.oasis.xal.PremiseNumberSuffix;
import com.verticon.oasis.xal.XalPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Premise Number Range To</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeToImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeToImpl#getPremiseNumberPrefix <em>Premise Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeToImpl#getPremiseNumber <em>Premise Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeToImpl#getPremiseNumberSuffix <em>Premise Number Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PremiseNumberRangeToImpl extends MinimalEObjectImpl.Container implements PremiseNumberRangeTo {
	/**
	 * The cached value of the '{@link #getAddressLine() <em>Address Line</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressLine()
	 * @generated
	 * @ordered
	 */
	protected EList<AddressLine> addressLine;

	/**
	 * The cached value of the '{@link #getPremiseNumberPrefix() <em>Premise Number Prefix</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberPrefix()
	 * @generated
	 * @ordered
	 */
	protected EList<PremiseNumberPrefix> premiseNumberPrefix;

	/**
	 * The cached value of the '{@link #getPremiseNumber() <em>Premise Number</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumber()
	 * @generated
	 * @ordered
	 */
	protected EList<PremiseNumber> premiseNumber;

	/**
	 * The cached value of the '{@link #getPremiseNumberSuffix() <em>Premise Number Suffix</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberSuffix()
	 * @generated
	 * @ordered
	 */
	protected EList<PremiseNumberSuffix> premiseNumberSuffix;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PremiseNumberRangeToImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getPremiseNumberRangeTo();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.PREMISE_NUMBER_RANGE_TO__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PremiseNumberPrefix> getPremiseNumberPrefix() {
		if (premiseNumberPrefix == null) {
			premiseNumberPrefix = new EObjectContainmentEList<PremiseNumberPrefix>(PremiseNumberPrefix.class, this, XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_PREFIX);
		}
		return premiseNumberPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PremiseNumber> getPremiseNumber() {
		if (premiseNumber == null) {
			premiseNumber = new EObjectContainmentEList<PremiseNumber>(PremiseNumber.class, this, XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER);
		}
		return premiseNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PremiseNumberSuffix> getPremiseNumberSuffix() {
		if (premiseNumberSuffix == null) {
			premiseNumberSuffix = new EObjectContainmentEList<PremiseNumberSuffix>(PremiseNumberSuffix.class, this, XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_SUFFIX);
		}
		return premiseNumberSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XalPackage.PREMISE_NUMBER_RANGE_TO__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_PREFIX:
				return ((InternalEList<?>)getPremiseNumberPrefix()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER:
				return ((InternalEList<?>)getPremiseNumber()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_SUFFIX:
				return ((InternalEList<?>)getPremiseNumberSuffix()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XalPackage.PREMISE_NUMBER_RANGE_TO__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_PREFIX:
				return getPremiseNumberPrefix();
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER:
				return getPremiseNumber();
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_SUFFIX:
				return getPremiseNumberSuffix();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XalPackage.PREMISE_NUMBER_RANGE_TO__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_PREFIX:
				getPremiseNumberPrefix().clear();
				getPremiseNumberPrefix().addAll((Collection<? extends PremiseNumberPrefix>)newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER:
				getPremiseNumber().clear();
				getPremiseNumber().addAll((Collection<? extends PremiseNumber>)newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_SUFFIX:
				getPremiseNumberSuffix().clear();
				getPremiseNumberSuffix().addAll((Collection<? extends PremiseNumberSuffix>)newValue);
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
			case XalPackage.PREMISE_NUMBER_RANGE_TO__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_PREFIX:
				getPremiseNumberPrefix().clear();
				return;
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER:
				getPremiseNumber().clear();
				return;
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_SUFFIX:
				getPremiseNumberSuffix().clear();
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
			case XalPackage.PREMISE_NUMBER_RANGE_TO__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_PREFIX:
				return premiseNumberPrefix != null && !premiseNumberPrefix.isEmpty();
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER:
				return premiseNumber != null && !premiseNumber.isEmpty();
			case XalPackage.PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_SUFFIX:
				return premiseNumberSuffix != null && !premiseNumberSuffix.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PremiseNumberRangeToImpl
