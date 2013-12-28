/**
 */
package org.usaha.ecvi;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 *             (c) Copyright 2012-2013 Trace First Limited.
 *             All rights reserved.
 *             http://www.tracefirst.com/
 *         
 * This XML Schema is Copyright © Trace First Limited and is made available under their XML Schema Public License v1. This license is accessible at http://www.statevet.com/xml/public-license-v1.pdf
 * <!-- end-model-doc -->
 * @see org.usaha.ecvi.EcviFactory
 * @model kind="package"
 * @generated
 */
public interface EcviPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ecvi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.usaha.org/xmlns/ecvi";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ecvi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcviPackage eINSTANCE = org.usaha.ecvi.impl.EcviPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.AccessionImpl <em>Accession</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.AccessionImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAccession()
	 * @generated
	 */
	int ACCESSION = 0;

	/**
	 * The feature id for the '<em><b>Laboratory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSION__LABORATORY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSION__ID = 1;

	/**
	 * The feature id for the '<em><b>Infield Test</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSION__INFIELD_TEST = 2;

	/**
	 * The number of structural features of the '<em>Accession</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Accession</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.AccessionsImpl <em>Accessions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.AccessionsImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAccessions()
	 * @generated
	 */
	int ACCESSIONS = 1;

	/**
	 * The feature id for the '<em><b>Accession</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIONS__ACCESSION = 0;

	/**
	 * The number of structural features of the '<em>Accessions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Accessions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.AddressImpl <em>Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.AddressImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAddress()
	 * @generated
	 */
	int ADDRESS = 2;

	/**
	 * The feature id for the '<em><b>Line1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__LINE1 = 0;

	/**
	 * The feature id for the '<em><b>Line2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__LINE2 = 1;

	/**
	 * The feature id for the '<em><b>Town</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__TOWN = 2;

	/**
	 * The feature id for the '<em><b>County</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__COUNTY = 3;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__STATE = 4;

	/**
	 * The feature id for the '<em><b>ZIP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__ZIP = 5;

	/**
	 * The feature id for the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__COUNTRY = 6;

	/**
	 * The feature id for the '<em><b>Geo Point</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__GEO_POINT = 7;

	/**
	 * The number of structural features of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.AnimalImpl <em>Animal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.AnimalImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAnimal()
	 * @generated
	 */
	int ANIMAL = 3;

	/**
	 * The feature id for the '<em><b>Animal Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__ANIMAL_TAG = 0;

	/**
	 * The feature id for the '<em><b>Test</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__TEST = 1;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__AGE = 2;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__BREED = 3;

	/**
	 * The feature id for the '<em><b>Inspection Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__INSPECTION_DATE = 4;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SEX = 5;

	/**
	 * The feature id for the '<em><b>Sex Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SEX_DETAIL = 6;

	/**
	 * The number of structural features of the '<em>Animal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Animal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.AnimalTagImpl <em>Animal Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.AnimalTagImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAnimalTag()
	 * @generated
	 */
	int ANIMAL_TAG = 4;

	/**
	 * The feature id for the '<em><b>Brand Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_TAG__BRAND_IMAGE = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_TAG__NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_TAG__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Animal Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_TAG_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Animal Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_TAG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.AttachementImpl <em>Attachement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.AttachementImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAttachement()
	 * @generated
	 */
	int ATTACHEMENT = 5;

	/**
	 * The feature id for the '<em><b>Payload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT__PAYLOAD = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Doc Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT__DOC_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT__FILENAME = 3;

	/**
	 * The feature id for the '<em><b>Mime Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT__MIME_TYPE = 4;

	/**
	 * The number of structural features of the '<em>Attachement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Attachement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.ContactImpl <em>Contact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.ContactImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getContact()
	 * @generated
	 */
	int CONTACT = 6;

	/**
	 * The feature id for the '<em><b>Prem Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__PREM_ID = 0;

	/**
	 * The feature id for the '<em><b>Prem Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__PREM_NAME = 1;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__ADDRESS = 2;

	/**
	 * The feature id for the '<em><b>Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__PERSON = 3;

	/**
	 * The number of structural features of the '<em>Contact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Contact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.DocumentRootImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 7;

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
	 * The feature id for the '<em><b>ECVI</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ECVI = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.EcviImpl <em>Ecvi</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.EcviImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getEcvi()
	 * @generated
	 */
	int ECVI = 8;

	/**
	 * The feature id for the '<em><b>Veterinarian</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__VETERINARIAN = 0;

	/**
	 * The feature id for the '<em><b>Movement Purposes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__MOVEMENT_PURPOSES = 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__ORIGIN = 2;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__DESTINATION = 3;

	/**
	 * The feature id for the '<em><b>Consignor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__CONSIGNOR = 4;

	/**
	 * The feature id for the '<em><b>Consignee</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__CONSIGNEE = 5;

	/**
	 * The feature id for the '<em><b>Accessions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__ACCESSIONS = 6;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__GROUP = 7;

	/**
	 * The feature id for the '<em><b>Animal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__ANIMAL = 8;

	/**
	 * The feature id for the '<em><b>Group1</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__GROUP1 = 9;

	/**
	 * The feature id for the '<em><b>Group Lot</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__GROUP_LOT = 10;

	/**
	 * The feature id for the '<em><b>Attachment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__ATTACHMENT = 11;

	/**
	 * The feature id for the '<em><b>Cvi Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__CVI_NUMBER = 12;

	/**
	 * The feature id for the '<em><b>Entry Permit Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__ENTRY_PERMIT_NUMBER = 13;

	/**
	 * The feature id for the '<em><b>Expiration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__EXPIRATION_DATE = 14;

	/**
	 * The feature id for the '<em><b>Issue Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__ISSUE_DATE = 15;

	/**
	 * The feature id for the '<em><b>Shipment Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__SHIPMENT_DATE = 16;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI__SPECIES_CODE = 17;

	/**
	 * The number of structural features of the '<em>Ecvi</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI_FEATURE_COUNT = 18;

	/**
	 * The number of operations of the '<em>Ecvi</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECVI_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.GeoPointImpl <em>Geo Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.GeoPointImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getGeoPoint()
	 * @generated
	 */
	int GEO_POINT = 9;

	/**
	 * The feature id for the '<em><b>Lat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_POINT__LAT = 0;

	/**
	 * The feature id for the '<em><b>Lng</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_POINT__LNG = 1;

	/**
	 * The number of structural features of the '<em>Geo Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_POINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Geo Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.GroupLotImpl <em>Group Lot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.GroupLotImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getGroupLot()
	 * @generated
	 */
	int GROUP_LOT = 10;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT__AGE = 0;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT__BREED = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT__QUANTITY = 3;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT__SEX = 4;

	/**
	 * The feature id for the '<em><b>Sex Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT__SEX_DETAIL = 5;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT__SPECIES = 6;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT__UNIT = 7;

	/**
	 * The number of structural features of the '<em>Group Lot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Group Lot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_LOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.LaboratoryImpl <em>Laboratory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.LaboratoryImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getLaboratory()
	 * @generated
	 */
	int LABORATORY = 11;

	/**
	 * The feature id for the '<em><b>Lab Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABORATORY__LAB_NAME = 0;

	/**
	 * The feature id for the '<em><b>Prem Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABORATORY__PREM_ID = 1;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABORATORY__ADDRESS = 2;

	/**
	 * The feature id for the '<em><b>Accession Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABORATORY__ACCESSION_DATE = 3;

	/**
	 * The feature id for the '<em><b>Accession Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABORATORY__ACCESSION_NUMBER = 4;

	/**
	 * The number of structural features of the '<em>Laboratory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABORATORY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Laboratory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABORATORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.MovementPurposesImpl <em>Movement Purposes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.MovementPurposesImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getMovementPurposes()
	 * @generated
	 */
	int MOVEMENT_PURPOSES = 12;

	/**
	 * The feature id for the '<em><b>Movement Purpose</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVEMENT_PURPOSES__MOVEMENT_PURPOSE = 0;

	/**
	 * The number of structural features of the '<em>Movement Purposes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVEMENT_PURPOSES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Movement Purposes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVEMENT_PURPOSES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.PersonImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 0;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PHONE = 1;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.PhoneNumImpl <em>Phone Num</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.PhoneNumImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneNum()
	 * @generated
	 */
	int PHONE_NUM = 14;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHONE_NUM__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHONE_NUM__NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHONE_NUM__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Phone Num</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHONE_NUM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Phone Num</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHONE_NUM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.PremisesImpl <em>Premises</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.PremisesImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPremises()
	 * @generated
	 */
	int PREMISES = 15;

	/**
	 * The feature id for the '<em><b>Prem Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__PREM_ID = 0;

	/**
	 * The feature id for the '<em><b>Prem Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__PREM_NAME = 1;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__ADDRESS = 2;

	/**
	 * The feature id for the '<em><b>Program Status</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__PROGRAM_STATUS = 3;

	/**
	 * The feature id for the '<em><b>Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__PERSON = 4;

	/**
	 * The number of structural features of the '<em>Premises</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Premises</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.ProgramStatusImpl <em>Program Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.ProgramStatusImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatus()
	 * @generated
	 */
	int PROGRAM_STATUS = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_STATUS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_STATUS__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Value Other</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_STATUS__VALUE_OTHER = 2;

	/**
	 * The number of structural features of the '<em>Program Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_STATUS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Program Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_STATUS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.ResultValueImpl <em>Result Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.ResultValueImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getResultValue()
	 * @generated
	 */
	int RESULT_VALUE = 17;

	/**
	 * The feature id for the '<em><b>Result Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_VALUE__RESULT_INTEGER = 0;

	/**
	 * The feature id for the '<em><b>Result String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_VALUE__RESULT_STRING = 1;

	/**
	 * The feature id for the '<em><b>Result Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_VALUE__RESULT_FLOAT = 2;

	/**
	 * The feature id for the '<em><b>Result Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_VALUE__RESULT_NAME = 3;

	/**
	 * The number of structural features of the '<em>Result Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_VALUE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Result Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.TestImpl <em>Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.TestImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getTest()
	 * @generated
	 */
	int TEST = 18;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__RESULT = 0;

	/**
	 * The feature id for the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__IDREF = 1;

	/**
	 * The feature id for the '<em><b>Test Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__TEST_CODE = 2;

	/**
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.impl.VeterinarianImpl <em>Veterinarian</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.impl.VeterinarianImpl
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getVeterinarian()
	 * @generated
	 */
	int VETERINARIAN = 19;

	/**
	 * The feature id for the '<em><b>Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VETERINARIAN__PERSON = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VETERINARIAN__ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>License Issue State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VETERINARIAN__LICENSE_ISSUE_STATE = 2;

	/**
	 * The feature id for the '<em><b>License Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VETERINARIAN__LICENSE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>National Accreditation Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VETERINARIAN__NATIONAL_ACCREDITATION_NUMBER = 4;

	/**
	 * The number of structural features of the '<em>Veterinarian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VETERINARIAN_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Veterinarian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VETERINARIAN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.DocType <em>Doc Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.DocType
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getDocType()
	 * @generated
	 */
	int DOC_TYPE = 20;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.ISO3166Country <em>ISO3166 Country</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.ISO3166Country
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getISO3166Country()
	 * @generated
	 */
	int ISO3166_COUNTRY = 21;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.MovementPurpose <em>Movement Purpose</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.MovementPurpose
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getMovementPurpose()
	 * @generated
	 */
	int MOVEMENT_PURPOSE = 22;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.PhoneDevice <em>Phone Device</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.PhoneDevice
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneDevice()
	 * @generated
	 */
	int PHONE_DEVICE = 23;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.ProgramStatusName <em>Program Status Name</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.ProgramStatusName
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatusName()
	 * @generated
	 */
	int PROGRAM_STATUS_NAME = 24;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.ProgramStatusValue <em>Program Status Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.ProgramStatusValue
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatusValue()
	 * @generated
	 */
	int PROGRAM_STATUS_VALUE = 25;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.ResultName <em>Result Name</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.ResultName
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getResultName()
	 * @generated
	 */
	int RESULT_NAME = 26;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.Sex <em>Sex</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.Sex
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getSex()
	 * @generated
	 */
	int SEX = 27;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.SpeciesCode <em>Species Code</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.SpeciesCode
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getSpeciesCode()
	 * @generated
	 */
	int SPECIES_CODE = 28;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.TagType <em>Tag Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.TagType
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getTagType()
	 * @generated
	 */
	int TAG_TYPE = 29;

	/**
	 * The meta object id for the '{@link org.usaha.ecvi.UsState <em>Us State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.UsState
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getUsState()
	 * @generated
	 */
	int US_STATE = 30;

	/**
	 * The meta object id for the '<em>Address Line1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAddressLine1()
	 * @generated
	 */
	int ADDRESS_LINE1 = 31;

	/**
	 * The meta object id for the '<em>Address Line2</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAddressLine2()
	 * @generated
	 */
	int ADDRESS_LINE2 = 32;

	/**
	 * The meta object id for the '<em>Age</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAge()
	 * @generated
	 */
	int AGE = 33;

	/**
	 * The meta object id for the '<em>Animal Sex Detail</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAnimalSexDetail()
	 * @generated
	 */
	int ANIMAL_SEX_DETAIL = 34;

	/**
	 * The meta object id for the '<em>Attachement Comment</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAttachementComment()
	 * @generated
	 */
	int ATTACHEMENT_COMMENT = 35;

	/**
	 * The meta object id for the '<em>Breed</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getBreed()
	 * @generated
	 */
	int BREED = 36;

	/**
	 * The meta object id for the '<em>County</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getCounty()
	 * @generated
	 */
	int COUNTY = 37;

	/**
	 * The meta object id for the '<em>Cvi Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getCviNumber()
	 * @generated
	 */
	int CVI_NUMBER = 38;

	/**
	 * The meta object id for the '<em>Doc Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.DocType
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getDocTypeObject()
	 * @generated
	 */
	int DOC_TYPE_OBJECT = 39;

	/**
	 * The meta object id for the '<em>Entry Permit Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getEntryPermitNumber()
	 * @generated
	 */
	int ENTRY_PERMIT_NUMBER = 40;

	/**
	 * The meta object id for the '<em>File Name</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getFileName()
	 * @generated
	 */
	int FILE_NAME = 41;

	/**
	 * The meta object id for the '<em>Group Lot Description</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getGroupLotDescription()
	 * @generated
	 */
	int GROUP_LOT_DESCRIPTION = 42;

	/**
	 * The meta object id for the '<em>Group Lot Sex Detail</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getGroupLotSexDetail()
	 * @generated
	 */
	int GROUP_LOT_SEX_DETAIL = 43;

	/**
	 * The meta object id for the '<em>ISO3166 Country Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.ISO3166Country
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getISO3166CountryObject()
	 * @generated
	 */
	int ISO3166_COUNTRY_OBJECT = 44;

	/**
	 * The meta object id for the '<em>Latitude</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigDecimal
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getLatitude()
	 * @generated
	 */
	int LATITUDE = 45;

	/**
	 * The meta object id for the '<em>Longitude</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigDecimal
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getLongitude()
	 * @generated
	 */
	int LONGITUDE = 46;

	/**
	 * The meta object id for the '<em>Mime Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getMimeType()
	 * @generated
	 */
	int MIME_TYPE = 47;

	/**
	 * The meta object id for the '<em>Movement Purpose Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.MovementPurpose
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getMovementPurposeObject()
	 * @generated
	 */
	int MOVEMENT_PURPOSE_OBJECT = 48;

	/**
	 * The meta object id for the '<em>Phone Device Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.PhoneDevice
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneDeviceObject()
	 * @generated
	 */
	int PHONE_DEVICE_OBJECT = 49;

	/**
	 * The meta object id for the '<em>Phone Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneNumber()
	 * @generated
	 */
	int PHONE_NUMBER = 50;

	/**
	 * The meta object id for the '<em>Phone Num Comment</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneNumComment()
	 * @generated
	 */
	int PHONE_NUM_COMMENT = 51;

	/**
	 * The meta object id for the '<em>Phone Num Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneNumNumber()
	 * @generated
	 */
	int PHONE_NUM_NUMBER = 52;

	/**
	 * The meta object id for the '<em>Prem Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPremId()
	 * @generated
	 */
	int PREM_ID = 53;

	/**
	 * The meta object id for the '<em>Program Status Name Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.ProgramStatusName
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatusNameObject()
	 * @generated
	 */
	int PROGRAM_STATUS_NAME_OBJECT = 54;

	/**
	 * The meta object id for the '<em>Program Status Value Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.ProgramStatusValue
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatusValueObject()
	 * @generated
	 */
	int PROGRAM_STATUS_VALUE_OBJECT = 55;

	/**
	 * The meta object id for the '<em>Result Name Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.ResultName
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getResultNameObject()
	 * @generated
	 */
	int RESULT_NAME_OBJECT = 56;

	/**
	 * The meta object id for the '<em>Sex Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.Sex
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getSexObject()
	 * @generated
	 */
	int SEX_OBJECT = 57;

	/**
	 * The meta object id for the '<em>Species Code Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.SpeciesCode
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getSpeciesCodeObject()
	 * @generated
	 */
	int SPECIES_CODE_OBJECT = 58;

	/**
	 * The meta object id for the '<em>Tag Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.TagType
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getTagTypeObject()
	 * @generated
	 */
	int TAG_TYPE_OBJECT = 59;

	/**
	 * The meta object id for the '<em>Town</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getTown()
	 * @generated
	 */
	int TOWN = 60;

	/**
	 * The meta object id for the '<em>Us State Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.usaha.ecvi.UsState
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getUsStateObject()
	 * @generated
	 */
	int US_STATE_OBJECT = 61;

	/**
	 * The meta object id for the '<em>Zip Code</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.usaha.ecvi.impl.EcviPackageImpl#getZipCode()
	 * @generated
	 */
	int ZIP_CODE = 62;


	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Accession <em>Accession</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Accession</em>'.
	 * @see org.usaha.ecvi.Accession
	 * @generated
	 */
	EClass getAccession();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Accession#getLaboratory <em>Laboratory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Laboratory</em>'.
	 * @see org.usaha.ecvi.Accession#getLaboratory()
	 * @see #getAccession()
	 * @generated
	 */
	EReference getAccession_Laboratory();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Accession#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.usaha.ecvi.Accession#getId()
	 * @see #getAccession()
	 * @generated
	 */
	EAttribute getAccession_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Accession#isInfieldTest <em>Infield Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infield Test</em>'.
	 * @see org.usaha.ecvi.Accession#isInfieldTest()
	 * @see #getAccession()
	 * @generated
	 */
	EAttribute getAccession_InfieldTest();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Accessions <em>Accessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Accessions</em>'.
	 * @see org.usaha.ecvi.Accessions
	 * @generated
	 */
	EClass getAccessions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Accessions#getAccession <em>Accession</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Accession</em>'.
	 * @see org.usaha.ecvi.Accessions#getAccession()
	 * @see #getAccessions()
	 * @generated
	 */
	EReference getAccessions_Accession();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address</em>'.
	 * @see org.usaha.ecvi.Address
	 * @generated
	 */
	EClass getAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Address#getLine1 <em>Line1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line1</em>'.
	 * @see org.usaha.ecvi.Address#getLine1()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Line1();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Address#getLine2 <em>Line2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line2</em>'.
	 * @see org.usaha.ecvi.Address#getLine2()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Line2();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Address#getTown <em>Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Town</em>'.
	 * @see org.usaha.ecvi.Address#getTown()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Town();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Address#getCounty <em>County</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>County</em>'.
	 * @see org.usaha.ecvi.Address#getCounty()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_County();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Address#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.usaha.ecvi.Address#getState()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_State();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Address#getZIP <em>ZIP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ZIP</em>'.
	 * @see org.usaha.ecvi.Address#getZIP()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_ZIP();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Address#getCountry <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Country</em>'.
	 * @see org.usaha.ecvi.Address#getCountry()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Country();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Address#getGeoPoint <em>Geo Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Geo Point</em>'.
	 * @see org.usaha.ecvi.Address#getGeoPoint()
	 * @see #getAddress()
	 * @generated
	 */
	EReference getAddress_GeoPoint();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Animal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animal</em>'.
	 * @see org.usaha.ecvi.Animal
	 * @generated
	 */
	EClass getAnimal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Animal#getAnimalTag <em>Animal Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animal Tag</em>'.
	 * @see org.usaha.ecvi.Animal#getAnimalTag()
	 * @see #getAnimal()
	 * @generated
	 */
	EReference getAnimal_AnimalTag();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Animal#getTest <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test</em>'.
	 * @see org.usaha.ecvi.Animal#getTest()
	 * @see #getAnimal()
	 * @generated
	 */
	EReference getAnimal_Test();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Animal#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see org.usaha.ecvi.Animal#getAge()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Age();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Animal#getBreed <em>Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breed</em>'.
	 * @see org.usaha.ecvi.Animal#getBreed()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Breed();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Animal#getInspectionDate <em>Inspection Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inspection Date</em>'.
	 * @see org.usaha.ecvi.Animal#getInspectionDate()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_InspectionDate();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Animal#getSex <em>Sex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sex</em>'.
	 * @see org.usaha.ecvi.Animal#getSex()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Sex();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Animal#getSexDetail <em>Sex Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sex Detail</em>'.
	 * @see org.usaha.ecvi.Animal#getSexDetail()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_SexDetail();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.AnimalTag <em>Animal Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animal Tag</em>'.
	 * @see org.usaha.ecvi.AnimalTag
	 * @generated
	 */
	EClass getAnimalTag();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.AnimalTag#getBrandImage <em>Brand Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Brand Image</em>'.
	 * @see org.usaha.ecvi.AnimalTag#getBrandImage()
	 * @see #getAnimalTag()
	 * @generated
	 */
	EAttribute getAnimalTag_BrandImage();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.AnimalTag#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.usaha.ecvi.AnimalTag#getNumber()
	 * @see #getAnimalTag()
	 * @generated
	 */
	EAttribute getAnimalTag_Number();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.AnimalTag#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.usaha.ecvi.AnimalTag#getType()
	 * @see #getAnimalTag()
	 * @generated
	 */
	EAttribute getAnimalTag_Type();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Attachement <em>Attachement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachement</em>'.
	 * @see org.usaha.ecvi.Attachement
	 * @generated
	 */
	EClass getAttachement();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Attachement#getPayload <em>Payload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Payload</em>'.
	 * @see org.usaha.ecvi.Attachement#getPayload()
	 * @see #getAttachement()
	 * @generated
	 */
	EAttribute getAttachement_Payload();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Attachement#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.usaha.ecvi.Attachement#getComment()
	 * @see #getAttachement()
	 * @generated
	 */
	EAttribute getAttachement_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Attachement#getDocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Doc Type</em>'.
	 * @see org.usaha.ecvi.Attachement#getDocType()
	 * @see #getAttachement()
	 * @generated
	 */
	EAttribute getAttachement_DocType();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Attachement#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see org.usaha.ecvi.Attachement#getFilename()
	 * @see #getAttachement()
	 * @generated
	 */
	EAttribute getAttachement_Filename();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Attachement#getMimeType <em>Mime Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mime Type</em>'.
	 * @see org.usaha.ecvi.Attachement#getMimeType()
	 * @see #getAttachement()
	 * @generated
	 */
	EAttribute getAttachement_MimeType();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Contact <em>Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contact</em>'.
	 * @see org.usaha.ecvi.Contact
	 * @generated
	 */
	EClass getContact();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Contact#getPremId <em>Prem Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prem Id</em>'.
	 * @see org.usaha.ecvi.Contact#getPremId()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_PremId();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Contact#getPremName <em>Prem Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prem Name</em>'.
	 * @see org.usaha.ecvi.Contact#getPremName()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_PremName();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Contact#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.usaha.ecvi.Contact#getAddress()
	 * @see #getContact()
	 * @generated
	 */
	EReference getContact_Address();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Contact#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Person</em>'.
	 * @see org.usaha.ecvi.Contact#getPerson()
	 * @see #getContact()
	 * @generated
	 */
	EReference getContact_Person();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.usaha.ecvi.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.usaha.ecvi.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.usaha.ecvi.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.usaha.ecvi.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.usaha.ecvi.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.usaha.ecvi.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.usaha.ecvi.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.DocumentRoot#getECVI <em>ECVI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>ECVI</em>'.
	 * @see org.usaha.ecvi.DocumentRoot#getECVI()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ECVI();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Ecvi <em>Ecvi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecvi</em>'.
	 * @see org.usaha.ecvi.Ecvi
	 * @generated
	 */
	EClass getEcvi();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Ecvi#getVeterinarian <em>Veterinarian</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Veterinarian</em>'.
	 * @see org.usaha.ecvi.Ecvi#getVeterinarian()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_Veterinarian();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Ecvi#getMovementPurposes <em>Movement Purposes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Movement Purposes</em>'.
	 * @see org.usaha.ecvi.Ecvi#getMovementPurposes()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_MovementPurposes();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Ecvi#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Origin</em>'.
	 * @see org.usaha.ecvi.Ecvi#getOrigin()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_Origin();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Ecvi#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see org.usaha.ecvi.Ecvi#getDestination()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Ecvi#getConsignor <em>Consignor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consignor</em>'.
	 * @see org.usaha.ecvi.Ecvi#getConsignor()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_Consignor();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Ecvi#getConsignee <em>Consignee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consignee</em>'.
	 * @see org.usaha.ecvi.Ecvi#getConsignee()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_Consignee();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Ecvi#getAccessions <em>Accessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Accessions</em>'.
	 * @see org.usaha.ecvi.Ecvi#getAccessions()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_Accessions();

	/**
	 * Returns the meta object for the attribute list '{@link org.usaha.ecvi.Ecvi#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.usaha.ecvi.Ecvi#getGroup()
	 * @see #getEcvi()
	 * @generated
	 */
	EAttribute getEcvi_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Ecvi#getAnimal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animal</em>'.
	 * @see org.usaha.ecvi.Ecvi#getAnimal()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_Animal();

	/**
	 * Returns the meta object for the attribute list '{@link org.usaha.ecvi.Ecvi#getGroup1 <em>Group1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group1</em>'.
	 * @see org.usaha.ecvi.Ecvi#getGroup1()
	 * @see #getEcvi()
	 * @generated
	 */
	EAttribute getEcvi_Group1();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Ecvi#getGroupLot <em>Group Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Group Lot</em>'.
	 * @see org.usaha.ecvi.Ecvi#getGroupLot()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_GroupLot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Ecvi#getAttachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachment</em>'.
	 * @see org.usaha.ecvi.Ecvi#getAttachment()
	 * @see #getEcvi()
	 * @generated
	 */
	EReference getEcvi_Attachment();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Ecvi#getCviNumber <em>Cvi Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cvi Number</em>'.
	 * @see org.usaha.ecvi.Ecvi#getCviNumber()
	 * @see #getEcvi()
	 * @generated
	 */
	EAttribute getEcvi_CviNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Ecvi#getEntryPermitNumber <em>Entry Permit Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry Permit Number</em>'.
	 * @see org.usaha.ecvi.Ecvi#getEntryPermitNumber()
	 * @see #getEcvi()
	 * @generated
	 */
	EAttribute getEcvi_EntryPermitNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Ecvi#getExpirationDate <em>Expiration Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiration Date</em>'.
	 * @see org.usaha.ecvi.Ecvi#getExpirationDate()
	 * @see #getEcvi()
	 * @generated
	 */
	EAttribute getEcvi_ExpirationDate();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Ecvi#getIssueDate <em>Issue Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issue Date</em>'.
	 * @see org.usaha.ecvi.Ecvi#getIssueDate()
	 * @see #getEcvi()
	 * @generated
	 */
	EAttribute getEcvi_IssueDate();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Ecvi#getShipmentDate <em>Shipment Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shipment Date</em>'.
	 * @see org.usaha.ecvi.Ecvi#getShipmentDate()
	 * @see #getEcvi()
	 * @generated
	 */
	EAttribute getEcvi_ShipmentDate();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Ecvi#getSpeciesCode <em>Species Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Species Code</em>'.
	 * @see org.usaha.ecvi.Ecvi#getSpeciesCode()
	 * @see #getEcvi()
	 * @generated
	 */
	EAttribute getEcvi_SpeciesCode();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.GeoPoint <em>Geo Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geo Point</em>'.
	 * @see org.usaha.ecvi.GeoPoint
	 * @generated
	 */
	EClass getGeoPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GeoPoint#getLat <em>Lat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lat</em>'.
	 * @see org.usaha.ecvi.GeoPoint#getLat()
	 * @see #getGeoPoint()
	 * @generated
	 */
	EAttribute getGeoPoint_Lat();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GeoPoint#getLng <em>Lng</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lng</em>'.
	 * @see org.usaha.ecvi.GeoPoint#getLng()
	 * @see #getGeoPoint()
	 * @generated
	 */
	EAttribute getGeoPoint_Lng();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.GroupLot <em>Group Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Lot</em>'.
	 * @see org.usaha.ecvi.GroupLot
	 * @generated
	 */
	EClass getGroupLot();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GroupLot#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see org.usaha.ecvi.GroupLot#getAge()
	 * @see #getGroupLot()
	 * @generated
	 */
	EAttribute getGroupLot_Age();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GroupLot#getBreed <em>Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breed</em>'.
	 * @see org.usaha.ecvi.GroupLot#getBreed()
	 * @see #getGroupLot()
	 * @generated
	 */
	EAttribute getGroupLot_Breed();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GroupLot#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.usaha.ecvi.GroupLot#getDescription()
	 * @see #getGroupLot()
	 * @generated
	 */
	EAttribute getGroupLot_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GroupLot#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see org.usaha.ecvi.GroupLot#getQuantity()
	 * @see #getGroupLot()
	 * @generated
	 */
	EAttribute getGroupLot_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GroupLot#getSex <em>Sex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sex</em>'.
	 * @see org.usaha.ecvi.GroupLot#getSex()
	 * @see #getGroupLot()
	 * @generated
	 */
	EAttribute getGroupLot_Sex();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GroupLot#getSexDetail <em>Sex Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sex Detail</em>'.
	 * @see org.usaha.ecvi.GroupLot#getSexDetail()
	 * @see #getGroupLot()
	 * @generated
	 */
	EAttribute getGroupLot_SexDetail();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GroupLot#getSpecies <em>Species</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Species</em>'.
	 * @see org.usaha.ecvi.GroupLot#getSpecies()
	 * @see #getGroupLot()
	 * @generated
	 */
	EAttribute getGroupLot_Species();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.GroupLot#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.usaha.ecvi.GroupLot#getUnit()
	 * @see #getGroupLot()
	 * @generated
	 */
	EAttribute getGroupLot_Unit();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Laboratory <em>Laboratory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Laboratory</em>'.
	 * @see org.usaha.ecvi.Laboratory
	 * @generated
	 */
	EClass getLaboratory();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Laboratory#getLabName <em>Lab Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lab Name</em>'.
	 * @see org.usaha.ecvi.Laboratory#getLabName()
	 * @see #getLaboratory()
	 * @generated
	 */
	EAttribute getLaboratory_LabName();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Laboratory#getPremId <em>Prem Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prem Id</em>'.
	 * @see org.usaha.ecvi.Laboratory#getPremId()
	 * @see #getLaboratory()
	 * @generated
	 */
	EAttribute getLaboratory_PremId();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Laboratory#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.usaha.ecvi.Laboratory#getAddress()
	 * @see #getLaboratory()
	 * @generated
	 */
	EReference getLaboratory_Address();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Laboratory#getAccessionDate <em>Accession Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accession Date</em>'.
	 * @see org.usaha.ecvi.Laboratory#getAccessionDate()
	 * @see #getLaboratory()
	 * @generated
	 */
	EAttribute getLaboratory_AccessionDate();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Laboratory#getAccessionNumber <em>Accession Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accession Number</em>'.
	 * @see org.usaha.ecvi.Laboratory#getAccessionNumber()
	 * @see #getLaboratory()
	 * @generated
	 */
	EAttribute getLaboratory_AccessionNumber();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.MovementPurposes <em>Movement Purposes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movement Purposes</em>'.
	 * @see org.usaha.ecvi.MovementPurposes
	 * @generated
	 */
	EClass getMovementPurposes();

	/**
	 * Returns the meta object for the attribute list '{@link org.usaha.ecvi.MovementPurposes#getMovementPurpose <em>Movement Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Movement Purpose</em>'.
	 * @see org.usaha.ecvi.MovementPurposes#getMovementPurpose()
	 * @see #getMovementPurposes()
	 * @generated
	 */
	EAttribute getMovementPurposes_MovementPurpose();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.usaha.ecvi.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.usaha.ecvi.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Person#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Phone</em>'.
	 * @see org.usaha.ecvi.Person#getPhone()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Phone();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.PhoneNum <em>Phone Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Phone Num</em>'.
	 * @see org.usaha.ecvi.PhoneNum
	 * @generated
	 */
	EClass getPhoneNum();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.PhoneNum#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.usaha.ecvi.PhoneNum#getComment()
	 * @see #getPhoneNum()
	 * @generated
	 */
	EAttribute getPhoneNum_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.PhoneNum#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.usaha.ecvi.PhoneNum#getNumber()
	 * @see #getPhoneNum()
	 * @generated
	 */
	EAttribute getPhoneNum_Number();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.PhoneNum#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.usaha.ecvi.PhoneNum#getType()
	 * @see #getPhoneNum()
	 * @generated
	 */
	EAttribute getPhoneNum_Type();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Premises <em>Premises</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premises</em>'.
	 * @see org.usaha.ecvi.Premises
	 * @generated
	 */
	EClass getPremises();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Premises#getPremId <em>Prem Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prem Id</em>'.
	 * @see org.usaha.ecvi.Premises#getPremId()
	 * @see #getPremises()
	 * @generated
	 */
	EAttribute getPremises_PremId();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Premises#getPremName <em>Prem Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prem Name</em>'.
	 * @see org.usaha.ecvi.Premises#getPremName()
	 * @see #getPremises()
	 * @generated
	 */
	EAttribute getPremises_PremName();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Premises#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.usaha.ecvi.Premises#getAddress()
	 * @see #getPremises()
	 * @generated
	 */
	EReference getPremises_Address();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Premises#getProgramStatus <em>Program Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Program Status</em>'.
	 * @see org.usaha.ecvi.Premises#getProgramStatus()
	 * @see #getPremises()
	 * @generated
	 */
	EReference getPremises_ProgramStatus();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Premises#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Person</em>'.
	 * @see org.usaha.ecvi.Premises#getPerson()
	 * @see #getPremises()
	 * @generated
	 */
	EReference getPremises_Person();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.ProgramStatus <em>Program Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program Status</em>'.
	 * @see org.usaha.ecvi.ProgramStatus
	 * @generated
	 */
	EClass getProgramStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.ProgramStatus#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.usaha.ecvi.ProgramStatus#getName()
	 * @see #getProgramStatus()
	 * @generated
	 */
	EAttribute getProgramStatus_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.ProgramStatus#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.usaha.ecvi.ProgramStatus#getValue()
	 * @see #getProgramStatus()
	 * @generated
	 */
	EAttribute getProgramStatus_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.ProgramStatus#getValueOther <em>Value Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Other</em>'.
	 * @see org.usaha.ecvi.ProgramStatus#getValueOther()
	 * @see #getProgramStatus()
	 * @generated
	 */
	EAttribute getProgramStatus_ValueOther();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.ResultValue <em>Result Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Value</em>'.
	 * @see org.usaha.ecvi.ResultValue
	 * @generated
	 */
	EClass getResultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.ResultValue#getResultInteger <em>Result Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Integer</em>'.
	 * @see org.usaha.ecvi.ResultValue#getResultInteger()
	 * @see #getResultValue()
	 * @generated
	 */
	EAttribute getResultValue_ResultInteger();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.ResultValue#getResultString <em>Result String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result String</em>'.
	 * @see org.usaha.ecvi.ResultValue#getResultString()
	 * @see #getResultValue()
	 * @generated
	 */
	EAttribute getResultValue_ResultString();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.ResultValue#getResultFloat <em>Result Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Float</em>'.
	 * @see org.usaha.ecvi.ResultValue#getResultFloat()
	 * @see #getResultValue()
	 * @generated
	 */
	EAttribute getResultValue_ResultFloat();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.ResultValue#getResultName <em>Result Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Name</em>'.
	 * @see org.usaha.ecvi.ResultValue#getResultName()
	 * @see #getResultValue()
	 * @generated
	 */
	EAttribute getResultValue_ResultName();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see org.usaha.ecvi.Test
	 * @generated
	 */
	EClass getTest();

	/**
	 * Returns the meta object for the containment reference list '{@link org.usaha.ecvi.Test#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result</em>'.
	 * @see org.usaha.ecvi.Test#getResult()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Test#getIdref <em>Idref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idref</em>'.
	 * @see org.usaha.ecvi.Test#getIdref()
	 * @see #getTest()
	 * @generated
	 */
	EAttribute getTest_Idref();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Test#getTestCode <em>Test Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Code</em>'.
	 * @see org.usaha.ecvi.Test#getTestCode()
	 * @see #getTest()
	 * @generated
	 */
	EAttribute getTest_TestCode();

	/**
	 * Returns the meta object for class '{@link org.usaha.ecvi.Veterinarian <em>Veterinarian</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Veterinarian</em>'.
	 * @see org.usaha.ecvi.Veterinarian
	 * @generated
	 */
	EClass getVeterinarian();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Veterinarian#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Person</em>'.
	 * @see org.usaha.ecvi.Veterinarian#getPerson()
	 * @see #getVeterinarian()
	 * @generated
	 */
	EReference getVeterinarian_Person();

	/**
	 * Returns the meta object for the containment reference '{@link org.usaha.ecvi.Veterinarian#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.usaha.ecvi.Veterinarian#getAddress()
	 * @see #getVeterinarian()
	 * @generated
	 */
	EReference getVeterinarian_Address();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Veterinarian#getLicenseIssueState <em>License Issue State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License Issue State</em>'.
	 * @see org.usaha.ecvi.Veterinarian#getLicenseIssueState()
	 * @see #getVeterinarian()
	 * @generated
	 */
	EAttribute getVeterinarian_LicenseIssueState();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Veterinarian#getLicenseNumber <em>License Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License Number</em>'.
	 * @see org.usaha.ecvi.Veterinarian#getLicenseNumber()
	 * @see #getVeterinarian()
	 * @generated
	 */
	EAttribute getVeterinarian_LicenseNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.usaha.ecvi.Veterinarian#getNationalAccreditationNumber <em>National Accreditation Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>National Accreditation Number</em>'.
	 * @see org.usaha.ecvi.Veterinarian#getNationalAccreditationNumber()
	 * @see #getVeterinarian()
	 * @generated
	 */
	EAttribute getVeterinarian_NationalAccreditationNumber();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.DocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Doc Type</em>'.
	 * @see org.usaha.ecvi.DocType
	 * @generated
	 */
	EEnum getDocType();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.ISO3166Country <em>ISO3166 Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ISO3166 Country</em>'.
	 * @see org.usaha.ecvi.ISO3166Country
	 * @generated
	 */
	EEnum getISO3166Country();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.MovementPurpose <em>Movement Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Movement Purpose</em>'.
	 * @see org.usaha.ecvi.MovementPurpose
	 * @generated
	 */
	EEnum getMovementPurpose();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.PhoneDevice <em>Phone Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Phone Device</em>'.
	 * @see org.usaha.ecvi.PhoneDevice
	 * @generated
	 */
	EEnum getPhoneDevice();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.ProgramStatusName <em>Program Status Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Program Status Name</em>'.
	 * @see org.usaha.ecvi.ProgramStatusName
	 * @generated
	 */
	EEnum getProgramStatusName();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.ProgramStatusValue <em>Program Status Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Program Status Value</em>'.
	 * @see org.usaha.ecvi.ProgramStatusValue
	 * @generated
	 */
	EEnum getProgramStatusValue();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.ResultName <em>Result Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Result Name</em>'.
	 * @see org.usaha.ecvi.ResultName
	 * @generated
	 */
	EEnum getResultName();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.Sex <em>Sex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sex</em>'.
	 * @see org.usaha.ecvi.Sex
	 * @generated
	 */
	EEnum getSex();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.SpeciesCode <em>Species Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Species Code</em>'.
	 * @see org.usaha.ecvi.SpeciesCode
	 * @generated
	 */
	EEnum getSpeciesCode();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.TagType <em>Tag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tag Type</em>'.
	 * @see org.usaha.ecvi.TagType
	 * @generated
	 */
	EEnum getTagType();

	/**
	 * Returns the meta object for enum '{@link org.usaha.ecvi.UsState <em>Us State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Us State</em>'.
	 * @see org.usaha.ecvi.UsState
	 * @generated
	 */
	EEnum getUsState();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Address Line1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Address Line1</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Line1_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='200'"
	 * @generated
	 */
	EDataType getAddressLine1();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Address Line2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Address Line2</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Line2_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='200'"
	 * @generated
	 */
	EDataType getAddressLine2();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Age</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='AgeType' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[0-9]{1,2}(d|wk|mo|a) (19|20)\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])'"
	 * @generated
	 */
	EDataType getAge();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Animal Sex Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Animal Sex Detail</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='SexDetail_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='100'"
	 * @generated
	 */
	EDataType getAnimalSexDetail();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Attachement Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Attachement Comment</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Comment_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='250'"
	 * @generated
	 */
	EDataType getAttachementComment();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Breed</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='BreedType' baseType='http://www.eclipse.org/emf/2003/XMLType#string' minLength='2' maxLength='3' pattern='[A-Z]{2,3}'"
	 * @generated
	 */
	EDataType getBreed();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>County</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>County</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='CountyType' baseType='http://www.eclipse.org/emf/2003/XMLType#string' minLength='3' maxLength='40'"
	 * @generated
	 */
	EDataType getCounty();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Cvi Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Cvi Number</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='CviNumber_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='100'"
	 * @generated
	 */
	EDataType getCviNumber();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.DocType <em>Doc Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Doc Type Object</em>'.
	 * @see org.usaha.ecvi.DocType
	 * @model instanceClass="org.usaha.ecvi.DocType"
	 *        extendedMetaData="name='DocType_._type:Object' baseType='DocType_._type'"
	 * @generated
	 */
	EDataType getDocTypeObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Entry Permit Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Entry Permit Number</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='EntryPermitNumber_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='100'"
	 * @generated
	 */
	EDataType getEntryPermitNumber();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>File Name</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Filename_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='250'"
	 * @generated
	 */
	EDataType getFileName();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Group Lot Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Group Lot Description</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Description_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='200'"
	 * @generated
	 */
	EDataType getGroupLotDescription();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Group Lot Sex Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Group Lot Sex Detail</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='SexDetail_._1_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='100'"
	 * @generated
	 */
	EDataType getGroupLotSexDetail();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.ISO3166Country <em>ISO3166 Country Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ISO3166 Country Object</em>'.
	 * @see org.usaha.ecvi.ISO3166Country
	 * @model instanceClass="org.usaha.ecvi.ISO3166Country"
	 *        extendedMetaData="name='ISO3166CountryType:Object' baseType='ISO3166CountryType'"
	 * @generated
	 */
	EDataType getISO3166CountryObject();

	/**
	 * Returns the meta object for data type '{@link java.math.BigDecimal <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Latitude</em>'.
	 * @see java.math.BigDecimal
	 * @model instanceClass="java.math.BigDecimal"
	 *        extendedMetaData="name='LatitudeType' baseType='http://www.eclipse.org/emf/2003/XMLType#decimal' minInclusive='-90.0' maxInclusive='90.0'"
	 * @generated
	 */
	EDataType getLatitude();

	/**
	 * Returns the meta object for data type '{@link java.math.BigDecimal <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Longitude</em>'.
	 * @see java.math.BigDecimal
	 * @model instanceClass="java.math.BigDecimal"
	 *        extendedMetaData="name='LongitudeType' baseType='http://www.eclipse.org/emf/2003/XMLType#decimal' minInclusive='-180.0' maxInclusive='180.0'"
	 * @generated
	 */
	EDataType getLongitude();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Mime Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mime Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='MimeTypeType' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='^.{1,127}/.{1,127}$'"
	 * @generated
	 */
	EDataType getMimeType();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.MovementPurpose <em>Movement Purpose Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Movement Purpose Object</em>'.
	 * @see org.usaha.ecvi.MovementPurpose
	 * @model instanceClass="org.usaha.ecvi.MovementPurpose"
	 *        extendedMetaData="name='MovementPurposeType:Object' baseType='MovementPurposeType'"
	 * @generated
	 */
	EDataType getMovementPurposeObject();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.PhoneDevice <em>Phone Device Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Phone Device Object</em>'.
	 * @see org.usaha.ecvi.PhoneDevice
	 * @model instanceClass="org.usaha.ecvi.PhoneDevice"
	 *        extendedMetaData="name='PhoneDeviceType:Object' baseType='PhoneDeviceType'"
	 * @generated
	 */
	EDataType getPhoneDeviceObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Phone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Phone Number</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='PhoneNumber' baseType='http://www.eclipse.org/emf/2003/XMLType#string' length='10' pattern='[0-9]{10}'"
	 * @generated
	 */
	EDataType getPhoneNumber();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Phone Num Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Phone Num Comment</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Comment_._1_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='100'"
	 * @generated
	 */
	EDataType getPhoneNumComment();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Phone Num Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Phone Num Number</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Number_._type' baseType='PhoneNumber' pattern='[0-9]{10}'"
	 * @generated
	 */
	EDataType getPhoneNumNumber();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Prem Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Prem Id</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='PremIdType' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[A-Z0-9]{6,8}'"
	 * @generated
	 */
	EDataType getPremId();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.ProgramStatusName <em>Program Status Name Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Program Status Name Object</em>'.
	 * @see org.usaha.ecvi.ProgramStatusName
	 * @model instanceClass="org.usaha.ecvi.ProgramStatusName"
	 *        extendedMetaData="name='Name_._type:Object' baseType='Name_._type'"
	 * @generated
	 */
	EDataType getProgramStatusNameObject();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.ProgramStatusValue <em>Program Status Value Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Program Status Value Object</em>'.
	 * @see org.usaha.ecvi.ProgramStatusValue
	 * @model instanceClass="org.usaha.ecvi.ProgramStatusValue"
	 *        extendedMetaData="name='Value_._type:Object' baseType='Value_._type'"
	 * @generated
	 */
	EDataType getProgramStatusValueObject();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.ResultName <em>Result Name Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Result Name Object</em>'.
	 * @see org.usaha.ecvi.ResultName
	 * @model instanceClass="org.usaha.ecvi.ResultName"
	 *        extendedMetaData="name='ResultNameType:Object' baseType='ResultNameType'"
	 * @generated
	 */
	EDataType getResultNameObject();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.Sex <em>Sex Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Sex Object</em>'.
	 * @see org.usaha.ecvi.Sex
	 * @model instanceClass="org.usaha.ecvi.Sex"
	 *        extendedMetaData="name='SexType:Object' baseType='SexType'"
	 * @generated
	 */
	EDataType getSexObject();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.SpeciesCode <em>Species Code Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Species Code Object</em>'.
	 * @see org.usaha.ecvi.SpeciesCode
	 * @model instanceClass="org.usaha.ecvi.SpeciesCode"
	 *        extendedMetaData="name='SpeciesCodeType:Object' baseType='SpeciesCodeType'"
	 * @generated
	 */
	EDataType getSpeciesCodeObject();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.TagType <em>Tag Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Tag Type Object</em>'.
	 * @see org.usaha.ecvi.TagType
	 * @model instanceClass="org.usaha.ecvi.TagType"
	 *        extendedMetaData="name='TagType:Object' baseType='TagType'"
	 * @generated
	 */
	EDataType getTagTypeObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Town</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Town_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='200'"
	 * @generated
	 */
	EDataType getTown();

	/**
	 * Returns the meta object for data type '{@link org.usaha.ecvi.UsState <em>Us State Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Us State Object</em>'.
	 * @see org.usaha.ecvi.UsState
	 * @model instanceClass="org.usaha.ecvi.UsState"
	 *        extendedMetaData="name='UsState:Object' baseType='UsState'"
	 * @generated
	 */
	EDataType getUsStateObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Zip Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Zip Code</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ZipCode' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[0-9]{5} [0-9]{5}-[0-9]{4}'"
	 * @generated
	 */
	EDataType getZipCode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EcviFactory getEcviFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.AccessionImpl <em>Accession</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.AccessionImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAccession()
		 * @generated
		 */
		EClass ACCESSION = eINSTANCE.getAccession();

		/**
		 * The meta object literal for the '<em><b>Laboratory</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESSION__LABORATORY = eINSTANCE.getAccession_Laboratory();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESSION__ID = eINSTANCE.getAccession_Id();

		/**
		 * The meta object literal for the '<em><b>Infield Test</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESSION__INFIELD_TEST = eINSTANCE.getAccession_InfieldTest();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.AccessionsImpl <em>Accessions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.AccessionsImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAccessions()
		 * @generated
		 */
		EClass ACCESSIONS = eINSTANCE.getAccessions();

		/**
		 * The meta object literal for the '<em><b>Accession</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESSIONS__ACCESSION = eINSTANCE.getAccessions_Accession();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.AddressImpl <em>Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.AddressImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAddress()
		 * @generated
		 */
		EClass ADDRESS = eINSTANCE.getAddress();

		/**
		 * The meta object literal for the '<em><b>Line1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__LINE1 = eINSTANCE.getAddress_Line1();

		/**
		 * The meta object literal for the '<em><b>Line2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__LINE2 = eINSTANCE.getAddress_Line2();

		/**
		 * The meta object literal for the '<em><b>Town</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__TOWN = eINSTANCE.getAddress_Town();

		/**
		 * The meta object literal for the '<em><b>County</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__COUNTY = eINSTANCE.getAddress_County();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__STATE = eINSTANCE.getAddress_State();

		/**
		 * The meta object literal for the '<em><b>ZIP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__ZIP = eINSTANCE.getAddress_ZIP();

		/**
		 * The meta object literal for the '<em><b>Country</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__COUNTRY = eINSTANCE.getAddress_Country();

		/**
		 * The meta object literal for the '<em><b>Geo Point</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDRESS__GEO_POINT = eINSTANCE.getAddress_GeoPoint();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.AnimalImpl <em>Animal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.AnimalImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAnimal()
		 * @generated
		 */
		EClass ANIMAL = eINSTANCE.getAnimal();

		/**
		 * The meta object literal for the '<em><b>Animal Tag</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL__ANIMAL_TAG = eINSTANCE.getAnimal_AnimalTag();

		/**
		 * The meta object literal for the '<em><b>Test</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL__TEST = eINSTANCE.getAnimal_Test();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__AGE = eINSTANCE.getAnimal_Age();

		/**
		 * The meta object literal for the '<em><b>Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__BREED = eINSTANCE.getAnimal_Breed();

		/**
		 * The meta object literal for the '<em><b>Inspection Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__INSPECTION_DATE = eINSTANCE.getAnimal_InspectionDate();

		/**
		 * The meta object literal for the '<em><b>Sex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__SEX = eINSTANCE.getAnimal_Sex();

		/**
		 * The meta object literal for the '<em><b>Sex Detail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__SEX_DETAIL = eINSTANCE.getAnimal_SexDetail();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.AnimalTagImpl <em>Animal Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.AnimalTagImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAnimalTag()
		 * @generated
		 */
		EClass ANIMAL_TAG = eINSTANCE.getAnimalTag();

		/**
		 * The meta object literal for the '<em><b>Brand Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_TAG__BRAND_IMAGE = eINSTANCE.getAnimalTag_BrandImage();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_TAG__NUMBER = eINSTANCE.getAnimalTag_Number();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_TAG__TYPE = eINSTANCE.getAnimalTag_Type();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.AttachementImpl <em>Attachement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.AttachementImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAttachement()
		 * @generated
		 */
		EClass ATTACHEMENT = eINSTANCE.getAttachement();

		/**
		 * The meta object literal for the '<em><b>Payload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHEMENT__PAYLOAD = eINSTANCE.getAttachement_Payload();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHEMENT__COMMENT = eINSTANCE.getAttachement_Comment();

		/**
		 * The meta object literal for the '<em><b>Doc Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHEMENT__DOC_TYPE = eINSTANCE.getAttachement_DocType();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHEMENT__FILENAME = eINSTANCE.getAttachement_Filename();

		/**
		 * The meta object literal for the '<em><b>Mime Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHEMENT__MIME_TYPE = eINSTANCE.getAttachement_MimeType();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.ContactImpl <em>Contact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.ContactImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getContact()
		 * @generated
		 */
		EClass CONTACT = eINSTANCE.getContact();

		/**
		 * The meta object literal for the '<em><b>Prem Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__PREM_ID = eINSTANCE.getContact_PremId();

		/**
		 * The meta object literal for the '<em><b>Prem Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__PREM_NAME = eINSTANCE.getContact_PremName();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTACT__ADDRESS = eINSTANCE.getContact_Address();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTACT__PERSON = eINSTANCE.getContact_Person();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.DocumentRootImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>ECVI</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ECVI = eINSTANCE.getDocumentRoot_ECVI();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.EcviImpl <em>Ecvi</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.EcviImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getEcvi()
		 * @generated
		 */
		EClass ECVI = eINSTANCE.getEcvi();

		/**
		 * The meta object literal for the '<em><b>Veterinarian</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__VETERINARIAN = eINSTANCE.getEcvi_Veterinarian();

		/**
		 * The meta object literal for the '<em><b>Movement Purposes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__MOVEMENT_PURPOSES = eINSTANCE.getEcvi_MovementPurposes();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__ORIGIN = eINSTANCE.getEcvi_Origin();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__DESTINATION = eINSTANCE.getEcvi_Destination();

		/**
		 * The meta object literal for the '<em><b>Consignor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__CONSIGNOR = eINSTANCE.getEcvi_Consignor();

		/**
		 * The meta object literal for the '<em><b>Consignee</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__CONSIGNEE = eINSTANCE.getEcvi_Consignee();

		/**
		 * The meta object literal for the '<em><b>Accessions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__ACCESSIONS = eINSTANCE.getEcvi_Accessions();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECVI__GROUP = eINSTANCE.getEcvi_Group();

		/**
		 * The meta object literal for the '<em><b>Animal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__ANIMAL = eINSTANCE.getEcvi_Animal();

		/**
		 * The meta object literal for the '<em><b>Group1</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECVI__GROUP1 = eINSTANCE.getEcvi_Group1();

		/**
		 * The meta object literal for the '<em><b>Group Lot</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__GROUP_LOT = eINSTANCE.getEcvi_GroupLot();

		/**
		 * The meta object literal for the '<em><b>Attachment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECVI__ATTACHMENT = eINSTANCE.getEcvi_Attachment();

		/**
		 * The meta object literal for the '<em><b>Cvi Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECVI__CVI_NUMBER = eINSTANCE.getEcvi_CviNumber();

		/**
		 * The meta object literal for the '<em><b>Entry Permit Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECVI__ENTRY_PERMIT_NUMBER = eINSTANCE.getEcvi_EntryPermitNumber();

		/**
		 * The meta object literal for the '<em><b>Expiration Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECVI__EXPIRATION_DATE = eINSTANCE.getEcvi_ExpirationDate();

		/**
		 * The meta object literal for the '<em><b>Issue Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECVI__ISSUE_DATE = eINSTANCE.getEcvi_IssueDate();

		/**
		 * The meta object literal for the '<em><b>Shipment Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECVI__SHIPMENT_DATE = eINSTANCE.getEcvi_ShipmentDate();

		/**
		 * The meta object literal for the '<em><b>Species Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECVI__SPECIES_CODE = eINSTANCE.getEcvi_SpeciesCode();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.GeoPointImpl <em>Geo Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.GeoPointImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getGeoPoint()
		 * @generated
		 */
		EClass GEO_POINT = eINSTANCE.getGeoPoint();

		/**
		 * The meta object literal for the '<em><b>Lat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEO_POINT__LAT = eINSTANCE.getGeoPoint_Lat();

		/**
		 * The meta object literal for the '<em><b>Lng</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEO_POINT__LNG = eINSTANCE.getGeoPoint_Lng();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.GroupLotImpl <em>Group Lot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.GroupLotImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getGroupLot()
		 * @generated
		 */
		EClass GROUP_LOT = eINSTANCE.getGroupLot();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_LOT__AGE = eINSTANCE.getGroupLot_Age();

		/**
		 * The meta object literal for the '<em><b>Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_LOT__BREED = eINSTANCE.getGroupLot_Breed();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_LOT__DESCRIPTION = eINSTANCE.getGroupLot_Description();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_LOT__QUANTITY = eINSTANCE.getGroupLot_Quantity();

		/**
		 * The meta object literal for the '<em><b>Sex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_LOT__SEX = eINSTANCE.getGroupLot_Sex();

		/**
		 * The meta object literal for the '<em><b>Sex Detail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_LOT__SEX_DETAIL = eINSTANCE.getGroupLot_SexDetail();

		/**
		 * The meta object literal for the '<em><b>Species</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_LOT__SPECIES = eINSTANCE.getGroupLot_Species();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_LOT__UNIT = eINSTANCE.getGroupLot_Unit();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.LaboratoryImpl <em>Laboratory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.LaboratoryImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getLaboratory()
		 * @generated
		 */
		EClass LABORATORY = eINSTANCE.getLaboratory();

		/**
		 * The meta object literal for the '<em><b>Lab Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABORATORY__LAB_NAME = eINSTANCE.getLaboratory_LabName();

		/**
		 * The meta object literal for the '<em><b>Prem Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABORATORY__PREM_ID = eINSTANCE.getLaboratory_PremId();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABORATORY__ADDRESS = eINSTANCE.getLaboratory_Address();

		/**
		 * The meta object literal for the '<em><b>Accession Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABORATORY__ACCESSION_DATE = eINSTANCE.getLaboratory_AccessionDate();

		/**
		 * The meta object literal for the '<em><b>Accession Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABORATORY__ACCESSION_NUMBER = eINSTANCE.getLaboratory_AccessionNumber();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.MovementPurposesImpl <em>Movement Purposes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.MovementPurposesImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getMovementPurposes()
		 * @generated
		 */
		EClass MOVEMENT_PURPOSES = eINSTANCE.getMovementPurposes();

		/**
		 * The meta object literal for the '<em><b>Movement Purpose</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVEMENT_PURPOSES__MOVEMENT_PURPOSE = eINSTANCE.getMovementPurposes_MovementPurpose();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.PersonImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__PHONE = eINSTANCE.getPerson_Phone();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.PhoneNumImpl <em>Phone Num</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.PhoneNumImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneNum()
		 * @generated
		 */
		EClass PHONE_NUM = eINSTANCE.getPhoneNum();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHONE_NUM__COMMENT = eINSTANCE.getPhoneNum_Comment();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHONE_NUM__NUMBER = eINSTANCE.getPhoneNum_Number();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHONE_NUM__TYPE = eINSTANCE.getPhoneNum_Type();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.PremisesImpl <em>Premises</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.PremisesImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPremises()
		 * @generated
		 */
		EClass PREMISES = eINSTANCE.getPremises();

		/**
		 * The meta object literal for the '<em><b>Prem Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREMISES__PREM_ID = eINSTANCE.getPremises_PremId();

		/**
		 * The meta object literal for the '<em><b>Prem Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREMISES__PREM_NAME = eINSTANCE.getPremises_PremName();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREMISES__ADDRESS = eINSTANCE.getPremises_Address();

		/**
		 * The meta object literal for the '<em><b>Program Status</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREMISES__PROGRAM_STATUS = eINSTANCE.getPremises_ProgramStatus();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREMISES__PERSON = eINSTANCE.getPremises_Person();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.ProgramStatusImpl <em>Program Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.ProgramStatusImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatus()
		 * @generated
		 */
		EClass PROGRAM_STATUS = eINSTANCE.getProgramStatus();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM_STATUS__NAME = eINSTANCE.getProgramStatus_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM_STATUS__VALUE = eINSTANCE.getProgramStatus_Value();

		/**
		 * The meta object literal for the '<em><b>Value Other</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM_STATUS__VALUE_OTHER = eINSTANCE.getProgramStatus_ValueOther();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.ResultValueImpl <em>Result Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.ResultValueImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getResultValue()
		 * @generated
		 */
		EClass RESULT_VALUE = eINSTANCE.getResultValue();

		/**
		 * The meta object literal for the '<em><b>Result Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_VALUE__RESULT_INTEGER = eINSTANCE.getResultValue_ResultInteger();

		/**
		 * The meta object literal for the '<em><b>Result String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_VALUE__RESULT_STRING = eINSTANCE.getResultValue_ResultString();

		/**
		 * The meta object literal for the '<em><b>Result Float</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_VALUE__RESULT_FLOAT = eINSTANCE.getResultValue_ResultFloat();

		/**
		 * The meta object literal for the '<em><b>Result Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_VALUE__RESULT_NAME = eINSTANCE.getResultValue_ResultName();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.TestImpl <em>Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.TestImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getTest()
		 * @generated
		 */
		EClass TEST = eINSTANCE.getTest();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__RESULT = eINSTANCE.getTest_Result();

		/**
		 * The meta object literal for the '<em><b>Idref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST__IDREF = eINSTANCE.getTest_Idref();

		/**
		 * The meta object literal for the '<em><b>Test Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST__TEST_CODE = eINSTANCE.getTest_TestCode();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.impl.VeterinarianImpl <em>Veterinarian</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.impl.VeterinarianImpl
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getVeterinarian()
		 * @generated
		 */
		EClass VETERINARIAN = eINSTANCE.getVeterinarian();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VETERINARIAN__PERSON = eINSTANCE.getVeterinarian_Person();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VETERINARIAN__ADDRESS = eINSTANCE.getVeterinarian_Address();

		/**
		 * The meta object literal for the '<em><b>License Issue State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VETERINARIAN__LICENSE_ISSUE_STATE = eINSTANCE.getVeterinarian_LicenseIssueState();

		/**
		 * The meta object literal for the '<em><b>License Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VETERINARIAN__LICENSE_NUMBER = eINSTANCE.getVeterinarian_LicenseNumber();

		/**
		 * The meta object literal for the '<em><b>National Accreditation Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VETERINARIAN__NATIONAL_ACCREDITATION_NUMBER = eINSTANCE.getVeterinarian_NationalAccreditationNumber();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.DocType <em>Doc Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.DocType
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getDocType()
		 * @generated
		 */
		EEnum DOC_TYPE = eINSTANCE.getDocType();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.ISO3166Country <em>ISO3166 Country</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.ISO3166Country
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getISO3166Country()
		 * @generated
		 */
		EEnum ISO3166_COUNTRY = eINSTANCE.getISO3166Country();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.MovementPurpose <em>Movement Purpose</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.MovementPurpose
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getMovementPurpose()
		 * @generated
		 */
		EEnum MOVEMENT_PURPOSE = eINSTANCE.getMovementPurpose();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.PhoneDevice <em>Phone Device</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.PhoneDevice
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneDevice()
		 * @generated
		 */
		EEnum PHONE_DEVICE = eINSTANCE.getPhoneDevice();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.ProgramStatusName <em>Program Status Name</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.ProgramStatusName
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatusName()
		 * @generated
		 */
		EEnum PROGRAM_STATUS_NAME = eINSTANCE.getProgramStatusName();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.ProgramStatusValue <em>Program Status Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.ProgramStatusValue
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatusValue()
		 * @generated
		 */
		EEnum PROGRAM_STATUS_VALUE = eINSTANCE.getProgramStatusValue();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.ResultName <em>Result Name</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.ResultName
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getResultName()
		 * @generated
		 */
		EEnum RESULT_NAME = eINSTANCE.getResultName();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.Sex <em>Sex</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.Sex
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getSex()
		 * @generated
		 */
		EEnum SEX = eINSTANCE.getSex();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.SpeciesCode <em>Species Code</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.SpeciesCode
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getSpeciesCode()
		 * @generated
		 */
		EEnum SPECIES_CODE = eINSTANCE.getSpeciesCode();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.TagType <em>Tag Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.TagType
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getTagType()
		 * @generated
		 */
		EEnum TAG_TYPE = eINSTANCE.getTagType();

		/**
		 * The meta object literal for the '{@link org.usaha.ecvi.UsState <em>Us State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.UsState
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getUsState()
		 * @generated
		 */
		EEnum US_STATE = eINSTANCE.getUsState();

		/**
		 * The meta object literal for the '<em>Address Line1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAddressLine1()
		 * @generated
		 */
		EDataType ADDRESS_LINE1 = eINSTANCE.getAddressLine1();

		/**
		 * The meta object literal for the '<em>Address Line2</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAddressLine2()
		 * @generated
		 */
		EDataType ADDRESS_LINE2 = eINSTANCE.getAddressLine2();

		/**
		 * The meta object literal for the '<em>Age</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAge()
		 * @generated
		 */
		EDataType AGE = eINSTANCE.getAge();

		/**
		 * The meta object literal for the '<em>Animal Sex Detail</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAnimalSexDetail()
		 * @generated
		 */
		EDataType ANIMAL_SEX_DETAIL = eINSTANCE.getAnimalSexDetail();

		/**
		 * The meta object literal for the '<em>Attachement Comment</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getAttachementComment()
		 * @generated
		 */
		EDataType ATTACHEMENT_COMMENT = eINSTANCE.getAttachementComment();

		/**
		 * The meta object literal for the '<em>Breed</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getBreed()
		 * @generated
		 */
		EDataType BREED = eINSTANCE.getBreed();

		/**
		 * The meta object literal for the '<em>County</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getCounty()
		 * @generated
		 */
		EDataType COUNTY = eINSTANCE.getCounty();

		/**
		 * The meta object literal for the '<em>Cvi Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getCviNumber()
		 * @generated
		 */
		EDataType CVI_NUMBER = eINSTANCE.getCviNumber();

		/**
		 * The meta object literal for the '<em>Doc Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.DocType
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getDocTypeObject()
		 * @generated
		 */
		EDataType DOC_TYPE_OBJECT = eINSTANCE.getDocTypeObject();

		/**
		 * The meta object literal for the '<em>Entry Permit Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getEntryPermitNumber()
		 * @generated
		 */
		EDataType ENTRY_PERMIT_NUMBER = eINSTANCE.getEntryPermitNumber();

		/**
		 * The meta object literal for the '<em>File Name</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getFileName()
		 * @generated
		 */
		EDataType FILE_NAME = eINSTANCE.getFileName();

		/**
		 * The meta object literal for the '<em>Group Lot Description</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getGroupLotDescription()
		 * @generated
		 */
		EDataType GROUP_LOT_DESCRIPTION = eINSTANCE.getGroupLotDescription();

		/**
		 * The meta object literal for the '<em>Group Lot Sex Detail</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getGroupLotSexDetail()
		 * @generated
		 */
		EDataType GROUP_LOT_SEX_DETAIL = eINSTANCE.getGroupLotSexDetail();

		/**
		 * The meta object literal for the '<em>ISO3166 Country Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.ISO3166Country
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getISO3166CountryObject()
		 * @generated
		 */
		EDataType ISO3166_COUNTRY_OBJECT = eINSTANCE.getISO3166CountryObject();

		/**
		 * The meta object literal for the '<em>Latitude</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigDecimal
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getLatitude()
		 * @generated
		 */
		EDataType LATITUDE = eINSTANCE.getLatitude();

		/**
		 * The meta object literal for the '<em>Longitude</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigDecimal
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getLongitude()
		 * @generated
		 */
		EDataType LONGITUDE = eINSTANCE.getLongitude();

		/**
		 * The meta object literal for the '<em>Mime Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getMimeType()
		 * @generated
		 */
		EDataType MIME_TYPE = eINSTANCE.getMimeType();

		/**
		 * The meta object literal for the '<em>Movement Purpose Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.MovementPurpose
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getMovementPurposeObject()
		 * @generated
		 */
		EDataType MOVEMENT_PURPOSE_OBJECT = eINSTANCE.getMovementPurposeObject();

		/**
		 * The meta object literal for the '<em>Phone Device Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.PhoneDevice
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneDeviceObject()
		 * @generated
		 */
		EDataType PHONE_DEVICE_OBJECT = eINSTANCE.getPhoneDeviceObject();

		/**
		 * The meta object literal for the '<em>Phone Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneNumber()
		 * @generated
		 */
		EDataType PHONE_NUMBER = eINSTANCE.getPhoneNumber();

		/**
		 * The meta object literal for the '<em>Phone Num Comment</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneNumComment()
		 * @generated
		 */
		EDataType PHONE_NUM_COMMENT = eINSTANCE.getPhoneNumComment();

		/**
		 * The meta object literal for the '<em>Phone Num Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPhoneNumNumber()
		 * @generated
		 */
		EDataType PHONE_NUM_NUMBER = eINSTANCE.getPhoneNumNumber();

		/**
		 * The meta object literal for the '<em>Prem Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getPremId()
		 * @generated
		 */
		EDataType PREM_ID = eINSTANCE.getPremId();

		/**
		 * The meta object literal for the '<em>Program Status Name Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.ProgramStatusName
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatusNameObject()
		 * @generated
		 */
		EDataType PROGRAM_STATUS_NAME_OBJECT = eINSTANCE.getProgramStatusNameObject();

		/**
		 * The meta object literal for the '<em>Program Status Value Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.ProgramStatusValue
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getProgramStatusValueObject()
		 * @generated
		 */
		EDataType PROGRAM_STATUS_VALUE_OBJECT = eINSTANCE.getProgramStatusValueObject();

		/**
		 * The meta object literal for the '<em>Result Name Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.ResultName
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getResultNameObject()
		 * @generated
		 */
		EDataType RESULT_NAME_OBJECT = eINSTANCE.getResultNameObject();

		/**
		 * The meta object literal for the '<em>Sex Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.Sex
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getSexObject()
		 * @generated
		 */
		EDataType SEX_OBJECT = eINSTANCE.getSexObject();

		/**
		 * The meta object literal for the '<em>Species Code Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.SpeciesCode
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getSpeciesCodeObject()
		 * @generated
		 */
		EDataType SPECIES_CODE_OBJECT = eINSTANCE.getSpeciesCodeObject();

		/**
		 * The meta object literal for the '<em>Tag Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.TagType
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getTagTypeObject()
		 * @generated
		 */
		EDataType TAG_TYPE_OBJECT = eINSTANCE.getTagTypeObject();

		/**
		 * The meta object literal for the '<em>Town</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getTown()
		 * @generated
		 */
		EDataType TOWN = eINSTANCE.getTown();

		/**
		 * The meta object literal for the '<em>Us State Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.usaha.ecvi.UsState
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getUsStateObject()
		 * @generated
		 */
		EDataType US_STATE_OBJECT = eINSTANCE.getUsStateObject();

		/**
		 * The meta object literal for the '<em>Zip Code</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.usaha.ecvi.impl.EcviPackageImpl#getZipCode()
		 * @generated
		 */
		EDataType ZIP_CODE = eINSTANCE.getZipCode();

	}

} //EcviPackage
