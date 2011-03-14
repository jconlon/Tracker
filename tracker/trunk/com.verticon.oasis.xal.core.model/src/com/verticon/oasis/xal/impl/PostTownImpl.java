/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.PostTown;
import com.verticon.oasis.xal.PostTownName;
import com.verticon.oasis.xal.PostTownSuffix;
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
 * An implementation of the model object '<em><b>Post Town</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.PostTownImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostTownImpl#getPostTownName <em>Post Town Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostTownImpl#getPostTownSuffix <em>Post Town Suffix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostTownImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostTownImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostTownImpl extends MinimalEObjectImpl.Container implements PostTown {
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
	 * The cached value of the '{@link #getPostTownName() <em>Post Town Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostTownName()
	 * @generated
	 * @ordered
	 */
	protected EList<PostTownName> postTownName;

	/**
	 * The cached value of the '{@link #getPostTownSuffix() <em>Post Town Suffix</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostTownSuffix()
	 * @generated
	 * @ordered
	 */
	protected PostTownSuffix postTownSuffix;

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
	protected PostTownImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getPostTown();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.POST_TOWN__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PostTownName> getPostTownName() {
		if (postTownName == null) {
			postTownName = new EObjectContainmentEList<PostTownName>(PostTownName.class, this, XalPackage.POST_TOWN__POST_TOWN_NAME);
		}
		return postTownName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostTownSuffix getPostTownSuffix() {
		return postTownSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostTownSuffix(PostTownSuffix newPostTownSuffix, NotificationChain msgs) {
		PostTownSuffix oldPostTownSuffix = postTownSuffix;
		postTownSuffix = newPostTownSuffix;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POST_TOWN__POST_TOWN_SUFFIX, oldPostTownSuffix, newPostTownSuffix);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostTownSuffix(PostTownSuffix newPostTownSuffix) {
		if (newPostTownSuffix != postTownSuffix) {
			NotificationChain msgs = null;
			if (postTownSuffix != null)
				msgs = ((InternalEObject)postTownSuffix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POST_TOWN__POST_TOWN_SUFFIX, null, msgs);
			if (newPostTownSuffix != null)
				msgs = ((InternalEObject)newPostTownSuffix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POST_TOWN__POST_TOWN_SUFFIX, null, msgs);
			msgs = basicSetPostTownSuffix(newPostTownSuffix, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POST_TOWN__POST_TOWN_SUFFIX, newPostTownSuffix, newPostTownSuffix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POST_TOWN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.POST_TOWN__ANY_ATTRIBUTE);
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
			case XalPackage.POST_TOWN__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.POST_TOWN__POST_TOWN_NAME:
				return ((InternalEList<?>)getPostTownName()).basicRemove(otherEnd, msgs);
			case XalPackage.POST_TOWN__POST_TOWN_SUFFIX:
				return basicSetPostTownSuffix(null, msgs);
			case XalPackage.POST_TOWN__ANY_ATTRIBUTE:
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
			case XalPackage.POST_TOWN__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.POST_TOWN__POST_TOWN_NAME:
				return getPostTownName();
			case XalPackage.POST_TOWN__POST_TOWN_SUFFIX:
				return getPostTownSuffix();
			case XalPackage.POST_TOWN__TYPE:
				return getType();
			case XalPackage.POST_TOWN__ANY_ATTRIBUTE:
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
			case XalPackage.POST_TOWN__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.POST_TOWN__POST_TOWN_NAME:
				getPostTownName().clear();
				getPostTownName().addAll((Collection<? extends PostTownName>)newValue);
				return;
			case XalPackage.POST_TOWN__POST_TOWN_SUFFIX:
				setPostTownSuffix((PostTownSuffix)newValue);
				return;
			case XalPackage.POST_TOWN__TYPE:
				setType(newValue);
				return;
			case XalPackage.POST_TOWN__ANY_ATTRIBUTE:
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
			case XalPackage.POST_TOWN__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.POST_TOWN__POST_TOWN_NAME:
				getPostTownName().clear();
				return;
			case XalPackage.POST_TOWN__POST_TOWN_SUFFIX:
				setPostTownSuffix((PostTownSuffix)null);
				return;
			case XalPackage.POST_TOWN__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.POST_TOWN__ANY_ATTRIBUTE:
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
			case XalPackage.POST_TOWN__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.POST_TOWN__POST_TOWN_NAME:
				return postTownName != null && !postTownName.isEmpty();
			case XalPackage.POST_TOWN__POST_TOWN_SUFFIX:
				return postTownSuffix != null;
			case XalPackage.POST_TOWN__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.POST_TOWN__ANY_ATTRIBUTE:
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
		result.append(" (type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //PostTownImpl
