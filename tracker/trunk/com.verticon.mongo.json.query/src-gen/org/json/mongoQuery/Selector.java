/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.json.mongoQuery.Selector#getQuery <em>Query</em>}</li>
 *   <li>{@link org.json.mongoQuery.Selector#getSelection <em>Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.json.mongoQuery.MongoQueryPackage#getSelector()
 * @model
 * @generated
 */
public interface Selector extends EObject
{
  /**
   * Returns the value of the '<em><b>Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Query</em>' containment reference.
   * @see #setQuery(Query)
   * @see org.json.mongoQuery.MongoQueryPackage#getSelector_Query()
   * @model containment="true"
   * @generated
   */
  Query getQuery();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Selector#getQuery <em>Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query</em>' containment reference.
   * @see #getQuery()
   * @generated
   */
  void setQuery(Query value);

  /**
   * Returns the value of the '<em><b>Selection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selection</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selection</em>' containment reference.
   * @see #setSelection(Selection)
   * @see org.json.mongoQuery.MongoQueryPackage#getSelector_Selection()
   * @model containment="true"
   * @generated
   */
  Selection getSelection();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Selector#getSelection <em>Selection</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Selection</em>' containment reference.
   * @see #getSelection()
   * @generated
   */
  void setSelection(Selection value);

} // Selector
