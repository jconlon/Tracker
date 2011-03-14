/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import com.verticon.opengis.kml.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.Tour#getPlaylist <em>Playlist</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getTour()
 * @model extendedMetaData="name='TourType' kind='elementOnly'"
 * @generated
 */
public interface Tour extends Feature {
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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getTour_Playlist()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Playlist' namespace='##targetNamespace'"
	 * @generated
	 */
	Playlist getPlaylist();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.Tour#getPlaylist <em>Playlist</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Playlist</em>' containment reference.
	 * @see #getPlaylist()
	 * @generated
	 */
	void setPlaylist(Playlist value);

} // Tour
