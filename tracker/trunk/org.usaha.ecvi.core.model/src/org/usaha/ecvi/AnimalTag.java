/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animal Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.AnimalTag#getBrandImage <em>Brand Image</em>}</li>
 *   <li>{@link org.usaha.ecvi.AnimalTag#getNumber <em>Number</em>}</li>
 *   <li>{@link org.usaha.ecvi.AnimalTag#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getAnimalTag()
 * @model extendedMetaData="name='AnimalTag_._type' kind='empty'"
 * @generated
 */
public interface AnimalTag extends EObject {
	/**
	 * Returns the value of the '<em><b>Brand Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This should be PNG/JPEG/GIF/PDF format and must be provided if the TagType is BRAND-IMAGE
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Brand Image</em>' attribute.
	 * @see #setBrandImage(byte[])
	 * @see org.usaha.ecvi.EcviPackage#getAnimalTag_BrandImage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Base64Binary"
	 *        extendedMetaData="kind='attribute' name='BrandImage'"
	 * @generated
	 */
	byte[] getBrandImage();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.AnimalTag#getBrandImage <em>Brand Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Brand Image</em>' attribute.
	 * @see #getBrandImage()
	 * @generated
	 */
	void setBrandImage(byte[] value);

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
	 * @see org.usaha.ecvi.EcviPackage#getAnimalTag_Number()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Number'"
	 * @generated
	 */
	String getNumber();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.AnimalTag#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.TagType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.usaha.ecvi.TagType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(TagType)
	 * @see org.usaha.ecvi.EcviPackage#getAnimalTag_Type()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	TagType getType();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.AnimalTag#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.usaha.ecvi.TagType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(TagType value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.AnimalTag#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(TagType)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.AnimalTag#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(TagType)
	 * @generated
	 */
	boolean isSetType();

} // AnimalTag
