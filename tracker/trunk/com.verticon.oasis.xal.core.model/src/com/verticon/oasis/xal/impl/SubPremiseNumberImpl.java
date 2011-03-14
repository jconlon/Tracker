/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.IndicatorOccurrence2;
import com.verticon.oasis.xal.NumberTypeOccurrence;
import com.verticon.oasis.xal.SubPremiseNumber;
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
 * An implementation of the model object '<em><b>Sub Premise Number</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl#getIndicatorOccurrence <em>Indicator Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl#getNumberTypeOccurrence <em>Number Type Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl#getPremiseNumberSeparator <em>Premise Number Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubPremiseNumberImpl extends MinimalEObjectImpl.Container implements SubPremiseNumber {
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
	protected static final IndicatorOccurrence2 INDICATOR_OCCURRENCE_EDEFAULT = IndicatorOccurrence2.BEFORE;

	/**
	 * The cached value of the '{@link #getIndicatorOccurrence() <em>Indicator Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicatorOccurrence()
	 * @generated
	 * @ordered
	 */
	protected IndicatorOccurrence2 indicatorOccurrence = INDICATOR_OCCURRENCE_EDEFAULT;

	/**
	 * This is true if the Indicator Occurrence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indicatorOccurrenceESet;

	/**
	 * The default value of the '{@link #getNumberTypeOccurrence() <em>Number Type Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberTypeOccurrence()
	 * @generated
	 * @ordered
	 */
	protected static final NumberTypeOccurrence NUMBER_TYPE_OCCURRENCE_EDEFAULT = NumberTypeOccurrence.BEFORE;

	/**
	 * The cached value of the '{@link #getNumberTypeOccurrence() <em>Number Type Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberTypeOccurrence()
	 * @generated
	 * @ordered
	 */
	protected NumberTypeOccurrence numberTypeOccurrence = NUMBER_TYPE_OCCURRENCE_EDEFAULT;

	/**
	 * This is true if the Number Type Occurrence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numberTypeOccurrenceESet;

	/**
	 * The default value of the '{@link #getPremiseNumberSeparator() <em>Premise Number Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final Object PREMISE_NUMBER_SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremiseNumberSeparator() <em>Premise Number Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberSeparator()
	 * @generated
	 * @ordered
	 */
	protected Object premiseNumberSeparator = PREMISE_NUMBER_SEPARATOR_EDEFAULT;

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
	protected SubPremiseNumberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getSubPremiseNumber();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, XalPackage.SUB_PREMISE_NUMBER__MIXED);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER__CODE, oldCode, code));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER__INDICATOR, oldIndicator, indicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence2 getIndicatorOccurrence() {
		return indicatorOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndicatorOccurrence(IndicatorOccurrence2 newIndicatorOccurrence) {
		IndicatorOccurrence2 oldIndicatorOccurrence = indicatorOccurrence;
		indicatorOccurrence = newIndicatorOccurrence == null ? INDICATOR_OCCURRENCE_EDEFAULT : newIndicatorOccurrence;
		boolean oldIndicatorOccurrenceESet = indicatorOccurrenceESet;
		indicatorOccurrenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER__INDICATOR_OCCURRENCE, oldIndicatorOccurrence, indicatorOccurrence, !oldIndicatorOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndicatorOccurrence() {
		IndicatorOccurrence2 oldIndicatorOccurrence = indicatorOccurrence;
		boolean oldIndicatorOccurrenceESet = indicatorOccurrenceESet;
		indicatorOccurrence = INDICATOR_OCCURRENCE_EDEFAULT;
		indicatorOccurrenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.SUB_PREMISE_NUMBER__INDICATOR_OCCURRENCE, oldIndicatorOccurrence, INDICATOR_OCCURRENCE_EDEFAULT, oldIndicatorOccurrenceESet));
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
	public NumberTypeOccurrence getNumberTypeOccurrence() {
		return numberTypeOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberTypeOccurrence(NumberTypeOccurrence newNumberTypeOccurrence) {
		NumberTypeOccurrence oldNumberTypeOccurrence = numberTypeOccurrence;
		numberTypeOccurrence = newNumberTypeOccurrence == null ? NUMBER_TYPE_OCCURRENCE_EDEFAULT : newNumberTypeOccurrence;
		boolean oldNumberTypeOccurrenceESet = numberTypeOccurrenceESet;
		numberTypeOccurrenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER__NUMBER_TYPE_OCCURRENCE, oldNumberTypeOccurrence, numberTypeOccurrence, !oldNumberTypeOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumberTypeOccurrence() {
		NumberTypeOccurrence oldNumberTypeOccurrence = numberTypeOccurrence;
		boolean oldNumberTypeOccurrenceESet = numberTypeOccurrenceESet;
		numberTypeOccurrence = NUMBER_TYPE_OCCURRENCE_EDEFAULT;
		numberTypeOccurrenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.SUB_PREMISE_NUMBER__NUMBER_TYPE_OCCURRENCE, oldNumberTypeOccurrence, NUMBER_TYPE_OCCURRENCE_EDEFAULT, oldNumberTypeOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumberTypeOccurrence() {
		return numberTypeOccurrenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPremiseNumberSeparator() {
		return premiseNumberSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseNumberSeparator(Object newPremiseNumberSeparator) {
		Object oldPremiseNumberSeparator = premiseNumberSeparator;
		premiseNumberSeparator = newPremiseNumberSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER__PREMISE_NUMBER_SEPARATOR, oldPremiseNumberSeparator, premiseNumberSeparator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE_NUMBER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.SUB_PREMISE_NUMBER__ANY_ATTRIBUTE);
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
			case XalPackage.SUB_PREMISE_NUMBER__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE_NUMBER__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NUMBER__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case XalPackage.SUB_PREMISE_NUMBER__CODE:
				return getCode();
			case XalPackage.SUB_PREMISE_NUMBER__INDICATOR:
				return getIndicator();
			case XalPackage.SUB_PREMISE_NUMBER__INDICATOR_OCCURRENCE:
				return getIndicatorOccurrence();
			case XalPackage.SUB_PREMISE_NUMBER__NUMBER_TYPE_OCCURRENCE:
				return getNumberTypeOccurrence();
			case XalPackage.SUB_PREMISE_NUMBER__PREMISE_NUMBER_SEPARATOR:
				return getPremiseNumberSeparator();
			case XalPackage.SUB_PREMISE_NUMBER__TYPE:
				return getType();
			case XalPackage.SUB_PREMISE_NUMBER__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NUMBER__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__CODE:
				setCode(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__INDICATOR:
				setIndicator(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__INDICATOR_OCCURRENCE:
				setIndicatorOccurrence((IndicatorOccurrence2)newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__NUMBER_TYPE_OCCURRENCE:
				setNumberTypeOccurrence((NumberTypeOccurrence)newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__PREMISE_NUMBER_SEPARATOR:
				setPremiseNumberSeparator(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__TYPE:
				setType(newValue);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NUMBER__MIXED:
				getMixed().clear();
				return;
			case XalPackage.SUB_PREMISE_NUMBER__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__INDICATOR:
				setIndicator(INDICATOR_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__INDICATOR_OCCURRENCE:
				unsetIndicatorOccurrence();
				return;
			case XalPackage.SUB_PREMISE_NUMBER__NUMBER_TYPE_OCCURRENCE:
				unsetNumberTypeOccurrence();
				return;
			case XalPackage.SUB_PREMISE_NUMBER__PREMISE_NUMBER_SEPARATOR:
				setPremiseNumberSeparator(PREMISE_NUMBER_SEPARATOR_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE_NUMBER__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE_NUMBER__MIXED:
				return mixed != null && !mixed.isEmpty();
			case XalPackage.SUB_PREMISE_NUMBER__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case XalPackage.SUB_PREMISE_NUMBER__INDICATOR:
				return INDICATOR_EDEFAULT == null ? indicator != null : !INDICATOR_EDEFAULT.equals(indicator);
			case XalPackage.SUB_PREMISE_NUMBER__INDICATOR_OCCURRENCE:
				return isSetIndicatorOccurrence();
			case XalPackage.SUB_PREMISE_NUMBER__NUMBER_TYPE_OCCURRENCE:
				return isSetNumberTypeOccurrence();
			case XalPackage.SUB_PREMISE_NUMBER__PREMISE_NUMBER_SEPARATOR:
				return PREMISE_NUMBER_SEPARATOR_EDEFAULT == null ? premiseNumberSeparator != null : !PREMISE_NUMBER_SEPARATOR_EDEFAULT.equals(premiseNumberSeparator);
			case XalPackage.SUB_PREMISE_NUMBER__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.SUB_PREMISE_NUMBER__ANY_ATTRIBUTE:
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
		result.append(", numberTypeOccurrence: ");
		if (numberTypeOccurrenceESet) result.append(numberTypeOccurrence); else result.append("<unset>");
		result.append(", premiseNumberSeparator: ");
		result.append(premiseNumberSeparator);
		result.append(", type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //SubPremiseNumberImpl
