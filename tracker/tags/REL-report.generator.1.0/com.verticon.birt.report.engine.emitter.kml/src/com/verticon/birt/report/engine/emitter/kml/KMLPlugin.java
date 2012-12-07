package com.verticon.birt.report.engine.emitter.kml;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class KMLPlugin implements BundleActivator {

	/**
	 * An Log object that <code>CSVReportEmitter</code> use to log the error,
	 * debug, information messages.
	 */
	protected static Logger logger = Logger.getLogger(KMLPlugin.class
			.getName());
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		KMLPlugin.context = bundleContext;
		 Handler fh = new FileHandler("%t/kmlReportEmitter.log");
		 fh.setFormatter(new SimpleFormatter());
		 Logger verticonlogger = Logger.getLogger("com.verticon");
		 verticonlogger.addHandler(fh);
		 verticonlogger.setLevel(Level.FINEST);
		 logger.info("Started Bundle");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		KMLPlugin.context = null;
	}

}
