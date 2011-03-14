/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import java.util.List;

import com.verticon.opengis.kml.AbstractObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lat Lon Quad</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.LatLonQuad#getCoordinates <em>Coordinates</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getLatLonQuad()
 * @model extendedMetaData="name='LatLonQuadType' kind='elementOnly'"
 * @generated
 */
public interface LatLonQuad extends AbstractObject {
	/**
	 * Returns the value of the '<em><b>Coordinates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinates</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinates</em>' attribute.
	 * @see #setCoordinates(List)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getLatLonQuad_Coordinates()
	 * @model dataType="com.verticon.opengis.kml.CoordinatesType" many="false"
	 *        extendedMetaData="kind='element' name='coordinates' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	List<String> getCoordinates();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.LatLonQuad#getCoordinates <em>Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordinates</em>' attribute.
	 * @see #getCoordinates()
	 * @generated
	 */
	void setCoordinates(List<String> value);

} // LatLonQuad
