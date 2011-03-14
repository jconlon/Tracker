/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.LatLonQuad;
import com.verticon.opengis.kml.impl.AbstractObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lat Lon Quad</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.LatLonQuadImpl#getCoordinates <em>Coordinates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LatLonQuadImpl extends AbstractObjectImpl implements LatLonQuad {
	/**
	 * The default value of the '{@link #getCoordinates() <em>Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinates()
	 * @generated
	 * @ordered
	 */
	protected static final List<String> COORDINATES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoordinates() <em>Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinates()
	 * @generated
	 * @ordered
	 */
	protected List<String> coordinates = COORDINATES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LatLonQuadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.LAT_LON_QUAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getCoordinates() {
		return coordinates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoordinates(List<String> newCoordinates) {
		List<String> oldCoordinates = coordinates;
		coordinates = newCoordinates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.LAT_LON_QUAD__COORDINATES, oldCoordinates, coordinates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmlgxPackage.LAT_LON_QUAD__COORDINATES:
				return getCoordinates();
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
			case KmlgxPackage.LAT_LON_QUAD__COORDINATES:
				setCoordinates((List<String>)newValue);
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
			case KmlgxPackage.LAT_LON_QUAD__COORDINATES:
				setCoordinates(COORDINATES_EDEFAULT);
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
			case KmlgxPackage.LAT_LON_QUAD__COORDINATES:
				return COORDINATES_EDEFAULT == null ? coordinates != null : !COORDINATES_EDEFAULT.equals(coordinates);
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
		result.append(" (coordinates: ");
		result.append(coordinates);
		result.append(')');
		return result.toString();
	}

} //LatLonQuadImpl
