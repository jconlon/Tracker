/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * xAL: eXtensible Address Language 
 * This is an XML document type definition (DTD) for
 * defining addresses.
 * Original Date of Creation: 1 March 2001
 * Copyright(c) 2000, OASIS. All Rights Reserved [http://www.oasis-open.org]
 * Contact: Customer Information Quality Technical Committee, OASIS
 * http://www.oasis-open.org/committees/ciq
 * VERSION: 2.0 [MAJOR RELEASE] Date of Creation: 01 May 2002
 * Last Update: 24 July 2002
 * Previous Version: 1.3
 * Common Attributes:Type - If not documented then it means, possible values of Type not limited to: Official, Unique, Abbreviation, OldName, Synonym
 * Code:Address element codes are used by groups like postal groups like ECCMA, ADIS, UN/PROLIST for postal services
 * <!-- end-model-doc -->
 * @see com.verticon.oasis.xal.XalFactory
 * @model kind="package"
 * @generated
 */
public interface XalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xal";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "com.verticon.oasis.xal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XalPackage eINSTANCE = com.verticon.oasis.xal.impl.XalPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressImpl <em>Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddress()
	 * @generated
	 */
	int ADDRESS = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressDetailsImpl <em>Address Details</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressDetailsImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddressDetails()
	 * @generated
	 */
	int ADDRESS_DETAILS = 1;

	/**
	 * The feature id for the '<em><b>Postal Service Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__POSTAL_SERVICE_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>Address Lines</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__ADDRESS_LINES = 2;

	/**
	 * The feature id for the '<em><b>Country</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__COUNTRY = 3;

	/**
	 * The feature id for the '<em><b>Administrative Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__ADMINISTRATIVE_AREA = 4;

	/**
	 * The feature id for the '<em><b>Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__LOCALITY = 5;

	/**
	 * The feature id for the '<em><b>Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__THOROUGHFARE = 6;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__ANY = 7;

	/**
	 * The feature id for the '<em><b>Address Details Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__ADDRESS_DETAILS_KEY = 8;

	/**
	 * The feature id for the '<em><b>Address Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__ADDRESS_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__CODE = 10;

	/**
	 * The feature id for the '<em><b>Current Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__CURRENT_STATUS = 11;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__USAGE = 12;

	/**
	 * The feature id for the '<em><b>Valid From Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__VALID_FROM_DATE = 13;

	/**
	 * The feature id for the '<em><b>Valid To Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__VALID_TO_DATE = 14;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS__ANY_ATTRIBUTE = 15;

	/**
	 * The number of structural features of the '<em>Address Details</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_DETAILS_FEATURE_COUNT = 16;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressIdentifierImpl <em>Address Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressIdentifierImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddressIdentifier()
	 * @generated
	 */
	int ADDRESS_IDENTIFIER = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_IDENTIFIER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_IDENTIFIER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Identifier Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_IDENTIFIER__IDENTIFIER_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_IDENTIFIER__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_IDENTIFIER__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Address Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_IDENTIFIER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressLatitudeImpl <em>Address Latitude</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressLatitudeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddressLatitude()
	 * @generated
	 */
	int ADDRESS_LATITUDE = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Address Latitude</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressLatitudeDirectionImpl <em>Address Latitude Direction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressLatitudeDirectionImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddressLatitudeDirection()
	 * @generated
	 */
	int ADDRESS_LATITUDE_DIRECTION = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE_DIRECTION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE_DIRECTION__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE_DIRECTION__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE_DIRECTION__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Address Latitude Direction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LATITUDE_DIRECTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressLineImpl <em>Address Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressLineImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddressLine()
	 * @generated
	 */
	int ADDRESS_LINE = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Address Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressLinesImpl <em>Address Lines</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressLinesImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddressLines()
	 * @generated
	 */
	int ADDRESS_LINES = 6;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINES__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINES__ANY = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINES__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Address Lines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LINES_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressLongitudeImpl <em>Address Longitude</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressLongitudeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddressLongitude()
	 * @generated
	 */
	int ADDRESS_LONGITUDE = 7;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Address Longitude</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AddressLongitudeDirectionImpl <em>Address Longitude Direction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AddressLongitudeDirectionImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAddressLongitudeDirection()
	 * @generated
	 */
	int ADDRESS_LONGITUDE_DIRECTION = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE_DIRECTION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE_DIRECTION__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE_DIRECTION__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE_DIRECTION__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Address Longitude Direction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_LONGITUDE_DIRECTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AdministrativeAreaImpl <em>Administrative Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AdministrativeAreaImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAdministrativeArea()
	 * @generated
	 */
	int ADMINISTRATIVE_AREA = 9;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Administrative Area Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__ADMINISTRATIVE_AREA_NAME = 1;

	/**
	 * The feature id for the '<em><b>Sub Administrative Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__SUB_ADMINISTRATIVE_AREA = 2;

	/**
	 * The feature id for the '<em><b>Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__LOCALITY = 3;

	/**
	 * The feature id for the '<em><b>Post Office</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__POST_OFFICE = 4;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__POSTAL_CODE = 5;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__ANY = 6;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__INDICATOR = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__TYPE = 8;

	/**
	 * The feature id for the '<em><b>Usage Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__USAGE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA__ANY_ATTRIBUTE = 10;

	/**
	 * The number of structural features of the '<em>Administrative Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.AdministrativeAreaNameImpl <em>Administrative Area Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.AdministrativeAreaNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getAdministrativeAreaName()
	 * @generated
	 */
	int ADMINISTRATIVE_AREA_NAME = 10;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Administrative Area Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATIVE_AREA_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.BarcodeImpl <em>Barcode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.BarcodeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getBarcode()
	 * @generated
	 */
	int BARCODE = 11;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARCODE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARCODE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARCODE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARCODE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Barcode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARCODE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.BuildingNameImpl <em>Building Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.BuildingNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getBuildingName()
	 * @generated
	 */
	int BUILDING_NAME = 12;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Type Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_NAME__TYPE_OCCURRENCE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_NAME__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Building Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_NAME_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.CountryImpl <em>Country</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.CountryImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getCountry()
	 * @generated
	 */
	int COUNTRY = 13;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Country Name Code</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__COUNTRY_NAME_CODE = 1;

	/**
	 * The feature id for the '<em><b>Country Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__COUNTRY_NAME = 2;

	/**
	 * The feature id for the '<em><b>Administrative Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__ADMINISTRATIVE_AREA = 3;

	/**
	 * The feature id for the '<em><b>Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__LOCALITY = 4;

	/**
	 * The feature id for the '<em><b>Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__THOROUGHFARE = 5;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__ANY = 6;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__ANY_ATTRIBUTE = 7;

	/**
	 * The number of structural features of the '<em>Country</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.CountryNameImpl <em>Country Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.CountryNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getCountryName()
	 * @generated
	 */
	int COUNTRY_NAME = 14;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Country Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.CountryNameCodeImpl <em>Country Name Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.CountryNameCodeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getCountryNameCode()
	 * @generated
	 */
	int COUNTRY_NAME_CODE = 15;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME_CODE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME_CODE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Scheme</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME_CODE__SCHEME = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME_CODE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Country Name Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_NAME_CODE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.DepartmentImpl <em>Department</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.DepartmentImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDepartment()
	 * @generated
	 */
	int DEPARTMENT = 16;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Department Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__DEPARTMENT_NAME = 1;

	/**
	 * The feature id for the '<em><b>Mail Stop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__MAIL_STOP = 2;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__POSTAL_CODE = 3;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__ANY = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__ANY_ATTRIBUTE = 6;

	/**
	 * The number of structural features of the '<em>Department</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.DepartmentNameImpl <em>Department Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.DepartmentNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDepartmentName()
	 * @generated
	 */
	int DEPARTMENT_NAME = 17;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Department Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.DependentLocalityImpl <em>Dependent Locality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.DependentLocalityImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDependentLocality()
	 * @generated
	 */
	int DEPENDENT_LOCALITY = 18;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Dependent Locality Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__DEPENDENT_LOCALITY_NAME = 1;

	/**
	 * The feature id for the '<em><b>Dependent Locality Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__DEPENDENT_LOCALITY_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Post Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__POST_BOX = 3;

	/**
	 * The feature id for the '<em><b>Large Mail User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__LARGE_MAIL_USER = 4;

	/**
	 * The feature id for the '<em><b>Post Office</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__POST_OFFICE = 5;

	/**
	 * The feature id for the '<em><b>Postal Route</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__POSTAL_ROUTE = 6;

	/**
	 * The feature id for the '<em><b>Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__THOROUGHFARE = 7;

	/**
	 * The feature id for the '<em><b>Premise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__PREMISE = 8;

	/**
	 * The feature id for the '<em><b>Dependent Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__DEPENDENT_LOCALITY = 9;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__POSTAL_CODE = 10;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__ANY = 11;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__CONNECTOR = 12;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__INDICATOR = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__TYPE = 14;

	/**
	 * The feature id for the '<em><b>Usage Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__USAGE_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY__ANY_ATTRIBUTE = 16;

	/**
	 * The number of structural features of the '<em>Dependent Locality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_FEATURE_COUNT = 17;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.DependentLocalityNameImpl <em>Dependent Locality Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.DependentLocalityNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDependentLocalityName()
	 * @generated
	 */
	int DEPENDENT_LOCALITY_NAME = 19;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Dependent Locality Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.DependentLocalityNumberImpl <em>Dependent Locality Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.DependentLocalityNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDependentLocalityNumber()
	 * @generated
	 */
	int DEPENDENT_LOCALITY_NUMBER = 20;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Name Number Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NUMBER__NAME_NUMBER_OCCURRENCE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NUMBER__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Dependent Locality Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_LOCALITY_NUMBER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.DependentThoroughfareImpl <em>Dependent Thoroughfare</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.DependentThoroughfareImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDependentThoroughfare()
	 * @generated
	 */
	int DEPENDENT_THOROUGHFARE = 21;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Thoroughfare Pre Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION = 1;

	/**
	 * The feature id for the '<em><b>Thoroughfare Leading Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__THOROUGHFARE_LEADING_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Thoroughfare Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__THOROUGHFARE_NAME = 3;

	/**
	 * The feature id for the '<em><b>Thoroughfare Trailing Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Thoroughfare Post Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__THOROUGHFARE_POST_DIRECTION = 5;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__ANY = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__TYPE = 7;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE__ANY_ATTRIBUTE = 8;

	/**
	 * The number of structural features of the '<em>Dependent Thoroughfare</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_THOROUGHFARE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.DocumentRootImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 22;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Address Details</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ADDRESS_DETAILS = 3;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ADDRESS_LINE = 4;

	/**
	 * The feature id for the '<em><b>Administrative Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ADMINISTRATIVE_AREA = 5;

	/**
	 * The feature id for the '<em><b>Country Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COUNTRY_NAME = 6;

	/**
	 * The feature id for the '<em><b>Department</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DEPARTMENT = 7;

	/**
	 * The feature id for the '<em><b>Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LOCALITY = 8;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__POSTAL_CODE = 9;

	/**
	 * The feature id for the '<em><b>Post Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__POST_BOX = 10;

	/**
	 * The feature id for the '<em><b>Post Office</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__POST_OFFICE = 11;

	/**
	 * The feature id for the '<em><b>Premise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PREMISE = 12;

	/**
	 * The feature id for the '<em><b>Premise Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PREMISE_NUMBER = 13;

	/**
	 * The feature id for the '<em><b>Premise Number Prefix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PREMISE_NUMBER_PREFIX = 14;

	/**
	 * The feature id for the '<em><b>Premise Number Suffix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PREMISE_NUMBER_SUFFIX = 15;

	/**
	 * The feature id for the '<em><b>Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__THOROUGHFARE = 16;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__THOROUGHFARE_NUMBER = 17;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Prefix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__THOROUGHFARE_NUMBER_PREFIX = 18;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Suffix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__THOROUGHFARE_NUMBER_SUFFIX = 19;

	/**
	 * The feature id for the '<em><b>XAL</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XAL = 20;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 21;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.EndorsementLineCodeImpl <em>Endorsement Line Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.EndorsementLineCodeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getEndorsementLineCode()
	 * @generated
	 */
	int ENDORSEMENT_LINE_CODE = 23;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDORSEMENT_LINE_CODE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDORSEMENT_LINE_CODE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDORSEMENT_LINE_CODE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDORSEMENT_LINE_CODE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Endorsement Line Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDORSEMENT_LINE_CODE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.FirmImpl <em>Firm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.FirmImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getFirm()
	 * @generated
	 */
	int FIRM = 24;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Firm Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM__FIRM_NAME = 1;

	/**
	 * The feature id for the '<em><b>Department</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM__DEPARTMENT = 2;

	/**
	 * The feature id for the '<em><b>Mail Stop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM__MAIL_STOP = 3;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM__POSTAL_CODE = 4;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM__ANY = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM__TYPE = 6;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM__ANY_ATTRIBUTE = 7;

	/**
	 * The number of structural features of the '<em>Firm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.FirmNameImpl <em>Firm Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.FirmNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getFirmName()
	 * @generated
	 */
	int FIRM_NAME = 25;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Firm Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRM_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.KeyLineCodeImpl <em>Key Line Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.KeyLineCodeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getKeyLineCode()
	 * @generated
	 */
	int KEY_LINE_CODE = 26;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LINE_CODE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LINE_CODE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LINE_CODE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LINE_CODE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Key Line Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LINE_CODE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.LargeMailUserImpl <em>Large Mail User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.LargeMailUserImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getLargeMailUser()
	 * @generated
	 */
	int LARGE_MAIL_USER = 27;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Large Mail User Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__LARGE_MAIL_USER_NAME = 1;

	/**
	 * The feature id for the '<em><b>Large Mail User Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER = 2;

	/**
	 * The feature id for the '<em><b>Building Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__BUILDING_NAME = 3;

	/**
	 * The feature id for the '<em><b>Department</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__DEPARTMENT = 4;

	/**
	 * The feature id for the '<em><b>Post Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__POST_BOX = 5;

	/**
	 * The feature id for the '<em><b>Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__THOROUGHFARE = 6;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__POSTAL_CODE = 7;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__ANY = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__TYPE = 9;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER__ANY_ATTRIBUTE = 10;

	/**
	 * The number of structural features of the '<em>Large Mail User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.LargeMailUserIdentifierImpl <em>Large Mail User Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.LargeMailUserIdentifierImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getLargeMailUserIdentifier()
	 * @generated
	 */
	int LARGE_MAIL_USER_IDENTIFIER = 28;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_IDENTIFIER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_IDENTIFIER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_IDENTIFIER__INDICATOR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_IDENTIFIER__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_IDENTIFIER__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Large Mail User Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_IDENTIFIER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.LargeMailUserNameImpl <em>Large Mail User Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.LargeMailUserNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getLargeMailUserName()
	 * @generated
	 */
	int LARGE_MAIL_USER_NAME = 29;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Large Mail User Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_MAIL_USER_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.LocalityImpl <em>Locality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.LocalityImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getLocality()
	 * @generated
	 */
	int LOCALITY = 30;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Locality Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__LOCALITY_NAME = 1;

	/**
	 * The feature id for the '<em><b>Post Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__POST_BOX = 2;

	/**
	 * The feature id for the '<em><b>Large Mail User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__LARGE_MAIL_USER = 3;

	/**
	 * The feature id for the '<em><b>Post Office</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__POST_OFFICE = 4;

	/**
	 * The feature id for the '<em><b>Postal Route</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__POSTAL_ROUTE = 5;

	/**
	 * The feature id for the '<em><b>Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__THOROUGHFARE = 6;

	/**
	 * The feature id for the '<em><b>Premise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__PREMISE = 7;

	/**
	 * The feature id for the '<em><b>Dependent Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__DEPENDENT_LOCALITY = 8;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__POSTAL_CODE = 9;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__ANY = 10;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__INDICATOR = 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__TYPE = 12;

	/**
	 * The feature id for the '<em><b>Usage Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__USAGE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY__ANY_ATTRIBUTE = 14;

	/**
	 * The number of structural features of the '<em>Locality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY_FEATURE_COUNT = 15;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.LocalityNameImpl <em>Locality Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.LocalityNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getLocalityName()
	 * @generated
	 */
	int LOCALITY_NAME = 31;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Locality Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALITY_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.MailStopImpl <em>Mail Stop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.MailStopImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getMailStop()
	 * @generated
	 */
	int MAIL_STOP = 32;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Mail Stop Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP__MAIL_STOP_NAME = 1;

	/**
	 * The feature id for the '<em><b>Mail Stop Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP__MAIL_STOP_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP__ANY = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP__ANY_ATTRIBUTE = 5;

	/**
	 * The number of structural features of the '<em>Mail Stop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.MailStopNameImpl <em>Mail Stop Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.MailStopNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getMailStopName()
	 * @generated
	 */
	int MAIL_STOP_NAME = 33;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Mail Stop Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.MailStopNumberImpl <em>Mail Stop Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.MailStopNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getMailStopNumber()
	 * @generated
	 */
	int MAIL_STOP_NUMBER = 34;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Name Number Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NUMBER__NAME_NUMBER_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NUMBER__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Mail Stop Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_STOP_NUMBER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostalCodeImpl <em>Postal Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostalCodeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostalCode()
	 * @generated
	 */
	int POSTAL_CODE = 35;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Postal Code Number</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE__POSTAL_CODE_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Postal Code Number Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE__POSTAL_CODE_NUMBER_EXTENSION = 2;

	/**
	 * The feature id for the '<em><b>Post Town</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE__POST_TOWN = 3;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE__ANY = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE__ANY_ATTRIBUTE = 6;

	/**
	 * The number of structural features of the '<em>Postal Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostalCodeNumberImpl <em>Postal Code Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostalCodeNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostalCodeNumber()
	 * @generated
	 */
	int POSTAL_CODE_NUMBER = 36;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Postal Code Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostalCodeNumberExtensionImpl <em>Postal Code Number Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostalCodeNumberExtensionImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostalCodeNumberExtension()
	 * @generated
	 */
	int POSTAL_CODE_NUMBER_EXTENSION = 37;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER_EXTENSION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER_EXTENSION__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Extension Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER_EXTENSION__NUMBER_EXTENSION_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER_EXTENSION__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER_EXTENSION__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Postal Code Number Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_CODE_NUMBER_EXTENSION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostalRouteImpl <em>Postal Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostalRouteImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostalRoute()
	 * @generated
	 */
	int POSTAL_ROUTE = 38;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Postal Route Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE__POSTAL_ROUTE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Postal Route Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE__POSTAL_ROUTE_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Post Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE__POST_BOX = 3;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE__ANY = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE__ANY_ATTRIBUTE = 6;

	/**
	 * The number of structural features of the '<em>Postal Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostalRouteNameImpl <em>Postal Route Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostalRouteNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostalRouteName()
	 * @generated
	 */
	int POSTAL_ROUTE_NAME = 39;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Postal Route Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostalRouteNumberImpl <em>Postal Route Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostalRouteNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostalRouteNumber()
	 * @generated
	 */
	int POSTAL_ROUTE_NUMBER = 40;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NUMBER__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Postal Route Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_ROUTE_NUMBER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl <em>Postal Service Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostalServiceElementsImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostalServiceElements()
	 * @generated
	 */
	int POSTAL_SERVICE_ELEMENTS = 41;

	/**
	 * The feature id for the '<em><b>Address Identifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__ADDRESS_IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Endorsement Line Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE = 1;

	/**
	 * The feature id for the '<em><b>Key Line Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE = 2;

	/**
	 * The feature id for the '<em><b>Barcode</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__BARCODE = 3;

	/**
	 * The feature id for the '<em><b>Sorting Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__SORTING_CODE = 4;

	/**
	 * The feature id for the '<em><b>Address Latitude</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE = 5;

	/**
	 * The feature id for the '<em><b>Address Latitude Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION = 6;

	/**
	 * The feature id for the '<em><b>Address Longitude</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE = 7;

	/**
	 * The feature id for the '<em><b>Address Longitude Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION = 8;

	/**
	 * The feature id for the '<em><b>Supplementary Postal Service Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__SUPPLEMENTARY_POSTAL_SERVICE_DATA = 9;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__ANY = 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__TYPE = 11;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS__ANY_ATTRIBUTE = 12;

	/**
	 * The number of structural features of the '<em>Postal Service Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_SERVICE_ELEMENTS_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostBoxImpl <em>Post Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostBoxImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostBox()
	 * @generated
	 */
	int POST_BOX = 42;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Post Box Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__POST_BOX_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Post Box Number Prefix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__POST_BOX_NUMBER_PREFIX = 2;

	/**
	 * The feature id for the '<em><b>Post Box Number Suffix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__POST_BOX_NUMBER_SUFFIX = 3;

	/**
	 * The feature id for the '<em><b>Post Box Number Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__POST_BOX_NUMBER_EXTENSION = 4;

	/**
	 * The feature id for the '<em><b>Firm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__FIRM = 5;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__POSTAL_CODE = 6;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__ANY = 7;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__INDICATOR = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__TYPE = 9;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX__ANY_ATTRIBUTE = 10;

	/**
	 * The number of structural features of the '<em>Post Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostBoxNumberImpl <em>Post Box Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostBoxNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostBoxNumber()
	 * @generated
	 */
	int POST_BOX_NUMBER = 43;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Post Box Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostBoxNumberExtensionImpl <em>Post Box Number Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostBoxNumberExtensionImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostBoxNumberExtension()
	 * @generated
	 */
	int POST_BOX_NUMBER_EXTENSION = 44;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_EXTENSION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Number Extension Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_EXTENSION__NUMBER_EXTENSION_SEPARATOR = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_EXTENSION__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Post Box Number Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_EXTENSION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostBoxNumberPrefixImpl <em>Post Box Number Prefix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostBoxNumberPrefixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostBoxNumberPrefix()
	 * @generated
	 */
	int POST_BOX_NUMBER_PREFIX = 45;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_PREFIX__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_PREFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Prefix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_PREFIX__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Post Box Number Prefix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_PREFIX_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostBoxNumberSuffixImpl <em>Post Box Number Suffix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostBoxNumberSuffixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostBoxNumberSuffix()
	 * @generated
	 */
	int POST_BOX_NUMBER_SUFFIX = 46;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_SUFFIX__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_SUFFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Suffix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_SUFFIX__NUMBER_SUFFIX_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_SUFFIX__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Post Box Number Suffix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BOX_NUMBER_SUFFIX_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostOfficeImpl <em>Post Office</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostOfficeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostOffice()
	 * @generated
	 */
	int POST_OFFICE = 47;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Post Office Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__POST_OFFICE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Post Office Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__POST_OFFICE_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Postal Route</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__POSTAL_ROUTE = 3;

	/**
	 * The feature id for the '<em><b>Post Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__POST_BOX = 4;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__POSTAL_CODE = 5;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__ANY = 6;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__INDICATOR = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__TYPE = 8;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE__ANY_ATTRIBUTE = 9;

	/**
	 * The number of structural features of the '<em>Post Office</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostOfficeNameImpl <em>Post Office Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostOfficeNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostOfficeName()
	 * @generated
	 */
	int POST_OFFICE_NAME = 48;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Post Office Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostOfficeNumberImpl <em>Post Office Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostOfficeNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostOfficeNumber()
	 * @generated
	 */
	int POST_OFFICE_NUMBER = 49;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NUMBER__INDICATOR = 2;

	/**
	 * The feature id for the '<em><b>Indicator Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NUMBER__INDICATOR_OCCURRENCE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NUMBER__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Post Office Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OFFICE_NUMBER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostTownImpl <em>Post Town</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostTownImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostTown()
	 * @generated
	 */
	int POST_TOWN = 50;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Post Town Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN__POST_TOWN_NAME = 1;

	/**
	 * The feature id for the '<em><b>Post Town Suffix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN__POST_TOWN_SUFFIX = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Post Town</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostTownNameImpl <em>Post Town Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostTownNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostTownName()
	 * @generated
	 */
	int POST_TOWN_NAME = 51;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Post Town Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PostTownSuffixImpl <em>Post Town Suffix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PostTownSuffixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPostTownSuffix()
	 * @generated
	 */
	int POST_TOWN_SUFFIX = 52;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_SUFFIX__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_SUFFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_SUFFIX__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Post Town Suffix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TOWN_SUFFIX_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseImpl <em>Premise</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremise()
	 * @generated
	 */
	int PREMISE = 53;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Premise Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Premise Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Premise Number</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>Premise Number Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_NUMBER_RANGE = 4;

	/**
	 * The feature id for the '<em><b>Premise Number Prefix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_NUMBER_PREFIX = 5;

	/**
	 * The feature id for the '<em><b>Premise Number Suffix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_NUMBER_SUFFIX = 6;

	/**
	 * The feature id for the '<em><b>Building Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__BUILDING_NAME = 7;

	/**
	 * The feature id for the '<em><b>Sub Premise</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__SUB_PREMISE = 8;

	/**
	 * The feature id for the '<em><b>Firm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__FIRM = 9;

	/**
	 * The feature id for the '<em><b>Mail Stop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__MAIL_STOP = 10;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__POSTAL_CODE = 11;

	/**
	 * The feature id for the '<em><b>Premise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE = 12;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__ANY = 13;

	/**
	 * The feature id for the '<em><b>Premise Dependency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_DEPENDENCY = 14;

	/**
	 * The feature id for the '<em><b>Premise Dependency Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_DEPENDENCY_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Premise Thoroughfare Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__PREMISE_THOROUGHFARE_CONNECTOR = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__TYPE = 17;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE__ANY_ATTRIBUTE = 18;

	/**
	 * The number of structural features of the '<em>Premise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_FEATURE_COUNT = 19;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseLocationImpl <em>Premise Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseLocationImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremiseLocation()
	 * @generated
	 */
	int PREMISE_LOCATION = 54;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_LOCATION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_LOCATION__CODE = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_LOCATION__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Premise Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_LOCATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseNameImpl <em>Premise Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremiseName()
	 * @generated
	 */
	int PREMISE_NAME = 55;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Type Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NAME__TYPE_OCCURRENCE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NAME__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Premise Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NAME_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseNumberImpl <em>Premise Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremiseNumber()
	 * @generated
	 */
	int PREMISE_NUMBER = 56;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER__INDICATOR = 2;

	/**
	 * The feature id for the '<em><b>Indicator Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER__INDICATOR_OCCURRENCE = 3;

	/**
	 * The feature id for the '<em><b>Number Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER__NUMBER_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Number Type Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER__NUMBER_TYPE_OCCURRENCE = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER__TYPE = 6;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER__ANY_ATTRIBUTE = 7;

	/**
	 * The number of structural features of the '<em>Premise Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseNumberPrefixImpl <em>Premise Number Prefix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseNumberPrefixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremiseNumberPrefix()
	 * @generated
	 */
	int PREMISE_NUMBER_PREFIX = 57;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_PREFIX__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_PREFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Prefix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_PREFIX__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_PREFIX__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Premise Number Prefix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_PREFIX_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseNumberRangeImpl <em>Premise Number Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseNumberRangeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremiseNumberRange()
	 * @generated
	 */
	int PREMISE_NUMBER_RANGE = 58;

	/**
	 * The feature id for the '<em><b>Premise Number Range From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_FROM = 0;

	/**
	 * The feature id for the '<em><b>Premise Number Range To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE__PREMISE_NUMBER_RANGE_TO = 1;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE__INDICATOR = 2;

	/**
	 * The feature id for the '<em><b>Indicator Occurence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE__INDICATOR_OCCURENCE = 3;

	/**
	 * The feature id for the '<em><b>Number Range Occurence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE__NUMBER_RANGE_OCCURENCE = 4;

	/**
	 * The feature id for the '<em><b>Range Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE__RANGE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE__SEPARATOR = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE__TYPE = 7;

	/**
	 * The number of structural features of the '<em>Premise Number Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseNumberRangeFromImpl <em>Premise Number Range From</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseNumberRangeFromImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremiseNumberRangeFrom()
	 * @generated
	 */
	int PREMISE_NUMBER_RANGE_FROM = 59;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_FROM__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Premise Number Prefix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_FROM__PREMISE_NUMBER_PREFIX = 1;

	/**
	 * The feature id for the '<em><b>Premise Number</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_FROM__PREMISE_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Premise Number Suffix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_FROM__PREMISE_NUMBER_SUFFIX = 3;

	/**
	 * The number of structural features of the '<em>Premise Number Range From</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_FROM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseNumberRangeToImpl <em>Premise Number Range To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseNumberRangeToImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremiseNumberRangeTo()
	 * @generated
	 */
	int PREMISE_NUMBER_RANGE_TO = 60;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_TO__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Premise Number Prefix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_PREFIX = 1;

	/**
	 * The feature id for the '<em><b>Premise Number</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Premise Number Suffix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_TO__PREMISE_NUMBER_SUFFIX = 3;

	/**
	 * The number of structural features of the '<em>Premise Number Range To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_RANGE_TO_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.PremiseNumberSuffixImpl <em>Premise Number Suffix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.PremiseNumberSuffixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getPremiseNumberSuffix()
	 * @generated
	 */
	int PREMISE_NUMBER_SUFFIX = 61;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_SUFFIX__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_SUFFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Suffix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_SUFFIX__NUMBER_SUFFIX_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_SUFFIX__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_SUFFIX__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Premise Number Suffix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISE_NUMBER_SUFFIX_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SortingCodeImpl <em>Sorting Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SortingCodeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSortingCode()
	 * @generated
	 */
	int SORTING_CODE = 62;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTING_CODE__CODE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTING_CODE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Sorting Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTING_CODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SubAdministrativeAreaImpl <em>Sub Administrative Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SubAdministrativeAreaImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSubAdministrativeArea()
	 * @generated
	 */
	int SUB_ADMINISTRATIVE_AREA = 63;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Sub Administrative Area Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__SUB_ADMINISTRATIVE_AREA_NAME = 1;

	/**
	 * The feature id for the '<em><b>Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__LOCALITY = 2;

	/**
	 * The feature id for the '<em><b>Post Office</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__POST_OFFICE = 3;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__POSTAL_CODE = 4;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__ANY = 5;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__INDICATOR = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__TYPE = 7;

	/**
	 * The feature id for the '<em><b>Usage Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__USAGE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA__ANY_ATTRIBUTE = 9;

	/**
	 * The number of structural features of the '<em>Sub Administrative Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SubAdministrativeAreaNameImpl <em>Sub Administrative Area Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SubAdministrativeAreaNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSubAdministrativeAreaName()
	 * @generated
	 */
	int SUB_ADMINISTRATIVE_AREA_NAME = 64;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Sub Administrative Area Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_ADMINISTRATIVE_AREA_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SubPremiseImpl <em>Sub Premise</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SubPremiseImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSubPremise()
	 * @generated
	 */
	int SUB_PREMISE = 65;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Sub Premise Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__SUB_PREMISE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Sub Premise Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__SUB_PREMISE_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Sub Premise Number</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__SUB_PREMISE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>Sub Premise Number Prefix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__SUB_PREMISE_NUMBER_PREFIX = 4;

	/**
	 * The feature id for the '<em><b>Sub Premise Number Suffix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__SUB_PREMISE_NUMBER_SUFFIX = 5;

	/**
	 * The feature id for the '<em><b>Building Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__BUILDING_NAME = 6;

	/**
	 * The feature id for the '<em><b>Firm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__FIRM = 7;

	/**
	 * The feature id for the '<em><b>Mail Stop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__MAIL_STOP = 8;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__POSTAL_CODE = 9;

	/**
	 * The feature id for the '<em><b>Sub Premise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__SUB_PREMISE = 10;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__ANY = 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__TYPE = 12;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE__ANY_ATTRIBUTE = 13;

	/**
	 * The number of structural features of the '<em>Sub Premise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SubPremiseLocationImpl <em>Sub Premise Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SubPremiseLocationImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSubPremiseLocation()
	 * @generated
	 */
	int SUB_PREMISE_LOCATION = 66;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_LOCATION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_LOCATION__CODE = 1;

	/**
	 * The number of structural features of the '<em>Sub Premise Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_LOCATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SubPremiseNameImpl <em>Sub Premise Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SubPremiseNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSubPremiseName()
	 * @generated
	 */
	int SUB_PREMISE_NAME = 67;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Type Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NAME__TYPE_OCCURRENCE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NAME__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Sub Premise Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NAME_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SubPremiseNumberImpl <em>Sub Premise Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SubPremiseNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSubPremiseNumber()
	 * @generated
	 */
	int SUB_PREMISE_NUMBER = 68;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER__INDICATOR = 2;

	/**
	 * The feature id for the '<em><b>Indicator Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER__INDICATOR_OCCURRENCE = 3;

	/**
	 * The feature id for the '<em><b>Number Type Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER__NUMBER_TYPE_OCCURRENCE = 4;

	/**
	 * The feature id for the '<em><b>Premise Number Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER__PREMISE_NUMBER_SEPARATOR = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER__TYPE = 6;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER__ANY_ATTRIBUTE = 7;

	/**
	 * The number of structural features of the '<em>Sub Premise Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SubPremiseNumberPrefixImpl <em>Sub Premise Number Prefix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SubPremiseNumberPrefixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSubPremiseNumberPrefix()
	 * @generated
	 */
	int SUB_PREMISE_NUMBER_PREFIX = 69;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_PREFIX__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_PREFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Prefix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_PREFIX__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_PREFIX__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Sub Premise Number Prefix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_PREFIX_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SubPremiseNumberSuffixImpl <em>Sub Premise Number Suffix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SubPremiseNumberSuffixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSubPremiseNumberSuffix()
	 * @generated
	 */
	int SUB_PREMISE_NUMBER_SUFFIX = 70;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_SUFFIX__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_SUFFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Suffix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_SUFFIX__NUMBER_SUFFIX_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_SUFFIX__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_SUFFIX__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Sub Premise Number Suffix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PREMISE_NUMBER_SUFFIX_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.SupplementaryPostalServiceDataImpl <em>Supplementary Postal Service Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.SupplementaryPostalServiceDataImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getSupplementaryPostalServiceData()
	 * @generated
	 */
	int SUPPLEMENTARY_POSTAL_SERVICE_DATA = 71;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_POSTAL_SERVICE_DATA__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_POSTAL_SERVICE_DATA__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_POSTAL_SERVICE_DATA__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_POSTAL_SERVICE_DATA__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Supplementary Postal Service Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLEMENTARY_POSTAL_SERVICE_DATA_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareImpl <em>Thoroughfare</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfare()
	 * @generated
	 */
	int THOROUGHFARE = 72;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__GROUP = 1;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Range</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_NUMBER_RANGE = 3;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Prefix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_NUMBER_PREFIX = 4;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Suffix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_NUMBER_SUFFIX = 5;

	/**
	 * The feature id for the '<em><b>Thoroughfare Pre Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_PRE_DIRECTION = 6;

	/**
	 * The feature id for the '<em><b>Thoroughfare Leading Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_LEADING_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Thoroughfare Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_NAME = 8;

	/**
	 * The feature id for the '<em><b>Thoroughfare Trailing Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_TRAILING_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Thoroughfare Post Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__THOROUGHFARE_POST_DIRECTION = 10;

	/**
	 * The feature id for the '<em><b>Dependent Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__DEPENDENT_THOROUGHFARE = 11;

	/**
	 * The feature id for the '<em><b>Dependent Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__DEPENDENT_LOCALITY = 12;

	/**
	 * The feature id for the '<em><b>Premise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__PREMISE = 13;

	/**
	 * The feature id for the '<em><b>Firm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__FIRM = 14;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__POSTAL_CODE = 15;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__ANY = 16;

	/**
	 * The feature id for the '<em><b>Dependent Thoroughfares</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__DEPENDENT_THOROUGHFARES = 17;

	/**
	 * The feature id for the '<em><b>Dependent Thoroughfares Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__DEPENDENT_THOROUGHFARES_CONNECTOR = 18;

	/**
	 * The feature id for the '<em><b>Dependent Thoroughfares Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__DEPENDENT_THOROUGHFARES_INDICATOR = 19;

	/**
	 * The feature id for the '<em><b>Dependent Thoroughfares Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__DEPENDENT_THOROUGHFARES_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__TYPE = 21;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE__ANY_ATTRIBUTE = 22;

	/**
	 * The number of structural features of the '<em>Thoroughfare</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_FEATURE_COUNT = 23;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareLeadingTypeImpl <em>Thoroughfare Leading Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareLeadingTypeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareLeadingType()
	 * @generated
	 */
	int THOROUGHFARE_LEADING_TYPE = 73;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_LEADING_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_LEADING_TYPE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_LEADING_TYPE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_LEADING_TYPE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Thoroughfare Leading Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_LEADING_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareNameImpl <em>Thoroughfare Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareNameImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareName()
	 * @generated
	 */
	int THOROUGHFARE_NAME = 74;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NAME__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NAME__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NAME__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NAME__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Thoroughfare Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareNumberImpl <em>Thoroughfare Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareNumberImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareNumber()
	 * @generated
	 */
	int THOROUGHFARE_NUMBER = 75;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER__CODE = 1;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER__INDICATOR = 2;

	/**
	 * The feature id for the '<em><b>Indicator Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER__INDICATOR_OCCURRENCE = 3;

	/**
	 * The feature id for the '<em><b>Number Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER__NUMBER_OCCURRENCE = 4;

	/**
	 * The feature id for the '<em><b>Number Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER__NUMBER_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER__TYPE = 6;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER__ANY_ATTRIBUTE = 7;

	/**
	 * The number of structural features of the '<em>Thoroughfare Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareNumberFromImpl <em>Thoroughfare Number From</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareNumberFromImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareNumberFrom()
	 * @generated
	 */
	int THOROUGHFARE_NUMBER_FROM = 76;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FROM__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FROM__ADDRESS_LINE = 1;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Prefix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FROM__THOROUGHFARE_NUMBER_PREFIX = 2;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FROM__THOROUGHFARE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Suffix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FROM__THOROUGHFARE_NUMBER_SUFFIX = 4;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FROM__CODE = 5;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FROM__ANY_ATTRIBUTE = 6;

	/**
	 * The number of structural features of the '<em>Thoroughfare Number From</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_FROM_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareNumberPrefixImpl <em>Thoroughfare Number Prefix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareNumberPrefixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareNumberPrefix()
	 * @generated
	 */
	int THOROUGHFARE_NUMBER_PREFIX = 77;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_PREFIX__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_PREFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Prefix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_PREFIX__NUMBER_PREFIX_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_PREFIX__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_PREFIX__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Thoroughfare Number Prefix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_PREFIX_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl <em>Thoroughfare Number Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareNumberRangeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareNumberRange()
	 * @generated
	 */
	int THOROUGHFARE_NUMBER_RANGE = 78;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__ADDRESS_LINE = 0;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_FROM = 1;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__THOROUGHFARE_NUMBER_TO = 2;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__CODE = 3;

	/**
	 * The feature id for the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__INDICATOR = 4;

	/**
	 * The feature id for the '<em><b>Indicator Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__INDICATOR_OCCURRENCE = 5;

	/**
	 * The feature id for the '<em><b>Number Range Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__NUMBER_RANGE_OCCURRENCE = 6;

	/**
	 * The feature id for the '<em><b>Range Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__RANGE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__SEPARATOR = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__TYPE = 9;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE__ANY_ATTRIBUTE = 10;

	/**
	 * The number of structural features of the '<em>Thoroughfare Number Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_RANGE_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareNumberSuffixImpl <em>Thoroughfare Number Suffix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareNumberSuffixImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareNumberSuffix()
	 * @generated
	 */
	int THOROUGHFARE_NUMBER_SUFFIX = 79;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_SUFFIX__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_SUFFIX__CODE = 1;

	/**
	 * The feature id for the '<em><b>Number Suffix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_SUFFIX__NUMBER_SUFFIX_SEPARATOR = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_SUFFIX__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_SUFFIX__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Thoroughfare Number Suffix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_SUFFIX_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl <em>Thoroughfare Number To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareNumberToImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareNumberTo()
	 * @generated
	 */
	int THOROUGHFARE_NUMBER_TO = 80;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_TO__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Address Line</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_TO__ADDRESS_LINE = 1;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Prefix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_PREFIX = 2;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>Thoroughfare Number Suffix</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_TO__THOROUGHFARE_NUMBER_SUFFIX = 4;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_TO__CODE = 5;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_TO__ANY_ATTRIBUTE = 6;

	/**
	 * The number of structural features of the '<em>Thoroughfare Number To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_NUMBER_TO_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfarePostDirectionImpl <em>Thoroughfare Post Direction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfarePostDirectionImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfarePostDirection()
	 * @generated
	 */
	int THOROUGHFARE_POST_DIRECTION = 81;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_POST_DIRECTION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_POST_DIRECTION__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_POST_DIRECTION__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_POST_DIRECTION__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Thoroughfare Post Direction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_POST_DIRECTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfarePreDirectionImpl <em>Thoroughfare Pre Direction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfarePreDirectionImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfarePreDirection()
	 * @generated
	 */
	int THOROUGHFARE_PRE_DIRECTION = 82;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_PRE_DIRECTION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_PRE_DIRECTION__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_PRE_DIRECTION__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_PRE_DIRECTION__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Thoroughfare Pre Direction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_PRE_DIRECTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.ThoroughfareTrailingTypeImpl <em>Thoroughfare Trailing Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.ThoroughfareTrailingTypeImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getThoroughfareTrailingType()
	 * @generated
	 */
	int THOROUGHFARE_TRAILING_TYPE = 83;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_TRAILING_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_TRAILING_TYPE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_TRAILING_TYPE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_TRAILING_TYPE__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Thoroughfare Trailing Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THOROUGHFARE_TRAILING_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.impl.XalImpl <em>Xal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.impl.XalImpl
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getXal()
	 * @generated
	 */
	int XAL = 84;

	/**
	 * The feature id for the '<em><b>Address Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XAL__ADDRESS_DETAILS = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XAL__ANY = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XAL__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XAL__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>Xal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XAL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.DependentThoroughfaresType <em>Dependent Thoroughfares Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.DependentThoroughfaresType
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDependentThoroughfaresType()
	 * @generated
	 */
	int DEPENDENT_THOROUGHFARES_TYPE = 85;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.IndicatorOccurence <em>Indicator Occurence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurence()
	 * @generated
	 */
	int INDICATOR_OCCURENCE = 86;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.IndicatorOccurrence <em>Indicator Occurrence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrence()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE = 87;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.IndicatorOccurrence1 <em>Indicator Occurrence1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence1
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrence1()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE1 = 88;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.IndicatorOccurrence2 <em>Indicator Occurrence2</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence2
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrence2()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE2 = 89;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.IndicatorOccurrence3 <em>Indicator Occurrence3</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence3
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrence3()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE3 = 90;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.IndicatorOccurrence4 <em>Indicator Occurrence4</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence4
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrence4()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE4 = 91;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.NameNumberOccurrence <em>Name Number Occurrence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NameNumberOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNameNumberOccurrence()
	 * @generated
	 */
	int NAME_NUMBER_OCCURRENCE = 92;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.NumberOccurrence <em>Number Occurrence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberOccurrence()
	 * @generated
	 */
	int NUMBER_OCCURRENCE = 93;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.NumberRangeOccurence <em>Number Range Occurence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberRangeOccurence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberRangeOccurence()
	 * @generated
	 */
	int NUMBER_RANGE_OCCURENCE = 94;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.NumberRangeOccurrence <em>Number Range Occurrence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberRangeOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberRangeOccurrence()
	 * @generated
	 */
	int NUMBER_RANGE_OCCURRENCE = 95;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.NumberTypeOccurrence <em>Number Type Occurrence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberTypeOccurrence()
	 * @generated
	 */
	int NUMBER_TYPE_OCCURRENCE = 96;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.NumberTypeOccurrence1 <em>Number Type Occurrence1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence1
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberTypeOccurrence1()
	 * @generated
	 */
	int NUMBER_TYPE_OCCURRENCE1 = 97;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.NumberTypeType <em>Number Type Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberTypeType
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberTypeType()
	 * @generated
	 */
	int NUMBER_TYPE_TYPE = 98;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.NumberTypeType1 <em>Number Type Type1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberTypeType1
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberTypeType1()
	 * @generated
	 */
	int NUMBER_TYPE_TYPE1 = 99;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.RangeTypeType <em>Range Type Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.RangeTypeType
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getRangeTypeType()
	 * @generated
	 */
	int RANGE_TYPE_TYPE = 100;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.TypeOccurrence <em>Type Occurrence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.TypeOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getTypeOccurrence()
	 * @generated
	 */
	int TYPE_OCCURRENCE = 101;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.TypeOccurrence1 <em>Type Occurrence1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.TypeOccurrence1
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getTypeOccurrence1()
	 * @generated
	 */
	int TYPE_OCCURRENCE1 = 102;

	/**
	 * The meta object id for the '{@link com.verticon.oasis.xal.TypeOccurrence2 <em>Type Occurrence2</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.TypeOccurrence2
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getTypeOccurrence2()
	 * @generated
	 */
	int TYPE_OCCURRENCE2 = 103;

	/**
	 * The meta object id for the '<em>Dependent Thoroughfares Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.DependentThoroughfaresType
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getDependentThoroughfaresTypeObject()
	 * @generated
	 */
	int DEPENDENT_THOROUGHFARES_TYPE_OBJECT = 104;

	/**
	 * The meta object id for the '<em>Indicator Occurence Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurenceObject()
	 * @generated
	 */
	int INDICATOR_OCCURENCE_OBJECT = 105;

	/**
	 * The meta object id for the '<em>Indicator Occurrence Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence1
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrenceObject()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE_OBJECT = 106;

	/**
	 * The meta object id for the '<em>Indicator Occurrence Object1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence3
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrenceObject1()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE_OBJECT1 = 107;

	/**
	 * The meta object id for the '<em>Indicator Occurrence Object2</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence2
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrenceObject2()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE_OBJECT2 = 108;

	/**
	 * The meta object id for the '<em>Indicator Occurrence Object3</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrenceObject3()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE_OBJECT3 = 109;

	/**
	 * The meta object id for the '<em>Indicator Occurrence Object4</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.IndicatorOccurrence4
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getIndicatorOccurrenceObject4()
	 * @generated
	 */
	int INDICATOR_OCCURRENCE_OBJECT4 = 110;

	/**
	 * The meta object id for the '<em>Name Number Occurrence Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NameNumberOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNameNumberOccurrenceObject()
	 * @generated
	 */
	int NAME_NUMBER_OCCURRENCE_OBJECT = 111;

	/**
	 * The meta object id for the '<em>Number Occurrence Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberOccurrenceObject()
	 * @generated
	 */
	int NUMBER_OCCURRENCE_OBJECT = 112;

	/**
	 * The meta object id for the '<em>Number Range Occurence Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberRangeOccurence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberRangeOccurenceObject()
	 * @generated
	 */
	int NUMBER_RANGE_OCCURENCE_OBJECT = 113;

	/**
	 * The meta object id for the '<em>Number Range Occurrence Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberRangeOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberRangeOccurrenceObject()
	 * @generated
	 */
	int NUMBER_RANGE_OCCURRENCE_OBJECT = 114;

	/**
	 * The meta object id for the '<em>Number Type Occurrence Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberTypeOccurrenceObject()
	 * @generated
	 */
	int NUMBER_TYPE_OCCURRENCE_OBJECT = 115;

	/**
	 * The meta object id for the '<em>Number Type Occurrence Object1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence1
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberTypeOccurrenceObject1()
	 * @generated
	 */
	int NUMBER_TYPE_OCCURRENCE_OBJECT1 = 116;

	/**
	 * The meta object id for the '<em>Number Type Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberTypeType
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberTypeTypeObject()
	 * @generated
	 */
	int NUMBER_TYPE_TYPE_OBJECT = 117;

	/**
	 * The meta object id for the '<em>Number Type Type Object1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.NumberTypeType1
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getNumberTypeTypeObject1()
	 * @generated
	 */
	int NUMBER_TYPE_TYPE_OBJECT1 = 118;

	/**
	 * The meta object id for the '<em>Range Type Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.RangeTypeType
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getRangeTypeTypeObject()
	 * @generated
	 */
	int RANGE_TYPE_TYPE_OBJECT = 119;

	/**
	 * The meta object id for the '<em>Type Occurrence Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.TypeOccurrence
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getTypeOccurrenceObject()
	 * @generated
	 */
	int TYPE_OCCURRENCE_OBJECT = 120;

	/**
	 * The meta object id for the '<em>Type Occurrence Object1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.TypeOccurrence1
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getTypeOccurrenceObject1()
	 * @generated
	 */
	int TYPE_OCCURRENCE_OBJECT1 = 121;

	/**
	 * The meta object id for the '<em>Type Occurrence Object2</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.oasis.xal.TypeOccurrence2
	 * @see com.verticon.oasis.xal.impl.XalPackageImpl#getTypeOccurrenceObject2()
	 * @generated
	 */
	int TYPE_OCCURRENCE_OBJECT2 = 122;


	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address</em>'.
	 * @see com.verticon.oasis.xal.Address
	 * @generated
	 */
	EClass getAddress();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Address#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.Address#getMixed()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Address#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.Address#getCode()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Address#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.Address#getType()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Address#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Address#getAnyAttribute()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AddressDetails <em>Address Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Details</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails
	 * @generated
	 */
	EClass getAddressDetails();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AddressDetails#getPostalServiceElements <em>Postal Service Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Service Elements</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getPostalServiceElements()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EReference getAddressDetails_PostalServiceElements();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AddressDetails#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getAddress()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EReference getAddressDetails_Address();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AddressDetails#getAddressLines <em>Address Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address Lines</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getAddressLines()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EReference getAddressDetails_AddressLines();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AddressDetails#getCountry <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Country</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getCountry()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EReference getAddressDetails_Country();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AddressDetails#getAdministrativeArea <em>Administrative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Administrative Area</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getAdministrativeArea()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EReference getAddressDetails_AdministrativeArea();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AddressDetails#getLocality <em>Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Locality</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getLocality()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EReference getAddressDetails_Locality();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AddressDetails#getThoroughfare <em>Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getThoroughfare()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EReference getAddressDetails_Thoroughfare();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressDetails#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getAny()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressDetails#getAddressDetailsKey <em>Address Details Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address Details Key</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getAddressDetailsKey()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_AddressDetailsKey();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressDetails#getAddressType <em>Address Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address Type</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getAddressType()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_AddressType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressDetails#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getCode()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressDetails#getCurrentStatus <em>Current Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Status</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getCurrentStatus()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_CurrentStatus();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressDetails#getUsage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getUsage()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_Usage();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressDetails#getValidFromDate <em>Valid From Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid From Date</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getValidFromDate()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_ValidFromDate();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressDetails#getValidToDate <em>Valid To Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid To Date</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getValidToDate()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_ValidToDate();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressDetails#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AddressDetails#getAnyAttribute()
	 * @see #getAddressDetails()
	 * @generated
	 */
	EAttribute getAddressDetails_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AddressIdentifier <em>Address Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Identifier</em>'.
	 * @see com.verticon.oasis.xal.AddressIdentifier
	 * @generated
	 */
	EClass getAddressIdentifier();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressIdentifier#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.AddressIdentifier#getMixed()
	 * @see #getAddressIdentifier()
	 * @generated
	 */
	EAttribute getAddressIdentifier_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressIdentifier#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.AddressIdentifier#getCode()
	 * @see #getAddressIdentifier()
	 * @generated
	 */
	EAttribute getAddressIdentifier_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressIdentifier#getIdentifierType <em>Identifier Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier Type</em>'.
	 * @see com.verticon.oasis.xal.AddressIdentifier#getIdentifierType()
	 * @see #getAddressIdentifier()
	 * @generated
	 */
	EAttribute getAddressIdentifier_IdentifierType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressIdentifier#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.AddressIdentifier#getType()
	 * @see #getAddressIdentifier()
	 * @generated
	 */
	EAttribute getAddressIdentifier_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressIdentifier#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AddressIdentifier#getAnyAttribute()
	 * @see #getAddressIdentifier()
	 * @generated
	 */
	EAttribute getAddressIdentifier_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AddressLatitude <em>Address Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Latitude</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitude
	 * @generated
	 */
	EClass getAddressLatitude();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLatitude#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitude#getMixed()
	 * @see #getAddressLatitude()
	 * @generated
	 */
	EAttribute getAddressLatitude_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLatitude#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitude#getCode()
	 * @see #getAddressLatitude()
	 * @generated
	 */
	EAttribute getAddressLatitude_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLatitude#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitude#getType()
	 * @see #getAddressLatitude()
	 * @generated
	 */
	EAttribute getAddressLatitude_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLatitude#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitude#getAnyAttribute()
	 * @see #getAddressLatitude()
	 * @generated
	 */
	EAttribute getAddressLatitude_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AddressLatitudeDirection <em>Address Latitude Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Latitude Direction</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitudeDirection
	 * @generated
	 */
	EClass getAddressLatitudeDirection();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLatitudeDirection#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitudeDirection#getMixed()
	 * @see #getAddressLatitudeDirection()
	 * @generated
	 */
	EAttribute getAddressLatitudeDirection_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLatitudeDirection#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitudeDirection#getCode()
	 * @see #getAddressLatitudeDirection()
	 * @generated
	 */
	EAttribute getAddressLatitudeDirection_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLatitudeDirection#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitudeDirection#getType()
	 * @see #getAddressLatitudeDirection()
	 * @generated
	 */
	EAttribute getAddressLatitudeDirection_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLatitudeDirection#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AddressLatitudeDirection#getAnyAttribute()
	 * @see #getAddressLatitudeDirection()
	 * @generated
	 */
	EAttribute getAddressLatitudeDirection_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.AddressLine
	 * @generated
	 */
	EClass getAddressLine();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLine#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.AddressLine#getMixed()
	 * @see #getAddressLine()
	 * @generated
	 */
	EAttribute getAddressLine_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLine#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.AddressLine#getCode()
	 * @see #getAddressLine()
	 * @generated
	 */
	EAttribute getAddressLine_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLine#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.AddressLine#getType()
	 * @see #getAddressLine()
	 * @generated
	 */
	EAttribute getAddressLine_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLine#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AddressLine#getAnyAttribute()
	 * @see #getAddressLine()
	 * @generated
	 */
	EAttribute getAddressLine_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AddressLines <em>Address Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Lines</em>'.
	 * @see com.verticon.oasis.xal.AddressLines
	 * @generated
	 */
	EClass getAddressLines();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.AddressLines#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.AddressLines#getAddressLine()
	 * @see #getAddressLines()
	 * @generated
	 */
	EReference getAddressLines_AddressLine();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLines#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.AddressLines#getAny()
	 * @see #getAddressLines()
	 * @generated
	 */
	EAttribute getAddressLines_Any();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLines#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AddressLines#getAnyAttribute()
	 * @see #getAddressLines()
	 * @generated
	 */
	EAttribute getAddressLines_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AddressLongitude <em>Address Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Longitude</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitude
	 * @generated
	 */
	EClass getAddressLongitude();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLongitude#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitude#getMixed()
	 * @see #getAddressLongitude()
	 * @generated
	 */
	EAttribute getAddressLongitude_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLongitude#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitude#getCode()
	 * @see #getAddressLongitude()
	 * @generated
	 */
	EAttribute getAddressLongitude_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLongitude#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitude#getType()
	 * @see #getAddressLongitude()
	 * @generated
	 */
	EAttribute getAddressLongitude_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLongitude#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitude#getAnyAttribute()
	 * @see #getAddressLongitude()
	 * @generated
	 */
	EAttribute getAddressLongitude_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AddressLongitudeDirection <em>Address Longitude Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Longitude Direction</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitudeDirection
	 * @generated
	 */
	EClass getAddressLongitudeDirection();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLongitudeDirection#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitudeDirection#getMixed()
	 * @see #getAddressLongitudeDirection()
	 * @generated
	 */
	EAttribute getAddressLongitudeDirection_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLongitudeDirection#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitudeDirection#getCode()
	 * @see #getAddressLongitudeDirection()
	 * @generated
	 */
	EAttribute getAddressLongitudeDirection_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AddressLongitudeDirection#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitudeDirection#getType()
	 * @see #getAddressLongitudeDirection()
	 * @generated
	 */
	EAttribute getAddressLongitudeDirection_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AddressLongitudeDirection#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AddressLongitudeDirection#getAnyAttribute()
	 * @see #getAddressLongitudeDirection()
	 * @generated
	 */
	EAttribute getAddressLongitudeDirection_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AdministrativeArea <em>Administrative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Administrative Area</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea
	 * @generated
	 */
	EClass getAdministrativeArea();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.AdministrativeArea#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getAddressLine()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EReference getAdministrativeArea_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.AdministrativeArea#getAdministrativeAreaName <em>Administrative Area Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Administrative Area Name</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getAdministrativeAreaName()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EReference getAdministrativeArea_AdministrativeAreaName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AdministrativeArea#getSubAdministrativeArea <em>Sub Administrative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Administrative Area</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getSubAdministrativeArea()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EReference getAdministrativeArea_SubAdministrativeArea();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AdministrativeArea#getLocality <em>Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Locality</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getLocality()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EReference getAdministrativeArea_Locality();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AdministrativeArea#getPostOffice <em>Post Office</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Office</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getPostOffice()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EReference getAdministrativeArea_PostOffice();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.AdministrativeArea#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getPostalCode()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EReference getAdministrativeArea_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AdministrativeArea#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getAny()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EAttribute getAdministrativeArea_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AdministrativeArea#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getIndicator()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EAttribute getAdministrativeArea_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AdministrativeArea#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getType()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EAttribute getAdministrativeArea_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AdministrativeArea#getUsageType <em>Usage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage Type</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getUsageType()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EAttribute getAdministrativeArea_UsageType();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AdministrativeArea#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeArea#getAnyAttribute()
	 * @see #getAdministrativeArea()
	 * @generated
	 */
	EAttribute getAdministrativeArea_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.AdministrativeAreaName <em>Administrative Area Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Administrative Area Name</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeAreaName
	 * @generated
	 */
	EClass getAdministrativeAreaName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AdministrativeAreaName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeAreaName#getMixed()
	 * @see #getAdministrativeAreaName()
	 * @generated
	 */
	EAttribute getAdministrativeAreaName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AdministrativeAreaName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeAreaName#getCode()
	 * @see #getAdministrativeAreaName()
	 * @generated
	 */
	EAttribute getAdministrativeAreaName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.AdministrativeAreaName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeAreaName#getType()
	 * @see #getAdministrativeAreaName()
	 * @generated
	 */
	EAttribute getAdministrativeAreaName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.AdministrativeAreaName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.AdministrativeAreaName#getAnyAttribute()
	 * @see #getAdministrativeAreaName()
	 * @generated
	 */
	EAttribute getAdministrativeAreaName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Barcode <em>Barcode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Barcode</em>'.
	 * @see com.verticon.oasis.xal.Barcode
	 * @generated
	 */
	EClass getBarcode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Barcode#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.Barcode#getMixed()
	 * @see #getBarcode()
	 * @generated
	 */
	EAttribute getBarcode_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Barcode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.Barcode#getCode()
	 * @see #getBarcode()
	 * @generated
	 */
	EAttribute getBarcode_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Barcode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.Barcode#getType()
	 * @see #getBarcode()
	 * @generated
	 */
	EAttribute getBarcode_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Barcode#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Barcode#getAnyAttribute()
	 * @see #getBarcode()
	 * @generated
	 */
	EAttribute getBarcode_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.BuildingName <em>Building Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Building Name</em>'.
	 * @see com.verticon.oasis.xal.BuildingName
	 * @generated
	 */
	EClass getBuildingName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.BuildingName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.BuildingName#getMixed()
	 * @see #getBuildingName()
	 * @generated
	 */
	EAttribute getBuildingName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.BuildingName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.BuildingName#getCode()
	 * @see #getBuildingName()
	 * @generated
	 */
	EAttribute getBuildingName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.BuildingName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.BuildingName#getType()
	 * @see #getBuildingName()
	 * @generated
	 */
	EAttribute getBuildingName_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.BuildingName#getTypeOccurrence <em>Type Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Occurrence</em>'.
	 * @see com.verticon.oasis.xal.BuildingName#getTypeOccurrence()
	 * @see #getBuildingName()
	 * @generated
	 */
	EAttribute getBuildingName_TypeOccurrence();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.BuildingName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.BuildingName#getAnyAttribute()
	 * @see #getBuildingName()
	 * @generated
	 */
	EAttribute getBuildingName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Country <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Country</em>'.
	 * @see com.verticon.oasis.xal.Country
	 * @generated
	 */
	EClass getCountry();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Country#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.Country#getAddressLine()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Country#getCountryNameCode <em>Country Name Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Country Name Code</em>'.
	 * @see com.verticon.oasis.xal.Country#getCountryNameCode()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_CountryNameCode();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Country#getCountryName <em>Country Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Country Name</em>'.
	 * @see com.verticon.oasis.xal.Country#getCountryName()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_CountryName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Country#getAdministrativeArea <em>Administrative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Administrative Area</em>'.
	 * @see com.verticon.oasis.xal.Country#getAdministrativeArea()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_AdministrativeArea();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Country#getLocality <em>Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Locality</em>'.
	 * @see com.verticon.oasis.xal.Country#getLocality()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_Locality();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Country#getThoroughfare <em>Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.Country#getThoroughfare()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_Thoroughfare();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Country#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.Country#getAny()
	 * @see #getCountry()
	 * @generated
	 */
	EAttribute getCountry_Any();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Country#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Country#getAnyAttribute()
	 * @see #getCountry()
	 * @generated
	 */
	EAttribute getCountry_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.CountryName <em>Country Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Country Name</em>'.
	 * @see com.verticon.oasis.xal.CountryName
	 * @generated
	 */
	EClass getCountryName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.CountryName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.CountryName#getMixed()
	 * @see #getCountryName()
	 * @generated
	 */
	EAttribute getCountryName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.CountryName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.CountryName#getCode()
	 * @see #getCountryName()
	 * @generated
	 */
	EAttribute getCountryName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.CountryName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.CountryName#getType()
	 * @see #getCountryName()
	 * @generated
	 */
	EAttribute getCountryName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.CountryName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.CountryName#getAnyAttribute()
	 * @see #getCountryName()
	 * @generated
	 */
	EAttribute getCountryName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.CountryNameCode <em>Country Name Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Country Name Code</em>'.
	 * @see com.verticon.oasis.xal.CountryNameCode
	 * @generated
	 */
	EClass getCountryNameCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.CountryNameCode#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.CountryNameCode#getMixed()
	 * @see #getCountryNameCode()
	 * @generated
	 */
	EAttribute getCountryNameCode_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.CountryNameCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.CountryNameCode#getCode()
	 * @see #getCountryNameCode()
	 * @generated
	 */
	EAttribute getCountryNameCode_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.CountryNameCode#getScheme <em>Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheme</em>'.
	 * @see com.verticon.oasis.xal.CountryNameCode#getScheme()
	 * @see #getCountryNameCode()
	 * @generated
	 */
	EAttribute getCountryNameCode_Scheme();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.CountryNameCode#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.CountryNameCode#getAnyAttribute()
	 * @see #getCountryNameCode()
	 * @generated
	 */
	EAttribute getCountryNameCode_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Department <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Department</em>'.
	 * @see com.verticon.oasis.xal.Department
	 * @generated
	 */
	EClass getDepartment();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Department#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.Department#getAddressLine()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Department#getDepartmentName <em>Department Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Department Name</em>'.
	 * @see com.verticon.oasis.xal.Department#getDepartmentName()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_DepartmentName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Department#getMailStop <em>Mail Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mail Stop</em>'.
	 * @see com.verticon.oasis.xal.Department#getMailStop()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_MailStop();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Department#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.Department#getPostalCode()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Department#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.Department#getAny()
	 * @see #getDepartment()
	 * @generated
	 */
	EAttribute getDepartment_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Department#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.Department#getType()
	 * @see #getDepartment()
	 * @generated
	 */
	EAttribute getDepartment_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Department#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Department#getAnyAttribute()
	 * @see #getDepartment()
	 * @generated
	 */
	EAttribute getDepartment_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.DepartmentName <em>Department Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Department Name</em>'.
	 * @see com.verticon.oasis.xal.DepartmentName
	 * @generated
	 */
	EClass getDepartmentName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DepartmentName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.DepartmentName#getMixed()
	 * @see #getDepartmentName()
	 * @generated
	 */
	EAttribute getDepartmentName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DepartmentName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.DepartmentName#getCode()
	 * @see #getDepartmentName()
	 * @generated
	 */
	EAttribute getDepartmentName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DepartmentName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.DepartmentName#getType()
	 * @see #getDepartmentName()
	 * @generated
	 */
	EAttribute getDepartmentName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DepartmentName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.DepartmentName#getAnyAttribute()
	 * @see #getDepartmentName()
	 * @generated
	 */
	EAttribute getDepartmentName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.DependentLocality <em>Dependent Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependent Locality</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality
	 * @generated
	 */
	EClass getDependentLocality();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.DependentLocality#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getAddressLine()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.DependentLocality#getDependentLocalityName <em>Dependent Locality Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependent Locality Name</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getDependentLocalityName()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_DependentLocalityName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getDependentLocalityNumber <em>Dependent Locality Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependent Locality Number</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getDependentLocalityNumber()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_DependentLocalityNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getPostBox <em>Post Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getPostBox()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_PostBox();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getLargeMailUser <em>Large Mail User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Large Mail User</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getLargeMailUser()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_LargeMailUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getPostOffice <em>Post Office</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Office</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getPostOffice()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_PostOffice();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getPostalRoute <em>Postal Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Route</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getPostalRoute()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_PostalRoute();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getThoroughfare <em>Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getThoroughfare()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_Thoroughfare();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getPremise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getPremise()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_Premise();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getDependentLocality <em>Dependent Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependent Locality</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getDependentLocality()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_DependentLocality();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentLocality#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getPostalCode()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EReference getDependentLocality_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DependentLocality#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getAny()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EAttribute getDependentLocality_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentLocality#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connector</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getConnector()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EAttribute getDependentLocality_Connector();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentLocality#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getIndicator()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EAttribute getDependentLocality_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentLocality#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getType()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EAttribute getDependentLocality_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentLocality#getUsageType <em>Usage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage Type</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getUsageType()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EAttribute getDependentLocality_UsageType();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DependentLocality#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.DependentLocality#getAnyAttribute()
	 * @see #getDependentLocality()
	 * @generated
	 */
	EAttribute getDependentLocality_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.DependentLocalityName <em>Dependent Locality Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependent Locality Name</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityName
	 * @generated
	 */
	EClass getDependentLocalityName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DependentLocalityName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityName#getMixed()
	 * @see #getDependentLocalityName()
	 * @generated
	 */
	EAttribute getDependentLocalityName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentLocalityName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityName#getCode()
	 * @see #getDependentLocalityName()
	 * @generated
	 */
	EAttribute getDependentLocalityName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentLocalityName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityName#getType()
	 * @see #getDependentLocalityName()
	 * @generated
	 */
	EAttribute getDependentLocalityName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DependentLocalityName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityName#getAnyAttribute()
	 * @see #getDependentLocalityName()
	 * @generated
	 */
	EAttribute getDependentLocalityName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.DependentLocalityNumber <em>Dependent Locality Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependent Locality Number</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityNumber
	 * @generated
	 */
	EClass getDependentLocalityNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DependentLocalityNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityNumber#getMixed()
	 * @see #getDependentLocalityNumber()
	 * @generated
	 */
	EAttribute getDependentLocalityNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentLocalityNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityNumber#getCode()
	 * @see #getDependentLocalityNumber()
	 * @generated
	 */
	EAttribute getDependentLocalityNumber_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentLocalityNumber#getNameNumberOccurrence <em>Name Number Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Number Occurrence</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityNumber#getNameNumberOccurrence()
	 * @see #getDependentLocalityNumber()
	 * @generated
	 */
	EAttribute getDependentLocalityNumber_NameNumberOccurrence();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DependentLocalityNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.DependentLocalityNumber#getAnyAttribute()
	 * @see #getDependentLocalityNumber()
	 * @generated
	 */
	EAttribute getDependentLocalityNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.DependentThoroughfare <em>Dependent Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependent Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare
	 * @generated
	 */
	EClass getDependentThoroughfare();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.DependentThoroughfare#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getAddressLine()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EReference getDependentThoroughfare_AddressLine();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Pre Direction</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getThoroughfarePreDirection()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EReference getDependentThoroughfare_ThoroughfarePreDirection();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Leading Type</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareLeadingType()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EReference getDependentThoroughfare_ThoroughfareLeadingType();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareName <em>Thoroughfare Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Name</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareName()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EReference getDependentThoroughfare_ThoroughfareName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Trailing Type</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareTrailingType()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EReference getDependentThoroughfare_ThoroughfareTrailingType();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Post Direction</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getThoroughfarePostDirection()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EReference getDependentThoroughfare_ThoroughfarePostDirection();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DependentThoroughfare#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getAny()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EAttribute getDependentThoroughfare_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.DependentThoroughfare#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getType()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EAttribute getDependentThoroughfare_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DependentThoroughfare#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfare#getAnyAttribute()
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	EAttribute getDependentThoroughfare_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.verticon.oasis.xal.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.verticon.oasis.xal.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getAddressDetails <em>Address Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address Details</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getAddressDetails()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AddressDetails();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getAddressLine()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AddressLine();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getAdministrativeArea <em>Administrative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Administrative Area</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getAdministrativeArea()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AdministrativeArea();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getCountryName <em>Country Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Country Name</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getCountryName()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_CountryName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Department</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getDepartment()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Department();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getLocality <em>Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Locality</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getLocality()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Locality();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getPostalCode()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PostalCode();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getPostBox <em>Post Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getPostBox()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PostBox();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getPostOffice <em>Post Office</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Office</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getPostOffice()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PostOffice();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getPremise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getPremise()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Premise();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getPremiseNumber <em>Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise Number</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getPremiseNumber()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PremiseNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getPremiseNumberPrefix <em>Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getPremiseNumberPrefix()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PremiseNumberPrefix();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getPremiseNumberSuffix <em>Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getPremiseNumberSuffix()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PremiseNumberSuffix();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getThoroughfare <em>Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getThoroughfare()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Thoroughfare();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getThoroughfareNumber <em>Thoroughfare Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Number</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getThoroughfareNumber()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ThoroughfareNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getThoroughfareNumberPrefix()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ThoroughfareNumberPrefix();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getThoroughfareNumberSuffix()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ThoroughfareNumberSuffix();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.DocumentRoot#getXAL <em>XAL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>XAL</em>'.
	 * @see com.verticon.oasis.xal.DocumentRoot#getXAL()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XAL();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.EndorsementLineCode <em>Endorsement Line Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Endorsement Line Code</em>'.
	 * @see com.verticon.oasis.xal.EndorsementLineCode
	 * @generated
	 */
	EClass getEndorsementLineCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.EndorsementLineCode#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.EndorsementLineCode#getMixed()
	 * @see #getEndorsementLineCode()
	 * @generated
	 */
	EAttribute getEndorsementLineCode_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.EndorsementLineCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.EndorsementLineCode#getCode()
	 * @see #getEndorsementLineCode()
	 * @generated
	 */
	EAttribute getEndorsementLineCode_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.EndorsementLineCode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.EndorsementLineCode#getType()
	 * @see #getEndorsementLineCode()
	 * @generated
	 */
	EAttribute getEndorsementLineCode_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.EndorsementLineCode#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.EndorsementLineCode#getAnyAttribute()
	 * @see #getEndorsementLineCode()
	 * @generated
	 */
	EAttribute getEndorsementLineCode_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Firm <em>Firm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Firm</em>'.
	 * @see com.verticon.oasis.xal.Firm
	 * @generated
	 */
	EClass getFirm();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Firm#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.Firm#getAddressLine()
	 * @see #getFirm()
	 * @generated
	 */
	EReference getFirm_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Firm#getFirmName <em>Firm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Firm Name</em>'.
	 * @see com.verticon.oasis.xal.Firm#getFirmName()
	 * @see #getFirm()
	 * @generated
	 */
	EReference getFirm_FirmName();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Firm#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Department</em>'.
	 * @see com.verticon.oasis.xal.Firm#getDepartment()
	 * @see #getFirm()
	 * @generated
	 */
	EReference getFirm_Department();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Firm#getMailStop <em>Mail Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mail Stop</em>'.
	 * @see com.verticon.oasis.xal.Firm#getMailStop()
	 * @see #getFirm()
	 * @generated
	 */
	EReference getFirm_MailStop();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Firm#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.Firm#getPostalCode()
	 * @see #getFirm()
	 * @generated
	 */
	EReference getFirm_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Firm#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.Firm#getAny()
	 * @see #getFirm()
	 * @generated
	 */
	EAttribute getFirm_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Firm#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.Firm#getType()
	 * @see #getFirm()
	 * @generated
	 */
	EAttribute getFirm_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Firm#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Firm#getAnyAttribute()
	 * @see #getFirm()
	 * @generated
	 */
	EAttribute getFirm_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.FirmName <em>Firm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Firm Name</em>'.
	 * @see com.verticon.oasis.xal.FirmName
	 * @generated
	 */
	EClass getFirmName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.FirmName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.FirmName#getMixed()
	 * @see #getFirmName()
	 * @generated
	 */
	EAttribute getFirmName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.FirmName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.FirmName#getCode()
	 * @see #getFirmName()
	 * @generated
	 */
	EAttribute getFirmName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.FirmName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.FirmName#getType()
	 * @see #getFirmName()
	 * @generated
	 */
	EAttribute getFirmName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.FirmName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.FirmName#getAnyAttribute()
	 * @see #getFirmName()
	 * @generated
	 */
	EAttribute getFirmName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.KeyLineCode <em>Key Line Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Line Code</em>'.
	 * @see com.verticon.oasis.xal.KeyLineCode
	 * @generated
	 */
	EClass getKeyLineCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.KeyLineCode#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.KeyLineCode#getMixed()
	 * @see #getKeyLineCode()
	 * @generated
	 */
	EAttribute getKeyLineCode_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.KeyLineCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.KeyLineCode#getCode()
	 * @see #getKeyLineCode()
	 * @generated
	 */
	EAttribute getKeyLineCode_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.KeyLineCode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.KeyLineCode#getType()
	 * @see #getKeyLineCode()
	 * @generated
	 */
	EAttribute getKeyLineCode_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.KeyLineCode#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.KeyLineCode#getAnyAttribute()
	 * @see #getKeyLineCode()
	 * @generated
	 */
	EAttribute getKeyLineCode_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.LargeMailUser <em>Large Mail User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Large Mail User</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser
	 * @generated
	 */
	EClass getLargeMailUser();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.LargeMailUser#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getAddressLine()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EReference getLargeMailUser_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.LargeMailUser#getLargeMailUserName <em>Large Mail User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Large Mail User Name</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getLargeMailUserName()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EReference getLargeMailUser_LargeMailUserName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.LargeMailUser#getLargeMailUserIdentifier <em>Large Mail User Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Large Mail User Identifier</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getLargeMailUserIdentifier()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EReference getLargeMailUser_LargeMailUserIdentifier();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.LargeMailUser#getBuildingName <em>Building Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Building Name</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getBuildingName()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EReference getLargeMailUser_BuildingName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.LargeMailUser#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Department</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getDepartment()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EReference getLargeMailUser_Department();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.LargeMailUser#getPostBox <em>Post Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getPostBox()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EReference getLargeMailUser_PostBox();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.LargeMailUser#getThoroughfare <em>Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getThoroughfare()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EReference getLargeMailUser_Thoroughfare();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.LargeMailUser#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getPostalCode()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EReference getLargeMailUser_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.LargeMailUser#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getAny()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EAttribute getLargeMailUser_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.LargeMailUser#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getType()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EAttribute getLargeMailUser_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.LargeMailUser#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUser#getAnyAttribute()
	 * @see #getLargeMailUser()
	 * @generated
	 */
	EAttribute getLargeMailUser_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.LargeMailUserIdentifier <em>Large Mail User Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Large Mail User Identifier</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserIdentifier
	 * @generated
	 */
	EClass getLargeMailUserIdentifier();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.LargeMailUserIdentifier#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserIdentifier#getMixed()
	 * @see #getLargeMailUserIdentifier()
	 * @generated
	 */
	EAttribute getLargeMailUserIdentifier_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.LargeMailUserIdentifier#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserIdentifier#getCode()
	 * @see #getLargeMailUserIdentifier()
	 * @generated
	 */
	EAttribute getLargeMailUserIdentifier_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.LargeMailUserIdentifier#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserIdentifier#getIndicator()
	 * @see #getLargeMailUserIdentifier()
	 * @generated
	 */
	EAttribute getLargeMailUserIdentifier_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.LargeMailUserIdentifier#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserIdentifier#getType()
	 * @see #getLargeMailUserIdentifier()
	 * @generated
	 */
	EAttribute getLargeMailUserIdentifier_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.LargeMailUserIdentifier#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserIdentifier#getAnyAttribute()
	 * @see #getLargeMailUserIdentifier()
	 * @generated
	 */
	EAttribute getLargeMailUserIdentifier_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.LargeMailUserName <em>Large Mail User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Large Mail User Name</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserName
	 * @generated
	 */
	EClass getLargeMailUserName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.LargeMailUserName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserName#getMixed()
	 * @see #getLargeMailUserName()
	 * @generated
	 */
	EAttribute getLargeMailUserName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.LargeMailUserName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserName#getCode()
	 * @see #getLargeMailUserName()
	 * @generated
	 */
	EAttribute getLargeMailUserName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.LargeMailUserName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserName#getType()
	 * @see #getLargeMailUserName()
	 * @generated
	 */
	EAttribute getLargeMailUserName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.LargeMailUserName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.LargeMailUserName#getAnyAttribute()
	 * @see #getLargeMailUserName()
	 * @generated
	 */
	EAttribute getLargeMailUserName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Locality <em>Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Locality</em>'.
	 * @see com.verticon.oasis.xal.Locality
	 * @generated
	 */
	EClass getLocality();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Locality#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.Locality#getAddressLine()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Locality#getLocalityName <em>Locality Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locality Name</em>'.
	 * @see com.verticon.oasis.xal.Locality#getLocalityName()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_LocalityName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Locality#getPostBox <em>Post Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box</em>'.
	 * @see com.verticon.oasis.xal.Locality#getPostBox()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_PostBox();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Locality#getLargeMailUser <em>Large Mail User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Large Mail User</em>'.
	 * @see com.verticon.oasis.xal.Locality#getLargeMailUser()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_LargeMailUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Locality#getPostOffice <em>Post Office</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Office</em>'.
	 * @see com.verticon.oasis.xal.Locality#getPostOffice()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_PostOffice();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Locality#getPostalRoute <em>Postal Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Route</em>'.
	 * @see com.verticon.oasis.xal.Locality#getPostalRoute()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_PostalRoute();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Locality#getThoroughfare <em>Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.Locality#getThoroughfare()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_Thoroughfare();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Locality#getPremise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise</em>'.
	 * @see com.verticon.oasis.xal.Locality#getPremise()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_Premise();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Locality#getDependentLocality <em>Dependent Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependent Locality</em>'.
	 * @see com.verticon.oasis.xal.Locality#getDependentLocality()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_DependentLocality();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Locality#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.Locality#getPostalCode()
	 * @see #getLocality()
	 * @generated
	 */
	EReference getLocality_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Locality#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.Locality#getAny()
	 * @see #getLocality()
	 * @generated
	 */
	EAttribute getLocality_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Locality#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.Locality#getIndicator()
	 * @see #getLocality()
	 * @generated
	 */
	EAttribute getLocality_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Locality#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.Locality#getType()
	 * @see #getLocality()
	 * @generated
	 */
	EAttribute getLocality_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Locality#getUsageType <em>Usage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage Type</em>'.
	 * @see com.verticon.oasis.xal.Locality#getUsageType()
	 * @see #getLocality()
	 * @generated
	 */
	EAttribute getLocality_UsageType();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Locality#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Locality#getAnyAttribute()
	 * @see #getLocality()
	 * @generated
	 */
	EAttribute getLocality_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.LocalityName <em>Locality Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Locality Name</em>'.
	 * @see com.verticon.oasis.xal.LocalityName
	 * @generated
	 */
	EClass getLocalityName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.LocalityName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.LocalityName#getMixed()
	 * @see #getLocalityName()
	 * @generated
	 */
	EAttribute getLocalityName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.LocalityName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.LocalityName#getCode()
	 * @see #getLocalityName()
	 * @generated
	 */
	EAttribute getLocalityName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.LocalityName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.LocalityName#getType()
	 * @see #getLocalityName()
	 * @generated
	 */
	EAttribute getLocalityName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.LocalityName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.LocalityName#getAnyAttribute()
	 * @see #getLocalityName()
	 * @generated
	 */
	EAttribute getLocalityName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.MailStop <em>Mail Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mail Stop</em>'.
	 * @see com.verticon.oasis.xal.MailStop
	 * @generated
	 */
	EClass getMailStop();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.MailStop#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.MailStop#getAddressLine()
	 * @see #getMailStop()
	 * @generated
	 */
	EReference getMailStop_AddressLine();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.MailStop#getMailStopName <em>Mail Stop Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mail Stop Name</em>'.
	 * @see com.verticon.oasis.xal.MailStop#getMailStopName()
	 * @see #getMailStop()
	 * @generated
	 */
	EReference getMailStop_MailStopName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.MailStop#getMailStopNumber <em>Mail Stop Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mail Stop Number</em>'.
	 * @see com.verticon.oasis.xal.MailStop#getMailStopNumber()
	 * @see #getMailStop()
	 * @generated
	 */
	EReference getMailStop_MailStopNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.MailStop#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.MailStop#getAny()
	 * @see #getMailStop()
	 * @generated
	 */
	EAttribute getMailStop_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.MailStop#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.MailStop#getType()
	 * @see #getMailStop()
	 * @generated
	 */
	EAttribute getMailStop_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.MailStop#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.MailStop#getAnyAttribute()
	 * @see #getMailStop()
	 * @generated
	 */
	EAttribute getMailStop_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.MailStopName <em>Mail Stop Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mail Stop Name</em>'.
	 * @see com.verticon.oasis.xal.MailStopName
	 * @generated
	 */
	EClass getMailStopName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.MailStopName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.MailStopName#getMixed()
	 * @see #getMailStopName()
	 * @generated
	 */
	EAttribute getMailStopName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.MailStopName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.MailStopName#getCode()
	 * @see #getMailStopName()
	 * @generated
	 */
	EAttribute getMailStopName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.MailStopName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.MailStopName#getType()
	 * @see #getMailStopName()
	 * @generated
	 */
	EAttribute getMailStopName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.MailStopName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.MailStopName#getAnyAttribute()
	 * @see #getMailStopName()
	 * @generated
	 */
	EAttribute getMailStopName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.MailStopNumber <em>Mail Stop Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mail Stop Number</em>'.
	 * @see com.verticon.oasis.xal.MailStopNumber
	 * @generated
	 */
	EClass getMailStopNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.MailStopNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.MailStopNumber#getMixed()
	 * @see #getMailStopNumber()
	 * @generated
	 */
	EAttribute getMailStopNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.MailStopNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.MailStopNumber#getCode()
	 * @see #getMailStopNumber()
	 * @generated
	 */
	EAttribute getMailStopNumber_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.MailStopNumber#getNameNumberSeparator <em>Name Number Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Number Separator</em>'.
	 * @see com.verticon.oasis.xal.MailStopNumber#getNameNumberSeparator()
	 * @see #getMailStopNumber()
	 * @generated
	 */
	EAttribute getMailStopNumber_NameNumberSeparator();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.MailStopNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.MailStopNumber#getAnyAttribute()
	 * @see #getMailStopNumber()
	 * @generated
	 */
	EAttribute getMailStopNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.PostalCode
	 * @generated
	 */
	EClass getPostalCode();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostalCode#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.PostalCode#getAddressLine()
	 * @see #getPostalCode()
	 * @generated
	 */
	EReference getPostalCode_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostalCode#getPostalCodeNumber <em>Postal Code Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postal Code Number</em>'.
	 * @see com.verticon.oasis.xal.PostalCode#getPostalCodeNumber()
	 * @see #getPostalCode()
	 * @generated
	 */
	EReference getPostalCode_PostalCodeNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostalCode#getPostalCodeNumberExtension <em>Postal Code Number Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postal Code Number Extension</em>'.
	 * @see com.verticon.oasis.xal.PostalCode#getPostalCodeNumberExtension()
	 * @see #getPostalCode()
	 * @generated
	 */
	EReference getPostalCode_PostalCodeNumberExtension();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalCode#getPostTown <em>Post Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Town</em>'.
	 * @see com.verticon.oasis.xal.PostalCode#getPostTown()
	 * @see #getPostalCode()
	 * @generated
	 */
	EReference getPostalCode_PostTown();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalCode#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.PostalCode#getAny()
	 * @see #getPostalCode()
	 * @generated
	 */
	EAttribute getPostalCode_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalCode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostalCode#getType()
	 * @see #getPostalCode()
	 * @generated
	 */
	EAttribute getPostalCode_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalCode#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostalCode#getAnyAttribute()
	 * @see #getPostalCode()
	 * @generated
	 */
	EAttribute getPostalCode_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostalCodeNumber <em>Postal Code Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Code Number</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumber
	 * @generated
	 */
	EClass getPostalCodeNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalCodeNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumber#getMixed()
	 * @see #getPostalCodeNumber()
	 * @generated
	 */
	EAttribute getPostalCodeNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalCodeNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumber#getCode()
	 * @see #getPostalCodeNumber()
	 * @generated
	 */
	EAttribute getPostalCodeNumber_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalCodeNumber#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumber#getType()
	 * @see #getPostalCodeNumber()
	 * @generated
	 */
	EAttribute getPostalCodeNumber_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalCodeNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumber#getAnyAttribute()
	 * @see #getPostalCodeNumber()
	 * @generated
	 */
	EAttribute getPostalCodeNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostalCodeNumberExtension <em>Postal Code Number Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Code Number Extension</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumberExtension
	 * @generated
	 */
	EClass getPostalCodeNumberExtension();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalCodeNumberExtension#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumberExtension#getMixed()
	 * @see #getPostalCodeNumberExtension()
	 * @generated
	 */
	EAttribute getPostalCodeNumberExtension_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalCodeNumberExtension#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumberExtension#getCode()
	 * @see #getPostalCodeNumberExtension()
	 * @generated
	 */
	EAttribute getPostalCodeNumberExtension_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalCodeNumberExtension#getNumberExtensionSeparator <em>Number Extension Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Extension Separator</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumberExtension#getNumberExtensionSeparator()
	 * @see #getPostalCodeNumberExtension()
	 * @generated
	 */
	EAttribute getPostalCodeNumberExtension_NumberExtensionSeparator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalCodeNumberExtension#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumberExtension#getType()
	 * @see #getPostalCodeNumberExtension()
	 * @generated
	 */
	EAttribute getPostalCodeNumberExtension_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalCodeNumberExtension#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostalCodeNumberExtension#getAnyAttribute()
	 * @see #getPostalCodeNumberExtension()
	 * @generated
	 */
	EAttribute getPostalCodeNumberExtension_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostalRoute <em>Postal Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Route</em>'.
	 * @see com.verticon.oasis.xal.PostalRoute
	 * @generated
	 */
	EClass getPostalRoute();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostalRoute#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.PostalRoute#getAddressLine()
	 * @see #getPostalRoute()
	 * @generated
	 */
	EReference getPostalRoute_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostalRoute#getPostalRouteName <em>Postal Route Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postal Route Name</em>'.
	 * @see com.verticon.oasis.xal.PostalRoute#getPostalRouteName()
	 * @see #getPostalRoute()
	 * @generated
	 */
	EReference getPostalRoute_PostalRouteName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalRoute#getPostalRouteNumber <em>Postal Route Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Route Number</em>'.
	 * @see com.verticon.oasis.xal.PostalRoute#getPostalRouteNumber()
	 * @see #getPostalRoute()
	 * @generated
	 */
	EReference getPostalRoute_PostalRouteNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalRoute#getPostBox <em>Post Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box</em>'.
	 * @see com.verticon.oasis.xal.PostalRoute#getPostBox()
	 * @see #getPostalRoute()
	 * @generated
	 */
	EReference getPostalRoute_PostBox();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalRoute#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.PostalRoute#getAny()
	 * @see #getPostalRoute()
	 * @generated
	 */
	EAttribute getPostalRoute_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalRoute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostalRoute#getType()
	 * @see #getPostalRoute()
	 * @generated
	 */
	EAttribute getPostalRoute_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalRoute#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostalRoute#getAnyAttribute()
	 * @see #getPostalRoute()
	 * @generated
	 */
	EAttribute getPostalRoute_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostalRouteName <em>Postal Route Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Route Name</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteName
	 * @generated
	 */
	EClass getPostalRouteName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalRouteName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteName#getMixed()
	 * @see #getPostalRouteName()
	 * @generated
	 */
	EAttribute getPostalRouteName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalRouteName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteName#getCode()
	 * @see #getPostalRouteName()
	 * @generated
	 */
	EAttribute getPostalRouteName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalRouteName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteName#getType()
	 * @see #getPostalRouteName()
	 * @generated
	 */
	EAttribute getPostalRouteName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalRouteName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteName#getAnyAttribute()
	 * @see #getPostalRouteName()
	 * @generated
	 */
	EAttribute getPostalRouteName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostalRouteNumber <em>Postal Route Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Route Number</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteNumber
	 * @generated
	 */
	EClass getPostalRouteNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalRouteNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteNumber#getMixed()
	 * @see #getPostalRouteNumber()
	 * @generated
	 */
	EAttribute getPostalRouteNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalRouteNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteNumber#getCode()
	 * @see #getPostalRouteNumber()
	 * @generated
	 */
	EAttribute getPostalRouteNumber_Code();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalRouteNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostalRouteNumber#getAnyAttribute()
	 * @see #getPostalRouteNumber()
	 * @generated
	 */
	EAttribute getPostalRouteNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostalServiceElements <em>Postal Service Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Service Elements</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements
	 * @generated
	 */
	EClass getPostalServiceElements();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressIdentifier <em>Address Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Identifier</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getAddressIdentifier()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_AddressIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalServiceElements#getEndorsementLineCode <em>Endorsement Line Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Endorsement Line Code</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getEndorsementLineCode()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_EndorsementLineCode();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalServiceElements#getKeyLineCode <em>Key Line Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key Line Code</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getKeyLineCode()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_KeyLineCode();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalServiceElements#getBarcode <em>Barcode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Barcode</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getBarcode()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_Barcode();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalServiceElements#getSortingCode <em>Sorting Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sorting Code</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getSortingCode()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_SortingCode();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLatitude <em>Address Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address Latitude</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getAddressLatitude()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_AddressLatitude();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLatitudeDirection <em>Address Latitude Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address Latitude Direction</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getAddressLatitudeDirection()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_AddressLatitudeDirection();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLongitude <em>Address Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address Longitude</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getAddressLongitude()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_AddressLongitude();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostalServiceElements#getAddressLongitudeDirection <em>Address Longitude Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address Longitude Direction</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getAddressLongitudeDirection()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_AddressLongitudeDirection();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostalServiceElements#getSupplementaryPostalServiceData <em>Supplementary Postal Service Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supplementary Postal Service Data</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getSupplementaryPostalServiceData()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EReference getPostalServiceElements_SupplementaryPostalServiceData();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalServiceElements#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getAny()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EAttribute getPostalServiceElements_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostalServiceElements#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getType()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EAttribute getPostalServiceElements_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostalServiceElements#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostalServiceElements#getAnyAttribute()
	 * @see #getPostalServiceElements()
	 * @generated
	 */
	EAttribute getPostalServiceElements_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostBox <em>Post Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Box</em>'.
	 * @see com.verticon.oasis.xal.PostBox
	 * @generated
	 */
	EClass getPostBox();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostBox#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getAddressLine()
	 * @see #getPostBox()
	 * @generated
	 */
	EReference getPostBox_AddressLine();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostBox#getPostBoxNumber <em>Post Box Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box Number</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getPostBoxNumber()
	 * @see #getPostBox()
	 * @generated
	 */
	EReference getPostBox_PostBoxNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostBox#getPostBoxNumberPrefix <em>Post Box Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getPostBoxNumberPrefix()
	 * @see #getPostBox()
	 * @generated
	 */
	EReference getPostBox_PostBoxNumberPrefix();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostBox#getPostBoxNumberSuffix <em>Post Box Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getPostBoxNumberSuffix()
	 * @see #getPostBox()
	 * @generated
	 */
	EReference getPostBox_PostBoxNumberSuffix();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostBox#getPostBoxNumberExtension <em>Post Box Number Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box Number Extension</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getPostBoxNumberExtension()
	 * @see #getPostBox()
	 * @generated
	 */
	EReference getPostBox_PostBoxNumberExtension();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostBox#getFirm <em>Firm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Firm</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getFirm()
	 * @see #getPostBox()
	 * @generated
	 */
	EReference getPostBox_Firm();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostBox#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getPostalCode()
	 * @see #getPostBox()
	 * @generated
	 */
	EReference getPostBox_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBox#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getAny()
	 * @see #getPostBox()
	 * @generated
	 */
	EAttribute getPostBox_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostBox#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getIndicator()
	 * @see #getPostBox()
	 * @generated
	 */
	EAttribute getPostBox_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostBox#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getType()
	 * @see #getPostBox()
	 * @generated
	 */
	EAttribute getPostBox_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBox#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostBox#getAnyAttribute()
	 * @see #getPostBox()
	 * @generated
	 */
	EAttribute getPostBox_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostBoxNumber <em>Post Box Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Box Number</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumber
	 * @generated
	 */
	EClass getPostBoxNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBoxNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumber#getMixed()
	 * @see #getPostBoxNumber()
	 * @generated
	 */
	EAttribute getPostBoxNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostBoxNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumber#getCode()
	 * @see #getPostBoxNumber()
	 * @generated
	 */
	EAttribute getPostBoxNumber_Code();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBoxNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumber#getAnyAttribute()
	 * @see #getPostBoxNumber()
	 * @generated
	 */
	EAttribute getPostBoxNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostBoxNumberExtension <em>Post Box Number Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Box Number Extension</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberExtension
	 * @generated
	 */
	EClass getPostBoxNumberExtension();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBoxNumberExtension#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberExtension#getMixed()
	 * @see #getPostBoxNumberExtension()
	 * @generated
	 */
	EAttribute getPostBoxNumberExtension_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostBoxNumberExtension#getNumberExtensionSeparator <em>Number Extension Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Extension Separator</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberExtension#getNumberExtensionSeparator()
	 * @see #getPostBoxNumberExtension()
	 * @generated
	 */
	EAttribute getPostBoxNumberExtension_NumberExtensionSeparator();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBoxNumberExtension#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberExtension#getAnyAttribute()
	 * @see #getPostBoxNumberExtension()
	 * @generated
	 */
	EAttribute getPostBoxNumberExtension_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostBoxNumberPrefix <em>Post Box Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Box Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberPrefix
	 * @generated
	 */
	EClass getPostBoxNumberPrefix();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberPrefix#getMixed()
	 * @see #getPostBoxNumberPrefix()
	 * @generated
	 */
	EAttribute getPostBoxNumberPrefix_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberPrefix#getCode()
	 * @see #getPostBoxNumberPrefix()
	 * @generated
	 */
	EAttribute getPostBoxNumberPrefix_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getNumberPrefixSeparator <em>Number Prefix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Prefix Separator</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberPrefix#getNumberPrefixSeparator()
	 * @see #getPostBoxNumberPrefix()
	 * @generated
	 */
	EAttribute getPostBoxNumberPrefix_NumberPrefixSeparator();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberPrefix#getAnyAttribute()
	 * @see #getPostBoxNumberPrefix()
	 * @generated
	 */
	EAttribute getPostBoxNumberPrefix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostBoxNumberSuffix <em>Post Box Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Box Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberSuffix
	 * @generated
	 */
	EClass getPostBoxNumberSuffix();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBoxNumberSuffix#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberSuffix#getMixed()
	 * @see #getPostBoxNumberSuffix()
	 * @generated
	 */
	EAttribute getPostBoxNumberSuffix_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostBoxNumberSuffix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberSuffix#getCode()
	 * @see #getPostBoxNumberSuffix()
	 * @generated
	 */
	EAttribute getPostBoxNumberSuffix_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostBoxNumberSuffix#getNumberSuffixSeparator <em>Number Suffix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Suffix Separator</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberSuffix#getNumberSuffixSeparator()
	 * @see #getPostBoxNumberSuffix()
	 * @generated
	 */
	EAttribute getPostBoxNumberSuffix_NumberSuffixSeparator();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostBoxNumberSuffix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostBoxNumberSuffix#getAnyAttribute()
	 * @see #getPostBoxNumberSuffix()
	 * @generated
	 */
	EAttribute getPostBoxNumberSuffix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostOffice <em>Post Office</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Office</em>'.
	 * @see com.verticon.oasis.xal.PostOffice
	 * @generated
	 */
	EClass getPostOffice();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostOffice#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getAddressLine()
	 * @see #getPostOffice()
	 * @generated
	 */
	EReference getPostOffice_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostOffice#getPostOfficeName <em>Post Office Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Post Office Name</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getPostOfficeName()
	 * @see #getPostOffice()
	 * @generated
	 */
	EReference getPostOffice_PostOfficeName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostOffice#getPostOfficeNumber <em>Post Office Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Office Number</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getPostOfficeNumber()
	 * @see #getPostOffice()
	 * @generated
	 */
	EReference getPostOffice_PostOfficeNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostOffice#getPostalRoute <em>Postal Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Route</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getPostalRoute()
	 * @see #getPostOffice()
	 * @generated
	 */
	EReference getPostOffice_PostalRoute();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostOffice#getPostBox <em>Post Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Box</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getPostBox()
	 * @see #getPostOffice()
	 * @generated
	 */
	EReference getPostOffice_PostBox();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostOffice#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getPostalCode()
	 * @see #getPostOffice()
	 * @generated
	 */
	EReference getPostOffice_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostOffice#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getAny()
	 * @see #getPostOffice()
	 * @generated
	 */
	EAttribute getPostOffice_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostOffice#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getIndicator()
	 * @see #getPostOffice()
	 * @generated
	 */
	EAttribute getPostOffice_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostOffice#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getType()
	 * @see #getPostOffice()
	 * @generated
	 */
	EAttribute getPostOffice_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostOffice#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostOffice#getAnyAttribute()
	 * @see #getPostOffice()
	 * @generated
	 */
	EAttribute getPostOffice_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostOfficeName <em>Post Office Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Office Name</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeName
	 * @generated
	 */
	EClass getPostOfficeName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostOfficeName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeName#getMixed()
	 * @see #getPostOfficeName()
	 * @generated
	 */
	EAttribute getPostOfficeName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostOfficeName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeName#getCode()
	 * @see #getPostOfficeName()
	 * @generated
	 */
	EAttribute getPostOfficeName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostOfficeName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeName#getType()
	 * @see #getPostOfficeName()
	 * @generated
	 */
	EAttribute getPostOfficeName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostOfficeName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeName#getAnyAttribute()
	 * @see #getPostOfficeName()
	 * @generated
	 */
	EAttribute getPostOfficeName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostOfficeNumber <em>Post Office Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Office Number</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeNumber
	 * @generated
	 */
	EClass getPostOfficeNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostOfficeNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeNumber#getMixed()
	 * @see #getPostOfficeNumber()
	 * @generated
	 */
	EAttribute getPostOfficeNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostOfficeNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeNumber#getCode()
	 * @see #getPostOfficeNumber()
	 * @generated
	 */
	EAttribute getPostOfficeNumber_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostOfficeNumber#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeNumber#getIndicator()
	 * @see #getPostOfficeNumber()
	 * @generated
	 */
	EAttribute getPostOfficeNumber_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostOfficeNumber#getIndicatorOccurrence <em>Indicator Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator Occurrence</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeNumber#getIndicatorOccurrence()
	 * @see #getPostOfficeNumber()
	 * @generated
	 */
	EAttribute getPostOfficeNumber_IndicatorOccurrence();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostOfficeNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostOfficeNumber#getAnyAttribute()
	 * @see #getPostOfficeNumber()
	 * @generated
	 */
	EAttribute getPostOfficeNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostTown <em>Post Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Town</em>'.
	 * @see com.verticon.oasis.xal.PostTown
	 * @generated
	 */
	EClass getPostTown();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostTown#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.PostTown#getAddressLine()
	 * @see #getPostTown()
	 * @generated
	 */
	EReference getPostTown_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PostTown#getPostTownName <em>Post Town Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Post Town Name</em>'.
	 * @see com.verticon.oasis.xal.PostTown#getPostTownName()
	 * @see #getPostTown()
	 * @generated
	 */
	EReference getPostTown_PostTownName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PostTown#getPostTownSuffix <em>Post Town Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Town Suffix</em>'.
	 * @see com.verticon.oasis.xal.PostTown#getPostTownSuffix()
	 * @see #getPostTown()
	 * @generated
	 */
	EReference getPostTown_PostTownSuffix();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostTown#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostTown#getType()
	 * @see #getPostTown()
	 * @generated
	 */
	EAttribute getPostTown_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostTown#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostTown#getAnyAttribute()
	 * @see #getPostTown()
	 * @generated
	 */
	EAttribute getPostTown_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostTownName <em>Post Town Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Town Name</em>'.
	 * @see com.verticon.oasis.xal.PostTownName
	 * @generated
	 */
	EClass getPostTownName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostTownName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostTownName#getMixed()
	 * @see #getPostTownName()
	 * @generated
	 */
	EAttribute getPostTownName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostTownName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostTownName#getCode()
	 * @see #getPostTownName()
	 * @generated
	 */
	EAttribute getPostTownName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostTownName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PostTownName#getType()
	 * @see #getPostTownName()
	 * @generated
	 */
	EAttribute getPostTownName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostTownName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostTownName#getAnyAttribute()
	 * @see #getPostTownName()
	 * @generated
	 */
	EAttribute getPostTownName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PostTownSuffix <em>Post Town Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Town Suffix</em>'.
	 * @see com.verticon.oasis.xal.PostTownSuffix
	 * @generated
	 */
	EClass getPostTownSuffix();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostTownSuffix#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PostTownSuffix#getMixed()
	 * @see #getPostTownSuffix()
	 * @generated
	 */
	EAttribute getPostTownSuffix_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PostTownSuffix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PostTownSuffix#getCode()
	 * @see #getPostTownSuffix()
	 * @generated
	 */
	EAttribute getPostTownSuffix_Code();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PostTownSuffix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PostTownSuffix#getAnyAttribute()
	 * @see #getPostTownSuffix()
	 * @generated
	 */
	EAttribute getPostTownSuffix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Premise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise</em>'.
	 * @see com.verticon.oasis.xal.Premise
	 * @generated
	 */
	EClass getPremise();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Premise#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.Premise#getAddressLine()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Premise#getPremiseName <em>Premise Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Name</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseName()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_PremiseName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Premise#getPremiseLocation <em>Premise Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise Location</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseLocation()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_PremiseLocation();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Premise#getPremiseNumber <em>Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseNumber()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_PremiseNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Premise#getPremiseNumberRange <em>Premise Number Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise Number Range</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseNumberRange()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_PremiseNumberRange();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Premise#getPremiseNumberPrefix <em>Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseNumberPrefix()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_PremiseNumberPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Premise#getPremiseNumberSuffix <em>Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseNumberSuffix()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_PremiseNumberSuffix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Premise#getBuildingName <em>Building Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Building Name</em>'.
	 * @see com.verticon.oasis.xal.Premise#getBuildingName()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_BuildingName();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Premise#getSubPremise <em>Sub Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Premise</em>'.
	 * @see com.verticon.oasis.xal.Premise#getSubPremise()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_SubPremise();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Premise#getFirm <em>Firm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Firm</em>'.
	 * @see com.verticon.oasis.xal.Premise#getFirm()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_Firm();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Premise#getMailStop <em>Mail Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mail Stop</em>'.
	 * @see com.verticon.oasis.xal.Premise#getMailStop()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_MailStop();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Premise#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPostalCode()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_PostalCode();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Premise#getPremise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremise()
	 * @see #getPremise()
	 * @generated
	 */
	EReference getPremise_Premise();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Premise#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.Premise#getAny()
	 * @see #getPremise()
	 * @generated
	 */
	EAttribute getPremise_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Premise#getPremiseDependency <em>Premise Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Premise Dependency</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseDependency()
	 * @see #getPremise()
	 * @generated
	 */
	EAttribute getPremise_PremiseDependency();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Premise#getPremiseDependencyType <em>Premise Dependency Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Premise Dependency Type</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseDependencyType()
	 * @see #getPremise()
	 * @generated
	 */
	EAttribute getPremise_PremiseDependencyType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Premise#getPremiseThoroughfareConnector <em>Premise Thoroughfare Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Premise Thoroughfare Connector</em>'.
	 * @see com.verticon.oasis.xal.Premise#getPremiseThoroughfareConnector()
	 * @see #getPremise()
	 * @generated
	 */
	EAttribute getPremise_PremiseThoroughfareConnector();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Premise#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.Premise#getType()
	 * @see #getPremise()
	 * @generated
	 */
	EAttribute getPremise_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Premise#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Premise#getAnyAttribute()
	 * @see #getPremise()
	 * @generated
	 */
	EAttribute getPremise_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PremiseLocation <em>Premise Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise Location</em>'.
	 * @see com.verticon.oasis.xal.PremiseLocation
	 * @generated
	 */
	EClass getPremiseLocation();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseLocation#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PremiseLocation#getMixed()
	 * @see #getPremiseLocation()
	 * @generated
	 */
	EAttribute getPremiseLocation_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseLocation#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PremiseLocation#getCode()
	 * @see #getPremiseLocation()
	 * @generated
	 */
	EAttribute getPremiseLocation_Code();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseLocation#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PremiseLocation#getAnyAttribute()
	 * @see #getPremiseLocation()
	 * @generated
	 */
	EAttribute getPremiseLocation_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PremiseName <em>Premise Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise Name</em>'.
	 * @see com.verticon.oasis.xal.PremiseName
	 * @generated
	 */
	EClass getPremiseName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PremiseName#getMixed()
	 * @see #getPremiseName()
	 * @generated
	 */
	EAttribute getPremiseName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PremiseName#getCode()
	 * @see #getPremiseName()
	 * @generated
	 */
	EAttribute getPremiseName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PremiseName#getType()
	 * @see #getPremiseName()
	 * @generated
	 */
	EAttribute getPremiseName_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseName#getTypeOccurrence <em>Type Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Occurrence</em>'.
	 * @see com.verticon.oasis.xal.PremiseName#getTypeOccurrence()
	 * @see #getPremiseName()
	 * @generated
	 */
	EAttribute getPremiseName_TypeOccurrence();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PremiseName#getAnyAttribute()
	 * @see #getPremiseName()
	 * @generated
	 */
	EAttribute getPremiseName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PremiseNumber <em>Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise Number</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber
	 * @generated
	 */
	EClass getPremiseNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber#getMixed()
	 * @see #getPremiseNumber()
	 * @generated
	 */
	EAttribute getPremiseNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber#getCode()
	 * @see #getPremiseNumber()
	 * @generated
	 */
	EAttribute getPremiseNumber_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumber#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber#getIndicator()
	 * @see #getPremiseNumber()
	 * @generated
	 */
	EAttribute getPremiseNumber_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumber#getIndicatorOccurrence <em>Indicator Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator Occurrence</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber#getIndicatorOccurrence()
	 * @see #getPremiseNumber()
	 * @generated
	 */
	EAttribute getPremiseNumber_IndicatorOccurrence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumber#getNumberType <em>Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Type</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber#getNumberType()
	 * @see #getPremiseNumber()
	 * @generated
	 */
	EAttribute getPremiseNumber_NumberType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumber#getNumberTypeOccurrence <em>Number Type Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Type Occurrence</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber#getNumberTypeOccurrence()
	 * @see #getPremiseNumber()
	 * @generated
	 */
	EAttribute getPremiseNumber_NumberTypeOccurrence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumber#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber#getType()
	 * @see #getPremiseNumber()
	 * @generated
	 */
	EAttribute getPremiseNumber_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumber#getAnyAttribute()
	 * @see #getPremiseNumber()
	 * @generated
	 */
	EAttribute getPremiseNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PremiseNumberPrefix <em>Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberPrefix
	 * @generated
	 */
	EClass getPremiseNumberPrefix();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberPrefix#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberPrefix#getValue()
	 * @see #getPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getPremiseNumberPrefix_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberPrefix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberPrefix#getCode()
	 * @see #getPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getPremiseNumberPrefix_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberPrefix#getNumberPrefixSeparator <em>Number Prefix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Prefix Separator</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberPrefix#getNumberPrefixSeparator()
	 * @see #getPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getPremiseNumberPrefix_NumberPrefixSeparator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberPrefix#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberPrefix#getType()
	 * @see #getPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getPremiseNumberPrefix_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseNumberPrefix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberPrefix#getAnyAttribute()
	 * @see #getPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getPremiseNumberPrefix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PremiseNumberRange <em>Premise Number Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise Number Range</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange
	 * @generated
	 */
	EClass getPremiseNumberRange();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PremiseNumberRange#getPremiseNumberRangeFrom <em>Premise Number Range From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise Number Range From</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange#getPremiseNumberRangeFrom()
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	EReference getPremiseNumberRange_PremiseNumberRangeFrom();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.PremiseNumberRange#getPremiseNumberRangeTo <em>Premise Number Range To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise Number Range To</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange#getPremiseNumberRangeTo()
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	EReference getPremiseNumberRange_PremiseNumberRangeTo();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberRange#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange#getIndicator()
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	EAttribute getPremiseNumberRange_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberRange#getIndicatorOccurence <em>Indicator Occurence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator Occurence</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange#getIndicatorOccurence()
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	EAttribute getPremiseNumberRange_IndicatorOccurence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberRange#getNumberRangeOccurence <em>Number Range Occurence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Range Occurence</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange#getNumberRangeOccurence()
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	EAttribute getPremiseNumberRange_NumberRangeOccurence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberRange#getRangeType <em>Range Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range Type</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange#getRangeType()
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	EAttribute getPremiseNumberRange_RangeType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberRange#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Separator</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange#getSeparator()
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	EAttribute getPremiseNumberRange_Separator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberRange#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRange#getType()
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	EAttribute getPremiseNumberRange_Type();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PremiseNumberRangeFrom <em>Premise Number Range From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise Number Range From</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeFrom
	 * @generated
	 */
	EClass getPremiseNumberRangeFrom();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PremiseNumberRangeFrom#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeFrom#getAddressLine()
	 * @see #getPremiseNumberRangeFrom()
	 * @generated
	 */
	EReference getPremiseNumberRangeFrom_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumberPrefix <em>Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumberPrefix()
	 * @see #getPremiseNumberRangeFrom()
	 * @generated
	 */
	EReference getPremiseNumberRangeFrom_PremiseNumberPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumber <em>Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumber()
	 * @see #getPremiseNumberRangeFrom()
	 * @generated
	 */
	EReference getPremiseNumberRangeFrom_PremiseNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumberSuffix <em>Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeFrom#getPremiseNumberSuffix()
	 * @see #getPremiseNumberRangeFrom()
	 * @generated
	 */
	EReference getPremiseNumberRangeFrom_PremiseNumberSuffix();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PremiseNumberRangeTo <em>Premise Number Range To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise Number Range To</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeTo
	 * @generated
	 */
	EClass getPremiseNumberRangeTo();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PremiseNumberRangeTo#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeTo#getAddressLine()
	 * @see #getPremiseNumberRangeTo()
	 * @generated
	 */
	EReference getPremiseNumberRangeTo_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PremiseNumberRangeTo#getPremiseNumberPrefix <em>Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeTo#getPremiseNumberPrefix()
	 * @see #getPremiseNumberRangeTo()
	 * @generated
	 */
	EReference getPremiseNumberRangeTo_PremiseNumberPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PremiseNumberRangeTo#getPremiseNumber <em>Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeTo#getPremiseNumber()
	 * @see #getPremiseNumberRangeTo()
	 * @generated
	 */
	EReference getPremiseNumberRangeTo_PremiseNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.PremiseNumberRangeTo#getPremiseNumberSuffix <em>Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Premise Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeTo#getPremiseNumberSuffix()
	 * @see #getPremiseNumberRangeTo()
	 * @generated
	 */
	EReference getPremiseNumberRangeTo_PremiseNumberSuffix();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.PremiseNumberSuffix <em>Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premise Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberSuffix
	 * @generated
	 */
	EClass getPremiseNumberSuffix();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseNumberSuffix#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberSuffix#getMixed()
	 * @see #getPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getPremiseNumberSuffix_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberSuffix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberSuffix#getCode()
	 * @see #getPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getPremiseNumberSuffix_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberSuffix#getNumberSuffixSeparator <em>Number Suffix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Suffix Separator</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberSuffix#getNumberSuffixSeparator()
	 * @see #getPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getPremiseNumberSuffix_NumberSuffixSeparator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.PremiseNumberSuffix#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberSuffix#getType()
	 * @see #getPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getPremiseNumberSuffix_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.PremiseNumberSuffix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.PremiseNumberSuffix#getAnyAttribute()
	 * @see #getPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getPremiseNumberSuffix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SortingCode <em>Sorting Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sorting Code</em>'.
	 * @see com.verticon.oasis.xal.SortingCode
	 * @generated
	 */
	EClass getSortingCode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SortingCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.SortingCode#getCode()
	 * @see #getSortingCode()
	 * @generated
	 */
	EAttribute getSortingCode_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SortingCode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SortingCode#getType()
	 * @see #getSortingCode()
	 * @generated
	 */
	EAttribute getSortingCode_Type();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SubAdministrativeArea <em>Sub Administrative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Administrative Area</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea
	 * @generated
	 */
	EClass getSubAdministrativeArea();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.SubAdministrativeArea#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getAddressLine()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EReference getSubAdministrativeArea_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.SubAdministrativeArea#getSubAdministrativeAreaName <em>Sub Administrative Area Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Administrative Area Name</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getSubAdministrativeAreaName()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EReference getSubAdministrativeArea_SubAdministrativeAreaName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.SubAdministrativeArea#getLocality <em>Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Locality</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getLocality()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EReference getSubAdministrativeArea_Locality();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.SubAdministrativeArea#getPostOffice <em>Post Office</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Office</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getPostOffice()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EReference getSubAdministrativeArea_PostOffice();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.SubAdministrativeArea#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getPostalCode()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EReference getSubAdministrativeArea_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubAdministrativeArea#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getAny()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EAttribute getSubAdministrativeArea_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubAdministrativeArea#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getIndicator()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EAttribute getSubAdministrativeArea_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubAdministrativeArea#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getType()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EAttribute getSubAdministrativeArea_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubAdministrativeArea#getUsageType <em>Usage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage Type</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getUsageType()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EAttribute getSubAdministrativeArea_UsageType();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubAdministrativeArea#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea#getAnyAttribute()
	 * @see #getSubAdministrativeArea()
	 * @generated
	 */
	EAttribute getSubAdministrativeArea_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SubAdministrativeAreaName <em>Sub Administrative Area Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Administrative Area Name</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeAreaName
	 * @generated
	 */
	EClass getSubAdministrativeAreaName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubAdministrativeAreaName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeAreaName#getMixed()
	 * @see #getSubAdministrativeAreaName()
	 * @generated
	 */
	EAttribute getSubAdministrativeAreaName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubAdministrativeAreaName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeAreaName#getCode()
	 * @see #getSubAdministrativeAreaName()
	 * @generated
	 */
	EAttribute getSubAdministrativeAreaName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubAdministrativeAreaName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeAreaName#getType()
	 * @see #getSubAdministrativeAreaName()
	 * @generated
	 */
	EAttribute getSubAdministrativeAreaName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubAdministrativeAreaName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.SubAdministrativeAreaName#getAnyAttribute()
	 * @see #getSubAdministrativeAreaName()
	 * @generated
	 */
	EAttribute getSubAdministrativeAreaName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SubPremise <em>Sub Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Premise</em>'.
	 * @see com.verticon.oasis.xal.SubPremise
	 * @generated
	 */
	EClass getSubPremise();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.SubPremise#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getAddressLine()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.SubPremise#getSubPremiseName <em>Sub Premise Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Premise Name</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getSubPremiseName()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_SubPremiseName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.SubPremise#getSubPremiseLocation <em>Sub Premise Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Premise Location</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getSubPremiseLocation()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_SubPremiseLocation();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.SubPremise#getSubPremiseNumber <em>Sub Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Premise Number</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getSubPremiseNumber()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_SubPremiseNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.SubPremise#getSubPremiseNumberPrefix <em>Sub Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Premise Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getSubPremiseNumberPrefix()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_SubPremiseNumberPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.SubPremise#getSubPremiseNumberSuffix <em>Sub Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Premise Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getSubPremiseNumberSuffix()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_SubPremiseNumberSuffix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.SubPremise#getBuildingName <em>Building Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Building Name</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getBuildingName()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_BuildingName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.SubPremise#getFirm <em>Firm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Firm</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getFirm()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_Firm();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.SubPremise#getMailStop <em>Mail Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mail Stop</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getMailStop()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_MailStop();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.SubPremise#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getPostalCode()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_PostalCode();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.SubPremise#getSubPremise <em>Sub Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Premise</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getSubPremise()
	 * @see #getSubPremise()
	 * @generated
	 */
	EReference getSubPremise_SubPremise();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremise#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getAny()
	 * @see #getSubPremise()
	 * @generated
	 */
	EAttribute getSubPremise_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremise#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getType()
	 * @see #getSubPremise()
	 * @generated
	 */
	EAttribute getSubPremise_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremise#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.SubPremise#getAnyAttribute()
	 * @see #getSubPremise()
	 * @generated
	 */
	EAttribute getSubPremise_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SubPremiseLocation <em>Sub Premise Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Premise Location</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseLocation
	 * @generated
	 */
	EClass getSubPremiseLocation();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseLocation#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseLocation#getMixed()
	 * @see #getSubPremiseLocation()
	 * @generated
	 */
	EAttribute getSubPremiseLocation_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseLocation#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseLocation#getCode()
	 * @see #getSubPremiseLocation()
	 * @generated
	 */
	EAttribute getSubPremiseLocation_Code();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SubPremiseName <em>Sub Premise Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Premise Name</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseName
	 * @generated
	 */
	EClass getSubPremiseName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseName#getMixed()
	 * @see #getSubPremiseName()
	 * @generated
	 */
	EAttribute getSubPremiseName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseName#getCode()
	 * @see #getSubPremiseName()
	 * @generated
	 */
	EAttribute getSubPremiseName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseName#getType()
	 * @see #getSubPremiseName()
	 * @generated
	 */
	EAttribute getSubPremiseName_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseName#getTypeOccurrence <em>Type Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Occurrence</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseName#getTypeOccurrence()
	 * @see #getSubPremiseName()
	 * @generated
	 */
	EAttribute getSubPremiseName_TypeOccurrence();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseName#getAnyAttribute()
	 * @see #getSubPremiseName()
	 * @generated
	 */
	EAttribute getSubPremiseName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SubPremiseNumber <em>Sub Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Premise Number</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber
	 * @generated
	 */
	EClass getSubPremiseNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber#getMixed()
	 * @see #getSubPremiseNumber()
	 * @generated
	 */
	EAttribute getSubPremiseNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber#getCode()
	 * @see #getSubPremiseNumber()
	 * @generated
	 */
	EAttribute getSubPremiseNumber_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumber#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber#getIndicator()
	 * @see #getSubPremiseNumber()
	 * @generated
	 */
	EAttribute getSubPremiseNumber_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumber#getIndicatorOccurrence <em>Indicator Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator Occurrence</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber#getIndicatorOccurrence()
	 * @see #getSubPremiseNumber()
	 * @generated
	 */
	EAttribute getSubPremiseNumber_IndicatorOccurrence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumber#getNumberTypeOccurrence <em>Number Type Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Type Occurrence</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber#getNumberTypeOccurrence()
	 * @see #getSubPremiseNumber()
	 * @generated
	 */
	EAttribute getSubPremiseNumber_NumberTypeOccurrence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumber#getPremiseNumberSeparator <em>Premise Number Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Premise Number Separator</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber#getPremiseNumberSeparator()
	 * @see #getSubPremiseNumber()
	 * @generated
	 */
	EAttribute getSubPremiseNumber_PremiseNumberSeparator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumber#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber#getType()
	 * @see #getSubPremiseNumber()
	 * @generated
	 */
	EAttribute getSubPremiseNumber_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumber#getAnyAttribute()
	 * @see #getSubPremiseNumber()
	 * @generated
	 */
	EAttribute getSubPremiseNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SubPremiseNumberPrefix <em>Sub Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Premise Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberPrefix
	 * @generated
	 */
	EClass getSubPremiseNumberPrefix();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseNumberPrefix#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberPrefix#getMixed()
	 * @see #getSubPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberPrefix_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumberPrefix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberPrefix#getCode()
	 * @see #getSubPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberPrefix_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumberPrefix#getNumberPrefixSeparator <em>Number Prefix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Prefix Separator</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberPrefix#getNumberPrefixSeparator()
	 * @see #getSubPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberPrefix_NumberPrefixSeparator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumberPrefix#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberPrefix#getType()
	 * @see #getSubPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberPrefix_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseNumberPrefix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberPrefix#getAnyAttribute()
	 * @see #getSubPremiseNumberPrefix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberPrefix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SubPremiseNumberSuffix <em>Sub Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Premise Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberSuffix
	 * @generated
	 */
	EClass getSubPremiseNumberSuffix();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseNumberSuffix#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberSuffix#getMixed()
	 * @see #getSubPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberSuffix_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumberSuffix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberSuffix#getCode()
	 * @see #getSubPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberSuffix_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumberSuffix#getNumberSuffixSeparator <em>Number Suffix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Suffix Separator</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberSuffix#getNumberSuffixSeparator()
	 * @see #getSubPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberSuffix_NumberSuffixSeparator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SubPremiseNumberSuffix#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberSuffix#getType()
	 * @see #getSubPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberSuffix_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SubPremiseNumberSuffix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.SubPremiseNumberSuffix#getAnyAttribute()
	 * @see #getSubPremiseNumberSuffix()
	 * @generated
	 */
	EAttribute getSubPremiseNumberSuffix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.SupplementaryPostalServiceData <em>Supplementary Postal Service Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplementary Postal Service Data</em>'.
	 * @see com.verticon.oasis.xal.SupplementaryPostalServiceData
	 * @generated
	 */
	EClass getSupplementaryPostalServiceData();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SupplementaryPostalServiceData#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.SupplementaryPostalServiceData#getMixed()
	 * @see #getSupplementaryPostalServiceData()
	 * @generated
	 */
	EAttribute getSupplementaryPostalServiceData_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SupplementaryPostalServiceData#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.SupplementaryPostalServiceData#getCode()
	 * @see #getSupplementaryPostalServiceData()
	 * @generated
	 */
	EAttribute getSupplementaryPostalServiceData_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.SupplementaryPostalServiceData#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.SupplementaryPostalServiceData#getType()
	 * @see #getSupplementaryPostalServiceData()
	 * @generated
	 */
	EAttribute getSupplementaryPostalServiceData_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.SupplementaryPostalServiceData#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.SupplementaryPostalServiceData#getAnyAttribute()
	 * @see #getSupplementaryPostalServiceData()
	 * @generated
	 */
	EAttribute getSupplementaryPostalServiceData_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Thoroughfare <em>Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare
	 * @generated
	 */
	EClass getThoroughfare();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Thoroughfare#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getAddressLine()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_AddressLine();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Thoroughfare#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getGroup()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EAttribute getThoroughfare_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumber <em>Thoroughfare Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumber()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfareNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberRange <em>Thoroughfare Number Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number Range</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberRange()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfareNumberRange();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberPrefix()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfareNumberPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberSuffix()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfareNumberSuffix();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Pre Direction</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfarePreDirection()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfarePreDirection();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Leading Type</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfareLeadingType()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfareLeadingType();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareName <em>Thoroughfare Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Name</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfareName()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfareName();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Trailing Type</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfareTrailingType()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfareTrailingType();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Post Direction</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getThoroughfarePostDirection()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_ThoroughfarePostDirection();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfare <em>Dependent Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependent Thoroughfare</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfare()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_DependentThoroughfare();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getDependentLocality <em>Dependent Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependent Locality</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getDependentLocality()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_DependentLocality();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getPremise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Premise</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getPremise()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_Premise();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getFirm <em>Firm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Firm</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getFirm()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_Firm();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.Thoroughfare#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Code</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getPostalCode()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EReference getThoroughfare_PostalCode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Thoroughfare#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getAny()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EAttribute getThoroughfare_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfares <em>Dependent Thoroughfares</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependent Thoroughfares</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfares()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EAttribute getThoroughfare_DependentThoroughfares();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresConnector <em>Dependent Thoroughfares Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependent Thoroughfares Connector</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresConnector()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EAttribute getThoroughfare_DependentThoroughfaresConnector();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresIndicator <em>Dependent Thoroughfares Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependent Thoroughfares Indicator</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresIndicator()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EAttribute getThoroughfare_DependentThoroughfaresIndicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresType <em>Dependent Thoroughfares Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependent Thoroughfares Type</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresType()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EAttribute getThoroughfare_DependentThoroughfaresType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Thoroughfare#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getType()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EAttribute getThoroughfare_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Thoroughfare#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Thoroughfare#getAnyAttribute()
	 * @see #getThoroughfare()
	 * @generated
	 */
	EAttribute getThoroughfare_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Leading Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareLeadingType
	 * @generated
	 */
	EClass getThoroughfareLeadingType();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareLeadingType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareLeadingType#getMixed()
	 * @see #getThoroughfareLeadingType()
	 * @generated
	 */
	EAttribute getThoroughfareLeadingType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareLeadingType#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareLeadingType#getCode()
	 * @see #getThoroughfareLeadingType()
	 * @generated
	 */
	EAttribute getThoroughfareLeadingType_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareLeadingType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareLeadingType#getType()
	 * @see #getThoroughfareLeadingType()
	 * @generated
	 */
	EAttribute getThoroughfareLeadingType_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareLeadingType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareLeadingType#getAnyAttribute()
	 * @see #getThoroughfareLeadingType()
	 * @generated
	 */
	EAttribute getThoroughfareLeadingType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareName <em>Thoroughfare Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Name</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareName
	 * @generated
	 */
	EClass getThoroughfareName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareName#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareName#getMixed()
	 * @see #getThoroughfareName()
	 * @generated
	 */
	EAttribute getThoroughfareName_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareName#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareName#getCode()
	 * @see #getThoroughfareName()
	 * @generated
	 */
	EAttribute getThoroughfareName_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareName#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareName#getType()
	 * @see #getThoroughfareName()
	 * @generated
	 */
	EAttribute getThoroughfareName_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareName#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareName#getAnyAttribute()
	 * @see #getThoroughfareName()
	 * @generated
	 */
	EAttribute getThoroughfareName_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareNumber <em>Thoroughfare Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Number</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber
	 * @generated
	 */
	EClass getThoroughfareNumber();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumber#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber#getMixed()
	 * @see #getThoroughfareNumber()
	 * @generated
	 */
	EAttribute getThoroughfareNumber_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumber#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber#getCode()
	 * @see #getThoroughfareNumber()
	 * @generated
	 */
	EAttribute getThoroughfareNumber_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumber#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber#getIndicator()
	 * @see #getThoroughfareNumber()
	 * @generated
	 */
	EAttribute getThoroughfareNumber_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumber#getIndicatorOccurrence <em>Indicator Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator Occurrence</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber#getIndicatorOccurrence()
	 * @see #getThoroughfareNumber()
	 * @generated
	 */
	EAttribute getThoroughfareNumber_IndicatorOccurrence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumber#getNumberOccurrence <em>Number Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Occurrence</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber#getNumberOccurrence()
	 * @see #getThoroughfareNumber()
	 * @generated
	 */
	EAttribute getThoroughfareNumber_NumberOccurrence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumber#getNumberType <em>Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber#getNumberType()
	 * @see #getThoroughfareNumber()
	 * @generated
	 */
	EAttribute getThoroughfareNumber_NumberType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumber#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber#getType()
	 * @see #getThoroughfareNumber()
	 * @generated
	 */
	EAttribute getThoroughfareNumber_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumber#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber#getAnyAttribute()
	 * @see #getThoroughfareNumber()
	 * @generated
	 */
	EAttribute getThoroughfareNumber_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom <em>Thoroughfare Number From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Number From</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom
	 * @generated
	 */
	EClass getThoroughfareNumberFrom();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom#getMixed()
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 */
	EAttribute getThoroughfareNumberFrom_Mixed();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom#getAddressLine()
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 */
	EReference getThoroughfareNumberFrom_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom#getThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom#getThoroughfareNumberPrefix()
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 */
	EReference getThoroughfareNumberFrom_ThoroughfareNumberPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom#getThoroughfareNumber <em>Thoroughfare Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom#getThoroughfareNumber()
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 */
	EReference getThoroughfareNumberFrom_ThoroughfareNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom#getThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom#getThoroughfareNumberSuffix()
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 */
	EReference getThoroughfareNumberFrom_ThoroughfareNumberSuffix();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom#getCode()
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 */
	EAttribute getThoroughfareNumberFrom_Code();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom#getAnyAttribute()
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 */
	EAttribute getThoroughfareNumberFrom_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberPrefix
	 * @generated
	 */
	EClass getThoroughfareNumberPrefix();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberPrefix#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberPrefix#getMixed()
	 * @see #getThoroughfareNumberPrefix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberPrefix_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberPrefix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberPrefix#getCode()
	 * @see #getThoroughfareNumberPrefix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberPrefix_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberPrefix#getNumberPrefixSeparator <em>Number Prefix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Prefix Separator</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberPrefix#getNumberPrefixSeparator()
	 * @see #getThoroughfareNumberPrefix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberPrefix_NumberPrefixSeparator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberPrefix#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberPrefix#getType()
	 * @see #getThoroughfareNumberPrefix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberPrefix_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberPrefix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberPrefix#getAnyAttribute()
	 * @see #getThoroughfareNumberPrefix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberPrefix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareNumberRange <em>Thoroughfare Number Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Number Range</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange
	 * @generated
	 */
	EClass getThoroughfareNumberRange();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getAddressLine()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EReference getThoroughfareNumberRange_AddressLine();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getThoroughfareNumberFrom <em>Thoroughfare Number From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Number From</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getThoroughfareNumberFrom()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EReference getThoroughfareNumberRange_ThoroughfareNumberFrom();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getThoroughfareNumberTo <em>Thoroughfare Number To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thoroughfare Number To</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getThoroughfareNumberTo()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EReference getThoroughfareNumberRange_ThoroughfareNumberTo();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getCode()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EAttribute getThoroughfareNumberRange_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicator <em>Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicator()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EAttribute getThoroughfareNumberRange_Indicator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicatorOccurrence <em>Indicator Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indicator Occurrence</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicatorOccurrence()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EAttribute getThoroughfareNumberRange_IndicatorOccurrence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getNumberRangeOccurrence <em>Number Range Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Range Occurrence</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getNumberRangeOccurrence()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EAttribute getThoroughfareNumberRange_NumberRangeOccurrence();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getRangeType <em>Range Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getRangeType()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EAttribute getThoroughfareNumberRange_RangeType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Separator</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getSeparator()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EAttribute getThoroughfareNumberRange_Separator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getType()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EAttribute getThoroughfareNumberRange_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange#getAnyAttribute()
	 * @see #getThoroughfareNumberRange()
	 * @generated
	 */
	EAttribute getThoroughfareNumberRange_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberSuffix
	 * @generated
	 */
	EClass getThoroughfareNumberSuffix();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberSuffix#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberSuffix#getMixed()
	 * @see #getThoroughfareNumberSuffix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberSuffix_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberSuffix#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberSuffix#getCode()
	 * @see #getThoroughfareNumberSuffix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberSuffix_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberSuffix#getNumberSuffixSeparator <em>Number Suffix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Suffix Separator</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberSuffix#getNumberSuffixSeparator()
	 * @see #getThoroughfareNumberSuffix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberSuffix_NumberSuffixSeparator();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberSuffix#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberSuffix#getType()
	 * @see #getThoroughfareNumberSuffix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberSuffix_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberSuffix#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberSuffix#getAnyAttribute()
	 * @see #getThoroughfareNumberSuffix()
	 * @generated
	 */
	EAttribute getThoroughfareNumberSuffix_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareNumberTo <em>Thoroughfare Number To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Number To</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo
	 * @generated
	 */
	EClass getThoroughfareNumberTo();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberTo#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo#getMixed()
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 */
	EAttribute getThoroughfareNumberTo_Mixed();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberTo#getAddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Line</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo#getAddressLine()
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 */
	EReference getThoroughfareNumberTo_AddressLine();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberTo#getThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number Prefix</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo#getThoroughfareNumberPrefix()
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 */
	EReference getThoroughfareNumberTo_ThoroughfareNumberPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberTo#getThoroughfareNumber <em>Thoroughfare Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo#getThoroughfareNumber()
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 */
	EReference getThoroughfareNumberTo_ThoroughfareNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.ThoroughfareNumberTo#getThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thoroughfare Number Suffix</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo#getThoroughfareNumberSuffix()
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 */
	EReference getThoroughfareNumberTo_ThoroughfareNumberSuffix();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareNumberTo#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo#getCode()
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 */
	EAttribute getThoroughfareNumberTo_Code();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareNumberTo#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo#getAnyAttribute()
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 */
	EAttribute getThoroughfareNumberTo_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Post Direction</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePostDirection
	 * @generated
	 */
	EClass getThoroughfarePostDirection();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfarePostDirection#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePostDirection#getMixed()
	 * @see #getThoroughfarePostDirection()
	 * @generated
	 */
	EAttribute getThoroughfarePostDirection_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfarePostDirection#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePostDirection#getCode()
	 * @see #getThoroughfarePostDirection()
	 * @generated
	 */
	EAttribute getThoroughfarePostDirection_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfarePostDirection#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePostDirection#getType()
	 * @see #getThoroughfarePostDirection()
	 * @generated
	 */
	EAttribute getThoroughfarePostDirection_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfarePostDirection#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePostDirection#getAnyAttribute()
	 * @see #getThoroughfarePostDirection()
	 * @generated
	 */
	EAttribute getThoroughfarePostDirection_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Pre Direction</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePreDirection
	 * @generated
	 */
	EClass getThoroughfarePreDirection();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfarePreDirection#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePreDirection#getMixed()
	 * @see #getThoroughfarePreDirection()
	 * @generated
	 */
	EAttribute getThoroughfarePreDirection_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfarePreDirection#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePreDirection#getCode()
	 * @see #getThoroughfarePreDirection()
	 * @generated
	 */
	EAttribute getThoroughfarePreDirection_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfarePreDirection#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePreDirection#getType()
	 * @see #getThoroughfarePreDirection()
	 * @generated
	 */
	EAttribute getThoroughfarePreDirection_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfarePreDirection#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfarePreDirection#getAnyAttribute()
	 * @see #getThoroughfarePreDirection()
	 * @generated
	 */
	EAttribute getThoroughfarePreDirection_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.ThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thoroughfare Trailing Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareTrailingType
	 * @generated
	 */
	EClass getThoroughfareTrailingType();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareTrailingType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareTrailingType#getMixed()
	 * @see #getThoroughfareTrailingType()
	 * @generated
	 */
	EAttribute getThoroughfareTrailingType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareTrailingType#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareTrailingType#getCode()
	 * @see #getThoroughfareTrailingType()
	 * @generated
	 */
	EAttribute getThoroughfareTrailingType_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.ThoroughfareTrailingType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareTrailingType#getType()
	 * @see #getThoroughfareTrailingType()
	 * @generated
	 */
	EAttribute getThoroughfareTrailingType_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.ThoroughfareTrailingType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.ThoroughfareTrailingType#getAnyAttribute()
	 * @see #getThoroughfareTrailingType()
	 * @generated
	 */
	EAttribute getThoroughfareTrailingType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link com.verticon.oasis.xal.Xal <em>Xal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xal</em>'.
	 * @see com.verticon.oasis.xal.Xal
	 * @generated
	 */
	EClass getXal();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.oasis.xal.Xal#getAddressDetails <em>Address Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address Details</em>'.
	 * @see com.verticon.oasis.xal.Xal#getAddressDetails()
	 * @see #getXal()
	 * @generated
	 */
	EReference getXal_AddressDetails();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Xal#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.verticon.oasis.xal.Xal#getAny()
	 * @see #getXal()
	 * @generated
	 */
	EAttribute getXal_Any();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.oasis.xal.Xal#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.verticon.oasis.xal.Xal#getVersion()
	 * @see #getXal()
	 * @generated
	 */
	EAttribute getXal_Version();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.oasis.xal.Xal#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see com.verticon.oasis.xal.Xal#getAnyAttribute()
	 * @see #getXal()
	 * @generated
	 */
	EAttribute getXal_AnyAttribute();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.DependentThoroughfaresType <em>Dependent Thoroughfares Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dependent Thoroughfares Type</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfaresType
	 * @generated
	 */
	EEnum getDependentThoroughfaresType();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.IndicatorOccurence <em>Indicator Occurence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Indicator Occurence</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurence
	 * @generated
	 */
	EEnum getIndicatorOccurence();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.IndicatorOccurrence <em>Indicator Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Indicator Occurrence</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence
	 * @generated
	 */
	EEnum getIndicatorOccurrence();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.IndicatorOccurrence1 <em>Indicator Occurrence1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Indicator Occurrence1</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence1
	 * @generated
	 */
	EEnum getIndicatorOccurrence1();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.IndicatorOccurrence2 <em>Indicator Occurrence2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Indicator Occurrence2</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence2
	 * @generated
	 */
	EEnum getIndicatorOccurrence2();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.IndicatorOccurrence3 <em>Indicator Occurrence3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Indicator Occurrence3</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence3
	 * @generated
	 */
	EEnum getIndicatorOccurrence3();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.IndicatorOccurrence4 <em>Indicator Occurrence4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Indicator Occurrence4</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence4
	 * @generated
	 */
	EEnum getIndicatorOccurrence4();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.NameNumberOccurrence <em>Name Number Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Name Number Occurrence</em>'.
	 * @see com.verticon.oasis.xal.NameNumberOccurrence
	 * @generated
	 */
	EEnum getNameNumberOccurrence();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.NumberOccurrence <em>Number Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Number Occurrence</em>'.
	 * @see com.verticon.oasis.xal.NumberOccurrence
	 * @generated
	 */
	EEnum getNumberOccurrence();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.NumberRangeOccurence <em>Number Range Occurence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Number Range Occurence</em>'.
	 * @see com.verticon.oasis.xal.NumberRangeOccurence
	 * @generated
	 */
	EEnum getNumberRangeOccurence();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.NumberRangeOccurrence <em>Number Range Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Number Range Occurrence</em>'.
	 * @see com.verticon.oasis.xal.NumberRangeOccurrence
	 * @generated
	 */
	EEnum getNumberRangeOccurrence();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.NumberTypeOccurrence <em>Number Type Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Number Type Occurrence</em>'.
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence
	 * @generated
	 */
	EEnum getNumberTypeOccurrence();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.NumberTypeOccurrence1 <em>Number Type Occurrence1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Number Type Occurrence1</em>'.
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence1
	 * @generated
	 */
	EEnum getNumberTypeOccurrence1();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.NumberTypeType <em>Number Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Number Type Type</em>'.
	 * @see com.verticon.oasis.xal.NumberTypeType
	 * @generated
	 */
	EEnum getNumberTypeType();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.NumberTypeType1 <em>Number Type Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Number Type Type1</em>'.
	 * @see com.verticon.oasis.xal.NumberTypeType1
	 * @generated
	 */
	EEnum getNumberTypeType1();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.RangeTypeType <em>Range Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Range Type Type</em>'.
	 * @see com.verticon.oasis.xal.RangeTypeType
	 * @generated
	 */
	EEnum getRangeTypeType();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.TypeOccurrence <em>Type Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Occurrence</em>'.
	 * @see com.verticon.oasis.xal.TypeOccurrence
	 * @generated
	 */
	EEnum getTypeOccurrence();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.TypeOccurrence1 <em>Type Occurrence1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Occurrence1</em>'.
	 * @see com.verticon.oasis.xal.TypeOccurrence1
	 * @generated
	 */
	EEnum getTypeOccurrence1();

	/**
	 * Returns the meta object for enum '{@link com.verticon.oasis.xal.TypeOccurrence2 <em>Type Occurrence2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Occurrence2</em>'.
	 * @see com.verticon.oasis.xal.TypeOccurrence2
	 * @generated
	 */
	EEnum getTypeOccurrence2();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.DependentThoroughfaresType <em>Dependent Thoroughfares Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dependent Thoroughfares Type Object</em>'.
	 * @see com.verticon.oasis.xal.DependentThoroughfaresType
	 * @model instanceClass="com.verticon.oasis.xal.DependentThoroughfaresType"
	 *        extendedMetaData="name='DependentThoroughfares_._type:Object' baseType='DependentThoroughfares_._type'"
	 * @generated
	 */
	EDataType getDependentThoroughfaresTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.IndicatorOccurence <em>Indicator Occurence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Indicator Occurence Object</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurence
	 * @model instanceClass="com.verticon.oasis.xal.IndicatorOccurence"
	 *        extendedMetaData="name='IndicatorOccurence_._type:Object' baseType='IndicatorOccurence_._type'"
	 * @generated
	 */
	EDataType getIndicatorOccurenceObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.IndicatorOccurrence1 <em>Indicator Occurrence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Indicator Occurrence Object</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence1
	 * @model instanceClass="com.verticon.oasis.xal.IndicatorOccurrence1"
	 *        extendedMetaData="name='IndicatorOccurrence_._1_._type:Object' baseType='IndicatorOccurrence_._1_._type'"
	 * @generated
	 */
	EDataType getIndicatorOccurrenceObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.IndicatorOccurrence3 <em>Indicator Occurrence Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Indicator Occurrence Object1</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence3
	 * @model instanceClass="com.verticon.oasis.xal.IndicatorOccurrence3"
	 *        extendedMetaData="name='IndicatorOccurrence_._3_._type:Object' baseType='IndicatorOccurrence_._3_._type'"
	 * @generated
	 */
	EDataType getIndicatorOccurrenceObject1();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.IndicatorOccurrence2 <em>Indicator Occurrence Object2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Indicator Occurrence Object2</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence2
	 * @model instanceClass="com.verticon.oasis.xal.IndicatorOccurrence2"
	 *        extendedMetaData="name='IndicatorOccurrence_._2_._type:Object' baseType='IndicatorOccurrence_._2_._type'"
	 * @generated
	 */
	EDataType getIndicatorOccurrenceObject2();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.IndicatorOccurrence <em>Indicator Occurrence Object3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Indicator Occurrence Object3</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence
	 * @model instanceClass="com.verticon.oasis.xal.IndicatorOccurrence"
	 *        extendedMetaData="name='IndicatorOccurrence_._type:Object' baseType='IndicatorOccurrence_._type'"
	 * @generated
	 */
	EDataType getIndicatorOccurrenceObject3();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.IndicatorOccurrence4 <em>Indicator Occurrence Object4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Indicator Occurrence Object4</em>'.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence4
	 * @model instanceClass="com.verticon.oasis.xal.IndicatorOccurrence4"
	 *        extendedMetaData="name='IndicatorOccurrence_._4_._type:Object' baseType='IndicatorOccurrence_._4_._type'"
	 * @generated
	 */
	EDataType getIndicatorOccurrenceObject4();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.NameNumberOccurrence <em>Name Number Occurrence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Name Number Occurrence Object</em>'.
	 * @see com.verticon.oasis.xal.NameNumberOccurrence
	 * @model instanceClass="com.verticon.oasis.xal.NameNumberOccurrence"
	 *        extendedMetaData="name='NameNumberOccurrence_._type:Object' baseType='NameNumberOccurrence_._type'"
	 * @generated
	 */
	EDataType getNameNumberOccurrenceObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.NumberOccurrence <em>Number Occurrence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number Occurrence Object</em>'.
	 * @see com.verticon.oasis.xal.NumberOccurrence
	 * @model instanceClass="com.verticon.oasis.xal.NumberOccurrence"
	 *        extendedMetaData="name='NumberOccurrence_._type:Object' baseType='NumberOccurrence_._type'"
	 * @generated
	 */
	EDataType getNumberOccurrenceObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.NumberRangeOccurence <em>Number Range Occurence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number Range Occurence Object</em>'.
	 * @see com.verticon.oasis.xal.NumberRangeOccurence
	 * @model instanceClass="com.verticon.oasis.xal.NumberRangeOccurence"
	 *        extendedMetaData="name='NumberRangeOccurence_._type:Object' baseType='NumberRangeOccurence_._type'"
	 * @generated
	 */
	EDataType getNumberRangeOccurenceObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.NumberRangeOccurrence <em>Number Range Occurrence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number Range Occurrence Object</em>'.
	 * @see com.verticon.oasis.xal.NumberRangeOccurrence
	 * @model instanceClass="com.verticon.oasis.xal.NumberRangeOccurrence"
	 *        extendedMetaData="name='NumberRangeOccurrence_._type:Object' baseType='NumberRangeOccurrence_._type'"
	 * @generated
	 */
	EDataType getNumberRangeOccurrenceObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.NumberTypeOccurrence <em>Number Type Occurrence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number Type Occurrence Object</em>'.
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence
	 * @model instanceClass="com.verticon.oasis.xal.NumberTypeOccurrence"
	 *        extendedMetaData="name='NumberTypeOccurrence_._type:Object' baseType='NumberTypeOccurrence_._type'"
	 * @generated
	 */
	EDataType getNumberTypeOccurrenceObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.NumberTypeOccurrence1 <em>Number Type Occurrence Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number Type Occurrence Object1</em>'.
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence1
	 * @model instanceClass="com.verticon.oasis.xal.NumberTypeOccurrence1"
	 *        extendedMetaData="name='NumberTypeOccurrence_._1_._type:Object' baseType='NumberTypeOccurrence_._1_._type'"
	 * @generated
	 */
	EDataType getNumberTypeOccurrenceObject1();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.NumberTypeType <em>Number Type Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number Type Type Object</em>'.
	 * @see com.verticon.oasis.xal.NumberTypeType
	 * @model instanceClass="com.verticon.oasis.xal.NumberTypeType"
	 *        extendedMetaData="name='NumberType_._type:Object' baseType='NumberType_._type'"
	 * @generated
	 */
	EDataType getNumberTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.NumberTypeType1 <em>Number Type Type Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number Type Type Object1</em>'.
	 * @see com.verticon.oasis.xal.NumberTypeType1
	 * @model instanceClass="com.verticon.oasis.xal.NumberTypeType1"
	 *        extendedMetaData="name='NumberType_._1_._type:Object' baseType='NumberType_._1_._type'"
	 * @generated
	 */
	EDataType getNumberTypeTypeObject1();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.RangeTypeType <em>Range Type Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Range Type Type Object</em>'.
	 * @see com.verticon.oasis.xal.RangeTypeType
	 * @model instanceClass="com.verticon.oasis.xal.RangeTypeType"
	 *        extendedMetaData="name='RangeType_._type:Object' baseType='RangeType_._type'"
	 * @generated
	 */
	EDataType getRangeTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.TypeOccurrence <em>Type Occurrence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Occurrence Object</em>'.
	 * @see com.verticon.oasis.xal.TypeOccurrence
	 * @model instanceClass="com.verticon.oasis.xal.TypeOccurrence"
	 *        extendedMetaData="name='TypeOccurrence_._type:Object' baseType='TypeOccurrence_._type'"
	 * @generated
	 */
	EDataType getTypeOccurrenceObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.TypeOccurrence1 <em>Type Occurrence Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Occurrence Object1</em>'.
	 * @see com.verticon.oasis.xal.TypeOccurrence1
	 * @model instanceClass="com.verticon.oasis.xal.TypeOccurrence1"
	 *        extendedMetaData="name='TypeOccurrence_._1_._type:Object' baseType='TypeOccurrence_._1_._type'"
	 * @generated
	 */
	EDataType getTypeOccurrenceObject1();

	/**
	 * Returns the meta object for data type '{@link com.verticon.oasis.xal.TypeOccurrence2 <em>Type Occurrence Object2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Occurrence Object2</em>'.
	 * @see com.verticon.oasis.xal.TypeOccurrence2
	 * @model instanceClass="com.verticon.oasis.xal.TypeOccurrence2"
	 *        extendedMetaData="name='TypeOccurrence_._2_._type:Object' baseType='TypeOccurrence_._2_._type'"
	 * @generated
	 */
	EDataType getTypeOccurrenceObject2();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XalFactory getXalFactory();

} //XalPackage
