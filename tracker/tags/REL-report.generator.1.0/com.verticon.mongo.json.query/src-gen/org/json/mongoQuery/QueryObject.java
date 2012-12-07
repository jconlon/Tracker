/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.json.mongoQuery.QueryObject#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.json.mongoQuery.MongoQueryPackage#getQueryObject()
 * @model
 * @generated
 */
public interface QueryObject extends Query
{
  /**
   * Returns the value of the '<em><b>Members</b></em>' containment reference list.
   * The list contents are of type {@link org.json.mongoQuery.Query}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Members</em>' containment reference list.
   * @see org.json.mongoQuery.MongoQueryPackage#getQueryObject_Members()
   * @model containment="true"
   * @generated
   */
  EList<Query> getMembers();

} // QueryObject
