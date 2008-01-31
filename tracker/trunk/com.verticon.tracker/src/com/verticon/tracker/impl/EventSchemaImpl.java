/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import com.verticon.tracker.AnimalType;
import com.verticon.tracker.EventAttributeSchema;
import com.verticon.tracker.EventSchema;
import com.verticon.tracker.TrackerPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.EventSchemaImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventSchemaImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventSchemaImpl#getAnimalType <em>Animal Type</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventSchemaImpl#getEventAttributes <em>Event Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventSchemaImpl extends EObjectImpl implements EventSchema {
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
	 * The cached value of the '{@link #getAnimalType() <em>Animal Type</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimalType()
	 * @generated
	 * @ordered
	 */
	protected EList<AnimalType> animalType;

	/**
	 * The cached value of the '{@link #getEventAttributes() <em>Event Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<EventAttributeSchema> eventAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventSchemaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.EVENT_SCHEMA;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT_SCHEMA__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT_SCHEMA__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnimalType> getAnimalType() {
		if (animalType == null) {
			animalType = new EDataTypeUniqueEList<AnimalType>(AnimalType.class, this, TrackerPackage.EVENT_SCHEMA__ANIMAL_TYPE);
		}
		return animalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventAttributeSchema> getEventAttributes() {
		if (eventAttributes == null) {
			eventAttributes = new EObjectContainmentEList<EventAttributeSchema>(EventAttributeSchema.class, this, TrackerPackage.EVENT_SCHEMA__EVENT_ATTRIBUTES);
		}
		return eventAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.EVENT_SCHEMA__EVENT_ATTRIBUTES:
				return ((InternalEList<?>)getEventAttributes()).basicRemove(otherEnd, msgs);
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
			case TrackerPackage.EVENT_SCHEMA__NAME:
				return getName();
			case TrackerPackage.EVENT_SCHEMA__DESCRIPTION:
				return getDescription();
			case TrackerPackage.EVENT_SCHEMA__ANIMAL_TYPE:
				return getAnimalType();
			case TrackerPackage.EVENT_SCHEMA__EVENT_ATTRIBUTES:
				return getEventAttributes();
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
			case TrackerPackage.EVENT_SCHEMA__NAME:
				setName((String)newValue);
				return;
			case TrackerPackage.EVENT_SCHEMA__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case TrackerPackage.EVENT_SCHEMA__ANIMAL_TYPE:
				getAnimalType().clear();
				getAnimalType().addAll((Collection<? extends AnimalType>)newValue);
				return;
			case TrackerPackage.EVENT_SCHEMA__EVENT_ATTRIBUTES:
				getEventAttributes().clear();
				getEventAttributes().addAll((Collection<? extends EventAttributeSchema>)newValue);
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
			case TrackerPackage.EVENT_SCHEMA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TrackerPackage.EVENT_SCHEMA__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case TrackerPackage.EVENT_SCHEMA__ANIMAL_TYPE:
				getAnimalType().clear();
				return;
			case TrackerPackage.EVENT_SCHEMA__EVENT_ATTRIBUTES:
				getEventAttributes().clear();
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
			case TrackerPackage.EVENT_SCHEMA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TrackerPackage.EVENT_SCHEMA__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case TrackerPackage.EVENT_SCHEMA__ANIMAL_TYPE:
				return animalType != null && !animalType.isEmpty();
			case TrackerPackage.EVENT_SCHEMA__EVENT_ATTRIBUTES:
				return eventAttributes != null && !eventAttributes.isEmpty();
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
		result.append(", description: ");
		result.append(description);
		result.append(", animalType: ");
		result.append(animalType);
		result.append(')');
		return result.toString();
	}

} //EventSchemaImpl
