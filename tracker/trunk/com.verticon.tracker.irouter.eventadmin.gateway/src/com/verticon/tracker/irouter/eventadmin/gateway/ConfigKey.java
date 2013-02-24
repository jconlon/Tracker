package com.verticon.tracker.irouter.eventadmin.gateway;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

/**
 * Configuration attributes for the Measurement Trigger File component.
 * 
 * @author jconlon
 * 
 */
public enum ConfigKey {

	WIRING_GROUP("tracker.wiring.group.name"), //
	PRODUCER_SCOPES("wireadmin.producer.scope"), //
	SERVICE_PID("service.pid"), // an implicit constant
	FACTORY_PID("com.verticon.tracker.irouter.eventadmin.gateway"), //
	EVENT_ADMIN_PROPERTY_PRODUCT_STRING("com.verticon.product.string");

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


	private static String[] getScope(Map<String, Object> config) {
		Object[] scopes = config.get(PRODUCER_SCOPES.getKey()) != null ? (Object[]) config
				.get(PRODUCER_SCOPES.getKey())
				: new Object[] { "ohaus.weight" };
		List<String> result = newArrayList();
		for (Object o : scopes) {
			result.add(o.toString());
		}
		return result.toArray(new String[] {});

	}

	public static String getFirstScope(Map<String, Object> config) {
		String[] scopes = getScope(config);
		return scopes[0];
	}



	public static String getServicePid(Map<String, Object> config) {
		String str = (String) config.get(SERVICE_PID.getKey());
		checkState(!isNullOrEmpty(str),
				"Configuration key value %s cannot be null or empty.",
				SERVICE_PID.getKey());
		return str;
	}

	public static String getWiringGroup(Map<String, Object> config) {
		return config.get(WIRING_GROUP.getKey()) != null ? (String) config
				.get(WIRING_GROUP.getKey()) : "one";
	}



	

	public void configure(Dictionary<String, Object> config, Object value) {
		checkNotNull(config);
		config.put(key, value);
	}
	
	public void configure(Map<String, Object> config, Object value) {
		checkNotNull(config);
		config.put(key, value);
	}

}
