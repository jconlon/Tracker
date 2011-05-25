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
 * A representation of the model object '<em><b>Birthing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Birthing#isViability <em>Viability</em>}</li>
 *   <li>{@link com.verticon.tracker.Birthing#isAssisted <em>Assisted</em>}</li>
 *   <li>{@link com.verticon.tracker.Birthing#getDifficulty <em>Difficulty</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getBirthing()
 * @model
 * @generated
 */
public interface Birthing extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";
	
	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 105;

	/**
	 * Returns the value of the '<em><b>Viability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viability</em>' attribute.
	 * @see #setViability(boolean)
	 * @see com.verticon.tracker.TrackerPackage#getBirthing_Viability()
	 * @model
	 * @generated
	 */
	boolean isViability();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Birthing#isViability <em>Viability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viability</em>' attribute.
	 * @see #isViability()
	 * @generated
	 */
	void setViability(boolean value);

	/**
	 * Returns the value of the '<em><b>Assisted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assisted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assisted</em>' attribute.
	 * @see #setAssisted(boolean)
	 * @see com.verticon.tracker.TrackerPackage#getBirthing_Assisted()
	 * @model
	 * @generated
	 */
	boolean isAssisted();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Birthing#isAssisted <em>Assisted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assisted</em>' attribute.
	 * @see #isAssisted()
	 * @generated
	 */
	void setAssisted(boolean value);

	/**
	 * Returns the value of the '<em><b>Difficulty</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.OneToTen}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Difficulty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Difficulty</em>' attribute.
	 * @see com.verticon.tracker.OneToTen
	 * @see #setDifficulty(OneToTen)
	 * @see com.verticon.tracker.TrackerPackage#getBirthing_Difficulty()
	 * @model
	 * @generated
	 */
	OneToTen getDifficulty();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Birthing#getDifficulty <em>Difficulty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Difficulty</em>' attribute.
	 * @see com.verticon.tracker.OneToTen
	 * @see #getDifficulty()
	 * @generated
	 */
	void setDifficulty(OneToTen value);

} // Birthing
