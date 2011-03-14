/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.verticon.oasis.xal.XalPackage
 * @generated
 */
public interface XalFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XalFactory eINSTANCE = com.verticon.oasis.xal.impl.XalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address</em>'.
	 * @generated
	 */
	Address createAddress();

	/**
	 * Returns a new object of class '<em>Address Details</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Details</em>'.
	 * @generated
	 */
	AddressDetails createAddressDetails();

	/**
	 * Returns a new object of class '<em>Address Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Identifier</em>'.
	 * @generated
	 */
	AddressIdentifier createAddressIdentifier();

	/**
	 * Returns a new object of class '<em>Address Latitude</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Latitude</em>'.
	 * @generated
	 */
	AddressLatitude createAddressLatitude();

	/**
	 * Returns a new object of class '<em>Address Latitude Direction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Latitude Direction</em>'.
	 * @generated
	 */
	AddressLatitudeDirection createAddressLatitudeDirection();

	/**
	 * Returns a new object of class '<em>Address Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Line</em>'.
	 * @generated
	 */
	AddressLine createAddressLine();

	/**
	 * Returns a new object of class '<em>Address Lines</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Lines</em>'.
	 * @generated
	 */
	AddressLines createAddressLines();

	/**
	 * Returns a new object of class '<em>Address Longitude</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Longitude</em>'.
	 * @generated
	 */
	AddressLongitude createAddressLongitude();

	/**
	 * Returns a new object of class '<em>Address Longitude Direction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Longitude Direction</em>'.
	 * @generated
	 */
	AddressLongitudeDirection createAddressLongitudeDirection();

	/**
	 * Returns a new object of class '<em>Administrative Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Administrative Area</em>'.
	 * @generated
	 */
	AdministrativeArea createAdministrativeArea();

	/**
	 * Returns a new object of class '<em>Administrative Area Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Administrative Area Name</em>'.
	 * @generated
	 */
	AdministrativeAreaName createAdministrativeAreaName();

	/**
	 * Returns a new object of class '<em>Barcode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Barcode</em>'.
	 * @generated
	 */
	Barcode createBarcode();

	/**
	 * Returns a new object of class '<em>Building Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Building Name</em>'.
	 * @generated
	 */
	BuildingName createBuildingName();

	/**
	 * Returns a new object of class '<em>Country</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Country</em>'.
	 * @generated
	 */
	Country createCountry();

	/**
	 * Returns a new object of class '<em>Country Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Country Name</em>'.
	 * @generated
	 */
	CountryName createCountryName();

	/**
	 * Returns a new object of class '<em>Country Name Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Country Name Code</em>'.
	 * @generated
	 */
	CountryNameCode createCountryNameCode();

	/**
	 * Returns a new object of class '<em>Department</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Department</em>'.
	 * @generated
	 */
	Department createDepartment();

	/**
	 * Returns a new object of class '<em>Department Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Department Name</em>'.
	 * @generated
	 */
	DepartmentName createDepartmentName();

	/**
	 * Returns a new object of class '<em>Dependent Locality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependent Locality</em>'.
	 * @generated
	 */
	DependentLocality createDependentLocality();

	/**
	 * Returns a new object of class '<em>Dependent Locality Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependent Locality Name</em>'.
	 * @generated
	 */
	DependentLocalityName createDependentLocalityName();

	/**
	 * Returns a new object of class '<em>Dependent Locality Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependent Locality Number</em>'.
	 * @generated
	 */
	DependentLocalityNumber createDependentLocalityNumber();

	/**
	 * Returns a new object of class '<em>Dependent Thoroughfare</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependent Thoroughfare</em>'.
	 * @generated
	 */
	DependentThoroughfare createDependentThoroughfare();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Endorsement Line Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Endorsement Line Code</em>'.
	 * @generated
	 */
	EndorsementLineCode createEndorsementLineCode();

	/**
	 * Returns a new object of class '<em>Firm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Firm</em>'.
	 * @generated
	 */
	Firm createFirm();

	/**
	 * Returns a new object of class '<em>Firm Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Firm Name</em>'.
	 * @generated
	 */
	FirmName createFirmName();

	/**
	 * Returns a new object of class '<em>Key Line Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Line Code</em>'.
	 * @generated
	 */
	KeyLineCode createKeyLineCode();

	/**
	 * Returns a new object of class '<em>Large Mail User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Large Mail User</em>'.
	 * @generated
	 */
	LargeMailUser createLargeMailUser();

	/**
	 * Returns a new object of class '<em>Large Mail User Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Large Mail User Identifier</em>'.
	 * @generated
	 */
	LargeMailUserIdentifier createLargeMailUserIdentifier();

	/**
	 * Returns a new object of class '<em>Large Mail User Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Large Mail User Name</em>'.
	 * @generated
	 */
	LargeMailUserName createLargeMailUserName();

	/**
	 * Returns a new object of class '<em>Locality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Locality</em>'.
	 * @generated
	 */
	Locality createLocality();

	/**
	 * Returns a new object of class '<em>Locality Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Locality Name</em>'.
	 * @generated
	 */
	LocalityName createLocalityName();

	/**
	 * Returns a new object of class '<em>Mail Stop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mail Stop</em>'.
	 * @generated
	 */
	MailStop createMailStop();

	/**
	 * Returns a new object of class '<em>Mail Stop Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mail Stop Name</em>'.
	 * @generated
	 */
	MailStopName createMailStopName();

	/**
	 * Returns a new object of class '<em>Mail Stop Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mail Stop Number</em>'.
	 * @generated
	 */
	MailStopNumber createMailStopNumber();

	/**
	 * Returns a new object of class '<em>Postal Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postal Code</em>'.
	 * @generated
	 */
	PostalCode createPostalCode();

	/**
	 * Returns a new object of class '<em>Postal Code Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postal Code Number</em>'.
	 * @generated
	 */
	PostalCodeNumber createPostalCodeNumber();

	/**
	 * Returns a new object of class '<em>Postal Code Number Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postal Code Number Extension</em>'.
	 * @generated
	 */
	PostalCodeNumberExtension createPostalCodeNumberExtension();

	/**
	 * Returns a new object of class '<em>Postal Route</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postal Route</em>'.
	 * @generated
	 */
	PostalRoute createPostalRoute();

	/**
	 * Returns a new object of class '<em>Postal Route Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postal Route Name</em>'.
	 * @generated
	 */
	PostalRouteName createPostalRouteName();

	/**
	 * Returns a new object of class '<em>Postal Route Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postal Route Number</em>'.
	 * @generated
	 */
	PostalRouteNumber createPostalRouteNumber();

	/**
	 * Returns a new object of class '<em>Postal Service Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postal Service Elements</em>'.
	 * @generated
	 */
	PostalServiceElements createPostalServiceElements();

	/**
	 * Returns a new object of class '<em>Post Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Box</em>'.
	 * @generated
	 */
	PostBox createPostBox();

	/**
	 * Returns a new object of class '<em>Post Box Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Box Number</em>'.
	 * @generated
	 */
	PostBoxNumber createPostBoxNumber();

	/**
	 * Returns a new object of class '<em>Post Box Number Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Box Number Extension</em>'.
	 * @generated
	 */
	PostBoxNumberExtension createPostBoxNumberExtension();

	/**
	 * Returns a new object of class '<em>Post Box Number Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Box Number Prefix</em>'.
	 * @generated
	 */
	PostBoxNumberPrefix createPostBoxNumberPrefix();

	/**
	 * Returns a new object of class '<em>Post Box Number Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Box Number Suffix</em>'.
	 * @generated
	 */
	PostBoxNumberSuffix createPostBoxNumberSuffix();

	/**
	 * Returns a new object of class '<em>Post Office</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Office</em>'.
	 * @generated
	 */
	PostOffice createPostOffice();

	/**
	 * Returns a new object of class '<em>Post Office Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Office Name</em>'.
	 * @generated
	 */
	PostOfficeName createPostOfficeName();

	/**
	 * Returns a new object of class '<em>Post Office Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Office Number</em>'.
	 * @generated
	 */
	PostOfficeNumber createPostOfficeNumber();

	/**
	 * Returns a new object of class '<em>Post Town</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Town</em>'.
	 * @generated
	 */
	PostTown createPostTown();

	/**
	 * Returns a new object of class '<em>Post Town Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Town Name</em>'.
	 * @generated
	 */
	PostTownName createPostTownName();

	/**
	 * Returns a new object of class '<em>Post Town Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Town Suffix</em>'.
	 * @generated
	 */
	PostTownSuffix createPostTownSuffix();

	/**
	 * Returns a new object of class '<em>Premise</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise</em>'.
	 * @generated
	 */
	Premise createPremise();

	/**
	 * Returns a new object of class '<em>Premise Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise Location</em>'.
	 * @generated
	 */
	PremiseLocation createPremiseLocation();

	/**
	 * Returns a new object of class '<em>Premise Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise Name</em>'.
	 * @generated
	 */
	PremiseName createPremiseName();

	/**
	 * Returns a new object of class '<em>Premise Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise Number</em>'.
	 * @generated
	 */
	PremiseNumber createPremiseNumber();

	/**
	 * Returns a new object of class '<em>Premise Number Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise Number Prefix</em>'.
	 * @generated
	 */
	PremiseNumberPrefix createPremiseNumberPrefix();

	/**
	 * Returns a new object of class '<em>Premise Number Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise Number Range</em>'.
	 * @generated
	 */
	PremiseNumberRange createPremiseNumberRange();

	/**
	 * Returns a new object of class '<em>Premise Number Range From</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise Number Range From</em>'.
	 * @generated
	 */
	PremiseNumberRangeFrom createPremiseNumberRangeFrom();

	/**
	 * Returns a new object of class '<em>Premise Number Range To</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise Number Range To</em>'.
	 * @generated
	 */
	PremiseNumberRangeTo createPremiseNumberRangeTo();

	/**
	 * Returns a new object of class '<em>Premise Number Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premise Number Suffix</em>'.
	 * @generated
	 */
	PremiseNumberSuffix createPremiseNumberSuffix();

	/**
	 * Returns a new object of class '<em>Sorting Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sorting Code</em>'.
	 * @generated
	 */
	SortingCode createSortingCode();

	/**
	 * Returns a new object of class '<em>Sub Administrative Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Administrative Area</em>'.
	 * @generated
	 */
	SubAdministrativeArea createSubAdministrativeArea();

	/**
	 * Returns a new object of class '<em>Sub Administrative Area Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Administrative Area Name</em>'.
	 * @generated
	 */
	SubAdministrativeAreaName createSubAdministrativeAreaName();

	/**
	 * Returns a new object of class '<em>Sub Premise</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Premise</em>'.
	 * @generated
	 */
	SubPremise createSubPremise();

	/**
	 * Returns a new object of class '<em>Sub Premise Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Premise Location</em>'.
	 * @generated
	 */
	SubPremiseLocation createSubPremiseLocation();

	/**
	 * Returns a new object of class '<em>Sub Premise Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Premise Name</em>'.
	 * @generated
	 */
	SubPremiseName createSubPremiseName();

	/**
	 * Returns a new object of class '<em>Sub Premise Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Premise Number</em>'.
	 * @generated
	 */
	SubPremiseNumber createSubPremiseNumber();

	/**
	 * Returns a new object of class '<em>Sub Premise Number Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Premise Number Prefix</em>'.
	 * @generated
	 */
	SubPremiseNumberPrefix createSubPremiseNumberPrefix();

	/**
	 * Returns a new object of class '<em>Sub Premise Number Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Premise Number Suffix</em>'.
	 * @generated
	 */
	SubPremiseNumberSuffix createSubPremiseNumberSuffix();

	/**
	 * Returns a new object of class '<em>Supplementary Postal Service Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supplementary Postal Service Data</em>'.
	 * @generated
	 */
	SupplementaryPostalServiceData createSupplementaryPostalServiceData();

	/**
	 * Returns a new object of class '<em>Thoroughfare</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare</em>'.
	 * @generated
	 */
	Thoroughfare createThoroughfare();

	/**
	 * Returns a new object of class '<em>Thoroughfare Leading Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Leading Type</em>'.
	 * @generated
	 */
	ThoroughfareLeadingType createThoroughfareLeadingType();

	/**
	 * Returns a new object of class '<em>Thoroughfare Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Name</em>'.
	 * @generated
	 */
	ThoroughfareName createThoroughfareName();

	/**
	 * Returns a new object of class '<em>Thoroughfare Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Number</em>'.
	 * @generated
	 */
	ThoroughfareNumber createThoroughfareNumber();

	/**
	 * Returns a new object of class '<em>Thoroughfare Number From</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Number From</em>'.
	 * @generated
	 */
	ThoroughfareNumberFrom createThoroughfareNumberFrom();

	/**
	 * Returns a new object of class '<em>Thoroughfare Number Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Number Prefix</em>'.
	 * @generated
	 */
	ThoroughfareNumberPrefix createThoroughfareNumberPrefix();

	/**
	 * Returns a new object of class '<em>Thoroughfare Number Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Number Range</em>'.
	 * @generated
	 */
	ThoroughfareNumberRange createThoroughfareNumberRange();

	/**
	 * Returns a new object of class '<em>Thoroughfare Number Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Number Suffix</em>'.
	 * @generated
	 */
	ThoroughfareNumberSuffix createThoroughfareNumberSuffix();

	/**
	 * Returns a new object of class '<em>Thoroughfare Number To</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Number To</em>'.
	 * @generated
	 */
	ThoroughfareNumberTo createThoroughfareNumberTo();

	/**
	 * Returns a new object of class '<em>Thoroughfare Post Direction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Post Direction</em>'.
	 * @generated
	 */
	ThoroughfarePostDirection createThoroughfarePostDirection();

	/**
	 * Returns a new object of class '<em>Thoroughfare Pre Direction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Pre Direction</em>'.
	 * @generated
	 */
	ThoroughfarePreDirection createThoroughfarePreDirection();

	/**
	 * Returns a new object of class '<em>Thoroughfare Trailing Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thoroughfare Trailing Type</em>'.
	 * @generated
	 */
	ThoroughfareTrailingType createThoroughfareTrailingType();

	/**
	 * Returns a new object of class '<em>Xal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xal</em>'.
	 * @generated
	 */
	Xal createXal();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XalPackage getXalPackage();

} //XalFactory
