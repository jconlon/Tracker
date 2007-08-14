/**
 * 
 */
package com.verticon.tracker.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
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

	public static final GregorianCalendar DATE_REFERENCE = new GregorianCalendar(1000, Calendar.JANUARY, 1);  

	public static final void setEventDate(Event event){
		if(event.getDateTime().before(DATE_REFERENCE.getTime())){
			event.setDateTime(new Date());
		}
	}
	
	/**
	 * @deprecated use getAnimalFromTemplate
	 * @param resource
	 * @return
	 */
	public static Premises getPremisesFromTemplate(Resource resource){
		Object o = resource.getContents().get(0);
		if(o instanceof Premises){
			return (Premises)o;
		}
		return null;
	}
	
	public static Animal getAnimalFromTemplate(Resource resource){
		Object o = resource.getContents().get(0);
		Animal animal = null;
		if(o instanceof Animal){
			animal= (Animal)o;
		}
		return animal;
	}
	
	/**
	 * @deprecated use getAnimal
	 * @param resource
	 * @return
	 */
	public static Animal getDefaultAnimalFromTemplate(Resource resource){
		Object o = resource.getContents().get(0);
		Animal animal = null;
		if(o instanceof Premises){
			Premises premises = (Premises)o;
			if(premises.getAnimals()!=null){
				animal= (Animal)premises.getAnimals().get(0);
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
//	public static Collection<Event> createEvents(Premises premisesTemplate, AnimalId animalId, Premises premises) {
//		Copier copier = new Copier();	  
//		ArrayList<Event> outputResults = new ArrayList<Event>();
//		Event outputEvent;
//		for (Object o : premisesTemplate.eventHistory()) {
//			outputEvent= (Event) copier.copy((Event)o);
//			setEventDate(outputEvent);
//			if(canAddEventToAnimal(animalId, outputEvent, premises.getEventHistory()) ){
//				outputResults.add(outputEvent);
//			}
//		}
//		return outputResults;
//	}
	
	/**
	 * Create a preference policy for adding duplicates.
	 * @param animal
	 * @param event
	 * @param premises
	 * @return true if no similar event is associated with the animal
	 */
//	public static boolean canAddEventToAnimal(AnimalId animalId, Event event, EventHistory eventHistory){
//		for (Event ev : eventHistory.getEvents()) {
//			if (ev.getEventCode() == event.getEventCode() && ev.getAin() == animalId) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	
	/**
	 * Finds an existing AnimalId or creates an animal in the Premises and returns its animalId.
	 * @param tagNumber
	 * @param premises
	 * @param defaultAnimal
	 * @return
	 */
	public static Tag findAnimalId(Long tagNumber, Premises premises, Animal defaultAnimal) {
		Tag result = null;
		for (Animal animal : premises.getAnimals()) {
			for (Tag tag : animal.getTags()) {
				if(tagNumber.equals(tag.getIdNumber())){
					result=tag;
					break;
				}
			}
			
		}
		if(result==null && defaultAnimal!=null){
			result=TrackerFactory.eINSTANCE.createTag();
			result.setIdNumber(tagNumber.longValue());
			Animal animal = createAnimalFromTemplate(defaultAnimal, result);
			premises.getAnimals().add(animal);
		}
		return result;
	}

	/**
	 * 
	 * @param premises to add animal
	 * @param defaultAnimal template to use
	 * @param animalId of animal
	 */
	private static Animal createAnimalFromTemplate(Animal defaultAnimal, Tag animalId) {
		Copier copier = new Copier();
		Animal animal = (Animal)copier.copy(defaultAnimal);
		animal.getTags().add(animalId);
		return animal;
	}
	
	
	
}
