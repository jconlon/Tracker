/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Test#getResult <em>Result</em>}</li>
 *   <li>{@link org.usaha.ecvi.Test#getIdref <em>Idref</em>}</li>
 *   <li>{@link org.usaha.ecvi.Test#getTestCode <em>Test Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getTest()
 * @model extendedMetaData="name='TestType' kind='elementOnly'"
 * @generated
 */
public interface Test extends EObject {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference list.
	 * The list contents are of type {@link org.usaha.ecvi.ResultValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference list.
	 * @see org.usaha.ecvi.EcviPackage#getTest_Result()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Result' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ResultValue> getResult();

	/**
	 * Returns the value of the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This *must* be one of the ID values in the Accessions included with this document. If any Animal Test references an Accession ID that doesn't exist, the document will not be valid.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Idref</em>' attribute.
	 * @see #setIdref(String)
	 * @see org.usaha.ecvi.EcviPackage#getTest_Idref()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF" required="true"
	 *        extendedMetaData="kind='attribute' name='idref'"
	 * @generated
	 */
	String getIdref();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Test#getIdref <em>Idref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idref</em>' attribute.
	 * @see #getIdref()
	 * @generated
	 */
	void setIdref(String value);

	/**
	 * Returns the value of the '<em><b>Test Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Code</em>' attribute.
	 * @see #setTestCode(String)
	 * @see org.usaha.ecvi.EcviPackage#getTest_TestCode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='TestCode'"
	 * @generated
	 */
	String getTestCode();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Test#getTestCode <em>Test Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Code</em>' attribute.
	 * @see #getTestCode()
	 * @generated
	 */
	void setTestCode(String value);

} // Test
