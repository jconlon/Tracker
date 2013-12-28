/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.ProgramStatus#getName <em>Name</em>}</li>
 *   <li>{@link org.usaha.ecvi.ProgramStatus#getValue <em>Value</em>}</li>
 *   <li>{@link org.usaha.ecvi.ProgramStatus#getValueOther <em>Value Other</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getProgramStatus()
 * @model extendedMetaData="name='ProgramStatusType' kind='empty'"
 * @generated
 */
public interface ProgramStatus extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.ProgramStatusName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.usaha.ecvi.ProgramStatusName
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(ProgramStatusName)
	 * @see org.usaha.ecvi.EcviPackage#getProgramStatus_Name()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	ProgramStatusName getName();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.ProgramStatus#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see org.usaha.ecvi.ProgramStatusName
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(ProgramStatusName value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.ProgramStatus#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(ProgramStatusName)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.ProgramStatus#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(ProgramStatusName)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.ProgramStatusValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this is 'Other' you should elaborate using the ValueOther attribute
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.usaha.ecvi.ProgramStatusValue
	 * @see #isSetValue()
	 * @see #unsetValue()
	 * @see #setValue(ProgramStatusValue)
	 * @see org.usaha.ecvi.EcviPackage#getProgramStatus_Value()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='Value'"
	 * @generated
	 */
	ProgramStatusValue getValue();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.ProgramStatus#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see org.usaha.ecvi.ProgramStatusValue
	 * @see #isSetValue()
	 * @see #unsetValue()
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ProgramStatusValue value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.ProgramStatus#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValue()
	 * @see #getValue()
	 * @see #setValue(ProgramStatusValue)
	 * @generated
	 */
	void unsetValue();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.ProgramStatus#getValue <em>Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value</em>' attribute is set.
	 * @see #unsetValue()
	 * @see #getValue()
	 * @see #setValue(ProgramStatusValue)
	 * @generated
	 */
	boolean isSetValue();

	/**
	 * Returns the value of the '<em><b>Value Other</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * You should only provide this attribute if the Value is 'Other'
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Other</em>' attribute.
	 * @see #setValueOther(String)
	 * @see org.usaha.ecvi.EcviPackage#getProgramStatus_ValueOther()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ValueOther'"
	 * @generated
	 */
	String getValueOther();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.ProgramStatus#getValueOther <em>Value Other</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Other</em>' attribute.
	 * @see #getValueOther()
	 * @generated
	 */
	void setValueOther(String value);

} // ProgramStatus
