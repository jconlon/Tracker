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
package com.verticon.tracker.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.tracker.AnimalType;
import com.verticon.tracker.EventInclusion;
import com.verticon.tracker.EventType;
import com.verticon.tracker.GenericEventInclusion;
import com.verticon.tracker.Policy;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.PolicyImpl#getIncludedSpecies <em>Included Species</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PolicyImpl#getIncludedEvents <em>Included Events</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PolicyImpl#getIncludedGenericEvents <em>Included Generic Events</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PolicyImpl#isExcludeUnspecifiedEvents <em>Exclude Unspecified Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PolicyImpl extends MinimalEObjectImpl.Container implements Policy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The cached value of the '{@link #getIncludedSpecies() <em>Included Species</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedSpecies()
	 * @generated
	 * @ordered
	 */
	protected EList<AnimalType> includedSpecies;

	/**
	 * The cached value of the '{@link #getIncludedEvents() <em>Included Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<EventInclusion> includedEvents;

	/**
	 * The cached value of the '{@link #getIncludedGenericEvents() <em>Included Generic Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedGenericEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<GenericEventInclusion> includedGenericEvents;

	/**
	 * The default value of the '{@link #isExcludeUnspecifiedEvents() <em>Exclude Unspecified Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExcludeUnspecifiedEvents()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXCLUDE_UNSPECIFIED_EVENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExcludeUnspecifiedEvents() <em>Exclude Unspecified Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExcludeUnspecifiedEvents()
	 * @generated
	 * @ordered
	 */
	protected boolean excludeUnspecifiedEvents = EXCLUDE_UNSPECIFIED_EVENTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnimalType> getIncludedSpecies() {
		if (includedSpecies == null) {
			includedSpecies = new EDataTypeUniqueEList<AnimalType>(AnimalType.class, this, TrackerPackage.POLICY__INCLUDED_SPECIES);
		}
		return includedSpecies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventInclusion> getIncludedEvents() {
		if (includedEvents == null) {
			includedEvents = new EObjectContainmentEList.Resolving<EventInclusion>(EventInclusion.class, this, TrackerPackage.POLICY__INCLUDED_EVENTS);
		}
		return includedEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenericEventInclusion> getIncludedGenericEvents() {
		if (includedGenericEvents == null) {
			includedGenericEvents = new EObjectContainmentEList.Resolving<GenericEventInclusion>(GenericEventInclusion.class, this, TrackerPackage.POLICY__INCLUDED_GENERIC_EVENTS);
		}
		return includedGenericEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExcludeUnspecifiedEvents() {
		return excludeUnspecifiedEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExcludeUnspecifiedEvents(boolean newExcludeUnspecifiedEvents) {
		boolean oldExcludeUnspecifiedEvents = excludeUnspecifiedEvents;
		excludeUnspecifiedEvents = newExcludeUnspecifiedEvents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.POLICY__EXCLUDE_UNSPECIFIED_EVENTS, oldExcludeUnspecifiedEvents, excludeUnspecifiedEvents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean canContain(final EventType eventType, final String ocdId, final AnimalType animalType) {
		//Filter species if there are some in the list.  If not pass all species to the next filter.
		if(!getIncludedSpecies().isEmpty()){
			//Filter out species that are not included 
		        boolean result = false;
			for (AnimalType includedAnimalType : getIncludedSpecies()) {
				if(animalType==includedAnimalType){
		                        result=true;
					break;
				}
			}
		        if(!result){
		                //There was a list of included species but this one was not in it.
				return Boolean.FALSE;
		        }
		}
		
		//Filter genericEvents
		if(ocdId !=null){
		        // If the includedGeneric list is empty 
		       if(getIncludedGenericEvents().isEmpty()){
			  if(isExcludeUnspecifiedEvents()){
				//block all Unspecified GenericEvents.
				return Boolean.FALSE;
			  }
			  //pass all Unspecified GenericEvents.
		           return Boolean.TRUE;
		       }
		      
		        // If there are includedGeneric events in the list.  
		        // See if the GenericEvent is in the list.  Pass it if it has there is an species match
			for (GenericEventInclusion genericEventInclusion : getIncludedGenericEvents()) {
				if(genericEventInclusion.getOcd().getID().equals(ocdId)){
					for (AnimalType includedAnimalType : genericEventInclusion.getSpecies()) {
						if(animalType==includedAnimalType){
							return Boolean.TRUE;
						}
					}
		                        //There was a ocdId match but no animal
					return Boolean.FALSE;
				}
			}
		        //There was no match in the included list pass it.
		}else if(!getIncludedEvents().isEmpty()){
			//Filter events
			for (EventInclusion eventInclusion : getIncludedEvents()) {
				//Find the Event
				for (EventType includedEventType : eventInclusion.getEvent()) {
					if(eventType==includedEventType){
						//Find the animal
						for (AnimalType includedAnimalType : eventInclusion.getSpecies()) {
							if(animalType==includedAnimalType){
								return Boolean.TRUE;
							}
						}
						return Boolean.FALSE;
					}
				}
			}
		}
		//Unspecified Event
		 if(isExcludeUnspecifiedEvents()){
				//block all Unspecified GenericEvents.
				return Boolean.FALSE;
		}
		//pass all Unspecified GenericEvents.
		return Boolean.TRUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.POLICY__INCLUDED_EVENTS:
				return ((InternalEList<?>)getIncludedEvents()).basicRemove(otherEnd, msgs);
			case TrackerPackage.POLICY__INCLUDED_GENERIC_EVENTS:
				return ((InternalEList<?>)getIncludedGenericEvents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.POLICY__INCLUDED_SPECIES:
				return getIncludedSpecies();
			case TrackerPackage.POLICY__INCLUDED_EVENTS:
				return getIncludedEvents();
			case TrackerPackage.POLICY__INCLUDED_GENERIC_EVENTS:
				return getIncludedGenericEvents();
			case TrackerPackage.POLICY__EXCLUDE_UNSPECIFIED_EVENTS:
				return isExcludeUnspecifiedEvents();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.POLICY__INCLUDED_SPECIES:
				getIncludedSpecies().clear();
				getIncludedSpecies().addAll((Collection<? extends AnimalType>)newValue);
				return;
			case TrackerPackage.POLICY__INCLUDED_EVENTS:
				getIncludedEvents().clear();
				getIncludedEvents().addAll((Collection<? extends EventInclusion>)newValue);
				return;
			case TrackerPackage.POLICY__INCLUDED_GENERIC_EVENTS:
				getIncludedGenericEvents().clear();
				getIncludedGenericEvents().addAll((Collection<? extends GenericEventInclusion>)newValue);
				return;
			case TrackerPackage.POLICY__EXCLUDE_UNSPECIFIED_EVENTS:
				setExcludeUnspecifiedEvents((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.POLICY__INCLUDED_SPECIES:
				getIncludedSpecies().clear();
				return;
			case TrackerPackage.POLICY__INCLUDED_EVENTS:
				getIncludedEvents().clear();
				return;
			case TrackerPackage.POLICY__INCLUDED_GENERIC_EVENTS:
				getIncludedGenericEvents().clear();
				return;
			case TrackerPackage.POLICY__EXCLUDE_UNSPECIFIED_EVENTS:
				setExcludeUnspecifiedEvents(EXCLUDE_UNSPECIFIED_EVENTS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.POLICY__INCLUDED_SPECIES:
				return includedSpecies != null && !includedSpecies.isEmpty();
			case TrackerPackage.POLICY__INCLUDED_EVENTS:
				return includedEvents != null && !includedEvents.isEmpty();
			case TrackerPackage.POLICY__INCLUDED_GENERIC_EVENTS:
				return includedGenericEvents != null && !includedGenericEvents.isEmpty();
			case TrackerPackage.POLICY__EXCLUDE_UNSPECIFIED_EVENTS:
				return excludeUnspecifiedEvents != EXCLUDE_UNSPECIFIED_EVENTS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (includedSpecies: ");
		result.append(includedSpecies);
		result.append(", excludeUnspecifiedEvents: ");
		result.append(excludeUnspecifiedEvents);
		result.append(')');
		return result.toString();
	}

} //PolicyImpl
