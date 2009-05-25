/**
 * (c) Copyright Mirasol Op'nWorks Inc. 2002, 2003. 
 * http://www.opnworks.com
 * Created on Apr 2, 2003 by lgauthier@opnworks.com
 * 
 */

package com.verticon.tracker.fair.views;
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
 * @deprecated use GenericViewSorter
 */
public class ExhibitSorter extends ViewerSorter {

	// Criteria that the instance uses 
	private final ExhibitsView.ExhibitColumn criteria;
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
	public ExhibitSorter(ExhibitsView.ExhibitColumn criteria, int dir) {
		super();
		this.criteria = criteria;
		this.dir=dir;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {
		Exhibit exhibit1 = (Exhibit) o1;
		Exhibit exhibit2 = (Exhibit) o2;

		int returnValue = 0;
		
		switch (criteria) {
			case NUMBER :
				returnValue = compareNumbers(exhibit1, exhibit2);
				break;
			case ANIMAL :
				returnValue = compareAnimals(exhibit1, exhibit2);
				break;
			case LOT :
				returnValue = compareLots(exhibit1, exhibit2);
				break;
			case LOT_DESC :
				returnValue = compareLotDescriptions(exhibit1, exhibit2);
				break;
			case CLASS :
				returnValue = compareClasses(exhibit1, exhibit2);
				break;
			case CLASS_DESC :
				returnValue = compareClassDescriptions(exhibit1, exhibit2);
				break;
			case DEPARTMENT :
				returnValue = compareDepartments(exhibit1, exhibit2);
				break;
			case DEPARTMENT_DESC :
				returnValue = compareDepartmentDescriptions(exhibit1, exhibit2);
				break;
			case DIVISION :
				returnValue = compareDivisions(exhibit1, exhibit2);
				break;
			case DIVISION_DESC :
				returnValue = compareDivisionsDescription(exhibit1, exhibit2);
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
	 *
	 * @param exhibit1 the first element to be ordered
	 * @param exhibit2 the second element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareClasses(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = exhibit1.getLot().getClass_().getName()==null?
				"":exhibit1.getLot().getClass_().getName();
		String value2 = exhibit2.getLot().getClass_().getName()==null?
				"":exhibit2.getLot().getClass_().getName();
		return value1.compareTo(value2);
		
	}
	
	/**
	 *
	 * @param exhibit1 the first element to be ordered
	 * @param exhibit2 the second element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareClassDescriptions(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = exhibit1.getLot().getClass_().getDescription()==null?
				"":exhibit1.getLot().getClass_().getDescription();
		String value2 = exhibit2.getLot().getClass_().getDescription()==null?
				"":exhibit2.getLot().getClass_().getDescription();
		return value1.compareTo(value2);
		
	}
	
	/**
	 *
	 * @param exhibit1
	 * @param exhibit2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareLots(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = exhibit1.getLot().getName()==null?
				"":exhibit1.getLot().getName();
		String value2 = exhibit2.getLot().getName()==null?
				"":exhibit2.getLot().getName();
		return value1.compareTo(value2);
	}
	
	/**
	 *
	 * @param exhibit1
	 * @param exhibit2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareLotDescriptions(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = exhibit1.getLot().getDescription()==null?
				"":exhibit1.getLot().getDescription();
		String value2 = exhibit2.getLot().getDescription()==null?
				"":exhibit2.getLot().getDescription();
		return value1.compareTo(value2);
	}
	
	/**
	 * 
	 * @param exhibit1
	 * @param exhibit2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareDepartments(Exhibit exhibit1, Exhibit exhibit2) {
		
		String value1 = exhibit1.getLot().getClass_().getDepartment().getName()==null?
				"":exhibit1.getLot().getClass_().getDepartment().getName();
		String value2 = exhibit2.getLot().getClass_().getDepartment().getName()==null?
				"":exhibit2.getLot().getClass_().getDepartment().getName();
		return value1.compareTo(value2);
		
	}
	
	/**
	 * 
	 * @param exhibit1
	 * @param exhibit2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareDepartmentDescriptions(Exhibit exhibit1, Exhibit exhibit2) {
		
		String value1 = exhibit1.getLot().getClass_().getDepartment().getDescription()==null?
				"":exhibit1.getLot().getClass_().getDepartment().getDescription();
		String value2 = exhibit2.getLot().getClass_().getDepartment().getDescription()==null?
				"":exhibit2.getLot().getClass_().getDepartment().getDescription();
		return value1.compareTo(value2);
		
	}
	
	/**
	 *
	 * @param exhibit1
	 * @param exhibit2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareAnimals(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = (exhibit1.getAnimal()==null || exhibit1.getAnimal().getId()==null)?
				"":exhibit1.getAnimal().getId();
		String value2 = (exhibit2.getAnimal()==null || exhibit2.getAnimal().getId()==null)?
				"":exhibit2.getAnimal().getId();
		return value1.compareTo(value2);
		
	}

	/**
	 * @param exhibit1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareNumbers(Exhibit exhibit1, Exhibit exhibit2) {
		 if( exhibit1.getNumber() < exhibit2.getNumber()){
			 return -1;
		 }else if(exhibit1.getNumber() == exhibit2.getNumber()){
			return 0;
		 }
		 return 1;
	}

	/**
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareExhibitors(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = (exhibit1.getExhibitor()==null || exhibit1.getExhibitor().getName()==null)?
				"":exhibit1.getExhibitor().getName();
		String value2 = (exhibit2.getExhibitor()==null|| exhibit2.getExhibitor().getName()==null)?
				"":exhibit2.getExhibitor().getName();
		return value1.compareTo(value2);
		
	}

	/**
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareDivisions(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = exhibit1.getLot().getClass_().getDepartment().getDivision().getName()==null?
				"":exhibit1.getLot().getClass_().getDepartment().getDivision().getName();
		String value2 = exhibit2.getLot().getClass_().getDepartment().getDivision().getName()==null?
				"":exhibit2.getLot().getClass_().getDepartment().getDivision().getName();
		return value1.compareTo(value2);
	}

	/**
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareDivisionsDescription(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = exhibit1.getLot().getClass_().getDepartment().getDivision().getDescription()==null?
				"":exhibit1.getLot().getClass_().getDepartment().getDivision().getDescription();
		String value2 = exhibit2.getLot().getClass_().getDepartment().getDivision().getDescription()==null?
				"":exhibit2.getLot().getClass_().getDepartment().getDivision().getDescription();
		return value1.compareTo(value2);
	}
	
	/**
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareNames(Exhibit exhibit1, Exhibit exhibit2) {
		String value1 = exhibit1.getExhibitor()==null?"":exhibit1.getExhibitor().getName();
		String value2 = exhibit2.getExhibitor()==null?"":exhibit2.getExhibitor().getName();
		return value1.compareTo(value2);
		
		
	}
	
	/**
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	private int compareComments(Exhibit exhibit1, Exhibit exhibit2) {
		String comments1 = exhibit1.getComments()==null?"":exhibit1.getComments();
		String comments2 = exhibit2.getComments()==null?"":exhibit2.getComments();
		return comments1.compareTo(comments2);
	}
	
}
