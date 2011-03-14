/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.SimpleArrayData;
import com.verticon.opengis.kml.impl.AbstractObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Array Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayDataImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayDataImpl#getSimpleArrayDataExtensionGroup <em>Simple Array Data Extension Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayDataImpl#getSimpleArrayDataExtension <em>Simple Array Data Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.SimpleArrayDataImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleArrayDataImpl extends AbstractObjectImpl implements SimpleArrayData {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<String> value;

	/**
	 * The cached value of the '{@link #getSimpleArrayDataExtensionGroup() <em>Simple Array Data Extension Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleArrayDataExtensionGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap simpleArrayDataExtensionGroup;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleArrayDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.SIMPLE_ARRAY_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getValue() {
		if (value == null) {
			value = new EDataTypeEList<String>(String.class, this, KmlgxPackage.SIMPLE_ARRAY_DATA__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getSimpleArrayDataExtensionGroup() {
		if (simpleArrayDataExtensionGroup == null) {
			simpleArrayDataExtensionGroup = new BasicFeatureMap(this, KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP);
		}
		return simpleArrayDataExtensionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getSimpleArrayDataExtension() {
		return getSimpleArrayDataExtensionGroup().list(KmlgxPackage.Literals.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION);
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
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.SIMPLE_ARRAY_DATA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP:
				return ((InternalEList<?>)getSimpleArrayDataExtensionGroup()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION:
				return ((InternalEList<?>)getSimpleArrayDataExtension()).basicRemove(otherEnd, msgs);
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
			case KmlgxPackage.SIMPLE_ARRAY_DATA__VALUE:
				return getValue();
			case KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP:
				if (coreType) return getSimpleArrayDataExtensionGroup();
				return ((FeatureMap.Internal)getSimpleArrayDataExtensionGroup()).getWrapper();
			case KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION:
				return getSimpleArrayDataExtension();
			case KmlgxPackage.SIMPLE_ARRAY_DATA__NAME:
				return getName();
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
			case KmlgxPackage.SIMPLE_ARRAY_DATA__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends String>)newValue);
				return;
			case KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP:
				((FeatureMap.Internal)getSimpleArrayDataExtensionGroup()).set(newValue);
				return;
			case KmlgxPackage.SIMPLE_ARRAY_DATA__NAME:
				setName((String)newValue);
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
			case KmlgxPackage.SIMPLE_ARRAY_DATA__VALUE:
				getValue().clear();
				return;
			case KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP:
				getSimpleArrayDataExtensionGroup().clear();
				return;
			case KmlgxPackage.SIMPLE_ARRAY_DATA__NAME:
				setName(NAME_EDEFAULT);
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
			case KmlgxPackage.SIMPLE_ARRAY_DATA__VALUE:
				return value != null && !value.isEmpty();
			case KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP:
				return simpleArrayDataExtensionGroup != null && !simpleArrayDataExtensionGroup.isEmpty();
			case KmlgxPackage.SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION:
				return !getSimpleArrayDataExtension().isEmpty();
			case KmlgxPackage.SIMPLE_ARRAY_DATA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (value: ");
		result.append(value);
		result.append(", simpleArrayDataExtensionGroup: ");
		result.append(simpleArrayDataExtensionGroup);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SimpleArrayDataImpl
