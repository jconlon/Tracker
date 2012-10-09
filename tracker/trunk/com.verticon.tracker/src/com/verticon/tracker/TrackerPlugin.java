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

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.location.service.ILocationService;
import com.verticon.tracker.store.ITrackerStore;

/**
 * @author jconlon
 * 
 */
public class TrackerPlugin extends Plugin {

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

	private ServiceTracker<ILocationService, ILocationService> locationServiceTracker = null;
	private ServiceTracker<ITrackerStore, ITrackerStore> trackerStoreServiceTracker = null;

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
		locationServiceTracker = new ServiceTracker<ILocationService, ILocationService>(
				context, ILocationService.class.getName(), null);
		locationServiceTracker.open();
		trackerStoreServiceTracker = new ServiceTracker<ITrackerStore, ITrackerStore>(
				context, ITrackerStore.class.getName(), null);
		trackerStoreServiceTracker.open();
		logger.debug(bundleMarker, "Started Bundle");
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		locationServiceTracker.close();
		trackerStoreServiceTracker.close();
		super.stop(context);
		locationServiceTracker = null;
		trackerStoreServiceTracker = null;
		plugin = null;
		logger.debug(bundleMarker, "Stopped Bundle");
	}

	/**
	 * Returns the shared instance.
	 */
	public static TrackerPlugin getDefault() {
		return plugin;
	}

	public boolean hasLocationService() {
		return locationServiceTracker != null
				&& locationServiceTracker.getService() != null;
	}

	public boolean hasTrackerStoreService() {
		return trackerStoreServiceTracker != null
				&& trackerStoreServiceTracker.getService() != null;
	}

	/**
	 * Try to get an animal from any of the TrackerStores
	 * 
	 * @param uri
	 * @return Animal
	 */
	public Animal getAnimal(String uri) {
		Animal result = null;
		List<ITrackerStore> trackerStores = getTrackerStores();
		if (trackerStores != null) {
			for (ITrackerStore iTrackerStore : trackerStores) {
				result = iTrackerStore.retrieveAnimal(uri);
				if (result != null) {
					break;
				}
			}

		}
		return result != null ? result : null;
	}

	/**
	 * Used by Animals to find names for a foreign premises.
	 */
	public String name(String uri) {
		String result = null;
		List<ILocationService> iLocationServices = getLocationServices();
		if (iLocationServices != null) {
			for (ILocationService iLocationService : iLocationServices) {
				result = iLocationService.name(uri);
				if (result != null) {
					break;
				}
			}

		}
		return result != null ? result : null;
	}

	/**
	 * Used by Animals to find names for all foreign premises.
	 */
	public Map<String, String> getAssociates(String uri) {
		Map<String, String> result = null;
		List<ILocationService> iLocationServices = getLocationServices();
		if (iLocationServices != null) {
			for (ILocationService iLocationService : iLocationServices) {
				result = iLocationService.getAssociates(uri);
				if (result != null) {
					break;
				}
			}

		}
		return result;
	}

	/**
	 * Called by animals to find out the location outside the premises.
	 * 
	 * @param point
	 *            coordinates
	 * @return name of Premises location
	 */
	public String locate(String point) {
		if (point == null) {
			throw new IllegalArgumentException(
					"point argument can not be null.");
		}
		String result = null;
		List<ILocationService> iLocationServices = getLocationServices();
		if (iLocationServices != null) {
			for (ILocationService iLocationService : iLocationServices) {
				result = iLocationService.locate(point);
				if (result != null) {
					break;
				}
			}

		}
		return result != null ? result : "InPremises:" + point;
	}

	/**
	 * 
	 * @return ILocationService
	 */
	private List<ILocationService> getLocationServices() {
		List<ILocationService> iLocationServices = null;
		if (hasLocationService()) {
			iLocationServices = newArrayList();
			for (Object o : locationServiceTracker.getServices()) {
				iLocationServices.add((ILocationService) o);
			}
		} else {
			logger.warn(bundleMarker, "Failed to find a location service.");
		}
		return iLocationServices;

	}

	/**
	 * 
	 * @return ITrackerStore
	 */
	private List<ITrackerStore> getTrackerStores() {
		List<ITrackerStore> trackerStores = null;
		if (hasTrackerStoreService()) {
			trackerStores = newArrayList();
			for (Object o : trackerStoreServiceTracker.getServices()) {
				trackerStores.add((ITrackerStore) o);
			}

		} else {
			logger.warn(bundleMarker, "Failed to find a TrackerStore service.");
		}
		return trackerStores;
	}
}
