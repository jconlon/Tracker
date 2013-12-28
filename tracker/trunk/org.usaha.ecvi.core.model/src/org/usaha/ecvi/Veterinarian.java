/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Veterinarian</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Veterinarian#getPerson <em>Person</em>}</li>
 *   <li>{@link org.usaha.ecvi.Veterinarian#getAddress <em>Address</em>}</li>
 *   <li>{@link org.usaha.ecvi.Veterinarian#getLicenseIssueState <em>License Issue State</em>}</li>
 *   <li>{@link org.usaha.ecvi.Veterinarian#getLicenseNumber <em>License Number</em>}</li>
 *   <li>{@link org.usaha.ecvi.Veterinarian#getNationalAccreditationNumber <em>National Accreditation Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getVeterinarian()
 * @model extendedMetaData="name='Veterinarian_._type' kind='elementOnly'"
 * @generated
 */
public interface Veterinarian extends EObject {
	/**
	 * Returns the value of the '<em><b>Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' containment reference.
	 * @see #setPerson(Person)
	 * @see org.usaha.ecvi.EcviPackage#getVeterinarian_Person()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Person' namespace='##targetNamespace'"
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Veterinarian#getPerson <em>Person</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' containment reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

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
	 * @see org.usaha.ecvi.EcviPackage#getVeterinarian_Address()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Address' namespace='##targetNamespace'"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Veterinarian#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

	/**
	 * Returns the value of the '<em><b>License Issue State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.UsState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License Issue State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License Issue State</em>' attribute.
	 * @see org.usaha.ecvi.UsState
	 * @see #isSetLicenseIssueState()
	 * @see #unsetLicenseIssueState()
	 * @see #setLicenseIssueState(UsState)
	 * @see org.usaha.ecvi.EcviPackage#getVeterinarian_LicenseIssueState()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='LicenseIssueState'"
	 * @generated
	 */
	UsState getLicenseIssueState();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Veterinarian#getLicenseIssueState <em>License Issue State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License Issue State</em>' attribute.
	 * @see org.usaha.ecvi.UsState
	 * @see #isSetLicenseIssueState()
	 * @see #unsetLicenseIssueState()
	 * @see #getLicenseIssueState()
	 * @generated
	 */
	void setLicenseIssueState(UsState value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.Veterinarian#getLicenseIssueState <em>License Issue State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLicenseIssueState()
	 * @see #getLicenseIssueState()
	 * @see #setLicenseIssueState(UsState)
	 * @generated
	 */
	void unsetLicenseIssueState();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.Veterinarian#getLicenseIssueState <em>License Issue State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>License Issue State</em>' attribute is set.
	 * @see #unsetLicenseIssueState()
	 * @see #getLicenseIssueState()
	 * @see #setLicenseIssueState(UsState)
	 * @generated
	 */
	boolean isSetLicenseIssueState();

	/**
	 * Returns the value of the '<em><b>License Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License Number</em>' attribute.
	 * @see #setLicenseNumber(String)
	 * @see org.usaha.ecvi.EcviPackage#getVeterinarian_LicenseNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LicenseNumber'"
	 * @generated
	 */
	String getLicenseNumber();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Veterinarian#getLicenseNumber <em>License Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License Number</em>' attribute.
	 * @see #getLicenseNumber()
	 * @generated
	 */
	void setLicenseNumber(String value);

	/**
	 * Returns the value of the '<em><b>National Accreditation Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>National Accreditation Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>National Accreditation Number</em>' attribute.
	 * @see #setNationalAccreditationNumber(String)
	 * @see org.usaha.ecvi.EcviPackage#getVeterinarian_NationalAccreditationNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='NationalAccreditationNumber'"
	 * @generated
	 */
	String getNationalAccreditationNumber();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Veterinarian#getNationalAccreditationNumber <em>National Accreditation Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>National Accreditation Number</em>' attribute.
	 * @see #getNationalAccreditationNumber()
	 * @generated
	 */
	void setNationalAccreditationNumber(String value);

} // Veterinarian
