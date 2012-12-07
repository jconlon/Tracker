/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.location.Location#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.location.Location#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.location.Location#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.verticon.location.Location#getStreet <em>Street</em>}</li>
 *   <li>{@link com.verticon.location.Location#getCity <em>City</em>}</li>
 *   <li>{@link com.verticon.location.Location#getState <em>State</em>}</li>
 *   <li>{@link com.verticon.location.Location#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.location.Location#getCountry <em>Country</em>}</li>
 *   <li>{@link com.verticon.location.Location#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.location.Location#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link com.verticon.location.Location#getAltitude <em>Altitude</em>}</li>
 *   <li>{@link com.verticon.location.Location#getAltitudeMode <em>Altitude Mode</em>}</li>
 *   <li>{@link com.verticon.location.Location#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.location.Location#getAreas <em>Areas</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.location.LocationPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.verticon.location.LocationPackage#getLocation_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.verticon.location.LocationPackage#getLocation_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Number</em>' attribute.
	 * @see #setPhoneNumber(String)
	 * @see com.verticon.location.LocationPackage#getLocation_PhoneNumber()
	 * @model
	 * @generated
	 */
	String getPhoneNumber();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getPhoneNumber <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone Number</em>' attribute.
	 * @see #getPhoneNumber()
	 * @generated
	 */
	void setPhoneNumber(String value);

	/**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Street</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Street</em>' attribute.
	 * @see #setStreet(String)
	 * @see com.verticon.location.LocationPackage#getLocation_Street()
	 * @model required="true"
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #getStreet()
	 * @generated
	 */
	void setStreet(String value);

	/**
	 * Returns the value of the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>City</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>City</em>' attribute.
	 * @see #setCity(String)
	 * @see com.verticon.location.LocationPackage#getLocation_City()
	 * @model required="true"
	 * @generated
	 */
	String getCity();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @see #getCity()
	 * @generated
	 */
	void setCity(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #setState(String)
	 * @see com.verticon.location.LocationPackage#getLocation_State()
	 * @model required="true"
	 * @generated
	 */
	String getState();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #getState()
	 * @generated
	 */
	void setState(String value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Code</em>' attribute.
	 * @see #setPostalCode(String)
	 * @see com.verticon.location.LocationPackage#getLocation_PostalCode()
	 * @model required="true"
	 * @generated
	 */
	String getPostalCode();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getPostalCode <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' attribute.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(String value);

	/**
	 * Returns the value of the '<em><b>Country</b></em>' attribute.
	 * The default value is <code>"United States"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Country</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Country</em>' attribute.
	 * @see #setCountry(String)
	 * @see com.verticon.location.LocationPackage#getLocation_Country()
	 * @model default="United States" required="true"
	 * @generated
	 */
	String getCountry();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getCountry <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country</em>' attribute.
	 * @see #getCountry()
	 * @generated
	 */
	void setCountry(String value);

	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #isSetLongitude()
	 * @see #unsetLongitude()
	 * @see #setLongitude(double)
	 * @see com.verticon.location.LocationPackage#getLocation_Longitude()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
	double getLongitude();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #isSetLongitude()
	 * @see #unsetLongitude()
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(double value);

	/**
	 * Unsets the value of the '{@link com.verticon.location.Location#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitude()
	 * @see #getLongitude()
	 * @see #setLongitude(double)
	 * @generated
	 */
	void unsetLongitude();

	/**
	 * Returns whether the value of the '{@link com.verticon.location.Location#getLongitude <em>Longitude</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitude</em>' attribute is set.
	 * @see #unsetLongitude()
	 * @see #getLongitude()
	 * @see #setLongitude(double)
	 * @generated
	 */
	boolean isSetLongitude();

	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #isSetLatitude()
	 * @see #unsetLatitude()
	 * @see #setLatitude(double)
	 * @see com.verticon.location.LocationPackage#getLocation_Latitude()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
	double getLatitude();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #isSetLatitude()
	 * @see #unsetLatitude()
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(double value);

	/**
	 * Unsets the value of the '{@link com.verticon.location.Location#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLatitude()
	 * @see #getLatitude()
	 * @see #setLatitude(double)
	 * @generated
	 */
	void unsetLatitude();

	/**
	 * Returns whether the value of the '{@link com.verticon.location.Location#getLatitude <em>Latitude</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Latitude</em>' attribute is set.
	 * @see #unsetLatitude()
	 * @see #getLatitude()
	 * @see #setLatitude(double)
	 * @generated
	 */
	boolean isSetLatitude();

	/**
	 * Returns the value of the '<em><b>Altitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Altitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Altitude</em>' attribute.
	 * @see #isSetAltitude()
	 * @see #unsetAltitude()
	 * @see #setAltitude(double)
	 * @see com.verticon.location.LocationPackage#getLocation_Altitude()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
	double getAltitude();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getAltitude <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Altitude</em>' attribute.
	 * @see #isSetAltitude()
	 * @see #unsetAltitude()
	 * @see #getAltitude()
	 * @generated
	 */
	void setAltitude(double value);

	/**
	 * Unsets the value of the '{@link com.verticon.location.Location#getAltitude <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAltitude()
	 * @see #getAltitude()
	 * @see #setAltitude(double)
	 * @generated
	 */
	void unsetAltitude();

	/**
	 * Returns whether the value of the '{@link com.verticon.location.Location#getAltitude <em>Altitude</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Altitude</em>' attribute is set.
	 * @see #unsetAltitude()
	 * @see #getAltitude()
	 * @see #setAltitude(double)
	 * @generated
	 */
	boolean isSetAltitude();

	/**
	 * Returns the value of the '<em><b>Altitude Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.location.AltitudeMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Altitude Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Altitude Mode</em>' attribute.
	 * @see com.verticon.location.AltitudeMode
	 * @see #setAltitudeMode(AltitudeMode)
	 * @see com.verticon.location.LocationPackage#getLocation_AltitudeMode()
	 * @model required="true"
	 * @generated
	 */
	AltitudeMode getAltitudeMode();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getAltitudeMode <em>Altitude Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Altitude Mode</em>' attribute.
	 * @see com.verticon.location.AltitudeMode
	 * @see #getAltitudeMode()
	 * @generated
	 */
	void setAltitudeMode(AltitudeMode value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(String)
	 * @see com.verticon.location.LocationPackage#getLocation_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.location.Location#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Areas</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.location.Area}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Areas</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Areas</em>' containment reference list.
	 * @see com.verticon.location.LocationPackage#getLocation_Areas()
	 * @model containment="true"
	 * @generated
	 */
	EList<Area> getAreas();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getCoordinates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getAddress();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="com.verticon.location.PointFormatException"
	 * @generated
	 */
	boolean containsPoint(String point) throws IllegalArgumentException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="com.verticon.location.PointFormatException"
	 * @generated
	 */
	String locate(String point) throws IllegalArgumentException;

} // Location
