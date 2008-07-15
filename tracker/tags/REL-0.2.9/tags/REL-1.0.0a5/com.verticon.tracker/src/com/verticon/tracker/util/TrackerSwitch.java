/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.util;

import com.verticon.tracker.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.Animals;
import com.verticon.tracker.Bovine;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.Died;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Exported;
import com.verticon.tracker.ICVI;
import com.verticon.tracker.Imported;
import com.verticon.tracker.LostTag;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Premises;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.Slaughtered;
import com.verticon.tracker.TagAllocated;
import com.verticon.tracker.TagApplied;
import com.verticon.tracker.TagRetired;
import com.verticon.tracker.TrackerPackage;

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
public class TrackerSwitch {
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
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TrackerPackage.ANIMAL: {
				Animal animal = (Animal)theEObject;
				Object result = caseAnimal(animal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ANIMAL_ID: {
				AnimalId animalId = (AnimalId)theEObject;
				Object result = caseAnimalId(animalId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BOVINE: {
				Bovine bovine = (Bovine)theEObject;
				Object result = caseBovine(bovine);
				if (result == null) result = caseAnimal(bovine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.EVENT: {
				Event event = (Event)theEObject;
				Object result = caseEvent(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.TAG_ALLOCATED: {
				TagAllocated tagAllocated = (TagAllocated)theEObject;
				Object result = caseTagAllocated(tagAllocated);
				if (result == null) result = caseEvent(tagAllocated);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.PREMISES: {
				Premises premises = (Premises)theEObject;
				Object result = casePremises(premises);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.EVENT_HISTORY: {
				EventHistory eventHistory = (EventHistory)theEObject;
				Object result = caseEventHistory(eventHistory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ANIMALS: {
				Animals animals = (Animals)theEObject;
				Object result = caseAnimals(animals);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BOVINE_BEEF: {
				BovineBeef bovineBeef = (BovineBeef)theEObject;
				Object result = caseBovineBeef(bovineBeef);
				if (result == null) result = caseBovine(bovineBeef);
				if (result == null) result = caseAnimal(bovineBeef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.OVINE: {
				Ovine ovine = (Ovine)theEObject;
				Object result = caseOvine(ovine);
				if (result == null) result = caseAnimal(ovine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BOVINE_BISON: {
				BovineBison bovineBison = (BovineBison)theEObject;
				Object result = caseBovineBison(bovineBison);
				if (result == null) result = caseBovine(bovineBison);
				if (result == null) result = caseAnimal(bovineBison);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.BOVINE_DAIRY: {
				BovineDairy bovineDairy = (BovineDairy)theEObject;
				Object result = caseBovineDairy(bovineDairy);
				if (result == null) result = caseBovine(bovineDairy);
				if (result == null) result = caseAnimal(bovineDairy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.TAG_APPLIED: {
				TagApplied tagApplied = (TagApplied)theEObject;
				Object result = caseTagApplied(tagApplied);
				if (result == null) result = caseEvent(tagApplied);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.MOVED_IN: {
				MovedIn movedIn = (MovedIn)theEObject;
				Object result = caseMovedIn(movedIn);
				if (result == null) result = caseEvent(movedIn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.MOVED_OUT: {
				MovedOut movedOut = (MovedOut)theEObject;
				Object result = caseMovedOut(movedOut);
				if (result == null) result = caseEvent(movedOut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.LOST_TAG: {
				LostTag lostTag = (LostTag)theEObject;
				Object result = caseLostTag(lostTag);
				if (result == null) result = caseEvent(lostTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.REPLACED_TAG: {
				ReplacedTag replacedTag = (ReplacedTag)theEObject;
				Object result = caseReplacedTag(replacedTag);
				if (result == null) result = caseEvent(replacedTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.IMPORTED: {
				Imported imported = (Imported)theEObject;
				Object result = caseImported(imported);
				if (result == null) result = caseEvent(imported);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.EXPORTED: {
				Exported exported = (Exported)theEObject;
				Object result = caseExported(exported);
				if (result == null) result = caseEvent(exported);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.SIGHTING: {
				Sighting sighting = (Sighting)theEObject;
				Object result = caseSighting(sighting);
				if (result == null) result = caseEvent(sighting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.SLAUGHTERED: {
				Slaughtered slaughtered = (Slaughtered)theEObject;
				Object result = caseSlaughtered(slaughtered);
				if (result == null) result = caseEvent(slaughtered);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.DIED: {
				Died died = (Died)theEObject;
				Object result = caseDied(died);
				if (result == null) result = caseEvent(died);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.TAG_RETIRED: {
				TagRetired tagRetired = (TagRetired)theEObject;
				Object result = caseTagRetired(tagRetired);
				if (result == null) result = caseEvent(tagRetired);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ANIMAL_MISSING: {
				AnimalMissing animalMissing = (AnimalMissing)theEObject;
				Object result = caseAnimalMissing(animalMissing);
				if (result == null) result = caseEvent(animalMissing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ICVI: {
				ICVI icvi = (ICVI)theEObject;
				Object result = caseICVI(icvi);
				if (result == null) result = caseEvent(icvi);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.FAIR_REGISTRATION: {
				FairRegistration fairRegistration = (FairRegistration)theEObject;
				Object result = caseFairRegistration(fairRegistration);
				if (result == null) result = caseEvent(fairRegistration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.WEIGH_IN: {
				WeighIn weighIn = (WeighIn)theEObject;
				Object result = caseWeighIn(weighIn);
				if (result == null) result = caseEvent(weighIn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.SWINE: {
				Swine swine = (Swine)theEObject;
				Object result = caseSwine(swine);
				if (result == null) result = caseAnimal(swine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.UN_APPLIED_TAGS: {
				UnAppliedTags unAppliedTags = (UnAppliedTags)theEObject;
				Object result = caseUnAppliedTags(unAppliedTags);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Animal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Animal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnimal(Animal object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Animal Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Animal Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnimalId(AnimalId object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Bovine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Bovine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBovine(Bovine object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tag Allocated</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tag Allocated</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTagAllocated(TagAllocated object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Died</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Died</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDied(Died object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tag Retired</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tag Retired</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTagRetired(TagRetired object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Animal Missing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Animal Missing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnimalMissing(AnimalMissing object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>ICVI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>ICVI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseICVI(ICVI object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Fair Registration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Fair Registration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFairRegistration(FairRegistration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Weigh In</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Weigh In</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWeighIn(WeighIn object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Swine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Swine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSwine(Swine object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Un Applied Tags</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Un Applied Tags</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnAppliedTags(UnAppliedTags object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Premises</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Premises</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePremises(Premises object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Event History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Event History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEventHistory(EventHistory object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Animals</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Animals</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnimals(Animals object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Bovine Beef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Bovine Beef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBovineBeef(BovineBeef object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Ovine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Ovine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOvine(Ovine object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Bovine Bison</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Bovine Bison</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBovineBison(BovineBison object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Bovine Dairy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Bovine Dairy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBovineDairy(BovineDairy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tag Applied</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tag Applied</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTagApplied(TagApplied object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Moved In</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Moved In</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMovedIn(MovedIn object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Moved Out</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Moved Out</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMovedOut(MovedOut object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Lost Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Lost Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLostTag(LostTag object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Replaced Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Replaced Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReplacedTag(ReplacedTag object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Imported</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Imported</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseImported(Imported object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Exported</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Exported</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExported(Exported object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sighting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sighting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSighting(Sighting object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Slaughtered</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Slaughtered</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSlaughtered(Slaughtered object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //TrackerSwitch
