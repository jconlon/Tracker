/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.MailStop;
import com.verticon.oasis.xal.MailStopName;
import com.verticon.oasis.xal.MailStopNumber;
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
 * An implementation of the model object '<em><b>Mail Stop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.MailStopImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.MailStopImpl#getMailStopName <em>Mail Stop Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.MailStopImpl#getMailStopNumber <em>Mail Stop Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.MailStopImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.MailStopImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.MailStopImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MailStopImpl extends MinimalEObjectImpl.Container implements MailStop {
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
	 * The cached value of the '{@link #getMailStopName() <em>Mail Stop Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailStopName()
	 * @generated
	 * @ordered
	 */
	protected MailStopName mailStopName;

	/**
	 * The cached value of the '{@link #getMailStopNumber() <em>Mail Stop Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailStopNumber()
	 * @generated
	 * @ordered
	 */
	protected MailStopNumber mailStopNumber;

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
	protected MailStopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getMailStop();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.MAIL_STOP__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailStopName getMailStopName() {
		return mailStopName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMailStopName(MailStopName newMailStopName, NotificationChain msgs) {
		MailStopName oldMailStopName = mailStopName;
		mailStopName = newMailStopName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.MAIL_STOP__MAIL_STOP_NAME, oldMailStopName, newMailStopName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailStopName(MailStopName newMailStopName) {
		if (newMailStopName != mailStopName) {
			NotificationChain msgs = null;
			if (mailStopName != null)
				msgs = ((InternalEObject)mailStopName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.MAIL_STOP__MAIL_STOP_NAME, null, msgs);
			if (newMailStopName != null)
				msgs = ((InternalEObject)newMailStopName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.MAIL_STOP__MAIL_STOP_NAME, null, msgs);
			msgs = basicSetMailStopName(newMailStopName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.MAIL_STOP__MAIL_STOP_NAME, newMailStopName, newMailStopName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailStopNumber getMailStopNumber() {
		return mailStopNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMailStopNumber(MailStopNumber newMailStopNumber, NotificationChain msgs) {
		MailStopNumber oldMailStopNumber = mailStopNumber;
		mailStopNumber = newMailStopNumber;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.MAIL_STOP__MAIL_STOP_NUMBER, oldMailStopNumber, newMailStopNumber);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailStopNumber(MailStopNumber newMailStopNumber) {
		if (newMailStopNumber != mailStopNumber) {
			NotificationChain msgs = null;
			if (mailStopNumber != null)
				msgs = ((InternalEObject)mailStopNumber).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.MAIL_STOP__MAIL_STOP_NUMBER, null, msgs);
			if (newMailStopNumber != null)
				msgs = ((InternalEObject)newMailStopNumber).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.MAIL_STOP__MAIL_STOP_NUMBER, null, msgs);
			msgs = basicSetMailStopNumber(newMailStopNumber, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.MAIL_STOP__MAIL_STOP_NUMBER, newMailStopNumber, newMailStopNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.MAIL_STOP__ANY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.MAIL_STOP__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.MAIL_STOP__ANY_ATTRIBUTE);
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
			case XalPackage.MAIL_STOP__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.MAIL_STOP__MAIL_STOP_NAME:
				return basicSetMailStopName(null, msgs);
			case XalPackage.MAIL_STOP__MAIL_STOP_NUMBER:
				return basicSetMailStopNumber(null, msgs);
			case XalPackage.MAIL_STOP__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.MAIL_STOP__ANY_ATTRIBUTE:
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
			case XalPackage.MAIL_STOP__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.MAIL_STOP__MAIL_STOP_NAME:
				return getMailStopName();
			case XalPackage.MAIL_STOP__MAIL_STOP_NUMBER:
				return getMailStopNumber();
			case XalPackage.MAIL_STOP__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.MAIL_STOP__TYPE:
				return getType();
			case XalPackage.MAIL_STOP__ANY_ATTRIBUTE:
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
			case XalPackage.MAIL_STOP__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.MAIL_STOP__MAIL_STOP_NAME:
				setMailStopName((MailStopName)newValue);
				return;
			case XalPackage.MAIL_STOP__MAIL_STOP_NUMBER:
				setMailStopNumber((MailStopNumber)newValue);
				return;
			case XalPackage.MAIL_STOP__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.MAIL_STOP__TYPE:
				setType(newValue);
				return;
			case XalPackage.MAIL_STOP__ANY_ATTRIBUTE:
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
			case XalPackage.MAIL_STOP__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.MAIL_STOP__MAIL_STOP_NAME:
				setMailStopName((MailStopName)null);
				return;
			case XalPackage.MAIL_STOP__MAIL_STOP_NUMBER:
				setMailStopNumber((MailStopNumber)null);
				return;
			case XalPackage.MAIL_STOP__ANY:
				getAny().clear();
				return;
			case XalPackage.MAIL_STOP__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.MAIL_STOP__ANY_ATTRIBUTE:
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
			case XalPackage.MAIL_STOP__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.MAIL_STOP__MAIL_STOP_NAME:
				return mailStopName != null;
			case XalPackage.MAIL_STOP__MAIL_STOP_NUMBER:
				return mailStopNumber != null;
			case XalPackage.MAIL_STOP__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.MAIL_STOP__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.MAIL_STOP__ANY_ATTRIBUTE:
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

} //MailStopImpl
