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

import com.verticon.location.LocationPackage;
import com.verticon.location.impl.LocationPackageImpl;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.impl.MetatypePackageImpl;
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
import com.verticon.tracker.EventDataType;
import com.verticon.tracker.EventInclusion;
import com.verticon.tracker.EventType;
import com.verticon.tracker.Exported;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.GenericEventInclusion;
import com.verticon.tracker.GoatBreed;
import com.verticon.tracker.HerdTest;
import com.verticon.tracker.HorseBreed;
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
import com.verticon.tracker.util.TrackerValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrackerPackageImpl extends EPackageImpl implements TrackerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bovineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagAllocatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagRetiredEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animalMissingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass icviEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass weighInEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caprineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass medicalConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass medicalTreatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass birthingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calvingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass birthDefectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mastitisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass milkTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass herdTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToStringMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usBeefGradingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usOvineGradingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usSwineGradingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass policyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventInclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericEventInclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premisesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bovineBeefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ovineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bovineBisonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bovineDairyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagAppliedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movedInEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movedOutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lostTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacedTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sightingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slaughteredEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sexEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bisonBreedEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sheepBreedEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum beefBreedEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dairyBreedEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum swineBreedEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum horseBreedEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum goatBreedEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum treatmentEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum treatmentMethodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum oneToTenEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum animalTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eventDataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum usQualityGradeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum usBeefYieldGradeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum levelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum usSwineQualityGradeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum weightMeasurementUnitEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eventTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType premisesIdNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType emailEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType usPhoneNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.verticon.tracker.TrackerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TrackerPackageImpl() {
		super(eNS_URI, TrackerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TrackerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TrackerPackage init() {
		if (isInited) return (TrackerPackage)EPackage.Registry.INSTANCE.getEPackage(TrackerPackage.eNS_URI);

		// Obtain or create and register package
		TrackerPackageImpl theTrackerPackage = (TrackerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TrackerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TrackerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		MetatypePackageImpl theMetatypePackage = (MetatypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetatypePackage.eNS_URI) instanceof MetatypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetatypePackage.eNS_URI) : MetatypePackage.eINSTANCE);
		LocationPackageImpl theLocationPackage = (LocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LocationPackage.eNS_URI) instanceof LocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LocationPackage.eNS_URI) : LocationPackage.eINSTANCE);

		// Create package meta-data objects
		theTrackerPackage.createPackageContents();
		theMetatypePackage.createPackageContents();
		theLocationPackage.createPackageContents();

		// Initialize created meta-data
		theTrackerPackage.initializePackageContents();
		theMetatypePackage.initializePackageContents();
		theLocationPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theTrackerPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return TrackerValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theTrackerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TrackerPackage.eNS_URI, theTrackerPackage);
		return theTrackerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimal() {
		return animalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_BirthDate() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Sex() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimal_Tags() {
		return (EReference)animalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Species() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Breed() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_SexCode() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_SpeciesCode() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Id() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Comments() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_LastEventDateTime() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimal_Dam() {
		return (EReference)animalEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimal_Sire() {
		return (EReference)animalEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Weight() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_WeightGainPerDay() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Type() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_VisualID() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_AgeInDays() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_AlternativeID() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Location() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTag() {
		return tagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_UsainNumberUsed() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTag_Events() {
		return (EReference)tagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Id() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTag_Animal() {
		return (EReference)tagEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBovine() {
		return bovineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_DateTime() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_EventCode() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_ElectronicallyRead() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Correction() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Comments() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Tag() {
		return (EReference)eventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Id() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Date() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_DateKey() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Pid() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagAllocated() {
		return tagAllocatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDied() {
		return diedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagRetired() {
		return tagRetiredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimalMissing() {
		return animalMissingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICVI() {
		return icviEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWeighIn() {
		return weighInEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWeighIn_Weight() {
		return (EAttribute)weighInEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWeighIn_WeightGainPerDay() {
		return (EAttribute)weighInEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWeighIn_Unit() {
		return (EAttribute)weighInEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwine() {
		return swineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwine_SwineBreed() {
		return (EAttribute)swineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwine_RightEarNotching() {
		return (EAttribute)swineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwine_LeftEarNotching() {
		return (EAttribute)swineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquine() {
		return equineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquine_HorseBreed() {
		return (EAttribute)equineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaprine() {
		return caprineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCaprine_GoatBreed() {
		return (EAttribute)caprineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMedicalCondition() {
		return medicalConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMedicalTreatment() {
		return medicalTreatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedicalTreatment_Name() {
		return (EAttribute)medicalTreatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedicalTreatment_Product() {
		return (EAttribute)medicalTreatmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedicalTreatment_Manufacturer() {
		return (EAttribute)medicalTreatmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedicalTreatment_Lot() {
		return (EAttribute)medicalTreatmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedicalTreatment_Quantity() {
		return (EAttribute)medicalTreatmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedicalTreatment_Treatment() {
		return (EAttribute)medicalTreatmentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedicalTreatment_Method() {
		return (EAttribute)medicalTreatmentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBirthing() {
		return birthingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBirthing_Viability() {
		return (EAttribute)birthingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBirthing_Assisted() {
		return (EAttribute)birthingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBirthing_Difficulty() {
		return (EAttribute)birthingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalving() {
		return calvingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBirthDefect() {
		return birthDefectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBirthDefect_Freemartin() {
		return (EAttribute)birthDefectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMastitis() {
		return mastitisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMastitis_Location() {
		return (EAttribute)mastitisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMastitis_Origin() {
		return (EAttribute)mastitisEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMilkTest() {
		return milkTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkTest_PoundsProduced() {
		return (EAttribute)milkTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkTest_PercentButterFat() {
		return (EAttribute)milkTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkTest_PercentProtein() {
		return (EAttribute)milkTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkTest_SomaticCellCounts() {
		return (EAttribute)milkTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkTest_OtherSolids() {
		return (EAttribute)milkTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHerdTest() {
		return herdTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHerdTest_Pregnant() {
		return (EAttribute)herdTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHerdTest_DaysSinceBredEstimate() {
		return (EAttribute)herdTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHerdTest_BredDateEstimate() {
		return (EAttribute)herdTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericEvent() {
		return genericEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericEvent_EventAttributes() {
		return (EReference)genericEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericEvent_Ocd() {
		return (EReference)genericEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToStringMap() {
		return stringToStringMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToStringMap_Key() {
		return (EAttribute)stringToStringMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToStringMap_Value() {
		return (EAttribute)stringToStringMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUSBeefGrading() {
		return usBeefGradingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUSBeefGrading_QualityGrade() {
		return (EAttribute)usBeefGradingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUSBeefGrading_QualityGradeLevel() {
		return (EAttribute)usBeefGradingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUSBeefGrading_YieldGrade() {
		return (EAttribute)usBeefGradingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUSOvineGrading() {
		return usOvineGradingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUSOvineGrading_QualityGrade() {
		return (EAttribute)usOvineGradingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUSOvineGrading_QualityGradeLevel() {
		return (EAttribute)usOvineGradingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUSSwineGrading() {
		return usSwineGradingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUSSwineGrading_QualityGrade() {
		return (EAttribute)usSwineGradingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolicy() {
		return policyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicy_IncludedSpecies() {
		return (EAttribute)policyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicy_IncludedEvents() {
		return (EReference)policyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicy_IncludedGenericEvents() {
		return (EReference)policyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicy_ExcludeUnspecifiedEvents() {
		return (EAttribute)policyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventInclusion() {
		return eventInclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventInclusion_Species() {
		return (EAttribute)eventInclusionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventInclusion_Event() {
		return (EAttribute)eventInclusionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericEventInclusion() {
		return genericEventInclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericEventInclusion_Species() {
		return (EAttribute)genericEventInclusionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenericEventInclusion_Ocd() {
		return (EReference)genericEventInclusionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPosition() {
		return positionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPosition_Longitude() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPosition_Latitude() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPosition_Coordinates() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremises() {
		return premisesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_PremisesId() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_EmailContact() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremises_Animals() {
		return (EReference)premisesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremises_UnAppliedTags() {
		return (EReference)premisesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_Uri() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_Name() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_Description() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_PhoneNumber() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_Address() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremises_Location() {
		return (EReference)premisesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremises_Policy() {
		return (EReference)premisesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_Administrator() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBovineBeef() {
		return bovineBeefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBovineBeef_BeefBreed() {
		return (EAttribute)bovineBeefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOvine() {
		return ovineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOvine_SheepBreed() {
		return (EAttribute)ovineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOvine_ScrapieTag() {
		return (EAttribute)ovineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBovineBison() {
		return bovineBisonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBovineBison_BuffaloBreed() {
		return (EAttribute)bovineBisonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBovineDairy() {
		return bovineDairyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBovineDairy_DairyBreed() {
		return (EAttribute)bovineDairyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagApplied() {
		return tagAppliedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovedIn() {
		return movedInEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovedIn_SourcePin() {
		return (EAttribute)movedInEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovedIn_Uri() {
		return (EAttribute)movedInEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovedOut() {
		return movedOutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovedOut_DestinationPin() {
		return (EAttribute)movedOutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovedOut_Uri() {
		return (EAttribute)movedOutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLostTag() {
		return lostTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacedTag() {
		return replacedTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReplacedTag_OldId() {
		return (EAttribute)replacedTagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReplacedTag_UsainNumberUsedForOldId() {
		return (EAttribute)replacedTagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplacedTag_OldTag() {
		return (EReference)replacedTagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImported() {
		return importedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExported() {
		return exportedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSighting() {
		return sightingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSighting_Location() {
		return (EAttribute)sightingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlaughtered() {
		return slaughteredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSex() {
		return sexEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBisonBreed() {
		return bisonBreedEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSheepBreed() {
		return sheepBreedEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBeefBreed() {
		return beefBreedEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDairyBreed() {
		return dairyBreedEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSwineBreed() {
		return swineBreedEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHorseBreed() {
		return horseBreedEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGoatBreed() {
		return goatBreedEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTreatment() {
		return treatmentEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTreatmentMethod() {
		return treatmentMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOneToTen() {
		return oneToTenEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAnimalType() {
		return animalTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEventDataType() {
		return eventDataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUSQualityGrade() {
		return usQualityGradeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUSBeefYieldGrade() {
		return usBeefYieldGradeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLevel() {
		return levelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUSSwineQualityGrade() {
		return usSwineQualityGradeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWeightMeasurementUnit() {
		return weightMeasurementUnitEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEventType() {
		return eventTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPremisesIdNumber() {
		return premisesIdNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEmail() {
		return emailEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAge() {
		return ageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUSPhoneNumber() {
		return usPhoneNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerFactory getTrackerFactory() {
		return (TrackerFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		animalEClass = createEClass(ANIMAL);
		createEAttribute(animalEClass, ANIMAL__BIRTH_DATE);
		createEAttribute(animalEClass, ANIMAL__SEX);
		createEReference(animalEClass, ANIMAL__TAGS);
		createEAttribute(animalEClass, ANIMAL__SPECIES);
		createEAttribute(animalEClass, ANIMAL__BREED);
		createEAttribute(animalEClass, ANIMAL__SEX_CODE);
		createEAttribute(animalEClass, ANIMAL__SPECIES_CODE);
		createEAttribute(animalEClass, ANIMAL__ID);
		createEAttribute(animalEClass, ANIMAL__COMMENTS);
		createEAttribute(animalEClass, ANIMAL__LAST_EVENT_DATE_TIME);
		createEReference(animalEClass, ANIMAL__DAM);
		createEReference(animalEClass, ANIMAL__SIRE);
		createEAttribute(animalEClass, ANIMAL__WEIGHT);
		createEAttribute(animalEClass, ANIMAL__WEIGHT_GAIN_PER_DAY);
		createEAttribute(animalEClass, ANIMAL__TYPE);
		createEAttribute(animalEClass, ANIMAL__VISUAL_ID);
		createEAttribute(animalEClass, ANIMAL__AGE_IN_DAYS);
		createEAttribute(animalEClass, ANIMAL__ALTERNATIVE_ID);
		createEAttribute(animalEClass, ANIMAL__LOCATION);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__USAIN_NUMBER_USED);
		createEReference(tagEClass, TAG__EVENTS);
		createEAttribute(tagEClass, TAG__ID);
		createEReference(tagEClass, TAG__ANIMAL);

		bovineEClass = createEClass(BOVINE);

		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__DATE_TIME);
		createEAttribute(eventEClass, EVENT__EVENT_CODE);
		createEAttribute(eventEClass, EVENT__ELECTRONICALLY_READ);
		createEAttribute(eventEClass, EVENT__CORRECTION);
		createEAttribute(eventEClass, EVENT__COMMENTS);
		createEReference(eventEClass, EVENT__TAG);
		createEAttribute(eventEClass, EVENT__ID);
		createEAttribute(eventEClass, EVENT__DATE);
		createEAttribute(eventEClass, EVENT__DATE_KEY);
		createEAttribute(eventEClass, EVENT__PID);

		tagAllocatedEClass = createEClass(TAG_ALLOCATED);

		premisesEClass = createEClass(PREMISES);
		createEAttribute(premisesEClass, PREMISES__PREMISES_ID);
		createEAttribute(premisesEClass, PREMISES__EMAIL_CONTACT);
		createEReference(premisesEClass, PREMISES__ANIMALS);
		createEReference(premisesEClass, PREMISES__UN_APPLIED_TAGS);
		createEAttribute(premisesEClass, PREMISES__URI);
		createEReference(premisesEClass, PREMISES__POLICY);
		createEAttribute(premisesEClass, PREMISES__ADMINISTRATOR);
		createEAttribute(premisesEClass, PREMISES__NAME);
		createEAttribute(premisesEClass, PREMISES__DESCRIPTION);
		createEAttribute(premisesEClass, PREMISES__PHONE_NUMBER);
		createEAttribute(premisesEClass, PREMISES__ADDRESS);
		createEReference(premisesEClass, PREMISES__LOCATION);

		bovineBeefEClass = createEClass(BOVINE_BEEF);
		createEAttribute(bovineBeefEClass, BOVINE_BEEF__BEEF_BREED);

		ovineEClass = createEClass(OVINE);
		createEAttribute(ovineEClass, OVINE__SHEEP_BREED);
		createEAttribute(ovineEClass, OVINE__SCRAPIE_TAG);

		bovineBisonEClass = createEClass(BOVINE_BISON);
		createEAttribute(bovineBisonEClass, BOVINE_BISON__BUFFALO_BREED);

		bovineDairyEClass = createEClass(BOVINE_DAIRY);
		createEAttribute(bovineDairyEClass, BOVINE_DAIRY__DAIRY_BREED);

		tagAppliedEClass = createEClass(TAG_APPLIED);

		movedInEClass = createEClass(MOVED_IN);
		createEAttribute(movedInEClass, MOVED_IN__SOURCE_PIN);
		createEAttribute(movedInEClass, MOVED_IN__URI);

		movedOutEClass = createEClass(MOVED_OUT);
		createEAttribute(movedOutEClass, MOVED_OUT__DESTINATION_PIN);
		createEAttribute(movedOutEClass, MOVED_OUT__URI);

		lostTagEClass = createEClass(LOST_TAG);

		replacedTagEClass = createEClass(REPLACED_TAG);
		createEAttribute(replacedTagEClass, REPLACED_TAG__OLD_ID);
		createEAttribute(replacedTagEClass, REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID);
		createEReference(replacedTagEClass, REPLACED_TAG__OLD_TAG);

		importedEClass = createEClass(IMPORTED);

		exportedEClass = createEClass(EXPORTED);

		sightingEClass = createEClass(SIGHTING);
		createEAttribute(sightingEClass, SIGHTING__LOCATION);

		slaughteredEClass = createEClass(SLAUGHTERED);

		diedEClass = createEClass(DIED);

		tagRetiredEClass = createEClass(TAG_RETIRED);

		animalMissingEClass = createEClass(ANIMAL_MISSING);

		icviEClass = createEClass(ICVI);

		weighInEClass = createEClass(WEIGH_IN);
		createEAttribute(weighInEClass, WEIGH_IN__WEIGHT);
		createEAttribute(weighInEClass, WEIGH_IN__WEIGHT_GAIN_PER_DAY);
		createEAttribute(weighInEClass, WEIGH_IN__UNIT);

		swineEClass = createEClass(SWINE);
		createEAttribute(swineEClass, SWINE__SWINE_BREED);
		createEAttribute(swineEClass, SWINE__RIGHT_EAR_NOTCHING);
		createEAttribute(swineEClass, SWINE__LEFT_EAR_NOTCHING);

		equineEClass = createEClass(EQUINE);
		createEAttribute(equineEClass, EQUINE__HORSE_BREED);

		caprineEClass = createEClass(CAPRINE);
		createEAttribute(caprineEClass, CAPRINE__GOAT_BREED);

		medicalConditionEClass = createEClass(MEDICAL_CONDITION);

		medicalTreatmentEClass = createEClass(MEDICAL_TREATMENT);
		createEAttribute(medicalTreatmentEClass, MEDICAL_TREATMENT__NAME);
		createEAttribute(medicalTreatmentEClass, MEDICAL_TREATMENT__PRODUCT);
		createEAttribute(medicalTreatmentEClass, MEDICAL_TREATMENT__MANUFACTURER);
		createEAttribute(medicalTreatmentEClass, MEDICAL_TREATMENT__LOT);
		createEAttribute(medicalTreatmentEClass, MEDICAL_TREATMENT__QUANTITY);
		createEAttribute(medicalTreatmentEClass, MEDICAL_TREATMENT__TREATMENT);
		createEAttribute(medicalTreatmentEClass, MEDICAL_TREATMENT__METHOD);

		birthingEClass = createEClass(BIRTHING);
		createEAttribute(birthingEClass, BIRTHING__VIABILITY);
		createEAttribute(birthingEClass, BIRTHING__ASSISTED);
		createEAttribute(birthingEClass, BIRTHING__DIFFICULTY);

		calvingEClass = createEClass(CALVING);

		birthDefectEClass = createEClass(BIRTH_DEFECT);
		createEAttribute(birthDefectEClass, BIRTH_DEFECT__FREEMARTIN);

		mastitisEClass = createEClass(MASTITIS);
		createEAttribute(mastitisEClass, MASTITIS__LOCATION);
		createEAttribute(mastitisEClass, MASTITIS__ORIGIN);

		milkTestEClass = createEClass(MILK_TEST);
		createEAttribute(milkTestEClass, MILK_TEST__POUNDS_PRODUCED);
		createEAttribute(milkTestEClass, MILK_TEST__PERCENT_BUTTER_FAT);
		createEAttribute(milkTestEClass, MILK_TEST__PERCENT_PROTEIN);
		createEAttribute(milkTestEClass, MILK_TEST__SOMATIC_CELL_COUNTS);
		createEAttribute(milkTestEClass, MILK_TEST__OTHER_SOLIDS);

		herdTestEClass = createEClass(HERD_TEST);
		createEAttribute(herdTestEClass, HERD_TEST__PREGNANT);
		createEAttribute(herdTestEClass, HERD_TEST__DAYS_SINCE_BRED_ESTIMATE);
		createEAttribute(herdTestEClass, HERD_TEST__BRED_DATE_ESTIMATE);

		genericEventEClass = createEClass(GENERIC_EVENT);
		createEReference(genericEventEClass, GENERIC_EVENT__EVENT_ATTRIBUTES);
		createEReference(genericEventEClass, GENERIC_EVENT__OCD);

		stringToStringMapEClass = createEClass(STRING_TO_STRING_MAP);
		createEAttribute(stringToStringMapEClass, STRING_TO_STRING_MAP__KEY);
		createEAttribute(stringToStringMapEClass, STRING_TO_STRING_MAP__VALUE);

		usBeefGradingEClass = createEClass(US_BEEF_GRADING);
		createEAttribute(usBeefGradingEClass, US_BEEF_GRADING__QUALITY_GRADE);
		createEAttribute(usBeefGradingEClass, US_BEEF_GRADING__QUALITY_GRADE_LEVEL);
		createEAttribute(usBeefGradingEClass, US_BEEF_GRADING__YIELD_GRADE);

		usOvineGradingEClass = createEClass(US_OVINE_GRADING);
		createEAttribute(usOvineGradingEClass, US_OVINE_GRADING__QUALITY_GRADE);
		createEAttribute(usOvineGradingEClass, US_OVINE_GRADING__QUALITY_GRADE_LEVEL);

		usSwineGradingEClass = createEClass(US_SWINE_GRADING);
		createEAttribute(usSwineGradingEClass, US_SWINE_GRADING__QUALITY_GRADE);

		policyEClass = createEClass(POLICY);
		createEAttribute(policyEClass, POLICY__INCLUDED_SPECIES);
		createEReference(policyEClass, POLICY__INCLUDED_EVENTS);
		createEReference(policyEClass, POLICY__INCLUDED_GENERIC_EVENTS);
		createEAttribute(policyEClass, POLICY__EXCLUDE_UNSPECIFIED_EVENTS);

		eventInclusionEClass = createEClass(EVENT_INCLUSION);
		createEAttribute(eventInclusionEClass, EVENT_INCLUSION__SPECIES);
		createEAttribute(eventInclusionEClass, EVENT_INCLUSION__EVENT);

		genericEventInclusionEClass = createEClass(GENERIC_EVENT_INCLUSION);
		createEAttribute(genericEventInclusionEClass, GENERIC_EVENT_INCLUSION__SPECIES);
		createEReference(genericEventInclusionEClass, GENERIC_EVENT_INCLUSION__OCD);

		positionEClass = createEClass(POSITION);
		createEAttribute(positionEClass, POSITION__LONGITUDE);
		createEAttribute(positionEClass, POSITION__LATITUDE);
		createEAttribute(positionEClass, POSITION__COORDINATES);

		// Create enums
		sexEEnum = createEEnum(SEX);
		bisonBreedEEnum = createEEnum(BISON_BREED);
		sheepBreedEEnum = createEEnum(SHEEP_BREED);
		beefBreedEEnum = createEEnum(BEEF_BREED);
		dairyBreedEEnum = createEEnum(DAIRY_BREED);
		swineBreedEEnum = createEEnum(SWINE_BREED);
		horseBreedEEnum = createEEnum(HORSE_BREED);
		goatBreedEEnum = createEEnum(GOAT_BREED);
		treatmentEEnum = createEEnum(TREATMENT);
		treatmentMethodEEnum = createEEnum(TREATMENT_METHOD);
		oneToTenEEnum = createEEnum(ONE_TO_TEN);
		animalTypeEEnum = createEEnum(ANIMAL_TYPE);
		eventDataTypeEEnum = createEEnum(EVENT_DATA_TYPE);
		usQualityGradeEEnum = createEEnum(US_QUALITY_GRADE);
		usBeefYieldGradeEEnum = createEEnum(US_BEEF_YIELD_GRADE);
		levelEEnum = createEEnum(LEVEL);
		usSwineQualityGradeEEnum = createEEnum(US_SWINE_QUALITY_GRADE);
		weightMeasurementUnitEEnum = createEEnum(WEIGHT_MEASUREMENT_UNIT);
		eventTypeEEnum = createEEnum(EVENT_TYPE);

		// Create data types
		premisesIdNumberEDataType = createEDataType(PREMISES_ID_NUMBER);
		emailEDataType = createEDataType(EMAIL);
		ageEDataType = createEDataType(AGE);
		usPhoneNumberEDataType = createEDataType(US_PHONE_NUMBER);
		uriEDataType = createEDataType(URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		MetatypePackage theMetatypePackage = (MetatypePackage)EPackage.Registry.INSTANCE.getEPackage(MetatypePackage.eNS_URI);
		LocationPackage theLocationPackage = (LocationPackage)EPackage.Registry.INSTANCE.getEPackage(LocationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bovineEClass.getESuperTypes().add(this.getAnimal());
		tagAllocatedEClass.getESuperTypes().add(this.getEvent());
		bovineBeefEClass.getESuperTypes().add(this.getBovine());
		ovineEClass.getESuperTypes().add(this.getAnimal());
		bovineBisonEClass.getESuperTypes().add(this.getBovine());
		bovineDairyEClass.getESuperTypes().add(this.getBovine());
		tagAppliedEClass.getESuperTypes().add(this.getEvent());
		movedInEClass.getESuperTypes().add(this.getEvent());
		movedOutEClass.getESuperTypes().add(this.getEvent());
		lostTagEClass.getESuperTypes().add(this.getEvent());
		replacedTagEClass.getESuperTypes().add(this.getEvent());
		importedEClass.getESuperTypes().add(this.getEvent());
		exportedEClass.getESuperTypes().add(this.getEvent());
		sightingEClass.getESuperTypes().add(this.getEvent());
		slaughteredEClass.getESuperTypes().add(this.getEvent());
		diedEClass.getESuperTypes().add(this.getEvent());
		tagRetiredEClass.getESuperTypes().add(this.getEvent());
		animalMissingEClass.getESuperTypes().add(this.getEvent());
		icviEClass.getESuperTypes().add(this.getEvent());
		weighInEClass.getESuperTypes().add(this.getEvent());
		swineEClass.getESuperTypes().add(this.getAnimal());
		equineEClass.getESuperTypes().add(this.getAnimal());
		caprineEClass.getESuperTypes().add(this.getAnimal());
		medicalConditionEClass.getESuperTypes().add(this.getEvent());
		medicalTreatmentEClass.getESuperTypes().add(this.getEvent());
		birthingEClass.getESuperTypes().add(this.getEvent());
		calvingEClass.getESuperTypes().add(this.getBirthing());
		birthDefectEClass.getESuperTypes().add(this.getEvent());
		mastitisEClass.getESuperTypes().add(this.getMedicalCondition());
		milkTestEClass.getESuperTypes().add(this.getEvent());
		herdTestEClass.getESuperTypes().add(this.getEvent());
		genericEventEClass.getESuperTypes().add(this.getEvent());
		usBeefGradingEClass.getESuperTypes().add(this.getEvent());
		usOvineGradingEClass.getESuperTypes().add(this.getEvent());
		usSwineGradingEClass.getESuperTypes().add(this.getEvent());
		positionEClass.getESuperTypes().add(this.getEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(animalEClass, Animal.class, "Animal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnimal_BirthDate(), ecorePackage.getEDate(), "birthDate", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Sex(), this.getSex(), "sex", "Unspecified", 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimal_Tags(), this.getTag(), this.getTag_Animal(), "tags", null, 1, -1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Species(), ecorePackage.getEString(), "species", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Breed(), ecorePackage.getEString(), "breed", "", 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_SexCode(), ecorePackage.getEString(), "sexCode", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_SpeciesCode(), ecorePackage.getEString(), "speciesCode", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Id(), ecorePackage.getEString(), "id", null, 1, 1, Animal.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Comments(), ecorePackage.getEString(), "comments", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_LastEventDateTime(), ecorePackage.getEDate(), "lastEventDateTime", null, 1, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getAnimal_Dam(), this.getAnimal(), null, "dam", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimal_Sire(), this.getAnimal(), null, "sire", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Weight(), ecorePackage.getEDoubleObject(), "weight", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_WeightGainPerDay(), ecorePackage.getEDoubleObject(), "weightGainPerDay", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Type(), this.getAnimalType(), "type", null, 1, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_VisualID(), ecorePackage.getEString(), "visualID", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_AgeInDays(), ecorePackage.getEInt(), "ageInDays", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_AlternativeID(), ecorePackage.getEString(), "alternativeID", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAnimal_Location(), ecorePackage.getEString(), "location", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(animalEClass, this.getEvent(), "allEvents", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(animalEClass, null, "addTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getEvent());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eventTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(animalEClass, this.getTag(), "activeTag", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(animalEClass, this.getEvent(), "eventHistory", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(animalEClass, this.getWeighIn(), "lastWeighIn", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(animalEClass, this.getAge(), "getAge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(animalEClass, theXMLTypePackage.getBoolean(), "canContain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventType(), "eventType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getString(), "ocdId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(animalEClass, this.getEvent(), "lastEvent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_UsainNumberUsed(), ecorePackage.getEBoolean(), "usainNumberUsed", null, 1, 1, Tag.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTag_Events(), this.getEvent(), this.getEvent_Tag(), "events", null, 1, -1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Id(), ecorePackage.getEString(), "id", "", 1, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTag_Animal(), this.getAnimal(), this.getAnimal_Tags(), "animal", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(tagEClass, theXMLTypePackage.getBoolean(), "canContain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventType(), "eventType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getString(), "ocdId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(tagEClass, theMetatypePackage.getOCD(), "findOCD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "ocdId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(tagEClass, null, "findOCDs", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(theMetatypePackage.getOCD());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(bovineEClass, Bovine.class, "Bovine", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_DateTime(), ecorePackage.getEDate(), "dateTime", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_EventCode(), ecorePackage.getEInt(), "eventCode", "0", 1, 1, Event.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_ElectronicallyRead(), ecorePackage.getEBoolean(), "electronicallyRead", "false", 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Correction(), ecorePackage.getEBoolean(), "correction", "false", 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Comments(), ecorePackage.getEString(), "comments", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Tag(), this.getTag(), this.getTag_Events(), "tag", null, 1, 1, Event.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Id(), ecorePackage.getEString(), "id", null, 1, 1, Event.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Date(), theXMLTypePackage.getString(), "date", null, 0, 1, Event.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_DateKey(), theXMLTypePackage.getString(), "dateKey", null, 0, 1, Event.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Pid(), ecorePackage.getEString(), "pid", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(eventEClass, this.getEvent(), "dateEvent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eventEClass, this.getEvent(), "dateEvents", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eventEClass, ecorePackage.getEString(), "values", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tagAllocatedEClass, TagAllocated.class, "TagAllocated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(premisesEClass, Premises.class, "Premises", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPremises_PremisesId(), this.getPremisesIdNumber(), "premisesId", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_EmailContact(), this.getEmail(), "emailContact", "", 1, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_Animals(), this.getAnimal(), null, "animals", null, 0, -1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_UnAppliedTags(), this.getTag(), null, "unAppliedTags", null, 0, -1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_Uri(), this.getURI(), "uri", null, 1, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_Policy(), this.getPolicy(), null, "policy", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_Administrator(), ecorePackage.getEString(), "administrator", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_Name(), ecorePackage.getEString(), "name", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_Description(), ecorePackage.getEString(), "description", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_PhoneNumber(), this.getUSPhoneNumber(), "phoneNumber", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_Address(), ecorePackage.getEString(), "address", "", 0, 1, Premises.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_Location(), theLocationPackage.getLocation(), null, "location", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(premisesEClass, this.getEvent(), "eventHistory", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(premisesEClass, this.getAnimal(), "findAnimal", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(premisesEClass, null, "addTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "ains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAnimal(), "animalTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(premisesEClass, theXMLTypePackage.getBoolean(), "canContain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventType(), "eventType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getString(), "ocdId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAnimalType(), "animalType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bovineBeefEClass, BovineBeef.class, "BovineBeef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBovineBeef_BeefBreed(), this.getBeefBreed(), "beefBreed", "Unspecified", 0, 1, BovineBeef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ovineEClass, Ovine.class, "Ovine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOvine_SheepBreed(), this.getSheepBreed(), "sheepBreed", "Unspecified", 0, 1, Ovine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOvine_ScrapieTag(), ecorePackage.getEString(), "scrapieTag", null, 0, 1, Ovine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bovineBisonEClass, BovineBison.class, "BovineBison", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBovineBison_BuffaloBreed(), this.getBisonBreed(), "buffaloBreed", "Unspecified", 0, 1, BovineBison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bovineDairyEClass, BovineDairy.class, "BovineDairy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBovineDairy_DairyBreed(), this.getDairyBreed(), "dairyBreed", "Unspecified", 0, 1, BovineDairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagAppliedEClass, TagApplied.class, "TagApplied", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(movedInEClass, MovedIn.class, "MovedIn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovedIn_SourcePin(), this.getPremisesIdNumber(), "sourcePin", null, 0, 1, MovedIn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovedIn_Uri(), this.getURI(), "uri", null, 0, 1, MovedIn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(movedOutEClass, MovedOut.class, "MovedOut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovedOut_DestinationPin(), this.getPremisesIdNumber(), "destinationPin", null, 0, 1, MovedOut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovedOut_Uri(), this.getURI(), "uri", null, 0, 1, MovedOut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lostTagEClass, LostTag.class, "LostTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(replacedTagEClass, ReplacedTag.class, "ReplacedTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReplacedTag_OldId(), ecorePackage.getEString(), "oldId", "", 1, 1, ReplacedTag.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getReplacedTag_UsainNumberUsedForOldId(), ecorePackage.getEBoolean(), "usainNumberUsedForOldId", null, 1, 1, ReplacedTag.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getReplacedTag_OldTag(), this.getTag(), null, "oldTag", null, 1, 1, ReplacedTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importedEClass, Imported.class, "Imported", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(exportedEClass, Exported.class, "Exported", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sightingEClass, Sighting.class, "Sighting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSighting_Location(), ecorePackage.getEString(), "location", null, 0, 1, Sighting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(slaughteredEClass, Slaughtered.class, "Slaughtered", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diedEClass, Died.class, "Died", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tagRetiredEClass, TagRetired.class, "TagRetired", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(animalMissingEClass, AnimalMissing.class, "AnimalMissing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(icviEClass, com.verticon.tracker.ICVI.class, "ICVI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(weighInEClass, WeighIn.class, "WeighIn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWeighIn_Weight(), ecorePackage.getEDoubleObject(), "weight", null, 1, 1, WeighIn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWeighIn_WeightGainPerDay(), ecorePackage.getEDoubleObject(), "weightGainPerDay", null, 0, 1, WeighIn.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getWeighIn_Unit(), this.getWeightMeasurementUnit(), "unit", "pound", 0, 1, WeighIn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(weighInEClass, this.getWeighIn(), "previousWeighIn", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(swineEClass, Swine.class, "Swine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwine_SwineBreed(), this.getSwineBreed(), "swineBreed", "Unspecified", 0, 1, Swine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwine_RightEarNotching(), ecorePackage.getEInt(), "rightEarNotching", null, 0, 1, Swine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwine_LeftEarNotching(), ecorePackage.getEInt(), "leftEarNotching", null, 0, 1, Swine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equineEClass, Equine.class, "Equine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEquine_HorseBreed(), this.getHorseBreed(), "horseBreed", "Unspecified", 0, 1, Equine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caprineEClass, Caprine.class, "Caprine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaprine_GoatBreed(), this.getGoatBreed(), "goatBreed", "Unspecified", 0, 1, Caprine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(medicalConditionEClass, MedicalCondition.class, "MedicalCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(medicalTreatmentEClass, MedicalTreatment.class, "MedicalTreatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMedicalTreatment_Name(), ecorePackage.getEString(), "name", null, 1, 1, MedicalTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMedicalTreatment_Product(), ecorePackage.getEString(), "product", null, 0, 1, MedicalTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMedicalTreatment_Manufacturer(), ecorePackage.getEString(), "manufacturer", null, 0, 1, MedicalTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMedicalTreatment_Lot(), ecorePackage.getEString(), "lot", null, 0, 1, MedicalTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMedicalTreatment_Quantity(), ecorePackage.getEString(), "quantity", null, 0, 1, MedicalTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMedicalTreatment_Treatment(), this.getTreatment(), "treatment", null, 0, 1, MedicalTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMedicalTreatment_Method(), this.getTreatmentMethod(), "method", null, 0, 1, MedicalTreatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(birthingEClass, Birthing.class, "Birthing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBirthing_Viability(), ecorePackage.getEBoolean(), "viability", null, 0, 1, Birthing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBirthing_Assisted(), ecorePackage.getEBoolean(), "assisted", null, 0, 1, Birthing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBirthing_Difficulty(), this.getOneToTen(), "difficulty", null, 0, 1, Birthing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(calvingEClass, Calving.class, "Calving", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(birthDefectEClass, BirthDefect.class, "BirthDefect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBirthDefect_Freemartin(), ecorePackage.getEBoolean(), "freemartin", null, 0, 1, BirthDefect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mastitisEClass, Mastitis.class, "Mastitis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMastitis_Location(), ecorePackage.getEString(), "location", null, 0, 1, Mastitis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMastitis_Origin(), ecorePackage.getEString(), "origin", null, 0, 1, Mastitis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(milkTestEClass, MilkTest.class, "MilkTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMilkTest_PoundsProduced(), ecorePackage.getEDouble(), "poundsProduced", null, 0, 1, MilkTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkTest_PercentButterFat(), ecorePackage.getEDouble(), "percentButterFat", null, 0, 1, MilkTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkTest_PercentProtein(), ecorePackage.getEDouble(), "percentProtein", null, 0, 1, MilkTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkTest_SomaticCellCounts(), ecorePackage.getEInt(), "somaticCellCounts", null, 0, 1, MilkTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkTest_OtherSolids(), ecorePackage.getEDouble(), "otherSolids", null, 0, 1, MilkTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(herdTestEClass, HerdTest.class, "HerdTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHerdTest_Pregnant(), ecorePackage.getEBoolean(), "pregnant", null, 0, 1, HerdTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHerdTest_DaysSinceBredEstimate(), ecorePackage.getEInt(), "daysSinceBredEstimate", null, 0, 1, HerdTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHerdTest_BredDateEstimate(), ecorePackage.getEDate(), "bredDateEstimate", null, 0, 1, HerdTest.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(genericEventEClass, GenericEvent.class, "GenericEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenericEvent_EventAttributes(), this.getStringToStringMap(), null, "eventAttributes", null, 0, -1, GenericEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericEvent_Ocd(), theMetatypePackage.getOCD(), null, "ocd", null, 1, 1, GenericEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(genericEventEClass, theMetatypePackage.getAttributeDefinition(), "findAttributeDefinition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStringToStringMap(), "eventAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(genericEventEClass, theXMLTypePackage.getString(), "findName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericEventEClass, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericEventEClass, ecorePackage.getEBoolean(), "hasRequiredAttributes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericEventEClass, ecorePackage.getEBoolean(), "hasValidAttributes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericEventEClass, ecorePackage.getEBoolean(), "hasAllAttributes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stringToStringMapEClass, Map.Entry.class, "StringToStringMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToStringMap_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringToStringMap_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usBeefGradingEClass, USBeefGrading.class, "USBeefGrading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUSBeefGrading_QualityGrade(), this.getUSQualityGrade(), "qualityGrade", null, 0, 1, USBeefGrading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUSBeefGrading_QualityGradeLevel(), this.getLevel(), "qualityGradeLevel", null, 0, 1, USBeefGrading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUSBeefGrading_YieldGrade(), this.getUSBeefYieldGrade(), "yieldGrade", null, 0, 1, USBeefGrading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usOvineGradingEClass, USOvineGrading.class, "USOvineGrading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUSOvineGrading_QualityGrade(), this.getUSQualityGrade(), "qualityGrade", null, 0, 1, USOvineGrading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUSOvineGrading_QualityGradeLevel(), this.getLevel(), "qualityGradeLevel", null, 0, 1, USOvineGrading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usSwineGradingEClass, USSwineGrading.class, "USSwineGrading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUSSwineGrading_QualityGrade(), this.getUSSwineQualityGrade(), "qualityGrade", null, 0, 1, USSwineGrading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policyEClass, Policy.class, "Policy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolicy_IncludedSpecies(), this.getAnimalType(), "includedSpecies", null, 0, -1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicy_IncludedEvents(), this.getEventInclusion(), null, "includedEvents", null, 0, -1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicy_IncludedGenericEvents(), this.getGenericEventInclusion(), null, "includedGenericEvents", null, 0, -1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicy_ExcludeUnspecifiedEvents(), theXMLTypePackage.getBoolean(), "excludeUnspecifiedEvents", null, 0, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(policyEClass, theXMLTypePackage.getBoolean(), "canContain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventType(), "eventType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getString(), "ocdId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAnimalType(), "animalType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventInclusionEClass, EventInclusion.class, "EventInclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventInclusion_Species(), this.getAnimalType(), "species", null, 1, -1, EventInclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventInclusion_Event(), this.getEventType(), "event", null, 1, -1, EventInclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericEventInclusionEClass, GenericEventInclusion.class, "GenericEventInclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenericEventInclusion_Species(), this.getAnimalType(), "species", null, 1, -1, GenericEventInclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericEventInclusion_Ocd(), theMetatypePackage.getOCD(), null, "ocd", null, 1, 1, GenericEventInclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(positionEClass, Position.class, "Position", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPosition_Longitude(), ecorePackage.getEDouble(), "longitude", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPosition_Latitude(), ecorePackage.getEDouble(), "latitude", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPosition_Coordinates(), ecorePackage.getEString(), "coordinates", null, 0, 1, Position.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sexEEnum, Sex.class, "Sex");
		addEEnumLiteral(sexEEnum, Sex.UNSPECIFIED_LITERAL);
		addEEnumLiteral(sexEEnum, Sex.F_LITERAL);
		addEEnumLiteral(sexEEnum, Sex.M_LITERAL);
		addEEnumLiteral(sexEEnum, Sex.C_LITERAL);
		addEEnumLiteral(sexEEnum, Sex.S_LITERAL);

		initEEnum(bisonBreedEEnum, BisonBreed.class, "BisonBreed");
		addEEnumLiteral(bisonBreedEEnum, BisonBreed.WO_LITERAL);
		addEEnumLiteral(bisonBreedEEnum, BisonBreed.PB_LITERAL);
		addEEnumLiteral(bisonBreedEEnum, BisonBreed.UNSPECIFIED_LITERAL);

		initEEnum(sheepBreedEEnum, SheepBreed.class, "SheepBreed");
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.CD_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.OU_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.RI_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.LY_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.FB_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.BW_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.BF_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.BO_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.BC_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.CO_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.CF_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.CL_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.CP_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.CR_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.DH_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.DP_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.DL_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.ER_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.FN_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.HS_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.HY_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.IL_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.KK_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.KA_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.KH_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.BL_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.LE_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.HL_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.LI_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.MM_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.MP_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.MT_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.NL_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.NC_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.OX_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.PE_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.PO_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.RG_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.RV_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.RM_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.RY_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.SX_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.SC_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.SL_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.SR_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.ST_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.SU_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.TA_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.TX_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.TU_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.XL_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.XM_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.ZS_LITERAL);
		addEEnumLiteral(sheepBreedEEnum, SheepBreed.UNSPECIFIED_LITERAL);

		initEEnum(beefBreedEEnum, BeefBreed.class, "BeefBreed");
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AN_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AF_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AL_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AE_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AM_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AK_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AW_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AU_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BF_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BE_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BM_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BG_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BD_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.NS_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BO_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BH_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BI_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BL_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BN_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BU_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BW_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.BQ_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.CP_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.CN_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.CB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.CH_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.CG_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.CM_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.CA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.XX_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.XT_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.CU_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.DB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.DJ_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RW_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.DE_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.DR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.DL_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.FP_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.ER_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.FA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.FL_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.FC_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.FR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.FB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.DF_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.GA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.GS_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.GE_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.GV_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.GI_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.GR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.GZ_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.GY_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.HC_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.HB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.HH_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.HP_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SH_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.HY_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.IB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.KY_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.KB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.LM_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.LR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.LO_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.LU_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.MA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.MH_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.ML_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.MR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.ME_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.MI_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.MC_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.MO_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.MU_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.MG_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.NE_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.NM_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.NR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.PA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.PR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.PI_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.PZ_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.AR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RR_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RD_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RP_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RN_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RS_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.RO_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.DN_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SW_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SG_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SL_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SE_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SV_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SS_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.IS_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SP_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SI_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SM_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.DS_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.SX_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.TP_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.TA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.TG_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.TN_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.TL_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.TI_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.WB_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.WF_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.WP_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.YA_LITERAL);
		addEEnumLiteral(beefBreedEEnum, BeefBreed.UNSPECIFIED_LITERAL);

		initEEnum(dairyBreedEEnum, DairyBreed.class, "DairyBreed");
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.LD_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.AY_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.BS_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.GD_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.GU_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.HO_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.JE_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.WW_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.FM_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.MS_LITERAL);
		addEEnumLiteral(dairyBreedEEnum, DairyBreed.UNSPECIFIED_LITERAL);

		initEEnum(swineBreedEEnum, SwineBreed.class, "SwineBreed");
		addEEnumLiteral(swineBreedEEnum, SwineBreed.BK_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.CW_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.DU_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.HA_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.LC_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.LA_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.LB_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.LW_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.PE_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.PC_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.RW_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.SO_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.TM_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.WS_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.YO_LITERAL);
		addEEnumLiteral(swineBreedEEnum, SwineBreed.UNSPECIFIED_LITERAL);

		initEEnum(horseBreedEEnum, HorseBreed.class, "HorseBreed");
		addEEnumLiteral(horseBreedEEnum, HorseBreed.AC);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.AS);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.AA);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.AO);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.NO);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.AP);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.AD);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.BW);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.BY);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.BU);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.CI);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.FC);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.CV);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.CY);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.CM);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.DT);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.DW);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.EX);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.FE);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.FJ);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.FH);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.FR);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.GL);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.WG);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.HN);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.HK);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.HF);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.HV);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.HG);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.HT);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.HW);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.HU);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.IC);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.LZ);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.MU);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.MF);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.MN);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.NF);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.NK);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.OB);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.PT);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.PL);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.PF);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.PH);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.PV);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.PN);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.PW);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.OL);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.QH);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.RH);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.RU);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.SE);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.SY);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.SN);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.SF);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.WW);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.WI);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.TP);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.TW);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.TH);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.TR);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.TF);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.VK);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.WE);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.WF);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.WU);
		addEEnumLiteral(horseBreedEEnum, HorseBreed.UNSPECIFIED);

		initEEnum(goatBreedEEnum, GoatBreed.class, "GoatBreed");
		addEEnumLiteral(goatBreedEEnum, GoatBreed.AI);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.AG);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.BZ);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.CS);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.LN);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.ND);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.NU);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.OH);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.PY);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.EN);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.TO);
		addEEnumLiteral(goatBreedEEnum, GoatBreed.UNSPECIFIED);

		initEEnum(treatmentEEnum, Treatment.class, "Treatment");
		addEEnumLiteral(treatmentEEnum, Treatment.UNSPECIFIED);
		addEEnumLiteral(treatmentEEnum, Treatment.VACCINATION);
		addEEnumLiteral(treatmentEEnum, Treatment.VITAMIN);
		addEEnumLiteral(treatmentEEnum, Treatment.HORMONE);
		addEEnumLiteral(treatmentEEnum, Treatment.PREVENTION);

		initEEnum(treatmentMethodEEnum, TreatmentMethod.class, "TreatmentMethod");
		addEEnumLiteral(treatmentMethodEEnum, TreatmentMethod.UNSPECIFIED);
		addEEnumLiteral(treatmentMethodEEnum, TreatmentMethod.INTRAMUSCULAR);
		addEEnumLiteral(treatmentMethodEEnum, TreatmentMethod.NASAL);
		addEEnumLiteral(treatmentMethodEEnum, TreatmentMethod.SALVE);

		initEEnum(oneToTenEEnum, OneToTen.class, "OneToTen");
		addEEnumLiteral(oneToTenEEnum, OneToTen.UNSPECIFIED);
		addEEnumLiteral(oneToTenEEnum, OneToTen.ONE);
		addEEnumLiteral(oneToTenEEnum, OneToTen.TWO);
		addEEnumLiteral(oneToTenEEnum, OneToTen.THREE);
		addEEnumLiteral(oneToTenEEnum, OneToTen.FOUR);
		addEEnumLiteral(oneToTenEEnum, OneToTen.FIVE);
		addEEnumLiteral(oneToTenEEnum, OneToTen.SIX);
		addEEnumLiteral(oneToTenEEnum, OneToTen.SEVEN);
		addEEnumLiteral(oneToTenEEnum, OneToTen.EIGHT);
		addEEnumLiteral(oneToTenEEnum, OneToTen.NINE);
		addEEnumLiteral(oneToTenEEnum, OneToTen.TEN);

		initEEnum(animalTypeEEnum, AnimalType.class, "AnimalType");
		addEEnumLiteral(animalTypeEEnum, AnimalType.UNSPECIFIED);
		addEEnumLiteral(animalTypeEEnum, AnimalType.SWINE);
		addEEnumLiteral(animalTypeEEnum, AnimalType.EQUINE);
		addEEnumLiteral(animalTypeEEnum, AnimalType.CAPRINE);
		addEEnumLiteral(animalTypeEEnum, AnimalType.OVINE);
		addEEnumLiteral(animalTypeEEnum, AnimalType.BOVINE_BEEF);
		addEEnumLiteral(animalTypeEEnum, AnimalType.BOVINE_DAIRY);
		addEEnumLiteral(animalTypeEEnum, AnimalType.BOVINE_BISON);

		initEEnum(eventDataTypeEEnum, EventDataType.class, "EventDataType");
		addEEnumLiteral(eventDataTypeEEnum, EventDataType.STRING);
		addEEnumLiteral(eventDataTypeEEnum, EventDataType.INTEGER);
		addEEnumLiteral(eventDataTypeEEnum, EventDataType.BOOLEAN);

		initEEnum(usQualityGradeEEnum, USQualityGrade.class, "USQualityGrade");
		addEEnumLiteral(usQualityGradeEEnum, USQualityGrade.UNSPECIFIED);
		addEEnumLiteral(usQualityGradeEEnum, USQualityGrade.STANDARD);
		addEEnumLiteral(usQualityGradeEEnum, USQualityGrade.SELECT);
		addEEnumLiteral(usQualityGradeEEnum, USQualityGrade.CHOICE);
		addEEnumLiteral(usQualityGradeEEnum, USQualityGrade.PRIME);

		initEEnum(usBeefYieldGradeEEnum, USBeefYieldGrade.class, "USBeefYieldGrade");
		addEEnumLiteral(usBeefYieldGradeEEnum, USBeefYieldGrade.UNSPECIFIED);
		addEEnumLiteral(usBeefYieldGradeEEnum, USBeefYieldGrade.ONE);
		addEEnumLiteral(usBeefYieldGradeEEnum, USBeefYieldGrade.TWO);
		addEEnumLiteral(usBeefYieldGradeEEnum, USBeefYieldGrade.THREE);
		addEEnumLiteral(usBeefYieldGradeEEnum, USBeefYieldGrade.FOUR);
		addEEnumLiteral(usBeefYieldGradeEEnum, USBeefYieldGrade.FIVE);

		initEEnum(levelEEnum, Level.class, "Level");
		addEEnumLiteral(levelEEnum, Level.UNSPECIFIED);
		addEEnumLiteral(levelEEnum, Level.LOW);
		addEEnumLiteral(levelEEnum, Level.AVERAGE);
		addEEnumLiteral(levelEEnum, Level.HIGH);

		initEEnum(usSwineQualityGradeEEnum, USSwineQualityGrade.class, "USSwineQualityGrade");
		addEEnumLiteral(usSwineQualityGradeEEnum, USSwineQualityGrade.UNSPECIFIED);
		addEEnumLiteral(usSwineQualityGradeEEnum, USSwineQualityGrade.ONE);
		addEEnumLiteral(usSwineQualityGradeEEnum, USSwineQualityGrade.TWO);
		addEEnumLiteral(usSwineQualityGradeEEnum, USSwineQualityGrade.THREE);
		addEEnumLiteral(usSwineQualityGradeEEnum, USSwineQualityGrade.FOUR);

		initEEnum(weightMeasurementUnitEEnum, WeightMeasurementUnit.class, "WeightMeasurementUnit");
		addEEnumLiteral(weightMeasurementUnitEEnum, WeightMeasurementUnit.POUND);
		addEEnumLiteral(weightMeasurementUnitEEnum, WeightMeasurementUnit.KILOGRAM);

		initEEnum(eventTypeEEnum, EventType.class, "EventType");
		addEEnumLiteral(eventTypeEEnum, EventType.TAG_ALLOCATED);
		addEEnumLiteral(eventTypeEEnum, EventType.TAG_APPLIED);
		addEEnumLiteral(eventTypeEEnum, EventType.MOVED_IN);
		addEEnumLiteral(eventTypeEEnum, EventType.MOVED_OUT);
		addEEnumLiteral(eventTypeEEnum, EventType.EXPORTED);
		addEEnumLiteral(eventTypeEEnum, EventType.ICVI);
		addEEnumLiteral(eventTypeEEnum, EventType.DIED);
		addEEnumLiteral(eventTypeEEnum, EventType.ANIMAL_MISSING);
		addEEnumLiteral(eventTypeEEnum, EventType.SLAUGHTERED);
		addEEnumLiteral(eventTypeEEnum, EventType.SIGHTING);
		addEEnumLiteral(eventTypeEEnum, EventType.TAG_RETIRED);
		addEEnumLiteral(eventTypeEEnum, EventType.WEIGH_IN);
		addEEnumLiteral(eventTypeEEnum, EventType.GENERIC_EVENT);
		addEEnumLiteral(eventTypeEEnum, EventType.LOST_TAG);
		addEEnumLiteral(eventTypeEEnum, EventType.REPLACED_TAG);
		addEEnumLiteral(eventTypeEEnum, EventType.IMPORTED);
		addEEnumLiteral(eventTypeEEnum, EventType.MEDICAL_CONDITION);
		addEEnumLiteral(eventTypeEEnum, EventType.MEDICAL_TREATMENT);
		addEEnumLiteral(eventTypeEEnum, EventType.BIRTH_DEFECT);
		addEEnumLiteral(eventTypeEEnum, EventType.MASTITIS);
		addEEnumLiteral(eventTypeEEnum, EventType.HERD_TEST);
		addEEnumLiteral(eventTypeEEnum, EventType.BIRTHING);
		addEEnumLiteral(eventTypeEEnum, EventType.MILK_TEST);
		addEEnumLiteral(eventTypeEEnum, EventType.US_OVINE_GRADING);
		addEEnumLiteral(eventTypeEEnum, EventType.CALVING);
		addEEnumLiteral(eventTypeEEnum, EventType.US_BEEF_GRADING);
		addEEnumLiteral(eventTypeEEnum, EventType.US_SWINE_GRADING);
		addEEnumLiteral(eventTypeEEnum, EventType.POSITION);

		// Initialize data types
		initEDataType(premisesIdNumberEDataType, String.class, "PremisesIdNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(emailEDataType, String.class, "Email", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ageEDataType, Age.class, "Age", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(usPhoneNumberEDataType, String.class, "USPhoneNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, String.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";							
		addAnnotation
		  (tagEClass, 
		   source, 
		   new String[] {
			 "constraints", "IDIsValidURISegment"
		   });							
		addAnnotation
		  (premisesEClass, 
		   source, 
		   new String[] {
			 "constraints", "URIIsValidURISegment"
		   });				
		addAnnotation
		  (movedInEClass, 
		   source, 
		   new String[] {
			 "constraints", "URIIsValidURISegment"
		   });		
		addAnnotation
		  (movedOutEClass, 
		   source, 
		   new String[] {
			 "constraints", "URIIsValidURISegment"
		   });								
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";															
		addAnnotation
		  (premisesIdNumberEDataType, 
		   source, 
		   new String[] {
			 "minLength", "7",
			 "maxLength", "7",
			 "length", "7",
			 "maxExclusive", "adcdefg"
		   });										
	}

} //TrackerPackageImpl
