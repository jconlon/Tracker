/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postal Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.PostalCode#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalCode#getPostalCodeNumber <em>Postal Code Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalCode#getPostalCodeNumberExtension <em>Postal Code Number Extension</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalCode#getPostTown <em>Post Town</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalCode#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalCode#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalCode#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getPostalCode()
 * @model extendedMetaData="name='PostalCode_._type' kind='elementOnly'"
 * @generated
 */
public interface PostalCode extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostalCode_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

	/**
	 * Returns the value of the '<em><b>Postal Code Number</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PostalCodeNumber}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a postcode. The postcode is formatted according to country-specific rules. Example: SW3 0A8-1A, 600074, 2067
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Code Number</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostalCode_PostalCodeNumber()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalCodeNumber' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PostalCodeNumber> getPostalCodeNumber();

	/**
	 * Returns the value of the '<em><b>Postal Code Number Extension</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PostalCodeNumberExtension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Examples are: 1234 (USA), 1G (UK), etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Code Number Extension</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostalCode_PostalCodeNumberExtension()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalCodeNumberExtension' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PostalCodeNumberExtension> getPostalCodeNumberExtension();

	/**
	 * Returns the value of the '<em><b>Post Town</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A post town is not the same as a locality. A post town can encompass a collection of (small) localities. It can also be a subpart of a locality. An actual post town in Norway is "Bergen".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Town</em>' containment reference.
	 * @see #setPostTown(PostTown)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalCode_PostTown()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostTown' namespace='##targetNamespace'"
	 * @generated
	 */
	PostTown getPostTown();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalCode#getPostTown <em>Post Town</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Town</em>' containment reference.
	 * @see #getPostTown()
	 * @generated
	 */
	void setPostTown(PostTown value);

	/**
	 * Returns the value of the '<em><b>Any</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostalCode_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':4' processing='strict'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Area Code, Postcode, Delivery code as in NZ, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalCode_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalCode#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(Object value);

	/**
	 * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Attribute</em>' attribute list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostalCode_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':6' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // PostalCode
