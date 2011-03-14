/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.util;

import com.verticon.oasis.xal.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.verticon.oasis.xal.XalPackage
 * @generated
 */
public class XalSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XalPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XalSwitch() {
		if (modelPackage == null) {
			modelPackage = XalPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case XalPackage.ADDRESS: {
				Address address = (Address)theEObject;
				T result = caseAddress(address);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADDRESS_DETAILS: {
				AddressDetails addressDetails = (AddressDetails)theEObject;
				T result = caseAddressDetails(addressDetails);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADDRESS_IDENTIFIER: {
				AddressIdentifier addressIdentifier = (AddressIdentifier)theEObject;
				T result = caseAddressIdentifier(addressIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADDRESS_LATITUDE: {
				AddressLatitude addressLatitude = (AddressLatitude)theEObject;
				T result = caseAddressLatitude(addressLatitude);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADDRESS_LATITUDE_DIRECTION: {
				AddressLatitudeDirection addressLatitudeDirection = (AddressLatitudeDirection)theEObject;
				T result = caseAddressLatitudeDirection(addressLatitudeDirection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADDRESS_LINE: {
				AddressLine addressLine = (AddressLine)theEObject;
				T result = caseAddressLine(addressLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADDRESS_LINES: {
				AddressLines addressLines = (AddressLines)theEObject;
				T result = caseAddressLines(addressLines);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADDRESS_LONGITUDE: {
				AddressLongitude addressLongitude = (AddressLongitude)theEObject;
				T result = caseAddressLongitude(addressLongitude);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADDRESS_LONGITUDE_DIRECTION: {
				AddressLongitudeDirection addressLongitudeDirection = (AddressLongitudeDirection)theEObject;
				T result = caseAddressLongitudeDirection(addressLongitudeDirection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADMINISTRATIVE_AREA: {
				AdministrativeArea administrativeArea = (AdministrativeArea)theEObject;
				T result = caseAdministrativeArea(administrativeArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ADMINISTRATIVE_AREA_NAME: {
				AdministrativeAreaName administrativeAreaName = (AdministrativeAreaName)theEObject;
				T result = caseAdministrativeAreaName(administrativeAreaName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.BARCODE: {
				Barcode barcode = (Barcode)theEObject;
				T result = caseBarcode(barcode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.BUILDING_NAME: {
				BuildingName buildingName = (BuildingName)theEObject;
				T result = caseBuildingName(buildingName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.COUNTRY: {
				Country country = (Country)theEObject;
				T result = caseCountry(country);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.COUNTRY_NAME: {
				CountryName countryName = (CountryName)theEObject;
				T result = caseCountryName(countryName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.COUNTRY_NAME_CODE: {
				CountryNameCode countryNameCode = (CountryNameCode)theEObject;
				T result = caseCountryNameCode(countryNameCode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.DEPARTMENT: {
				Department department = (Department)theEObject;
				T result = caseDepartment(department);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.DEPARTMENT_NAME: {
				DepartmentName departmentName = (DepartmentName)theEObject;
				T result = caseDepartmentName(departmentName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.DEPENDENT_LOCALITY: {
				DependentLocality dependentLocality = (DependentLocality)theEObject;
				T result = caseDependentLocality(dependentLocality);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.DEPENDENT_LOCALITY_NAME: {
				DependentLocalityName dependentLocalityName = (DependentLocalityName)theEObject;
				T result = caseDependentLocalityName(dependentLocalityName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.DEPENDENT_LOCALITY_NUMBER: {
				DependentLocalityNumber dependentLocalityNumber = (DependentLocalityNumber)theEObject;
				T result = caseDependentLocalityNumber(dependentLocalityNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.DEPENDENT_THOROUGHFARE: {
				DependentThoroughfare dependentThoroughfare = (DependentThoroughfare)theEObject;
				T result = caseDependentThoroughfare(dependentThoroughfare);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.ENDORSEMENT_LINE_CODE: {
				EndorsementLineCode endorsementLineCode = (EndorsementLineCode)theEObject;
				T result = caseEndorsementLineCode(endorsementLineCode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.FIRM: {
				Firm firm = (Firm)theEObject;
				T result = caseFirm(firm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.FIRM_NAME: {
				FirmName firmName = (FirmName)theEObject;
				T result = caseFirmName(firmName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.KEY_LINE_CODE: {
				KeyLineCode keyLineCode = (KeyLineCode)theEObject;
				T result = caseKeyLineCode(keyLineCode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.LARGE_MAIL_USER: {
				LargeMailUser largeMailUser = (LargeMailUser)theEObject;
				T result = caseLargeMailUser(largeMailUser);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.LARGE_MAIL_USER_IDENTIFIER: {
				LargeMailUserIdentifier largeMailUserIdentifier = (LargeMailUserIdentifier)theEObject;
				T result = caseLargeMailUserIdentifier(largeMailUserIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.LARGE_MAIL_USER_NAME: {
				LargeMailUserName largeMailUserName = (LargeMailUserName)theEObject;
				T result = caseLargeMailUserName(largeMailUserName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.LOCALITY: {
				Locality locality = (Locality)theEObject;
				T result = caseLocality(locality);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.LOCALITY_NAME: {
				LocalityName localityName = (LocalityName)theEObject;
				T result = caseLocalityName(localityName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.MAIL_STOP: {
				MailStop mailStop = (MailStop)theEObject;
				T result = caseMailStop(mailStop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.MAIL_STOP_NAME: {
				MailStopName mailStopName = (MailStopName)theEObject;
				T result = caseMailStopName(mailStopName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.MAIL_STOP_NUMBER: {
				MailStopNumber mailStopNumber = (MailStopNumber)theEObject;
				T result = caseMailStopNumber(mailStopNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POSTAL_CODE: {
				PostalCode postalCode = (PostalCode)theEObject;
				T result = casePostalCode(postalCode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POSTAL_CODE_NUMBER: {
				PostalCodeNumber postalCodeNumber = (PostalCodeNumber)theEObject;
				T result = casePostalCodeNumber(postalCodeNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POSTAL_CODE_NUMBER_EXTENSION: {
				PostalCodeNumberExtension postalCodeNumberExtension = (PostalCodeNumberExtension)theEObject;
				T result = casePostalCodeNumberExtension(postalCodeNumberExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POSTAL_ROUTE: {
				PostalRoute postalRoute = (PostalRoute)theEObject;
				T result = casePostalRoute(postalRoute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POSTAL_ROUTE_NAME: {
				PostalRouteName postalRouteName = (PostalRouteName)theEObject;
				T result = casePostalRouteName(postalRouteName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POSTAL_ROUTE_NUMBER: {
				PostalRouteNumber postalRouteNumber = (PostalRouteNumber)theEObject;
				T result = casePostalRouteNumber(postalRouteNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POSTAL_SERVICE_ELEMENTS: {
				PostalServiceElements postalServiceElements = (PostalServiceElements)theEObject;
				T result = casePostalServiceElements(postalServiceElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_BOX: {
				PostBox postBox = (PostBox)theEObject;
				T result = casePostBox(postBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_BOX_NUMBER: {
				PostBoxNumber postBoxNumber = (PostBoxNumber)theEObject;
				T result = casePostBoxNumber(postBoxNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_BOX_NUMBER_EXTENSION: {
				PostBoxNumberExtension postBoxNumberExtension = (PostBoxNumberExtension)theEObject;
				T result = casePostBoxNumberExtension(postBoxNumberExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_BOX_NUMBER_PREFIX: {
				PostBoxNumberPrefix postBoxNumberPrefix = (PostBoxNumberPrefix)theEObject;
				T result = casePostBoxNumberPrefix(postBoxNumberPrefix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_BOX_NUMBER_SUFFIX: {
				PostBoxNumberSuffix postBoxNumberSuffix = (PostBoxNumberSuffix)theEObject;
				T result = casePostBoxNumberSuffix(postBoxNumberSuffix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_OFFICE: {
				PostOffice postOffice = (PostOffice)theEObject;
				T result = casePostOffice(postOffice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_OFFICE_NAME: {
				PostOfficeName postOfficeName = (PostOfficeName)theEObject;
				T result = casePostOfficeName(postOfficeName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_OFFICE_NUMBER: {
				PostOfficeNumber postOfficeNumber = (PostOfficeNumber)theEObject;
				T result = casePostOfficeNumber(postOfficeNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_TOWN: {
				PostTown postTown = (PostTown)theEObject;
				T result = casePostTown(postTown);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_TOWN_NAME: {
				PostTownName postTownName = (PostTownName)theEObject;
				T result = casePostTownName(postTownName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.POST_TOWN_SUFFIX: {
				PostTownSuffix postTownSuffix = (PostTownSuffix)theEObject;
				T result = casePostTownSuffix(postTownSuffix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE: {
				Premise premise = (Premise)theEObject;
				T result = casePremise(premise);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE_LOCATION: {
				PremiseLocation premiseLocation = (PremiseLocation)theEObject;
				T result = casePremiseLocation(premiseLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE_NAME: {
				PremiseName premiseName = (PremiseName)theEObject;
				T result = casePremiseName(premiseName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE_NUMBER: {
				PremiseNumber premiseNumber = (PremiseNumber)theEObject;
				T result = casePremiseNumber(premiseNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE_NUMBER_PREFIX: {
				PremiseNumberPrefix premiseNumberPrefix = (PremiseNumberPrefix)theEObject;
				T result = casePremiseNumberPrefix(premiseNumberPrefix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE_NUMBER_RANGE: {
				PremiseNumberRange premiseNumberRange = (PremiseNumberRange)theEObject;
				T result = casePremiseNumberRange(premiseNumberRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE_NUMBER_RANGE_FROM: {
				PremiseNumberRangeFrom premiseNumberRangeFrom = (PremiseNumberRangeFrom)theEObject;
				T result = casePremiseNumberRangeFrom(premiseNumberRangeFrom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE_NUMBER_RANGE_TO: {
				PremiseNumberRangeTo premiseNumberRangeTo = (PremiseNumberRangeTo)theEObject;
				T result = casePremiseNumberRangeTo(premiseNumberRangeTo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.PREMISE_NUMBER_SUFFIX: {
				PremiseNumberSuffix premiseNumberSuffix = (PremiseNumberSuffix)theEObject;
				T result = casePremiseNumberSuffix(premiseNumberSuffix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SORTING_CODE: {
				SortingCode sortingCode = (SortingCode)theEObject;
				T result = caseSortingCode(sortingCode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUB_ADMINISTRATIVE_AREA: {
				SubAdministrativeArea subAdministrativeArea = (SubAdministrativeArea)theEObject;
				T result = caseSubAdministrativeArea(subAdministrativeArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUB_ADMINISTRATIVE_AREA_NAME: {
				SubAdministrativeAreaName subAdministrativeAreaName = (SubAdministrativeAreaName)theEObject;
				T result = caseSubAdministrativeAreaName(subAdministrativeAreaName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUB_PREMISE: {
				SubPremise subPremise = (SubPremise)theEObject;
				T result = caseSubPremise(subPremise);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUB_PREMISE_LOCATION: {
				SubPremiseLocation subPremiseLocation = (SubPremiseLocation)theEObject;
				T result = caseSubPremiseLocation(subPremiseLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUB_PREMISE_NAME: {
				SubPremiseName subPremiseName = (SubPremiseName)theEObject;
				T result = caseSubPremiseName(subPremiseName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUB_PREMISE_NUMBER: {
				SubPremiseNumber subPremiseNumber = (SubPremiseNumber)theEObject;
				T result = caseSubPremiseNumber(subPremiseNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUB_PREMISE_NUMBER_PREFIX: {
				SubPremiseNumberPrefix subPremiseNumberPrefix = (SubPremiseNumberPrefix)theEObject;
				T result = caseSubPremiseNumberPrefix(subPremiseNumberPrefix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUB_PREMISE_NUMBER_SUFFIX: {
				SubPremiseNumberSuffix subPremiseNumberSuffix = (SubPremiseNumberSuffix)theEObject;
				T result = caseSubPremiseNumberSuffix(subPremiseNumberSuffix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.SUPPLEMENTARY_POSTAL_SERVICE_DATA: {
				SupplementaryPostalServiceData supplementaryPostalServiceData = (SupplementaryPostalServiceData)theEObject;
				T result = caseSupplementaryPostalServiceData(supplementaryPostalServiceData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE: {
				Thoroughfare thoroughfare = (Thoroughfare)theEObject;
				T result = caseThoroughfare(thoroughfare);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_LEADING_TYPE: {
				ThoroughfareLeadingType thoroughfareLeadingType = (ThoroughfareLeadingType)theEObject;
				T result = caseThoroughfareLeadingType(thoroughfareLeadingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_NAME: {
				ThoroughfareName thoroughfareName = (ThoroughfareName)theEObject;
				T result = caseThoroughfareName(thoroughfareName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_NUMBER: {
				ThoroughfareNumber thoroughfareNumber = (ThoroughfareNumber)theEObject;
				T result = caseThoroughfareNumber(thoroughfareNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_NUMBER_FROM: {
				ThoroughfareNumberFrom thoroughfareNumberFrom = (ThoroughfareNumberFrom)theEObject;
				T result = caseThoroughfareNumberFrom(thoroughfareNumberFrom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_NUMBER_PREFIX: {
				ThoroughfareNumberPrefix thoroughfareNumberPrefix = (ThoroughfareNumberPrefix)theEObject;
				T result = caseThoroughfareNumberPrefix(thoroughfareNumberPrefix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_NUMBER_RANGE: {
				ThoroughfareNumberRange thoroughfareNumberRange = (ThoroughfareNumberRange)theEObject;
				T result = caseThoroughfareNumberRange(thoroughfareNumberRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_NUMBER_SUFFIX: {
				ThoroughfareNumberSuffix thoroughfareNumberSuffix = (ThoroughfareNumberSuffix)theEObject;
				T result = caseThoroughfareNumberSuffix(thoroughfareNumberSuffix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_NUMBER_TO: {
				ThoroughfareNumberTo thoroughfareNumberTo = (ThoroughfareNumberTo)theEObject;
				T result = caseThoroughfareNumberTo(thoroughfareNumberTo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_POST_DIRECTION: {
				ThoroughfarePostDirection thoroughfarePostDirection = (ThoroughfarePostDirection)theEObject;
				T result = caseThoroughfarePostDirection(thoroughfarePostDirection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_PRE_DIRECTION: {
				ThoroughfarePreDirection thoroughfarePreDirection = (ThoroughfarePreDirection)theEObject;
				T result = caseThoroughfarePreDirection(thoroughfarePreDirection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.THOROUGHFARE_TRAILING_TYPE: {
				ThoroughfareTrailingType thoroughfareTrailingType = (ThoroughfareTrailingType)theEObject;
				T result = caseThoroughfareTrailingType(thoroughfareTrailingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XalPackage.XAL: {
				Xal xal = (Xal)theEObject;
				T result = caseXal(xal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddress(Address object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Details</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Details</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressDetails(AddressDetails object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressIdentifier(AddressIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Latitude</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Latitude</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressLatitude(AddressLatitude object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Latitude Direction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Latitude Direction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressLatitudeDirection(AddressLatitudeDirection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressLine(AddressLine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Lines</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Lines</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressLines(AddressLines object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Longitude</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Longitude</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressLongitude(AddressLongitude object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Longitude Direction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Longitude Direction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressLongitudeDirection(AddressLongitudeDirection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Administrative Area</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Administrative Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdministrativeArea(AdministrativeArea object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Administrative Area Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Administrative Area Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdministrativeAreaName(AdministrativeAreaName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Barcode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Barcode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBarcode(Barcode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Building Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Building Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuildingName(BuildingName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Country</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Country</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountry(Country object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Country Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Country Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountryName(CountryName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Country Name Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Country Name Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountryNameCode(CountryNameCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Department</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Department</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDepartment(Department object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Department Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Department Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDepartmentName(DepartmentName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependent Locality</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependent Locality</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependentLocality(DependentLocality object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependent Locality Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependent Locality Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependentLocalityName(DependentLocalityName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependent Locality Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependent Locality Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependentLocalityNumber(DependentLocalityNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependent Thoroughfare</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependent Thoroughfare</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependentThoroughfare(DependentThoroughfare object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Endorsement Line Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Endorsement Line Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndorsementLineCode(EndorsementLineCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Firm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Firm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFirm(Firm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Firm Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Firm Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFirmName(FirmName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Line Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Line Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyLineCode(KeyLineCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Large Mail User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Large Mail User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLargeMailUser(LargeMailUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Large Mail User Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Large Mail User Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLargeMailUserIdentifier(LargeMailUserIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Large Mail User Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Large Mail User Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLargeMailUserName(LargeMailUserName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Locality</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Locality</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocality(Locality object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Locality Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Locality Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalityName(LocalityName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mail Stop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mail Stop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMailStop(MailStop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mail Stop Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mail Stop Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMailStopName(MailStopName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mail Stop Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mail Stop Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMailStopNumber(MailStopNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postal Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postal Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostalCode(PostalCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postal Code Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postal Code Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostalCodeNumber(PostalCodeNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postal Code Number Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postal Code Number Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostalCodeNumberExtension(PostalCodeNumberExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postal Route</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postal Route</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostalRoute(PostalRoute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postal Route Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postal Route Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostalRouteName(PostalRouteName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postal Route Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postal Route Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostalRouteNumber(PostalRouteNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postal Service Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postal Service Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostalServiceElements(PostalServiceElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostBox(PostBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Box Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Box Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostBoxNumber(PostBoxNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Box Number Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Box Number Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostBoxNumberExtension(PostBoxNumberExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Box Number Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Box Number Prefix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostBoxNumberPrefix(PostBoxNumberPrefix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Box Number Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Box Number Suffix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostBoxNumberSuffix(PostBoxNumberSuffix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Office</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Office</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostOffice(PostOffice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Office Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Office Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostOfficeName(PostOfficeName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Office Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Office Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostOfficeNumber(PostOfficeNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Town</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Town</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostTown(PostTown object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Town Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Town Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostTownName(PostTownName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Town Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Town Suffix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostTownSuffix(PostTownSuffix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremise(Premise object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremiseLocation(PremiseLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremiseName(PremiseName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremiseNumber(PremiseNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise Number Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise Number Prefix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremiseNumberPrefix(PremiseNumberPrefix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise Number Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise Number Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremiseNumberRange(PremiseNumberRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise Number Range From</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise Number Range From</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremiseNumberRangeFrom(PremiseNumberRangeFrom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise Number Range To</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise Number Range To</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremiseNumberRangeTo(PremiseNumberRangeTo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premise Number Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premise Number Suffix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremiseNumberSuffix(PremiseNumberSuffix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sorting Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sorting Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSortingCode(SortingCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Administrative Area</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Administrative Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubAdministrativeArea(SubAdministrativeArea object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Administrative Area Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Administrative Area Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubAdministrativeAreaName(SubAdministrativeAreaName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Premise</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Premise</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubPremise(SubPremise object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Premise Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Premise Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubPremiseLocation(SubPremiseLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Premise Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Premise Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubPremiseName(SubPremiseName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Premise Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Premise Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubPremiseNumber(SubPremiseNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Premise Number Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Premise Number Prefix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubPremiseNumberPrefix(SubPremiseNumberPrefix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Premise Number Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Premise Number Suffix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubPremiseNumberSuffix(SubPremiseNumberSuffix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Supplementary Postal Service Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Supplementary Postal Service Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSupplementaryPostalServiceData(SupplementaryPostalServiceData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfare(Thoroughfare object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Leading Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Leading Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareLeadingType(ThoroughfareLeadingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareName(ThoroughfareName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareNumber(ThoroughfareNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Number From</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Number From</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareNumberFrom(ThoroughfareNumberFrom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Number Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Number Prefix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareNumberPrefix(ThoroughfareNumberPrefix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Number Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Number Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareNumberRange(ThoroughfareNumberRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Number Suffix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Number Suffix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareNumberSuffix(ThoroughfareNumberSuffix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Number To</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Number To</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareNumberTo(ThoroughfareNumberTo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Post Direction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Post Direction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfarePostDirection(ThoroughfarePostDirection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Pre Direction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Pre Direction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfarePreDirection(ThoroughfarePreDirection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thoroughfare Trailing Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thoroughfare Trailing Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThoroughfareTrailingType(ThoroughfareTrailingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXal(Xal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //XalSwitch
