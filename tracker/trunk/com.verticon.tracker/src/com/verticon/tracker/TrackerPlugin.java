/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.location.LocationService;

/**
 * @author jconlon
 * 
 */
public class TrackerPlugin extends Plugin implements LocationService{

	// The identifier for this plugin
	public static final String ID = "com.verticon.tracker";
	
	// The shared instance.
	private static TrackerPlugin plugin;
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(TrackerPlugin.class);

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();

	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
	}

	 private static ServiceTracker locationServiceTracker = null;   

	/**
	 * The constructor.
	 */
	public TrackerPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		locationServiceTracker = new ServiceTracker(context, LocationService.class.getName(),null);

		logger.debug(bundleMarker, "Started Bundle");
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		locationServiceTracker.close();
		super.stop(context);
		locationServiceTracker = null;
		plugin = null;
		logger.debug(bundleMarker, "Stopped Bundle");
	}

	/**
	 * Returns the shared instance.
	 */
	public static TrackerPlugin getDefault() {
		return plugin;
	}

	@Override
	public String location(EObject eObject) {
		String result = null;
		if(locationServiceTracker!=null && locationServiceTracker.getService()!=null){
			result = ((LocationService)locationServiceTracker.getService()).location(eObject);
		}
		return result;
	}

	@Override
	public String coordinates(EObject eObject) {
		String result = null;
		if(locationServiceTracker!=null && locationServiceTracker.getService()!=null){
			result = ((LocationService)locationServiceTracker.getService()).coordinates(eObject);
		}
		return result;
	}

	@Override
	public String address(EObject eObject) {
		String result = null;
		if(locationServiceTracker!=null && locationServiceTracker.getService()!=null){
			result = ((LocationService)locationServiceTracker.getService()).address(eObject);
		}
		return result;
	}

}
