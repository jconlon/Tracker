/**
 * 
 */
package com.verticon.tracker.editor.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;

/**
 * Data container for an Animal template and a flag indicating how to use event
 * timestamps
 * 
 * @author jconlon
 *
 */
 public class AnimalTemplateBean {
	private final Animal animal;
	private Date date = null;
	private final String name;
	private final static Copier copier = new Copier();
	
	public AnimalTemplateBean(Animal animal, String name) {
		super();
		this.animal = animal;
		this.name=name;
	}

	/**
	 * @deprecated use method with the string parm 
	 * @return the animal and set all the event dates if useCurrentDate is set.
	 */
	public Animal getAnimal(Long tag) {
		return getAnimal( tag.toString());
	}
	

	/**
	 * 
	 * @return the animal and set all the event dates if useCurrentDate is set.
	 */
	public Animal getAnimal(String tag){
		Animal copiedAnimal = (Animal)copier.copy(animal);
		if(copiedAnimal.activeTag()!=null){
			copiedAnimal.activeTag().setId(tag);
			if(date !=null){
				for (Event event : copiedAnimal.allEvents()) {
					event.setDateTime(date);
				}
			}else{
				for (Event event : copiedAnimal.allEvents()) {
					setEventDate( event);
				}
			}
		}else{
			//no active tag create one
			Tag newTag = TrackerFactory.eINSTANCE.createTag();
			newTag.setId(tag);
			copiedAnimal.getTags().add(newTag);
		}
		return copiedAnimal;
	}

	

	public int numberOfEvents(){
		return animal.allEvents().size();
	}
	/**
	 * 
	 * @return a list of events using the current date if necessary.
	 */
	public Collection<Event> getEvents(){
		Animal copiedAnimal = (Animal)copier.copy(animal);
		Collection<Event> events = null;
		if(copiedAnimal.allEvents().isEmpty()){
			events= Collections.emptyList();
		}else if(date!=null){
			 events = new ArrayList<Event>();
			 for (Event event : copiedAnimal.allEvents()) {
				event.setDateTime(date);
				events.add(event);
			 }
		}
		else {
			 events = new ArrayList<Event>();
			 events.addAll(copiedAnimal.allEvents());//Just add all the events
		}
		return events;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Template resource: "+name;
	}
	
	public static final GregorianCalendar DATE_REFERENCE = new GregorianCalendar(1000, Calendar.JANUARY, 1);  

	public static final void setEventDate(Event event){
		if(event.getDateTime().before(DATE_REFERENCE.getTime())){
			event.setDateTime(new Date());
		}
	}
}
