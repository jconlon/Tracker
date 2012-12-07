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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.impl.DepartmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.DepartmentImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.DepartmentImpl#getSuperintendents <em>Superintendents</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.DepartmentImpl#getDivision <em>Division</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.DepartmentImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.impl.DepartmentImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DepartmentImpl extends MinimalEObjectImpl.Container implements Department {
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
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<com.verticon.tracker.fair.Class> classes;

	/**
	 * The cached value of the '{@link #getSuperintendents() <em>Superintendents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperintendents()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> superintendents;

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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FairPackage.Literals.DEPARTMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.DEPARTMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<com.verticon.tracker.fair.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentWithInverseEList<com.verticon.tracker.fair.Class>(com.verticon.tracker.fair.Class.class, this, FairPackage.DEPARTMENT__CLASSES, FairPackage.CLASS__DEPARTMENT);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getSuperintendents() {
		if (superintendents == null) {
			superintendents = new EObjectResolvingEList<Person>(Person.class, this, FairPackage.DEPARTMENT__SUPERINTENDENTS);
		}
		return superintendents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Division getDivision() {
		if (eContainerFeatureID() != FairPackage.DEPARTMENT__DIVISION) return null;
		return (Division)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDivision(Division newDivision, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDivision, FairPackage.DEPARTMENT__DIVISION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDivision(Division newDivision) {
		if (newDivision != eInternalContainer() || (eContainerFeatureID() != FairPackage.DEPARTMENT__DIVISION && newDivision != null)) {
			if (EcoreUtil.isAncestor(this, newDivision))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDivision != null)
				msgs = ((InternalEObject)newDivision).eInverseAdd(this, FairPackage.DIVISION__DEPARTMENTS, Division.class, msgs);
			msgs = basicSetDivision(newDivision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.DEPARTMENT__DIVISION, newDivision, newDivision));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.DEPARTMENT__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FairPackage.DEPARTMENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FairPackage.DEPARTMENT__CLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClasses()).basicAdd(otherEnd, msgs);
			case FairPackage.DEPARTMENT__DIVISION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDivision((Division)otherEnd, msgs);
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
			case FairPackage.DEPARTMENT__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case FairPackage.DEPARTMENT__DIVISION:
				return basicSetDivision(null, msgs);
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
			case FairPackage.DEPARTMENT__DIVISION:
				return eInternalContainer().eInverseRemove(this, FairPackage.DIVISION__DEPARTMENTS, Division.class, msgs);
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
			case FairPackage.DEPARTMENT__NAME:
				return getName();
			case FairPackage.DEPARTMENT__CLASSES:
				return getClasses();
			case FairPackage.DEPARTMENT__SUPERINTENDENTS:
				return getSuperintendents();
			case FairPackage.DEPARTMENT__DIVISION:
				return getDivision();
			case FairPackage.DEPARTMENT__COMMENTS:
				return getComments();
			case FairPackage.DEPARTMENT__DESCRIPTION:
				return getDescription();
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
			case FairPackage.DEPARTMENT__NAME:
				setName((String)newValue);
				return;
			case FairPackage.DEPARTMENT__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends com.verticon.tracker.fair.Class>)newValue);
				return;
			case FairPackage.DEPARTMENT__SUPERINTENDENTS:
				getSuperintendents().clear();
				getSuperintendents().addAll((Collection<? extends Person>)newValue);
				return;
			case FairPackage.DEPARTMENT__DIVISION:
				setDivision((Division)newValue);
				return;
			case FairPackage.DEPARTMENT__COMMENTS:
				setComments((String)newValue);
				return;
			case FairPackage.DEPARTMENT__DESCRIPTION:
				setDescription((String)newValue);
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
			case FairPackage.DEPARTMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FairPackage.DEPARTMENT__CLASSES:
				getClasses().clear();
				return;
			case FairPackage.DEPARTMENT__SUPERINTENDENTS:
				getSuperintendents().clear();
				return;
			case FairPackage.DEPARTMENT__DIVISION:
				setDivision((Division)null);
				return;
			case FairPackage.DEPARTMENT__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case FairPackage.DEPARTMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case FairPackage.DEPARTMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FairPackage.DEPARTMENT__CLASSES:
				return classes != null && !classes.isEmpty();
			case FairPackage.DEPARTMENT__SUPERINTENDENTS:
				return superintendents != null && !superintendents.isEmpty();
			case FairPackage.DEPARTMENT__DIVISION:
				return getDivision() != null;
			case FairPackage.DEPARTMENT__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case FairPackage.DEPARTMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //DepartmentImpl
