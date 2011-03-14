/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address Details</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getPostalServiceElements <em>Postal Service Elements</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getAddress <em>Address</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getAddressLines <em>Address Lines</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getCountry <em>Country</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getAdministrativeArea <em>Administrative Area</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getLocality <em>Locality</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getThoroughfare <em>Thoroughfare</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getAddressDetailsKey <em>Address Details Key</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getAddressType <em>Address Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getCurrentStatus <em>Current Status</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getUsage <em>Usage</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getValidFromDate <em>Valid From Date</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getValidToDate <em>Valid To Date</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.AddressDetails#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails()
 * @model extendedMetaData="name='AddressDetails' kind='elementOnly'"
 * @generated
 */
public interface AddressDetails extends EObject {
	/**
	 * Returns the value of the '<em><b>Postal Service Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Postal authorities use specific postal service data to expedient delivery of mail
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Service Elements</em>' containment reference.
	 * @see #setPostalServiceElements(PostalServiceElements)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_PostalServiceElements()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalServiceElements' namespace='##targetNamespace'"
	 * @generated
	 */
	PostalServiceElements getPostalServiceElements();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getPostalServiceElements <em>Postal Service Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Service Elements</em>' containment reference.
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	void setPostalServiceElements(PostalServiceElements value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Address as one line of free text
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(Address)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_Address()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Address' namespace='##targetNamespace'"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

	/**
	 * Returns the value of the '<em><b>Address Lines</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Container for Address lines
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Lines</em>' containment reference.
	 * @see #setAddressLines(AddressLines)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_AddressLines()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLines' namespace='##targetNamespace'"
	 * @generated
	 */
	AddressLines getAddressLines();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getAddressLines <em>Address Lines</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Lines</em>' containment reference.
	 * @see #getAddressLines()
	 * @generated
	 */
	void setAddressLines(AddressLines value);

	/**
	 * Returns the value of the '<em><b>Country</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a country
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Country</em>' containment reference.
	 * @see #setCountry(Country)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_Country()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Country' namespace='##targetNamespace'"
	 * @generated
	 */
	Country getCountry();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getCountry <em>Country</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country</em>' containment reference.
	 * @see #getCountry()
	 * @generated
	 */
	void setCountry(Country value);

	/**
	 * Returns the value of the '<em><b>Administrative Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Examples of administrative areas are provinces counties, special regions (such as "Rijnmond"), etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Administrative Area</em>' containment reference.
	 * @see #setAdministrativeArea(AdministrativeArea)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_AdministrativeArea()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AdministrativeArea' namespace='##targetNamespace'"
	 * @generated
	 */
	AdministrativeArea getAdministrativeArea();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getAdministrativeArea <em>Administrative Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Administrative Area</em>' containment reference.
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	void setAdministrativeArea(AdministrativeArea value);

	/**
	 * Returns the value of the '<em><b>Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Locality is one level lower than adminisstrative area. Eg.: cities, reservations and any other built-up areas.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Locality</em>' containment reference.
	 * @see #setLocality(Locality)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_Locality()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Locality' namespace='##targetNamespace'"
	 * @generated
	 */
	Locality getLocality();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getLocality <em>Locality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locality</em>' containment reference.
	 * @see #getLocality()
	 * @generated
	 */
	void setLocality(Locality value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a thoroughfare. A thoroughfare could be a rd, street, canal, river, etc.  Note dependentlocality in a street. For example, in some countries, a large street will 
	 * have many subdivisions with numbers. Normally the subdivision name is the same as the road name, but with a number to identifiy it. Eg. SOI SUKUMVIT 3, SUKUMVIT RD, BANGKOK
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare</em>' containment reference.
	 * @see #setThoroughfare(Thoroughfare)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_Thoroughfare()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Thoroughfare' namespace='##targetNamespace'"
	 * @generated
	 */
	Thoroughfare getThoroughfare();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getThoroughfare <em>Thoroughfare</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare</em>' containment reference.
	 * @see #getThoroughfare()
	 * @generated
	 */
	void setThoroughfare(Thoroughfare value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':7' processing='strict'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Address Details Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Key identifier for the element for not reinforced references from other elements. Not required to be unique for the document to be valid, but application may get confused if not unique. Extend this schema adding unique contraint if needed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Details Key</em>' attribute.
	 * @see #setAddressDetailsKey(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_AddressDetailsKey()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='AddressDetailsKey'"
	 * @generated
	 */
	Object getAddressDetailsKey();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getAddressDetailsKey <em>Address Details Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Details Key</em>' attribute.
	 * @see #getAddressDetailsKey()
	 * @generated
	 */
	void setAddressDetailsKey(Object value);

	/**
	 * Returns the value of the '<em><b>Address Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of address. Example: Postal, residential,business, primary, secondary, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Type</em>' attribute.
	 * @see #setAddressType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_AddressType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='AddressType'"
	 * @generated
	 */
	Object getAddressType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getAddressType <em>Address Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Type</em>' attribute.
	 * @see #getAddressType()
	 * @generated
	 */
	void setAddressType(Object value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used by postal services to encode the name of the element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_Code()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Code'"
	 * @generated
	 */
	Object getCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(Object value);

	/**
	 * Returns the value of the '<em><b>Current Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Moved, Living, Investment, Deceased, etc..
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Current Status</em>' attribute.
	 * @see #setCurrentStatus(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_CurrentStatus()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='CurrentStatus'"
	 * @generated
	 */
	Object getCurrentStatus();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getCurrentStatus <em>Current Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Status</em>' attribute.
	 * @see #getCurrentStatus()
	 * @generated
	 */
	void setCurrentStatus(Object value);

	/**
	 * Returns the value of the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Communication, Contact, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Usage</em>' attribute.
	 * @see #setUsage(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_Usage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Usage'"
	 * @generated
	 */
	Object getUsage();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getUsage <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage</em>' attribute.
	 * @see #getUsage()
	 * @generated
	 */
	void setUsage(Object value);

	/**
	 * Returns the value of the '<em><b>Valid From Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Start Date of the validity of address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Valid From Date</em>' attribute.
	 * @see #setValidFromDate(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_ValidFromDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='ValidFromDate'"
	 * @generated
	 */
	Object getValidFromDate();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getValidFromDate <em>Valid From Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid From Date</em>' attribute.
	 * @see #getValidFromDate()
	 * @generated
	 */
	void setValidFromDate(Object value);

	/**
	 * Returns the value of the '<em><b>Valid To Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * End date of the validity of address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Valid To Date</em>' attribute.
	 * @see #setValidToDate(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_ValidToDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='ValidToDate'"
	 * @generated
	 */
	Object getValidToDate();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.AddressDetails#getValidToDate <em>Valid To Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid To Date</em>' attribute.
	 * @see #getValidToDate()
	 * @generated
	 */
	void setValidToDate(Object value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getAddressDetails_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':15' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // AddressDetails
