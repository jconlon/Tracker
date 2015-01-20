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

import com.verticon.tracker.Orientation;
import com.verticon.tracker.Station;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orientation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.OrientationImpl#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.OrientationImpl#getStation <em>Station</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.OrientationImpl#getValues <em>Values</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.OrientationImpl#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.OrientationImpl#getSensorId <em>Sensor Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.OrientationImpl#getAz <em>Az</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.OrientationImpl#getPitch <em>Pitch</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.OrientationImpl#getRoll <em>Roll</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrientationImpl extends MinimalEObjectImpl.Container implements Orientation {
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
	 * The default value of the '{@link #getAz() <em>Az</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAz()
	 * @generated
	 * @ordered
	 */
	protected static final double AZ_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAz() <em>Az</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAz()
	 * @generated
	 * @ordered
	 */
	protected double az = AZ_EDEFAULT;

	/**
	 * The default value of the '{@link #getPitch() <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitch()
	 * @generated
	 * @ordered
	 */
	protected static final double PITCH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPitch() <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitch()
	 * @generated
	 * @ordered
	 */
	protected double pitch = PITCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getRoll() <em>Roll</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoll()
	 * @generated
	 * @ordered
	 */
	protected static final double ROLL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRoll() <em>Roll</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoll()
	 * @generated
	 * @ordered
	 */
	protected double roll = ROLL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrientationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.ORIENTATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ORIENTATION__DATE_TIME, oldDateTime, dateTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Station getStation() {
		if (eContainerFeatureID() != TrackerPackage.ORIENTATION__STATION) return null;
		return (Station)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Station basicGetStation() {
		if (eContainerFeatureID() != TrackerPackage.ORIENTATION__STATION) return null;
		return (Station)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStation(Station newStation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStation, TrackerPackage.ORIENTATION__STATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStation(Station newStation) {
		if (newStation != eInternalContainer() || (eContainerFeatureID() != TrackerPackage.ORIENTATION__STATION && newStation != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ORIENTATION__STATION, newStation, newStation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<Double> getValues() {
		EList<Double> result = new BasicEList<Double>();
		result.add(getAz());
		result.add(getPitch());
		result.add(getRoll());
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getMeasurement() {
		StringBuilder builder = new StringBuilder();
		builder.append(getAz());
		builder.append(',');
		builder.append(getPitch());
		builder.append(',');
		builder.append(getRoll());
		return builder.toString();
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ORIENTATION__SENSOR_ID, oldSensorId, sensorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getAz() {
		return az;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAz(double newAz) {
		double oldAz = az;
		az = newAz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ORIENTATION__AZ, oldAz, az));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPitch() {
		return pitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPitch(double newPitch) {
		double oldPitch = pitch;
		pitch = newPitch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ORIENTATION__PITCH, oldPitch, pitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRoll() {
		return roll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRoll(double newRoll) {
		double oldRoll = roll;
		roll = newRoll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ORIENTATION__ROLL, oldRoll, roll));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.ORIENTATION__STATION:
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
			case TrackerPackage.ORIENTATION__STATION:
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
			case TrackerPackage.ORIENTATION__STATION:
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
			case TrackerPackage.ORIENTATION__DATE_TIME:
				return getDateTime();
			case TrackerPackage.ORIENTATION__STATION:
				if (resolve) return getStation();
				return basicGetStation();
			case TrackerPackage.ORIENTATION__VALUES:
				return getValues();
			case TrackerPackage.ORIENTATION__MEASUREMENT:
				return getMeasurement();
			case TrackerPackage.ORIENTATION__SENSOR_ID:
				return getSensorId();
			case TrackerPackage.ORIENTATION__AZ:
				return getAz();
			case TrackerPackage.ORIENTATION__PITCH:
				return getPitch();
			case TrackerPackage.ORIENTATION__ROLL:
				return getRoll();
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
			case TrackerPackage.ORIENTATION__DATE_TIME:
				setDateTime((Date)newValue);
				return;
			case TrackerPackage.ORIENTATION__STATION:
				setStation((Station)newValue);
				return;
			case TrackerPackage.ORIENTATION__SENSOR_ID:
				setSensorId((String)newValue);
				return;
			case TrackerPackage.ORIENTATION__AZ:
				setAz((Double)newValue);
				return;
			case TrackerPackage.ORIENTATION__PITCH:
				setPitch((Double)newValue);
				return;
			case TrackerPackage.ORIENTATION__ROLL:
				setRoll((Double)newValue);
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
			case TrackerPackage.ORIENTATION__DATE_TIME:
				setDateTime(DATE_TIME_EDEFAULT);
				return;
			case TrackerPackage.ORIENTATION__STATION:
				setStation((Station)null);
				return;
			case TrackerPackage.ORIENTATION__SENSOR_ID:
				setSensorId(SENSOR_ID_EDEFAULT);
				return;
			case TrackerPackage.ORIENTATION__AZ:
				setAz(AZ_EDEFAULT);
				return;
			case TrackerPackage.ORIENTATION__PITCH:
				setPitch(PITCH_EDEFAULT);
				return;
			case TrackerPackage.ORIENTATION__ROLL:
				setRoll(ROLL_EDEFAULT);
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
			case TrackerPackage.ORIENTATION__DATE_TIME:
				return DATE_TIME_EDEFAULT == null ? dateTime != null : !DATE_TIME_EDEFAULT.equals(dateTime);
			case TrackerPackage.ORIENTATION__STATION:
				return basicGetStation() != null;
			case TrackerPackage.ORIENTATION__VALUES:
				return !getValues().isEmpty();
			case TrackerPackage.ORIENTATION__MEASUREMENT:
				return MEASUREMENT_EDEFAULT == null ? getMeasurement() != null : !MEASUREMENT_EDEFAULT.equals(getMeasurement());
			case TrackerPackage.ORIENTATION__SENSOR_ID:
				return SENSOR_ID_EDEFAULT == null ? sensorId != null : !SENSOR_ID_EDEFAULT.equals(sensorId);
			case TrackerPackage.ORIENTATION__AZ:
				return az != AZ_EDEFAULT;
			case TrackerPackage.ORIENTATION__PITCH:
				return pitch != PITCH_EDEFAULT;
			case TrackerPackage.ORIENTATION__ROLL:
				return roll != ROLL_EDEFAULT;
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
		result.append(", az: ");
		result.append(az);
		result.append(", pitch: ");
		result.append(pitch);
		result.append(", roll: ");
		result.append(roll);
		result.append(')');
		return result.toString();
	}

} //OrientationImpl
