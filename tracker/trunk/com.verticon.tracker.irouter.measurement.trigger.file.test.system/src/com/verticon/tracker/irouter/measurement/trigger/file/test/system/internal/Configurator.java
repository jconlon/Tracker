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

package com.verticon.tracker.irouter.measurement.trigger.file.test.system.internal;

import static com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey.CONNECTION_URI;
import static com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey.FACTORY_PID;
import static com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey.WIRING_GROUP;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author jconlon
 * 
 */
public class Configurator {


	static final String OHAUS_WEIGHT = "ohaus.weight";
	static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.trigger.file.test.system";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		Configurator.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Configurator.class);
    


	public void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "Setting ConfigurationAdmin");
		deleteConfigurations(configAdmin);
		
		// Configure the first test class
		Configuration config = configAdmin
				.createFactoryConfiguration(FACTORY_PID.getKey());
		Dictionary<String, Object> props = configureTest1();
		config.update(props);
		logger.debug(bundleMarker, "Created Configuration for Test 1 {}",
				config.getPid());

		// Configure the Measurement Trigger File

	}

	public void unsetConfigurationAdmin(ConfigurationAdmin configAdmin)
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

	private static Dictionary<String, Object> configureTest1() {
		Dictionary<String, Object> config = new Hashtable<String, Object>();
		config.put(
				"com.verticon.tracker.irouter.measurement.trigger.file.test",
				"testOne");
		WIRING_GROUP.configure(config, "test");
		CONNECTION_URI.configure(config, "file:///tmp");

		config.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { OHAUS_WEIGHT });
		return config;
	}
}
