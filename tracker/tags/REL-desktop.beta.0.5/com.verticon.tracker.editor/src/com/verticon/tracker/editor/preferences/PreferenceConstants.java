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
package com.verticon.tracker.editor.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {


	/**
	 * Duplicate events are ignored if they occur within this timeframe
	 * in seconds
	 */
	public static final int DEFAULT_IGNORE_WINDOW = 10;
	
	public static final String P_IGNORE_WINDOW = "ignoreWindowPreference";
	
	
	/**
	 * Should validation be done prior to generating export reports?
	 */
	public static final boolean DEFAULT_VALIDATE_BEFORE_EXPORT = true;
	
	public static final String P_VALIDATE_BEFORE_EXPORT = "validateBeforeExportPreference";
	
	
	/**
	 * Should submenus for Child and Sibling be used in Tracker Model element popup menus?
	 * 
	 */
	public static final boolean DEFAULT_USE_SUBMENUS = true;
	
	public static final String P_USE_SUBMENUS = "useSubMenusInPopupMenus";
	
	/**
	 * Events added to an animal must not have the same time.  This value specifies
	 * how many seconds to use to separate events when adding to the same animal if 
	 * the events are submitted with the same time.
	 */
	public static final int DEFAULT_SPREAD_INTERVAL = 1;
	
	public static final String P_SPREAD_INTERVAL = "spreadInterval";
	
}
