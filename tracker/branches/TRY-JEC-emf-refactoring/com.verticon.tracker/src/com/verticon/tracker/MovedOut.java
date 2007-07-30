/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Moved Out</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.MovedOut#getDestinationPin <em>Destination Pin</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getMovedOut()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='DestinationPin_can_not_be_same_as_the_local_premisesId'"
 *        annotation="http://www.eclipse.org/ocl/examples/OCL DestinationPin_can_not_be_same_as_the_local_premisesId='-- The MovedOut destinationPin can not be the same as the local premisesId. --\nPremises.allInstances() -> select(premisesId=self.destinationPin) -> isEmpty()'"
 * @generated
 */
public interface MovedOut extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";
	
	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 4;

	/**
	 * Returns the value of the '<em><b>Destination Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Pin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Pin</em>' attribute.
	 * @see #setDestinationPin(String)
	 * @see com.verticon.tracker.TrackerPackage#getMovedOut_DestinationPin()
	 * @model dataType="com.verticon.tracker.PremisesIdNumber" required="true"
	 * @generated
	 */
	String getDestinationPin();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MovedOut#getDestinationPin <em>Destination Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Pin</em>' attribute.
	 * @see #getDestinationPin()
	 * @generated
	 */
	void setDestinationPin(String value);

} // MovedOut