package com.verticon.tracker.irouter.measurement.logger.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.measurement.logger.internal.ComponentFactory.bundleMarker;
import static com.verticon.tracker.irouter.measurement.logger.internal.Context.CONSUMER_EID_SCOPE;
import static com.verticon.tracker.irouter.measurement.logger.internal.Context.CONSUMER_MEASUREMENT_SCOPE;
import static com.verticon.tracker.irouter.measurement.logger.internal.Context.CONSUMER_STATE_SCOPE;
import static com.verticon.tracker.irouter.measurement.logger.internal.Context.LAST_LOG_ENTRY;
import static com.verticon.tracker.irouter.measurement.logger.internal.Context.WIRES_COUNT;

import java.util.Arrays;
import java.util.Vector;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import com.verticon.tracker.irouter.common.AbstractConsumer;
import com.verticon.tracker.irouter.common.IContext;

/**
 * Consumers a set of measurement scopes contained within a transaction and normalizes the
 * values from each of the measurements to a logger.  
 * 
 * Trigger is hard coded to TrackerConstants.TRANSACTION_STATE_SCOPE
 * ID is hard coded to TrackerConstants.ANIMAL_TAG_NUMBER_SCOPE
 * 
 * @author jconlon
 * 
 */
public class MeasurementLoggingConsumer extends AbstractConsumer implements Monitorable{

	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}
	
	private final String[] scope;
	private final ILogger iLogger;

	protected MeasurementLoggingConsumer(IContext context) {
		super(context);
		scope = buildScope();
		if(context.getConfigurationInteger(Context.LOGGER_TYPE).equals(Context.LOGGER_TYPE_AGGREGATING)){
			iLogger = new AggregatedTransactionLogger(
					getLoggerType(AggregatedTransactionLogger.class),
					context.getConfigurationString(Context.CONSUMER_STATE_SCOPE),
					context.getConfigurationString(Context.CONSUMER_EID_SCOPE)
			);
		}else{
			iLogger = new NormalizedTransactionLogger(
					context.getConfigurationString(TRACKER_WIRE_GROUP_NAME),
					context.getConfigurationString(Context.CONSUMER_STATE_SCOPE),
					context.getConfigurationString(Context.CONSUMER_EID_SCOPE),
					getLoggerType(NormalizedTransactionLogger.class));
		}
	}

	private Logger getLoggerType(Class<?> z){
		String loggerName = context.getConfigurationString(Context.LOGGER_NAME);
		if(loggerName==null || loggerName.trim().length()==0){
			return LoggerFactory
					.getLogger(z);
		}
		return LoggerFactory.getLogger(loggerName);
	}
	
	@Override
	public String toString() {
		return "MeasurementLoggingConsumer [scope=" + Arrays.toString(scope)
				+ ", iLogger=" + iLogger + "]";
	}


	/**
	 * Scope is configurable.
	 */
	@Override
	public String[] getScope() {
		return scope;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin
	 * .Wire, java.lang.Object)
	 */
	@Override
	public void updated(Wire wire, Object in) {
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			iLogger.add(envelope);
		} else {
			logError(wire, in);
		}
	}

	/**
	 * Build an array of measurement scopes.  A measurement scope looks like:
	 * mettler.weight.measurement
	 *  
	 * @return
	 */
	private String[] buildScope() {
		Vector<String> v = new Vector<String>();
		for (String scopeName : context.getConfigurationArray(CONSUMER_MEASUREMENT_SCOPE)) {
			if(scopeName==null || scopeName.trim().length()==0){
				break;
			}
			v.add(scopeName);
		}
		v.add(context.getConfigurationString(CONSUMER_STATE_SCOPE));
		v.add(context.getConfigurationString(CONSUMER_EID_SCOPE));
		return v.toArray(new String[] {});

	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[]{WIRES_COUNT, LAST_LOG_ENTRY};
	}

	@Override
	public StatusVariable getStatusVariable(String name)
	throws IllegalArgumentException {
		
		if (WIRES_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_GAUGE,
					wiresConnected.get()
		    );
		}else if (LAST_LOG_ENTRY.equals(name)){
				return
				new StatusVariable(name,
						StatusVariable.CM_DER,
						iLogger.getLastLogEntry()
				);
		}else{
			throw new IllegalArgumentException(
					"Invalid Status Variable name " + name);
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
	public String getDescription(String name) throws IllegalArgumentException {	
		if (WIRES_COUNT.equals(name)){
			return
			"The number of connected wires.";
		}else if (LAST_LOG_ENTRY.equals(name)){
			return iLogger.getLastLogEntryDescription();
		}
		return null;
	}

}
