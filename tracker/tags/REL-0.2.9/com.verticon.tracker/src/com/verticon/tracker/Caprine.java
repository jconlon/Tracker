/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Caprine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Caprine#getGoatBreed <em>Goat Breed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getCaprine()
 * @model
 * @generated
 */
public interface Caprine extends Animal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Goat Breed</b></em>' attribute.
	 * The default value is <code>"Unspecified"</code>.
	 * The literals are from the enumeration {@link com.verticon.tracker.GoatBreed}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goat Breed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goat Breed</em>' attribute.
	 * @see com.verticon.tracker.GoatBreed
	 * @see #setGoatBreed(GoatBreed)
	 * @see com.verticon.tracker.TrackerPackage#getCaprine_GoatBreed()
	 * @model default="Unspecified"
	 * @generated
	 */
	GoatBreed getGoatBreed();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Caprine#getGoatBreed <em>Goat Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goat Breed</em>' attribute.
	 * @see com.verticon.tracker.GoatBreed
	 * @see #getGoatBreed()
	 * @generated
	 */
	void setGoatBreed(GoatBreed value);

} // Caprine
