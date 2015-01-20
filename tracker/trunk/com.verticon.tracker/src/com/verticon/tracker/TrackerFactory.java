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
package com.verticon.tracker;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage
 * @generated
 */
public interface TrackerFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TrackerFactory eINSTANCE = com.verticon.tracker.impl.TrackerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag</em>'.
	 * @generated
	 */
	Tag createTag();

	/**
	 * Returns a new object of class '<em>Tag Allocated</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag Allocated</em>'.
	 * @generated
	 */
	TagAllocated createTagAllocated();

	/**
	 * Returns a new object of class '<em>Died</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Died</em>'.
	 * @generated
	 */
	Died createDied();

	/**
	 * Returns a new object of class '<em>Tag Retired</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag Retired</em>'.
	 * @generated
	 */
	TagRetired createTagRetired();

	/**
	 * Returns a new object of class '<em>Animal Missing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Animal Missing</em>'.
	 * @generated
	 */
	AnimalMissing createAnimalMissing();

	/**
	 * Returns a new object of class '<em>ICVI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ICVI</em>'.
	 * @generated
	 */
	ICVI createICVI();

	/**
	 * Returns a new object of class '<em>Weigh In</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Weigh In</em>'.
	 * @generated
	 */
	WeighIn createWeighIn();

	/**
	 * Returns a new object of class '<em>Swine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Swine</em>'.
	 * @generated
	 */
	Swine createSwine();

	/**
	 * Returns a new object of class '<em>Equine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equine</em>'.
	 * @generated
	 */
	Equine createEquine();

	/**
	 * Returns a new object of class '<em>Caprine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Caprine</em>'.
	 * @generated
	 */
	Caprine createCaprine();

	/**
	 * Returns a new object of class '<em>Medical Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Medical Condition</em>'.
	 * @generated
	 */
	MedicalCondition createMedicalCondition();

	/**
	 * Returns a new object of class '<em>Medical Treatment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Medical Treatment</em>'.
	 * @generated
	 */
	MedicalTreatment createMedicalTreatment();

	/**
	 * Returns a new object of class '<em>Birthing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Birthing</em>'.
	 * @generated
	 */
	Birthing createBirthing();

	/**
	 * Returns a new object of class '<em>Calving</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Calving</em>'.
	 * @generated
	 */
	Calving createCalving();

	/**
	 * Returns a new object of class '<em>Birth Defect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Birth Defect</em>'.
	 * @generated
	 */
	BirthDefect createBirthDefect();

	/**
	 * Returns a new object of class '<em>Mastitis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mastitis</em>'.
	 * @generated
	 */
	Mastitis createMastitis();

	/**
	 * Returns a new object of class '<em>Milk Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Milk Test</em>'.
	 * @generated
	 */
	MilkTest createMilkTest();

	/**
	 * Returns a new object of class '<em>Herd Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Herd Test</em>'.
	 * @generated
	 */
	HerdTest createHerdTest();

	/**
	 * Returns a new object of class '<em>Generic Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Event</em>'.
	 * @generated
	 */
	GenericEvent createGenericEvent();

	/**
	 * Returns a new object of class '<em>US Beef Grading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>US Beef Grading</em>'.
	 * @generated
	 */
	USBeefGrading createUSBeefGrading();

	/**
	 * Returns a new object of class '<em>US Ovine Grading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>US Ovine Grading</em>'.
	 * @generated
	 */
	USOvineGrading createUSOvineGrading();

	/**
	 * Returns a new object of class '<em>US Swine Grading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>US Swine Grading</em>'.
	 * @generated
	 */
	USSwineGrading createUSSwineGrading();

	/**
	 * Returns a new object of class '<em>Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Policy</em>'.
	 * @generated
	 */
	Policy createPolicy();

	/**
	 * Returns a new object of class '<em>Event Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Inclusion</em>'.
	 * @generated
	 */
	EventInclusion createEventInclusion();

	/**
	 * Returns a new object of class '<em>Generic Event Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Event Inclusion</em>'.
	 * @generated
	 */
	GenericEventInclusion createGenericEventInclusion();

	/**
	 * Returns a new object of class '<em>Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Position</em>'.
	 * @generated
	 */
	Position createPosition();

	/**
	 * Returns a new object of class '<em>Station</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Station</em>'.
	 * @generated
	 */
	Station createStation();

	/**
	 * Returns a new object of class '<em>Wind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wind</em>'.
	 * @generated
	 */
	Wind createWind();

	/**
	 * Returns a new object of class '<em>Station Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Station Location</em>'.
	 * @generated
	 */
	StationLocation createStationLocation();

	/**
	 * Returns a new object of class '<em>Air</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Air</em>'.
	 * @generated
	 */
	Air createAir();

	/**
	 * Returns a new object of class '<em>Light</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Light</em>'.
	 * @generated
	 */
	Light createLight();

	/**
	 * Returns a new object of class '<em>Orientation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Orientation</em>'.
	 * @generated
	 */
	Orientation createOrientation();

	/**
	 * Returns a new object of class '<em>Premises</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premises</em>'.
	 * @generated
	 */
	Premises createPremises();

	/**
	 * Returns a new object of class '<em>Bovine Beef</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bovine Beef</em>'.
	 * @generated
	 */
	BovineBeef createBovineBeef();

	/**
	 * Returns a new object of class '<em>Ovine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ovine</em>'.
	 * @generated
	 */
	Ovine createOvine();

	/**
	 * Returns a new object of class '<em>Bovine Bison</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bovine Bison</em>'.
	 * @generated
	 */
	BovineBison createBovineBison();

	/**
	 * Returns a new object of class '<em>Bovine Dairy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bovine Dairy</em>'.
	 * @generated
	 */
	BovineDairy createBovineDairy();

	/**
	 * Returns a new object of class '<em>Tag Applied</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag Applied</em>'.
	 * @generated
	 */
	TagApplied createTagApplied();

	/**
	 * Returns a new object of class '<em>Moved In</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Moved In</em>'.
	 * @generated
	 */
	MovedIn createMovedIn();

	/**
	 * Returns a new object of class '<em>Moved Out</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Moved Out</em>'.
	 * @generated
	 */
	MovedOut createMovedOut();

	/**
	 * Returns a new object of class '<em>Lost Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lost Tag</em>'.
	 * @generated
	 */
	LostTag createLostTag();

	/**
	 * Returns a new object of class '<em>Replaced Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replaced Tag</em>'.
	 * @generated
	 */
	ReplacedTag createReplacedTag();

	/**
	 * Returns a new object of class '<em>Imported</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imported</em>'.
	 * @generated
	 */
	Imported createImported();

	/**
	 * Returns a new object of class '<em>Exported</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exported</em>'.
	 * @generated
	 */
	Exported createExported();

	/**
	 * Returns a new object of class '<em>Sighting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sighting</em>'.
	 * @generated
	 */
	Sighting createSighting();

	/**
	 * Returns a new object of class '<em>Slaughtered</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slaughtered</em>'.
	 * @generated
	 */
	Slaughtered createSlaughtered();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TrackerPackage getTrackerPackage();

} //TrackerFactory
