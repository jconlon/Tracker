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
import com.verticon.google.kmlgx.SoundCue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sound Cue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.SoundCueImpl#getHref <em>Href</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.SoundCueImpl#getDelayedStart <em>Delayed Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoundCueImpl extends TourPrimitiveImpl implements SoundCue {
	/**
	 * The default value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected static final String HREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected String href = HREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getDelayedStart() <em>Delayed Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelayedStart()
	 * @generated
	 * @ordered
	 */
	protected static final double DELAYED_START_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDelayedStart() <em>Delayed Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelayedStart()
	 * @generated
	 * @ordered
	 */
	protected double delayedStart = DELAYED_START_EDEFAULT;

	/**
	 * This is true if the Delayed Start attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean delayedStartESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoundCueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.SOUND_CUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHref() {
		return href;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHref(String newHref) {
		String oldHref = href;
		href = newHref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.SOUND_CUE__HREF, oldHref, href));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDelayedStart() {
		return delayedStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelayedStart(double newDelayedStart) {
		double oldDelayedStart = delayedStart;
		delayedStart = newDelayedStart;
		boolean oldDelayedStartESet = delayedStartESet;
		delayedStartESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.SOUND_CUE__DELAYED_START, oldDelayedStart, delayedStart, !oldDelayedStartESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDelayedStart() {
		double oldDelayedStart = delayedStart;
		boolean oldDelayedStartESet = delayedStartESet;
		delayedStart = DELAYED_START_EDEFAULT;
		delayedStartESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.SOUND_CUE__DELAYED_START, oldDelayedStart, DELAYED_START_EDEFAULT, oldDelayedStartESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDelayedStart() {
		return delayedStartESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmlgxPackage.SOUND_CUE__HREF:
				return getHref();
			case KmlgxPackage.SOUND_CUE__DELAYED_START:
				return getDelayedStart();
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
			case KmlgxPackage.SOUND_CUE__HREF:
				setHref((String)newValue);
				return;
			case KmlgxPackage.SOUND_CUE__DELAYED_START:
				setDelayedStart((Double)newValue);
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
			case KmlgxPackage.SOUND_CUE__HREF:
				setHref(HREF_EDEFAULT);
				return;
			case KmlgxPackage.SOUND_CUE__DELAYED_START:
				unsetDelayedStart();
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
			case KmlgxPackage.SOUND_CUE__HREF:
				return HREF_EDEFAULT == null ? href != null : !HREF_EDEFAULT.equals(href);
			case KmlgxPackage.SOUND_CUE__DELAYED_START:
				return isSetDelayedStart();
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
		result.append(" (href: ");
		result.append(href);
		result.append(", delayedStart: ");
		if (delayedStartESet) result.append(delayedStart); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //SoundCueImpl
