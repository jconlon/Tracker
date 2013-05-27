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
package com.verticon.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


final public class Utils {

	private Utils() {
		// prevent construction
	}

	/**
	 * Parses the semicolon separated list of server:port names.
	 * 
	 * @param serverNames
	 *            the server names, cannot be <code>null</code>.
	 * @return a list of {@link ServerAddress}es to connect to, never
	 *         <code>null</code>.
	 * @throws IllegalArgumentException
	 *             in case the given server names was invalid.
	 */
	public static List<ServerAddress> parseServers(String serverNames) {
		String[] parts = serverNames.split(";");

		List<ServerAddress> servers = new ArrayList<ServerAddress>();
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			try {
				int colonPos = part.indexOf(":");
				if (colonPos > 0 && (colonPos < part.length() - 1)) {
					String name = part.substring(0, colonPos);
					String portStr = part.substring(colonPos + 1);
					servers.add(new ServerAddress(name, Integer
							.valueOf(portStr)));
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Illegal port number in: "
						+ part);
			} catch (UnknownHostException e) {
				throw new IllegalArgumentException("Unknown host: " + part);
			}
		}

		if (servers.isEmpty()) {
			throw new IllegalArgumentException("No (valid) servers defined!");
		}

		return servers;
	}

	/**
	 * Connects to the database with the supplied credentials.
	 * 
	 * @param userName
	 *            the optional user name to use;
	 * @param password
	 *            the optional password to use.
	 * @return <code>true</code> if the connection was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean authenticate(String userName, String password,
			MongoClient mongoClient, String dbName) {
		if ((userName != null) && (password != null)) {
			DB db = mongoClient.getDB(dbName);
			if (!db.authenticate(userName, password.toCharArray())) {
				return false;
			}
		}

		return true;
	}


}
