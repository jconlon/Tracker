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
package org.usaha.ecvi.store.mongodb.internal.irouter;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * Status and Configuration Variables for the EcviMongoIRouterComponent
 * 
 * 
 * @author jconlon
 * 
 */
public enum StatusAndConfigVariables {

	MONGO_PROVIDER_URI("mongo.provider.uri", "consumer.Provider_URI", false,
			"The Univeral Resource Identifier of the Mongo Provider.", null),

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
	LAST_RECORD_TIME(null, "consumer.Last_Record", false,
			"Last time animals were recorded.", null),
	//

	PRODUCTS_CONSUMED(null, "consumer.Products_Consumed", false,
			"Total number of iRouter products consumed by this component.",
			null),
	//
	PRODUCTS_PRODUCED(null, "producer.Products_Produced", false,
			"Total number of iRouter products produced by this component.",
			null),
	//
	PRODUCERS_CONNECTED(null, "consumer.Producers_Connected", true,
			"Number of Producers connected to this component.", null),
	//
	CONSUMERS_CONNECTED(null, "producer.Consumers_Connected", true,
			"Number of Consumers connected to this component.", null),
	//
	EXCEPTIONS(
			null,
			"consumer.Exception_Count",
			false,
			"Number of exceptions encounted during processing. See log for details.",
			null),
	//
	ECVIS_RECORDED(null, "consumer.Ecvis_Recorded", false,
			"Total number of ecvis recorded.", null),

	PRODUCER_SCOPES("wireadmin.producer.scope", null, false,
			"Producer Scope names", "agriculture.premises.response");
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

	static StatusAndConfigVariables instance(String statusVarID) {
		for (StatusAndConfigVariables var : values()) {
			if (statusVarID.equals(var.statusVarID)) {
				return var;
			}
		}
		throw new IllegalArgumentException("Invalid Status Variable name "
				+ statusVarID);
	}

	static String getProducerScope(
			Map<String, Object> properties) {
		String[] scopes = getPropertyArray(properties,
				PRODUCER_SCOPES.configID, PRODUCER_SCOPES.defaultValue);
		if (scopes == null | scopes.length == 0) {
			throw new NullPointerException("No Producer Scopes configured.");
		}
		return scopes[0];
	}

	private static String[] getPropertyArray(Map<String, Object> properties,
			String key, String defaultValue) {
		String[] result = null;
		if (!isNullOrEmpty(defaultValue)) {
			result = Iterables.toArray(Splitter.on(',').split(defaultValue),
					String.class);
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
