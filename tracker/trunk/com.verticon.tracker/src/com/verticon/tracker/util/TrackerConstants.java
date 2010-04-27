package com.verticon.tracker.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Constant Utility Class
 * 
 * @author jconlon
 * 
 */
public class TrackerConstants {

	public final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static DateFormat DAY_FORMAT = new SimpleDateFormat("MMMM d, yyyy");
	private TrackerConstants() {
	} // Prevents Instantiation

	//Properties and Event creation
	public static final String EVENT_ADMIN_PROPERTY_EVENT_TYPE = "com.verticon.tracker.event.type";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_COMMENTS = "com.verticon.tracker.event.comments";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_DATE = "com.verticon.tracker.event.date";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_UNIT ="com.verticon.tracker.event.weighIn.unit";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT ="com.verticon.tracker.event.weighIn.weight";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_GENERICEVENT_OCDID ="com.verticon.tracker.event.weighIn.ocdid";
	
	
}
