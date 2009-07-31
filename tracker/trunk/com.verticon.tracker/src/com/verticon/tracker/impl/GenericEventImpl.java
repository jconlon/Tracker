/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.tracker.EventAttributeSchema;
import com.verticon.tracker.EventSchema;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.GenericEventImpl#getEventAttributes <em>Event Attributes</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.GenericEventImpl#getEventSchema <em>Event Schema</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericEventImpl extends EventImpl implements GenericEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The cached value of the '{@link #getEventAttributes() <em>Event Attributes</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventAttributes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> eventAttributes;

	/**
	 * The cached value of the '{@link #getEventSchema() <em>Event Schema</em>}' reference.
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
	protected GenericEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.GENERIC_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getEventAttributes() {
		if (eventAttributes == null) {
			eventAttributes = new EcoreEMap<String,String>(TrackerPackage.Literals.EVENT_ATTRIBUTE, EventAttributeImpl.class, this, TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES);
		}
		return eventAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSchema getEventSchema() {
		if (eventSchema != null && eventSchema.eIsProxy()) {
			InternalEObject oldEventSchema = (InternalEObject)eventSchema;
			eventSchema = (EventSchema)eResolveProxy(oldEventSchema);
			if (eventSchema != oldEventSchema) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.GENERIC_EVENT__EVENT_SCHEMA, oldEventSchema, eventSchema));
			}
		}
		return eventSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSchema basicGetEventSchema() {
		return eventSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventSchemaGen(EventSchema newEventSchema) {
		EventSchema oldEventSchema = eventSchema;
		eventSchema = newEventSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.GENERIC_EVENT__EVENT_SCHEMA, oldEventSchema, eventSchema));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEventSchema(EventSchema newEventSchema) {
		setEventSchemaGen( newEventSchema);
		if(newEventSchema == null || newEventSchema.getEventAttributes().isEmpty()){
			getEventAttributes().clear();
			return;
		}else if (getEventAttributes().isEmpty()) {
			for (EventAttributeSchema eventAttributeSchema : newEventSchema.getEventAttributes()) {
				EventAttributeImpl eventAttribute =new EventAttributeImpl();
				eventAttribute.setKey(eventAttributeSchema.getName());
				getEventAttributes().add(eventAttribute);
			}
			return;
		}
	}


	/**
	 * <!-- begin-user-doc -->
	 * Implemented operation
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EventAttributeSchema findSchema(Map.Entry<String, String> eventAttribute) {
		if(getEventSchema() ==null ){
			return null;
		}
		for (EventAttributeSchema eventAttributeSchema : this.getEventSchema().getEventAttributes()) {
			if(eventAttribute.getKey().equals(eventAttributeSchema.getName())){
				return eventAttributeSchema;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
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
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				if (coreType) return getEventAttributes();
				else return getEventAttributes().map();
			case TrackerPackage.GENERIC_EVENT__EVENT_SCHEMA:
				if (resolve) return getEventSchema();
				return basicGetEventSchema();
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
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				((EStructuralFeature.Setting)getEventAttributes()).set(newValue);
				return;
			case TrackerPackage.GENERIC_EVENT__EVENT_SCHEMA:
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
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				getEventAttributes().clear();
				return;
			case TrackerPackage.GENERIC_EVENT__EVENT_SCHEMA:
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
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				return eventAttributes != null && !eventAttributes.isEmpty();
			case TrackerPackage.GENERIC_EVENT__EVENT_SCHEMA:
				return eventSchema != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getEventCode() {
		return EVENT_CODE;
	}

} //GenericEventImpl
