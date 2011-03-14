/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.verticon.opengis.kml.ExtendedData;
import com.verticon.opengis.kml.Geometry;
import com.verticon.opengis.kml.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Track</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.Track#isExtrude <em>Extrude</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#isTessellate <em>Tessellate</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getAltitudeModeGroupGroup <em>Altitude Mode Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getAltitudeModeGroup <em>Altitude Mode Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getWhen <em>When</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getCoord <em>Coord</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getAngles <em>Angles</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getModel <em>Model</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getAbstractTrackSimpleExtensionGroupGroup <em>Abstract Track Simple Extension Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Track#getAbstractTrackSimpleExtensionGroup <em>Abstract Track Simple Extension Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack()
 * @model extendedMetaData="name='TrackType' kind='elementOnly'"
 * @generated
 */
public interface Track extends Geometry {
	/**
	 * Returns the value of the '<em><b>Extrude</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extrude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extrude</em>' attribute.
	 * @see #isSetExtrude()
	 * @see #unsetExtrude()
	 * @see #setExtrude(boolean)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_Extrude()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='extrude' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	boolean isExtrude();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.Track#isExtrude <em>Extrude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extrude</em>' attribute.
	 * @see #isSetExtrude()
	 * @see #unsetExtrude()
	 * @see #isExtrude()
	 * @generated
	 */
	void setExtrude(boolean value);

	/**
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.Track#isExtrude <em>Extrude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExtrude()
	 * @see #isExtrude()
	 * @see #setExtrude(boolean)
	 * @generated
	 */
	void unsetExtrude();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.Track#isExtrude <em>Extrude</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Extrude</em>' attribute is set.
	 * @see #unsetExtrude()
	 * @see #isExtrude()
	 * @see #setExtrude(boolean)
	 * @generated
	 */
	boolean isSetExtrude();

	/**
	 * Returns the value of the '<em><b>Tessellate</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tessellate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tessellate</em>' attribute.
	 * @see #isSetTessellate()
	 * @see #unsetTessellate()
	 * @see #setTessellate(boolean)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_Tessellate()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='tessellate' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	boolean isTessellate();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.Track#isTessellate <em>Tessellate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tessellate</em>' attribute.
	 * @see #isSetTessellate()
	 * @see #unsetTessellate()
	 * @see #isTessellate()
	 * @generated
	 */
	void setTessellate(boolean value);

	/**
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.Track#isTessellate <em>Tessellate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTessellate()
	 * @see #isTessellate()
	 * @see #setTessellate(boolean)
	 * @generated
	 */
	void unsetTessellate();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.Track#isTessellate <em>Tessellate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tessellate</em>' attribute is set.
	 * @see #unsetTessellate()
	 * @see #isTessellate()
	 * @see #setTessellate(boolean)
	 * @generated
	 */
	boolean isSetTessellate();

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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_AltitudeModeGroupGroup()
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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_AltitudeModeGroup()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='altitudeModeGroup' namespace='http://www.opengis.net/kml/2.2' group='http://www.opengis.net/kml/2.2#altitudeModeGroup:group'"
	 * @generated
	 */
	EObject getAltitudeModeGroup();

	/**
	 * Returns the value of the '<em><b>When</b></em>' attribute list.
	 * The list contents are of type {@link javax.xml.datatype.XMLGregorianCalendar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_When()
	 * @model unique="false" dataType="com.verticon.opengis.kml.DateTimeType"
	 *        extendedMetaData="kind='element' name='when' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	EList<XMLGregorianCalendar> getWhen();

	/**
	 * Returns the value of the '<em><b>Coord</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coord</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coord</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_Coord()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='coord' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getCoord();

	/**
	 * Returns the value of the '<em><b>Angles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angles</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_Angles()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='angles' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getAngles();

	/**
	 * Returns the value of the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' containment reference.
	 * @see #setModel(Model)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_Model()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Model' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	Model getModel();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.Track#getModel <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' containment reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Model value);

	/**
	 * Returns the value of the '<em><b>Extended Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Data</em>' containment reference.
	 * @see #setExtendedData(ExtendedData)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_ExtendedData()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ExtendedData' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	ExtendedData getExtendedData();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.Track#getExtendedData <em>Extended Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Data</em>' containment reference.
	 * @see #getExtendedData()
	 * @generated
	 */
	void setExtendedData(ExtendedData value);

	/**
	 * Returns the value of the '<em><b>Abstract Track Simple Extension Group Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Track Simple Extension Group Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Track Simple Extension Group Group</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_AbstractTrackSimpleExtensionGroupGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='AbstractTrackSimpleExtensionGroup:group' namespace='##targetNamespace'"
	 * @generated
	 */
	FeatureMap getAbstractTrackSimpleExtensionGroupGroup();

	/**
	 * Returns the value of the '<em><b>Abstract Track Simple Extension Group</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Track Simple Extension Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Track Simple Extension Group</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTrack_AbstractTrackSimpleExtensionGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AbstractTrackSimpleExtensionGroup' namespace='##targetNamespace' group='AbstractTrackSimpleExtensionGroup:group'"
	 * @generated
	 */
	EList<Object> getAbstractTrackSimpleExtensionGroup();

} // Track
