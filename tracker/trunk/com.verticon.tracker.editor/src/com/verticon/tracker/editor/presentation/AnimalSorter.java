/**
 * (c) Copyright Mirasol Op'nWorks Inc. 2002, 2003. 
 * http://www.opnworks.com
 * Created on Apr 2, 2003 by lgauthier@opnworks.com
 * 
 */

package com.verticon.tracker.editor.presentation;
import java.util.Date;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;

import com.verticon.tracker.Animal;
import com.verticon.tracker.util.TrackerUtils;


/**
 * Sorter for the Publisher that displays items of type 
 * <code>ExampleTask</code>.
 * The sorter supports three sort criteria:
 * <p>
 * <code>BIRTHDATE</code>: Birthdate of the Animal (String)
 * </p>
 * <p>
 * <code>SPECIES</code>: Species of the Animal (String)
 * </p>
 * <p>
 * <code>BREED</code>: Breed of the Animal (String)
 * </p>
 * <p>
 * <code>SEX</code>: Sex of the Animal (String)
 * </p>
 * <p>
 * <code>AIN</code>: AIN number of the event (String).
 *
 * </p>
 */
public class AnimalSorter extends ViewerSorter {

	/**
	 * Constructor argument values that indicate to sort items by 
	 * description, owner or percent complete.
	 */
	public final static int BIRTHDATE = 1;
	public final static int SPECIES = 2;
	public final static int AIN 	= 3;
	public final static int	BREED	= 4;
	public final static int SEX		= 5;
	public final static int ANIMAL = 6;
	public final static int AGE = 7;
	public final static int COMMENTS = 8;
	public final static int ANIMAL_TEXT = 9;
	public final static int LAST_EVENT_DATE = 10;
	public final static int WEIGHT = 11;
	public final static int WEIGHT_GAIN = 12;
	

	// Criteria that the instance uses 
	private final int criteria;
	private final int dir;
	
	

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of 
	 * 	<code>SPECIES</code> 
	 * 	or 
	 *  <code>BIRTHDATE</code>
	 *  or 
	 *  <code>AIN</code>
	 *  or 
	 *  <code>BREED</code>
	 *  or 
	 *  <code>SEX</code>
	 */
	public AnimalSorter(int criteria, int dir) {
		super();
		this.criteria = criteria;
		this.dir=dir;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {
		Animal animal1 = (Animal) o1;
		Animal animal2 = (Animal) o2;

		int returnValue = 0;
		
		switch (criteria) {
			case BIRTHDATE :
				returnValue = compareBirthDates(animal1, animal2);
				break;
			case SPECIES :
				returnValue = compareSpecies(animal1, animal2);
				break;
			case AIN :
				returnValue = compareAins(animal1, animal2);
				break;
			case BREED :
				returnValue = compareBreeds(animal1, animal2);
				break;
			case SEX :
				returnValue = compareSexes(animal1, animal2);
				break;
			case ANIMAL :
				returnValue = compareAnimals(animal1, animal2);
				break;
			case AGE :
				returnValue = compareAges(animal1, animal2);
				break;
			case COMMENTS :
				returnValue = compareComments(animal1, animal2);
				break;
			case ANIMAL_TEXT :
				returnValue = compareAnimalsText(animal1, animal2);
				break;
			case LAST_EVENT_DATE :
				returnValue = compareLastEventDates(animal1, animal2);
				break;
			case WEIGHT :
				returnValue = compareWeight(animal1, animal2);
				break;
			case WEIGHT_GAIN :
				returnValue = compareWeightGain(animal1, animal2);
				break;	
				
			default:
				returnValue = 0;
		}
		if (this.dir == SWT.DOWN) {
			returnValue = returnValue * -1;
		}
		return returnValue;
	}

	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the Sexes.
	 *
	 * @param animal1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareSexes(Animal animal1, Animal animal2) {
		return getComparator().compare(animal1.getSexCode(), animal2.getSexCode());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the Breeds
	 *
	 * @param animal1
	 * @param animal2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareBreeds(Animal animal1, Animal animal2) {
		
		return getComparator().compare(animal1.getBreed(), animal2.getBreed());
		
	}
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the name of the Class of Animal
	 *
	 * @param animal1
	 * @param animal2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareAnimals(Animal animal1, Animal animal2) {
		return getComparator().compare(animal1.getClass().getSimpleName(), animal2.getClass().getSimpleName());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the Ains.
	 *
	 * @param animal1
	 * @param animal2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareAins(Animal animal1, Animal animal2) {
		return getComparator().compare(animal1.getId(), animal2.getId());
	}

	
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the Birth Date.
	 *
	 * @param animal1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareBirthDates(Animal animal1, Animal animal2) {
		Date date1 = animal1.getBirthDate()==null?TrackerUtils.DATE_REFERENCE.getTime():animal1.getBirthDate();
		Date date2 = animal2.getBirthDate()==null?TrackerUtils.DATE_REFERENCE.getTime():animal2.getBirthDate();
		return date1.compareTo(date2);
	}

	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on their species.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareSpecies(Animal animal1, Animal animal2) {
		return getComparator().compare(animal1.getSpecies(), 
				animal2.getSpecies());
	}

	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the name of the comments of event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareAges(Animal animal1, Animal animal2) {
		Date date1 = animal1.getBirthDate()==null?TrackerUtils.DATE_REFERENCE.getTime():animal1.getBirthDate();
		Date date2 = animal2.getBirthDate()==null?TrackerUtils.DATE_REFERENCE.getTime():animal2.getBirthDate();
		return date2.compareTo(date1);
	}
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the name of the comments of event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareComments(Animal animal1, Animal animal2) {
		String comments1 = animal1.getComments()==null?"":animal1.getComments();
		String comments2 = animal2.getComments()==null?"":animal2.getComments();
		return comments1.compareTo(comments2);
	}
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the labels associated with the animals.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareAnimalsText(Animal animal1, Animal animal2) {
		return getText(animal1).compareTo(getText(animal2));
	}
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the Last Event Date.
	 *
	 * @param animal1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareLastEventDates(Animal animal1, Animal animal2) {
		Date date1 = animal1.getLastEventDateTime()==null?TrackerUtils.DATE_REFERENCE.getTime():animal1.getLastEventDateTime();
		Date date2 = animal2.getLastEventDateTime()==null?TrackerUtils.DATE_REFERENCE.getTime():animal2.getLastEventDateTime();
		return date1.compareTo(date2);
	}
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the weights associated with the animals.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareWeight(Animal animal1, Animal animal2) {
		if(animal1.getWeight()==null && animal2.getWeight()==null){
			return 0;
		}
		if(animal1.getWeight()==null){
			return -1;
		}
		if(animal2.getWeight()==null){
			return 1;
		}
		return animal1.getWeight().compareTo(animal2.getWeight());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given animals
	 * based on the weight gains associated with the animals.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareWeightGain(Animal animal1, Animal animal2) {
		if(animal1.getWeightGainPerDay()==null && animal2.getWeightGainPerDay()==null){
			return 0;
		}
		if(animal1.getWeightGainPerDay()==null){
			return -1;
		}
		if(animal2.getWeightGainPerDay()==null){
			return 1;
		}
		return animal1.getWeightGainPerDay().compareTo(animal2.getWeightGainPerDay());
	}
	
	/**
	 * Returns the sort criteria of this this sorter.
	 *
	 * @return the sort criterion
	 */
	public int getCriteria() {
		return criteria;
	}
	
	private static final String getText(Object object) {
		String label = ((Animal)object).getId();
		return label == null || label.length() == 0 ?
			getResourceName(object):
			label+getResourceName(object);
	}

	/**
	 * @param object
	 * @return
	 */
	private static final String getResourceName(Object object) {
		String simpleName = object.getClass().getSimpleName();
		String resourceName = simpleName.substring(0,simpleName.indexOf("Impl"));
		return resourceName;
	}
	
}
