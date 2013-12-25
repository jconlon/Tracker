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

package com.verticon.tracker.store.mqtt.test.integration;

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

import com.google.common.base.Strings;
import com.verticon.mqtt.test.utilities.IMqttConfigurator;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;

/**
 * 
 * 
 * For creating ConfigAdmin configuration for a dependent service of the
 * com.verticon.tracker.update.mongo component. BACKEND_WIRING_GROUP The
 * dependent service is:
 * <ol>
 * <li>IMongoClientProvider</li>
 * </ol>
 * 
 * 
 * @author jconlon
 * 
 */
public class Configurator implements IMqttConfigurator {

	private static final String BACKEND_MQTT_CLIENTID = "verticon.com";
	private static final String FRONTEND_WIRING_GROUP = "test";
	private static final String BACKEND_WIRING_GROUP = "backend";

	static String PLUGIN_ID = "com.verticon.tracker.store.mongodb.test.system";

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

	static final String PREMISES_URI_003ALKMN = "urn:pin:003ALKM";

	static final String PREMISES_URI = "jc:www.verticon";

	private final String BACKEND_PREMISES_URI = "jc:verticon.com";

	static final String ANIMAL_COLLECTION = "Animal";

	static final String OCD_COLLECTION = "OCD";

	static final String TAG_COLLECTION = "Tag";

	static final String PREMISES_COLLECTION = "Premises";

	static final String UPDATES_COLLECTION = "Updates";

	static final String DOC_PREMISES = "example.premises";

	static final String TAG_ID_1 = "1234567890";

	static final String TAG_ID_WITH_GENERIC_EVENT = "840456789012341";

	static final String FILE_TMP_OUT_PREMISES1 = "/tmp/out1.premises";

	static final String FILE_TMP_OUT_PREMISES2 = "/tmp/out2.premises";

	static final String TAG_ID_WITH_SIRE_AND_DAM = "840456789012343";

	private static final String TRACKER_STORE_MQTT_FACTORY_PID = "com.verticon.tracker.store.mqtt";
	private static final String IROUTER_MQTT_FACTORY_PID = "com.verticon.tracker.irouter.mqtt";
	private static final String TRACKERSTORE_FACTORY_PID = "com.verticon.tracker.store.mongodb";

	private static final String UNITTEST_PROPERTIES = "private/localhost.properties";


	static Properties localProps = new Properties();
	static {
		init();
	}

	public Configurator() {
		super();
		
	}

	void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "Setting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

		// Configure trackerStoreMQTT -> irouterMQTT -> trackerStore
		configure_trackerStoreMQTT_frontend(configAdmin);
		configure_irouterMQTT_backend(configAdmin);
		configure_trackerStoreMongoDB_backend(configAdmin);
	}

	void configure_trackerStoreMQTT_frontend(ConfigurationAdmin configAdmin)
			throws IOException {
		Configuration config = configAdmin
				.createFactoryConfiguration(TRACKER_STORE_MQTT_FACTORY_PID);
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

		props.put("test", "com.verticon.tracker.store.mqtt");
		props.put("wait.seconds", 1000);
		props.put("tracker.wiring.group.name", FRONTEND_WIRING_GROUP);
		props.put("tracker.premises.uri", PREMISES_URI_H89234X);
		props.put("premises.animal.default", TrackerPackage.BOVINE_BISON);
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[] {
				"animal.weight", "premises.tag", "gps.position",
				"mettler.weight", "premises.animal",
				"agriculture.premises.response" });
		config.update(props);
		logger.debug(bundleMarker, "Created Configuration for {}",
				config.getPid());
	}

	void configure_irouterMQTT_backend(ConfigurationAdmin configAdmin)
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
		 * Backend will listen to Registrations, Events, and Queries
		 */
		props.put("mqtt.subscriber.topics",
 new String[] {
				"Agriculture/Premises/+/Query",
				"Agriculture/Premises/+/Register/EMF",
				"Agriculture/Premises/+/Events/EMF" });
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
 new String[] {
				"agriculture.premises.query",
				"agriculture.premises.register.emf",
				"agriculture.premises.events.emf" });

		/*
		 * Consumer will handle responses to queries from the backend
		 */
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { "agriculture.premises.response" });

		// take all defaults
		config.update(props);
		logger.debug(bundleMarker, "Created Configuration for {}",
				config.getPid());
	}

	void configure_trackerStoreMongoDB_backend(ConfigurationAdmin configAdmin)
			throws IOException {
		Configuration config = configAdmin
				.createFactoryConfiguration(TRACKERSTORE_FACTORY_PID);
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put("iMongoClientProvider", "remote");
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

		props.put("tracker.wiring.group.name", BACKEND_WIRING_GROUP);
		props.put("tracker.premises.uri", BACKEND_PREMISES_URI);
		props.put("premises.animal.default", TrackerPackage.BOVINE_BISON);
		/*
		 * Will handle queries, registrations, and events
		 */
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[] {
				"agriculture.premises.query",
				"agriculture.premises.register.emf",
				"agriculture.premises.events.emf" });
		/*
		 * Will produce responses to queries
		 */
		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE,
				new String[] { "agriculture.premises.response" });
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
		String pluginID = "com.verticon.tracker.store.mqtt.test.integration";
		return getXMIResource(pluginID, fileName, segment);
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
				.getBundle("com.verticon.tracker.store.mqtt.test.integration");
		URL fileURL=null;
		
		if(bundle!=null){
			fileURL = bundle.getEntry(UNITTEST_PROPERTIES);
		}else{

		}
		File file = null;
		try {
			if (bundle != null) {
				fileURL = bundle.getEntry(UNITTEST_PROPERTIES);
				file = new File(FileLocator.resolve(fileURL).toURI());
			} else {
				file = new File(
						"/home/jconlon/Workspaces/tracker_dev-01/com.verticon.tracker.store.mqtt.test.integration/private/localhost.properties");
			}

			if (file.exists()) {
				localProps.load(new FileReader(file));
			}
		} catch (Exception e1) {
			throw new IllegalStateException(e1);
		}
	}

	@Override
	public String getURL() {
		return localProps.getProperty("connection.uri");
	}

	@Override
	public String getTopic() {
		return TOPIC;
	}
}
