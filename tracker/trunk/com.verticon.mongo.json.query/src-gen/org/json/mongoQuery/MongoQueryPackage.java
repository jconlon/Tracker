/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.json.mongoQuery.MongoQueryFactory
 * @model kind="package"
 * @generated
 */
public interface MongoQueryPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mongoQuery";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.json.org/MongoQuery";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mongoQuery";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MongoQueryPackage eINSTANCE = org.json.mongoQuery.impl.MongoQueryPackageImpl.init();

  /**
   * The meta object id for the '{@link org.json.mongoQuery.impl.SelectorImpl <em>Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.json.mongoQuery.impl.SelectorImpl
   * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getSelector()
   * @generated
   */
  int SELECTOR = 0;

  /**
   * The feature id for the '<em><b>Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR__QUERY = 0;

  /**
   * The feature id for the '<em><b>Selection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR__SELECTION = 1;

  /**
   * The number of structural features of the '<em>Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.json.mongoQuery.impl.SelectionImpl <em>Selection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.json.mongoQuery.impl.SelectionImpl
   * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getSelection()
   * @generated
   */
  int SELECTION = 1;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__FIELDS = 0;

  /**
   * The number of structural features of the '<em>Selection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.json.mongoQuery.impl.FieldSelectionImpl <em>Field Selection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.json.mongoQuery.impl.FieldSelectionImpl
   * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getFieldSelection()
   * @generated
   */
  int FIELD_SELECTION = 2;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_SELECTION__KEY = 0;

  /**
   * The feature id for the '<em><b>Enabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_SELECTION__ENABLED = 1;

  /**
   * The number of structural features of the '<em>Field Selection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_SELECTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.json.mongoQuery.impl.QueryImpl <em>Query</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.json.mongoQuery.impl.QueryImpl
   * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getQuery()
   * @generated
   */
  int QUERY = 3;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__VALUE = 1;

  /**
   * The feature id for the '<em><b>String Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__STRING_VALUE = 2;

  /**
   * The feature id for the '<em><b>Number Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__NUMBER_VALUE = 3;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__DATE_VALUE = 4;

  /**
   * The feature id for the '<em><b>Array Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__ARRAY_VALUE = 5;

  /**
   * The feature id for the '<em><b>Integer Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__INTEGER_VALUE = 6;

  /**
   * The feature id for the '<em><b>Object Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__OBJECT_VALUE = 7;

  /**
   * The number of structural features of the '<em>Query</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.json.mongoQuery.impl.ArrayImpl <em>Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.json.mongoQuery.impl.ArrayImpl
   * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getArray()
   * @generated
   */
  int ARRAY = 4;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY__VALUES = 0;

  /**
   * The number of structural features of the '<em>Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.json.mongoQuery.impl.JsonDateImpl <em>Json Date</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.json.mongoQuery.impl.JsonDateImpl
   * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getJsonDate()
   * @generated
   */
  int JSON_DATE = 5;

  /**
   * The feature id for the '<em><b>Milliseconds</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__MILLISECONDS = 0;

  /**
   * The feature id for the '<em><b>Date String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__DATE_STRING = 1;

  /**
   * The feature id for the '<em><b>Year</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__YEAR = 2;

  /**
   * The feature id for the '<em><b>Month</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__MONTH = 3;

  /**
   * The feature id for the '<em><b>Day</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__DAY = 4;

  /**
   * The feature id for the '<em><b>Hour</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__HOUR = 5;

  /**
   * The feature id for the '<em><b>Minute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__MINUTE = 6;

  /**
   * The feature id for the '<em><b>Second</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__SECOND = 7;

  /**
   * The feature id for the '<em><b>Millisecond</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE__MILLISECOND = 8;

  /**
   * The number of structural features of the '<em>Json Date</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JSON_DATE_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link org.json.mongoQuery.impl.QueryObjectImpl <em>Query Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.json.mongoQuery.impl.QueryObjectImpl
   * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getQueryObject()
   * @generated
   */
  int QUERY_OBJECT = 6;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__KEY = QUERY__KEY;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__VALUE = QUERY__VALUE;

  /**
   * The feature id for the '<em><b>String Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__STRING_VALUE = QUERY__STRING_VALUE;

  /**
   * The feature id for the '<em><b>Number Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__NUMBER_VALUE = QUERY__NUMBER_VALUE;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__DATE_VALUE = QUERY__DATE_VALUE;

  /**
   * The feature id for the '<em><b>Array Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__ARRAY_VALUE = QUERY__ARRAY_VALUE;

  /**
   * The feature id for the '<em><b>Integer Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__INTEGER_VALUE = QUERY__INTEGER_VALUE;

  /**
   * The feature id for the '<em><b>Object Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__OBJECT_VALUE = QUERY__OBJECT_VALUE;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT__MEMBERS = QUERY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Query Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_OBJECT_FEATURE_COUNT = QUERY_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.json.mongoQuery.Selector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selector</em>'.
   * @see org.json.mongoQuery.Selector
   * @generated
   */
  EClass getSelector();

  /**
   * Returns the meta object for the containment reference '{@link org.json.mongoQuery.Selector#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Query</em>'.
   * @see org.json.mongoQuery.Selector#getQuery()
   * @see #getSelector()
   * @generated
   */
  EReference getSelector_Query();

  /**
   * Returns the meta object for the containment reference '{@link org.json.mongoQuery.Selector#getSelection <em>Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Selection</em>'.
   * @see org.json.mongoQuery.Selector#getSelection()
   * @see #getSelector()
   * @generated
   */
  EReference getSelector_Selection();

  /**
   * Returns the meta object for class '{@link org.json.mongoQuery.Selection <em>Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection</em>'.
   * @see org.json.mongoQuery.Selection
   * @generated
   */
  EClass getSelection();

  /**
   * Returns the meta object for the containment reference list '{@link org.json.mongoQuery.Selection#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.json.mongoQuery.Selection#getFields()
   * @see #getSelection()
   * @generated
   */
  EReference getSelection_Fields();

  /**
   * Returns the meta object for class '{@link org.json.mongoQuery.FieldSelection <em>Field Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Selection</em>'.
   * @see org.json.mongoQuery.FieldSelection
   * @generated
   */
  EClass getFieldSelection();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.FieldSelection#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.json.mongoQuery.FieldSelection#getKey()
   * @see #getFieldSelection()
   * @generated
   */
  EAttribute getFieldSelection_Key();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.FieldSelection#getEnabled <em>Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Enabled</em>'.
   * @see org.json.mongoQuery.FieldSelection#getEnabled()
   * @see #getFieldSelection()
   * @generated
   */
  EAttribute getFieldSelection_Enabled();

  /**
   * Returns the meta object for class '{@link org.json.mongoQuery.Query <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query</em>'.
   * @see org.json.mongoQuery.Query
   * @generated
   */
  EClass getQuery();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.Query#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.json.mongoQuery.Query#getKey()
   * @see #getQuery()
   * @generated
   */
  EAttribute getQuery_Key();

  /**
   * Returns the meta object for the containment reference '{@link org.json.mongoQuery.Query#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.json.mongoQuery.Query#getValue()
   * @see #getQuery()
   * @generated
   */
  EReference getQuery_Value();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.Query#getStringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Value</em>'.
   * @see org.json.mongoQuery.Query#getStringValue()
   * @see #getQuery()
   * @generated
   */
  EAttribute getQuery_StringValue();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.Query#getNumberValue <em>Number Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number Value</em>'.
   * @see org.json.mongoQuery.Query#getNumberValue()
   * @see #getQuery()
   * @generated
   */
  EAttribute getQuery_NumberValue();

  /**
   * Returns the meta object for the containment reference '{@link org.json.mongoQuery.Query#getDateValue <em>Date Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Date Value</em>'.
   * @see org.json.mongoQuery.Query#getDateValue()
   * @see #getQuery()
   * @generated
   */
  EReference getQuery_DateValue();

  /**
   * Returns the meta object for the containment reference '{@link org.json.mongoQuery.Query#getArrayValue <em>Array Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Array Value</em>'.
   * @see org.json.mongoQuery.Query#getArrayValue()
   * @see #getQuery()
   * @generated
   */
  EReference getQuery_ArrayValue();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.Query#getIntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Integer Value</em>'.
   * @see org.json.mongoQuery.Query#getIntegerValue()
   * @see #getQuery()
   * @generated
   */
  EAttribute getQuery_IntegerValue();

  /**
   * Returns the meta object for the containment reference '{@link org.json.mongoQuery.Query#getObjectValue <em>Object Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Object Value</em>'.
   * @see org.json.mongoQuery.Query#getObjectValue()
   * @see #getQuery()
   * @generated
   */
  EReference getQuery_ObjectValue();

  /**
   * Returns the meta object for class '{@link org.json.mongoQuery.Array <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array</em>'.
   * @see org.json.mongoQuery.Array
   * @generated
   */
  EClass getArray();

  /**
   * Returns the meta object for the containment reference list '{@link org.json.mongoQuery.Array#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.json.mongoQuery.Array#getValues()
   * @see #getArray()
   * @generated
   */
  EReference getArray_Values();

  /**
   * Returns the meta object for class '{@link org.json.mongoQuery.JsonDate <em>Json Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Json Date</em>'.
   * @see org.json.mongoQuery.JsonDate
   * @generated
   */
  EClass getJsonDate();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getMilliseconds <em>Milliseconds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Milliseconds</em>'.
   * @see org.json.mongoQuery.JsonDate#getMilliseconds()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_Milliseconds();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getDateString <em>Date String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date String</em>'.
   * @see org.json.mongoQuery.JsonDate#getDateString()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_DateString();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getYear <em>Year</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Year</em>'.
   * @see org.json.mongoQuery.JsonDate#getYear()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_Year();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getMonth <em>Month</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Month</em>'.
   * @see org.json.mongoQuery.JsonDate#getMonth()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_Month();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getDay <em>Day</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Day</em>'.
   * @see org.json.mongoQuery.JsonDate#getDay()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_Day();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getHour <em>Hour</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hour</em>'.
   * @see org.json.mongoQuery.JsonDate#getHour()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_Hour();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getMinute <em>Minute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Minute</em>'.
   * @see org.json.mongoQuery.JsonDate#getMinute()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_Minute();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Second</em>'.
   * @see org.json.mongoQuery.JsonDate#getSecond()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_Second();

  /**
   * Returns the meta object for the attribute '{@link org.json.mongoQuery.JsonDate#getMillisecond <em>Millisecond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Millisecond</em>'.
   * @see org.json.mongoQuery.JsonDate#getMillisecond()
   * @see #getJsonDate()
   * @generated
   */
  EAttribute getJsonDate_Millisecond();

  /**
   * Returns the meta object for class '{@link org.json.mongoQuery.QueryObject <em>Query Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Object</em>'.
   * @see org.json.mongoQuery.QueryObject
   * @generated
   */
  EClass getQueryObject();

  /**
   * Returns the meta object for the containment reference list '{@link org.json.mongoQuery.QueryObject#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see org.json.mongoQuery.QueryObject#getMembers()
   * @see #getQueryObject()
   * @generated
   */
  EReference getQueryObject_Members();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MongoQueryFactory getMongoQueryFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.json.mongoQuery.impl.SelectorImpl <em>Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.json.mongoQuery.impl.SelectorImpl
     * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getSelector()
     * @generated
     */
    EClass SELECTOR = eINSTANCE.getSelector();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTOR__QUERY = eINSTANCE.getSelector_Query();

    /**
     * The meta object literal for the '<em><b>Selection</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTOR__SELECTION = eINSTANCE.getSelector_Selection();

    /**
     * The meta object literal for the '{@link org.json.mongoQuery.impl.SelectionImpl <em>Selection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.json.mongoQuery.impl.SelectionImpl
     * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getSelection()
     * @generated
     */
    EClass SELECTION = eINSTANCE.getSelection();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION__FIELDS = eINSTANCE.getSelection_Fields();

    /**
     * The meta object literal for the '{@link org.json.mongoQuery.impl.FieldSelectionImpl <em>Field Selection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.json.mongoQuery.impl.FieldSelectionImpl
     * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getFieldSelection()
     * @generated
     */
    EClass FIELD_SELECTION = eINSTANCE.getFieldSelection();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_SELECTION__KEY = eINSTANCE.getFieldSelection_Key();

    /**
     * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_SELECTION__ENABLED = eINSTANCE.getFieldSelection_Enabled();

    /**
     * The meta object literal for the '{@link org.json.mongoQuery.impl.QueryImpl <em>Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.json.mongoQuery.impl.QueryImpl
     * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getQuery()
     * @generated
     */
    EClass QUERY = eINSTANCE.getQuery();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY__KEY = eINSTANCE.getQuery_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY__VALUE = eINSTANCE.getQuery_Value();

    /**
     * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY__STRING_VALUE = eINSTANCE.getQuery_StringValue();

    /**
     * The meta object literal for the '<em><b>Number Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY__NUMBER_VALUE = eINSTANCE.getQuery_NumberValue();

    /**
     * The meta object literal for the '<em><b>Date Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY__DATE_VALUE = eINSTANCE.getQuery_DateValue();

    /**
     * The meta object literal for the '<em><b>Array Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY__ARRAY_VALUE = eINSTANCE.getQuery_ArrayValue();

    /**
     * The meta object literal for the '<em><b>Integer Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY__INTEGER_VALUE = eINSTANCE.getQuery_IntegerValue();

    /**
     * The meta object literal for the '<em><b>Object Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY__OBJECT_VALUE = eINSTANCE.getQuery_ObjectValue();

    /**
     * The meta object literal for the '{@link org.json.mongoQuery.impl.ArrayImpl <em>Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.json.mongoQuery.impl.ArrayImpl
     * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getArray()
     * @generated
     */
    EClass ARRAY = eINSTANCE.getArray();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY__VALUES = eINSTANCE.getArray_Values();

    /**
     * The meta object literal for the '{@link org.json.mongoQuery.impl.JsonDateImpl <em>Json Date</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.json.mongoQuery.impl.JsonDateImpl
     * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getJsonDate()
     * @generated
     */
    EClass JSON_DATE = eINSTANCE.getJsonDate();

    /**
     * The meta object literal for the '<em><b>Milliseconds</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__MILLISECONDS = eINSTANCE.getJsonDate_Milliseconds();

    /**
     * The meta object literal for the '<em><b>Date String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__DATE_STRING = eINSTANCE.getJsonDate_DateString();

    /**
     * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__YEAR = eINSTANCE.getJsonDate_Year();

    /**
     * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__MONTH = eINSTANCE.getJsonDate_Month();

    /**
     * The meta object literal for the '<em><b>Day</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__DAY = eINSTANCE.getJsonDate_Day();

    /**
     * The meta object literal for the '<em><b>Hour</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__HOUR = eINSTANCE.getJsonDate_Hour();

    /**
     * The meta object literal for the '<em><b>Minute</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__MINUTE = eINSTANCE.getJsonDate_Minute();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__SECOND = eINSTANCE.getJsonDate_Second();

    /**
     * The meta object literal for the '<em><b>Millisecond</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JSON_DATE__MILLISECOND = eINSTANCE.getJsonDate_Millisecond();

    /**
     * The meta object literal for the '{@link org.json.mongoQuery.impl.QueryObjectImpl <em>Query Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.json.mongoQuery.impl.QueryObjectImpl
     * @see org.json.mongoQuery.impl.MongoQueryPackageImpl#getQueryObject()
     * @generated
     */
    EClass QUERY_OBJECT = eINSTANCE.getQueryObject();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_OBJECT__MEMBERS = eINSTANCE.getQueryObject_Members();

  }

} //MongoQueryPackage
