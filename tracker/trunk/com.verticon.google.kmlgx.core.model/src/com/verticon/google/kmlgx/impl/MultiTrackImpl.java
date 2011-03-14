/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.MultiTrack;
import com.verticon.google.kmlgx.Track;
import com.verticon.opengis.kml.impl.GeometryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Track</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.MultiTrackImpl#getAltitudeModeGroupGroup <em>Altitude Mode Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.MultiTrackImpl#getAltitudeModeGroup <em>Altitude Mode Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.MultiTrackImpl#isInterpolate <em>Interpolate</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.MultiTrackImpl#getTrack <em>Track</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiTrackImpl extends GeometryImpl implements MultiTrack {
	/**
	 * The cached value of the '{@link #getAltitudeModeGroupGroup() <em>Altitude Mode Group Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitudeModeGroupGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap altitudeModeGroupGroup;

	/**
	 * The default value of the '{@link #isInterpolate() <em>Interpolate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterpolate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERPOLATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInterpolate() <em>Interpolate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterpolate()
	 * @generated
	 * @ordered
	 */
	protected boolean interpolate = INTERPOLATE_EDEFAULT;

	/**
	 * This is true if the Interpolate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean interpolateESet;

	/**
	 * The cached value of the '{@link #getTrack() <em>Track</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrack()
	 * @generated
	 * @ordered
	 */
	protected EList<Track> track;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiTrackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.MULTI_TRACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAltitudeModeGroupGroup() {
		if (altitudeModeGroupGroup == null) {
			altitudeModeGroupGroup = new BasicFeatureMap(this, KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP);
		}
		return altitudeModeGroupGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getAltitudeModeGroup() {
		return (EObject)getAltitudeModeGroupGroup().get(KmlgxPackage.Literals.MULTI_TRACK__ALTITUDE_MODE_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAltitudeModeGroup(EObject newAltitudeModeGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal)getAltitudeModeGroupGroup()).basicAdd(KmlgxPackage.Literals.MULTI_TRACK__ALTITUDE_MODE_GROUP, newAltitudeModeGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterpolate() {
		return interpolate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpolate(boolean newInterpolate) {
		boolean oldInterpolate = interpolate;
		interpolate = newInterpolate;
		boolean oldInterpolateESet = interpolateESet;
		interpolateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.MULTI_TRACK__INTERPOLATE, oldInterpolate, interpolate, !oldInterpolateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInterpolate() {
		boolean oldInterpolate = interpolate;
		boolean oldInterpolateESet = interpolateESet;
		interpolate = INTERPOLATE_EDEFAULT;
		interpolateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.MULTI_TRACK__INTERPOLATE, oldInterpolate, INTERPOLATE_EDEFAULT, oldInterpolateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInterpolate() {
		return interpolateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Track> getTrack() {
		if (track == null) {
			track = new EObjectContainmentEList<Track>(Track.class, this, KmlgxPackage.MULTI_TRACK__TRACK);
		}
		return track;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP:
				return ((InternalEList<?>)getAltitudeModeGroupGroup()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP:
				return basicSetAltitudeModeGroup(null, msgs);
			case KmlgxPackage.MULTI_TRACK__TRACK:
				return ((InternalEList<?>)getTrack()).basicRemove(otherEnd, msgs);
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
			case KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP:
				if (coreType) return getAltitudeModeGroupGroup();
				return ((FeatureMap.Internal)getAltitudeModeGroupGroup()).getWrapper();
			case KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP:
				return getAltitudeModeGroup();
			case KmlgxPackage.MULTI_TRACK__INTERPOLATE:
				return isInterpolate();
			case KmlgxPackage.MULTI_TRACK__TRACK:
				return getTrack();
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
			case KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP:
				((FeatureMap.Internal)getAltitudeModeGroupGroup()).set(newValue);
				return;
			case KmlgxPackage.MULTI_TRACK__INTERPOLATE:
				setInterpolate((Boolean)newValue);
				return;
			case KmlgxPackage.MULTI_TRACK__TRACK:
				getTrack().clear();
				getTrack().addAll((Collection<? extends Track>)newValue);
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
			case KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP:
				getAltitudeModeGroupGroup().clear();
				return;
			case KmlgxPackage.MULTI_TRACK__INTERPOLATE:
				unsetInterpolate();
				return;
			case KmlgxPackage.MULTI_TRACK__TRACK:
				getTrack().clear();
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
			case KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP:
				return altitudeModeGroupGroup != null && !altitudeModeGroupGroup.isEmpty();
			case KmlgxPackage.MULTI_TRACK__ALTITUDE_MODE_GROUP:
				return getAltitudeModeGroup() != null;
			case KmlgxPackage.MULTI_TRACK__INTERPOLATE:
				return isSetInterpolate();
			case KmlgxPackage.MULTI_TRACK__TRACK:
				return track != null && !track.isEmpty();
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
		result.append(" (altitudeModeGroupGroup: ");
		result.append(altitudeModeGroupGroup);
		result.append(", interpolate: ");
		if (interpolateESet) result.append(interpolate); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MultiTrackImpl
