package com.verticon.tracker.irouter.measurement.logger;

import static com.verticon.tracker.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME_DEFAULT;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.service.cm.ConfigurationException;

import com.verticon.tracker.common.AbstractContext;

public class Context extends AbstractContext {
	
	public static final String LOGGER_TYPE ="logger.type";//Integer
	public static final Integer LOGGER_TYPE_NORMALIZING = 0;
	public static final Integer LOGGER_TYPE_AGGREGATING = 1;
	
	public static final String CONSUMER_SCOPE ="consumable.scope";//An array
	public static final String LOGGER_NAME = "logger.name";
	
	
	private static Dictionary<String, Object> DEFAULTS;
	static {
		DEFAULTS = new Hashtable<String, Object>();
		DEFAULTS.put(TRACKER_WIRE_GROUP_NAME,TRACKER_WIRE_GROUP_NAME_DEFAULT);
		DEFAULTS.put(CONSUMER_SCOPE,new String[]{});
		DEFAULTS.put(LOGGER_TYPE,LOGGER_TYPE_AGGREGATING);
		DEFAULTS.put(LOGGER_NAME,"");
	}
	
	public Context(String pid, Dictionary<?, ?> configuration,
			ExecutorService exec, ScheduledExecutorService scheduler)
			throws ConfigurationException {
		super(pid, configuration, exec, scheduler);
	}

	@Override
	protected Dictionary<?, ?> getDefaults() {
		return DEFAULTS;
	}

}
