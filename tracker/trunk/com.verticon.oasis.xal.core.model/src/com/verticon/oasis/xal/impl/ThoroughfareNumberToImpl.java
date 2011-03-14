/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.ThoroughfareNumber;
import com.verticon.oasis.xal.ThoroughfareNumberPrefix;
import com.verticon.oasis.xal.ThoroughfareNumberSuffix;
import com.verticon.oasis.xal.ThoroughfareNumberTo;
import com.verticon.oasis.xal.XalPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thoroughfare Number To</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl#getThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl#getThoroughfareNumber <em>Thoroughfare Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl#getThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThoroughfareNumberToImpl extends MinimalEObjectImpl.Container implements ThoroughfareNumberTo {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final Object CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected Object code = CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnyAttribute()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap anyAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThoroughfareNumberToImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getThoroughfareNumberTo();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, XalPackage.THOROUGHFARE_NUMBER_TO__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		return getMixed().list(XalPackage.eINSTANCE.getThoroughfareNumberTo_AddressLine());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix() {
		return getMixed().list(XalPackage.eINSTANCE.getThoroughfareNumberTo_ThoroughfareNumberPrefix());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThoroughfareNumber> getThoroughfareNumber() {
		return getMixed().list(XalPackage.eINSTANCE.getThoroughfareNumberTo_ThoroughfareNumber());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix() {
		return getMixed().list(XalPackage.eINSTANCE.getThoroughfareNumberTo_ThoroughfareNumberSuffix());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(Object newCode) {
		Object oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_TO__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.THOROUGHFARE_NUMBER_TO__ANY_ATTRIBUTE);
		}
		return anyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XalPackage.THOROUGHFARE_NUMBER_TO__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case XalPackage.THOROUGHFARE_NUMBER_TO__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_PREFIX:
				return ((InternalEList<?>)getThoroughfareNumberPrefix()).basicRemove(otherEnd, msgs);
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER:
				return ((InternalEList<?>)getThoroughfareNumber()).basicRemove(otherEnd, msgs);
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_SUFFIX:
				return ((InternalEList<?>)getThoroughfareNumberSuffix()).basicRemove(otherEnd, msgs);
			case XalPackage.THOROUGHFARE_NUMBER_TO__ANY_ATTRIBUTE:
				return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
			case XalPackage.THOROUGHFARE_NUMBER_TO__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case XalPackage.THOROUGHFARE_NUMBER_TO__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_PREFIX:
				return getThoroughfareNumberPrefix();
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER:
				return getThoroughfareNumber();
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_SUFFIX:
				return getThoroughfareNumberSuffix();
			case XalPackage.THOROUGHFARE_NUMBER_TO__CODE:
				return getCode();
			case XalPackage.THOROUGHFARE_NUMBER_TO__ANY_ATTRIBUTE:
				if (coreType) return getAnyAttribute();
				return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
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
			case XalPackage.THOROUGHFARE_NUMBER_TO__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_PREFIX:
				getThoroughfareNumberPrefix().clear();
				getThoroughfareNumberPrefix().addAll((Collection<? extends ThoroughfareNumberPrefix>)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER:
				getThoroughfareNumber().clear();
				getThoroughfareNumber().addAll((Collection<? extends ThoroughfareNumber>)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_SUFFIX:
				getThoroughfareNumberSuffix().clear();
				getThoroughfareNumberSuffix().addAll((Collection<? extends ThoroughfareNumberSuffix>)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__CODE:
				setCode(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__ANY_ATTRIBUTE:
				((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
			case XalPackage.THOROUGHFARE_NUMBER_TO__MIXED:
				getMixed().clear();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_PREFIX:
				getThoroughfareNumberPrefix().clear();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER:
				getThoroughfareNumber().clear();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_SUFFIX:
				getThoroughfareNumberSuffix().clear();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_TO__ANY_ATTRIBUTE:
				getAnyAttribute().clear();
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
			case XalPackage.THOROUGHFARE_NUMBER_TO__MIXED:
				return mixed != null && !mixed.isEmpty();
			case XalPackage.THOROUGHFARE_NUMBER_TO__ADDRESS_LINE:
				return !getAddressLine().isEmpty();
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_PREFIX:
				return !getThoroughfareNumberPrefix().isEmpty();
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER:
				return !getThoroughfareNumber().isEmpty();
			case XalPackage.THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_SUFFIX:
				return !getThoroughfareNumberSuffix().isEmpty();
			case XalPackage.THOROUGHFARE_NUMBER_TO__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case XalPackage.THOROUGHFARE_NUMBER_TO__ANY_ATTRIBUTE:
				return anyAttribute != null && !anyAttribute.isEmpty();
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(", code: ");
		result.append(code);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //ThoroughfareNumberToImpl
