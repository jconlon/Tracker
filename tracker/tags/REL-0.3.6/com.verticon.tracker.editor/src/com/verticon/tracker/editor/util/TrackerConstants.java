package com.verticon.tracker.editor.util;

/**
 * Constant Utility Class
 * 
 * @author jconlon
 * 
 */
public class TrackerConstants {

	private TrackerConstants() {
	} // Prevents Instantiation

	/**
	 * Topic for transaction readers
	 */
	public static final String EVENT_ADMIN_TOPIC_READER = "com/verticon/tracker/reader";
	public static final String EVENT_ADMIN_PROPERTY_ANIMAL_TEMPLATE = "com.verticon.tracker.animal";
	public static final String EVENT_ADMIN_PROPERTY_READER_NAME = "com.verticon.tracker.reader.name";
	

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
