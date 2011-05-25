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
package com.verticon.tracker.editor.util;

/**
 * Constant Utility Class
 * 
 * @author jconlon
 * 
 */
public class TrackerEditorConstants {

	private TrackerEditorConstants() {
	} // Prevents Instantiation

	/**
	 * Topic for transaction readers
	 */
	public static final String EVENT_ADMIN_TOPIC_READER = "com/verticon/tracker/reader";
	
	//Properties for AnimalTemplate and Event transmission
	public static final String EVENT_ADMIN_PROPERTY_ANIMAL_TEMPLATE = "com.verticon.tracker.animal";
	public static final String EVENT_ADMIN_PROPERTY_READER_NAME = "com.verticon.tracker.reader.name";
	public static final String EVENT_ADMIN_PROPERTY_ANIMAL_ID = "com.verticon.tracker.animal.id";
//	public static final String EVENT_ADMIN_PROPERTY_SOURCE = "com.verticon.tracker.source";
	
	public static final String EVENT_ADMIN_PROPERTY_EVENT_TYPE = "com.verticon.tracker.event.type";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_COMMENTS = "com.verticon.tracker.event.comments";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_DATE = "com.verticon.tracker.event.date";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_UNIT ="com.verticon.tracker.event.weighIn.unit";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT ="com.verticon.tracker.event.weighIn.weight";
	

	/**
	 * Topic for views
	 */
	// public static final String EVENT_ADMIN_TOPIC_VIEW =
	// "com/verticon/tracker/view";
	
	/**
	 * DataChannel Topic for Animals View
	 */
	public static final String EVENT_ADMIN_TOPIC_VIEW_SELECTION = "com/verticon/tracker/view/animal";
		
	
	protected static final String EVENT_ADMIN_PROPERTY_SELECTION = "com.verticon.tracker.view.selection";
	protected static final String EVENT_ADMIN_PROPERTY_SELECTION_SOURCE = "com.verticon.tracker.view.selection.source";
	public static final String EVENT_ADMIN_VALUE_SELECTION_SOURCE_ANIMALS_VIEW = "Animals Detail";
	public static final String EVENT_ADMIN_VALUE_SELECTION_SOURCE_EVENTS_VIEW = "Events Detail";
	
	
	

	
}
