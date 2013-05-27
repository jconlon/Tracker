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

package com.verticon.tracker.store.mongo.test.system.internal;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.verticon.tracker.store.mongo.test.system.Member.ONE;
import static com.verticon.tracker.store.mongo.test.system.Variables.PREMISES_URI;
import static com.verticon.tracker.store.mongo.test.system.Variables.PROVIDED_COLLECTION;
import static com.verticon.tracker.store.mongo.test.system.internal.Test_TrackerStore_1_Basic.bundleMarker;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
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

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.mongo.test.system.Member;
import com.verticon.tracker.store.mongo.test.system.Variables;

/**
 * @author jconlon
 * 
 */
public class Configuator {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Configuator.class);

	private static final String UNITTEST_PROPERTIES = "private/unittest.properties";

	private static final String FACTORY_PID = "com.verticon.tracker.store.mongo";
	private static final String MONITORED_FACTORY_PID = "com.verticon.tracker.store.mongo.monitored";
    
	static final String ANIMAL_SCOPE = "premises.animald";
	static final String TAG_SCOPE = "premises.tag";
	static final String ANIMAL_WEIGHT_SCOPE = "animal.weight";
    static final String POSITION_SCOPE = "gps.position";
    static final String METTLER_WEIGHT_SCOPE = "mettler.weight";
    

	private static Properties localProps = null;
	private static MongoClient mongoClient = null;
	private static MongoClientURI mongoURI = null;
	private static DB trackerDB = null;

	void activate() throws UnknownHostException {
		mongoURI = getMongoURI();
		mongoClient = new MongoClient(mongoURI);
		trackerDB = mongoClient.getDB("tracker");
	}

	void deactivate() {
		if (mongoClient != null) {
			mongoClient.close();
			mongoClient = null;
		}
		mongoURI = null;
		trackerDB = null;

	}

	void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "Setting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

		// Configure the first test class
		Configuration config;
		if (isMonitored()) {
			config = configAdmin
					.createFactoryConfiguration(MONITORED_FACTORY_PID);
		} else {
			config = configAdmin.createFactoryConfiguration(FACTORY_PID);
		}

		Dictionary<String, Object> props = configureTest1();
		config.update(props);
		logger.debug(bundleMarker, "Created Configuration for Test 1 {}",
				config.getPid());

		// Configure the second test class
		if (isMonitored()) {
			config = configAdmin
					.createFactoryConfiguration(MONITORED_FACTORY_PID);
		} else {
			config = configAdmin.createFactoryConfiguration(FACTORY_PID);
		}
		props = configureTest2();
		config.update(props);
		logger.debug(bundleMarker, "Created Configuration for Test 2 {}",
				config.getPid());
	}

	void unsetConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "UnSetting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

	}

	public static DB getTrackerDB() throws UnknownHostException {
		String userName = mongoURI.getUsername();
		if (userName != null && !trackerDB.isAuthenticated()) {
			trackerDB.authenticate(userName, mongoURI.getPassword());
		}
		return trackerDB;
	}

	static MongoClientURI getMongoURI() {
		if (mongoURI == null) {
			if (localProps == null) {
				loadLocalProps();
			}

			mongoURI = new MongoClientURI((String) localProps.get("mongourl"));
		}
		return mongoURI;
	}

	private static boolean isMonitored() {
		boolean monitored = false;
		if (localProps == null) {
			loadLocalProps();
		}

		if (localProps.get("monitored") != null) {
			monitored = localProps.get("monitored").equals("true");
		}

		return monitored;
	}

	private static void loadLocalProps() {
		Bundle bundle = Platform
				.getBundle("com.verticon.tracker.store.mongo.test.system");
		URL fileURL = bundle.getEntry(UNITTEST_PROPERTIES);
		File file = null;
		try {
			file = new File(FileLocator.resolve(fileURL).toURI());
			localProps = new Properties();
			localProps.load(new FileReader(file));
		} catch (Exception e1) {
			// e1.printStackTrace();
			throw new IllegalStateException(e1);
		}
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
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		configureConnection(props);
		
		//Provided 
		props.put("com.verticon.tracker.mongo.test","testOne");
		props.put(Variables.DEFAULT_ANIMAL.configID, TrackerPackage.BOVINE_BISON);
		props.put("tracker.wiring.group.name", "test");
		props.put(PREMISES_URI.configID, ONE.uri);
		props.put(PROVIDED_COLLECTION.configID, "useradmin");

		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[]{
				TAG_SCOPE,//Tags ->Tags
				ANIMAL_WEIGHT_SCOPE, //Measurements ->WeighIn
				POSITION_SCOPE,//Positions -> Positions
				METTLER_WEIGHT_SCOPE,//Measurement -> GenericEvents
				ANIMAL_SCOPE//Animals -> Animals
				});
		props.put("enableConsole", Boolean.TRUE);
		props.put("output.directory.name", "/tmp/trackerStore1");
		return props;
	}
	
	private static Dictionary<String, Object> configureTest2() {
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		configureConnection(props);
		props.put(PROVIDED_COLLECTION.configID, "useradmin");
		props.put("com.verticon.tracker.mongo.test", "testTwo");
		props.put(Variables.DEFAULT_ANIMAL.configID, TrackerPackage.SWINE);
		props.put("tracker.wiring.group.name", "test2");
		props.put(Variables.PREMISES_URI.configID, Member.THREE.uri);
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE,
				new String[] { TAG_SCOPE });
		props.put("enableConsole", Boolean.TRUE);
		props.put("output.directory.name", "/tmp/trackerStore2");
		return props;
	}



	private static void configureConnection(Dictionary<String, Object> props) {
		MongoClientURI mongoURI = getMongoURI();
		if (isNullOrEmpty(mongoURI.getUsername())
				|| mongoURI.getPassword().length < 1) {

		} else {

			props.put("user", mongoURI.getUsername());

			props.put("password", mongoURI.getPassword() != null ? new String(
					mongoURI.getPassword()) : null);
		}
		props.put(Variables.MONGO_URI.configID, mongoURI.toString());
	}


}
