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
 * A representation of the literals of the enumeration '<em><b>Animal Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage#getAnimalType()
 * @model
 * @generated
 */
public enum AnimalType implements Enumerator {
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED(0, "Unspecified", "Unspecified"),

	/**
	 * The '<em><b>Swine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SWINE_VALUE
	 * @generated
	 * @ordered
	 */
	SWINE(2, "Swine", "Swine"),

	/**
	 * The '<em><b>Equine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUINE_VALUE
	 * @generated
	 * @ordered
	 */
	EQUINE(3, "Equine", "Equine"),

	/**
	 * The '<em><b>Caprine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAPRINE_VALUE
	 * @generated
	 * @ordered
	 */
	CAPRINE(4, "Caprine", "Caprine"),

	/**
	 * The '<em><b>Ovine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVINE_VALUE
	 * @generated
	 * @ordered
	 */
	OVINE(0, "Ovine", "Ovine"),

	/**
	 * The '<em><b>Bovine Beef</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOVINE_BEEF_VALUE
	 * @generated
	 * @ordered
	 */
	BOVINE_BEEF(5, "BovineBeef", "BovineBeef"),

	/**
	 * The '<em><b>Bovine Dairy</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOVINE_DAIRY_VALUE
	 * @generated
	 * @ordered
	 */
	BOVINE_DAIRY(6, "BovineDairy", "BovineDairy"),

	/**
	 * The '<em><b>Bovine Bison</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOVINE_BISON_VALUE
	 * @generated
	 * @ordered
	 */
	BOVINE_BISON(7, "BovineBison", "BovineBison");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

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
	public static final int UNSPECIFIED_VALUE = 0;

	/**
	 * The '<em><b>Swine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Swine</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SWINE
	 * @model name="Swine"
	 * @generated
	 * @ordered
	 */
	public static final int SWINE_VALUE = 2;

	/**
	 * The '<em><b>Equine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Equine</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUINE
	 * @model name="Equine"
	 * @generated
	 * @ordered
	 */
	public static final int EQUINE_VALUE = 3;

	/**
	 * The '<em><b>Caprine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Caprine</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAPRINE
	 * @model name="Caprine"
	 * @generated
	 * @ordered
	 */
	public static final int CAPRINE_VALUE = 4;

	/**
	 * The '<em><b>Ovine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ovine</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVINE
	 * @model name="Ovine"
	 * @generated
	 * @ordered
	 */
	public static final int OVINE_VALUE = 0;

	/**
	 * The '<em><b>Bovine Beef</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bovine Beef</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOVINE_BEEF
	 * @model name="BovineBeef"
	 * @generated
	 * @ordered
	 */
	public static final int BOVINE_BEEF_VALUE = 5;

	/**
	 * The '<em><b>Bovine Dairy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bovine Dairy</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOVINE_DAIRY
	 * @model name="BovineDairy"
	 * @generated
	 * @ordered
	 */
	public static final int BOVINE_DAIRY_VALUE = 6;

	/**
	 * The '<em><b>Bovine Bison</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bovine Bison</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOVINE_BISON
	 * @model name="BovineBison"
	 * @generated
	 * @ordered
	 */
	public static final int BOVINE_BISON_VALUE = 7;

	/**
	 * An array of all the '<em><b>Animal Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AnimalType[] VALUES_ARRAY =
		new AnimalType[] {
			UNSPECIFIED,
			SWINE,
			EQUINE,
			CAPRINE,
			OVINE,
			BOVINE_BEEF,
			BOVINE_DAIRY,
			BOVINE_BISON,
		};

	/**
	 * A public read-only list of all the '<em><b>Animal Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AnimalType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Animal Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnimalType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnimalType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Animal Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnimalType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnimalType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Animal Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnimalType get(int value) {
		switch (value) {
			case UNSPECIFIED_VALUE: return UNSPECIFIED;
			case SWINE_VALUE: return SWINE;
			case EQUINE_VALUE: return EQUINE;
			case CAPRINE_VALUE: return CAPRINE;
			case BOVINE_BEEF_VALUE: return BOVINE_BEEF;
			case BOVINE_DAIRY_VALUE: return BOVINE_DAIRY;
			case BOVINE_BISON_VALUE: return BOVINE_BISON;
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
	private AnimalType(int value, String name, String literal) {
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
	
} //AnimalType
