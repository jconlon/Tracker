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
package com.verticon.tracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Milk Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.MilkTest#getPoundsProduced <em>Pounds Produced</em>}</li>
 *   <li>{@link com.verticon.tracker.MilkTest#getPercentButterFat <em>Percent Butter Fat</em>}</li>
 *   <li>{@link com.verticon.tracker.MilkTest#getPercentProtein <em>Percent Protein</em>}</li>
 *   <li>{@link com.verticon.tracker.MilkTest#getSomaticCellCounts <em>Somatic Cell Counts</em>}</li>
 *   <li>{@link com.verticon.tracker.MilkTest#getOtherSolids <em>Other Solids</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getMilkTest()
 * @model
 * @generated
 */
public interface MilkTest extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 107;
	
	
	/**
	 * Returns the value of the '<em><b>Pounds Produced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pounds Produced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pounds Produced</em>' attribute.
	 * @see #setPoundsProduced(double)
	 * @see com.verticon.tracker.TrackerPackage#getMilkTest_PoundsProduced()
	 * @model
	 * @generated
	 */
	double getPoundsProduced();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MilkTest#getPoundsProduced <em>Pounds Produced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pounds Produced</em>' attribute.
	 * @see #getPoundsProduced()
	 * @generated
	 */
	void setPoundsProduced(double value);

	/**
	 * Returns the value of the '<em><b>Percent Butter Fat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percent Butter Fat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percent Butter Fat</em>' attribute.
	 * @see #setPercentButterFat(double)
	 * @see com.verticon.tracker.TrackerPackage#getMilkTest_PercentButterFat()
	 * @model
	 * @generated
	 */
	double getPercentButterFat();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MilkTest#getPercentButterFat <em>Percent Butter Fat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percent Butter Fat</em>' attribute.
	 * @see #getPercentButterFat()
	 * @generated
	 */
	void setPercentButterFat(double value);

	/**
	 * Returns the value of the '<em><b>Percent Protein</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percent Protein</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percent Protein</em>' attribute.
	 * @see #setPercentProtein(double)
	 * @see com.verticon.tracker.TrackerPackage#getMilkTest_PercentProtein()
	 * @model
	 * @generated
	 */
	double getPercentProtein();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MilkTest#getPercentProtein <em>Percent Protein</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percent Protein</em>' attribute.
	 * @see #getPercentProtein()
	 * @generated
	 */
	void setPercentProtein(double value);

	/**
	 * Returns the value of the '<em><b>Somatic Cell Counts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Somatic Cell Counts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Somatic Cell Counts</em>' attribute.
	 * @see #setSomaticCellCounts(int)
	 * @see com.verticon.tracker.TrackerPackage#getMilkTest_SomaticCellCounts()
	 * @model
	 * @generated
	 */
	int getSomaticCellCounts();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MilkTest#getSomaticCellCounts <em>Somatic Cell Counts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Somatic Cell Counts</em>' attribute.
	 * @see #getSomaticCellCounts()
	 * @generated
	 */
	void setSomaticCellCounts(int value);

	/**
	 * Returns the value of the '<em><b>Other Solids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Solids</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Solids</em>' attribute.
	 * @see #setOtherSolids(double)
	 * @see com.verticon.tracker.TrackerPackage#getMilkTest_OtherSolids()
	 * @model
	 * @generated
	 */
	double getOtherSolids();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.MilkTest#getOtherSolids <em>Other Solids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Solids</em>' attribute.
	 * @see #getOtherSolids()
	 * @generated
	 */
	void setOtherSolids(double value);

} // MilkTest
