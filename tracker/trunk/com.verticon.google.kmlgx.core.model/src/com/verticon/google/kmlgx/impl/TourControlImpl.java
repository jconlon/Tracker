/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.PlayModeEnumType;
import com.verticon.google.kmlgx.TourControl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tour Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.TourControlImpl#getPlayMode <em>Play Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TourControlImpl extends TourPrimitiveImpl implements TourControl {
	/**
	 * The default value of the '{@link #getPlayMode() <em>Play Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayMode()
	 * @generated
	 * @ordered
	 */
	protected static final PlayModeEnumType PLAY_MODE_EDEFAULT = PlayModeEnumType.PAUSE;

	/**
	 * The cached value of the '{@link #getPlayMode() <em>Play Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayMode()
	 * @generated
	 * @ordered
	 */
	protected PlayModeEnumType playMode = PLAY_MODE_EDEFAULT;

	/**
	 * This is true if the Play Mode attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean playModeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TourControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.TOUR_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlayModeEnumType getPlayMode() {
		return playMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayMode(PlayModeEnumType newPlayMode) {
		PlayModeEnumType oldPlayMode = playMode;
		playMode = newPlayMode == null ? PLAY_MODE_EDEFAULT : newPlayMode;
		boolean oldPlayModeESet = playModeESet;
		playModeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.TOUR_CONTROL__PLAY_MODE, oldPlayMode, playMode, !oldPlayModeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlayMode() {
		PlayModeEnumType oldPlayMode = playMode;
		boolean oldPlayModeESet = playModeESet;
		playMode = PLAY_MODE_EDEFAULT;
		playModeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.TOUR_CONTROL__PLAY_MODE, oldPlayMode, PLAY_MODE_EDEFAULT, oldPlayModeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlayMode() {
		return playModeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmlgxPackage.TOUR_CONTROL__PLAY_MODE:
				return getPlayMode();
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
			case KmlgxPackage.TOUR_CONTROL__PLAY_MODE:
				setPlayMode((PlayModeEnumType)newValue);
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
			case KmlgxPackage.TOUR_CONTROL__PLAY_MODE:
				unsetPlayMode();
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
			case KmlgxPackage.TOUR_CONTROL__PLAY_MODE:
				return isSetPlayMode();
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
		result.append(" (playMode: ");
		if (playModeESet) result.append(playMode); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TourControlImpl
