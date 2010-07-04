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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Award</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.fair.FairPackage#getAward()
 * @model
 * @generated
 */
public enum Award implements Enumerator {
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED(0, "Unspecified", ""),

	/**
	 * The '<em><b>Grand Champion</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAND_CHAMPION_VALUE
	 * @generated
	 * @ordered
	 */
	GRAND_CHAMPION(1, "GrandChampion", "Grand Champion"),

	/**
	 * The '<em><b>Reserve Champion</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESERVE_CHAMPION_VALUE
	 * @generated
	 * @ordered
	 */
	RESERVE_CHAMPION(2, "ReserveChampion", "Reserve Champion"),

	/**
	 * The '<em><b>Blue Ribbon</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLUE_RIBBON_VALUE
	 * @generated
	 * @ordered
	 */
	BLUE_RIBBON(3, "BlueRibbon", "Blue Ribbon"),

	/**
	 * The '<em><b>Red Ribbon</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RED_RIBBON_VALUE
	 * @generated
	 * @ordered
	 */
	RED_RIBBON(4, "RedRibbon", "Red Ribbon"),

	/**
	 * The '<em><b>White Ribbon</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WHITE_RIBBON_VALUE
	 * @generated
	 * @ordered
	 */
	WHITE_RIBBON(5, "WhiteRibbon", "White Ribbon"),

	/**
	 * The '<em><b>Pink Ribbon</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PINK_RIBBON_VALUE
	 * @generated
	 * @ordered
	 */
	PINK_RIBBON(6, "PinkRibbon", "Pink Ribbon");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unspecified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @model name="Unspecified" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED_VALUE = 0;

	/**
	 * The '<em><b>Grand Champion</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Grand Champion</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAND_CHAMPION
	 * @model name="GrandChampion" literal="Grand Champion"
	 * @generated
	 * @ordered
	 */
	public static final int GRAND_CHAMPION_VALUE = 1;

	/**
	 * The '<em><b>Reserve Champion</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reserve Champion</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESERVE_CHAMPION
	 * @model name="ReserveChampion" literal="Reserve Champion"
	 * @generated
	 * @ordered
	 */
	public static final int RESERVE_CHAMPION_VALUE = 2;

	/**
	 * The '<em><b>Blue Ribbon</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Blue Ribbon</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLUE_RIBBON
	 * @model name="BlueRibbon" literal="Blue Ribbon"
	 * @generated
	 * @ordered
	 */
	public static final int BLUE_RIBBON_VALUE = 3;

	/**
	 * The '<em><b>Red Ribbon</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Red Ribbon</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RED_RIBBON
	 * @model name="RedRibbon" literal="Red Ribbon"
	 * @generated
	 * @ordered
	 */
	public static final int RED_RIBBON_VALUE = 4;

	/**
	 * The '<em><b>White Ribbon</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>White Ribbon</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WHITE_RIBBON
	 * @model name="WhiteRibbon" literal="White Ribbon"
	 * @generated
	 * @ordered
	 */
	public static final int WHITE_RIBBON_VALUE = 5;

	/**
	 * The '<em><b>Pink Ribbon</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pink Ribbon</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PINK_RIBBON
	 * @model name="PinkRibbon" literal="Pink Ribbon"
	 * @generated
	 * @ordered
	 */
	public static final int PINK_RIBBON_VALUE = 6;

	/**
	 * An array of all the '<em><b>Award</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Award[] VALUES_ARRAY =
		new Award[] {
			UNSPECIFIED,
			GRAND_CHAMPION,
			RESERVE_CHAMPION,
			BLUE_RIBBON,
			RED_RIBBON,
			WHITE_RIBBON,
			PINK_RIBBON,
		};

	/**
	 * A public read-only list of all the '<em><b>Award</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Award> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Award</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Award get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Award result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Award</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Award getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Award result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Award</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Award get(int value) {
		switch (value) {
			case UNSPECIFIED_VALUE: return UNSPECIFIED;
			case GRAND_CHAMPION_VALUE: return GRAND_CHAMPION;
			case RESERVE_CHAMPION_VALUE: return RESERVE_CHAMPION;
			case BLUE_RIBBON_VALUE: return BLUE_RIBBON;
			case RED_RIBBON_VALUE: return RED_RIBBON;
			case WHITE_RIBBON_VALUE: return WHITE_RIBBON;
			case PINK_RIBBON_VALUE: return PINK_RIBBON;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Award(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Award
