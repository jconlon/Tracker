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
package com.verticon.tracker.store.mongodb.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * StatusAndConfigVar
 * 
 * @author jconlon
 * 
 */
public enum StatusAndConfigVariables {

	KEY_MONGODB_SERVER("connection.uri", "consumer.Connection_URI",
			false,
			"The Server and port of the MongoDB.",
			"localhost:27017"),
	//
	KEY_MONGODB_DBNAME("dbname", "external.Name", false,
			"Name of the database.", "tracker"),
	//
	KEY_MONGODB_USERNAME("username", null, false,
			"Last time an iRouter product was consumed.", null),
	//
	KEY_MONGODB_PASSWORD("password", null, false,
			"Last time an iRouter product was consumed.", null),
	//
	LAST_CONNECTION_TIME(null, "consumer.Last_Connection", false,
			"Last time an connection to the database was established.", null),

	//
	PREMISES_URI("tracker.premises.uri", "consumer.Premises_URI", false,
			"The Univeral Resource Identifier of the Tracker Premises.", null),
	//
	DEFAULT_ANIMAL(
			"premises.animal.default",
			"consumer.Default_New_Animal",
			false,
			"The default animal to save when a new tag is saved and an animal must be created.",
			null),
	//
	STATUS(null, "consumer.Connection_Status", false,
			"Status of the Utils connection.", null),
	//
	LAST_PRODUCT_TIME(null, "consumer.Last_Product", false,
			"Last time an iRouter product was consumed.", null),
	//
	LAST_RECORD_TIME(null, "consumer.Last_Record", false,
			"Last time animals were recorded.", null),
	//
	TAGS_ADDED(null, "consumer.Tags_Added", false,
			"Total number of new animal tags recorded.", null),
	//
	ANIMALS_ADDED(null, "consumer.Animals_Added", false,
			"Total number of new animals recorded.", null),
	//
	EVENTS_ADDED(null, "consumer.Events_Added", false,
			"Total number of new events recorded.", null),
	//
	ANIMALS_PROCESSED(null, "consumer.Animals_Processed", false,
			"Total number of animals processed in iRouter processing.", null),
	//
	PRODUCTS_CONSUMED(null, "consumer.Products_Consumed", false,
			"Total number of iRouter products consumed by this component.",
			null),
	//
	PRODUCERS_CONNECTED(null, "consumer.Producers_Connected", true,
			"Number of Producers connected to this component.", null),
	//
	CONNECTION_URI(
			"connection.uri",
			"consumer.Connection_URI",
			false,
			"Host and port of the MongoDB service. (This optional attribute has no functionality other than to visualize the connection to a MongoDB Client Provider.)",
			null),
	//
	EXCEPTIONS(
			null,
			"consumer.Exception_Count",
			false,
			"Number of exceptions encounted during processing. See log for details.",
			null),
	//
	PREMISES_REGISTERED(null, "consumer.Premises_Registered", false,
			"Total number of premises registered.", null);
	//
	public final String configID;
	public final String statusVarID;
	public final boolean notifiesOnChange;
	public final String description;
	public final String defaultValue;

	/**
	 * 
	 * @param configKey
	 * @param statusVarID
	 * @param notifiesOnChange
	 * @param description
	 */
	StatusAndConfigVariables(String configKey, String statusVarID,
			boolean notifiesOnChange, String description, String defaultValue) {
		this.configID = configKey;
		this.statusVarID = statusVarID;
		this.notifiesOnChange = notifiesOnChange;
		this.description = description;
		this.defaultValue = defaultValue;
	}

	public static String[] getStatusVariableNames() {
		List<String> varNames = new ArrayList<String>();
		for (StatusAndConfigVariables var : values()) {
			if (var.statusVarID != null) {
				varNames.add(var.statusVarID);
			}
		}
		return varNames.toArray(new String[] {});
	}

	public static StatusAndConfigVariables instance(String statusVarID) {
		for (StatusAndConfigVariables var : values()) {
			if (statusVarID.equals(var.statusVarID)) {
				return var;
			}
		}
		throw new IllegalArgumentException("Invalid Status Variable name "
				+ statusVarID);
	}

	/** The PID for the managed service reference. */
	private static final String PID = "com.verticon.mongo";

	private static final String PREFIX = PID.concat(".");

	private static final String DEFAULT_MONGODB_SERVER = System.getProperty(
			PREFIX.concat(KEY_MONGODB_SERVER.configID),
			KEY_MONGODB_SERVER.defaultValue);

	private static final String DEFAULT_MONGODB_DBNAME = System.getProperty(
			PREFIX.concat(KEY_MONGODB_DBNAME.configID),
			KEY_MONGODB_DBNAME.defaultValue);

	private static final String DEFAULT_MONGODB_USERNAME = System
			.getProperty(PREFIX.concat(KEY_MONGODB_USERNAME.configID));

	private static final String DEFAULT_MONGODB_PASSWORD = System
			.getProperty(PREFIX.concat(KEY_MONGODB_PASSWORD.configID));

	static String getPassword(Map<String, Object> properties) {
		return getProperty(properties, KEY_MONGODB_PASSWORD.configID,
				DEFAULT_MONGODB_PASSWORD);
	}

	static String getUserName(Map<String, Object> properties) {
		return getProperty(properties, KEY_MONGODB_USERNAME.configID,
				DEFAULT_MONGODB_USERNAME);
	}

	static String getServerNames(Map<String, Object> properties) {
		return getProperty(properties, KEY_MONGODB_SERVER.configID,
				DEFAULT_MONGODB_SERVER);
	}

	static String getDBName(Map<String, Object> properties) {
		return getProperty(properties, KEY_MONGODB_DBNAME.configID,
				DEFAULT_MONGODB_DBNAME);
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
	private static String getProperty(Map<String, Object> properties,
			String key,
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
