package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.Map;

class ExternalNodeUtils {

	enum TYPE {
		SENSOR, ACTUATOR, GATEWAY
	}

	static IExternalNode getInstance(Map<String, Object> sr) {
		TYPE type = TYPE.valueOf(((String) sr.get("external.service.type"))
				.toUpperCase());

		switch (type) {
		case SENSOR:
			return new SensorNode(getString("tracker.wiring.group.name", sr),
					getString("service.pid", sr), getLong("service.id", sr),
					getLabel(sr), getConnection(sr), getDescription(sr));

		case ACTUATOR:

			return new ActuatorNode(getString("tracker.wiring.group.name", sr),
					getString("service.pid", sr), getLong("service.id", sr),
					getLabel(sr), getConnection(sr), getDescription(sr));

		case GATEWAY:

			return new GatewayNode(getString("tracker.wiring.group.name", sr),
					getString("service.pid", sr), getLong("service.id", sr),
					getLabel(sr), getConnection(sr), getDescription(sr));

		}

		throw new IllegalArgumentException(type.toString());

	}

	private static String getConnection(Map<String, Object> sr) {
		String uri = sr.get("external.connection.uri") != null ? getString(
				"external.connection.uri", sr) : null;
		return uri;

	}

	private static String getLabel(Map<String, Object> sr) {
		String label = sr.get("tracker.monitor.label") != null ? getString(
				"tracker.monitor.label", sr) : getString("service.pid", sr);
		return label;

	}
	
	private static String getDescription(Map<String, Object> sr) {
		String description = sr.get("external.description") != null ? getString(
				"external.description", sr) : "";
		return description;

	}

	private static String getString(String key, Map<String, Object> sr) {
		Object value = sr.get(key);
		if (value == null) {
			throw new IllegalArgumentException(key + " cannot be null.");
		}
		if (value instanceof String) {
			return (String) value;
		}
		throw new IllegalArgumentException("The value for " + key + ", "
				+ value + " is not a String.");

	}

	private static Long getLong(String key, Map<String, Object> sr) {
		Object value = sr.get(key);
		if (value == null) {
			throw new IllegalArgumentException(key + " cannot be null.");
		}
		if (value instanceof Long) {
			return (Long) value;
		}
		throw new IllegalArgumentException("The value for " + key + ", "
				+ value + " is not a Long.");

	}

}
