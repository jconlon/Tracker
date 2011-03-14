/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sound Cue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.SoundCue#getHref <em>Href</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.SoundCue#getDelayedStart <em>Delayed Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getSoundCue()
 * @model extendedMetaData="name='SoundCueType' kind='elementOnly'"
 * @generated
 */
public interface SoundCue extends TourPrimitive {
	/**
	 * Returns the value of the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * not anyURI due to $[x] substitution in
	 * 				PhotoOverlay
	 * 			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Href</em>' attribute.
	 * @see #setHref(String)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSoundCue_Href()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='href' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	String getHref();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.SoundCue#getHref <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Href</em>' attribute.
	 * @see #getHref()
	 * @generated
	 */
	void setHref(String value);

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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getSoundCue_DelayedStart()
	 * @model default="0.0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='element' name='delayedStart' namespace='##targetNamespace'"
	 * @generated
	 */
	double getDelayedStart();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.SoundCue#getDelayedStart <em>Delayed Start</em>}' attribute.
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
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.SoundCue#getDelayedStart <em>Delayed Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDelayedStart()
	 * @see #getDelayedStart()
	 * @see #setDelayedStart(double)
	 * @generated
	 */
	void unsetDelayedStart();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.SoundCue#getDelayedStart <em>Delayed Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delayed Start</em>' attribute is set.
	 * @see #unsetDelayedStart()
	 * @see #getDelayedStart()
	 * @see #setDelayedStart(double)
	 * @generated
	 */
	boolean isSetDelayedStart();

} // SoundCue
