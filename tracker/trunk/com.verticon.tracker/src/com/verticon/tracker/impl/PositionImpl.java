/**
 * Copyright 2010 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker.impl;

import com.verticon.tracker.Position;
import com.verticon.tracker.TrackerPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLongitudeInRadians <em>Longitude In Radians</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLongitudeError <em>Longitude Error</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLatitudeInRadians <em>Latitude In Radians</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLatitudeError <em>Latitude Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PositionImpl extends EventImpl implements Position {
	
	private static final int EVENT_CODE = 15;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getLongitudeInRadians() <em>Longitude In Radians</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitudeInRadians()
	 * @generated
	 * @ordered
	 */
	protected static final double LONGITUDE_IN_RADIANS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLongitudeInRadians() <em>Longitude In Radians</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitudeInRadians()
	 * @generated
	 * @ordered
	 */
	protected double longitudeInRadians = LONGITUDE_IN_RADIANS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LONGITUDE_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getLongitudeError() <em>Longitude Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitudeError()
	 * @generated
	 * @ordered
	 */
	protected static final double LONGITUDE_ERROR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLongitudeError() <em>Longitude Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitudeError()
	 * @generated
	 * @ordered
	 */
	protected double longitudeError = LONGITUDE_ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getLatitudeInRadians() <em>Latitude In Radians</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitudeInRadians()
	 * @generated
	 * @ordered
	 */
	protected static final double LATITUDE_IN_RADIANS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLatitudeInRadians() <em>Latitude In Radians</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitudeInRadians()
	 * @generated
	 * @ordered
	 */
	protected double latitudeInRadians = LATITUDE_IN_RADIANS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LATITUDE_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getLatitudeError() <em>Latitude Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitudeError()
	 * @generated
	 * @ordered
	 */
	protected static final double LATITUDE_ERROR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLatitudeError() <em>Latitude Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitudeError()
	 * @generated
	 * @ordered
	 */
	protected double latitudeError = LATITUDE_ERROR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PositionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.POSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitudeInRadians() {
		return longitudeInRadians;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudeInRadians(double newLongitudeInRadians) {
		double oldLongitudeInRadians = longitudeInRadians;
		longitudeInRadians = newLongitudeInRadians;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.POSITION__LONGITUDE_IN_RADIANS, oldLongitudeInRadians, longitudeInRadians));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitudeError() {
		return longitudeError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudeError(double newLongitudeError) {
		double oldLongitudeError = longitudeError;
		longitudeError = newLongitudeError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.POSITION__LONGITUDE_ERROR, oldLongitudeError, longitudeError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLatitudeInRadians() {
		return latitudeInRadians;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitudeInRadians(double newLatitudeInRadians) {
		double oldLatitudeInRadians = latitudeInRadians;
		latitudeInRadians = newLatitudeInRadians;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.POSITION__LATITUDE_IN_RADIANS, oldLatitudeInRadians, latitudeInRadians));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getLongitude() {
		double result = LONGITUDE_IN_RADIANS_EDEFAULT;
		if(getLongitudeInRadians()!=LONGITUDE_IN_RADIANS_EDEFAULT){
			result = degrees(getLongitudeInRadians());
		}
		
		return result;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getLatitude() {
		double result = LATITUDE_IN_RADIANS_EDEFAULT;
		if(getLatitudeInRadians()!=LATITUDE_IN_RADIANS_EDEFAULT){
			result = degrees(getLatitudeInRadians());
		}
		
		return result;
	}
	
	private static final double degrees(double radians) {
		return radians * 360 / (2*Math.PI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLatitudeError() {
		return latitudeError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitudeError(double newLatitudeError) {
		double oldLatitudeError = latitudeError;
		latitudeError = newLatitudeError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.POSITION__LATITUDE_ERROR, oldLatitudeError, latitudeError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.POSITION__LONGITUDE_IN_RADIANS:
				return getLongitudeInRadians();
			case TrackerPackage.POSITION__LONGITUDE:
				return getLongitude();
			case TrackerPackage.POSITION__LONGITUDE_ERROR:
				return getLongitudeError();
			case TrackerPackage.POSITION__LATITUDE_IN_RADIANS:
				return getLatitudeInRadians();
			case TrackerPackage.POSITION__LATITUDE:
				return getLatitude();
			case TrackerPackage.POSITION__LATITUDE_ERROR:
				return getLatitudeError();
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
			case TrackerPackage.POSITION__LONGITUDE_IN_RADIANS:
				setLongitudeInRadians((Double)newValue);
				return;
			case TrackerPackage.POSITION__LONGITUDE_ERROR:
				setLongitudeError((Double)newValue);
				return;
			case TrackerPackage.POSITION__LATITUDE_IN_RADIANS:
				setLatitudeInRadians((Double)newValue);
				return;
			case TrackerPackage.POSITION__LATITUDE_ERROR:
				setLatitudeError((Double)newValue);
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
			case TrackerPackage.POSITION__LONGITUDE_IN_RADIANS:
				setLongitudeInRadians(LONGITUDE_IN_RADIANS_EDEFAULT);
				return;
			case TrackerPackage.POSITION__LONGITUDE_ERROR:
				setLongitudeError(LONGITUDE_ERROR_EDEFAULT);
				return;
			case TrackerPackage.POSITION__LATITUDE_IN_RADIANS:
				setLatitudeInRadians(LATITUDE_IN_RADIANS_EDEFAULT);
				return;
			case TrackerPackage.POSITION__LATITUDE_ERROR:
				setLatitudeError(LATITUDE_ERROR_EDEFAULT);
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
			case TrackerPackage.POSITION__LONGITUDE_IN_RADIANS:
				return longitudeInRadians != LONGITUDE_IN_RADIANS_EDEFAULT;
			case TrackerPackage.POSITION__LONGITUDE:
				return getLongitude() != LONGITUDE_EDEFAULT;
			case TrackerPackage.POSITION__LONGITUDE_ERROR:
				return longitudeError != LONGITUDE_ERROR_EDEFAULT;
			case TrackerPackage.POSITION__LATITUDE_IN_RADIANS:
				return latitudeInRadians != LATITUDE_IN_RADIANS_EDEFAULT;
			case TrackerPackage.POSITION__LATITUDE:
				return getLatitude() != LATITUDE_EDEFAULT;
			case TrackerPackage.POSITION__LATITUDE_ERROR:
				return latitudeError != LATITUDE_ERROR_EDEFAULT;
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
		result.append(" (longitudeInRadians: ");
		result.append(longitudeInRadians);
		result.append(", longitudeError: ");
		result.append(longitudeError);
		result.append(", latitudeInRadians: ");
		result.append(latitudeInRadians);
		result.append(", latitudeError: ");
		result.append(latitudeError);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getEventCode() {
		return EVENT_CODE;
	}

} //PositionImpl
