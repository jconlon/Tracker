/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Sex</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage#getSex()
 * @model
 * @generated
 */
public enum Sex implements Enumerator
{
	/**
	 * The '<em><b>F</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #F
	 * @generated
	 * @ordered
	 */
	F_LITERAL(0, "F", "Female"),
	/**
	 * The '<em><b>M</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #M
	 * @generated
	 * @ordered
	 */
	M_LITERAL(1, "M", "Male"),
	/**
	 * The '<em><b>C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #C
	 * @generated
	 * @ordered
	 */
	C_LITERAL(2, "C", "Neutered/castrated male"),
	/**
	 * The '<em><b>S</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #S
	 * @generated
	 * @ordered
	 */
	S_LITERAL(3, "S", "Neutered/spayed female"),
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED_LITERAL(4, "Unspecified", "Unspecified");
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The '<em><b>F</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>F</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #F_LITERAL
	 * @model literal="Female"
	 * @generated
	 * @ordered
	 */
	public static final int F = 0;

	/**
	 * The '<em><b>M</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>M</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #M_LITERAL
	 * @model literal="Male"
	 * @generated
	 * @ordered
	 */
	public static final int M = 1;

	/**
	 * The '<em><b>C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>C</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #C_LITERAL
	 * @model literal="Neutered/castrated male"
	 * @generated
	 * @ordered
	 */
	public static final int C = 2;

	/**
	 * The '<em><b>S</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>S</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #S_LITERAL
	 * @model literal="Neutered/spayed female"
	 * @generated
	 * @ordered
	 */
	public static final int S = 3;

	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unspecified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_LITERAL
	 * @model name="Unspecified"
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED = 4;

	/**
	 * An array of all the '<em><b>Sex</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Sex[] VALUES_ARRAY =
		new Sex[] {
			F_LITERAL,
			M_LITERAL,
			C_LITERAL,
			S_LITERAL,
			UNSPECIFIED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Sex</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Sex> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Sex</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Sex get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Sex result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sex</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Sex getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Sex result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sex</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Sex get(int value) {
		switch (value) {
			case F: return F_LITERAL;
			case M: return M_LITERAL;
			case C: return C_LITERAL;
			case S: return S_LITERAL;
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
	private Sex(int value, String name, String literal) {
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
