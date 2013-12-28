/**
 */
package org.usaha.ecvi;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Laboratory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Laboratory#getLabName <em>Lab Name</em>}</li>
 *   <li>{@link org.usaha.ecvi.Laboratory#getPremId <em>Prem Id</em>}</li>
 *   <li>{@link org.usaha.ecvi.Laboratory#getAddress <em>Address</em>}</li>
 *   <li>{@link org.usaha.ecvi.Laboratory#getAccessionDate <em>Accession Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.Laboratory#getAccessionNumber <em>Accession Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getLaboratory()
 * @model extendedMetaData="name='Laboratory_._type' kind='elementOnly'"
 * @generated
 */
public interface Laboratory extends EObject {
	/**
	 * Returns the value of the '<em><b>Lab Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lab Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lab Name</em>' attribute.
	 * @see #setLabName(String)
	 * @see org.usaha.ecvi.EcviPackage#getLaboratory_LabName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='LabName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getLabName();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Laboratory#getLabName <em>Lab Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lab Name</em>' attribute.
	 * @see #getLabName()
	 * @generated
	 */
	void setLabName(String value);

	/**
	 * Returns the value of the '<em><b>Prem Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the Premises ID for the Laboratory. If it is an in-field test, then the premises ID of the farm on which the tests were performed should be used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prem Id</em>' attribute.
	 * @see #setPremId(String)
	 * @see org.usaha.ecvi.EcviPackage#getLaboratory_PremId()
	 * @model dataType="org.usaha.ecvi.PremId"
	 *        extendedMetaData="kind='element' name='PremId' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPremId();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Laboratory#getPremId <em>Prem Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prem Id</em>' attribute.
	 * @see #getPremId()
	 * @generated
	 */
	void setPremId(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the address for the Laboratory. If it is an in-field test, then the address of the farm on which the tests were performed should be used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(Address)
	 * @see org.usaha.ecvi.EcviPackage#getLaboratory_Address()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Address' namespace='##targetNamespace'"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Laboratory#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

	/**
	 * Returns the value of the '<em><b>Accession Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the date on which the samples were received by the laboratory.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Accession Date</em>' attribute.
	 * @see #setAccessionDate(XMLGregorianCalendar)
	 * @see org.usaha.ecvi.EcviPackage#getLaboratory_AccessionDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Date" required="true"
	 *        extendedMetaData="kind='attribute' name='AccessionDate'"
	 * @generated
	 */
	XMLGregorianCalendar getAccessionDate();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Laboratory#getAccessionDate <em>Accession Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accession Date</em>' attribute.
	 * @see #getAccessionDate()
	 * @generated
	 */
	void setAccessionDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Accession Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the Accession Number of this accession/test chart.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Accession Number</em>' attribute.
	 * @see #setAccessionNumber(String)
	 * @see org.usaha.ecvi.EcviPackage#getLaboratory_AccessionNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AccessionNumber'"
	 * @generated
	 */
	String getAccessionNumber();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Laboratory#getAccessionNumber <em>Accession Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accession Number</em>' attribute.
	 * @see #getAccessionNumber()
	 * @generated
	 */
	void setAccessionNumber(String value);

} // Laboratory
