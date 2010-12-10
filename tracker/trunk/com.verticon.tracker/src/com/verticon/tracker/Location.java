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
package com.verticon.tracker;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Location#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.Location#getLatitudeInRadians <em>Latitude In Radians</em>}</li>
 *   <li>{@link com.verticon.tracker.Location#getLatitudeError <em>Latitude Error</em>}</li>
 *   <li>{@link com.verticon.tracker.Location#getLongitudeError <em>Longitude Error</em>}</li>
 *   <li>{@link com.verticon.tracker.Location#getLongitudeInRadians <em>Longitude In Radians</em>}</li>
 *   <li>{@link com.verticon.tracker.Location#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.tracker.Location#getLatitude <em>Latitude</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.verticon.tracker.TrackerPackage#getLocation_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Location#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Latitude In Radians</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude In Radians</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude In Radians</em>' attribute.
	 * @see #setLatitudeInRadians(double)
	 * @see com.verticon.tracker.TrackerPackage#getLocation_LatitudeInRadians()
	 * @model
	 * @generated
	 */
	double getLatitudeInRadians();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Location#getLatitudeInRadians <em>Latitude In Radians</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude In Radians</em>' attribute.
	 * @see #getLatitudeInRadians()
	 * @generated
	 */
	void setLatitudeInRadians(double value);

	/**
	 * Returns the value of the '<em><b>Latitude Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude Error</em>' attribute.
	 * @see #setLatitudeError(double)
	 * @see com.verticon.tracker.TrackerPackage#getLocation_LatitudeError()
	 * @model
	 * @generated
	 */
	double getLatitudeError();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Location#getLatitudeError <em>Latitude Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude Error</em>' attribute.
	 * @see #getLatitudeError()
	 * @generated
	 */
	void setLatitudeError(double value);

	/**
	 * Returns the value of the '<em><b>Longitude Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude Error</em>' attribute.
	 * @see #setLongitudeError(double)
	 * @see com.verticon.tracker.TrackerPackage#getLocation_LongitudeError()
	 * @model
	 * @generated
	 */
	double getLongitudeError();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Location#getLongitudeError <em>Longitude Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude Error</em>' attribute.
	 * @see #getLongitudeError()
	 * @generated
	 */
	void setLongitudeError(double value);

	/**
	 * Returns the value of the '<em><b>Longitude In Radians</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude In Radians</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude In Radians</em>' attribute.
	 * @see #setLongitudeInRadians(double)
	 * @see com.verticon.tracker.TrackerPackage#getLocation_LongitudeInRadians()
	 * @model
	 * @generated
	 */
	double getLongitudeInRadians();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Location#getLongitudeInRadians <em>Longitude In Radians</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude In Radians</em>' attribute.
	 * @see #getLongitudeInRadians()
	 * @generated
	 */
	void setLongitudeInRadians(double value);

	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getLocation_Longitude()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getLongitude();

	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getLocation_Latitude()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getLatitude();

} // Location
