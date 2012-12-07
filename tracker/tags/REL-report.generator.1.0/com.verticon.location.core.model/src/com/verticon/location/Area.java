/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.location.Area#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.location.Area#getBoundary <em>Boundary</em>}</li>
 *   <li>{@link com.verticon.location.Area#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.location.LocationPackage#getArea()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidCoordinatesFormat'"
 * @generated
 */
public interface Area extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.verticon.location.LocationPackage#getArea_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.location.Area#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Boundary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary</em>' attribute.
	 * @see #setBoundary(String)
	 * @see com.verticon.location.LocationPackage#getArea_Boundary()
	 * @model dataType="com.verticon.location.Polygon" required="true"
	 * @generated
	 */
	String getBoundary();

	/**
	 * Sets the value of the '{@link com.verticon.location.Area#getBoundary <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boundary</em>' attribute.
	 * @see #getBoundary()
	 * @generated
	 */
	void setBoundary(String value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(String)
	 * @see com.verticon.location.LocationPackage#getArea_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.location.Area#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	double getAreaMeasurement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="com.verticon.location.PointFormatException"
	 * @generated
	 */
	boolean containsPoint(String point) throws IllegalArgumentException;

} // Area
