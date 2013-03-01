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
 * 
 * Configures a com.verticon.tracker.irouter.measurement.trigger.file and a
 * com.verticon.tracker.irouter.eventadmin.gateway
 * 
 * @author jconlon
 * 
 */
public class Configurator {

	private static final String EVENTADMIN_GATEWAY = "com.verticon.tracker.irouter.eventadmin.gateway";

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
    


	/**
	 * Configuration Admin is injected here. It will be used to configure a
	 * 
	 * @param configAdmin
	 * @throws IOException
	 */
	public void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "Setting ConfigurationAdmin");
		deleteConfigurations(configAdmin);
		
		// Configure the Measurement Trigger File
		Configuration config = configAdmin
				.createFactoryConfiguration(FACTORY_PID.getKey());
		Dictionary<String, Object> props = configureMeasurementTriggerFile();
		config.update(props);
		logger.debug(bundleMarker,
				"Created Configuration for measurement.trigger.file {}",
				config.getPid());

		// Configure the Event Admin Gateway
		config = configAdmin.createFactoryConfiguration(EVENTADMIN_GATEWAY);
		props = configureEventAdminGateway();
		config.update(props);
		logger.debug(bundleMarker,
				"Created Configuration for event.admin.gateway {}",
				config.getPid());

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

	private static Dictionary<String, Object> configureMeasurementTriggerFile() {
		Dictionary<String, Object> config = new Hashtable<String, Object>();
		config.put(
				"com.verticon.tracker.irouter.measurement.trigger.file.test",
				"testOne");
		WIRING_GROUP.configure(config, "test");
		CONNECTION_URI.configure(config, "file:///tmp");

		config.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
 new String[] {
				OHAUS_WEIGHT, "event.admin.gateway" });
		return config;
	}

	private static Dictionary<String, Object> configureEventAdminGateway() {
		Dictionary<String, Object> config = new Hashtable<String, Object>();
		config.put("com.verticon.tracker.irouter.eventadmin.gateway.test",
				"testOne");
		WIRING_GROUP.configure(config, "test");// constant doesnt matter
		// TOPIC
		config.put("event.topics", "com/verticon/tracker/irouter");

		config.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { "event.admin.gateway" });
		return config;
	}
}
