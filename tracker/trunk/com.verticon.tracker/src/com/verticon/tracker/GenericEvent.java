/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.GenericEvent#getEventAttributes <em>Event Attributes</em>}</li>
 *   <li>{@link com.verticon.tracker.GenericEvent#getEventSchema <em>Event Schema</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getGenericEvent()
 * @model
 * @generated
 */
public interface GenericEvent extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 200;
	
	/**
	 * Returns the value of the '<em><b>Event Attributes</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Attributes</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Attributes</em>' map.
	 * @see com.verticon.tracker.TrackerPackage#getGenericEvent_EventAttributes()
	 * @model mapType="com.verticon.tracker.EventAttribute<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getEventAttributes();

	/**
	 * Returns the value of the '<em><b>Event Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Schema</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Schema</em>' reference.
	 * @see #setEventSchema(EventSchema)
	 * @see com.verticon.tracker.TrackerPackage#getGenericEvent_EventSchema()
	 * @model required="true"
	 * @generated
	 */
	EventSchema getEventSchema();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.GenericEvent#getEventSchema <em>Event Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Schema</em>' reference.
	 * @see #getEventSchema()
	 * @generated
	 */
	void setEventSchema(EventSchema value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model eventAttributeMapType="com.verticon.tracker.EventAttribute<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EventAttributeSchema findSchema(Entry eventAttribute);

} // GenericEvent
