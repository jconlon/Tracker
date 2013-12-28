/**
 */
package org.usaha.ecvi.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.ProgramStatus;
import org.usaha.ecvi.ProgramStatusName;
import org.usaha.ecvi.ProgramStatusValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.ProgramStatusImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.ProgramStatusImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.ProgramStatusImpl#getValueOther <em>Value Other</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgramStatusImpl extends MinimalEObjectImpl.Container implements ProgramStatus {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final ProgramStatusName NAME_EDEFAULT = ProgramStatusName.BOVINE_TUBERCULOSIS;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected ProgramStatusName name = NAME_EDEFAULT;

	/**
	 * This is true if the Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nameESet;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final ProgramStatusValue VALUE_EDEFAULT = ProgramStatusValue.FREE;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected ProgramStatusValue value = VALUE_EDEFAULT;

	/**
	 * This is true if the Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean valueESet;

	/**
	 * The default value of the '{@link #getValueOther() <em>Value Other</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueOther()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_OTHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueOther() <em>Value Other</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueOther()
	 * @generated
	 * @ordered
	 */
	protected String valueOther = VALUE_OTHER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.PROGRAM_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramStatusName getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(ProgramStatusName newName) {
		ProgramStatusName oldName = name;
		name = newName == null ? NAME_EDEFAULT : newName;
		boolean oldNameESet = nameESet;
		nameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.PROGRAM_STATUS__NAME, oldName, name, !oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		ProgramStatusName oldName = name;
		boolean oldNameESet = nameESet;
		name = NAME_EDEFAULT;
		nameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.PROGRAM_STATUS__NAME, oldName, NAME_EDEFAULT, oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return nameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramStatusValue getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ProgramStatusValue newValue) {
		ProgramStatusValue oldValue = value;
		value = newValue == null ? VALUE_EDEFAULT : newValue;
		boolean oldValueESet = valueESet;
		valueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.PROGRAM_STATUS__VALUE, oldValue, value, !oldValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValue() {
		ProgramStatusValue oldValue = value;
		boolean oldValueESet = valueESet;
		value = VALUE_EDEFAULT;
		valueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.PROGRAM_STATUS__VALUE, oldValue, VALUE_EDEFAULT, oldValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValue() {
		return valueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueOther() {
		return valueOther;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueOther(String newValueOther) {
		String oldValueOther = valueOther;
		valueOther = newValueOther;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.PROGRAM_STATUS__VALUE_OTHER, oldValueOther, valueOther));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcviPackage.PROGRAM_STATUS__NAME:
				return getName();
			case EcviPackage.PROGRAM_STATUS__VALUE:
				return getValue();
			case EcviPackage.PROGRAM_STATUS__VALUE_OTHER:
				return getValueOther();
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
			case EcviPackage.PROGRAM_STATUS__NAME:
				setName((ProgramStatusName)newValue);
				return;
			case EcviPackage.PROGRAM_STATUS__VALUE:
				setValue((ProgramStatusValue)newValue);
				return;
			case EcviPackage.PROGRAM_STATUS__VALUE_OTHER:
				setValueOther((String)newValue);
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
			case EcviPackage.PROGRAM_STATUS__NAME:
				unsetName();
				return;
			case EcviPackage.PROGRAM_STATUS__VALUE:
				unsetValue();
				return;
			case EcviPackage.PROGRAM_STATUS__VALUE_OTHER:
				setValueOther(VALUE_OTHER_EDEFAULT);
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
			case EcviPackage.PROGRAM_STATUS__NAME:
				return isSetName();
			case EcviPackage.PROGRAM_STATUS__VALUE:
				return isSetValue();
			case EcviPackage.PROGRAM_STATUS__VALUE_OTHER:
				return VALUE_OTHER_EDEFAULT == null ? valueOther != null : !VALUE_OTHER_EDEFAULT.equals(valueOther);
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
		result.append(" (name: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(", value: ");
		if (valueESet) result.append(value); else result.append("<unset>");
		result.append(", valueOther: ");
		result.append(valueOther);
		result.append(')');
		return result.toString();
	}

} //ProgramStatusImpl
