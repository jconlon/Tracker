/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.atom.authorlink;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.atom.authorlink.Link#getHref <em>Href</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.Link#getHreflang <em>Hreflang</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.Link#getLength <em>Length</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.Link#getRel <em>Rel</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.Link#getTitle <em>Title</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.Link#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.atom.authorlink.AuthorlinkPackage#getLink()
 * @model extendedMetaData="name='link_._type' kind='empty'"
 * @generated
 */
public interface Link extends EObject {
	/**
	 * Returns the value of the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Href</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Href</em>' attribute.
	 * @see #setHref(Object)
	 * @see com.verticon.atom.authorlink.AuthorlinkPackage#getLink_Href()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='href'"
	 * @generated
	 */
	Object getHref();

	/**
	 * Sets the value of the '{@link com.verticon.atom.authorlink.Link#getHref <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Href</em>' attribute.
	 * @see #getHref()
	 * @generated
	 */
	void setHref(Object value);

	/**
	 * Returns the value of the '<em><b>Hreflang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hreflang</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hreflang</em>' attribute.
	 * @see #setHreflang(String)
	 * @see com.verticon.atom.authorlink.AuthorlinkPackage#getLink_Hreflang()
	 * @model dataType="com.verticon.atom.authorlink.AtomLanguageTag"
	 *        extendedMetaData="kind='attribute' name='hreflang'"
	 * @generated
	 */
	String getHreflang();

	/**
	 * Sets the value of the '{@link com.verticon.atom.authorlink.Link#getHreflang <em>Hreflang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hreflang</em>' attribute.
	 * @see #getHreflang()
	 * @generated
	 */
	void setHreflang(String value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(Object)
	 * @see com.verticon.atom.authorlink.AuthorlinkPackage#getLink_Length()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='length'"
	 * @generated
	 */
	Object getLength();

	/**
	 * Sets the value of the '{@link com.verticon.atom.authorlink.Link#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Object value);

	/**
	 * Returns the value of the '<em><b>Rel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel</em>' attribute.
	 * @see #setRel(Object)
	 * @see com.verticon.atom.authorlink.AuthorlinkPackage#getLink_Rel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='rel'"
	 * @generated
	 */
	Object getRel();

	/**
	 * Sets the value of the '{@link com.verticon.atom.authorlink.Link#getRel <em>Rel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel</em>' attribute.
	 * @see #getRel()
	 * @generated
	 */
	void setRel(Object value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(Object)
	 * @see com.verticon.atom.authorlink.AuthorlinkPackage#getLink_Title()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='title'"
	 * @generated
	 */
	Object getTitle();

	/**
	 * Sets the value of the '{@link com.verticon.atom.authorlink.Link#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(Object value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.verticon.atom.authorlink.AuthorlinkPackage#getLink_Type()
	 * @model dataType="com.verticon.atom.authorlink.AtomMediaType"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.verticon.atom.authorlink.Link#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // Link
