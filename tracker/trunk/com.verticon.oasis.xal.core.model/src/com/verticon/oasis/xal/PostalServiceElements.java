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
 * A representation of the model object '<em><b>Postal Service Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getAddressIdentifier <em>Address Identifier</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getEndorsementLineCode <em>Endorsement Line Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getKeyLineCode <em>Key Line Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getBarcode <em>Barcode</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getSortingCode <em>Sorting Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLatitude <em>Address Latitude</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLatitudeDirection <em>Address Latitude Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLongitude <em>Address Longitude</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLongitudeDirection <em>Address Longitude Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getSupplementaryPostalServiceData <em>Supplementary Postal Service Data</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostalServiceElements#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements()
 * @model extendedMetaData="name='PostalServiceElements_._type' kind='elementOnly'"
 * @generated
 */
public interface PostalServiceElements extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Identifier</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressIdentifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A unique identifier of an address assigned by postal authorities. Example: DPID in Australia
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Identifier</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_AddressIdentifier()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressIdentifier' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressIdentifier> getAddressIdentifier();

	/**
	 * Returns the value of the '<em><b>Endorsement Line Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Directly affects postal service distribution
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Endorsement Line Code</em>' containment reference.
	 * @see #setEndorsementLineCode(EndorsementLineCode)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_EndorsementLineCode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='EndorsementLineCode' namespace='##targetNamespace'"
	 * @generated
	 */
	EndorsementLineCode getEndorsementLineCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getEndorsementLineCode <em>Endorsement Line Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endorsement Line Code</em>' containment reference.
	 * @see #getEndorsementLineCode()
	 * @generated
	 */
	void setEndorsementLineCode(EndorsementLineCode value);

	/**
	 * Returns the value of the '<em><b>Key Line Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Required for some postal services
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key Line Code</em>' containment reference.
	 * @see #setKeyLineCode(KeyLineCode)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_KeyLineCode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='KeyLineCode' namespace='##targetNamespace'"
	 * @generated
	 */
	KeyLineCode getKeyLineCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getKeyLineCode <em>Key Line Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Line Code</em>' containment reference.
	 * @see #getKeyLineCode()
	 * @generated
	 */
	void setKeyLineCode(KeyLineCode value);

	/**
	 * Returns the value of the '<em><b>Barcode</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Required for some postal services
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Barcode</em>' containment reference.
	 * @see #setBarcode(Barcode)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_Barcode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Barcode' namespace='##targetNamespace'"
	 * @generated
	 */
	Barcode getBarcode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getBarcode <em>Barcode</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Barcode</em>' containment reference.
	 * @see #getBarcode()
	 * @generated
	 */
	void setBarcode(Barcode value);

	/**
	 * Returns the value of the '<em><b>Sorting Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used for sorting addresses. Values may for example be CEDEX 16 (France)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sorting Code</em>' containment reference.
	 * @see #setSortingCode(SortingCode)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_SortingCode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SortingCode' namespace='##targetNamespace'"
	 * @generated
	 */
	SortingCode getSortingCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getSortingCode <em>Sorting Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sorting Code</em>' containment reference.
	 * @see #getSortingCode()
	 * @generated
	 */
	void setSortingCode(SortingCode value);

	/**
	 * Returns the value of the '<em><b>Address Latitude</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Latitude of delivery address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Latitude</em>' containment reference.
	 * @see #setAddressLatitude(AddressLatitude)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_AddressLatitude()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLatitude' namespace='##targetNamespace'"
	 * @generated
	 */
	AddressLatitude getAddressLatitude();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLatitude <em>Address Latitude</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Latitude</em>' containment reference.
	 * @see #getAddressLatitude()
	 * @generated
	 */
	void setAddressLatitude(AddressLatitude value);

	/**
	 * Returns the value of the '<em><b>Address Latitude Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Latitude direction of delivery address;N = North and S = South
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Latitude Direction</em>' containment reference.
	 * @see #setAddressLatitudeDirection(AddressLatitudeDirection)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_AddressLatitudeDirection()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLatitudeDirection' namespace='##targetNamespace'"
	 * @generated
	 */
	AddressLatitudeDirection getAddressLatitudeDirection();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLatitudeDirection <em>Address Latitude Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Latitude Direction</em>' containment reference.
	 * @see #getAddressLatitudeDirection()
	 * @generated
	 */
	void setAddressLatitudeDirection(AddressLatitudeDirection value);

	/**
	 * Returns the value of the '<em><b>Address Longitude</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Longtitude of delivery address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Longitude</em>' containment reference.
	 * @see #setAddressLongitude(AddressLongitude)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_AddressLongitude()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLongitude' namespace='##targetNamespace'"
	 * @generated
	 */
	AddressLongitude getAddressLongitude();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLongitude <em>Address Longitude</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Longitude</em>' containment reference.
	 * @see #getAddressLongitude()
	 * @generated
	 */
	void setAddressLongitude(AddressLongitude value);

	/**
	 * Returns the value of the '<em><b>Address Longitude Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Longtitude direction of delivery address;N=North and S=South
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Longitude Direction</em>' containment reference.
	 * @see #setAddressLongitudeDirection(AddressLongitudeDirection)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_AddressLongitudeDirection()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLongitudeDirection' namespace='##targetNamespace'"
	 * @generated
	 */
	AddressLongitudeDirection getAddressLongitudeDirection();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLongitudeDirection <em>Address Longitude Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Longitude Direction</em>' containment reference.
	 * @see #getAddressLongitudeDirection()
	 * @generated
	 */
	void setAddressLongitudeDirection(AddressLongitudeDirection value);

	/**
	 * Returns the value of the '<em><b>Supplementary Postal Service Data</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.SupplementaryPostalServiceData}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * any postal service elements not covered by the container can be represented using this element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Supplementary Postal Service Data</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_SupplementaryPostalServiceData()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SupplementaryPostalServiceData' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SupplementaryPostalServiceData> getSupplementaryPostalServiceData();

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
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':10' processing='strict'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * USPS, ECMA, UN/PROLIST, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostalServiceElements#getType <em>Type</em>}' attribute.
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
	 * @see com.verticon.oasis.xal.XalPackage#getPostalServiceElements_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':12' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // PostalServiceElements
