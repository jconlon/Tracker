package com.verticon.tracker.irouter.common;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;

import java.util.Dictionary;
import java.util.concurrent.ExecutionException;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.slf4j.Logger;

/**
 * A controller for starting and stopping wireadmin services.
 * @author jconlon
 *
 */
public class ServiceController  {
	/**
	 * slf4j Logger
	 */
	private final Logger log;
	private final IContext context;
	private final IService[] services;

	
	/**
	 * Constructor for testing
	 * @param context
	 * @param services
	 * @throws ConfigurationException
	 */
	public ServiceController(IContext context, IService[] services, Logger log)
			throws ConfigurationException {
		this.context = context;
		this.services = services;
		this.log = log;
	}

	@Override
	public String toString() {
		return "ServiceController [pid=" + context.getPid() + ", group="
				+ context.getConfigurationString(TRACKER_WIRE_GROUP_NAME) + "]";
	}
	
	/**
	 * 
	 * @param bc
	 * @param config
	 * @throws ConfigurationException
	 */
	public void updated(BundleContext bc, Dictionary<?, ?> config)
			throws ConfigurationException {
		log.debug("{}: Updating",this);
		context.setBundleContext(bc);
		context.setConfig(config);
		stop();
		IService serv = null;
		try {
			for (IService service : services) {
				serv=service;
				service.start(bc);
			}
			
		} catch (InterruptedException e) {
			// Restore the interrupted status
            Thread.currentThread().interrupt();
            throw new ConfigurationException("", "Start of "+serv+" interrupted.");
            
		} catch (ExecutionException e) {
			throw new ConfigurationException("", this+ "Failed to start "+serv,e.getCause());
		}
		
	}

	public void stop() {
		for (IService service : services) {
			service.stop();
		}
	}
	

}
