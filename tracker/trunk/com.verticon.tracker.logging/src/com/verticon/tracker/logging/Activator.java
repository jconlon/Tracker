/**
 * 
 */
package com.verticon.tracker.logging;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;


/**
 * @author jconlon
 *-Dlog4j.configuration=file:/home/jconlon/eclipse-workspaces/tracker-TRUNK/com.verticon.tracker.reader.tagid.bluetooth/log4j/log4j.properties
 */
public class Activator implements BundleActivator {
	
	
	private LogServiceTracker logServiceTracker = null;
	public static final String ID = "my.bundle.symbolic.name";

	public static final Marker bundleMarker = createBundleMarker();

	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_MARKER"));
		return bundleMarker;
	}
	
	public void start(BundleContext context) throws Exception {
//		logger.info("Started! "+ context.getBundle().getSymbolicName());
		Filter filter = context.createFilter(
				"(|(objectClass=org.osgi.service.log.LogReaderService) (objectClass=org.eclipse.equinox.log.ExtendedLogReaderService))");
		logServiceTracker = new LogServiceTracker(context, filter);
		logServiceTracker.open();
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
//		logger.info("Stopped!");
		logServiceTracker.close();
		logServiceTracker = null;
	}

}
