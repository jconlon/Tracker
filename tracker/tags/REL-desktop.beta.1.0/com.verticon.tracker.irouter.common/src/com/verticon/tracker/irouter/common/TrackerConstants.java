package com.verticon.tracker.irouter.common;

public class TrackerConstants {
	
	private TrackerConstants() {}//Prevents instantiation
	/**
	 * A logical grouping of a set of Producers and Consumers
	 */
	public static final String TRACKER_WIRE_GROUP_NAME = "tracker.wiring.group.name";
	public static final String TRACKER_WIRE_GROUP_NAME_DEFAULT = "";
	
	public static final String STABLE_WEIGHT_ERROR = "stable.weight.error";
	public static final String UNSTABLE_WEIGHT_ERROR = "unstable.weight.error";
	public static final String CONNECTION_URI = "connection.uri";
	public static final String POLL_DELAY = "poll.milliseconds.delay";
	public static final String REQUEST_COMMAND = "request.command";
	public static final String RESPONSE_PATTERN = "response.pattern";
	public static final String RETRY_CONNECTION_DELAY = "connection.retry.seconds";
	public static final String CONNECTION_URI_DEFAULT = "";
	
	//State scopes
	public static final String STATE_SCOPE = "state";
	public static final String TRANSACTION_STATE_SCOPE = "transaction."+STATE_SCOPE;
	public static final String ALARM_STATE_SCOPE = "alarm."+STATE_SCOPE;
	
	//Misc scopes
	public static final String ANIMAL_TAG_NUMBER_SCOPE = "animal.tag.number";
	public static final String COMMAND_STRING_SCOPE = "command.string";
	
	
}
