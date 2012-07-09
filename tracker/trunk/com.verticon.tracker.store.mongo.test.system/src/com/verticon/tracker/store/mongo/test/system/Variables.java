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
package com.verticon.tracker.store.mongo.test.system;


/**
 * StatusMonitorVar
 * 
 * @author jconlon
 * 
 */
public enum Variables {
	MONGO_URI("connection.uri", "consumer.Connection_URI", false,"The Univeral Resource Identifier of the MongoDB service"), 
	//
	PREMISES_URI("tracker.premises.uri", "consumer.Premises_URI", false,
			"The Univeral Resource Identifier of the Tracker Premises"),
	//
	STATUS(null, "consumer.Connection_Status", false,"Status of the connection."), 
	//
	LAST_UPDATE_TIME(null,
			"consumer.Last_Recording", true,"Time of last update."), 
	//
	UPDATED_ANIMALS(null,
			"consumer.Animals_Updated", false,"Number of existing animals that were updated in the last update."), 
	//
	NEW_ANIMALS_ADDED(null,
			"consumer.New_Animals_Added", false,"Number of new animals added in the last update."), 
	//
	TOTAL_ANIMALS_PROCESSED(null,
			"consumer.Animals_Processed", false,"The total number of animals processed in the last update."),
	//
	PRODUCTS_CONSUMED(null, 
			"consumer.Products_Consumed", false,
					"Total number of iRouter products consumed by this component."),
	//
	PRODUCERS_CONNECTED(null, "consumer.Producers_Connected", true, "Number of Producers connected to this component."),
			//
	DEFAULT_ANIMAL("premises.animal.default", "consumer.Default_New_Animal",
			false, "The kind of animal to save when a new tag is saved."),
	//
	MONGO_ADMIN_LOADED(null, "consumer.Admin_Loaded", 
			true, "Administration configuration has been loaded to Mongo"),
			//
	IS_PUBLISHER(null, "consumer.Is_Publisher", 
			true, "Authorized to publish (save) event histories for this Premises."),
			//
	IS_ADMINISTRATOR(null, "consumer.Is_Administrator", 
			true, "Authorized to load administration configuration documents.");

	public final String configID;
	public final String statusVarID;
	public final boolean notifiesOnChange;
	public final String description;

	Variables(String configKey, String statusVarID, boolean notifiesOnChange, String description) {
		this.configID = configKey;
		this.statusVarID = statusVarID;
		this.notifiesOnChange = notifiesOnChange;
		this.description = description;
	}

}
