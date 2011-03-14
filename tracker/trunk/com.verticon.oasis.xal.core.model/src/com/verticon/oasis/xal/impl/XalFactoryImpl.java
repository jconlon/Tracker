/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XalFactoryImpl extends EFactoryImpl implements XalFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XalFactory init() {
		try {
			XalFactory theXalFactory = (XalFactory)EPackage.Registry.INSTANCE.getEFactory("urn:oasis:names:tc:ciq:xsdschema:xAL:2.0"); 
			if (theXalFactory != null) {
				return theXalFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XalFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XalFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XalPackage.ADDRESS: return createAddress();
			case XalPackage.ADDRESS_DETAILS: return createAddressDetails();
			case XalPackage.ADDRESS_IDENTIFIER: return createAddressIdentifier();
			case XalPackage.ADDRESS_LATITUDE: return createAddressLatitude();
			case XalPackage.ADDRESS_LATITUDE_DIRECTION: return createAddressLatitudeDirection();
			case XalPackage.ADDRESS_LINE: return createAddressLine();
			case XalPackage.ADDRESS_LINES: return createAddressLines();
			case XalPackage.ADDRESS_LONGITUDE: return createAddressLongitude();
			case XalPackage.ADDRESS_LONGITUDE_DIRECTION: return createAddressLongitudeDirection();
			case XalPackage.ADMINISTRATIVE_AREA: return createAdministrativeArea();
			case XalPackage.ADMINISTRATIVE_AREA_NAME: return createAdministrativeAreaName();
			case XalPackage.BARCODE: return createBarcode();
			case XalPackage.BUILDING_NAME: return createBuildingName();
			case XalPackage.COUNTRY: return createCountry();
			case XalPackage.COUNTRY_NAME: return createCountryName();
			case XalPackage.COUNTRY_NAME_CODE: return createCountryNameCode();
			case XalPackage.DEPARTMENT: return createDepartment();
			case XalPackage.DEPARTMENT_NAME: return createDepartmentName();
			case XalPackage.DEPENDENT_LOCALITY: return createDependentLocality();
			case XalPackage.DEPENDENT_LOCALITY_NAME: return createDependentLocalityName();
			case XalPackage.DEPENDENT_LOCALITY_NUMBER: return createDependentLocalityNumber();
			case XalPackage.DEPENDENT_THOROUGHFARE: return createDependentThoroughfare();
			case XalPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case XalPackage.ENDORSEMENT_LINE_CODE: return createEndorsementLineCode();
			case XalPackage.FIRM: return createFirm();
			case XalPackage.FIRM_NAME: return createFirmName();
			case XalPackage.KEY_LINE_CODE: return createKeyLineCode();
			case XalPackage.LARGE_MAIL_USER: return createLargeMailUser();
			case XalPackage.LARGE_MAIL_USER_IDENTIFIER: return createLargeMailUserIdentifier();
			case XalPackage.LARGE_MAIL_USER_NAME: return createLargeMailUserName();
			case XalPackage.LOCALITY: return createLocality();
			case XalPackage.LOCALITY_NAME: return createLocalityName();
			case XalPackage.MAIL_STOP: return createMailStop();
			case XalPackage.MAIL_STOP_NAME: return createMailStopName();
			case XalPackage.MAIL_STOP_NUMBER: return createMailStopNumber();
			case XalPackage.POSTAL_CODE: return createPostalCode();
			case XalPackage.POSTAL_CODE_NUMBER: return createPostalCodeNumber();
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION: return createPostalCodeNumberExtension();
			case XalPackage.POSTAL_ROUTE: return createPostalRoute();
			case XalPackage.POSTAL_ROUTE_NAME: return createPostalRouteName();
			case XalPackage.POSTAL_ROUTE_NUMBER: return createPostalRouteNumber();
			case XalPackage.POSTAL_SERVICE_ELEMENTS: return createPostalServiceElements();
			case XalPackage.POST_BOX: return createPostBox();
			case XalPackage.POST_BOX_NUMBER: return createPostBoxNumber();
			case XalPackage.POST_BOX_NUMBER_EXTENSION: return createPostBoxNumberExtension();
			case XalPackage.POST_BOX_NUMBER_PREFIX: return createPostBoxNumberPrefix();
			case XalPackage.POST_BOX_NUMBER_SUFFIX: return createPostBoxNumberSuffix();
			case XalPackage.POST_OFFICE: return createPostOffice();
			case XalPackage.POST_OFFICE_NAME: return createPostOfficeName();
			case XalPackage.POST_OFFICE_NUMBER: return createPostOfficeNumber();
			case XalPackage.POST_TOWN: return createPostTown();
			case XalPackage.POST_TOWN_NAME: return createPostTownName();
			case XalPackage.POST_TOWN_SUFFIX: return createPostTownSuffix();
			case XalPackage.PREMISE: return createPremise();
			case XalPackage.PREMISE_LOCATION: return createPremiseLocation();
			case XalPackage.PREMISE_NAME: return createPremiseName();
			case XalPackage.PREMISE_NUMBER: return createPremiseNumber();
			case XalPackage.PREMISE_NUMBER_PREFIX: return createPremiseNumberPrefix();
			case XalPackage.PREMISE_NUMBER_RANGE: return createPremiseNumberRange();
			case XalPackage.PREMISE_NUMBER_RANGE_FROM: return createPremiseNumberRangeFrom();
			case XalPackage.PREMISE_NUMBER_RANGE_TO: return createPremiseNumberRangeTo();
			case XalPackage.PREMISE_NUMBER_SUFFIX: return createPremiseNumberSuffix();
			case XalPackage.SORTING_CODE: return createSortingCode();
			case XalPackage.SUB_ADMINISTRATIVE_AREA: return createSubAdministrativeArea();
			case XalPackage.SUB_ADMINISTRATIVE_AREA_NAME: return createSubAdministrativeAreaName();
			case XalPackage.SUB_PREMISE: return createSubPremise();
			case XalPackage.SUB_PREMISE_LOCATION: return createSubPremiseLocation();
			case XalPackage.SUB_PREMISE_NAME: return createSubPremiseName();
			case XalPackage.SUB_PREMISE_NUMBER: return createSubPremiseNumber();
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX: return createSubPremiseNumberPrefix();
			case XalPackage.SUB_PREMISE_NUMBER_SUFFIX: return createSubPremiseNumberSuffix();
			case XalPackage.SUPPLEMENTARY_POSTAL_SERVICE_DATA: return createSupplementaryPostalServiceData();
			case XalPackage.THOROUGHFARE: return createThoroughfare();
			case XalPackage.THOROUGHFARE_LEADING_TYPE: return createThoroughfareLeadingType();
			case XalPackage.THOROUGHFARE_NAME: return createThoroughfareName();
			case XalPackage.THOROUGHFARE_NUMBER: return createThoroughfareNumber();
			case XalPackage.THOROUGHFARE_NUMBER_FROM: return createThoroughfareNumberFrom();
			case XalPackage.THOROUGHFARE_NUMBER_PREFIX: return createThoroughfareNumberPrefix();
			case XalPackage.THOROUGHFARE_NUMBER_RANGE: return createThoroughfareNumberRange();
			case XalPackage.THOROUGHFARE_NUMBER_SUFFIX: return createThoroughfareNumberSuffix();
			case XalPackage.THOROUGHFARE_NUMBER_TO: return createThoroughfareNumberTo();
			case XalPackage.THOROUGHFARE_POST_DIRECTION: return createThoroughfarePostDirection();
			case XalPackage.THOROUGHFARE_PRE_DIRECTION: return createThoroughfarePreDirection();
			case XalPackage.THOROUGHFARE_TRAILING_TYPE: return createThoroughfareTrailingType();
			case XalPackage.XAL: return createXal();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case XalPackage.DEPENDENT_THOROUGHFARES_TYPE:
				return createDependentThoroughfaresTypeFromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURENCE:
				return createIndicatorOccurenceFromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE:
				return createIndicatorOccurrenceFromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE1:
				return createIndicatorOccurrence1FromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE2:
				return createIndicatorOccurrence2FromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE3:
				return createIndicatorOccurrence3FromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE4:
				return createIndicatorOccurrence4FromString(eDataType, initialValue);
			case XalPackage.NAME_NUMBER_OCCURRENCE:
				return createNameNumberOccurrenceFromString(eDataType, initialValue);
			case XalPackage.NUMBER_OCCURRENCE:
				return createNumberOccurrenceFromString(eDataType, initialValue);
			case XalPackage.NUMBER_RANGE_OCCURENCE:
				return createNumberRangeOccurenceFromString(eDataType, initialValue);
			case XalPackage.NUMBER_RANGE_OCCURRENCE:
				return createNumberRangeOccurrenceFromString(eDataType, initialValue);
			case XalPackage.NUMBER_TYPE_OCCURRENCE:
				return createNumberTypeOccurrenceFromString(eDataType, initialValue);
			case XalPackage.NUMBER_TYPE_OCCURRENCE1:
				return createNumberTypeOccurrence1FromString(eDataType, initialValue);
			case XalPackage.NUMBER_TYPE_TYPE:
				return createNumberTypeTypeFromString(eDataType, initialValue);
			case XalPackage.NUMBER_TYPE_TYPE1:
				return createNumberTypeType1FromString(eDataType, initialValue);
			case XalPackage.RANGE_TYPE_TYPE:
				return createRangeTypeTypeFromString(eDataType, initialValue);
			case XalPackage.TYPE_OCCURRENCE:
				return createTypeOccurrenceFromString(eDataType, initialValue);
			case XalPackage.TYPE_OCCURRENCE1:
				return createTypeOccurrence1FromString(eDataType, initialValue);
			case XalPackage.TYPE_OCCURRENCE2:
				return createTypeOccurrence2FromString(eDataType, initialValue);
			case XalPackage.DEPENDENT_THOROUGHFARES_TYPE_OBJECT:
				return createDependentThoroughfaresTypeObjectFromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURENCE_OBJECT:
				return createIndicatorOccurenceObjectFromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT:
				return createIndicatorOccurrenceObjectFromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT1:
				return createIndicatorOccurrenceObject1FromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT2:
				return createIndicatorOccurrenceObject2FromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT3:
				return createIndicatorOccurrenceObject3FromString(eDataType, initialValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT4:
				return createIndicatorOccurrenceObject4FromString(eDataType, initialValue);
			case XalPackage.NAME_NUMBER_OCCURRENCE_OBJECT:
				return createNameNumberOccurrenceObjectFromString(eDataType, initialValue);
			case XalPackage.NUMBER_OCCURRENCE_OBJECT:
				return createNumberOccurrenceObjectFromString(eDataType, initialValue);
			case XalPackage.NUMBER_RANGE_OCCURENCE_OBJECT:
				return createNumberRangeOccurenceObjectFromString(eDataType, initialValue);
			case XalPackage.NUMBER_RANGE_OCCURRENCE_OBJECT:
				return createNumberRangeOccurrenceObjectFromString(eDataType, initialValue);
			case XalPackage.NUMBER_TYPE_OCCURRENCE_OBJECT:
				return createNumberTypeOccurrenceObjectFromString(eDataType, initialValue);
			case XalPackage.NUMBER_TYPE_OCCURRENCE_OBJECT1:
				return createNumberTypeOccurrenceObject1FromString(eDataType, initialValue);
			case XalPackage.NUMBER_TYPE_TYPE_OBJECT:
				return createNumberTypeTypeObjectFromString(eDataType, initialValue);
			case XalPackage.NUMBER_TYPE_TYPE_OBJECT1:
				return createNumberTypeTypeObject1FromString(eDataType, initialValue);
			case XalPackage.RANGE_TYPE_TYPE_OBJECT:
				return createRangeTypeTypeObjectFromString(eDataType, initialValue);
			case XalPackage.TYPE_OCCURRENCE_OBJECT:
				return createTypeOccurrenceObjectFromString(eDataType, initialValue);
			case XalPackage.TYPE_OCCURRENCE_OBJECT1:
				return createTypeOccurrenceObject1FromString(eDataType, initialValue);
			case XalPackage.TYPE_OCCURRENCE_OBJECT2:
				return createTypeOccurrenceObject2FromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case XalPackage.DEPENDENT_THOROUGHFARES_TYPE:
				return convertDependentThoroughfaresTypeToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURENCE:
				return convertIndicatorOccurenceToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE:
				return convertIndicatorOccurrenceToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE1:
				return convertIndicatorOccurrence1ToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE2:
				return convertIndicatorOccurrence2ToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE3:
				return convertIndicatorOccurrence3ToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE4:
				return convertIndicatorOccurrence4ToString(eDataType, instanceValue);
			case XalPackage.NAME_NUMBER_OCCURRENCE:
				return convertNameNumberOccurrenceToString(eDataType, instanceValue);
			case XalPackage.NUMBER_OCCURRENCE:
				return convertNumberOccurrenceToString(eDataType, instanceValue);
			case XalPackage.NUMBER_RANGE_OCCURENCE:
				return convertNumberRangeOccurenceToString(eDataType, instanceValue);
			case XalPackage.NUMBER_RANGE_OCCURRENCE:
				return convertNumberRangeOccurrenceToString(eDataType, instanceValue);
			case XalPackage.NUMBER_TYPE_OCCURRENCE:
				return convertNumberTypeOccurrenceToString(eDataType, instanceValue);
			case XalPackage.NUMBER_TYPE_OCCURRENCE1:
				return convertNumberTypeOccurrence1ToString(eDataType, instanceValue);
			case XalPackage.NUMBER_TYPE_TYPE:
				return convertNumberTypeTypeToString(eDataType, instanceValue);
			case XalPackage.NUMBER_TYPE_TYPE1:
				return convertNumberTypeType1ToString(eDataType, instanceValue);
			case XalPackage.RANGE_TYPE_TYPE:
				return convertRangeTypeTypeToString(eDataType, instanceValue);
			case XalPackage.TYPE_OCCURRENCE:
				return convertTypeOccurrenceToString(eDataType, instanceValue);
			case XalPackage.TYPE_OCCURRENCE1:
				return convertTypeOccurrence1ToString(eDataType, instanceValue);
			case XalPackage.TYPE_OCCURRENCE2:
				return convertTypeOccurrence2ToString(eDataType, instanceValue);
			case XalPackage.DEPENDENT_THOROUGHFARES_TYPE_OBJECT:
				return convertDependentThoroughfaresTypeObjectToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURENCE_OBJECT:
				return convertIndicatorOccurenceObjectToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT:
				return convertIndicatorOccurrenceObjectToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT1:
				return convertIndicatorOccurrenceObject1ToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT2:
				return convertIndicatorOccurrenceObject2ToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT3:
				return convertIndicatorOccurrenceObject3ToString(eDataType, instanceValue);
			case XalPackage.INDICATOR_OCCURRENCE_OBJECT4:
				return convertIndicatorOccurrenceObject4ToString(eDataType, instanceValue);
			case XalPackage.NAME_NUMBER_OCCURRENCE_OBJECT:
				return convertNameNumberOccurrenceObjectToString(eDataType, instanceValue);
			case XalPackage.NUMBER_OCCURRENCE_OBJECT:
				return convertNumberOccurrenceObjectToString(eDataType, instanceValue);
			case XalPackage.NUMBER_RANGE_OCCURENCE_OBJECT:
				return convertNumberRangeOccurenceObjectToString(eDataType, instanceValue);
			case XalPackage.NUMBER_RANGE_OCCURRENCE_OBJECT:
				return convertNumberRangeOccurrenceObjectToString(eDataType, instanceValue);
			case XalPackage.NUMBER_TYPE_OCCURRENCE_OBJECT:
				return convertNumberTypeOccurrenceObjectToString(eDataType, instanceValue);
			case XalPackage.NUMBER_TYPE_OCCURRENCE_OBJECT1:
				return convertNumberTypeOccurrenceObject1ToString(eDataType, instanceValue);
			case XalPackage.NUMBER_TYPE_TYPE_OBJECT:
				return convertNumberTypeTypeObjectToString(eDataType, instanceValue);
			case XalPackage.NUMBER_TYPE_TYPE_OBJECT1:
				return convertNumberTypeTypeObject1ToString(eDataType, instanceValue);
			case XalPackage.RANGE_TYPE_TYPE_OBJECT:
				return convertRangeTypeTypeObjectToString(eDataType, instanceValue);
			case XalPackage.TYPE_OCCURRENCE_OBJECT:
				return convertTypeOccurrenceObjectToString(eDataType, instanceValue);
			case XalPackage.TYPE_OCCURRENCE_OBJECT1:
				return convertTypeOccurrenceObject1ToString(eDataType, instanceValue);
			case XalPackage.TYPE_OCCURRENCE_OBJECT2:
				return convertTypeOccurrenceObject2ToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Address createAddress() {
		AddressImpl address = new AddressImpl();
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressDetails createAddressDetails() {
		AddressDetailsImpl addressDetails = new AddressDetailsImpl();
		return addressDetails;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressIdentifier createAddressIdentifier() {
		AddressIdentifierImpl addressIdentifier = new AddressIdentifierImpl();
		return addressIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLatitude createAddressLatitude() {
		AddressLatitudeImpl addressLatitude = new AddressLatitudeImpl();
		return addressLatitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLatitudeDirection createAddressLatitudeDirection() {
		AddressLatitudeDirectionImpl addressLatitudeDirection = new AddressLatitudeDirectionImpl();
		return addressLatitudeDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLine createAddressLine() {
		AddressLineImpl addressLine = new AddressLineImpl();
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLines createAddressLines() {
		AddressLinesImpl addressLines = new AddressLinesImpl();
		return addressLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLongitude createAddressLongitude() {
		AddressLongitudeImpl addressLongitude = new AddressLongitudeImpl();
		return addressLongitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLongitudeDirection createAddressLongitudeDirection() {
		AddressLongitudeDirectionImpl addressLongitudeDirection = new AddressLongitudeDirectionImpl();
		return addressLongitudeDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdministrativeArea createAdministrativeArea() {
		AdministrativeAreaImpl administrativeArea = new AdministrativeAreaImpl();
		return administrativeArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdministrativeAreaName createAdministrativeAreaName() {
		AdministrativeAreaNameImpl administrativeAreaName = new AdministrativeAreaNameImpl();
		return administrativeAreaName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Barcode createBarcode() {
		BarcodeImpl barcode = new BarcodeImpl();
		return barcode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildingName createBuildingName() {
		BuildingNameImpl buildingName = new BuildingNameImpl();
		return buildingName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Country createCountry() {
		CountryImpl country = new CountryImpl();
		return country;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountryName createCountryName() {
		CountryNameImpl countryName = new CountryNameImpl();
		return countryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountryNameCode createCountryNameCode() {
		CountryNameCodeImpl countryNameCode = new CountryNameCodeImpl();
		return countryNameCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Department createDepartment() {
		DepartmentImpl department = new DepartmentImpl();
		return department;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepartmentName createDepartmentName() {
		DepartmentNameImpl departmentName = new DepartmentNameImpl();
		return departmentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependentLocality createDependentLocality() {
		DependentLocalityImpl dependentLocality = new DependentLocalityImpl();
		return dependentLocality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependentLocalityName createDependentLocalityName() {
		DependentLocalityNameImpl dependentLocalityName = new DependentLocalityNameImpl();
		return dependentLocalityName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependentLocalityNumber createDependentLocalityNumber() {
		DependentLocalityNumberImpl dependentLocalityNumber = new DependentLocalityNumberImpl();
		return dependentLocalityNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependentThoroughfare createDependentThoroughfare() {
		DependentThoroughfareImpl dependentThoroughfare = new DependentThoroughfareImpl();
		return dependentThoroughfare;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndorsementLineCode createEndorsementLineCode() {
		EndorsementLineCodeImpl endorsementLineCode = new EndorsementLineCodeImpl();
		return endorsementLineCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Firm createFirm() {
		FirmImpl firm = new FirmImpl();
		return firm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FirmName createFirmName() {
		FirmNameImpl firmName = new FirmNameImpl();
		return firmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyLineCode createKeyLineCode() {
		KeyLineCodeImpl keyLineCode = new KeyLineCodeImpl();
		return keyLineCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LargeMailUser createLargeMailUser() {
		LargeMailUserImpl largeMailUser = new LargeMailUserImpl();
		return largeMailUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LargeMailUserIdentifier createLargeMailUserIdentifier() {
		LargeMailUserIdentifierImpl largeMailUserIdentifier = new LargeMailUserIdentifierImpl();
		return largeMailUserIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LargeMailUserName createLargeMailUserName() {
		LargeMailUserNameImpl largeMailUserName = new LargeMailUserNameImpl();
		return largeMailUserName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Locality createLocality() {
		LocalityImpl locality = new LocalityImpl();
		return locality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalityName createLocalityName() {
		LocalityNameImpl localityName = new LocalityNameImpl();
		return localityName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailStop createMailStop() {
		MailStopImpl mailStop = new MailStopImpl();
		return mailStop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailStopName createMailStopName() {
		MailStopNameImpl mailStopName = new MailStopNameImpl();
		return mailStopName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailStopNumber createMailStopNumber() {
		MailStopNumberImpl mailStopNumber = new MailStopNumberImpl();
		return mailStopNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalCode createPostalCode() {
		PostalCodeImpl postalCode = new PostalCodeImpl();
		return postalCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalCodeNumber createPostalCodeNumber() {
		PostalCodeNumberImpl postalCodeNumber = new PostalCodeNumberImpl();
		return postalCodeNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalCodeNumberExtension createPostalCodeNumberExtension() {
		PostalCodeNumberExtensionImpl postalCodeNumberExtension = new PostalCodeNumberExtensionImpl();
		return postalCodeNumberExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalRoute createPostalRoute() {
		PostalRouteImpl postalRoute = new PostalRouteImpl();
		return postalRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalRouteName createPostalRouteName() {
		PostalRouteNameImpl postalRouteName = new PostalRouteNameImpl();
		return postalRouteName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalRouteNumber createPostalRouteNumber() {
		PostalRouteNumberImpl postalRouteNumber = new PostalRouteNumberImpl();
		return postalRouteNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalServiceElements createPostalServiceElements() {
		PostalServiceElementsImpl postalServiceElements = new PostalServiceElementsImpl();
		return postalServiceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBox createPostBox() {
		PostBoxImpl postBox = new PostBoxImpl();
		return postBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBoxNumber createPostBoxNumber() {
		PostBoxNumberImpl postBoxNumber = new PostBoxNumberImpl();
		return postBoxNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBoxNumberExtension createPostBoxNumberExtension() {
		PostBoxNumberExtensionImpl postBoxNumberExtension = new PostBoxNumberExtensionImpl();
		return postBoxNumberExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBoxNumberPrefix createPostBoxNumberPrefix() {
		PostBoxNumberPrefixImpl postBoxNumberPrefix = new PostBoxNumberPrefixImpl();
		return postBoxNumberPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBoxNumberSuffix createPostBoxNumberSuffix() {
		PostBoxNumberSuffixImpl postBoxNumberSuffix = new PostBoxNumberSuffixImpl();
		return postBoxNumberSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostOffice createPostOffice() {
		PostOfficeImpl postOffice = new PostOfficeImpl();
		return postOffice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostOfficeName createPostOfficeName() {
		PostOfficeNameImpl postOfficeName = new PostOfficeNameImpl();
		return postOfficeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostOfficeNumber createPostOfficeNumber() {
		PostOfficeNumberImpl postOfficeNumber = new PostOfficeNumberImpl();
		return postOfficeNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostTown createPostTown() {
		PostTownImpl postTown = new PostTownImpl();
		return postTown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostTownName createPostTownName() {
		PostTownNameImpl postTownName = new PostTownNameImpl();
		return postTownName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostTownSuffix createPostTownSuffix() {
		PostTownSuffixImpl postTownSuffix = new PostTownSuffixImpl();
		return postTownSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premise createPremise() {
		PremiseImpl premise = new PremiseImpl();
		return premise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseLocation createPremiseLocation() {
		PremiseLocationImpl premiseLocation = new PremiseLocationImpl();
		return premiseLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseName createPremiseName() {
		PremiseNameImpl premiseName = new PremiseNameImpl();
		return premiseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumber createPremiseNumber() {
		PremiseNumberImpl premiseNumber = new PremiseNumberImpl();
		return premiseNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberPrefix createPremiseNumberPrefix() {
		PremiseNumberPrefixImpl premiseNumberPrefix = new PremiseNumberPrefixImpl();
		return premiseNumberPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberRange createPremiseNumberRange() {
		PremiseNumberRangeImpl premiseNumberRange = new PremiseNumberRangeImpl();
		return premiseNumberRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberRangeFrom createPremiseNumberRangeFrom() {
		PremiseNumberRangeFromImpl premiseNumberRangeFrom = new PremiseNumberRangeFromImpl();
		return premiseNumberRangeFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberRangeTo createPremiseNumberRangeTo() {
		PremiseNumberRangeToImpl premiseNumberRangeTo = new PremiseNumberRangeToImpl();
		return premiseNumberRangeTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberSuffix createPremiseNumberSuffix() {
		PremiseNumberSuffixImpl premiseNumberSuffix = new PremiseNumberSuffixImpl();
		return premiseNumberSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortingCode createSortingCode() {
		SortingCodeImpl sortingCode = new SortingCodeImpl();
		return sortingCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAdministrativeArea createSubAdministrativeArea() {
		SubAdministrativeAreaImpl subAdministrativeArea = new SubAdministrativeAreaImpl();
		return subAdministrativeArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAdministrativeAreaName createSubAdministrativeAreaName() {
		SubAdministrativeAreaNameImpl subAdministrativeAreaName = new SubAdministrativeAreaNameImpl();
		return subAdministrativeAreaName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPremise createSubPremise() {
		SubPremiseImpl subPremise = new SubPremiseImpl();
		return subPremise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPremiseLocation createSubPremiseLocation() {
		SubPremiseLocationImpl subPremiseLocation = new SubPremiseLocationImpl();
		return subPremiseLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPremiseName createSubPremiseName() {
		SubPremiseNameImpl subPremiseName = new SubPremiseNameImpl();
		return subPremiseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPremiseNumber createSubPremiseNumber() {
		SubPremiseNumberImpl subPremiseNumber = new SubPremiseNumberImpl();
		return subPremiseNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPremiseNumberPrefix createSubPremiseNumberPrefix() {
		SubPremiseNumberPrefixImpl subPremiseNumberPrefix = new SubPremiseNumberPrefixImpl();
		return subPremiseNumberPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPremiseNumberSuffix createSubPremiseNumberSuffix() {
		SubPremiseNumberSuffixImpl subPremiseNumberSuffix = new SubPremiseNumberSuffixImpl();
		return subPremiseNumberSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupplementaryPostalServiceData createSupplementaryPostalServiceData() {
		SupplementaryPostalServiceDataImpl supplementaryPostalServiceData = new SupplementaryPostalServiceDataImpl();
		return supplementaryPostalServiceData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Thoroughfare createThoroughfare() {
		ThoroughfareImpl thoroughfare = new ThoroughfareImpl();
		return thoroughfare;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareLeadingType createThoroughfareLeadingType() {
		ThoroughfareLeadingTypeImpl thoroughfareLeadingType = new ThoroughfareLeadingTypeImpl();
		return thoroughfareLeadingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareName createThoroughfareName() {
		ThoroughfareNameImpl thoroughfareName = new ThoroughfareNameImpl();
		return thoroughfareName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumber createThoroughfareNumber() {
		ThoroughfareNumberImpl thoroughfareNumber = new ThoroughfareNumberImpl();
		return thoroughfareNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberFrom createThoroughfareNumberFrom() {
		ThoroughfareNumberFromImpl thoroughfareNumberFrom = new ThoroughfareNumberFromImpl();
		return thoroughfareNumberFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberPrefix createThoroughfareNumberPrefix() {
		ThoroughfareNumberPrefixImpl thoroughfareNumberPrefix = new ThoroughfareNumberPrefixImpl();
		return thoroughfareNumberPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberRange createThoroughfareNumberRange() {
		ThoroughfareNumberRangeImpl thoroughfareNumberRange = new ThoroughfareNumberRangeImpl();
		return thoroughfareNumberRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberSuffix createThoroughfareNumberSuffix() {
		ThoroughfareNumberSuffixImpl thoroughfareNumberSuffix = new ThoroughfareNumberSuffixImpl();
		return thoroughfareNumberSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberTo createThoroughfareNumberTo() {
		ThoroughfareNumberToImpl thoroughfareNumberTo = new ThoroughfareNumberToImpl();
		return thoroughfareNumberTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfarePostDirection createThoroughfarePostDirection() {
		ThoroughfarePostDirectionImpl thoroughfarePostDirection = new ThoroughfarePostDirectionImpl();
		return thoroughfarePostDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfarePreDirection createThoroughfarePreDirection() {
		ThoroughfarePreDirectionImpl thoroughfarePreDirection = new ThoroughfarePreDirectionImpl();
		return thoroughfarePreDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareTrailingType createThoroughfareTrailingType() {
		ThoroughfareTrailingTypeImpl thoroughfareTrailingType = new ThoroughfareTrailingTypeImpl();
		return thoroughfareTrailingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xal createXal() {
		XalImpl xal = new XalImpl();
		return xal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependentThoroughfaresType createDependentThoroughfaresTypeFromString(EDataType eDataType, String initialValue) {
		DependentThoroughfaresType result = DependentThoroughfaresType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependentThoroughfaresTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurence createIndicatorOccurenceFromString(EDataType eDataType, String initialValue) {
		IndicatorOccurence result = IndicatorOccurence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence createIndicatorOccurrenceFromString(EDataType eDataType, String initialValue) {
		IndicatorOccurrence result = IndicatorOccurrence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence1 createIndicatorOccurrence1FromString(EDataType eDataType, String initialValue) {
		IndicatorOccurrence1 result = IndicatorOccurrence1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrence1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence2 createIndicatorOccurrence2FromString(EDataType eDataType, String initialValue) {
		IndicatorOccurrence2 result = IndicatorOccurrence2.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrence2ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence3 createIndicatorOccurrence3FromString(EDataType eDataType, String initialValue) {
		IndicatorOccurrence3 result = IndicatorOccurrence3.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrence3ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence4 createIndicatorOccurrence4FromString(EDataType eDataType, String initialValue) {
		IndicatorOccurrence4 result = IndicatorOccurrence4.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrence4ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameNumberOccurrence createNameNumberOccurrenceFromString(EDataType eDataType, String initialValue) {
		NameNumberOccurrence result = NameNumberOccurrence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNameNumberOccurrenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberOccurrence createNumberOccurrenceFromString(EDataType eDataType, String initialValue) {
		NumberOccurrence result = NumberOccurrence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberOccurrenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberRangeOccurence createNumberRangeOccurenceFromString(EDataType eDataType, String initialValue) {
		NumberRangeOccurence result = NumberRangeOccurence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberRangeOccurenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberRangeOccurrence createNumberRangeOccurrenceFromString(EDataType eDataType, String initialValue) {
		NumberRangeOccurrence result = NumberRangeOccurrence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberRangeOccurrenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeOccurrence createNumberTypeOccurrenceFromString(EDataType eDataType, String initialValue) {
		NumberTypeOccurrence result = NumberTypeOccurrence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberTypeOccurrenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeOccurrence1 createNumberTypeOccurrence1FromString(EDataType eDataType, String initialValue) {
		NumberTypeOccurrence1 result = NumberTypeOccurrence1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberTypeOccurrence1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeType createNumberTypeTypeFromString(EDataType eDataType, String initialValue) {
		NumberTypeType result = NumberTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeType1 createNumberTypeType1FromString(EDataType eDataType, String initialValue) {
		NumberTypeType1 result = NumberTypeType1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberTypeType1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeTypeType createRangeTypeTypeFromString(EDataType eDataType, String initialValue) {
		RangeTypeType result = RangeTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRangeTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeOccurrence createTypeOccurrenceFromString(EDataType eDataType, String initialValue) {
		TypeOccurrence result = TypeOccurrence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeOccurrenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeOccurrence1 createTypeOccurrence1FromString(EDataType eDataType, String initialValue) {
		TypeOccurrence1 result = TypeOccurrence1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeOccurrence1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeOccurrence2 createTypeOccurrence2FromString(EDataType eDataType, String initialValue) {
		TypeOccurrence2 result = TypeOccurrence2.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeOccurrence2ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependentThoroughfaresType createDependentThoroughfaresTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDependentThoroughfaresTypeFromString(XalPackage.eINSTANCE.getDependentThoroughfaresType(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependentThoroughfaresTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDependentThoroughfaresTypeToString(XalPackage.eINSTANCE.getDependentThoroughfaresType(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurence createIndicatorOccurenceObjectFromString(EDataType eDataType, String initialValue) {
		return createIndicatorOccurenceFromString(XalPackage.eINSTANCE.getIndicatorOccurence(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurenceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertIndicatorOccurenceToString(XalPackage.eINSTANCE.getIndicatorOccurence(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence1 createIndicatorOccurrenceObjectFromString(EDataType eDataType, String initialValue) {
		return createIndicatorOccurrence1FromString(XalPackage.eINSTANCE.getIndicatorOccurrence1(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrenceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertIndicatorOccurrence1ToString(XalPackage.eINSTANCE.getIndicatorOccurrence1(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence3 createIndicatorOccurrenceObject1FromString(EDataType eDataType, String initialValue) {
		return createIndicatorOccurrence3FromString(XalPackage.eINSTANCE.getIndicatorOccurrence3(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrenceObject1ToString(EDataType eDataType, Object instanceValue) {
		return convertIndicatorOccurrence3ToString(XalPackage.eINSTANCE.getIndicatorOccurrence3(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence2 createIndicatorOccurrenceObject2FromString(EDataType eDataType, String initialValue) {
		return createIndicatorOccurrence2FromString(XalPackage.eINSTANCE.getIndicatorOccurrence2(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrenceObject2ToString(EDataType eDataType, Object instanceValue) {
		return convertIndicatorOccurrence2ToString(XalPackage.eINSTANCE.getIndicatorOccurrence2(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence createIndicatorOccurrenceObject3FromString(EDataType eDataType, String initialValue) {
		return createIndicatorOccurrenceFromString(XalPackage.eINSTANCE.getIndicatorOccurrence(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrenceObject3ToString(EDataType eDataType, Object instanceValue) {
		return convertIndicatorOccurrenceToString(XalPackage.eINSTANCE.getIndicatorOccurrence(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndicatorOccurrence4 createIndicatorOccurrenceObject4FromString(EDataType eDataType, String initialValue) {
		return createIndicatorOccurrence4FromString(XalPackage.eINSTANCE.getIndicatorOccurrence4(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndicatorOccurrenceObject4ToString(EDataType eDataType, Object instanceValue) {
		return convertIndicatorOccurrence4ToString(XalPackage.eINSTANCE.getIndicatorOccurrence4(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameNumberOccurrence createNameNumberOccurrenceObjectFromString(EDataType eDataType, String initialValue) {
		return createNameNumberOccurrenceFromString(XalPackage.eINSTANCE.getNameNumberOccurrence(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNameNumberOccurrenceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertNameNumberOccurrenceToString(XalPackage.eINSTANCE.getNameNumberOccurrence(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberOccurrence createNumberOccurrenceObjectFromString(EDataType eDataType, String initialValue) {
		return createNumberOccurrenceFromString(XalPackage.eINSTANCE.getNumberOccurrence(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberOccurrenceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertNumberOccurrenceToString(XalPackage.eINSTANCE.getNumberOccurrence(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberRangeOccurence createNumberRangeOccurenceObjectFromString(EDataType eDataType, String initialValue) {
		return createNumberRangeOccurenceFromString(XalPackage.eINSTANCE.getNumberRangeOccurence(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberRangeOccurenceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertNumberRangeOccurenceToString(XalPackage.eINSTANCE.getNumberRangeOccurence(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberRangeOccurrence createNumberRangeOccurrenceObjectFromString(EDataType eDataType, String initialValue) {
		return createNumberRangeOccurrenceFromString(XalPackage.eINSTANCE.getNumberRangeOccurrence(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberRangeOccurrenceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertNumberRangeOccurrenceToString(XalPackage.eINSTANCE.getNumberRangeOccurrence(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeOccurrence createNumberTypeOccurrenceObjectFromString(EDataType eDataType, String initialValue) {
		return createNumberTypeOccurrenceFromString(XalPackage.eINSTANCE.getNumberTypeOccurrence(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberTypeOccurrenceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertNumberTypeOccurrenceToString(XalPackage.eINSTANCE.getNumberTypeOccurrence(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeOccurrence1 createNumberTypeOccurrenceObject1FromString(EDataType eDataType, String initialValue) {
		return createNumberTypeOccurrence1FromString(XalPackage.eINSTANCE.getNumberTypeOccurrence1(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberTypeOccurrenceObject1ToString(EDataType eDataType, Object instanceValue) {
		return convertNumberTypeOccurrence1ToString(XalPackage.eINSTANCE.getNumberTypeOccurrence1(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeType createNumberTypeTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createNumberTypeTypeFromString(XalPackage.eINSTANCE.getNumberTypeType(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberTypeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertNumberTypeTypeToString(XalPackage.eINSTANCE.getNumberTypeType(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTypeType1 createNumberTypeTypeObject1FromString(EDataType eDataType, String initialValue) {
		return createNumberTypeType1FromString(XalPackage.eINSTANCE.getNumberTypeType1(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberTypeTypeObject1ToString(EDataType eDataType, Object instanceValue) {
		return convertNumberTypeType1ToString(XalPackage.eINSTANCE.getNumberTypeType1(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeTypeType createRangeTypeTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createRangeTypeTypeFromString(XalPackage.eINSTANCE.getRangeTypeType(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRangeTypeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertRangeTypeTypeToString(XalPackage.eINSTANCE.getRangeTypeType(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeOccurrence createTypeOccurrenceObjectFromString(EDataType eDataType, String initialValue) {
		return createTypeOccurrenceFromString(XalPackage.eINSTANCE.getTypeOccurrence(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeOccurrenceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTypeOccurrenceToString(XalPackage.eINSTANCE.getTypeOccurrence(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeOccurrence1 createTypeOccurrenceObject1FromString(EDataType eDataType, String initialValue) {
		return createTypeOccurrence1FromString(XalPackage.eINSTANCE.getTypeOccurrence1(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeOccurrenceObject1ToString(EDataType eDataType, Object instanceValue) {
		return convertTypeOccurrence1ToString(XalPackage.eINSTANCE.getTypeOccurrence1(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeOccurrence2 createTypeOccurrenceObject2FromString(EDataType eDataType, String initialValue) {
		return createTypeOccurrence2FromString(XalPackage.eINSTANCE.getTypeOccurrence2(), initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeOccurrenceObject2ToString(EDataType eDataType, Object instanceValue) {
		return convertTypeOccurrence2ToString(XalPackage.eINSTANCE.getTypeOccurrence2(), instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XalPackage getXalPackage() {
		return (XalPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XalPackage getPackage() {
		return XalPackage.eINSTANCE;
	}

} //XalFactoryImpl
