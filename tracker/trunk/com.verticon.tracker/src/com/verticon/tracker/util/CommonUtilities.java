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
	 * Finds an existing Animal or creates it in the Premises.
	 * @param tagNumber
	 * @param premises
	 * @param defaultAnimal
	 * 
	 * @return
	 */
	public static final Animal findOrCreateAnimal(String tagNumber, Premises activePremises, Animal defaultAnimal){
		if(defaultAnimal==null){
			return null;
		}
		Animal result = activePremises.findAnimal(tagNumber);
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
}
