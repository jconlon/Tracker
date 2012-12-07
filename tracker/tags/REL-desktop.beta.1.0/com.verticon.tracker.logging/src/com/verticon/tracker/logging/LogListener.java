package com.verticon.tracker.logging;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class LogListener implements org.osgi.service.log.LogListener {
	private final BundleContext context;
	
	public LogListener(BundleContext context) {
		super();
		this.context = context;
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(LogServiceTracker.class);

	public void logged(LogEntry entry) {
		logLogEntry(logger, 
				entry.getLevel(), 
				createBundleAndServiceMarker(entry, context), 
				entry.getMessage(), 
				entry.getException());
	}
	
	/**
	 * 
	 * @param logger 
	 * @param level
	 * @param marker
	 * @param message
	 * @param e
	 */
	private void logLogEntry(Logger logger, int level, Marker marker, String message, 
			Throwable e){
		switch (level) {
		case LogService.LOG_DEBUG:
			logger.debug(marker, message,e);
			break;
		case LogService.LOG_ERROR:
			logger.error(marker, message,e);
			break;
		case LogService.LOG_WARNING:
			logger.warn(marker, message,e);
			break;

		default:
			logger.info(marker, message, e);
			break;
		}
	}

	
	static Marker createBundleAndServiceMarker(LogEntry entry, BundleContext context){
		String id = context.getBundle().getSymbolicName();
		Marker bundleMarker = MarkerFactory.getMarker(id); 
		//Not sure what to do with the serviceReference
		ServiceReference ref = entry.getServiceReference();
		Object sid = ref.getProperty(Constants.SERVICE_ID);
		if(sid !=null){
			bundleMarker.add(MarkerFactory.getMarker(((Long)sid).toString()));
		}
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
		
	}
	
}
