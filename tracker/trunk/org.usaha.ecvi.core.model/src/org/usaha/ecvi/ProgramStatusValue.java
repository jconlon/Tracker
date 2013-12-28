/**
 */
package org.usaha.ecvi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Program Status Value</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.usaha.ecvi.EcviPackage#getProgramStatusValue()
 * @model extendedMetaData="name='Value_._type'"
 * @generated
 */
public enum ProgramStatusValue implements Enumerator {
	/**
	 * The '<em><b>Free</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREE_VALUE
	 * @generated
	 * @ordered
	 */
	FREE(0, "Free", "Free"),

	/**
	 * The '<em><b>Modified Accredited</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFIED_ACCREDITED_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFIED_ACCREDITED(1, "ModifiedAccredited", "Modified Accredited"),

	/**
	 * The '<em><b>Modified Advanced Accredited</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFIED_ADVANCED_ACCREDITED_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFIED_ADVANCED_ACCREDITED(2, "ModifiedAdvancedAccredited", "Modified Advanced Accredited"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(3, "Other", "Other");

	/**
	 * The '<em><b>Free</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Free</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREE
	 * @model name="Free"
	 * @generated
	 * @ordered
	 */
	public static final int FREE_VALUE = 0;

	/**
	 * The '<em><b>Modified Accredited</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Modified Accredited</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODIFIED_ACCREDITED
	 * @model name="ModifiedAccredited" literal="Modified Accredited"
	 * @generated
	 * @ordered
	 */
	public static final int MODIFIED_ACCREDITED_VALUE = 1;

	/**
	 * The '<em><b>Modified Advanced Accredited</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Modified Advanced Accredited</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODIFIED_ADVANCED_ACCREDITED
	 * @model name="ModifiedAdvancedAccredited" literal="Modified Advanced Accredited"
	 * @generated
	 * @ordered
	 */
	public static final int MODIFIED_ADVANCED_ACCREDITED_VALUE = 2;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @model name="Other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 3;

	/**
	 * An array of all the '<em><b>Program Status Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProgramStatusValue[] VALUES_ARRAY =
		new ProgramStatusValue[] {
			FREE,
			MODIFIED_ACCREDITED,
			MODIFIED_ADVANCED_ACCREDITED,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Program Status Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ProgramStatusValue> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Program Status Value</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProgramStatusValue get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProgramStatusValue result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Program Status Value</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProgramStatusValue getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProgramStatusValue result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Program Status Value</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProgramStatusValue get(int value) {
		switch (value) {
			case FREE_VALUE: return FREE;
			case MODIFIED_ACCREDITED_VALUE: return MODIFIED_ACCREDITED;
			case MODIFIED_ADVANCED_ACCREDITED_VALUE: return MODIFIED_ADVANCED_ACCREDITED;
			case OTHER_VALUE: return OTHER;
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
	private ProgramStatusValue(int value, String name, String literal) {
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
	
} //ProgramStatusValue
