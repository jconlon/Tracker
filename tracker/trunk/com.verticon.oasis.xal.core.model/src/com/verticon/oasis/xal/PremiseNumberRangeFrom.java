/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Premise Number Range From</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRangeFrom#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumberPrefix <em>Premise Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumber <em>Premise Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumberSuffix <em>Premise Number Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRangeFrom()
 * @model extendedMetaData="name='PremiseNumberRangeFrom_._type' kind='elementOnly'"
 * @generated
 */
public interface PremiseNumberRangeFrom extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRangeFrom_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

	/**
	 * Returns the value of the '<em><b>Premise Number Prefix</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PremiseNumberPrefix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A in A12
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number Prefix</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRangeFrom_PremiseNumberPrefix()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PremiseNumberPrefix' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PremiseNumberPrefix> getPremiseNumberPrefix();

	/**
	 * Returns the value of the '<em><b>Premise Number</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PremiseNumber}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the identifier of the premise (house, building, etc). Premises in a street are often uniquely identified by means of consecutive identifiers. The identifier can be a number, a letter or any combination of the two.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRangeFrom_PremiseNumber()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='PremiseNumber' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PremiseNumber> getPremiseNumber();

	/**
	 * Returns the value of the '<em><b>Premise Number Suffix</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PremiseNumberSuffix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A in 12A
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number Suffix</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRangeFrom_PremiseNumberSuffix()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PremiseNumberSuffix' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PremiseNumberSuffix> getPremiseNumberSuffix();

} // PremiseNumberRangeFrom
