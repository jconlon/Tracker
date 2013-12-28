/**
 */
package org.usaha.ecvi.impl;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.usaha.ecvi.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcviFactoryImpl extends EFactoryImpl implements EcviFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcviFactory init() {
		try {
			EcviFactory theEcviFactory = (EcviFactory)EPackage.Registry.INSTANCE.getEFactory(EcviPackage.eNS_URI);
			if (theEcviFactory != null) {
				return theEcviFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcviFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcviFactoryImpl() {
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
			case EcviPackage.ACCESSION: return createAccession();
			case EcviPackage.ACCESSIONS: return createAccessions();
			case EcviPackage.ADDRESS: return createAddress();
			case EcviPackage.ANIMAL: return createAnimal();
			case EcviPackage.ANIMAL_TAG: return createAnimalTag();
			case EcviPackage.ATTACHEMENT: return createAttachement();
			case EcviPackage.CONTACT: return createContact();
			case EcviPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case EcviPackage.ECVI: return createEcvi();
			case EcviPackage.GEO_POINT: return createGeoPoint();
			case EcviPackage.GROUP_LOT: return createGroupLot();
			case EcviPackage.LABORATORY: return createLaboratory();
			case EcviPackage.MOVEMENT_PURPOSES: return createMovementPurposes();
			case EcviPackage.PERSON: return createPerson();
			case EcviPackage.PHONE_NUM: return createPhoneNum();
			case EcviPackage.PREMISES: return createPremises();
			case EcviPackage.PROGRAM_STATUS: return createProgramStatus();
			case EcviPackage.RESULT_VALUE: return createResultValue();
			case EcviPackage.TEST: return createTest();
			case EcviPackage.VETERINARIAN: return createVeterinarian();
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
			case EcviPackage.DOC_TYPE:
				return createDocTypeFromString(eDataType, initialValue);
			case EcviPackage.ISO3166_COUNTRY:
				return createISO3166CountryFromString(eDataType, initialValue);
			case EcviPackage.MOVEMENT_PURPOSE:
				return createMovementPurposeFromString(eDataType, initialValue);
			case EcviPackage.PHONE_DEVICE:
				return createPhoneDeviceFromString(eDataType, initialValue);
			case EcviPackage.PROGRAM_STATUS_NAME:
				return createProgramStatusNameFromString(eDataType, initialValue);
			case EcviPackage.PROGRAM_STATUS_VALUE:
				return createProgramStatusValueFromString(eDataType, initialValue);
			case EcviPackage.RESULT_NAME:
				return createResultNameFromString(eDataType, initialValue);
			case EcviPackage.SEX:
				return createSexFromString(eDataType, initialValue);
			case EcviPackage.SPECIES_CODE:
				return createSpeciesCodeFromString(eDataType, initialValue);
			case EcviPackage.TAG_TYPE:
				return createTagTypeFromString(eDataType, initialValue);
			case EcviPackage.US_STATE:
				return createUsStateFromString(eDataType, initialValue);
			case EcviPackage.ADDRESS_LINE1:
				return createAddressLine1FromString(eDataType, initialValue);
			case EcviPackage.ADDRESS_LINE2:
				return createAddressLine2FromString(eDataType, initialValue);
			case EcviPackage.AGE:
				return createAgeFromString(eDataType, initialValue);
			case EcviPackage.ANIMAL_SEX_DETAIL:
				return createAnimalSexDetailFromString(eDataType, initialValue);
			case EcviPackage.ATTACHEMENT_COMMENT:
				return createAttachementCommentFromString(eDataType, initialValue);
			case EcviPackage.BREED:
				return createBreedFromString(eDataType, initialValue);
			case EcviPackage.COUNTY:
				return createCountyFromString(eDataType, initialValue);
			case EcviPackage.CVI_NUMBER:
				return createCviNumberFromString(eDataType, initialValue);
			case EcviPackage.DOC_TYPE_OBJECT:
				return createDocTypeObjectFromString(eDataType, initialValue);
			case EcviPackage.ENTRY_PERMIT_NUMBER:
				return createEntryPermitNumberFromString(eDataType, initialValue);
			case EcviPackage.FILE_NAME:
				return createFileNameFromString(eDataType, initialValue);
			case EcviPackage.GROUP_LOT_DESCRIPTION:
				return createGroupLotDescriptionFromString(eDataType, initialValue);
			case EcviPackage.GROUP_LOT_SEX_DETAIL:
				return createGroupLotSexDetailFromString(eDataType, initialValue);
			case EcviPackage.ISO3166_COUNTRY_OBJECT:
				return createISO3166CountryObjectFromString(eDataType, initialValue);
			case EcviPackage.LATITUDE:
				return createLatitudeFromString(eDataType, initialValue);
			case EcviPackage.LONGITUDE:
				return createLongitudeFromString(eDataType, initialValue);
			case EcviPackage.MIME_TYPE:
				return createMimeTypeFromString(eDataType, initialValue);
			case EcviPackage.MOVEMENT_PURPOSE_OBJECT:
				return createMovementPurposeObjectFromString(eDataType, initialValue);
			case EcviPackage.PHONE_DEVICE_OBJECT:
				return createPhoneDeviceObjectFromString(eDataType, initialValue);
			case EcviPackage.PHONE_NUMBER:
				return createPhoneNumberFromString(eDataType, initialValue);
			case EcviPackage.PHONE_NUM_COMMENT:
				return createPhoneNumCommentFromString(eDataType, initialValue);
			case EcviPackage.PHONE_NUM_NUMBER:
				return createPhoneNumNumberFromString(eDataType, initialValue);
			case EcviPackage.PREM_ID:
				return createPremIdFromString(eDataType, initialValue);
			case EcviPackage.PROGRAM_STATUS_NAME_OBJECT:
				return createProgramStatusNameObjectFromString(eDataType, initialValue);
			case EcviPackage.PROGRAM_STATUS_VALUE_OBJECT:
				return createProgramStatusValueObjectFromString(eDataType, initialValue);
			case EcviPackage.RESULT_NAME_OBJECT:
				return createResultNameObjectFromString(eDataType, initialValue);
			case EcviPackage.SEX_OBJECT:
				return createSexObjectFromString(eDataType, initialValue);
			case EcviPackage.SPECIES_CODE_OBJECT:
				return createSpeciesCodeObjectFromString(eDataType, initialValue);
			case EcviPackage.TAG_TYPE_OBJECT:
				return createTagTypeObjectFromString(eDataType, initialValue);
			case EcviPackage.TOWN:
				return createTownFromString(eDataType, initialValue);
			case EcviPackage.US_STATE_OBJECT:
				return createUsStateObjectFromString(eDataType, initialValue);
			case EcviPackage.ZIP_CODE:
				return createZipCodeFromString(eDataType, initialValue);
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
			case EcviPackage.DOC_TYPE:
				return convertDocTypeToString(eDataType, instanceValue);
			case EcviPackage.ISO3166_COUNTRY:
				return convertISO3166CountryToString(eDataType, instanceValue);
			case EcviPackage.MOVEMENT_PURPOSE:
				return convertMovementPurposeToString(eDataType, instanceValue);
			case EcviPackage.PHONE_DEVICE:
				return convertPhoneDeviceToString(eDataType, instanceValue);
			case EcviPackage.PROGRAM_STATUS_NAME:
				return convertProgramStatusNameToString(eDataType, instanceValue);
			case EcviPackage.PROGRAM_STATUS_VALUE:
				return convertProgramStatusValueToString(eDataType, instanceValue);
			case EcviPackage.RESULT_NAME:
				return convertResultNameToString(eDataType, instanceValue);
			case EcviPackage.SEX:
				return convertSexToString(eDataType, instanceValue);
			case EcviPackage.SPECIES_CODE:
				return convertSpeciesCodeToString(eDataType, instanceValue);
			case EcviPackage.TAG_TYPE:
				return convertTagTypeToString(eDataType, instanceValue);
			case EcviPackage.US_STATE:
				return convertUsStateToString(eDataType, instanceValue);
			case EcviPackage.ADDRESS_LINE1:
				return convertAddressLine1ToString(eDataType, instanceValue);
			case EcviPackage.ADDRESS_LINE2:
				return convertAddressLine2ToString(eDataType, instanceValue);
			case EcviPackage.AGE:
				return convertAgeToString(eDataType, instanceValue);
			case EcviPackage.ANIMAL_SEX_DETAIL:
				return convertAnimalSexDetailToString(eDataType, instanceValue);
			case EcviPackage.ATTACHEMENT_COMMENT:
				return convertAttachementCommentToString(eDataType, instanceValue);
			case EcviPackage.BREED:
				return convertBreedToString(eDataType, instanceValue);
			case EcviPackage.COUNTY:
				return convertCountyToString(eDataType, instanceValue);
			case EcviPackage.CVI_NUMBER:
				return convertCviNumberToString(eDataType, instanceValue);
			case EcviPackage.DOC_TYPE_OBJECT:
				return convertDocTypeObjectToString(eDataType, instanceValue);
			case EcviPackage.ENTRY_PERMIT_NUMBER:
				return convertEntryPermitNumberToString(eDataType, instanceValue);
			case EcviPackage.FILE_NAME:
				return convertFileNameToString(eDataType, instanceValue);
			case EcviPackage.GROUP_LOT_DESCRIPTION:
				return convertGroupLotDescriptionToString(eDataType, instanceValue);
			case EcviPackage.GROUP_LOT_SEX_DETAIL:
				return convertGroupLotSexDetailToString(eDataType, instanceValue);
			case EcviPackage.ISO3166_COUNTRY_OBJECT:
				return convertISO3166CountryObjectToString(eDataType, instanceValue);
			case EcviPackage.LATITUDE:
				return convertLatitudeToString(eDataType, instanceValue);
			case EcviPackage.LONGITUDE:
				return convertLongitudeToString(eDataType, instanceValue);
			case EcviPackage.MIME_TYPE:
				return convertMimeTypeToString(eDataType, instanceValue);
			case EcviPackage.MOVEMENT_PURPOSE_OBJECT:
				return convertMovementPurposeObjectToString(eDataType, instanceValue);
			case EcviPackage.PHONE_DEVICE_OBJECT:
				return convertPhoneDeviceObjectToString(eDataType, instanceValue);
			case EcviPackage.PHONE_NUMBER:
				return convertPhoneNumberToString(eDataType, instanceValue);
			case EcviPackage.PHONE_NUM_COMMENT:
				return convertPhoneNumCommentToString(eDataType, instanceValue);
			case EcviPackage.PHONE_NUM_NUMBER:
				return convertPhoneNumNumberToString(eDataType, instanceValue);
			case EcviPackage.PREM_ID:
				return convertPremIdToString(eDataType, instanceValue);
			case EcviPackage.PROGRAM_STATUS_NAME_OBJECT:
				return convertProgramStatusNameObjectToString(eDataType, instanceValue);
			case EcviPackage.PROGRAM_STATUS_VALUE_OBJECT:
				return convertProgramStatusValueObjectToString(eDataType, instanceValue);
			case EcviPackage.RESULT_NAME_OBJECT:
				return convertResultNameObjectToString(eDataType, instanceValue);
			case EcviPackage.SEX_OBJECT:
				return convertSexObjectToString(eDataType, instanceValue);
			case EcviPackage.SPECIES_CODE_OBJECT:
				return convertSpeciesCodeObjectToString(eDataType, instanceValue);
			case EcviPackage.TAG_TYPE_OBJECT:
				return convertTagTypeObjectToString(eDataType, instanceValue);
			case EcviPackage.TOWN:
				return convertTownToString(eDataType, instanceValue);
			case EcviPackage.US_STATE_OBJECT:
				return convertUsStateObjectToString(eDataType, instanceValue);
			case EcviPackage.ZIP_CODE:
				return convertZipCodeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accession createAccession() {
		AccessionImpl accession = new AccessionImpl();
		return accession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accessions createAccessions() {
		AccessionsImpl accessions = new AccessionsImpl();
		return accessions;
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
	public Animal createAnimal() {
		AnimalImpl animal = new AnimalImpl();
		return animal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalTag createAnimalTag() {
		AnimalTagImpl animalTag = new AnimalTagImpl();
		return animalTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attachement createAttachement() {
		AttachementImpl attachement = new AttachementImpl();
		return attachement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact createContact() {
		ContactImpl contact = new ContactImpl();
		return contact;
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
	public Ecvi createEcvi() {
		EcviImpl ecvi = new EcviImpl();
		return ecvi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoPoint createGeoPoint() {
		GeoPointImpl geoPoint = new GeoPointImpl();
		return geoPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupLot createGroupLot() {
		GroupLotImpl groupLot = new GroupLotImpl();
		return groupLot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Laboratory createLaboratory() {
		LaboratoryImpl laboratory = new LaboratoryImpl();
		return laboratory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovementPurposes createMovementPurposes() {
		MovementPurposesImpl movementPurposes = new MovementPurposesImpl();
		return movementPurposes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhoneNum createPhoneNum() {
		PhoneNumImpl phoneNum = new PhoneNumImpl();
		return phoneNum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises createPremises() {
		PremisesImpl premises = new PremisesImpl();
		return premises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramStatus createProgramStatus() {
		ProgramStatusImpl programStatus = new ProgramStatusImpl();
		return programStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultValue createResultValue() {
		ResultValueImpl resultValue = new ResultValueImpl();
		return resultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Test createTest() {
		TestImpl test = new TestImpl();
		return test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Veterinarian createVeterinarian() {
		VeterinarianImpl veterinarian = new VeterinarianImpl();
		return veterinarian;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocType createDocTypeFromString(EDataType eDataType, String initialValue) {
		DocType result = DocType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDocTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISO3166Country createISO3166CountryFromString(EDataType eDataType, String initialValue) {
		ISO3166Country result = ISO3166Country.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertISO3166CountryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovementPurpose createMovementPurposeFromString(EDataType eDataType, String initialValue) {
		MovementPurpose result = MovementPurpose.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMovementPurposeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhoneDevice createPhoneDeviceFromString(EDataType eDataType, String initialValue) {
		PhoneDevice result = PhoneDevice.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPhoneDeviceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramStatusName createProgramStatusNameFromString(EDataType eDataType, String initialValue) {
		ProgramStatusName result = ProgramStatusName.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProgramStatusNameToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramStatusValue createProgramStatusValueFromString(EDataType eDataType, String initialValue) {
		ProgramStatusValue result = ProgramStatusValue.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProgramStatusValueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultName createResultNameFromString(EDataType eDataType, String initialValue) {
		ResultName result = ResultName.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResultNameToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sex createSexFromString(EDataType eDataType, String initialValue) {
		Sex result = Sex.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSexToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpeciesCode createSpeciesCodeFromString(EDataType eDataType, String initialValue) {
		SpeciesCode result = SpeciesCode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSpeciesCodeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagType createTagTypeFromString(EDataType eDataType, String initialValue) {
		TagType result = TagType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTagTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsState createUsStateFromString(EDataType eDataType, String initialValue) {
		UsState result = UsState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUsStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAddressLine1FromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAddressLine1ToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAddressLine2FromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAddressLine2ToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAgeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAgeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAnimalSexDetailFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAnimalSexDetailToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAttachementCommentFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttachementCommentToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createBreedFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBreedToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createCountyFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCountyToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createCviNumberFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCviNumberToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocType createDocTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDocTypeFromString(EcviPackage.Literals.DOC_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDocTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDocTypeToString(EcviPackage.Literals.DOC_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createEntryPermitNumberFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEntryPermitNumberToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFileNameFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileNameToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createGroupLotDescriptionFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGroupLotDescriptionToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createGroupLotSexDetailFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGroupLotSexDetailToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISO3166Country createISO3166CountryObjectFromString(EDataType eDataType, String initialValue) {
		return createISO3166CountryFromString(EcviPackage.Literals.ISO3166_COUNTRY, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertISO3166CountryObjectToString(EDataType eDataType, Object instanceValue) {
		return convertISO3166CountryToString(EcviPackage.Literals.ISO3166_COUNTRY, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal createLatitudeFromString(EDataType eDataType, String initialValue) {
		return (BigDecimal)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.DECIMAL, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLatitudeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.DECIMAL, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal createLongitudeFromString(EDataType eDataType, String initialValue) {
		return (BigDecimal)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.DECIMAL, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLongitudeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.DECIMAL, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createMimeTypeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMimeTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovementPurpose createMovementPurposeObjectFromString(EDataType eDataType, String initialValue) {
		return createMovementPurposeFromString(EcviPackage.Literals.MOVEMENT_PURPOSE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMovementPurposeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertMovementPurposeToString(EcviPackage.Literals.MOVEMENT_PURPOSE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhoneDevice createPhoneDeviceObjectFromString(EDataType eDataType, String initialValue) {
		return createPhoneDeviceFromString(EcviPackage.Literals.PHONE_DEVICE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPhoneDeviceObjectToString(EDataType eDataType, Object instanceValue) {
		return convertPhoneDeviceToString(EcviPackage.Literals.PHONE_DEVICE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPhoneNumberFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPhoneNumberToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPhoneNumCommentFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPhoneNumCommentToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPhoneNumNumberFromString(EDataType eDataType, String initialValue) {
		return createPhoneNumberFromString(EcviPackage.Literals.PHONE_NUMBER, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPhoneNumNumberToString(EDataType eDataType, Object instanceValue) {
		return convertPhoneNumberToString(EcviPackage.Literals.PHONE_NUMBER, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPremIdFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPremIdToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramStatusName createProgramStatusNameObjectFromString(EDataType eDataType, String initialValue) {
		return createProgramStatusNameFromString(EcviPackage.Literals.PROGRAM_STATUS_NAME, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProgramStatusNameObjectToString(EDataType eDataType, Object instanceValue) {
		return convertProgramStatusNameToString(EcviPackage.Literals.PROGRAM_STATUS_NAME, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramStatusValue createProgramStatusValueObjectFromString(EDataType eDataType, String initialValue) {
		return createProgramStatusValueFromString(EcviPackage.Literals.PROGRAM_STATUS_VALUE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProgramStatusValueObjectToString(EDataType eDataType, Object instanceValue) {
		return convertProgramStatusValueToString(EcviPackage.Literals.PROGRAM_STATUS_VALUE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultName createResultNameObjectFromString(EDataType eDataType, String initialValue) {
		return createResultNameFromString(EcviPackage.Literals.RESULT_NAME, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResultNameObjectToString(EDataType eDataType, Object instanceValue) {
		return convertResultNameToString(EcviPackage.Literals.RESULT_NAME, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sex createSexObjectFromString(EDataType eDataType, String initialValue) {
		return createSexFromString(EcviPackage.Literals.SEX, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSexObjectToString(EDataType eDataType, Object instanceValue) {
		return convertSexToString(EcviPackage.Literals.SEX, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpeciesCode createSpeciesCodeObjectFromString(EDataType eDataType, String initialValue) {
		return createSpeciesCodeFromString(EcviPackage.Literals.SPECIES_CODE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSpeciesCodeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertSpeciesCodeToString(EcviPackage.Literals.SPECIES_CODE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagType createTagTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createTagTypeFromString(EcviPackage.Literals.TAG_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTagTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTagTypeToString(EcviPackage.Literals.TAG_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTownFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTownToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsState createUsStateObjectFromString(EDataType eDataType, String initialValue) {
		return createUsStateFromString(EcviPackage.Literals.US_STATE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUsStateObjectToString(EDataType eDataType, Object instanceValue) {
		return convertUsStateToString(EcviPackage.Literals.US_STATE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createZipCodeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertZipCodeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcviPackage getEcviPackage() {
		return (EcviPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcviPackage getPackage() {
		return EcviPackage.eINSTANCE;
	}

} //EcviFactoryImpl
