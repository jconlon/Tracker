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
package com.verticon.tracker.store.mongo.internal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.StatusVariable;

/**
 * StatusAndConfigVar
 * 
 * @author jconlon
 * 
 */
public enum StatusAndConfigVariables {
	MONGO_URI("connection.uri", "consumer.Connection_URI", false,
			"The Univeral Resource Identifier (URI) specifying the connection to the MongoDB."),
	//
	PREMISES_URI("tracker.premises.uri", "consumer.Premises_URI", false,
			"The Univeral Resource Identifier of the Tracker Premises."),
	//
	STATUS(null, "consumer.Connection_Status", false,
			"Status of the MongoDB connection."),
	//
	LAST_UPDATE_TIME(null, "consumer.Last_Recording", false,
			"Last time Premises Animal histories were recorded."),
	//
	UPDATED_ANIMALS(null, "consumer.Animals_Updated", false,
			"Total number of existing animals updated in Premises Animal history recordings and iRouter processing."),
	//
	NEW_ANIMALS_ADDED(null, "consumer.New_Animals_Added", false,
			"Total number of new animals added in Premises Animal history recordings and iRouter processing."),
	//
	TOTAL_ANIMALS_PROCESSED(null, "consumer.Animals_Processed", false,
			"Total number of animals processed in Premises Animal history recordings and iRouter processing."),
	//
	PRODUCTS_CONSUMED(null, "consumer.Products_Consumed", false,
					"Total number of iRouter products consumed by this component."),
	//
	PRODUCERS_CONNECTED(null, "consumer.Producers_Connected", true, "Number of Producers connected to this component."),
	//
	DEFAULT_ANIMAL("premises.animal.default", "consumer.Default_New_Animal",
			false,
			"The default animal to save when a new tag is saved and an animal must be created."),
	//
	PROVIDED_COLLECTION("collection", null, false, "Provided collection");

	final String configID;
	final String statusVarID;
	final boolean notifiesOnChange;
	final String description;

	/**
	 * 
	 * @param configKey
	 * @param statusVarID
	 * @param notifiesOnChange
	 * @param description
	 */
	StatusAndConfigVariables(String configKey, String statusVarID,
			boolean notifiesOnChange, String description) {
		this.configID = configKey;
		this.statusVarID = statusVarID;
		this.notifiesOnChange = notifiesOnChange;
		this.description = description;
	}

	static String[] getStatusVariableNames() {
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

	static StatusVariable getStatusVariable(String id,
			Map<String, Object> config, String status, AtomicLong lastUpdate,
			AtomicInteger totalUpdatedAnimals, AtomicInteger totalAnimalsAdded, 
			AtomicInteger totalAnimalsProcessed, AtomicInteger producersConnected, AtomicInteger totalProductsConsumed)
			throws IllegalArgumentException {

		StatusAndConfigVariables var = instance(id);
		switch (var) {
		case MONGO_URI:
		case PREMISES_URI:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));
			
	    case DEFAULT_ANIMAL:
	    	Integer key = Utils.getConfigurationInteger(config.get(var.configID));
	    	String name = Utils.createDefaultAnimal(key).eClass().getName();
	    	return new StatusVariable(id, StatusVariable.TYPE_STRING, name);
		case STATUS:
			return new StatusVariable(id, StatusVariable.TYPE_STRING, status);
		case LAST_UPDATE_TIME:
			Date date = new Date(lastUpdate.get());
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					date.toString());
		case UPDATED_ANIMALS:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalUpdatedAnimals.get());
		case NEW_ANIMALS_ADDED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalAnimalsAdded.get());
		case PRODUCERS_CONNECTED:
			return new StatusVariable(id, StatusVariable.CM_GAUGE,
					producersConnected.get());
		case TOTAL_ANIMALS_PROCESSED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalAnimalsProcessed.get());
		case PRODUCTS_CONSUMED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalProductsConsumed.get());
		default:
			break;
		}
		
		throw new IllegalArgumentException("Invalid Status Variable name " + id);
	}

}
