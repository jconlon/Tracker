/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerFactory
 * @model kind="package"
 * @generated
 */
public interface TrackerPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tracker";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.verticon.com/ns/tracker/0.1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.verticon.tracker";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TrackerPackage eINSTANCE = com.verticon.tracker.impl.TrackerPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.AnimalImpl <em>Animal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.AnimalImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAnimal()
	 * @generated
	 */
	int ANIMAL = 0;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__BIRTH_DATE = 0;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SEX = 1;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__TAGS = 2;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SPECIES = 3;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__BREED = 4;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__AGE = 5;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SEX_CODE = 6;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SPECIES_CODE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__ID = 8;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__COMMENTS = 9;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__LAST_EVENT_DATE_TIME = 10;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__DAM = 11;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SIRE = 12;

	/**
	 * The number of structural features of the '<em>Animal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.TagImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTag()
	 * @generated
	 */
	int TAG = 1;

	/**
	 * The feature id for the '<em><b>Usain Number Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__USAIN_NUMBER_USED = 0;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__EVENTS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__ID = 2;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.BovineImpl <em>Bovine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.BovineImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBovine()
	 * @generated
	 */
	int BOVINE = 2;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__BIRTH_DATE = ANIMAL__BIRTH_DATE;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__SEX = ANIMAL__SEX;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__TAGS = ANIMAL__TAGS;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__SPECIES = ANIMAL__SPECIES;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__BREED = ANIMAL__BREED;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__AGE = ANIMAL__AGE;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__SEX_CODE = ANIMAL__SEX_CODE;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__SPECIES_CODE = ANIMAL__SPECIES_CODE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__ID = ANIMAL__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__COMMENTS = ANIMAL__COMMENTS;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__LAST_EVENT_DATE_TIME = ANIMAL__LAST_EVENT_DATE_TIME;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__DAM = ANIMAL__DAM;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__SIRE = ANIMAL__SIRE;

	/**
	 * The number of structural features of the '<em>Bovine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_FEATURE_COUNT = ANIMAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.EventImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 3;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DATE_TIME = 0;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__EVENT_CODE = 1;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ELECTRONICALLY_READ = 2;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__CORRECTION = 3;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__COMMENTS = 4;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TAG = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ID = 6;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.TagAllocatedImpl <em>Tag Allocated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.TagAllocatedImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTagAllocated()
	 * @generated
	 */
	int TAG_ALLOCATED = 4;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_ALLOCATED__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_ALLOCATED__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_ALLOCATED__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_ALLOCATED__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_ALLOCATED__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_ALLOCATED__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_ALLOCATED__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Tag Allocated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_ALLOCATED_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.DiedImpl <em>Died</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.DiedImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getDied()
	 * @generated
	 */
	int DIED = 19;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.TagRetiredImpl <em>Tag Retired</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.TagRetiredImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTagRetired()
	 * @generated
	 */
	int TAG_RETIRED = 20;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.AnimalMissingImpl <em>Animal Missing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.AnimalMissingImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAnimalMissing()
	 * @generated
	 */
	int ANIMAL_MISSING = 21;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.ICVIImpl <em>ICVI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.ICVIImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getICVI()
	 * @generated
	 */
	int ICVI = 22;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.PremisesImpl <em>Premises</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.PremisesImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getPremises()
	 * @generated
	 */
	int PREMISES = 5;

	/**
	 * The feature id for the '<em><b>Premises Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__PREMISES_ID = 0;

	/**
	 * The feature id for the '<em><b>Email Contact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__EMAIL_CONTACT = 1;

	/**
	 * The feature id for the '<em><b>Animals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__ANIMALS = 2;

	/**
	 * The feature id for the '<em><b>Un Applied Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__UN_APPLIED_TAGS = 3;

	/**
	 * The number of structural features of the '<em>Premises</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.BovineBeefImpl <em>Bovine Beef</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.BovineBeefImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBovineBeef()
	 * @generated
	 */
	int BOVINE_BEEF = 6;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__BIRTH_DATE = BOVINE__BIRTH_DATE;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__SEX = BOVINE__SEX;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__TAGS = BOVINE__TAGS;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__SPECIES = BOVINE__SPECIES;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__BREED = BOVINE__BREED;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__AGE = BOVINE__AGE;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__SEX_CODE = BOVINE__SEX_CODE;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__SPECIES_CODE = BOVINE__SPECIES_CODE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__ID = BOVINE__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__COMMENTS = BOVINE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__LAST_EVENT_DATE_TIME = BOVINE__LAST_EVENT_DATE_TIME;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__DAM = BOVINE__DAM;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__SIRE = BOVINE__SIRE;

	/**
	 * The feature id for the '<em><b>Beef Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__BEEF_BREED = BOVINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bovine Beef</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF_FEATURE_COUNT = BOVINE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.OvineImpl <em>Ovine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.OvineImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getOvine()
	 * @generated
	 */
	int OVINE = 7;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__BIRTH_DATE = ANIMAL__BIRTH_DATE;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__SEX = ANIMAL__SEX;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__TAGS = ANIMAL__TAGS;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__SPECIES = ANIMAL__SPECIES;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__BREED = ANIMAL__BREED;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__AGE = ANIMAL__AGE;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__SEX_CODE = ANIMAL__SEX_CODE;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__SPECIES_CODE = ANIMAL__SPECIES_CODE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__ID = ANIMAL__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__COMMENTS = ANIMAL__COMMENTS;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__LAST_EVENT_DATE_TIME = ANIMAL__LAST_EVENT_DATE_TIME;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__DAM = ANIMAL__DAM;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__SIRE = ANIMAL__SIRE;

	/**
	 * The feature id for the '<em><b>Sheep Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__SHEEP_BREED = ANIMAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ovine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE_FEATURE_COUNT = ANIMAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.BovineBisonImpl <em>Bovine Bison</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.BovineBisonImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBovineBison()
	 * @generated
	 */
	int BOVINE_BISON = 8;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__BIRTH_DATE = BOVINE__BIRTH_DATE;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__SEX = BOVINE__SEX;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__TAGS = BOVINE__TAGS;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__SPECIES = BOVINE__SPECIES;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__BREED = BOVINE__BREED;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__AGE = BOVINE__AGE;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__SEX_CODE = BOVINE__SEX_CODE;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__SPECIES_CODE = BOVINE__SPECIES_CODE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__ID = BOVINE__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__COMMENTS = BOVINE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__LAST_EVENT_DATE_TIME = BOVINE__LAST_EVENT_DATE_TIME;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__DAM = BOVINE__DAM;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__SIRE = BOVINE__SIRE;

	/**
	 * The feature id for the '<em><b>Buffalo Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__BUFFALO_BREED = BOVINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bovine Bison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON_FEATURE_COUNT = BOVINE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.BovineDairyImpl <em>Bovine Dairy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.BovineDairyImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBovineDairy()
	 * @generated
	 */
	int BOVINE_DAIRY = 9;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__BIRTH_DATE = BOVINE__BIRTH_DATE;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__SEX = BOVINE__SEX;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__TAGS = BOVINE__TAGS;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__SPECIES = BOVINE__SPECIES;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__BREED = BOVINE__BREED;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__AGE = BOVINE__AGE;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__SEX_CODE = BOVINE__SEX_CODE;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__SPECIES_CODE = BOVINE__SPECIES_CODE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__ID = BOVINE__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__COMMENTS = BOVINE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__LAST_EVENT_DATE_TIME = BOVINE__LAST_EVENT_DATE_TIME;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__DAM = BOVINE__DAM;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__SIRE = BOVINE__SIRE;

	/**
	 * The feature id for the '<em><b>Dairy Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__DAIRY_BREED = BOVINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bovine Dairy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY_FEATURE_COUNT = BOVINE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.TagAppliedImpl <em>Tag Applied</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.TagAppliedImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTagApplied()
	 * @generated
	 */
	int TAG_APPLIED = 10;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_APPLIED__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_APPLIED__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_APPLIED__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_APPLIED__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_APPLIED__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_APPLIED__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_APPLIED__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Tag Applied</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_APPLIED_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.MovedInImpl <em>Moved In</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.MovedInImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMovedIn()
	 * @generated
	 */
	int MOVED_IN = 11;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Source Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN__SOURCE_PIN = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Moved In</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_IN_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.MovedOutImpl <em>Moved Out</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.MovedOutImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMovedOut()
	 * @generated
	 */
	int MOVED_OUT = 12;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Destination Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT__DESTINATION_PIN = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Moved Out</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_OUT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.LostTagImpl <em>Lost Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.LostTagImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getLostTag()
	 * @generated
	 */
	int LOST_TAG = 13;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOST_TAG__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOST_TAG__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOST_TAG__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOST_TAG__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOST_TAG__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOST_TAG__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOST_TAG__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Lost Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOST_TAG_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.ReplacedTagImpl <em>Replaced Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.ReplacedTagImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getReplacedTag()
	 * @generated
	 */
	int REPLACED_TAG = 14;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Old Ain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__OLD_AIN = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Replaced Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.ImportedImpl <em>Imported</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.ImportedImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getImported()
	 * @generated
	 */
	int IMPORTED = 15;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Imported</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.ExportedImpl <em>Exported</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.ExportedImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getExported()
	 * @generated
	 */
	int EXPORTED = 16;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Exported</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.SightingImpl <em>Sighting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.SightingImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSighting()
	 * @generated
	 */
	int SIGHTING = 17;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING__LOCATION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sighting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGHTING_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.SlaughteredImpl <em>Slaughtered</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.SlaughteredImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSlaughtered()
	 * @generated
	 */
	int SLAUGHTERED = 18;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAUGHTERED__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAUGHTERED__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAUGHTERED__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAUGHTERED__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAUGHTERED__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAUGHTERED__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAUGHTERED__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Slaughtered</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAUGHTERED_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIED__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIED__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIED__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIED__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIED__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIED__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIED__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Died</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIED_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_RETIRED__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_RETIRED__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_RETIRED__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_RETIRED__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_RETIRED__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_RETIRED__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_RETIRED__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Tag Retired</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_RETIRED_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_MISSING__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_MISSING__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_MISSING__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_MISSING__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_MISSING__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_MISSING__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_MISSING__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Animal Missing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_MISSING_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICVI__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICVI__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICVI__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICVI__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICVI__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICVI__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICVI__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>ICVI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICVI_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.FairRegistrationImpl <em>Fair Registration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.FairRegistrationImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getFairRegistration()
	 * @generated
	 */
	int FAIR_REGISTRATION = 23;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Participant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__PARTICIPANT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__ADDRESS = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__PHONE = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__PARENT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Club</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__CLUB = EVENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sale Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__SALE_ORDER = EVENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Exhibit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION__EXHIBIT = EVENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Fair Registration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_REGISTRATION_FEATURE_COUNT = EVENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.WeighInImpl <em>Weigh In</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.WeighInImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getWeighIn()
	 * @generated
	 */
	int WEIGH_IN = 24;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__WEIGHT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__WEIGHT_GAIN_PER_DAY = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Weigh In</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.SwineImpl <em>Swine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.SwineImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSwine()
	 * @generated
	 */
	int SWINE = 25;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__BIRTH_DATE = ANIMAL__BIRTH_DATE;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__SEX = ANIMAL__SEX;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__TAGS = ANIMAL__TAGS;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__SPECIES = ANIMAL__SPECIES;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__BREED = ANIMAL__BREED;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__AGE = ANIMAL__AGE;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__SEX_CODE = ANIMAL__SEX_CODE;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__SPECIES_CODE = ANIMAL__SPECIES_CODE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__ID = ANIMAL__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__COMMENTS = ANIMAL__COMMENTS;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__LAST_EVENT_DATE_TIME = ANIMAL__LAST_EVENT_DATE_TIME;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__DAM = ANIMAL__DAM;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__SIRE = ANIMAL__SIRE;

	/**
	 * The feature id for the '<em><b>Swine Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__SWINE_BREED = ANIMAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Swine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE_FEATURE_COUNT = ANIMAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.EquineImpl <em>Equine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.EquineImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEquine()
	 * @generated
	 */
	int EQUINE = 26;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__BIRTH_DATE = ANIMAL__BIRTH_DATE;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__SEX = ANIMAL__SEX;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__TAGS = ANIMAL__TAGS;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__SPECIES = ANIMAL__SPECIES;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__BREED = ANIMAL__BREED;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__AGE = ANIMAL__AGE;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__SEX_CODE = ANIMAL__SEX_CODE;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__SPECIES_CODE = ANIMAL__SPECIES_CODE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__ID = ANIMAL__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__COMMENTS = ANIMAL__COMMENTS;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__LAST_EVENT_DATE_TIME = ANIMAL__LAST_EVENT_DATE_TIME;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__DAM = ANIMAL__DAM;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__SIRE = ANIMAL__SIRE;

	/**
	 * The feature id for the '<em><b>Horse Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__HORSE_BREED = ANIMAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Equine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE_FEATURE_COUNT = ANIMAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.CaprineImpl <em>Caprine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.CaprineImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getCaprine()
	 * @generated
	 */
	int CAPRINE = 27;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__BIRTH_DATE = ANIMAL__BIRTH_DATE;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__SEX = ANIMAL__SEX;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__TAGS = ANIMAL__TAGS;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__SPECIES = ANIMAL__SPECIES;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__BREED = ANIMAL__BREED;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__AGE = ANIMAL__AGE;

	/**
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__SEX_CODE = ANIMAL__SEX_CODE;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__SPECIES_CODE = ANIMAL__SPECIES_CODE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__ID = ANIMAL__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__COMMENTS = ANIMAL__COMMENTS;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__LAST_EVENT_DATE_TIME = ANIMAL__LAST_EVENT_DATE_TIME;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__DAM = ANIMAL__DAM;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__SIRE = ANIMAL__SIRE;

	/**
	 * The feature id for the '<em><b>Goat Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__GOAT_BREED = ANIMAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Caprine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE_FEATURE_COUNT = ANIMAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.Sex <em>Sex</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Sex
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSex()
	 * @generated
	 */
	int SEX = 28;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.BisonBreed <em>Bison Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.BisonBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBisonBreed()
	 * @generated
	 */
	int BISON_BREED = 29;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.SheepBreed <em>Sheep Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.SheepBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSheepBreed()
	 * @generated
	 */
	int SHEEP_BREED = 30;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.BeefBreed <em>Beef Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.BeefBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBeefBreed()
	 * @generated
	 */
	int BEEF_BREED = 31;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.DairyBreed <em>Dairy Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.DairyBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getDairyBreed()
	 * @generated
	 */
	int DAIRY_BREED = 32;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.SwineBreed <em>Swine Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.SwineBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSwineBreed()
	 * @generated
	 */
	int SWINE_BREED = 33;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.HorseBreed <em>Horse Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.HorseBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getHorseBreed()
	 * @generated
	 */
	int HORSE_BREED = 34;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.GoatBreed <em>Goat Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GoatBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getGoatBreed()
	 * @generated
	 */
	int GOAT_BREED = 35;

	/**
	 * The meta object id for the '<em>Animial Id Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAnimialIdNumber()
	 * @generated
	 */
	int ANIMIAL_ID_NUMBER = 36;

	/**
	 * The meta object id for the '<em>Premises Id Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getPremisesIdNumber()
	 * @generated
	 */
	int PREMISES_ID_NUMBER = 37;

	/**
	 * The meta object id for the '<em>Email</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEmail()
	 * @generated
	 */
	int EMAIL = 38;


	/**
	 * The meta object id for the '<em>Age</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.util.Age
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAge()
	 * @generated
	 */
	int AGE = 39;


	/**
	 * The meta object id for the '<em>US Phone Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSPhoneNumber()
	 * @generated
	 */
	int US_PHONE_NUMBER = 40;


	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Animal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animal</em>'.
	 * @see com.verticon.tracker.Animal
	 * @generated
	 */
	EClass getAnimal();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getBirthDate <em>Birth Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Birth Date</em>'.
	 * @see com.verticon.tracker.Animal#getBirthDate()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_BirthDate();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getSex <em>Sex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sex</em>'.
	 * @see com.verticon.tracker.Animal#getSex()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Sex();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.Animal#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see com.verticon.tracker.Animal#getTags()
	 * @see #getAnimal()
	 * @generated
	 */
	EReference getAnimal_Tags();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getSpecies <em>Species</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Species</em>'.
	 * @see com.verticon.tracker.Animal#getSpecies()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Species();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getBreed <em>Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breed</em>'.
	 * @see com.verticon.tracker.Animal#getBreed()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Breed();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see com.verticon.tracker.Animal#getAge()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Age();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getSexCode <em>Sex Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sex Code</em>'.
	 * @see com.verticon.tracker.Animal#getSexCode()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_SexCode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getSpeciesCode <em>Species Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Species Code</em>'.
	 * @see com.verticon.tracker.Animal#getSpeciesCode()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_SpeciesCode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.verticon.tracker.Animal#getId()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see com.verticon.tracker.Animal#getComments()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Comments();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getLastEventDateTime <em>Last Event Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Event Date Time</em>'.
	 * @see com.verticon.tracker.Animal#getLastEventDateTime()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_LastEventDateTime();

	/**
	 * Returns the meta object for the reference '{@link com.verticon.tracker.Animal#getDam <em>Dam</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dam</em>'.
	 * @see com.verticon.tracker.Animal#getDam()
	 * @see #getAnimal()
	 * @generated
	 */
	EReference getAnimal_Dam();

	/**
	 * Returns the meta object for the reference '{@link com.verticon.tracker.Animal#getSire <em>Sire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sire</em>'.
	 * @see com.verticon.tracker.Animal#getSire()
	 * @see #getAnimal()
	 * @generated
	 */
	EReference getAnimal_Sire();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see com.verticon.tracker.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Tag#isUsainNumberUsed <em>Usain Number Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usain Number Used</em>'.
	 * @see com.verticon.tracker.Tag#isUsainNumberUsed()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_UsainNumberUsed();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.Tag#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see com.verticon.tracker.Tag#getEvents()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_Events();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Tag#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.verticon.tracker.Tag#getId()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Id();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Bovine <em>Bovine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bovine</em>'.
	 * @see com.verticon.tracker.Bovine
	 * @generated
	 */
	EClass getBovine();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see com.verticon.tracker.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Event#getDateTime <em>Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Time</em>'.
	 * @see com.verticon.tracker.Event#getDateTime()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_DateTime();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Event#getEventCode <em>Event Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Code</em>'.
	 * @see com.verticon.tracker.Event#getEventCode()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_EventCode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Event#isElectronicallyRead <em>Electronically Read</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Electronically Read</em>'.
	 * @see com.verticon.tracker.Event#isElectronicallyRead()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_ElectronicallyRead();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Event#isCorrection <em>Correction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Correction</em>'.
	 * @see com.verticon.tracker.Event#isCorrection()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Correction();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Event#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see com.verticon.tracker.Event#getComments()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Comments();

	/**
	 * Returns the meta object for the container reference '{@link com.verticon.tracker.Event#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tag</em>'.
	 * @see com.verticon.tracker.Event#getTag()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Tag();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Event#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.verticon.tracker.Event#getId()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Id();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.TagAllocated <em>Tag Allocated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Allocated</em>'.
	 * @see com.verticon.tracker.TagAllocated
	 * @generated
	 */
	EClass getTagAllocated();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Died <em>Died</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Died</em>'.
	 * @see com.verticon.tracker.Died
	 * @generated
	 */
	EClass getDied();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.TagRetired <em>Tag Retired</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Retired</em>'.
	 * @see com.verticon.tracker.TagRetired
	 * @generated
	 */
	EClass getTagRetired();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.AnimalMissing <em>Animal Missing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animal Missing</em>'.
	 * @see com.verticon.tracker.AnimalMissing
	 * @generated
	 */
	EClass getAnimalMissing();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.ICVI <em>ICVI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ICVI</em>'.
	 * @see com.verticon.tracker.ICVI
	 * @generated
	 */
	EClass getICVI();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.FairRegistration <em>Fair Registration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fair Registration</em>'.
	 * @see com.verticon.tracker.FairRegistration
	 * @generated
	 */
	EClass getFairRegistration();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.FairRegistration#getParticipant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Participant</em>'.
	 * @see com.verticon.tracker.FairRegistration#getParticipant()
	 * @see #getFairRegistration()
	 * @generated
	 */
	EAttribute getFairRegistration_Participant();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.FairRegistration#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see com.verticon.tracker.FairRegistration#getAddress()
	 * @see #getFairRegistration()
	 * @generated
	 */
	EAttribute getFairRegistration_Address();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.FairRegistration#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see com.verticon.tracker.FairRegistration#getPhone()
	 * @see #getFairRegistration()
	 * @generated
	 */
	EAttribute getFairRegistration_Phone();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.FairRegistration#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent</em>'.
	 * @see com.verticon.tracker.FairRegistration#getParent()
	 * @see #getFairRegistration()
	 * @generated
	 */
	EAttribute getFairRegistration_Parent();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.FairRegistration#getClub <em>Club</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Club</em>'.
	 * @see com.verticon.tracker.FairRegistration#getClub()
	 * @see #getFairRegistration()
	 * @generated
	 */
	EAttribute getFairRegistration_Club();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.FairRegistration#getSaleOrder <em>Sale Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sale Order</em>'.
	 * @see com.verticon.tracker.FairRegistration#getSaleOrder()
	 * @see #getFairRegistration()
	 * @generated
	 */
	EAttribute getFairRegistration_SaleOrder();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.FairRegistration#getExhibit <em>Exhibit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exhibit</em>'.
	 * @see com.verticon.tracker.FairRegistration#getExhibit()
	 * @see #getFairRegistration()
	 * @generated
	 */
	EAttribute getFairRegistration_Exhibit();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.WeighIn <em>Weigh In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weigh In</em>'.
	 * @see com.verticon.tracker.WeighIn
	 * @generated
	 */
	EClass getWeighIn();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.WeighIn#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see com.verticon.tracker.WeighIn#getWeight()
	 * @see #getWeighIn()
	 * @generated
	 */
	EAttribute getWeighIn_Weight();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.WeighIn#getWeightGainPerDay <em>Weight Gain Per Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight Gain Per Day</em>'.
	 * @see com.verticon.tracker.WeighIn#getWeightGainPerDay()
	 * @see #getWeighIn()
	 * @generated
	 */
	EAttribute getWeighIn_WeightGainPerDay();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Swine <em>Swine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Swine</em>'.
	 * @see com.verticon.tracker.Swine
	 * @generated
	 */
	EClass getSwine();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Swine#getSwineBreed <em>Swine Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Swine Breed</em>'.
	 * @see com.verticon.tracker.Swine#getSwineBreed()
	 * @see #getSwine()
	 * @generated
	 */
	EAttribute getSwine_SwineBreed();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Equine <em>Equine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equine</em>'.
	 * @see com.verticon.tracker.Equine
	 * @generated
	 */
	EClass getEquine();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Equine#getHorseBreed <em>Horse Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horse Breed</em>'.
	 * @see com.verticon.tracker.Equine#getHorseBreed()
	 * @see #getEquine()
	 * @generated
	 */
	EAttribute getEquine_HorseBreed();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Caprine <em>Caprine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Caprine</em>'.
	 * @see com.verticon.tracker.Caprine
	 * @generated
	 */
	EClass getCaprine();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Caprine#getGoatBreed <em>Goat Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goat Breed</em>'.
	 * @see com.verticon.tracker.Caprine#getGoatBreed()
	 * @see #getCaprine()
	 * @generated
	 */
	EAttribute getCaprine_GoatBreed();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Premises <em>Premises</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Premises</em>'.
	 * @see com.verticon.tracker.Premises
	 * @generated
	 */
	EClass getPremises();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Premises#getPremisesId <em>Premises Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Premises Id</em>'.
	 * @see com.verticon.tracker.Premises#getPremisesId()
	 * @see #getPremises()
	 * @generated
	 */
	EAttribute getPremises_PremisesId();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Premises#getEmailContact <em>Email Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email Contact</em>'.
	 * @see com.verticon.tracker.Premises#getEmailContact()
	 * @see #getPremises()
	 * @generated
	 */
	EAttribute getPremises_EmailContact();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.Premises#getAnimals <em>Animals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animals</em>'.
	 * @see com.verticon.tracker.Premises#getAnimals()
	 * @see #getPremises()
	 * @generated
	 */
	EReference getPremises_Animals();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.Premises#getUnAppliedTags <em>Un Applied Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Un Applied Tags</em>'.
	 * @see com.verticon.tracker.Premises#getUnAppliedTags()
	 * @see #getPremises()
	 * @generated
	 */
	EReference getPremises_UnAppliedTags();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.BovineBeef <em>Bovine Beef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bovine Beef</em>'.
	 * @see com.verticon.tracker.BovineBeef
	 * @generated
	 */
	EClass getBovineBeef();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.BovineBeef#getBeefBreed <em>Beef Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Beef Breed</em>'.
	 * @see com.verticon.tracker.BovineBeef#getBeefBreed()
	 * @see #getBovineBeef()
	 * @generated
	 */
	EAttribute getBovineBeef_BeefBreed();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Ovine <em>Ovine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ovine</em>'.
	 * @see com.verticon.tracker.Ovine
	 * @generated
	 */
	EClass getOvine();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Ovine#getSheepBreed <em>Sheep Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sheep Breed</em>'.
	 * @see com.verticon.tracker.Ovine#getSheepBreed()
	 * @see #getOvine()
	 * @generated
	 */
	EAttribute getOvine_SheepBreed();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.BovineBison <em>Bovine Bison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bovine Bison</em>'.
	 * @see com.verticon.tracker.BovineBison
	 * @generated
	 */
	EClass getBovineBison();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.BovineBison#getBuffaloBreed <em>Buffalo Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Buffalo Breed</em>'.
	 * @see com.verticon.tracker.BovineBison#getBuffaloBreed()
	 * @see #getBovineBison()
	 * @generated
	 */
	EAttribute getBovineBison_BuffaloBreed();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.BovineDairy <em>Bovine Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bovine Dairy</em>'.
	 * @see com.verticon.tracker.BovineDairy
	 * @generated
	 */
	EClass getBovineDairy();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.BovineDairy#getDairyBreed <em>Dairy Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dairy Breed</em>'.
	 * @see com.verticon.tracker.BovineDairy#getDairyBreed()
	 * @see #getBovineDairy()
	 * @generated
	 */
	EAttribute getBovineDairy_DairyBreed();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.TagApplied <em>Tag Applied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Applied</em>'.
	 * @see com.verticon.tracker.TagApplied
	 * @generated
	 */
	EClass getTagApplied();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.MovedIn <em>Moved In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moved In</em>'.
	 * @see com.verticon.tracker.MovedIn
	 * @generated
	 */
	EClass getMovedIn();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MovedIn#getSourcePin <em>Source Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Pin</em>'.
	 * @see com.verticon.tracker.MovedIn#getSourcePin()
	 * @see #getMovedIn()
	 * @generated
	 */
	EAttribute getMovedIn_SourcePin();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.MovedOut <em>Moved Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moved Out</em>'.
	 * @see com.verticon.tracker.MovedOut
	 * @generated
	 */
	EClass getMovedOut();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MovedOut#getDestinationPin <em>Destination Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Pin</em>'.
	 * @see com.verticon.tracker.MovedOut#getDestinationPin()
	 * @see #getMovedOut()
	 * @generated
	 */
	EAttribute getMovedOut_DestinationPin();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.LostTag <em>Lost Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lost Tag</em>'.
	 * @see com.verticon.tracker.LostTag
	 * @generated
	 */
	EClass getLostTag();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.ReplacedTag <em>Replaced Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replaced Tag</em>'.
	 * @see com.verticon.tracker.ReplacedTag
	 * @generated
	 */
	EClass getReplacedTag();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.ReplacedTag#getOldAin <em>Old Ain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Ain</em>'.
	 * @see com.verticon.tracker.ReplacedTag#getOldAin()
	 * @see #getReplacedTag()
	 * @generated
	 */
	EAttribute getReplacedTag_OldAin();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Imported <em>Imported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported</em>'.
	 * @see com.verticon.tracker.Imported
	 * @generated
	 */
	EClass getImported();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Exported <em>Exported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exported</em>'.
	 * @see com.verticon.tracker.Exported
	 * @generated
	 */
	EClass getExported();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Sighting <em>Sighting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sighting</em>'.
	 * @see com.verticon.tracker.Sighting
	 * @generated
	 */
	EClass getSighting();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Sighting#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.verticon.tracker.Sighting#getLocation()
	 * @see #getSighting()
	 * @generated
	 */
	EAttribute getSighting_Location();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Slaughtered <em>Slaughtered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slaughtered</em>'.
	 * @see com.verticon.tracker.Slaughtered
	 * @generated
	 */
	EClass getSlaughtered();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.Sex <em>Sex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sex</em>'.
	 * @see com.verticon.tracker.Sex
	 * @generated
	 */
	EEnum getSex();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.BisonBreed <em>Bison Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Bison Breed</em>'.
	 * @see com.verticon.tracker.BisonBreed
	 * @generated
	 */
	EEnum getBisonBreed();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.SheepBreed <em>Sheep Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sheep Breed</em>'.
	 * @see com.verticon.tracker.SheepBreed
	 * @generated
	 */
	EEnum getSheepBreed();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.BeefBreed <em>Beef Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Beef Breed</em>'.
	 * @see com.verticon.tracker.BeefBreed
	 * @generated
	 */
	EEnum getBeefBreed();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.DairyBreed <em>Dairy Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dairy Breed</em>'.
	 * @see com.verticon.tracker.DairyBreed
	 * @generated
	 */
	EEnum getDairyBreed();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.SwineBreed <em>Swine Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Swine Breed</em>'.
	 * @see com.verticon.tracker.SwineBreed
	 * @generated
	 */
	EEnum getSwineBreed();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.HorseBreed <em>Horse Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Horse Breed</em>'.
	 * @see com.verticon.tracker.HorseBreed
	 * @generated
	 */
	EEnum getHorseBreed();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.GoatBreed <em>Goat Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Goat Breed</em>'.
	 * @see com.verticon.tracker.GoatBreed
	 * @generated
	 */
	EEnum getGoatBreed();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Animial Id Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Animial Id Number</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="minLength='15' maxLength='15'"
	 * @generated
	 */
	EDataType getAnimialIdNumber();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Premises Id Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Premises Id Number</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="minLength='7' maxLength='7' length='7' maxExclusive='adcdefg'"
	 * @generated
	 */
	EDataType getPremisesIdNumber();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Email</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getEmail();

	/**
	 * Returns the meta object for data type '{@link com.verticon.tracker.util.Age <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Age</em>'.
	 * @see com.verticon.tracker.util.Age
	 * @model instanceClass="com.verticon.tracker.util.Age"
	 * @generated
	 */
	EDataType getAge();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>US Phone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>US Phone Number</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getUSPhoneNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TrackerFactory getTrackerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.AnimalImpl <em>Animal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.AnimalImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAnimal()
		 * @generated
		 */
		EClass ANIMAL = eINSTANCE.getAnimal();

		/**
		 * The meta object literal for the '<em><b>Birth Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__BIRTH_DATE = eINSTANCE.getAnimal_BirthDate();

		/**
		 * The meta object literal for the '<em><b>Sex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__SEX = eINSTANCE.getAnimal_Sex();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL__TAGS = eINSTANCE.getAnimal_Tags();

		/**
		 * The meta object literal for the '<em><b>Species</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__SPECIES = eINSTANCE.getAnimal_Species();

		/**
		 * The meta object literal for the '<em><b>Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__BREED = eINSTANCE.getAnimal_Breed();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__AGE = eINSTANCE.getAnimal_Age();

		/**
		 * The meta object literal for the '<em><b>Sex Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__SEX_CODE = eINSTANCE.getAnimal_SexCode();

		/**
		 * The meta object literal for the '<em><b>Species Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__SPECIES_CODE = eINSTANCE.getAnimal_SpeciesCode();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__ID = eINSTANCE.getAnimal_Id();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__COMMENTS = eINSTANCE.getAnimal_Comments();

		/**
		 * The meta object literal for the '<em><b>Last Event Date Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__LAST_EVENT_DATE_TIME = eINSTANCE.getAnimal_LastEventDateTime();

		/**
		 * The meta object literal for the '<em><b>Dam</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL__DAM = eINSTANCE.getAnimal_Dam();

		/**
		 * The meta object literal for the '<em><b>Sire</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL__SIRE = eINSTANCE.getAnimal_Sire();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.TagImpl <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.TagImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Usain Number Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__USAIN_NUMBER_USED = eINSTANCE.getTag_UsainNumberUsed();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG__EVENTS = eINSTANCE.getTag_Events();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__ID = eINSTANCE.getTag_Id();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.BovineImpl <em>Bovine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.BovineImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBovine()
		 * @generated
		 */
		EClass BOVINE = eINSTANCE.getBovine();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.EventImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Date Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__DATE_TIME = eINSTANCE.getEvent_DateTime();

		/**
		 * The meta object literal for the '<em><b>Event Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__EVENT_CODE = eINSTANCE.getEvent_EventCode();

		/**
		 * The meta object literal for the '<em><b>Electronically Read</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__ELECTRONICALLY_READ = eINSTANCE.getEvent_ElectronicallyRead();

		/**
		 * The meta object literal for the '<em><b>Correction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__CORRECTION = eINSTANCE.getEvent_Correction();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__COMMENTS = eINSTANCE.getEvent_Comments();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__TAG = eINSTANCE.getEvent_Tag();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__ID = eINSTANCE.getEvent_Id();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.TagAllocatedImpl <em>Tag Allocated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.TagAllocatedImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTagAllocated()
		 * @generated
		 */
		EClass TAG_ALLOCATED = eINSTANCE.getTagAllocated();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.DiedImpl <em>Died</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.DiedImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getDied()
		 * @generated
		 */
		EClass DIED = eINSTANCE.getDied();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.TagRetiredImpl <em>Tag Retired</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.TagRetiredImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTagRetired()
		 * @generated
		 */
		EClass TAG_RETIRED = eINSTANCE.getTagRetired();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.AnimalMissingImpl <em>Animal Missing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.AnimalMissingImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAnimalMissing()
		 * @generated
		 */
		EClass ANIMAL_MISSING = eINSTANCE.getAnimalMissing();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.ICVIImpl <em>ICVI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.ICVIImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getICVI()
		 * @generated
		 */
		EClass ICVI = eINSTANCE.getICVI();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.FairRegistrationImpl <em>Fair Registration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.FairRegistrationImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getFairRegistration()
		 * @generated
		 */
		EClass FAIR_REGISTRATION = eINSTANCE.getFairRegistration();

		/**
		 * The meta object literal for the '<em><b>Participant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIR_REGISTRATION__PARTICIPANT = eINSTANCE.getFairRegistration_Participant();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIR_REGISTRATION__ADDRESS = eINSTANCE.getFairRegistration_Address();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIR_REGISTRATION__PHONE = eINSTANCE.getFairRegistration_Phone();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIR_REGISTRATION__PARENT = eINSTANCE.getFairRegistration_Parent();

		/**
		 * The meta object literal for the '<em><b>Club</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIR_REGISTRATION__CLUB = eINSTANCE.getFairRegistration_Club();

		/**
		 * The meta object literal for the '<em><b>Sale Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIR_REGISTRATION__SALE_ORDER = eINSTANCE.getFairRegistration_SaleOrder();

		/**
		 * The meta object literal for the '<em><b>Exhibit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIR_REGISTRATION__EXHIBIT = eINSTANCE.getFairRegistration_Exhibit();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.WeighInImpl <em>Weigh In</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.WeighInImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getWeighIn()
		 * @generated
		 */
		EClass WEIGH_IN = eINSTANCE.getWeighIn();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEIGH_IN__WEIGHT = eINSTANCE.getWeighIn_Weight();

		/**
		 * The meta object literal for the '<em><b>Weight Gain Per Day</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEIGH_IN__WEIGHT_GAIN_PER_DAY = eINSTANCE.getWeighIn_WeightGainPerDay();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.SwineImpl <em>Swine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.SwineImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSwine()
		 * @generated
		 */
		EClass SWINE = eINSTANCE.getSwine();

		/**
		 * The meta object literal for the '<em><b>Swine Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWINE__SWINE_BREED = eINSTANCE.getSwine_SwineBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.EquineImpl <em>Equine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.EquineImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEquine()
		 * @generated
		 */
		EClass EQUINE = eINSTANCE.getEquine();

		/**
		 * The meta object literal for the '<em><b>Horse Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUINE__HORSE_BREED = eINSTANCE.getEquine_HorseBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.CaprineImpl <em>Caprine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.CaprineImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getCaprine()
		 * @generated
		 */
		EClass CAPRINE = eINSTANCE.getCaprine();

		/**
		 * The meta object literal for the '<em><b>Goat Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPRINE__GOAT_BREED = eINSTANCE.getCaprine_GoatBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.PremisesImpl <em>Premises</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.PremisesImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getPremises()
		 * @generated
		 */
		EClass PREMISES = eINSTANCE.getPremises();

		/**
		 * The meta object literal for the '<em><b>Premises Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREMISES__PREMISES_ID = eINSTANCE.getPremises_PremisesId();

		/**
		 * The meta object literal for the '<em><b>Email Contact</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREMISES__EMAIL_CONTACT = eINSTANCE.getPremises_EmailContact();

		/**
		 * The meta object literal for the '<em><b>Animals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREMISES__ANIMALS = eINSTANCE.getPremises_Animals();

		/**
		 * The meta object literal for the '<em><b>Un Applied Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREMISES__UN_APPLIED_TAGS = eINSTANCE.getPremises_UnAppliedTags();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.BovineBeefImpl <em>Bovine Beef</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.BovineBeefImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBovineBeef()
		 * @generated
		 */
		EClass BOVINE_BEEF = eINSTANCE.getBovineBeef();

		/**
		 * The meta object literal for the '<em><b>Beef Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOVINE_BEEF__BEEF_BREED = eINSTANCE.getBovineBeef_BeefBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.OvineImpl <em>Ovine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.OvineImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getOvine()
		 * @generated
		 */
		EClass OVINE = eINSTANCE.getOvine();

		/**
		 * The meta object literal for the '<em><b>Sheep Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVINE__SHEEP_BREED = eINSTANCE.getOvine_SheepBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.BovineBisonImpl <em>Bovine Bison</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.BovineBisonImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBovineBison()
		 * @generated
		 */
		EClass BOVINE_BISON = eINSTANCE.getBovineBison();

		/**
		 * The meta object literal for the '<em><b>Buffalo Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOVINE_BISON__BUFFALO_BREED = eINSTANCE.getBovineBison_BuffaloBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.BovineDairyImpl <em>Bovine Dairy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.BovineDairyImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBovineDairy()
		 * @generated
		 */
		EClass BOVINE_DAIRY = eINSTANCE.getBovineDairy();

		/**
		 * The meta object literal for the '<em><b>Dairy Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOVINE_DAIRY__DAIRY_BREED = eINSTANCE.getBovineDairy_DairyBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.TagAppliedImpl <em>Tag Applied</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.TagAppliedImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTagApplied()
		 * @generated
		 */
		EClass TAG_APPLIED = eINSTANCE.getTagApplied();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.MovedInImpl <em>Moved In</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.MovedInImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMovedIn()
		 * @generated
		 */
		EClass MOVED_IN = eINSTANCE.getMovedIn();

		/**
		 * The meta object literal for the '<em><b>Source Pin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVED_IN__SOURCE_PIN = eINSTANCE.getMovedIn_SourcePin();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.MovedOutImpl <em>Moved Out</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.MovedOutImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMovedOut()
		 * @generated
		 */
		EClass MOVED_OUT = eINSTANCE.getMovedOut();

		/**
		 * The meta object literal for the '<em><b>Destination Pin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVED_OUT__DESTINATION_PIN = eINSTANCE.getMovedOut_DestinationPin();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.LostTagImpl <em>Lost Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.LostTagImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getLostTag()
		 * @generated
		 */
		EClass LOST_TAG = eINSTANCE.getLostTag();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.ReplacedTagImpl <em>Replaced Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.ReplacedTagImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getReplacedTag()
		 * @generated
		 */
		EClass REPLACED_TAG = eINSTANCE.getReplacedTag();

		/**
		 * The meta object literal for the '<em><b>Old Ain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACED_TAG__OLD_AIN = eINSTANCE.getReplacedTag_OldAin();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.ImportedImpl <em>Imported</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.ImportedImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getImported()
		 * @generated
		 */
		EClass IMPORTED = eINSTANCE.getImported();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.ExportedImpl <em>Exported</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.ExportedImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getExported()
		 * @generated
		 */
		EClass EXPORTED = eINSTANCE.getExported();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.SightingImpl <em>Sighting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.SightingImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSighting()
		 * @generated
		 */
		EClass SIGHTING = eINSTANCE.getSighting();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGHTING__LOCATION = eINSTANCE.getSighting_Location();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.SlaughteredImpl <em>Slaughtered</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.SlaughteredImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSlaughtered()
		 * @generated
		 */
		EClass SLAUGHTERED = eINSTANCE.getSlaughtered();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.Sex <em>Sex</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.Sex
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSex()
		 * @generated
		 */
		EEnum SEX = eINSTANCE.getSex();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.BisonBreed <em>Bison Breed</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.BisonBreed
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBisonBreed()
		 * @generated
		 */
		EEnum BISON_BREED = eINSTANCE.getBisonBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.SheepBreed <em>Sheep Breed</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.SheepBreed
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSheepBreed()
		 * @generated
		 */
		EEnum SHEEP_BREED = eINSTANCE.getSheepBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.BeefBreed <em>Beef Breed</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.BeefBreed
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBeefBreed()
		 * @generated
		 */
		EEnum BEEF_BREED = eINSTANCE.getBeefBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.DairyBreed <em>Dairy Breed</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.DairyBreed
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getDairyBreed()
		 * @generated
		 */
		EEnum DAIRY_BREED = eINSTANCE.getDairyBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.SwineBreed <em>Swine Breed</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.SwineBreed
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSwineBreed()
		 * @generated
		 */
		EEnum SWINE_BREED = eINSTANCE.getSwineBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.HorseBreed <em>Horse Breed</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.HorseBreed
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getHorseBreed()
		 * @generated
		 */
		EEnum HORSE_BREED = eINSTANCE.getHorseBreed();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.GoatBreed <em>Goat Breed</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.GoatBreed
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getGoatBreed()
		 * @generated
		 */
		EEnum GOAT_BREED = eINSTANCE.getGoatBreed();

		/**
		 * The meta object literal for the '<em>Animial Id Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAnimialIdNumber()
		 * @generated
		 */
		EDataType ANIMIAL_ID_NUMBER = eINSTANCE.getAnimialIdNumber();

		/**
		 * The meta object literal for the '<em>Premises Id Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getPremisesIdNumber()
		 * @generated
		 */
		EDataType PREMISES_ID_NUMBER = eINSTANCE.getPremisesIdNumber();

		/**
		 * The meta object literal for the '<em>Email</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEmail()
		 * @generated
		 */
		EDataType EMAIL = eINSTANCE.getEmail();

		/**
		 * The meta object literal for the '<em>Age</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.util.Age
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAge()
		 * @generated
		 */
		EDataType AGE = eINSTANCE.getAge();

		/**
		 * The meta object literal for the '<em>US Phone Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSPhoneNumber()
		 * @generated
		 */
		EDataType US_PHONE_NUMBER = eINSTANCE.getUSPhoneNumber();

	}

} //TrackerPackage
