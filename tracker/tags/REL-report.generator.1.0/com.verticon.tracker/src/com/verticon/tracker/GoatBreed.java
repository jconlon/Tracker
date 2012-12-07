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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Goat Breed</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage#getGoatBreed()
 * @model
 * @generated
 */
public enum GoatBreed implements Enumerator {
	/**
	 * The '<em><b>AI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AI_VALUE
	 * @generated
	 * @ordered
	 */
	AI(0, "AI", "ALPINE"),

	/**
	 * The '<em><b>AG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AG_VALUE
	 * @generated
	 * @ordered
	 */
	AG(1, "AG", "ANGORA"),

	/**
	 * The '<em><b>BZ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BZ_VALUE
	 * @generated
	 * @ordered
	 */
	BZ(2, "BZ", "BOER"),

	/**
	 * The '<em><b>CS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CS_VALUE
	 * @generated
	 * @ordered
	 */
	CS(3, "CS", "CASHMERE"),

	/**
	 * The '<em><b>LN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LN_VALUE
	 * @generated
	 * @ordered
	 */
	LN(4, "LN", "LA MANCHA"),

	/**
	 * The '<em><b>ND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ND_VALUE
	 * @generated
	 * @ordered
	 */
	ND(5, "ND", "NIGERIAN DWARF"),

	/**
	 * The '<em><b>NU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NU_VALUE
	 * @generated
	 * @ordered
	 */
	NU(6, "NU", "NUBIAN"),

	/**
	 * The '<em><b>OH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OH_VALUE
	 * @generated
	 * @ordered
	 */
	OH(7, "OH", "OBERHASLI"),

	/**
	 * The '<em><b>PY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PY_VALUE
	 * @generated
	 * @ordered
	 */
	PY(8, "PY", "PYGMY"),

	/**
	 * The '<em><b>EN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EN_VALUE
	 * @generated
	 * @ordered
	 */
	EN(9, "EN", "SAANEN"),

	/**
	 * The '<em><b>TO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TO_VALUE
	 * @generated
	 * @ordered
	 */
	TO(10, "TO", "TOGGENBURG"),

	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED(11, "Unspecified", "Unspecified");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The '<em><b>AI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AI
	 * @model literal="ALPINE"
	 * @generated
	 * @ordered
	 */
	public static final int AI_VALUE = 0;

	/**
	 * The '<em><b>AG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AG
	 * @model literal="ANGORA"
	 * @generated
	 * @ordered
	 */
	public static final int AG_VALUE = 1;

	/**
	 * The '<em><b>BZ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BZ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BZ
	 * @model literal="BOER"
	 * @generated
	 * @ordered
	 */
	public static final int BZ_VALUE = 2;

	/**
	 * The '<em><b>CS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CS
	 * @model literal="CASHMERE"
	 * @generated
	 * @ordered
	 */
	public static final int CS_VALUE = 3;

	/**
	 * The '<em><b>LN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LN
	 * @model literal="LA MANCHA"
	 * @generated
	 * @ordered
	 */
	public static final int LN_VALUE = 4;

	/**
	 * The '<em><b>ND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ND
	 * @model literal="NIGERIAN DWARF"
	 * @generated
	 * @ordered
	 */
	public static final int ND_VALUE = 5;

	/**
	 * The '<em><b>NU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NU
	 * @model literal="NUBIAN"
	 * @generated
	 * @ordered
	 */
	public static final int NU_VALUE = 6;

	/**
	 * The '<em><b>OH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OH
	 * @model literal="OBERHASLI"
	 * @generated
	 * @ordered
	 */
	public static final int OH_VALUE = 7;

	/**
	 * The '<em><b>PY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PY
	 * @model literal="PYGMY"
	 * @generated
	 * @ordered
	 */
	public static final int PY_VALUE = 8;

	/**
	 * The '<em><b>EN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EN
	 * @model literal="SAANEN"
	 * @generated
	 * @ordered
	 */
	public static final int EN_VALUE = 9;

	/**
	 * The '<em><b>TO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TO
	 * @model literal="TOGGENBURG"
	 * @generated
	 * @ordered
	 */
	public static final int TO_VALUE = 10;

	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unspecified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @model name="Unspecified"
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED_VALUE = 11;

	/**
	 * An array of all the '<em><b>Goat Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GoatBreed[] VALUES_ARRAY =
		new GoatBreed[] {
			AI,
			AG,
			BZ,
			CS,
			LN,
			ND,
			NU,
			OH,
			PY,
			EN,
			TO,
			UNSPECIFIED,
		};

	/**
	 * A public read-only list of all the '<em><b>Goat Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GoatBreed> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Goat Breed</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GoatBreed get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GoatBreed result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Goat Breed</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GoatBreed getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GoatBreed result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Goat Breed</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GoatBreed get(int value) {
		switch (value) {
			case AI_VALUE: return AI;
			case AG_VALUE: return AG;
			case BZ_VALUE: return BZ;
			case CS_VALUE: return CS;
			case LN_VALUE: return LN;
			case ND_VALUE: return ND;
			case NU_VALUE: return NU;
			case OH_VALUE: return OH;
			case PY_VALUE: return PY;
			case EN_VALUE: return EN;
			case TO_VALUE: return TO;
			case UNSPECIFIED_VALUE: return UNSPECIFIED;
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
	private GoatBreed(int value, String name, String literal) {
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
	
} //GoatBreed
