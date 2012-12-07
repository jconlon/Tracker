/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.location.AltitudeMode;
import com.verticon.location.Area;
import com.verticon.location.Location;
import com.verticon.location.LocationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getCity <em>City</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getState <em>State</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getCountry <em>Country</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getAltitude <em>Altitude</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getAltitudeMode <em>Altitude Mode</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.location.impl.LocationImpl#getAreas <em>Areas</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationImpl extends MinimalEObjectImpl.Container implements Location {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhoneNumber() <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoneNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String PHONE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhoneNumber() <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoneNumber()
	 * @generated
	 * @ordered
	 */
	protected String phoneNumber = PHONE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected String street = STREET_EDEFAULT;

	/**
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected static final String CITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected String city = CITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected String state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTAL_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected String postalCode = POSTAL_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected static final String COUNTRY_EDEFAULT = "United States";

	/**
	 * The cached value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected String country = COUNTRY_EDEFAULT;

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
	 * This is true if the Longitude attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean longitudeESet;

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
	 * This is true if the Latitude attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean latitudeESet;

	/**
	 * The default value of the '{@link #getAltitude() <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitude()
	 * @generated
	 * @ordered
	 */
	protected static final double ALTITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAltitude() <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitude()
	 * @generated
	 * @ordered
	 */
	protected double altitude = ALTITUDE_EDEFAULT;

	/**
	 * This is true if the Altitude attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean altitudeESet;

	/**
	 * The default value of the '{@link #getAltitudeMode() <em>Altitude Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitudeMode()
	 * @generated
	 * @ordered
	 */
	protected static final AltitudeMode ALTITUDE_MODE_EDEFAULT = AltitudeMode.ABSOLUTE;

	/**
	 * The cached value of the '{@link #getAltitudeMode() <em>Altitude Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitudeMode()
	 * @generated
	 * @ordered
	 */
	protected AltitudeMode altitudeMode = ALTITUDE_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected String comments = COMMENTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAreas() <em>Areas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreas()
	 * @generated
	 * @ordered
	 */
	protected EList<Area> areas;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LocationPackage.Literals.LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhoneNumber(String newPhoneNumber) {
		String oldPhoneNumber = phoneNumber;
		phoneNumber = newPhoneNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__PHONE_NUMBER, oldPhoneNumber, phoneNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__STREET, oldStreet, street));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCity(String newCity) {
		String oldCity = city;
		city = newCity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__CITY, oldCity, city));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(String newState) {
		String oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalCode(String newPostalCode) {
		String oldPostalCode = postalCode;
		postalCode = newPostalCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__POSTAL_CODE, oldPostalCode, postalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountry(String newCountry) {
		String oldCountry = country;
		country = newCountry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__COUNTRY, oldCountry, country));
	}

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
		boolean oldLongitudeESet = longitudeESet;
		longitudeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__LONGITUDE, oldLongitude, longitude, !oldLongitudeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongitude() {
		double oldLongitude = longitude;
		boolean oldLongitudeESet = longitudeESet;
		longitude = LONGITUDE_EDEFAULT;
		longitudeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LocationPackage.LOCATION__LONGITUDE, oldLongitude, LONGITUDE_EDEFAULT, oldLongitudeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongitude() {
		return longitudeESet;
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
		boolean oldLatitudeESet = latitudeESet;
		latitudeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__LATITUDE, oldLatitude, latitude, !oldLatitudeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLatitude() {
		double oldLatitude = latitude;
		boolean oldLatitudeESet = latitudeESet;
		latitude = LATITUDE_EDEFAULT;
		latitudeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LocationPackage.LOCATION__LATITUDE, oldLatitude, LATITUDE_EDEFAULT, oldLatitudeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLatitude() {
		return latitudeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAltitude() {
		return altitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAltitude(double newAltitude) {
		double oldAltitude = altitude;
		altitude = newAltitude;
		boolean oldAltitudeESet = altitudeESet;
		altitudeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__ALTITUDE, oldAltitude, altitude, !oldAltitudeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAltitude() {
		double oldAltitude = altitude;
		boolean oldAltitudeESet = altitudeESet;
		altitude = ALTITUDE_EDEFAULT;
		altitudeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LocationPackage.LOCATION__ALTITUDE, oldAltitude, ALTITUDE_EDEFAULT, oldAltitudeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAltitude() {
		return altitudeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AltitudeMode getAltitudeMode() {
		return altitudeMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAltitudeMode(AltitudeMode newAltitudeMode) {
		AltitudeMode oldAltitudeMode = altitudeMode;
		altitudeMode = newAltitudeMode == null ? ALTITUDE_MODE_EDEFAULT : newAltitudeMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__ALTITUDE_MODE, oldAltitudeMode, altitudeMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(String newComments) {
		String oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Area> getAreas() {
		if (areas == null) {
			areas = new EObjectContainmentEList<Area>(Area.class, this, LocationPackage.LOCATION__AREAS);
		}
		return areas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCoordinates() {
		StringBuffer buff = new StringBuffer();
		buff.append(getLongitude()).append(',').append(getLatitude()).append(',').append(getAltitude());
		return buff.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAddress() {
		StringBuffer buff = new StringBuffer();
		buff.append(getStreet()).append(" ").append(getCity()).append(", ").append(getState()).append(' ').append(getPostalCode());
		return buff.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsPoint(String point) throws IllegalArgumentException {
		for (Area area : getAreas()) {
			if(area.containsPoint(point)){
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * public String locate(Point point) {
		String result = null;
		BoundedLocation currentPolygon = null;
		for (BoundedLocation polygon : boundedLocations) {
			if (polygon.contains(point)) {
				if (currentPolygon == null) {
					currentPolygon = polygon;
					result = polygon.getName();
				} else if (polygon.getArea() < currentPolygon.getArea()) {
					currentPolygon = polygon;
					result = polygon.getName();
				}
			}
		}

		return result;
	}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String locate(String point) throws IllegalArgumentException {
		String result = null;
		double currentAreaMeasurement = Double.MAX_VALUE;
		for (Area area : getAreas()) {
			if(area.containsPoint(point)){
				if(area.getAreaMeasurement()<currentAreaMeasurement){
					result = area.getName();
					currentAreaMeasurement= area.getAreaMeasurement();
				}
				
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LocationPackage.LOCATION__AREAS:
				return ((InternalEList<?>)getAreas()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LocationPackage.LOCATION__NAME:
				return getName();
			case LocationPackage.LOCATION__DESCRIPTION:
				return getDescription();
			case LocationPackage.LOCATION__PHONE_NUMBER:
				return getPhoneNumber();
			case LocationPackage.LOCATION__STREET:
				return getStreet();
			case LocationPackage.LOCATION__CITY:
				return getCity();
			case LocationPackage.LOCATION__STATE:
				return getState();
			case LocationPackage.LOCATION__POSTAL_CODE:
				return getPostalCode();
			case LocationPackage.LOCATION__COUNTRY:
				return getCountry();
			case LocationPackage.LOCATION__LONGITUDE:
				return getLongitude();
			case LocationPackage.LOCATION__LATITUDE:
				return getLatitude();
			case LocationPackage.LOCATION__ALTITUDE:
				return getAltitude();
			case LocationPackage.LOCATION__ALTITUDE_MODE:
				return getAltitudeMode();
			case LocationPackage.LOCATION__COMMENTS:
				return getComments();
			case LocationPackage.LOCATION__AREAS:
				return getAreas();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LocationPackage.LOCATION__NAME:
				setName((String)newValue);
				return;
			case LocationPackage.LOCATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LocationPackage.LOCATION__PHONE_NUMBER:
				setPhoneNumber((String)newValue);
				return;
			case LocationPackage.LOCATION__STREET:
				setStreet((String)newValue);
				return;
			case LocationPackage.LOCATION__CITY:
				setCity((String)newValue);
				return;
			case LocationPackage.LOCATION__STATE:
				setState((String)newValue);
				return;
			case LocationPackage.LOCATION__POSTAL_CODE:
				setPostalCode((String)newValue);
				return;
			case LocationPackage.LOCATION__COUNTRY:
				setCountry((String)newValue);
				return;
			case LocationPackage.LOCATION__LONGITUDE:
				setLongitude((Double)newValue);
				return;
			case LocationPackage.LOCATION__LATITUDE:
				setLatitude((Double)newValue);
				return;
			case LocationPackage.LOCATION__ALTITUDE:
				setAltitude((Double)newValue);
				return;
			case LocationPackage.LOCATION__ALTITUDE_MODE:
				setAltitudeMode((AltitudeMode)newValue);
				return;
			case LocationPackage.LOCATION__COMMENTS:
				setComments((String)newValue);
				return;
			case LocationPackage.LOCATION__AREAS:
				getAreas().clear();
				getAreas().addAll((Collection<? extends Area>)newValue);
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
			case LocationPackage.LOCATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LocationPackage.LOCATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LocationPackage.LOCATION__PHONE_NUMBER:
				setPhoneNumber(PHONE_NUMBER_EDEFAULT);
				return;
			case LocationPackage.LOCATION__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case LocationPackage.LOCATION__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case LocationPackage.LOCATION__STATE:
				setState(STATE_EDEFAULT);
				return;
			case LocationPackage.LOCATION__POSTAL_CODE:
				setPostalCode(POSTAL_CODE_EDEFAULT);
				return;
			case LocationPackage.LOCATION__COUNTRY:
				setCountry(COUNTRY_EDEFAULT);
				return;
			case LocationPackage.LOCATION__LONGITUDE:
				unsetLongitude();
				return;
			case LocationPackage.LOCATION__LATITUDE:
				unsetLatitude();
				return;
			case LocationPackage.LOCATION__ALTITUDE:
				unsetAltitude();
				return;
			case LocationPackage.LOCATION__ALTITUDE_MODE:
				setAltitudeMode(ALTITUDE_MODE_EDEFAULT);
				return;
			case LocationPackage.LOCATION__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case LocationPackage.LOCATION__AREAS:
				getAreas().clear();
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
			case LocationPackage.LOCATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LocationPackage.LOCATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LocationPackage.LOCATION__PHONE_NUMBER:
				return PHONE_NUMBER_EDEFAULT == null ? phoneNumber != null : !PHONE_NUMBER_EDEFAULT.equals(phoneNumber);
			case LocationPackage.LOCATION__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case LocationPackage.LOCATION__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case LocationPackage.LOCATION__STATE:
				return STATE_EDEFAULT == null ? state != null : !STATE_EDEFAULT.equals(state);
			case LocationPackage.LOCATION__POSTAL_CODE:
				return POSTAL_CODE_EDEFAULT == null ? postalCode != null : !POSTAL_CODE_EDEFAULT.equals(postalCode);
			case LocationPackage.LOCATION__COUNTRY:
				return COUNTRY_EDEFAULT == null ? country != null : !COUNTRY_EDEFAULT.equals(country);
			case LocationPackage.LOCATION__LONGITUDE:
				return isSetLongitude();
			case LocationPackage.LOCATION__LATITUDE:
				return isSetLatitude();
			case LocationPackage.LOCATION__ALTITUDE:
				return isSetAltitude();
			case LocationPackage.LOCATION__ALTITUDE_MODE:
				return altitudeMode != ALTITUDE_MODE_EDEFAULT;
			case LocationPackage.LOCATION__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case LocationPackage.LOCATION__AREAS:
				return areas != null && !areas.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", phoneNumber: ");
		result.append(phoneNumber);
		result.append(", street: ");
		result.append(street);
		result.append(", city: ");
		result.append(city);
		result.append(", state: ");
		result.append(state);
		result.append(", postalCode: ");
		result.append(postalCode);
		result.append(", country: ");
		result.append(country);
		result.append(", longitude: ");
		if (longitudeESet) result.append(longitude); else result.append("<unset>");
		result.append(", latitude: ");
		if (latitudeESet) result.append(latitude); else result.append("<unset>");
		result.append(", altitude: ");
		if (altitudeESet) result.append(altitude); else result.append("<unset>");
		result.append(", altitudeMode: ");
		result.append(altitudeMode);
		result.append(", comments: ");
		result.append(comments);
		result.append(')');
		return result.toString();
	}

} //LocationImpl
