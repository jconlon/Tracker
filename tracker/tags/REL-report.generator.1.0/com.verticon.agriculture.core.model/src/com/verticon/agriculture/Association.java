/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.agriculture;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.Premises;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.agriculture.Association#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.agriculture.Association#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.agriculture.Association#getLivestock <em>Livestock</em>}</li>
 *   <li>{@link com.verticon.agriculture.Association#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.agriculture.AgriculturePackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends EObject {
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
	 * @see com.verticon.agriculture.AgriculturePackage#getAssociation_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.verticon.agriculture.Association#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.verticon.agriculture.AgriculturePackage#getAssociation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.verticon.agriculture.Association#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see com.verticon.agriculture.AgriculturePackage#getAssociation_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.agriculture.Association#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Livestock</b></em>' reference list.
	 * The list contents are of type {@link com.verticon.tracker.Premises}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Livestock</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Livestock</em>' reference list.
	 * @see com.verticon.agriculture.AgriculturePackage#getAssociation_Livestock()
	 * @model
	 * @generated
	 */
	EList<Premises> getLivestock();

} // Association
