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
 * A representation of the model object '<em><b>Ovine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Ovine#getSheepBreed <em>Sheep Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.Ovine#getScrapieTag <em>Scrapie Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getOvine()
 * @model
 * @generated
 */
public interface Ovine extends Animal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Sheep Breed</b></em>' attribute.
	 * The default value is <code>"Unspecified"</code>.
	 * The literals are from the enumeration {@link com.verticon.tracker.SheepBreed}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sheep Breed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sheep Breed</em>' attribute.
	 * @see com.verticon.tracker.SheepBreed
	 * @see #setSheepBreed(SheepBreed)
	 * @see com.verticon.tracker.TrackerPackage#getOvine_SheepBreed()
	 * @model default="Unspecified"
	 * @generated
	 */
	SheepBreed getSheepBreed();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Ovine#getSheepBreed <em>Sheep Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sheep Breed</em>' attribute.
	 * @see com.verticon.tracker.SheepBreed
	 * @see #getSheepBreed()
	 * @generated
	 */
	void setSheepBreed(SheepBreed value);

	/**
	 * Returns the value of the '<em><b>Scrapie Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scrapie Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scrapie Tag</em>' attribute.
	 * @see #setScrapieTag(String)
	 * @see com.verticon.tracker.TrackerPackage#getOvine_ScrapieTag()
	 * @model
	 * @generated
	 */
	String getScrapieTag();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Ovine#getScrapieTag <em>Scrapie Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scrapie Tag</em>' attribute.
	 * @see #getScrapieTag()
	 * @generated
	 */
	void setScrapieTag(String value);

} // Ovine