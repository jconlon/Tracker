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
package com.verticon.tracker.irouter.monitor.external.internal;

import java.util.Map;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;



public class ExternalService implements Monitorable {

	private static final String NAME = "external.Name";
	private static final String LOCATION = "external.Location";
	private static final String DESCRIPTION = "external.Description";
	private static final String CONNECTION_URI = "external.Connection_URI";
	
	static final String PLUGIN_ID = "com.verticon.tracker.irouter.monitor.external";

	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ExternalService.class);
	
	private Map<String, Object> config = null;
	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		this.config = config;
		logger.debug(bundleMarker, "{} activating properties={}", this, config);
	}
	
	@Override
	public String[] getStatusVariableNames() {
		return new String[] {
				NAME, CONNECTION_URI, LOCATION, DESCRIPTION };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (NAME.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					(String)config.get(NAME.toLowerCase()));
		} else if (CONNECTION_URI.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					(String)config.get("external.connection.uri"));
		} else if (LOCATION.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					(String)config.get(LOCATION.toLowerCase()));
		} else if (DESCRIPTION.equals(name)){
			return new StatusVariable(name, StatusVariable.CM_DER,
					(String)config.get(DESCRIPTION.toLowerCase()));
		} else {
			throw new IllegalArgumentException("Invalid Status Variable name "
					+ name);
		}
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String name)
			throws IllegalArgumentException {
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {
		if (NAME.equals(name)) {
			return "The name of the external service or device.";
		} else if (DESCRIPTION.equals(name)) {
			return "The description of the external service or device.";
		} else if (CONNECTION_URI.equals(name)) {
			return "The Univeral Resource Identifier of the external service or device.";
		} else if (LOCATION.equals(name)) {
			return "The physical location of the external service or device.";
		}
		return null;
	}

}
