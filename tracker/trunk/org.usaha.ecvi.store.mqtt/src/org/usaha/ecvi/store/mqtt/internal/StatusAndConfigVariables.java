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
package org.usaha.ecvi.store.mqtt.internal;

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
	KEY_SERVER("connection.uri", "consumer.Connection_URI", false,
			"The MQTT Server.", "tcp://m2m.eclipse.org:1883"),
	//
	KEY_USERNAME("username", null, false,
			"Last time an iRouter product was consumed.", null),
	//
	KEY_PASSWORD("password", null, false,
			"Last time an iRouter product was consumed.", null),
	//
	LAST_CONNECTION_TIME(null, "consumer.Last_Connection", false,
			"Last time an connection to the database was established.", null),
	//
	PREMISES_URI("tracker.premises.uri", "consumer.Premises_URI", false,
			"The Univeral Resource Identifier of the Tracker Premises.", null),

	STATUS(null, "consumer.Connection_Status", false,
			"Status of the Utils connection.", null),
	//
	LAST_PRODUCT_TIME(null, "consumer.Last_Product", false,
			"Last time an iRouter product was consumed.", null),
	//
	LAST_RECORD_TIME(null, "consumer.Last_Record", false,
			"Last time animals were recorded.", null),
	//

	PRODUCTS_CONSUMED(null, "consumer.Products_Consumed", false,
			"Total number of iRouter products consumed by this component.",
			null),
	//
	PRODUCERS_CONNECTED(null, "consumer.Producers_Connected", true,
			"Number of Producers connected to this component.", null),
	//
	WAIT_SECONDS_FOR_RESPONSE(
			"wait.seconds",
			null,
			false,
			"Number of seconds to wait for a response to a query before timing out.",
			"1"),
	//
	EXCEPTIONS(
			null,
			"consumer.Exception_Count",
			false,
			"Number of exceptions encounted during processing. See log for details.",
			null),
	//
	ECVIS_RECORDED(null, "consumer.Premises_Registered", false,
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
	private static final String PID = "com.verticon.mqtt";

	private static final String PREFIX = PID.concat(".");

	private static final String DEFAULT_SERVER = System.getProperty(
			PREFIX.concat(KEY_SERVER.configID), KEY_SERVER.defaultValue);

	private static final String DEFAULT_USERNAME = System.getProperty(PREFIX
			.concat(KEY_USERNAME.configID));

	private static final String DEFAULT_PASSWORD = System.getProperty(PREFIX
			.concat(KEY_PASSWORD.configID));

	static String getPassword(Map<String, Object> properties) {
		return getProperty(properties, KEY_PASSWORD.configID, DEFAULT_PASSWORD);
	}

	static String getUserName(Map<String, Object> properties) {
		return getProperty(properties, KEY_USERNAME.configID, DEFAULT_USERNAME);
	}

	static String getServerName(Map<String, Object> properties) {
		return getProperty(properties, KEY_SERVER.configID, DEFAULT_SERVER);
	}

	static Integer getWaitSecondsForRespsonse(Map<String, Object> properties) {
		return getIntegerProperty(properties,
				WAIT_SECONDS_FOR_RESPONSE.configID,
				WAIT_SECONDS_FOR_RESPONSE.defaultValue);
	}

	static String getPremisesURI(Map<String, Object> properties) {
		return getProperty(properties, PREMISES_URI.configID, null);
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
			String key, String defaultValue) {
		String result = defaultValue;
		if (properties != null) {
			Object value = properties.get(key);
			if (value != null && (value instanceof String)) {
				result = (String) value;
			}
		}
		return result;
	}

	private static Integer getIntegerProperty(Map<String, Object> properties,
			String key, String defaultValue) {
		Integer result = Integer.parseInt(defaultValue);
		if (properties != null) {
			Object value = properties.get(key);
			if (value != null && (value instanceof String)) {
				result = Integer.parseInt((String) value);
			} else if (value != null && (value instanceof Integer)) {
				result = (Integer) value;
			}
		}
		return result;
	}
}
