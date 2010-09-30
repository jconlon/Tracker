/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.fair;

import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.Animal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exhibit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getNumber <em>Number</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getAnimal <em>Animal</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getExhibitor <em>Exhibitor</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getLot <em>Lot</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getSalesOrder <em>Sales Order</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#isInAuction <em>In Auction</em>}</li>
 *   <li>{@link com.verticon.tracker.fair.Exhibit#getAward <em>Award</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.fair.FairPackage#getExhibit()
 * @model
 * @generated
 */
public interface Exhibit extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Number()
	 * @model default="0" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getNumber();

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
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Animal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal</em>' reference.
	 * @see #setAnimal(Animal)
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Animal()
	 * @model required="true"
	 * @generated
	 */
	Animal getAnimal();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getAnimal <em>Animal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Animal</em>' reference.
	 * @see #getAnimal()
	 * @generated
	 */
	void setAnimal(Animal value);

	/**
	 * Returns the value of the '<em><b>Exhibitor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exhibitor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exhibitor</em>' reference.
	 * @see #setExhibitor(Person)
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Exhibitor()
	 * @model required="true"
	 * @generated
	 */
	Person getExhibitor();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getExhibitor <em>Exhibitor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exhibitor</em>' reference.
	 * @see #getExhibitor()
	 * @generated
	 */
	void setExhibitor(Person value);

	/**
	 * Returns the value of the '<em><b>Lot</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.fair.Lot#getExhibits <em>Exhibits</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lot</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lot</em>' container reference.
	 * @see #setLot(Lot)
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Lot()
	 * @see com.verticon.tracker.fair.Lot#getExhibits
	 * @model opposite="exhibits" required="true" transient="false"
	 * @generated
	 */
	Lot getLot();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getLot <em>Lot</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lot</em>' container reference.
	 * @see #getLot()
	 * @generated
	 */
	void setLot(Lot value);

	/**
	 * Returns the value of the '<em><b>Sales Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sales Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sales Order</em>' attribute.
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_SalesOrder()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getSalesOrder();

	/**
	 * Returns the value of the '<em><b>In Auction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Auction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Auction</em>' attribute.
	 * @see #setInAuction(boolean)
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_InAuction()
	 * @model
	 * @generated
	 */
	boolean isInAuction();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#isInAuction <em>In Auction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Auction</em>' attribute.
	 * @see #isInAuction()
	 * @generated
	 */
	void setInAuction(boolean value);

	/**
	 * Returns the value of the '<em><b>Award</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.fair.Award}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Award</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Award</em>' attribute.
	 * @see com.verticon.tracker.fair.Award
	 * @see #setAward(Award)
	 * @see com.verticon.tracker.fair.FairPackage#getExhibit_Award()
	 * @model
	 * @generated
	 */
	Award getAward();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.fair.Exhibit#getAward <em>Award</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Award</em>' attribute.
	 * @see com.verticon.tracker.fair.Award
	 * @see #getAward()
	 * @generated
	 */
	void setAward(Award value);

} // Exhibit
