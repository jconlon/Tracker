/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.IndicatorOccurrence1;
import com.verticon.oasis.xal.NumberRangeOccurrence;
import com.verticon.oasis.xal.RangeTypeType;
import com.verticon.oasis.xal.ThoroughfareNumberFrom;
import com.verticon.oasis.xal.ThoroughfareNumberRange;
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thoroughfare Number Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getThoroughfareNumberFrom <em>Thoroughfare Number From</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getThoroughfareNumberTo <em>Thoroughfare Number To</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getIndicatorOccurrence <em>Indicator Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getNumberRangeOccurrence <em>Number Range Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getRangeType <em>Range Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getSeparator <em>Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThoroughfareNumberRangeImpl extends MinimalEObjectImpl.Container implements ThoroughfareNumberRange {
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
	 * The cached value of the '{@link #getThoroughfareNumberFrom() <em>Thoroughfare Number From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 * @ordered
	 */
	protected ThoroughfareNumberFrom thoroughfareNumberFrom;

	/**
	 * The cached value of the '{@link #getThoroughfareNumberTo() <em>Thoroughfare Number To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 * @ordered
	 */
	protected ThoroughfareNumberTo thoroughfareNumberTo;

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
	protected static final IndicatorOccurrence1 INDICATOR_OCCURRENCE_EDEFAULT = IndicatorOccurrence1.BEFORE;

	/**
	 * The cached value of the '{@link #getIndicatorOccurrence() <em>Indicator Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicatorOccurrence()
	 * @generated
	 * @ordered
	 */
	protected IndicatorOccurrence1 indicatorOccurrence = INDICATOR_OCCURRENCE_EDEFAULT;

	/**
	 * This is true if the Indicator Occurrence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indicatorOccurrenceESet;

	/**
	 * The default value of the '{@link #getNumberRangeOccurrence() <em>Number Range Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberRangeOccurrence()
	 * @generated
	 * @ordered
	 */
	protected static final NumberRangeOccurrence NUMBER_RANGE_OCCURRENCE_EDEFAULT = NumberRangeOccurrence.BEFORE_NAME;

	/**
	 * The cached value of the '{@link #getNumberRangeOccurrence() <em>Number Range Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberRangeOccurrence()
	 * @generated
	 * @ordered
	 */
	protected NumberRangeOccurrence numberRangeOccurrence = NUMBER_RANGE_OCCURRENCE_EDEFAULT;

	/**
	 * This is true if the Number Range Occurrence attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numberRangeOccurrenceESet;

	/**
	 * The default value of the '{@link #getRangeType() <em>Range Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeType()
	 * @generated
	 * @ordered
	 */
	protected static final RangeTypeType RANGE_TYPE_EDEFAULT = RangeTypeType.ODD;

	/**
	 * The cached value of the '{@link #getRangeType() <em>Range Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeType()
	 * @generated
	 * @ordered
	 */
	protected RangeTypeType rangeType = RANGE_TYPE_EDEFAULT;

	/**
	 * This is true if the Range Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean rangeTypeESet;

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
	protected ThoroughfareNumberRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getThoroughfareNumberRange();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.THOROUGHFARE_NUMBER_RANGE__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberFrom getThoroughfareNumberFrom() {
		return thoroughfareNumberFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfareNumberFrom(ThoroughfareNumberFrom newThoroughfareNumberFrom, NotificationChain msgs) {
		ThoroughfareNumberFrom oldThoroughfareNumberFrom = thoroughfareNumberFrom;
		thoroughfareNumberFrom = newThoroughfareNumberFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM, oldThoroughfareNumberFrom, newThoroughfareNumberFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfareNumberFrom(ThoroughfareNumberFrom newThoroughfareNumberFrom) {
		if (newThoroughfareNumberFrom != thoroughfareNumberFrom) {
			NotificationChain msgs = null;
			if (thoroughfareNumberFrom != null)
				msgs = ((InternalEObject)thoroughfareNumberFrom).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM, null, msgs);
			if (newThoroughfareNumberFrom != null)
				msgs = ((InternalEObject)newThoroughfareNumberFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM, null, msgs);
			msgs = basicSetThoroughfareNumberFrom(newThoroughfareNumberFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM, newThoroughfareNumberFrom, newThoroughfareNumberFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberTo getThoroughfareNumberTo() {
		return thoroughfareNumberTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfareNumberTo(ThoroughfareNumberTo newThoroughfareNumberTo, NotificationChain msgs) {
		ThoroughfareNumberTo oldThoroughfareNumberTo = thoroughfareNumberTo;
		thoroughfareNumberTo = newThoroughfareNumberTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO, oldThoroughfareNumberTo, newThoroughfareNumberTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfareNumberTo(ThoroughfareNumberTo newThoroughfareNumberTo) {
		if (newThoroughfareNumberTo != thoroughfareNumberTo) {
			NotificationChain msgs = null;
			if (thoroughfareNumberTo != null)
				msgs = ((InternalEObject)thoroughfareNumberTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO, null, msgs);
			if (newThoroughfareNumberTo != null)
				msgs = ((InternalEObject)newThoroughfareNumberTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO, null, msgs);
			msgs = basicSetThoroughfareNumberTo(newThoroughfareNumberTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO, newThoroughfareNumberTo, newThoroughfareNumberTo));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__CODE, oldCode, code));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR, oldIndicator, indicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence1 getIndicatorOccurrence() {
		return indicatorOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndicatorOccurrence(IndicatorOccurrence1 newIndicatorOccurrence) {
		IndicatorOccurrence1 oldIndicatorOccurrence = indicatorOccurrence;
		indicatorOccurrence = newIndicatorOccurrence == null ? INDICATOR_OCCURRENCE_EDEFAULT : newIndicatorOccurrence;
		boolean oldIndicatorOccurrenceESet = indicatorOccurrenceESet;
		indicatorOccurrenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR_OCCURRENCE, oldIndicatorOccurrence, indicatorOccurrence, !oldIndicatorOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndicatorOccurrence() {
		IndicatorOccurrence1 oldIndicatorOccurrence = indicatorOccurrence;
		boolean oldIndicatorOccurrenceESet = indicatorOccurrenceESet;
		indicatorOccurrence = INDICATOR_OCCURRENCE_EDEFAULT;
		indicatorOccurrenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR_OCCURRENCE, oldIndicatorOccurrence, INDICATOR_OCCURRENCE_EDEFAULT, oldIndicatorOccurrenceESet));
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
	public NumberRangeOccurrence getNumberRangeOccurrence() {
		return numberRangeOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberRangeOccurrence(NumberRangeOccurrence newNumberRangeOccurrence) {
		NumberRangeOccurrence oldNumberRangeOccurrence = numberRangeOccurrence;
		numberRangeOccurrence = newNumberRangeOccurrence == null ? NUMBER_RANGE_OCCURRENCE_EDEFAULT : newNumberRangeOccurrence;
		boolean oldNumberRangeOccurrenceESet = numberRangeOccurrenceESet;
		numberRangeOccurrenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__NUMBER_RANGE_OCCURRENCE, oldNumberRangeOccurrence, numberRangeOccurrence, !oldNumberRangeOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumberRangeOccurrence() {
		NumberRangeOccurrence oldNumberRangeOccurrence = numberRangeOccurrence;
		boolean oldNumberRangeOccurrenceESet = numberRangeOccurrenceESet;
		numberRangeOccurrence = NUMBER_RANGE_OCCURRENCE_EDEFAULT;
		numberRangeOccurrenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.THOROUGHFARE_NUMBER_RANGE__NUMBER_RANGE_OCCURRENCE, oldNumberRangeOccurrence, NUMBER_RANGE_OCCURRENCE_EDEFAULT, oldNumberRangeOccurrenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumberRangeOccurrence() {
		return numberRangeOccurrenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeTypeType getRangeType() {
		return rangeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRangeType(RangeTypeType newRangeType) {
		RangeTypeType oldRangeType = rangeType;
		rangeType = newRangeType == null ? RANGE_TYPE_EDEFAULT : newRangeType;
		boolean oldRangeTypeESet = rangeTypeESet;
		rangeTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__RANGE_TYPE, oldRangeType, rangeType, !oldRangeTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRangeType() {
		RangeTypeType oldRangeType = rangeType;
		boolean oldRangeTypeESet = rangeTypeESet;
		rangeType = RANGE_TYPE_EDEFAULT;
		rangeTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XalPackage.THOROUGHFARE_NUMBER_RANGE__RANGE_TYPE, oldRangeType, RANGE_TYPE_EDEFAULT, oldRangeTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRangeType() {
		return rangeTypeESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__SEPARATOR, oldSeparator, separator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.THOROUGHFARE_NUMBER_RANGE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.THOROUGHFARE_NUMBER_RANGE__ANY_ATTRIBUTE);
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
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM:
				return basicSetThoroughfareNumberFrom(null, msgs);
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO:
				return basicSetThoroughfareNumberTo(null, msgs);
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ANY_ATTRIBUTE:
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
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM:
				return getThoroughfareNumberFrom();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO:
				return getThoroughfareNumberTo();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__CODE:
				return getCode();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR:
				return getIndicator();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR_OCCURRENCE:
				return getIndicatorOccurrence();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__NUMBER_RANGE_OCCURRENCE:
				return getNumberRangeOccurrence();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__RANGE_TYPE:
				return getRangeType();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__SEPARATOR:
				return getSeparator();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__TYPE:
				return getType();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ANY_ATTRIBUTE:
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
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM:
				setThoroughfareNumberFrom((ThoroughfareNumberFrom)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO:
				setThoroughfareNumberTo((ThoroughfareNumberTo)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__CODE:
				setCode(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR:
				setIndicator(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR_OCCURRENCE:
				setIndicatorOccurrence((IndicatorOccurrence1)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__NUMBER_RANGE_OCCURRENCE:
				setNumberRangeOccurrence((NumberRangeOccurrence)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__RANGE_TYPE:
				setRangeType((RangeTypeType)newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__SEPARATOR:
				setSeparator(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__TYPE:
				setType(newValue);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ANY_ATTRIBUTE:
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
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM:
				setThoroughfareNumberFrom((ThoroughfareNumberFrom)null);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO:
				setThoroughfareNumberTo((ThoroughfareNumberTo)null);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR:
				setIndicator(INDICATOR_EDEFAULT);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR_OCCURRENCE:
				unsetIndicatorOccurrence();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__NUMBER_RANGE_OCCURRENCE:
				unsetNumberRangeOccurrence();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__RANGE_TYPE:
				unsetRangeType();
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__SEPARATOR:
				setSeparator(SEPARATOR_EDEFAULT);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ANY_ATTRIBUTE:
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
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM:
				return thoroughfareNumberFrom != null;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO:
				return thoroughfareNumberTo != null;
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR:
				return INDICATOR_EDEFAULT == null ? indicator != null : !INDICATOR_EDEFAULT.equals(indicator);
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__INDICATOR_OCCURRENCE:
				return isSetIndicatorOccurrence();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__NUMBER_RANGE_OCCURRENCE:
				return isSetNumberRangeOccurrence();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__RANGE_TYPE:
				return isSetRangeType();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__SEPARATOR:
				return SEPARATOR_EDEFAULT == null ? separator != null : !SEPARATOR_EDEFAULT.equals(separator);
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.THOROUGHFARE_NUMBER_RANGE__ANY_ATTRIBUTE:
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
		result.append(" (code: ");
		result.append(code);
		result.append(", indicator: ");
		result.append(indicator);
		result.append(", indicatorOccurrence: ");
		if (indicatorOccurrenceESet) result.append(indicatorOccurrence); else result.append("<unset>");
		result.append(", numberRangeOccurrence: ");
		if (numberRangeOccurrenceESet) result.append(numberRangeOccurrence); else result.append("<unset>");
		result.append(", rangeType: ");
		if (rangeTypeESet) result.append(rangeType); else result.append("<unset>");
		result.append(", separator: ");
		result.append(separator);
		result.append(", type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //ThoroughfareNumberRangeImpl
