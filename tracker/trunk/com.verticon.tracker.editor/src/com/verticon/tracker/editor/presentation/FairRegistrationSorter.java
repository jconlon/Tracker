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
import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.edit.provider.FairRegistrationItemProvider;
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
public class FairRegistrationSorter extends ViewerSorter {

	/**
	 * Constructor argument values that indicate to sort items by 
	 * description, owner or percent complete.
	 */
	public final static int DATETIME = 1;
	public final static int PARTICIPANT = 2; 
	public final static int TAG_IDNUMBER 	= 3;
	public final static int ANIMAL_IDNUMBER 	= 4;
	public final static int ADDRESS 	= 5;
	public final static int EVENT_COMMENTS 	= 6;
	public final static int CLUB = 7; 
	public final static int PARENT = 8; 
	public final static int PHONE = 9;
	public final static int BEGIN_WEIGHT = 10;
	public final static int END_WEIGHT = 11;
	

	// Criteria that the instance uses 
	private int criteria;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of <code>SPECIES</code> or 
	 *   <code>TYPE</code>
	 */
	public FairRegistrationSorter(int criteria) {
		super();
		this.criteria = criteria;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {
		FairRegistration fairRegistration1 = (FairRegistration) o1;
		FairRegistration fairRegistration2 = (FairRegistration) o2;

		switch (criteria) {
			case DATETIME :
				return compareDateTimes(fairRegistration1, fairRegistration2);
			case PHONE :
				return comparePhones(fairRegistration1, fairRegistration2);
			case TAG_IDNUMBER :
				return compareTagIDNumber(fairRegistration1, fairRegistration2);
			case ANIMAL_IDNUMBER :
				return compareAnimalIDNumber(fairRegistration1, fairRegistration2);
			case PARENT :
				return compareParents(fairRegistration1, fairRegistration2);
			case EVENT_COMMENTS :
				return compareComments(fairRegistration1, fairRegistration2);
			case CLUB :
				return compareClubs(fairRegistration1, fairRegistration2);
			case PARTICIPANT :
				return compareParticipants(fairRegistration1, fairRegistration2);
			case ADDRESS :
				return compareAddresses(fairRegistration1, fairRegistration2);
			case BEGIN_WEIGHT :
				return compareBeginWeights(fairRegistration1, fairRegistration2);
			case END_WEIGHT :
				return compareEndWeights(fairRegistration1, fairRegistration2);
			default:
				return 0;
		}
	}


	
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the TagID number.
	 *
	 * @param fairRegistration1
	 * @param fairRegistration2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareTagIDNumber(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		return new Long(fairRegistration1.getIdNumber()).compareTo(fairRegistration2.getIdNumber());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the Event Tag's Animal ID number.
	 *
	 * @param fairRegistration1
	 * @param fairRegistration2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareAnimalIDNumber(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		Animal animal1 = (Animal)fairRegistration1.getTag().eContainer();
		Animal animal2 = (Animal)fairRegistration2.getTag().eContainer();
		return new Long(animal1.getIdNumber()).compareTo(animal2.getIdNumber());
	}

	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the dateTimes.
	 *
	 * @param fairRegistration1 the first task element to be ordered
	 * @param resource2 the second task element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	protected int compareDateTimes(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		Date date1 = fairRegistration1.getDateTime()==null?CommonUtilities.DATE_REFERENCE.getTime():fairRegistration1.getDateTime();
		Date date2 = fairRegistration2.getDateTime()==null?CommonUtilities.DATE_REFERENCE.getTime():fairRegistration2.getDateTime();
		return date1.compareTo(date2);
	}


	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the Parent of event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareParents(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		return fairRegistration1.getParent().compareTo(fairRegistration2.getParent());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given events
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
	protected int compareComments(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		String comments1 = fairRegistration1.getComments()==null?"":fairRegistration1.getComments();
		String comments2 = fairRegistration2.getComments()==null?"":fairRegistration2.getComments();
		return comments1.compareTo(comments2);
	}
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the Phone of event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int comparePhones(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		return fairRegistration1.getPhone().compareTo(fairRegistration2.getPhone());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the Club of the event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareClubs(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		return fairRegistration1.getClub().compareTo(fairRegistration2.getClub());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the Participant of the event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareParticipants(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		return fairRegistration1.getParticipant().compareTo(fairRegistration2.getParticipant());
	}
	
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the Address of the event.
	 *
	 * @param resource1 the first resource element to be ordered
	 * @param resource2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareAddresses(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		return fairRegistration1.getAddress().compareTo(fairRegistration2.getAddress());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the begining WeighIn weights.
	 *
	 * @param fairRegistration1
	 * @param fairRegistration2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareBeginWeights(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		return FairRegistrationItemProvider.getBeginWeight(fairRegistration1) - FairRegistrationItemProvider.getBeginWeight(fairRegistration2);
	}
	
	/**
	 * Returns a number reflecting the collation order of the given events
	 * based on the begining WeighIn weights.
	 *
	 * @param fairRegistration1
	 * @param fairRegistration2
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareEndWeights(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		return FairRegistrationItemProvider.getEndWeight(fairRegistration1) - FairRegistrationItemProvider.getEndWeight(fairRegistration2);
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
