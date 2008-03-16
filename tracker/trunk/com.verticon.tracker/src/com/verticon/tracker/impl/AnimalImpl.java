/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Sex;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.util.Age;
import com.verticon.tracker.util.CollectionFilter;
import com.verticon.tracker.util.CommonUtilities;
import com.verticon.tracker.util.Species;

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
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getAge <em>Age</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSexCode <em>Sex Code</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSpeciesCode <em>Species Code</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getLastEventDateTime <em>Last Event Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getDam <em>Dam</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSire <em>Sire</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getWeightGainPerDay <em>Weight Gain Per Day</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnimalImpl extends EObjectImpl implements Animal {
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
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final Age AGE_EDEFAULT = (Age)TrackerFactory.eINSTANCE.createFromString(TrackerPackage.eINSTANCE.getAge(), "");

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
	protected static final Integer WEIGHT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getWeightGainPerDay() <em>Weight Gain Per Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeightGainPerDay()
	 * @generated
	 * @ordered
	 */
	protected static final Integer WEIGHT_GAIN_PER_DAY_EDEFAULT = null;

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
	public void setBirthDate(Date newBirthDate) {
		Date oldBirthDate = birthDate;
		birthDate = newBirthDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__BIRTH_DATE, oldBirthDate, birthDate));
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
			tags = new EObjectContainmentEList<Tag>(Tag.class, this, TrackerPackage.ANIMAL__TAGS);
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
	 * @NOT
	 * @return
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Date getLastEventDateTime() {
		List<Event> winners = new LinkedList<Event>();
		winners.addAll(allEvents());
		if(winners.isEmpty()){
			return null;
		}
		// Sort events according to date
		Collections.sort(winners, new Comparator<Event>() {
		    public int compare(Event event1, Event event2) {
		        return event2.getDateTime().compareTo(event1.getDateTime());
		    }});
		return winners.get(0).getDateTime();
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

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Integer getWeight() {
		WeighIn lastWeighIn = getLastWeighIn();
		return lastWeighIn==null ? null: lastWeighIn.getWeight();
	}
	
	 /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Integer getWeightGainPerDay() {
		WeighIn lastWeighIn = getLastWeighIn();
		return lastWeighIn==null?null: lastWeighIn.getWeightGainPerDay();
	}

	private WeighIn getLastWeighIn(){
		WeighIn lastWeighIn = null;
		if(!allEvents().isEmpty()){
			CollectionFilter<Event> weighInsProducer = new CollectionFilter<Event>();
			weighInsProducer.addFilter(CommonUtilities.weighInFilterCriteria);
			List<Event> weighIns = new ArrayList<Event>(weighInsProducer.filterCopy(allEvents()));
			Collections.sort(weighIns, CommonUtilities.DATE_COMPARATOR);
			lastWeighIn = (WeighIn) weighIns.get(weighIns.size()-1);
		}
		return lastWeighIn;
	}
	
	

/**
	 * <!-- begin-user-doc -->
	 * Hand implemented for speed (versus OCL??) because this method is used to generate the
	 * key attribute for Animal.
	 * Originally generated with the following OCL:
	 * if (tags -> notEmpty()) and ( tags.events -> notEmpty())
	 * 		then tags.events
	 * 		else Set{}
	 * endif
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Event> allEvents() {
		
		if(tags==null || tags.isEmpty()){
			return  ECollections.emptyEList();
		}
		EList<Event> events = new BasicEList<Event>();
		for (Tag tag : tags) {
			events.addAll(tag.getEvents());
		}
		return ECollections.unmodifiableEList(events);
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
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Tag activeTag() {
		if(allEvents().isEmpty()){
			return null;
		}
		List<Event> winners = new LinkedList<Event>();
		winners.addAll(allEvents());
		
		// Sort events according to date
		Collections.sort(winners, new Comparator<Event>() {
		    public int compare(Event event1, Event event2) {
		        return event2.getDateTime().compareTo(event1.getDateTime());
		    }});
		return winners.get(0).getTag();
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
			case TrackerPackage.ANIMAL__AGE:
				return getAge();
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
			case TrackerPackage.ANIMAL__AGE:
				return AGE_EDEFAULT == null ? getAge() != null : !AGE_EDEFAULT.equals(getAge());
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
		result.append(')');
		return result.toString();
	}

} //AnimalImpl