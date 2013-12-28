/**
 */
package org.usaha.ecvi.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.ResultName;
import org.usaha.ecvi.ResultValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.ResultValueImpl#getResultInteger <em>Result Integer</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.ResultValueImpl#getResultString <em>Result String</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.ResultValueImpl#getResultFloat <em>Result Float</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.ResultValueImpl#getResultName <em>Result Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultValueImpl extends MinimalEObjectImpl.Container implements ResultValue {
	/**
	 * The default value of the '{@link #getResultInteger() <em>Result Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultInteger()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger RESULT_INTEGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultInteger() <em>Result Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultInteger()
	 * @generated
	 * @ordered
	 */
	protected BigInteger resultInteger = RESULT_INTEGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getResultString() <em>Result String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultString()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultString() <em>Result String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultString()
	 * @generated
	 * @ordered
	 */
	protected String resultString = RESULT_STRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getResultFloat() <em>Result Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultFloat()
	 * @generated
	 * @ordered
	 */
	protected static final float RESULT_FLOAT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getResultFloat() <em>Result Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultFloat()
	 * @generated
	 * @ordered
	 */
	protected float resultFloat = RESULT_FLOAT_EDEFAULT;

	/**
	 * This is true if the Result Float attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean resultFloatESet;

	/**
	 * The default value of the '{@link #getResultName() <em>Result Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultName()
	 * @generated
	 * @ordered
	 */
	protected static final ResultName RESULT_NAME_EDEFAULT = ResultName.RESULT;

	/**
	 * The cached value of the '{@link #getResultName() <em>Result Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultName()
	 * @generated
	 * @ordered
	 */
	protected ResultName resultName = RESULT_NAME_EDEFAULT;

	/**
	 * This is true if the Result Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean resultNameESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.RESULT_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getResultInteger() {
		return resultInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultInteger(BigInteger newResultInteger) {
		BigInteger oldResultInteger = resultInteger;
		resultInteger = newResultInteger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.RESULT_VALUE__RESULT_INTEGER, oldResultInteger, resultInteger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultString() {
		return resultString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultString(String newResultString) {
		String oldResultString = resultString;
		resultString = newResultString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.RESULT_VALUE__RESULT_STRING, oldResultString, resultString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getResultFloat() {
		return resultFloat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultFloat(float newResultFloat) {
		float oldResultFloat = resultFloat;
		resultFloat = newResultFloat;
		boolean oldResultFloatESet = resultFloatESet;
		resultFloatESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.RESULT_VALUE__RESULT_FLOAT, oldResultFloat, resultFloat, !oldResultFloatESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResultFloat() {
		float oldResultFloat = resultFloat;
		boolean oldResultFloatESet = resultFloatESet;
		resultFloat = RESULT_FLOAT_EDEFAULT;
		resultFloatESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.RESULT_VALUE__RESULT_FLOAT, oldResultFloat, RESULT_FLOAT_EDEFAULT, oldResultFloatESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResultFloat() {
		return resultFloatESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultName getResultName() {
		return resultName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultName(ResultName newResultName) {
		ResultName oldResultName = resultName;
		resultName = newResultName == null ? RESULT_NAME_EDEFAULT : newResultName;
		boolean oldResultNameESet = resultNameESet;
		resultNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.RESULT_VALUE__RESULT_NAME, oldResultName, resultName, !oldResultNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResultName() {
		ResultName oldResultName = resultName;
		boolean oldResultNameESet = resultNameESet;
		resultName = RESULT_NAME_EDEFAULT;
		resultNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.RESULT_VALUE__RESULT_NAME, oldResultName, RESULT_NAME_EDEFAULT, oldResultNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResultName() {
		return resultNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcviPackage.RESULT_VALUE__RESULT_INTEGER:
				return getResultInteger();
			case EcviPackage.RESULT_VALUE__RESULT_STRING:
				return getResultString();
			case EcviPackage.RESULT_VALUE__RESULT_FLOAT:
				return getResultFloat();
			case EcviPackage.RESULT_VALUE__RESULT_NAME:
				return getResultName();
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
			case EcviPackage.RESULT_VALUE__RESULT_INTEGER:
				setResultInteger((BigInteger)newValue);
				return;
			case EcviPackage.RESULT_VALUE__RESULT_STRING:
				setResultString((String)newValue);
				return;
			case EcviPackage.RESULT_VALUE__RESULT_FLOAT:
				setResultFloat((Float)newValue);
				return;
			case EcviPackage.RESULT_VALUE__RESULT_NAME:
				setResultName((ResultName)newValue);
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
			case EcviPackage.RESULT_VALUE__RESULT_INTEGER:
				setResultInteger(RESULT_INTEGER_EDEFAULT);
				return;
			case EcviPackage.RESULT_VALUE__RESULT_STRING:
				setResultString(RESULT_STRING_EDEFAULT);
				return;
			case EcviPackage.RESULT_VALUE__RESULT_FLOAT:
				unsetResultFloat();
				return;
			case EcviPackage.RESULT_VALUE__RESULT_NAME:
				unsetResultName();
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
			case EcviPackage.RESULT_VALUE__RESULT_INTEGER:
				return RESULT_INTEGER_EDEFAULT == null ? resultInteger != null : !RESULT_INTEGER_EDEFAULT.equals(resultInteger);
			case EcviPackage.RESULT_VALUE__RESULT_STRING:
				return RESULT_STRING_EDEFAULT == null ? resultString != null : !RESULT_STRING_EDEFAULT.equals(resultString);
			case EcviPackage.RESULT_VALUE__RESULT_FLOAT:
				return isSetResultFloat();
			case EcviPackage.RESULT_VALUE__RESULT_NAME:
				return isSetResultName();
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
		result.append(" (resultInteger: ");
		result.append(resultInteger);
		result.append(", resultString: ");
		result.append(resultString);
		result.append(", resultFloat: ");
		if (resultFloatESet) result.append(resultFloat); else result.append("<unset>");
		result.append(", resultName: ");
		if (resultNameESet) result.append(resultName); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ResultValueImpl
