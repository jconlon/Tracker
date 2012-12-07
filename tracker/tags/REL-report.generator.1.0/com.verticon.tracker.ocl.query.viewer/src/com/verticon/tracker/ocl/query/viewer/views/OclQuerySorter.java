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
package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewer.Column;

/**
 * Sorter for the QueryViewer
 * 
 */

class OclQuerySorter extends ViewerSorter {

	// Criteria that the instance uses
	private Column criteria;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 * 
	 * @param criteria
	 *            the sort criterion to use: one of <code>NAME</code> or
	 *            <code>TYPE</code> or <code>TEMPLATE</code> or
	 *            <code>TARGET</code> columns
	 */
	protected OclQuerySorter(Column criteria) {
		super();
		this.criteria = criteria;
	}

	/*
	 * (non-Javadoc) Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {

		IOclQuery task1 = (IOclQuery) o1;
		IOclQuery task2 = (IOclQuery) o2;

		if (criteria == Column.NAME) {
			return compareNames(task1, task2);
		} else if (criteria == Column.TYPE) {
			return compareContexts(task1, task2);
		} else if (criteria == Column.ERRORS) {
			return compareDescriptions(task1, task2);
		} else {
			return compareQueries(task1, task2);
		}
	}

	/**
	 * Returns a number reflecting the collation order of the given Query based
	 * on the names.
	 * 
	 * @param query1
	 *            the first query element to be ordered
	 * @param query2
	 *            the second query element to be ordered
	 * @return a negative number if the first element is less than the second
	 *         element; the value <code>0</code> if the first element is equal
	 *         to the second element; and a positive number if the first element
	 *         is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareNames(IOclQuery query1, IOclQuery query2) {
		return getComparator().compare(query1.getName(), query2.getName());
	}

	/**
	 * Returns a number reflecting the collation order of the given query based
	 * on their Type.
	 * 
	 * @param query1
	 *            the first resource element to be ordered
	 * @param query2
	 *            the second resource element to be ordered
	 * @return a negative number if the first element is less than the second
	 *         element; the value <code>0</code> if the first element is equal
	 *         to the second element; and a positive number if the first element
	 *         is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareContexts(IOclQuery query1, IOclQuery query2) {
		return getComparator().compare(query1.getType(), query2.getType());
	}

	/**
	 * Returns a number reflecting the collation order of the given query based
	 * on their Template.
	 * 
	 * @param query1
	 *            the first resource element to be ordered
	 * @param query2
	 *            the second resource element to be ordered
	 * @return a negative number if the first element is less than the second
	 *         element; the value <code>0</code> if the first element is equal
	 *         to the second element; and a positive number if the first element
	 *         is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareDescriptions(IOclQuery query1, IOclQuery query2) {
		return getComparator().compare(query1.getErrorSyntax(),
				query2.getErrorSyntax());
	}

	/**
	 * Returns a number reflecting the collation order of the given query based
	 * on their Target.
	 * 
	 * @param query1
	 *            the first resource element to be ordered
	 * @param query2
	 *            the second resource element to be ordered
	 * @return a negative number if the first element is less than the second
	 *         element; the value <code>0</code> if the first element is equal
	 *         to the second element; and a positive number if the first element
	 *         is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	private int compareQueries(IOclQuery query1, IOclQuery query2) {
		return getComparator().compare(query1.getQuery(), query2.getQuery());
	}

}
