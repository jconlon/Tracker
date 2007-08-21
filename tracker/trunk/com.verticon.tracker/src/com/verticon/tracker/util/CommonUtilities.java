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
	 * Finds an existing Animal or creates it in the Premises.
	 * @param tagNumber
	 * @param premises
	 * @param defaultAnimal
	 * @return
	 */
	public static Animal findAnimal(Long tagNumber, Premises premises, Animal defaultAnimal) {
		Animal result = null;
		for (Animal animal : premises.getAnimals()) {
			for (Tag tag : animal.getTags()) {
				if(tagNumber.equals(tag.getIdNumber())){
					result=animal;
					break;
				}
			}
			
		}
		if(result==null && defaultAnimal!=null){
			Tag tag =TrackerFactory.eINSTANCE.createTag();
			tag.setIdNumber(tagNumber.longValue());
			result = createAnimalFromTemplate(defaultAnimal, tag);
			premises.getAnimals().add(result);
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
