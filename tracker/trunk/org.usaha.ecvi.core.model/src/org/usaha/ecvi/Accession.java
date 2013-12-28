/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accession</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Accession#getLaboratory <em>Laboratory</em>}</li>
 *   <li>{@link org.usaha.ecvi.Accession#getId <em>Id</em>}</li>
 *   <li>{@link org.usaha.ecvi.Accession#isInfieldTest <em>Infield Test</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getAccession()
 * @model extendedMetaData="name='AccessionType' kind='elementOnly'"
 * @generated
 */
public interface Accession extends EObject {
	/**
	 * Returns the value of the '<em><b>Laboratory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Laboratory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Laboratory</em>' containment reference.
	 * @see #setLaboratory(Laboratory)
	 * @see org.usaha.ecvi.EcviPackage#getAccession_Laboratory()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Laboratory' namespace='##targetNamespace'"
	 * @generated
	 */
	Laboratory getLaboratory();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Accession#getLaboratory <em>Laboratory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Laboratory</em>' containment reference.
	 * @see #getLaboratory()
	 * @generated
	 */
	void setLaboratory(Laboratory value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the reference number that we will use to associate an animal's test details derived from this Accession.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.usaha.ecvi.EcviPackage#getAccession_Id()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Accession#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Infield Test</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This flag should be 'true' if this Accession is the result of an infield test; it should be 'false' if the Accession was sent to a laboratory
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Infield Test</em>' attribute.
	 * @see #isSetInfieldTest()
	 * @see #unsetInfieldTest()
	 * @see #setInfieldTest(boolean)
	 * @see org.usaha.ecvi.EcviPackage#getAccession_InfieldTest()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='attribute' name='InfieldTest'"
	 * @generated
	 */
	boolean isInfieldTest();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Accession#isInfieldTest <em>Infield Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infield Test</em>' attribute.
	 * @see #isSetInfieldTest()
	 * @see #unsetInfieldTest()
	 * @see #isInfieldTest()
	 * @generated
	 */
	void setInfieldTest(boolean value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.Accession#isInfieldTest <em>Infield Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInfieldTest()
	 * @see #isInfieldTest()
	 * @see #setInfieldTest(boolean)
	 * @generated
	 */
	void unsetInfieldTest();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.Accession#isInfieldTest <em>Infield Test</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Infield Test</em>' attribute is set.
	 * @see #unsetInfieldTest()
	 * @see #isInfieldTest()
	 * @see #setInfieldTest(boolean)
	 * @generated
	 */
	boolean isSetInfieldTest();

} // Accession
