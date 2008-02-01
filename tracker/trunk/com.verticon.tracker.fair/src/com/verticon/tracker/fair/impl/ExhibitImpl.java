/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair.impl;

import com.verticon.tracker.Animal;

import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YouthClub;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

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
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExhibitImpl extends EObjectImpl implements Exhibit {
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
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

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
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.EXHIBIT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.EXHIBIT__NUMBER, oldNumber, number));
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FairPackage.EXHIBIT__NAME:
				return getName();
			case FairPackage.EXHIBIT__NUMBER:
				return new Integer(getNumber());
			case FairPackage.EXHIBIT__COMMENTS:
				return getComments();
			case FairPackage.EXHIBIT__ANIMAL:
				if (resolve) return getAnimal();
				return basicGetAnimal();
			case FairPackage.EXHIBIT__EXHIBITOR:
				if (resolve) return getExhibitor();
				return basicGetExhibitor();
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
			case FairPackage.EXHIBIT__NAME:
				setName((String)newValue);
				return;
			case FairPackage.EXHIBIT__NUMBER:
				setNumber(((Integer)newValue).intValue());
				return;
			case FairPackage.EXHIBIT__COMMENTS:
				setComments((String)newValue);
				return;
			case FairPackage.EXHIBIT__ANIMAL:
				setAnimal((Animal)newValue);
				return;
			case FairPackage.EXHIBIT__EXHIBITOR:
				setExhibitor((Person)newValue);
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
			case FairPackage.EXHIBIT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FairPackage.EXHIBIT__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case FairPackage.EXHIBIT__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case FairPackage.EXHIBIT__ANIMAL:
				setAnimal((Animal)null);
				return;
			case FairPackage.EXHIBIT__EXHIBITOR:
				setExhibitor((Person)null);
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
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FairPackage.EXHIBIT__NUMBER:
				return number != NUMBER_EDEFAULT;
			case FairPackage.EXHIBIT__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case FairPackage.EXHIBIT__ANIMAL:
				return animal != null;
			case FairPackage.EXHIBIT__EXHIBITOR:
				return exhibitor != null;
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
		result.append(", number: ");
		result.append(number);
		result.append(", comments: ");
		result.append(comments);
		result.append(')');
		return result.toString();
	}

} //ExhibitImpl
