/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

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
	 * The feature id for the '<em><b>Exhibitors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__EXHIBITORS = 1;

	/**
	 * The feature id for the '<em><b>Clubs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__CLUBS = 2;

	/**
	 * The feature id for the '<em><b>Divisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__DIVISIONS = 3;

	/**
	 * The feature id for the '<em><b>Premises</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR__PREMISES = 4;

	/**
	 * The number of structural features of the '<em>Fair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIR_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.ExhibitorImpl <em>Exhibitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.ExhibitorImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getExhibitor()
	 * @generated
	 */
	int EXHIBITOR = 1;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Exhibits</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__EXHIBITS = 2;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__PHONE = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__PARENT = 4;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__COMMENTS = 5;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__STREET = 6;

	/**
	 * The feature id for the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__CITY = 7;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__STATE = 8;

	/**
	 * The feature id for the '<em><b>Zip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR__ZIP = 9;

	/**
	 * The number of structural features of the '<em>Exhibitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBITOR_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.ExhibitImpl <em>Exhibit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.ExhibitImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getExhibit()
	 * @generated
	 */
	int EXHIBIT = 2;

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
	 * The feature id for the '<em><b>Club</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT__CLUB = 2;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT__COMMENTS = 3;

	/**
	 * The feature id for the '<em><b>Animal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXHIBIT__ANIMAL = 4;

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
	int YOUTH_CLUB = 3;

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
	int DIVISION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Departments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__DEPARTMENTS = 1;

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
	int DEPARTMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__CLASSES = 1;

	/**
	 * The number of structural features of the '<em>Department</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.ClassImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__LOTS = 1;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.verticon.tracker.fair.impl.LotImpl <em>Lot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.fair.impl.LotImpl
	 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getLot()
	 * @generated
	 */
	int LOT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Exhibits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOT__EXHIBITS = 1;

	/**
	 * The number of structural features of the '<em>Lot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOT_FEATURE_COUNT = 2;


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
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Fair#getExhibitors <em>Exhibitors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exhibitors</em>'.
	 * @see com.verticon.tracker.fair.Fair#getExhibitors()
	 * @see #getFair()
	 * @generated
	 */
	EReference getFair_Exhibitors();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Fair#getClubs <em>Clubs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clubs</em>'.
	 * @see com.verticon.tracker.fair.Fair#getClubs()
	 * @see #getFair()
	 * @generated
	 */
	EReference getFair_Clubs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Fair#getDivisions <em>Divisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Divisions</em>'.
	 * @see com.verticon.tracker.fair.Fair#getDivisions()
	 * @see #getFair()
	 * @generated
	 */
	EReference getFair_Divisions();

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
	 * Returns the meta object for class '{@link com.verticon.tracker.fair.Exhibitor <em>Exhibitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exhibitor</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor
	 * @generated
	 */
	EClass getExhibitor();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getFirstName()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getLastName()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_LastName();

	/**
	 * Returns the meta object for the reference list '{@link com.verticon.tracker.fair.Exhibitor#getExhibits <em>Exhibits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exhibits</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getExhibits()
	 * @see #getExhibitor()
	 * @generated
	 */
	EReference getExhibitor_Exhibits();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getPhone()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_Phone();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getParent()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_Parent();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getComments()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_Comments();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getStreet()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_Street();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getCity <em>City</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>City</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getCity()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_City();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getState()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_State();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.tracker.fair.Exhibitor#getZip <em>Zip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zip</em>'.
	 * @see com.verticon.tracker.fair.Exhibitor#getZip()
	 * @see #getExhibitor()
	 * @generated
	 */
	EAttribute getExhibitor_Zip();

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
	 * Returns the meta object for the reference '{@link com.verticon.tracker.fair.Exhibit#getClub <em>Club</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Club</em>'.
	 * @see com.verticon.tracker.fair.Exhibit#getClub()
	 * @see #getExhibit()
	 * @generated
	 */
	EReference getExhibit_Club();

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
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Division#getDepartments <em>Departments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Departments</em>'.
	 * @see com.verticon.tracker.fair.Division#getDepartments()
	 * @see #getDivision()
	 * @generated
	 */
	EReference getDivision_Departments();

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
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Department#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see com.verticon.tracker.fair.Department#getClasses()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_Classes();

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
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Class#getLots <em>Lots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lots</em>'.
	 * @see com.verticon.tracker.fair.Class#getLots()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Lots();

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
	 * Returns the meta object for the containment reference list '{@link com.verticon.tracker.fair.Lot#getExhibits <em>Exhibits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exhibits</em>'.
	 * @see com.verticon.tracker.fair.Lot#getExhibits()
	 * @see #getLot()
	 * @generated
	 */
	EReference getLot_Exhibits();

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
		 * The meta object literal for the '<em><b>Exhibitors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAIR__EXHIBITORS = eINSTANCE.getFair_Exhibitors();

		/**
		 * The meta object literal for the '<em><b>Clubs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAIR__CLUBS = eINSTANCE.getFair_Clubs();

		/**
		 * The meta object literal for the '<em><b>Divisions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAIR__DIVISIONS = eINSTANCE.getFair_Divisions();

		/**
		 * The meta object literal for the '<em><b>Premises</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAIR__PREMISES = eINSTANCE.getFair_Premises();

		/**
		 * The meta object literal for the '{@link com.verticon.tracker.fair.impl.ExhibitorImpl <em>Exhibitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.tracker.fair.impl.ExhibitorImpl
		 * @see com.verticon.tracker.fair.impl.FairPackageImpl#getExhibitor()
		 * @generated
		 */
		EClass EXHIBITOR = eINSTANCE.getExhibitor();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__FIRST_NAME = eINSTANCE.getExhibitor_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__LAST_NAME = eINSTANCE.getExhibitor_LastName();

		/**
		 * The meta object literal for the '<em><b>Exhibits</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXHIBITOR__EXHIBITS = eINSTANCE.getExhibitor_Exhibits();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__PHONE = eINSTANCE.getExhibitor_Phone();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__PARENT = eINSTANCE.getExhibitor_Parent();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__COMMENTS = eINSTANCE.getExhibitor_Comments();

		/**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__STREET = eINSTANCE.getExhibitor_Street();

		/**
		 * The meta object literal for the '<em><b>City</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__CITY = eINSTANCE.getExhibitor_City();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__STATE = eINSTANCE.getExhibitor_State();

		/**
		 * The meta object literal for the '<em><b>Zip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXHIBITOR__ZIP = eINSTANCE.getExhibitor_Zip();

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
		 * The meta object literal for the '<em><b>Club</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXHIBIT__CLUB = eINSTANCE.getExhibit_Club();

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
		 * The meta object literal for the '<em><b>Departments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIVISION__DEPARTMENTS = eINSTANCE.getDivision_Departments();

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
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPARTMENT__CLASSES = eINSTANCE.getDepartment_Classes();

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
		 * The meta object literal for the '<em><b>Lots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__LOTS = eINSTANCE.getClass_Lots();

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
		 * The meta object literal for the '<em><b>Exhibits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOT__EXHIBITS = eINSTANCE.getLot_Exhibits();

	}

} //FairPackage
