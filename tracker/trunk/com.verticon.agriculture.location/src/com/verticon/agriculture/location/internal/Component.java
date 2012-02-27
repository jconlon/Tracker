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
package com.verticon.agriculture.location.internal;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.location.LocationServiceProvider;

/**
 * LocationServiceProvider for Animals and Premises created from all projects
 * having an AgriculutureNature and a doc.agri in the root folder.
 * 
 * @author jconlon
 * 
 */
public class Component implements LocationServiceProvider {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);
	final static String PLUGIN_ID = "com.verticon.agriculture.location";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	private final LocationIndex delegate = LocationIndex.getInstance();

	public void activate() {
		logger.debug(bundleMarker, "Activated", this);
	}

	public void deactivate() {
		LocationIndex.getInstance().clean();
		logger.debug(bundleMarker, "Deactivated", this);
	}

	/**
	 * Can handle premises and String IDs
	 */
	@Override
	public boolean canHandle(Object target) {
		return delegate.canHandle(target);
	}

	/**
	 * Find address for a premises.
	 */
	@Override
	public String address(Object target) {
		return delegate.address(target);
	}

	/**
	 * Find location for an animal or a inside a Premises
	 */
	@Override
	public String positionIn(Object target, String coordinates) {
		return delegate.positionIn(target, coordinates);
	}

	/**
	 * Find location for a Premises. Used for remote locations.
	 */
	@Override
	public String name(Object target) {
		return delegate.name(target);

	}

	/**
	 * 
	 * @param container
	 *            that has sublocations
	 * @return names of all the sublocations for the container
	 */
	@Override
	public Set<String> locationsIn(Object container) {
		return delegate.locationsIn(container);
	}

}
