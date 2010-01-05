package com.verticon.tracker.irouter.abbott;

import static com.verticon.tracker.common.TrackerConstants.*;

public class Constants {

	private Constants() {
	}// prevents instantiation

	public static final String BEEP_COMMAND = "trutest.beepCommand";
	public static final String BW_MULT = "abbott.bwmult";
	public static final String BW_ALARM_TRIGGER = "abbott.bwalarm.trigger";
	public static final String BW_ALARM_SECONDS = "abbott.bwalarm.period";
	public static final String ACT_BW_ID = "trutest.actbw.field";
	public static final String CAL_BW_ID = "trutest.calbw.field";
	public static final String DISPLAY_UNITS = "trutest.field.units";
	public static final Integer DISPLAY_UNITS_GRAMS = 0;
	public static final Integer DISPLAY_UNITS_KILOGRAMS = 1;
	public static final String CALCULATION_THRESHOLD = "abbott.calbw.threashold";
	final static int TRANSACTION_STATE = 0;
//	final static int ANIMAL_TAG_NUMBER_SCOPE = 1;
	final static int METTLER_WEIGHT_MEASUREMENT = 1;// works
	final static int ANIMAL_WEIGHT_MEASUREMENT = 2;
	/**
	 * Hard coded to listen to Mettler weight measurement producers
	 */
	final static String[] CONSUMER_SCOPE = { 
			TRANSACTION_STATE_SCOPE,
			"mettler."+WEIGHT_MEASUREMENT_SCOPE, 
			ANIMAL_WEIGHT_MEASUREMENT_SCOPE };
	/**
	 * Hard coded to produce trutest command strings.
	 */
    final static String[] PRODUCER_SCOPE = {"trutest."+COMMAND_STRING_SCOPE};

}
