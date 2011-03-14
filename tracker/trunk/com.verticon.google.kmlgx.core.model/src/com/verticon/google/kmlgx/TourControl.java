/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tour Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.TourControl#getPlayMode <em>Play Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getTourControl()
 * @model extendedMetaData="name='TourControlType' kind='elementOnly'"
 * @generated
 */
public interface TourControl extends TourPrimitive {
	/**
	 * Returns the value of the '<em><b>Play Mode</b></em>' attribute.
	 * The default value is <code>"pause"</code>.
	 * The literals are from the enumeration {@link com.verticon.google.kmlgx.PlayModeEnumType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Play Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Play Mode</em>' attribute.
	 * @see com.verticon.google.kmlgx.PlayModeEnumType
	 * @see #isSetPlayMode()
	 * @see #unsetPlayMode()
	 * @see #setPlayMode(PlayModeEnumType)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTourControl_PlayMode()
	 * @model default="pause" unsettable="true"
	 *        extendedMetaData="kind='element' name='playMode' namespace='##targetNamespace'"
	 * @generated
	 */
	PlayModeEnumType getPlayMode();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.TourControl#getPlayMode <em>Play Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Play Mode</em>' attribute.
	 * @see com.verticon.google.kmlgx.PlayModeEnumType
	 * @see #isSetPlayMode()
	 * @see #unsetPlayMode()
	 * @see #getPlayMode()
	 * @generated
	 */
	void setPlayMode(PlayModeEnumType value);

	/**
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.TourControl#getPlayMode <em>Play Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlayMode()
	 * @see #getPlayMode()
	 * @see #setPlayMode(PlayModeEnumType)
	 * @generated
	 */
	void unsetPlayMode();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.TourControl#getPlayMode <em>Play Mode</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Play Mode</em>' attribute is set.
	 * @see #unsetPlayMode()
	 * @see #getPlayMode()
	 * @see #setPlayMode(PlayModeEnumType)
	 * @generated
	 */
	boolean isSetPlayMode();

} // TourControl
