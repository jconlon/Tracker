/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.verticon.tracker.Station;
import com.verticon.tracker.StationLocation;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.TrackerPlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Station Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getStation <em>Station</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getValues <em>Values</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getSensorId <em>Sensor Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getLocationName <em>Location Name</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getLat <em>Lat</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationLocationImpl#getLong <em>Long</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StationLocationImpl extends MinimalEObjectImpl.Container implements StationLocation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";


	/**
	 * The default value of the '{@link #getDateTime() <em>Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTime()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateTime() <em>Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTime()
	 * @generated
	 * @ordered
	 */
	protected Date dateTime = DATE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeasurement() <em>Measurement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurement()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASUREMENT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSensorId() <em>Sensor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensorId()
	 * @generated
	 * @ordered
	 */
	protected static final String SENSOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSensorId() <em>Sensor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensorId()
	 * @generated
	 * @ordered
	 */
	protected String sensorId = SENSOR_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoordinates() <em>Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinates()
	 * @generated
	 * @ordered
	 */
	protected static final String COORDINATES_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLocationName() <em>Location Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationName()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLat() <em>Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLat()
	 * @generated
	 * @ordered
	 */
	protected static final double LAT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLat() <em>Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLat()
	 * @generated
	 * @ordered
	 */
	protected double lat = LAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLong() <em>Long</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLong()
	 * @generated
	 * @ordered
	 */
	protected static final double LONG_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLong() <em>Long</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLong()
	 * @generated
	 * @ordered
	 */
	protected double long_ = LONG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StationLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.STATION_LOCATION;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDateTime(Date newDateTime) {
		Date oldDateTime = dateTime;
		dateTime = newDateTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION_LOCATION__DATE_TIME, oldDateTime, dateTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Station getStation() {
		if (eContainerFeatureID() != TrackerPackage.STATION_LOCATION__STATION) return null;
		return (Station)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Station basicGetStation() {
		if (eContainerFeatureID() != TrackerPackage.STATION_LOCATION__STATION) return null;
		return (Station)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStation(Station newStation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStation, TrackerPackage.STATION_LOCATION__STATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStation(Station newStation) {
		if (newStation != eInternalContainer() || (eContainerFeatureID() != TrackerPackage.STATION_LOCATION__STATION && newStation != null)) {
			if (EcoreUtil.isAncestor(this, newStation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newStation != null)
				msgs = ((InternalEObject)newStation).eInverseAdd(this, TrackerPackage.STATION__EVENTS, Station.class, msgs);
			msgs = basicSetStation(newStation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION_LOCATION__STATION, newStation, newStation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<Double> getValues() {
		EList<Double> result = new BasicEList<Double>();
		result.add(getLong());
		result.add(getLat());
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getMeasurement() {
		return getCoordinates();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSensorId() {
		return sensorId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSensorId(String newSensorId) {
		String oldSensorId = sensorId;
		sensorId = newSensorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION_LOCATION__SENSOR_ID, oldSensorId, sensorId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getCoordinates() {
		StringBuilder builder = new StringBuilder();
		builder.append(getLong());
		builder.append(',');
		builder.append(getLat());
		return builder.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getLocationName() {
		return TrackerPlugin.getDefault().locate(getCoordinates());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLat() {
		return lat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLat(double newLat) {
		double oldLat = lat;
		lat = newLat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION_LOCATION__LAT, oldLat, lat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLong() {
		return long_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLong(double newLong) {
		double oldLong = long_;
		long_ = newLong;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION_LOCATION__LONG, oldLong, long_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.STATION_LOCATION__STATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetStation((Station)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.STATION_LOCATION__STATION:
				return basicSetStation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TrackerPackage.STATION_LOCATION__STATION:
				return eInternalContainer().eInverseRemove(this, TrackerPackage.STATION__EVENTS, Station.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.STATION_LOCATION__DATE_TIME:
				return getDateTime();
			case TrackerPackage.STATION_LOCATION__STATION:
				if (resolve) return getStation();
				return basicGetStation();
			case TrackerPackage.STATION_LOCATION__VALUES:
				return getValues();
			case TrackerPackage.STATION_LOCATION__MEASUREMENT:
				return getMeasurement();
			case TrackerPackage.STATION_LOCATION__SENSOR_ID:
				return getSensorId();
			case TrackerPackage.STATION_LOCATION__COORDINATES:
				return getCoordinates();
			case TrackerPackage.STATION_LOCATION__LOCATION_NAME:
				return getLocationName();
			case TrackerPackage.STATION_LOCATION__LAT:
				return getLat();
			case TrackerPackage.STATION_LOCATION__LONG:
				return getLong();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.STATION_LOCATION__DATE_TIME:
				setDateTime((Date)newValue);
				return;
			case TrackerPackage.STATION_LOCATION__STATION:
				setStation((Station)newValue);
				return;
			case TrackerPackage.STATION_LOCATION__SENSOR_ID:
				setSensorId((String)newValue);
				return;
			case TrackerPackage.STATION_LOCATION__LAT:
				setLat((Double)newValue);
				return;
			case TrackerPackage.STATION_LOCATION__LONG:
				setLong((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.STATION_LOCATION__DATE_TIME:
				setDateTime(DATE_TIME_EDEFAULT);
				return;
			case TrackerPackage.STATION_LOCATION__STATION:
				setStation((Station)null);
				return;
			case TrackerPackage.STATION_LOCATION__SENSOR_ID:
				setSensorId(SENSOR_ID_EDEFAULT);
				return;
			case TrackerPackage.STATION_LOCATION__LAT:
				setLat(LAT_EDEFAULT);
				return;
			case TrackerPackage.STATION_LOCATION__LONG:
				setLong(LONG_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.STATION_LOCATION__DATE_TIME:
				return DATE_TIME_EDEFAULT == null ? dateTime != null : !DATE_TIME_EDEFAULT.equals(dateTime);
			case TrackerPackage.STATION_LOCATION__STATION:
				return basicGetStation() != null;
			case TrackerPackage.STATION_LOCATION__VALUES:
				return !getValues().isEmpty();
			case TrackerPackage.STATION_LOCATION__MEASUREMENT:
				return MEASUREMENT_EDEFAULT == null ? getMeasurement() != null : !MEASUREMENT_EDEFAULT.equals(getMeasurement());
			case TrackerPackage.STATION_LOCATION__SENSOR_ID:
				return SENSOR_ID_EDEFAULT == null ? sensorId != null : !SENSOR_ID_EDEFAULT.equals(sensorId);
			case TrackerPackage.STATION_LOCATION__COORDINATES:
				return COORDINATES_EDEFAULT == null ? getCoordinates() != null : !COORDINATES_EDEFAULT.equals(getCoordinates());
			case TrackerPackage.STATION_LOCATION__LOCATION_NAME:
				return LOCATION_NAME_EDEFAULT == null ? getLocationName() != null : !LOCATION_NAME_EDEFAULT.equals(getLocationName());
			case TrackerPackage.STATION_LOCATION__LAT:
				return lat != LAT_EDEFAULT;
			case TrackerPackage.STATION_LOCATION__LONG:
				return long_ != LONG_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dateTime: ");
		result.append(dateTime);
		result.append(", sensorId: ");
		result.append(sensorId);
		result.append(", lat: ");
		result.append(lat);
		result.append(", long: ");
		result.append(long_);
		result.append(')');
		return result.toString();
	}

} //StationLocationImpl
