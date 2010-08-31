package com.verticon.tracker.irouter.measurement.logger.internal;

import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.AbstractComponentFactory;
import com.verticon.tracker.irouter.common.IService;
import com.verticon.tracker.irouter.common.ServiceController;

/**
 * Component Factory for creating Consumers that cache multiple Measurements,
 * and an Animal ID until a 'transaction.state' is received, which will
 * trigger the logging of the cached information.
 * 
 * Multiple types loggers can be created which will log the cached 
 * information differently at trigger ('transaction.state') time. 
 *  
 * @author jconlon
 *
 */
public class ComponentFactory extends AbstractComponentFactory {

	protected static String PLUGIN_ID = 
		"com.verticon.tracker.irouter.measurement.logger.internal";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker;

	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}
	
	protected ServiceController createServiceController(String pid,
			Dictionary<?,?> config) throws ConfigurationException {
		ServiceController controller = null;
		Context context = new Context(pid, config, exec, scheduler);
		IService consumer = new MeasurementLoggingConsumer(context);
		controller = new ServiceController(context, new IService[]{consumer}, log);
		return controller;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.cm.ManagedServiceFactory#getName()
	 */
	@Override
	public String getName() {
		return "Transaction Logger";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComponentFactory [name=" + getName() + "]";
	}
	
}
