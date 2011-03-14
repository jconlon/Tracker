/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.util;

import com.verticon.oasis.xal.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.verticon.oasis.xal.XalPackage
 * @generated
 */
public class XalAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XalPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XalAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XalPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XalSwitch<Adapter> modelSwitch =
		new XalSwitch<Adapter>() {
			@Override
			public Adapter caseAddress(Address object) {
				return createAddressAdapter();
			}
			@Override
			public Adapter caseAddressDetails(AddressDetails object) {
				return createAddressDetailsAdapter();
			}
			@Override
			public Adapter caseAddressIdentifier(AddressIdentifier object) {
				return createAddressIdentifierAdapter();
			}
			@Override
			public Adapter caseAddressLatitude(AddressLatitude object) {
				return createAddressLatitudeAdapter();
			}
			@Override
			public Adapter caseAddressLatitudeDirection(AddressLatitudeDirection object) {
				return createAddressLatitudeDirectionAdapter();
			}
			@Override
			public Adapter caseAddressLine(AddressLine object) {
				return createAddressLineAdapter();
			}
			@Override
			public Adapter caseAddressLines(AddressLines object) {
				return createAddressLinesAdapter();
			}
			@Override
			public Adapter caseAddressLongitude(AddressLongitude object) {
				return createAddressLongitudeAdapter();
			}
			@Override
			public Adapter caseAddressLongitudeDirection(AddressLongitudeDirection object) {
				return createAddressLongitudeDirectionAdapter();
			}
			@Override
			public Adapter caseAdministrativeArea(AdministrativeArea object) {
				return createAdministrativeAreaAdapter();
			}
			@Override
			public Adapter caseAdministrativeAreaName(AdministrativeAreaName object) {
				return createAdministrativeAreaNameAdapter();
			}
			@Override
			public Adapter caseBarcode(Barcode object) {
				return createBarcodeAdapter();
			}
			@Override
			public Adapter caseBuildingName(BuildingName object) {
				return createBuildingNameAdapter();
			}
			@Override
			public Adapter caseCountry(Country object) {
				return createCountryAdapter();
			}
			@Override
			public Adapter caseCountryName(CountryName object) {
				return createCountryNameAdapter();
			}
			@Override
			public Adapter caseCountryNameCode(CountryNameCode object) {
				return createCountryNameCodeAdapter();
			}
			@Override
			public Adapter caseDepartment(Department object) {
				return createDepartmentAdapter();
			}
			@Override
			public Adapter caseDepartmentName(DepartmentName object) {
				return createDepartmentNameAdapter();
			}
			@Override
			public Adapter caseDependentLocality(DependentLocality object) {
				return createDependentLocalityAdapter();
			}
			@Override
			public Adapter caseDependentLocalityName(DependentLocalityName object) {
				return createDependentLocalityNameAdapter();
			}
			@Override
			public Adapter caseDependentLocalityNumber(DependentLocalityNumber object) {
				return createDependentLocalityNumberAdapter();
			}
			@Override
			public Adapter caseDependentThoroughfare(DependentThoroughfare object) {
				return createDependentThoroughfareAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseEndorsementLineCode(EndorsementLineCode object) {
				return createEndorsementLineCodeAdapter();
			}
			@Override
			public Adapter caseFirm(Firm object) {
				return createFirmAdapter();
			}
			@Override
			public Adapter caseFirmName(FirmName object) {
				return createFirmNameAdapter();
			}
			@Override
			public Adapter caseKeyLineCode(KeyLineCode object) {
				return createKeyLineCodeAdapter();
			}
			@Override
			public Adapter caseLargeMailUser(LargeMailUser object) {
				return createLargeMailUserAdapter();
			}
			@Override
			public Adapter caseLargeMailUserIdentifier(LargeMailUserIdentifier object) {
				return createLargeMailUserIdentifierAdapter();
			}
			@Override
			public Adapter caseLargeMailUserName(LargeMailUserName object) {
				return createLargeMailUserNameAdapter();
			}
			@Override
			public Adapter caseLocality(Locality object) {
				return createLocalityAdapter();
			}
			@Override
			public Adapter caseLocalityName(LocalityName object) {
				return createLocalityNameAdapter();
			}
			@Override
			public Adapter caseMailStop(MailStop object) {
				return createMailStopAdapter();
			}
			@Override
			public Adapter caseMailStopName(MailStopName object) {
				return createMailStopNameAdapter();
			}
			@Override
			public Adapter caseMailStopNumber(MailStopNumber object) {
				return createMailStopNumberAdapter();
			}
			@Override
			public Adapter casePostalCode(PostalCode object) {
				return createPostalCodeAdapter();
			}
			@Override
			public Adapter casePostalCodeNumber(PostalCodeNumber object) {
				return createPostalCodeNumberAdapter();
			}
			@Override
			public Adapter casePostalCodeNumberExtension(PostalCodeNumberExtension object) {
				return createPostalCodeNumberExtensionAdapter();
			}
			@Override
			public Adapter casePostalRoute(PostalRoute object) {
				return createPostalRouteAdapter();
			}
			@Override
			public Adapter casePostalRouteName(PostalRouteName object) {
				return createPostalRouteNameAdapter();
			}
			@Override
			public Adapter casePostalRouteNumber(PostalRouteNumber object) {
				return createPostalRouteNumberAdapter();
			}
			@Override
			public Adapter casePostalServiceElements(PostalServiceElements object) {
				return createPostalServiceElementsAdapter();
			}
			@Override
			public Adapter casePostBox(PostBox object) {
				return createPostBoxAdapter();
			}
			@Override
			public Adapter casePostBoxNumber(PostBoxNumber object) {
				return createPostBoxNumberAdapter();
			}
			@Override
			public Adapter casePostBoxNumberExtension(PostBoxNumberExtension object) {
				return createPostBoxNumberExtensionAdapter();
			}
			@Override
			public Adapter casePostBoxNumberPrefix(PostBoxNumberPrefix object) {
				return createPostBoxNumberPrefixAdapter();
			}
			@Override
			public Adapter casePostBoxNumberSuffix(PostBoxNumberSuffix object) {
				return createPostBoxNumberSuffixAdapter();
			}
			@Override
			public Adapter casePostOffice(PostOffice object) {
				return createPostOfficeAdapter();
			}
			@Override
			public Adapter casePostOfficeName(PostOfficeName object) {
				return createPostOfficeNameAdapter();
			}
			@Override
			public Adapter casePostOfficeNumber(PostOfficeNumber object) {
				return createPostOfficeNumberAdapter();
			}
			@Override
			public Adapter casePostTown(PostTown object) {
				return createPostTownAdapter();
			}
			@Override
			public Adapter casePostTownName(PostTownName object) {
				return createPostTownNameAdapter();
			}
			@Override
			public Adapter casePostTownSuffix(PostTownSuffix object) {
				return createPostTownSuffixAdapter();
			}
			@Override
			public Adapter casePremise(Premise object) {
				return createPremiseAdapter();
			}
			@Override
			public Adapter casePremiseLocation(PremiseLocation object) {
				return createPremiseLocationAdapter();
			}
			@Override
			public Adapter casePremiseName(PremiseName object) {
				return createPremiseNameAdapter();
			}
			@Override
			public Adapter casePremiseNumber(PremiseNumber object) {
				return createPremiseNumberAdapter();
			}
			@Override
			public Adapter casePremiseNumberPrefix(PremiseNumberPrefix object) {
				return createPremiseNumberPrefixAdapter();
			}
			@Override
			public Adapter casePremiseNumberRange(PremiseNumberRange object) {
				return createPremiseNumberRangeAdapter();
			}
			@Override
			public Adapter casePremiseNumberRangeFrom(PremiseNumberRangeFrom object) {
				return createPremiseNumberRangeFromAdapter();
			}
			@Override
			public Adapter casePremiseNumberRangeTo(PremiseNumberRangeTo object) {
				return createPremiseNumberRangeToAdapter();
			}
			@Override
			public Adapter casePremiseNumberSuffix(PremiseNumberSuffix object) {
				return createPremiseNumberSuffixAdapter();
			}
			@Override
			public Adapter caseSortingCode(SortingCode object) {
				return createSortingCodeAdapter();
			}
			@Override
			public Adapter caseSubAdministrativeArea(SubAdministrativeArea object) {
				return createSubAdministrativeAreaAdapter();
			}
			@Override
			public Adapter caseSubAdministrativeAreaName(SubAdministrativeAreaName object) {
				return createSubAdministrativeAreaNameAdapter();
			}
			@Override
			public Adapter caseSubPremise(SubPremise object) {
				return createSubPremiseAdapter();
			}
			@Override
			public Adapter caseSubPremiseLocation(SubPremiseLocation object) {
				return createSubPremiseLocationAdapter();
			}
			@Override
			public Adapter caseSubPremiseName(SubPremiseName object) {
				return createSubPremiseNameAdapter();
			}
			@Override
			public Adapter caseSubPremiseNumber(SubPremiseNumber object) {
				return createSubPremiseNumberAdapter();
			}
			@Override
			public Adapter caseSubPremiseNumberPrefix(SubPremiseNumberPrefix object) {
				return createSubPremiseNumberPrefixAdapter();
			}
			@Override
			public Adapter caseSubPremiseNumberSuffix(SubPremiseNumberSuffix object) {
				return createSubPremiseNumberSuffixAdapter();
			}
			@Override
			public Adapter caseSupplementaryPostalServiceData(SupplementaryPostalServiceData object) {
				return createSupplementaryPostalServiceDataAdapter();
			}
			@Override
			public Adapter caseThoroughfare(Thoroughfare object) {
				return createThoroughfareAdapter();
			}
			@Override
			public Adapter caseThoroughfareLeadingType(ThoroughfareLeadingType object) {
				return createThoroughfareLeadingTypeAdapter();
			}
			@Override
			public Adapter caseThoroughfareName(ThoroughfareName object) {
				return createThoroughfareNameAdapter();
			}
			@Override
			public Adapter caseThoroughfareNumber(ThoroughfareNumber object) {
				return createThoroughfareNumberAdapter();
			}
			@Override
			public Adapter caseThoroughfareNumberFrom(ThoroughfareNumberFrom object) {
				return createThoroughfareNumberFromAdapter();
			}
			@Override
			public Adapter caseThoroughfareNumberPrefix(ThoroughfareNumberPrefix object) {
				return createThoroughfareNumberPrefixAdapter();
			}
			@Override
			public Adapter caseThoroughfareNumberRange(ThoroughfareNumberRange object) {
				return createThoroughfareNumberRangeAdapter();
			}
			@Override
			public Adapter caseThoroughfareNumberSuffix(ThoroughfareNumberSuffix object) {
				return createThoroughfareNumberSuffixAdapter();
			}
			@Override
			public Adapter caseThoroughfareNumberTo(ThoroughfareNumberTo object) {
				return createThoroughfareNumberToAdapter();
			}
			@Override
			public Adapter caseThoroughfarePostDirection(ThoroughfarePostDirection object) {
				return createThoroughfarePostDirectionAdapter();
			}
			@Override
			public Adapter caseThoroughfarePreDirection(ThoroughfarePreDirection object) {
				return createThoroughfarePreDirectionAdapter();
			}
			@Override
			public Adapter caseThoroughfareTrailingType(ThoroughfareTrailingType object) {
				return createThoroughfareTrailingTypeAdapter();
			}
			@Override
			public Adapter caseXal(Xal object) {
				return createXalAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Address
	 * @generated
	 */
	public Adapter createAddressAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AddressDetails <em>Address Details</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AddressDetails
	 * @generated
	 */
	public Adapter createAddressDetailsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AddressIdentifier <em>Address Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AddressIdentifier
	 * @generated
	 */
	public Adapter createAddressIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AddressLatitude <em>Address Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AddressLatitude
	 * @generated
	 */
	public Adapter createAddressLatitudeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AddressLatitudeDirection <em>Address Latitude Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AddressLatitudeDirection
	 * @generated
	 */
	public Adapter createAddressLatitudeDirectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AddressLine <em>Address Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AddressLine
	 * @generated
	 */
	public Adapter createAddressLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AddressLines <em>Address Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AddressLines
	 * @generated
	 */
	public Adapter createAddressLinesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AddressLongitude <em>Address Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AddressLongitude
	 * @generated
	 */
	public Adapter createAddressLongitudeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AddressLongitudeDirection <em>Address Longitude Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AddressLongitudeDirection
	 * @generated
	 */
	public Adapter createAddressLongitudeDirectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AdministrativeArea <em>Administrative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AdministrativeArea
	 * @generated
	 */
	public Adapter createAdministrativeAreaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.AdministrativeAreaName <em>Administrative Area Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.AdministrativeAreaName
	 * @generated
	 */
	public Adapter createAdministrativeAreaNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Barcode <em>Barcode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Barcode
	 * @generated
	 */
	public Adapter createBarcodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.BuildingName <em>Building Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.BuildingName
	 * @generated
	 */
	public Adapter createBuildingNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Country <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Country
	 * @generated
	 */
	public Adapter createCountryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.CountryName <em>Country Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.CountryName
	 * @generated
	 */
	public Adapter createCountryNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.CountryNameCode <em>Country Name Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.CountryNameCode
	 * @generated
	 */
	public Adapter createCountryNameCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Department <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Department
	 * @generated
	 */
	public Adapter createDepartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.DepartmentName <em>Department Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.DepartmentName
	 * @generated
	 */
	public Adapter createDepartmentNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.DependentLocality <em>Dependent Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.DependentLocality
	 * @generated
	 */
	public Adapter createDependentLocalityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.DependentLocalityName <em>Dependent Locality Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.DependentLocalityName
	 * @generated
	 */
	public Adapter createDependentLocalityNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.DependentLocalityNumber <em>Dependent Locality Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.DependentLocalityNumber
	 * @generated
	 */
	public Adapter createDependentLocalityNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.DependentThoroughfare <em>Dependent Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.DependentThoroughfare
	 * @generated
	 */
	public Adapter createDependentThoroughfareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.EndorsementLineCode <em>Endorsement Line Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.EndorsementLineCode
	 * @generated
	 */
	public Adapter createEndorsementLineCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Firm <em>Firm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Firm
	 * @generated
	 */
	public Adapter createFirmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.FirmName <em>Firm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.FirmName
	 * @generated
	 */
	public Adapter createFirmNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.KeyLineCode <em>Key Line Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.KeyLineCode
	 * @generated
	 */
	public Adapter createKeyLineCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.LargeMailUser <em>Large Mail User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.LargeMailUser
	 * @generated
	 */
	public Adapter createLargeMailUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.LargeMailUserIdentifier <em>Large Mail User Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.LargeMailUserIdentifier
	 * @generated
	 */
	public Adapter createLargeMailUserIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.LargeMailUserName <em>Large Mail User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.LargeMailUserName
	 * @generated
	 */
	public Adapter createLargeMailUserNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Locality <em>Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Locality
	 * @generated
	 */
	public Adapter createLocalityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.LocalityName <em>Locality Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.LocalityName
	 * @generated
	 */
	public Adapter createLocalityNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.MailStop <em>Mail Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.MailStop
	 * @generated
	 */
	public Adapter createMailStopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.MailStopName <em>Mail Stop Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.MailStopName
	 * @generated
	 */
	public Adapter createMailStopNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.MailStopNumber <em>Mail Stop Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.MailStopNumber
	 * @generated
	 */
	public Adapter createMailStopNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostalCode
	 * @generated
	 */
	public Adapter createPostalCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostalCodeNumber <em>Postal Code Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostalCodeNumber
	 * @generated
	 */
	public Adapter createPostalCodeNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostalCodeNumberExtension <em>Postal Code Number Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostalCodeNumberExtension
	 * @generated
	 */
	public Adapter createPostalCodeNumberExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostalRoute <em>Postal Route</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostalRoute
	 * @generated
	 */
	public Adapter createPostalRouteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostalRouteName <em>Postal Route Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostalRouteName
	 * @generated
	 */
	public Adapter createPostalRouteNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostalRouteNumber <em>Postal Route Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostalRouteNumber
	 * @generated
	 */
	public Adapter createPostalRouteNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostalServiceElements <em>Postal Service Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostalServiceElements
	 * @generated
	 */
	public Adapter createPostalServiceElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostBox <em>Post Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostBox
	 * @generated
	 */
	public Adapter createPostBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostBoxNumber <em>Post Box Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostBoxNumber
	 * @generated
	 */
	public Adapter createPostBoxNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostBoxNumberExtension <em>Post Box Number Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostBoxNumberExtension
	 * @generated
	 */
	public Adapter createPostBoxNumberExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostBoxNumberPrefix <em>Post Box Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostBoxNumberPrefix
	 * @generated
	 */
	public Adapter createPostBoxNumberPrefixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostBoxNumberSuffix <em>Post Box Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostBoxNumberSuffix
	 * @generated
	 */
	public Adapter createPostBoxNumberSuffixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostOffice <em>Post Office</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostOffice
	 * @generated
	 */
	public Adapter createPostOfficeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostOfficeName <em>Post Office Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostOfficeName
	 * @generated
	 */
	public Adapter createPostOfficeNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostOfficeNumber <em>Post Office Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostOfficeNumber
	 * @generated
	 */
	public Adapter createPostOfficeNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostTown <em>Post Town</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostTown
	 * @generated
	 */
	public Adapter createPostTownAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostTownName <em>Post Town Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostTownName
	 * @generated
	 */
	public Adapter createPostTownNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PostTownSuffix <em>Post Town Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PostTownSuffix
	 * @generated
	 */
	public Adapter createPostTownSuffixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Premise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Premise
	 * @generated
	 */
	public Adapter createPremiseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PremiseLocation <em>Premise Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PremiseLocation
	 * @generated
	 */
	public Adapter createPremiseLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PremiseName <em>Premise Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PremiseName
	 * @generated
	 */
	public Adapter createPremiseNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PremiseNumber <em>Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PremiseNumber
	 * @generated
	 */
	public Adapter createPremiseNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PremiseNumberPrefix <em>Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PremiseNumberPrefix
	 * @generated
	 */
	public Adapter createPremiseNumberPrefixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PremiseNumberRange <em>Premise Number Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PremiseNumberRange
	 * @generated
	 */
	public Adapter createPremiseNumberRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PremiseNumberRangeFrom <em>Premise Number Range From</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeFrom
	 * @generated
	 */
	public Adapter createPremiseNumberRangeFromAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PremiseNumberRangeTo <em>Premise Number Range To</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PremiseNumberRangeTo
	 * @generated
	 */
	public Adapter createPremiseNumberRangeToAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.PremiseNumberSuffix <em>Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.PremiseNumberSuffix
	 * @generated
	 */
	public Adapter createPremiseNumberSuffixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SortingCode <em>Sorting Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SortingCode
	 * @generated
	 */
	public Adapter createSortingCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SubAdministrativeArea <em>Sub Administrative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SubAdministrativeArea
	 * @generated
	 */
	public Adapter createSubAdministrativeAreaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SubAdministrativeAreaName <em>Sub Administrative Area Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SubAdministrativeAreaName
	 * @generated
	 */
	public Adapter createSubAdministrativeAreaNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SubPremise <em>Sub Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SubPremise
	 * @generated
	 */
	public Adapter createSubPremiseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SubPremiseLocation <em>Sub Premise Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SubPremiseLocation
	 * @generated
	 */
	public Adapter createSubPremiseLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SubPremiseName <em>Sub Premise Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SubPremiseName
	 * @generated
	 */
	public Adapter createSubPremiseNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SubPremiseNumber <em>Sub Premise Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SubPremiseNumber
	 * @generated
	 */
	public Adapter createSubPremiseNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SubPremiseNumberPrefix <em>Sub Premise Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SubPremiseNumberPrefix
	 * @generated
	 */
	public Adapter createSubPremiseNumberPrefixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SubPremiseNumberSuffix <em>Sub Premise Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SubPremiseNumberSuffix
	 * @generated
	 */
	public Adapter createSubPremiseNumberSuffixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.SupplementaryPostalServiceData <em>Supplementary Postal Service Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.SupplementaryPostalServiceData
	 * @generated
	 */
	public Adapter createSupplementaryPostalServiceDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Thoroughfare <em>Thoroughfare</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Thoroughfare
	 * @generated
	 */
	public Adapter createThoroughfareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareLeadingType
	 * @generated
	 */
	public Adapter createThoroughfareLeadingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareName <em>Thoroughfare Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareName
	 * @generated
	 */
	public Adapter createThoroughfareNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareNumber <em>Thoroughfare Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareNumber
	 * @generated
	 */
	public Adapter createThoroughfareNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareNumberFrom <em>Thoroughfare Number From</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberFrom
	 * @generated
	 */
	public Adapter createThoroughfareNumberFromAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberPrefix
	 * @generated
	 */
	public Adapter createThoroughfareNumberPrefixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareNumberRange <em>Thoroughfare Number Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberRange
	 * @generated
	 */
	public Adapter createThoroughfareNumberRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberSuffix
	 * @generated
	 */
	public Adapter createThoroughfareNumberSuffixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareNumberTo <em>Thoroughfare Number To</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareNumberTo
	 * @generated
	 */
	public Adapter createThoroughfareNumberToAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfarePostDirection
	 * @generated
	 */
	public Adapter createThoroughfarePostDirectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfarePreDirection
	 * @generated
	 */
	public Adapter createThoroughfarePreDirectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.ThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.ThoroughfareTrailingType
	 * @generated
	 */
	public Adapter createThoroughfareTrailingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.oasis.xal.Xal <em>Xal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.oasis.xal.Xal
	 * @generated
	 */
	public Adapter createXalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //XalAdapterFactory
