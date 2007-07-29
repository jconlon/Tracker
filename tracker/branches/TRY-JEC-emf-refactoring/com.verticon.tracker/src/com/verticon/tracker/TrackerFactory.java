/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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
	 * Returns a new object of class '<em>Fair Registration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fair Registration</em>'.
	 * @generated
	 */
	FairRegistration createFairRegistration();

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
