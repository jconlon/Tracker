/**
 */
package org.usaha.ecvi;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Geo Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.GeoPoint#getLat <em>Lat</em>}</li>
 *   <li>{@link org.usaha.ecvi.GeoPoint#getLng <em>Lng</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getGeoPoint()
 * @model extendedMetaData="name='GeoPointType' kind='empty'"
 * @generated
 */
public interface GeoPoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Lat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lat</em>' attribute.
	 * @see #setLat(BigDecimal)
	 * @see org.usaha.ecvi.EcviPackage#getGeoPoint_Lat()
	 * @model dataType="org.usaha.ecvi.Latitude" required="true"
	 *        extendedMetaData="kind='attribute' name='lat'"
	 * @generated
	 */
	BigDecimal getLat();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GeoPoint#getLat <em>Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lat</em>' attribute.
	 * @see #getLat()
	 * @generated
	 */
	void setLat(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Lng</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lng</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lng</em>' attribute.
	 * @see #setLng(BigDecimal)
	 * @see org.usaha.ecvi.EcviPackage#getGeoPoint_Lng()
	 * @model dataType="org.usaha.ecvi.Longitude" required="true"
	 *        extendedMetaData="kind='attribute' name='lng'"
	 * @generated
	 */
	BigDecimal getLng();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GeoPoint#getLng <em>Lng</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lng</em>' attribute.
	 * @see #getLng()
	 * @generated
	 */
	void setLng(BigDecimal value);

} // GeoPoint
