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
package com.verticon.tracker.irouter.mettler;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI_DEFAULT;
import static com.verticon.tracker.irouter.common.TrackerConstants.POLL_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.REQUEST_COMMAND;
import static com.verticon.tracker.irouter.common.TrackerConstants.RESPONSE_PATTERN;
import static com.verticon.tracker.irouter.common.TrackerConstants.RETRY_CONNECTION_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.STABLE_WEIGHT_ERROR;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME_DEFAULT;
import static com.verticon.tracker.irouter.common.TrackerConstants.UNSTABLE_WEIGHT_ERROR;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.service.cm.ConfigurationException;

import com.verticon.tracker.irouter.common.AbstractContext;
import com.verticon.tracker.irouter.common.IContext;

public class Context extends AbstractContext implements
		IContext {

	static final String PRODUCER_WEIGHT_MEASUREMENT_NAME = "producer.weight.measurement.name";
	static final String PRODUCER_WEIGHT_MEASUREMENT_NAME_DEFAULT = "mettler.weight.measurement";
	static final Double UNSTABLE_WEIGHT_ERROR_DEFAULT = new Double(.01);
	static final Double STABLE_WEIGHT_ERROR_DEFAULT = new Double(.002);
	static final String NODE_LABEL = "tracker.monitor.label";
	static final String NODE_LABEL_DEFAULT = "Mettler Proxy";

	public static final Dictionary<String, Object> DEFAULTS;
	static {
		DEFAULTS = new Hashtable<String, Object>();
		DEFAULTS.put(CONNECTION_URI, CONNECTION_URI_DEFAULT);// socket://mudshark:2345
		DEFAULTS.put(STABLE_WEIGHT_ERROR, STABLE_WEIGHT_ERROR_DEFAULT);
		DEFAULTS.put(UNSTABLE_WEIGHT_ERROR, UNSTABLE_WEIGHT_ERROR_DEFAULT);
		DEFAULTS.put(PRODUCER_WEIGHT_MEASUREMENT_NAME, PRODUCER_WEIGHT_MEASUREMENT_NAME_DEFAULT);
		DEFAULTS.put(POLL_DELAY, new Long(100));
		// Set request to a space if no requests are sent to the balance
		// in the case the balance must be set to continuously send out weights
		DEFAULTS.put(REQUEST_COMMAND, "");// "SI%13%%10%");
		DEFAULTS.put(RESPONSE_PATTERN, "^S (D|S)((\\s*)(.*))\\sg$");
		DEFAULTS.put(TRACKER_WIRE_GROUP_NAME, TRACKER_WIRE_GROUP_NAME_DEFAULT);
		DEFAULTS.put(RETRY_CONNECTION_DELAY, new Long(5));
		DEFAULTS.put(NODE_LABEL, NODE_LABEL_DEFAULT);
	}
	
	@Override
	protected Dictionary<?, ?> getDefaults() {
		return DEFAULTS;
	}

	public Context(String pid, Dictionary<?, ?> configuration,
			ExecutorService exec, ScheduledExecutorService scheduler)
			throws ConfigurationException {
		super(pid, configuration, exec, scheduler);
	}

}
