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

import com.verticon.tracker.Air;
import com.verticon.tracker.Station;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Air</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getStation <em>Station</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getValues <em>Values</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getSensorId <em>Sensor Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getK <em>K</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getFarenheit <em>Farenheit</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getCelsius <em>Celsius</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getPa <em>Pa</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getIncheOfMercury <em>Inche Of Mercury</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AirImpl#getRh <em>Rh</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AirImpl extends MinimalEObjectImpl.Container implements Air {
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
	 * The default value of the '{@link #getK() <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected static final double K_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getK() <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected double k = K_EDEFAULT;

	/**
	 * The default value of the '{@link #getFarenheit() <em>Farenheit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFarenheit()
	 * @generated
	 * @ordered
	 */
	protected static final double FARENHEIT_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getCelsius() <em>Celsius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCelsius()
	 * @generated
	 * @ordered
	 */
	protected static final double CELSIUS_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getPa() <em>Pa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPa()
	 * @generated
	 * @ordered
	 */
	protected static final double PA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPa() <em>Pa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPa()
	 * @generated
	 * @ordered
	 */
	protected double pa = PA_EDEFAULT;

	/**
	 * The default value of the '{@link #getIncheOfMercury() <em>Inche Of Mercury</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncheOfMercury()
	 * @generated
	 * @ordered
	 */
	protected static final double INCHE_OF_MERCURY_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getRh() <em>Rh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRh()
	 * @generated
	 * @ordered
	 */
	protected static final double RH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRh() <em>Rh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRh()
	 * @generated
	 * @ordered
	 */
	protected double rh = RH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AirImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.AIR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.AIR__DATE_TIME, oldDateTime, dateTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Station getStation() {
		if (eContainerFeatureID() != TrackerPackage.AIR__STATION) return null;
		return (Station)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Station basicGetStation() {
		if (eContainerFeatureID() != TrackerPackage.AIR__STATION) return null;
		return (Station)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStation(Station newStation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStation, TrackerPackage.AIR__STATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStation(Station newStation) {
		if (newStation != eInternalContainer() || (eContainerFeatureID() != TrackerPackage.AIR__STATION && newStation != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.AIR__STATION, newStation, newStation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<Double> getValues() {
		EList<Double> result = new BasicEList<Double>();
		result.add(getK());
		result.add(getPa());
		result.add(getRh());
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
		builder.append(getK());
		builder.append(',');
		builder.append(getPa());
		builder.append(',');
		builder.append(getRh());
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.AIR__SENSOR_ID, oldSensorId, sensorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getK() {
		return k;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setK(double newK) {
		double oldK = k;
		k = newK;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.AIR__K, oldK, k));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public double getFarenheit() {
		return (k * 9 / 5) - 459.67;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public double getCelsius() {
		return k - 273.15;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPa() {
		return pa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPa(double newPa) {
		double oldPa = pa;
		pa = newPa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.AIR__PA, oldPa, pa));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public double getIncheOfMercury() {
		return 3386.389 * pa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRh() {
		return rh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRh(double newRh) {
		double oldRh = rh;
		rh = newRh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.AIR__RH, oldRh, rh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.AIR__STATION:
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
			case TrackerPackage.AIR__STATION:
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
			case TrackerPackage.AIR__STATION:
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
			case TrackerPackage.AIR__DATE_TIME:
				return getDateTime();
			case TrackerPackage.AIR__STATION:
				if (resolve) return getStation();
				return basicGetStation();
			case TrackerPackage.AIR__VALUES:
				return getValues();
			case TrackerPackage.AIR__MEASUREMENT:
				return getMeasurement();
			case TrackerPackage.AIR__SENSOR_ID:
				return getSensorId();
			case TrackerPackage.AIR__K:
				return getK();
			case TrackerPackage.AIR__FARENHEIT:
				return getFarenheit();
			case TrackerPackage.AIR__CELSIUS:
				return getCelsius();
			case TrackerPackage.AIR__PA:
				return getPa();
			case TrackerPackage.AIR__INCHE_OF_MERCURY:
				return getIncheOfMercury();
			case TrackerPackage.AIR__RH:
				return getRh();
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
			case TrackerPackage.AIR__DATE_TIME:
				setDateTime((Date)newValue);
				return;
			case TrackerPackage.AIR__STATION:
				setStation((Station)newValue);
				return;
			case TrackerPackage.AIR__SENSOR_ID:
				setSensorId((String)newValue);
				return;
			case TrackerPackage.AIR__K:
				setK((Double)newValue);
				return;
			case TrackerPackage.AIR__PA:
				setPa((Double)newValue);
				return;
			case TrackerPackage.AIR__RH:
				setRh((Double)newValue);
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
			case TrackerPackage.AIR__DATE_TIME:
				setDateTime(DATE_TIME_EDEFAULT);
				return;
			case TrackerPackage.AIR__STATION:
				setStation((Station)null);
				return;
			case TrackerPackage.AIR__SENSOR_ID:
				setSensorId(SENSOR_ID_EDEFAULT);
				return;
			case TrackerPackage.AIR__K:
				setK(K_EDEFAULT);
				return;
			case TrackerPackage.AIR__PA:
				setPa(PA_EDEFAULT);
				return;
			case TrackerPackage.AIR__RH:
				setRh(RH_EDEFAULT);
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
			case TrackerPackage.AIR__DATE_TIME:
				return DATE_TIME_EDEFAULT == null ? dateTime != null : !DATE_TIME_EDEFAULT.equals(dateTime);
			case TrackerPackage.AIR__STATION:
				return basicGetStation() != null;
			case TrackerPackage.AIR__VALUES:
				return !getValues().isEmpty();
			case TrackerPackage.AIR__MEASUREMENT:
				return MEASUREMENT_EDEFAULT == null ? getMeasurement() != null : !MEASUREMENT_EDEFAULT.equals(getMeasurement());
			case TrackerPackage.AIR__SENSOR_ID:
				return SENSOR_ID_EDEFAULT == null ? sensorId != null : !SENSOR_ID_EDEFAULT.equals(sensorId);
			case TrackerPackage.AIR__K:
				return k != K_EDEFAULT;
			case TrackerPackage.AIR__FARENHEIT:
				return getFarenheit() != FARENHEIT_EDEFAULT;
			case TrackerPackage.AIR__CELSIUS:
				return getCelsius() != CELSIUS_EDEFAULT;
			case TrackerPackage.AIR__PA:
				return pa != PA_EDEFAULT;
			case TrackerPackage.AIR__INCHE_OF_MERCURY:
				return getIncheOfMercury() != INCHE_OF_MERCURY_EDEFAULT;
			case TrackerPackage.AIR__RH:
				return rh != RH_EDEFAULT;
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
		result.append(", k: ");
		result.append(k);
		result.append(", pa: ");
		result.append(pa);
		result.append(", rh: ");
		result.append(rh);
		result.append(')');
		return result.toString();
	}

} //AirImpl
