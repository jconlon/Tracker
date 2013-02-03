package com.verticon.tracker.irouter.ohaus;

import java.util.Dictionary;
import java.util.Map;

/**
 * Configuration attributes for the Ohaus proxy component.
 * 
 * @author jconlon
 * 
 */
public enum ConfigKey {

	CONNECTION_URI("connection.uri"), //
	CONNECTION_RETRY_SECONDS("connection.retry.seconds"), //
	PRODUCER_SCOPE("wireadmin.producer.scope"), //
	COMMAND_DELAY_MILLIS("command.delay.millis"), //
	MINIMUM_WEIGHT_THRESHOLD("minimum.weight.threshold"), //
	SERVICE_PID("service.pid"), //
	FACTORY_PID("com.verticon.tracker.irouter.ohaus"), //
	SCALE_ERROR("scale.error"), //
	WIRING_GROUP("tracker.wiring.group.name");

	private String key;

	private ConfigKey(String key) {
		this.key = key;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	public static String getURI(Map<String, Object> config) {
		return (String) config.get(CONNECTION_URI.getKey());
	}

	public static String getScope(Map<String, Object> config) {
		if (config.get(PRODUCER_SCOPE.getKey()) != null) {
			String[] scopes = (String[]) config.get(PRODUCER_SCOPE.getKey());
			return scopes[0];
		}
		return "ohaus.weight";
	}

	// public static Long getRetrySeconds(Map<String, Object> config) {
	// return (Long) config.get(CONNECTION_RETRY_SECONDS.getKey());
	// }

	public static Long getCommandDelayMilliSeconds(Map<String, Object> config) {
		return config.get(COMMAND_DELAY_MILLIS.getKey()) != null ? (Long) config
				.get(COMMAND_DELAY_MILLIS.getKey()) : 0l;
	}

	public static Double getMinimumWeight(Map<String, Object> config) {
		return config.get(MINIMUM_WEIGHT_THRESHOLD.getKey()) != null ? (Double) config
				.get(MINIMUM_WEIGHT_THRESHOLD.getKey()) : .03;
	}

	public static String getServicePid(Map<String, Object> config) {
		return (String) config.get(SERVICE_PID.getKey());
	}

	public static String getWiringGroup(Map<String, Object> config) {
		return config.get(WIRING_GROUP.getKey()) != null ? (String) config
				.get(WIRING_GROUP.getKey()) : "none";
	}

	public static Double getScaleError(Map<String, Object> config) {
		return config.get(SCALE_ERROR.getKey()) != null ? (Double) config
				.get(SCALE_ERROR.getKey()) : .0001;
	}

	public static Long getRetryDelay(Map<String, Object> config) {
		return config.get(CONNECTION_RETRY_SECONDS.getKey()) != null ? (Long) config
				.get(CONNECTION_RETRY_SECONDS.getKey()) : 10l;
	}

	public void configure(Dictionary<String, Object> config, Object value) {
		config.put(key, value);
	}
}
