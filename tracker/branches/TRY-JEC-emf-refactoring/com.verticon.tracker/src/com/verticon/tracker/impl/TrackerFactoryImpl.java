/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import com.verticon.tracker.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.verticon.tracker.AnimalId;
import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.BeefBreed;
import com.verticon.tracker.BisonBreed;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.DairyBreed;
import com.verticon.tracker.Died;
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
import com.verticon.tracker.TagAllocated;
import com.verticon.tracker.TagApplied;
import com.verticon.tracker.TagRetired;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.util.Age;
import com.verticon.tracker.util.CheckEmail;
import com.verticon.tracker.util.CheckISO7064Mod37_36;
import com.verticon.tracker.util.TrackerLog;

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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TrackerFactory init() {
		try {
			TrackerFactory theTrackerFactory = (TrackerFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.verticon.com/ns/tracker/1.0"); 
			if (theTrackerFactory != null) {
				return theTrackerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
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
			case TrackerPackage.ANIMAL_ID: return createAnimalId();
			case TrackerPackage.TAG_ALLOCATED: return createTagAllocated();
			case TrackerPackage.PREMISES: return createPremises();
			case TrackerPackage.BOVINE_BEEF: return createBovineBeef();
			case TrackerPackage.OVINE: return createOvine();
			case TrackerPackage.BOVINE_BISON: return createBovineBison();
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
			case TrackerPackage.FAIR_REGISTRATION: return createFairRegistration();
			case TrackerPackage.WEIGH_IN: return createWeighIn();
			case TrackerPackage.SWINE: return createSwine();
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
			case TrackerPackage.DATE:
				return createDateFromString(eDataType, initialValue);
			case TrackerPackage.ANIMIAL_ID_NUMBER:
				return createAnimialIdNumberFromString(eDataType, initialValue);
			case TrackerPackage.PREMISES_ID_NUMBER:
				return createPremisesIdNumberFromString(eDataType, initialValue);
			case TrackerPackage.EMAIL:
				return createEmailFromString(eDataType, initialValue);
			case TrackerPackage.DATE_TIME:
				return createDateTimeFromString(eDataType, initialValue);
			case TrackerPackage.AGE:
				return createAgeFromString(eDataType, initialValue);
			case TrackerPackage.US_PHONE_NUMBER:
				return createUSPhoneNumberFromString(eDataType, initialValue);
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
			case TrackerPackage.DATE:
				return convertDateToString(eDataType, instanceValue);
			case TrackerPackage.ANIMIAL_ID_NUMBER:
				return convertAnimialIdNumberToString(eDataType, instanceValue);
			case TrackerPackage.PREMISES_ID_NUMBER:
				return convertPremisesIdNumberToString(eDataType, instanceValue);
			case TrackerPackage.EMAIL:
				return convertEmailToString(eDataType, instanceValue);
			case TrackerPackage.DATE_TIME:
				return convertDateTimeToString(eDataType, instanceValue);
			case TrackerPackage.AGE:
				return convertAgeToString(eDataType, instanceValue);
			case TrackerPackage.US_PHONE_NUMBER:
				return convertUSPhoneNumberToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalId createAnimalId() {
		AnimalIdImpl animalId = new AnimalIdImpl();
		return animalId;
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
	public FairRegistration createFairRegistration() {
		FairRegistrationImpl fairRegistration = new FairRegistrationImpl();
		return fairRegistration;
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
	 * Use a Date class instead of a String.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Date createDateFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		return formatter.parse(initialValue, new ParsePosition(0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Use a Date class instead of a String.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertDateToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		return formatter.format((Date)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String createAnimialIdNumberFromString(EDataType eDataType, String initialValue) {
		if(initialValue == null) return null;
		Pattern p = Pattern.compile("(\\d{15})");
		// Match the given string with the pattern
		Matcher m = p.matcher(initialValue);
		if(m.matches()){
			return (String)initialValue;
		}
		
		TrackerLog.logError(
		            "Illegal Animal ID number: " + initialValue, new IllegalArgumentException("Animal ID number must be an numeric of 15 characthers in length"));
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertAnimialIdNumberToString(EDataType eDataType, Object instanceValue) {
		return (String) instanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 7-digit code that includes both letters and numbers.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String createPremisesIdNumberFromString(EDataType eDataType, String initialValue) {
		if(initialValue == null) return null;
		if(initialValue.length()!=7){
			TrackerLog.logError(
		            "Illegal Premise ID number: " + initialValue, new IllegalArgumentException("Premise ID number must be an alphanumeric string of 7 characthers in length"));
			return null;
		}
		try {
			if(CheckISO7064Mod37_36.verify(initialValue)){
				return (String)initialValue;
			}
		} catch (NumberFormatException e) {
			TrackerLog.logError(
		            "Illegal Premise ID number: " + initialValue, e);
			return null;
		}
		TrackerLog.logError(
	            "Illegal Premise ID number: " + initialValue, new IllegalArgumentException("Failed CheckDigit"));
		return null;
		
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
		if(initialValue == null) return null;
		if(CheckEmail.validate(initialValue)){
			return (String)initialValue;
		}
		TrackerLog.logError(
	            "Illegal email format: " + initialValue, null);
		return null;
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
	public Date createDateTimeFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		return formatter.parse(initialValue, new ParsePosition(0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertDateTimeToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		return formatter.format((Date)instanceValue);
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		Date date = formatter.parse(initialValue, new ParsePosition(0));
		return new Age(date);
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createUSPhoneNumberFromString(EDataType eDataType, String initialValue) {
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

} //TrackerFactoryImpl
