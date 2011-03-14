/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.PostalCodeNumberExtension;
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
 * An implementation of the model object '<em><b>Postal Code Number Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeNumberExtensionImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeNumberExtensionImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeNumberExtensionImpl#getNumberExtensionSeparator <em>Number Extension Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeNumberExtensionImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeNumberExtensionImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostalCodeNumberExtensionImpl extends MinimalEObjectImpl.Container implements PostalCodeNumberExtension {
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
	 * The default value of the '{@link #getNumberExtensionSeparator() <em>Number Extension Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberExtensionSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final Object NUMBER_EXTENSION_SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberExtensionSeparator() <em>Number Extension Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberExtensionSeparator()
	 * @generated
	 * @ordered
	 */
	protected Object numberExtensionSeparator = NUMBER_EXTENSION_SEPARATOR_EDEFAULT;

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
	protected PostalCodeNumberExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getPostalCodeNumberExtension();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, XalPackage.POSTAL_CODE_NUMBER_EXTENSION__MIXED);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_CODE_NUMBER_EXTENSION__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNumberExtensionSeparator() {
		return numberExtensionSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberExtensionSeparator(Object newNumberExtensionSeparator) {
		Object oldNumberExtensionSeparator = numberExtensionSeparator;
		numberExtensionSeparator = newNumberExtensionSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_CODE_NUMBER_EXTENSION__NUMBER_EXTENSION_SEPARATOR, oldNumberExtensionSeparator, numberExtensionSeparator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_CODE_NUMBER_EXTENSION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.POSTAL_CODE_NUMBER_EXTENSION__ANY_ATTRIBUTE);
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
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__CODE:
				return getCode();
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__NUMBER_EXTENSION_SEPARATOR:
				return getNumberExtensionSeparator();
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__TYPE:
				return getType();
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__CODE:
				setCode(newValue);
				return;
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__NUMBER_EXTENSION_SEPARATOR:
				setNumberExtensionSeparator(newValue);
				return;
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__TYPE:
				setType(newValue);
				return;
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__MIXED:
				getMixed().clear();
				return;
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__NUMBER_EXTENSION_SEPARATOR:
				setNumberExtensionSeparator(NUMBER_EXTENSION_SEPARATOR_EDEFAULT);
				return;
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__MIXED:
				return mixed != null && !mixed.isEmpty();
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__NUMBER_EXTENSION_SEPARATOR:
				return NUMBER_EXTENSION_SEPARATOR_EDEFAULT == null ? numberExtensionSeparator != null : !NUMBER_EXTENSION_SEPARATOR_EDEFAULT.equals(numberExtensionSeparator);
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION__ANY_ATTRIBUTE:
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
		result.append(", numberExtensionSeparator: ");
		result.append(numberExtensionSeparator);
		result.append(", type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //PostalCodeNumberExtensionImpl
