package com.verticon.tracker.irouter.measurement.logger;

import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;

import com.verticon.tracker.common.AbstractComponentFactory;
import com.verticon.tracker.common.IService;
import com.verticon.tracker.common.ServiceController;


public class ComponentFactory extends AbstractComponentFactory {

	
	protected ServiceController createServiceController(String pid,
			Dictionary<?,?> config) throws ConfigurationException {
		ServiceController controller = null;
		Context context = new Context(pid, config, exec, scheduler);
		IService commandProducer = new MeasurementLoggingConsumer(context);
		controller = new ServiceController(context, new IService[]{commandProducer});
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
