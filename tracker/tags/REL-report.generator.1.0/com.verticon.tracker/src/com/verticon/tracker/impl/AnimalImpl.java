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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.impl.StringSegment;

import com.verticon.location.util.LocationValidator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.EventType;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Position;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Sex;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.TrackerPlugin;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.util.Age;
import com.verticon.tracker.util.CollectionFilter;
import com.verticon.tracker.util.EventHistoryAdapterFactory;
import com.verticon.tracker.util.Species;
import com.verticon.tracker.util.TrackerSwitch;
import com.verticon.tracker.util.TrackerUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSex <em>Sex</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSpecies <em>Species</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getBreed <em>Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSexCode <em>Sex Code</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSpeciesCode <em>Species Code</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getLastEventDateTime <em>Last Event Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getDam <em>Dam</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSire <em>Sire</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getWeightGainPerDay <em>Weight Gain Per Day</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getVisualID <em>Visual ID</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getAgeInDays <em>Age In Days</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getAlternativeID <em>Alternative ID</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnimalImpl extends MinimalEObjectImpl.Container implements Animal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";
	
	
	/**
	 * Used for copying eventTemplate events.
	 */
	private static final Copier copier = new Copier();
	
	/**
	 * Holds a copy of the old id, so it can be sent in notifications.
	 */
	private String idCache;
	
	/**
	 * The default value of the '{@link #getBirthDate() <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date BIRTH_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthDate() <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDate()
	 * @generated
	 * @ordered
	 */
	protected Date birthDate = BIRTH_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSex() <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSex()
	 * @generated
	 * @ordered
	 */
	protected static final Sex SEX_EDEFAULT = Sex.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getSex() <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSex()
	 * @generated
	 * @ordered
	 */
	protected Sex sex = SEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> tags;

	/**
	 * The default value of the '{@link #getSpecies() <em>Species</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecies()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIES_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getBreed() <em>Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreed()
	 * @generated
	 * @ordered
	 */
	protected static final String BREED_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSexCode() <em>Sex Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSexCode()
	 * @generated
	 * @ordered
	 */
	protected static final String SEX_CODE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSpeciesCode() <em>Species Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeciesCode()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIES_CODE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected String comments = COMMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastEventDateTime() <em>Last Event Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastEventDateTime()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_EVENT_DATE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDam() <em>Dam</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDam()
	 * @generated
	 * @ordered
	 */
	protected Animal dam;

	/**
	 * The cached value of the '{@link #getSire() <em>Sire</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSire()
	 * @generated
	 * @ordered
	 */
	protected Animal sire;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final Double WEIGHT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getWeightGainPerDay() <em>Weight Gain Per Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeightGainPerDay()
	 * @generated
	 * @ordered
	 */
	protected static final Double WEIGHT_GAIN_PER_DAY_EDEFAULT = null;

	
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final AnimalType TYPE_EDEFAULT = AnimalType.UNSPECIFIED;


	/**
	 * The default value of the '{@link #getVisualID() <em>Visual ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualID()
	 * @generated
	 * @ordered
	 */
	protected static final String VISUAL_ID_EDEFAULT = null;


	/**
	 * The cached value of the '{@link #getVisualID() <em>Visual ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualID()
	 * @generated
	 * @ordered
	 */
	protected String visualID = VISUAL_ID_EDEFAULT;


	/**
	 * This is true if the Visual ID attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean visualIDESet;


	/**
	 * The default value of the '{@link #getAgeInDays() <em>Age In Days</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgeInDays()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_IN_DAYS_EDEFAULT = 0;


	/**
	 * The default value of the '{@link #getAlternativeID() <em>Alternative ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternativeID()
	 * @generated
	 * @ordered
	 */
	protected static final String ALTERNATIVE_ID_EDEFAULT = null;


	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.ANIMAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBirthDateGen(Date newBirthDate) {
		Date oldBirthDate = birthDate;
		birthDate = newBirthDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__BIRTH_DATE, oldBirthDate, birthDate));
	}
	private final static Calendar OLDEST_VALID_DATE = Calendar.getInstance();
	static{
		OLDEST_VALID_DATE.set(Calendar.YEAR, 1900);
	}
	/**
	 * Extends functionality of generated setBirthDate so the user can null the date.
	 * @generated NOT
	 */
	/**
	 * Extends functionality of generated setBirthDate so the user can null the date.
	 * @generated NOT
	 */
	public void setBirthDate(Date newBirthDate) {
		if(OLDEST_VALID_DATE.getTime().before(newBirthDate)){
			setBirthDateGen(newBirthDate);
		}else{
		    setBirthDateGen(null);
		}
		int oldAgeInDays = getAgeInDays();
		calculateAge();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__AGE_IN_DAYS, 
					oldAgeInDays, getAgeInDays()));
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSex(Sex newSex) {
		Sex oldSex = sex;
		sex = newSex == null ? SEX_EDEFAULT : newSex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__SEX, oldSex, sex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentWithInverseEList.Resolving<Tag>(Tag.class, this, TrackerPackage.ANIMAL__TAGS, TrackerPackage.TAG__ANIMAL);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSpecies(){
		return getSpeciesEnum().literal();
	}
	

	/**
	 * @generated NOT
	 * @return species
	 */
	public abstract Species getSpeciesEnum();



	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract String getBreed();

	
	 /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	 public Age getAge() {
		 return birthDate==null?null:new Age(birthDate);
	 }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean canContain(EventType eventType, String ocdId) {
		if(eContainer instanceof Premises){
			return ((Premises)eContainer).canContain(
					eventType, ocdId, getType());
		}
		return Boolean.TRUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event lastEvent(EventType type, String name) {
		Event result = null;
				if(!eventHistory().isEmpty() && type!=null){
					CollectionFilter<Event> eventsProducer = new CollectionFilter<Event>();
					eventsProducer.addFilter(TrackerUtils.createFilterCriteria(type, name));
					List<Event> events = new ArrayList<Event>(eventsProducer.filterCopy(eventHistory()));
					if(events.isEmpty()){
						return null;
					}
					Collections.sort(events, TrackerUtils.DATE_COMPARATOR);
					result = events.get(events.size()-1);
				}
		return result;
	}

	private String resolvedLocation = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * Operation finds the name of the location of the animal.  If the getLocation() is
	 * a urn or a point then it calls the LocationService for resolution.  If it finds
	 * a value it will set the resolvedLocation variable.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String findLocationName() {
		String oldLocation = getLocation();
		String newLocation= null;
		if(oldLocation!=null){
			resolvedLocation=null;
			String location = getLocation();

			if(location.startsWith("urn:")){
				resolvedLocation = TrackerPlugin.getDefault().name(location);
			}else if(location.matches(LocationValidator.COORDINATE_REGEX)){
				resolvedLocation = TrackerPlugin.getDefault().locate(location);
			}
		    newLocation = getLocation();
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(
						this, Notification.SET, TrackerPackage.ANIMAL__LOCATION, oldLocation, newLocation));
		}
		for (Event event : eventHistory()) {
			event.findPublisherName();
		}
		return newLocation;		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.ANIMAL__TAGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTags()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the sexcode from the sex enumeration name.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSexCode() {
		if(sex==null){
			return "";
		}
		if(sex==Sex.UNSPECIFIED_LITERAL){
			return "";
		}
	
		return sex.getName();
	}



	/**
	 * <!-- begin-user-doc -->
	 * Get the speciescode from the species enumeration name.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSpeciesCode() {
		return getSpeciesEnum().name();
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getId() {
		String result = "";
		if (tags==null || tags.isEmpty()){
			//no events no IdNumber
		} else if (tags.size()==1){
			result = tags.get(0).getId();
		} else if(tags.size()>1){
			Tag tag = activeTag();
			result = tag!=null? tag.getId():tags.get(0).getId();
		}
		return result==null?"":result;
	}

/**
	 * <!-- begin-user-doc -->
	 * Id is an ID, it is volatile=true, transient=false, settable=true 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setId(String newId) {
		if (eNotificationRequired()){
			eNotify(
					new ENotificationImpl(
							this, Notification.SET, 
							TrackerPackage.ANIMAL__ID, 
							idCache, 
							newId));
		}
		idCache =newId;
		
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComments() {
		return comments;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(String newComments) {
		String oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__COMMENTS, oldComments, comments));
	}


	/**
	 * Calculated values should fire notifications. Changing attributes on an event
	 * will fire notifications that are detected in the AnimalEventHistoryAdapter
	 * that was added through the EventHistoryAdapterFactory which was added
	 * in the allEvents method
	 * @param n Notification forwarded from the AnimalEventHistoryAdapter 
	 * 
	 * @see #allEvents()
	 * @see EventHistoryAdapterFactory
	 * @see AnimalEventHistoryAdapter
	 * @see #getWeight()
	 * @see #getWeightGainPerDay()
	 * @see #getLastEventDateTime()
	 */
	  void forward(Notification n){
		  if(n.getNotifier() instanceof Event){
			  switch (n.getFeatureID(Event.class)) {
			  case TrackerPackage.EVENT__DATE_TIME:
				  mostCurrentEvent = (Event) n.getNotifier();
				  setMostCurrentWeighIn();
				 
				  eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__LAST_EVENT_DATE_TIME, n.getOldValue(), n.getNewValue())); 
				  break;
			  case TrackerPackage.WEIGH_IN__WEIGHT_GAIN_PER_DAY:
				  eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__WEIGHT_GAIN_PER_DAY,  null, getWeightGainPerDay())); 
				  break;
			  case TrackerPackage.WEIGH_IN__WEIGHT:
				  eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__WEIGHT, n.getOldValue(), n.getNewValue())); 
				  break;
			  default:

				  break;
			  }
		}else if (n.getNotifier() instanceof Tag){
			switch (n.getFeatureID(Tag.class)) {
			  case TrackerPackage.TAG__EVENTS:
				  //LastDateTime
				  Date oldLastDateTime = mostCurrentEvent!=null?mostCurrentEvent.getDateTime():null;
				  mostCurrentEvent =  findMostCurrentEvent();
				  if(mostCurrentEvent==null){
					  return;
				  }
				  //Weight
				  Double oldWeight = mostCurrentWeighIn==null ? null: mostCurrentWeighIn.getWeight();
				  Double oldWeightGain = mostCurrentWeighIn==null ? null: mostCurrentWeighIn.getWeightGainPerDay();
//				  mostCurrentWeighIn = mostCurrentEvent instanceof WeighIn? 
//						  (WeighIn)mostCurrentEvent: lastWeighIn();
						  setMostCurrentWeighIn();

				  eNotify(new ENotificationImpl(this, Notification.SET, 
						  TrackerPackage.ANIMAL__LAST_EVENT_DATE_TIME, oldLastDateTime, mostCurrentEvent.getDateTime())); 
				  eNotify(new ENotificationImpl(this, Notification.SET, 
						  TrackerPackage.ANIMAL__WEIGHT, 
						  oldWeight, 
						  mostCurrentWeighIn==null ? null: mostCurrentWeighIn.getWeight()));  
				  eNotify(new ENotificationImpl(this, Notification.SET, 
						  TrackerPackage.ANIMAL__WEIGHT_GAIN_PER_DAY, 
						  oldWeightGain, 
						  mostCurrentWeighIn==null ? null: mostCurrentWeighIn.getWeightGainPerDay())); 
				  
				  break;
			  default:
				  break;
			  }
		}
	  }

	//TODO refactor this into lastWeighIn
	private void setMostCurrentWeighIn() {
		if(mostCurrentEvent instanceof WeighIn){
			  if( ((WeighIn)mostCurrentEvent).getWeight()!=null){
				  mostCurrentWeighIn = (WeighIn)mostCurrentEvent;
				  return;
			  }
		}
		mostCurrentWeighIn =	lastWeighIn();
	}
	
	 /**
	  *  MostCurrentEvent of this animal is
	  *  used contains the active tag and the lastEventDateTime. It is calculated on initial
	  *  startup and on notification processing.
	  *  @see #getLastEventDateTime()
	  *  @see #activeTag()
	  */
	 private Event mostCurrentEvent = null;
	 
 /**
	 * <!-- begin-user-doc -->
	 * Refactored to eliminate the dynamic processing of the event Tree.
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Date getLastEventDateTime() {
		if(mostCurrentEvent == null){
			mostCurrentEvent =  findMostCurrentEvent();
		}
		return mostCurrentEvent != null ? mostCurrentEvent.getDateTime():null;
	}


/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animal getDam() {
		if (dam != null && dam.eIsProxy()) {
			InternalEObject oldDam = (InternalEObject)dam;
			dam = (Animal)eResolveProxy(oldDam);
			if (dam != oldDam) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.ANIMAL__DAM, oldDam, dam));
			}
		}
		return dam;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animal basicGetDam() {
		return dam;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDam(Animal newDam) {
		Animal oldDam = dam;
		dam = newDam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__DAM, oldDam, dam));
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animal getSire() {
		if (sire != null && sire.eIsProxy()) {
			InternalEObject oldSire = (InternalEObject)sire;
			sire = (Animal)eResolveProxy(oldSire);
			if (sire != oldSire) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.ANIMAL__SIRE, oldSire, sire));
			}
		}
		return sire;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animal basicGetSire() {
		return sire;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSire(Animal newSire) {
		Animal oldSire = sire;
		sire = newSire;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__SIRE, oldSire, sire));
	}

	
	private WeighIn mostCurrentWeighIn = null;
	
   /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Double getWeight() {
		if(mostCurrentWeighIn == null){
			mostCurrentWeighIn = lastWeighIn();
		}
		return mostCurrentWeighIn==null ? null: mostCurrentWeighIn.getWeight();
	}
	
	 /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Double getWeightGainPerDay() {
		if(mostCurrentWeighIn == null){
			mostCurrentWeighIn = lastWeighIn();
		}
		return mostCurrentWeighIn==null?null: mostCurrentWeighIn.getWeightGainPerDay();
	}

   /**
	 * <!-- begin-user-doc -->
	 * Overrided by subclasses
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AnimalType getType() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisualID() {
		return visualID;
	}

			/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualID(String newVisualID) {
		String oldVisualID = visualID;
		visualID = newVisualID;
		boolean oldVisualIDESet = visualIDESet;
		visualIDESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__VISUAL_ID, oldVisualID, visualID, !oldVisualIDESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisualID() {
		String oldVisualID = visualID;
		boolean oldVisualIDESet = visualIDESet;
		visualID = VISUAL_ID_EDEFAULT;
		visualIDESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TrackerPackage.ANIMAL__VISUAL_ID, oldVisualID, VISUAL_ID_EDEFAULT, oldVisualIDESet));
	}

			/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisualID() {
		return visualIDESet;
	}
	int ageInDays = 0;
	long millisToReCalculateAge = 0;

	private void calculateAge() {
		if (birthDate == null) {
			millisToReCalculateAge = 0;
			ageInDays = 0;
		} else {
			// Get a calendar and set it to Midnight
			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 24);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.MILLISECOND, 0);
			millisToReCalculateAge = c.getTimeInMillis();
			Age age = new Age(birthDate);
			ageInDays = age.getTotalDays();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getAgeInDays() {
		if (System.currentTimeMillis() > millisToReCalculateAge) {
			calculateAge();
		}
		return ageInDays;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * Overriden in selected subclasses.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAlternativeID() {
		return ALTERNATIVE_ID_EDEFAULT;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * Location is set to a value based on the resolvedLocation variable if it is 
	 * not null or the most recently significant event in the history. 
	 * If the most recent event is a:
	 * <ol>
	 * <li>Position event, then the location will be resolved by the Location embedded
	 * in the Premises with the coordinates from the Position event;</li>
	 * <li>Sighting event, then the location is resolved locally based on the name of the 
	 * location in the sighting event;</li>
	 * <li>MoveOut event then the location will be the uri of the MoveOut premises;</li>
	 * </ol>
	 * 
	 * Note this derived attribute does not resolve Locations with the LocationService, 
	 * but will use the resolvedLocation if it set by the LocationService.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLocation() {
		if(resolvedLocation!=null){
			return resolvedLocation;
		}
		String location = null;
		animalLocator.location(this);
		switch (animalLocator.getTypeOfPosition()) {
		case HASCOORDINATES:
			String point = animalLocator.getLocation();
			//First try the local Premises
			if(eContainer()!=null && ((Premises)eContainer()).getLocation()!=null){
				location = ((Premises)eContainer()).getLocation().locate(point);
			}
			//If it was not in the local premises try the locationService
			if(location==null){
				location = point;
			}
			break;
		case MOVED_TO_PREMISES:
			location = animalLocator.getLocation();
			break;
		case SIGHTING:
			location = animalLocator.location;
			break;
		default:
			break;
		}
		return location;

	}

	/**
	 * <!-- begin-user-doc -->
	 * Implemented for speed (versus OCL??)
	 * Originally generated with the following OCL:
	 * if (tags -> notEmpty()) and ( tags.events -> notEmpty())
	 * 		then tags.events
	 * 		else Set{}
	 * endif
	 * 
	 * @see AnimalEventHistoryAdapter
	 * @deprecated use eventHistory()
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Deprecated
	public EList<Event> allEvents() {
		EventHistory eventHistory = (EventHistory) EventHistoryAdapterFactory.INSTANCE.adapt(
				this, EventHistory.class);
		return eventHistory.eventHistory();
	}


	
	/**
	 * <!-- begin-user-doc -->
	 * Add copies of the events in the eventTemplate to the current Tag.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addTemplate(EList<Event> eventTemplate) {
		Tag currentTag = activeTag();
		if (currentTag!=null){
			for (Event event : eventTemplate) {
				Event eventToAdd =  (Event) copier.copy(event);
				currentTag.getEvents().add(eventToAdd);
			}
		}
	}

   /**
	 * <!-- begin-user-doc -->
	 * Tag currently identifying the Animal is the tag with the most current event timestamp.
	 * See model annotation.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag activeTag() {
		if(mostCurrentEvent ==null){
					 mostCurrentEvent = findMostCurrentEvent();
		}
		 return mostCurrentEvent!=null? mostCurrentEvent.getTag(): 
			    	this.tags.isEmpty()?null:tags.get(0);
	}

	/**
	 * 
	 * @return the most current event associated with this animal
	 */
	private Event findMostCurrentEvent() {
		if(eventHistory().isEmpty()){
			return null;
		}
		List<Event> eventsByDate = new LinkedList<Event>(eventHistory());
		// Sort events according to date
		Collections.sort(eventsByDate, new Comparator<Event>() {
			public int compare(Event event1, Event event2) {
				return event2.getDateTime().compareTo(event1.getDateTime());
			}});
		return eventsByDate.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> eventHistory() {
		return allEvents();
	}

	/**
	 * <!-- begin-user-doc -->
	 * TODO refactor this adding setMostCurrentWeighIn
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeighIn lastWeighIn() {
		WeighIn lastWeighIn = null;
				if(!eventHistory().isEmpty()){
					CollectionFilter<Event> weighInsProducer = new CollectionFilter<Event>();
					weighInsProducer.addFilter(TrackerUtils.weighInFilterCriteria);
					List<Event> weighIns = new ArrayList<Event>(weighInsProducer.filterCopy(eventHistory()));
					if(weighIns.isEmpty()){
						return null;
					}
					Collections.sort(weighIns, TrackerUtils.DATE_COMPARATOR);
					lastWeighIn = (WeighIn) weighIns.get(weighIns.size()-1);
				}
				return lastWeighIn;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.ANIMAL__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
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
			case TrackerPackage.ANIMAL__BIRTH_DATE:
				return getBirthDate();
			case TrackerPackage.ANIMAL__SEX:
				return getSex();
			case TrackerPackage.ANIMAL__TAGS:
				return getTags();
			case TrackerPackage.ANIMAL__SPECIES:
				return getSpecies();
			case TrackerPackage.ANIMAL__BREED:
				return getBreed();
			case TrackerPackage.ANIMAL__SEX_CODE:
				return getSexCode();
			case TrackerPackage.ANIMAL__SPECIES_CODE:
				return getSpeciesCode();
			case TrackerPackage.ANIMAL__ID:
				return getId();
			case TrackerPackage.ANIMAL__COMMENTS:
				return getComments();
			case TrackerPackage.ANIMAL__LAST_EVENT_DATE_TIME:
				return getLastEventDateTime();
			case TrackerPackage.ANIMAL__DAM:
				if (resolve) return getDam();
				return basicGetDam();
			case TrackerPackage.ANIMAL__SIRE:
				if (resolve) return getSire();
				return basicGetSire();
			case TrackerPackage.ANIMAL__WEIGHT:
				return getWeight();
			case TrackerPackage.ANIMAL__WEIGHT_GAIN_PER_DAY:
				return getWeightGainPerDay();
			case TrackerPackage.ANIMAL__TYPE:
				return getType();
			case TrackerPackage.ANIMAL__VISUAL_ID:
				return getVisualID();
			case TrackerPackage.ANIMAL__AGE_IN_DAYS:
				return getAgeInDays();
			case TrackerPackage.ANIMAL__ALTERNATIVE_ID:
				return getAlternativeID();
			case TrackerPackage.ANIMAL__LOCATION:
				return getLocation();
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
			case TrackerPackage.ANIMAL__BIRTH_DATE:
				setBirthDate((Date)newValue);
				return;
			case TrackerPackage.ANIMAL__SEX:
				setSex((Sex)newValue);
				return;
			case TrackerPackage.ANIMAL__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends Tag>)newValue);
				return;
			case TrackerPackage.ANIMAL__ID:
				setId((String)newValue);
				return;
			case TrackerPackage.ANIMAL__COMMENTS:
				setComments((String)newValue);
				return;
			case TrackerPackage.ANIMAL__DAM:
				setDam((Animal)newValue);
				return;
			case TrackerPackage.ANIMAL__SIRE:
				setSire((Animal)newValue);
				return;
			case TrackerPackage.ANIMAL__VISUAL_ID:
				setVisualID((String)newValue);
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
			case TrackerPackage.ANIMAL__BIRTH_DATE:
				setBirthDate(BIRTH_DATE_EDEFAULT);
				return;
			case TrackerPackage.ANIMAL__SEX:
				setSex(SEX_EDEFAULT);
				return;
			case TrackerPackage.ANIMAL__TAGS:
				getTags().clear();
				return;
			case TrackerPackage.ANIMAL__ID:
				setId(ID_EDEFAULT);
				return;
			case TrackerPackage.ANIMAL__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case TrackerPackage.ANIMAL__DAM:
				setDam((Animal)null);
				return;
			case TrackerPackage.ANIMAL__SIRE:
				setSire((Animal)null);
				return;
			case TrackerPackage.ANIMAL__VISUAL_ID:
				unsetVisualID();
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
			case TrackerPackage.ANIMAL__BIRTH_DATE:
				return BIRTH_DATE_EDEFAULT == null ? birthDate != null : !BIRTH_DATE_EDEFAULT.equals(birthDate);
			case TrackerPackage.ANIMAL__SEX:
				return sex != SEX_EDEFAULT;
			case TrackerPackage.ANIMAL__TAGS:
				return tags != null && !tags.isEmpty();
			case TrackerPackage.ANIMAL__SPECIES:
				return SPECIES_EDEFAULT == null ? getSpecies() != null : !SPECIES_EDEFAULT.equals(getSpecies());
			case TrackerPackage.ANIMAL__BREED:
				return BREED_EDEFAULT == null ? getBreed() != null : !BREED_EDEFAULT.equals(getBreed());
			case TrackerPackage.ANIMAL__SEX_CODE:
				return SEX_CODE_EDEFAULT == null ? getSexCode() != null : !SEX_CODE_EDEFAULT.equals(getSexCode());
			case TrackerPackage.ANIMAL__SPECIES_CODE:
				return SPECIES_CODE_EDEFAULT == null ? getSpeciesCode() != null : !SPECIES_CODE_EDEFAULT.equals(getSpeciesCode());
			case TrackerPackage.ANIMAL__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case TrackerPackage.ANIMAL__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case TrackerPackage.ANIMAL__LAST_EVENT_DATE_TIME:
				return LAST_EVENT_DATE_TIME_EDEFAULT == null ? getLastEventDateTime() != null : !LAST_EVENT_DATE_TIME_EDEFAULT.equals(getLastEventDateTime());
			case TrackerPackage.ANIMAL__DAM:
				return dam != null;
			case TrackerPackage.ANIMAL__SIRE:
				return sire != null;
			case TrackerPackage.ANIMAL__WEIGHT:
				return WEIGHT_EDEFAULT == null ? getWeight() != null : !WEIGHT_EDEFAULT.equals(getWeight());
			case TrackerPackage.ANIMAL__WEIGHT_GAIN_PER_DAY:
				return WEIGHT_GAIN_PER_DAY_EDEFAULT == null ? getWeightGainPerDay() != null : !WEIGHT_GAIN_PER_DAY_EDEFAULT.equals(getWeightGainPerDay());
			case TrackerPackage.ANIMAL__TYPE:
				return getType() != TYPE_EDEFAULT;
			case TrackerPackage.ANIMAL__VISUAL_ID:
				return isSetVisualID();
			case TrackerPackage.ANIMAL__AGE_IN_DAYS:
				return getAgeInDays() != AGE_IN_DAYS_EDEFAULT;
			case TrackerPackage.ANIMAL__ALTERNATIVE_ID:
				return ALTERNATIVE_ID_EDEFAULT == null ? getAlternativeID() != null : !ALTERNATIVE_ID_EDEFAULT.equals(getAlternativeID());
			case TrackerPackage.ANIMAL__LOCATION:
				return LOCATION_EDEFAULT == null ? getLocation() != null : !LOCATION_EDEFAULT.equals(getLocation());
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
		result.append(" (birthDate: ");
		result.append(birthDate);
		result.append(", sex: ");
		result.append(sex);
		result.append(", comments: ");
		result.append(comments);
		result.append(", visualID: ");
		if (visualIDESet) result.append(visualID); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}
	/**
	 * 
	 * Three types of locations for the animal based on the 
	 * event history.
	 *
	 */
	private enum Locate{
		HASCOORDINATES,//Position event in the eventHistory, getLocate returns a coordinates.
		MOVED_TO_PREMISES,//Animal is no longer in the premises and was moved out, getLocate returns the premises id.
		SIGHTING,//Sighting event in the eventHistory with the location attribute set
		NONE //no information on the animal, assume it is in the premises or waiting to be tagged getLocation is null
	}
	
	private AnimalLocator animalLocator = new AnimalLocator();
	
	class AnimalLocator {

		private Event lastEvent = null; 
		private String location = null;
		private Locate locate = Locate.NONE;
	    private int lastNumberOfEvents = 0;
		
		String getLocation(){
			return location;
		}
		
		Locate getTypeOfPosition(){
			return locate;
		}
		
		void location(Animal animal){
			List<Event> events = new ArrayList<Event>(animal.eventHistory());
			if(events.isEmpty() || events.size()==lastNumberOfEvents){
				return;
			}
			lastNumberOfEvents=events.size();
			locate = Locate.NONE;
			lastEvent = null;
			location = null;
			Collections.sort(events, mostRecentDateFirst);//Newest events are first
			

			Boolean getOlderEvents = true;
			Iterator<Event> it = events.iterator();
			while (getOlderEvents && it.hasNext()) {
				Event event = it.next();
				getOlderEvents = (Boolean)animalSwitch.doSwitch(event);
			}
			
		}
		
		
		private final Comparator<Event> mostRecentDateFirst = new Comparator<Event>() {
				public int compare(Event a, Event b) {
					Date d1 = a.getDateTime();
					Date d2 = b.getDateTime();
					return d2.compareTo(d1);
				}
		};
		
		
		private TrackerSwitch<?> animalSwitch = new TrackerSwitch<Object>(){
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * com.verticon.tracker.util.TrackerSwitch#casePosition(com.verticon
			 * .tracker.Position)
			 */
			@Override
			public Object casePosition(Position event) {
				location = event.getCoordinates();
				locate = Locate.HASCOORDINATES;
				return Boolean.FALSE;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * com.verticon.tracker.util.TrackerSwitch#caseMovedOut(com.verticon
			 * .tracker.MovedOut)
			 */
			@Override
			public Object caseMovedOut(MovedOut event) {
				if(lastEvent == null){
					//The last event was a MovedOut send a false to abort the processing
					location = event.getUri();
					if(location==null && event.getDestinationPin()!=null){
						StringBuffer buf = new StringBuffer("urn:pin:");
						buf.append( event.getDestinationPin());
						location=buf.toString();
					}
					locate = Locate.MOVED_TO_PREMISES;
					return Boolean.FALSE;
				}
				
				return Boolean.TRUE;
			}
			

			/* (non-Javadoc)
			 * @see com.verticon.tracker.util.TrackerSwitch#caseSighting(com.verticon.tracker.Sighting)
			 */
			@Override
			public Object caseSighting(Sighting event) {
				location = event.getLocation();
				locate = Locate.SIGHTING;
				return Boolean.FALSE;
			}

			/* (non-Javadoc)
			 * @see com.verticon.tracker.util.TrackerSwitch#caseEvent(com.verticon.tracker.Event)
			 */
			@Override
			public Object caseEvent(Event event) {
				if(lastEvent == null){
					lastEvent = event;
				}
				return Boolean.TRUE;
			}
		};
		
		
	}
	

} //AnimalImpl