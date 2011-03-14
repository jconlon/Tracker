/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.verticon.opengis.kml.AbstractObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Playlist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.Playlist#getAbstractTourPrimitiveGroupGroup <em>Abstract Tour Primitive Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.Playlist#getAbstractTourPrimitiveGroup <em>Abstract Tour Primitive Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getPlaylist()
 * @model extendedMetaData="name='PlaylistType' kind='elementOnly'"
 * @generated
 */
public interface Playlist extends AbstractObject {
	/**
	 * Returns the value of the '<em><b>Abstract Tour Primitive Group Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Tour Primitive Group Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Tour Primitive Group Group</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getPlaylist_AbstractTourPrimitiveGroupGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='AbstractTourPrimitiveGroup:group' namespace='##targetNamespace'"
	 * @generated
	 */
	FeatureMap getAbstractTourPrimitiveGroupGroup();

	/**
	 * Returns the value of the '<em><b>Abstract Tour Primitive Group</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.google.kmlgx.TourPrimitive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Tour Primitive Group</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Tour Primitive Group</em>' containment reference list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getPlaylist_AbstractTourPrimitiveGroup()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AbstractTourPrimitiveGroup' namespace='##targetNamespace' group='AbstractTourPrimitiveGroup:group'"
	 * @generated
	 */
	EList<TourPrimitive> getAbstractTourPrimitiveGroup();

} // Playlist
