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

import com.verticon.opengis.kml.AbstractObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Array Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayData#getValue <em>Value</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayData#getSimpleArrayDataExtensionGroup <em>Simple Array Data Extension Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayData#getSimpleArrayDataExtension <em>Simple Array Data Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.SimpleArrayData#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayData()
 * @model extendedMetaData="name='SimpleArrayDataType' kind='elementOnly'"
 * @generated
 */
public interface SimpleArrayData extends AbstractObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayData_Value()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getValue();

	/**
	 * Returns the value of the '<em><b>Simple Array Data Extension Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Array Data Extension Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Array Data Extension Group</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayData_SimpleArrayDataExtensionGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='SimpleArrayDataExtension:group' namespace='##targetNamespace'"
	 * @generated
	 */
	FeatureMap getSimpleArrayDataExtensionGroup();

	/**
	 * Returns the value of the '<em><b>Simple Array Data Extension</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Array Data Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Array Data Extension</em>' containment reference list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayData_SimpleArrayDataExtension()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SimpleArrayDataExtension' namespace='##targetNamespace' group='SimpleArrayDataExtension:group'"
	 * @generated
	 */
	EList<EObject> getSimpleArrayDataExtension();

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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSimpleArrayData_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.SimpleArrayData#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SimpleArrayData
