/**
 */
package org.usaha.ecvi;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * You should choose the correct type for the result based on your source data type. We support Integer, Float and String.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.ResultValue#getResultInteger <em>Result Integer</em>}</li>
 *   <li>{@link org.usaha.ecvi.ResultValue#getResultString <em>Result String</em>}</li>
 *   <li>{@link org.usaha.ecvi.ResultValue#getResultFloat <em>Result Float</em>}</li>
 *   <li>{@link org.usaha.ecvi.ResultValue#getResultName <em>Result Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getResultValue()
 * @model extendedMetaData="name='ResultValueType' kind='elementOnly'"
 * @generated
 */
public interface ResultValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Integer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Integer</em>' attribute.
	 * @see #setResultInteger(BigInteger)
	 * @see org.usaha.ecvi.EcviPackage#getResultValue_ResultInteger()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='element' name='ResultInteger' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getResultInteger();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.ResultValue#getResultInteger <em>Result Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Integer</em>' attribute.
	 * @see #getResultInteger()
	 * @generated
	 */
	void setResultInteger(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Result String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result String</em>' attribute.
	 * @see #setResultString(String)
	 * @see org.usaha.ecvi.EcviPackage#getResultValue_ResultString()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='ResultString' namespace='##targetNamespace'"
	 * @generated
	 */
	String getResultString();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.ResultValue#getResultString <em>Result String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result String</em>' attribute.
	 * @see #getResultString()
	 * @generated
	 */
	void setResultString(String value);

	/**
	 * Returns the value of the '<em><b>Result Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Float</em>' attribute.
	 * @see #isSetResultFloat()
	 * @see #unsetResultFloat()
	 * @see #setResultFloat(float)
	 * @see org.usaha.ecvi.EcviPackage#getResultValue_ResultFloat()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Float"
	 *        extendedMetaData="kind='element' name='ResultFloat' namespace='##targetNamespace'"
	 * @generated
	 */
	float getResultFloat();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.ResultValue#getResultFloat <em>Result Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Float</em>' attribute.
	 * @see #isSetResultFloat()
	 * @see #unsetResultFloat()
	 * @see #getResultFloat()
	 * @generated
	 */
	void setResultFloat(float value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.ResultValue#getResultFloat <em>Result Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetResultFloat()
	 * @see #getResultFloat()
	 * @see #setResultFloat(float)
	 * @generated
	 */
	void unsetResultFloat();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.ResultValue#getResultFloat <em>Result Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Result Float</em>' attribute is set.
	 * @see #unsetResultFloat()
	 * @see #getResultFloat()
	 * @see #setResultFloat(float)
	 * @generated
	 */
	boolean isSetResultFloat();

	/**
	 * Returns the value of the '<em><b>Result Name</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.ResultName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Name</em>' attribute.
	 * @see org.usaha.ecvi.ResultName
	 * @see #isSetResultName()
	 * @see #unsetResultName()
	 * @see #setResultName(ResultName)
	 * @see org.usaha.ecvi.EcviPackage#getResultValue_ResultName()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='ResultName'"
	 * @generated
	 */
	ResultName getResultName();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.ResultValue#getResultName <em>Result Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Name</em>' attribute.
	 * @see org.usaha.ecvi.ResultName
	 * @see #isSetResultName()
	 * @see #unsetResultName()
	 * @see #getResultName()
	 * @generated
	 */
	void setResultName(ResultName value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.ResultValue#getResultName <em>Result Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetResultName()
	 * @see #getResultName()
	 * @see #setResultName(ResultName)
	 * @generated
	 */
	void unsetResultName();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.ResultValue#getResultName <em>Result Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Result Name</em>' attribute is set.
	 * @see #unsetResultName()
	 * @see #getResultName()
	 * @see #setResultName(ResultName)
	 * @generated
	 */
	boolean isSetResultName();

} // ResultValue
