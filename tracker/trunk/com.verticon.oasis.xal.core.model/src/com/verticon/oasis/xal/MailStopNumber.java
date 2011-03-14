/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mail Stop Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.MailStopNumber#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.MailStopNumber#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.MailStopNumber#getNameNumberSeparator <em>Name Number Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.MailStopNumber#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getMailStopNumber()
 * @model extendedMetaData="name='MailStopNumber_._type' kind='mixed'"
 * @generated
 */
public interface MailStopNumber extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.verticon.oasis.xal.XalPackage#getMailStopNumber_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used by postal services to encode the name of the element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getMailStopNumber_Code()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Code'"
	 * @generated
	 */
	Object getCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.MailStopNumber#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(Object value);

	/**
	 * Returns the value of the '<em><b>Name Number Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "-" in MS-123
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name Number Separator</em>' attribute.
	 * @see #setNameNumberSeparator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getMailStopNumber_NameNumberSeparator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='NameNumberSeparator'"
	 * @generated
	 */
	Object getNameNumberSeparator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.MailStopNumber#getNameNumberSeparator <em>Name Number Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Number Separator</em>' attribute.
	 * @see #getNameNumberSeparator()
	 * @generated
	 */
	void setNameNumberSeparator(Object value);

	/**
	 * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Attribute</em>' attribute list.
	 * @see com.verticon.oasis.xal.XalPackage#getMailStopNumber_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':3' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // MailStopNumber
