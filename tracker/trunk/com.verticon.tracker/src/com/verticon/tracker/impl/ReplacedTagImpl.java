/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.CommonUtilities;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replaced Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.ReplacedTagImpl#getOldId <em>Old Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.ReplacedTagImpl#isUsainNumberUsedForOldId <em>Usain Number Used For Old Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplacedTagImpl extends EventImpl implements ReplacedTag {
	private static final int EVENT_CODE = 6;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getOldId() <em>Old Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldId()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldId() <em>Old Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldId()
	 * @generated
	 * @ordered
	 */
	protected String oldId = OLD_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isUsainNumberUsedForOldId() <em>Usain Number Used For Old Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsainNumberUsedForOldId()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USAIN_NUMBER_USED_FOR_OLD_ID_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplacedTagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.REPLACED_TAG;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getEventCode() {
		return EVENT_CODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldId() {
		return oldId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldId(String newOldId) {
		String oldOldId = oldId;
		oldId = newOldId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.REPLACED_TAG__OLD_ID, oldOldId, oldId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isUsainNumberUsedForOldId() {
		return CommonUtilities.isUsainNumberUsed(oldId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.REPLACED_TAG__OLD_ID:
				return getOldId();
			case TrackerPackage.REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID:
				return isUsainNumberUsedForOldId() ? Boolean.TRUE : Boolean.FALSE;
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
			case TrackerPackage.REPLACED_TAG__OLD_ID:
				setOldId((String)newValue);
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
			case TrackerPackage.REPLACED_TAG__OLD_ID:
				setOldId(OLD_ID_EDEFAULT);
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
			case TrackerPackage.REPLACED_TAG__OLD_ID:
				return OLD_ID_EDEFAULT == null ? oldId != null : !OLD_ID_EDEFAULT.equals(oldId);
			case TrackerPackage.REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID:
				return isUsainNumberUsedForOldId() != USAIN_NUMBER_USED_FOR_OLD_ID_EDEFAULT;
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
		result.append(" (oldId: ");
		result.append(oldId);
		result.append(')');
		return result.toString();
	}

} //ReplacedTagImpl