/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Phone Num</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.PhoneNum#getComment <em>Comment</em>}</li>
 *   <li>{@link org.usaha.ecvi.PhoneNum#getNumber <em>Number</em>}</li>
 *   <li>{@link org.usaha.ecvi.PhoneNum#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getPhoneNum()
 * @model extendedMetaData="name='PhoneNumType' kind='empty'"
 * @generated
 */
public interface PhoneNum extends EObject {
	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is meant for comments about this phone number. Examples might be an extension number or a comment such as "daytime only."
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.usaha.ecvi.EcviPackage#getPhoneNum_Comment()
	 * @model dataType="org.usaha.ecvi.PhoneNumComment"
	 *        extendedMetaData="kind='attribute' name='Comment'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.PhoneNum#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(String)
	 * @see org.usaha.ecvi.EcviPackage#getPhoneNum_Number()
	 * @model dataType="org.usaha.ecvi.PhoneNumNumber" required="true"
	 *        extendedMetaData="kind='attribute' name='Number'"
	 * @generated
	 */
	String getNumber();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.PhoneNum#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.PhoneDevice}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.usaha.ecvi.PhoneDevice
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(PhoneDevice)
	 * @see org.usaha.ecvi.EcviPackage#getPhoneNum_Type()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	PhoneDevice getType();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.PhoneNum#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.usaha.ecvi.PhoneDevice
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(PhoneDevice value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.PhoneNum#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(PhoneDevice)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.PhoneNum#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(PhoneDevice)
	 * @generated
	 */
	boolean isSetType();

} // PhoneNum
