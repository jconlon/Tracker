package com.verticon.tracker.irouter.measurement.logger.internal;

import com.verticon.tracker.irouter.common.ITransactionHandler;

public interface ILogger extends ITransactionHandler {
	
	String getLastLogEntry();

	public abstract String getLastLogEntryDescription();
}
