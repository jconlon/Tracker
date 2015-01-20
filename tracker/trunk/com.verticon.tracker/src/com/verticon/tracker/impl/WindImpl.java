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
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.Wind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wind</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getStation <em>Station</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getValues <em>Values</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getSensorId <em>Sensor Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getM_s <em>Ms</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getMph <em>Mph</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getR <em>R</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getDegrees <em>Degrees</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WindImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindImpl extends MinimalEObjectImpl.Container implements Wind {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	private static final String[] DIRECTIONS = { "N", "NE", "E", "SE", "S",
			"SW", "W", "NW", "N" };

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
	 * The default value of the '{@link #getM_s() <em>Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_s()
	 * @generated
	 * @ordered
	 */
	protected static final double MS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getM_s() <em>Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_s()
	 * @generated
	 * @ordered
	 */
	protected double m_s = MS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMph() <em>Mph</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMph()
	 * @generated
	 * @ordered
	 */
	protected static final double MPH_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected static final double R_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected double r = R_EDEFAULT;

	/**
	 * The default value of the '{@link #getDegrees() <em>Degrees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDegrees()
	 * @generated
	 * @ordered
	 */
	protected static final double DEGREES_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final String DIRECTION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.WIND;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WIND__DATE_TIME, oldDateTime, dateTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Station getStation() {
		if (eContainerFeatureID() != TrackerPackage.WIND__STATION) return null;
		return (Station)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Station basicGetStation() {
		if (eContainerFeatureID() != TrackerPackage.WIND__STATION) return null;
		return (Station)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStation(Station newStation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStation, TrackerPackage.WIND__STATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStation(Station newStation) {
		if (newStation != eInternalContainer() || (eContainerFeatureID() != TrackerPackage.WIND__STATION && newStation != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WIND__STATION, newStation, newStation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<Double> getValues() {
		EList<Double> result = new BasicEList<Double>();
		result.add(getM_s());
		result.add(getR());
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
		builder.append(getM_s());
		builder.append(',');
		builder.append(getR());
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WIND__SENSOR_ID, oldSensorId, sensorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getM_s() {
		return m_s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setM_s(double newM_s) {
		double oldM_s = m_s;
		m_s = newM_s;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WIND__MS, oldM_s, m_s));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public double getMph() {
		return 0.44704 * m_s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getR() {
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setR(double newR) {
		double oldR = r;
		r = newR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WIND__R, oldR, r));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public double getDegrees() {
		return Math.toDegrees(r);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getDirection() {
		double x = getDegrees();
		return DIRECTIONS[(int) Math.round(((x % 360) / 45))];
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.WIND__STATION:
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
			case TrackerPackage.WIND__STATION:
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
			case TrackerPackage.WIND__STATION:
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
			case TrackerPackage.WIND__DATE_TIME:
				return getDateTime();
			case TrackerPackage.WIND__STATION:
				if (resolve) return getStation();
				return basicGetStation();
			case TrackerPackage.WIND__VALUES:
				return getValues();
			case TrackerPackage.WIND__MEASUREMENT:
				return getMeasurement();
			case TrackerPackage.WIND__SENSOR_ID:
				return getSensorId();
			case TrackerPackage.WIND__MS:
				return getM_s();
			case TrackerPackage.WIND__MPH:
				return getMph();
			case TrackerPackage.WIND__R:
				return getR();
			case TrackerPackage.WIND__DEGREES:
				return getDegrees();
			case TrackerPackage.WIND__DIRECTION:
				return getDirection();
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
			case TrackerPackage.WIND__DATE_TIME:
				setDateTime((Date)newValue);
				return;
			case TrackerPackage.WIND__STATION:
				setStation((Station)newValue);
				return;
			case TrackerPackage.WIND__SENSOR_ID:
				setSensorId((String)newValue);
				return;
			case TrackerPackage.WIND__MS:
				setM_s((Double)newValue);
				return;
			case TrackerPackage.WIND__R:
				setR((Double)newValue);
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
			case TrackerPackage.WIND__DATE_TIME:
				setDateTime(DATE_TIME_EDEFAULT);
				return;
			case TrackerPackage.WIND__STATION:
				setStation((Station)null);
				return;
			case TrackerPackage.WIND__SENSOR_ID:
				setSensorId(SENSOR_ID_EDEFAULT);
				return;
			case TrackerPackage.WIND__MS:
				setM_s(MS_EDEFAULT);
				return;
			case TrackerPackage.WIND__R:
				setR(R_EDEFAULT);
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
			case TrackerPackage.WIND__DATE_TIME:
				return DATE_TIME_EDEFAULT == null ? dateTime != null : !DATE_TIME_EDEFAULT.equals(dateTime);
			case TrackerPackage.WIND__STATION:
				return basicGetStation() != null;
			case TrackerPackage.WIND__VALUES:
				return !getValues().isEmpty();
			case TrackerPackage.WIND__MEASUREMENT:
				return MEASUREMENT_EDEFAULT == null ? getMeasurement() != null : !MEASUREMENT_EDEFAULT.equals(getMeasurement());
			case TrackerPackage.WIND__SENSOR_ID:
				return SENSOR_ID_EDEFAULT == null ? sensorId != null : !SENSOR_ID_EDEFAULT.equals(sensorId);
			case TrackerPackage.WIND__MS:
				return m_s != MS_EDEFAULT;
			case TrackerPackage.WIND__MPH:
				return getMph() != MPH_EDEFAULT;
			case TrackerPackage.WIND__R:
				return r != R_EDEFAULT;
			case TrackerPackage.WIND__DEGREES:
				return getDegrees() != DEGREES_EDEFAULT;
			case TrackerPackage.WIND__DIRECTION:
				return DIRECTION_EDEFAULT == null ? getDirection() != null : !DIRECTION_EDEFAULT.equals(getDirection());
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
		result.append(", m_s: ");
		result.append(m_s);
		result.append(", r: ");
		result.append(r);
		result.append(')');
		return result.toString();
	}

} //WindImpl
