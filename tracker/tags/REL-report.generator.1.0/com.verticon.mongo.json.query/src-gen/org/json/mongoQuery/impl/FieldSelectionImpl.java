/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.json.mongoQuery.FieldSelection;
import org.json.mongoQuery.MongoQueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.json.mongoQuery.impl.FieldSelectionImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.FieldSelectionImpl#getEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldSelectionImpl extends MinimalEObjectImpl.Container implements FieldSelection
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
   * The default value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnabled()
   * @generated
   * @ordered
   */
  protected static final int ENABLED_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnabled()
   * @generated
   * @ordered
   */
  protected int enabled = ENABLED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FieldSelectionImpl()
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
    return MongoQueryPackage.Literals.FIELD_SELECTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.FIELD_SELECTION__KEY, oldKey, key));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getEnabled()
  {
    return enabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnabled(int newEnabled)
  {
    int oldEnabled = enabled;
    enabled = newEnabled;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.FIELD_SELECTION__ENABLED, oldEnabled, enabled));
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
      case MongoQueryPackage.FIELD_SELECTION__KEY:
        return getKey();
      case MongoQueryPackage.FIELD_SELECTION__ENABLED:
        return getEnabled();
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
      case MongoQueryPackage.FIELD_SELECTION__KEY:
        setKey((String)newValue);
        return;
      case MongoQueryPackage.FIELD_SELECTION__ENABLED:
        setEnabled((Integer)newValue);
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
      case MongoQueryPackage.FIELD_SELECTION__KEY:
        setKey(KEY_EDEFAULT);
        return;
      case MongoQueryPackage.FIELD_SELECTION__ENABLED:
        setEnabled(ENABLED_EDEFAULT);
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
      case MongoQueryPackage.FIELD_SELECTION__KEY:
        return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
      case MongoQueryPackage.FIELD_SELECTION__ENABLED:
        return enabled != ENABLED_EDEFAULT;
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
    result.append(", enabled: ");
    result.append(enabled);
    result.append(')');
    return result.toString();
  }

} //FieldSelectionImpl
