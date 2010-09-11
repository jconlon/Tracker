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

import static com.verticon.tracker.irouter.bwcontrol.Constants.*;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME_DEFAULT;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.service.cm.ConfigurationException;

import com.verticon.tracker.irouter.common.AbstractContext;

public class ControllerContext extends AbstractContext {
	private static Dictionary<String, Object> DEFAULTS;
	
	static {
		DEFAULTS = new Hashtable<String, Object>();
		DEFAULTS.put(TRACKER_WIRE_GROUP_NAME,TRACKER_WIRE_GROUP_NAME_DEFAULT);
		DEFAULTS.put(BEEP_COMMAND,  "{SABP500}%13%");
		/*
		 * To write actual and calculated data to the display, the ports fields, and the 
		 * minimum number of characters must be specified.
		 * Change the defaults if the indicator is reconfigured changing field locations.
		 * SXD1 is Com Port 1, 8 is the first data field, 9 the second.
		 * SXC1 is Com Port 1 and 6 is the number of characters.
		 */
		DEFAULTS.put(ACT_BW_ID, "{SXD19}%13%%10%{SXC16}%13%");
		DEFAULTS.put(CAL_BW_ID, "{SXD18}%13%%10%{SXC16}%13%");
		DEFAULTS.put(BW_MULT,  ".01");
		DEFAULTS.put(BW_ALARM_TRIGGER,  ".75");
		DEFAULTS.put(BW_ALARM_SECONDS,  "5");
		DEFAULTS.put(DISPLAY_UNITS,  DISPLAY_UNITS_KILOGRAMS);
		DEFAULTS.put(CALCULATION_THRESHOLD, "5");
		DEFAULTS.put(DISABLE_PRODUCTION_AFTER_RECORD, Boolean.TRUE);
	}

	/**
	 * Constructor
	 * 
	 * @param pid
	 */
	public ControllerContext(String pid, Dictionary<?, ?> configuration,
			ExecutorService exec, ScheduledExecutorService scheduler)
			throws ConfigurationException {

		super(pid, configuration, exec, scheduler);
	}

	@Override
	protected Dictionary<?, ?> getDefaults() {
		return DEFAULTS;
	}

	
	
}
