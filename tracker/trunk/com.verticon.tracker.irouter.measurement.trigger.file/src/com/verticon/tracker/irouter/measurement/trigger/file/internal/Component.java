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

public class Component implements Monitorable, Consumer {

	private static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.trigger.file";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		Component.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);

	private final StatusMonitor statusMonitor = new StatusMonitor();

	private Map<String, Object> config;

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

	}

	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void deactivate() {
		logger.debug(bundleMarker, "Deactivating");

		config = null;
	}

	private void handle(Envelope envelope) {
		if ((envelope.getValue() instanceof Measurement)) {
			handle((Measurement) envelope.getValue());
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
		String values = ConfigKey.getFormatedMeasurement(config, measurement);
		logger.info(bundleMarker, "Writting values = {} to file = {}", values);
		try {
			Files.write(values, destination, Charsets.US_ASCII);
			statusMonitor.setLastFileName(destination.toString());
			statusMonitor.setLastMeasurementValue(values);
			statusMonitor.incMeasurementCount();
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to write " + measurement, e);
		}
	}

}
