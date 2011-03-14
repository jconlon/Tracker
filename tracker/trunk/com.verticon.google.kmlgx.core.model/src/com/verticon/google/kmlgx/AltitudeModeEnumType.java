/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Altitude Mode Enum Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.google.kmlgx.KmlgxPackage#getAltitudeModeEnumType()
 * @model extendedMetaData="name='altitudeModeEnumType'"
 * @generated
 */
public enum AltitudeModeEnumType implements Enumerator {
	/**
	 * The '<em><b>Clamp To Sea Floor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLAMP_TO_SEA_FLOOR_VALUE
	 * @generated
	 * @ordered
	 */
	CLAMP_TO_SEA_FLOOR(0, "clampToSeaFloor", "clampToSeaFloor"),

	/**
	 * The '<em><b>Relative To Sea Floor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELATIVE_TO_SEA_FLOOR_VALUE
	 * @generated
	 * @ordered
	 */
	RELATIVE_TO_SEA_FLOOR(1, "relativeToSeaFloor", "relativeToSeaFloor");

	/**
	 * The '<em><b>Clamp To Sea Floor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Clamp To Sea Floor</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLAMP_TO_SEA_FLOOR
	 * @model name="clampToSeaFloor"
	 * @generated
	 * @ordered
	 */
	public static final int CLAMP_TO_SEA_FLOOR_VALUE = 0;

	/**
	 * The '<em><b>Relative To Sea Floor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Relative To Sea Floor</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELATIVE_TO_SEA_FLOOR
	 * @model name="relativeToSeaFloor"
	 * @generated
	 * @ordered
	 */
	public static final int RELATIVE_TO_SEA_FLOOR_VALUE = 1;

	/**
	 * An array of all the '<em><b>Altitude Mode Enum Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AltitudeModeEnumType[] VALUES_ARRAY =
		new AltitudeModeEnumType[] {
			CLAMP_TO_SEA_FLOOR,
			RELATIVE_TO_SEA_FLOOR,
		};

	/**
	 * A public read-only list of all the '<em><b>Altitude Mode Enum Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AltitudeModeEnumType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Altitude Mode Enum Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AltitudeModeEnumType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AltitudeModeEnumType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Altitude Mode Enum Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AltitudeModeEnumType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AltitudeModeEnumType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Altitude Mode Enum Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AltitudeModeEnumType get(int value) {
		switch (value) {
			case CLAMP_TO_SEA_FLOOR_VALUE: return CLAMP_TO_SEA_FLOOR;
			case RELATIVE_TO_SEA_FLOOR_VALUE: return RELATIVE_TO_SEA_FLOOR;
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
	private AltitudeModeEnumType(int value, String name, String literal) {
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
	
} //AltitudeModeEnumType
