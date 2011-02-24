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

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.util.Age;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Animal#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSex <em>Sex</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getTags <em>Tags</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSpecies <em>Species</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getBreed <em>Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSexCode <em>Sex Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSpeciesCode <em>Species Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getId <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getLastEventDateTime <em>Last Event Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getDam <em>Dam</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getSire <em>Sire</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getWeight <em>Weight</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getWeightGainPerDay <em>Weight Gain Per Day</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getVisualID <em>Visual ID</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getAgeInDays <em>Age In Days</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getAlternativeID <em>Alternative ID</em>}</li>
 *   <li>{@link com.verticon.tracker.Animal#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getAnimal()
 * @model abstract="true"
 * @generated
 */
public interface Animal extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Date</em>' attribute.
	 * @see #setBirthDate(Date)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_BirthDate()
	 * @model
	 * @generated
	 */
	Date getBirthDate();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getBirthDate <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Date</em>' attribute.
	 * @see #getBirthDate()
	 * @generated
	 */
	void setBirthDate(Date value);

	/**
	 * Returns the value of the '<em><b>Sex</b></em>' attribute.
	 * The default value is <code>"Unspecified"</code>.
	 * The literals are from the enumeration {@link com.verticon.tracker.Sex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sex</em>' attribute.
	 * @see com.verticon.tracker.Sex
	 * @see #setSex(Sex)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Sex()
	 * @model default="Unspecified"
	 * @generated
	 */
	Sex getSex();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sex</em>' attribute.
	 * @see com.verticon.tracker.Sex
	 * @see #getSex()
	 * @generated
	 */
	void setSex(Sex value);

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.Tag}.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.Tag#getAnimal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Tags()
	 * @see com.verticon.tracker.Tag#getAnimal
	 * @model opposite="Animal" containment="true" required="true"
	 * @generated
	 */
	EList<Tag> getTags();

	/**
	 * Returns the value of the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Species</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Species</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Species()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getSpecies();

	/**
	 * Returns the value of the '<em><b>Breed</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Breed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Breed</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Breed()
	 * @model default="" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getBreed();

	/**
	 * Returns the value of the '<em><b>Sex Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sex Code</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_SexCode()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getSexCode();

	/**
	 * Returns the value of the '<em><b>Species Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Species Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Species Code</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_SpeciesCode()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getSpeciesCode();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Id()
	 * @model id="true" required="true" volatile="true" derived="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(String)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Last Event Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Event Date Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Event Date Time</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_LastEventDateTime()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Date getLastEventDateTime();

	/**
	 * Returns the value of the '<em><b>Dam</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dam</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dam</em>' reference.
	 * @see #setDam(Animal)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Dam()
	 * @model
	 * @generated
	 */
	Animal getDam();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getDam <em>Dam</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dam</em>' reference.
	 * @see #getDam()
	 * @generated
	 */
	void setDam(Animal value);

	/**
	 * Returns the value of the '<em><b>Sire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sire</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sire</em>' reference.
	 * @see #setSire(Animal)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Sire()
	 * @model
	 * @generated
	 */
	Animal getSire();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getSire <em>Sire</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sire</em>' reference.
	 * @see #getSire()
	 * @generated
	 */
	void setSire(Animal value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Weight()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Double getWeight();

	/**
	 * Returns the value of the '<em><b>Weight Gain Per Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight Gain Per Day</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight Gain Per Day</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_WeightGainPerDay()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Double getWeightGainPerDay();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.tracker.AnimalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.verticon.tracker.AnimalType
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	AnimalType getType();

	/**
	 * Returns the value of the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visual ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visual ID</em>' attribute.
	 * @see #isSetVisualID()
	 * @see #unsetVisualID()
	 * @see #setVisualID(String)
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_VisualID()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVisualID();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Animal#getVisualID <em>Visual ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual ID</em>' attribute.
	 * @see #isSetVisualID()
	 * @see #unsetVisualID()
	 * @see #getVisualID()
	 * @generated
	 */
	void setVisualID(String value);

	/**
	 * Unsets the value of the '{@link com.verticon.tracker.Animal#getVisualID <em>Visual ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisualID()
	 * @see #getVisualID()
	 * @see #setVisualID(String)
	 * @generated
	 */
	void unsetVisualID();

	/**
	 * Returns whether the value of the '{@link com.verticon.tracker.Animal#getVisualID <em>Visual ID</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visual ID</em>' attribute is set.
	 * @see #unsetVisualID()
	 * @see #getVisualID()
	 * @see #setVisualID(String)
	 * @generated
	 */
	boolean isSetVisualID();

	/**
	 * Returns the value of the '<em><b>Age In Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age In Days</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age In Days</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_AgeInDays()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getAgeInDays();

	/**
	 * Returns the value of the '<em><b>Alternative ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative ID</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_AlternativeID()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getAlternativeID();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getAnimal_Location()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getLocation();

	/**
	 * <!-- begin-user-doc -->
	 * @deprecated use eventHistory() instead
	 * 
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	@Deprecated
	EList<Event> allEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model eventTemplateMany="false"
	 * @generated
	 */
	void addTemplate(EList<Event> eventTemplate);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(mostCurrentEvent ==null){\n\t\t\t mostCurrentEvent = findMostCurrentEvent();\n}\n return mostCurrentEvent!=null? mostCurrentEvent.getTag(): \n\t    \tthis.tags.isEmpty()?null:tags.get(0);'"
	 * @generated
	 */
	Tag activeTag();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All the events associated with this animal.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return allEvents();'"
	 * @generated
	 */
	EList<Event> eventHistory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The most recent WeighIn event for this animal.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='WeighIn lastWeighIn = null;\n\t\tif(!eventHistory().isEmpty()){\n\t\t\tCollectionFilter<Event> weighInsProducer = new CollectionFilter<Event>();\n\t\t\tweighInsProducer.addFilter(TrackerUtils.weighInFilterCriteria);\n\t\t\tList<Event> weighIns = new ArrayList<Event>(weighInsProducer.filterCopy(eventHistory()));\n\t\t\tif(weighIns.isEmpty()){\n\t\t\t\treturn null;\n\t\t\t}\n\t\t\tCollections.sort(weighIns, TrackerUtils.DATE_COMPARATOR);\n\t\t\tlastWeighIn = (WeighIn) weighIns.get(weighIns.size()-1);\n\t\t}\n\t\treturn lastWeighIn;'"
	 * @generated
	 */
	WeighIn lastWeighIn();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="com.verticon.tracker.Age"
	 * @generated
	 */
	Age getAge();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" ocdIdDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(eContainer instanceof <%Premises%>){\n\treturn ((Premises)eContainer).canContain(\n\t\t\teventType, ocdId, getType());\n}\nreturn Boolean.TRUE;'"
	 * @generated
	 */
	boolean canContain(EventType eventType, String ocdId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The most recent event for this animal.
	 * <!-- end-model-doc -->
	 * @model nameDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Event result = null;\n\t\tif(!eventHistory().isEmpty() && type!=null){\n\t\t\tCollectionFilter<Event> eventsProducer = new CollectionFilter<Event>();\n\t\t\teventsProducer.addFilter(TrackerUtils.createFilterCriteria(type, name));\n\t\t\tList<Event> events = new ArrayList<Event>(eventsProducer.filterCopy(eventHistory()));\n\t\t\tif(events.isEmpty()){\n\t\t\t\treturn null;\n\t\t\t}\n\t\t\tCollections.sort(events, TrackerUtils.DATE_COMPARATOR);\n\t\t\tresult = events.get(events.size()-1);\n\t\t}\nreturn result;'"
	 * @generated
	 */
	Event lastEvent(EventType type, String name);

} // Animal