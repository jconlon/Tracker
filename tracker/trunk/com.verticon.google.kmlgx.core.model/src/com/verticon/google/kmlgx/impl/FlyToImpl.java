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
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.google.kmlgx.FlyTo;
import com.verticon.google.kmlgx.FlyToModeEnumType;
import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.opengis.kml.AbstractView;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fly To</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.FlyToImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.FlyToImpl#getFlyToMode <em>Fly To Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.FlyToImpl#getAbstractViewGroupGroup <em>Abstract View Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.FlyToImpl#getAbstractViewGroup <em>Abstract View Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlyToImpl extends TourPrimitiveImpl implements FlyTo {
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
	 * The default value of the '{@link #getFlyToMode() <em>Fly To Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlyToMode()
	 * @generated
	 * @ordered
	 */
	protected static final FlyToModeEnumType FLY_TO_MODE_EDEFAULT = FlyToModeEnumType.BOUNCE;

	/**
	 * The cached value of the '{@link #getFlyToMode() <em>Fly To Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlyToMode()
	 * @generated
	 * @ordered
	 */
	protected FlyToModeEnumType flyToMode = FLY_TO_MODE_EDEFAULT;

	/**
	 * This is true if the Fly To Mode attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean flyToModeESet;

	/**
	 * The cached value of the '{@link #getAbstractViewGroupGroup() <em>Abstract View Group Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractViewGroupGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap abstractViewGroupGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlyToImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.FLY_TO;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.FLY_TO__DURATION, oldDuration, duration, !oldDurationESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.FLY_TO__DURATION, oldDuration, DURATION_EDEFAULT, oldDurationESet));
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
	public FlyToModeEnumType getFlyToMode() {
		return flyToMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlyToMode(FlyToModeEnumType newFlyToMode) {
		FlyToModeEnumType oldFlyToMode = flyToMode;
		flyToMode = newFlyToMode == null ? FLY_TO_MODE_EDEFAULT : newFlyToMode;
		boolean oldFlyToModeESet = flyToModeESet;
		flyToModeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.FLY_TO__FLY_TO_MODE, oldFlyToMode, flyToMode, !oldFlyToModeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlyToMode() {
		FlyToModeEnumType oldFlyToMode = flyToMode;
		boolean oldFlyToModeESet = flyToModeESet;
		flyToMode = FLY_TO_MODE_EDEFAULT;
		flyToModeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.FLY_TO__FLY_TO_MODE, oldFlyToMode, FLY_TO_MODE_EDEFAULT, oldFlyToModeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlyToMode() {
		return flyToModeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAbstractViewGroupGroup() {
		if (abstractViewGroupGroup == null) {
			abstractViewGroupGroup = new BasicFeatureMap(this, KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP_GROUP);
		}
		return abstractViewGroupGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractView getAbstractViewGroup() {
		return (AbstractView)getAbstractViewGroupGroup().get(KmlgxPackage.Literals.FLY_TO__ABSTRACT_VIEW_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbstractViewGroup(AbstractView newAbstractViewGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal)getAbstractViewGroupGroup()).basicAdd(KmlgxPackage.Literals.FLY_TO__ABSTRACT_VIEW_GROUP, newAbstractViewGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP_GROUP:
				return ((InternalEList<?>)getAbstractViewGroupGroup()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP:
				return basicSetAbstractViewGroup(null, msgs);
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
			case KmlgxPackage.FLY_TO__DURATION:
				return getDuration();
			case KmlgxPackage.FLY_TO__FLY_TO_MODE:
				return getFlyToMode();
			case KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP_GROUP:
				if (coreType) return getAbstractViewGroupGroup();
				return ((FeatureMap.Internal)getAbstractViewGroupGroup()).getWrapper();
			case KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP:
				return getAbstractViewGroup();
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
			case KmlgxPackage.FLY_TO__DURATION:
				setDuration((Double)newValue);
				return;
			case KmlgxPackage.FLY_TO__FLY_TO_MODE:
				setFlyToMode((FlyToModeEnumType)newValue);
				return;
			case KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP_GROUP:
				((FeatureMap.Internal)getAbstractViewGroupGroup()).set(newValue);
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
			case KmlgxPackage.FLY_TO__DURATION:
				unsetDuration();
				return;
			case KmlgxPackage.FLY_TO__FLY_TO_MODE:
				unsetFlyToMode();
				return;
			case KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP_GROUP:
				getAbstractViewGroupGroup().clear();
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
			case KmlgxPackage.FLY_TO__DURATION:
				return isSetDuration();
			case KmlgxPackage.FLY_TO__FLY_TO_MODE:
				return isSetFlyToMode();
			case KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP_GROUP:
				return abstractViewGroupGroup != null && !abstractViewGroupGroup.isEmpty();
			case KmlgxPackage.FLY_TO__ABSTRACT_VIEW_GROUP:
				return getAbstractViewGroup() != null;
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
		result.append(", flyToMode: ");
		if (flyToModeESet) result.append(flyToMode); else result.append("<unset>");
		result.append(", abstractViewGroupGroup: ");
		result.append(abstractViewGroupGroup);
		result.append(')');
		return result.toString();
	}

} //FlyToImpl
