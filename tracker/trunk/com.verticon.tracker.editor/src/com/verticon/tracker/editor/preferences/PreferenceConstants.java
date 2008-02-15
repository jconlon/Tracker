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
	
}
