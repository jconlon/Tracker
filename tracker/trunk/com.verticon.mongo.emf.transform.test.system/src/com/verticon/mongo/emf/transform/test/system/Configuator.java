/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.mongo.emf.transform.test.system;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * For creating configurations for ConfigAdmin IMongoClientProvider components.
 * 
 * @author jconlon
 * 
 */
public class Configuator {

	static String PLUGIN_ID = "com.verticon.mongo.emf.transform.test.system";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Configuator.class);
	private static final String FACTORY_PID = "com.verticon.mongo";

	void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "Setting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

		// Configure the IMongoClientProvider
		Configuration config = configAdmin
				.createFactoryConfiguration(FACTORY_PID);

		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put("mongoClientProvider", "remote");
		// take all defaults
		config.update(props);
		logger.debug(bundleMarker,
				"Created Configuration for IMongoClientProvider {}",
				config.getPid());

	}

	void unsetConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "UnSetting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

	}

	private void deleteConfigurations(ConfigurationAdmin configAdmin) {
		try {
			Configuration[] configs = configAdmin.listConfigurations(null);
			if (configs != null) {
				for (Configuration configuration : configs) {
					logger.debug(bundleMarker, "Deleting Configuration {}",
							configuration.getPid());
					configuration.delete();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
