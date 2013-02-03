package com.verticon.tracker.irouter.ohaus;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

/**
 * Status variables for the Ohaus Proxy component.
 * 
 * @author jconlon
 * 
 */
public enum StatusVar {
	CONNECTION_STATUS("producer.Proxy_Connection_Status",
			"Status of the connection to the scale."), //
	LAST_STABLE_SCALE_VALUE("producer.last.scale.value",
			"Measurement Values recieved from the scale prior to conversion."), //
	MEASUREMENT_COUNT("producer.measurement.count",
			"Total number of Measurement products sent."), //
	WIRES_COUNT("producer.Connected_Consumers",
			"Number of Measurement Consumers conneted to this service."), //
	LAST_MEASUREMENT_SENT_TIME("producer.Last_Measurement_Sent",
			"Time the last Measurement product sent to consumers.");

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