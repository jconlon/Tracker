package com.verticon.tracker.irouter.common;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static org.osgi.framework.Constants.SERVICE_PID;
import static com.verticon.tracker.irouter.common.internal.bundle.BundleConstants.bundleMarker;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.monitor.Monitorable;
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
	private ServiceRegistration monitorableServiceRegistration = null;
	

	
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
		log.debug(bundleMarker,"{}: Updating",this);
		context.setBundleContext(bc);
		context.setConfig(config);
		stop();
		IService serv = null;
		List<Monitorable> monitorables = new ArrayList<Monitorable>();
		try {
			for (IService service : services) {
				serv=service;
				service.start(bc);
				if(service instanceof Monitorable){
					monitorables.add((Monitorable)service);
				}
			}
			
		} catch (InterruptedException e) {
			// Restore the interrupted status
            Thread.currentThread().interrupt();
            throw new ConfigurationException("", "Start of "+serv+" interrupted.");
            
		} catch (ExecutionException e) {
			throw new ConfigurationException("", this+ "Failed to start "+serv,e.getCause());
		}
		
		//Register the Monitorable
		Hashtable<String, Object> regProps = new Hashtable<String, Object>();
		regProps.put(SERVICE_PID, this.context.getPid());
		
		regProps.put(TRACKER_WIRE_GROUP_NAME, 
				this.context.getConfigurationString(TRACKER_WIRE_GROUP_NAME));
		
		if(monitorables.size()>1){
			monitorableServiceRegistration =  bc.registerService(Monitorable.class.getName(), 
				new MonitorableHandler(monitorables),
				regProps);
		}else if(monitorables.size()==1){
			monitorableServiceRegistration =  bc.registerService(Monitorable.class.getName(), 
					monitorables.get(0),
					regProps);
		}
	}

	public void stop() {
		for (IService service : services) {
			service.stop();
		}
		
		if(monitorableServiceRegistration !=null){
			monitorableServiceRegistration.unregister();
			monitorableServiceRegistration = null;
		}
	}
	

}
