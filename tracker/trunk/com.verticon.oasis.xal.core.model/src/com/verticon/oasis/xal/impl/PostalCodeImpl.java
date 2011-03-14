/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.PostTown;
import com.verticon.oasis.xal.PostalCode;
import com.verticon.oasis.xal.PostalCodeNumber;
import com.verticon.oasis.xal.PostalCodeNumberExtension;
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
 * An implementation of the model object '<em><b>Postal Code</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeImpl#getPostalCodeNumber <em>Postal Code Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeImpl#getPostalCodeNumberExtension <em>Postal Code Number Extension</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeImpl#getPostTown <em>Post Town</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalCodeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostalCodeImpl extends MinimalEObjectImpl.Container implements PostalCode {
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
	 * The cached value of the '{@link #getPostalCodeNumber() <em>Postal Code Number</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCodeNumber()
	 * @generated
	 * @ordered
	 */
	protected EList<PostalCodeNumber> postalCodeNumber;

	/**
	 * The cached value of the '{@link #getPostalCodeNumberExtension() <em>Postal Code Number Extension</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCodeNumberExtension()
	 * @generated
	 * @ordered
	 */
	protected EList<PostalCodeNumberExtension> postalCodeNumberExtension;

	/**
	 * The cached value of the '{@link #getPostTown() <em>Post Town</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostTown()
	 * @generated
	 * @ordered
	 */
	protected PostTown postTown;

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
	protected PostalCodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getPostalCode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.POSTAL_CODE__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PostalCodeNumber> getPostalCodeNumber() {
		if (postalCodeNumber == null) {
			postalCodeNumber = new EObjectContainmentEList<PostalCodeNumber>(PostalCodeNumber.class, this, XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER);
		}
		return postalCodeNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PostalCodeNumberExtension> getPostalCodeNumberExtension() {
		if (postalCodeNumberExtension == null) {
			postalCodeNumberExtension = new EObjectContainmentEList<PostalCodeNumberExtension>(PostalCodeNumberExtension.class, this, XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER_EXTENSION);
		}
		return postalCodeNumberExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostTown getPostTown() {
		return postTown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostTown(PostTown newPostTown, NotificationChain msgs) {
		PostTown oldPostTown = postTown;
		postTown = newPostTown;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_CODE__POST_TOWN, oldPostTown, newPostTown);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostTown(PostTown newPostTown) {
		if (newPostTown != postTown) {
			NotificationChain msgs = null;
			if (postTown != null)
				msgs = ((InternalEObject)postTown).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_CODE__POST_TOWN, null, msgs);
			if (newPostTown != null)
				msgs = ((InternalEObject)newPostTown).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_CODE__POST_TOWN, null, msgs);
			msgs = basicSetPostTown(newPostTown, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_CODE__POST_TOWN, newPostTown, newPostTown));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.POSTAL_CODE__ANY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_CODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.POSTAL_CODE__ANY_ATTRIBUTE);
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
			case XalPackage.POSTAL_CODE__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER:
				return ((InternalEList<?>)getPostalCodeNumber()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER_EXTENSION:
				return ((InternalEList<?>)getPostalCodeNumberExtension()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_CODE__POST_TOWN:
				return basicSetPostTown(null, msgs);
			case XalPackage.POSTAL_CODE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_CODE__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_CODE__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER:
				return getPostalCodeNumber();
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER_EXTENSION:
				return getPostalCodeNumberExtension();
			case XalPackage.POSTAL_CODE__POST_TOWN:
				return getPostTown();
			case XalPackage.POSTAL_CODE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.POSTAL_CODE__TYPE:
				return getType();
			case XalPackage.POSTAL_CODE__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_CODE__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER:
				getPostalCodeNumber().clear();
				getPostalCodeNumber().addAll((Collection<? extends PostalCodeNumber>)newValue);
				return;
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER_EXTENSION:
				getPostalCodeNumberExtension().clear();
				getPostalCodeNumberExtension().addAll((Collection<? extends PostalCodeNumberExtension>)newValue);
				return;
			case XalPackage.POSTAL_CODE__POST_TOWN:
				setPostTown((PostTown)newValue);
				return;
			case XalPackage.POSTAL_CODE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.POSTAL_CODE__TYPE:
				setType(newValue);
				return;
			case XalPackage.POSTAL_CODE__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_CODE__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER:
				getPostalCodeNumber().clear();
				return;
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER_EXTENSION:
				getPostalCodeNumberExtension().clear();
				return;
			case XalPackage.POSTAL_CODE__POST_TOWN:
				setPostTown((PostTown)null);
				return;
			case XalPackage.POSTAL_CODE__ANY:
				getAny().clear();
				return;
			case XalPackage.POSTAL_CODE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.POSTAL_CODE__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_CODE__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER:
				return postalCodeNumber != null && !postalCodeNumber.isEmpty();
			case XalPackage.POSTAL_CODE__POSTAL_CODE_NUMBER_EXTENSION:
				return postalCodeNumberExtension != null && !postalCodeNumberExtension.isEmpty();
			case XalPackage.POSTAL_CODE__POST_TOWN:
				return postTown != null;
			case XalPackage.POSTAL_CODE__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.POSTAL_CODE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.POSTAL_CODE__ANY_ATTRIBUTE:
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

} //PostalCodeImpl
