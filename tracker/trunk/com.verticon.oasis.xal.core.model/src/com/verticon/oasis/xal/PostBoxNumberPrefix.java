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
 * A representation of the model object '<em><b>Post Box Number Prefix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getNumberPrefixSeparator <em>Number Prefix Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberPrefix()
 * @model extendedMetaData="name='PostBoxNumberPrefix_._type' kind='mixed'"
 * @generated
 */
public interface PostBoxNumberPrefix extends EObject {
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
	 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberPrefix_Mixed()
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
	 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberPrefix_Code()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Code'"
	 * @generated
	 */
	Object getCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(Object value);

	/**
	 * Returns the value of the '<em><b>Number Prefix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A-12 where 12 is number and A is prefix and "-" is the separator
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number Prefix Separator</em>' attribute.
	 * @see #setNumberPrefixSeparator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberPrefix_NumberPrefixSeparator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='NumberPrefixSeparator'"
	 * @generated
	 */
	Object getNumberPrefixSeparator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostBoxNumberPrefix#getNumberPrefixSeparator <em>Number Prefix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Prefix Separator</em>' attribute.
	 * @see #getNumberPrefixSeparator()
	 * @generated
	 */
	void setNumberPrefixSeparator(Object value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberPrefix_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':3' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // PostBoxNumberPrefix
