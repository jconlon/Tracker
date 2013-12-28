/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attachement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Attachement#getPayload <em>Payload</em>}</li>
 *   <li>{@link org.usaha.ecvi.Attachement#getComment <em>Comment</em>}</li>
 *   <li>{@link org.usaha.ecvi.Attachement#getDocType <em>Doc Type</em>}</li>
 *   <li>{@link org.usaha.ecvi.Attachement#getFilename <em>Filename</em>}</li>
 *   <li>{@link org.usaha.ecvi.Attachement#getMimeType <em>Mime Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getAttachement()
 * @model extendedMetaData="name='AttachmentType' kind='elementOnly'"
 * @generated
 */
public interface Attachement extends EObject {
	/**
	 * Returns the value of the '<em><b>Payload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload</em>' attribute.
	 * @see #setPayload(byte[])
	 * @see org.usaha.ecvi.EcviPackage#getAttachement_Payload()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Base64Binary" required="true"
	 *        extendedMetaData="kind='element' name='Payload' namespace='##targetNamespace'"
	 * @generated
	 */
	byte[] getPayload();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Attachement#getPayload <em>Payload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload</em>' attribute.
	 * @see #getPayload()
	 * @generated
	 */
	void setPayload(byte[] value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.usaha.ecvi.EcviPackage#getAttachement_Comment()
	 * @model dataType="org.usaha.ecvi.AttachementComment"
	 *        extendedMetaData="kind='attribute' name='Comment'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Attachement#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Doc Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.DocType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This specifies what type of document this attachment is
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Doc Type</em>' attribute.
	 * @see org.usaha.ecvi.DocType
	 * @see #isSetDocType()
	 * @see #unsetDocType()
	 * @see #setDocType(DocType)
	 * @see org.usaha.ecvi.EcviPackage#getAttachement_DocType()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='DocType'"
	 * @generated
	 */
	DocType getDocType();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Attachement#getDocType <em>Doc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Doc Type</em>' attribute.
	 * @see org.usaha.ecvi.DocType
	 * @see #isSetDocType()
	 * @see #unsetDocType()
	 * @see #getDocType()
	 * @generated
	 */
	void setDocType(DocType value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.Attachement#getDocType <em>Doc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDocType()
	 * @see #getDocType()
	 * @see #setDocType(DocType)
	 * @generated
	 */
	void unsetDocType();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.Attachement#getDocType <em>Doc Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Doc Type</em>' attribute is set.
	 * @see #unsetDocType()
	 * @see #getDocType()
	 * @see #setDocType(DocType)
	 * @generated
	 */
	boolean isSetDocType();

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see org.usaha.ecvi.EcviPackage#getAttachement_Filename()
	 * @model dataType="org.usaha.ecvi.FileName" required="true"
	 *        extendedMetaData="kind='attribute' name='Filename'"
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Attachement#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Mime Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mime Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mime Type</em>' attribute.
	 * @see #setMimeType(String)
	 * @see org.usaha.ecvi.EcviPackage#getAttachement_MimeType()
	 * @model dataType="org.usaha.ecvi.MimeType"
	 *        extendedMetaData="kind='attribute' name='MimeType'"
	 * @generated
	 */
	String getMimeType();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Attachement#getMimeType <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mime Type</em>' attribute.
	 * @see #getMimeType()
	 * @generated
	 */
	void setMimeType(String value);

} // Attachement
