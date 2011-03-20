/*******************************************************************************
 * Copyright (c) 2011 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.location.internal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.location.LocationService;
import com.verticon.location.LocationServiceProvider;

public class Component implements LocationService {

	private final static String PLUGIN_ID = "com.verticon.location";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);

	private List<LocationServiceProvider> serviceProviders = new CopyOnWriteArrayList<LocationServiceProvider>();

	
	public void activate() {
		logger.debug(bundleMarker, "{} activated", this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocationService Component []";
	}

	@Override
	public String positionIn(Object container,
			String coordinates) {
		String result = null;
		if (!serviceProviders.isEmpty()) {
			for (LocationServiceProvider locationServiceProvider : serviceProviders) {
				if (locationServiceProvider.canHandle(container)) {
					result = locationServiceProvider.positionIn(container,
							coordinates);
					if (result != null)
						break;
				}
			}
		}
		return result;
	}
	
	@Override
	public String name(Object target) {
		String result = null;
		if (!serviceProviders.isEmpty()) {
			for (LocationServiceProvider locationServiceProvider : serviceProviders) {
				if (locationServiceProvider.canHandle(target)) {
					result = locationServiceProvider.name(target);
					if (result != null)
						break;
				}
			}
		}
		return result;
	}

	@Override
	public String address(Object target) {
		String result = null;
		if (!serviceProviders.isEmpty()) {
			for (LocationServiceProvider locationServiceProvider : serviceProviders) {
				if (locationServiceProvider.canHandle(target)) {
					result = locationServiceProvider.address(target);
					if (result != null)
						break;
				}
			}
		}
		return result;
	}
	
//	@Override
//	public String name(String clazzName, String id) {
//		String result = null;
//		if (!serviceProviders.isEmpty()) {
//			for (LocationServiceProvider locationServiceProvider : serviceProviders) {
//				if (locationServiceProvider.canHandle(clazzName)) {
//					result = locationServiceProvider.name(clazzName,id);
//					if (result != null)
//						break;
//				}
//			}
//		}
//		return result;
//	}

//	@Override
//	public String address(String clazzName, String id) {
//		String result = null;
//		if (!serviceProviders.isEmpty()) {
//			for (LocationServiceProvider locationServiceProvider : serviceProviders) {
//				if (locationServiceProvider.canHandle(clazzName)) {
//					result = locationServiceProvider.address(clazzName,id);
//					if (result != null)
//						break;
//				}
//			}
//		}
//		return result;
//	}

	public void setLocationServiceProvider(
			LocationServiceProvider locationServiceProvider) {
		serviceProviders.add(locationServiceProvider);
		logger.debug(bundleMarker, "{} added serviceProvider {}", this,
				locationServiceProvider.getClass().getName());
	}

	public void unsetLocationServiceProvider(
			LocationServiceProvider locationServiceProvider) {
		serviceProviders.remove(locationServiceProvider);
		logger.debug(bundleMarker, "{} removed serviceProvider {}", this,
				locationServiceProvider.getClass().getName());
	}

	public void deactivate() {
		serviceProviders.clear();
		logger.debug(bundleMarker, "{} deactivated", this);
	}

	

}
