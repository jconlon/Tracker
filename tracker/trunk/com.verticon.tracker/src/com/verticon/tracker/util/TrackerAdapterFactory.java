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

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

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
	@Override
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
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrackerSwitch<Adapter> modelSwitch =
		new TrackerSwitch<Adapter>() {
			@Override
			public Adapter caseAnimal(Animal object) {
				return createAnimalAdapter();
			}
			@Override
			public Adapter caseTag(Tag object) {
				return createTagAdapter();
			}
			@Override
			public Adapter caseBovine(Bovine object) {
				return createBovineAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseTagAllocated(TagAllocated object) {
				return createTagAllocatedAdapter();
			}
			@Override
			public Adapter casePremises(Premises object) {
				return createPremisesAdapter();
			}
			@Override
			public Adapter caseBovineBeef(BovineBeef object) {
				return createBovineBeefAdapter();
			}
			@Override
			public Adapter caseOvine(Ovine object) {
				return createOvineAdapter();
			}
			@Override
			public Adapter caseBovineBison(BovineBison object) {
				return createBovineBisonAdapter();
			}
			@Override
			public Adapter caseBovineDairy(BovineDairy object) {
				return createBovineDairyAdapter();
			}
			@Override
			public Adapter caseTagApplied(TagApplied object) {
				return createTagAppliedAdapter();
			}
			@Override
			public Adapter caseMovedIn(MovedIn object) {
				return createMovedInAdapter();
			}
			@Override
			public Adapter caseMovedOut(MovedOut object) {
				return createMovedOutAdapter();
			}
			@Override
			public Adapter caseLostTag(LostTag object) {
				return createLostTagAdapter();
			}
			@Override
			public Adapter caseReplacedTag(ReplacedTag object) {
				return createReplacedTagAdapter();
			}
			@Override
			public Adapter caseImported(Imported object) {
				return createImportedAdapter();
			}
			@Override
			public Adapter caseExported(Exported object) {
				return createExportedAdapter();
			}
			@Override
			public Adapter caseSighting(Sighting object) {
				return createSightingAdapter();
			}
			@Override
			public Adapter caseSlaughtered(Slaughtered object) {
				return createSlaughteredAdapter();
			}
			@Override
			public Adapter caseDied(Died object) {
				return createDiedAdapter();
			}
			@Override
			public Adapter caseTagRetired(TagRetired object) {
				return createTagRetiredAdapter();
			}
			@Override
			public Adapter caseAnimalMissing(AnimalMissing object) {
				return createAnimalMissingAdapter();
			}
			@Override
			public Adapter caseICVI(ICVI object) {
				return createICVIAdapter();
			}
			@Override
			public Adapter caseWeighIn(WeighIn object) {
				return createWeighInAdapter();
			}
			@Override
			public Adapter caseSwine(Swine object) {
				return createSwineAdapter();
			}
			@Override
			public Adapter caseEquine(Equine object) {
				return createEquineAdapter();
			}
			@Override
			public Adapter caseCaprine(Caprine object) {
				return createCaprineAdapter();
			}
			@Override
			public Adapter caseMedicalCondition(MedicalCondition object) {
				return createMedicalConditionAdapter();
			}
			@Override
			public Adapter caseMedicalTreatment(MedicalTreatment object) {
				return createMedicalTreatmentAdapter();
			}
			@Override
			public Adapter caseBirthing(Birthing object) {
				return createBirthingAdapter();
			}
			@Override
			public Adapter caseCalving(Calving object) {
				return createCalvingAdapter();
			}
			@Override
			public Adapter caseBirthDefect(BirthDefect object) {
				return createBirthDefectAdapter();
			}
			@Override
			public Adapter caseMastitis(Mastitis object) {
				return createMastitisAdapter();
			}
			@Override
			public Adapter caseMilkTest(MilkTest object) {
				return createMilkTestAdapter();
			}
			@Override
			public Adapter caseHerdTest(HerdTest object) {
				return createHerdTestAdapter();
			}
			@Override
			public Adapter caseGenericEvent(GenericEvent object) {
				return createGenericEventAdapter();
			}
			@Override
			public Adapter caseStringToStringMap(Map.Entry<String, String> object) {
				return createStringToStringMapAdapter();
			}
			@Override
			public Adapter caseUSBeefGrading(USBeefGrading object) {
				return createUSBeefGradingAdapter();
			}
			@Override
			public Adapter caseUSOvineGrading(USOvineGrading object) {
				return createUSOvineGradingAdapter();
			}
			@Override
			public Adapter caseUSSwineGrading(USSwineGrading object) {
				return createUSSwineGradingAdapter();
			}
			@Override
			public Adapter casePolicy(Policy object) {
				return createPolicyAdapter();
			}
			@Override
			public Adapter caseEventInclusion(EventInclusion object) {
				return createEventInclusionAdapter();
			}
			@Override
			public Adapter caseGenericEventInclusion(GenericEventInclusion object) {
				return createGenericEventInclusionAdapter();
			}
			@Override
			public Adapter casePosition(Position object) {
				return createPositionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
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
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Tag
	 * @generated
	 */
	public Adapter createTagAdapter() {
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
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Equine <em>Equine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Equine
	 * @generated
	 */
	public Adapter createEquineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Caprine <em>Caprine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Caprine
	 * @generated
	 */
	public Adapter createCaprineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.MedicalCondition <em>Medical Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.MedicalCondition
	 * @generated
	 */
	public Adapter createMedicalConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.MedicalTreatment <em>Medical Treatment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.MedicalTreatment
	 * @generated
	 */
	public Adapter createMedicalTreatmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Birthing <em>Birthing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Birthing
	 * @generated
	 */
	public Adapter createBirthingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Calving <em>Calving</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Calving
	 * @generated
	 */
	public Adapter createCalvingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.BirthDefect <em>Birth Defect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.BirthDefect
	 * @generated
	 */
	public Adapter createBirthDefectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Mastitis <em>Mastitis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Mastitis
	 * @generated
	 */
	public Adapter createMastitisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.MilkTest <em>Milk Test</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.MilkTest
	 * @generated
	 */
	public Adapter createMilkTestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.HerdTest <em>Herd Test</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.HerdTest
	 * @generated
	 */
	public Adapter createHerdTestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.GenericEvent <em>Generic Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.GenericEvent
	 * @generated
	 */
	public Adapter createGenericEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To String Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToStringMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.USBeefGrading <em>US Beef Grading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.USBeefGrading
	 * @generated
	 */
	public Adapter createUSBeefGradingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.USOvineGrading <em>US Ovine Grading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.USOvineGrading
	 * @generated
	 */
	public Adapter createUSOvineGradingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.USSwineGrading <em>US Swine Grading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.USSwineGrading
	 * @generated
	 */
	public Adapter createUSSwineGradingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Policy
	 * @generated
	 */
	public Adapter createPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.EventInclusion <em>Event Inclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.EventInclusion
	 * @generated
	 */
	public Adapter createEventInclusionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.GenericEventInclusion <em>Generic Event Inclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.GenericEventInclusion
	 * @generated
	 */
	public Adapter createGenericEventInclusionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.verticon.tracker.Position <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.verticon.tracker.Position
	 * @generated
	 */
	public Adapter createPositionAdapter() {
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
