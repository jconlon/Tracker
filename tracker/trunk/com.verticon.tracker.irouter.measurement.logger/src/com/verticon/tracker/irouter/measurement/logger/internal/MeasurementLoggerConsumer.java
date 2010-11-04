/**
 * 
 */
package com.verticon.tracker.irouter.measurement.logger.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

/**
 * Measurement to Tracker Log Gateway that caches measurements and animal ids
 * transforming them into Log entrys and sending these to the slf4j Log service.
 * 
 * @author jconlon
 * 
 */
public class MeasurementLoggerConsumer implements Consumer, Monitorable {
   
    static final String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.logger";
    public static final Marker bundleMarker = MarkerFactory
	.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	//Configuration
	private static final String LOGGER_TYPE ="logger.type";//Integer
	@SuppressWarnings("unused")
	private static final Integer LOGGER_TYPE_NORMALIZING = 0;
	private static final Integer LOGGER_TYPE_AGGREGATING = 1;
	/**
	 * Name of the log4j category
	 *  log4j.category.<value>
	 * Name of the logback logger name
	 * <logger name="<value>">
	 * 
	 */
	private static final String LOGGER_NAME = "logger.name";
	private static final String CONTROL_STATE_NAME = "consumer.transaction.state";
	private static final String CONTROL_STATE_VALUE = "consumer.transaction.state.value";

	//Status variables
	private static final String LAST_LOG_ENTRY ="consumer.Last_Log_Entry";
	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String LOG_ENTRY_SENT_COUNT = "consumer.Log_Entries_Sent";
	private static final String MEASUREMENT_QUEUE_DEPTH = "consumer.Measurements_In_Queue";
	private static final String CURRENT_EID = "consumer.Current_EID";
	private static final String CONNECTION_URI_STATUS_VAR = "consumer.Connection_URI";
	
	//Misc
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	
	private Map<String, Object> config = null;
	
	
	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(MeasurementLoggerConsumer.class);

	private AbstractTransactionHandler delegate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MeasurementLoggerConsumer [config=" + config + "]";
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		this.config = config;
		log.debug(bundleMarker, "Activating...");
		for (Map.Entry<String, Object> entry : config.entrySet()) {
			log.debug(bundleMarker, "Property key={} value={}", entry.getKey(),
					entry.getValue());
		}
		State state = new State(getConfigInteger(CONTROL_STATE_VALUE),
				getConfigString(CONTROL_STATE_NAME));

		if (getConfigInteger(LOGGER_TYPE).equals(
				LOGGER_TYPE_AGGREGATING)) {
			delegate = new AggregatedTransactionLogger(
					getLoggerType(AggregatedTransactionLogger.class), state);
		} else {
			delegate = new NormalizedTransactionLogger(
					getConfigString(TRACKER_WIRE_GROUP_NAME), state,
					getLoggerType(NormalizedTransactionLogger.class));
		}

	}

	private Logger getLoggerType(Class<?> z) {
		String loggerName = getConfigString(LOGGER_NAME);
		if (loggerName == null || loggerName.trim().length() == 0) {
			return LoggerFactory.getLogger(z);
		}
		return LoggerFactory.getLogger(loggerName);
	}

	private String getConfigString(String key) {
		return (String) config.get(key);
	}
	
	public Integer getConfigInteger(String key) {
		Object conf = config.get( key);
		if(conf instanceof String){
			return new Integer((String)conf);
		}
		return (Integer)conf;
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		this.config.clear();
		log.debug(bundleMarker, "deactivating...");
	}

	@Override
	public void updated(Wire wire, Object in) {
		log.debug(bundleMarker, "Invoked updated with value={}", in);
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			delegate.add(envelope);
		} else {
			log.error(bundleMarker,
					"Unknown object={} was received from wire scope={}", in,
					Arrays.toString(wire.getScope()));
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		log.debug(bundleMarker, "Invoked producerConnected with wires={}",
				Arrays.toString(wires));
		producersConnected.set(wires!=null?wires.length:0);
	}

	
	@Override
	public String[] getStatusVariableNames() {
		return new String[] { 
				CONNECTED_PRODUCERS_COUNT, 
				LAST_LOG_ENTRY, 
				LOG_ENTRY_SENT_COUNT,
				MEASUREMENT_QUEUE_DEPTH, 
				CURRENT_EID, 
				CONNECTION_URI_STATUS_VAR };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					producersConnected.get());
		} else if (LAST_LOG_ENTRY.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					((ILogger) delegate).getLastLogEntry());
		}else if (LOG_ENTRY_SENT_COUNT.equals(name)){
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					((ILogger) delegate).transactionsLogged());
		}else if (MEASUREMENT_QUEUE_DEPTH.equals(name)){
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					((ILogger) delegate).getMeasurementsSize());
		} else if (CURRENT_EID.equals(name)){
			return new StatusVariable(name, StatusVariable.CM_DER,
					((ILogger) delegate).getCurrentEID());
		} else if (CONNECTION_URI_STATUS_VAR.equals(name)){
				return
				new StatusVariable(name,
						StatusVariable.CM_DER,
						getConfigString(CONNECTION_URI)
						);
			
		} else {
			throw new IllegalArgumentException("Invalid Status Variable name "
					+ name);
		}
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {

		return false;
	}
	
	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if (CONNECTED_PRODUCERS_COUNT.equals(id)) {
			return "The number of connected wires.";
		} else if (LAST_LOG_ENTRY.equals(id)) {
			return ((ILogger) delegate).getLastLogEntryDescription();
		} else if (LOG_ENTRY_SENT_COUNT.equals(id)){
			return "The number of log entries sent to the log service.";
		} else if (MEASUREMENT_QUEUE_DEPTH.equals(id)) {
			return "The number of measurements in the queued to be sent to the log service on the next trigger state.";
		} else if (CURRENT_EID.equals(id)){
			return "The EID number to be associated with the measurements in queued to be sent to the log service.";
		} else if (CONNECTION_URI_STATUS_VAR.equals(id)){
			return "The URI of the connected logger.";
		}
		return null;
	}

}
