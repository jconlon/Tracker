package com.verticon.tracker.irouter.abbott;

import java.util.Dictionary;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.osgi.service.cm.ConfigurationException;

import com.verticon.tracker.common.AbstractComponentFactory;
import com.verticon.tracker.common.IService;
import com.verticon.tracker.common.ServiceController;

/**
 * ComponentFactory for creating instances of an Abbott controller that will 
 * consume
 * <ol>
 * <li>mettler.weight.measurement scoped blood weight measurements from a Mettler balance</li>
 * <li>animal.weight.measurement scoped measurements from a TruTest scale head</li>
 * </ol>
 * and produce TruTest commands for 
 * <ol>
 * <li>producing commands to display a calculated blood weight</li>
 * <li>producing commands to display an actual blood weight</li>
 * <li>producing commands to turn on and off the TruTest audible alarm based on percentage
 * of calculated to actual blood weight</li>
 * </ol>
 * 
 * TODO move out command generation to a separate TruTest Command generator that consumes 
 * <ol>
 * <li>generic scoped measurements</li>
 * <li>alarm states</li>
 * </ol>
 * retain the ability to
 * <ol>
 * <li>produce a calculated blood weight measurement</li>
 * <li>produce an alarm state based on percentage of calculated to actual blood weight</li>
 * </ol>
 * 
 * @author jconlon
 *
 */
public class ComponentFactory extends AbstractComponentFactory {

	protected ServiceController createServiceController(String pid,
			Dictionary<?,?> config) throws ConfigurationException {
		ServiceController controller;
		ControllerContext context = new ControllerContext(pid, config, exec, scheduler);
		BlockingQueue<String> commandQueue = new LinkedBlockingQueue<String>();
		IService commandProducer = new CommandProducer(context, commandQueue);
		IService compositeConsumer = new CompositeConsumer(context, commandQueue);
		controller = new ServiceController(context, new IService[]{commandProducer, compositeConsumer});
		return controller;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.cm.ManagedServiceFactory#getName()
	 */
	@Override
	public String getName() {
		return "Abbott Bleed Operations Controller";
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
