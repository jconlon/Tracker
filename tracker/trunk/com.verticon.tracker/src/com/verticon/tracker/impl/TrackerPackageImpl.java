/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

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

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.BeefBreed;
import com.verticon.tracker.BisonBreed;
import com.verticon.tracker.Bovine;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.Caprine;
import com.verticon.tracker.DairyBreed;
import com.verticon.tracker.Died;
import com.verticon.tracker.Equine;
import com.verticon.tracker.Event;
import com.verticon.tracker.Exported;
import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.GoatBreed;
import com.verticon.tracker.HorseBreed;
import com.verticon.tracker.Imported;
import com.verticon.tracker.Location;
import com.verticon.tracker.LostTag;
import com.verticon.tracker.MedicalCondition;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Ovine;
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
import com.verticon.tracker.WeighIn;
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
	private EClass fairRegistrationEClass = null;

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
	private EClass locationEClass = null;

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
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
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
		TrackerPackageImpl theTrackerPackage = (TrackerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof TrackerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new TrackerPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTrackerPackage.createPackageContents();

		// Initialize created meta-data
		theTrackerPackage.initializePackageContents();

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
	public EAttribute getAnimal_Age() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_SexCode() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_SpeciesCode() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Id() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Comments() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_LastEventDateTime() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimal_Dam() {
		return (EReference)animalEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimal_Sire() {
		return (EReference)animalEClass.getEStructuralFeatures().get(12);
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
	public EClass getFairRegistration() {
		return fairRegistrationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFairRegistration_Participant() {
		return (EAttribute)fairRegistrationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFairRegistration_Address() {
		return (EAttribute)fairRegistrationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFairRegistration_Phone() {
		return (EAttribute)fairRegistrationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFairRegistration_Parent() {
		return (EAttribute)fairRegistrationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFairRegistration_Club() {
		return (EAttribute)fairRegistrationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFairRegistration_SaleOrder() {
		return (EAttribute)fairRegistrationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFairRegistration_Exhibit() {
		return (EAttribute)fairRegistrationEClass.getEStructuralFeatures().get(6);
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
	public EClass getLocation() {
		return locationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocation_Name() {
		return (EAttribute)locationEClass.getEStructuralFeatures().get(0);
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
	public EReference getPremises_Locations() {
		return (EReference)premisesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_Uri() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(5);
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
	public EReference getSighting_Location() {
		return (EReference)sightingEClass.getEStructuralFeatures().get(0);
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
		createEAttribute(animalEClass, ANIMAL__AGE);
		createEAttribute(animalEClass, ANIMAL__SEX_CODE);
		createEAttribute(animalEClass, ANIMAL__SPECIES_CODE);
		createEAttribute(animalEClass, ANIMAL__ID);
		createEAttribute(animalEClass, ANIMAL__COMMENTS);
		createEAttribute(animalEClass, ANIMAL__LAST_EVENT_DATE_TIME);
		createEReference(animalEClass, ANIMAL__DAM);
		createEReference(animalEClass, ANIMAL__SIRE);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__USAIN_NUMBER_USED);
		createEReference(tagEClass, TAG__EVENTS);
		createEAttribute(tagEClass, TAG__ID);

		bovineEClass = createEClass(BOVINE);

		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__DATE_TIME);
		createEAttribute(eventEClass, EVENT__EVENT_CODE);
		createEAttribute(eventEClass, EVENT__ELECTRONICALLY_READ);
		createEAttribute(eventEClass, EVENT__CORRECTION);
		createEAttribute(eventEClass, EVENT__COMMENTS);
		createEReference(eventEClass, EVENT__TAG);
		createEAttribute(eventEClass, EVENT__ID);

		tagAllocatedEClass = createEClass(TAG_ALLOCATED);

		premisesEClass = createEClass(PREMISES);
		createEAttribute(premisesEClass, PREMISES__PREMISES_ID);
		createEAttribute(premisesEClass, PREMISES__EMAIL_CONTACT);
		createEReference(premisesEClass, PREMISES__ANIMALS);
		createEReference(premisesEClass, PREMISES__UN_APPLIED_TAGS);
		createEReference(premisesEClass, PREMISES__LOCATIONS);
		createEAttribute(premisesEClass, PREMISES__URI);

		bovineBeefEClass = createEClass(BOVINE_BEEF);
		createEAttribute(bovineBeefEClass, BOVINE_BEEF__BEEF_BREED);

		ovineEClass = createEClass(OVINE);
		createEAttribute(ovineEClass, OVINE__SHEEP_BREED);

		bovineBisonEClass = createEClass(BOVINE_BISON);
		createEAttribute(bovineBisonEClass, BOVINE_BISON__BUFFALO_BREED);

		bovineDairyEClass = createEClass(BOVINE_DAIRY);
		createEAttribute(bovineDairyEClass, BOVINE_DAIRY__DAIRY_BREED);

		tagAppliedEClass = createEClass(TAG_APPLIED);

		movedInEClass = createEClass(MOVED_IN);
		createEAttribute(movedInEClass, MOVED_IN__SOURCE_PIN);

		movedOutEClass = createEClass(MOVED_OUT);
		createEAttribute(movedOutEClass, MOVED_OUT__DESTINATION_PIN);

		lostTagEClass = createEClass(LOST_TAG);

		replacedTagEClass = createEClass(REPLACED_TAG);
		createEAttribute(replacedTagEClass, REPLACED_TAG__OLD_ID);
		createEAttribute(replacedTagEClass, REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID);

		importedEClass = createEClass(IMPORTED);

		exportedEClass = createEClass(EXPORTED);

		sightingEClass = createEClass(SIGHTING);
		createEReference(sightingEClass, SIGHTING__LOCATION);

		slaughteredEClass = createEClass(SLAUGHTERED);

		diedEClass = createEClass(DIED);

		tagRetiredEClass = createEClass(TAG_RETIRED);

		animalMissingEClass = createEClass(ANIMAL_MISSING);

		icviEClass = createEClass(ICVI);

		fairRegistrationEClass = createEClass(FAIR_REGISTRATION);
		createEAttribute(fairRegistrationEClass, FAIR_REGISTRATION__PARTICIPANT);
		createEAttribute(fairRegistrationEClass, FAIR_REGISTRATION__ADDRESS);
		createEAttribute(fairRegistrationEClass, FAIR_REGISTRATION__PHONE);
		createEAttribute(fairRegistrationEClass, FAIR_REGISTRATION__PARENT);
		createEAttribute(fairRegistrationEClass, FAIR_REGISTRATION__CLUB);
		createEAttribute(fairRegistrationEClass, FAIR_REGISTRATION__SALE_ORDER);
		createEAttribute(fairRegistrationEClass, FAIR_REGISTRATION__EXHIBIT);

		weighInEClass = createEClass(WEIGH_IN);
		createEAttribute(weighInEClass, WEIGH_IN__WEIGHT);
		createEAttribute(weighInEClass, WEIGH_IN__WEIGHT_GAIN_PER_DAY);

		swineEClass = createEClass(SWINE);
		createEAttribute(swineEClass, SWINE__SWINE_BREED);

		equineEClass = createEClass(EQUINE);
		createEAttribute(equineEClass, EQUINE__HORSE_BREED);

		caprineEClass = createEClass(CAPRINE);
		createEAttribute(caprineEClass, CAPRINE__GOAT_BREED);

		locationEClass = createEClass(LOCATION);
		createEAttribute(locationEClass, LOCATION__NAME);

		medicalConditionEClass = createEClass(MEDICAL_CONDITION);

		// Create enums
		sexEEnum = createEEnum(SEX);
		bisonBreedEEnum = createEEnum(BISON_BREED);
		sheepBreedEEnum = createEEnum(SHEEP_BREED);
		beefBreedEEnum = createEEnum(BEEF_BREED);
		dairyBreedEEnum = createEEnum(DAIRY_BREED);
		swineBreedEEnum = createEEnum(SWINE_BREED);
		horseBreedEEnum = createEEnum(HORSE_BREED);
		goatBreedEEnum = createEEnum(GOAT_BREED);

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
		fairRegistrationEClass.getESuperTypes().add(this.getEvent());
		weighInEClass.getESuperTypes().add(this.getEvent());
		swineEClass.getESuperTypes().add(this.getAnimal());
		equineEClass.getESuperTypes().add(this.getAnimal());
		caprineEClass.getESuperTypes().add(this.getAnimal());
		medicalConditionEClass.getESuperTypes().add(this.getEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(animalEClass, Animal.class, "Animal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnimal_BirthDate(), ecorePackage.getEDate(), "birthDate", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Sex(), this.getSex(), "sex", "Unspecified", 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimal_Tags(), this.getTag(), null, "tags", null, 1, -1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Species(), ecorePackage.getEString(), "species", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Breed(), ecorePackage.getEString(), "breed", "", 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Age(), this.getAge(), "age", "", 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_SexCode(), ecorePackage.getEString(), "sexCode", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_SpeciesCode(), ecorePackage.getEString(), "speciesCode", null, 0, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Id(), ecorePackage.getEString(), "id", null, 1, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Comments(), ecorePackage.getEString(), "comments", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_LastEventDateTime(), ecorePackage.getEDate(), "lastEventDateTime", null, 1, 1, Animal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getAnimal_Dam(), this.getAnimal(), null, "dam", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimal_Sire(), this.getAnimal(), null, "sire", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(animalEClass, this.getEvent(), "allEvents", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(animalEClass, null, "addTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getEvent());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eventTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(animalEClass, this.getTag(), "activeTag", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_UsainNumberUsed(), ecorePackage.getEBoolean(), "usainNumberUsed", null, 1, 1, Tag.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTag_Events(), this.getEvent(), this.getEvent_Tag(), "events", null, 1, -1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Id(), ecorePackage.getEString(), "id", "", 1, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bovineEClass, Bovine.class, "Bovine", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_DateTime(), ecorePackage.getEDate(), "dateTime", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_EventCode(), ecorePackage.getEInt(), "eventCode", "0", 1, 1, Event.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_ElectronicallyRead(), ecorePackage.getEBoolean(), "electronicallyRead", "false", 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Correction(), ecorePackage.getEBoolean(), "correction", "false", 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Comments(), ecorePackage.getEString(), "comments", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Tag(), this.getTag(), this.getTag_Events(), "tag", null, 1, 1, Event.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Id(), ecorePackage.getEString(), "id", null, 1, 1, Event.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(tagAllocatedEClass, TagAllocated.class, "TagAllocated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(premisesEClass, Premises.class, "Premises", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPremises_PremisesId(), this.getPremisesIdNumber(), "premisesId", null, 1, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_EmailContact(), this.getEmail(), "emailContact", "", 1, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_Animals(), this.getAnimal(), null, "animals", null, 0, -1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_UnAppliedTags(), this.getTag(), null, "unAppliedTags", null, 0, -1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_Locations(), this.getLocation(), null, "locations", null, 0, -1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_Uri(), this.getURI(), "uri", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(premisesEClass, this.getEvent(), "eventHistory", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(premisesEClass, this.getAnimal(), "findAnimal", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(premisesEClass, null, "addTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "ains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAnimal(), "animalTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bovineBeefEClass, BovineBeef.class, "BovineBeef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBovineBeef_BeefBreed(), this.getBeefBreed(), "beefBreed", "Unspecified", 0, 1, BovineBeef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ovineEClass, Ovine.class, "Ovine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOvine_SheepBreed(), this.getSheepBreed(), "sheepBreed", "Unspecified", 0, 1, Ovine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bovineBisonEClass, BovineBison.class, "BovineBison", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBovineBison_BuffaloBreed(), this.getBisonBreed(), "buffaloBreed", "Unspecified", 0, 1, BovineBison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bovineDairyEClass, BovineDairy.class, "BovineDairy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBovineDairy_DairyBreed(), this.getDairyBreed(), "dairyBreed", "Unspecified", 0, 1, BovineDairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagAppliedEClass, TagApplied.class, "TagApplied", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(movedInEClass, MovedIn.class, "MovedIn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovedIn_SourcePin(), this.getPremisesIdNumber(), "sourcePin", null, 1, 1, MovedIn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(movedOutEClass, MovedOut.class, "MovedOut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovedOut_DestinationPin(), this.getPremisesIdNumber(), "destinationPin", null, 1, 1, MovedOut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lostTagEClass, LostTag.class, "LostTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(replacedTagEClass, ReplacedTag.class, "ReplacedTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReplacedTag_OldId(), ecorePackage.getEString(), "oldId", null, 1, 1, ReplacedTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReplacedTag_UsainNumberUsedForOldId(), ecorePackage.getEBoolean(), "usainNumberUsedForOldId", null, 1, 1, ReplacedTag.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(importedEClass, Imported.class, "Imported", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(exportedEClass, Exported.class, "Exported", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sightingEClass, Sighting.class, "Sighting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSighting_Location(), this.getLocation(), null, "location", null, 0, 1, Sighting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(slaughteredEClass, Slaughtered.class, "Slaughtered", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diedEClass, Died.class, "Died", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tagRetiredEClass, TagRetired.class, "TagRetired", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(animalMissingEClass, AnimalMissing.class, "AnimalMissing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(icviEClass, com.verticon.tracker.ICVI.class, "ICVI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fairRegistrationEClass, FairRegistration.class, "FairRegistration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFairRegistration_Participant(), ecorePackage.getEString(), "participant", null, 1, 1, FairRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFairRegistration_Address(), ecorePackage.getEString(), "address", null, 1, 1, FairRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFairRegistration_Phone(), this.getUSPhoneNumber(), "phone", null, 1, 1, FairRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFairRegistration_Parent(), ecorePackage.getEString(), "parent", null, 0, 1, FairRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFairRegistration_Club(), ecorePackage.getEString(), "club", null, 0, 1, FairRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFairRegistration_SaleOrder(), ecorePackage.getEInt(), "SaleOrder", null, 0, 1, FairRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFairRegistration_Exhibit(), ecorePackage.getEInt(), "Exhibit", null, 0, 1, FairRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(weighInEClass, WeighIn.class, "WeighIn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWeighIn_Weight(), ecorePackage.getEInt(), "weight", null, 1, 1, WeighIn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWeighIn_WeightGainPerDay(), ecorePackage.getEInt(), "weightGainPerDay", null, 0, 1, WeighIn.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(swineEClass, Swine.class, "Swine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwine_SwineBreed(), this.getSwineBreed(), "swineBreed", "Unspecified", 0, 1, Swine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equineEClass, Equine.class, "Equine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEquine_HorseBreed(), this.getHorseBreed(), "horseBreed", "Unspecified", 0, 1, Equine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caprineEClass, Caprine.class, "Caprine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaprine_GoatBreed(), this.getGoatBreed(), "goatBreed", "Unspecified", 0, 1, Caprine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(locationEClass, Location.class, "Location", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocation_Name(), ecorePackage.getEString(), "name", null, 1, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(medicalConditionEClass, MedicalCondition.class, "MedicalCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(sexEEnum, Sex.class, "Sex");
		addEEnumLiteral(sexEEnum, Sex.F_LITERAL);
		addEEnumLiteral(sexEEnum, Sex.M_LITERAL);
		addEEnumLiteral(sexEEnum, Sex.C_LITERAL);
		addEEnumLiteral(sexEEnum, Sex.S_LITERAL);
		addEEnumLiteral(sexEEnum, Sex.UNSPECIFIED_LITERAL);

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

		// Initialize data types
		initEDataType(premisesIdNumberEDataType, String.class, "PremisesIdNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(emailEDataType, String.class, "Email", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ageEDataType, Age.class, "Age", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(usPhoneNumberEDataType, String.class, "USPhoneNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, String.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ocl/examples/OCL
		createOCLAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ocl/examples/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/ocl/examples/OCL";		
		addAnnotation
		  (premisesEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "if (animals -> notEmpty()) and (animals.tags->notEmpty())\n\tthen  animals.tags.events\n\telse Set{}\nendif"
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
