package com.verticon.tracker.irouter.measurement.logger.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME_DEFAULT;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.service.cm.ConfigurationException;

import com.verticon.tracker.irouter.common.AbstractContext;

public class Context extends AbstractContext {
	
	public static final String LOGGER_TYPE ="logger.type";//Integer
	public static final Integer LOGGER_TYPE_NORMALIZING = 0;
	public static final Integer LOGGER_TYPE_AGGREGATING = 1;
	
	public static final String CONSUMER_MEASUREMENT_SCOPE ="consumer.measurement.scopes";//An array
	static final String CONSUMER_EID_SCOPE ="consumer.scope.eid";
    static final String CONSUMER_EID_SCOPE_DEFAULT = "animal.tag.number";
	static final String CONSUMER_STATE_SCOPE = "consumer.scope.control";
	static final String CONSUMER_STATE_SCOPE_DEFAULT = "transaction.state";
	static final String CONTROL_STATE_NAME ="consumer.transaction.state";
	static final String CONTROL_STATE_NAME_DEFAULT ="transaction.state" ;
	static final String CONTROL_STATE_VALUE = "consumer.transaction.state.value";
	
	static final String LOGGER_NAME = "logger.name";
    static final String WIRES_COUNT = "consumer.Connected_Wires";
    static final String LAST_LOG_ENTRY ="consumer.Last_Log_Entry";
	
	
	private static Dictionary<String, Object> DEFAULTS;
	static {
		DEFAULTS = new Hashtable<String, Object>();
		DEFAULTS.put(TRACKER_WIRE_GROUP_NAME,TRACKER_WIRE_GROUP_NAME_DEFAULT);
		DEFAULTS.put(CONSUMER_MEASUREMENT_SCOPE,new String[]{});
		DEFAULTS.put(LOGGER_TYPE,LOGGER_TYPE_AGGREGATING);
		DEFAULTS.put(LOGGER_NAME,"");
		
		DEFAULTS.put(CONSUMER_EID_SCOPE,CONSUMER_EID_SCOPE_DEFAULT);
		DEFAULTS.put(CONSUMER_STATE_SCOPE,CONSUMER_STATE_SCOPE_DEFAULT);
		DEFAULTS.put(CONTROL_STATE_NAME, CONTROL_STATE_NAME_DEFAULT) ;
		DEFAULTS.put(CONTROL_STATE_VALUE, 1);
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
