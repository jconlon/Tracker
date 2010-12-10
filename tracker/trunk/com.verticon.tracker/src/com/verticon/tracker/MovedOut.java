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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Moved Out</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.MovedOut#getDestinationPin <em>Destination Pin</em>}</li>
 *   <li>{@link com.verticon.tracker.MovedOut#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getMovedOut()
 * @model
 * @generated
 */
public interface MovedOut extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";
	
	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 4;

	/**
	 * Returns the value of the '<em><b>Destination Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Pin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Pin</em>' attribute.
	 * @see #setDestinationPin(String)
	 * @see com.verticon.tracker.TrackerPackage#getMovedOut_DestinationPin()
	 * @model dataType="com.verticon.tracker.PremisesIdNumber" required="true"
	 * @generated
	 */
	String getDestinationPin();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MovedOut#getDestinationPin <em>Destination Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Pin</em>' attribute.
	 * @see #getDestinationPin()
	 * @generated
	 */
	void setDestinationPin(String value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see com.verticon.tracker.TrackerPackage#getMovedOut_Uri()
	 * @model dataType="com.verticon.tracker.URI"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MovedOut#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // MovedOut