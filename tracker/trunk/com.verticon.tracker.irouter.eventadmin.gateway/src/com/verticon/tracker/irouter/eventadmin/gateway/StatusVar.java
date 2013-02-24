package com.verticon.tracker.irouter.eventadmin.gateway;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

/**
 * Status variables for the Measurement Trigger File component.
 * 
 * @author jconlon
 * 
 */
public enum StatusVar {

	PRODUCT_COUNT("producer.Products_Passed",
			"Total number of products produced."), //
	WIRES_COUNT("producer.Connected_Consumers",
			"Connected number of Consumers of this service."), //
	LAST_PRODUCT_TIME("producer.Last_Product_Time",
			"Creation time of the last Product."), //
	WIRING_GROUP("producer.Wiring_Group",
			"Name of the iRouter Wiring Group.");

	public final String id;
	public final String description;
	public static final String[] identifiers;

	static {
		List<String> namesAsList = newArrayList();
		for (StatusVar v : values()) {
			namesAsList.add(v.id);
		}
		identifiers = namesAsList.toArray(new String[] {});
	}

	private StatusVar(String id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public static StatusVar get(String id) throws IllegalArgumentException {
		StatusVar result = null;
		for (StatusVar v : values()) {
			if(id.equals(v.id)){
				result = v;
				break;
			}
		}
		if (result == null) {
			throw new IllegalArgumentException(id + " is not valid.");
		}
		return result;
	}
	
	

}