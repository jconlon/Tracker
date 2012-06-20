/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.agriculture;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Altitude Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.agriculture.AgriculturePackage#getAltitudeMode()
 * @model
 * @generated
 */
public enum AltitudeMode implements Enumerator {
	/**
	 * The '<em><b>Absolute</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE_VALUE
	 * @generated
	 * @ordered
	 */
	ABSOLUTE(0, "absolute", "absolute"),

	/**
	 * The '<em><b>Clamp To Ground</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLAMP_TO_GROUND_VALUE
	 * @generated
	 * @ordered
	 */
	CLAMP_TO_GROUND(1, "clampToGround", "clampToGround"),

	/**
	 * The '<em><b>Relative To Ground</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELATIVE_TO_GROUND_VALUE
	 * @generated
	 * @ordered
	 */
	RELATIVE_TO_GROUND(2, "relativeToGround", "relativeToGround");

	/**
	 * The '<em><b>Absolute</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Absolute</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE
	 * @model name="absolute"
	 * @generated
	 * @ordered
	 */
	public static final int ABSOLUTE_VALUE = 0;

	/**
	 * The '<em><b>Clamp To Ground</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Clamp To Ground</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLAMP_TO_GROUND
	 * @model name="clampToGround"
	 * @generated
	 * @ordered
	 */
	public static final int CLAMP_TO_GROUND_VALUE = 1;

	/**
	 * The '<em><b>Relative To Ground</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Relative To Ground</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELATIVE_TO_GROUND
	 * @model name="relativeToGround"
	 * @generated
	 * @ordered
	 */
	public static final int RELATIVE_TO_GROUND_VALUE = 2;

	/**
	 * An array of all the '<em><b>Altitude Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AltitudeMode[] VALUES_ARRAY =
		new AltitudeMode[] {
			ABSOLUTE,
			CLAMP_TO_GROUND,
			RELATIVE_TO_GROUND,
		};

	/**
	 * A public read-only list of all the '<em><b>Altitude Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AltitudeMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Altitude Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AltitudeMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AltitudeMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Altitude Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AltitudeMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AltitudeMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Altitude Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AltitudeMode get(int value) {
		switch (value) {
			case ABSOLUTE_VALUE: return ABSOLUTE;
			case CLAMP_TO_GROUND_VALUE: return CLAMP_TO_GROUND;
			case RELATIVE_TO_GROUND_VALUE: return RELATIVE_TO_GROUND;
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
	private AltitudeMode(int value, String name, String literal) {
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
	
} //AltitudeMode
