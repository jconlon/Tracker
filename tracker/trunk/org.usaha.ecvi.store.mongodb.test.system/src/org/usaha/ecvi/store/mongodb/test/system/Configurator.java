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

package org.usaha.ecvi.store.mongodb.test.system;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * The EcviMongoDBUpdate requires one or more IMongoClientProvider services and
 * a IFunctionProvider.
 * 
 * 
 * For creating ConfigAdmin configuration for a dependent service.
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
public class Configurator {

	static final String PLUGIN_ID = "org.usaha.ecvi.store.mongodb.test.system";

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
	private static final String MONGO_PROVIDER_FACTORY_PID = "com.verticon.mongo";
	private static final String ECVIMONGOIROUTERCOMPONENT_FACTORY_PID = "org.usaha.ecvi.store.mongodb.irouter";

	private static final String UNITTEST_PROPERTIES = "private/localhost.properties";
	static final Properties localProps = new Properties();
	static {
		init();
	}

	/**
	 * DS injected
	 * 
	 * @param configAdmin
	 * @throws IOException
	 */
	void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "Setting ConfigurationAdmin");
		deleteConfigurations(configAdmin);
		configureIMongoClientProvider(configAdmin);
		configureEcviMongoIRouterComponent(configAdmin);
	}

	/**
	 * DS injected
	 * 
	 * @param configAdmin
	 * @throws IOException
	 */
	void unsetConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "UnSetting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

	}

	/**
	 * The EcviMongoComponent requires a IMongoClientProvider to offer its
	 * IEcviStore service
	 * 
	 * @param configAdmin
	 * @throws IOException
	 */
	private void configureIMongoClientProvider(ConfigurationAdmin configAdmin)
			throws IOException {
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
	private void configureEcviMongoIRouterComponent(
			ConfigurationAdmin configAdmin) throws IOException {
		Configuration config = configAdmin
				.createFactoryConfiguration(ECVIMONGOIROUTERCOMPONENT_FACTORY_PID);

		Dictionary<String, Object> props = new Hashtable<String, Object>();

		// MongoProvider URI
		props.put("mongo.provider.uri", "localhost:27017/tracker");
		// iRouter configurations
		props.put("tracker.wiring.group.name", "test");
		// These are the Defaults for scopes
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { "agriculture.ecvi" });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { "agriculture.ecvi.response" });

		// take all defaults
		config.update(props);
		logger.debug(bundleMarker,
				"Created Configuration for EcviMongoIRouterComponent {}",
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
