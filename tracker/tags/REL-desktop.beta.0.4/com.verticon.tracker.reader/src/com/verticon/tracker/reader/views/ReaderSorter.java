/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.reader.views;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.views.ReaderViewer.Column;

/**
 * Sorter for the ReaderViewer
 *
 */

class ReaderSorter extends ViewerSorter {
	
	// Criteria that the instance uses 
	private Column criteria;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of <code>NAME</code> or 
	 *   <code>TYPE</code> or <code>TEMPLATE</code> or <code>TARGET</code> columns
	 */
	protected ReaderSorter(Column criteria) {
		super();
		this.criteria = criteria;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {

		IReader task1 = (IReader) o1;
		IReader task2 = (IReader) o2;
		
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
	 * @param reader1 the first publisher element to be ordered
	 * @param reader2 the second publisher element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareNames(IReader reader1, IReader reader2) {
		return getComparator().compare(reader1.getName(), reader2.getName());
	}

	/**
	 * Returns a number reflecting the collation order of the given publisher
	 * based on their Type.
	 *
	 * @param reader1 the first resource element to be ordered
	 * @param reader2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareTypes(IReader reader1, IReader reader2) {
		return getComparator().compare(reader1.getType(), reader2.getType());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given publisher
	 * based on their Template.
	 *
	 * @param reader1 the first resource element to be ordered
	 * @param reader2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareTemplates(IReader reader1, IReader reader2) {
		return getComparator().compare(reader1.getTemplate(), reader2.getTemplate());
	}
	
	/**
	 * Returns a number reflecting the collation order of the given publisher
	 * based on their Target.
	 *
	 * @param reader1 the first resource element to be ordered
	 * @param reader2 the second resource element to be ordered
	 * @return a negative number if the first element is less  than the 
	 *  second element; the value <code>0</code> if the first element is
	 *  equal to the second element; and a positive number if the first
	 *  element is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareTargets(IReader reader1, IReader reader2) {
		return getComparator().compare(reader1.getTarget(), reader2.getTarget());
	}
	
}
