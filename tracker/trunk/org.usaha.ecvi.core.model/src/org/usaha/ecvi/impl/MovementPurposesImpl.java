/**
 */
package org.usaha.ecvi.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.MovementPurpose;
import org.usaha.ecvi.MovementPurposes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Movement Purposes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.MovementPurposesImpl#getMovementPurpose <em>Movement Purpose</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MovementPurposesImpl extends MinimalEObjectImpl.Container implements MovementPurposes {
	/**
	 * The cached value of the '{@link #getMovementPurpose() <em>Movement Purpose</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovementPurpose()
	 * @generated
	 * @ordered
	 */
	protected EList<MovementPurpose> movementPurpose;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovementPurposesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.MOVEMENT_PURPOSES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MovementPurpose> getMovementPurpose() {
		if (movementPurpose == null) {
			movementPurpose = new EDataTypeEList<MovementPurpose>(MovementPurpose.class, this, EcviPackage.MOVEMENT_PURPOSES__MOVEMENT_PURPOSE);
		}
		return movementPurpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcviPackage.MOVEMENT_PURPOSES__MOVEMENT_PURPOSE:
				return getMovementPurpose();
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
			case EcviPackage.MOVEMENT_PURPOSES__MOVEMENT_PURPOSE:
				getMovementPurpose().clear();
				getMovementPurpose().addAll((Collection<? extends MovementPurpose>)newValue);
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
			case EcviPackage.MOVEMENT_PURPOSES__MOVEMENT_PURPOSE:
				getMovementPurpose().clear();
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
			case EcviPackage.MOVEMENT_PURPOSES__MOVEMENT_PURPOSE:
				return movementPurpose != null && !movementPurpose.isEmpty();
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
		result.append(" (movementPurpose: ");
		result.append(movementPurpose);
		result.append(')');
		return result.toString();
	}

} //MovementPurposesImpl
