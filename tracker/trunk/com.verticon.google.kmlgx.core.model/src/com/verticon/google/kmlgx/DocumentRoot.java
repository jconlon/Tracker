/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.verticon.opengis.kml.TimeSpan;
import com.verticon.opengis.kml.TimeStamp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitive <em>Abstract Tour Primitive</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitiveGroup <em>Abstract Tour Primitive Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTrackSimpleExtensionGroup <em>Abstract Track Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeMode <em>Altitude Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeOffset <em>Altitude Offset</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAngles <em>Angles</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAnimatedUpdate <em>Animated Update</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#isBalloonVisibility <em>Balloon Visibility</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getCoord <em>Coord</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getDelayedStart <em>Delayed Start</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getDrawOrder <em>Draw Order</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getFlyTo <em>Fly To</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getFlyToMode <em>Fly To Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getH <em>H</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#isInterpolate <em>Interpolate</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getLatLonQuad <em>Lat Lon Quad</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getMultiTrack <em>Multi Track</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getOption <em>Option</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getOuterColor <em>Outer Color</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getOuterWidth <em>Outer Width</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getPhysicalWidth <em>Physical Width</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getPlaylist <em>Playlist</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getPlayMode <em>Play Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getRank <em>Rank</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayData <em>Simple Array Data</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayDataExtension <em>Simple Array Data Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayField <em>Simple Array Field</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayFieldExtension <em>Simple Array Field Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSoundCue <em>Sound Cue</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTimeSpan <em>Time Span</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTimeStamp <em>Time Stamp</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTour <em>Tour</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTourControl <em>Tour Control</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTrack <em>Track</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getValue <em>Value</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getViewerOptions <em>Viewer Options</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getW <em>W</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getWait <em>Wait</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getX <em>X</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Abstract Tour Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Tour Primitive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Tour Primitive</em>' containment reference.
	 * @see #setAbstractTourPrimitive(TourPrimitive)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_AbstractTourPrimitive()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AbstractTourPrimitive' namespace='##targetNamespace'"
	 * @generated
	 */
	TourPrimitive getAbstractTourPrimitive();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitive <em>Abstract Tour Primitive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Tour Primitive</em>' containment reference.
	 * @see #getAbstractTourPrimitive()
	 * @generated
	 */
	void setAbstractTourPrimitive(TourPrimitive value);

	/**
	 * Returns the value of the '<em><b>Abstract Tour Primitive Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Tour Primitive Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Tour Primitive Group</em>' containment reference.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_AbstractTourPrimitiveGroup()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AbstractTourPrimitiveGroup' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractObjectGroup'"
	 * @generated
	 */
	TourPrimitive getAbstractTourPrimitiveGroup();

	/**
	 * Returns the value of the '<em><b>Abstract Track Simple Extension Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Track Simple Extension Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Track Simple Extension Group</em>' attribute.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_AbstractTrackSimpleExtensionGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AbstractTrackSimpleExtensionGroup' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getAbstractTrackSimpleExtensionGroup();

	/**
	 * Returns the value of the '<em><b>Altitude Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.google.kmlgx.AltitudeModeEnumType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Altitude Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Altitude Mode</em>' attribute.
	 * @see com.verticon.google.kmlgx.AltitudeModeEnumType
	 * @see #setAltitudeMode(AltitudeModeEnumType)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_AltitudeMode()
	 * @model unique="false" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='altitudeMode' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#altitudeModeGroup'"
	 * @generated
	 */
	AltitudeModeEnumType getAltitudeMode();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeMode <em>Altitude Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Altitude Mode</em>' attribute.
	 * @see com.verticon.google.kmlgx.AltitudeModeEnumType
	 * @see #getAltitudeMode()
	 * @generated
	 */
	void setAltitudeMode(AltitudeModeEnumType value);

	/**
	 * Returns the value of the '<em><b>Altitude Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Altitude Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Altitude Offset</em>' attribute.
	 * @see #setAltitudeOffset(double)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_AltitudeOffset()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Double" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='altitudeOffset' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractGeometrySimpleExtensionGroup'"
	 * @generated
	 */
	double getAltitudeOffset();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeOffset <em>Altitude Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Altitude Offset</em>' attribute.
	 * @see #getAltitudeOffset()
	 * @generated
	 */
	void setAltitudeOffset(double value);

	/**
	 * Returns the value of the '<em><b>Angles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angles</em>' attribute.
	 * @see #setAngles(String)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Angles()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='angles' namespace='##targetNamespace'"
	 * @generated
	 */
	String getAngles();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getAngles <em>Angles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angles</em>' attribute.
	 * @see #getAngles()
	 * @generated
	 */
	void setAngles(String value);

	/**
	 * Returns the value of the '<em><b>Animated Update</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animated Update</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animated Update</em>' containment reference.
	 * @see #setAnimatedUpdate(AnimatedUpdate)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_AnimatedUpdate()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AnimatedUpdate' namespace='##targetNamespace' affiliation='AbstractTourPrimitiveGroup'"
	 * @generated
	 */
	AnimatedUpdate getAnimatedUpdate();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getAnimatedUpdate <em>Animated Update</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Animated Update</em>' containment reference.
	 * @see #getAnimatedUpdate()
	 * @generated
	 */
	void setAnimatedUpdate(AnimatedUpdate value);

	/**
	 * Returns the value of the '<em><b>Balloon Visibility</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Balloon Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balloon Visibility</em>' attribute.
	 * @see #setBalloonVisibility(boolean)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_BalloonVisibility()
	 * @model default="true" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='balloonVisibility' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractFeatureSimpleExtensionGroup'"
	 * @generated
	 */
	boolean isBalloonVisibility();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#isBalloonVisibility <em>Balloon Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Balloon Visibility</em>' attribute.
	 * @see #isBalloonVisibility()
	 * @generated
	 */
	void setBalloonVisibility(boolean value);

	/**
	 * Returns the value of the '<em><b>Coord</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coord</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coord</em>' attribute.
	 * @see #setCoord(String)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Coord()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='coord' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCoord();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getCoord <em>Coord</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coord</em>' attribute.
	 * @see #getCoord()
	 * @generated
	 */
	void setCoord(String value);

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
	 * @see #setDelayedStart(double)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_DelayedStart()
	 * @model default="0.0" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Double" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='delayedStart' namespace='##targetNamespace'"
	 * @generated
	 */
	double getDelayedStart();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getDelayedStart <em>Delayed Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delayed Start</em>' attribute.
	 * @see #getDelayedStart()
	 * @generated
	 */
	void setDelayedStart(double value);

	/**
	 * Returns the value of the '<em><b>Draw Order</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Draw Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Draw Order</em>' attribute.
	 * @see #setDrawOrder(BigInteger)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_DrawOrder()
	 * @model default="0" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='drawOrder' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractGeometrySimpleExtensionGroup'"
	 * @generated
	 */
	BigInteger getDrawOrder();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getDrawOrder <em>Draw Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Draw Order</em>' attribute.
	 * @see #getDrawOrder()
	 * @generated
	 */
	void setDrawOrder(BigInteger value);

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
	 * @see #setDuration(double)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Duration()
	 * @model default="0.0" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Double" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='duration' namespace='##targetNamespace'"
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(double value);

	/**
	 * Returns the value of the '<em><b>Fly To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fly To</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fly To</em>' containment reference.
	 * @see #setFlyTo(FlyTo)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_FlyTo()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='FlyTo' namespace='##targetNamespace' affiliation='AbstractTourPrimitiveGroup'"
	 * @generated
	 */
	FlyTo getFlyTo();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getFlyTo <em>Fly To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fly To</em>' containment reference.
	 * @see #getFlyTo()
	 * @generated
	 */
	void setFlyTo(FlyTo value);

	/**
	 * Returns the value of the '<em><b>Fly To Mode</b></em>' attribute.
	 * The default value is <code>"bounce"</code>.
	 * The literals are from the enumeration {@link com.verticon.google.kmlgx.FlyToModeEnumType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fly To Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fly To Mode</em>' attribute.
	 * @see com.verticon.google.kmlgx.FlyToModeEnumType
	 * @see #setFlyToMode(FlyToModeEnumType)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_FlyToMode()
	 * @model default="bounce" unique="false" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='flyToMode' namespace='##targetNamespace'"
	 * @generated
	 */
	FlyToModeEnumType getFlyToMode();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getFlyToMode <em>Fly To Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fly To Mode</em>' attribute.
	 * @see com.verticon.google.kmlgx.FlyToModeEnumType
	 * @see #getFlyToMode()
	 * @generated
	 */
	void setFlyToMode(FlyToModeEnumType value);

	/**
	 * Returns the value of the '<em><b>H</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>H</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>H</em>' attribute.
	 * @see #setH(BigInteger)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_H()
	 * @model default="-1" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='h' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#BasicLinkSimpleExtensionGroup'"
	 * @generated
	 */
	BigInteger getH();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getH <em>H</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>H</em>' attribute.
	 * @see #getH()
	 * @generated
	 */
	void setH(BigInteger value);

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
	 * @see #setInterpolate(boolean)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Interpolate()
	 * @model default="false" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interpolate' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isInterpolate();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#isInterpolate <em>Interpolate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpolate</em>' attribute.
	 * @see #isInterpolate()
	 * @generated
	 */
	void setInterpolate(boolean value);

	/**
	 * Returns the value of the '<em><b>Lat Lon Quad</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lat Lon Quad</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lat Lon Quad</em>' containment reference.
	 * @see #setLatLonQuad(LatLonQuad)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_LatLonQuad()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='LatLonQuad' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#GroundOverlayObjectExtensionGroup'"
	 * @generated
	 */
	LatLonQuad getLatLonQuad();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getLatLonQuad <em>Lat Lon Quad</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lat Lon Quad</em>' containment reference.
	 * @see #getLatLonQuad()
	 * @generated
	 */
	void setLatLonQuad(LatLonQuad value);

	/**
	 * Returns the value of the '<em><b>Multi Track</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Track</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Track</em>' containment reference.
	 * @see #setMultiTrack(MultiTrack)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_MultiTrack()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='MultiTrack' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractGeometryGroup'"
	 * @generated
	 */
	MultiTrack getMultiTrack();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getMultiTrack <em>Multi Track</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Track</em>' containment reference.
	 * @see #getMultiTrack()
	 * @generated
	 */
	void setMultiTrack(MultiTrack value);

	/**
	 * Returns the value of the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' containment reference.
	 * @see #setOption(Option)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Option()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='option' namespace='##targetNamespace'"
	 * @generated
	 */
	Option getOption();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getOption <em>Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option</em>' containment reference.
	 * @see #getOption()
	 * @generated
	 */
	void setOption(Option value);

	/**
	 * Returns the value of the '<em><b>Outer Color</b></em>' attribute.
	 * The default value is <code>"ffffffff"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Color</em>' attribute.
	 * @see #setOuterColor(byte[])
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_OuterColor()
	 * @model default="ffffffff" unique="false" dataType="com.verticon.opengis.kml.ColorType" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='outerColor' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#LineStyleSimpleExtensionGroup'"
	 * @generated
	 */
	byte[] getOuterColor();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getOuterColor <em>Outer Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Color</em>' attribute.
	 * @see #getOuterColor()
	 * @generated
	 */
	void setOuterColor(byte[] value);

	/**
	 * Returns the value of the '<em><b>Outer Width</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Width</em>' attribute.
	 * @see #setOuterWidth(float)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_OuterWidth()
	 * @model default="0.0" unique="false" dataType="com.verticon.google.kmlgx.OuterWidthType" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='outerWidth' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#LineStyleSimpleExtensionGroup'"
	 * @generated
	 */
	float getOuterWidth();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getOuterWidth <em>Outer Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Width</em>' attribute.
	 * @see #getOuterWidth()
	 * @generated
	 */
	void setOuterWidth(float value);

	/**
	 * Returns the value of the '<em><b>Physical Width</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Physical Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physical Width</em>' attribute.
	 * @see #setPhysicalWidth(float)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_PhysicalWidth()
	 * @model default="0.0" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Float" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='physicalWidth' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#LineStyleSimpleExtensionGroup'"
	 * @generated
	 */
	float getPhysicalWidth();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getPhysicalWidth <em>Physical Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physical Width</em>' attribute.
	 * @see #getPhysicalWidth()
	 * @generated
	 */
	void setPhysicalWidth(float value);

	/**
	 * Returns the value of the '<em><b>Playlist</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Playlist</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Playlist</em>' containment reference.
	 * @see #setPlaylist(Playlist)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Playlist()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Playlist' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractObjectGroup'"
	 * @generated
	 */
	Playlist getPlaylist();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getPlaylist <em>Playlist</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Playlist</em>' containment reference.
	 * @see #getPlaylist()
	 * @generated
	 */
	void setPlaylist(Playlist value);

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
	 * @see #setPlayMode(PlayModeEnumType)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_PlayMode()
	 * @model default="pause" unique="false" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='playMode' namespace='##targetNamespace'"
	 * @generated
	 */
	PlayModeEnumType getPlayMode();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getPlayMode <em>Play Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Play Mode</em>' attribute.
	 * @see com.verticon.google.kmlgx.PlayModeEnumType
	 * @see #getPlayMode()
	 * @generated
	 */
	void setPlayMode(PlayModeEnumType value);

	/**
	 * Returns the value of the '<em><b>Rank</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rank</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rank</em>' attribute.
	 * @see #setRank(double)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Rank()
	 * @model default="0.0" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Double" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='rank' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractFeatureSimpleExtensionGroup'"
	 * @generated
	 */
	double getRank();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getRank <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rank</em>' attribute.
	 * @see #getRank()
	 * @generated
	 */
	void setRank(double value);

	/**
	 * Returns the value of the '<em><b>Simple Array Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Array Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Array Data</em>' containment reference.
	 * @see #setSimpleArrayData(SimpleArrayData)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_SimpleArrayData()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SimpleArrayData' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#SchemaDataExtension'"
	 * @generated
	 */
	SimpleArrayData getSimpleArrayData();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayData <em>Simple Array Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Array Data</em>' containment reference.
	 * @see #getSimpleArrayData()
	 * @generated
	 */
	void setSimpleArrayData(SimpleArrayData value);

	/**
	 * Returns the value of the '<em><b>Simple Array Data Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Array Data Extension</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Array Data Extension</em>' containment reference.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_SimpleArrayDataExtension()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SimpleArrayDataExtension' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getSimpleArrayDataExtension();

	/**
	 * Returns the value of the '<em><b>Simple Array Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Array Field</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Array Field</em>' containment reference.
	 * @see #setSimpleArrayField(SimpleArrayField)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_SimpleArrayField()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SimpleArrayField' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#SchemaExtension'"
	 * @generated
	 */
	SimpleArrayField getSimpleArrayField();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayField <em>Simple Array Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Array Field</em>' containment reference.
	 * @see #getSimpleArrayField()
	 * @generated
	 */
	void setSimpleArrayField(SimpleArrayField value);

	/**
	 * Returns the value of the '<em><b>Simple Array Field Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Array Field Extension</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Array Field Extension</em>' containment reference.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_SimpleArrayFieldExtension()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SimpleArrayFieldExtension' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getSimpleArrayFieldExtension();

	/**
	 * Returns the value of the '<em><b>Sound Cue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sound Cue</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sound Cue</em>' containment reference.
	 * @see #setSoundCue(SoundCue)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_SoundCue()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SoundCue' namespace='##targetNamespace' affiliation='AbstractTourPrimitiveGroup'"
	 * @generated
	 */
	SoundCue getSoundCue();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getSoundCue <em>Sound Cue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sound Cue</em>' containment reference.
	 * @see #getSoundCue()
	 * @generated
	 */
	void setSoundCue(SoundCue value);

	/**
	 * Returns the value of the '<em><b>Time Span</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Span</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Span</em>' containment reference.
	 * @see #setTimeSpan(TimeSpan)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_TimeSpan()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='TimeSpan' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractViewObjectExtensionGroup'"
	 * @generated
	 */
	TimeSpan getTimeSpan();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getTimeSpan <em>Time Span</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Span</em>' containment reference.
	 * @see #getTimeSpan()
	 * @generated
	 */
	void setTimeSpan(TimeSpan value);

	/**
	 * Returns the value of the '<em><b>Time Stamp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Stamp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Stamp</em>' containment reference.
	 * @see #setTimeStamp(TimeStamp)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_TimeStamp()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='TimeStamp' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractViewObjectExtensionGroup'"
	 * @generated
	 */
	TimeStamp getTimeStamp();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getTimeStamp <em>Time Stamp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Stamp</em>' containment reference.
	 * @see #getTimeStamp()
	 * @generated
	 */
	void setTimeStamp(TimeStamp value);

	/**
	 * Returns the value of the '<em><b>Tour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tour</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tour</em>' containment reference.
	 * @see #setTour(Tour)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Tour()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Tour' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractFeatureGroup'"
	 * @generated
	 */
	Tour getTour();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getTour <em>Tour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tour</em>' containment reference.
	 * @see #getTour()
	 * @generated
	 */
	void setTour(Tour value);

	/**
	 * Returns the value of the '<em><b>Tour Control</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tour Control</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tour Control</em>' containment reference.
	 * @see #setTourControl(TourControl)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_TourControl()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='TourControl' namespace='##targetNamespace' affiliation='AbstractTourPrimitiveGroup'"
	 * @generated
	 */
	TourControl getTourControl();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getTourControl <em>Tour Control</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tour Control</em>' containment reference.
	 * @see #getTourControl()
	 * @generated
	 */
	void setTourControl(TourControl value);

	/**
	 * Returns the value of the '<em><b>Track</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Track</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Track</em>' containment reference.
	 * @see #setTrack(Track)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Track()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Track' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractGeometryGroup'"
	 * @generated
	 */
	Track getTrack();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getTrack <em>Track</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Track</em>' containment reference.
	 * @see #getTrack()
	 * @generated
	 */
	void setTrack(Track value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Value()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Viewer Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewer Options</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewer Options</em>' containment reference.
	 * @see #setViewerOptions(ViewerOptions)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_ViewerOptions()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ViewerOptions' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#AbstractViewObjectExtensionGroup'"
	 * @generated
	 */
	ViewerOptions getViewerOptions();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getViewerOptions <em>Viewer Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewer Options</em>' containment reference.
	 * @see #getViewerOptions()
	 * @generated
	 */
	void setViewerOptions(ViewerOptions value);

	/**
	 * Returns the value of the '<em><b>W</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>W</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>W</em>' attribute.
	 * @see #setW(BigInteger)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_W()
	 * @model default="-1" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='w' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#BasicLinkSimpleExtensionGroup'"
	 * @generated
	 */
	BigInteger getW();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getW <em>W</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>W</em>' attribute.
	 * @see #getW()
	 * @generated
	 */
	void setW(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait</em>' containment reference.
	 * @see #setWait(Wait)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Wait()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Wait' namespace='##targetNamespace' affiliation='AbstractTourPrimitiveGroup'"
	 * @generated
	 */
	Wait getWait();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getWait <em>Wait</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait</em>' containment reference.
	 * @see #getWait()
	 * @generated
	 */
	void setWait(Wait value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(BigInteger)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_X()
	 * @model default="0" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='x' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#BasicLinkSimpleExtensionGroup'"
	 * @generated
	 */
	BigInteger getX();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(BigInteger)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getDocumentRoot_Y()
	 * @model default="0" unique="false" dataType="org.eclipse.emf.ecore.xml.type.Integer" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='y' namespace='##targetNamespace' affiliation='http://www.opengis.net/kml/2.2#BasicLinkSimpleExtensionGroup'"
	 * @generated
	 */
	BigInteger getY();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.DocumentRoot#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(BigInteger value);

} // DocumentRoot
