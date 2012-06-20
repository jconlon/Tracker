/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.json.mongoQuery.Query#getKey <em>Key</em>}</li>
 *   <li>{@link org.json.mongoQuery.Query#getValue <em>Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.Query#getStringValue <em>String Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.Query#getNumberValue <em>Number Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.Query#getDateValue <em>Date Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.Query#getArrayValue <em>Array Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.Query#getIntegerValue <em>Integer Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.Query#getObjectValue <em>Object Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.json.mongoQuery.MongoQueryPackage#getQuery()
 * @model
 * @generated
 */
public interface Query extends EObject
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
   * @see org.json.mongoQuery.MongoQueryPackage#getQuery_Key()
   * @model
   * @generated
   */
  String getKey();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Query#getKey <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' attribute.
   * @see #getKey()
   * @generated
   */
  void setKey(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Query)
   * @see org.json.mongoQuery.MongoQueryPackage#getQuery_Value()
   * @model containment="true"
   * @generated
   */
  Query getValue();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Query#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Query value);

  /**
   * Returns the value of the '<em><b>String Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String Value</em>' attribute.
   * @see #setStringValue(String)
   * @see org.json.mongoQuery.MongoQueryPackage#getQuery_StringValue()
   * @model
   * @generated
   */
  String getStringValue();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Query#getStringValue <em>String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String Value</em>' attribute.
   * @see #getStringValue()
   * @generated
   */
  void setStringValue(String value);

  /**
   * Returns the value of the '<em><b>Number Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number Value</em>' attribute.
   * @see #setNumberValue(double)
   * @see org.json.mongoQuery.MongoQueryPackage#getQuery_NumberValue()
   * @model
   * @generated
   */
  double getNumberValue();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Query#getNumberValue <em>Number Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number Value</em>' attribute.
   * @see #getNumberValue()
   * @generated
   */
  void setNumberValue(double value);

  /**
   * Returns the value of the '<em><b>Date Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Value</em>' containment reference.
   * @see #setDateValue(JsonDate)
   * @see org.json.mongoQuery.MongoQueryPackage#getQuery_DateValue()
   * @model containment="true"
   * @generated
   */
  JsonDate getDateValue();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Query#getDateValue <em>Date Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Value</em>' containment reference.
   * @see #getDateValue()
   * @generated
   */
  void setDateValue(JsonDate value);

  /**
   * Returns the value of the '<em><b>Array Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Value</em>' containment reference.
   * @see #setArrayValue(Array)
   * @see org.json.mongoQuery.MongoQueryPackage#getQuery_ArrayValue()
   * @model containment="true"
   * @generated
   */
  Array getArrayValue();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Query#getArrayValue <em>Array Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array Value</em>' containment reference.
   * @see #getArrayValue()
   * @generated
   */
  void setArrayValue(Array value);

  /**
   * Returns the value of the '<em><b>Integer Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integer Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integer Value</em>' attribute.
   * @see #setIntegerValue(int)
   * @see org.json.mongoQuery.MongoQueryPackage#getQuery_IntegerValue()
   * @model
   * @generated
   */
  int getIntegerValue();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Query#getIntegerValue <em>Integer Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integer Value</em>' attribute.
   * @see #getIntegerValue()
   * @generated
   */
  void setIntegerValue(int value);

  /**
   * Returns the value of the '<em><b>Object Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Value</em>' containment reference.
   * @see #setObjectValue(Query)
   * @see org.json.mongoQuery.MongoQueryPackage#getQuery_ObjectValue()
   * @model containment="true"
   * @generated
   */
  Query getObjectValue();

  /**
   * Sets the value of the '{@link org.json.mongoQuery.Query#getObjectValue <em>Object Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Value</em>' containment reference.
   * @see #getObjectValue()
   * @generated
   */
  void setObjectValue(Query value);

} // Query
