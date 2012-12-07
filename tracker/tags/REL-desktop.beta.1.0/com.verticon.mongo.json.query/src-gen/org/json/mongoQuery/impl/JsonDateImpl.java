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

import org.json.mongoQuery.JsonDate;
import org.json.mongoQuery.MongoQueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Json Date</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getMilliseconds <em>Milliseconds</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getDateString <em>Date String</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getYear <em>Year</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getDay <em>Day</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getHour <em>Hour</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getMinute <em>Minute</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getSecond <em>Second</em>}</li>
 *   <li>{@link org.json.mongoQuery.impl.JsonDateImpl#getMillisecond <em>Millisecond</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JsonDateImpl extends MinimalEObjectImpl.Container implements JsonDate
{
  /**
   * The default value of the '{@link #getMilliseconds() <em>Milliseconds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMilliseconds()
   * @generated
   * @ordered
   */
  protected static final int MILLISECONDS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMilliseconds() <em>Milliseconds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMilliseconds()
   * @generated
   * @ordered
   */
  protected int milliseconds = MILLISECONDS_EDEFAULT;

  /**
   * The default value of the '{@link #getDateString() <em>Date String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateString()
   * @generated
   * @ordered
   */
  protected static final String DATE_STRING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDateString() <em>Date String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateString()
   * @generated
   * @ordered
   */
  protected String dateString = DATE_STRING_EDEFAULT;

  /**
   * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYear()
   * @generated
   * @ordered
   */
  protected static final int YEAR_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getYear()
   * @generated
   * @ordered
   */
  protected int year = YEAR_EDEFAULT;

  /**
   * The default value of the '{@link #getMonth() <em>Month</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMonth()
   * @generated
   * @ordered
   */
  protected static final int MONTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMonth() <em>Month</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMonth()
   * @generated
   * @ordered
   */
  protected int month = MONTH_EDEFAULT;

  /**
   * The default value of the '{@link #getDay() <em>Day</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDay()
   * @generated
   * @ordered
   */
  protected static final int DAY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDay() <em>Day</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDay()
   * @generated
   * @ordered
   */
  protected int day = DAY_EDEFAULT;

  /**
   * The default value of the '{@link #getHour() <em>Hour</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHour()
   * @generated
   * @ordered
   */
  protected static final int HOUR_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getHour() <em>Hour</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHour()
   * @generated
   * @ordered
   */
  protected int hour = HOUR_EDEFAULT;

  /**
   * The default value of the '{@link #getMinute() <em>Minute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinute()
   * @generated
   * @ordered
   */
  protected static final int MINUTE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMinute() <em>Minute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinute()
   * @generated
   * @ordered
   */
  protected int minute = MINUTE_EDEFAULT;

  /**
   * The default value of the '{@link #getSecond() <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecond()
   * @generated
   * @ordered
   */
  protected static final int SECOND_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSecond() <em>Second</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecond()
   * @generated
   * @ordered
   */
  protected int second = SECOND_EDEFAULT;

  /**
   * The default value of the '{@link #getMillisecond() <em>Millisecond</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMillisecond()
   * @generated
   * @ordered
   */
  protected static final int MILLISECOND_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMillisecond() <em>Millisecond</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMillisecond()
   * @generated
   * @ordered
   */
  protected int millisecond = MILLISECOND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JsonDateImpl()
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
    return MongoQueryPackage.Literals.JSON_DATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMilliseconds()
  {
    return milliseconds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMilliseconds(int newMilliseconds)
  {
    int oldMilliseconds = milliseconds;
    milliseconds = newMilliseconds;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__MILLISECONDS, oldMilliseconds, milliseconds));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDateString()
  {
    return dateString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDateString(String newDateString)
  {
    String oldDateString = dateString;
    dateString = newDateString;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__DATE_STRING, oldDateString, dateString));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getYear()
  {
    return year;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setYear(int newYear)
  {
    int oldYear = year;
    year = newYear;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__YEAR, oldYear, year));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMonth(int newMonth)
  {
    int oldMonth = month;
    month = newMonth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__MONTH, oldMonth, month));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDay()
  {
    return day;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDay(int newDay)
  {
    int oldDay = day;
    day = newDay;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__DAY, oldDay, day));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getHour()
  {
    return hour;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHour(int newHour)
  {
    int oldHour = hour;
    hour = newHour;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__HOUR, oldHour, hour));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMinute()
  {
    return minute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMinute(int newMinute)
  {
    int oldMinute = minute;
    minute = newMinute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__MINUTE, oldMinute, minute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSecond()
  {
    return second;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecond(int newSecond)
  {
    int oldSecond = second;
    second = newSecond;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__SECOND, oldSecond, second));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMillisecond()
  {
    return millisecond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMillisecond(int newMillisecond)
  {
    int oldMillisecond = millisecond;
    millisecond = newMillisecond;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MongoQueryPackage.JSON_DATE__MILLISECOND, oldMillisecond, millisecond));
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
      case MongoQueryPackage.JSON_DATE__MILLISECONDS:
        return getMilliseconds();
      case MongoQueryPackage.JSON_DATE__DATE_STRING:
        return getDateString();
      case MongoQueryPackage.JSON_DATE__YEAR:
        return getYear();
      case MongoQueryPackage.JSON_DATE__MONTH:
        return getMonth();
      case MongoQueryPackage.JSON_DATE__DAY:
        return getDay();
      case MongoQueryPackage.JSON_DATE__HOUR:
        return getHour();
      case MongoQueryPackage.JSON_DATE__MINUTE:
        return getMinute();
      case MongoQueryPackage.JSON_DATE__SECOND:
        return getSecond();
      case MongoQueryPackage.JSON_DATE__MILLISECOND:
        return getMillisecond();
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
      case MongoQueryPackage.JSON_DATE__MILLISECONDS:
        setMilliseconds((Integer)newValue);
        return;
      case MongoQueryPackage.JSON_DATE__DATE_STRING:
        setDateString((String)newValue);
        return;
      case MongoQueryPackage.JSON_DATE__YEAR:
        setYear((Integer)newValue);
        return;
      case MongoQueryPackage.JSON_DATE__MONTH:
        setMonth((Integer)newValue);
        return;
      case MongoQueryPackage.JSON_DATE__DAY:
        setDay((Integer)newValue);
        return;
      case MongoQueryPackage.JSON_DATE__HOUR:
        setHour((Integer)newValue);
        return;
      case MongoQueryPackage.JSON_DATE__MINUTE:
        setMinute((Integer)newValue);
        return;
      case MongoQueryPackage.JSON_DATE__SECOND:
        setSecond((Integer)newValue);
        return;
      case MongoQueryPackage.JSON_DATE__MILLISECOND:
        setMillisecond((Integer)newValue);
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
      case MongoQueryPackage.JSON_DATE__MILLISECONDS:
        setMilliseconds(MILLISECONDS_EDEFAULT);
        return;
      case MongoQueryPackage.JSON_DATE__DATE_STRING:
        setDateString(DATE_STRING_EDEFAULT);
        return;
      case MongoQueryPackage.JSON_DATE__YEAR:
        setYear(YEAR_EDEFAULT);
        return;
      case MongoQueryPackage.JSON_DATE__MONTH:
        setMonth(MONTH_EDEFAULT);
        return;
      case MongoQueryPackage.JSON_DATE__DAY:
        setDay(DAY_EDEFAULT);
        return;
      case MongoQueryPackage.JSON_DATE__HOUR:
        setHour(HOUR_EDEFAULT);
        return;
      case MongoQueryPackage.JSON_DATE__MINUTE:
        setMinute(MINUTE_EDEFAULT);
        return;
      case MongoQueryPackage.JSON_DATE__SECOND:
        setSecond(SECOND_EDEFAULT);
        return;
      case MongoQueryPackage.JSON_DATE__MILLISECOND:
        setMillisecond(MILLISECOND_EDEFAULT);
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
      case MongoQueryPackage.JSON_DATE__MILLISECONDS:
        return milliseconds != MILLISECONDS_EDEFAULT;
      case MongoQueryPackage.JSON_DATE__DATE_STRING:
        return DATE_STRING_EDEFAULT == null ? dateString != null : !DATE_STRING_EDEFAULT.equals(dateString);
      case MongoQueryPackage.JSON_DATE__YEAR:
        return year != YEAR_EDEFAULT;
      case MongoQueryPackage.JSON_DATE__MONTH:
        return month != MONTH_EDEFAULT;
      case MongoQueryPackage.JSON_DATE__DAY:
        return day != DAY_EDEFAULT;
      case MongoQueryPackage.JSON_DATE__HOUR:
        return hour != HOUR_EDEFAULT;
      case MongoQueryPackage.JSON_DATE__MINUTE:
        return minute != MINUTE_EDEFAULT;
      case MongoQueryPackage.JSON_DATE__SECOND:
        return second != SECOND_EDEFAULT;
      case MongoQueryPackage.JSON_DATE__MILLISECOND:
        return millisecond != MILLISECOND_EDEFAULT;
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
    result.append(" (milliseconds: ");
    result.append(milliseconds);
    result.append(", dateString: ");
    result.append(dateString);
    result.append(", year: ");
    result.append(year);
    result.append(", month: ");
    result.append(month);
    result.append(", day: ");
    result.append(day);
    result.append(", hour: ");
    result.append(hour);
    result.append(", minute: ");
    result.append(minute);
    result.append(", second: ");
    result.append(second);
    result.append(", millisecond: ");
    result.append(millisecond);
    result.append(')');
    return result.toString();
  }

} //JsonDateImpl
