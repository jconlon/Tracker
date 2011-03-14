/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.SubPremiseNumberPrefix;
import com.verticon.oasis.xal.XalPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Premise Number Prefix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberPrefixImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberPrefixImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberPrefixImpl#getNumberPrefixSeparator <em>Number Prefix Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberPrefixImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberPrefixImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubPremiseNumberPrefixImpl extends MinimalEObjectImpl.Container implements SubPremiseNumberPrefix {
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
	 * The default value of the '{@link #getNumberPrefixSeparator() <em>Number Prefix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberPrefixSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final Object NUMBER_PREFIX_SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberPrefixSeparator() <em>Number Prefix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberPrefixSeparator()
	 * @generated
	 * @ordered
	 */
	protected Object numberPrefixSeparator = NUMBER_PREFIX_SEPARATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final Object TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Object type = TYPE_EDEFAULT;

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
	protected SubPremiseNumberPrefixImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getSubPremiseNumberPrefix();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, XalPackage.SUB_PREMISE_NUMBER_PREFIX__MIXED);
		}
		return mixed;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER_PREFIX__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNumberPrefixSeparator() {
		return numberPrefixSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberPrefixSeparator(Object newNumberPrefixSeparator) {
		Object oldNumberPrefixSeparator = numberPrefixSeparator;
		numberPrefixSeparator = newNumberPrefixSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR, oldNumberPrefixSeparator, numberPrefixSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Object newType) {
		Object oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER_PREFIX__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.SUB_PREMISE_NUMBER_PREFIX__ANY_ATTRIBUTE);
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
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__CODE:
				return getCode();
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR:
				return getNumberPrefixSeparator();
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__TYPE:
				return getType();
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__ANY_ATTRIBUTE:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__CODE:
				setCode(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR:
				setNumberPrefixSeparator(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__TYPE:
				setType(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__MIXED:
				getMixed().clear();
				return;
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR:
				setNumberPrefixSeparator(NUMBER_PREFIX_SEPARATOR_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__MIXED:
				return mixed != null && !mixed.isEmpty();
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR:
				return NUMBER_PREFIX_SEPARATOR_EDEFAULT == null ? numberPrefixSeparator != null : !NUMBER_PREFIX_SEPARATOR_EDEFAULT.equals(numberPrefixSeparator);
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX__ANY_ATTRIBUTE:
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
		result.append(", numberPrefixSeparator: ");
		result.append(numberPrefixSeparator);
		result.append(", type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //SubPremiseNumberPrefixImpl
