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
package com.verticon.tracker.irouter.mqtt.internal;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * StatusAndConfigVar
 * 
 * @author jconlon
 * 
 */
public enum StatusAndConfigVariables {

	KEY_SERVER("connection.uri", "consumer.Connection_URI",
			false,
			"The MQTT Server.", "tcp://m2m.eclipse.org:1883"),
	//

	KEY_USERNAME("username", null, false,
			"Last time an iRouter product was consumed.", null),
	//
	KEY_PASSWORD("password", null, false,
			"Last time an iRouter product was consumed.", null),
	//
	MQTT_SUBSCRIBER_TOPICS(
			"mqtt.subscriber.topics",
			"producer.Subscriber_Topics",
			false,
			"MQTT Subscriber topic names",
			"Agriculture/Premises/+/Query,Agriculture/Premises/+/Events/EMF,Agriculture/Premises/+/Register/EMF"),
	//
	PRODUCER_SCOPES(
			"wireadmin.producer.scope",
			null,
			false,
			"Producer Scope names",
			"agriculture.premises.query,agriculture.premises.events.emf,agriculture.premises.register.emf"),
	//

	CLIENT_ID("mqtt.clientid", "consumer.MQTT_ClientID", false,
			"The MQTT Client Identifier.", null),
	//

	STATUS(null, "consumer.Connection_Status", false,
			"Status of the Utils connection.", null),
	//
	LAST_CONSUMED_TIME(null, "consumer.Last_Consumed", false,
			"Last time an iRouter product was consumed.", null),
	//
	LAST_PRODUCED_TIME(null, "producer.Last_Produced", false,
			"Last time an iRouter product was produced.", null),
	//
	PRODUCTS_PRODUCED(null, "producer.Products_Produced", false,
			"Total number of iRouter products produced by this component.",
			null),
	//
	PRODUCTS_CONSUMED(null, "consumer.Products_Consumed", false,
			"Total number of iRouter products consumed by this component.",
			null),
	//

	CONSUMERS_CONNECTED(null, "producer.Consumers_Connected", true,
			"Number of Consumers connected to this component.", null),
	//

	PRODUCERS_CONNECTED(null, "consumer.Producers_Connected", true,
			"Number of Producers connected to this component.", null),
	//

	EXCEPTIONS(
			null,
			"consumer.Exception_Count",
			false,
			"Number of exceptions encounted during processing. See log for details.",
			null);
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

	// static String getConnectionURI(Map<String, Object> properties) {
	// return getProperty(properties, CONNECTION_URI.configID, null);
	// }

	static String getClientID(Map<String, Object> properties) {
		return getProperty(properties, CLIENT_ID.configID, null);
	}

	static Iterable<String> getSubscriberTopics(Map<String, Object> properties) {
		String[] topics = getPropertyArray(properties,
				MQTT_SUBSCRIBER_TOPICS.configID, null);
		if (topics == null || topics.length == 0) {
			throw new NullPointerException("No Producer Scopes configured.");
		}
		return Arrays.asList(topics);
	}

	static Iterable<String> getProducerScopes(Map<String, Object> properties) {
		String[] scopes = getPropertyArray(properties,
				PRODUCER_SCOPES.configID, null);
		if (scopes == null | scopes.length == 0) {
			throw new NullPointerException("No Producer Scopes configured.");
		}
		return Arrays.asList(scopes);
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

	private static String[] getPropertyArray(Map<String, Object> properties,
			String key, String defaultValue) {
		String[] result = null;
		if (!isNullOrEmpty(defaultValue)) {
			result = Iterables.toArray(Splitter.on(',')
				.split(defaultValue), String.class);
		}

		if (properties != null) {
			Object value = properties.get(key);
			if (value != null && (value instanceof String[])) {
				result = (String[]) value;
			}
		}
		return result;
	}

}
