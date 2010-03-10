/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
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
 * A representation of the literals of the enumeration '<em><b>Event Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage#getEventType()
 * @model
 * @generated
 */
public enum EventType implements Enumerator {
	/**
	 * The '<em><b>Tag Allocated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TAG_ALLOCATED_VALUE
	 * @generated
	 * @ordered
	 */
	TAG_ALLOCATED(0, "TagAllocated", "TagAllocated"),

	/**
	 * The '<em><b>Tag Applied</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TAG_APPLIED_VALUE
	 * @generated
	 * @ordered
	 */
	TAG_APPLIED(1, "TagApplied", "TagApplied"),

	/**
	 * The '<em><b>Moved In</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVED_IN_VALUE
	 * @generated
	 * @ordered
	 */
	MOVED_IN(2, "MovedIn", "MovedIn"),

	/**
	 * The '<em><b>Moved Out</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVED_OUT_VALUE
	 * @generated
	 * @ordered
	 */
	MOVED_OUT(3, "MovedOut", "MovedOut"),

	/**
	 * The '<em><b>Exported</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPORTED_VALUE
	 * @generated
	 * @ordered
	 */
	EXPORTED(4, "Exported", "Exported"),

	/**
	 * The '<em><b>ICVI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ICVI_VALUE
	 * @generated
	 * @ordered
	 */
	ICVI(5, "ICVI", "ICVI"),

	/**
	 * The '<em><b>Died</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIED_VALUE
	 * @generated
	 * @ordered
	 */
	DIED(6, "Died", "Died"),

	/**
	 * The '<em><b>Animal Missing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANIMAL_MISSING_VALUE
	 * @generated
	 * @ordered
	 */
	ANIMAL_MISSING(7, "AnimalMissing", "AnimalMissing"),

	/**
	 * The '<em><b>Slaughtered</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLAUGHTERED_VALUE
	 * @generated
	 * @ordered
	 */
	SLAUGHTERED(8, "Slaughtered", "Slaughtered"),

	/**
	 * The '<em><b>Sighting</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIGHTING_VALUE
	 * @generated
	 * @ordered
	 */
	SIGHTING(9, "Sighting", "Sighting"),

	/**
	 * The '<em><b>Tag Retired</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TAG_RETIRED_VALUE
	 * @generated
	 * @ordered
	 */
	TAG_RETIRED(10, "TagRetired", "TagRetired"),

	/**
	 * The '<em><b>Weigh In</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEIGH_IN_VALUE
	 * @generated
	 * @ordered
	 */
	WEIGH_IN(11, "WeighIn", "WeighIn"),

	/**
	 * The '<em><b>Generic Event</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERIC_EVENT_VALUE
	 * @generated
	 * @ordered
	 */
	GENERIC_EVENT(12, "GenericEvent", "GenericEvent"), /**
	 * The '<em><b>Lost Tag</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOST_TAG_VALUE
	 * @generated
	 * @ordered
	 */
	LOST_TAG(13, "LostTag", "LostTag"), /**
	 * The '<em><b>Replaced Tag</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPLACED_TAG_VALUE
	 * @generated
	 * @ordered
	 */
	REPLACED_TAG(14, "ReplacedTag", "ReplacedTag"), /**
	 * The '<em><b>Imported</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPORTED_VALUE
	 * @generated
	 * @ordered
	 */
	IMPORTED(15, "Imported", "Imported");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The '<em><b>Tag Allocated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tag Allocated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TAG_ALLOCATED
	 * @model name="TagAllocated"
	 * @generated
	 * @ordered
	 */
	public static final int TAG_ALLOCATED_VALUE = 0;

	/**
	 * The '<em><b>Tag Applied</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tag Applied</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TAG_APPLIED
	 * @model name="TagApplied"
	 * @generated
	 * @ordered
	 */
	public static final int TAG_APPLIED_VALUE = 1;

	/**
	 * The '<em><b>Moved In</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Moved In</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOVED_IN
	 * @model name="MovedIn"
	 * @generated
	 * @ordered
	 */
	public static final int MOVED_IN_VALUE = 2;

	/**
	 * The '<em><b>Moved Out</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Moved Out</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOVED_OUT
	 * @model name="MovedOut"
	 * @generated
	 * @ordered
	 */
	public static final int MOVED_OUT_VALUE = 3;

	/**
	 * The '<em><b>Exported</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exported</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPORTED
	 * @model name="Exported"
	 * @generated
	 * @ordered
	 */
	public static final int EXPORTED_VALUE = 4;

	/**
	 * The '<em><b>ICVI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ICVI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ICVI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ICVI_VALUE = 5;

	/**
	 * The '<em><b>Died</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Died</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIED
	 * @model name="Died"
	 * @generated
	 * @ordered
	 */
	public static final int DIED_VALUE = 6;

	/**
	 * The '<em><b>Animal Missing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Animal Missing</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANIMAL_MISSING
	 * @model name="AnimalMissing"
	 * @generated
	 * @ordered
	 */
	public static final int ANIMAL_MISSING_VALUE = 7;

	/**
	 * The '<em><b>Slaughtered</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Slaughtered</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLAUGHTERED
	 * @model name="Slaughtered"
	 * @generated
	 * @ordered
	 */
	public static final int SLAUGHTERED_VALUE = 8;

	/**
	 * The '<em><b>Sighting</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sighting</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIGHTING
	 * @model name="Sighting"
	 * @generated
	 * @ordered
	 */
	public static final int SIGHTING_VALUE = 9;

	/**
	 * The '<em><b>Tag Retired</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tag Retired</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TAG_RETIRED
	 * @model name="TagRetired"
	 * @generated
	 * @ordered
	 */
	public static final int TAG_RETIRED_VALUE = 10;

	/**
	 * The '<em><b>Weigh In</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Weigh In</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEIGH_IN
	 * @model name="WeighIn"
	 * @generated
	 * @ordered
	 */
	public static final int WEIGH_IN_VALUE = 11;

	/**
	 * The '<em><b>Generic Event</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Generic Event</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERIC_EVENT
	 * @model name="GenericEvent"
	 * @generated
	 * @ordered
	 */
	public static final int GENERIC_EVENT_VALUE = 12;

	/**
	 * The '<em><b>Lost Tag</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lost Tag</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOST_TAG
	 * @model name="LostTag"
	 * @generated
	 * @ordered
	 */
	public static final int LOST_TAG_VALUE = 13;

	/**
	 * The '<em><b>Replaced Tag</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Replaced Tag</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPLACED_TAG
	 * @model name="ReplacedTag"
	 * @generated
	 * @ordered
	 */
	public static final int REPLACED_TAG_VALUE = 14;

	/**
	 * The '<em><b>Imported</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Imported</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMPORTED
	 * @model name="Imported"
	 * @generated
	 * @ordered
	 */
	public static final int IMPORTED_VALUE = 15;

	/**
	 * An array of all the '<em><b>Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EventType[] VALUES_ARRAY =
		new EventType[] {
			TAG_ALLOCATED,
			TAG_APPLIED,
			MOVED_IN,
			MOVED_OUT,
			EXPORTED,
			ICVI,
			DIED,
			ANIMAL_MISSING,
			SLAUGHTERED,
			SIGHTING,
			TAG_RETIRED,
			WEIGH_IN,
			GENERIC_EVENT,
			LOST_TAG,
			REPLACED_TAG,
			IMPORTED,
		};

	/**
	 * A public read-only list of all the '<em><b>Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EventType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType get(int value) {
		switch (value) {
			case TAG_ALLOCATED_VALUE: return TAG_ALLOCATED;
			case TAG_APPLIED_VALUE: return TAG_APPLIED;
			case MOVED_IN_VALUE: return MOVED_IN;
			case MOVED_OUT_VALUE: return MOVED_OUT;
			case EXPORTED_VALUE: return EXPORTED;
			case ICVI_VALUE: return ICVI;
			case DIED_VALUE: return DIED;
			case ANIMAL_MISSING_VALUE: return ANIMAL_MISSING;
			case SLAUGHTERED_VALUE: return SLAUGHTERED;
			case SIGHTING_VALUE: return SIGHTING;
			case TAG_RETIRED_VALUE: return TAG_RETIRED;
			case WEIGH_IN_VALUE: return WEIGH_IN;
			case GENERIC_EVENT_VALUE: return GENERIC_EVENT;
			case LOST_TAG_VALUE: return LOST_TAG;
			case REPLACED_TAG_VALUE: return REPLACED_TAG;
			case IMPORTED_VALUE: return IMPORTED;
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
	private EventType(int value, String name, String literal) {
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
	
} //EventType
