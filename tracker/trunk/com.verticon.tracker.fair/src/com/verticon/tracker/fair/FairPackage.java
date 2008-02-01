/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see com.verticon.tracker.fair.FairFactory
 * @model kind="package"
 * @generated
 */
public interface FairPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fair";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.verticon.com/ns/tracker/fair/0.1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.verticon.tracker.fair";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FairPackage eINSTANCE = com.verticon.tracker.fair.impl.FairPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.FairImpl <em>Fair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.FairImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getFair()
	 * @generated
	 */
	int FAIR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Youth Club</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__YOUTH_CLUB = 1;

	/**
	 * The feature id for the '<em><b>Division</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__DIVISION = 2;

	/**
	 * The feature id for the '<em><b>Premises</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__PREMISES = 3;

	/**
	 * The feature id for the '<em><b>People</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__PEOPLE = 4;

	/**
	 * The number of structural features of the '<em>Fair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.ExhibitImpl <em>Exhibit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.ExhibitImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getExhibit()
	 * @generated
	 */
	int EXHIBIT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT__NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT__COMMENTS = 2;

	/**
	 * The feature id for the '<em><b>Animal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT__ANIMAL = 3;

	/**
	 * The feature id for the '<em><b>Exhibitor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT__EXHIBITOR = 4;

	/**
	 * The number of structural features of the '<em>Exhibit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.YouthClubImpl <em>Youth Club</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.YouthClubImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getYouthClub()
	 * @generated
	 */
	int YOUTH_CLUB = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUTH_CLUB__NAME = 0;

	/**
	 * The number of structural features of the '<em>Youth Club</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUTH_CLUB_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.DivisionImpl <em>Division</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.DivisionImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getDivision()
	 * @generated
	 */
	int DIVISION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Department</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__DEPARTMENT = 1;

	/**
	 * The number of structural features of the '<em>Division</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.DepartmentImpl <em>Department</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.DepartmentImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getDepartment()
	 * @generated
	 */
	int DEPARTMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__CLASS = 1;

	/**
	 * The feature id for the '<em><b>Superintendent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__SUPERINTENDENT = 2;

	/**
	 * The number of structural features of the '<em>Department</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.ClassImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lot</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__LOT = 1;

	/**
	 * The feature id for the '<em><b>Judge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__JUDGE = 2;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.LotImpl <em>Lot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.LotImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getLot()
	 * @generated
	 */
	int LOT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Exhibit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOT__EXHIBIT = 1;

	/**
	 * The number of structural features of the '<em>Lot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOT_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.PeopleImpl <em>People</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.PeopleImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getPeople()
	 * @generated
	 */
	int PEOPLE = 7;

	/**
	 * The feature id for the '<em><b>Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE__PERSON = 0;

	/**
	 * The number of structural features of the '<em>People</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEOPLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.PersonImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 8;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PHONE = 2;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__STREET = 3;

	/**
	 * The feature id for the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__CITY = 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__STATE = 5;

	/**
	 * The feature id for the '<em><b>Zip Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ZIP_CODE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 7;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.YoungPersonImpl <em>Young Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.YoungPersonImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getYoungPerson()
	 * @generated
	 */
	int YOUNG_PERSON = 9;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__FIRST_NAME = PERSON__FIRST_NAME;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__LAST_NAME = PERSON__LAST_NAME;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__PHONE = PERSON__PHONE;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__STREET = PERSON__STREET;

	/**
	 * The feature id for the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__CITY = PERSON__CITY;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__STATE = PERSON__STATE;

	/**
	 * The feature id for the '<em><b>Zip Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__ZIP_CODE = PERSON__ZIP_CODE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__NAME = PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__PARENT = PERSON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Club</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON__CLUB = PERSON_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Young Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOUNG_PERSON_FEATURE_COUNT = PERSON_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '<em>Zip Code</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getZipCode()
	 * @generated
	 */
	int ZIP_CODE = 10;

	/**
	 * The meta object id for the '<em>US Telephone Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getUSTelephoneNumber()
	 * @generated
	 */
	int US_TELEPHONE_NUMBER = 11;


	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.Fair <em>Fair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fair</em>'.
	 * @see com.verticon.tracker.fair.Fair
	 * @generated
	 */
	EClass getFair();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Fair#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.fair.Fair#getName()
	 * @see #getFair()
	 * @generated
	 */
	EAttribute getFair_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Fair#getYouthClub <em>Youth Club</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Youth Club</em>'.
	 * @see com.verticon.tracker.fair.Fair#getYouthClub()
	 * @see #getFair()
	 * @generated
	 */
	EReference getFair_YouthClub();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Fair#getDivision <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Division</em>'.
	 * @see com.verticon.tracker.fair.Fair#getDivision()
	 * @see #getFair()
	 * @generated
	 */
	EReference getFair_Division();

	/**
	 * Returns the meta object for the reference '{@link com.verticon.tracker.fair.Fair#getPremises <em>Premises</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Premises</em>'.
	 * @see com.verticon.tracker.fair.Fair#getPremises()
	 * @see #getFair()
	 * @generated
	 */
	EReference getFair_Premises();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.tracker.fair.Fair#getPeople <em>People</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>People</em>'.
	 * @see com.verticon.tracker.fair.Fair#getPeople()
	 * @see #getFair()
	 * @generated
	 */
	EReference getFair_People();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.Exhibit <em>Exhibit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exhibit</em>'.
	 * @see com.verticon.tracker.fair.Exhibit
	 * @generated
	 */
	EClass getExhibit();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.fair.Exhibit#getName()
	 * @see #getExhibit()
	 * @generated
	 */
	EAttribute getExhibit_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibit#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see com.verticon.tracker.fair.Exhibit#getNumber()
	 * @see #getExhibit()
	 * @generated
	 */
	EAttribute getExhibit_Number();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibit#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see com.verticon.tracker.fair.Exhibit#getComments()
	 * @see #getExhibit()
	 * @generated
	 */
	EAttribute getExhibit_Comments();

	/**
	 * Returns the meta object for the reference '{@link com.verticon.tracker.fair.Exhibit#getAnimal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Animal</em>'.
	 * @see com.verticon.tracker.fair.Exhibit#getAnimal()
	 * @see #getExhibit()
	 * @generated
	 */
	EReference getExhibit_Animal();

	/**
	 * Returns the meta object for the reference '{@link com.verticon.tracker.fair.Exhibit#getExhibitor <em>Exhibitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exhibitor</em>'.
	 * @see com.verticon.tracker.fair.Exhibit#getExhibitor()
	 * @see #getExhibit()
	 * @generated
	 */
	EReference getExhibit_Exhibitor();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.YouthClub <em>Youth Club</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Youth Club</em>'.
	 * @see com.verticon.tracker.fair.YouthClub
	 * @generated
	 */
	EClass getYouthClub();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.YouthClub#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.fair.YouthClub#getName()
	 * @see #getYouthClub()
	 * @generated
	 */
	EAttribute getYouthClub_Name();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.Division <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Division</em>'.
	 * @see com.verticon.tracker.fair.Division
	 * @generated
	 */
	EClass getDivision();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Division#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.fair.Division#getName()
	 * @see #getDivision()
	 * @generated
	 */
	EAttribute getDivision_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Division#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Department</em>'.
	 * @see com.verticon.tracker.fair.Division#getDepartment()
	 * @see #getDivision()
	 * @generated
	 */
	EReference getDivision_Department();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.Department <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Department</em>'.
	 * @see com.verticon.tracker.fair.Department
	 * @generated
	 */
	EClass getDepartment();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Department#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.fair.Department#getName()
	 * @see #getDepartment()
	 * @generated
	 */
	EAttribute getDepartment_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Department#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class</em>'.
	 * @see com.verticon.tracker.fair.Department#getClass_()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_Class();

	/**
	 * Returns the meta object for the reference list '{@link com.verticon.tracker.fair.Department#getSuperintendent <em>Superintendent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Superintendent</em>'.
	 * @see com.verticon.tracker.fair.Department#getSuperintendent()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_Superintendent();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see com.verticon.tracker.fair.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Class#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.fair.Class#getName()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Class#getLot <em>Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lot</em>'.
	 * @see com.verticon.tracker.fair.Class#getLot()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Lot();

	/**
	 * Returns the meta object for the reference list '{@link com.verticon.tracker.fair.Class#getJudge <em>Judge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Judge</em>'.
	 * @see com.verticon.tracker.fair.Class#getJudge()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Judge();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.Lot <em>Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lot</em>'.
	 * @see com.verticon.tracker.fair.Lot
	 * @generated
	 */
	EClass getLot();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Lot#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.fair.Lot#getName()
	 * @see #getLot()
	 * @generated
	 */
	EAttribute getLot_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Lot#getExhibit <em>Exhibit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exhibit</em>'.
	 * @see com.verticon.tracker.fair.Lot#getExhibit()
	 * @see #getLot()
	 * @generated
	 */
	EReference getLot_Exhibit();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.People <em>People</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>People</em>'.
	 * @see com.verticon.tracker.fair.People
	 * @generated
	 */
	EClass getPeople();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.People#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Person</em>'.
	 * @see com.verticon.tracker.fair.People#getPerson()
	 * @see #getPeople()
	 * @generated
	 */
	EReference getPeople_Person();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see com.verticon.tracker.fair.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Person#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see com.verticon.tracker.fair.Person#getFirstName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Person#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see com.verticon.tracker.fair.Person#getLastName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_LastName();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Person#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see com.verticon.tracker.fair.Person#getPhone()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Phone();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Person#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see com.verticon.tracker.fair.Person#getStreet()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Street();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Person#getCity <em>City</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>City</em>'.
	 * @see com.verticon.tracker.fair.Person#getCity()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_City();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Person#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.verticon.tracker.fair.Person#getState()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_State();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Person#getZipCode <em>Zip Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zip Code</em>'.
	 * @see com.verticon.tracker.fair.Person#getZipCode()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_ZipCode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.tracker.fair.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.YoungPerson <em>Young Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Young Person</em>'.
	 * @see com.verticon.tracker.fair.YoungPerson
	 * @generated
	 */
	EClass getYoungPerson();

	/**
	 * Returns the meta object for the reference list '{@link com.verticon.tracker.fair.YoungPerson#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent</em>'.
	 * @see com.verticon.tracker.fair.YoungPerson#getParent()
	 * @see #getYoungPerson()
	 * @generated
	 */
	EReference getYoungPerson_Parent();

	/**
	 * Returns the meta object for the reference '{@link com.verticon.tracker.fair.YoungPerson#getClub <em>Club</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Club</em>'.
	 * @see com.verticon.tracker.fair.YoungPerson#getClub()
	 * @see #getYoungPerson()
	 * @generated
	 */
	EReference getYoungPerson_Club();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Zip Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Zip Code</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getZipCode();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>US Telephone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>US Telephone Number</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getUSTelephoneNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FairFactory getFairFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.FairImpl <em>Fair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.FairImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getFair()
		 * @generated
		 */
		EClass FAIR = eINSTANCE.getFair();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIR__NAME = eINSTANCE.getFair_Name();

		/**
		 * The meta object literal for the '<em><b>Youth Club</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAIR__YOUTH_CLUB = eINSTANCE.getFair_YouthClub();

		/**
		 * The meta object literal for the '<em><b>Division</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAIR__DIVISION = eINSTANCE.getFair_Division();

		/**
		 * The meta object literal for the '<em><b>Premises</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAIR__PREMISES = eINSTANCE.getFair_Premises();

		/**
		 * The meta object literal for the '<em><b>People</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAIR__PEOPLE = eINSTANCE.getFair_People();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.ExhibitImpl <em>Exhibit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.ExhibitImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getExhibit()
		 * @generated
		 */
		EClass EXHIBIT = eINSTANCE.getExhibit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBIT__NAME = eINSTANCE.getExhibit_Name();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBIT__NUMBER = eINSTANCE.getExhibit_Number();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBIT__COMMENTS = eINSTANCE.getExhibit_Comments();

		/**
		 * The meta object literal for the '<em><b>Animal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXHIBIT__ANIMAL = eINSTANCE.getExhibit_Animal();

		/**
		 * The meta object literal for the '<em><b>Exhibitor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXHIBIT__EXHIBITOR = eINSTANCE.getExhibit_Exhibitor();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.YouthClubImpl <em>Youth Club</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.YouthClubImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getYouthClub()
		 * @generated
		 */
		EClass YOUTH_CLUB = eINSTANCE.getYouthClub();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YOUTH_CLUB__NAME = eINSTANCE.getYouthClub_Name();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.DivisionImpl <em>Division</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.DivisionImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getDivision()
		 * @generated
		 */
		EClass DIVISION = eINSTANCE.getDivision();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIVISION__NAME = eINSTANCE.getDivision_Name();

		/**
		 * The meta object literal for the '<em><b>Department</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIVISION__DEPARTMENT = eINSTANCE.getDivision_Department();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.DepartmentImpl <em>Department</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.DepartmentImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getDepartment()
		 * @generated
		 */
		EClass DEPARTMENT = eINSTANCE.getDepartment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPARTMENT__NAME = eINSTANCE.getDepartment_Name();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPARTMENT__CLASS = eINSTANCE.getDepartment_Class();

		/**
		 * The meta object literal for the '<em><b>Superintendent</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPARTMENT__SUPERINTENDENT = eINSTANCE.getDepartment_Superintendent();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.ClassImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__NAME = eINSTANCE.getClass_Name();

		/**
		 * The meta object literal for the '<em><b>Lot</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__LOT = eINSTANCE.getClass_Lot();

		/**
		 * The meta object literal for the '<em><b>Judge</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__JUDGE = eINSTANCE.getClass_Judge();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.LotImpl <em>Lot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.LotImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getLot()
		 * @generated
		 */
		EClass LOT = eINSTANCE.getLot();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOT__NAME = eINSTANCE.getLot_Name();

		/**
		 * The meta object literal for the '<em><b>Exhibit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOT__EXHIBIT = eINSTANCE.getLot_Exhibit();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.PeopleImpl <em>People</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.PeopleImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getPeople()
		 * @generated
		 */
		EClass PEOPLE = eINSTANCE.getPeople();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEOPLE__PERSON = eINSTANCE.getPeople_Person();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.PersonImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRST_NAME = eINSTANCE.getPerson_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LAST_NAME = eINSTANCE.getPerson_LastName();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__PHONE = eINSTANCE.getPerson_Phone();

		/**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__STREET = eINSTANCE.getPerson_Street();

		/**
		 * The meta object literal for the '<em><b>City</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__CITY = eINSTANCE.getPerson_City();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__STATE = eINSTANCE.getPerson_State();

		/**
		 * The meta object literal for the '<em><b>Zip Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ZIP_CODE = eINSTANCE.getPerson_ZipCode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.YoungPersonImpl <em>Young Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.YoungPersonImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getYoungPerson()
		 * @generated
		 */
		EClass YOUNG_PERSON = eINSTANCE.getYoungPerson();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference YOUNG_PERSON__PARENT = eINSTANCE.getYoungPerson_Parent();

		/**
		 * The meta object literal for the '<em><b>Club</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference YOUNG_PERSON__CLUB = eINSTANCE.getYoungPerson_Club();

		/**
		 * The meta object literal for the '<em>Zip Code</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getZipCode()
		 * @generated
		 */
		EDataType ZIP_CODE = eINSTANCE.getZipCode();

		/**
		 * The meta object literal for the '<em>US Telephone Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getUSTelephoneNumber()
		 * @generated
		 */
		EDataType US_TELEPHONE_NUMBER = eINSTANCE.getUSTelephoneNumber();

	}

} //FairPackage
