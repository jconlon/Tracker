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
/**
 * 
 */
package com.verticon.tracker.util;

import static com.verticon.tracker.TrackerPlugin.bundleMarker;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_COMMENTS;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_DATE;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_GENERICEVENT_OCDID;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_TYPE;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_UNIT;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.osgi.service.metatype.AttributeDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.DocumentRoot;
import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.OCD;
import com.verticon.osgi.metatype.util.MetatypeSwitch;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.WeightMeasurementUnit;
import com.verticon.tracker.store.TrackerStoreUtils;


/**
 * @author jconlon
 *
 */
public class TrackerUtils {

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TrackerUtils.class);


	// Suppress default constructor for noninstantiability
	private TrackerUtils() {
		throw new AssertionError();
	}

	public static final GregorianCalendar DATE_REFERENCE = new GregorianCalendar(1000, Calendar.JANUARY, 1);  

	
	
	/**
	 * 
	 * @param template
	 * @return animal from the template
	 */
	public static Animal getAnimalFromTemplate(Resource template){
		Object o = template.getContents().get(0);
		Animal animal = null;
		if(o instanceof Animal){
			animal= (Animal)o;
		}
		return animal;
	}
	
	
	
	/**
	 * Finds an existing Animal or creates it in the Premises.
	 * @param tagNumber
	 * @param activePremises
	 * @param defaultAnimal
	 * 
	 * @return animal
	 */
	public static final Animal findOrCreateAnimal(String tagNumber, Premises activePremises, Animal defaultAnimal){
		if(defaultAnimal==null){
			return null;
		}
		Animal result = activePremises.findAnimal(tagNumber);
		if(result==null){
			//Try and find the animal in the TrackerStore
			try {
				result = TrackerStoreUtils.dynamicallyImportAnimal(tagNumber, activePremises);
			} catch (IOException e) {
				logger.error(bundleMarker,"Failde to import animal", e);
			}
			
		}
		if(result==null ){
			Tag tag =TrackerFactory.eINSTANCE.createTag();
			tag.setId(tagNumber);
			result = createAnimalFromTemplate(defaultAnimal, tag);
			activePremises.getAnimals().add(result);
		}
		return result;
	}
	/**
	 * Create a new Animal based on the defaultAnimal and assign it the animalId
	 * @param defaultAnimal
	 * @param animalId
	 * @return createdAnimal
	 */
	private static Animal createAnimalFromTemplate(Animal defaultAnimal, Tag animalId) {
		Copier copier = new Copier();
		Animal animal = (Animal)copier.copy(defaultAnimal);
		//Remove any tags
		animal.getTags().clear();
		animal.getTags().add(animalId);
		return animal;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public final static boolean isUsainNumberUsed(String id) {
		Long idNumber;
		try {
			idNumber = new Long(id);
		} catch (NumberFormatException e) {
			return false;
		}
		return idNumber>840002000000000L && idNumber<843000000000000L;
	}
	
	public static final Comparator<Event> DATE_COMPARATOR = new Comparator<Event>() {
		public int compare(Event a, Event b) {
			Date d1 = a.getDateTime();
			Date d2 = b.getDateTime();
			return d1.compareTo(d2);
		}

	};
	
	/**
	 * Passes all different weighIn events that have a non zero weight.
	 */
	public static final FilterCriteria<Event> weighInFilterCriteria = new FilterCriteria<Event>(){

		public boolean passes(Event o) {
			if(o instanceof WeighIn){
				return true;
			}
			return false;
		}
		
	};
	public static FilterCriteria<Event> createFilterCriteria(
			final String date){
		
		return new FilterCriteria<Event>(){

			@Override
			public boolean passes(Event event) {
				return event.getDate().equals(date);
			}
			
		};
	}
	
	/**
	 * 
	 * @param type of Event
	 * @param name of Generic Event
	 * @return  a FilterCriteria that passes events
	 */
	public static FilterCriteria<Event> createFilterCriteria(
			final EventType type, final String name){
		
		return new FilterCriteria<Event>(){

			@Override
			public boolean passes(Event event) {
				if(EventType.GENERIC_EVENT.equals(type) && 
						EventType.GENERIC_EVENT.equals(getType(event))){
					GenericEvent ge = (GenericEvent)event;
					if(name!=null){
						return ge.findName().equals(name);
					}
					return true;
				}
				return getType(event).equals(type);
				
			}
			
		};
	}
	
	public static EList<OCD> findOCDs(EObject object) {
		final EList<OCD> results = new BasicEList<OCD>();
		MetatypeSwitch<Boolean> ocdVisitor = new MetatypeSwitch<Boolean>(){
			@Override
			public Boolean caseOCD(OCD object) {
				results.add(object);
				return Boolean.FALSE;
			}
		
			@Override
			public Boolean caseDocumentRoot(DocumentRoot object) {
				return  Boolean.TRUE;
			}
		
					
			@Override
			public Boolean caseMetaData(MetaData object) {
				return  Boolean.TRUE;
			}
		
			@Override
			public Boolean defaultCase(EObject object) {
				return Boolean.FALSE;
			}
		};
		
		for(TreeIterator<?> iter = EcoreUtil.getAllContents(object.eResource().getResourceSet(), true); iter.hasNext();){
			Object o =  iter.next();
			if(o instanceof EObject){
				EObject eObject = (EObject)o;
				if(ocdVisitor.doSwitch(eObject) == Boolean.FALSE){
					iter.prune();
				}
			}
		}
		return results;
	}
	
	public static EventType getType(Event event){
		return EventType.getByName(event.eClass().getName());
	}
	
	
	/**
	 * 
	 * There may be a policy on the premises and there may be OCDs that are not accessible on the premises.  
	 * Insure that only the appropriate events are added to the animal.
	 * 
	 * @param premises with or with out a Policy
	 * @param eventsToAdd list of standard and or genericEvents
	 * @param animal target for the copied Events
	 */
	public final static void copyEventsToAnimal(Premises premises, 
			List<Event> eventsToAdd, Animal animal){
		Assert.isNotNull(animal.activeTag());
		Assert.isNotNull(eventsToAdd);
		Assert.isNotNull(premises);
		
		for (Event eventToAdd : eventsToAdd) {
			if(eventToAdd instanceof GenericEvent){
				String ocdId = ((GenericEvent)eventToAdd).getOcd().getID();
				
				if(premises.canContain( EventType.GENERIC_EVENT, ocdId, animal.getType())){
					//Need to find the appropriate ocd
					for (OCD ocd : TrackerUtils.findOCDs(premises)) {
						if(ocd.getID()==ocdId){
							GenericEvent ge = (GenericEvent) EcoreUtil.copy(eventToAdd);
							ge.setOcd(ocd);
							animal.activeTag().getEvents().add(ge);
						}
					}
				
				}else{
				    logger.warn(
				    	"Policy violation. Can't add {} with ocdId={} to the premises.",
				    	EventType.GENERIC_EVENT, ocdId );
				}
			}else{
				EventType eventType = TrackerUtils.getType(eventToAdd);
				if(premises.canContain( eventType, null, animal.getType())){
					animal.activeTag().getEvents().add((Event)EcoreUtil.copy(eventToAdd));
				}else{
					logger.warn(
					    	"Policy violation. Can't add {} to the premises.", eventType );
				}
			}
		}
	}
	
	
	/**
	 * @param premises
	 * @param animalType
	 * @return appropriate potential Events based on premises policies
	 */
	public static List<Event> getAppropriateEvents(Premises premises, AnimalType animalType) {

		List<Event> events = new ArrayList<Event>();

		for (EClassifier eClassifier : TrackerPackage.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (!eClass.isAbstract() && !eClass.equals(TrackerPackage.eINSTANCE.getGenericEvent())) {
					if (TrackerPackage.eINSTANCE.getEvent().isSuperTypeOf(eClass)) {
						Event event = (Event)EcoreUtil.create(eClass);
						if(premises.canContain(TrackerUtils.getType(event), 
								null, animalType)){
							events.add(event);
						}
					}

				}
			}
		}
		

		//Get a list of all the appropriate OCDs
		for (OCD ocd : TrackerUtils.findOCDs(premises)) {
			if(premises.canContain(EventType.GENERIC_EVENT, ocd.getID(), animalType)){
				GenericEvent ge = TrackerFactory.eINSTANCE.createGenericEvent();
				ge.setOcd(ocd);
				events.add(ge);
			}
		}
		Collections.sort(events, eventComparator);

		return events;
	}
	
	/**
	 * @param premises
	 * @return appropriate potential Animals based on premises policies
	 */
	public static List<Animal> getAppropriateAnimals(Premises premises) {

		List<Animal> animals = new ArrayList<Animal>();

		for (EClassifier eClassifier : TrackerPackage.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (!eClass.isAbstract()) {
					if (TrackerPackage.eINSTANCE.getAnimal().isSuperTypeOf(eClass)) {
						Animal event = (Animal)EcoreUtil.create(eClass);
						if(premises.canContain(null, 
								null, event.getType())){
							animals.add(event);
						}
					}

				}
			}
		}
		
		Collections.sort(animals, animalComparator);

		return animals;
	}
	
	/**
	 * For comparing events.
	 */
	public static final Comparator<Event> eventComparator = new Comparator<Event>(){
		@Override
		public int compare(Event parm1, Event parm2) {
			String name1 = getName(parm1);
			String name2 = getName(parm2);
			
			return name1.compareTo(name2);
		}
		
		private String getName(Event parm){
			if(parm instanceof GenericEvent){
				return ((GenericEvent)parm).findName();
			}
				
			return parm.getClass().getSimpleName();
		}
	};
	
	/**
	 * For comparing animals.
	 */
	public static final Comparator<Animal> animalComparator = new Comparator<Animal>(){
		@Override
		public int compare(Animal parm1, Animal parm2) {
			return  parm1.getClass().getSimpleName().compareTo( parm2.getClass().getSimpleName());
		}
	};
	
	public static final Event createEvent(Properties props, Tag tag){
		String type = props.getProperty(EVENT_ADMIN_PROPERTY_EVENT_TYPE);
		EventType eventType = EventType.get(type);
		Event event = null;
		String ocdId = null;
		switch (eventType.getValue()) {
		case EventType.ANIMAL_MISSING_VALUE:
			event = TrackerFactory.eINSTANCE.createAnimalMissing();
			break;
		case EventType.DIED_VALUE:
			event = TrackerFactory.eINSTANCE.createDied();
			break;
		case EventType.EXPORTED_VALUE:
			event = TrackerFactory.eINSTANCE.createExported();
			break;
		case EventType.GENERIC_EVENT_VALUE:
			event = TrackerFactory.eINSTANCE.createGenericEvent();
		    ocdId = props.getProperty(EVENT_ADMIN_PROPERTY_EVENT_GENERICEVENT_OCDID);
			
			if(ocdId == null){
				logger.error(bundleMarker,
						"Could not create a GenericEvent because the osgi.event did not have a {} set.",
						EVENT_ADMIN_PROPERTY_EVENT_GENERICEVENT_OCDID);
						return null;
			}
			OCD ocd = tag.findOCD(ocdId);
			if(ocd == null){
				logger.error(bundleMarker,
						"Could not create a GenericEvent because the {} could not find an OCD.",
						tag);
						return null;
			}
			
			((GenericEvent)event).setOcd(ocd);
			
			for (Entry<String, String> ad : ((GenericEvent)event).getEventAttributes()) {
				AttributeDefinition def = ((GenericEvent)event).findAttributeDefinition(ad);
				String key = def.getID();
				String value = props.getProperty(key);
				if (value!=null){
					String error = def.validate(value);
					if(error==null||error.length()==0){
						ad.setValue(value);
					}else{
						logger.error(bundleMarker,
						"Could not create a GenericEvent because attribute {} failed to validate. {}",
							ad.getKey(), error);
						return null;
					}
				}
			}
			//Add all attributes and values
			
			break;
		case EventType.ICVI_VALUE:
			event = TrackerFactory.eINSTANCE.createICVI();
			break;
		case EventType.LOST_TAG_VALUE:
			event = TrackerFactory.eINSTANCE.createLostTag();
			break;
		case EventType.MOVED_IN_VALUE:
			event = TrackerFactory.eINSTANCE.createMovedIn();
			//TODO SourcePin
			break;
		case EventType.MOVED_OUT_VALUE:
			event = TrackerFactory.eINSTANCE.createMovedOut();
			//TODO DestinationPin
			break;
		case EventType.REPLACED_TAG_VALUE:
			event = TrackerFactory.eINSTANCE.createReplacedTag();
			//TODO OldTag Reference
//			((ReplacedTag)event).setOldTag(props.getProperty("com.verticon.tracker.event.date"));
			break;
		case EventType.SIGHTING_VALUE:
			event = TrackerFactory.eINSTANCE.createSighting();
			break;
		case EventType.SLAUGHTERED_VALUE:
			event = TrackerFactory.eINSTANCE.createSlaughtered();
			break;
		case EventType.TAG_ALLOCATED_VALUE:
			event = TrackerFactory.eINSTANCE.createTagAllocated();
			break;
		case EventType.TAG_APPLIED_VALUE:
			event = TrackerFactory.eINSTANCE.createTagApplied();
			break;
		case EventType.TAG_RETIRED_VALUE:
			event = TrackerFactory.eINSTANCE.createTagRetired();
			break;
		case EventType.WEIGH_IN_VALUE:
			event = TrackerFactory.eINSTANCE.createWeighIn();
			WeightMeasurementUnit unit = WeightMeasurementUnit.get(
					props.getProperty(EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_UNIT)
			);
			if(unit!=null){
				((WeighIn)event).setUnit(unit);
			}
			
			Object d = props.get(EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT);
			if(d instanceof Double){
				((WeighIn)event).setWeight((Double)d);
			}else{
				logger.error(bundleMarker,
						"Failed to create weighIn Event, because there was no weight value property set as a double number.");
				return null;
			}
			
			break;
		default:
			logger.error(bundleMarker,
					"Unsupported eventType={}.",eventType);
			return null;
		}
		
		if(!tag.canContain(eventType, ocdId)){
			logger.warn(bundleMarker,"Containment policy for {} does not allow adding {}",
	    			 new Object[]{tag.eContainer(), eventType});
			return null;
		}
		
		event.setComments(props.getProperty(EVENT_ADMIN_PROPERTY_EVENT_COMMENTS));
		Date date = null;
		try {
			date = TrackerConstants.DATE_FORMAT.parse(props.getProperty(EVENT_ADMIN_PROPERTY_EVENT_DATE));
		} catch (ParseException e) {
			logger.error(bundleMarker,
					"Failed to create the {} dateTime value failed to parse.",event);
			return null;
					
		}
		event.setDateTime(date);
		event.setElectronicallyRead(true);
		event.setCorrection(false);
		return event;
	}
	
}
