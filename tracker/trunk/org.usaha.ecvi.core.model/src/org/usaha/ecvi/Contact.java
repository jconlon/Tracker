/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Contact#getPremId <em>Prem Id</em>}</li>
 *   <li>{@link org.usaha.ecvi.Contact#getPremName <em>Prem Name</em>}</li>
 *   <li>{@link org.usaha.ecvi.Contact#getAddress <em>Address</em>}</li>
 *   <li>{@link org.usaha.ecvi.Contact#getPerson <em>Person</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getContact()
 * @model extendedMetaData="name='ContactType' kind='elementOnly'"
 * @generated
 */
public interface Contact extends EObject {
	/**
	 * Returns the value of the '<em><b>Prem Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prem Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prem Id</em>' attribute.
	 * @see #setPremId(String)
	 * @see org.usaha.ecvi.EcviPackage#getContact_PremId()
	 * @model dataType="org.usaha.ecvi.PremId"
	 *        extendedMetaData="kind='element' name='PremId' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPremId();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Contact#getPremId <em>Prem Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prem Id</em>' attribute.
	 * @see #getPremId()
	 * @generated
	 */
	void setPremId(String value);

	/**
	 * Returns the value of the '<em><b>Prem Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prem Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prem Name</em>' attribute.
	 * @see #setPremName(String)
	 * @see org.usaha.ecvi.EcviPackage#getContact_PremName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='PremName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPremName();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Contact#getPremName <em>Prem Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prem Name</em>' attribute.
	 * @see #getPremName()
	 * @generated
	 */
	void setPremName(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(Address)
	 * @see org.usaha.ecvi.EcviPackage#getContact_Address()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Address' namespace='##targetNamespace'"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Contact#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

	/**
	 * Returns the value of the '<em><b>Person</b></em>' containment reference list.
	 * The list contents are of type {@link org.usaha.ecvi.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' containment reference list.
	 * @see org.usaha.ecvi.EcviPackage#getContact_Person()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Person' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Person> getPerson();

} // Contact
