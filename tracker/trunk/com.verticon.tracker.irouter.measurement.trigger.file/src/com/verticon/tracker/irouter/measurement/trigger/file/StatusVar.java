package com.verticon.tracker.irouter.measurement.trigger.file;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

/**
 * Status variables for the Measurement Trigger File component.
 * 
 * @author jconlon
 * 
 */
public enum StatusVar {
	LAST_FILE_NAME("consumer.last.file.name",
			"File name of the last Measurement trigger file."), //
	LAST_MEASUREMENT_VALUE("consumer.last.measurement.value",
			"Measurement value written in the last trigger file."), //
	MEASUREMENT_COUNT("consumer.measurement.count",
			"Total number of Measurement trigger files created."), //
	WIRES_COUNT("consumer.Connected_Producers",
			"Connected number of the Measurement Producers for this service."), //
	LAST_MEASUREMENT_TIME("consumer.Last_Measurement_Time",
			"Creation time of the last Measurement trigger file.");

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