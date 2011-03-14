/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Array Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayField#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayField#getSimpleArrayFieldExtensionGroup <em>Simple Array Field Extension Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayField#getSimpleArrayFieldExtension <em>Simple Array Field Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayField#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayField#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayField()
 * @model extendedMetaData="name='SimpleArrayFieldType' kind='elementOnly'"
 * @generated
 */
public interface SimpleArrayField extends EObject {
	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayField_DisplayName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='displayName' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.SimpleArrayField#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Simple Array Field Extension Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Array Field Extension Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Array Field Extension Group</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayField_SimpleArrayFieldExtensionGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='SimpleArrayFieldExtension:group' namespace='##targetNamespace'"
	 * @generated
	 */
	FeatureMap getSimpleArrayFieldExtensionGroup();

	/**
	 * Returns the value of the '<em><b>Simple Array Field Extension</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Array Field Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Array Field Extension</em>' containment reference list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayField_SimpleArrayFieldExtension()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SimpleArrayFieldExtension' namespace='##targetNamespace' group='SimpleArrayFieldExtension:group'"
	 * @generated
	 */
	EList<EObject> getSimpleArrayFieldExtension();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayField_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.SimpleArrayField#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayField_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.SimpleArrayField#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // SimpleArrayField
