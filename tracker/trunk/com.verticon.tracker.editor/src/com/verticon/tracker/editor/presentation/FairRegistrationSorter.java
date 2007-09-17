/**
 * (c) Copyright Mirasol Op'nWorks Inc. 2002, 2003. 
 * http://www.opnworks.com
 * Created on Apr 2, 2003 by lgauthier@opnworks.com
 * 
 */

package com.verticon.tracker.editor.presentation;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;

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
	public final static int ANIMAL = 12;
	

	// Criteria that the instance uses 
	private final int criteria;
	private final int dir;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of <code>SPECIES</code> or 
	 *   <code>TYPE</code>
	 */
	public FairRegistrationSorter(int criteria, int dir) {
		super();
		this.criteria = criteria;
		this.dir = dir;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {
		FairRegistration fairRegistration1 = (FairRegistration) o1;
		FairRegistration fairRegistration2 = (FairRegistration) o2;

		int returnValue = 0;
		switch (criteria) {
			case DATETIME :
				returnValue = compareDateTimes(fairRegistration1, fairRegistration2);
				break;
			case PHONE :
				returnValue = comparePhones(fairRegistration1, fairRegistration2);
				break;
			case TAG_IDNUMBER :
				returnValue = compareTagIDNumber(fairRegistration1, fairRegistration2);
				break;
			case ANIMAL_IDNUMBER :
				returnValue = compareAnimalIDNumber(fairRegistration1, fairRegistration2);
				break;
			case PARENT :
				returnValue = compareParents(fairRegistration1, fairRegistration2);
				break;
			case EVENT_COMMENTS :
				returnValue = compareComments(fairRegistration1, fairRegistration2);
				break;
			case CLUB :
				returnValue = compareClubs(fairRegistration1, fairRegistration2);
				break;
			case PARTICIPANT :
				returnValue = compareParticipants(fairRegistration1, fairRegistration2);
				break;
			case ADDRESS :
				returnValue = compareAddresses(fairRegistration1, fairRegistration2);
				break;
			case BEGIN_WEIGHT :
				returnValue = compareBeginWeights(fairRegistration1, fairRegistration2);
				break;
			case END_WEIGHT :
				returnValue = compareEndWeights(fairRegistration1, fairRegistration2);
				break;
			case ANIMAL :
				returnValue = compareAnimals(fairRegistration1, fairRegistration2);
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
		String s1 = fairRegistration1.getParent()==null?"":fairRegistration1.getParent();
		String s2 = fairRegistration2.getParent()==null?"":fairRegistration2.getParent();
		return s1.compareTo(s2);
		
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
		String s1 = fairRegistration1.getComments()==null?"":fairRegistration1.getComments();
		String s2 = fairRegistration2.getComments()==null?"":fairRegistration2.getComments();
		return s1.compareTo(s2);
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
		String s1 = fairRegistration1.getPhone()==null?"":fairRegistration1.getPhone();
		String s2 = fairRegistration2.getPhone()==null?"":fairRegistration2.getPhone();
		return s1.compareTo(s2);
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
		String s1 = fairRegistration1.getClub()==null?"":fairRegistration1.getClub();
		String s2 = fairRegistration2.getClub()==null?"":fairRegistration2.getClub();
		return s1.compareTo(s2);
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
		String s1 = fairRegistration1.getParticipant()==null?"":fairRegistration1.getParticipant();
		String s2 = fairRegistration2.getParticipant()==null?"":fairRegistration2.getParticipant();
		return s1.compareTo(s2);
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
		String s1 = fairRegistration1.getAddress()==null?"":fairRegistration1.getAddress();
		String s2 = fairRegistration2.getAddress()==null?"":fairRegistration2.getAddress();
		return s1.compareTo(s2);
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
	 * Returns a number reflecting the collation order of the given events
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
	private int compareAnimals(FairRegistration fairRegistration1, FairRegistration fairRegistration2) {
		EObject o1 = fairRegistration1.getTag();
		EObject o2 = fairRegistration2.getTag();
		String s1 = o1==null?"":o1.eContainer()==null?"":o1.eContainer().getClass().getName();
		String s2 = o2==null?"":o2.eContainer()==null?"":o2.eContainer().getClass().getName();
		return s1.compareTo(s2);
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
