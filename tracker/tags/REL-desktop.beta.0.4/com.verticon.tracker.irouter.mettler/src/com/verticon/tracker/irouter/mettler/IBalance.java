package com.verticon.tracker.irouter.mettler;

import java.io.IOException;

import org.osgi.service.io.ConnectorService;

import com.verticon.tracker.irouter.common.IContext;


/**
 * Provides a connectionService, the PID, the configuration, and a place to 
 * send the measurements.
 * 
 * TODO Refactor Balance for reuse similar to abbott and measurement.logger
 * projects to use a ServiceController.  Caution watch out for synchronization
 * issues in this project.
 * @author jconlon
 *
 */
public interface IBalance{
	void registerProducer();
	void unregisterProducer();
	ConnectorService getConnectorService() throws IOException;
	IContext getContext();
}
