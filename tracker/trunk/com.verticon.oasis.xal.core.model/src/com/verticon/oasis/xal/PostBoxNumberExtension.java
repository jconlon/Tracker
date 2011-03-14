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
 * A representation of the model object '<em><b>Post Box Number Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.PostBoxNumberExtension#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostBoxNumberExtension#getNumberExtensionSeparator <em>Number Extension Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PostBoxNumberExtension#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberExtension()
 * @model extendedMetaData="name='PostBoxNumberExtension_._type' kind='mixed'"
 * @generated
 */
public interface PostBoxNumberExtension extends EObject {
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
	 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberExtension_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Number Extension Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "-" is the NumberExtensionSeparator in POBOX:12345-123
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number Extension Separator</em>' attribute.
	 * @see #setNumberExtensionSeparator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberExtension_NumberExtensionSeparator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='NumberExtensionSeparator'"
	 * @generated
	 */
	Object getNumberExtensionSeparator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PostBoxNumberExtension#getNumberExtensionSeparator <em>Number Extension Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Extension Separator</em>' attribute.
	 * @see #getNumberExtensionSeparator()
	 * @generated
	 */
	void setNumberExtensionSeparator(Object value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getPostBoxNumberExtension_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':2' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // PostBoxNumberExtension
