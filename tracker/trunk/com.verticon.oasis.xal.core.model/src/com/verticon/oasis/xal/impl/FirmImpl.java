/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.Department;
import com.verticon.oasis.xal.Firm;
import com.verticon.oasis.xal.FirmName;
import com.verticon.oasis.xal.MailStop;
import com.verticon.oasis.xal.PostalCode;
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
 * An implementation of the model object '<em><b>Firm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.FirmImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.FirmImpl#getFirmName <em>Firm Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.FirmImpl#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.FirmImpl#getMailStop <em>Mail Stop</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.FirmImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.FirmImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.FirmImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.FirmImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FirmImpl extends MinimalEObjectImpl.Container implements Firm {
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
	 * The cached value of the '{@link #getFirmName() <em>Firm Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirmName()
	 * @generated
	 * @ordered
	 */
	protected EList<FirmName> firmName;

	/**
	 * The cached value of the '{@link #getDepartment() <em>Department</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartment()
	 * @generated
	 * @ordered
	 */
	protected EList<Department> department;

	/**
	 * The cached value of the '{@link #getMailStop() <em>Mail Stop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailStop()
	 * @generated
	 * @ordered
	 */
	protected MailStop mailStop;

	/**
	 * The cached value of the '{@link #getPostalCode() <em>Postal Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected PostalCode postalCode;

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
	protected FirmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getFirm();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.FIRM__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FirmName> getFirmName() {
		if (firmName == null) {
			firmName = new EObjectContainmentEList<FirmName>(FirmName.class, this, XalPackage.FIRM__FIRM_NAME);
		}
		return firmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Department> getDepartment() {
		if (department == null) {
			department = new EObjectContainmentEList<Department>(Department.class, this, XalPackage.FIRM__DEPARTMENT);
		}
		return department;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailStop getMailStop() {
		return mailStop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMailStop(MailStop newMailStop, NotificationChain msgs) {
		MailStop oldMailStop = mailStop;
		mailStop = newMailStop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.FIRM__MAIL_STOP, oldMailStop, newMailStop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailStop(MailStop newMailStop) {
		if (newMailStop != mailStop) {
			NotificationChain msgs = null;
			if (mailStop != null)
				msgs = ((InternalEObject)mailStop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.FIRM__MAIL_STOP, null, msgs);
			if (newMailStop != null)
				msgs = ((InternalEObject)newMailStop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.FIRM__MAIL_STOP, null, msgs);
			msgs = basicSetMailStop(newMailStop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.FIRM__MAIL_STOP, newMailStop, newMailStop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalCode getPostalCode() {
		return postalCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostalCode(PostalCode newPostalCode, NotificationChain msgs) {
		PostalCode oldPostalCode = postalCode;
		postalCode = newPostalCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.FIRM__POSTAL_CODE, oldPostalCode, newPostalCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalCode(PostalCode newPostalCode) {
		if (newPostalCode != postalCode) {
			NotificationChain msgs = null;
			if (postalCode != null)
				msgs = ((InternalEObject)postalCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.FIRM__POSTAL_CODE, null, msgs);
			if (newPostalCode != null)
				msgs = ((InternalEObject)newPostalCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.FIRM__POSTAL_CODE, null, msgs);
			msgs = basicSetPostalCode(newPostalCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.FIRM__POSTAL_CODE, newPostalCode, newPostalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.FIRM__ANY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.FIRM__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.FIRM__ANY_ATTRIBUTE);
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
			case XalPackage.FIRM__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.FIRM__FIRM_NAME:
				return ((InternalEList<?>)getFirmName()).basicRemove(otherEnd, msgs);
			case XalPackage.FIRM__DEPARTMENT:
				return ((InternalEList<?>)getDepartment()).basicRemove(otherEnd, msgs);
			case XalPackage.FIRM__MAIL_STOP:
				return basicSetMailStop(null, msgs);
			case XalPackage.FIRM__POSTAL_CODE:
				return basicSetPostalCode(null, msgs);
			case XalPackage.FIRM__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.FIRM__ANY_ATTRIBUTE:
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
			case XalPackage.FIRM__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.FIRM__FIRM_NAME:
				return getFirmName();
			case XalPackage.FIRM__DEPARTMENT:
				return getDepartment();
			case XalPackage.FIRM__MAIL_STOP:
				return getMailStop();
			case XalPackage.FIRM__POSTAL_CODE:
				return getPostalCode();
			case XalPackage.FIRM__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.FIRM__TYPE:
				return getType();
			case XalPackage.FIRM__ANY_ATTRIBUTE:
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
			case XalPackage.FIRM__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.FIRM__FIRM_NAME:
				getFirmName().clear();
				getFirmName().addAll((Collection<? extends FirmName>)newValue);
				return;
			case XalPackage.FIRM__DEPARTMENT:
				getDepartment().clear();
				getDepartment().addAll((Collection<? extends Department>)newValue);
				return;
			case XalPackage.FIRM__MAIL_STOP:
				setMailStop((MailStop)newValue);
				return;
			case XalPackage.FIRM__POSTAL_CODE:
				setPostalCode((PostalCode)newValue);
				return;
			case XalPackage.FIRM__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.FIRM__TYPE:
				setType(newValue);
				return;
			case XalPackage.FIRM__ANY_ATTRIBUTE:
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
			case XalPackage.FIRM__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.FIRM__FIRM_NAME:
				getFirmName().clear();
				return;
			case XalPackage.FIRM__DEPARTMENT:
				getDepartment().clear();
				return;
			case XalPackage.FIRM__MAIL_STOP:
				setMailStop((MailStop)null);
				return;
			case XalPackage.FIRM__POSTAL_CODE:
				setPostalCode((PostalCode)null);
				return;
			case XalPackage.FIRM__ANY:
				getAny().clear();
				return;
			case XalPackage.FIRM__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.FIRM__ANY_ATTRIBUTE:
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
			case XalPackage.FIRM__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.FIRM__FIRM_NAME:
				return firmName != null && !firmName.isEmpty();
			case XalPackage.FIRM__DEPARTMENT:
				return department != null && !department.isEmpty();
			case XalPackage.FIRM__MAIL_STOP:
				return mailStop != null;
			case XalPackage.FIRM__POSTAL_CODE:
				return postalCode != null;
			case XalPackage.FIRM__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.FIRM__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.FIRM__ANY_ATTRIBUTE:
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

} //FirmImpl
