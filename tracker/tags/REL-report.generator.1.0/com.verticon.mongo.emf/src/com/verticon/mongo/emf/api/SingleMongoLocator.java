/*******************************************************************************
 * Copyright (c) 2012 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package com.verticon.mongo.emf.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mongo.IDatabaseAuthenticationProvider;
import org.eclipselabs.mongo.IDatabaseLocator;
import org.eclipselabs.mongo.IMongoProvider;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * IMongoLocator for a single nongoDB Connection.
 * 
 * @author bhunt
 * @author jconlon
 * 
 */
public class SingleMongoLocator implements IMongoProvider, IDatabaseLocator, IDatabaseAuthenticationProvider {

	private volatile Mongo mongo;
	private String user;
	private String password;

	// Convention for formating a connection uri variable name so it can be
	// used for drawing connections in the graphic iRouter network map
	public String CONNECTION_PROP_URI = "connection.uri";
	private String rawUri;

	/**
	 * @return the rawUri
	 */
	public String getRawUri() {
		return rawUri;
	}

	public SingleMongoLocator() {
	}

	public SingleMongoLocator(String uri, String user, String password)
			throws MongoException, UnknownHostException, URISyntaxException {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put(CONNECTION_PROP_URI, uri);
		properties.put(PROP_USER, user);
		properties.put(PROP_PASSWORD, password);
		configure(properties);
	}

	@Override
	public Mongo getMongo() {
		return mongo;
	}

	@Override
	public String getUser() {
		return user;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void configure(Map<String, Object> config) throws MongoException,
			UnknownHostException, URISyntaxException {
		MongoOptions options = new MongoOptions();

		String description = (String) config.get(PROP_DESCRIPTION);

		if (description != null)
			options.description = description;

		Integer connectionsPerHost = getConfigurationInteger(config
				.get(PROP_CONNECTIONS_PER_HOST));

		if (connectionsPerHost != null)
			options.connectionsPerHost = connectionsPerHost;

		Integer threadsAllowedToBlockForConnectionMultiplier = getConfigurationInteger(config
				.get(PROP_THREADS_ALLOWED_TO_BLOCK_FOR_CONNECTION_MULTIPLIER));

		if (threadsAllowedToBlockForConnectionMultiplier != null)
			options.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;

		Integer maxWaitTime = getConfigurationInteger(config
				.get(PROP_MAX_WAIT_TIME));

		if (maxWaitTime != null)
			options.maxWaitTime = maxWaitTime;

		Integer connectTimeout = getConfigurationInteger(config
				.get(PROP_CONNECT_TIMEOUT));

		if (connectTimeout != null)
			options.connectTimeout = connectTimeout;

		Integer socketTimeout = getConfigurationInteger(config
				.get(PROP_SOCKET_TIMEOUT));

		if (socketTimeout != null)
			options.socketTimeout = socketTimeout;

		Boolean socketKeepAlive = getConfigurationBoolean(config
				.get(PROP_SOCKET_KEEP_ALIVE));

		if (socketKeepAlive != null)
			options.socketKeepAlive = socketKeepAlive;

		Boolean autoConnectRetry = getConfigurationBoolean(config
				.get(PROP_AUTO_CONNECT_RETRY));

		if (autoConnectRetry != null)
			options.autoConnectRetry = autoConnectRetry;

		Long maxAutoConnectRetryTime = getConfigurationLong(config
				.get(PROP_MAX_AUTO_CONNECT_RETRY_TIME));

		if (maxAutoConnectRetryTime != null)
			options.maxAutoConnectRetryTime = maxAutoConnectRetryTime;

		Boolean safe = getConfigurationBoolean(config.get(PROP_SAFE));

		if (safe != null)
			options.safe = safe;

		Integer w = getConfigurationInteger(config.get(PROP_W));

		if (w != null)
			options.w = w;

		Integer wtimeout = getConfigurationInteger(config.get(PROP_WTIMEOUT));

		if (wtimeout != null)
			options.wtimeout = wtimeout;

		Boolean fsync = getConfigurationBoolean(config.get(PROP_FSYNC));

		if (fsync != null)
			options.fsync = fsync;

		Boolean j = getConfigurationBoolean(config.get(PROP_J));

		if (j != null)
			options.j = j;

		// The uriProperty is a single string containing one or more server
		// URIs.
		// When more than one URI is specified, it denotes a replica set and the
		// URIs must be separated by a comma (CSV).
		Object uriProperty = config.get(CONNECTION_PROP_URI);

		if (uriProperty == null)
			throw new UnknownHostException(
					"The MongoDB URI was not found in the configuration properties");

		rawUri = (String) uriProperty;
		String[] uris = (rawUri).split(",");

		if (uris.length == 1) {
			ServerAddress serverAddress = createServerAddress(uris[0].trim());
			mongo = new Mongo(serverAddress, options);
		} else {
			ArrayList<ServerAddress> serverAddresses = new ArrayList<ServerAddress>(
					uris.length);

			for (String uri : uris)
				serverAddresses.add(createServerAddress(uri.trim()));

			mongo = new Mongo(serverAddresses, options);
		}

		user = (String) config.get(PROP_USER);
		password = (String) config.get(PROP_PASSWORD);
	}

	private ServerAddress createServerAddress(String uriProperty)
			throws URISyntaxException, UnknownHostException {
		URI uri = new URI(uriProperty);
		int port = uri.getPort();
		ServerAddress serverAddress = port == -1 ? new ServerAddress(
				uri.getHost())
				: new ServerAddress(uri.getHost(), uri.getPort());
		return serverAddress;
	}

	@Override
	public DB getDatabase(String uri) {
		String[] parts = uri.split("/");

		if (parts.length < 4)
			return null;

		DB db = getMongo().getDB(parts[3]);
		String user = getUser();

		if (user != null)
			db.authenticate(user, getPassword().toCharArray());

		return db;
	}

//	@Override
//	public Mongo getMongo(String arg0) {
//		return getMongo();
//	}

	public DB getTrackerDatabase() {
		DB db = getMongo().getDB("tracker");
		String user = getUser();

		if (user != null)
			db.authenticate(user, getPassword().toCharArray());

		return db;
	}

	private static Integer getConfigurationInteger(Object o) {
		Integer result = null;
		if (o instanceof Integer) {
			result = (Integer) o;
		} else if (o instanceof String) {
			result = Integer.parseInt((String) o);
		}
		return result;
	}

	private static Long getConfigurationLong(Object o) {
		Long result = null;
		if (o instanceof Long) {
			result = (Long) o;
		} else if (o instanceof String) {
			result = Long.parseLong((String) o);
		}
		return result;
	}

	private static Boolean getConfigurationBoolean(Object o) {
		Boolean result = null;
		if (o instanceof Boolean) {
			result = (Boolean) o;
		} else if (o instanceof String) {
			result = Boolean.parseBoolean((String) o);
		}
		return result;
	}

	@Override
	public String getURI() {
		return rawUri;
	}

}
