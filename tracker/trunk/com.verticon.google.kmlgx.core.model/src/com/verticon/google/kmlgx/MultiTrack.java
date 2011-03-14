/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.verticon.opengis.kml.Geometry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Track</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.MultiTrack#getAltitudeModeGroupGroup <em>Altitude Mode Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.MultiTrack#getAltitudeModeGroup <em>Altitude Mode Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.MultiTrack#isInterpolate <em>Interpolate</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.MultiTrack#getTrack <em>Track</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getMultiTrack()
 * @model extendedMetaData="name='MultiTrackType' kind='elementOnly'"
 * @generated
 */
public interface MultiTrack extends Geometry {
	/**
	 * Returns the value of the '<em><b>Altitude Mode Group Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Altitude Mode Group Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Altitude Mode Group Group</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getMultiTrack_AltitudeModeGroupGroup()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false"
	 *        extendedMetaData="kind='group' name='altitudeModeGroup:group' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	FeatureMap getAltitudeModeGroupGroup();

	/**
	 * Returns the value of the '<em><b>Altitude Mode Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Altitude Mode Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Altitude Mode Group</em>' containment reference.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getMultiTrack_AltitudeModeGroup()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='altitudeModeGroup' namespace='http://www.opengis.net/kml/2.2' group='http://www.opengis.net/kml/2.2#altitudeModeGroup:group'"
	 * @generated
	 */
	EObject getAltitudeModeGroup();

	/**
	 * Returns the value of the '<em><b>Interpolate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpolate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpolate</em>' attribute.
	 * @see #isSetInterpolate()
	 * @see #unsetInterpolate()
	 * @see #setInterpolate(boolean)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getMultiTrack_Interpolate()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='interpolate' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isInterpolate();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.MultiTrack#isInterpolate <em>Interpolate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpolate</em>' attribute.
	 * @see #isSetInterpolate()
	 * @see #unsetInterpolate()
	 * @see #isInterpolate()
	 * @generated
	 */
	void setInterpolate(boolean value);

	/**
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.MultiTrack#isInterpolate <em>Interpolate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInterpolate()
	 * @see #isInterpolate()
	 * @see #setInterpolate(boolean)
	 * @generated
	 */
	void unsetInterpolate();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.MultiTrack#isInterpolate <em>Interpolate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interpolate</em>' attribute is set.
	 * @see #unsetInterpolate()
	 * @see #isInterpolate()
	 * @see #setInterpolate(boolean)
	 * @generated
	 */
	boolean isSetInterpolate();

	/**
	 * Returns the value of the '<em><b>Track</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.google.kmlgx.Track}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Track</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Track</em>' containment reference list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getMultiTrack_Track()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Track' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Track> getTrack();

} // MultiTrack
