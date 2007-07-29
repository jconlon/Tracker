/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;

import java.math.BigInteger;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.util.Age;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Animal#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSex <em>Sex</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getAins <em>Ains</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSpecies <em>Species</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getIdNumber <em>Id Number</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getBreed <em>Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getAge <em>Age</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSexCode <em>Sex Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSpeciesCode <em>Species Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getAnimal()
 * @model abstract="true"
 * @generated
 */
public interface Animal extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Date</em>' attribute.
	 * @see #setBirthDate(Date)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_BirthDate()
	 * @model dataType="com.verticon.tracker.Date"
	 * @generated
	 */
	Date getBirthDate();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getBirthDate <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Date</em>' attribute.
	 * @see #getBirthDate()
	 * @generated
	 */
	void setBirthDate(Date value);

	/**
	 * Returns the value of the '<em><b>Sex</b></em>' attribute.
	 * The default value is <code>"Unspecified"</code>.
	 * The literals are from the enumeration {@link com.verticon.tracker.Sex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sex</em>' attribute.
	 * @see com.verticon.tracker.Sex
	 * @see #isSetSex()
	 * @see #unsetSex()
	 * @see #setSex(Sex)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Sex()
	 * @model default="Unspecified" unsettable="true"
	 * @generated
	 */
	Sex getSex();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sex</em>' attribute.
	 * @see com.verticon.tracker.Sex
	 * @see #isSetSex()
	 * @see #unsetSex()
	 * @see #getSex()
	 * @generated
	 */
	void setSex(Sex value);

	/**
	 * Unsets the value of the '{@link com.verticon.tracker.Animal#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSex()
	 * @see #getSex()
	 * @see #setSex(Sex)
	 * @generated
	 */
	void unsetSex();

	/**
	 * Returns whether the value of the '{@link com.verticon.tracker.Animal#getSex <em>Sex</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sex</em>' attribute is set.
	 * @see #unsetSex()
	 * @see #getSex()
	 * @see #setSex(Sex)
	 * @generated
	 */
	boolean isSetSex();

	/**
	 * Returns the value of the '<em><b>Ains</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.AnimalId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ains</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Ains()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AnimalId> getAins();

	/**
	 * Returns the value of the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Species</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Species</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Species()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getSpecies();

	/**
	 * Returns the value of the '<em><b>Id Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Number</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_IdNumber()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	BigInteger getIdNumber();

	/**
	 * Returns the value of the '<em><b>Breed</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Breed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Breed</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Breed()
	 * @model default="" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getBreed();

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Age()
	 * @model default="" dataType="com.verticon.tracker.Age" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Age getAge();

	/**
	 * Returns the value of the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sex Code</em>' attribute.
	 * @see #isSetSexCode()
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_SexCode()
	 * @model unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getSexCode();

	/**
	 * Returns whether the value of the '{@link com.verticon.tracker.Animal#getSexCode <em>Sex Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sex Code</em>' attribute is set.
	 * @see #getSexCode()
	 * @generated
	 */
	boolean isSetSexCode();

	/**
	 * Returns the value of the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Species Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Species Code</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_SpeciesCode()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getSpeciesCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/ocl/examples/OCL body='if (ains -> notEmpty()) and ( ains.events -> notEmpty())\n\tthen ains.events\n\telse Set{}\nendif'"
	 * @generated
	 */
	EList<Event> allEvents();

} // Animal