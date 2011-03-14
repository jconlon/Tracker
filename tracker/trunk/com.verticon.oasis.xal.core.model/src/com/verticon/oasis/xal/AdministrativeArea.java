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
 * A representation of the model object '<em><b>Administrative Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getAdministrativeAreaName <em>Administrative Area Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getSubAdministrativeArea <em>Sub Administrative Area</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getLocality <em>Locality</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getPostOffice <em>Post Office</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getUsageType <em>Usage Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AdministrativeArea#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea()
 * @model extendedMetaData="name='AdministrativeArea_._type' kind='elementOnly'"
 * @generated
 */
public interface AdministrativeArea extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

	/**
	 * Returns the value of the '<em><b>Administrative Area Name</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AdministrativeAreaName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Name of the administrative area. eg. MI in USA, NSW in Australia
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Administrative Area Name</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_AdministrativeAreaName()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AdministrativeAreaName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AdministrativeAreaName> getAdministrativeAreaName();

	/**
	 * Returns the value of the '<em><b>Sub Administrative Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Specification of a sub-administrative area. An example of a sub-administrative areas is a county. There are two places where the name of an administrative 
	 * area can be specified and in this case, one becomes sub-administrative area.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Administrative Area</em>' containment reference.
	 * @see #setSubAdministrativeArea(SubAdministrativeArea)
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_SubAdministrativeArea()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SubAdministrativeArea' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAdministrativeArea getSubAdministrativeArea();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AdministrativeArea#getSubAdministrativeArea <em>Sub Administrative Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Administrative Area</em>' containment reference.
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	void setSubAdministrativeArea(SubAdministrativeArea value);

	/**
	 * Returns the value of the '<em><b>Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Locality is one level lower than adminisstrative area. Eg.: cities, reservations and any other built-up areas.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Locality</em>' containment reference.
	 * @see #setLocality(Locality)
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_Locality()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Locality' namespace='##targetNamespace'"
	 * @generated
	 */
	Locality getLocality();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AdministrativeArea#getLocality <em>Locality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locality</em>' containment reference.
	 * @see #getLocality()
	 * @generated
	 */
	void setLocality(Locality value);

	/**
	 * Returns the value of the '<em><b>Post Office</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a post office. Examples are a rural post office where post is delivered and a post office containing post office boxes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Office</em>' containment reference.
	 * @see #setPostOffice(PostOffice)
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_PostOffice()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostOffice' namespace='##targetNamespace'"
	 * @generated
	 */
	PostOffice getPostOffice();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AdministrativeArea#getPostOffice <em>Post Office</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Office</em>' containment reference.
	 * @see #getPostOffice()
	 * @generated
	 */
	void setPostOffice(PostOffice value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * PostalCode is the container element for either simple or complex (extended) postal codes. Type: Area Code, Postcode, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Code</em>' containment reference.
	 * @see #setPostalCode(PostalCode)
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_PostalCode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalCode' namespace='##targetNamespace'"
	 * @generated
	 */
	PostalCode getPostalCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AdministrativeArea#getPostalCode <em>Postal Code</em>}' containment reference.
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
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_Any()
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
	 * Erode (Dist) where (Dist) is the Indicator
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indicator</em>' attribute.
	 * @see #setIndicator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_Indicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Indicator'"
	 * @generated
	 */
	Object getIndicator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AdministrativeArea#getIndicator <em>Indicator</em>}' attribute.
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
	 * Province or State or County or Kanton, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AdministrativeArea#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(Object value);

	/**
	 * Returns the value of the '<em><b>Usage Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Postal or Political - Sometimes locations must be distinguished between postal system, and physical locations as defined by a political system
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Usage Type</em>' attribute.
	 * @see #setUsageType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_UsageType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='UsageType'"
	 * @generated
	 */
	Object getUsageType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AdministrativeArea#getUsageType <em>Usage Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Type</em>' attribute.
	 * @see #getUsageType()
	 * @generated
	 */
	void setUsageType(Object value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getAdministrativeArea_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':10' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // AdministrativeArea
