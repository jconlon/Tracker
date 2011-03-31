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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Policy#getIncludedSpecies <em>Included Species</em>}</li>
 *   <li>{@link com.verticon.tracker.Policy#getIncludedEvents <em>Included Events</em>}</li>
 *   <li>{@link com.verticon.tracker.Policy#getIncludedGenericEvents <em>Included Generic Events</em>}</li>
 *   <li>{@link com.verticon.tracker.Policy#isExcludeUnspecifiedEvents <em>Exclude Unspecified Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getPolicy()
 * @model
 * @generated
 */
public interface Policy extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Included Species</b></em>' attribute list.
	 * The list contents are of type {@link com.verticon.tracker.AnimalType}.
	 * The literals are from the enumeration {@link com.verticon.tracker.AnimalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Species</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Species</em>' attribute list.
	 * @see com.verticon.tracker.AnimalType
	 * @see com.verticon.tracker.TrackerPackage#getPolicy_IncludedSpecies()
	 * @model
	 * @generated
	 */
	EList<AnimalType> getIncludedSpecies();

	/**
	 * Returns the value of the '<em><b>Included Events</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.EventInclusion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Events</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getPolicy_IncludedEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventInclusion> getIncludedEvents();

	/**
	 * Returns the value of the '<em><b>Included Generic Events</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.GenericEventInclusion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Generic Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Generic Events</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getPolicy_IncludedGenericEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenericEventInclusion> getIncludedGenericEvents();

	/**
	 * Returns the value of the '<em><b>Exclude Unspecified Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclude Unspecified Events</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclude Unspecified Events</em>' attribute.
	 * @see #setExcludeUnspecifiedEvents(boolean)
	 * @see com.verticon.tracker.TrackerPackage#getPolicy_ExcludeUnspecifiedEvents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean isExcludeUnspecifiedEvents();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Policy#isExcludeUnspecifiedEvents <em>Exclude Unspecified Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclude Unspecified Events</em>' attribute.
	 * @see #isExcludeUnspecifiedEvents()
	 * @generated
	 */
	void setExcludeUnspecifiedEvents(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" ocdIdDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='//Filter species if there are some in the list.  If not pass all species to the next filter.\nif(!getIncludedSpecies().isEmpty()){\n\t//Filter out species that are not included \n        boolean result = false;\n\tfor (AnimalType includedAnimalType : getIncludedSpecies()) {\n\t\tif(animalType==includedAnimalType){\n                        result=true;\n\t\t\tbreak;\n\t\t}\n\t}\n        if(!result){\n                //There was a list of included species but this one was not in it.\n\t\treturn Boolean.FALSE;\n        }\n}\n\n//Filter genericEvents\nif(ocdId !=null){\n        // If the includedGeneric list is empty \n       if(getIncludedGenericEvents().isEmpty()){\n\t  if(isExcludeUnspecifiedEvents()){\n\t\t//block all Unspecified GenericEvents.\n\t\treturn Boolean.FALSE;\n\t  }\n\t  //pass all Unspecified GenericEvents.\n           return Boolean.TRUE;\n       }\n      \n        // If there are includedGeneric events in the list.  \n        // See if the GenericEvent is in the list.  Pass it if it has there is an species match\n\tfor (GenericEventInclusion genericEventInclusion : getIncludedGenericEvents()) {\n\t\tif(genericEventInclusion.getOcd().getID().equals(ocdId)){\n\t\t\tfor (AnimalType includedAnimalType : genericEventInclusion.getSpecies()) {\n\t\t\t\tif(animalType==includedAnimalType){\n\t\t\t\t\treturn Boolean.TRUE;\n\t\t\t\t}\n\t\t\t}\n                        //There was a ocdId match but no animal\n\t\t\treturn Boolean.FALSE;\n\t\t}\n\t}\n        //There was no match in the included list pass it.\n}else if(!getIncludedEvents().isEmpty()){\n\t//Filter events\n\tfor (EventInclusion eventInclusion : getIncludedEvents()) {\n\t\t//Find the Event\n\t\tfor (EventType includedEventType : eventInclusion.getEvent()) {\n\t\t\tif(eventType==includedEventType){\n\t\t\t\t//Find the animal\n\t\t\t\tfor (AnimalType includedAnimalType : eventInclusion.getSpecies()) {\n\t\t\t\t\tif(animalType==includedAnimalType){\n\t\t\t\t\t\treturn Boolean.TRUE;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn Boolean.FALSE;\n\t\t\t}\n\t\t}\n\t}\n}\n//Unspecified Event\n if(isExcludeUnspecifiedEvents()){\n\t\t//block all Unspecified GenericEvents.\n\t\treturn Boolean.FALSE;\n}\n//pass all Unspecified GenericEvents.\nreturn Boolean.TRUE;'"
	 * @generated
	 */
	boolean canContain(EventType eventType, String ocdId, AnimalType animalType);

} // Policy
