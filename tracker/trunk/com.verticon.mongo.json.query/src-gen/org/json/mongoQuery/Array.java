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
 * A representation of the model object '<em><b>Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.json.mongoQuery.Array#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.json.mongoQuery.MongoQueryPackage#getArray()
 * @model
 * @generated
 */
public interface Array extends EObject
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link org.json.mongoQuery.Query}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see org.json.mongoQuery.MongoQueryPackage#getArray_Values()
   * @model containment="true"
   * @generated
   */
  EList<Query> getValues();

} // Array
