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
 * A representation of the model object '<em><b>Post Office</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getPostOfficeName <em>Post Office Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getPostOfficeNumber <em>Post Office Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getPostalRoute <em>Postal Route</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getPostBox <em>Post Box</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostOffice#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getPostOffice()
 * @model extendedMetaData="name='PostOffice_._type' kind='elementOnly'"
 * @generated
 */
public interface PostOffice extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

	/**
	 * Returns the value of the '<em><b>Post Office Name</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PostOfficeName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the name of the post office. This can be a rural postoffice where post is delivered or a post office containing post office boxes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Office Name</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_PostOfficeName()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostOfficeName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PostOfficeName> getPostOfficeName();

	/**
	 * Returns the value of the '<em><b>Post Office Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the number of the postoffice. Common in rural postoffices
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Office Number</em>' containment reference.
	 * @see #setPostOfficeNumber(PostOfficeNumber)
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_PostOfficeNumber()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostOfficeNumber' namespace='##targetNamespace'"
	 * @generated
	 */
	PostOfficeNumber getPostOfficeNumber();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostOffice#getPostOfficeNumber <em>Post Office Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Office Number</em>' containment reference.
	 * @see #getPostOfficeNumber()
	 * @generated
	 */
	void setPostOfficeNumber(PostOfficeNumber value);

	/**
	 * Returns the value of the '<em><b>Postal Route</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A Postal van is specific for a route as in Is`rael, Rural route
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Route</em>' containment reference.
	 * @see #setPostalRoute(PostalRoute)
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_PostalRoute()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalRoute' namespace='##targetNamespace'"
	 * @generated
	 */
	PostalRoute getPostalRoute();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostOffice#getPostalRoute <em>Postal Route</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Route</em>' containment reference.
	 * @see #getPostalRoute()
	 * @generated
	 */
	void setPostalRoute(PostalRoute value);

	/**
	 * Returns the value of the '<em><b>Post Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a postbox like mail delivery point. Only a single postbox number can be specified. Examples of postboxes are POBox, free mail numbers, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Box</em>' containment reference.
	 * @see #setPostBox(PostBox)
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_PostBox()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostBox' namespace='##targetNamespace'"
	 * @generated
	 */
	PostBox getPostBox();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostOffice#getPostBox <em>Post Box</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Box</em>' containment reference.
	 * @see #getPostBox()
	 * @generated
	 */
	void setPostBox(PostBox value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * PostalCode is the container element for either simple or complex (extended) postal codes. Type: Area Code, Postcode, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Code</em>' containment reference.
	 * @see #setPostalCode(PostalCode)
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_PostalCode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalCode' namespace='##targetNamespace'"
	 * @generated
	 */
	PostalCode getPostalCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostOffice#getPostalCode <em>Postal Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' containment reference.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(PostalCode value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':6' processing='strict'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * eg. Kottivakkam (P.O) here (P.O) is the Indicator
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indicator</em>' attribute.
	 * @see #setIndicator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_Indicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Indicator'"
	 * @generated
	 */
	Object getIndicator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostOffice#getIndicator <em>Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indicator</em>' attribute.
	 * @see #getIndicator()
	 * @generated
	 */
	void setIndicator(Object value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Could be a Mobile Postoffice Van as in Isreal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostOffice#getType <em>Type</em>}' attribute.
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
	 * @see com.verticon.oasis.xal.XalPackage#getPostOffice_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':9' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // PostOffice
