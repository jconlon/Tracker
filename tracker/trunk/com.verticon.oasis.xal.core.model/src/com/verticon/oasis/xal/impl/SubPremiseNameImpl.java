/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.SubPremiseName;
import com.verticon.oasis.xal.TypeOccurrence;
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
 * An implementation of the model object '<em><b>Sub Premise Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNameImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNameImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNameImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNameImpl#getTypeOccurrence <em>Type Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNameImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubPremiseNameImpl extends MinimalEObjectImpl.Container implements SubPremiseName {
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
	 * The default value of the '{@link #getTypeOccurrence() <em>Type Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeOccurrence()
	 * @generated
	 * @ordered
	 */
	protected static final TypeOccurrence TYPE_OCCURRENCE_EDEFAULT = TypeOccurrence.BEFORE;

	/**
	 * The cached value of the '{@link #getTypeOccurrence() <em>Type Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeOccurrence()
	 * @generated
	 * @ordered
	 */
	protected TypeOccurrence typeOccurrence = TYPE_OCCURRENCE_EDEFAULT;

	/**
	 * This is true if the Type Occurrence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeOccurrenceESet;

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
	protected SubPremiseNameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getSubPremiseName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, XalPackage.SUB_PREMISE_NAME__MIXED);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NAME__CODE, oldCode, code));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NAME__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeOccurrence getTypeOccurrence() {
		return typeOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeOccurrence(TypeOccurrence newTypeOccurrence) {
		TypeOccurrence oldTypeOccurrence = typeOccurrence;
		typeOccurrence = newTypeOccurrence == null ? TYPE_OCCURRENCE_EDEFAULT : newTypeOccurrence;
		boolean oldTypeOccurrenceESet = typeOccurrenceESet;
		typeOccurrenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NAME__TYPE_OCCURRENCE, oldTypeOccurrence, typeOccurrence, !oldTypeOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTypeOccurrence() {
		TypeOccurrence oldTypeOccurrence = typeOccurrence;
		boolean oldTypeOccurrenceESet = typeOccurrenceESet;
		typeOccurrence = TYPE_OCCURRENCE_EDEFAULT;
		typeOccurrenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.SUB_PREMISE_NAME__TYPE_OCCURRENCE, oldTypeOccurrence, TYPE_OCCURRENCE_EDEFAULT, oldTypeOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTypeOccurrence() {
		return typeOccurrenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.SUB_PREMISE_NAME__ANY_ATTRIBUTE);
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
			case XalPackage.SUB_PREMISE_NAME__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE_NAME__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NAME__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case XalPackage.SUB_PREMISE_NAME__CODE:
				return getCode();
			case XalPackage.SUB_PREMISE_NAME__TYPE:
				return getType();
			case XalPackage.SUB_PREMISE_NAME__TYPE_OCCURRENCE:
				return getTypeOccurrence();
			case XalPackage.SUB_PREMISE_NAME__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NAME__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case XalPackage.SUB_PREMISE_NAME__CODE:
				setCode(newValue);
				return;
			case XalPackage.SUB_PREMISE_NAME__TYPE:
				setType(newValue);
				return;
			case XalPackage.SUB_PREMISE_NAME__TYPE_OCCURRENCE:
				setTypeOccurrence((TypeOccurrence)newValue);
				return;
			case XalPackage.SUB_PREMISE_NAME__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NAME__MIXED:
				getMixed().clear();
				return;
			case XalPackage.SUB_PREMISE_NAME__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NAME__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NAME__TYPE_OCCURRENCE:
				unsetTypeOccurrence();
				return;
			case XalPackage.SUB_PREMISE_NAME__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NAME__MIXED:
				return mixed != null && !mixed.isEmpty();
			case XalPackage.SUB_PREMISE_NAME__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case XalPackage.SUB_PREMISE_NAME__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.SUB_PREMISE_NAME__TYPE_OCCURRENCE:
				return isSetTypeOccurrence();
			case XalPackage.SUB_PREMISE_NAME__ANY_ATTRIBUTE:
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
		result.append(", type: ");
		result.append(type);
		result.append(", typeOccurrence: ");
		if (typeOccurrenceESet) result.append(typeOccurrence); else result.append("<unset>");
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //SubPremiseNameImpl
