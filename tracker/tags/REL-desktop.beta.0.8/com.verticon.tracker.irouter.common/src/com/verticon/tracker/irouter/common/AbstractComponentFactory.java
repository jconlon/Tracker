package com.verticon.tracker.irouter.common;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;


public abstract class AbstractComponentFactory implements ManagedServiceFactory {

	/**
	 * slf4j Logger
	 */
	protected final Logger log = LoggerFactory
			.getLogger(this.getClass());


	private Map<String, ServiceController> servicControllers = null;
	protected ExecutorService exec;
	protected ScheduledExecutorService scheduler;
	private BundleContext bc;
	
	protected abstract Marker bundleMarker();
	

	protected void activate(BundleContext bc) throws Exception {
		log.debug(bundleMarker(),"Starting");
		this.bc = bc;
		exec = Executors.newCachedThreadPool();
		scheduler = Executors.newSingleThreadScheduledExecutor();
		servicControllers = new HashMap<String, ServiceController>();
		log.debug(bundleMarker(),"Started");
	}

	protected void deactivate(BundleContext context) throws Exception {
		Collection<ServiceController> indicatorInstances = servicControllers.values();
		for (ServiceController indicator : indicatorInstances) {
			indicator.stop();
		}
		servicControllers.clear();
		servicControllers = null;
	
		exec.shutdownNow();
		exec = null;
		scheduler.shutdownNow();
		scheduler = null;
	
	}

	protected abstract ServiceController createServiceController(String pid,
			Dictionary<?,?> config) throws ConfigurationException ;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void updated(String pid, Dictionary config)
			throws ConfigurationException {
				log.info(bundleMarker(),this + ": Updating pid " + pid);
			
				ServiceController controller = servicControllers.get(pid);
				if (controller == null) {
					controller = createServiceController(pid, config);
					servicControllers.put(pid, controller);
				}
				controller.updated(bc, config);
			}

	@Override
	public void deleted(String pid) {
		log.info(bundleMarker(),this + ": Deleting pid " + pid);
		ServiceController serviceController = servicControllers.get(pid);
		if (serviceController != null) {
			servicControllers.remove(pid);
			serviceController.stop();
		}
	}

	
}
