/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import org.eclipse.emf.common.util.EList;

import com.verticon.opengis.kml.AbstractObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Viewer Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.ViewerOptions#getOption <em>Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getViewerOptions()
 * @model extendedMetaData="name='ViewerOptionsType' kind='elementOnly'"
 * @generated
 */
public interface ViewerOptions extends AbstractObject {
	/**
	 * Returns the value of the '<em><b>Option</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.google.kmlgx.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' containment reference list.
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getViewerOptions_Option()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='option' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Option> getOption();

} // ViewerOptions
