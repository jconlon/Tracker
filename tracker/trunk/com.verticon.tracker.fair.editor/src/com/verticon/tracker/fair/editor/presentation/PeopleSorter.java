/**
 * (c) Copyright Mirasol Op'nWorks Inc. 2002, 2003. 
 * http://www.opnworks.com
 * Created on Apr 2, 2003 by lgauthier@opnworks.com
 * 
 */

package com.verticon.tracker.fair.editor.presentation;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;

import com.verticon.tracker.fair.Person;


/**
 * Sorter for the Publisher that displays items of type 
 * <code>ExampleTask</code>.
 * The sorter supports three sort criteria:
 * <p>
 * <code>NUMBER</code>: Birthdate of the Animal (String)
 * </p>
 * <p>
 * <code>EXHIBITOR</code>: Species of the Animal (String)
 * </p>
 * <p>
 * <code>LOT</code>: Breed of the Animal (String)
 * </p>
 * <p>
 * <code>CLASS</code>: Sex of the Animal (String)
 * </p>
 * <p>
 * <code>ANIMAL</code>: ANIMAL number of the event (String).
 *
 * </p>
 */
public class PeopleSorter extends ViewerSorter {

	/**
	 * Constructor argument values that indicate to sort items by 
	 * description, owner or percent complete.
	 */
	public final static int STATE = 1;
	public final static int PHONE = 2;
	public final static int FIRST_NAME 	= 3;
	public final static int	CITY	= 4;
	public final static int STREET		= 5;
	public final static int LAST_NAME = 6;
	public final static int ZIP = 7;
	public final static int NAME = 8;
	public final static int COMMENTS = 9;
	public final static int PIN = 10;
	

	// Criteria that the instance uses 
	private final int criteria;
	private final int dir;
	
	

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of 
	 * 	<code>EXHIBITOR</code> 
	 * 	or 
	 *  <code>NUMBER</code>
	 *  or 
	 *  <code>ANIMAL</code>
	 *  or 
	 *  <code>LOT</code>
	 *  or 
	 *  <code>CLASS</code>
	 */
	public PeopleSorter(int criteria, int dir) {
		super();
		this.criteria = criteria;
		this.dir=dir;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {
		Person person1 = (Person) o1;
		Person person2 = (Person) o2;

		int returnValue = 0;
		
		switch (criteria) {
			case STATE :
				returnValue = compareStates(person1, person2);
				break;
			case PHONE :
				returnValue = comparePhones(person1, person2);
				break;
			case FIRST_NAME :
				returnValue = compareFirstNames(person1, person2);
				break;
			case CITY :
				returnValue = compareCities(person1, person2);
				break;
			case STREET :
				returnValue = compareStreets(person1, person2);
				break;
			case LAST_NAME :
				returnValue = compareLastNames(person1, person2);
				break;
			case ZIP :
				returnValue = compareZips(person1, person2);
				break;
			case NAME :
				returnValue = compareNames(person1, person2);
				break;
			case COMMENTS :
				returnValue = compareComments(person1, person2);
				break;
			case PIN :
				returnValue = comparePins(person1, person2);
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
	 * based on the Street.
	 *
	 * @param animal1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareStreets(Person person1, Person person2) {
		String value1 = person1.getStreet()==null?"":person1.getStreet();
		String value2 = person2.getStreet()==null?"":person2.getStreet();
		return value1.compareTo(value2);
		
		
	}
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the City
	 *
	 * @param person1
	 * @param animal2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareCities(Person person1, Person person2) {
		String value1 = person1.getCity()==null?"":person1.getCity();
		String value2 = person2.getCity()==null?"":person2.getCity();
		return value1.compareTo(value2);
	}
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the name of the Last Name
	 *
	 * @param person1
	 * @param person2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareLastNames(Person person1, Person person2) {
		String value1 = person1.getLastName()==null?"":person1.getLastName();
		String value2 = person2.getLastName()==null?"":person2.getLastName();
		return value1.compareTo(value2);	
	}
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the firstName.
	 *
	 * @param person1
	 * @param person2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareFirstNames(Person person1, Person person2) {
		String value1 = person1.getFirstName()==null?"":person1.getFirstName();
		String value2 = person2.getFirstName()==null?"":person2.getFirstName();
		return value1.compareTo(value2);
	}

	
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the State.
	 *
	 * @param person1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareStates(Person person1, Person person2) {
		String value1 = person1.getState()==null?"":person1.getState();
		String value2 = person2.getState()==null?"":person2.getState();
		return value1.compareTo(value2);
	}

	/**
	 * Returns a number reflecting the collation order of the given people
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
	protected int comparePhones(Person person1, Person person2) {
		String value1 = person1.getPhone()==null?"":person1.getPhone();
		String value2 = person2.getPhone()==null?"":person2.getPhone();
		return value1.compareTo(value2);
	}

	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the name of the comments of event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareZips(Person person1, Person person2) {
		String value1 = person1.getZipCode()==null?"":person1.getZipCode();
		String value2 = person2.getZipCode()==null?"":person2.getZipCode();
		return value1.compareTo(value2);
	}
	
	
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the labels associated with the people.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareNames(Person person1, Person person2) {
		String value1 = person1.getName()==null?"":person1.getClass().getName()+person1.getName();
		String value2 = person2.getName()==null?"":person2.getClass().getName()+person2.getName();
		return value1.compareTo(value2);
	}
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the comments associated with the people.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareComments(Person person1, Person person2) {
		String value1 = person1.getComments()==null?"":person1.getComments();
		String value2 = person2.getComments()==null?"":person2.getComments();
		return value1.compareTo(value2);
	}
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the Pin associated with the people.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int comparePins(Person person1, Person person2) {
		String value1 = person1.getPin()==null?"":person1.getPin();
		String value2 = person2.getPin()==null?"":person2.getPin();
		return value1.compareTo(value2);
	}
	
	
	
	
}
