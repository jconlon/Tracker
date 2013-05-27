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

import static com.verticon.mongo.internal.StatusAndConfigVariables.getDBName;
import static com.verticon.mongo.internal.StatusAndConfigVariables.getPassword;
import static com.verticon.mongo.internal.StatusAndConfigVariables.getServerNames;
import static com.verticon.mongo.internal.StatusAndConfigVariables.getUserName;

import java.io.IOException;
import java.util.Map;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.verticon.mongo.IMongoClientProvider;
import com.verticon.mongo.MongoClientBuilder;
import com.verticon.mongo.MongoClientProvider;

/**
 * Provides a repository store that uses Utils for storing the role information.
 * <p>
 * This service can also be configured at runtime by using the PID .<br/>
 * The configuration options recognized by this service are:
 * </p>
 * <dl>
 * <dt>server</dt>
 * <dd>A space separated string containing the Utils servers. The format for
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
 * Utils. This value is optional;</dd>
 * <dt>password</dt>
 * <dd>A string value representing the password to authenticate against Utils.
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
public class Component implements IMongoClientProvider, Monitorable {

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
	private final Monitor monitor = new Monitor();
	private MongoClientProvider mongoClientProvider;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.mongo.IMongoClientProvider#getMongoClient()
	 */
	@Override
	public MongoClient getMongoClient() {
		return mongoClientProvider.getMongoClient();
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.resetStatusVariable(id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return monitor.getDescription(id);
	}

	@Override
	public String uri() {
		return mongoClientProvider.uri();
	}

	void activate(Map<String, Object> config) throws IOException {
		monitor.activate(config);
		String dbName = getDBName(config);
		// Defaults to "localhost:27017"
		String serverNames = getServerNames(config);

		String uri = serverNames + '/' + dbName;

		String username = getUserName(config);
		String password = getPassword(config);
		try {

			this.mongoClientProvider = new MongoClientBuilder().dbName(dbName)
					.serverNames(serverNames).userName(username)
					.password(password).build();

		} catch (MongoException e) {
			logger.error("Failed to connect to " + uri, e);
			throw e;
		}
	}

	/**
	 * Closes this store and disconnects from the Utils back end.
	 */
	void deactivate() {
		if (mongoClientProvider != null) {
			mongoClientProvider.close();
		}

	}

	@Override
	public String getDatabaseName() {
		return mongoClientProvider.getDatabaseName();
	}

	@Override
	public String[] getStatusVariableNames() {
		return monitor.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.getStatusVariable(id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return monitor.notifiesOnChange(id);
	}



	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		// monitor.setMonitorListener(monitorListener);
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		// monitor.unsetMonitorListener(monitorListener);
	}


}
