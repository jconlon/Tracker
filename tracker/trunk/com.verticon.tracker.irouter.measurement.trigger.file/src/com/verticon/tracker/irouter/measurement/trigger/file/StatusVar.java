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
	LAST_FILE_NAME("consumer.Last_File_Created",
			"File name of the last Measurement trigger file."), //
	LAST_MEASUREMENT_VALUE("consumer.Last_Measurement",
			"Measurement value written in the last trigger file."), //
	MEASUREMENT_COUNT("consumer.Measurement_Count",
			"Total number of Measurement trigger files created."), //
	FORMAT_CHANGE_COUNT("consumer.Format_Changes",
			"Total number of output format changes."), //
	WIRES_COUNT("consumer.Connected_Producers",
			"Connected number of the Measurement Producers for this service."), //
	LAST_MEASUREMENT_TIME("consumer.Last_Measurement_Time",
			"Creation time of the last Measurement trigger file."), //
	LAST_FORMAT_CHANGE_TIME("consumer.Last_Format_Change_Time",
			"Last time of a change to the output format."), //
	MEASUREMENT_VALUE_FORMAT("consumer.Format_Value",
			"Format for the outputting values."), //
	WIRING_GROUP(
			"consumer.Wiring_Group",
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