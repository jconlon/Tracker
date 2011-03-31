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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Inclusion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.EventInclusion#getSpecies <em>Species</em>}</li>
 *   <li>{@link com.verticon.tracker.EventInclusion#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getEventInclusion()
 * @model
 * @generated
 */
public interface EventInclusion extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Species</b></em>' attribute list.
	 * The list contents are of type {@link com.verticon.tracker.AnimalType}.
	 * The literals are from the enumeration {@link com.verticon.tracker.AnimalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Species</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Species</em>' attribute list.
	 * @see com.verticon.tracker.AnimalType
	 * @see com.verticon.tracker.TrackerPackage#getEventInclusion_Species()
	 * @model required="true"
	 * @generated
	 */
	EList<AnimalType> getSpecies();

	/**
	 * Returns the value of the '<em><b>Event</b></em>' attribute list.
	 * The list contents are of type {@link com.verticon.tracker.EventType}.
	 * The literals are from the enumeration {@link com.verticon.tracker.EventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' attribute list.
	 * @see com.verticon.tracker.EventType
	 * @see com.verticon.tracker.TrackerPackage#getEventInclusion_Event()
	 * @model required="true"
	 * @generated
	 */
	EList<EventType> getEvent();

} // EventInclusion
