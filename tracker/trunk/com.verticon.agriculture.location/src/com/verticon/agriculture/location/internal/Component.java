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

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.location.service.ILocationServiceProvider;

/**
 * ILocationServiceProvider for the agriculture objects Animals and Premises.
 * LocationService is based on Premises and Location information residing in Agriculture projects.
 * (Agriculture projects have an AgriculutureNature and a doc.agri in the root folder)
 * 
 * At the first request for service all Agriculture projects in the workspace are interrogated and 
 * index of Premises and Location information is cached.
 * 
 * @see LocationIndex
 * @author jconlon
 * 
 */
public class Component implements ILocationServiceProvider {

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
	 * Can handle all String target ID
	 */
	@Override
	public boolean canHandle(Object target) {
		return delegate.canHandle(target);
	}

	/**
	 * Find address for a target identifier.
	 */
	@Override
	public String address(String target) {
		return delegate.address(target);
	}

	/**
	 * Find location for a 
	 */
	@Override
	public String locate(String coordinates) {
		return delegate.locate(coordinates);
	}

	/**
	 * Find location for a Premises. Used for remote locations.
	 */
	@Override
	public String name(String target) {
		return delegate.name(target);

	}

	/**
	 * 
	 * @param container
	 *            that has sublocations
	 * @return names of all the sublocations for the container
	 */
	@Override
	public Set<String> locationsIn(String container) {
		return delegate.locationsIn(container);
	}

	@Override
	public Map<String, String> getAssociates(String id) {
		return delegate.getAssociates(id);
	}

}
