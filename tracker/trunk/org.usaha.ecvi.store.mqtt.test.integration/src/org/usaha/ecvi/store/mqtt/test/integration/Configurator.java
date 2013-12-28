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

package org.usaha.ecvi.store.mqtt.test.integration;

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
import org.osgi.service.wireadmin.WireConstants;
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
 * For creating ConfigAdmin configuration for testing the
 * org.usaha.ecvi.store.mqtt component.
 * 
 * Configuring the services in the chain: org.usaha.ecvi.store.mqtt <--> MQTT
 * <-> com.verticon.tracker.irouter.mqtt <->
 * org.usaha.ecvi.store.mongodb.irouter -> com.verticon.mongo
 * 
 * 
 * 
 * The dependent services are:
 * <ol>
 * <li>IMongoClientProvider for the backend</li>
 * </ol>
 * 
 * 
 * @author jconlon
 * 
 */
public class Configurator implements IMqttConfigurator {

	private static final String ECVI_RESPONSE_SCOPE = "agriculture.ecvi.response";

	private static final String RECORD_ECVI_SCOPE = "agriculture.premises.ecvi.emf";

	private static final String RECORD_ECVI_MQTT_TOPIC = "Agriculture/Premises/+/Ecvi/EMF";

	static String PLUGIN_ID = "org.usaha.ecvi.store.mqtt.test.integration";

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

	// Frontend
	private static final String FRONTEND_WIRING_GROUP = "test";
	// Factories to configure
	private static final String ECVI_STORE_MQTT_FACTORY_PID = "org.usaha.ecvi.store.mqtt";

	// Backend
	private static final String BACKEND_WIRING_GROUP = "backend";
	private static final String BACKEND_MQTT_CLIENTID = "verticon.com";
	// Factories to configure
	private static final String IROUTER_MQTT_FACTORY_PID = "com.verticon.tracker.irouter.mqtt";
	private static final String MONGO_PROVIDER_FACTORY_PID = "com.verticon.mongo";
	private static final String ECVIMONGOIROUTERCOMPONENT_FACTORY_PID = "org.usaha.ecvi.store.mongodb.irouter";

	private final String TOPIC = "Agriculture/Premises/#";

	private static final String PREMISES_URI_H89234X = "urn:pin:H89234X";

	private static final String UNITTEST_PROPERTIES = "private/localhost.properties";

	static final Properties localProps = new Properties();
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
		// Configure MqttEcviStore --> MQTT -> irouterMQTT -> trackerStore
		// Configure the frontend service
		configure_MqttEcviStore_frontend(configAdmin);
		// Configure the backend service
		configure_irouterMQTT_backend(configAdmin);
		configure_IMongoClientProvider_backend(configAdmin);
		configure_EcviMongoIRouter_backend(configAdmin);
	}

	void unsetConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "UnSetting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

	}

	private void configure_MqttEcviStore_frontend(ConfigurationAdmin configAdmin)
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

		props.put("tracker.wiring.group.name", FRONTEND_WIRING_GROUP);
		props.put("tracker.premises.uri", PREMISES_URI_H89234X);

		// take all defaults
		config.update(props);
		logger.debug(bundleMarker, "Created Configuration for {}",
				config.getPid());
	}

	// Backend
	private void configure_irouterMQTT_backend(ConfigurationAdmin configAdmin)
			throws IOException {
		Configuration config = configAdmin
				.createFactoryConfiguration(IROUTER_MQTT_FACTORY_PID);
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

		props.put("tracker.wiring.group.name", BACKEND_WIRING_GROUP);
		props.put("mqtt.clientid", BACKEND_MQTT_CLIENTID);
		/*
		 * Topics and producer scopes must have the same number of entries and
		 * be semantically compatible.
		 * 
		 * Backend will listen to Recordings of Ecvis
		 */
		props.put("mqtt.subscriber.topics",
				new String[] { RECORD_ECVI_MQTT_TOPIC });

		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { RECORD_ECVI_SCOPE });

		/*
		 * Consumer will handle responses to queries from the backend
		 */
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { ECVI_RESPONSE_SCOPE });

		// take all defaults
		config.update(props);
		logger.debug(bundleMarker, "Created Configuration for {}",
				config.getPid());
	}

	/**
	 * The EcviMongoIRouterComponent requires a IEcviStore service and
	 * configuration to offer its WireAdmin Consumer and a WireAdmin Producer
	 * services.
	 * 
	 * Configuration: the uri to use for the IEcviStore;
	 * 
	 * 
	 * 
	 * To test it a MockProducerConsumer will offer Consumer, Producer and
	 * IProducerConsumer services.
	 * 
	 * The IConsumerProducer is a service that offers controls to the Test class
	 * for sending Envelopes out of its producer and generating products
	 * received by its Consumer to IConsumerListener.
	 * 
	 * The tests will send the MockProducerConsumer envelopes containing Ecvi
	 * objects and listen as a IConsumerListener for Responses
	 * 
	 * 
	 * @param configAdmin
	 * @throws IOException
	 */
	private void configure_EcviMongoIRouter_backend(
			ConfigurationAdmin configAdmin) throws IOException {
		Configuration config = configAdmin
				.createFactoryConfiguration(ECVIMONGOIROUTERCOMPONENT_FACTORY_PID);

		Dictionary<String, Object> props = new Hashtable<String, Object>();

		// MongoProvider URI
		props.put("mongo.provider.uri", "localhost:27017/tracker");
		// iRouter configurations
		props.put("tracker.wiring.group.name", BACKEND_WIRING_GROUP);
		// These are the Defaults for scopes
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { RECORD_ECVI_SCOPE });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { ECVI_RESPONSE_SCOPE });

		// take all defaults
		config.update(props);
		logger.debug(bundleMarker,
				"Created Configuration for EcviMongoIRouterComponent {}",
				config.getPid());
	}

	/**
	 * The EcviMongoIRouterComponent requires a IEcviStore which in turn requies
	 * a IMongoClientProvider to offer its service
	 * 
	 * @param configAdmin
	 * @throws IOException
	 */
	private void configure_IMongoClientProvider_backend(
			ConfigurationAdmin configAdmin) throws IOException {
		Configuration config = configAdmin
				.createFactoryConfiguration(MONGO_PROVIDER_FACTORY_PID);

		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put("mongoClientProvider", "local");

		if (localProps.get("dbname") != null) {
			props.put("dbname", localProps.get("dbname"));
		} else {
			props.put("dbname", "test_tracker");
		}

		if (localProps.get("mongo.connection.uri") != null) {
			props.put("connection.uri", localProps.get("mongo.connection.uri"));
		}
		logger.info(bundleMarker, "Mongo Host{}", props.get("connection.uri"));
		if (localProps.get("password") != null) {
			props.put("password", localProps.get("password"));
		}
		if (localProps.get("username") != null) {
			props.put("username", localProps.get("username"));
		}

		// take all other defaults
		config.update(props);
		logger.debug(bundleMarker,
				"Created Configuration for IMongoClientProvider {}",
				config.getPid());
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

	@SuppressWarnings("unused")
	private static void saveXMIResource(String fileName, Premises premises)
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

	private static Resource getXMIResource(String pluginID, String fileName,
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

	private static void init() {
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
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
