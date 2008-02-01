/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair.impl;

import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;
import com.verticon.tracker.fair.YouthClub;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Young Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.impl.YoungPersonImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.YoungPersonImpl#getClub <em>Club</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class YoungPersonImpl extends PersonImpl implements YoungPerson {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> parent;

	/**
	 * The cached value of the '{@link #getClub() <em>Club</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClub()
	 * @generated
	 * @ordered
	 */
	protected YouthClub club;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected YoungPersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FairPackage.Literals.YOUNG_PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getParent() {
		if (parent == null) {
			parent = new EObjectResolvingEList<Person>(Person.class, this, FairPackage.YOUNG_PERSON__PARENT);
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YouthClub getClub() {
		if (club != null && club.eIsProxy()) {
			InternalEObject oldClub = (InternalEObject)club;
			club = (YouthClub)eResolveProxy(oldClub);
			if (club != oldClub) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FairPackage.YOUNG_PERSON__CLUB, oldClub, club));
			}
		}
		return club;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YouthClub basicGetClub() {
		return club;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClub(YouthClub newClub) {
		YouthClub oldClub = club;
		club = newClub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.YOUNG_PERSON__CLUB, oldClub, club));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FairPackage.YOUNG_PERSON__PARENT:
				return getParent();
			case FairPackage.YOUNG_PERSON__CLUB:
				if (resolve) return getClub();
				return basicGetClub();
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
			case FairPackage.YOUNG_PERSON__PARENT:
				getParent().clear();
				getParent().addAll((Collection<? extends Person>)newValue);
				return;
			case FairPackage.YOUNG_PERSON__CLUB:
				setClub((YouthClub)newValue);
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
			case FairPackage.YOUNG_PERSON__PARENT:
				getParent().clear();
				return;
			case FairPackage.YOUNG_PERSON__CLUB:
				setClub((YouthClub)null);
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
			case FairPackage.YOUNG_PERSON__PARENT:
				return parent != null && !parent.isEmpty();
			case FairPackage.YOUNG_PERSON__CLUB:
				return club != null;
		}
		return super.eIsSet(featureID);
	}

} //YoungPersonImpl
