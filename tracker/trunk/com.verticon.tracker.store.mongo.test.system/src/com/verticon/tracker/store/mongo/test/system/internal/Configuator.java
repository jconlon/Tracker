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

import com.mongodb.MongoURI;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.mongo.test.system.Member;
import com.verticon.tracker.store.mongo.test.system.Variables;

/**
 * @author jconlon
 * 
 */
public class Configuator {
	private static final String UNITTEST_PROPERTIES = "private/unittest.properties";

	private static final String FACTORY_PID = "com.verticon.tracker.store.mongo";
	//static final String MONGO_LOCALHOST = "mongodb://localhost";
    
	static final String ANIMAL_SCOPE = "premises.animald";
	static final String TAG_SCOPE = "premises.tag";
	static final String ANIMAL_WEIGHT_SCOPE = "animal.weight";
    static final String POSITION_SCOPE = "gps.position";
    static final String METTLER_WEIGHT_SCOPE = "mettler.weight";
    

	private static Properties localProps = null;

	public void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
//		addMembersCollection();
		// Configure the first instance
		Configuration config = configAdmin.createFactoryConfiguration(FACTORY_PID);
		Dictionary<String, Object> props = configure1();
		config.update(props);
		
		//The second
		config = configAdmin.createFactoryConfiguration(FACTORY_PID);
		props = configure2();
		config.update(props);
	}


	private static Dictionary<String, Object> configure1() {
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		configureConnection(props);
		
		//Provided 
		props.put("com.verticon.tracker.mongo.test","testOne");
		props.put(Variables.DEFAULT_ANIMAL.configID, TrackerPackage.BOVINE_BISON);
		props.put("tracker.wiring.group.name", "test");
		props.put(PREMISES_URI.configID, ONE.uri);
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[]{
				TAG_SCOPE,//Tags ->Tags
				ANIMAL_WEIGHT_SCOPE, //Measurements ->WeighIn
				POSITION_SCOPE,//Positions -> Positions
				METTLER_WEIGHT_SCOPE,//Measurement -> GenericEvents
				ANIMAL_SCOPE//Animals -> Animals
				});

		props.put("w", 1);
		return props;
	}

	public static MongoURI getLocalMongoURL() {
		// ResourceBundle myResources = ResourceBundle
		// .getBundle(UNITTEST_PROPERTIES);
		// for (String s : myResources.keySet()) {
		// System.out.println(s);
		// }

		if (localProps == null) {
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

		return new MongoURI((String) localProps.get("mongourl"));
	}
	
	private static Dictionary<String, Object> configure2() {
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		configureConnection(props);

		props.put("com.verticon.tracker.mongo.test","testTwo");
		props.put(Variables.DEFAULT_ANIMAL.configID, TrackerPackage.SWINE);
		props.put("tracker.wiring.group.name", "test2");
		props.put(Variables.PREMISES_URI.configID, Member.THREE.uri);
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[]{TAG_SCOPE});
		return props;
	}

	public static void configureConnection(Dictionary<String, Object> props) {
		MongoURI mongoURI = getLocalMongoURL();
		if (isNullOrEmpty(mongoURI.getUsername())
				|| mongoURI.getPassword().length < 1) {

		} else {

			props.put("user", mongoURI.getUsername());

			props.put("password", mongoURI.getPassword() != null ? new String(
					mongoURI.getPassword()) : null);
		}
		props.put(Variables.MONGO_URI.configID, mongoURI.toString());
	}

//	private static void addMembersCollection() throws UnknownHostException,
//			MongoException {
//		Mongo mongo = new Mongo();
//		DB db = mongo.getDB("tracker");
//		if (!db.collectionExists("Members")) {
//			// db.getCollection(TrackerPackage.Literals.ANIMAL.getName()).drop();
//			DBCollection collection = db.getCollection("Members");
//			for (Member m : Member.values()) {
//				DBObject member = new BasicDBObject("id", m.uri);
////				member.put("pw", m.password);
//				collection.insert(member);
//			}
//
//		}
//	}
}
