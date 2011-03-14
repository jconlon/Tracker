/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.Wait#getDuration <em>Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.google.kmlgx.KmlgxPackage#getWait()
 * @model extendedMetaData="name='WaitType' kind='elementOnly'"
 * @generated
 */
public interface Wait extends TourPrimitive {
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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#getWait_Duration()
	 * @model default="0.0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='element' name='duration' namespace='##targetNamespace'"
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link com.verticon.google.kmlgx.Wait#getDuration <em>Duration</em>}' attribute.
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
	 * Unsets the value of the '{@link com.verticon.google.kmlgx.Wait#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link com.verticon.google.kmlgx.Wait#getDuration <em>Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration</em>' attribute is set.
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	boolean isSetDuration();

} // Wait
