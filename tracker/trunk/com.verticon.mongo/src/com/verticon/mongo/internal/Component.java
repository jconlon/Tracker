/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.verticon.mongo.internal;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.mongodb.DBCollection;
import com.mongodb.MongoException;
import com.verticon.mongo.MongoDBCollectionProvider;

/**
 * Provides a repository store that uses MongoDB for storing the role
 * information.
 * <p>
 * This service can also be configured at runtime by using the PID {@value #PID}
 * .<br/>
 * The configuration options recognized by this service are:
 * </p>
 * <dl>
 * <dt>server</dt>
 * <dd>A space separated string containing the MongoDB servers. The format for
 * this string is: "<code>&lt;host1:port1&gt; &lt;host2:port2&gt;</code>". This
 * value is optional;</dd>
 * <dt>dbname</dt>
 * <dd>A string value containing the name of the database to use for this store.
 * This value is optional;</dd>
 * <dt>collection</dt>
 * <dd>The name of the database collection to use for this store. This value is
 * optional;</dd>
 * <dt>username</dt>
 * <dd>A string value representing the name of the user to authenticate against
 * MongoDB. This value is optional;</dd>
 * <dt>password</dt>
 * <dd>A string value representing the password to authenticate against MongoDB.
 * This value is optional.</dd>
 * </dl>
 * <p>
 * Alternatively, one can also supply the above mentioned configuration keys
 * prefixed with "<tt>org.apache.felix.useradmin.mongodb.</tt>" as system
 * properties (e.g.:
 * <tt>-Dorg.apache.felix.useradmin.mongodb.server=my.mongo.server:27017</tt>).
 * However, this implies that only a single store can be configured on a system
 * (which could be a sensible default for some situations)!
 * </p>
 * <p>
 * By default, the following values are used:
 * </p>
 * <table>
 * <tr>
 * <td><tt>server</tt></td>
 * <td>"<tt>localhost:27017</tt>"</td>
 * </tr>
 * <tr>
 * <td><tt>dbname</tt></td>
 * <td>"<tt>ua_repo</tt>"</td>
 * </tr>
 * <tr>
 * <td><tt>collection</tt></td>
 * <td>"<tt>useradmin</tt>"</td>
 * </tr>
 * <tr>
 * <td><tt>username</tt></td>
 * <td>&lt;none&gt;</td>
 * </tr>
 * <tr>
 * <td><tt>password</tt></td>
 * <td>&lt;none&gt;</td>
 * </tr>
 * </table>
 * <p>
 * This class is thread-safe.
 * </p>
 */
public class Component implements MongoDBCollectionProvider {

	private static final String PLUGIN_ID = "com.verticon.mongo";
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
	private final Logger logger = LoggerFactory.getLogger(Component.class);

	/** The PID for the managed service reference. */
	public static final String PID = "com.verticon.mongo";

	/**
	 * A space-separated array with server definitions to access MongoDB. Format
	 * = "&lt;host1:port1&gt; &lt;host2:port2&gt;".
	 * */
	private static final String KEY_MONGODB_SERVER = "server";
	/** The name of the MongoDB database instance. */
	private static final String KEY_MONGODB_DBNAME = "dbname";
	/** The username of the MongoDB database instance. */
	private static final String KEY_MONGODB_USERNAME = "username";
	/** The password of the MongoDB database instance. */
	private static final String KEY_MONGODB_PASSWORD = "password";
	/** The name of the MongoDB collection to use. */
	private static final String KEY_MONGODB_COLLECTION_NAME = "collection";

	private static final String PREFIX = PID.concat(".");
	/** Default MongoDB server; first checks a system property */
	private static final String DEFAULT_MONGODB_SERVER = System.getProperty(
			PREFIX.concat(KEY_MONGODB_SERVER), "localhost:27017");
	/** Default MongoDB name */
	private static final String DEFAULT_MONGODB_DBNAME = System.getProperty(
			PREFIX.concat(KEY_MONGODB_DBNAME), "ua_repo");
	/** Default MongoDB collection */
	private static final String DEFAULT_MONGODB_COLLECTION = System
			.getProperty(PREFIX.concat(KEY_MONGODB_COLLECTION_NAME),
					"useradmin");
	/** Default MongoDB username */
	private static final String DEFAULT_MONGODB_USERNAME = System
			.getProperty(PREFIX.concat(KEY_MONGODB_USERNAME));
	/** Default MongoDB password */
	private static final String DEFAULT_MONGODB_PASSWORD = System
			.getProperty(PREFIX.concat(KEY_MONGODB_PASSWORD));

	private final AtomicReference<MongoDB> m_mongoDbRef;

	public Component() {
		m_mongoDbRef = new AtomicReference<MongoDB>();

	}

	/**
	 * Closes this store and disconnects from the MongoDB backend.
	 */
	void deactivate() {
		MongoDB mongoDB = m_mongoDbRef.get();
		if (mongoDB != null) {
			mongoDB.disconnect();
		}
		m_mongoDbRef.set(null);
	}

	void activate(Map<String, Object> properties) throws IOException {
		// Defaults to "ua_repo"
		String newDbName = getProperty(properties, KEY_MONGODB_DBNAME,
				DEFAULT_MONGODB_DBNAME);
		// Defaults to "localhost:27017"
		String newServers = getProperty(properties, KEY_MONGODB_SERVER,
				DEFAULT_MONGODB_SERVER);
		// Defaults to "useradmin"
		String newCollectionName = getProperty(properties,
				KEY_MONGODB_COLLECTION_NAME, DEFAULT_MONGODB_COLLECTION);
		// Defaults to null
		String newUsername = getProperty(properties, KEY_MONGODB_USERNAME,
				DEFAULT_MONGODB_USERNAME);
		// Defaults to null. FELIX-3774; use correct property name...
		String newPassword = getProperty(properties, KEY_MONGODB_PASSWORD,
				DEFAULT_MONGODB_PASSWORD);

		MongoDB newMongoDb = new MongoDB(newServers, newDbName,
				newCollectionName);

		MongoDB oldMongoDb;
		do {
			oldMongoDb = m_mongoDbRef.get();
		} while (!m_mongoDbRef.compareAndSet(oldMongoDb, newMongoDb));

		try {
			// FELIX-3775: oldMongoDb can be null when supplying the
			// configuration for the first time...
			if (oldMongoDb != null) {
				oldMongoDb.disconnect();
			}
		} catch (MongoException e) {
			logger.error(bundleMarker,
					"Failed to disconnect from (old) MongoDB!", e);
		}

		try {
			connectToDB(newMongoDb, newUsername, newPassword);
		} catch (MongoException e) {
			logger.error("Failed to connect to (new) MongoDB!", e);
			throw e;
		}
	}

	/**
	 * Creates a connection to MongoDB using the given credentials.
	 * 
	 * @param mongoDB
	 *            the {@link MongoDB} facade to connect to;
	 * @param userName
	 *            the (optional) user name to use;
	 * @param password
	 *            the (optional) password to use.
	 * @throws MongoException
	 *             in case the connection or authentication failed.
	 */
	private void connectToDB(MongoDB mongoDB, String userName, String password)
			throws MongoException {
		if (!mongoDB.connect(userName, password)) {
			throw new MongoException(
					"Failed to connect to MongoDB! Authentication failed!");
		}

		DBCollection collection = mongoDB.getCollection();
		if (collection == null) {
			throw new MongoException(
					"Failed to connect to MongoDB! No collection returned!");
		}

		// TODO
		// collection.ensureIndex(new BasicDBObject(NAME, 1).append("unique",
		// true));
		logger.info(bundleMarker, "Connected to {}. Collection {} ready.",
				mongoDB, collection.getName());
	}

	/**
	 * Returns the current database collection.
	 * 
	 * @return the database collection to work with, cannot be <code>null</code>
	 *         .
	 * @throws MongoException
	 *             in case no connection to MongoDB exists.
	 */
	@Override
	public DBCollection getCollection() {
		MongoDB mongoDB = m_mongoDbRef.get();
		if (mongoDB == null) {
			throw new MongoException("No connection to MongoDB?!");
		}
		return mongoDB.getCollection();
	}

	/**
	 * Returns the value for the given key from the given properties.
	 * 
	 * @param properties
	 *            the properties to get the value from, may be <code>null</code>
	 *            ;
	 * @param key
	 *            the key to retrieve the value for, cannot be <code>null</code>
	 *            ;
	 * @param defaultValue
	 *            the default value to use in case no value is present in the
	 *            given dictionary, the value is not a string, or the dictionary
	 *            itself was <code>null</code>.
	 * @return the value, can be <code>null</code> in case the given key lead to
	 *         a null value, or a null value was supplied as default value.
	 */
	private String getProperty(Map<String, Object> properties, String key,
			String defaultValue) {
		String result = defaultValue;
		if (properties != null) {
			Object value = properties.get(key);
			if (value != null && (value instanceof String)) {
				result = (String) value;
			}
		}
		return result;
	}

}
