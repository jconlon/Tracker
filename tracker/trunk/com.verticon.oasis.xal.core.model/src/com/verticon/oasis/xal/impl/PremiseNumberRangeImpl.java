/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.IndicatorOccurence;
import com.verticon.oasis.xal.NumberRangeOccurence;
import com.verticon.oasis.xal.PremiseNumberRange;
import com.verticon.oasis.xal.PremiseNumberRangeFrom;
import com.verticon.oasis.xal.PremiseNumberRangeTo;
import com.verticon.oasis.xal.XalPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Premise Number Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl#getPremiseNumberRangeFrom <em>Premise Number Range From</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl#getPremiseNumberRangeTo <em>Premise Number Range To</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl#getIndicatorOccurence <em>Indicator Occurence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl#getNumberRangeOccurence <em>Number Range Occurence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl#getRangeType <em>Range Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl#getSeparator <em>Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PremiseNumberRangeImpl extends MinimalEObjectImpl.Container implements PremiseNumberRange {
	/**
	 * The cached value of the '{@link #getPremiseNumberRangeFrom() <em>Premise Number Range From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberRangeFrom()
	 * @generated
	 * @ordered
	 */
	protected PremiseNumberRangeFrom premiseNumberRangeFrom;

	/**
	 * The cached value of the '{@link #getPremiseNumberRangeTo() <em>Premise Number Range To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberRangeTo()
	 * @generated
	 * @ordered
	 */
	protected PremiseNumberRangeTo premiseNumberRangeTo;

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
	 * The default value of the '{@link #getIndicatorOccurence() <em>Indicator Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicatorOccurence()
	 * @generated
	 * @ordered
	 */
	protected static final IndicatorOccurence INDICATOR_OCCURENCE_EDEFAULT = IndicatorOccurence.BEFORE;

	/**
	 * The cached value of the '{@link #getIndicatorOccurence() <em>Indicator Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicatorOccurence()
	 * @generated
	 * @ordered
	 */
	protected IndicatorOccurence indicatorOccurence = INDICATOR_OCCURENCE_EDEFAULT;

	/**
	 * This is true if the Indicator Occurence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indicatorOccurenceESet;

	/**
	 * The default value of the '{@link #getNumberRangeOccurence() <em>Number Range Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberRangeOccurence()
	 * @generated
	 * @ordered
	 */
	protected static final NumberRangeOccurence NUMBER_RANGE_OCCURENCE_EDEFAULT = NumberRangeOccurence.BEFORE_NAME;

	/**
	 * The cached value of the '{@link #getNumberRangeOccurence() <em>Number Range Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberRangeOccurence()
	 * @generated
	 * @ordered
	 */
	protected NumberRangeOccurence numberRangeOccurence = NUMBER_RANGE_OCCURENCE_EDEFAULT;

	/**
	 * This is true if the Number Range Occurence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numberRangeOccurenceESet;

	/**
	 * The default value of the '{@link #getRangeType() <em>Range Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeType()
	 * @generated
	 * @ordered
	 */
	protected static final Object RANGE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRangeType() <em>Range Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeType()
	 * @generated
	 * @ordered
	 */
	protected Object rangeType = RANGE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final Object SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected Object separator = SEPARATOR_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PremiseNumberRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getPremiseNumberRange();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberRangeFrom getPremiseNumberRangeFrom() {
		return premiseNumberRangeFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremiseNumberRangeFrom(PremiseNumberRangeFrom newPremiseNumberRangeFrom, NotificationChain msgs) {
		PremiseNumberRangeFrom oldPremiseNumberRangeFrom = premiseNumberRangeFrom;
		premiseNumberRangeFrom = newPremiseNumberRangeFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM, oldPremiseNumberRangeFrom, newPremiseNumberRangeFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseNumberRangeFrom(PremiseNumberRangeFrom newPremiseNumberRangeFrom) {
		if (newPremiseNumberRangeFrom != premiseNumberRangeFrom) {
			NotificationChain msgs = null;
			if (premiseNumberRangeFrom != null)
				msgs = ((InternalEObject)premiseNumberRangeFrom).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM, null, msgs);
			if (newPremiseNumberRangeFrom != null)
				msgs = ((InternalEObject)newPremiseNumberRangeFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM, null, msgs);
			msgs = basicSetPremiseNumberRangeFrom(newPremiseNumberRangeFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM, newPremiseNumberRangeFrom, newPremiseNumberRangeFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberRangeTo getPremiseNumberRangeTo() {
		return premiseNumberRangeTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremiseNumberRangeTo(PremiseNumberRangeTo newPremiseNumberRangeTo, NotificationChain msgs) {
		PremiseNumberRangeTo oldPremiseNumberRangeTo = premiseNumberRangeTo;
		premiseNumberRangeTo = newPremiseNumberRangeTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO, oldPremiseNumberRangeTo, newPremiseNumberRangeTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseNumberRangeTo(PremiseNumberRangeTo newPremiseNumberRangeTo) {
		if (newPremiseNumberRangeTo != premiseNumberRangeTo) {
			NotificationChain msgs = null;
			if (premiseNumberRangeTo != null)
				msgs = ((InternalEObject)premiseNumberRangeTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO, null, msgs);
			if (newPremiseNumberRangeTo != null)
				msgs = ((InternalEObject)newPremiseNumberRangeTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO, null, msgs);
			msgs = basicSetPremiseNumberRangeTo(newPremiseNumberRangeTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO, newPremiseNumberRangeTo, newPremiseNumberRangeTo));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__INDICATOR, oldIndicator, indicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurence getIndicatorOccurence() {
		return indicatorOccurence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndicatorOccurence(IndicatorOccurence newIndicatorOccurence) {
		IndicatorOccurence oldIndicatorOccurence = indicatorOccurence;
		indicatorOccurence = newIndicatorOccurence == null ? INDICATOR_OCCURENCE_EDEFAULT : newIndicatorOccurence;
		boolean oldIndicatorOccurenceESet = indicatorOccurenceESet;
		indicatorOccurenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__INDICATOR_OCCURENCE, oldIndicatorOccurence, indicatorOccurence, !oldIndicatorOccurenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndicatorOccurence() {
		IndicatorOccurence oldIndicatorOccurence = indicatorOccurence;
		boolean oldIndicatorOccurenceESet = indicatorOccurenceESet;
		indicatorOccurence = INDICATOR_OCCURENCE_EDEFAULT;
		indicatorOccurenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.PREMISE_NUMBER_RANGE__INDICATOR_OCCURENCE, oldIndicatorOccurence, INDICATOR_OCCURENCE_EDEFAULT, oldIndicatorOccurenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIndicatorOccurence() {
		return indicatorOccurenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberRangeOccurence getNumberRangeOccurence() {
		return numberRangeOccurence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberRangeOccurence(NumberRangeOccurence newNumberRangeOccurence) {
		NumberRangeOccurence oldNumberRangeOccurence = numberRangeOccurence;
		numberRangeOccurence = newNumberRangeOccurence == null ? NUMBER_RANGE_OCCURENCE_EDEFAULT : newNumberRangeOccurence;
		boolean oldNumberRangeOccurenceESet = numberRangeOccurenceESet;
		numberRangeOccurenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__NUMBER_RANGE_OCCURENCE, oldNumberRangeOccurence, numberRangeOccurence, !oldNumberRangeOccurenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumberRangeOccurence() {
		NumberRangeOccurence oldNumberRangeOccurence = numberRangeOccurence;
		boolean oldNumberRangeOccurenceESet = numberRangeOccurenceESet;
		numberRangeOccurence = NUMBER_RANGE_OCCURENCE_EDEFAULT;
		numberRangeOccurenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.PREMISE_NUMBER_RANGE__NUMBER_RANGE_OCCURENCE, oldNumberRangeOccurence, NUMBER_RANGE_OCCURENCE_EDEFAULT, oldNumberRangeOccurenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumberRangeOccurence() {
		return numberRangeOccurenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRangeType() {
		return rangeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRangeType(Object newRangeType) {
		Object oldRangeType = rangeType;
		rangeType = newRangeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__RANGE_TYPE, oldRangeType, rangeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSeparator() {
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeparator(Object newSeparator) {
		Object oldSeparator = separator;
		separator = newSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__SEPARATOR, oldSeparator, separator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE_NUMBER_RANGE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM:
				return basicSetPremiseNumberRangeFrom(null, msgs);
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO:
				return basicSetPremiseNumberRangeTo(null, msgs);
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
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM:
				return getPremiseNumberRangeFrom();
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO:
				return getPremiseNumberRangeTo();
			case XalPackage.PREMISE_NUMBER_RANGE__INDICATOR:
				return getIndicator();
			case XalPackage.PREMISE_NUMBER_RANGE__INDICATOR_OCCURENCE:
				return getIndicatorOccurence();
			case XalPackage.PREMISE_NUMBER_RANGE__NUMBER_RANGE_OCCURENCE:
				return getNumberRangeOccurence();
			case XalPackage.PREMISE_NUMBER_RANGE__RANGE_TYPE:
				return getRangeType();
			case XalPackage.PREMISE_NUMBER_RANGE__SEPARATOR:
				return getSeparator();
			case XalPackage.PREMISE_NUMBER_RANGE__TYPE:
				return getType();
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
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM:
				setPremiseNumberRangeFrom((PremiseNumberRangeFrom)newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO:
				setPremiseNumberRangeTo((PremiseNumberRangeTo)newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__INDICATOR:
				setIndicator(newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__INDICATOR_OCCURENCE:
				setIndicatorOccurence((IndicatorOccurence)newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__NUMBER_RANGE_OCCURENCE:
				setNumberRangeOccurence((NumberRangeOccurence)newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__RANGE_TYPE:
				setRangeType(newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__SEPARATOR:
				setSeparator(newValue);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__TYPE:
				setType(newValue);
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
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM:
				setPremiseNumberRangeFrom((PremiseNumberRangeFrom)null);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO:
				setPremiseNumberRangeTo((PremiseNumberRangeTo)null);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__INDICATOR:
				setIndicator(INDICATOR_EDEFAULT);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__INDICATOR_OCCURENCE:
				unsetIndicatorOccurence();
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__NUMBER_RANGE_OCCURENCE:
				unsetNumberRangeOccurence();
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__RANGE_TYPE:
				setRangeType(RANGE_TYPE_EDEFAULT);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__SEPARATOR:
				setSeparator(SEPARATOR_EDEFAULT);
				return;
			case XalPackage.PREMISE_NUMBER_RANGE__TYPE:
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
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM:
				return premiseNumberRangeFrom != null;
			case XalPackage.PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO:
				return premiseNumberRangeTo != null;
			case XalPackage.PREMISE_NUMBER_RANGE__INDICATOR:
				return INDICATOR_EDEFAULT == null ? indicator != null : !INDICATOR_EDEFAULT.equals(indicator);
			case XalPackage.PREMISE_NUMBER_RANGE__INDICATOR_OCCURENCE:
				return isSetIndicatorOccurence();
			case XalPackage.PREMISE_NUMBER_RANGE__NUMBER_RANGE_OCCURENCE:
				return isSetNumberRangeOccurence();
			case XalPackage.PREMISE_NUMBER_RANGE__RANGE_TYPE:
				return RANGE_TYPE_EDEFAULT == null ? rangeType != null : !RANGE_TYPE_EDEFAULT.equals(rangeType);
			case XalPackage.PREMISE_NUMBER_RANGE__SEPARATOR:
				return SEPARATOR_EDEFAULT == null ? separator != null : !SEPARATOR_EDEFAULT.equals(separator);
			case XalPackage.PREMISE_NUMBER_RANGE__TYPE:
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
		result.append(" (indicator: ");
		result.append(indicator);
		result.append(", indicatorOccurence: ");
		if (indicatorOccurenceESet) result.append(indicatorOccurence); else result.append("<unset>");
		result.append(", numberRangeOccurence: ");
		if (numberRangeOccurenceESet) result.append(numberRangeOccurence); else result.append("<unset>");
		result.append(", rangeType: ");
		result.append(rangeType);
		result.append(", separator: ");
		result.append(separator);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //PremiseNumberRangeImpl
