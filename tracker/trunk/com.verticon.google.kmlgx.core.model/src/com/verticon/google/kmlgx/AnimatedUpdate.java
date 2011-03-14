/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import com.verticon.opengis.kml.Update;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animated Update</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.AnimatedUpdate#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.AnimatedUpdate#getUpdate <em>Update</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.AnimatedUpdate#getDelayedStart <em>Delayed Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getAnimatedUpdate()
 * @model extendedMetaData="name='AnimatedUpdateType' kind='elementOnly'"
 * @generated
 */
public interface AnimatedUpdate extends TourPrimitive {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #setDuration(double)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getAnimatedUpdate_Duration()
	 * @model default="0.0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='element' name='duration' namespace='##targetNamespace'"
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.AnimatedUpdate#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(double value);

	/**
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.AnimatedUpdate#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.AnimatedUpdate#getDuration <em>Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration</em>' attribute is set.
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	boolean isSetDuration();

	/**
	 * Returns the value of the '<em><b>Update</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update</em>' containment reference.
	 * @see #setUpdate(Update)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getAnimatedUpdate_Update()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Update' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	Update getUpdate();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.AnimatedUpdate#getUpdate <em>Update</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update</em>' containment reference.
	 * @see #getUpdate()
	 * @generated
	 */
	void setUpdate(Update value);

	/**
	 * Returns the value of the '<em><b>Delayed Start</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delayed Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delayed Start</em>' attribute.
	 * @see #isSetDelayedStart()
	 * @see #unsetDelayedStart()
	 * @see #setDelayedStart(double)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getAnimatedUpdate_DelayedStart()
	 * @model default="0.0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='element' name='delayedStart' namespace='##targetNamespace'"
	 * @generated
	 */
	double getDelayedStart();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.AnimatedUpdate#getDelayedStart <em>Delayed Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delayed Start</em>' attribute.
	 * @see #isSetDelayedStart()
	 * @see #unsetDelayedStart()
	 * @see #getDelayedStart()
	 * @generated
	 */
	void setDelayedStart(double value);

	/**
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.AnimatedUpdate#getDelayedStart <em>Delayed Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDelayedStart()
	 * @see #getDelayedStart()
	 * @see #setDelayedStart(double)
	 * @generated
	 */
	void unsetDelayedStart();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.AnimatedUpdate#getDelayedStart <em>Delayed Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delayed Start</em>' attribute is set.
	 * @see #unsetDelayedStart()
	 * @see #getDelayedStart()
	 * @see #setDelayedStart(double)
	 * @generated
	 */
	boolean isSetDelayedStart();

} // AnimatedUpdate
