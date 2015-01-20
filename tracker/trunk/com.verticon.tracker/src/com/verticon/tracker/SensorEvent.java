/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sensor Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.SensorEvent#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.SensorEvent#getStation <em>Station</em>}</li>
 *   <li>{@link com.verticon.tracker.SensorEvent#getValues <em>Values</em>}</li>
 *   <li>{@link com.verticon.tracker.SensorEvent#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link com.verticon.tracker.SensorEvent#getSensorId <em>Sensor Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getSensorEvent()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SensorEvent extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Time</em>' attribute.
	 * @see #setDateTime(Date)
	 * @see com.verticon.tracker.TrackerPackage#getSensorEvent_DateTime()
	 * @model
	 * @generated
	 */
	Date getDateTime();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.SensorEvent#getDateTime <em>Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Time</em>' attribute.
	 * @see #getDateTime()
	 * @generated
	 */
	void setDateTime(Date value);

	/**
	 * Returns the value of the '<em><b>Station</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.Station#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Station</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Station</em>' container reference.
	 * @see #setStation(Station)
	 * @see com.verticon.tracker.TrackerPackage#getSensorEvent_Station()
	 * @see com.verticon.tracker.Station#getEvents
	 * @model opposite="events" required="true" transient="false"
	 * @generated
	 */
	Station getStation();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.SensorEvent#getStation <em>Station</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Station</em>' container reference.
	 * @see #getStation()
	 * @generated
	 */
	void setStation(Station value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see com.verticon.tracker.TrackerPackage#getSensorEvent_Values()
	 * @model required="true" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	EList<Double> getValues();

	/**
	 * Returns the value of the '<em><b>Measurement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getSensorEvent_Measurement()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getMeasurement();

	/**
	 * Returns the value of the '<em><b>Sensor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sensor Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensor Id</em>' attribute.
	 * @see #setSensorId(String)
	 * @see com.verticon.tracker.TrackerPackage#getSensorEvent_SensorId()
	 * @model required="true"
	 * @generated
	 */
	String getSensorId();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.SensorEvent#getSensorId <em>Sensor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sensor Id</em>' attribute.
	 * @see #getSensorId()
	 * @generated
	 */
	void setSensorId(String value);

} // SensorEvent
