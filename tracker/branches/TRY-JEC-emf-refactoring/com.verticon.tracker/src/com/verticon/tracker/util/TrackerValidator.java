/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.util;

import com.verticon.tracker.*;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.BeefBreed;
import com.verticon.tracker.BisonBreed;
import com.verticon.tracker.Bovine;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.DairyBreed;
import com.verticon.tracker.Died;
import com.verticon.tracker.Event;
import com.verticon.tracker.Exported;
import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.ICVI;
import com.verticon.tracker.Imported;
import com.verticon.tracker.LostTag;
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
import com.verticon.tracker.TrackerPackage;
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
	 * The parsed OCL expression for the definition of the '<em>Can_be_Slaughtered_only_once</em>' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Constraint animal_Can_be_Slaughtered_only_onceInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '<em>Must_have_TagApplied_or_MovedIn</em>' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Constraint animal_Must_have_TagApplied_or_MovedInInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '<em>SourcePin_can_not_be_same_as_the_local_premisesId</em>' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Constraint movedIn_SourcePin_can_not_be_same_as_the_local_premisesIdInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '<em>DestinationPin_can_not_be_same_as_the_local_premisesId</em>' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Constraint movedOut_DestinationPin_can_not_be_same_as_the_local_premisesIdInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/ocl/examples/OCL";

	private static final OCL OCL_ENV = OCL.newInstance();

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
			case TrackerPackage.FAIR_REGISTRATION:
				return validateFairRegistration((FairRegistration)value, diagnostics, context);
			case TrackerPackage.WEIGH_IN:
				return validateWeighIn((WeighIn)value, diagnostics, context);
			case TrackerPackage.SWINE:
				return validateSwine((Swine)value, diagnostics, context);
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
			case TrackerPackage.DATE:
				return validateDate((Date)value, diagnostics, context);
			case TrackerPackage.ANIMIAL_ID_NUMBER:
				return validateAnimialIdNumber((String)value, diagnostics, context);
			case TrackerPackage.PREMISES_ID_NUMBER:
				return validatePremisesIdNumber((String)value, diagnostics, context);
			case TrackerPackage.EMAIL:
				return validateEmail((String)value, diagnostics, context);
			case TrackerPackage.DATE_TIME:
				return validateDateTime((Date)value, diagnostics, context);
			case TrackerPackage.AGE:
				return validateAge((Age)value, diagnostics, context);
			case TrackerPackage.US_PHONE_NUMBER:
				return validateUSPhoneNumber((String)value, diagnostics, context);
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
		boolean result = validate_EveryMultiplicityConforms(animal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(animal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(animal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(animal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(animal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(animal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(animal, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Can_be_Slaughtered_only_once(animal, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Must_have_TagApplied_or_MovedIn(animal, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Can_be_Slaughtered_only_once constraint of '<em>Animal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimal_Can_be_Slaughtered_only_once(Animal animal, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (animal_Can_be_Slaughtered_only_onceInvOCL == null) {
			OCL.Helper helper = OCL_ENV.createOCLHelper();
			helper.setContext(TrackerPackage.Literals.ANIMAL);
			
			EAnnotation ocl = TrackerPackage.Literals.ANIMAL.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String expr = ocl.getDetails().get("Can_be_Slaughtered_only_once");
			
			try {
				animal_Can_be_Slaughtered_only_onceInvOCL = helper.createInvariant(expr);
			}
			catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(animal_Can_be_Slaughtered_only_onceInvOCL);
		
		if (!query.check(animal)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic", new Object[] { "Can_be_Slaughtered_only_once", getObjectLabel(animal, context) }),
						 new Object[] { animal }));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the Must_have_TagApplied_or_MovedIn constraint of '<em>Animal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimal_Must_have_TagApplied_or_MovedIn(Animal animal, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (animal_Must_have_TagApplied_or_MovedInInvOCL == null) {
			OCL.Helper helper = OCL_ENV.createOCLHelper();
			helper.setContext(TrackerPackage.Literals.ANIMAL);
			
			EAnnotation ocl = TrackerPackage.Literals.ANIMAL.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String expr = ocl.getDetails().get("Must_have_TagApplied_or_MovedIn");
			
			try {
				animal_Must_have_TagApplied_or_MovedInInvOCL = helper.createInvariant(expr);
			}
			catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(animal_Must_have_TagApplied_or_MovedInInvOCL);
		
		if (!query.check(animal)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic", new Object[] { "Must_have_TagApplied_or_MovedIn", getObjectLabel(animal, context) }),
						 new Object[] { animal }));
			}
			return false;
		}
		return true;
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
		boolean result = validate_EveryMultiplicityConforms(bovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bovine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Can_be_Slaughtered_only_once(bovine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Must_have_TagApplied_or_MovedIn(bovine, diagnostics, context);
		return result;
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
	public boolean validateFairRegistration(FairRegistration fairRegistration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fairRegistration, diagnostics, context);
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
		boolean result = validate_EveryMultiplicityConforms(swine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(swine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(swine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(swine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(swine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(swine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(swine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Can_be_Slaughtered_only_once(swine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Must_have_TagApplied_or_MovedIn(swine, diagnostics, context);
		return result;
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
		boolean result = validate_EveryMultiplicityConforms(bovineBeef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bovineBeef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bovineBeef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bovineBeef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bovineBeef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bovineBeef, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bovineBeef, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Can_be_Slaughtered_only_once(bovineBeef, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Must_have_TagApplied_or_MovedIn(bovineBeef, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOvine(Ovine ovine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(ovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(ovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(ovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(ovine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ovine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Can_be_Slaughtered_only_once(ovine, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Must_have_TagApplied_or_MovedIn(ovine, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBovineBison(BovineBison bovineBison, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(bovineBison, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bovineBison, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bovineBison, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bovineBison, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bovineBison, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bovineBison, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bovineBison, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Can_be_Slaughtered_only_once(bovineBison, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Must_have_TagApplied_or_MovedIn(bovineBison, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBovineDairy(BovineDairy bovineDairy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(bovineDairy, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bovineDairy, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bovineDairy, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bovineDairy, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bovineDairy, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bovineDairy, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bovineDairy, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Can_be_Slaughtered_only_once(bovineDairy, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimal_Must_have_TagApplied_or_MovedIn(bovineDairy, diagnostics, context);
		return result;
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
		boolean result = validate_EveryMultiplicityConforms(movedIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(movedIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(movedIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(movedIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(movedIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(movedIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(movedIn, diagnostics, context);
		if (result || diagnostics != null) result &= validateMovedIn_SourcePin_can_not_be_same_as_the_local_premisesId(movedIn, diagnostics, context);
		return result;
	}

	/**
	 * Validates the SourcePin_can_not_be_same_as_the_local_premisesId constraint of '<em>Moved In</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovedIn_SourcePin_can_not_be_same_as_the_local_premisesId(MovedIn movedIn, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (movedIn_SourcePin_can_not_be_same_as_the_local_premisesIdInvOCL == null) {
			OCL.Helper helper = OCL_ENV.createOCLHelper();
			helper.setContext(TrackerPackage.Literals.MOVED_IN);
			
			EAnnotation ocl = TrackerPackage.Literals.MOVED_IN.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String expr = ocl.getDetails().get("SourcePin_can_not_be_same_as_the_local_premisesId");
			
			try {
				movedIn_SourcePin_can_not_be_same_as_the_local_premisesIdInvOCL = helper.createInvariant(expr);
			}
			catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(movedIn_SourcePin_can_not_be_same_as_the_local_premisesIdInvOCL);
		
		if (!query.check(movedIn)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic", new Object[] { "SourcePin_can_not_be_same_as_the_local_premisesId", getObjectLabel(movedIn, context) }),
						 new Object[] { movedIn }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovedOut(MovedOut movedOut, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(movedOut, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(movedOut, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(movedOut, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(movedOut, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(movedOut, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(movedOut, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(movedOut, diagnostics, context);
		if (result || diagnostics != null) result &= validateMovedOut_DestinationPin_can_not_be_same_as_the_local_premisesId(movedOut, diagnostics, context);
		return result;
	}

	/**
	 * Validates the DestinationPin_can_not_be_same_as_the_local_premisesId constraint of '<em>Moved Out</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovedOut_DestinationPin_can_not_be_same_as_the_local_premisesId(MovedOut movedOut, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (movedOut_DestinationPin_can_not_be_same_as_the_local_premisesIdInvOCL == null) {
			OCL.Helper helper = OCL_ENV.createOCLHelper();
			helper.setContext(TrackerPackage.Literals.MOVED_OUT);
			
			EAnnotation ocl = TrackerPackage.Literals.MOVED_OUT.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String expr = ocl.getDetails().get("DestinationPin_can_not_be_same_as_the_local_premisesId");
			
			try {
				movedOut_DestinationPin_can_not_be_same_as_the_local_premisesIdInvOCL = helper.createInvariant(expr);
			}
			catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(movedOut_DestinationPin_can_not_be_same_as_the_local_premisesIdInvOCL);
		
		if (!query.check(movedOut)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic", new Object[] { "DestinationPin_can_not_be_same_as_the_local_premisesId", getObjectLabel(movedOut, context) }),
						 new Object[] { movedOut }));
			}
			return false;
		}
		return true;
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
	public boolean validateDate(Date date, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimialIdNumber(String animialIdNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateAnimialIdNumber_MinLength(animialIdNumber, diagnostics, context);
		if (result || diagnostics != null) result &= validateAnimialIdNumber_MaxLength(animialIdNumber, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MinLength constraint of '<em>Animial Id Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimialIdNumber_MinLength(String animialIdNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = animialIdNumber.length();  
		boolean result = length >= 15;
		if (!result && diagnostics != null) 
			reportMinLengthViolation(TrackerPackage.Literals.ANIMIAL_ID_NUMBER, animialIdNumber, length, 15, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Animial Id Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimialIdNumber_MaxLength(String animialIdNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = animialIdNumber.length();  
		boolean result = length <= 15;
		if (!result && diagnostics != null) 
			reportMaxLengthViolation(TrackerPackage.Literals.ANIMIAL_ID_NUMBER, animialIdNumber, length, 15, diagnostics, context);
		return result;
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
	public boolean validateDateTime(Date dateTime, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //TrackerValidator
