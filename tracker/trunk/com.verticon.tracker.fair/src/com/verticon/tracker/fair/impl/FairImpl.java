/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair.impl;

import com.verticon.tracker.Premises;

import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibitor;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.YouthClub;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getExhibitors <em>Exhibitors</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getClubs <em>Clubs</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getDivisions <em>Divisions</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getPremises <em>Premises</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FairImpl extends EObjectImpl implements Fair {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExhibitors() <em>Exhibitors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExhibitors()
	 * @generated
	 * @ordered
	 */
	protected EList<Exhibitor> exhibitors;

	/**
	 * The cached value of the '{@link #getClubs() <em>Clubs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClubs()
	 * @generated
	 * @ordered
	 */
	protected EList<YouthClub> clubs;

	/**
	 * The cached value of the '{@link #getDivisions() <em>Divisions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDivisions()
	 * @generated
	 * @ordered
	 */
	protected EList<Division> divisions;

	/**
	 * The cached value of the '{@link #getPremises() <em>Premises</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremises()
	 * @generated
	 * @ordered
	 */
	protected Premises premises;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FairImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FairPackage.Literals.FAIR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.FAIR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Exhibitor> getExhibitors() {
		if (exhibitors == null) {
			exhibitors = new EObjectContainmentEList<Exhibitor>(Exhibitor.class, this, FairPackage.FAIR__EXHIBITORS);
		}
		return exhibitors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<YouthClub> getClubs() {
		if (clubs == null) {
			clubs = new EObjectContainmentEList<YouthClub>(YouthClub.class, this, FairPackage.FAIR__CLUBS);
		}
		return clubs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Division> getDivisions() {
		if (divisions == null) {
			divisions = new EObjectContainmentEList<Division>(Division.class, this, FairPackage.FAIR__DIVISIONS);
		}
		return divisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises getPremises() {
		if (premises != null && premises.eIsProxy()) {
			InternalEObject oldPremises = (InternalEObject)premises;
			premises = (Premises)eResolveProxy(oldPremises);
			if (premises != oldPremises) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FairPackage.FAIR__PREMISES, oldPremises, premises));
			}
		}
		return premises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises basicGetPremises() {
		return premises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremises(Premises newPremises) {
		Premises oldPremises = premises;
		premises = newPremises;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.FAIR__PREMISES, oldPremises, premises));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FairPackage.FAIR__EXHIBITORS:
				return ((InternalEList<?>)getExhibitors()).basicRemove(otherEnd, msgs);
			case FairPackage.FAIR__CLUBS:
				return ((InternalEList<?>)getClubs()).basicRemove(otherEnd, msgs);
			case FairPackage.FAIR__DIVISIONS:
				return ((InternalEList<?>)getDivisions()).basicRemove(otherEnd, msgs);
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
			case FairPackage.FAIR__NAME:
				return getName();
			case FairPackage.FAIR__EXHIBITORS:
				return getExhibitors();
			case FairPackage.FAIR__CLUBS:
				return getClubs();
			case FairPackage.FAIR__DIVISIONS:
				return getDivisions();
			case FairPackage.FAIR__PREMISES:
				if (resolve) return getPremises();
				return basicGetPremises();
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
			case FairPackage.FAIR__NAME:
				setName((String)newValue);
				return;
			case FairPackage.FAIR__EXHIBITORS:
				getExhibitors().clear();
				getExhibitors().addAll((Collection<? extends Exhibitor>)newValue);
				return;
			case FairPackage.FAIR__CLUBS:
				getClubs().clear();
				getClubs().addAll((Collection<? extends YouthClub>)newValue);
				return;
			case FairPackage.FAIR__DIVISIONS:
				getDivisions().clear();
				getDivisions().addAll((Collection<? extends Division>)newValue);
				return;
			case FairPackage.FAIR__PREMISES:
				setPremises((Premises)newValue);
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
			case FairPackage.FAIR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FairPackage.FAIR__EXHIBITORS:
				getExhibitors().clear();
				return;
			case FairPackage.FAIR__CLUBS:
				getClubs().clear();
				return;
			case FairPackage.FAIR__DIVISIONS:
				getDivisions().clear();
				return;
			case FairPackage.FAIR__PREMISES:
				setPremises((Premises)null);
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
			case FairPackage.FAIR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FairPackage.FAIR__EXHIBITORS:
				return exhibitors != null && !exhibitors.isEmpty();
			case FairPackage.FAIR__CLUBS:
				return clubs != null && !clubs.isEmpty();
			case FairPackage.FAIR__DIVISIONS:
				return divisions != null && !divisions.isEmpty();
			case FairPackage.FAIR__PREMISES:
				return premises != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FairImpl
