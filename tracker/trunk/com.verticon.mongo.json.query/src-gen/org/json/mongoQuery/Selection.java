/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.json.mongoQuery.Selection#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.json.mongoQuery.MongoQueryPackage#getSelection()
 * @model
 * @generated
 */
public interface Selection extends EObject
{
  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link org.json.mongoQuery.FieldSelection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see org.json.mongoQuery.MongoQueryPackage#getSelection_Fields()
   * @model containment="true"
   * @generated
   */
  EList<FieldSelection> getFields();

} // Selection
