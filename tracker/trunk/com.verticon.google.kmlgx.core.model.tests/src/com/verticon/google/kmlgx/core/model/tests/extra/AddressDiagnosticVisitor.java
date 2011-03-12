package com.verticon.google.kmlgx.core.model.tests.extra;

import com.verticon.oasis.xal.Address;
import com.verticon.oasis.xal.AddressDetails;
import com.verticon.oasis.xal.AddressIdentifier;
import com.verticon.oasis.xal.AddressLatitude;
import com.verticon.oasis.xal.AddressLatitudeDirection;
import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.AddressLines;
import com.verticon.oasis.xal.AddressLongitude;
import com.verticon.oasis.xal.AddressLongitudeDirection;
import com.verticon.oasis.xal.AdministrativeArea;
import com.verticon.oasis.xal.Barcode;
import com.verticon.oasis.xal.BuildingName;
import com.verticon.oasis.xal.Country;
import com.verticon.oasis.xal.CountryName;
import com.verticon.oasis.xal.CountryNameCode;
import com.verticon.oasis.xal.Department;
import com.verticon.oasis.xal.DepartmentName;
import com.verticon.oasis.xal.DependentLocality;
import com.verticon.oasis.xal.DependentLocalityName;
import com.verticon.oasis.xal.DependentLocalityNumber;
import com.verticon.oasis.xal.DependentThoroughfare;
import com.verticon.oasis.xal.DocumentRoot;
import com.verticon.oasis.xal.EndorsementLineCode;
import com.verticon.oasis.xal.Firm;
import com.verticon.oasis.xal.FirmName;
import com.verticon.oasis.xal.util.XalSwitch;

/**
 * Address visitor.  Note: not all overrides were implemented so there will be some gaps.
 * @author jconlon
 *
 */
public class AddressDiagnosticVisitor extends XalSwitch<Object>{

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Xal visited ";
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddress(com.verticon.oasis.xal.Address)
	 */
	@Override
	public Object caseAddress(Address object) {
		System.out.println(this+" address: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddressDetails(com.verticon.oasis.xal.AddressDetails)
	 */
	@Override
	public Object caseAddressDetails(AddressDetails object) {
		System.out.println(this+" addressDetails: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddressIdentifier(com.verticon.oasis.xal.AddressIdentifier)
	 */
	@Override
	public Object caseAddressIdentifier(AddressIdentifier object) {
		System.out.println(this+" addressIdentifier: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddressLatitude(com.verticon.oasis.xal.AddressLatitude)
	 */
	@Override
	public Object caseAddressLatitude(AddressLatitude object) {
		System.out.println(this+" addressLatitude: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddressLatitudeDirection(com.verticon.oasis.xal.AddressLatitudeDirection)
	 */
	@Override
	public Object caseAddressLatitudeDirection(AddressLatitudeDirection object) {
		System.out.println(this+" addressLatitudeDirection: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddressLine(com.verticon.oasis.xal.AddressLine)
	 */
	@Override
	public Object caseAddressLine(AddressLine object) {
		System.out.println(this+" addressLine: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddressLines(com.verticon.oasis.xal.AddressLines)
	 */
	@Override
	public Object caseAddressLines(AddressLines object) {
		System.out.println(this+" addressLines: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddressLongitude(com.verticon.oasis.xal.AddressLongitude)
	 */
	@Override
	public Object caseAddressLongitude(AddressLongitude object) {
		System.out.println(this+" addressLongitude: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAddressLongitudeDirection(com.verticon.oasis.xal.AddressLongitudeDirection)
	 */
	@Override
	public Object caseAddressLongitudeDirection(AddressLongitudeDirection object) {
		System.out.println(this+" addressLongitudeDirection: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseAdministrativeArea(com.verticon.oasis.xal.AdministrativeArea)
	 */
	@Override
	public Object caseAdministrativeArea(AdministrativeArea object) {
		System.out.println(this+" adminstrativeArea: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseBarcode(com.verticon.oasis.xal.Barcode)
	 */
	@Override
	public Object caseBarcode(Barcode object) {
		System.out.println(this+" barcode: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseBuildingName(com.verticon.oasis.xal.BuildingName)
	 */
	@Override
	public Object caseBuildingName(BuildingName object) {
		System.out.println(this+" buildingName: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseCountry(com.verticon.oasis.xal.Country)
	 */
	@Override
	public Object caseCountry(Country object) {
		System.out.println(this+" country: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseCountryName(com.verticon.oasis.xal.CountryName)
	 */
	@Override
	public Object caseCountryName(CountryName object) {
		System.out.println(this+" countryName: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseCountryNameCode(com.verticon.oasis.xal.CountryNameCode)
	 */
	@Override
	public Object caseCountryNameCode(CountryNameCode object) {
		System.out.println(this+" countryNameCode: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseDepartment(com.verticon.oasis.xal.Department)
	 */
	@Override
	public Object caseDepartment(Department object) {
		System.out.println(this+" department: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseDepartmentName(com.verticon.oasis.xal.DepartmentName)
	 */
	@Override
	public Object caseDepartmentName(DepartmentName object) {
		System.out.println(this+" departmentName: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseDependentLocality(com.verticon.oasis.xal.DependentLocality)
	 */
	@Override
	public Object caseDependentLocality(DependentLocality object) {
		System.out.println(this+" departmentLocality: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseDependentLocalityName(com.verticon.oasis.xal.DependentLocalityName)
	 */
	@Override
	public Object caseDependentLocalityName(DependentLocalityName object) {
		System.out.println(this+" dependentLocalityName: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseDependentLocalityNumber(com.verticon.oasis.xal.DependentLocalityNumber)
	 */
	@Override
	public Object caseDependentLocalityNumber(DependentLocalityNumber object) {
		System.out.println(this+" dependentLocalityNumber: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseDependentThoroughfare(com.verticon.oasis.xal.DependentThoroughfare)
	 */
	@Override
	public Object caseDependentThoroughfare(DependentThoroughfare object) {
		System.out.println(this+" dependentThouroughfare: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseDocumentRoot(com.verticon.oasis.xal.DocumentRoot)
	 */
	@Override
	public Object caseDocumentRoot(DocumentRoot object) {
		System.out.println(this+" documentRoot: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseEndorsementLineCode(com.verticon.oasis.xal.EndorsementLineCode)
	 */
	@Override
	public Object caseEndorsementLineCode(EndorsementLineCode object) {
		System.out.println(this+" endorsmentLineCode: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseFirm(com.verticon.oasis.xal.Firm)
	 */
	@Override
	public Object caseFirm(Firm object) {
		System.out.println(this+" firm: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.oasis.xal.util.XalSwitch#caseFirmName(com.verticon.oasis.xal.FirmName)
	 */
	@Override
	public Object caseFirmName(FirmName object) {
		System.out.println(this+" firmName: " + object);
		return Boolean.TRUE;
	}
	
	
	

	
}
