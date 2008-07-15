/**
 * 
 */
package com.verticon.tracker.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author jconlon
 *-Dlog4j.configuration=file:/home/jconlon/eclipse-workspaces/tracker-TRUNK/com.verticon.tracker.reader.tagid.bluetooth/log4j/log4j.properties
 */
public class Activator implements BundleActivator {
	final Logger logger = LoggerFactory.getLogger(Activator.class);
	public void start(BundleContext context) throws Exception {
		logger.info("Started! "+ context.getBundle().getSymbolicName());
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		logger.info("Stopped!");
		
	}

}
