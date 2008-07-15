/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Animals#getAnimal <em>Animal</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getAnimals()
 * @model
 * @generated
 */
public interface Animals extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Animal</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.Animal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getAnimals_Animal()
	 * @model type="com.verticon.tracker.Animal" containment="true" required="true"
	 * @generated
	 */
	EList getAnimal();

} // Animals