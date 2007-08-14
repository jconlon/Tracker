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

import com.verticon.tracker.Animal;
import com.verticon.tracker.util.CommonUtilities;


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
	

	// Criteria that the instance uses 
	private int criteria;

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
	public AnimalSorter(int criteria) {
		super();
		this.criteria = criteria;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {
		Animal animal1 = (Animal) o1;
		Animal animal2 = (Animal) o2;

		switch (criteria) {
			case BIRTHDATE :
				return compareBirthDates(animal1, animal2);
			case SPECIES :
				return compareSpecies(animal1, animal2);
			case AIN :
				return compareAins(animal1, animal2);
			case BREED :
				return compareBreeds(animal1, animal2);
			case SEX :
				return compareSexes(animal1, animal2);
			default:
				return 0;
		}
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
		String ain1 = animal1.getAin()==null?"":animal1.getAin().getIdNumber();
		String ain2 = animal2.getAin()==null?"":animal2.getAin().getIdNumber();
		return getComparator().compare(
				ain1, 
				ain2);
		
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
		Date date1 = animal1.getBirthDate()==null?CommonUtilities.DATE_REFERENCE.getTime():animal1.getBirthDate();
		Date date2 = animal2.getBirthDate()==null?CommonUtilities.DATE_REFERENCE.getTime():animal2.getBirthDate();
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
	 * Returns the sort criteria of this this sorter.
	 *
	 * @return the sort criterion
	 */
	public int getCriteria() {
		return criteria;
	}
}
