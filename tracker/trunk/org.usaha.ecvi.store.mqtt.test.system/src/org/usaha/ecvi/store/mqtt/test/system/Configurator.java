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

package org.usaha.ecvi.store.mqtt.test.system;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.usaha.ecvi.Premises;

import com.google.common.base.Strings;
import com.verticon.mqtt.test.utilities.IMqttConfigurator;

/**
 * 
 * 
 * For creating ConfigAdmin configuration for a dependent service of the
 * com.verticon.tracker.update.mongo component.
 * 
 * The dependent service is:
 * <ol>
 * <li>IMongoClientProvider</li>
 * </ol>
 * 
 * 
 * @author jconlon
 * 
 */
public class Configurator implements IMqttConfigurator {

	static String PLUGIN_ID = "org.usaha.ecvi.store.mqtt.test.system";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Configurator.class);

	private final String TOPIC = "Agriculture/Premises/#";

	static final String PREMISES_URI_H89234X = "urn:pin:H89234X";

	// Frontend Factory to configure
	private static final String ECVI_STORE_MQTT_FACTORY_PID = "org.usaha.ecvi.store.mqtt";
	private static final String UNITTEST_PROPERTIES = "private/localhost.properties";

	static Properties localProps = new Properties();
	static {
		init();
	}

	public Configurator() {
		super();

	}

	@Override
	public String getURL() {
		return localProps.getProperty("connection.uri");

	}

	@Override
	public String getTopic() {
		return TOPIC;
	}

	void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "Setting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

		// Configure the frontend service
		configure_MqttEcviStore_Service(configAdmin);
	}

	void configure_MqttEcviStore_Service(ConfigurationAdmin configAdmin)
			throws IOException {
		Configuration config = configAdmin
				.createFactoryConfiguration(ECVI_STORE_MQTT_FACTORY_PID);
		Dictionary<String, Object> props = new Hashtable<String, Object>();

		if (localProps.get("connection.uri") != null) {
			props.put("connection.uri", localProps.get("connection.uri"));
		}
		logger.info(bundleMarker, "MQTT Host {}", props.get("connection.uri"));

		if (localProps.get("password") != null) {
			props.put("password", localProps.get("password"));
		}
		if (localProps.get("username") != null) {
			props.put("username", localProps.get("username"));
		}

		props.put("tracker.wiring.group.name", "test");
		props.put("tracker.premises.uri", PREMISES_URI_H89234X);

		// take all defaults
		config.update(props);
		logger.debug(bundleMarker, "Created Configuration for {}",
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
			logger.error(bundleMarker, "Failed to delete configurations", e);
		}
	}

	static void saveXMIResource(String fileName, Premises premises)
			throws IOException {
		checkNotNull(fileName);
		checkNotNull(premises);
		checkArgument(fileName.endsWith(".premises"));
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createFileURI(new File("resources/" + fileName)
				.getAbsolutePath());
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(premises);
		resource.save(null);
	}

	static Resource getXMIResource(String fileName, String segment) {
		return getXMIResource(PLUGIN_ID, fileName, segment);
	}

	static Resource getXMIResource(String pluginID, String fileName,
			String segment) {
		URI uri = URI.createPlatformPluginURI(pluginID, true);

		if (Strings.isNullOrEmpty(segment)) {
			uri = uri.appendSegments(new String[] { "resources", fileName });
		} else {
			uri = uri.appendSegments(new String[] { "resources", segment,
					fileName });
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		return resource;
	}

	static void init() {
		Bundle bundle = Platform
.getBundle(PLUGIN_ID);
		URL fileURL = bundle.getEntry(UNITTEST_PROPERTIES);
		File file = null;
		try {
			file = new File(FileLocator.resolve(fileURL).toURI());
			if (file.exists()) {
				localProps.load(new FileReader(file));
			}
		} catch (Exception e1) {
			throw new IllegalStateException(e1);
		}
	}
}
