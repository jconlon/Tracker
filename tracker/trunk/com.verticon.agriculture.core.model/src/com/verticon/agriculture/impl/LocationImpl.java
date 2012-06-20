/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.agriculture.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.verticon.agriculture.AgriculturePackage;
import com.verticon.agriculture.AltitudeMode;
import com.verticon.agriculture.Location;
import com.verticon.opengis.kml.Feature;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location</b></em>'.
 * 
 * See http://dev.eclipse.org/newslists/news.eclipse.tools.emf/msg33053.html for dealing with 
 * derived attributes.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getGeography <em>Geography</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getLivestock <em>Livestock</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getCity <em>City</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getState <em>State</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getCountry <em>Country</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getAltitude <em>Altitude</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getAltitudeMode <em>Altitude Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationImpl extends MinimalEObjectImpl.Container implements Location {
	/**
	 * The cached value of the '{@link #getGeography() <em>Geography</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeography()
	 * @generated
	 * @ordered
	 */
	protected com.verticon.opengis.kml.Container geography;

	/**
	 * The cached value of the '{@link #getLivestock() <em>Livestock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLivestock()
	 * @generated
	 * @ordered
	 */
	protected Premises livestock;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

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
		return AgriculturePackage.Literals.LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.verticon.opengis.kml.Container getGeography() {
		if (geography != null && geography.eIsProxy()) {
			InternalEObject oldGeography = (InternalEObject)geography;
			geography = (com.verticon.opengis.kml.Container)eResolveProxy(oldGeography);
			if (geography != oldGeography) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AgriculturePackage.LOCATION__GEOGRAPHY, oldGeography, geography));
			}
		}
		return geography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.verticon.opengis.kml.Container basicGetGeography() {
		return geography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeography(com.verticon.opengis.kml.Container newGeography) {
		com.verticon.opengis.kml.Container oldGeography = geography;
		geography = newGeography;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__GEOGRAPHY, oldGeography, geography));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises getLivestock() {
		if (livestock != null && livestock.eIsProxy()) {
			InternalEObject oldLivestock = (InternalEObject)livestock;
			livestock = (Premises)eResolveProxy(oldLivestock);
			if (livestock != oldLivestock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AgriculturePackage.LOCATION__LIVESTOCK, oldLivestock, livestock));
			}
		}
		return livestock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises basicGetLivestock() {
		return livestock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLivestock(Premises newLivestock) {
		Premises oldLivestock = livestock;
		livestock = newLivestock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__LIVESTOCK, oldLivestock, livestock));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUri() {
		return getLivestock()==null?null:livestock.getUri();
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__PHONE_NUMBER, oldPhoneNumber, phoneNumber));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__STREET, oldStreet, street));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__CITY, oldCity, city));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__STATE, oldState, state));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__POSTAL_CODE, oldPostalCode, postalCode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__COUNTRY, oldCountry, country));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__LONGITUDE, oldLongitude, longitude, !oldLongitudeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, AgriculturePackage.LOCATION__LONGITUDE, oldLongitude, LONGITUDE_EDEFAULT, oldLongitudeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__LATITUDE, oldLatitude, latitude, !oldLatitudeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, AgriculturePackage.LOCATION__LATITUDE, oldLatitude, LATITUDE_EDEFAULT, oldLatitudeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__ALTITUDE, oldAltitude, altitude, !oldAltitudeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, AgriculturePackage.LOCATION__ALTITUDE, oldAltitude, ALTITUDE_EDEFAULT, oldAltitudeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__ALTITUDE_MODE, oldAltitudeMode, altitudeMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAddress() {
		StringBuffer buff = new StringBuffer();
		buff.append(getStreet()).append(" ").append(getCity()).append(',').append(getState()).append(' ').append(getPostalCode());
		return buff.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCoordinates() {
		StringBuffer buff = new StringBuffer();
		buff.append(getLongitude()).append(", ").append(getLatitude()).append(", ").append(getAltitude());
		return buff.toString();
	}

	//	/**
//	 * <!-- begin-user-doc -->
//	 * Placemark name
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getName() {
//		String result = null;
//		if(place !=null){
//			result= place.getName();
//		};
//		return result;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Placemark description
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getDescription() {
//		String result = null;
//		if(place !=null){
//			result= place.getDescription();
//		};
//		return result;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Placemark phoneNumber
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getPhoneNumber() {
//		String result = null;
//		if(place !=null){
//			result= Strings.emptyToNull(place.getPhoneNumber());
//		};
//		return result;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Placemark Address Details Thoroughfare Name
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getStreet() {
//		String result = null;
//		if(place !=null && place.getAddressDetails()!=null && place.getAddressDetails().getThoroughfare()!=null && place.getAddressDetails().getThoroughfare().getThoroughfareName()!=null){
//				StringBuffer buff = new StringBuffer();
//				for (ThoroughfareName thoroghfareName : place.getAddressDetails().getThoroughfare().getThoroughfareName()) {
//					FeatureMap m = thoroghfareName.getMixed();
//					appendText(buff, m);
//				}
//				result= buff.toString();
//		}
//		return result;
//	}
//	
//	
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Placemark addressDetails Locality DependentLocality DependentLocalityName
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getCity() {
//		String result = null;
//		if(place !=null && place.getAddressDetails()!=null && place.getAddressDetails().getLocality()!=null && place.getAddressDetails().getLocality().getDependentLocality()!=null &&
//				!place.getAddressDetails().getLocality().getDependentLocality().getDependentLocalityName().isEmpty()){
//			StringBuffer buff = new StringBuffer();
//			for (DependentLocalityName localityName :place.getAddressDetails().getLocality().getDependentLocality().getDependentLocalityName()) {
//				FeatureMap m = localityName.getMixed();
//				appendText(buff, m);
//			}
//			result= buff.toString();
//		};
//		return result;
//	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * Placemark addressDetails Locality LocalityName
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getState() {
//		String result = null;
//		if(place !=null && place.getAddressDetails()!=null && place.getAddressDetails().getLocality()!=null && 
//				!place.getAddressDetails().getLocality().getLocalityName().isEmpty()
//				){
//			StringBuffer buff = new StringBuffer();
//			for (LocalityName localityName : place.getAddressDetails().getLocality().getLocalityName()) {
//				FeatureMap m = localityName.getMixed();
//				appendText(buff, m);
//			}
//			result= buff.toString();
//		};
//		return result;
//	}
//
//	private void appendText(StringBuffer buff, FeatureMap m) {
//		for (FeatureMap.Entry entry : m) {
//			if(entry.getEStructuralFeature().getName().equals("text")){
//			if(buff.length()>0){
//				buff.append(',');
//			}
//			buff.append(entry.getValue());
//			}
//		}
//	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * Placemark addressDetails Locality PostalCode PostalCodeNumber
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getPostalCode() {
//		String result = null;
//		if(place !=null && place.getAddressDetails()!=null && place.getAddressDetails().getLocality()!=null && 
//				place.getAddressDetails().getLocality().getPostalCode()!=null && 
//				place.getAddressDetails().getLocality().getPostalCode().getPostalCodeNumber()!=null 
//				){
//			
//			StringBuffer buff = new StringBuffer();
//			for (PostalCodeNumber postalCodeNumber : place.getAddressDetails().getLocality().getPostalCode().getPostalCodeNumber()) {
//				FeatureMap m = postalCodeNumber.getMixed();
//				appendText(buff, m);
//			}
//			result= buff.toString();
//		};
//		return result;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Country name of the referenced place
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getCountry() {
//		String result = null;
//		if(place !=null && place.getAddressDetails()!=null && place.getAddressDetails().getCountry()!=null && 
//				!place.getAddressDetails().getCountry().getCountryName().isEmpty()
//				){
//			StringBuffer buff = new StringBuffer();
//			for (CountryName countryName : place.getAddressDetails().getCountry().getCountryName()) {
//				FeatureMap m = countryName.getMixed();
//				appendText(buff, m);
//			}
//			result= buff.toString();
//		};
//		return result;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * Coordinates Long, Lat, Altitude
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	private String[] getCoordinates() {
//		String[] tokens = null;
//		if(place !=null && place.getAbstractGeometryGroup()!=null && place.getAbstractGeometryGroup() instanceof Point){
//			Point point = (Point)place.getAbstractGeometryGroup();
//			StringBuffer buf = listToString(point.getCoordinates());
//		    tokens = buf.toString().split(",");
//
//		}
//		return tokens;
//	}
//
//	private static StringBuffer listToString(List<String> strings) {
//		StringBuffer buf = new StringBuffer();
//		for (String s : strings) {
//			buf.append(s.trim());
//		}
//		return buf;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * If the place reference exists and it contains a Point, returns the longitude from the placemark point.
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getLongitude() {
//		String[] tokens = getCoordinates();
//		return tokens==null || tokens.length!=3 ?null:tokens[0];
//	}
//	
//	/**
//	 * <!-- begin-user-doc -->
//	 * If the place reference exists and it contains a Point, returns the latitude from the placemark point.
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getLatitude() {
//		String[] tokens = getCoordinates();
//		return tokens==null || tokens.length!=3?null:tokens[1];
//	}
//
//	
//
//	
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * If the place reference exists and it contains a Point, returns the latitude from the placemark point.
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getAltitude() {
//		String[] tokens = getCoordinates();
//		return tokens==null || tokens.length!=3?null:tokens[2];
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getAltitudeMode() {
//		String results = null;
//		if(place !=null && place.getAbstractGeometryGroup()!=null && place.getAbstractGeometryGroup() instanceof Point){
//			Point point = (Point)place.getAbstractGeometryGroup();
//			AltitudeModeEnumType mode = (AltitudeModeEnumType) point.getAltitudeModeGroupGroup().get(KmlPackage.eINSTANCE.getPoint_AltitudeModeGroup(), true);
//			results = mode !=null ? mode.getLiteral():null;
//		}
//		return results;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AgriculturePackage.LOCATION__GEOGRAPHY:
				if (resolve) return getGeography();
				return basicGetGeography();
			case AgriculturePackage.LOCATION__LIVESTOCK:
				if (resolve) return getLivestock();
				return basicGetLivestock();
			case AgriculturePackage.LOCATION__URI:
				return getUri();
			case AgriculturePackage.LOCATION__NAME:
				return getName();
			case AgriculturePackage.LOCATION__DESCRIPTION:
				return getDescription();
			case AgriculturePackage.LOCATION__PHONE_NUMBER:
				return getPhoneNumber();
			case AgriculturePackage.LOCATION__STREET:
				return getStreet();
			case AgriculturePackage.LOCATION__CITY:
				return getCity();
			case AgriculturePackage.LOCATION__STATE:
				return getState();
			case AgriculturePackage.LOCATION__POSTAL_CODE:
				return getPostalCode();
			case AgriculturePackage.LOCATION__COUNTRY:
				return getCountry();
			case AgriculturePackage.LOCATION__LONGITUDE:
				return getLongitude();
			case AgriculturePackage.LOCATION__LATITUDE:
				return getLatitude();
			case AgriculturePackage.LOCATION__ALTITUDE:
				return getAltitude();
			case AgriculturePackage.LOCATION__ALTITUDE_MODE:
				return getAltitudeMode();
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
			case AgriculturePackage.LOCATION__GEOGRAPHY:
				setGeography((com.verticon.opengis.kml.Container)newValue);
				return;
			case AgriculturePackage.LOCATION__LIVESTOCK:
				setLivestock((Premises)newValue);
				return;
			case AgriculturePackage.LOCATION__NAME:
				setName((String)newValue);
				return;
			case AgriculturePackage.LOCATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case AgriculturePackage.LOCATION__PHONE_NUMBER:
				setPhoneNumber((String)newValue);
				return;
			case AgriculturePackage.LOCATION__STREET:
				setStreet((String)newValue);
				return;
			case AgriculturePackage.LOCATION__CITY:
				setCity((String)newValue);
				return;
			case AgriculturePackage.LOCATION__STATE:
				setState((String)newValue);
				return;
			case AgriculturePackage.LOCATION__POSTAL_CODE:
				setPostalCode((String)newValue);
				return;
			case AgriculturePackage.LOCATION__COUNTRY:
				setCountry((String)newValue);
				return;
			case AgriculturePackage.LOCATION__LONGITUDE:
				setLongitude((Double)newValue);
				return;
			case AgriculturePackage.LOCATION__LATITUDE:
				setLatitude((Double)newValue);
				return;
			case AgriculturePackage.LOCATION__ALTITUDE:
				setAltitude((Double)newValue);
				return;
			case AgriculturePackage.LOCATION__ALTITUDE_MODE:
				setAltitudeMode((AltitudeMode)newValue);
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
			case AgriculturePackage.LOCATION__GEOGRAPHY:
				setGeography((com.verticon.opengis.kml.Container)null);
				return;
			case AgriculturePackage.LOCATION__LIVESTOCK:
				setLivestock((Premises)null);
				return;
			case AgriculturePackage.LOCATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AgriculturePackage.LOCATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AgriculturePackage.LOCATION__PHONE_NUMBER:
				setPhoneNumber(PHONE_NUMBER_EDEFAULT);
				return;
			case AgriculturePackage.LOCATION__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case AgriculturePackage.LOCATION__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case AgriculturePackage.LOCATION__STATE:
				setState(STATE_EDEFAULT);
				return;
			case AgriculturePackage.LOCATION__POSTAL_CODE:
				setPostalCode(POSTAL_CODE_EDEFAULT);
				return;
			case AgriculturePackage.LOCATION__COUNTRY:
				setCountry(COUNTRY_EDEFAULT);
				return;
			case AgriculturePackage.LOCATION__LONGITUDE:
				unsetLongitude();
				return;
			case AgriculturePackage.LOCATION__LATITUDE:
				unsetLatitude();
				return;
			case AgriculturePackage.LOCATION__ALTITUDE:
				unsetAltitude();
				return;
			case AgriculturePackage.LOCATION__ALTITUDE_MODE:
				setAltitudeMode(ALTITUDE_MODE_EDEFAULT);
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
			case AgriculturePackage.LOCATION__GEOGRAPHY:
				return geography != null;
			case AgriculturePackage.LOCATION__LIVESTOCK:
				return livestock != null;
			case AgriculturePackage.LOCATION__URI:
				return URI_EDEFAULT == null ? getUri() != null : !URI_EDEFAULT.equals(getUri());
			case AgriculturePackage.LOCATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AgriculturePackage.LOCATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AgriculturePackage.LOCATION__PHONE_NUMBER:
				return PHONE_NUMBER_EDEFAULT == null ? phoneNumber != null : !PHONE_NUMBER_EDEFAULT.equals(phoneNumber);
			case AgriculturePackage.LOCATION__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case AgriculturePackage.LOCATION__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case AgriculturePackage.LOCATION__STATE:
				return STATE_EDEFAULT == null ? state != null : !STATE_EDEFAULT.equals(state);
			case AgriculturePackage.LOCATION__POSTAL_CODE:
				return POSTAL_CODE_EDEFAULT == null ? postalCode != null : !POSTAL_CODE_EDEFAULT.equals(postalCode);
			case AgriculturePackage.LOCATION__COUNTRY:
				return COUNTRY_EDEFAULT == null ? country != null : !COUNTRY_EDEFAULT.equals(country);
			case AgriculturePackage.LOCATION__LONGITUDE:
				return isSetLongitude();
			case AgriculturePackage.LOCATION__LATITUDE:
				return isSetLatitude();
			case AgriculturePackage.LOCATION__ALTITUDE:
				return isSetAltitude();
			case AgriculturePackage.LOCATION__ALTITUDE_MODE:
				return altitudeMode != ALTITUDE_MODE_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

	/**
	 * Added to manage notifications for the derived attribute uri.
	 */
	private Adapter derivedURIAdapter = new AdapterImpl(){

		/* (non-Javadoc)
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(Notification notification) {
			switch (notification.getFeatureID(Feature.class)) {
			case TrackerPackage.PREMISES__URI:
				fireNameChange(notification.getOldStringValue(),notification.getNewStringValue());
				break;

			}
		}

		private void fireNameChange(String oldFeatureName, String newFeatureName){
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(
						LocationImpl.this, 
						Notification.SET, AgriculturePackage.LOCATION__URI, oldFeatureName, newFeatureName));
		}
	};

	
	/** 
	 * Added to manage notifications for the derived attribute name.
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotificationRequired()
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	/**
	 * Added to manage notifications for the derived attribute name.
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void eNotify(Notification notification) {
		if (notification.getFeature() == AgriculturePackage.Literals.LOCATION__LIVESTOCK)
		{
			switch (notification.getEventType())
			{
			case Notification.SET:
			case Notification.RESOLVE:
			{
				Premises oldValue = (Premises)notification.getOldValue();
				if (oldValue != null)
				{
					oldValue.eAdapters().remove(derivedURIAdapter);
				}
				Premises newValue = (Premises)notification.getNewValue();
				if (newValue != null)
				{
					newValue.eAdapters().add(derivedURIAdapter);
					
				}
				break;
			}
			}
		}
		super.eNotify(notification);
	}
	
	

} //LocationImpl
