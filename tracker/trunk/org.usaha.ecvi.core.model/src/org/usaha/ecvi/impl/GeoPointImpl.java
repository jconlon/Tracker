/**
 */
package org.usaha.ecvi.impl;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.GeoPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geo Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.GeoPointImpl#getLat <em>Lat</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.GeoPointImpl#getLng <em>Lng</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeoPointImpl extends MinimalEObjectImpl.Container implements GeoPoint {
	/**
	 * The default value of the '{@link #getLat() <em>Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLat()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal LAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLat() <em>Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLat()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal lat = LAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLng() <em>Lng</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLng()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal LNG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLng() <em>Lng</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLng()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal lng = LNG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeoPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.GEO_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getLat() {
		return lat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLat(BigDecimal newLat) {
		BigDecimal oldLat = lat;
		lat = newLat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GEO_POINT__LAT, oldLat, lat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getLng() {
		return lng;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLng(BigDecimal newLng) {
		BigDecimal oldLng = lng;
		lng = newLng;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GEO_POINT__LNG, oldLng, lng));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcviPackage.GEO_POINT__LAT:
				return getLat();
			case EcviPackage.GEO_POINT__LNG:
				return getLng();
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
			case EcviPackage.GEO_POINT__LAT:
				setLat((BigDecimal)newValue);
				return;
			case EcviPackage.GEO_POINT__LNG:
				setLng((BigDecimal)newValue);
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
			case EcviPackage.GEO_POINT__LAT:
				setLat(LAT_EDEFAULT);
				return;
			case EcviPackage.GEO_POINT__LNG:
				setLng(LNG_EDEFAULT);
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
			case EcviPackage.GEO_POINT__LAT:
				return LAT_EDEFAULT == null ? lat != null : !LAT_EDEFAULT.equals(lat);
			case EcviPackage.GEO_POINT__LNG:
				return LNG_EDEFAULT == null ? lng != null : !LNG_EDEFAULT.equals(lng);
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
		result.append(" (lat: ");
		result.append(lat);
		result.append(", lng: ");
		result.append(lng);
		result.append(')');
		return result.toString();
	}

} //GeoPointImpl
