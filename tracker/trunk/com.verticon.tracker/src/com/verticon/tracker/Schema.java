/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Schema#getEventSchema <em>Event Schema</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getSchema()
 * @model
 * @generated
 */
public interface Schema extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Event Schema</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Schema</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Schema</em>' containment reference.
	 * @see #setEventSchema(EventSchema)
	 * @see com.verticon.tracker.TrackerPackage#getSchema_EventSchema()
	 * @model containment="true"
	 * @generated
	 */
	EventSchema getEventSchema();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Schema#getEventSchema <em>Event Schema</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Schema</em>' containment reference.
	 * @see #getEventSchema()
	 * @generated
	 */
	void setEventSchema(EventSchema value);

} // Schema
