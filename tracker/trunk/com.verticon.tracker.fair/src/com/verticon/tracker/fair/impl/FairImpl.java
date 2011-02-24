/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.fair.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.tracker.Premises;
import com.verticon.tracker.fair.AllExhibits;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YouthClub;
import com.verticon.tracker.fair.util.AllExhibitsAdapterFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getYouthClubs <em>Youth Clubs</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getDivisions <em>Divisions</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getPremises <em>Premises</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getPeople <em>People</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FairImpl extends MinimalEObjectImpl.Container implements Fair {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

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
	 * The cached value of the '{@link #getYouthClubs() <em>Youth Clubs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYouthClubs()
	 * @generated
	 * @ordered
	 */
	protected EList<YouthClub> youthClubs;

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
	 * The cached value of the '{@link #getPeople() <em>People</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeople()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> people;

	/**
	 * The default value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected String comments = COMMENTS_EDEFAULT;

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
	public EList<YouthClub> getYouthClubs() {
		if (youthClubs == null) {
			youthClubs = new EObjectContainmentEList<YouthClub>(YouthClub.class, this, FairPackage.FAIR__YOUTH_CLUBS);
		}
		return youthClubs;
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
	public EList<Person> getPeople() {
		if (people == null) {
			people = new EObjectContainmentEList<Person>(Person.class, this, FairPackage.FAIR__PEOPLE);
		}
		return people;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(String newComments) {
		String oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.FAIR__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Hand implemented for speed (versus OCL??) because this method is used to generate 
	 * all the exhibits for the Fair. Similar pattern as Premises.eventHistory().
	 * Originally generated with the following OCL:
	 * if (divisions -> notEmpty())  and (divisions.departments->notEmpty())  
	 * and  (divisions.departments.classes->notEmpty()) and (divisions.departments.classes.lots->notEmpty()) 
	 * and (divisions.departments.classes.lots.exhibits -> notEmpty()) 
	 * then  divisions.departments.classes.lots.exhibits
	 * else Set{}
	 * endif
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Exhibit> exhibits() {
		AllExhibits allExhibits = (AllExhibits) AllExhibitsAdapterFactory.INSTANCE.adapt(
				this, AllExhibits.class);
		if(allExhibits ==null){
			throw new IllegalStateException("No exhibits for fair");
		}
		return allExhibits.exhibits();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FairPackage.FAIR__YOUTH_CLUBS:
				return ((InternalEList<?>)getYouthClubs()).basicRemove(otherEnd, msgs);
			case FairPackage.FAIR__DIVISIONS:
				return ((InternalEList<?>)getDivisions()).basicRemove(otherEnd, msgs);
			case FairPackage.FAIR__PEOPLE:
				return ((InternalEList<?>)getPeople()).basicRemove(otherEnd, msgs);
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
			case FairPackage.FAIR__YOUTH_CLUBS:
				return getYouthClubs();
			case FairPackage.FAIR__DIVISIONS:
				return getDivisions();
			case FairPackage.FAIR__PREMISES:
				if (resolve) return getPremises();
				return basicGetPremises();
			case FairPackage.FAIR__PEOPLE:
				return getPeople();
			case FairPackage.FAIR__COMMENTS:
				return getComments();
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
			case FairPackage.FAIR__YOUTH_CLUBS:
				getYouthClubs().clear();
				getYouthClubs().addAll((Collection<? extends YouthClub>)newValue);
				return;
			case FairPackage.FAIR__DIVISIONS:
				getDivisions().clear();
				getDivisions().addAll((Collection<? extends Division>)newValue);
				return;
			case FairPackage.FAIR__PREMISES:
				setPremises((Premises)newValue);
				return;
			case FairPackage.FAIR__PEOPLE:
				getPeople().clear();
				getPeople().addAll((Collection<? extends Person>)newValue);
				return;
			case FairPackage.FAIR__COMMENTS:
				setComments((String)newValue);
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
			case FairPackage.FAIR__YOUTH_CLUBS:
				getYouthClubs().clear();
				return;
			case FairPackage.FAIR__DIVISIONS:
				getDivisions().clear();
				return;
			case FairPackage.FAIR__PREMISES:
				setPremises((Premises)null);
				return;
			case FairPackage.FAIR__PEOPLE:
				getPeople().clear();
				return;
			case FairPackage.FAIR__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
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
			case FairPackage.FAIR__YOUTH_CLUBS:
				return youthClubs != null && !youthClubs.isEmpty();
			case FairPackage.FAIR__DIVISIONS:
				return divisions != null && !divisions.isEmpty();
			case FairPackage.FAIR__PREMISES:
				return premises != null;
			case FairPackage.FAIR__PEOPLE:
				return people != null && !people.isEmpty();
			case FairPackage.FAIR__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
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
		result.append(", comments: ");
		result.append(comments);
		result.append(')');
		return result.toString();
	}

} //FairImpl
