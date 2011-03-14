/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.PostBox;
import com.verticon.oasis.xal.PostalRoute;
import com.verticon.oasis.xal.PostalRouteName;
import com.verticon.oasis.xal.PostalRouteNumber;
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
 * An implementation of the model object '<em><b>Postal Route</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalRouteImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalRouteImpl#getPostalRouteName <em>Postal Route Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalRouteImpl#getPostalRouteNumber <em>Postal Route Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalRouteImpl#getPostBox <em>Post Box</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalRouteImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalRouteImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalRouteImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostalRouteImpl extends MinimalEObjectImpl.Container implements PostalRoute {
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
	 * The cached value of the '{@link #getPostalRouteName() <em>Postal Route Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalRouteName()
	 * @generated
	 * @ordered
	 */
	protected EList<PostalRouteName> postalRouteName;

	/**
	 * The cached value of the '{@link #getPostalRouteNumber() <em>Postal Route Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalRouteNumber()
	 * @generated
	 * @ordered
	 */
	protected PostalRouteNumber postalRouteNumber;

	/**
	 * The cached value of the '{@link #getPostBox() <em>Post Box</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostBox()
	 * @generated
	 * @ordered
	 */
	protected PostBox postBox;

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
	protected PostalRouteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getPostalRoute();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.POSTAL_ROUTE__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PostalRouteName> getPostalRouteName() {
		if (postalRouteName == null) {
			postalRouteName = new EObjectContainmentEList<PostalRouteName>(PostalRouteName.class, this, XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NAME);
		}
		return postalRouteName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalRouteNumber getPostalRouteNumber() {
		return postalRouteNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostalRouteNumber(PostalRouteNumber newPostalRouteNumber, NotificationChain msgs) {
		PostalRouteNumber oldPostalRouteNumber = postalRouteNumber;
		postalRouteNumber = newPostalRouteNumber;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER, oldPostalRouteNumber, newPostalRouteNumber);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalRouteNumber(PostalRouteNumber newPostalRouteNumber) {
		if (newPostalRouteNumber != postalRouteNumber) {
			NotificationChain msgs = null;
			if (postalRouteNumber != null)
				msgs = ((InternalEObject)postalRouteNumber).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER, null, msgs);
			if (newPostalRouteNumber != null)
				msgs = ((InternalEObject)newPostalRouteNumber).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER, null, msgs);
			msgs = basicSetPostalRouteNumber(newPostalRouteNumber, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER, newPostalRouteNumber, newPostalRouteNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBox getPostBox() {
		return postBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostBox(PostBox newPostBox, NotificationChain msgs) {
		PostBox oldPostBox = postBox;
		postBox = newPostBox;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_ROUTE__POST_BOX, oldPostBox, newPostBox);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostBox(PostBox newPostBox) {
		if (newPostBox != postBox) {
			NotificationChain msgs = null;
			if (postBox != null)
				msgs = ((InternalEObject)postBox).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_ROUTE__POST_BOX, null, msgs);
			if (newPostBox != null)
				msgs = ((InternalEObject)newPostBox).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_ROUTE__POST_BOX, null, msgs);
			msgs = basicSetPostBox(newPostBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_ROUTE__POST_BOX, newPostBox, newPostBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.POSTAL_ROUTE__ANY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_ROUTE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.POSTAL_ROUTE__ANY_ATTRIBUTE);
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
			case XalPackage.POSTAL_ROUTE__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NAME:
				return ((InternalEList<?>)getPostalRouteName()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER:
				return basicSetPostalRouteNumber(null, msgs);
			case XalPackage.POSTAL_ROUTE__POST_BOX:
				return basicSetPostBox(null, msgs);
			case XalPackage.POSTAL_ROUTE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_ROUTE__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_ROUTE__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NAME:
				return getPostalRouteName();
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER:
				return getPostalRouteNumber();
			case XalPackage.POSTAL_ROUTE__POST_BOX:
				return getPostBox();
			case XalPackage.POSTAL_ROUTE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.POSTAL_ROUTE__TYPE:
				return getType();
			case XalPackage.POSTAL_ROUTE__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_ROUTE__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NAME:
				getPostalRouteName().clear();
				getPostalRouteName().addAll((Collection<? extends PostalRouteName>)newValue);
				return;
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER:
				setPostalRouteNumber((PostalRouteNumber)newValue);
				return;
			case XalPackage.POSTAL_ROUTE__POST_BOX:
				setPostBox((PostBox)newValue);
				return;
			case XalPackage.POSTAL_ROUTE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.POSTAL_ROUTE__TYPE:
				setType(newValue);
				return;
			case XalPackage.POSTAL_ROUTE__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_ROUTE__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NAME:
				getPostalRouteName().clear();
				return;
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER:
				setPostalRouteNumber((PostalRouteNumber)null);
				return;
			case XalPackage.POSTAL_ROUTE__POST_BOX:
				setPostBox((PostBox)null);
				return;
			case XalPackage.POSTAL_ROUTE__ANY:
				getAny().clear();
				return;
			case XalPackage.POSTAL_ROUTE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.POSTAL_ROUTE__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_ROUTE__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NAME:
				return postalRouteName != null && !postalRouteName.isEmpty();
			case XalPackage.POSTAL_ROUTE__POSTAL_ROUTE_NUMBER:
				return postalRouteNumber != null;
			case XalPackage.POSTAL_ROUTE__POST_BOX:
				return postBox != null;
			case XalPackage.POSTAL_ROUTE__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.POSTAL_ROUTE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.POSTAL_ROUTE__ANY_ATTRIBUTE:
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

} //PostalRouteImpl
