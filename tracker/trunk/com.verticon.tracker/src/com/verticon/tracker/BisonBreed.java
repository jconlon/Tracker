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

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Bison Breed</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage#getBisonBreed()
 * @model
 * @generated
 */
public final class BisonBreed extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The '<em><b>WO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WO_LITERAL
	 * @model literal="WOOD BISON"
	 * @generated
	 * @ordered
	 */
	public static final int WO = 0;

	/**
	 * The '<em><b>PB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PB_LITERAL
	 * @model literal="PLAINS BISON"
	 * @generated
	 * @ordered
	 */
	public static final int PB = 1;

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
	public static final int UNSPECIFIED = 2;

	/**
	 * The '<em><b>WO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WO
	 * @generated
	 * @ordered
	 */
	public static final BisonBreed WO_LITERAL = new BisonBreed(WO, "WO", "WOOD BISON");

	/**
	 * The '<em><b>PB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PB
	 * @generated
	 * @ordered
	 */
	public static final BisonBreed PB_LITERAL = new BisonBreed(PB, "PB", "PLAINS BISON");

	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @generated
	 * @ordered
	 */
	public static final BisonBreed UNSPECIFIED_LITERAL = new BisonBreed(UNSPECIFIED, "Unspecified", "Unspecified");

	/**
	 * An array of all the '<em><b>Bison Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BisonBreed[] VALUES_ARRAY =
		new BisonBreed[] {
			WO_LITERAL,
			PB_LITERAL,
			UNSPECIFIED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Bison Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Bison Breed</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BisonBreed get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BisonBreed result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Bison Breed</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BisonBreed getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BisonBreed result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Bison Breed</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BisonBreed get(int value) {
		switch (value) {
			case WO: return WO_LITERAL;
			case PB: return PB_LITERAL;
			case UNSPECIFIED: return UNSPECIFIED_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BisonBreed(int value, String name, String literal) {
		super(value, name, literal);
	}

} //BisonBreed
