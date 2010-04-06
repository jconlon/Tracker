package com.verticon.tracker.irouter.measurement.logger;

import org.slf4j.Logger;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

public class NormalizedTransactionLogger extends AbstractTransactionHandler{

	private final String groupName;
	
	public NormalizedTransactionLogger(String groupName, Logger log) {
		super(log);
		this.groupName= groupName;
	}
	
	@Override
	public String toString() {
		return "NormalizedTransactionLogger [groupName=" + groupName + "]";
	}

	/**
	 * Create a comma delimited message id
	 */
	@Override
	protected void triggered(){
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(',');
		builder.append(groupName);
		for (String scope : measurements.keySet()) {
			builder.append(',');
			builder.append(get(scope).getValue());
		}
		log.info(builder.toString());
	}

}
