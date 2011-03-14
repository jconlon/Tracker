/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.SimpleArrayField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Array Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl#getSimpleArrayFieldExtensionGroup <em>Simple Array Field Extension Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl#getSimpleArrayFieldExtension <em>Simple Array Field Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleArrayFieldImpl extends MinimalEObjectImpl.Container implements SimpleArrayField {
	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSimpleArrayFieldExtensionGroup() <em>Simple Array Field Extension Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleArrayFieldExtensionGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap simpleArrayFieldExtensionGroup;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleArrayFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.SIMPLE_ARRAY_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.SIMPLE_ARRAY_FIELD__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getSimpleArrayFieldExtensionGroup() {
		if (simpleArrayFieldExtensionGroup == null) {
			simpleArrayFieldExtensionGroup = new BasicFeatureMap(this, KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP);
		}
		return simpleArrayFieldExtensionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getSimpleArrayFieldExtension() {
		return getSimpleArrayFieldExtensionGroup().list(KmlgxPackage.Literals.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION);
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
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.SIMPLE_ARRAY_FIELD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.SIMPLE_ARRAY_FIELD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP:
				return ((InternalEList<?>)getSimpleArrayFieldExtensionGroup()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION:
				return ((InternalEList<?>)getSimpleArrayFieldExtension()).basicRemove(otherEnd, msgs);
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
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__DISPLAY_NAME:
				return getDisplayName();
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP:
				if (coreType) return getSimpleArrayFieldExtensionGroup();
				return ((FeatureMap.Internal)getSimpleArrayFieldExtensionGroup()).getWrapper();
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION:
				return getSimpleArrayFieldExtension();
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__NAME:
				return getName();
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__TYPE:
				return getType();
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
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP:
				((FeatureMap.Internal)getSimpleArrayFieldExtensionGroup()).set(newValue);
				return;
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__NAME:
				setName((String)newValue);
				return;
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__TYPE:
				setType((String)newValue);
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
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP:
				getSimpleArrayFieldExtensionGroup().clear();
				return;
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__TYPE:
				setType(TYPE_EDEFAULT);
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
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP:
				return simpleArrayFieldExtensionGroup != null && !simpleArrayFieldExtensionGroup.isEmpty();
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION:
				return !getSimpleArrayFieldExtension().isEmpty();
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KmlgxPackage.SIMPLE_ARRAY_FIELD__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (displayName: ");
		result.append(displayName);
		result.append(", simpleArrayFieldExtensionGroup: ");
		result.append(simpleArrayFieldExtensionGroup);
		result.append(", name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //SimpleArrayFieldImpl
