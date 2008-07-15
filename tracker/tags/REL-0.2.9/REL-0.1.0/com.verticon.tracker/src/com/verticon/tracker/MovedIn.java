/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getMovedIn()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SourcePin_can_not_be_same_as_the_local_premisesId '"
 *        annotation="http://www.eclipse.org/ocl/examples/OCL SourcePin_can_not_be_same_as_the_local_premisesId='-- The MovedIn sourcePin can not be the same as the local premisesId. --\nPremises.allInstances() -> select(premisesId=self.sourcePin) -> isEmpty()'"
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

} // MovedIn