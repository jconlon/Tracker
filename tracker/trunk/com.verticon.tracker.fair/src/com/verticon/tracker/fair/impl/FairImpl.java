/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import com.verticon.tracker.Premises;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.People;
import com.verticon.tracker.fair.YouthClub;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getYouthClub <em>Youth Club</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getDivision <em>Division</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getPremises <em>Premises</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.FairImpl#getPeople <em>People</em>}</li>
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
	 * The cached value of the '{@link #getYouthClub() <em>Youth Club</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYouthClub()
	 * @generated
	 * @ordered
	 */
	protected EList<YouthClub> youthClub;

	/**
	 * The cached value of the '{@link #getDivision() <em>Division</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDivision()
	 * @generated
	 * @ordered
	 */
	protected EList<Division> division;

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
	 * The cached value of the '{@link #getPeople() <em>People</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeople()
	 * @generated
	 * @ordered
	 */
	protected People people;

	/**
	 * The parsed OCL expression for the body of the '{@link #exhibits <em>Exhibits</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #exhibits
	 * @generated
	 */
	private static OCLExpression<EClassifier> exhibitsBodyOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/ocl/examples/OCL";

	private static final OCL OCL_ENV = OCL.newInstance();

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
	public EList<YouthClub> getYouthClub() {
		if (youthClub == null) {
			youthClub = new EObjectContainmentEList<YouthClub>(YouthClub.class, this, FairPackage.FAIR__YOUTH_CLUB);
		}
		return youthClub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Division> getDivision() {
		if (division == null) {
			division = new EObjectContainmentEList<Division>(Division.class, this, FairPackage.FAIR__DIVISION);
		}
		return division;
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
	public People getPeople() {
		return people;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPeople(People newPeople, NotificationChain msgs) {
		People oldPeople = people;
		people = newPeople;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FairPackage.FAIR__PEOPLE, oldPeople, newPeople);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeople(People newPeople) {
		if (newPeople != people) {
			NotificationChain msgs = null;
			if (people != null)
				msgs = ((InternalEObject)people).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FairPackage.FAIR__PEOPLE, null, msgs);
			if (newPeople != null)
				msgs = ((InternalEObject)newPeople).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FairPackage.FAIR__PEOPLE, null, msgs);
			msgs = basicSetPeople(newPeople, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.FAIR__PEOPLE, newPeople, newPeople));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Exhibit> exhibits() {
		if (exhibitsBodyOCL == null) {
			EOperation eOperation = FairPackage.Literals.FAIR.getEOperations().get(0);
			OCL.Helper helper = OCL_ENV.createOCLHelper();
			helper.setOperationContext(FairPackage.Literals.FAIR, eOperation);
			EAnnotation ocl = eOperation.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String body = ocl.getDetails().get("body");
			
			try {
				exhibitsBodyOCL = helper.createQuery(body);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(exhibitsBodyOCL);
	
		@SuppressWarnings("unchecked")
		Collection<Exhibit> result = (Collection<Exhibit>) query.evaluate(this);
		return new BasicEList.UnmodifiableEList<Exhibit>(result.size(), result.toArray());
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FairPackage.FAIR__YOUTH_CLUB:
				return ((InternalEList<?>)getYouthClub()).basicRemove(otherEnd, msgs);
			case FairPackage.FAIR__DIVISION:
				return ((InternalEList<?>)getDivision()).basicRemove(otherEnd, msgs);
			case FairPackage.FAIR__PEOPLE:
				return basicSetPeople(null, msgs);
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
			case FairPackage.FAIR__YOUTH_CLUB:
				return getYouthClub();
			case FairPackage.FAIR__DIVISION:
				return getDivision();
			case FairPackage.FAIR__PREMISES:
				if (resolve) return getPremises();
				return basicGetPremises();
			case FairPackage.FAIR__PEOPLE:
				return getPeople();
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
			case FairPackage.FAIR__YOUTH_CLUB:
				getYouthClub().clear();
				getYouthClub().addAll((Collection<? extends YouthClub>)newValue);
				return;
			case FairPackage.FAIR__DIVISION:
				getDivision().clear();
				getDivision().addAll((Collection<? extends Division>)newValue);
				return;
			case FairPackage.FAIR__PREMISES:
				setPremises((Premises)newValue);
				return;
			case FairPackage.FAIR__PEOPLE:
				setPeople((People)newValue);
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
			case FairPackage.FAIR__YOUTH_CLUB:
				getYouthClub().clear();
				return;
			case FairPackage.FAIR__DIVISION:
				getDivision().clear();
				return;
			case FairPackage.FAIR__PREMISES:
				setPremises((Premises)null);
				return;
			case FairPackage.FAIR__PEOPLE:
				setPeople((People)null);
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
			case FairPackage.FAIR__YOUTH_CLUB:
				return youthClub != null && !youthClub.isEmpty();
			case FairPackage.FAIR__DIVISION:
				return division != null && !division.isEmpty();
			case FairPackage.FAIR__PREMISES:
				return premises != null;
			case FairPackage.FAIR__PEOPLE:
				return people != null;
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
