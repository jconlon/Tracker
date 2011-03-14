/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.DependentThoroughfare;
import com.verticon.oasis.xal.ThoroughfareLeadingType;
import com.verticon.oasis.xal.ThoroughfareName;
import com.verticon.oasis.xal.ThoroughfarePostDirection;
import com.verticon.oasis.xal.ThoroughfarePreDirection;
import com.verticon.oasis.xal.ThoroughfareTrailingType;
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
 * An implementation of the model object '<em><b>Dependent Thoroughfare</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getThoroughfareName <em>Thoroughfare Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependentThoroughfareImpl extends MinimalEObjectImpl.Container implements DependentThoroughfare {
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
	 * The cached value of the '{@link #getThoroughfarePreDirection() <em>Thoroughfare Pre Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThoroughfarePreDirection()
	 * @generated
	 * @ordered
	 */
	protected ThoroughfarePreDirection thoroughfarePreDirection;

	/**
	 * The cached value of the '{@link #getThoroughfareLeadingType() <em>Thoroughfare Leading Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThoroughfareLeadingType()
	 * @generated
	 * @ordered
	 */
	protected ThoroughfareLeadingType thoroughfareLeadingType;

	/**
	 * The cached value of the '{@link #getThoroughfareName() <em>Thoroughfare Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThoroughfareName()
	 * @generated
	 * @ordered
	 */
	protected EList<ThoroughfareName> thoroughfareName;

	/**
	 * The cached value of the '{@link #getThoroughfareTrailingType() <em>Thoroughfare Trailing Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThoroughfareTrailingType()
	 * @generated
	 * @ordered
	 */
	protected ThoroughfareTrailingType thoroughfareTrailingType;

	/**
	 * The cached value of the '{@link #getThoroughfarePostDirection() <em>Thoroughfare Post Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThoroughfarePostDirection()
	 * @generated
	 * @ordered
	 */
	protected ThoroughfarePostDirection thoroughfarePostDirection;

	/**
	 * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAny()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap any;

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
	protected DependentThoroughfareImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getDependentThoroughfare();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.DEPENDENT_THOROUGHFARE__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfarePreDirection getThoroughfarePreDirection() {
		return thoroughfarePreDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfarePreDirection(ThoroughfarePreDirection newThoroughfarePreDirection, NotificationChain msgs) {
		ThoroughfarePreDirection oldThoroughfarePreDirection = thoroughfarePreDirection;
		thoroughfarePreDirection = newThoroughfarePreDirection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION, oldThoroughfarePreDirection, newThoroughfarePreDirection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfarePreDirection(ThoroughfarePreDirection newThoroughfarePreDirection) {
		if (newThoroughfarePreDirection != thoroughfarePreDirection) {
			NotificationChain msgs = null;
			if (thoroughfarePreDirection != null)
				msgs = ((InternalEObject)thoroughfarePreDirection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION, null, msgs);
			if (newThoroughfarePreDirection != null)
				msgs = ((InternalEObject)newThoroughfarePreDirection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION, null, msgs);
			msgs = basicSetThoroughfarePreDirection(newThoroughfarePreDirection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION, newThoroughfarePreDirection, newThoroughfarePreDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareLeadingType getThoroughfareLeadingType() {
		return thoroughfareLeadingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfareLeadingType(ThoroughfareLeadingType newThoroughfareLeadingType, NotificationChain msgs) {
		ThoroughfareLeadingType oldThoroughfareLeadingType = thoroughfareLeadingType;
		thoroughfareLeadingType = newThoroughfareLeadingType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE, oldThoroughfareLeadingType, newThoroughfareLeadingType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfareLeadingType(ThoroughfareLeadingType newThoroughfareLeadingType) {
		if (newThoroughfareLeadingType != thoroughfareLeadingType) {
			NotificationChain msgs = null;
			if (thoroughfareLeadingType != null)
				msgs = ((InternalEObject)thoroughfareLeadingType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE, null, msgs);
			if (newThoroughfareLeadingType != null)
				msgs = ((InternalEObject)newThoroughfareLeadingType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE, null, msgs);
			msgs = basicSetThoroughfareLeadingType(newThoroughfareLeadingType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE, newThoroughfareLeadingType, newThoroughfareLeadingType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThoroughfareName> getThoroughfareName() {
		if (thoroughfareName == null) {
			thoroughfareName = new EObjectContainmentEList<ThoroughfareName>(ThoroughfareName.class, this, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_NAME);
		}
		return thoroughfareName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareTrailingType getThoroughfareTrailingType() {
		return thoroughfareTrailingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfareTrailingType(ThoroughfareTrailingType newThoroughfareTrailingType, NotificationChain msgs) {
		ThoroughfareTrailingType oldThoroughfareTrailingType = thoroughfareTrailingType;
		thoroughfareTrailingType = newThoroughfareTrailingType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE, oldThoroughfareTrailingType, newThoroughfareTrailingType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfareTrailingType(ThoroughfareTrailingType newThoroughfareTrailingType) {
		if (newThoroughfareTrailingType != thoroughfareTrailingType) {
			NotificationChain msgs = null;
			if (thoroughfareTrailingType != null)
				msgs = ((InternalEObject)thoroughfareTrailingType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE, null, msgs);
			if (newThoroughfareTrailingType != null)
				msgs = ((InternalEObject)newThoroughfareTrailingType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE, null, msgs);
			msgs = basicSetThoroughfareTrailingType(newThoroughfareTrailingType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE, newThoroughfareTrailingType, newThoroughfareTrailingType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfarePostDirection getThoroughfarePostDirection() {
		return thoroughfarePostDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfarePostDirection(ThoroughfarePostDirection newThoroughfarePostDirection, NotificationChain msgs) {
		ThoroughfarePostDirection oldThoroughfarePostDirection = thoroughfarePostDirection;
		thoroughfarePostDirection = newThoroughfarePostDirection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION, oldThoroughfarePostDirection, newThoroughfarePostDirection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfarePostDirection(ThoroughfarePostDirection newThoroughfarePostDirection) {
		if (newThoroughfarePostDirection != thoroughfarePostDirection) {
			NotificationChain msgs = null;
			if (thoroughfarePostDirection != null)
				msgs = ((InternalEObject)thoroughfarePostDirection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION, null, msgs);
			if (newThoroughfarePostDirection != null)
				msgs = ((InternalEObject)newThoroughfarePostDirection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION, null, msgs);
			msgs = basicSetThoroughfarePostDirection(newThoroughfarePostDirection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION, newThoroughfarePostDirection, newThoroughfarePostDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.DEPENDENT_THOROUGHFARE__ANY);
		}
		return any;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.DEPENDENT_THOROUGHFARE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.DEPENDENT_THOROUGHFARE__ANY_ATTRIBUTE);
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
			case XalPackage.DEPENDENT_THOROUGHFARE__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION:
				return basicSetThoroughfarePreDirection(null, msgs);
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE:
				return basicSetThoroughfareLeadingType(null, msgs);
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_NAME:
				return ((InternalEList<?>)getThoroughfareName()).basicRemove(otherEnd, msgs);
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE:
				return basicSetThoroughfareTrailingType(null, msgs);
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION:
				return basicSetThoroughfarePostDirection(null, msgs);
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY_ATTRIBUTE:
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
			case XalPackage.DEPENDENT_THOROUGHFARE__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION:
				return getThoroughfarePreDirection();
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE:
				return getThoroughfareLeadingType();
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_NAME:
				return getThoroughfareName();
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE:
				return getThoroughfareTrailingType();
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION:
				return getThoroughfarePostDirection();
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.DEPENDENT_THOROUGHFARE__TYPE:
				return getType();
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY_ATTRIBUTE:
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
			case XalPackage.DEPENDENT_THOROUGHFARE__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION:
				setThoroughfarePreDirection((ThoroughfarePreDirection)newValue);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE:
				setThoroughfareLeadingType((ThoroughfareLeadingType)newValue);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_NAME:
				getThoroughfareName().clear();
				getThoroughfareName().addAll((Collection<? extends ThoroughfareName>)newValue);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE:
				setThoroughfareTrailingType((ThoroughfareTrailingType)newValue);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION:
				setThoroughfarePostDirection((ThoroughfarePostDirection)newValue);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__TYPE:
				setType(newValue);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY_ATTRIBUTE:
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
			case XalPackage.DEPENDENT_THOROUGHFARE__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION:
				setThoroughfarePreDirection((ThoroughfarePreDirection)null);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE:
				setThoroughfareLeadingType((ThoroughfareLeadingType)null);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_NAME:
				getThoroughfareName().clear();
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE:
				setThoroughfareTrailingType((ThoroughfareTrailingType)null);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION:
				setThoroughfarePostDirection((ThoroughfarePostDirection)null);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY:
				getAny().clear();
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY_ATTRIBUTE:
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
			case XalPackage.DEPENDENT_THOROUGHFARE__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION:
				return thoroughfarePreDirection != null;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE:
				return thoroughfareLeadingType != null;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_NAME:
				return thoroughfareName != null && !thoroughfareName.isEmpty();
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE:
				return thoroughfareTrailingType != null;
			case XalPackage.DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION:
				return thoroughfarePostDirection != null;
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.DEPENDENT_THOROUGHFARE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.DEPENDENT_THOROUGHFARE__ANY_ATTRIBUTE:
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
		result.append(" (any: ");
		result.append(any);
		result.append(", type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //DependentThoroughfareImpl
