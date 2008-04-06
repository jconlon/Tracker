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

import com.verticon.tracker.fair.Exhibit;


/**
 * Sorter that relates items of type 
 * <code>Exhibit</code>.
 * The sorter supports three sort criteria:
 * Name, Number, Exhibitor, Animal, Lot, Class, Department, Division, Comments
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
public class ExhibitSorter extends ViewerSorter {

	/**
	 * Constructor argument values that indicate to sort items by 
	 * description, owner or percent complete.
	 */
	public final static int NUMBER = 1;
	public final static int EXHIBITOR = 2;
	public final static int ANIMAL 	= 3;
	public final static int	LOT	= 4;
	public final static int CLASS		= 5;
	public final static int DEPARTMENT = 6;
	public final static int DIVISION = 7;
	public final static int NAME = 8;
	public final static int COMMENTS = 9;
	

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
	public ExhibitSorter(int criteria, int dir) {
		super();
		this.criteria = criteria;
		this.dir=dir;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {
		Exhibit exhibit1 = (Exhibit) o1;
		Exhibit exhibit2 = (Exhibit) o2;

		int returnValue = 0;
		
		switch (criteria) {
			case NUMBER :
				returnValue = compareNumbers(exhibit1, exhibit2);
				break;
			case EXHIBITOR :
				returnValue = compareExhibitors(exhibit1, exhibit2);
				break;
			case ANIMAL :
				returnValue = compareAnimals(exhibit1, exhibit2);
				break;
			case LOT :
				returnValue = compareLots(exhibit1, exhibit2);
				break;
			case CLASS :
				returnValue = compareClasses(exhibit1, exhibit2);
				break;
			case DEPARTMENT :
				returnValue = compareDepartments(exhibit1, exhibit2);
				break;
			case DIVISION :
				returnValue = compareDivisions(exhibit1, exhibit2);
				break;
			case NAME :
				returnValue = compareNames(exhibit1, exhibit2);
				break;
			case COMMENTS :
				returnValue = compareComments(exhibit1, exhibit2);
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
	 * Returns a number reflecting the collation order of the given exhibit
	 * based on the Class.
	 *
	 * @param exhibit1 the first element to be ordered
	 * @param exhibit2 the second element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareClasses(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(
				exhibit1.getLot().getClass_(), exhibit2.getLot().getClass_());
	}
	
	
	
	/**
	 * Returns a number reflecting the collation order of the given exhibit
	 * based on the Log
	 *
	 * @param exhibit1
	 * @param exhibit2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareLots(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(
				exhibit1.getLot(), exhibit2.getLot());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the name of the Last Name
	 *
	 * @param exhibit1
	 * @param exhibit2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareDepartments(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(
				exhibit1.getLot().getClass_().getDepartment(), 
				exhibit2.getLot().getClass_().getDepartment());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the firstName.
	 *
	 * @param exhibit1
	 * @param exhibit2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareAnimals(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(exhibit1.getAnimal(), exhibit2.getAnimal());
	}

	
	
	/**
	 * Returns a number reflecting the collation order of the given people
	 * based on the State.
	 *
	 * @param exhibit1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareNumbers(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(exhibit1.getNumber(), exhibit2.getNumber());
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
	protected int compareExhibitors(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(exhibit1.getExhibitor(), exhibit2.getExhibitor());
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
	protected int compareDivisions(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(
				exhibit1.getLot().getClass_().getDepartment().getDivision(), 
				exhibit2.getLot().getClass_().getDepartment().getDivision());
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
	protected int compareNames(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(exhibit1.getName(), exhibit2.getName());
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
	protected int compareComments(Exhibit exhibit1, Exhibit exhibit2) {
		return getComparator().compare(exhibit1.getComments(), exhibit2.getComments());
	}
	
	
	
}
