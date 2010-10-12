package com.verticon.tracker.irouter.measurement.logger.internal;

import static com.verticon.tracker.irouter.measurement.logger.internal.ComponentFactory.bundleMarker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.Marker;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

/**
 * 
 * When triggered by the base class (on reception of a 'transaction.state') 
 * the NormalizedTransactionLogger will log all collected measurements 
 * as a single log entry where the order of the measurements
 * are sorted by the ascending order of their scope names.
 * 
 * Output Format is:
 * "123456789012345,<Group Name>,100.3,1.999"
 * 
 * @author jconlon
 * @since 0.2.0 added ordering of measurement values
 *
 */
public class NormalizedTransactionLogger extends AbstractTransactionHandler implements ILogger{

	private final String groupName;
	private final String triggeringScopeName;
	private final String animalIDNumberScopeName;
	private String lastLogEntry;
	
	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}
	
	public NormalizedTransactionLogger(String groupName,String triggeringScopeName, String animalIDNumberScopeName, Logger log) {
		super(log);
		this.groupName= groupName;
		this.animalIDNumberScopeName=animalIDNumberScopeName;
		this.triggeringScopeName=triggeringScopeName;
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
	protected void triggered(){
		List<String> scopes = new ArrayList<String>(measurements.keySet());
		Collections.sort(scopes);//
		
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(',');
		builder.append(groupName);
		for (String scope : scopes) {
			builder.append(',');
			builder.append(get(scope).getValue());
		}
		log.info(bundleMarker,builder.toString());
		lastLogEntry=builder.toString();
	}

	@Override
	public String getLastLogEntry() {
		return lastLogEntry;
	}

	@Override
	public String getLastLogEntryDescription() {
		return "Last concatinated log entry. Measurements in ascending scope name order.";
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.common.AbstractTransactionHandler#getTriggeringScopeName()
	 */
	@Override
	protected String getTriggeringScopeName() {
		return triggeringScopeName;
	}


	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.common.AbstractTransactionHandler#getAnimalIDNumberScopeName()
	 */
	@Override
	protected String getAnimalIDNumberScopeName() {
		return animalIDNumberScopeName;
	}
}
