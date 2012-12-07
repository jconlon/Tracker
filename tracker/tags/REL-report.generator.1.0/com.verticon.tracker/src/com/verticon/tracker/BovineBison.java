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
 * A representation of the model object '<em><b>Bovine Bison</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.BovineBison#getBuffaloBreed <em>Buffalo Breed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getBovineBison()
 * @model
 * @generated
 */
public interface BovineBison extends Bovine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Buffalo Breed</b></em>' attribute.
	 * The default value is <code>"Unspecified"</code>.
	 * The literals are from the enumeration {@link com.verticon.tracker.BisonBreed}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffalo Breed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffalo Breed</em>' attribute.
	 * @see com.verticon.tracker.BisonBreed
	 * @see #setBuffaloBreed(BisonBreed)
	 * @see com.verticon.tracker.TrackerPackage#getBovineBison_BuffaloBreed()
	 * @model default="Unspecified"
	 * @generated
	 */
	BisonBreed getBuffaloBreed();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.BovineBison#getBuffaloBreed <em>Buffalo Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffalo Breed</em>' attribute.
	 * @see com.verticon.tracker.BisonBreed
	 * @see #getBuffaloBreed()
	 * @generated
	 */
	void setBuffaloBreed(BisonBreed value);

} // BovineBison