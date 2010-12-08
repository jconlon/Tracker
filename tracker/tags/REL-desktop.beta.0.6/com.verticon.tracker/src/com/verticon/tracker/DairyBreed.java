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
 * A representation of the literals of the enumeration '<em><b>Dairy Breed</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage#getDairyBreed()
 * @model
 * @generated
 */
public enum DairyBreed implements Enumerator
{
	/**
	 * The '<em><b>LD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LD
	 * @generated
	 * @ordered
	 */
	LD_LITERAL(0, "LD", "AMERICAN LINEBACK"),
	/**
	 * The '<em><b>AY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AY
	 * @generated
	 * @ordered
	 */
	AY_LITERAL(1, "AY", "AYRSHIRE"),
	/**
	 * The '<em><b>BS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BS
	 * @generated
	 * @ordered
	 */
	BS_LITERAL(2, "BS", "BROWN SWISS"),
	/**
	 * The '<em><b>GD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GD
	 * @generated
	 * @ordered
	 */
	GD_LITERAL(3, "GD", "GALLOWAY"),
	/**
	 * The '<em><b>GU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GU
	 * @generated
	 * @ordered
	 */
	GU_LITERAL(4, "GU", "GUERNSEY"),
	/**
	 * The '<em><b>HO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HO
	 * @generated
	 * @ordered
	 */
	HO_LITERAL(5, "HO", "HOLSTEIN"),
	/**
	 * The '<em><b>JE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JE
	 * @generated
	 * @ordered
	 */
	JE_LITERAL(6, "JE", "JERSEY"),
	/**
	 * The '<em><b>WW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WW
	 * @generated
	 * @ordered
	 */
	WW_LITERAL(7, "WW", "RED HOLSTEIN"),
	/**
	 * The '<em><b>FM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FM
	 * @generated
	 * @ordered
	 */
	FM_LITERAL(8, "FM", "ROUGE FLAMAND"),
	/**
	 * The '<em><b>MS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MS
	 * @generated
	 * @ordered
	 */
	MS_LITERAL(9, "MS", "SHORTHORN"),
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED_LITERAL(10, "Unspecified", "");
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The '<em><b>LD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LD_LITERAL
	 * @model literal="AMERICAN LINEBACK"
	 * @generated
	 * @ordered
	 */
	public static final int LD = 0;

	/**
	 * The '<em><b>AY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AY_LITERAL
	 * @model literal="AYRSHIRE"
	 * @generated
	 * @ordered
	 */
	public static final int AY = 1;

	/**
	 * The '<em><b>BS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BS_LITERAL
	 * @model literal="BROWN SWISS"
	 * @generated
	 * @ordered
	 */
	public static final int BS = 2;

	/**
	 * The '<em><b>GD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GD_LITERAL
	 * @model literal="GALLOWAY"
	 * @generated
	 * @ordered
	 */
	public static final int GD = 3;

	/**
	 * The '<em><b>GU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GU_LITERAL
	 * @model literal="GUERNSEY"
	 * @generated
	 * @ordered
	 */
	public static final int GU = 4;

	/**
	 * The '<em><b>HO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HO_LITERAL
	 * @model literal="HOLSTEIN"
	 * @generated
	 * @ordered
	 */
	public static final int HO = 5;

	/**
	 * The '<em><b>JE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JE_LITERAL
	 * @model literal="JERSEY"
	 * @generated
	 * @ordered
	 */
	public static final int JE = 6;

	/**
	 * The '<em><b>WW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WW_LITERAL
	 * @model literal="RED HOLSTEIN"
	 * @generated
	 * @ordered
	 */
	public static final int WW = 7;

	/**
	 * The '<em><b>FM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FM_LITERAL
	 * @model literal="ROUGE FLAMAND"
	 * @generated
	 * @ordered
	 */
	public static final int FM = 8;

	/**
	 * The '<em><b>MS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MS_LITERAL
	 * @model literal="SHORTHORN"
	 * @generated
	 * @ordered
	 */
	public static final int MS = 9;

	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unspecified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_LITERAL
	 * @model name="Unspecified" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED = 10;

	/**
	 * An array of all the '<em><b>Dairy Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DairyBreed[] VALUES_ARRAY =
		new DairyBreed[] {
			LD_LITERAL,
			AY_LITERAL,
			BS_LITERAL,
			GD_LITERAL,
			GU_LITERAL,
			HO_LITERAL,
			JE_LITERAL,
			WW_LITERAL,
			FM_LITERAL,
			MS_LITERAL,
			UNSPECIFIED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Dairy Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DairyBreed> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Dairy Breed</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DairyBreed get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DairyBreed result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Dairy Breed</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DairyBreed getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DairyBreed result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Dairy Breed</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DairyBreed get(int value) {
		switch (value) {
			case LD: return LD_LITERAL;
			case AY: return AY_LITERAL;
			case BS: return BS_LITERAL;
			case GD: return GD_LITERAL;
			case GU: return GU_LITERAL;
			case HO: return HO_LITERAL;
			case JE: return JE_LITERAL;
			case WW: return WW_LITERAL;
			case FM: return FM_LITERAL;
			case MS: return MS_LITERAL;
			case UNSPECIFIED: return UNSPECIFIED_LITERAL;
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
	private DairyBreed(int value, String name, String literal) {
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
}
