/**
 * Copyright 2010 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.tracker.Position;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.TrackerPlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PositionImpl#getLocationName <em>Location Name</em>}</li>
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
	 * The default value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LONGITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected double longitude = LONGITUDE_EDEFAULT;

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
	 * The cached value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected double latitude = LATITUDE_EDEFAULT;

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
	protected static final String LOCATION_NAME_EDEFAULT = "";

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

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public double getLongitude() {
//		double result = LONGITUDE_IN_RADIANS_EDEFAULT;
//		if(getLongitudeInRadians()!=LONGITUDE_IN_RADIANS_EDEFAULT){
//			result = degrees(getLongitudeInRadians());
//		}
//		
//		return result;
//
//	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public double getLatitude() {
//		double result = LATITUDE_IN_RADIANS_EDEFAULT;
//		if(getLatitudeInRadians()!=LATITUDE_IN_RADIANS_EDEFAULT){
//			result = degrees(getLatitudeInRadians());
//		}
//		
//		return result;
//	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitude(double newLongitude) {
		double oldLongitude = longitude;
		longitude = newLongitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.POSITION__LONGITUDE, oldLongitude, longitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitude(double newLatitude) {
		double oldLatitude = latitude;
		latitude = newLatitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.POSITION__LATITUDE, oldLatitude, latitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCoordinates() {
		StringBuilder builder = new StringBuilder();
		builder.append(getLongitude());
		builder.append(',');
		builder.append(getLatitude());
		builder.append(',');
		builder.append('0');
		return builder.toString();
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * @return local Location Name for the position coordinates
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLocationName() {
		if(resolvedLocation!=null){
			return resolvedLocation;
		}
		String result = null;
		if(eContainer()!=null && getCoordinates()!=null){
			//Has a tag parent
			if(eContainer().eContainer()!=null){
				//Has an animal grandParent
				if(eContainer().eContainer().eContainer()!=null){
					//Has an premises great-grandParent
					Premises premises = (Premises)eContainer().eContainer().eContainer();
					if(premises.getLocation()!=null){
						result = premises.getLocation().locate(getCoordinates());
					}
				}
			}
		}
		return result;
	}
	
	private String resolvedLocation = null;

	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.impl.EventImpl#findPublisherName()
	 */
	@Override
	public String findPublisherName() {
		findLocationName();
		return super.findPublisherName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @return the local or from the LocationService the foreign location Name
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String findLocationName() {
		String oldLocation = getLocationName();
		resolvedLocation=null;
		String location = getLocationName();
		if(location==null && getCoordinates()!=null){
			resolvedLocation = TrackerPlugin.getDefault().locate(getCoordinates());
		}
		String newLocation = getLocationName();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this, Notification.SET, TrackerPackage.POSITION__LOCATION_NAME, oldLocation, newLocation));
		
		return newLocation;		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.POSITION__LONGITUDE:
				return getLongitude();
			case TrackerPackage.POSITION__LATITUDE:
				return getLatitude();
			case TrackerPackage.POSITION__COORDINATES:
				return getCoordinates();
			case TrackerPackage.POSITION__LOCATION_NAME:
				return getLocationName();
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
			case TrackerPackage.POSITION__LONGITUDE:
				setLongitude((Double)newValue);
				return;
			case TrackerPackage.POSITION__LATITUDE:
				setLatitude((Double)newValue);
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
			case TrackerPackage.POSITION__LONGITUDE:
				setLongitude(LONGITUDE_EDEFAULT);
				return;
			case TrackerPackage.POSITION__LATITUDE:
				setLatitude(LATITUDE_EDEFAULT);
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
			case TrackerPackage.POSITION__LONGITUDE:
				return longitude != LONGITUDE_EDEFAULT;
			case TrackerPackage.POSITION__LATITUDE:
				return latitude != LATITUDE_EDEFAULT;
			case TrackerPackage.POSITION__COORDINATES:
				return COORDINATES_EDEFAULT == null ? getCoordinates() != null : !COORDINATES_EDEFAULT.equals(getCoordinates());
			case TrackerPackage.POSITION__LOCATION_NAME:
				return LOCATION_NAME_EDEFAULT == null ? getLocationName() != null : !LOCATION_NAME_EDEFAULT.equals(getLocationName());
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
		result.append(" (longitude: ");
		result.append(longitude);
		result.append(", latitude: ");
		result.append(latitude);
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
