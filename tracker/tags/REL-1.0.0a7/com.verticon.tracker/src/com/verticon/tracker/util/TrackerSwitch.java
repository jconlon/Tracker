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
public class TrackerSwitch<T> {
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
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TrackerPackage.ANIMAL: {
				Animal animal = (Animal)theEObject;
				T result = caseAnimal(animal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ANIMAL_ID: {
				AnimalId animalId = (AnimalId)theEObject;
				T result = caseAnimalId(animalId);
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
			case TrackerPackage.EVENT_HISTORY: {
				EventHistory eventHistory = (EventHistory)theEObject;
				T result = caseEventHistory(eventHistory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TrackerPackage.ANIMALS: {
				Animals animals = (Animals)theEObject;
				T result = caseAnimals(animals);
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
			case TrackerPackage.FAIR_REGISTRATION: {
				FairRegistration fairRegistration = (FairRegistration)theEObject;
				T result = caseFairRegistration(fairRegistration);
				if (result == null) result = caseEvent(fairRegistration);
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
			case TrackerPackage.UN_APPLIED_TAGS: {
				UnAppliedTags unAppliedTags = (UnAppliedTags)theEObject;
				T result = caseUnAppliedTags(unAppliedTags);
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
	 * Returns the result of interpreting the object as an instance of '<em>Animal Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Animal Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnimalId(AnimalId object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Fair Registration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fair Registration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFairRegistration(FairRegistration object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Un Applied Tags</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Un Applied Tags</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnAppliedTags(UnAppliedTags object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Event History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventHistory(EventHistory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Animals</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Animals</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnimals(Animals object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //TrackerSwitch
