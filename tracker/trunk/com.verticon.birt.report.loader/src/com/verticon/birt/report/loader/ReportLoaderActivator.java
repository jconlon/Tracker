package com.verticon.birt.report.loader;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class ReportLoaderActivator implements BundleActivator {

	private static BundleContext context;
	private ReportLoader bl;
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ReportLoaderActivator.class);


	/**
	 * Identify the plugin to the logger
	 */
	private final static String PLUGIN_ID = "com.verticon.birt.report.loader";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker;
	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	static BundleContext getContext() {
		return context;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportLoaderActivator []";
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		logger.debug(bundleMarker,"{}: Started", 
				this);
		ReportLoaderActivator.context = bundleContext;
		bl = new ReportLoader(context);
		if(loadReports()){
			logger.debug(bundleMarker,"{}: Reports are loaded.", 
					this); 
			bl = null;
		}else{
			logger.debug(bundleMarker,"{}: Listening for BIRT bundle starts", 
					this);
			//reports are not loaded listen for right bundle start conditions
			context.addBundleListener(bl);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		if(bl!=null){
			context.removeBundleListener(bl);
			bl = null;
		}
		
		context = null;
	}
	
	private boolean loadReports(){
		
		for (Bundle bundle : context.getBundles()) {
			if(bl.loadAndStartServer(bundle)){
				return true;
			}
		}
		return false;
	}

}
