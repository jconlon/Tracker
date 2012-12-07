/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location;

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
 * @see com.verticon.location.LocationFactory
 * @model kind="package"
 * @generated
 */
public interface LocationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "location";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.verticon.com/location/1.0/loc";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "loc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LocationPackage eINSTANCE = com.verticon.location.impl.LocationPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.verticon.location.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.impl.LocationImpl
	 * @see com.verticon.location.impl.LocationPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__PHONE_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__STREET = 3;

	/**
	 * The feature id for the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__CITY = 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__STATE = 5;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__POSTAL_CODE = 6;

	/**
	 * The feature id for the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__COUNTRY = 7;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__LONGITUDE = 8;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__LATITUDE = 9;

	/**
	 * The feature id for the '<em><b>Altitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__ALTITUDE = 10;

	/**
	 * The feature id for the '<em><b>Altitude Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__ALTITUDE_MODE = 11;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__COMMENTS = 12;

	/**
	 * The feature id for the '<em><b>Areas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__AREAS = 13;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link com.verticon.location.impl.AreaImpl <em>Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.impl.AreaImpl
	 * @see com.verticon.location.impl.LocationPackageImpl#getArea()
	 * @generated
	 */
	int AREA = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Boundary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__BOUNDARY = 1;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__COMMENTS = 2;

	/**
	 * The number of structural features of the '<em>Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.verticon.location.AltitudeMode <em>Altitude Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.AltitudeMode
	 * @see com.verticon.location.impl.LocationPackageImpl#getAltitudeMode()
	 * @generated
	 */
	int ALTITUDE_MODE = 2;

	/**
	 * The meta object id for the '<em>Point Format Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.IllegalArgumentException
	 * @see com.verticon.location.impl.LocationPackageImpl#getPointFormatException()
	 * @generated
	 */
	int POINT_FORMAT_EXCEPTION = 3;


	/**
	 * The meta object id for the '<em>Polygon</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.location.impl.LocationPackageImpl#getPolygon()
	 * @generated
	 */
	int POLYGON = 4;


	/**
	 * Returns the meta object for class '{@link com.verticon.location.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see com.verticon.location.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.location.Location#getName()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.verticon.location.Location#getDescription()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getPhoneNumber <em>Phone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone Number</em>'.
	 * @see com.verticon.location.Location#getPhoneNumber()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_PhoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see com.verticon.location.Location#getStreet()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Street();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getCity <em>City</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>City</em>'.
	 * @see com.verticon.location.Location#getCity()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_City();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.verticon.location.Location#getState()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_State();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Code</em>'.
	 * @see com.verticon.location.Location#getPostalCode()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_PostalCode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getCountry <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Country</em>'.
	 * @see com.verticon.location.Location#getCountry()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Country();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see com.verticon.location.Location#getLongitude()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Longitude();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see com.verticon.location.Location#getLatitude()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Latitude();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getAltitude <em>Altitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Altitude</em>'.
	 * @see com.verticon.location.Location#getAltitude()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Altitude();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getAltitudeMode <em>Altitude Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Altitude Mode</em>'.
	 * @see com.verticon.location.Location#getAltitudeMode()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_AltitudeMode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Location#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see com.verticon.location.Location#getComments()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Comments();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.location.Location#getAreas <em>Areas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Areas</em>'.
	 * @see com.verticon.location.Location#getAreas()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_Areas();

	/**
	 * Returns the meta object for class '{@link com.verticon.location.Area <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area</em>'.
	 * @see com.verticon.location.Area
	 * @generated
	 */
	EClass getArea();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Area#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.location.Area#getName()
	 * @see #getArea()
	 * @generated
	 */
	EAttribute getArea_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Area#getBoundary <em>Boundary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boundary</em>'.
	 * @see com.verticon.location.Area#getBoundary()
	 * @see #getArea()
	 * @generated
	 */
	EAttribute getArea_Boundary();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.location.Area#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see com.verticon.location.Area#getComments()
	 * @see #getArea()
	 * @generated
	 */
	EAttribute getArea_Comments();

	/**
	 * Returns the meta object for enum '{@link com.verticon.location.AltitudeMode <em>Altitude Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Altitude Mode</em>'.
	 * @see com.verticon.location.AltitudeMode
	 * @generated
	 */
	EEnum getAltitudeMode();

	/**
	 * Returns the meta object for data type '{@link java.lang.IllegalArgumentException <em>Point Format Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Point Format Exception</em>'.
	 * @see java.lang.IllegalArgumentException
	 * @model instanceClass="java.lang.IllegalArgumentException"
	 * @generated
	 */
	EDataType getPointFormatException();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Polygon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Polygon</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPolygon();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LocationFactory getLocationFactory();

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
		 * The meta object literal for the '{@link com.verticon.location.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.location.impl.LocationImpl
		 * @see com.verticon.location.impl.LocationPackageImpl#getLocation()
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
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__DESCRIPTION = eINSTANCE.getLocation_Description();

		/**
		 * The meta object literal for the '<em><b>Phone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__PHONE_NUMBER = eINSTANCE.getLocation_PhoneNumber();

		/**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__STREET = eINSTANCE.getLocation_Street();

		/**
		 * The meta object literal for the '<em><b>City</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__CITY = eINSTANCE.getLocation_City();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__STATE = eINSTANCE.getLocation_State();

		/**
		 * The meta object literal for the '<em><b>Postal Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__POSTAL_CODE = eINSTANCE.getLocation_PostalCode();

		/**
		 * The meta object literal for the '<em><b>Country</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__COUNTRY = eINSTANCE.getLocation_Country();

		/**
		 * The meta object literal for the '<em><b>Longitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__LONGITUDE = eINSTANCE.getLocation_Longitude();

		/**
		 * The meta object literal for the '<em><b>Latitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__LATITUDE = eINSTANCE.getLocation_Latitude();

		/**
		 * The meta object literal for the '<em><b>Altitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__ALTITUDE = eINSTANCE.getLocation_Altitude();

		/**
		 * The meta object literal for the '<em><b>Altitude Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__ALTITUDE_MODE = eINSTANCE.getLocation_AltitudeMode();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__COMMENTS = eINSTANCE.getLocation_Comments();

		/**
		 * The meta object literal for the '<em><b>Areas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__AREAS = eINSTANCE.getLocation_Areas();

		/**
		 * The meta object literal for the '{@link com.verticon.location.impl.AreaImpl <em>Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.location.impl.AreaImpl
		 * @see com.verticon.location.impl.LocationPackageImpl#getArea()
		 * @generated
		 */
		EClass AREA = eINSTANCE.getArea();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AREA__NAME = eINSTANCE.getArea_Name();

		/**
		 * The meta object literal for the '<em><b>Boundary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AREA__BOUNDARY = eINSTANCE.getArea_Boundary();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AREA__COMMENTS = eINSTANCE.getArea_Comments();

		/**
		 * The meta object literal for the '{@link com.verticon.location.AltitudeMode <em>Altitude Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.location.AltitudeMode
		 * @see com.verticon.location.impl.LocationPackageImpl#getAltitudeMode()
		 * @generated
		 */
		EEnum ALTITUDE_MODE = eINSTANCE.getAltitudeMode();

		/**
		 * The meta object literal for the '<em>Point Format Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.IllegalArgumentException
		 * @see com.verticon.location.impl.LocationPackageImpl#getPointFormatException()
		 * @generated
		 */
		EDataType POINT_FORMAT_EXCEPTION = eINSTANCE.getPointFormatException();

		/**
		 * The meta object literal for the '<em>Polygon</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.location.impl.LocationPackageImpl#getPolygon()
		 * @generated
		 */
		EDataType POLYGON = eINSTANCE.getPolygon();

	}

} //LocationPackage
