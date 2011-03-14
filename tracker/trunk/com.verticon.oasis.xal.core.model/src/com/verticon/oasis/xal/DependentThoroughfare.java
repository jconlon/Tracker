/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependent Thoroughfare</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareName <em>Thoroughfare Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.DependentThoroughfare#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare()
 * @model extendedMetaData="name='DependentThoroughfare_._type' kind='elementOnly'"
 * @generated
 */
public interface DependentThoroughfare extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Pre Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * North Baker Street, where North is the pre-direction. The direction appears before the name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Pre Direction</em>' containment reference.
	 * @see #setThoroughfarePreDirection(ThoroughfarePreDirection)
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_ThoroughfarePreDirection()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfarePreDirection' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfarePreDirection getThoroughfarePreDirection();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Pre Direction</em>' containment reference.
	 * @see #getThoroughfarePreDirection()
	 * @generated
	 */
	void setThoroughfarePreDirection(ThoroughfarePreDirection value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare Leading Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Appears before the thoroughfare name. Ed. Spanish: Avenida Aurora, where Avenida is the leading type / French: Rue Moliere, where Rue is the leading type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Leading Type</em>' containment reference.
	 * @see #setThoroughfareLeadingType(ThoroughfareLeadingType)
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_ThoroughfareLeadingType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareLeadingType' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfareLeadingType getThoroughfareLeadingType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Leading Type</em>' containment reference.
	 * @see #getThoroughfareLeadingType()
	 * @generated
	 */
	void setThoroughfareLeadingType(ThoroughfareLeadingType value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare Name</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.ThoroughfareName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the name of a Thoroughfare (also dependant street name): street name, canal name, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Name</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_ThoroughfareName()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ThoroughfareName> getThoroughfareName();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Trailing Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Appears after the thoroughfare name. Ed. British: Baker Lane, where Lane is the trailing type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Trailing Type</em>' containment reference.
	 * @see #setThoroughfareTrailingType(ThoroughfareTrailingType)
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_ThoroughfareTrailingType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareTrailingType' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfareTrailingType getThoroughfareTrailingType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Trailing Type</em>' containment reference.
	 * @see #getThoroughfareTrailingType()
	 * @generated
	 */
	void setThoroughfareTrailingType(ThoroughfareTrailingType value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare Post Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 221-bis Baker Street North, where North is the post-direction. The post-direction appears after the name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Post Direction</em>' containment reference.
	 * @see #setThoroughfarePostDirection(ThoroughfarePostDirection)
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_ThoroughfarePostDirection()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfarePostDirection' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfarePostDirection getThoroughfarePostDirection();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.DependentThoroughfare#getThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Post Direction</em>' containment reference.
	 * @see #getThoroughfarePostDirection()
	 * @generated
	 */
	void setThoroughfarePostDirection(ThoroughfarePostDirection value);

	/**
	 * Returns the value of the '<em><b>Any</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute list.
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':6' processing='strict'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.DependentThoroughfare#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(Object value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getDependentThoroughfare_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':8' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // DependentThoroughfare
