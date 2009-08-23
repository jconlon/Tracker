/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.BeefBreed;
import com.verticon.tracker.BirthDefect;
import com.verticon.tracker.Birthing;
import com.verticon.tracker.BisonBreed;
import com.verticon.tracker.Bovine;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.Calving;
import com.verticon.tracker.Caprine;
import com.verticon.tracker.DairyBreed;
import com.verticon.tracker.Died;
import com.verticon.tracker.Equine;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventAttributeSchema;
import com.verticon.tracker.EventDataType;
import com.verticon.tracker.EventSchema;
import com.verticon.tracker.Exported;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.GoatBreed;
import com.verticon.tracker.HerdTest;
import com.verticon.tracker.HorseBreed;
import com.verticon.tracker.ICVI;
import com.verticon.tracker.Imported;
import com.verticon.tracker.Level;
import com.verticon.tracker.Location;
import com.verticon.tracker.LostTag;
import com.verticon.tracker.Mastitis;
import com.verticon.tracker.MedicalCondition;
import com.verticon.tracker.MedicalTreatment;
import com.verticon.tracker.MilkTest;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.OneToTen;
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Premises;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Schema;
import com.verticon.tracker.Sex;
import com.verticon.tracker.SheepBreed;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.Slaughtered;
import com.verticon.tracker.Swine;
import com.verticon.tracker.SwineBreed;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TagAllocated;
import com.verticon.tracker.TagApplied;
import com.verticon.tracker.TagRetired;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.Treatment;
import com.verticon.tracker.TreatmentMethod;
import com.verticon.tracker.USBeefGrading;
import com.verticon.tracker.USBeefYieldGrade;
import com.verticon.tracker.USOvineGrading;
import com.verticon.tracker.USQualityGrade;
import com.verticon.tracker.USSwineGrading;
import com.verticon.tracker.USSwineQualityGrade;
import com.verticon.tracker.WeighIn;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage
 * @generated
 */
public class TrackerValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TrackerValidator INSTANCE = new TrackerValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.verticon.tracker";

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
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return TrackerPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case TrackerPackage.ANIMAL:
				return validateAnimal((Animal)value, diagnostics, context);
			case TrackerPackage.TAG:
				return validateTag((Tag)value, diagnostics, context);
			case TrackerPackage.BOVINE:
				return validateBovine((Bovine)value, diagnostics, context);
			case TrackerPackage.EVENT:
				return validateEvent((Event)value, diagnostics, context);
			case TrackerPackage.TAG_ALLOCATED:
				return validateTagAllocated((TagAllocated)value, diagnostics, context);
			case TrackerPackage.PREMISES:
				return validatePremises((Premises)value, diagnostics, context);
			case TrackerPackage.BOVINE_BEEF:
				return validateBovineBeef((BovineBeef)value, diagnostics, context);
			case TrackerPackage.OVINE:
				return validateOvine((Ovine)value, diagnostics, context);
			case TrackerPackage.BOVINE_BISON:
				return validateBovineBison((BovineBison)value, diagnostics, context);
			case TrackerPackage.BOVINE_DAIRY:
				return validateBovineDairy((BovineDairy)value, diagnostics, context);
			case TrackerPackage.TAG_APPLIED:
				return validateTagApplied((TagApplied)value, diagnostics, context);
			case TrackerPackage.MOVED_IN:
				return validateMovedIn((MovedIn)value, diagnostics, context);
			case TrackerPackage.MOVED_OUT:
				return validateMovedOut((MovedOut)value, diagnostics, context);
			case TrackerPackage.LOST_TAG:
				return validateLostTag((LostTag)value, diagnostics, context);
			case TrackerPackage.REPLACED_TAG:
				return validateReplacedTag((ReplacedTag)value, diagnostics, context);
			case TrackerPackage.IMPORTED:
				return validateImported((Imported)value, diagnostics, context);
			case TrackerPackage.EXPORTED:
				return validateExported((Exported)value, diagnostics, context);
			case TrackerPackage.SIGHTING:
				return validateSighting((Sighting)value, diagnostics, context);
			case TrackerPackage.SLAUGHTERED:
				return validateSlaughtered((Slaughtered)value, diagnostics, context);
			case TrackerPackage.DIED:
				return validateDied((Died)value, diagnostics, context);
			case TrackerPackage.TAG_RETIRED:
				return validateTagRetired((TagRetired)value, diagnostics, context);
			case TrackerPackage.ANIMAL_MISSING:
				return validateAnimalMissing((AnimalMissing)value, diagnostics, context);
			case TrackerPackage.ICVI:
				return validateICVI((ICVI)value, diagnostics, context);
			case TrackerPackage.WEIGH_IN:
				return validateWeighIn((WeighIn)value, diagnostics, context);
			case TrackerPackage.SWINE:
				return validateSwine((Swine)value, diagnostics, context);
			case TrackerPackage.EQUINE:
				return validateEquine((Equine)value, diagnostics, context);
			case TrackerPackage.CAPRINE:
				return validateCaprine((Caprine)value, diagnostics, context);
			case TrackerPackage.LOCATION:
				return validateLocation((Location)value, diagnostics, context);
			case TrackerPackage.MEDICAL_CONDITION:
				return validateMedicalCondition((MedicalCondition)value, diagnostics, context);
			case TrackerPackage.MEDICAL_TREATMENT:
				return validateMedicalTreatment((MedicalTreatment)value, diagnostics, context);
			case TrackerPackage.BIRTHING:
				return validateBirthing((Birthing)value, diagnostics, context);
			case TrackerPackage.CALVING:
				return validateCalving((Calving)value, diagnostics, context);
			case TrackerPackage.BIRTH_DEFECT:
				return validateBirthDefect((BirthDefect)value, diagnostics, context);
			case TrackerPackage.MASTITIS:
				return validateMastitis((Mastitis)value, diagnostics, context);
			case TrackerPackage.MILK_TEST:
				return validateMilkTest((MilkTest)value, diagnostics, context);
			case TrackerPackage.HERD_TEST:
				return validateHerdTest((HerdTest)value, diagnostics, context);
			case TrackerPackage.GENERIC_EVENT:
				return validateGenericEvent((GenericEvent)value, diagnostics, context);
			case TrackerPackage.EVENT_ATTRIBUTE:
				return validateEventAttribute((Map.Entry<?, ?>)value, diagnostics, context);
			case TrackerPackage.EVENT_SCHEMA:
				return validateEventSchema((EventSchema)value, diagnostics, context);
			case TrackerPackage.EVENT_ATTRIBUTE_SCHEMA:
				return validateEventAttributeSchema((EventAttributeSchema)value, diagnostics, context);
			case TrackerPackage.SCHEMA:
				return validateSchema((Schema)value, diagnostics, context);
			case TrackerPackage.US_BEEF_GRADING:
				return validateUSBeefGrading((USBeefGrading)value, diagnostics, context);
			case TrackerPackage.US_OVINE_GRADING:
				return validateUSOvineGrading((USOvineGrading)value, diagnostics, context);
			case TrackerPackage.US_SWINE_GRADING:
				return validateUSSwineGrading((USSwineGrading)value, diagnostics, context);
			case TrackerPackage.SEX:
				return validateSex((Sex)value, diagnostics, context);
			case TrackerPackage.BISON_BREED:
				return validateBisonBreed((BisonBreed)value, diagnostics, context);
			case TrackerPackage.SHEEP_BREED:
				return validateSheepBreed((SheepBreed)value, diagnostics, context);
			case TrackerPackage.BEEF_BREED:
				return validateBeefBreed((BeefBreed)value, diagnostics, context);
			case TrackerPackage.DAIRY_BREED:
				return validateDairyBreed((DairyBreed)value, diagnostics, context);
			case TrackerPackage.SWINE_BREED:
				return validateSwineBreed((SwineBreed)value, diagnostics, context);
			case TrackerPackage.HORSE_BREED:
				return validateHorseBreed((HorseBreed)value, diagnostics, context);
			case TrackerPackage.GOAT_BREED:
				return validateGoatBreed((GoatBreed)value, diagnostics, context);
			case TrackerPackage.TREATMENT:
				return validateTreatment((Treatment)value, diagnostics, context);
			case TrackerPackage.TREATMENT_METHOD:
				return validateTreatmentMethod((TreatmentMethod)value, diagnostics, context);
			case TrackerPackage.ONE_TO_TEN:
				return validateOneToTen((OneToTen)value, diagnostics, context);
			case TrackerPackage.ANIMAL_TYPE:
				return validateAnimalType((AnimalType)value, diagnostics, context);
			case TrackerPackage.EVENT_DATA_TYPE:
				return validateEventDataType((EventDataType)value, diagnostics, context);
			case TrackerPackage.US_QUALITY_GRADE:
				return validateUSQualityGrade((USQualityGrade)value, diagnostics, context);
			case TrackerPackage.US_BEEF_YIELD_GRADE:
				return validateUSBeefYieldGrade((USBeefYieldGrade)value, diagnostics, context);
			case TrackerPackage.LEVEL:
				return validateLevel((Level)value, diagnostics, context);
			case TrackerPackage.US_SWINE_QUALITY_GRADE:
				return validateUSSwineQualityGrade((USSwineQualityGrade)value, diagnostics, context);
			case TrackerPackage.PREMISES_ID_NUMBER:
				return validatePremisesIdNumber((String)value, diagnostics, context);
			case TrackerPackage.EMAIL:
				return validateEmail((String)value, diagnostics, context);
			case TrackerPackage.AGE:
				return validateAge((Age)value, diagnostics, context);
			case TrackerPackage.US_PHONE_NUMBER:
				return validateUSPhoneNumber((String)value, diagnostics, context);
			case TrackerPackage.URI:
				return validateURI((String)value, diagnostics, context);
			default: 
				return true;
		}
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
	public boolean validateTag(Tag tag, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tag, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBovine(Bovine bovine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bovine, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvent(Event event, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(event, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTagAllocated(TagAllocated tagAllocated, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tagAllocated, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDied(Died died, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(died, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTagRetired(TagRetired tagRetired, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tagRetired, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimalMissing(AnimalMissing animalMissing, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(animalMissing, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateICVI(ICVI icvi, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(icvi, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWeighIn(WeighIn weighIn, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(weighIn, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwine(Swine swine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(swine, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquine(Equine equine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(equine, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCaprine(Caprine caprine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(caprine, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocation(Location location, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(location, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMedicalCondition(MedicalCondition medicalCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(medicalCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMedicalTreatment(MedicalTreatment medicalTreatment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(medicalTreatment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBirthing(Birthing birthing, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(birthing, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCalving(Calving calving, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(calving, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBirthDefect(BirthDefect birthDefect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(birthDefect, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMastitis(Mastitis mastitis, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mastitis, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMilkTest(MilkTest milkTest, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(milkTest, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHerdTest(HerdTest herdTest, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(herdTest, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenericEvent(GenericEvent genericEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(genericEvent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventAttribute(Map.Entry<?, ?> eventAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eventAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventSchema(EventSchema eventSchema, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventSchema, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventAttributeSchema(EventAttributeSchema eventAttributeSchema, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventAttributeSchema, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchema(Schema schema, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(schema, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUSBeefGrading(USBeefGrading usBeefGrading, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(usBeefGrading, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUSOvineGrading(USOvineGrading usOvineGrading, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(usOvineGrading, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUSSwineGrading(USSwineGrading usSwineGrading, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(usSwineGrading, diagnostics, context);
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
	public boolean validateBovineBeef(BovineBeef bovineBeef, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bovineBeef, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOvine(Ovine ovine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ovine, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBovineBison(BovineBison bovineBison, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bovineBison, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBovineDairy(BovineDairy bovineDairy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bovineDairy, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTagApplied(TagApplied tagApplied, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tagApplied, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovedIn(MovedIn movedIn, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(movedIn, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovedOut(MovedOut movedOut, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(movedOut, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLostTag(LostTag lostTag, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(lostTag, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReplacedTag(ReplacedTag replacedTag, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(replacedTag, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImported(Imported imported, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(imported, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExported(Exported exported, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exported, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSighting(Sighting sighting, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sighting, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSlaughtered(Slaughtered slaughtered, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(slaughtered, diagnostics, context);
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
	public boolean validateBisonBreed(BisonBreed bisonBreed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSheepBreed(SheepBreed sheepBreed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBeefBreed(BeefBreed beefBreed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDairyBreed(DairyBreed dairyBreed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwineBreed(SwineBreed swineBreed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHorseBreed(HorseBreed horseBreed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoatBreed(GoatBreed goatBreed, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTreatment(Treatment treatment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTreatmentMethod(TreatmentMethod treatmentMethod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneToTen(OneToTen oneToTen, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimalType(AnimalType animalType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventDataType(EventDataType eventDataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUSQualityGrade(USQualityGrade usQualityGrade, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUSBeefYieldGrade(USBeefYieldGrade usBeefYieldGrade, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLevel(Level level, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUSSwineQualityGrade(USSwineQualityGrade usSwineQualityGrade, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePremisesIdNumber(String premisesIdNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePremisesIdNumber_MinLength(premisesIdNumber, diagnostics, context);
		if (result || diagnostics != null) result &= validatePremisesIdNumber_MaxLength(premisesIdNumber, diagnostics, context);
		if (result || diagnostics != null) result &= validatePremisesIdNumber_Max(premisesIdNumber, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MinLength constraint of '<em>Premises Id Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePremisesIdNumber_MinLength(String premisesIdNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = premisesIdNumber.length();  
		boolean result = length >= 7;
		if (!result && diagnostics != null) 
			reportMinLengthViolation(TrackerPackage.Literals.PREMISES_ID_NUMBER, premisesIdNumber, length, 7, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Premises Id Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePremisesIdNumber_MaxLength(String premisesIdNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = premisesIdNumber.length();  
		boolean result = length <= 7;
		if (!result && diagnostics != null) 
			reportMaxLengthViolation(TrackerPackage.Literals.PREMISES_ID_NUMBER, premisesIdNumber, length, 7, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePremisesIdNumber_Max
	 */
	public static final String PREMISES_ID_NUMBER__MAX__VALUE = "adcdefg";

	/**
	 * Validates the Max constraint of '<em>Premises Id Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePremisesIdNumber_Max(String premisesIdNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = premisesIdNumber.compareTo(PREMISES_ID_NUMBER__MAX__VALUE) < 0;
		if (!result && diagnostics != null) 
			reportMaxViolation(TrackerPackage.Literals.PREMISES_ID_NUMBER, premisesIdNumber, PREMISES_ID_NUMBER__MAX__VALUE, false, diagnostics, context);
		return result; 
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmail(String email, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAge(Age age, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUSPhoneNumber(String usPhoneNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateURI(String uri, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

} //TrackerValidator
