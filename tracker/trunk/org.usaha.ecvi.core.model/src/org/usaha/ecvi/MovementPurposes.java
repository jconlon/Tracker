/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Movement Purposes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.MovementPurposes#getMovementPurpose <em>Movement Purpose</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getMovementPurposes()
 * @model extendedMetaData="name='MovementPurposeListType' kind='elementOnly'"
 * @generated
 */
public interface MovementPurposes extends EObject {
	/**
	 * Returns the value of the '<em><b>Movement Purpose</b></em>' attribute list.
	 * The list contents are of type {@link org.usaha.ecvi.MovementPurpose}.
	 * The literals are from the enumeration {@link org.usaha.ecvi.MovementPurpose}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movement Purpose</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movement Purpose</em>' attribute list.
	 * @see org.usaha.ecvi.MovementPurpose
	 * @see org.usaha.ecvi.EcviPackage#getMovementPurposes_MovementPurpose()
	 * @model unique="false" required="true"
	 *        extendedMetaData="kind='element' name='MovementPurpose' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<MovementPurpose> getMovementPurpose();

} // MovementPurposes
