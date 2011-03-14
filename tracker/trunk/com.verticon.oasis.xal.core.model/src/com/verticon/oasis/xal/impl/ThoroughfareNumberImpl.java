/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.IndicatorOccurrence4;
import com.verticon.oasis.xal.NumberOccurrence;
import com.verticon.oasis.xal.NumberTypeType1;
import com.verticon.oasis.xal.ThoroughfareNumber;
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
 * An implementation of the model object '<em><b>Thoroughfare Number</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl#getIndicatorOccurrence <em>Indicator Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl#getNumberOccurrence <em>Number Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl#getNumberType <em>Number Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThoroughfareNumberImpl extends MinimalEObjectImpl.Container implements ThoroughfareNumber {
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
	 * The default value of the '{@link #getIndicator() <em>Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicator()
	 * @generated
	 * @ordered
	 */
	protected static final Object INDICATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndicator() <em>Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicator()
	 * @generated
	 * @ordered
	 */
	protected Object indicator = INDICATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndicatorOccurrence() <em>Indicator Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicatorOccurrence()
	 * @generated
	 * @ordered
	 */
	protected static final IndicatorOccurrence4 INDICATOR_OCCURRENCE_EDEFAULT = IndicatorOccurrence4.BEFORE;

	/**
	 * The cached value of the '{@link #getIndicatorOccurrence() <em>Indicator Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicatorOccurrence()
	 * @generated
	 * @ordered
	 */
	protected IndicatorOccurrence4 indicatorOccurrence = INDICATOR_OCCURRENCE_EDEFAULT;

	/**
	 * This is true if the Indicator Occurrence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indicatorOccurrenceESet;

	/**
	 * The default value of the '{@link #getNumberOccurrence() <em>Number Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOccurrence()
	 * @generated
	 * @ordered
	 */
	protected static final NumberOccurrence NUMBER_OCCURRENCE_EDEFAULT = NumberOccurrence.BEFORE_NAME;

	/**
	 * The cached value of the '{@link #getNumberOccurrence() <em>Number Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOccurrence()
	 * @generated
	 * @ordered
	 */
	protected NumberOccurrence numberOccurrence = NUMBER_OCCURRENCE_EDEFAULT;

	/**
	 * This is true if the Number Occurrence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numberOccurrenceESet;

	/**
	 * The default value of the '{@link #getNumberType() <em>Number Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberType()
	 * @generated
	 * @ordered
	 */
	protected static final NumberTypeType1 NUMBER_TYPE_EDEFAULT = NumberTypeType1.SINGLE;

	/**
	 * The cached value of the '{@link #getNumberType() <em>Number Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberType()
	 * @generated
	 * @ordered
	 */
	protected NumberTypeType1 numberType = NUMBER_TYPE_EDEFAULT;

	/**
	 * This is true if the Number Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numberTypeESet;

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
	protected ThoroughfareNumberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getThoroughfareNumber();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, XalPackage.THOROUGHFARE_NUMBER__MIXED);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIndicator() {
		return indicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndicator(Object newIndicator) {
		Object oldIndicator = indicator;
		indicator = newIndicator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER__INDICATOR, oldIndicator, indicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence4 getIndicatorOccurrence() {
		return indicatorOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndicatorOccurrence(IndicatorOccurrence4 newIndicatorOccurrence) {
		IndicatorOccurrence4 oldIndicatorOccurrence = indicatorOccurrence;
		indicatorOccurrence = newIndicatorOccurrence == null ? INDICATOR_OCCURRENCE_EDEFAULT : newIndicatorOccurrence;
		boolean oldIndicatorOccurrenceESet = indicatorOccurrenceESet;
		indicatorOccurrenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER__INDICATOR_OCCURRENCE, oldIndicatorOccurrence, indicatorOccurrence, !oldIndicatorOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndicatorOccurrence() {
		IndicatorOccurrence4 oldIndicatorOccurrence = indicatorOccurrence;
		boolean oldIndicatorOccurrenceESet = indicatorOccurrenceESet;
		indicatorOccurrence = INDICATOR_OCCURRENCE_EDEFAULT;
		indicatorOccurrenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.THOROUGHFARE_NUMBER__INDICATOR_OCCURRENCE, oldIndicatorOccurrence, INDICATOR_OCCURRENCE_EDEFAULT, oldIndicatorOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIndicatorOccurrence() {
		return indicatorOccurrenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberOccurrence getNumberOccurrence() {
		return numberOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOccurrence(NumberOccurrence newNumberOccurrence) {
		NumberOccurrence oldNumberOccurrence = numberOccurrence;
		numberOccurrence = newNumberOccurrence == null ? NUMBER_OCCURRENCE_EDEFAULT : newNumberOccurrence;
		boolean oldNumberOccurrenceESet = numberOccurrenceESet;
		numberOccurrenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER__NUMBER_OCCURRENCE, oldNumberOccurrence, numberOccurrence, !oldNumberOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumberOccurrence() {
		NumberOccurrence oldNumberOccurrence = numberOccurrence;
		boolean oldNumberOccurrenceESet = numberOccurrenceESet;
		numberOccurrence = NUMBER_OCCURRENCE_EDEFAULT;
		numberOccurrenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.THOROUGHFARE_NUMBER__NUMBER_OCCURRENCE, oldNumberOccurrence, NUMBER_OCCURRENCE_EDEFAULT, oldNumberOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumberOccurrence() {
		return numberOccurrenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeType1 getNumberType() {
		return numberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberType(NumberTypeType1 newNumberType) {
		NumberTypeType1 oldNumberType = numberType;
		numberType = newNumberType == null ? NUMBER_TYPE_EDEFAULT : newNumberType;
		boolean oldNumberTypeESet = numberTypeESet;
		numberTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER__NUMBER_TYPE, oldNumberType, numberType, !oldNumberTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumberType() {
		NumberTypeType1 oldNumberType = numberType;
		boolean oldNumberTypeESet = numberTypeESet;
		numberType = NUMBER_TYPE_EDEFAULT;
		numberTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.THOROUGHFARE_NUMBER__NUMBER_TYPE, oldNumberType, NUMBER_TYPE_EDEFAULT, oldNumberTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumberType() {
		return numberTypeESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.THOROUGHFARE_NUMBER__ANY_ATTRIBUTE);
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
			case XalPackage.THOROUGHFARE_NUMBER__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case XalPackage.THOROUGHFARE_NUMBER__ANY_ATTRIBUTE:
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
			case XalPackage.THOROUGHFARE_NUMBER__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case XalPackage.THOROUGHFARE_NUMBER__CODE:
				return getCode();
			case XalPackage.THOROUGHFARE_NUMBER__INDICATOR:
				return getIndicator();
			case XalPackage.THOROUGHFARE_NUMBER__INDICATOR_OCCURRENCE:
				return getIndicatorOccurrence();
			case XalPackage.THOROUGHFARE_NUMBER__NUMBER_OCCURRENCE:
				return getNumberOccurrence();
			case XalPackage.THOROUGHFARE_NUMBER__NUMBER_TYPE:
				return getNumberType();
			case XalPackage.THOROUGHFARE_NUMBER__TYPE:
				return getType();
			case XalPackage.THOROUGHFARE_NUMBER__ANY_ATTRIBUTE:
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
			case XalPackage.THOROUGHFARE_NUMBER__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__CODE:
				setCode(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__INDICATOR:
				setIndicator(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__INDICATOR_OCCURRENCE:
				setIndicatorOccurrence((IndicatorOccurrence4)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__NUMBER_OCCURRENCE:
				setNumberOccurrence((NumberOccurrence)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__NUMBER_TYPE:
				setNumberType((NumberTypeType1)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__TYPE:
				setType(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__ANY_ATTRIBUTE:
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
			case XalPackage.THOROUGHFARE_NUMBER__MIXED:
				getMixed().clear();
				return;
			case XalPackage.THOROUGHFARE_NUMBER__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__INDICATOR:
				setIndicator(INDICATOR_EDEFAULT);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__INDICATOR_OCCURRENCE:
				unsetIndicatorOccurrence();
				return;
			case XalPackage.THOROUGHFARE_NUMBER__NUMBER_OCCURRENCE:
				unsetNumberOccurrence();
				return;
			case XalPackage.THOROUGHFARE_NUMBER__NUMBER_TYPE:
				unsetNumberType();
				return;
			case XalPackage.THOROUGHFARE_NUMBER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.THOROUGHFARE_NUMBER__ANY_ATTRIBUTE:
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
			case XalPackage.THOROUGHFARE_NUMBER__MIXED:
				return mixed != null && !mixed.isEmpty();
			case XalPackage.THOROUGHFARE_NUMBER__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case XalPackage.THOROUGHFARE_NUMBER__INDICATOR:
				return INDICATOR_EDEFAULT == null ? indicator != null : !INDICATOR_EDEFAULT.equals(indicator);
			case XalPackage.THOROUGHFARE_NUMBER__INDICATOR_OCCURRENCE:
				return isSetIndicatorOccurrence();
			case XalPackage.THOROUGHFARE_NUMBER__NUMBER_OCCURRENCE:
				return isSetNumberOccurrence();
			case XalPackage.THOROUGHFARE_NUMBER__NUMBER_TYPE:
				return isSetNumberType();
			case XalPackage.THOROUGHFARE_NUMBER__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.THOROUGHFARE_NUMBER__ANY_ATTRIBUTE:
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
		result.append(", indicator: ");
		result.append(indicator);
		result.append(", indicatorOccurrence: ");
		if (indicatorOccurrenceESet) result.append(indicatorOccurrence); else result.append("<unset>");
		result.append(", numberOccurrence: ");
		if (numberOccurrenceESet) result.append(numberOccurrence); else result.append("<unset>");
		result.append(", numberType: ");
		if (numberTypeESet) result.append(numberType); else result.append("<unset>");
		result.append(", type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //ThoroughfareNumberImpl
