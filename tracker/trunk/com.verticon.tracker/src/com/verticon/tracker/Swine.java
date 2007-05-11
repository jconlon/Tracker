/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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

} // Swine