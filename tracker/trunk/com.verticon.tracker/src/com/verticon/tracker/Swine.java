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
 * A representation of the model object '<em><b>Swine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Swine#getSwineBreed <em>Swine Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.Swine#getRightEarNotching <em>Right Ear Notching</em>}</li>
 *   <li>{@link com.verticon.tracker.Swine#getLeftEarNotching <em>Left Ear Notching</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getSwine()
 * @model
 * @generated
 */
public interface Swine extends Animal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Swine Breed</b></em>' attribute.
	 * The default value is <code>"Unspecified"</code>.
	 * The literals are from the enumeration {@link com.verticon.tracker.SwineBreed}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Swine Breed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swine Breed</em>' attribute.
	 * @see com.verticon.tracker.SwineBreed
	 * @see #setSwineBreed(SwineBreed)
	 * @see com.verticon.tracker.TrackerPackage#getSwine_SwineBreed()
	 * @model default="Unspecified"
	 * @generated
	 */
	SwineBreed getSwineBreed();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Swine#getSwineBreed <em>Swine Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Swine Breed</em>' attribute.
	 * @see com.verticon.tracker.SwineBreed
	 * @see #getSwineBreed()
	 * @generated
	 */
	void setSwineBreed(SwineBreed value);

	/**
	 * Returns the value of the '<em><b>Right Ear Notching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Ear Notching</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Ear Notching</em>' attribute.
	 * @see #setRightEarNotching(int)
	 * @see com.verticon.tracker.TrackerPackage#getSwine_RightEarNotching()
	 * @model
	 * @generated
	 */
	int getRightEarNotching();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Swine#getRightEarNotching <em>Right Ear Notching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Ear Notching</em>' attribute.
	 * @see #getRightEarNotching()
	 * @generated
	 */
	void setRightEarNotching(int value);

	/**
	 * Returns the value of the '<em><b>Left Ear Notching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Ear Notching</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Ear Notching</em>' attribute.
	 * @see #setLeftEarNotching(int)
	 * @see com.verticon.tracker.TrackerPackage#getSwine_LeftEarNotching()
	 * @model
	 * @generated
	 */
	int getLeftEarNotching();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Swine#getLeftEarNotching <em>Left Ear Notching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Ear Notching</em>' attribute.
	 * @see #getLeftEarNotching()
	 * @generated
	 */
	void setLeftEarNotching(int value);

} // Swine