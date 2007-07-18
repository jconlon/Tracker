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
 * A representation of the model object '<em><b>Un Applied Tags</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.UnAppliedTags#getAin <em>Ain</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getUnAppliedTags()
 * @model
 * @generated
 */
public interface UnAppliedTags extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Ain</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.AnimalId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ain</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getUnAppliedTags_Ain()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnimalId> getAin();

} // UnAppliedTags