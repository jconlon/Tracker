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

import com.verticon.tracker.Event;
import com.verticon.tracker.util.CommonUtilities;


/**
 * Sorter for the Event that displays items of type 
 * <code>Event</code>.
 * The sorter supports three sort criteria:
 * <p>
 * <code>BIRTHDATE</code>: Date of Event (String)
 * </p>
 * <p>
 * <code>SPECIES</code>: Name of Event(String)
 * </p>
 * <p>
 * <code>AIN</code>: AIN number of the event (String).
 * </p>
 */
public class EventSorter extends ViewerSorter {

	/**
	 * Constructor argument values that indicate to sort items by 
	 * description, owner or percent complete.
	 */
	public final static int DATETIME = 1;
	public final static int NAME 	= 2;
	public final static int AIN 	= 3;
	

	// Criteria that the instance uses 
	private int criteria;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of <code>SPECIES</code> or 
	 *   <code>TYPE</code>
	 */
	public EventSorter(int criteria) {
		super();
		this.criteria = criteria;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {
		Event event1 = (Event) o1;
		Event event2 = (Event) o2;

		switch (criteria) {
			case DATETIME :
				return compareDateTimes(event1, event2);
			case NAME :
				return compareNames(event1, event2);
			case AIN :
				return compareAins(event1, event2);
			default:
				return 0;
		}
	}

	
	
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the AIN number.
	 *
	 * @param event1
	 * @param event2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareAins(Event event1, Event event2) {
		return new Long(event1.getIdNumber()).compareTo(event2.getIdNumber());
	}

	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the dateTimes.
	 *
	 * @param event1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareDateTimes(Event event1, Event event2) {
		Date date1 = event1.getDateTime()==null?CommonUtilities.DATE_REFERENCE.getTime():event1.getDateTime();
		Date date2 = event2.getDateTime()==null?CommonUtilities.DATE_REFERENCE.getTime():event2.getDateTime();
		return date1.compareTo(date2);
	}


	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the name of the class of event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareNames(Event event1, Event event2) {
		return getComparator().compare(event1.getClass().getSimpleName(), 
				event2.getClass().getSimpleName());
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
