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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.verticon.tracker.Animal;
import com.verticon.tracker.fair.Award;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.Person;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exhibit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#getAnimal <em>Animal</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#getExhibitor <em>Exhibitor</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#getLot <em>Lot</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#getSalesOrder <em>Sales Order</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#isInAuction <em>In Auction</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.ExhibitImpl#getAward <em>Award</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExhibitImpl extends MinimalEObjectImpl.Container implements Exhibit {
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
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

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
	 * The cached value of the '{@link #getAnimal() <em>Animal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimal()
	 * @generated
	 * @ordered
	 */
	protected Animal animal;

	/**
	 * The cached value of the '{@link #getExhibitor() <em>Exhibitor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExhibitor()
	 * @generated
	 * @ordered
	 */
	protected Person exhibitor;

	/**
	 * The default value of the '{@link #getSalesOrder() <em>Sales Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalesOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int SALES_ORDER_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #isInAuction() <em>In Auction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInAuction()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_AUCTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInAuction() <em>In Auction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInAuction()
	 * @generated
	 * @ordered
	 */
	protected boolean inAuction = IN_AUCTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAward() <em>Award</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAward()
	 * @generated
	 * @ordered
	 */
	protected static final Award AWARD_EDEFAULT = Award.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getAward() <em>Award</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAward()
	 * @generated
	 * @ordered
	 */
	protected Award award = AWARD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExhibitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FairPackage.Literals.EXHIBIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		if (getExhibitor()==null){
			return "";
		}
		
		return getExhibitor().getFirstName()+' '+getExhibitor().getLastName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNumber() {
		if (getExhibitor()==null){
			return 0;
		}
		return getExhibitor().getExhibitorNumber();
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
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.EXHIBIT__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animal getAnimal() {
		if (animal != null && animal.eIsProxy()) {
			InternalEObject oldAnimal = (InternalEObject)animal;
			animal = (Animal)eResolveProxy(oldAnimal);
			if (animal != oldAnimal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FairPackage.EXHIBIT__ANIMAL, oldAnimal, animal));
			}
		}
		return animal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animal basicGetAnimal() {
		return animal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnimal(Animal newAnimal) {
		Animal oldAnimal = animal;
		animal = newAnimal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.EXHIBIT__ANIMAL, oldAnimal, animal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getExhibitor() {
		if (exhibitor != null && exhibitor.eIsProxy()) {
			InternalEObject oldExhibitor = (InternalEObject)exhibitor;
			exhibitor = (Person)eResolveProxy(oldExhibitor);
			if (exhibitor != oldExhibitor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FairPackage.EXHIBIT__EXHIBITOR, oldExhibitor, exhibitor));
			}
		}
		return exhibitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetExhibitor() {
		return exhibitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExhibitor(Person newExhibitor) {
		Person oldExhibitor = exhibitor;
		exhibitor = newExhibitor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.EXHIBIT__EXHIBITOR, oldExhibitor, exhibitor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lot getLot() {
		if (eContainerFeatureID() != FairPackage.EXHIBIT__LOT) return null;
		return (Lot)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLot(Lot newLot, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLot, FairPackage.EXHIBIT__LOT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLot(Lot newLot) {
		if (newLot != eInternalContainer() || (eContainerFeatureID() != FairPackage.EXHIBIT__LOT && newLot != null)) {
			if (EcoreUtil.isAncestor(this, newLot))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLot != null)
				msgs = ((InternalEObject)newLot).eInverseAdd(this, FairPackage.LOT__EXHIBITS, Lot.class, msgs);
			msgs = basicSetLot(newLot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.EXHIBIT__LOT, newLot, newLot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Exhibit derives the salesOrder from
	 * the Exhibitors salesOrder 
	 * if the Exhibit inAuction is true there 
	 * is a person and an animal
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getSalesOrder() {
		if(getAnimal()!=null && isInAuction() && getExhibitor()!=null){
			return getExhibitor().getSalesOrder();
		}
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInAuction() {
		return inAuction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInAuction(boolean newInAuction) {
		boolean oldInAuction = inAuction;
		inAuction = newInAuction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.EXHIBIT__IN_AUCTION, oldInAuction, inAuction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Award getAward() {
		return award;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAward(Award newAward) {
		Award oldAward = award;
		award = newAward == null ? AWARD_EDEFAULT : newAward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.EXHIBIT__AWARD, oldAward, award));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FairPackage.EXHIBIT__LOT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLot((Lot)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FairPackage.EXHIBIT__LOT:
				return basicSetLot(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FairPackage.EXHIBIT__LOT:
				return eInternalContainer().eInverseRemove(this, FairPackage.LOT__EXHIBITS, Lot.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FairPackage.EXHIBIT__NAME:
				return getName();
			case FairPackage.EXHIBIT__NUMBER:
				return getNumber();
			case FairPackage.EXHIBIT__COMMENTS:
				return getComments();
			case FairPackage.EXHIBIT__ANIMAL:
				if (resolve) return getAnimal();
				return basicGetAnimal();
			case FairPackage.EXHIBIT__EXHIBITOR:
				if (resolve) return getExhibitor();
				return basicGetExhibitor();
			case FairPackage.EXHIBIT__LOT:
				return getLot();
			case FairPackage.EXHIBIT__SALES_ORDER:
				return getSalesOrder();
			case FairPackage.EXHIBIT__IN_AUCTION:
				return isInAuction();
			case FairPackage.EXHIBIT__AWARD:
				return getAward();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FairPackage.EXHIBIT__COMMENTS:
				setComments((String)newValue);
				return;
			case FairPackage.EXHIBIT__ANIMAL:
				setAnimal((Animal)newValue);
				return;
			case FairPackage.EXHIBIT__EXHIBITOR:
				setExhibitor((Person)newValue);
				return;
			case FairPackage.EXHIBIT__LOT:
				setLot((Lot)newValue);
				return;
			case FairPackage.EXHIBIT__IN_AUCTION:
				setInAuction((Boolean)newValue);
				return;
			case FairPackage.EXHIBIT__AWARD:
				setAward((Award)newValue);
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
			case FairPackage.EXHIBIT__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case FairPackage.EXHIBIT__ANIMAL:
				setAnimal((Animal)null);
				return;
			case FairPackage.EXHIBIT__EXHIBITOR:
				setExhibitor((Person)null);
				return;
			case FairPackage.EXHIBIT__LOT:
				setLot((Lot)null);
				return;
			case FairPackage.EXHIBIT__IN_AUCTION:
				setInAuction(IN_AUCTION_EDEFAULT);
				return;
			case FairPackage.EXHIBIT__AWARD:
				setAward(AWARD_EDEFAULT);
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
			case FairPackage.EXHIBIT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case FairPackage.EXHIBIT__NUMBER:
				return getNumber() != NUMBER_EDEFAULT;
			case FairPackage.EXHIBIT__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case FairPackage.EXHIBIT__ANIMAL:
				return animal != null;
			case FairPackage.EXHIBIT__EXHIBITOR:
				return exhibitor != null;
			case FairPackage.EXHIBIT__LOT:
				return getLot() != null;
			case FairPackage.EXHIBIT__SALES_ORDER:
				return getSalesOrder() != SALES_ORDER_EDEFAULT;
			case FairPackage.EXHIBIT__IN_AUCTION:
				return inAuction != IN_AUCTION_EDEFAULT;
			case FairPackage.EXHIBIT__AWARD:
				return award != AWARD_EDEFAULT;
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
		result.append(" (comments: ");
		result.append(comments);
		result.append(", inAuction: ");
		result.append(inAuction);
		result.append(", award: ");
		result.append(award);
		result.append(')');
		return result.toString();
	}

} //ExhibitImpl
