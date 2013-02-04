package com.verticon.tracker.irouter.measurement.trigger.file;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;

import java.io.File;
import java.net.URI;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import org.osgi.util.measurement.Measurement;

import com.google.common.base.CharMatcher;

/**
 * Configuration attributes for the Measurement Trigger File component.
 * 
 * @author jconlon
 * 
 */
public enum ConfigKey {

	WIRING_GROUP("tracker.wiring.group.name"), //
	CONSUMABLE_SCOPES("wireadmin.consumer.scope"), //
	FILE_NAME_PATTERN("file.name.pattern"), //
	CONNECTION_URI("connection.uri"), //
	WEIGHT_MEASUREMENT_UNITS("weight.measurement.units"), //
	MEASUREMENT_VALUE_FORMAT("measurement.value.format"), //
	SERVICE_PID("service.pid"), // an implicit constant
	FACTORY_PID("com.verticon.tracker.irouter.measurement.trigger.file");

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

	public static URI getURI(Map<String, Object> config) {
		String str = (String) config.get(CONNECTION_URI.getKey());
		checkState(!isNullOrEmpty(str),
				"Configuration key value %s cannot be null or empty.",
				CONNECTION_URI.getKey());
		URI uri = URI.create(str);
		checkState(uri.getScheme().equals("file"),
				"Configuration key value %s must be a file url.",
				CONNECTION_URI.getKey());
		return uri;
	}

	public static String[] getScope(Map<String, Object> config) {
		Object[] scopes = config.get(CONSUMABLE_SCOPES.getKey()) != null ? (Object[]) config
				.get(CONSUMABLE_SCOPES.getKey())
				: new Object[] { "ohaus.weight" };
		List<String> result = newArrayList();
		for (Object o : scopes) {
			result.add(o.toString());
		}
		return result.toArray(new String[] {});

	}

	public static String getFileNamePattern(Map<String, Object> config) {
		return config.get(FILE_NAME_PATTERN.getKey()) != null ? (String) config
				.get(FILE_NAME_PATTERN.getKey()) : "measurement-***.txt";
	}

	/**
	 * Outputs a File including the path, parent directories and a timestamp if
	 * specified.
	 * 
	 * @param config
	 * @return the file f
	 */
	public static File getDestinationDirectory(Map<String, Object> config) {
		File result = new File(getURI(config));
		checkState(
				result.isDirectory(),
				"Destination directory %s does not exist. Please create it first.",
				result);
		return result;
	}
	
	public static File getFile(Map<String, Object> config) {
		File parent = getDestinationDirectory(config);
		String child = getFileNamePattern(config);
		if(child.contains("*")){
			child = CharMatcher.anyOf("*").collapseFrom(child, '*');
			child = CharMatcher.is('*').replaceFrom(child,
					new Date().getTime() + "");
		}
		
		return new File(parent, child);
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

	public static WeightUnit getWeightUnit(Map<String, Object> config) {
		WeightUnit result = WeightUnit.POUNDS;
		if (config.get(WEIGHT_MEASUREMENT_UNITS.getKey()) != null) {
			String str = (String) config.get(WEIGHT_MEASUREMENT_UNITS.getKey());
			result = WeightUnit.valueOf(str);
		}
		return result;
	}

	public static String getMeasurementValueFormat(Map<String, Object> config) {
		return config.get(MEASUREMENT_VALUE_FORMAT.getKey()) != null ? (String) config
				.get(MEASUREMENT_VALUE_FORMAT.getKey()) : "%tc,%s,%s,%5.4f";
	}

	/**
	 * Gets the formated value of the measurement.
	 * 
	 * @param config
	 * @param measurement
	 * @return formated string from values: dateTime, unit, value, error
	 */
	public static String getFormatedMeasurement(Map<String, Object> config,
			Measurement measurement) {
		WeightUnit wu = getWeightUnit(config);
		String formatString = getMeasurementValueFormat(config);
		return wu.getFormatedValue(measurement, formatString);
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
