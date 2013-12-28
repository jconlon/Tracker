/**
 */
package org.usaha.ecvi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.usaha.ecvi.Address;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.GeoPoint;
import org.usaha.ecvi.ISO3166Country;
import org.usaha.ecvi.UsState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.AddressImpl#getLine1 <em>Line1</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AddressImpl#getLine2 <em>Line2</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AddressImpl#getTown <em>Town</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AddressImpl#getCounty <em>County</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AddressImpl#getState <em>State</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AddressImpl#getZIP <em>ZIP</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AddressImpl#getCountry <em>Country</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AddressImpl#getGeoPoint <em>Geo Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddressImpl extends MinimalEObjectImpl.Container implements Address {
	/**
	 * The default value of the '{@link #getLine1() <em>Line1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine1()
	 * @generated
	 * @ordered
	 */
	protected static final String LINE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLine1() <em>Line1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine1()
	 * @generated
	 * @ordered
	 */
	protected String line1 = LINE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getLine2() <em>Line2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine2()
	 * @generated
	 * @ordered
	 */
	protected static final String LINE2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLine2() <em>Line2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine2()
	 * @generated
	 * @ordered
	 */
	protected String line2 = LINE2_EDEFAULT;

	/**
	 * The default value of the '{@link #getTown() <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTown()
	 * @generated
	 * @ordered
	 */
	protected static final String TOWN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTown() <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTown()
	 * @generated
	 * @ordered
	 */
	protected String town = TOWN_EDEFAULT;

	/**
	 * The default value of the '{@link #getCounty() <em>County</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounty()
	 * @generated
	 * @ordered
	 */
	protected static final String COUNTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCounty() <em>County</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounty()
	 * @generated
	 * @ordered
	 */
	protected String county = COUNTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final UsState STATE_EDEFAULT = UsState.AA;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected UsState state = STATE_EDEFAULT;

	/**
	 * This is true if the State attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean stateESet;

	/**
	 * The default value of the '{@link #getZIP() <em>ZIP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZIP()
	 * @generated
	 * @ordered
	 */
	protected static final String ZIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZIP() <em>ZIP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZIP()
	 * @generated
	 * @ordered
	 */
	protected String zIP = ZIP_EDEFAULT;

	/**
	 * The default value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected static final ISO3166Country COUNTRY_EDEFAULT = ISO3166Country.USA;

	/**
	 * The cached value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected ISO3166Country country = COUNTRY_EDEFAULT;

	/**
	 * This is true if the Country attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean countryESet;

	/**
	 * The cached value of the '{@link #getGeoPoint() <em>Geo Point</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeoPoint()
	 * @generated
	 * @ordered
	 */
	protected GeoPoint geoPoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine1(String newLine1) {
		String oldLine1 = line1;
		line1 = newLine1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__LINE1, oldLine1, line1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine2(String newLine2) {
		String oldLine2 = line2;
		line2 = newLine2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__LINE2, oldLine2, line2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTown() {
		return town;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTown(String newTown) {
		String oldTown = town;
		town = newTown;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__TOWN, oldTown, town));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCounty(String newCounty) {
		String oldCounty = county;
		county = newCounty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__COUNTY, oldCounty, county));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(UsState newState) {
		UsState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		boolean oldStateESet = stateESet;
		stateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__STATE, oldState, state, !oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetState() {
		UsState oldState = state;
		boolean oldStateESet = stateESet;
		state = STATE_EDEFAULT;
		stateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.ADDRESS__STATE, oldState, STATE_EDEFAULT, oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetState() {
		return stateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZIP() {
		return zIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZIP(String newZIP) {
		String oldZIP = zIP;
		zIP = newZIP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__ZIP, oldZIP, zIP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISO3166Country getCountry() {
		return country;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountry(ISO3166Country newCountry) {
		ISO3166Country oldCountry = country;
		country = newCountry == null ? COUNTRY_EDEFAULT : newCountry;
		boolean oldCountryESet = countryESet;
		countryESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__COUNTRY, oldCountry, country, !oldCountryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCountry() {
		ISO3166Country oldCountry = country;
		boolean oldCountryESet = countryESet;
		country = COUNTRY_EDEFAULT;
		countryESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.ADDRESS__COUNTRY, oldCountry, COUNTRY_EDEFAULT, oldCountryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCountry() {
		return countryESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoPoint getGeoPoint() {
		return geoPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeoPoint(GeoPoint newGeoPoint, NotificationChain msgs) {
		GeoPoint oldGeoPoint = geoPoint;
		geoPoint = newGeoPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__GEO_POINT, oldGeoPoint, newGeoPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeoPoint(GeoPoint newGeoPoint) {
		if (newGeoPoint != geoPoint) {
			NotificationChain msgs = null;
			if (geoPoint != null)
				msgs = ((InternalEObject)geoPoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ADDRESS__GEO_POINT, null, msgs);
			if (newGeoPoint != null)
				msgs = ((InternalEObject)newGeoPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ADDRESS__GEO_POINT, null, msgs);
			msgs = basicSetGeoPoint(newGeoPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ADDRESS__GEO_POINT, newGeoPoint, newGeoPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcviPackage.ADDRESS__GEO_POINT:
				return basicSetGeoPoint(null, msgs);
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
			case EcviPackage.ADDRESS__LINE1:
				return getLine1();
			case EcviPackage.ADDRESS__LINE2:
				return getLine2();
			case EcviPackage.ADDRESS__TOWN:
				return getTown();
			case EcviPackage.ADDRESS__COUNTY:
				return getCounty();
			case EcviPackage.ADDRESS__STATE:
				return getState();
			case EcviPackage.ADDRESS__ZIP:
				return getZIP();
			case EcviPackage.ADDRESS__COUNTRY:
				return getCountry();
			case EcviPackage.ADDRESS__GEO_POINT:
				return getGeoPoint();
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
			case EcviPackage.ADDRESS__LINE1:
				setLine1((String)newValue);
				return;
			case EcviPackage.ADDRESS__LINE2:
				setLine2((String)newValue);
				return;
			case EcviPackage.ADDRESS__TOWN:
				setTown((String)newValue);
				return;
			case EcviPackage.ADDRESS__COUNTY:
				setCounty((String)newValue);
				return;
			case EcviPackage.ADDRESS__STATE:
				setState((UsState)newValue);
				return;
			case EcviPackage.ADDRESS__ZIP:
				setZIP((String)newValue);
				return;
			case EcviPackage.ADDRESS__COUNTRY:
				setCountry((ISO3166Country)newValue);
				return;
			case EcviPackage.ADDRESS__GEO_POINT:
				setGeoPoint((GeoPoint)newValue);
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
			case EcviPackage.ADDRESS__LINE1:
				setLine1(LINE1_EDEFAULT);
				return;
			case EcviPackage.ADDRESS__LINE2:
				setLine2(LINE2_EDEFAULT);
				return;
			case EcviPackage.ADDRESS__TOWN:
				setTown(TOWN_EDEFAULT);
				return;
			case EcviPackage.ADDRESS__COUNTY:
				setCounty(COUNTY_EDEFAULT);
				return;
			case EcviPackage.ADDRESS__STATE:
				unsetState();
				return;
			case EcviPackage.ADDRESS__ZIP:
				setZIP(ZIP_EDEFAULT);
				return;
			case EcviPackage.ADDRESS__COUNTRY:
				unsetCountry();
				return;
			case EcviPackage.ADDRESS__GEO_POINT:
				setGeoPoint((GeoPoint)null);
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
			case EcviPackage.ADDRESS__LINE1:
				return LINE1_EDEFAULT == null ? line1 != null : !LINE1_EDEFAULT.equals(line1);
			case EcviPackage.ADDRESS__LINE2:
				return LINE2_EDEFAULT == null ? line2 != null : !LINE2_EDEFAULT.equals(line2);
			case EcviPackage.ADDRESS__TOWN:
				return TOWN_EDEFAULT == null ? town != null : !TOWN_EDEFAULT.equals(town);
			case EcviPackage.ADDRESS__COUNTY:
				return COUNTY_EDEFAULT == null ? county != null : !COUNTY_EDEFAULT.equals(county);
			case EcviPackage.ADDRESS__STATE:
				return isSetState();
			case EcviPackage.ADDRESS__ZIP:
				return ZIP_EDEFAULT == null ? zIP != null : !ZIP_EDEFAULT.equals(zIP);
			case EcviPackage.ADDRESS__COUNTRY:
				return isSetCountry();
			case EcviPackage.ADDRESS__GEO_POINT:
				return geoPoint != null;
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
		result.append(" (line1: ");
		result.append(line1);
		result.append(", line2: ");
		result.append(line2);
		result.append(", town: ");
		result.append(town);
		result.append(", county: ");
		result.append(county);
		result.append(", state: ");
		if (stateESet) result.append(state); else result.append("<unset>");
		result.append(", zIP: ");
		result.append(zIP);
		result.append(", country: ");
		if (countryESet) result.append(country); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AddressImpl
