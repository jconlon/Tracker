/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.google.kmlgx.AnimatedUpdate;
import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.opengis.kml.Update;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Animated Update</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.AnimatedUpdateImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.AnimatedUpdateImpl#getUpdate <em>Update</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.AnimatedUpdateImpl#getDelayedStart <em>Delayed Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnimatedUpdateImpl extends TourPrimitiveImpl implements AnimatedUpdate {
	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final double DURATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected double duration = DURATION_EDEFAULT;

	/**
	 * This is true if the Duration attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean durationESet;

	/**
	 * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdate()
	 * @generated
	 * @ordered
	 */
	protected Update update;

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
	protected AnimatedUpdateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.ANIMATED_UPDATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(double newDuration) {
		double oldDuration = duration;
		duration = newDuration;
		boolean oldDurationESet = durationESet;
		durationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.ANIMATED_UPDATE__DURATION, oldDuration, duration, !oldDurationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDuration() {
		double oldDuration = duration;
		boolean oldDurationESet = durationESet;
		duration = DURATION_EDEFAULT;
		durationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.ANIMATED_UPDATE__DURATION, oldDuration, DURATION_EDEFAULT, oldDurationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDuration() {
		return durationESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Update getUpdate() {
		return update;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpdate(Update newUpdate, NotificationChain msgs) {
		Update oldUpdate = update;
		update = newUpdate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmlgxPackage.ANIMATED_UPDATE__UPDATE, oldUpdate, newUpdate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdate(Update newUpdate) {
		if (newUpdate != update) {
			NotificationChain msgs = null;
			if (update != null)
				msgs = ((InternalEObject)update).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmlgxPackage.ANIMATED_UPDATE__UPDATE, null, msgs);
			if (newUpdate != null)
				msgs = ((InternalEObject)newUpdate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmlgxPackage.ANIMATED_UPDATE__UPDATE, null, msgs);
			msgs = basicSetUpdate(newUpdate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.ANIMATED_UPDATE__UPDATE, newUpdate, newUpdate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.ANIMATED_UPDATE__DELAYED_START, oldDelayedStart, delayedStart, !oldDelayedStartESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.ANIMATED_UPDATE__DELAYED_START, oldDelayedStart, DELAYED_START_EDEFAULT, oldDelayedStartESet));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.ANIMATED_UPDATE__UPDATE:
				return basicSetUpdate(null, msgs);
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
			case KmlgxPackage.ANIMATED_UPDATE__DURATION:
				return getDuration();
			case KmlgxPackage.ANIMATED_UPDATE__UPDATE:
				return getUpdate();
			case KmlgxPackage.ANIMATED_UPDATE__DELAYED_START:
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
			case KmlgxPackage.ANIMATED_UPDATE__DURATION:
				setDuration((Double)newValue);
				return;
			case KmlgxPackage.ANIMATED_UPDATE__UPDATE:
				setUpdate((Update)newValue);
				return;
			case KmlgxPackage.ANIMATED_UPDATE__DELAYED_START:
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
			case KmlgxPackage.ANIMATED_UPDATE__DURATION:
				unsetDuration();
				return;
			case KmlgxPackage.ANIMATED_UPDATE__UPDATE:
				setUpdate((Update)null);
				return;
			case KmlgxPackage.ANIMATED_UPDATE__DELAYED_START:
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
			case KmlgxPackage.ANIMATED_UPDATE__DURATION:
				return isSetDuration();
			case KmlgxPackage.ANIMATED_UPDATE__UPDATE:
				return update != null;
			case KmlgxPackage.ANIMATED_UPDATE__DELAYED_START:
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
		result.append(" (duration: ");
		if (durationESet) result.append(duration); else result.append("<unset>");
		result.append(", delayedStart: ");
		if (delayedStartESet) result.append(delayedStart); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AnimatedUpdateImpl
