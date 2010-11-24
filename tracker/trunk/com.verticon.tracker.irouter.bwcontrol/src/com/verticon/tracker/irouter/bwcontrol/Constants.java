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
package com.verticon.tracker.irouter.bwcontrol;


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
	public static final String DISABLE_PRODUCTION_AFTER_RECORD ="abbott.stop.production.after.record";
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
			"transaction.state",
			"mettler.weight", 
			"animal.weight" };
	/**
	 * Hard coded to produce trutest command strings.
	 */
    final static String[] PRODUCER_SCOPE = {"trutest.commands"};

}
