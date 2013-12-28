/**
 */
package org.usaha.ecvi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Species Code</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This enforces the list of allowed species codes that are supported.
 * <!-- end-model-doc -->
 * @see org.usaha.ecvi.EcviPackage#getSpeciesCode()
 * @model extendedMetaData="name='SpeciesCodeType'"
 * @generated
 */
public enum SpeciesCode implements Enumerator {
	/**
	 * The '<em><b>UNK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNK_VALUE
	 * @generated
	 * @ordered
	 */
	UNK(0, "UNK", "UNK"),

	/**
	 * The '<em><b>BOV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOV_VALUE
	 * @generated
	 * @ordered
	 */
	BOV(1, "BOV", "BOV"),

	/**
	 * The '<em><b>CAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAP_VALUE
	 * @generated
	 * @ordered
	 */
	CAP(2, "CAP", "CAP"),

	/**
	 * The '<em><b>CER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CER_VALUE
	 * @generated
	 * @ordered
	 */
	CER(3, "CER", "CER"),

	/**
	 * The '<em><b>EQU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQU_VALUE
	 * @generated
	 * @ordered
	 */
	EQU(4, "EQU", "EQU"),

	/**
	 * The '<em><b>OVI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVI_VALUE
	 * @generated
	 * @ordered
	 */
	OVI(5, "OVI", "OVI"),

	/**
	 * The '<em><b>POR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POR_VALUE
	 * @generated
	 * @ordered
	 */
	POR(6, "POR", "POR");

	/**
	 * The '<em><b>UNK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNK_VALUE = 0;

	/**
	 * The '<em><b>BOV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOV
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOV_VALUE = 1;

	/**
	 * The '<em><b>CAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CAP_VALUE = 2;

	/**
	 * The '<em><b>CER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CER_VALUE = 3;

	/**
	 * The '<em><b>EQU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQU
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQU_VALUE = 4;

	/**
	 * The '<em><b>OVI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OVI_VALUE = 5;

	/**
	 * The '<em><b>POR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POR_VALUE = 6;

	/**
	 * An array of all the '<em><b>Species Code</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SpeciesCode[] VALUES_ARRAY =
		new SpeciesCode[] {
			UNK,
			BOV,
			CAP,
			CER,
			EQU,
			OVI,
			POR,
		};

	/**
	 * A public read-only list of all the '<em><b>Species Code</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SpeciesCode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Species Code</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpeciesCode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SpeciesCode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Species Code</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpeciesCode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SpeciesCode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Species Code</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpeciesCode get(int value) {
		switch (value) {
			case UNK_VALUE: return UNK;
			case BOV_VALUE: return BOV;
			case CAP_VALUE: return CAP;
			case CER_VALUE: return CER;
			case EQU_VALUE: return EQU;
			case OVI_VALUE: return OVI;
			case POR_VALUE: return POR;
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
	private SpeciesCode(int value, String name, String literal) {
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
	
} //SpeciesCode
