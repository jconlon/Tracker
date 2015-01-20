/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Station</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Station#getId <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.Station#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.Station#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.tracker.Station#getPremises <em>Premises</em>}</li>
 *   <li>{@link com.verticon.tracker.Station#getLocationName <em>Location Name</em>}</li>
 *   <li>{@link com.verticon.tracker.Station#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link com.verticon.tracker.Station#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getStation()
 * @model
 * @generated
 */
public interface Station extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.verticon.tracker.TrackerPackage#getStation_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Station#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see com.verticon.tracker.TrackerPackage#getStation_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Station#getName <em>Name</em>}' attribute.
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
	 * @see com.verticon.tracker.TrackerPackage#getStation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Station#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Premises</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.Premises#getStations <em>Stations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Premises</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Premises</em>' container reference.
	 * @see #setPremises(Premises)
	 * @see com.verticon.tracker.TrackerPackage#getStation_Premises()
	 * @see com.verticon.tracker.Premises#getStations
	 * @model opposite="stations" required="true" transient="false"
	 * @generated
	 */
	Premises getPremises();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Station#getPremises <em>Premises</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premises</em>' container reference.
	 * @see #getPremises()
	 * @generated
	 */
	void setPremises(Premises value);

	/**
	 * Returns the value of the '<em><b>Location Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Name</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getStation_LocationName()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getLocationName();

	/**
	 * Returns the value of the '<em><b>Coordinates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinates</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinates</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getStation_Coordinates()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getCoordinates();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.SensorEvent}.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.SensorEvent#getStation <em>Station</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getStation_Events()
	 * @see com.verticon.tracker.SensorEvent#getStation
	 * @model opposite="station" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<SensorEvent> getEvents();

} // Station
