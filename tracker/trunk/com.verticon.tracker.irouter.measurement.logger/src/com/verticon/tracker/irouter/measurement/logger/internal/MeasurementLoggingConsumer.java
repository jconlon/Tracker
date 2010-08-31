package com.verticon.tracker.irouter.measurement.logger.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.ANIMAL_TAG_NUMBER_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRANSACTION_STATE_SCOPE;
import static com.verticon.tracker.irouter.measurement.logger.internal.ComponentFactory.bundleMarker;
import static com.verticon.tracker.irouter.measurement.logger.internal.Context.CONSUMER_SCOPE;
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
import com.verticon.tracker.irouter.common.ITransactionHandler;

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
	private final ITransactionHandler transactionHandler;

	protected MeasurementLoggingConsumer(IContext context) {
		super(context);
		scope = buildScope();
		if(context.getConfigurationInteger(Context.LOGGER_TYPE).equals(Context.LOGGER_TYPE_AGGREGATING)){
			transactionHandler = new AggregatedTransactionLogger(
					getLoggerType(AggregatedTransactionLogger.class));
		}else{
			transactionHandler = new NormalizedTransactionLogger(
					context.getConfigurationString(TRACKER_WIRE_GROUP_NAME),
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
				+ ", transactionHandler=" + transactionHandler + "]";
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
			transactionHandler.add(envelope);
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
		for (String scopeName : context.getConfigurationArray(CONSUMER_SCOPE)) {
			if(scopeName==null || scopeName.trim().length()==0){
				break;
			}
			v.add(scopeName+".measurement");
		}
		v.add(TRANSACTION_STATE_SCOPE);
		v.add(ANIMAL_TAG_NUMBER_SCOPE);
		return v.toArray(new String[] {});

	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[]{WIRES_COUNT};
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
		}
		return null;
	}

}
