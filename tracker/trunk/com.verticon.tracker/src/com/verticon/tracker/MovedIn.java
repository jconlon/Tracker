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
 * A representation of the model object '<em><b>Moved In</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.MovedIn#getSourcePin <em>Source Pin</em>}</li>
 *   <li>{@link com.verticon.tracker.MovedIn#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getMovedIn()
 * @model
 * @generated
 */
public interface MovedIn extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";
	
	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 3;

	/**
	 * Returns the value of the '<em><b>Source Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Pin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Pin</em>' attribute.
	 * @see #setSourcePin(String)
	 * @see com.verticon.tracker.TrackerPackage#getMovedIn_SourcePin()
	 * @model dataType="com.verticon.tracker.PremisesIdNumber" required="true"
	 * @generated
	 */
	String getSourcePin();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MovedIn#getSourcePin <em>Source Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Pin</em>' attribute.
	 * @see #getSourcePin()
	 * @generated
	 */
	void setSourcePin(String value);

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
	 * @see com.verticon.tracker.TrackerPackage#getMovedIn_Uri()
	 * @model dataType="com.verticon.tracker.URI"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MovedIn#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // MovedIn