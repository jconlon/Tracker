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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Constant Utility Class
 * 
 * @author jconlon
 * 
 */
public class TrackerConstants {

	
	
	private TrackerConstants() {
	} // Prevents Instantiation

	
	public static final String DAY_FORMAT_PATTERN = "MMMM d, yyyy";
	public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/**
	 * @deprecated not thread safe
	 */
	public final static DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);
	
	/**
	 * @deprecated not thread safe
	 */
	public final static DateFormat DAY_FORMAT = new SimpleDateFormat(DAY_FORMAT_PATTERN);
	
	//Properties and Event creation
	public static final String EVENT_ADMIN_PROPERTY_EVENT_TYPE = "com.verticon.tracker.event.type";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_COMMENTS = "com.verticon.tracker.event.comments";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_DATE = "com.verticon.tracker.event.date";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_UNIT ="com.verticon.tracker.event.weighIn.unit";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT ="com.verticon.tracker.event.weighIn.weight";
	public static final String EVENT_ADMIN_PROPERTY_EVENT_GENERICEVENT_OCDID ="com.verticon.tracker.event.weighIn.ocdid";
	
	
}
