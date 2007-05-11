/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.util;

import com.verticon.tracker.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage
 * @generated
 */
public class TrackerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TrackerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TrackerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrackerSwitch modelSwitch =
		new TrackerSwitch() {
			public Object caseAnimal(Animal object) {
				return createAnimalAdapter();
			}
			public Object caseAnimalId(AnimalId object) {
				return createAnimalIdAdapter();
			}
			public Object caseBovine(Bovine object) {
				return createBovineAdapter();
			}
			public Object caseEvent(Event object) {
				return createEventAdapter();
			}
			public Object caseTagAllocated(TagAllocated object) {
				return createTagAllocatedAdapter();
			}
			public Object casePremises(Premises object) {
				return createPremisesAdapter();
			}
			public Object caseEventHistory(EventHistory object) {
				return createEventHistoryAdapter();
			}
			public Object caseAnimals(Animals object) {
				return createAnimalsAdapter();
			}
			public Object caseBovineBeef(BovineBeef object) {
				return createBovineBeefAdapter();
			}
			public Object caseOvine(Ovine object) {
				return createOvineAdapter();
			}
			public Object caseBovineBison(BovineBison object) {
				return createBovineBisonAdapter();
			}
			public Object caseBovineDairy(BovineDairy object) {
				return createBovineDairyAdapter();
			}
			public Object caseTagApplied(TagApplied object) {
				return createTagAppliedAdapter();
			}
			public Object caseMovedIn(MovedIn object) {
				return createMovedInAdapter();
			}
			public Object caseMovedOut(MovedOut object) {
				return createMovedOutAdapter();
			}
			public Object caseLostTag(LostTag object) {
				return createLostTagAdapter();
			}
			public Object caseReplacedTag(ReplacedTag object) {
				return createReplacedTagAdapter();
			}
			public Object caseImported(Imported object) {
				return createImportedAdapter();
			}
			public Object caseExported(Exported object) {
				return createExportedAdapter();
			}
			public Object caseSighting(Sighting object) {
				return createSightingAdapter();
			}
			public Object caseSlaughtered(Slaughtered object) {
				return createSlaughteredAdapter();
			}
			public Object caseDied(Died object) {
				return createDiedAdapter();
			}
			public Object caseTagRetired(TagRetired object) {
				return createTagRetiredAdapter();
			}
			public Object caseAnimalMissing(AnimalMissing object) {
				return createAnimalMissingAdapter();
			}
			public Object caseICVI(ICVI object) {
				return createICVIAdapter();
			}
			public Object caseFairRegistration(FairRegistration object) {
				return createFairRegistrationAdapter();
			}
			public Object caseWeighIn(WeighIn object) {
				return createWeighInAdapter();
			}
			public Object caseSwine(Swine object) {
				return createSwineAdapter();
			}
			public Object caseUnAppliedTags(UnAppliedTags object) {
				return createUnAppliedTagsAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Animal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Animal
	 * @generated
	 */
	public Adapter createAnimalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.AnimalId <em>Animal Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.AnimalId
	 * @generated
	 */
	public Adapter createAnimalIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Bovine <em>Bovine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Bovine
	 * @generated
	 */
	public Adapter createBovineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.TagAllocated <em>Tag Allocated</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.TagAllocated
	 * @generated
	 */
	public Adapter createTagAllocatedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Died <em>Died</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Died
	 * @generated
	 */
	public Adapter createDiedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.TagRetired <em>Tag Retired</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.TagRetired
	 * @generated
	 */
	public Adapter createTagRetiredAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.AnimalMissing <em>Animal Missing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.AnimalMissing
	 * @generated
	 */
	public Adapter createAnimalMissingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.ICVI <em>ICVI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.ICVI
	 * @generated
	 */
	public Adapter createICVIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.FairRegistration <em>Fair Registration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.FairRegistration
	 * @generated
	 */
	public Adapter createFairRegistrationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.WeighIn <em>Weigh In</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.WeighIn
	 * @generated
	 */
	public Adapter createWeighInAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Swine <em>Swine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Swine
	 * @generated
	 */
	public Adapter createSwineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.UnAppliedTags <em>Un Applied Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.UnAppliedTags
	 * @generated
	 */
	public Adapter createUnAppliedTagsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Premises <em>Premises</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Premises
	 * @generated
	 */
	public Adapter createPremisesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.EventHistory <em>Event History</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.EventHistory
	 * @generated
	 */
	public Adapter createEventHistoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Animals <em>Animals</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Animals
	 * @generated
	 */
	public Adapter createAnimalsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.BovineBeef <em>Bovine Beef</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.BovineBeef
	 * @generated
	 */
	public Adapter createBovineBeefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Ovine <em>Ovine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Ovine
	 * @generated
	 */
	public Adapter createOvineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.BovineBison <em>Bovine Bison</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.BovineBison
	 * @generated
	 */
	public Adapter createBovineBisonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.BovineDairy <em>Bovine Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.BovineDairy
	 * @generated
	 */
	public Adapter createBovineDairyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.TagApplied <em>Tag Applied</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.TagApplied
	 * @generated
	 */
	public Adapter createTagAppliedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.MovedIn <em>Moved In</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.MovedIn
	 * @generated
	 */
	public Adapter createMovedInAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.MovedOut <em>Moved Out</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.MovedOut
	 * @generated
	 */
	public Adapter createMovedOutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.LostTag <em>Lost Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.LostTag
	 * @generated
	 */
	public Adapter createLostTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.ReplacedTag <em>Replaced Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.ReplacedTag
	 * @generated
	 */
	public Adapter createReplacedTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Imported <em>Imported</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Imported
	 * @generated
	 */
	public Adapter createImportedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Exported <em>Exported</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Exported
	 * @generated
	 */
	public Adapter createExportedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Sighting <em>Sighting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Sighting
	 * @generated
	 */
	public Adapter createSightingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Slaughtered <em>Slaughtered</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Slaughtered
	 * @generated
	 */
	public Adapter createSlaughteredAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TrackerAdapterFactory
