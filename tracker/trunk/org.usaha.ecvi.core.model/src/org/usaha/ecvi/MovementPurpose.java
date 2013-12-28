/**
 */
package org.usaha.ecvi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Movement Purpose</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.usaha.ecvi.EcviPackage#getMovementPurpose()
 * @model extendedMetaData="name='MovementPurposeType'"
 * @generated
 */
public enum MovementPurpose implements Enumerator {
	/**
	 * The '<em><b>Show</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHOW_VALUE
	 * @generated
	 * @ordered
	 */
	SHOW(0, "show", "show"),

	/**
	 * The '<em><b>Race</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RACE_VALUE
	 * @generated
	 * @ordered
	 */
	RACE(1, "race", "race"),

	/**
	 * The '<em><b>Rodeo</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RODEO_VALUE
	 * @generated
	 * @ordered
	 */
	RODEO(2, "rodeo", "rodeo"),

	/**
	 * The '<em><b>Sale</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SALE_VALUE
	 * @generated
	 * @ordered
	 */
	SALE(3, "sale", "sale"),

	/**
	 * The '<em><b>Pet</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PET_VALUE
	 * @generated
	 * @ordered
	 */
	PET(4, "pet", "pet"),

	/**
	 * The '<em><b>Breeding</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREEDING_VALUE
	 * @generated
	 * @ordered
	 */
	BREEDING(5, "breeding", "breeding"),

	/**
	 * The '<em><b>Feeding</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEEDING_VALUE
	 * @generated
	 * @ordered
	 */
	FEEDING(6, "feeding", "feeding"),

	/**
	 * The '<em><b>Grazing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAZING_VALUE
	 * @generated
	 * @ordered
	 */
	GRAZING(7, "grazing", "grazing"),

	/**
	 * The '<em><b>Training</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAINING_VALUE
	 * @generated
	 * @ordered
	 */
	TRAINING(8, "training", "training"),

	/**
	 * The '<em><b>Slaughter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLAUGHTER_VALUE
	 * @generated
	 * @ordered
	 */
	SLAUGHTER(9, "slaughter", "slaughter"),

	/**
	 * The '<em><b>Medical Treatment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDICAL_TREATMENT_VALUE
	 * @generated
	 * @ordered
	 */
	MEDICAL_TREATMENT(10, "medicalTreatment", "medicalTreatment"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(11, "other", "other");

	/**
	 * The '<em><b>Show</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Show</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHOW
	 * @model name="show"
	 * @generated
	 * @ordered
	 */
	public static final int SHOW_VALUE = 0;

	/**
	 * The '<em><b>Race</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Race</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RACE
	 * @model name="race"
	 * @generated
	 * @ordered
	 */
	public static final int RACE_VALUE = 1;

	/**
	 * The '<em><b>Rodeo</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rodeo</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RODEO
	 * @model name="rodeo"
	 * @generated
	 * @ordered
	 */
	public static final int RODEO_VALUE = 2;

	/**
	 * The '<em><b>Sale</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sale</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SALE
	 * @model name="sale"
	 * @generated
	 * @ordered
	 */
	public static final int SALE_VALUE = 3;

	/**
	 * The '<em><b>Pet</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pet</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PET
	 * @model name="pet"
	 * @generated
	 * @ordered
	 */
	public static final int PET_VALUE = 4;

	/**
	 * The '<em><b>Breeding</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Breeding</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BREEDING
	 * @model name="breeding"
	 * @generated
	 * @ordered
	 */
	public static final int BREEDING_VALUE = 5;

	/**
	 * The '<em><b>Feeding</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Feeding</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEEDING
	 * @model name="feeding"
	 * @generated
	 * @ordered
	 */
	public static final int FEEDING_VALUE = 6;

	/**
	 * The '<em><b>Grazing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Grazing</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAZING
	 * @model name="grazing"
	 * @generated
	 * @ordered
	 */
	public static final int GRAZING_VALUE = 7;

	/**
	 * The '<em><b>Training</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Training</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRAINING
	 * @model name="training"
	 * @generated
	 * @ordered
	 */
	public static final int TRAINING_VALUE = 8;

	/**
	 * The '<em><b>Slaughter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Slaughter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLAUGHTER
	 * @model name="slaughter"
	 * @generated
	 * @ordered
	 */
	public static final int SLAUGHTER_VALUE = 9;

	/**
	 * The '<em><b>Medical Treatment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Medical Treatment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEDICAL_TREATMENT
	 * @model name="medicalTreatment"
	 * @generated
	 * @ordered
	 */
	public static final int MEDICAL_TREATMENT_VALUE = 10;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 11;

	/**
	 * An array of all the '<em><b>Movement Purpose</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MovementPurpose[] VALUES_ARRAY =
		new MovementPurpose[] {
			SHOW,
			RACE,
			RODEO,
			SALE,
			PET,
			BREEDING,
			FEEDING,
			GRAZING,
			TRAINING,
			SLAUGHTER,
			MEDICAL_TREATMENT,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Movement Purpose</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MovementPurpose> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Movement Purpose</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MovementPurpose get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MovementPurpose result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Movement Purpose</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MovementPurpose getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MovementPurpose result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Movement Purpose</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MovementPurpose get(int value) {
		switch (value) {
			case SHOW_VALUE: return SHOW;
			case RACE_VALUE: return RACE;
			case RODEO_VALUE: return RODEO;
			case SALE_VALUE: return SALE;
			case PET_VALUE: return PET;
			case BREEDING_VALUE: return BREEDING;
			case FEEDING_VALUE: return FEEDING;
			case GRAZING_VALUE: return GRAZING;
			case TRAINING_VALUE: return TRAINING;
			case SLAUGHTER_VALUE: return SLAUGHTER;
			case MEDICAL_TREATMENT_VALUE: return MEDICAL_TREATMENT;
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
	private MovementPurpose(int value, String name, String literal) {
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
	
} //MovementPurpose
