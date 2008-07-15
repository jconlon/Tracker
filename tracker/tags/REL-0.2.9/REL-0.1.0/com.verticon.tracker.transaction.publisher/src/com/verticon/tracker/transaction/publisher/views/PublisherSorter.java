/**
 * (c) Copyright Mirasol Op'nWorks Inc. 2002, 2003. 
 * http://www.opnworks.com
 * Created on Apr 2, 2003 by lgauthier@opnworks.com
 * 
 */

package com.verticon.tracker.transaction.publisher.views;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import com.verticon.tracker.transaction.publisher.Publisher;

/**
 * Sorter for the Publisher that displays items of type 
 * <code>ExampleTask</code>.
 * The sorter supports three sort criteria:
 * <p>
 * <code>BIRTHDATE</code>: Task description (String)
 * </p>
 * <p>
 * <code>SPECIES</code>: Task Owner (String)
 * </p>
 * <p>
 * <code>AIN</code>: Task percent completed (int).
 * </p>
 */
public class PublisherSorter extends ViewerComparator {

	/**
	 * Constructor argument values that indicate to sort items by 
	 * description, owner or percent complete.
	 */
	public final static int DESCRIPTION 		= 1;
	public final static int NAME 				= 2;
	public final static int STATUS 	= 3;
	public final static int TARGET 				= 4;
	public final static int TEMPLATE 	= 5;
	

	// Criteria that the instance uses 
	private int criteria;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of <code>SPECIES</code> or 
	 *   <code>TYPE</code>
	 */
	public PublisherSorter(int criteria) {
		super();
		this.criteria = criteria;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {

		Publisher publisher1 = (Publisher) o1;
		Publisher publisher2 = (Publisher) o2;

		switch (criteria) {
			case DESCRIPTION :
				return compareDescriptions(publisher1, publisher2);
			case NAME :
				return compareNames(publisher1, publisher2);
			case STATUS :
				return compareStatus(publisher1, publisher2);
			case TARGET :
				return compareTarget(publisher1, publisher2);
			case TEMPLATE :
				return compareTemplate(publisher1, publisher2);
			default:
				return 0;
		}
	}

	/**
	 * Returns a number reflecting the collation order of the given tasks
	 * based on the template.
	 *
	 * @param publisher1
	 * @param publisher2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareTemplate(Publisher publisher1, Publisher publisher2) {
		return getComparator().compare(publisher1.getTemplate(), publisher2.getTemplate());
		
	}
	
	/**
	 * Returns a number reflecting the collation order of the given tasks
	 * based on the target.
	 *
	 * @param publisher1
	 * @param publisher2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareTarget(Publisher publisher1, Publisher publisher2) {
		return getComparator().compare(publisher1.getTarget(), publisher2.getTarget());
		
	}
	
	/**
	 * Returns a number reflecting the collation order of the given tasks
	 * based on the status.
	 *
	 * @param publisher1
	 * @param publisher2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareStatus(Publisher publisher1, Publisher publisher2) {
		return getComparator().compare(publisher1.getStatus(), publisher2.getStatus());
		
	}

	/**
	 * Returns a number reflecting the collation order of the given tasks
	 * based on the description.
	 *
	 * @param publisher1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareDescriptions(Publisher publisher1, Publisher publisher2) {
		return getComparator().compare(publisher1.getDescription(), publisher2.getDescription());
	}

	/**
	 * Returns a number reflecting the collation order of the given tasks
	 * based on their owner.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareNames(Publisher publisher1, Publisher publisher2) {
		return getComparator().compare(publisher1.getName(), publisher2.getName());
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
