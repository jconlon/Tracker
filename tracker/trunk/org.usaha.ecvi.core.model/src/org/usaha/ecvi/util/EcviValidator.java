/**
 */
package org.usaha.ecvi.util;

import java.math.BigDecimal;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

import org.usaha.ecvi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.usaha.ecvi.EcviPackage
 * @generated
 */
public class EcviValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EcviValidator INSTANCE = new EcviValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.usaha.ecvi";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcviValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return EcviPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case EcviPackage.ACCESSION:
				return validateAccession((Accession)value, diagnostics, context);
			case EcviPackage.ACCESSIONS:
				return validateAccessions((Accessions)value, diagnostics, context);
			case EcviPackage.ADDRESS:
				return validateAddress((Address)value, diagnostics, context);
			case EcviPackage.ANIMAL:
				return validateAnimal((Animal)value, diagnostics, context);
			case EcviPackage.ANIMAL_TAG:
				return validateAnimalTag((AnimalTag)value, diagnostics, context);
			case EcviPackage.ATTACHEMENT:
				return validateAttachement((Attachement)value, diagnostics, context);
			case EcviPackage.CONTACT:
				return validateContact((Contact)value, diagnostics, context);
			case EcviPackage.DOCUMENT_ROOT:
				return validateDocumentRoot((DocumentRoot)value, diagnostics, context);
			case EcviPackage.ECVI:
				return validateEcvi((Ecvi)value, diagnostics, context);
			case EcviPackage.GEO_POINT:
				return validateGeoPoint((GeoPoint)value, diagnostics, context);
			case EcviPackage.GROUP_LOT:
				return validateGroupLot((GroupLot)value, diagnostics, context);
			case EcviPackage.LABORATORY:
				return validateLaboratory((Laboratory)value, diagnostics, context);
			case EcviPackage.MOVEMENT_PURPOSES:
				return validateMovementPurposes((MovementPurposes)value, diagnostics, context);
			case EcviPackage.PERSON:
				return validatePerson((Person)value, diagnostics, context);
			case EcviPackage.PHONE_NUM:
				return validatePhoneNum((PhoneNum)value, diagnostics, context);
			case EcviPackage.PREMISES:
				return validatePremises((Premises)value, diagnostics, context);
			case EcviPackage.PROGRAM_STATUS:
				return validateProgramStatus((ProgramStatus)value, diagnostics, context);
			case EcviPackage.RESULT_VALUE:
				return validateResultValue((ResultValue)value, diagnostics, context);
			case EcviPackage.TEST:
				return validateTest((Test)value, diagnostics, context);
			case EcviPackage.VETERINARIAN:
				return validateVeterinarian((Veterinarian)value, diagnostics, context);
			case EcviPackage.DOC_TYPE:
				return validateDocType((DocType)value, diagnostics, context);
			case EcviPackage.ISO3166_COUNTRY:
				return validateISO3166Country((ISO3166Country)value, diagnostics, context);
			case EcviPackage.MOVEMENT_PURPOSE:
				return validateMovementPurpose((MovementPurpose)value, diagnostics, context);
			case EcviPackage.PHONE_DEVICE:
				return validatePhoneDevice((PhoneDevice)value, diagnostics, context);
			case EcviPackage.PROGRAM_STATUS_NAME:
				return validateProgramStatusName((ProgramStatusName)value, diagnostics, context);
			case EcviPackage.PROGRAM_STATUS_VALUE:
				return validateProgramStatusValue((ProgramStatusValue)value, diagnostics, context);
			case EcviPackage.RESULT_NAME:
				return validateResultName((ResultName)value, diagnostics, context);
			case EcviPackage.SEX:
				return validateSex((Sex)value, diagnostics, context);
			case EcviPackage.SPECIES_CODE:
				return validateSpeciesCode((SpeciesCode)value, diagnostics, context);
			case EcviPackage.TAG_TYPE:
				return validateTagType((TagType)value, diagnostics, context);
			case EcviPackage.US_STATE:
				return validateUsState((UsState)value, diagnostics, context);
			case EcviPackage.ADDRESS_LINE1:
				return validateAddressLine1((String)value, diagnostics, context);
			case EcviPackage.ADDRESS_LINE2:
				return validateAddressLine2((String)value, diagnostics, context);
			case EcviPackage.AGE:
				return validateAge((String)value, diagnostics, context);
			case EcviPackage.ANIMAL_SEX_DETAIL:
				return validateAnimalSexDetail((String)value, diagnostics, context);
			case EcviPackage.ATTACHEMENT_COMMENT:
				return validateAttachementComment((String)value, diagnostics, context);
			case EcviPackage.BREED:
				return validateBreed((String)value, diagnostics, context);
			case EcviPackage.COUNTY:
				return validateCounty((String)value, diagnostics, context);
			case EcviPackage.CVI_NUMBER:
				return validateCviNumber((String)value, diagnostics, context);
			case EcviPackage.DOC_TYPE_OBJECT:
				return validateDocTypeObject((DocType)value, diagnostics, context);
			case EcviPackage.ENTRY_PERMIT_NUMBER:
				return validateEntryPermitNumber((String)value, diagnostics, context);
			case EcviPackage.FILE_NAME:
				return validateFileName((String)value, diagnostics, context);
			case EcviPackage.GROUP_LOT_DESCRIPTION:
				return validateGroupLotDescription((String)value, diagnostics, context);
			case EcviPackage.GROUP_LOT_SEX_DETAIL:
				return validateGroupLotSexDetail((String)value, diagnostics, context);
			case EcviPackage.ISO3166_COUNTRY_OBJECT:
				return validateISO3166CountryObject((ISO3166Country)value, diagnostics, context);
			case EcviPackage.LATITUDE:
				return validateLatitude((BigDecimal)value, diagnostics, context);
			case EcviPackage.LONGITUDE:
				return validateLongitude((BigDecimal)value, diagnostics, context);
			case EcviPackage.MIME_TYPE:
				return validateMimeType((String)value, diagnostics, context);
			case EcviPackage.MOVEMENT_PURPOSE_OBJECT:
				return validateMovementPurposeObject((MovementPurpose)value, diagnostics, context);
			case EcviPackage.PHONE_DEVICE_OBJECT:
				return validatePhoneDeviceObject((PhoneDevice)value, diagnostics, context);
			case EcviPackage.PHONE_NUMBER:
				return validatePhoneNumber((String)value, diagnostics, context);
			case EcviPackage.PHONE_NUM_COMMENT:
				return validatePhoneNumComment((String)value, diagnostics, context);
			case EcviPackage.PHONE_NUM_NUMBER:
				return validatePhoneNumNumber((String)value, diagnostics, context);
			case EcviPackage.PREM_ID:
				return validatePremId((String)value, diagnostics, context);
			case EcviPackage.PROGRAM_STATUS_NAME_OBJECT:
				return validateProgramStatusNameObject((ProgramStatusName)value, diagnostics, context);
			case EcviPackage.PROGRAM_STATUS_VALUE_OBJECT:
				return validateProgramStatusValueObject((ProgramStatusValue)value, diagnostics, context);
			case EcviPackage.RESULT_NAME_OBJECT:
				return validateResultNameObject((ResultName)value, diagnostics, context);
			case EcviPackage.SEX_OBJECT:
				return validateSexObject((Sex)value, diagnostics, context);
			case EcviPackage.SPECIES_CODE_OBJECT:
				return validateSpeciesCodeObject((SpeciesCode)value, diagnostics, context);
			case EcviPackage.TAG_TYPE_OBJECT:
				return validateTagTypeObject((TagType)value, diagnostics, context);
			case EcviPackage.TOWN:
				return validateTown((String)value, diagnostics, context);
			case EcviPackage.US_STATE_OBJECT:
				return validateUsStateObject((UsState)value, diagnostics, context);
			case EcviPackage.ZIP_CODE:
				return validateZipCode((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccession(Accession accession, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(accession, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessions(Accessions accessions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(accessions, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddress(Address address, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(address, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimal(Animal animal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(animal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimalTag(AnimalTag animalTag, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(animalTag, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttachement(Attachement attachement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attachement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContact(Contact contact, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(contact, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocumentRoot(DocumentRoot documentRoot, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(documentRoot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEcvi(Ecvi ecvi, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ecvi, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeoPoint(GeoPoint geoPoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(geoPoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupLot(GroupLot groupLot, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(groupLot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLaboratory(Laboratory laboratory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(laboratory, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovementPurposes(MovementPurposes movementPurposes, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(movementPurposes, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePerson(Person person, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(person, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNum(PhoneNum phoneNum, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(phoneNum, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePremises(Premises premises, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(premises, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProgramStatus(ProgramStatus programStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(programStatus, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResultValue(ResultValue resultValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resultValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTest(Test test, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(test, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVeterinarian(Veterinarian veterinarian, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(veterinarian, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocType(DocType docType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateISO3166Country(ISO3166Country iso3166Country, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovementPurpose(MovementPurpose movementPurpose, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneDevice(PhoneDevice phoneDevice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProgramStatusName(ProgramStatusName programStatusName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProgramStatusValue(ProgramStatusValue programStatusValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResultName(ResultName resultName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSex(Sex sex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpeciesCode(SpeciesCode speciesCode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTagType(TagType tagType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUsState(UsState usState, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddressLine1(String addressLine1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateAddressLine1_MaxLength(addressLine1, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Address Line1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddressLine1_MaxLength(String addressLine1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = addressLine1.length();
		boolean result = length <= 200;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.ADDRESS_LINE1, addressLine1, length, 200, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddressLine2(String addressLine2, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateAddressLine2_MaxLength(addressLine2, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Address Line2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddressLine2_MaxLength(String addressLine2, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = addressLine2.length();
		boolean result = length <= 200;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.ADDRESS_LINE2, addressLine2, length, 200, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAge(String age, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateAge_Pattern(age, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateAge_Pattern
	 */
	public static final  PatternMatcher [][] AGE__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[0-9]{1,2}(d|wk|mo|a)"),
				XMLTypeUtil.createPatternMatcher("(19|20)\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Age</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAge_Pattern(String age, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(EcviPackage.Literals.AGE, age, AGE__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimalSexDetail(String animalSexDetail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateAnimalSexDetail_MaxLength(animalSexDetail, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Animal Sex Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimalSexDetail_MaxLength(String animalSexDetail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = animalSexDetail.length();
		boolean result = length <= 100;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.ANIMAL_SEX_DETAIL, animalSexDetail, length, 100, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttachementComment(String attachementComment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateAttachementComment_MaxLength(attachementComment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Attachement Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttachementComment_MaxLength(String attachementComment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = attachementComment.length();
		boolean result = length <= 250;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.ATTACHEMENT_COMMENT, attachementComment, length, 250, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBreed(String breed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateBreed_Pattern(breed, diagnostics, context);
		if (result || diagnostics != null) result &= validateBreed_MinLength(breed, diagnostics, context);
		if (result || diagnostics != null) result &= validateBreed_MaxLength(breed, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateBreed_Pattern
	 */
	public static final  PatternMatcher [][] BREED__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[A-Z]{2,3}")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Breed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBreed_Pattern(String breed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(EcviPackage.Literals.BREED, breed, BREED__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * Validates the MinLength constraint of '<em>Breed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBreed_MinLength(String breed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = breed.length();
		boolean result = length >= 2;
		if (!result && diagnostics != null)
			reportMinLengthViolation(EcviPackage.Literals.BREED, breed, length, 2, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Breed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBreed_MaxLength(String breed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = breed.length();
		boolean result = length <= 3;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.BREED, breed, length, 3, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCounty(String county, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateCounty_MinLength(county, diagnostics, context);
		if (result || diagnostics != null) result &= validateCounty_MaxLength(county, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MinLength constraint of '<em>County</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCounty_MinLength(String county, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = county.length();
		boolean result = length >= 3;
		if (!result && diagnostics != null)
			reportMinLengthViolation(EcviPackage.Literals.COUNTY, county, length, 3, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>County</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCounty_MaxLength(String county, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = county.length();
		boolean result = length <= 40;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.COUNTY, county, length, 40, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCviNumber(String cviNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateCviNumber_MaxLength(cviNumber, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Cvi Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCviNumber_MaxLength(String cviNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = cviNumber.length();
		boolean result = length <= 100;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.CVI_NUMBER, cviNumber, length, 100, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocTypeObject(DocType docTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntryPermitNumber(String entryPermitNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateEntryPermitNumber_MaxLength(entryPermitNumber, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Entry Permit Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntryPermitNumber_MaxLength(String entryPermitNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = entryPermitNumber.length();
		boolean result = length <= 100;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.ENTRY_PERMIT_NUMBER, entryPermitNumber, length, 100, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFileName(String fileName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateFileName_MaxLength(fileName, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>File Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFileName_MaxLength(String fileName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = fileName.length();
		boolean result = length <= 250;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.FILE_NAME, fileName, length, 250, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupLotDescription(String groupLotDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateGroupLotDescription_MaxLength(groupLotDescription, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Group Lot Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupLotDescription_MaxLength(String groupLotDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = groupLotDescription.length();
		boolean result = length <= 200;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.GROUP_LOT_DESCRIPTION, groupLotDescription, length, 200, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupLotSexDetail(String groupLotSexDetail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateGroupLotSexDetail_MaxLength(groupLotSexDetail, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Group Lot Sex Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupLotSexDetail_MaxLength(String groupLotSexDetail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = groupLotSexDetail.length();
		boolean result = length <= 100;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.GROUP_LOT_SEX_DETAIL, groupLotSexDetail, length, 100, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateISO3166CountryObject(ISO3166Country iso3166CountryObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLatitude(BigDecimal latitude, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateLatitude_Min(latitude, diagnostics, context);
		if (result || diagnostics != null) result &= validateLatitude_Max(latitude, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateLatitude_Min
	 */
	public static final BigDecimal LATITUDE__MIN__VALUE = new BigDecimal("-90.0");

	/**
	 * Validates the Min constraint of '<em>Latitude</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLatitude_Min(BigDecimal latitude, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = latitude.compareTo(LATITUDE__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(EcviPackage.Literals.LATITUDE, latitude, LATITUDE__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateLatitude_Max
	 */
	public static final BigDecimal LATITUDE__MAX__VALUE = new BigDecimal("90.0");

	/**
	 * Validates the Max constraint of '<em>Latitude</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLatitude_Max(BigDecimal latitude, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = latitude.compareTo(LATITUDE__MAX__VALUE) <= 0;
		if (!result && diagnostics != null)
			reportMaxViolation(EcviPackage.Literals.LATITUDE, latitude, LATITUDE__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLongitude(BigDecimal longitude, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateLongitude_Min(longitude, diagnostics, context);
		if (result || diagnostics != null) result &= validateLongitude_Max(longitude, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateLongitude_Min
	 */
	public static final BigDecimal LONGITUDE__MIN__VALUE = new BigDecimal("-180.0");

	/**
	 * Validates the Min constraint of '<em>Longitude</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLongitude_Min(BigDecimal longitude, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = longitude.compareTo(LONGITUDE__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(EcviPackage.Literals.LONGITUDE, longitude, LONGITUDE__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateLongitude_Max
	 */
	public static final BigDecimal LONGITUDE__MAX__VALUE = new BigDecimal("180.0");

	/**
	 * Validates the Max constraint of '<em>Longitude</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLongitude_Max(BigDecimal longitude, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = longitude.compareTo(LONGITUDE__MAX__VALUE) <= 0;
		if (!result && diagnostics != null)
			reportMaxViolation(EcviPackage.Literals.LONGITUDE, longitude, LONGITUDE__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMimeType(String mimeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateMimeType_Pattern(mimeType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateMimeType_Pattern
	 */
	public static final  PatternMatcher [][] MIME_TYPE__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("^.{1,127}/.{1,127}$")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Mime Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMimeType_Pattern(String mimeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(EcviPackage.Literals.MIME_TYPE, mimeType, MIME_TYPE__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovementPurposeObject(MovementPurpose movementPurposeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneDeviceObject(PhoneDevice phoneDeviceObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNumber(String phoneNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePhoneNumber_Pattern(phoneNumber, diagnostics, context);
		if (result || diagnostics != null) result &= validatePhoneNumber_MinLength(phoneNumber, diagnostics, context);
		if (result || diagnostics != null) result &= validatePhoneNumber_MaxLength(phoneNumber, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePhoneNumber_Pattern
	 */
	public static final  PatternMatcher [][] PHONE_NUMBER__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[0-9]{10}")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Phone Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNumber_Pattern(String phoneNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(EcviPackage.Literals.PHONE_NUMBER, phoneNumber, PHONE_NUMBER__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * Validates the MinLength constraint of '<em>Phone Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNumber_MinLength(String phoneNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = phoneNumber.length();
		boolean result = length >= 10;
		if (!result && diagnostics != null)
			reportMinLengthViolation(EcviPackage.Literals.PHONE_NUMBER, phoneNumber, length, 10, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Phone Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNumber_MaxLength(String phoneNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = phoneNumber.length();
		boolean result = length <= 10;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.PHONE_NUMBER, phoneNumber, length, 10, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNumComment(String phoneNumComment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePhoneNumComment_MaxLength(phoneNumComment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Phone Num Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNumComment_MaxLength(String phoneNumComment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = phoneNumComment.length();
		boolean result = length <= 100;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.PHONE_NUM_COMMENT, phoneNumComment, length, 100, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNumNumber(String phoneNumNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePhoneNumNumber_Pattern(phoneNumNumber, diagnostics, context);
		if (result || diagnostics != null) result &= validatePhoneNumber_MinLength(phoneNumNumber, diagnostics, context);
		if (result || diagnostics != null) result &= validatePhoneNumber_MaxLength(phoneNumNumber, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePhoneNumNumber_Pattern
	 */
	public static final  PatternMatcher [][] PHONE_NUM_NUMBER__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[0-9]{10}")
			},
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[0-9]{10}")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Phone Num Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePhoneNumNumber_Pattern(String phoneNumNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(EcviPackage.Literals.PHONE_NUM_NUMBER, phoneNumNumber, PHONE_NUM_NUMBER__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePremId(String premId, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePremId_Pattern(premId, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePremId_Pattern
	 */
	public static final  PatternMatcher [][] PREM_ID__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[A-Z0-9]{6,8}")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Prem Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePremId_Pattern(String premId, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(EcviPackage.Literals.PREM_ID, premId, PREM_ID__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProgramStatusNameObject(ProgramStatusName programStatusNameObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProgramStatusValueObject(ProgramStatusValue programStatusValueObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResultNameObject(ResultName resultNameObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSexObject(Sex sexObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpeciesCodeObject(SpeciesCode speciesCodeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTagTypeObject(TagType tagTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTown(String town, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateTown_MaxLength(town, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Town</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTown_MaxLength(String town, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = town.length();
		boolean result = length <= 200;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(EcviPackage.Literals.TOWN, town, length, 200, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUsStateObject(UsState usStateObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateZipCode(String zipCode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateZipCode_Pattern(zipCode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateZipCode_Pattern
	 */
	public static final  PatternMatcher [][] ZIP_CODE__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[0-9]{5}"),
				XMLTypeUtil.createPatternMatcher("[0-9]{5}-[0-9]{4}")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Zip Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateZipCode_Pattern(String zipCode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(EcviPackage.Literals.ZIP_CODE, zipCode, ZIP_CODE__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //EcviValidator
