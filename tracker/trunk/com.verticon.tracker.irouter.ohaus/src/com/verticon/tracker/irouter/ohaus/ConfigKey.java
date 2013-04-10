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
	RESPONSE_DELAY_MILLIS("response.delay.millis"), //
	RESPONSE_RETRIES_BEFORE_ABORT("response.retries"), //
	MINIMUM_WEIGHT_THRESHOLD("minimum.weight.threshold"), //
	SERVICE_PID("service.pid"), //
	FACTORY_PID("com.verticon.tracker.irouter.ohaus"), //
	SCALE_ERROR("scale.error"), //
	WIRING_GROUP("tracker.wiring.group.name"), //
	MILLIS_DELAY_BETWEEN_POLLS("poll.delay.millis");

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


	public static Long getResponseDelayMilliSeconds(Map<String, Object> config) {
		return config.get(RESPONSE_DELAY_MILLIS.getKey()) != null ? getConfigurationLong(config
				.get(RESPONSE_DELAY_MILLIS.getKey())) : 50l;
	}


	public static Integer getResponseRetriesBeforeAbort(
			Map<String, Object> config) {
		return config.get(RESPONSE_RETRIES_BEFORE_ABORT.getKey()) != null ? getConfigurationInteger(config
				.get(RESPONSE_RETRIES_BEFORE_ABORT.getKey())) : 10;
	}

	public static Double getMinimumWeight(Map<String, Object> config) {
		return config.get(MINIMUM_WEIGHT_THRESHOLD.getKey()) != null ? getConfigurationDouble(config
				.get(MINIMUM_WEIGHT_THRESHOLD.getKey())) : .03;
	}

	public static String getServicePid(Map<String, Object> config) {
		return (String) config.get(SERVICE_PID.getKey());
	}

	public static String getWiringGroup(Map<String, Object> config) {
		return config.get(WIRING_GROUP.getKey()) != null ? (String) config
				.get(WIRING_GROUP.getKey()) : "one";
	}

	public static Double getScaleError(Map<String, Object> config) {
		return config.get(SCALE_ERROR.getKey()) != null ? getConfigurationDouble(config
				.get(SCALE_ERROR.getKey())) : .0001;
	}

	public static Long getConnectionRetrySeconds(Map<String, Object> config) {
		return config.get(CONNECTION_RETRY_SECONDS.getKey()) != null ? getConfigurationLong(config
				.get(CONNECTION_RETRY_SECONDS.getKey())) : 10l;
	}

	public static Long getPollMillisDelay(Map<String, Object> config) {
		return config.get(MILLIS_DELAY_BETWEEN_POLLS.getKey()) != null ? getConfigurationLong(config
				.get(MILLIS_DELAY_BETWEEN_POLLS.getKey())) : 250l;
	}

	public static boolean isPollingEnabled(Map<String, Object> config) {
		return config.get(MILLIS_DELAY_BETWEEN_POLLS.getKey()) != null ? getConfigurationLong(config
				.get(MILLIS_DELAY_BETWEEN_POLLS.getKey())) > 0 : false;
	}

	public void configure(Dictionary<String, Object> config, Object value) {
		config.put(key, value);
	}

	private static Integer getConfigurationInteger(Object o) {
		Integer result = null;
		if (o instanceof Integer) {
			result = (Integer) o;
		} else if (o instanceof String) {
			result = Integer.parseInt((String) o);
		}
		return result;
	}

	private static Long getConfigurationLong(Object o) {
		Long result = null;
		if (o instanceof Long) {
			result = (Long) o;
		} else if (o instanceof String) {
			result = Long.parseLong((String) o);
		}
		return result;
	}

	private static Double getConfigurationDouble(Object o) {
		Double result = null;
		if (o instanceof Double) {
			result = (Double) o;
		} else if (o instanceof String) {
			result = Double.parseDouble((String) o);
		}
		return result;
	}
}
