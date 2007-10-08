
package com.verticon.tracker.transaction.publisher.views;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import com.verticon.tracker.transaction.publisher.IPublisher;
import com.verticon.tracker.transaction.publisher.views.PublisherViewer.Column;

/**
 * Sorter for the PublisherViewer
 *
 */

public class PublisherSorter extends ViewerSorter {
	
	// Criteria that the instance uses 
	private Column criteria;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of <code>NAME</code> or 
	 *   <code>TYPE</code> or <code>TEMPLATE</code> or <code>TARGET</code> columns
	 */
	public PublisherSorter(Column criteria) {
		super();
		this.criteria = criteria;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {

		IPublisher task1 = (IPublisher) o1;
		IPublisher task2 = (IPublisher) o2;
		
		if (criteria==Column.NAME) {
			return compareNames(task1, task2);
		}else if (criteria==Column.TYPE){
			return compareTypes(task1, task2);
		}else if (criteria==Column.TEMPLATE){
			return compareTemplates(task1, task2);
		}else {
			return compareTargets(task1, task2);
		}
	}

	
	/**
	 * Returns a number reflecting the collation order of the given Publisher
	 * based on the names.
	 *
	 * @param publisher1 the first publisher element to be ordered
	 * @param publisher2 the second publisher element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareNames(IPublisher publisher1, IPublisher publisher2) {
		return getComparator().compare(publisher1.getName(), publisher2.getName());
	}

	/**
	 * Returns a number reflecting the collation order of the given publisher
	 * based on their Type.
	 *
	 * @param publisher1 the first resource element to be ordered
	 * @param publisher2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareTypes(IPublisher publisher1, IPublisher publisher2) {
		return getComparator().compare(publisher1.getType(), publisher2.getType());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given publisher
	 * based on their Template.
	 *
	 * @param publisher1 the first resource element to be ordered
	 * @param publisher2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareTemplates(IPublisher publisher1, IPublisher publisher2) {
		return getComparator().compare(publisher1.getTemplate(), publisher2.getTemplate());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given publisher
	 * based on their Target.
	 *
	 * @param publisher1 the first resource element to be ordered
	 * @param publisher2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	protected int compareTargets(IPublisher publisher1, IPublisher publisher2) {
		return getComparator().compare(publisher1.getTarget(), publisher2.getTarget());
	}
	
}
