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

package com.verticon.tracker.store.location.test.system.internal;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.wireadmin.WireConstants;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.verticon.tracker.TrackerPackage;

/**
 * @author jconlon
 * 
 */
public class Configuator {
	private static final String TEST_TRACKERSTORE_LOCATION = "test_trackerstore_location";
	private static final String FACTORY_PID = "com.verticon.tracker.store.mongodb";
	static final String PREMISES_URI_H89234X = "urn:pin:H89234X";
	private static final String ANIMAL_COLLECTION = "Animal";
	static final String URN_PIN_003CZKO = "urn:pin:003CZKO";

	private static final String TAG_COLLECTION = "Tag";

	private static final String PREMISES_COLLECTION = "Premises";

	private static final String UPDATES_COLLECTION = "Updates";

	public void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {

		// Configure the IMongoClientProvider
		Configuration config = configAdmin
				.createFactoryConfiguration(FACTORY_PID);
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put("iMongoClientProvider", "remote");
		props.put("dbname", TEST_TRACKERSTORE_LOCATION);
		props.put("com.verticon.tracker.mongo.test", "testOne");

		props.put("tracker.wiring.group.name", "test");
		props.put("tracker.premises.uri", PREMISES_URI_H89234X);
		props.put("premises.animal.default", TrackerPackage.BOVINE_BISON);
		// wireadmin.consumer.scope
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[] {
				"animal.weight", "premises.tag", "gps.position",
				"mettler.weight", "premises.animal" });
		// take all defaults
		config.update(props);
	}

	static void cleanDatabase() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB(TEST_TRACKERSTORE_LOCATION);
		DBObject find = new BasicDBObject();
		DBCollection coll = db.getCollection(ANIMAL_COLLECTION);
		coll.remove(find);
		coll = db.getCollection(PREMISES_COLLECTION);
		coll.remove(find);
		// coll = getCollection(KEY_MONGODB_DBNAME, OCD_COLLECTION);
		// coll.remove(find);
		coll = db.getCollection(TAG_COLLECTION);
		coll.remove(find);
		coll = db.getCollection(UPDATES_COLLECTION);
		coll.remove(find);
	}

}
