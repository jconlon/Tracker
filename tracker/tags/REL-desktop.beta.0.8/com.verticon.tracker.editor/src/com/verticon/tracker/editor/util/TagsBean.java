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
/**
 * 
 */
package com.verticon.tracker.editor.util;

import java.util.Collection;
import java.util.Date;

/**
 * Data container for a Collection of tags and a date to use for generating event 
 * timestamps.
 * 
 * @author jconlon
 *
 */
 public class TagsBean {
	private final Date date;
	private final Collection<Long> tags;
	private final String name;
	
	protected TagsBean(Date date, Collection<Long> tags, String name) {
		super();
		this.date = date;
		this.tags = tags;
		this.name = name;
	}

	/**
	 * 
	 * @return Date to use for the timestamp. May be a null if no timestamp is associtated 
	 * the tags
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * @return tags as a collection of Long objects
	 */
	public Collection<Long> getTags() {
		return tags;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Tags resource: "+ name;
	}
	
	
}
