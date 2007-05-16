/**
 * 
 */
package com.verticon.tracker.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;

/**
 * @author jconlon
 *
 */
public class CommonUtilities {

	/**
	 * 
	 */
	private CommonUtilities() {}

	private static final GregorianCalendar DATE_REFERENCE = new GregorianCalendar(1000, Calendar.JANUARY, 1);  

	public static final void setEventDate(Event event){
		if(event.getDateTime().before(DATE_REFERENCE.getTime())){
			event.setDateTime(new Date());
		}
	}
	
	public static EventHistory getEventHistoryFromTemplate(Resource resource){
		Object o = resource.getContents().get(0);
		if(o instanceof EventHistory){//old templates had EventHistory as root
			return (EventHistory)o;
		}else if(o instanceof Premises){
			Premises premises = (Premises)o;
			return premises.getEventHistory();
		}
		return null;
	}
	
	public static Animal getDefaultAnimalFromTemplate(Resource resource){
		Object o = resource.getContents().get(0);
		Animal animal = null;
		if(o instanceof Premises){
			Premises premises = (Premises)o;
			if(premises.getAnimals()!=null){
				animal= (Animal)premises.getAnimals().getAnimal().get(0);
			}
		}
		return animal;
	}
	
	/**
	 * Create valid events for the animalId based on events in the template.
	 * @param template
	 * @param animalId
	 * @param premises
	 * @return
	 */
	public static Collection<Event> createEvents(EventHistory template, AnimalId animalId, Premises premises) {
		Copier copier = new Copier();	  
		ArrayList<Event> outputResults = new ArrayList<Event>();
		Event outputEvent;
		for (Object o : template.getEvents()) {
			outputEvent= (Event) copier.copy((Event)o);
			setEventDate(outputEvent);
			outputEvent.setAin(animalId);
			if(canAddEventToAnimal(animalId, outputEvent, premises.getEventHistory()) ){
				outputResults.add(outputEvent);
			}
		}
		return outputResults;
	}
	
	/**
	 * FIXME create a preference policy for adding duplicates.
	 * @param animal
	 * @param event
	 * @param premises
	 * @return true if no similar event is associated with the animal
	 */
	public static boolean canAddEventToAnimal(AnimalId animalId, Event event, EventHistory eventHistory){
		List elist = eventHistory.getEvents();
		for (Object object : elist) {
			Event ev = (Event) object;
			if (ev.getEventCode() == event.getEventCode() && ev.getAin() == animalId) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Finds an existing AnimalId or creates an animal in the Premises and returns its animalId.
	 * @param tag
	 * @param premises
	 * @param defaultAnimal
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static AnimalId findAnimalId(Long tag, Premises premises, Animal defaultAnimal) {
		List elist = premises.getAnimals().getAnimal();
		AnimalId animalId = null;
		for (Object object : elist) {
			Animal animal = (Animal) object;
			if (animal.getIdNumber().longValue() == tag) {
				animalId= animal.getAin();
				break;
			}
		}
		if(animalId==null && defaultAnimal!=null){
			Copier copier = new Copier();
			animalId=TrackerFactory.eINSTANCE.createAnimalId();
			animalId.setIdNumber(tag.toString());
			Animal animal = (Animal)copier.copy(defaultAnimal);
			animal.setAin(animalId);
			premises.getAnimals().getAnimal().add(animal);
		}
		return animalId;
	}
	
	
	
}
