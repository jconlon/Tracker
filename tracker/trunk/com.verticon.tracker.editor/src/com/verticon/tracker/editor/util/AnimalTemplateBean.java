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
package com.verticon.tracker.editor.util;

import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_SPREAD_INTERVAL;
import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jface.preference.IPreferenceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.util.TrackerUtils;

/**
 * Container modeling an Animal Template (*.animal) Document File
 * and the behavior associated with copying events from a template animal
 * for loading to animals in a Premises Document. 
 * 
 * Under certain conditions the dates of the Events in this bean will be
 * changed before being returned to clients.
 * 
 * Three dateTime manipulations are supported:
 * 
 * 1. If the dateTimes of templateEvents are after a reference time, then
 * dateTimes of the copied events are the same as in the template events. 
 * 
 * 2. If the dateTimes of templateEvents are before a reference time AND there is NO
 * default date time set then the current dateTime is used instead of the dateTime in 
 * the template events.
 * 
 * 3. If the dateTimes of templateEvents are before a reference time AND there IS a
 * default date time set then a default dateTime is used for all events.
 * 
 * @author jconlon
 *
 */
 public class AnimalTemplateBean {
	
	 /**
		 * slf4j Logger
		 */
		private final static Logger logger = LoggerFactory
				.getLogger(AnimalTemplateBean.class);
		
	private static final GregorianCalendar DATE_REFERENCE = 
		new GregorianCalendar(2000, Calendar.JANUARY, 1);  

	private final Animal animalInTemplate; 
	private Date defaultEventDate = null;
	private final String fileNameOfTemplate;
	private final static Copier copier = new Copier(false, false);
	
	/** 
	 * Internal constructor
	 * @param animal
	 * @param fileNameOfTemplate
	 */
	private AnimalTemplateBean(Animal animal, String fileNameOfTemplate) {
		super();
		this.animalInTemplate = animal;
		this.fileNameOfTemplate=fileNameOfTemplate;
	}
	
	
	/**
	 * 
	 * @param animalTemplateFile 
	 * @return AnimalTemplateBean or null if one could not be created from the animalTemplateFile
	 */
	public final static AnimalTemplateBean instance(IFile animalTemplateFile){
		Animal animal = getAnimal( animalTemplateFile);
		if(animal==null){
			return null;
		}
		AnimalTemplateBean templateBean = new AnimalTemplateBean(animal, animalTemplateFile.getName());
		return templateBean;
	}
	/**
	 * 
	 * @param animal in the bean
	 * @param event to be added to the animal
	 * @return AnimalTemplateBean
	 */
	public static final AnimalTemplateBean instance(Animal animal, Event event) {
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.getEvents().add(event);
		animal.getTags().add(tag);
		AnimalTemplateBean templateBean = new AnimalTemplateBean(animal,
				"User prompted dialog");
		return templateBean;
	}
	
	/**
	 * 
	 * @return number of Events in bean
	 */
	public int numberOfEvents(){
		return animalInTemplate.eventHistory().size();
	}
	
	/**
	 * @param premises
	 * @return a collection of events copied from the template.
	 */
	protected Collection<Event> getEvents(Premises premises){
		List<Event> events = null;
		if(animalInTemplate.eventHistory().isEmpty()){
			events= Collections.emptyList();
		}else{
			events = new ArrayList<Event>(animalInTemplate.eventHistory().size());
			for (Event event : animalInTemplate.eventHistory()) {
				Event copiedEvent = (Event)copier.copy(event);
				events.add(copiedEvent);
			}
			setAppropriateDateOnEvents(events, defaultEventDate);
			if(premises!=null){
				//Go through the genericEvents setting the OCDs 
				setOCDReferences(premises,  animalInTemplate.eventHistory(), events);
			}
		}
		return events;
	}

	/**
	 * This is the defaultDate to use for copied events
	 * when the date Time of an event in this 
	 * template is before the reference date.
	 * 
	 * If it is set to null, the default then events with
	 * dateTimes before the reference will be set to a null
	 * value.
	 * 
	 * @param date
	 */
    void setDateForAllEvents(Date date) {
		this.defaultEventDate = date;
	}

	@Override
	public String toString() {
		return "Template resource: "+fileNameOfTemplate;
	}
	
	/**
	 * 
	 * @return the defaultEventDate
	 */
	 Date getDate() {
		return defaultEventDate;
	}
	 
	
	String getFileNameOfTemplate() {
		return fileNameOfTemplate;
	}

	/**
	 * Return a copy of the Animal and its trees of Tags and Events.
	 * Sets Event dates if useCurrentDate is set.
	 * 
	 * Copier does not copy or any references so this has to 
	 * be done after the copy. Now only done for Sighting events
	 * and GenericEvents.
	 * 
	 * 
	 * @return copied animalInTemplate.
	 * @throws PremisesPolicyException 
	 */
	 Animal getAnimal(String tag, Premises premises) throws PremisesPolicyException{
		//Is the animal appropriate
			if(!premises.canContain(null, null, animalInTemplate.getType())){
				throw new PremisesPolicyException("Policy violation. Can't add "+animalInTemplate.getType());
			}
		Animal targetAnimal = (Animal)copier.copy(animalInTemplate);
		
		if(targetAnimal.activeTag()!=null){
			targetAnimal.activeTag().setId(tag);
			setAppropriateDateOnEvents(targetAnimal.eventHistory(), defaultEventDate);
		}else{
			//no active tag on the template animal, just create an tag without events
			Tag newTag = TrackerFactory.eINSTANCE.createTag();
			newTag.setId(tag);
			targetAnimal.getTags().add(newTag);
		}
		//Go through the genericEvents setting the OCDs 

		setOCDReferences(premises, animalInTemplate.eventHistory(), targetAnimal.eventHistory());
		//Go through the events Removing the ones that are not allowed in the premises
		for (Iterator<Event> iterator = targetAnimal.activeTag().getEvents().iterator(); iterator.hasNext();) {
			Event event = iterator.next();
			if(event instanceof GenericEvent){
				GenericEvent ge = (GenericEvent)event;
				if(!premises.canContain(EventType.GENERIC_EVENT, ge.getOcd().getID(), targetAnimal.getType())){
					iterator.remove();
					logger.warn(bundleMarker,"Policy violation. Deferred adding GenericEvent with ocdId={}",ge.getOcd().getID());
				}
			}else{
				if(!premises.canContain(TrackerUtils.getType(event), null, targetAnimal.getType())){
					iterator.remove();
					logger.warn(bundleMarker,"Policy violation. Deferred adding Event ={}",TrackerUtils.getType(event));
				}
			}
			
		}
		return targetAnimal;
	}
	 
	 /*
		 * There may be a policy on the premises and there may be OCDs that are not 
		 * accessible on the premises.  Insure that only the appropriate events
		 * are added to the animal.
		 */
//		private final static void setReferencesOnGenericEvents(Premises premises, 
//				Animal animalInTemplate, Animal copiedAnimal){
//			EList<Event> eventsInTemplate =  animalInTemplate.eventHistory();
//			EList<Event> eventsCopiedAnimal = copiedAnimal.eventHistory();
//			setOCDReferences(premises, eventsInTemplate, eventsCopiedAnimal);
//		}


		/**
		 * 
		 * @param premises of the target document
		 * @param sourceEvents
		 * @param targetEvents
		 */
		private static void setOCDReferences(Premises premises,
				List<Event> sourceEvents, List<Event> targetEvents) {
			for (int i = 0; i < targetEvents.size(); i++) {
				
				if(targetEvents.get(i) instanceof GenericEvent){
					String ocdId = ((GenericEvent)sourceEvents.get(i)).getOcd().getID();
					for (OCD ocd : TrackerUtils.findOCDs(premises)) {
						if(ocd.getID().equals(ocdId)){
							GenericEvent ge = (GenericEvent)targetEvents.get(i);
							ge.setOcd(ocd);
							break;
						}
					}
					
				}
			}
		}

	/**
	 * @param animalTemplateFile 
	 * @return animal from the animalTemplateFile
	 */
	private final static Animal getAnimal(IFile animalTemplateFile) {
		Resource resource;
		try {
			resource = TrackerEditorUtils.getResource(animalTemplateFile);
		} catch (IOException e) {
			return null;
		}
		if(resource==null){
			return null;
		}
		Animal animal = TrackerUtils.getAnimalFromTemplate(resource);
		return animal;
	}
	
	/**
	 * Sets appropriate dates on all events.
	 * @param events
	 * @param presetDate
	 */
	 private static void setAppropriateDateOnEvents(Collection<Event> events, Date presetDate) {
		int interval = getIntervalBetweenEventsPreference();
		Calendar cal = null;
		for (Event event : events) {
			if(isFirstEvent(cal) ){
				if(presetDate !=null){
					cal = Calendar.getInstance();
					cal.setTime(presetDate);
				}else{
					cal = Calendar.getInstance();
				}
			}else{//All subsequent events add the Spread Interval to space out the events.
				cal.add(Calendar.SECOND, interval);
			}
			setEventDateIfTemplateDateBeforeReference( event, cal.getTime());
			
		}
	}

	/**
	 * @return
	 */
	private static int getIntervalBetweenEventsPreference() {
		int interval = 1;
		if(TrackerReportEditorPlugin.getPlugin()!=null){
			IPreferenceStore prefs = TrackerReportEditorPlugin.getPlugin().getPreferenceStore();
			if(prefs!=null){
				interval = prefs.getInt(P_SPREAD_INTERVAL);
			}
		}
		return interval;
	}

	/**
	 * @param cal
	 * @return
	 */
	private static boolean isFirstEvent(Calendar cal) {
		return cal == null;
	}
	
	
    private static final void setEventDateIfTemplateDateBeforeReference(Event event, Date defaultDate){
		if(event.getDateTime().before(DATE_REFERENCE.getTime())){
			event.setDateTime(defaultDate);
		}
	}
}
