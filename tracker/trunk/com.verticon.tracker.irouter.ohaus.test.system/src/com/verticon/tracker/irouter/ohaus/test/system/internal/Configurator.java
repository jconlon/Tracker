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

package com.verticon.tracker.irouter.ohaus.test.system.internal;

import static com.verticon.tracker.irouter.ohaus.ConfigKey.RESPONSE_DELAY_MILLIS;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.CONNECTION_URI;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.FACTORY_PID;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.MINIMUM_WEIGHT_THRESHOLD;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.PRODUCER_SCOPE;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.WIRING_GROUP;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author jconlon
 * 
 */
public class Configurator {
	private static final int DELAY_IN_MILLIS = 20;
	private static final String portName = "/dev/ttyUSB0";
	private static final String baudRate = "9600";
	private static final String dataBits = "8";
	private static final String parity = "N";
	private static final String stopBits = "1";
	private static final String flowControl = null;// "0C";

	static String PLUGIN_ID = "com.verticon.tracker.irouter.ohaus.test.system";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	private static final String OHAUS_WEIGHT = "ohaus.weight";

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
		config.put("com.verticon.tracker.irouter.ohaus.test", "testOne");
		WIRING_GROUP.configure(config, "test");
		CONNECTION_URI.configure(config, getCommURI());
		MINIMUM_WEIGHT_THRESHOLD.configure(config, .1);
		RESPONSE_DELAY_MILLIS.configure(config, new Long(DELAY_IN_MILLIS));
		PRODUCER_SCOPE.configure(config, new String[] { OHAUS_WEIGHT });

		return config;
	}
	



	// comm://COM1;baudrate=9600;databits=9
	private static String getCommURI() {
		if (baudRate == null) {
			return "comm://" + portName;
		}
		try {
			URI uri = new URI("comm",// schema
					getSsp(portName),// ssp
					null);
			System.out.println(uri);
			return uri.toString();
		} catch (URISyntaxException e) {
			throw new IllegalStateException(e);
		}

	}

	private static String getSsp(String portName) {
		StringBuffer sb = new StringBuffer(portName);
		if (baudRate != null) {
			sb.append(";baudrate=");
			sb.append(baudRate);
		}

		if (dataBits != null) {
			sb.append(";databits=");
			sb.append(dataBits);
		}

		if (stopBits != null) {
			sb.append(";stopbits=");
			sb.append(stopBits);
		}

		if (parity != null) {
			sb.append(";parity=");
			sb.append(parity);
		}

		if (flowControl != null) {
			sb.append(";flowcontrol=");
			sb.append(flowControl);
		}

		return sb.toString();
		}
}
