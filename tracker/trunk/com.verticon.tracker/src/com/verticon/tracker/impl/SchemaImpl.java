/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import com.verticon.tracker.EventSchema;
import com.verticon.tracker.Schema;
import com.verticon.tracker.TrackerPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.SchemaImpl#getEventSchema <em>Event Schema</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchemaImpl extends EObjectImpl implements Schema {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The cached value of the '{@link #getEventSchema() <em>Event Schema</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventSchema()
	 * @generated
	 * @ordered
	 */
	protected EventSchema eventSchema;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchemaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.SCHEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSchema getEventSchema() {
		return eventSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventSchema(EventSchema newEventSchema, NotificationChain msgs) {
		EventSchema oldEventSchema = eventSchema;
		eventSchema = newEventSchema;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrackerPackage.SCHEMA__EVENT_SCHEMA, oldEventSchema, newEventSchema);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventSchema(EventSchema newEventSchema) {
		if (newEventSchema != eventSchema) {
			NotificationChain msgs = null;
			if (eventSchema != null)
				msgs = ((InternalEObject)eventSchema).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.SCHEMA__EVENT_SCHEMA, null, msgs);
			if (newEventSchema != null)
				msgs = ((InternalEObject)newEventSchema).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.SCHEMA__EVENT_SCHEMA, null, msgs);
			msgs = basicSetEventSchema(newEventSchema, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.SCHEMA__EVENT_SCHEMA, newEventSchema, newEventSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.SCHEMA__EVENT_SCHEMA:
				return basicSetEventSchema(null, msgs);
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
			case TrackerPackage.SCHEMA__EVENT_SCHEMA:
				return getEventSchema();
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
			case TrackerPackage.SCHEMA__EVENT_SCHEMA:
				setEventSchema((EventSchema)newValue);
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
			case TrackerPackage.SCHEMA__EVENT_SCHEMA:
				setEventSchema((EventSchema)null);
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
			case TrackerPackage.SCHEMA__EVENT_SCHEMA:
				return eventSchema != null;
		}
		return super.eIsSet(featureID);
	}

} //SchemaImpl
