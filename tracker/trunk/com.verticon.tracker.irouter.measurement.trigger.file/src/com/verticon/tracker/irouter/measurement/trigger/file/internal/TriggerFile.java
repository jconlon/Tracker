package com.verticon.tracker.irouter.measurement.trigger.file.internal;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey;

public class TriggerFile implements Monitorable, Consumer {

	private static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.trigger.file";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		TriggerFile.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(TriggerFile.class);

	private final StatusMonitor statusMonitor = new StatusMonitor();

	private Map<String, Object> config;

	private volatile String format = null;

	@Override
	public void updated(Wire wire, Object in) {
		logger.debug(bundleMarker, "Invoked updated with value={}", in);
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			handle(envelope);
		} else {
			logger.error(bundleMarker,
					"Unknown object={} was received from wire scope={}", in,
					Arrays.toString(wire.getScope()));
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "Invoked producerConnected with wires={}",
				Arrays.toString(wires));
		statusMonitor.setWiresConnected(wires != null ? wires.length : 0);
	}

	@Override
	public String[] getStatusVariableNames() {
		return statusMonitor.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return statusMonitor.getStatusVariable(id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return statusMonitor.notifiesOnChange(id);
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return statusMonitor.resetStatusVariable(id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return statusMonitor.getDescription(id);
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		statusMonitor.setMonitorListener(monitorListener);
	}


	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void activate(Map<String, Object> config) throws IOException {
		logger.debug(bundleMarker, "Activating");
		this.config = config;
		statusMonitor.setWiringGroup(ConfigKey.getWiringGroup(config));
		statusMonitor.setMeasurementValueFormat(ConfigKey
				.getMeasurementValueFormat(config));
	}

	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void deactivate() {
		logger.debug(bundleMarker, "Deactivating");
		config = null;
		statusMonitor.deactivate();
	}

	private void handle(Envelope envelope) {
		if ((envelope.getValue() instanceof Measurement)) {
			handle((Measurement) envelope.getValue());
		} else if ((envelope.getValue() instanceof String)) {
			handle((String) envelope.getValue());
		} else {
			logger.warn(
					bundleMarker,
					"Unsuppored envelope id={}, scope={}, value={}",
					new Object[] { envelope.getIdentification(),
							envelope.getScope(), envelope.getValue() });
		}
	}

	private void handle(Measurement measurement) {
		File destination = ConfigKey.getFile(config);
		String values = ConfigKey.getFormatedMeasurement(config, format,
				measurement);
		logger.info(bundleMarker, "Writing values = {} to file = {}", values,
				destination);
		try {
			Files.write(values, destination, Charsets.US_ASCII);
			statusMonitor.setLastFileName(destination.toString());
			statusMonitor.setLastMeasurementValue(values);
			statusMonitor.incMeasurementCount();
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to write " + measurement, e);
		}
	}

	private void handle(String string) {
		format = string;

		statusMonitor.setMeasurementValueFormat(string);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((config == null) ? 0 : config.hashCode());
		result = prime * result + ((logger == null) ? 0 : logger.hashCode());
		result = prime * result
				+ ((statusMonitor == null) ? 0 : statusMonitor.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TriggerFile)) {
			return false;
		}
		TriggerFile other = (TriggerFile) obj;
		if (config == null) {
			if (other.config != null) {
				return false;
			}
		} else if (!config.equals(other.config)) {
			return false;
		}
		if (logger == null) {
			if (other.logger != null) {
				return false;
			}
		} else if (!logger.equals(other.logger)) {
			return false;
		}
		if (statusMonitor == null) {
			if (other.statusMonitor != null) {
				return false;
			}
		} else if (!statusMonitor.equals(other.statusMonitor)) {
			return false;
		}
		return true;
	}



}
