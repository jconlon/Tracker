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
	 * The feature id for the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SEX_CODE = 5;

	/**
	 * The feature id for the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SPECIES_CODE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__ID = 7;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__COMMENTS = 8;

	/**
	 * The feature id for the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__LAST_EVENT_DATE_TIME = 9;

	/**
	 * The feature id for the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__DAM = 10;

	/**
	 * The feature id for the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__SIRE = 11;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__WEIGHT = 12;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__WEIGHT_GAIN_PER_DAY = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__TYPE = 14;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__VISUAL_ID = 15;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__AGE_IN_DAYS = 16;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__ALTERNATIVE_ID = 17;

	/**
	 * The number of structural features of the '<em>Animal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_FEATURE_COUNT = 18;

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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__WEIGHT = ANIMAL__WEIGHT;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__WEIGHT_GAIN_PER_DAY = ANIMAL__WEIGHT_GAIN_PER_DAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__TYPE = ANIMAL__TYPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__VISUAL_ID = ANIMAL__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__AGE_IN_DAYS = ANIMAL__AGE_IN_DAYS;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE__ALTERNATIVE_ID = ANIMAL__ALTERNATIVE_ID;

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
	 * The feature id for the '<em><b>Locations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__LOCATIONS = 4;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__URI = 5;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__SCHEMA = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES__NAME = 7;

	/**
	 * The number of structural features of the '<em>Premises</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREMISES_FEATURE_COUNT = 8;

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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__WEIGHT = BOVINE__WEIGHT;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__WEIGHT_GAIN_PER_DAY = BOVINE__WEIGHT_GAIN_PER_DAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__TYPE = BOVINE__TYPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__VISUAL_ID = BOVINE__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__AGE_IN_DAYS = BOVINE__AGE_IN_DAYS;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BEEF__ALTERNATIVE_ID = BOVINE__ALTERNATIVE_ID;

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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__WEIGHT = ANIMAL__WEIGHT;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__WEIGHT_GAIN_PER_DAY = ANIMAL__WEIGHT_GAIN_PER_DAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__TYPE = ANIMAL__TYPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__VISUAL_ID = ANIMAL__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__AGE_IN_DAYS = ANIMAL__AGE_IN_DAYS;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__ALTERNATIVE_ID = ANIMAL__ALTERNATIVE_ID;

	/**
	 * The feature id for the '<em><b>Sheep Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__SHEEP_BREED = ANIMAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scrapie Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE__SCRAPIE_TAG = ANIMAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ovine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVINE_FEATURE_COUNT = ANIMAL_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__WEIGHT = BOVINE__WEIGHT;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__WEIGHT_GAIN_PER_DAY = BOVINE__WEIGHT_GAIN_PER_DAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__TYPE = BOVINE__TYPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__VISUAL_ID = BOVINE__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__AGE_IN_DAYS = BOVINE__AGE_IN_DAYS;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_BISON__ALTERNATIVE_ID = BOVINE__ALTERNATIVE_ID;

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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__WEIGHT = BOVINE__WEIGHT;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__WEIGHT_GAIN_PER_DAY = BOVINE__WEIGHT_GAIN_PER_DAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__TYPE = BOVINE__TYPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__VISUAL_ID = BOVINE__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__AGE_IN_DAYS = BOVINE__AGE_IN_DAYS;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOVINE_DAIRY__ALTERNATIVE_ID = BOVINE__ALTERNATIVE_ID;

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
	 * The feature id for the '<em><b>Old Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__OLD_ID = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usain Number Used For Old Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Old Tag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG__OLD_TAG = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Replaced Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACED_TAG_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Location</b></em>' reference.
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
	 * The meta object id for the '{@link com.verticon.tracker.impl.WeighInImpl <em>Weigh In</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.WeighInImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getWeighIn()
	 * @generated
	 */
	int WEIGH_IN = 23;

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
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN__UNIT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Weigh In</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIGH_IN_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.SwineImpl <em>Swine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.SwineImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSwine()
	 * @generated
	 */
	int SWINE = 24;

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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__WEIGHT = ANIMAL__WEIGHT;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__WEIGHT_GAIN_PER_DAY = ANIMAL__WEIGHT_GAIN_PER_DAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__TYPE = ANIMAL__TYPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__VISUAL_ID = ANIMAL__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__AGE_IN_DAYS = ANIMAL__AGE_IN_DAYS;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__ALTERNATIVE_ID = ANIMAL__ALTERNATIVE_ID;

	/**
	 * The feature id for the '<em><b>Swine Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__SWINE_BREED = ANIMAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Ear Notching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__RIGHT_EAR_NOTCHING = ANIMAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Left Ear Notching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE__LEFT_EAR_NOTCHING = ANIMAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Swine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWINE_FEATURE_COUNT = ANIMAL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.EquineImpl <em>Equine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.EquineImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEquine()
	 * @generated
	 */
	int EQUINE = 25;

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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__WEIGHT = ANIMAL__WEIGHT;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__WEIGHT_GAIN_PER_DAY = ANIMAL__WEIGHT_GAIN_PER_DAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__TYPE = ANIMAL__TYPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__VISUAL_ID = ANIMAL__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__AGE_IN_DAYS = ANIMAL__AGE_IN_DAYS;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUINE__ALTERNATIVE_ID = ANIMAL__ALTERNATIVE_ID;

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
	int CAPRINE = 26;

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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__WEIGHT = ANIMAL__WEIGHT;

	/**
	 * The feature id for the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__WEIGHT_GAIN_PER_DAY = ANIMAL__WEIGHT_GAIN_PER_DAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__TYPE = ANIMAL__TYPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__VISUAL_ID = ANIMAL__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__AGE_IN_DAYS = ANIMAL__AGE_IN_DAYS;

	/**
	 * The feature id for the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRINE__ALTERNATIVE_ID = ANIMAL__ALTERNATIVE_ID;

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
	 * The meta object id for the '{@link com.verticon.tracker.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.LocationImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.MedicalConditionImpl <em>Medical Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.MedicalConditionImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMedicalCondition()
	 * @generated
	 */
	int MEDICAL_CONDITION = 28;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_CONDITION__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_CONDITION__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_CONDITION__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_CONDITION__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_CONDITION__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_CONDITION__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_CONDITION__ID = EVENT__ID;

	/**
	 * The number of structural features of the '<em>Medical Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_CONDITION_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.MedicalTreatmentImpl <em>Medical Treatment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.MedicalTreatmentImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMedicalTreatment()
	 * @generated
	 */
	int MEDICAL_TREATMENT = 29;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__NAME = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__PRODUCT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__MANUFACTURER = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__LOT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__QUANTITY = EVENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Treatment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__TREATMENT = EVENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT__METHOD = EVENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Medical Treatment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDICAL_TREATMENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.BirthingImpl <em>Birthing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.BirthingImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBirthing()
	 * @generated
	 */
	int BIRTHING = 30;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Viability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__VIABILITY = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assisted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__ASSISTED = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Difficulty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING__DIFFICULTY = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Birthing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTHING_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.CalvingImpl <em>Calving</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.CalvingImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getCalving()
	 * @generated
	 */
	int CALVING = 31;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__DATE_TIME = BIRTHING__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__EVENT_CODE = BIRTHING__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__ELECTRONICALLY_READ = BIRTHING__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__CORRECTION = BIRTHING__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__COMMENTS = BIRTHING__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__TAG = BIRTHING__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__ID = BIRTHING__ID;

	/**
	 * The feature id for the '<em><b>Viability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__VIABILITY = BIRTHING__VIABILITY;

	/**
	 * The feature id for the '<em><b>Assisted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__ASSISTED = BIRTHING__ASSISTED;

	/**
	 * The feature id for the '<em><b>Difficulty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING__DIFFICULTY = BIRTHING__DIFFICULTY;

	/**
	 * The number of structural features of the '<em>Calving</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALVING_FEATURE_COUNT = BIRTHING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.BirthDefectImpl <em>Birth Defect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.BirthDefectImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBirthDefect()
	 * @generated
	 */
	int BIRTH_DEFECT = 32;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Freemartin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT__FREEMARTIN = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Birth Defect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIRTH_DEFECT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.MastitisImpl <em>Mastitis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.MastitisImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMastitis()
	 * @generated
	 */
	int MASTITIS = 33;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__DATE_TIME = MEDICAL_CONDITION__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__EVENT_CODE = MEDICAL_CONDITION__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__ELECTRONICALLY_READ = MEDICAL_CONDITION__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__CORRECTION = MEDICAL_CONDITION__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__COMMENTS = MEDICAL_CONDITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__TAG = MEDICAL_CONDITION__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__ID = MEDICAL_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__LOCATION = MEDICAL_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS__ORIGIN = MEDICAL_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mastitis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTITIS_FEATURE_COUNT = MEDICAL_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.MilkTestImpl <em>Milk Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.MilkTestImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMilkTest()
	 * @generated
	 */
	int MILK_TEST = 34;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Pounds Produced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__POUNDS_PRODUCED = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Percent Butter Fat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__PERCENT_BUTTER_FAT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Percent Protein</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__PERCENT_PROTEIN = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Somatic Cell Counts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__SOMATIC_CELL_COUNTS = EVENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Other Solids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST__OTHER_SOLIDS = EVENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Milk Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_TEST_FEATURE_COUNT = EVENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.HerdTestImpl <em>Herd Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.HerdTestImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getHerdTest()
	 * @generated
	 */
	int HERD_TEST = 35;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Pregnant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__PREGNANT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Days Since Bred Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__DAYS_SINCE_BRED_ESTIMATE = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bred Date Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST__BRED_DATE_ESTIMATE = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Herd Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HERD_TEST_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.GenericEventImpl <em>Generic Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.GenericEventImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getGenericEvent()
	 * @generated
	 */
	int GENERIC_EVENT = 36;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Event Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__EVENT_ATTRIBUTES = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT__EVENT_SCHEMA = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Generic Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.EventAttributeImpl <em>Event Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.EventAttributeImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEventAttribute()
	 * @generated
	 */
	int EVENT_ATTRIBUTE = 37;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ATTRIBUTE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ATTRIBUTE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Event Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.EventSchemaImpl <em>Event Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.EventSchemaImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEventSchema()
	 * @generated
	 */
	int EVENT_SCHEMA = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCHEMA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCHEMA__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Animal Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCHEMA__ANIMAL_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Event Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCHEMA__EVENT_ATTRIBUTES = 3;

	/**
	 * The number of structural features of the '<em>Event Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SCHEMA_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.EventAttributeSchemaImpl <em>Event Attribute Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.EventAttributeSchemaImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEventAttributeSchema()
	 * @generated
	 */
	int EVENT_ATTRIBUTE_SCHEMA = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ATTRIBUTE_SCHEMA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ATTRIBUTE_SCHEMA__DATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ATTRIBUTE_SCHEMA__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Event Attribute Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ATTRIBUTE_SCHEMA_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.SchemaImpl <em>Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.SchemaImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSchema()
	 * @generated
	 */
	int SCHEMA = 40;

	/**
	 * The feature id for the '<em><b>Event Schemas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA__EVENT_SCHEMAS = 0;

	/**
	 * The number of structural features of the '<em>Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.USBeefGradingImpl <em>US Beef Grading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.USBeefGradingImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSBeefGrading()
	 * @generated
	 */
	int US_BEEF_GRADING = 41;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Quality Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__QUALITY_GRADE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Quality Grade Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__QUALITY_GRADE_LEVEL = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Yield Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING__YIELD_GRADE = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>US Beef Grading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_BEEF_GRADING_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.USOvineGradingImpl <em>US Ovine Grading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.USOvineGradingImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSOvineGrading()
	 * @generated
	 */
	int US_OVINE_GRADING = 42;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Quality Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__QUALITY_GRADE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Quality Grade Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING__QUALITY_GRADE_LEVEL = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>US Ovine Grading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_OVINE_GRADING_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.impl.USSwineGradingImpl <em>US Swine Grading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.impl.USSwineGradingImpl
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSSwineGrading()
	 * @generated
	 */
	int US_SWINE_GRADING = 43;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING__DATE_TIME = EVENT__DATE_TIME;

	/**
	 * The feature id for the '<em><b>Event Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING__EVENT_CODE = EVENT__EVENT_CODE;

	/**
	 * The feature id for the '<em><b>Electronically Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING__ELECTRONICALLY_READ = EVENT__ELECTRONICALLY_READ;

	/**
	 * The feature id for the '<em><b>Correction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING__CORRECTION = EVENT__CORRECTION;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING__COMMENTS = EVENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING__TAG = EVENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Quality Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING__QUALITY_GRADE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>US Swine Grading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int US_SWINE_GRADING_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.Sex <em>Sex</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Sex
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSex()
	 * @generated
	 */
	int SEX = 44;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.BisonBreed <em>Bison Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.BisonBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBisonBreed()
	 * @generated
	 */
	int BISON_BREED = 45;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.SheepBreed <em>Sheep Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.SheepBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSheepBreed()
	 * @generated
	 */
	int SHEEP_BREED = 46;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.BeefBreed <em>Beef Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.BeefBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBeefBreed()
	 * @generated
	 */
	int BEEF_BREED = 47;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.DairyBreed <em>Dairy Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.DairyBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getDairyBreed()
	 * @generated
	 */
	int DAIRY_BREED = 48;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.SwineBreed <em>Swine Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.SwineBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSwineBreed()
	 * @generated
	 */
	int SWINE_BREED = 49;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.HorseBreed <em>Horse Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.HorseBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getHorseBreed()
	 * @generated
	 */
	int HORSE_BREED = 50;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.GoatBreed <em>Goat Breed</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GoatBreed
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getGoatBreed()
	 * @generated
	 */
	int GOAT_BREED = 51;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.Treatment <em>Treatment</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Treatment
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTreatment()
	 * @generated
	 */
	int TREATMENT = 52;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.TreatmentMethod <em>Treatment Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.TreatmentMethod
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTreatmentMethod()
	 * @generated
	 */
	int TREATMENT_METHOD = 53;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.OneToTen <em>One To Ten</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.OneToTen
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getOneToTen()
	 * @generated
	 */
	int ONE_TO_TEN = 54;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.AnimalType <em>Animal Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.AnimalType
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAnimalType()
	 * @generated
	 */
	int ANIMAL_TYPE = 55;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.EventDataType <em>Event Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.EventDataType
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEventDataType()
	 * @generated
	 */
	int EVENT_DATA_TYPE = 56;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.USQualityGrade <em>US Quality Grade</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.USQualityGrade
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSQualityGrade()
	 * @generated
	 */
	int US_QUALITY_GRADE = 57;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.USBeefYieldGrade <em>US Beef Yield Grade</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.USBeefYieldGrade
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSBeefYieldGrade()
	 * @generated
	 */
	int US_BEEF_YIELD_GRADE = 58;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.Level <em>Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.Level
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getLevel()
	 * @generated
	 */
	int LEVEL = 59;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.USSwineQualityGrade <em>US Swine Quality Grade</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.USSwineQualityGrade
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSSwineQualityGrade()
	 * @generated
	 */
	int US_SWINE_QUALITY_GRADE = 60;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.WeightMeasurementUnit <em>Weight Measurement Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.WeightMeasurementUnit
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getWeightMeasurementUnit()
	 * @generated
	 */
	int WEIGHT_MEASUREMENT_UNIT = 61;

	/**
	 * The meta object id for the '<em>Premises Id Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getPremisesIdNumber()
	 * @generated
	 */
	int PREMISES_ID_NUMBER = 62;

	/**
	 * The meta object id for the '<em>Email</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEmail()
	 * @generated
	 */
	int EMAIL = 63;


	/**
	 * The meta object id for the '<em>Age</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.util.Age
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAge()
	 * @generated
	 */
	int AGE = 64;


	/**
	 * The meta object id for the '<em>US Phone Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSPhoneNumber()
	 * @generated
	 */
	int US_PHONE_NUMBER = 65;


	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.impl.TrackerPackageImpl#getURI()
	 * @generated
	 */
	int URI = 66;


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
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see com.verticon.tracker.Animal#getWeight()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Weight();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getWeightGainPerDay <em>Weight Gain Per Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight Gain Per Day</em>'.
	 * @see com.verticon.tracker.Animal#getWeightGainPerDay()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_WeightGainPerDay();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.tracker.Animal#getType()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getVisualID <em>Visual ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visual ID</em>'.
	 * @see com.verticon.tracker.Animal#getVisualID()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_VisualID();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getAgeInDays <em>Age In Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age In Days</em>'.
	 * @see com.verticon.tracker.Animal#getAgeInDays()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_AgeInDays();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Animal#getAlternativeID <em>Alternative ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alternative ID</em>'.
	 * @see com.verticon.tracker.Animal#getAlternativeID()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_AlternativeID();

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
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.WeighIn#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see com.verticon.tracker.WeighIn#getUnit()
	 * @see #getWeighIn()
	 * @generated
	 */
	EAttribute getWeighIn_Unit();

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
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Swine#getRightEarNotching <em>Right Ear Notching</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Ear Notching</em>'.
	 * @see com.verticon.tracker.Swine#getRightEarNotching()
	 * @see #getSwine()
	 * @generated
	 */
	EAttribute getSwine_RightEarNotching();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Swine#getLeftEarNotching <em>Left Ear Notching</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left Ear Notching</em>'.
	 * @see com.verticon.tracker.Swine#getLeftEarNotching()
	 * @see #getSwine()
	 * @generated
	 */
	EAttribute getSwine_LeftEarNotching();

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
	 * Returns the meta object for class '{@link com.verticon.tracker.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see com.verticon.tracker.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Location#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.Location#getName()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Name();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.MedicalCondition <em>Medical Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Medical Condition</em>'.
	 * @see com.verticon.tracker.MedicalCondition
	 * @generated
	 */
	EClass getMedicalCondition();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.MedicalTreatment <em>Medical Treatment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Medical Treatment</em>'.
	 * @see com.verticon.tracker.MedicalTreatment
	 * @generated
	 */
	EClass getMedicalTreatment();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MedicalTreatment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.MedicalTreatment#getName()
	 * @see #getMedicalTreatment()
	 * @generated
	 */
	EAttribute getMedicalTreatment_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MedicalTreatment#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product</em>'.
	 * @see com.verticon.tracker.MedicalTreatment#getProduct()
	 * @see #getMedicalTreatment()
	 * @generated
	 */
	EAttribute getMedicalTreatment_Product();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MedicalTreatment#getManufacturer <em>Manufacturer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manufacturer</em>'.
	 * @see com.verticon.tracker.MedicalTreatment#getManufacturer()
	 * @see #getMedicalTreatment()
	 * @generated
	 */
	EAttribute getMedicalTreatment_Manufacturer();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MedicalTreatment#getLot <em>Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lot</em>'.
	 * @see com.verticon.tracker.MedicalTreatment#getLot()
	 * @see #getMedicalTreatment()
	 * @generated
	 */
	EAttribute getMedicalTreatment_Lot();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MedicalTreatment#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see com.verticon.tracker.MedicalTreatment#getQuantity()
	 * @see #getMedicalTreatment()
	 * @generated
	 */
	EAttribute getMedicalTreatment_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MedicalTreatment#getTreatment <em>Treatment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Treatment</em>'.
	 * @see com.verticon.tracker.MedicalTreatment#getTreatment()
	 * @see #getMedicalTreatment()
	 * @generated
	 */
	EAttribute getMedicalTreatment_Treatment();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MedicalTreatment#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see com.verticon.tracker.MedicalTreatment#getMethod()
	 * @see #getMedicalTreatment()
	 * @generated
	 */
	EAttribute getMedicalTreatment_Method();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Birthing <em>Birthing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Birthing</em>'.
	 * @see com.verticon.tracker.Birthing
	 * @generated
	 */
	EClass getBirthing();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Birthing#isViability <em>Viability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Viability</em>'.
	 * @see com.verticon.tracker.Birthing#isViability()
	 * @see #getBirthing()
	 * @generated
	 */
	EAttribute getBirthing_Viability();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Birthing#isAssisted <em>Assisted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assisted</em>'.
	 * @see com.verticon.tracker.Birthing#isAssisted()
	 * @see #getBirthing()
	 * @generated
	 */
	EAttribute getBirthing_Assisted();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Birthing#getDifficulty <em>Difficulty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Difficulty</em>'.
	 * @see com.verticon.tracker.Birthing#getDifficulty()
	 * @see #getBirthing()
	 * @generated
	 */
	EAttribute getBirthing_Difficulty();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Calving <em>Calving</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calving</em>'.
	 * @see com.verticon.tracker.Calving
	 * @generated
	 */
	EClass getCalving();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.BirthDefect <em>Birth Defect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Birth Defect</em>'.
	 * @see com.verticon.tracker.BirthDefect
	 * @generated
	 */
	EClass getBirthDefect();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.BirthDefect#isFreemartin <em>Freemartin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Freemartin</em>'.
	 * @see com.verticon.tracker.BirthDefect#isFreemartin()
	 * @see #getBirthDefect()
	 * @generated
	 */
	EAttribute getBirthDefect_Freemartin();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Mastitis <em>Mastitis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mastitis</em>'.
	 * @see com.verticon.tracker.Mastitis
	 * @generated
	 */
	EClass getMastitis();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Mastitis#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.verticon.tracker.Mastitis#getLocation()
	 * @see #getMastitis()
	 * @generated
	 */
	EAttribute getMastitis_Location();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Mastitis#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see com.verticon.tracker.Mastitis#getOrigin()
	 * @see #getMastitis()
	 * @generated
	 */
	EAttribute getMastitis_Origin();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.MilkTest <em>Milk Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Milk Test</em>'.
	 * @see com.verticon.tracker.MilkTest
	 * @generated
	 */
	EClass getMilkTest();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MilkTest#getPoundsProduced <em>Pounds Produced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pounds Produced</em>'.
	 * @see com.verticon.tracker.MilkTest#getPoundsProduced()
	 * @see #getMilkTest()
	 * @generated
	 */
	EAttribute getMilkTest_PoundsProduced();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MilkTest#getPercentButterFat <em>Percent Butter Fat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percent Butter Fat</em>'.
	 * @see com.verticon.tracker.MilkTest#getPercentButterFat()
	 * @see #getMilkTest()
	 * @generated
	 */
	EAttribute getMilkTest_PercentButterFat();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MilkTest#getPercentProtein <em>Percent Protein</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percent Protein</em>'.
	 * @see com.verticon.tracker.MilkTest#getPercentProtein()
	 * @see #getMilkTest()
	 * @generated
	 */
	EAttribute getMilkTest_PercentProtein();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MilkTest#getSomaticCellCounts <em>Somatic Cell Counts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Somatic Cell Counts</em>'.
	 * @see com.verticon.tracker.MilkTest#getSomaticCellCounts()
	 * @see #getMilkTest()
	 * @generated
	 */
	EAttribute getMilkTest_SomaticCellCounts();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.MilkTest#getOtherSolids <em>Other Solids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other Solids</em>'.
	 * @see com.verticon.tracker.MilkTest#getOtherSolids()
	 * @see #getMilkTest()
	 * @generated
	 */
	EAttribute getMilkTest_OtherSolids();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.HerdTest <em>Herd Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Herd Test</em>'.
	 * @see com.verticon.tracker.HerdTest
	 * @generated
	 */
	EClass getHerdTest();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.HerdTest#isPregnant <em>Pregnant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pregnant</em>'.
	 * @see com.verticon.tracker.HerdTest#isPregnant()
	 * @see #getHerdTest()
	 * @generated
	 */
	EAttribute getHerdTest_Pregnant();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.HerdTest#getDaysSinceBredEstimate <em>Days Since Bred Estimate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Days Since Bred Estimate</em>'.
	 * @see com.verticon.tracker.HerdTest#getDaysSinceBredEstimate()
	 * @see #getHerdTest()
	 * @generated
	 */
	EAttribute getHerdTest_DaysSinceBredEstimate();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.HerdTest#getBredDateEstimate <em>Bred Date Estimate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bred Date Estimate</em>'.
	 * @see com.verticon.tracker.HerdTest#getBredDateEstimate()
	 * @see #getHerdTest()
	 * @generated
	 */
	EAttribute getHerdTest_BredDateEstimate();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.GenericEvent <em>Generic Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Event</em>'.
	 * @see com.verticon.tracker.GenericEvent
	 * @generated
	 */
	EClass getGenericEvent();

	/**
	 * Returns the meta object for the map '{@link com.verticon.tracker.GenericEvent#getEventAttributes <em>Event Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Event Attributes</em>'.
	 * @see com.verticon.tracker.GenericEvent#getEventAttributes()
	 * @see #getGenericEvent()
	 * @generated
	 */
	EReference getGenericEvent_EventAttributes();

	/**
	 * Returns the meta object for the reference '{@link com.verticon.tracker.GenericEvent#getEventSchema <em>Event Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Schema</em>'.
	 * @see com.verticon.tracker.GenericEvent#getEventSchema()
	 * @see #getGenericEvent()
	 * @generated
	 */
	EReference getGenericEvent_EventSchema();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Event Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Attribute</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EString" valueRequired="true"
	 * @generated
	 */
	EClass getEventAttribute();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEventAttribute()
	 * @generated
	 */
	EAttribute getEventAttribute_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEventAttribute()
	 * @generated
	 */
	EAttribute getEventAttribute_Value();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.EventSchema <em>Event Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Schema</em>'.
	 * @see com.verticon.tracker.EventSchema
	 * @generated
	 */
	EClass getEventSchema();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.EventSchema#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.EventSchema#getName()
	 * @see #getEventSchema()
	 * @generated
	 */
	EAttribute getEventSchema_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.EventSchema#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.verticon.tracker.EventSchema#getDescription()
	 * @see #getEventSchema()
	 * @generated
	 */
	EAttribute getEventSchema_Description();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.tracker.EventSchema#getAnimalType <em>Animal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Animal Type</em>'.
	 * @see com.verticon.tracker.EventSchema#getAnimalType()
	 * @see #getEventSchema()
	 * @generated
	 */
	EAttribute getEventSchema_AnimalType();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.EventSchema#getEventAttributes <em>Event Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event Attributes</em>'.
	 * @see com.verticon.tracker.EventSchema#getEventAttributes()
	 * @see #getEventSchema()
	 * @generated
	 */
	EReference getEventSchema_EventAttributes();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.EventAttributeSchema <em>Event Attribute Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Attribute Schema</em>'.
	 * @see com.verticon.tracker.EventAttributeSchema
	 * @generated
	 */
	EClass getEventAttributeSchema();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.EventAttributeSchema#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.EventAttributeSchema#getName()
	 * @see #getEventAttributeSchema()
	 * @generated
	 */
	EAttribute getEventAttributeSchema_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.EventAttributeSchema#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see com.verticon.tracker.EventAttributeSchema#getDataType()
	 * @see #getEventAttributeSchema()
	 * @generated
	 */
	EAttribute getEventAttributeSchema_DataType();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.EventAttributeSchema#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.verticon.tracker.EventAttributeSchema#getDescription()
	 * @see #getEventAttributeSchema()
	 * @generated
	 */
	EAttribute getEventAttributeSchema_Description();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.Schema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema</em>'.
	 * @see com.verticon.tracker.Schema
	 * @generated
	 */
	EClass getSchema();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.Schema#getEventSchemas <em>Event Schemas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event Schemas</em>'.
	 * @see com.verticon.tracker.Schema#getEventSchemas()
	 * @see #getSchema()
	 * @generated
	 */
	EReference getSchema_EventSchemas();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.USBeefGrading <em>US Beef Grading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>US Beef Grading</em>'.
	 * @see com.verticon.tracker.USBeefGrading
	 * @generated
	 */
	EClass getUSBeefGrading();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.USBeefGrading#getQualityGrade <em>Quality Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Grade</em>'.
	 * @see com.verticon.tracker.USBeefGrading#getQualityGrade()
	 * @see #getUSBeefGrading()
	 * @generated
	 */
	EAttribute getUSBeefGrading_QualityGrade();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.USBeefGrading#getQualityGradeLevel <em>Quality Grade Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Grade Level</em>'.
	 * @see com.verticon.tracker.USBeefGrading#getQualityGradeLevel()
	 * @see #getUSBeefGrading()
	 * @generated
	 */
	EAttribute getUSBeefGrading_QualityGradeLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.USBeefGrading#getYieldGrade <em>Yield Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Yield Grade</em>'.
	 * @see com.verticon.tracker.USBeefGrading#getYieldGrade()
	 * @see #getUSBeefGrading()
	 * @generated
	 */
	EAttribute getUSBeefGrading_YieldGrade();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.USOvineGrading <em>US Ovine Grading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>US Ovine Grading</em>'.
	 * @see com.verticon.tracker.USOvineGrading
	 * @generated
	 */
	EClass getUSOvineGrading();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.USOvineGrading#getQualityGrade <em>Quality Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Grade</em>'.
	 * @see com.verticon.tracker.USOvineGrading#getQualityGrade()
	 * @see #getUSOvineGrading()
	 * @generated
	 */
	EAttribute getUSOvineGrading_QualityGrade();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.USOvineGrading#getQualityGradeLevel <em>Quality Grade Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Grade Level</em>'.
	 * @see com.verticon.tracker.USOvineGrading#getQualityGradeLevel()
	 * @see #getUSOvineGrading()
	 * @generated
	 */
	EAttribute getUSOvineGrading_QualityGradeLevel();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.USSwineGrading <em>US Swine Grading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>US Swine Grading</em>'.
	 * @see com.verticon.tracker.USSwineGrading
	 * @generated
	 */
	EClass getUSSwineGrading();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.USSwineGrading#getQualityGrade <em>Quality Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Grade</em>'.
	 * @see com.verticon.tracker.USSwineGrading#getQualityGrade()
	 * @see #getUSSwineGrading()
	 * @generated
	 */
	EAttribute getUSSwineGrading_QualityGrade();

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
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.Premises#getLocations <em>Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locations</em>'.
	 * @see com.verticon.tracker.Premises#getLocations()
	 * @see #getPremises()
	 * @generated
	 */
	EReference getPremises_Locations();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Premises#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see com.verticon.tracker.Premises#getUri()
	 * @see #getPremises()
	 * @generated
	 */
	EAttribute getPremises_Uri();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.tracker.Premises#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Schema</em>'.
	 * @see com.verticon.tracker.Premises#getSchema()
	 * @see #getPremises()
	 * @generated
	 */
	EReference getPremises_Schema();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Premises#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.Premises#getName()
	 * @see #getPremises()
	 * @generated
	 */
	EAttribute getPremises_Name();

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
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.Ovine#getScrapieTag <em>Scrapie Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scrapie Tag</em>'.
	 * @see com.verticon.tracker.Ovine#getScrapieTag()
	 * @see #getOvine()
	 * @generated
	 */
	EAttribute getOvine_ScrapieTag();

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
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.ReplacedTag#getOldId <em>Old Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Id</em>'.
	 * @see com.verticon.tracker.ReplacedTag#getOldId()
	 * @see #getReplacedTag()
	 * @generated
	 */
	EAttribute getReplacedTag_OldId();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.ReplacedTag#isUsainNumberUsedForOldId <em>Usain Number Used For Old Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usain Number Used For Old Id</em>'.
	 * @see com.verticon.tracker.ReplacedTag#isUsainNumberUsedForOldId()
	 * @see #getReplacedTag()
	 * @generated
	 */
	EAttribute getReplacedTag_UsainNumberUsedForOldId();

	/**
	 * Returns the meta object for the reference '{@link com.verticon.tracker.ReplacedTag#getOldTag <em>Old Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Tag</em>'.
	 * @see com.verticon.tracker.ReplacedTag#getOldTag()
	 * @see #getReplacedTag()
	 * @generated
	 */
	EReference getReplacedTag_OldTag();

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
	 * Returns the meta object for the reference '{@link com.verticon.tracker.Sighting#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Location</em>'.
	 * @see com.verticon.tracker.Sighting#getLocation()
	 * @see #getSighting()
	 * @generated
	 */
	EReference getSighting_Location();

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
	 * Returns the meta object for enum '{@link com.verticon.tracker.Treatment <em>Treatment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Treatment</em>'.
	 * @see com.verticon.tracker.Treatment
	 * @generated
	 */
	EEnum getTreatment();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.TreatmentMethod <em>Treatment Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Treatment Method</em>'.
	 * @see com.verticon.tracker.TreatmentMethod
	 * @generated
	 */
	EEnum getTreatmentMethod();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.OneToTen <em>One To Ten</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>One To Ten</em>'.
	 * @see com.verticon.tracker.OneToTen
	 * @generated
	 */
	EEnum getOneToTen();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.AnimalType <em>Animal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Animal Type</em>'.
	 * @see com.verticon.tracker.AnimalType
	 * @generated
	 */
	EEnum getAnimalType();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.EventDataType <em>Event Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Data Type</em>'.
	 * @see com.verticon.tracker.EventDataType
	 * @generated
	 */
	EEnum getEventDataType();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.USQualityGrade <em>US Quality Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>US Quality Grade</em>'.
	 * @see com.verticon.tracker.USQualityGrade
	 * @generated
	 */
	EEnum getUSQualityGrade();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.USBeefYieldGrade <em>US Beef Yield Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>US Beef Yield Grade</em>'.
	 * @see com.verticon.tracker.USBeefYieldGrade
	 * @generated
	 */
	EEnum getUSBeefYieldGrade();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.Level <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Level</em>'.
	 * @see com.verticon.tracker.Level
	 * @generated
	 */
	EEnum getLevel();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.USSwineQualityGrade <em>US Swine Quality Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>US Swine Quality Grade</em>'.
	 * @see com.verticon.tracker.USSwineQualityGrade
	 * @generated
	 */
	EEnum getUSSwineQualityGrade();

	/**
	 * Returns the meta object for enum '{@link com.verticon.tracker.WeightMeasurementUnit <em>Weight Measurement Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Weight Measurement Unit</em>'.
	 * @see com.verticon.tracker.WeightMeasurementUnit
	 * @generated
	 */
	EEnum getWeightMeasurementUnit();

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
	 * Returns the meta object for data type '{@link java.lang.String <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getURI();

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
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__WEIGHT = eINSTANCE.getAnimal_Weight();

		/**
		 * The meta object literal for the '<em><b>Weight Gain Per Day</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__WEIGHT_GAIN_PER_DAY = eINSTANCE.getAnimal_WeightGainPerDay();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__TYPE = eINSTANCE.getAnimal_Type();

		/**
		 * The meta object literal for the '<em><b>Visual ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__VISUAL_ID = eINSTANCE.getAnimal_VisualID();

		/**
		 * The meta object literal for the '<em><b>Age In Days</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__AGE_IN_DAYS = eINSTANCE.getAnimal_AgeInDays();

		/**
		 * The meta object literal for the '<em><b>Alternative ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__ALTERNATIVE_ID = eINSTANCE.getAnimal_AlternativeID();

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
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEIGH_IN__UNIT = eINSTANCE.getWeighIn_Unit();

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
		 * The meta object literal for the '<em><b>Right Ear Notching</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWINE__RIGHT_EAR_NOTCHING = eINSTANCE.getSwine_RightEarNotching();

		/**
		 * The meta object literal for the '<em><b>Left Ear Notching</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWINE__LEFT_EAR_NOTCHING = eINSTANCE.getSwine_LeftEarNotching();

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
		 * The meta object literal for the '{@link com.verticon.tracker.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.LocationImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__NAME = eINSTANCE.getLocation_Name();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.MedicalConditionImpl <em>Medical Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.MedicalConditionImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMedicalCondition()
		 * @generated
		 */
		EClass MEDICAL_CONDITION = eINSTANCE.getMedicalCondition();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.MedicalTreatmentImpl <em>Medical Treatment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.MedicalTreatmentImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMedicalTreatment()
		 * @generated
		 */
		EClass MEDICAL_TREATMENT = eINSTANCE.getMedicalTreatment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDICAL_TREATMENT__NAME = eINSTANCE.getMedicalTreatment_Name();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDICAL_TREATMENT__PRODUCT = eINSTANCE.getMedicalTreatment_Product();

		/**
		 * The meta object literal for the '<em><b>Manufacturer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDICAL_TREATMENT__MANUFACTURER = eINSTANCE.getMedicalTreatment_Manufacturer();

		/**
		 * The meta object literal for the '<em><b>Lot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDICAL_TREATMENT__LOT = eINSTANCE.getMedicalTreatment_Lot();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDICAL_TREATMENT__QUANTITY = eINSTANCE.getMedicalTreatment_Quantity();

		/**
		 * The meta object literal for the '<em><b>Treatment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDICAL_TREATMENT__TREATMENT = eINSTANCE.getMedicalTreatment_Treatment();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDICAL_TREATMENT__METHOD = eINSTANCE.getMedicalTreatment_Method();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.BirthingImpl <em>Birthing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.BirthingImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBirthing()
		 * @generated
		 */
		EClass BIRTHING = eINSTANCE.getBirthing();

		/**
		 * The meta object literal for the '<em><b>Viability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIRTHING__VIABILITY = eINSTANCE.getBirthing_Viability();

		/**
		 * The meta object literal for the '<em><b>Assisted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIRTHING__ASSISTED = eINSTANCE.getBirthing_Assisted();

		/**
		 * The meta object literal for the '<em><b>Difficulty</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIRTHING__DIFFICULTY = eINSTANCE.getBirthing_Difficulty();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.CalvingImpl <em>Calving</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.CalvingImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getCalving()
		 * @generated
		 */
		EClass CALVING = eINSTANCE.getCalving();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.BirthDefectImpl <em>Birth Defect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.BirthDefectImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getBirthDefect()
		 * @generated
		 */
		EClass BIRTH_DEFECT = eINSTANCE.getBirthDefect();

		/**
		 * The meta object literal for the '<em><b>Freemartin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIRTH_DEFECT__FREEMARTIN = eINSTANCE.getBirthDefect_Freemartin();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.MastitisImpl <em>Mastitis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.MastitisImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMastitis()
		 * @generated
		 */
		EClass MASTITIS = eINSTANCE.getMastitis();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASTITIS__LOCATION = eINSTANCE.getMastitis_Location();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASTITIS__ORIGIN = eINSTANCE.getMastitis_Origin();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.MilkTestImpl <em>Milk Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.MilkTestImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getMilkTest()
		 * @generated
		 */
		EClass MILK_TEST = eINSTANCE.getMilkTest();

		/**
		 * The meta object literal for the '<em><b>Pounds Produced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_TEST__POUNDS_PRODUCED = eINSTANCE.getMilkTest_PoundsProduced();

		/**
		 * The meta object literal for the '<em><b>Percent Butter Fat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_TEST__PERCENT_BUTTER_FAT = eINSTANCE.getMilkTest_PercentButterFat();

		/**
		 * The meta object literal for the '<em><b>Percent Protein</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_TEST__PERCENT_PROTEIN = eINSTANCE.getMilkTest_PercentProtein();

		/**
		 * The meta object literal for the '<em><b>Somatic Cell Counts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_TEST__SOMATIC_CELL_COUNTS = eINSTANCE.getMilkTest_SomaticCellCounts();

		/**
		 * The meta object literal for the '<em><b>Other Solids</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_TEST__OTHER_SOLIDS = eINSTANCE.getMilkTest_OtherSolids();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.HerdTestImpl <em>Herd Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.HerdTestImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getHerdTest()
		 * @generated
		 */
		EClass HERD_TEST = eINSTANCE.getHerdTest();

		/**
		 * The meta object literal for the '<em><b>Pregnant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HERD_TEST__PREGNANT = eINSTANCE.getHerdTest_Pregnant();

		/**
		 * The meta object literal for the '<em><b>Days Since Bred Estimate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HERD_TEST__DAYS_SINCE_BRED_ESTIMATE = eINSTANCE.getHerdTest_DaysSinceBredEstimate();

		/**
		 * The meta object literal for the '<em><b>Bred Date Estimate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HERD_TEST__BRED_DATE_ESTIMATE = eINSTANCE.getHerdTest_BredDateEstimate();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.GenericEventImpl <em>Generic Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.GenericEventImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getGenericEvent()
		 * @generated
		 */
		EClass GENERIC_EVENT = eINSTANCE.getGenericEvent();

		/**
		 * The meta object literal for the '<em><b>Event Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_EVENT__EVENT_ATTRIBUTES = eINSTANCE.getGenericEvent_EventAttributes();

		/**
		 * The meta object literal for the '<em><b>Event Schema</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_EVENT__EVENT_SCHEMA = eINSTANCE.getGenericEvent_EventSchema();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.EventAttributeImpl <em>Event Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.EventAttributeImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEventAttribute()
		 * @generated
		 */
		EClass EVENT_ATTRIBUTE = eINSTANCE.getEventAttribute();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_ATTRIBUTE__KEY = eINSTANCE.getEventAttribute_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_ATTRIBUTE__VALUE = eINSTANCE.getEventAttribute_Value();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.EventSchemaImpl <em>Event Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.EventSchemaImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEventSchema()
		 * @generated
		 */
		EClass EVENT_SCHEMA = eINSTANCE.getEventSchema();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_SCHEMA__NAME = eINSTANCE.getEventSchema_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_SCHEMA__DESCRIPTION = eINSTANCE.getEventSchema_Description();

		/**
		 * The meta object literal for the '<em><b>Animal Type</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_SCHEMA__ANIMAL_TYPE = eINSTANCE.getEventSchema_AnimalType();

		/**
		 * The meta object literal for the '<em><b>Event Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_SCHEMA__EVENT_ATTRIBUTES = eINSTANCE.getEventSchema_EventAttributes();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.EventAttributeSchemaImpl <em>Event Attribute Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.EventAttributeSchemaImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEventAttributeSchema()
		 * @generated
		 */
		EClass EVENT_ATTRIBUTE_SCHEMA = eINSTANCE.getEventAttributeSchema();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_ATTRIBUTE_SCHEMA__NAME = eINSTANCE.getEventAttributeSchema_Name();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_ATTRIBUTE_SCHEMA__DATA_TYPE = eINSTANCE.getEventAttributeSchema_DataType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_ATTRIBUTE_SCHEMA__DESCRIPTION = eINSTANCE.getEventAttributeSchema_Description();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.SchemaImpl <em>Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.SchemaImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getSchema()
		 * @generated
		 */
		EClass SCHEMA = eINSTANCE.getSchema();

		/**
		 * The meta object literal for the '<em><b>Event Schemas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEMA__EVENT_SCHEMAS = eINSTANCE.getSchema_EventSchemas();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.USBeefGradingImpl <em>US Beef Grading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.USBeefGradingImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSBeefGrading()
		 * @generated
		 */
		EClass US_BEEF_GRADING = eINSTANCE.getUSBeefGrading();

		/**
		 * The meta object literal for the '<em><b>Quality Grade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute US_BEEF_GRADING__QUALITY_GRADE = eINSTANCE.getUSBeefGrading_QualityGrade();

		/**
		 * The meta object literal for the '<em><b>Quality Grade Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute US_BEEF_GRADING__QUALITY_GRADE_LEVEL = eINSTANCE.getUSBeefGrading_QualityGradeLevel();

		/**
		 * The meta object literal for the '<em><b>Yield Grade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute US_BEEF_GRADING__YIELD_GRADE = eINSTANCE.getUSBeefGrading_YieldGrade();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.USOvineGradingImpl <em>US Ovine Grading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.USOvineGradingImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSOvineGrading()
		 * @generated
		 */
		EClass US_OVINE_GRADING = eINSTANCE.getUSOvineGrading();

		/**
		 * The meta object literal for the '<em><b>Quality Grade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute US_OVINE_GRADING__QUALITY_GRADE = eINSTANCE.getUSOvineGrading_QualityGrade();

		/**
		 * The meta object literal for the '<em><b>Quality Grade Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute US_OVINE_GRADING__QUALITY_GRADE_LEVEL = eINSTANCE.getUSOvineGrading_QualityGradeLevel();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.impl.USSwineGradingImpl <em>US Swine Grading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.impl.USSwineGradingImpl
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSSwineGrading()
		 * @generated
		 */
		EClass US_SWINE_GRADING = eINSTANCE.getUSSwineGrading();

		/**
		 * The meta object literal for the '<em><b>Quality Grade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute US_SWINE_GRADING__QUALITY_GRADE = eINSTANCE.getUSSwineGrading_QualityGrade();

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
		 * The meta object literal for the '<em><b>Locations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREMISES__LOCATIONS = eINSTANCE.getPremises_Locations();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREMISES__URI = eINSTANCE.getPremises_Uri();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREMISES__SCHEMA = eINSTANCE.getPremises_Schema();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREMISES__NAME = eINSTANCE.getPremises_Name();

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
		 * The meta object literal for the '<em><b>Scrapie Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVINE__SCRAPIE_TAG = eINSTANCE.getOvine_ScrapieTag();

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
		 * The meta object literal for the '<em><b>Old Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACED_TAG__OLD_ID = eINSTANCE.getReplacedTag_OldId();

		/**
		 * The meta object literal for the '<em><b>Usain Number Used For Old Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID = eINSTANCE.getReplacedTag_UsainNumberUsedForOldId();

		/**
		 * The meta object literal for the '<em><b>Old Tag</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACED_TAG__OLD_TAG = eINSTANCE.getReplacedTag_OldTag();

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
		 * The meta object literal for the '<em><b>Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGHTING__LOCATION = eINSTANCE.getSighting_Location();

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
		 * The meta object literal for the '{@link com.verticon.tracker.Treatment <em>Treatment</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.Treatment
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTreatment()
		 * @generated
		 */
		EEnum TREATMENT = eINSTANCE.getTreatment();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.TreatmentMethod <em>Treatment Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.TreatmentMethod
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getTreatmentMethod()
		 * @generated
		 */
		EEnum TREATMENT_METHOD = eINSTANCE.getTreatmentMethod();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.OneToTen <em>One To Ten</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.OneToTen
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getOneToTen()
		 * @generated
		 */
		EEnum ONE_TO_TEN = eINSTANCE.getOneToTen();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.AnimalType <em>Animal Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.AnimalType
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getAnimalType()
		 * @generated
		 */
		EEnum ANIMAL_TYPE = eINSTANCE.getAnimalType();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.EventDataType <em>Event Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.EventDataType
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getEventDataType()
		 * @generated
		 */
		EEnum EVENT_DATA_TYPE = eINSTANCE.getEventDataType();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.USQualityGrade <em>US Quality Grade</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.USQualityGrade
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSQualityGrade()
		 * @generated
		 */
		EEnum US_QUALITY_GRADE = eINSTANCE.getUSQualityGrade();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.USBeefYieldGrade <em>US Beef Yield Grade</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.USBeefYieldGrade
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSBeefYieldGrade()
		 * @generated
		 */
		EEnum US_BEEF_YIELD_GRADE = eINSTANCE.getUSBeefYieldGrade();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.Level <em>Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.Level
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getLevel()
		 * @generated
		 */
		EEnum LEVEL = eINSTANCE.getLevel();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.USSwineQualityGrade <em>US Swine Quality Grade</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.USSwineQualityGrade
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getUSSwineQualityGrade()
		 * @generated
		 */
		EEnum US_SWINE_QUALITY_GRADE = eINSTANCE.getUSSwineQualityGrade();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.WeightMeasurementUnit <em>Weight Measurement Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.WeightMeasurementUnit
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getWeightMeasurementUnit()
		 * @generated
		 */
		EEnum WEIGHT_MEASUREMENT_UNIT = eINSTANCE.getWeightMeasurementUnit();

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

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.tracker.impl.TrackerPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //TrackerPackage
