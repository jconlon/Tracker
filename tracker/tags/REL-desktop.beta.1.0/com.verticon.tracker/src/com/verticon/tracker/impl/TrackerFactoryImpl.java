/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.impl;

import com.verticon.tracker.*;
import static com.verticon.tracker.TrackerPlugin.bundleMarker;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.BeefBreed;
import com.verticon.tracker.BirthDefect;
import com.verticon.tracker.Birthing;
import com.verticon.tracker.BisonBreed;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.Calving;
import com.verticon.tracker.Caprine;
import com.verticon.tracker.DairyBreed;
import com.verticon.tracker.Died;
import com.verticon.tracker.Equine;
import com.verticon.tracker.EventDataType;
import com.verticon.tracker.EventInclusion;
import com.verticon.tracker.EventType;
import com.verticon.tracker.Exported;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.GenericEventInclusion;
import com.verticon.tracker.GoatBreed;
import com.verticon.tracker.HerdTest;
import com.verticon.tracker.HorseBreed;
import com.verticon.tracker.ICVI;
import com.verticon.tracker.Imported;
import com.verticon.tracker.Level;
import com.verticon.tracker.LostTag;
import com.verticon.tracker.Mastitis;
import com.verticon.tracker.MedicalCondition;
import com.verticon.tracker.MedicalTreatment;
import com.verticon.tracker.MilkTest;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.OneToTen;
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Policy;
import com.verticon.tracker.Position;
import com.verticon.tracker.Premises;
import com.verticon.tracker.ReplacedTag;
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
import com.verticon.tracker.TrackerFactory;
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
import com.verticon.tracker.WeightMeasurementUnit;
import com.verticon.tracker.util.Age;
import com.verticon.tracker.util.CheckEmail;
import com.verticon.tracker.util.CheckISO7064Mod37_36;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrackerFactoryImpl extends EFactoryImpl implements TrackerFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * Added tracker specific Logging versus ECorePlugIn
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static TrackerFactory init() {
		try {
			TrackerFactory theTrackerFactory = (TrackerFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.verticon.com/tracker/0.4.2/premises"); 
			if (theTrackerFactory != null) {
				return theTrackerFactory;
			}
		}
		catch (Exception exception) {
			
			/**
			 * slf4j Logger
			 */
			Logger logger = LoggerFactory
					.getLogger(TrackerFactoryImpl.class);
			
			logger.error(bundleMarker,"Failed to initialize TrackerFactory",exception);
		}
		return new TrackerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerFactoryImpl() {
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
			case TrackerPackage.TAG: return createTag();
			case TrackerPackage.TAG_ALLOCATED: return createTagAllocated();
			case TrackerPackage.PREMISES: return createPremises();
			case TrackerPackage.BOVINE_BEEF: return createBovineBeef();
			case TrackerPackage.OVINE: return createOvine();
			case TrackerPackage.BOVINE_BISON: return createBovineBison();
			case TrackerPackage.BOVINE_DAIRY: return createBovineDairy();
			case TrackerPackage.TAG_APPLIED: return createTagApplied();
			case TrackerPackage.MOVED_IN: return createMovedIn();
			case TrackerPackage.MOVED_OUT: return createMovedOut();
			case TrackerPackage.LOST_TAG: return createLostTag();
			case TrackerPackage.REPLACED_TAG: return createReplacedTag();
			case TrackerPackage.IMPORTED: return createImported();
			case TrackerPackage.EXPORTED: return createExported();
			case TrackerPackage.SIGHTING: return createSighting();
			case TrackerPackage.SLAUGHTERED: return createSlaughtered();
			case TrackerPackage.DIED: return createDied();
			case TrackerPackage.TAG_RETIRED: return createTagRetired();
			case TrackerPackage.ANIMAL_MISSING: return createAnimalMissing();
			case TrackerPackage.ICVI: return createICVI();
			case TrackerPackage.WEIGH_IN: return createWeighIn();
			case TrackerPackage.SWINE: return createSwine();
			case TrackerPackage.EQUINE: return createEquine();
			case TrackerPackage.CAPRINE: return createCaprine();
			case TrackerPackage.MEDICAL_CONDITION: return createMedicalCondition();
			case TrackerPackage.MEDICAL_TREATMENT: return createMedicalTreatment();
			case TrackerPackage.BIRTHING: return createBirthing();
			case TrackerPackage.CALVING: return createCalving();
			case TrackerPackage.BIRTH_DEFECT: return createBirthDefect();
			case TrackerPackage.MASTITIS: return createMastitis();
			case TrackerPackage.MILK_TEST: return createMilkTest();
			case TrackerPackage.HERD_TEST: return createHerdTest();
			case TrackerPackage.GENERIC_EVENT: return createGenericEvent();
			case TrackerPackage.STRING_TO_STRING_MAP: return (EObject)createStringToStringMap();
			case TrackerPackage.US_BEEF_GRADING: return createUSBeefGrading();
			case TrackerPackage.US_OVINE_GRADING: return createUSOvineGrading();
			case TrackerPackage.US_SWINE_GRADING: return createUSSwineGrading();
			case TrackerPackage.POLICY: return createPolicy();
			case TrackerPackage.EVENT_INCLUSION: return createEventInclusion();
			case TrackerPackage.GENERIC_EVENT_INCLUSION: return createGenericEventInclusion();
			case TrackerPackage.POSITION: return createPosition();
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
			case TrackerPackage.SEX:
				return createSexFromString(eDataType, initialValue);
			case TrackerPackage.BISON_BREED:
				return createBisonBreedFromString(eDataType, initialValue);
			case TrackerPackage.SHEEP_BREED:
				return createSheepBreedFromString(eDataType, initialValue);
			case TrackerPackage.BEEF_BREED:
				return createBeefBreedFromString(eDataType, initialValue);
			case TrackerPackage.DAIRY_BREED:
				return createDairyBreedFromString(eDataType, initialValue);
			case TrackerPackage.SWINE_BREED:
				return createSwineBreedFromString(eDataType, initialValue);
			case TrackerPackage.HORSE_BREED:
				return createHorseBreedFromString(eDataType, initialValue);
			case TrackerPackage.GOAT_BREED:
				return createGoatBreedFromString(eDataType, initialValue);
			case TrackerPackage.TREATMENT:
				return createTreatmentFromString(eDataType, initialValue);
			case TrackerPackage.TREATMENT_METHOD:
				return createTreatmentMethodFromString(eDataType, initialValue);
			case TrackerPackage.ONE_TO_TEN:
				return createOneToTenFromString(eDataType, initialValue);
			case TrackerPackage.ANIMAL_TYPE:
				return createAnimalTypeFromString(eDataType, initialValue);
			case TrackerPackage.EVENT_DATA_TYPE:
				return createEventDataTypeFromString(eDataType, initialValue);
			case TrackerPackage.US_QUALITY_GRADE:
				return createUSQualityGradeFromString(eDataType, initialValue);
			case TrackerPackage.US_BEEF_YIELD_GRADE:
				return createUSBeefYieldGradeFromString(eDataType, initialValue);
			case TrackerPackage.LEVEL:
				return createLevelFromString(eDataType, initialValue);
			case TrackerPackage.US_SWINE_QUALITY_GRADE:
				return createUSSwineQualityGradeFromString(eDataType, initialValue);
			case TrackerPackage.WEIGHT_MEASUREMENT_UNIT:
				return createWeightMeasurementUnitFromString(eDataType, initialValue);
			case TrackerPackage.EVENT_TYPE:
				return createEventTypeFromString(eDataType, initialValue);
			case TrackerPackage.PREMISES_ID_NUMBER:
				return createPremisesIdNumberFromString(eDataType, initialValue);
			case TrackerPackage.EMAIL:
				return createEmailFromString(eDataType, initialValue);
			case TrackerPackage.AGE:
				return createAgeFromString(eDataType, initialValue);
			case TrackerPackage.US_PHONE_NUMBER:
				return createUSPhoneNumberFromString(eDataType, initialValue);
			case TrackerPackage.URI:
				return createURIFromString(eDataType, initialValue);
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
			case TrackerPackage.SEX:
				return convertSexToString(eDataType, instanceValue);
			case TrackerPackage.BISON_BREED:
				return convertBisonBreedToString(eDataType, instanceValue);
			case TrackerPackage.SHEEP_BREED:
				return convertSheepBreedToString(eDataType, instanceValue);
			case TrackerPackage.BEEF_BREED:
				return convertBeefBreedToString(eDataType, instanceValue);
			case TrackerPackage.DAIRY_BREED:
				return convertDairyBreedToString(eDataType, instanceValue);
			case TrackerPackage.SWINE_BREED:
				return convertSwineBreedToString(eDataType, instanceValue);
			case TrackerPackage.HORSE_BREED:
				return convertHorseBreedToString(eDataType, instanceValue);
			case TrackerPackage.GOAT_BREED:
				return convertGoatBreedToString(eDataType, instanceValue);
			case TrackerPackage.TREATMENT:
				return convertTreatmentToString(eDataType, instanceValue);
			case TrackerPackage.TREATMENT_METHOD:
				return convertTreatmentMethodToString(eDataType, instanceValue);
			case TrackerPackage.ONE_TO_TEN:
				return convertOneToTenToString(eDataType, instanceValue);
			case TrackerPackage.ANIMAL_TYPE:
				return convertAnimalTypeToString(eDataType, instanceValue);
			case TrackerPackage.EVENT_DATA_TYPE:
				return convertEventDataTypeToString(eDataType, instanceValue);
			case TrackerPackage.US_QUALITY_GRADE:
				return convertUSQualityGradeToString(eDataType, instanceValue);
			case TrackerPackage.US_BEEF_YIELD_GRADE:
				return convertUSBeefYieldGradeToString(eDataType, instanceValue);
			case TrackerPackage.LEVEL:
				return convertLevelToString(eDataType, instanceValue);
			case TrackerPackage.US_SWINE_QUALITY_GRADE:
				return convertUSSwineQualityGradeToString(eDataType, instanceValue);
			case TrackerPackage.WEIGHT_MEASUREMENT_UNIT:
				return convertWeightMeasurementUnitToString(eDataType, instanceValue);
			case TrackerPackage.EVENT_TYPE:
				return convertEventTypeToString(eDataType, instanceValue);
			case TrackerPackage.PREMISES_ID_NUMBER:
				return convertPremisesIdNumberToString(eDataType, instanceValue);
			case TrackerPackage.EMAIL:
				return convertEmailToString(eDataType, instanceValue);
			case TrackerPackage.AGE:
				return convertAgeToString(eDataType, instanceValue);
			case TrackerPackage.US_PHONE_NUMBER:
				return convertUSPhoneNumberToString(eDataType, instanceValue);
			case TrackerPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag createTag() {
		TagImpl tag = new TagImpl();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagAllocated createTagAllocated() {
		TagAllocatedImpl tagAllocated = new TagAllocatedImpl();
		return tagAllocated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Died createDied() {
		DiedImpl died = new DiedImpl();
		return died;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagRetired createTagRetired() {
		TagRetiredImpl tagRetired = new TagRetiredImpl();
		return tagRetired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalMissing createAnimalMissing() {
		AnimalMissingImpl animalMissing = new AnimalMissingImpl();
		return animalMissing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICVI createICVI() {
		ICVIImpl icvi = new ICVIImpl();
		return icvi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeighIn createWeighIn() {
		WeighInImpl weighIn = new WeighInImpl();
		return weighIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Swine createSwine() {
		SwineImpl swine = new SwineImpl();
		return swine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equine createEquine() {
		EquineImpl equine = new EquineImpl();
		return equine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Caprine createCaprine() {
		CaprineImpl caprine = new CaprineImpl();
		return caprine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MedicalCondition createMedicalCondition() {
		MedicalConditionImpl medicalCondition = new MedicalConditionImpl();
		return medicalCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MedicalTreatment createMedicalTreatment() {
		MedicalTreatmentImpl medicalTreatment = new MedicalTreatmentImpl();
		return medicalTreatment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Birthing createBirthing() {
		BirthingImpl birthing = new BirthingImpl();
		return birthing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Calving createCalving() {
		CalvingImpl calving = new CalvingImpl();
		return calving;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BirthDefect createBirthDefect() {
		BirthDefectImpl birthDefect = new BirthDefectImpl();
		return birthDefect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mastitis createMastitis() {
		MastitisImpl mastitis = new MastitisImpl();
		return mastitis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkTest createMilkTest() {
		MilkTestImpl milkTest = new MilkTestImpl();
		return milkTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HerdTest createHerdTest() {
		HerdTestImpl herdTest = new HerdTestImpl();
		return herdTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericEvent createGenericEvent() {
		GenericEventImpl genericEvent = new GenericEventImpl();
		return genericEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createStringToStringMap() {
		StringToStringMapImpl stringToStringMap = new StringToStringMapImpl();
		return stringToStringMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USBeefGrading createUSBeefGrading() {
		USBeefGradingImpl usBeefGrading = new USBeefGradingImpl();
		return usBeefGrading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USOvineGrading createUSOvineGrading() {
		USOvineGradingImpl usOvineGrading = new USOvineGradingImpl();
		return usOvineGrading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USSwineGrading createUSSwineGrading() {
		USSwineGradingImpl usSwineGrading = new USSwineGradingImpl();
		return usSwineGrading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Policy createPolicy() {
		PolicyImpl policy = new PolicyImpl();
		return policy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventInclusion createEventInclusion() {
		EventInclusionImpl eventInclusion = new EventInclusionImpl();
		return eventInclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericEventInclusion createGenericEventInclusion() {
		GenericEventInclusionImpl genericEventInclusion = new GenericEventInclusionImpl();
		return genericEventInclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Position createPosition() {
		PositionImpl position = new PositionImpl();
		return position;
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
	public BovineBeef createBovineBeef() {
		BovineBeefImpl bovineBeef = new BovineBeefImpl();
		return bovineBeef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ovine createOvine() {
		OvineImpl ovine = new OvineImpl();
		return ovine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BovineBison createBovineBison() {
		BovineBisonImpl bovineBison = new BovineBisonImpl();
		return bovineBison;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BovineDairy createBovineDairy() {
		BovineDairyImpl bovineDairy = new BovineDairyImpl();
		return bovineDairy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagApplied createTagApplied() {
		TagAppliedImpl tagApplied = new TagAppliedImpl();
		return tagApplied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovedIn createMovedIn() {
		MovedInImpl movedIn = new MovedInImpl();
		return movedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovedOut createMovedOut() {
		MovedOutImpl movedOut = new MovedOutImpl();
		return movedOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LostTag createLostTag() {
		LostTagImpl lostTag = new LostTagImpl();
		return lostTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacedTag createReplacedTag() {
		ReplacedTagImpl replacedTag = new ReplacedTagImpl();
		return replacedTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Imported createImported() {
		ImportedImpl imported = new ImportedImpl();
		return imported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exported createExported() {
		ExportedImpl exported = new ExportedImpl();
		return exported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sighting createSighting() {
		SightingImpl sighting = new SightingImpl();
		return sighting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slaughtered createSlaughtered() {
		SlaughteredImpl slaughtered = new SlaughteredImpl();
		return slaughtered;
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
	public BisonBreed createBisonBreedFromString(EDataType eDataType, String initialValue) {
		BisonBreed result = BisonBreed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBisonBreedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SheepBreed createSheepBreedFromString(EDataType eDataType, String initialValue) {
		SheepBreed result = SheepBreed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSheepBreedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeefBreed createBeefBreedFromString(EDataType eDataType, String initialValue) {
		BeefBreed result = BeefBreed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBeefBreedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyBreed createDairyBreedFromString(EDataType eDataType, String initialValue) {
		DairyBreed result = DairyBreed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDairyBreedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwineBreed createSwineBreedFromString(EDataType eDataType, String initialValue) {
		SwineBreed result = SwineBreed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSwineBreedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HorseBreed createHorseBreedFromString(EDataType eDataType, String initialValue) {
		HorseBreed result = HorseBreed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHorseBreedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoatBreed createGoatBreedFromString(EDataType eDataType, String initialValue) {
		GoatBreed result = GoatBreed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGoatBreedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Treatment createTreatmentFromString(EDataType eDataType, String initialValue) {
		Treatment result = Treatment.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTreatmentToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreatmentMethod createTreatmentMethodFromString(EDataType eDataType, String initialValue) {
		TreatmentMethod result = TreatmentMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTreatmentMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OneToTen createOneToTenFromString(EDataType eDataType, String initialValue) {
		OneToTen result = OneToTen.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOneToTenToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalType createAnimalTypeFromString(EDataType eDataType, String initialValue) {
		AnimalType result = AnimalType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAnimalTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDataType createEventDataTypeFromString(EDataType eDataType, String initialValue) {
		EventDataType result = EventDataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USQualityGrade createUSQualityGradeFromString(EDataType eDataType, String initialValue) {
		USQualityGrade result = USQualityGrade.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUSQualityGradeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USBeefYieldGrade createUSBeefYieldGradeFromString(EDataType eDataType, String initialValue) {
		USBeefYieldGrade result = USBeefYieldGrade.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUSBeefYieldGradeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level createLevelFromString(EDataType eDataType, String initialValue) {
		Level result = Level.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public USSwineQualityGrade createUSSwineQualityGradeFromString(EDataType eDataType, String initialValue) {
		USSwineQualityGrade result = USSwineQualityGrade.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUSSwineQualityGradeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeightMeasurementUnit createWeightMeasurementUnitFromString(EDataType eDataType, String initialValue) {
		WeightMeasurementUnit result = WeightMeasurementUnit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWeightMeasurementUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType createEventTypeFromString(EDataType eDataType, String initialValue) {
		EventType result = EventType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * 7-digit code that includes both letters and numbers.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String createPremisesIdNumberFromString(EDataType eDataType, String initialValue) {
		if(initialValue == null) {
			return null;
		}
		if(initialValue.length()!=7){
			throw new IllegalArgumentException("Premises Id must contain 7 digits: " + initialValue+
					", to delete enter 7 spaces.");
		}
		
		try {
			if(CheckISO7064Mod37_36.verify(initialValue)){
				return initialValue;
			}
		} catch (NumberFormatException e) {
			return null;
		}
		throw new IllegalArgumentException(initialValue+" is a not legal Premises Id. To delete enter 7 spaces.");
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertPremisesIdNumberToString(EDataType eDataType, Object instanceValue) {
		return (String) instanceValue;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String createEmailFromString(EDataType eDataType, String initialValue) {
		/*
		if(initialValue == null) {
			return null;
		}
		if(initialValue.length()!=7){
			throw new IllegalArgumentException("Premises Id must contain 7 digits: " + initialValue+
					", to delete enter 7 spaces.");
		}
		
		try {
			if(CheckISO7064Mod37_36.verify(initialValue)){
				return initialValue;
			}
		} catch (NumberFormatException e) {
			return null;
		}
		throw new IllegalArgumentException(initialValue+" is a not legal Premises Id. To delete enter 7 spaces.");
		
		
		
		*/
		if(initialValue == null) {
			return null;
		}
		
		if(CheckEmail.validate(initialValue)){
			return initialValue;
		}
		if(initialValue.trim().length()<1){
			return null;
		}
		throw new IllegalArgumentException(initialValue+" is not a legal Email Contact");
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEmailToString(EDataType eDataType, Object instanceValue) {
		return (String) instanceValue;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Age createAgeFromString(EDataType eDataType, String initialValue) {
		if(initialValue==null || initialValue.length()<8){
			return new Age(new Date());
		}
		//Try to build based on string output of Age
		//928 days old
		int space = initialValue.indexOf(' ');
		if(space!=-1){
			
			try {
				String daz = initialValue.substring(0,space);
				
				int days = Integer.parseInt(daz);
				
				Calendar someBirthday = Calendar.getInstance();
				someBirthday.add(Calendar.DATE, -days);
				
				Date date = someBirthday.getTime();
				return new Age(date);

			}

			catch (Exception ex) {
				//ignore
			}
		}
		return new Age(new Date());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertAgeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Validation code added.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String createUSPhoneNumberFromString(EDataType eDataType, String initialValue) {
		if(initialValue!=null && initialValue.trim().length()>0 && !isPhoneNumberValid(initialValue)){
			throw new IllegalArgumentException(initialValue+" is not a legal US Phone Number");
		}
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUSPhoneNumberToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String createURIFromString(EDataType eDataType, String initialValue) {
		if(initialValue == null) return null;
		try {
			URI.create(initialValue);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getCause());
		}

		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return (String) instanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerPackage getTrackerPackage() {
		return (TrackerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TrackerPackage getPackage() {
		return TrackerPackage.eINSTANCE;
	}
	
	/** isPhoneNumberValid: Validate phone number using Java reg ex.
	 * This method checks if the input string is a valid phone number.
	 * @param phoneNumber String. Phone number to validate
	 * @return boolean: true if phone number is valid, false otherwise.
	 */
	public static boolean isPhoneNumberValid(String phoneNumber){
		boolean isValid = false;
		/* Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn
		^\\(? : May start with an option "(" .
		(\\d{3}): Followed by 3 digits.
		\\)? : May have an optional ")"
		[- ]? : May have an optional "-" after the first 3 digits or after optional ) character.
		(\\d{3}) : Followed by 3 digits.
		 [- ]? : May have another optional "-" after numeric digits.
		 (\\d{4})$ : ends with four digits.

	         Examples: Matches following phone numbers:
	         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890

		 */
		//Initialize reg ex for phone number. 
		String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		CharSequence inputStr = phoneNumber;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if(matcher.matches()){
			isValid = true;
		}
		return isValid;
	}


} //TrackerFactoryImpl
