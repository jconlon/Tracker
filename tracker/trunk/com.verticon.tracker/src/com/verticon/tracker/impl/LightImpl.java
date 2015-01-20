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

import com.verticon.tracker.Light;
import com.verticon.tracker.Station;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Light</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.LightImpl#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.LightImpl#getStation <em>Station</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.LightImpl#getValues <em>Values</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.LightImpl#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.LightImpl#getSensorId <em>Sensor Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.LightImpl#getLux <em>Lux</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LightImpl extends MinimalEObjectImpl.Container implements Light {
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
	 * The default value of the '{@link #getLux() <em>Lux</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLux()
	 * @generated
	 * @ordered
	 */
	protected static final double LUX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLux() <em>Lux</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLux()
	 * @generated
	 * @ordered
	 */
	protected double lux = LUX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LightImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.LIGHT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.LIGHT__DATE_TIME, oldDateTime, dateTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Station getStation() {
		if (eContainerFeatureID() != TrackerPackage.LIGHT__STATION) return null;
		return (Station)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Station basicGetStation() {
		if (eContainerFeatureID() != TrackerPackage.LIGHT__STATION) return null;
		return (Station)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStation(Station newStation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStation, TrackerPackage.LIGHT__STATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStation(Station newStation) {
		if (newStation != eInternalContainer() || (eContainerFeatureID() != TrackerPackage.LIGHT__STATION && newStation != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.LIGHT__STATION, newStation, newStation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<Double> getValues() {
		EList<Double> result = new BasicEList<Double>();
		result.add(getLux());
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getMeasurement() {
		return Double.toHexString(getLux());
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.LIGHT__SENSOR_ID, oldSensorId, sensorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLux() {
		return lux;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLux(double newLux) {
		double oldLux = lux;
		lux = newLux;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.LIGHT__LUX, oldLux, lux));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.LIGHT__STATION:
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
			case TrackerPackage.LIGHT__STATION:
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
			case TrackerPackage.LIGHT__STATION:
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
			case TrackerPackage.LIGHT__DATE_TIME:
				return getDateTime();
			case TrackerPackage.LIGHT__STATION:
				if (resolve) return getStation();
				return basicGetStation();
			case TrackerPackage.LIGHT__VALUES:
				return getValues();
			case TrackerPackage.LIGHT__MEASUREMENT:
				return getMeasurement();
			case TrackerPackage.LIGHT__SENSOR_ID:
				return getSensorId();
			case TrackerPackage.LIGHT__LUX:
				return getLux();
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
			case TrackerPackage.LIGHT__DATE_TIME:
				setDateTime((Date)newValue);
				return;
			case TrackerPackage.LIGHT__STATION:
				setStation((Station)newValue);
				return;
			case TrackerPackage.LIGHT__SENSOR_ID:
				setSensorId((String)newValue);
				return;
			case TrackerPackage.LIGHT__LUX:
				setLux((Double)newValue);
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
			case TrackerPackage.LIGHT__DATE_TIME:
				setDateTime(DATE_TIME_EDEFAULT);
				return;
			case TrackerPackage.LIGHT__STATION:
				setStation((Station)null);
				return;
			case TrackerPackage.LIGHT__SENSOR_ID:
				setSensorId(SENSOR_ID_EDEFAULT);
				return;
			case TrackerPackage.LIGHT__LUX:
				setLux(LUX_EDEFAULT);
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
			case TrackerPackage.LIGHT__DATE_TIME:
				return DATE_TIME_EDEFAULT == null ? dateTime != null : !DATE_TIME_EDEFAULT.equals(dateTime);
			case TrackerPackage.LIGHT__STATION:
				return basicGetStation() != null;
			case TrackerPackage.LIGHT__VALUES:
				return !getValues().isEmpty();
			case TrackerPackage.LIGHT__MEASUREMENT:
				return MEASUREMENT_EDEFAULT == null ? getMeasurement() != null : !MEASUREMENT_EDEFAULT.equals(getMeasurement());
			case TrackerPackage.LIGHT__SENSOR_ID:
				return SENSOR_ID_EDEFAULT == null ? sensorId != null : !SENSOR_ID_EDEFAULT.equals(sensorId);
			case TrackerPackage.LIGHT__LUX:
				return lux != LUX_EDEFAULT;
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
		result.append(", Lux: ");
		result.append(lux);
		result.append(')');
		return result.toString();
	}

} //LightImpl
