package com.verticon.tracker.irouter.measurement.logger;

import static com.verticon.tracker.common.TrackerConstants.ANIMAL_TAG_NUMBER_SCOPE;
import static com.verticon.tracker.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.common.TrackerConstants.TRANSACTION_STATE_SCOPE;
import static com.verticon.tracker.irouter.measurement.logger.Context.*;

import java.util.Arrays;
import java.util.Vector;

import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.common.AbstractConsumer;
import com.verticon.tracker.common.IContext;
import com.verticon.tracker.common.ITransactionHandler;

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
public class MeasurementLoggingConsumer extends AbstractConsumer {

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

}
