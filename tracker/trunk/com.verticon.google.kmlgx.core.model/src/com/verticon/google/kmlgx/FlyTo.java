/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import org.eclipse.emf.ecore.util.FeatureMap;

import com.verticon.opengis.kml.AbstractView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fly To</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.FlyTo#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.FlyTo#getFlyToMode <em>Fly To Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.FlyTo#getAbstractViewGroupGroup <em>Abstract View Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.FlyTo#getAbstractViewGroup <em>Abstract View Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getFlyTo()
 * @model extendedMetaData="name='FlyToType' kind='elementOnly'"
 * @generated
 */
public interface FlyTo extends TourPrimitive {
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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getFlyTo_Duration()
	 * @model default="0.0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='element' name='duration' namespace='##targetNamespace'"
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.FlyTo#getDuration <em>Duration</em>}' attribute.
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
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.FlyTo#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.FlyTo#getDuration <em>Duration</em>}' attribute is set.
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
	 * @see #isSetFlyToMode()
	 * @see #unsetFlyToMode()
	 * @see #setFlyToMode(FlyToModeEnumType)
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getFlyTo_FlyToMode()
	 * @model default="bounce" unsettable="true"
	 *        extendedMetaData="kind='element' name='flyToMode' namespace='##targetNamespace'"
	 * @generated
	 */
	FlyToModeEnumType getFlyToMode();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.FlyTo#getFlyToMode <em>Fly To Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fly To Mode</em>' attribute.
	 * @see com.verticon.google.kmlgx.FlyToModeEnumType
	 * @see #isSetFlyToMode()
	 * @see #unsetFlyToMode()
	 * @see #getFlyToMode()
	 * @generated
	 */
	void setFlyToMode(FlyToModeEnumType value);

	/**
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.FlyTo#getFlyToMode <em>Fly To Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlyToMode()
	 * @see #getFlyToMode()
	 * @see #setFlyToMode(FlyToModeEnumType)
	 * @generated
	 */
	void unsetFlyToMode();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.FlyTo#getFlyToMode <em>Fly To Mode</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fly To Mode</em>' attribute is set.
	 * @see #unsetFlyToMode()
	 * @see #getFlyToMode()
	 * @see #setFlyToMode(FlyToModeEnumType)
	 * @generated
	 */
	boolean isSetFlyToMode();

	/**
	 * Returns the value of the '<em><b>Abstract View Group Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract View Group Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract View Group Group</em>' attribute list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getFlyTo_AbstractViewGroupGroup()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false"
	 *        extendedMetaData="kind='group' name='AbstractViewGroup:group' namespace='http://www.opengis.net/kml/2.2'"
	 * @generated
	 */
	FeatureMap getAbstractViewGroupGroup();

	/**
	 * Returns the value of the '<em><b>Abstract View Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract View Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract View Group</em>' containment reference.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getFlyTo_AbstractViewGroup()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AbstractViewGroup' namespace='http://www.opengis.net/kml/2.2' group='http://www.opengis.net/kml/2.2#AbstractViewGroup:group'"
	 * @generated
	 */
	AbstractView getAbstractViewGroup();

} // FlyTo
