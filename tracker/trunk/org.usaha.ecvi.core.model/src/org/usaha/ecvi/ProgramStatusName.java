/**
 */
package org.usaha.ecvi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Program Status Name</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.usaha.ecvi.EcviPackage#getProgramStatusName()
 * @model extendedMetaData="name='Name_._type'"
 * @generated
 */
public enum ProgramStatusName implements Enumerator {
	/**
	 * The '<em><b>Bovine Tuberculosis</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOVINE_TUBERCULOSIS_VALUE
	 * @generated
	 * @ordered
	 */
	BOVINE_TUBERCULOSIS(0, "BovineTuberculosis", "Bovine Tuberculosis"),

	/**
	 * The '<em><b>Brucellosis State</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRUCELLOSIS_STATE_VALUE
	 * @generated
	 * @ordered
	 */
	BRUCELLOSIS_STATE(1, "BrucellosisState", "Brucellosis (state)"),

	/**
	 * The '<em><b>Brucellosis Herd</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRUCELLOSIS_HERD_VALUE
	 * @generated
	 * @ordered
	 */
	BRUCELLOSIS_HERD(2, "BrucellosisHerd", "Brucellosis (herd)");

	/**
	 * The '<em><b>Bovine Tuberculosis</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bovine Tuberculosis</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOVINE_TUBERCULOSIS
	 * @model name="BovineTuberculosis" literal="Bovine Tuberculosis"
	 * @generated
	 * @ordered
	 */
	public static final int BOVINE_TUBERCULOSIS_VALUE = 0;

	/**
	 * The '<em><b>Brucellosis State</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Brucellosis State</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRUCELLOSIS_STATE
	 * @model name="BrucellosisState" literal="Brucellosis (state)"
	 * @generated
	 * @ordered
	 */
	public static final int BRUCELLOSIS_STATE_VALUE = 1;

	/**
	 * The '<em><b>Brucellosis Herd</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Brucellosis Herd</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRUCELLOSIS_HERD
	 * @model name="BrucellosisHerd" literal="Brucellosis (herd)"
	 * @generated
	 * @ordered
	 */
	public static final int BRUCELLOSIS_HERD_VALUE = 2;

	/**
	 * An array of all the '<em><b>Program Status Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProgramStatusName[] VALUES_ARRAY =
		new ProgramStatusName[] {
			BOVINE_TUBERCULOSIS,
			BRUCELLOSIS_STATE,
			BRUCELLOSIS_HERD,
		};

	/**
	 * A public read-only list of all the '<em><b>Program Status Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ProgramStatusName> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Program Status Name</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProgramStatusName get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProgramStatusName result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Program Status Name</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProgramStatusName getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProgramStatusName result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Program Status Name</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProgramStatusName get(int value) {
		switch (value) {
			case BOVINE_TUBERCULOSIS_VALUE: return BOVINE_TUBERCULOSIS;
			case BRUCELLOSIS_STATE_VALUE: return BRUCELLOSIS_STATE;
			case BRUCELLOSIS_HERD_VALUE: return BRUCELLOSIS_HERD;
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
	private ProgramStatusName(int value, String name, String literal) {
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
	
} //ProgramStatusName
