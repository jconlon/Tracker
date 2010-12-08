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
package com.verticon.tracker.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * Utility class for filtering Generic Objects from a collection.
 * 
 * @author jconlon
 *
 * @param <E>
 */
public class CollectionFilter<E> {
	private List <FilterCriteria<E>> filters = new ArrayList<FilterCriteria<E>>();
	
	/**
	 * 
	 * @param filterCriteria
	 */
	public void addFilter(FilterCriteria<E> filterCriteria){
		filters.add(filterCriteria);
	}
	
	/**
	 * 
	 * @param filterCriterias
	 */
	public void addFilters(Collection <FilterCriteria<E>> filterCriterias){
		filters.addAll(filterCriterias);
	}
	
	/**
	 * Apply filterCriteria to a copy of the collection filtering all items not specified by 
	 * the filterCriteria
	 * 
	 * @param collection to be filtered
	 * @return collection of filtered items
	 */
	public Collection<E> filterCopy(Collection<E> collection){
		List<E> list = new ArrayList<E>(collection);
		return filter(list);
	}

	/**
	 * Apply filterCriteria to collection filtering all items not specified by 
	 * the filterCriteria
	 * 
	 * @param collection to be filtered
	 * @return collection of filtered items
	 */
	public Collection<E> filter(Collection<E> collection) {
		if(filters.isEmpty()){
		   return collection;
		}
			for (FilterCriteria<E> filter : filters) {
				for (Iterator<E> iterator = collection.iterator(); iterator.hasNext();) {
					if (!filter.passes(iterator.next()))
						iterator.remove();
				}
			}
		
		return collection;
	}
	
}
