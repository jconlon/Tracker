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
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.location.service.LocationService;

/**
 * @author jconlon
 * 
 */
public class TrackerPlugin extends Plugin{

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

	 private ServiceTracker<LocationService, LocationService> locationServiceTracker = null;   

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
		locationServiceTracker = new ServiceTracker<LocationService, LocationService>(context, LocationService.class.getName(),null);
		locationServiceTracker.open();
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

	/**
	 * 
	 * @return LocationService
	 */
	private LocationService getLocationService(){
		LocationService locationService = null;
		if(locationServiceTracker!=null && locationServiceTracker.getService()!=null){
			locationService = locationServiceTracker.getService();
		}else{
			logger.warn(bundleMarker, "Failed to find a location service.");
		}
		return locationService;
		
	}

	/**
	 * Used by Animals to find names for foreign premises.
	 */
	 public String name(String uri) {
		String result = null;
		LocationService locationService = getLocationService();
		if(locationService != null){
			result = locationService.name(uri);
		}
		return result!=null?result:"";
	}

	/**
	 * Called by animals to find out the location outside the premises.
	 * @param point coordinates
	 * @return name of Premises location
	 */
	public String locate(String point) {
		String result = null;
		LocationService locationService = getLocationService();
		if(locationService != null){
			result = locationService.locate(point);
		}
		return result!=null?result:"InPremises:"+point;
	}

//	/**
//	 * Called by Premises to find out its address
//	 * @deprecated use embedded Location object
//	 */
//	@Override
//	public String address(Object target) {
//		String result = null;
//		LocationService locationService = getLocationService();
//		if(locationService != null){
//			result = locationService.address(target);
//		}
//		return result!=null?result:"unknown address";
//		
//	}

	
//	/**
//	 * @deprecated use embedded Location object
//	 */
//	@Override
//	public Set<String> locationsIn(Object container) {
//		Set<String> result = null;
//		LocationService locationService = getLocationService();
//		if(locationService != null){
//			result = locationService.locationsIn(container);
//		}
//		if(result == null){
//			result = Collections.emptySet();
//		}
//		return result;
//	}


}
