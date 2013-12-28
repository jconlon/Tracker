/**
 * 
 */
package org.usaha.ecvi.store.mqtt.internal;

import static org.usaha.ecvi.store.mqtt.internal.MqttEcviStoreComponent.bundleMarker;
import static org.usaha.ecvi.store.mqtt.internal.StatusAndConfigVariables.getPremisesURI;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usaha.ecvi.Ecvi;

/**
 * An iRouter Consumer that consumes Ecvi EMF objects and records these to the
 * MqttEcviStoreComponent.
 * 
 * 
 * @author jconlon
 * 
 */
public class MQTTConsumer implements Monitorable, Consumer {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MQTTConsumer.class);

	private final MqttEcviStoreComponent mqttEcviStoreComponent;
	private final Monitor monitor;
	private Map<String, Object> config = null;

	/**
	 * 
	 */
	public MQTTConsumer(MqttEcviStoreComponent mQTTTrackerStore, Monitor monitor) {
		this.mqttEcviStoreComponent = mQTTTrackerStore;
		this.monitor = monitor;
	}

	/**
	 * Consumes Ecvi objects and sends records these on the MqttEcviStoreComponent
	 * 
	 * @see org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin
	 *      .Wire, java.lang.Object)
	 */
	@Override
	public void updated(Wire wire, Object in) {
		if (in instanceof Envelope) {
			monitor.incrementTotalProductsConsumed();
			Envelope envelope = (Envelope) in;
			logger.debug(
					bundleMarker,
					"Received envelope on wire scope={}, with envelope id={}, value type ={}",
					new Object[] { Arrays.toString(wire.getScope()),
							envelope.getIdentification(),
							envelope.getValue().getClass().getName() });
			if (envelope.getValue() != null) {
				if (envelope.getValue() instanceof Ecvi) {
					handle((Ecvi) envelope.getValue());
				} else {
					logger.error(
							bundleMarker,
							"Unknown object={} was received from wire scope={}",
							in, Arrays.toString(wire.getScope()));
				}
			}
		} else {
			logger.error(bundleMarker,
					"Unknown object={} was received from wire scope={}", in,
					Arrays.toString(wire.getScope()));
		}
	}


	private void handle(Ecvi ecvi) {
		try {
			record(ecvi);
		} catch (IOException e) {
			String message = "Failed to handle " + ecvi.eClass().getName()
					+ " id=" + ecvi.getCviNumber();
			monitor.add(message, e);
			logger.error(bundleMarker, message, e);
		}
	}

	private void record(Ecvi ecvi) throws IOException {
		logger.debug(bundleMarker, "Recording Ecvi id={}", ecvi.getCviNumber());
		mqttEcviStoreComponent.record(ecvi, getPremisesURI(config));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#producersConnected(org.osgi.service
	 * .wireadmin.Wire[])
	 */
	@Override
	public void producersConnected(Wire[] wires) {
		monitor.setProducersConnected(wires != null ? wires.length : 0);
		monitor.update(monitor
				.getStatusVariable(StatusAndConfigVariables.PRODUCERS_CONNECTED.statusVarID));
		logger.debug(bundleMarker, "ProducerConnected with wires={}",
				Arrays.toString(wires));
	}

	void activate(Map<String, Object> config) throws IOException {
		this.config = config;
	}

	void deactivate() {

	}

	@Override
	public String[] getStatusVariableNames() {
		return monitor.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.getStatusVariable(id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return monitor.notifiesOnChange(id);
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.resetStatusVariable(id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return monitor.getDescription(id);
	}
}
