package com.verticon.tracker.trigger.view.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

	public static final String P_REPORTS_PATH = "reportsPathPreference";
	public static final String P_TESTING_PATH = "testingPathPreference";
	public static final String P_TESTING_FILE_FORMAT = "testingFileFormatPreference";

	public static final String P_ROOT_STRING = "stringRootPreference";
	public static final String P_BODY_STRING = "stringBodyPreference";
	public static final String P_LABEL_EXTENSION_STRING = "stringLabelFileExtPreference";
	public static final String P_SHOW_LABEL_PATH_BOOLEAN = "booleanShowFullLabelPathPreference";
	public static final String P_PRINT_STRING = "stringPrintPreference";
	public static final String P_LOT_SEPARATOR_STRING = "stringLotSepartorPreference";

	public static final String P_VALID_LOT_SUFFIXES_STRING = "stringLotValidSuffixesPreference";
	public static final String P_VALID_LOT_ID_MAX_SIZE_INTEGER = "stringLotValidIDMaxSizePreference";

	public static final String PRINTER = "<PRINTER>";
	public static final String LABEL_FILE = "<LABEL_FILE>";


	public static final String DEFAULT_TESTING_FILE_FORMAT = "measurement-***.txt";
	public static final String DEFAULT_LOT_SEPARATOR = "-";
	public static final String DEFAULT_FILE_EXTENSION = "*.btw";
	/**
	 * Value,unit,datestamp-mmddyy,error
	 */
	public static final String DEFAULT_BODY = "%3$5.2f,%2$s,%1$tm%1$td%ty,%4$5.4f";
	public static final String DEFAULT_ROOT = "%%BTW%% /AF=\"" + LABEL_FILE
			+ "\" /D=<Trigger File Name> /PRN=\"" + PRINTER
			+ "\" /R=3 /P /DD %n%%END%%%n";

}
