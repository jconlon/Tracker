package com.verticon.tracker.irouter.measurement.logger;

import static com.verticon.tracker.irouter.measurement.logger.ComponentFactory.bundleMarker;

import org.slf4j.Logger;
import org.slf4j.Marker;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

public class NormalizedTransactionLogger extends AbstractTransactionHandler{

	private final String groupName;
	
	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}
	
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
		log.info(bundleMarker,builder.toString());
	}

}
