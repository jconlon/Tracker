package com.verticon.tracker.irouter.deployment.logging;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.deploymentadmin.spi.ResourceProcessor;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {
		Dictionary properties = new Properties();
        properties.put(Constants.SERVICE_PID, "com.verticon.tracker.deployment.logging");
        // register the service
        context.registerService(
        		ResourceProcessor.class.getName(),
                        new LoggingResourceProcessor(),
                        properties);

        // create a tracker and track the log service
//        ServiceTracker repositoryServiceTracker =
//                new ServiceTracker(context, RepositoryService.class.getName(), null);
//        repositoryServiceTracker.open();
//
//        // grab the service
//        RepositoryService repositoryService = (RepositoryService) repositoryServiceTracker.getService();
//        System.err.println("RepositoryService Activated");

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
	}

}
