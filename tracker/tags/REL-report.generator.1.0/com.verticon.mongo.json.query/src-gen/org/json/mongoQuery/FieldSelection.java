/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.json.mongoQuery.FieldSelection#getKey <em>Key</em>}</li>
 *   <li>{@link org.json.mongoQuery.FieldSelection#getEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.json.mongoQuery.MongoQueryPackage#getFieldSelection()
 * @model
 * @generated
 */
public interface FieldSelection extends EObject
{
  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' attribute.
   * @see #setKey(String)
   * @see org.json.mongoQuery.MongoQueryPackage#getFieldSelection_Key()
   * @model
   * @generated
   */
  String getKey();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.FieldSelection#getKey <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' attribute.
   * @see #getKey()
   * @generated
   */
  void setKey(String value);

  /**
   * Returns the value of the '<em><b>Enabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enabled</em>' attribute.
   * @see #setEnabled(int)
   * @see org.json.mongoQuery.MongoQueryPackage#getFieldSelection_Enabled()
   * @model
   * @generated
   */
  int getEnabled();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.FieldSelection#getEnabled <em>Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enabled</em>' attribute.
   * @see #getEnabled()
   * @generated
   */
  void setEnabled(int value);

} // FieldSelection
