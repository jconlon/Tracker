package com.verticon.tracker.irouter.measurement.logger.internal;

import static com.verticon.tracker.irouter.measurement.logger.internal.MeasurementLoggerConsumer.bundleMarker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.Marker;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

/**
 * 
 * When triggered by the base class (on reception of a 'transaction.state') the
 * NormalizedTransactionLogger will log all collected measurements as a single
 * log entry where the order of the measurements are sorted by the ascending
 * order of their scope names.
 * 
 * Output Format is: "123456789012345,<Group Name>,100.3,1.999"
 * 
 * @author jconlon
 * @since 0.2.0 added ordering of measurement values
 * 
 */
public class NormalizedTransactionLogger extends AbstractTransactionHandler
		implements ILogger {

	private final String groupName;
	private String lastLogEntry;
	private final AtomicInteger transactionsLogged = new AtomicInteger(0);

	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}

	/**
	 * 
	 * @param groupName
	 * @param state
	 * @param log
	 */
	public NormalizedTransactionLogger(String groupName, State state,
			Logger log) {
		super(log, state);
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "NormalizedTransactionLogger [groupName=" + groupName + "]";
	}

	/**
	 * Create a comma delimited message id where the order of the measurements
	 * are sorted by the ascending order of their scope names.
	 * 
	 * @since 0.2.0
	 */
	@Override
	protected void triggered() {
		List<String> scopes = new ArrayList<String>(envelopes.keySet());
		Collections.sort(scopes);//

		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(',');
		builder.append(groupName);
		for (String scope : scopes) {
			builder.append(',');
			builder.append(get(scope).getValue());
		}
		log.info(bundleMarker, builder.toString());
		lastLogEntry = builder.toString();
		transactionsLogged.incrementAndGet();
	}

	@Override
	public String getLastLogEntry() {
		return lastLogEntry;
	}

	@Override
	public String getLastLogEntryDescription() {
		return "Last concatinated log entry. Measurements in ascending scope name order.";
	}

	@Override
	public int transactionsLogged() {
		return transactionsLogged.get();
	}
	
	@Override
	public Long getCurrentEID() {
		return id!=null?id:0;
	}


	@Override
	public int getMeasurementsSize() {
		return envelopes.size();
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.verticon.tracker.irouter.common.AbstractTransactionHandler#
//	 * getTriggeringScopeName()
//	 */
//	@Override
//	protected String getTriggeringScopeName() {
//		return triggeringScopeName;
//	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.verticon.tracker.irouter.common.AbstractTransactionHandler#
//	 * getAnimalIDNumberScopeName()
//	 */
//	@Override
//	protected String getAnimalIDNumberScopeName() {
//		return animalIDNumberScopeName;
//	}
}
