/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.json.mongoQuery.Array;
import org.json.mongoQuery.JsonDate;
import org.json.mongoQuery.MongoQueryPackage;
import org.json.mongoQuery.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.json.mongoQuery.impl.QueryImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.QueryImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.QueryImpl#getStringValue <em>String Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.QueryImpl#getNumberValue <em>Number Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.QueryImpl#getDateValue <em>Date Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.QueryImpl#getArrayValue <em>Array Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.QueryImpl#getIntegerValue <em>Integer Value</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.QueryImpl#getObjectValue <em>Object Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryImpl extends MinimalEObjectImpl.Container implements Query
{
  /**
   * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected static final String KEY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected String key = KEY_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Query value;

  /**
   * The default value of the '{@link #getStringValue() <em>String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringValue()
   * @generated
   * @ordered
   */
  protected static final String STRING_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStringValue() <em>String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringValue()
   * @generated
   * @ordered
   */
  protected String stringValue = STRING_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getNumberValue() <em>Number Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumberValue()
   * @generated
   * @ordered
   */
  protected static final double NUMBER_VALUE_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getNumberValue() <em>Number Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumberValue()
   * @generated
   * @ordered
   */
  protected double numberValue = NUMBER_VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getDateValue() <em>Date Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateValue()
   * @generated
   * @ordered
   */
  protected JsonDate dateValue;

  /**
   * The cached value of the '{@link #getArrayValue() <em>Array Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayValue()
   * @generated
   * @ordered
   */
  protected Array arrayValue;

  /**
   * The default value of the '{@link #getIntegerValue() <em>Integer Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegerValue()
   * @generated
   * @ordered
   */
  protected static final int INTEGER_VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getIntegerValue() <em>Integer Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegerValue()
   * @generated
   * @ordered
   */
  protected int integerValue = INTEGER_VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getObjectValue() <em>Object Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectValue()
   * @generated
   * @ordered
   */
  protected Query objectValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QueryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MongoQueryPackage.Literals.QUERY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getKey()
  {
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKey(String newKey)
  {
    String oldKey = key;
    key = newKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__KEY, oldKey, key));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Query getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(Query newValue, NotificationChain msgs)
  {
    Query oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Query newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MongoQueryPackage.QUERY__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MongoQueryPackage.QUERY__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStringValue()
  {
    return stringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStringValue(String newStringValue)
  {
    String oldStringValue = stringValue;
    stringValue = newStringValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__STRING_VALUE, oldStringValue, stringValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getNumberValue()
  {
    return numberValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumberValue(double newNumberValue)
  {
    double oldNumberValue = numberValue;
    numberValue = newNumberValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__NUMBER_VALUE, oldNumberValue, numberValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JsonDate getDateValue()
  {
    return dateValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDateValue(JsonDate newDateValue, NotificationChain msgs)
  {
    JsonDate oldDateValue = dateValue;
    dateValue = newDateValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__DATE_VALUE, oldDateValue, newDateValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDateValue(JsonDate newDateValue)
  {
    if (newDateValue != dateValue)
    {
      NotificationChain msgs = null;
      if (dateValue != null)
        msgs = ((InternalEObject)dateValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MongoQueryPackage.QUERY__DATE_VALUE, null, msgs);
      if (newDateValue != null)
        msgs = ((InternalEObject)newDateValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MongoQueryPackage.QUERY__DATE_VALUE, null, msgs);
      msgs = basicSetDateValue(newDateValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__DATE_VALUE, newDateValue, newDateValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Array getArrayValue()
  {
    return arrayValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArrayValue(Array newArrayValue, NotificationChain msgs)
  {
    Array oldArrayValue = arrayValue;
    arrayValue = newArrayValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__ARRAY_VALUE, oldArrayValue, newArrayValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArrayValue(Array newArrayValue)
  {
    if (newArrayValue != arrayValue)
    {
      NotificationChain msgs = null;
      if (arrayValue != null)
        msgs = ((InternalEObject)arrayValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MongoQueryPackage.QUERY__ARRAY_VALUE, null, msgs);
      if (newArrayValue != null)
        msgs = ((InternalEObject)newArrayValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MongoQueryPackage.QUERY__ARRAY_VALUE, null, msgs);
      msgs = basicSetArrayValue(newArrayValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__ARRAY_VALUE, newArrayValue, newArrayValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getIntegerValue()
  {
    return integerValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntegerValue(int newIntegerValue)
  {
    int oldIntegerValue = integerValue;
    integerValue = newIntegerValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__INTEGER_VALUE, oldIntegerValue, integerValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Query getObjectValue()
  {
    return objectValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObjectValue(Query newObjectValue, NotificationChain msgs)
  {
    Query oldObjectValue = objectValue;
    objectValue = newObjectValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__OBJECT_VALUE, oldObjectValue, newObjectValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObjectValue(Query newObjectValue)
  {
    if (newObjectValue != objectValue)
    {
      NotificationChain msgs = null;
      if (objectValue != null)
        msgs = ((InternalEObject)objectValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MongoQueryPackage.QUERY__OBJECT_VALUE, null, msgs);
      if (newObjectValue != null)
        msgs = ((InternalEObject)newObjectValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MongoQueryPackage.QUERY__OBJECT_VALUE, null, msgs);
      msgs = basicSetObjectValue(newObjectValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.QUERY__OBJECT_VALUE, newObjectValue, newObjectValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MongoQueryPackage.QUERY__VALUE:
        return basicSetValue(null, msgs);
      case MongoQueryPackage.QUERY__DATE_VALUE:
        return basicSetDateValue(null, msgs);
      case MongoQueryPackage.QUERY__ARRAY_VALUE:
        return basicSetArrayValue(null, msgs);
      case MongoQueryPackage.QUERY__OBJECT_VALUE:
        return basicSetObjectValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MongoQueryPackage.QUERY__KEY:
        return getKey();
      case MongoQueryPackage.QUERY__VALUE:
        return getValue();
      case MongoQueryPackage.QUERY__STRING_VALUE:
        return getStringValue();
      case MongoQueryPackage.QUERY__NUMBER_VALUE:
        return getNumberValue();
      case MongoQueryPackage.QUERY__DATE_VALUE:
        return getDateValue();
      case MongoQueryPackage.QUERY__ARRAY_VALUE:
        return getArrayValue();
      case MongoQueryPackage.QUERY__INTEGER_VALUE:
        return getIntegerValue();
      case MongoQueryPackage.QUERY__OBJECT_VALUE:
        return getObjectValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MongoQueryPackage.QUERY__KEY:
        setKey((String)newValue);
        return;
      case MongoQueryPackage.QUERY__VALUE:
        setValue((Query)newValue);
        return;
      case MongoQueryPackage.QUERY__STRING_VALUE:
        setStringValue((String)newValue);
        return;
      case MongoQueryPackage.QUERY__NUMBER_VALUE:
        setNumberValue((Double)newValue);
        return;
      case MongoQueryPackage.QUERY__DATE_VALUE:
        setDateValue((JsonDate)newValue);
        return;
      case MongoQueryPackage.QUERY__ARRAY_VALUE:
        setArrayValue((Array)newValue);
        return;
      case MongoQueryPackage.QUERY__INTEGER_VALUE:
        setIntegerValue((Integer)newValue);
        return;
      case MongoQueryPackage.QUERY__OBJECT_VALUE:
        setObjectValue((Query)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MongoQueryPackage.QUERY__KEY:
        setKey(KEY_EDEFAULT);
        return;
      case MongoQueryPackage.QUERY__VALUE:
        setValue((Query)null);
        return;
      case MongoQueryPackage.QUERY__STRING_VALUE:
        setStringValue(STRING_VALUE_EDEFAULT);
        return;
      case MongoQueryPackage.QUERY__NUMBER_VALUE:
        setNumberValue(NUMBER_VALUE_EDEFAULT);
        return;
      case MongoQueryPackage.QUERY__DATE_VALUE:
        setDateValue((JsonDate)null);
        return;
      case MongoQueryPackage.QUERY__ARRAY_VALUE:
        setArrayValue((Array)null);
        return;
      case MongoQueryPackage.QUERY__INTEGER_VALUE:
        setIntegerValue(INTEGER_VALUE_EDEFAULT);
        return;
      case MongoQueryPackage.QUERY__OBJECT_VALUE:
        setObjectValue((Query)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MongoQueryPackage.QUERY__KEY:
        return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
      case MongoQueryPackage.QUERY__VALUE:
        return value != null;
      case MongoQueryPackage.QUERY__STRING_VALUE:
        return STRING_VALUE_EDEFAULT == null ? stringValue != null : !STRING_VALUE_EDEFAULT.equals(stringValue);
      case MongoQueryPackage.QUERY__NUMBER_VALUE:
        return numberValue != NUMBER_VALUE_EDEFAULT;
      case MongoQueryPackage.QUERY__DATE_VALUE:
        return dateValue != null;
      case MongoQueryPackage.QUERY__ARRAY_VALUE:
        return arrayValue != null;
      case MongoQueryPackage.QUERY__INTEGER_VALUE:
        return integerValue != INTEGER_VALUE_EDEFAULT;
      case MongoQueryPackage.QUERY__OBJECT_VALUE:
        return objectValue != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (key: ");
    result.append(key);
    result.append(", stringValue: ");
    result.append(stringValue);
    result.append(", numberValue: ");
    result.append(numberValue);
    result.append(", integerValue: ");
    result.append(integerValue);
    result.append(')');
    return result.toString();
  }

} //QueryImpl
