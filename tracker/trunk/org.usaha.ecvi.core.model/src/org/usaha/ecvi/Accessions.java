/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accessions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Accessions#getAccession <em>Accession</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getAccessions()
 * @model extendedMetaData="name='Accessions_._type' kind='elementOnly'"
 * @generated
 */
public interface Accessions extends EObject {
	/**
	 * Returns the value of the '<em><b>Accession</b></em>' containment reference list.
	 * The list contents are of type {@link org.usaha.ecvi.Accession}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accession</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accession</em>' containment reference list.
	 * @see org.usaha.ecvi.EcviPackage#getAccessions_Accession()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Accession' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Accession> getAccession();

} // Accessions
