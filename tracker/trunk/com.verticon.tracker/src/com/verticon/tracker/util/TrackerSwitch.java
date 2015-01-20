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
package com.verticon.tracker.util;

import com.verticon.tracker.*;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.BirthDefect;
import com.verticon.tracker.Birthing;
import com.verticon.tracker.Bovine;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.Calving;
import com.verticon.tracker.Caprine;
import com.verticon.tracker.Died;
import com.verticon.tracker.Equine;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventInclusion;
import com.verticon.tracker.Exported;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.GenericEventInclusion;
import com.verticon.tracker.HerdTest;
import com.verticon.tracker.ICVI;
import com.verticon.tracker.Imported;
import com.verticon.tracker.LostTag;
import com.verticon.tracker.Mastitis;
import com.verticon.tracker.MedicalCondition;
import com.verticon.tracker.MedicalTreatment;
import com.verticon.tracker.MilkTest;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Policy;
import com.verticon.tracker.Position;
import com.verticon.tracker.Premises;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.Slaughtered;
import com.verticon.tracker.Swine;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TagAllocated;
import com.verticon.tracker.TagApplied;
import com.verticon.tracker.TagRetired;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.USBeefGrading;
import com.verticon.tracker.USOvineGrading;
import com.verticon.tracker.USSwineGrading;
import com.verticon.tracker.WeighIn;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage
 * @generated
 */
public class TrackerSwitch<T> extends Switch<T> {
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
	protected static TrackerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerSwitch() {
		if (modelPackage == null) {
			modelPackage = TrackerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TrackerPackage.ANIMAL: {
				Animal animal = (Animal)theEObject;
				T result = caseAnimal(animal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.TAG: {
				Tag tag = (Tag)theEObject;
				T result = caseTag(tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BOVINE: {
				Bovine bovine = (Bovine)theEObject;
				T result = caseBovine(bovine);
				if (result == null) result = caseAnimal(bovine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.TAG_ALLOCATED: {
				TagAllocated tagAllocated = (TagAllocated)theEObject;
				T result = caseTagAllocated(tagAllocated);
				if (result == null) result = caseEvent(tagAllocated);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.PREMISES: {
				Premises premises = (Premises)theEObject;
				T result = casePremises(premises);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BOVINE_BEEF: {
				BovineBeef bovineBeef = (BovineBeef)theEObject;
				T result = caseBovineBeef(bovineBeef);
				if (result == null) result = caseBovine(bovineBeef);
				if (result == null) result = caseAnimal(bovineBeef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.OVINE: {
				Ovine ovine = (Ovine)theEObject;
				T result = caseOvine(ovine);
				if (result == null) result = caseAnimal(ovine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BOVINE_BISON: {
				BovineBison bovineBison = (BovineBison)theEObject;
				T result = caseBovineBison(bovineBison);
				if (result == null) result = caseBovine(bovineBison);
				if (result == null) result = caseAnimal(bovineBison);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BOVINE_DAIRY: {
				BovineDairy bovineDairy = (BovineDairy)theEObject;
				T result = caseBovineDairy(bovineDairy);
				if (result == null) result = caseBovine(bovineDairy);
				if (result == null) result = caseAnimal(bovineDairy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.TAG_APPLIED: {
				TagApplied tagApplied = (TagApplied)theEObject;
				T result = caseTagApplied(tagApplied);
				if (result == null) result = caseEvent(tagApplied);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.MOVED_IN: {
				MovedIn movedIn = (MovedIn)theEObject;
				T result = caseMovedIn(movedIn);
				if (result == null) result = caseEvent(movedIn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.MOVED_OUT: {
				MovedOut movedOut = (MovedOut)theEObject;
				T result = caseMovedOut(movedOut);
				if (result == null) result = caseEvent(movedOut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.LOST_TAG: {
				LostTag lostTag = (LostTag)theEObject;
				T result = caseLostTag(lostTag);
				if (result == null) result = caseEvent(lostTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.REPLACED_TAG: {
				ReplacedTag replacedTag = (ReplacedTag)theEObject;
				T result = caseReplacedTag(replacedTag);
				if (result == null) result = caseEvent(replacedTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.IMPORTED: {
				Imported imported = (Imported)theEObject;
				T result = caseImported(imported);
				if (result == null) result = caseEvent(imported);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.EXPORTED: {
				Exported exported = (Exported)theEObject;
				T result = caseExported(exported);
				if (result == null) result = caseEvent(exported);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.SIGHTING: {
				Sighting sighting = (Sighting)theEObject;
				T result = caseSighting(sighting);
				if (result == null) result = caseEvent(sighting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.SLAUGHTERED: {
				Slaughtered slaughtered = (Slaughtered)theEObject;
				T result = caseSlaughtered(slaughtered);
				if (result == null) result = caseEvent(slaughtered);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.DIED: {
				Died died = (Died)theEObject;
				T result = caseDied(died);
				if (result == null) result = caseEvent(died);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.TAG_RETIRED: {
				TagRetired tagRetired = (TagRetired)theEObject;
				T result = caseTagRetired(tagRetired);
				if (result == null) result = caseEvent(tagRetired);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ANIMAL_MISSING: {
				AnimalMissing animalMissing = (AnimalMissing)theEObject;
				T result = caseAnimalMissing(animalMissing);
				if (result == null) result = caseEvent(animalMissing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ICVI: {
				ICVI icvi = (ICVI)theEObject;
				T result = caseICVI(icvi);
				if (result == null) result = caseEvent(icvi);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.WEIGH_IN: {
				WeighIn weighIn = (WeighIn)theEObject;
				T result = caseWeighIn(weighIn);
				if (result == null) result = caseEvent(weighIn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.SWINE: {
				Swine swine = (Swine)theEObject;
				T result = caseSwine(swine);
				if (result == null) result = caseAnimal(swine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.EQUINE: {
				Equine equine = (Equine)theEObject;
				T result = caseEquine(equine);
				if (result == null) result = caseAnimal(equine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.CAPRINE: {
				Caprine caprine = (Caprine)theEObject;
				T result = caseCaprine(caprine);
				if (result == null) result = caseAnimal(caprine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.MEDICAL_CONDITION: {
				MedicalCondition medicalCondition = (MedicalCondition)theEObject;
				T result = caseMedicalCondition(medicalCondition);
				if (result == null) result = caseEvent(medicalCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.MEDICAL_TREATMENT: {
				MedicalTreatment medicalTreatment = (MedicalTreatment)theEObject;
				T result = caseMedicalTreatment(medicalTreatment);
				if (result == null) result = caseEvent(medicalTreatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BIRTHING: {
				Birthing birthing = (Birthing)theEObject;
				T result = caseBirthing(birthing);
				if (result == null) result = caseEvent(birthing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.CALVING: {
				Calving calving = (Calving)theEObject;
				T result = caseCalving(calving);
				if (result == null) result = caseBirthing(calving);
				if (result == null) result = caseEvent(calving);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BIRTH_DEFECT: {
				BirthDefect birthDefect = (BirthDefect)theEObject;
				T result = caseBirthDefect(birthDefect);
				if (result == null) result = caseEvent(birthDefect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.MASTITIS: {
				Mastitis mastitis = (Mastitis)theEObject;
				T result = caseMastitis(mastitis);
				if (result == null) result = caseMedicalCondition(mastitis);
				if (result == null) result = caseEvent(mastitis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.MILK_TEST: {
				MilkTest milkTest = (MilkTest)theEObject;
				T result = caseMilkTest(milkTest);
				if (result == null) result = caseEvent(milkTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.HERD_TEST: {
				HerdTest herdTest = (HerdTest)theEObject;
				T result = caseHerdTest(herdTest);
				if (result == null) result = caseEvent(herdTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.GENERIC_EVENT: {
				GenericEvent genericEvent = (GenericEvent)theEObject;
				T result = caseGenericEvent(genericEvent);
				if (result == null) result = caseEvent(genericEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.STRING_TO_STRING_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, String> stringToStringMap = (Map.Entry<String, String>)theEObject;
				T result = caseStringToStringMap(stringToStringMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.US_BEEF_GRADING: {
				USBeefGrading usBeefGrading = (USBeefGrading)theEObject;
				T result = caseUSBeefGrading(usBeefGrading);
				if (result == null) result = caseEvent(usBeefGrading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.US_OVINE_GRADING: {
				USOvineGrading usOvineGrading = (USOvineGrading)theEObject;
				T result = caseUSOvineGrading(usOvineGrading);
				if (result == null) result = caseEvent(usOvineGrading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.US_SWINE_GRADING: {
				USSwineGrading usSwineGrading = (USSwineGrading)theEObject;
				T result = caseUSSwineGrading(usSwineGrading);
				if (result == null) result = caseEvent(usSwineGrading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.POLICY: {
				Policy policy = (Policy)theEObject;
				T result = casePolicy(policy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.EVENT_INCLUSION: {
				EventInclusion eventInclusion = (EventInclusion)theEObject;
				T result = caseEventInclusion(eventInclusion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.GENERIC_EVENT_INCLUSION: {
				GenericEventInclusion genericEventInclusion = (GenericEventInclusion)theEObject;
				T result = caseGenericEventInclusion(genericEventInclusion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.POSITION: {
				Position position = (Position)theEObject;
				T result = casePosition(position);
				if (result == null) result = caseEvent(position);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.STATION: {
				Station station = (Station)theEObject;
				T result = caseStation(station);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.WIND: {
				Wind wind = (Wind)theEObject;
				T result = caseWind(wind);
				if (result == null) result = caseSensorEvent(wind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.SENSOR_EVENT: {
				SensorEvent sensorEvent = (SensorEvent)theEObject;
				T result = caseSensorEvent(sensorEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.STATION_LOCATION: {
				StationLocation stationLocation = (StationLocation)theEObject;
				T result = caseStationLocation(stationLocation);
				if (result == null) result = caseSensorEvent(stationLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.AIR: {
				Air air = (Air)theEObject;
				T result = caseAir(air);
				if (result == null) result = caseSensorEvent(air);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.LIGHT: {
				Light light = (Light)theEObject;
				T result = caseLight(light);
				if (result == null) result = caseSensorEvent(light);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ORIENTATION: {
				Orientation orientation = (Orientation)theEObject;
				T result = caseOrientation(orientation);
				if (result == null) result = caseSensorEvent(orientation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Animal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Animal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnimal(Animal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTag(Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bovine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bovine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBovine(Bovine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Allocated</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Allocated</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagAllocated(TagAllocated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Died</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Died</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDied(Died object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Retired</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Retired</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagRetired(TagRetired object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Animal Missing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Animal Missing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnimalMissing(AnimalMissing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICVI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICVI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICVI(ICVI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Weigh In</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Weigh In</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWeighIn(WeighIn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Swine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Swine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwine(Swine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquine(Equine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Caprine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Caprine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaprine(Caprine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Medical Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Medical Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMedicalCondition(MedicalCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Medical Treatment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Medical Treatment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMedicalTreatment(MedicalTreatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Birthing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Birthing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBirthing(Birthing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calving</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calving</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalving(Calving object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Birth Defect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Birth Defect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBirthDefect(BirthDefect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mastitis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mastitis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMastitis(Mastitis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Milk Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Milk Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMilkTest(MilkTest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Herd Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Herd Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHerdTest(HerdTest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericEvent(GenericEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To String Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To String Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToStringMap(Map.Entry<String, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>US Beef Grading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>US Beef Grading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUSBeefGrading(USBeefGrading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>US Ovine Grading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>US Ovine Grading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUSOvineGrading(USOvineGrading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>US Swine Grading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>US Swine Grading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUSSwineGrading(USSwineGrading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolicy(Policy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Inclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventInclusion(EventInclusion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Event Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Event Inclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericEventInclusion(GenericEventInclusion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Position</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Position</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePosition(Position object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Station</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Station</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStation(Station object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWind(Wind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorEvent(SensorEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Station Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Station Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStationLocation(StationLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Air</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Air</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAir(Air object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Light</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Light</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLight(Light object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Orientation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Orientation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrientation(Orientation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Premises</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Premises</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePremises(Premises object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bovine Beef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bovine Beef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBovineBeef(BovineBeef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ovine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ovine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOvine(Ovine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bovine Bison</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bovine Bison</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBovineBison(BovineBison object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bovine Dairy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bovine Dairy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBovineDairy(BovineDairy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Applied</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Applied</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagApplied(TagApplied object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Moved In</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Moved In</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMovedIn(MovedIn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Moved Out</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Moved Out</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMovedOut(MovedOut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lost Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lost Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLostTag(LostTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replaced Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replaced Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacedTag(ReplacedTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imported</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imported</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImported(Imported object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exported</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exported</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExported(Exported object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sighting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sighting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSighting(Sighting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slaughtered</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slaughtered</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlaughtered(Slaughtered object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TrackerSwitch
