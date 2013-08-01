package com.verticon.tracker.irouter.mqtt.internal;

import static com.verticon.tracker.irouter.mqtt.internal.MqttBridgeComponent.bundleMarker;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerToPublisher implements Consumer {

	protected final AtomicInteger wiresConnected = new AtomicInteger(0);
	private final Client client;
	private final Monitor monitor;

	ConsumerToPublisher(Client client, Monitor monitor) {
		super();
		this.client = client;
		this.monitor = monitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConsumerToPublisher [client=" + client + "]";
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ConsumerToPublisher.class);

	@Override
	public void updated(Wire wire, Object value) {
		if (value instanceof Envelope) {
			Envelope envelope = (Envelope) value;
			if (envelope.getValue() instanceof byte[]) {
				logger.debug(bundleMarker, "Received envelope id={} scope={} ",
						envelope.getIdentification(), envelope.getScope());
				publish((String) envelope.getIdentification(),
						(byte[]) envelope.getValue());
				monitor.incrementTotalProductsConsumed();
			}

			else {
				logger.error(
						bundleMarker,
						"Unknown payload type={} id={} scope={} ",
						new Object[] { envelope.getValue().getClass(),
								envelope.getIdentification(),
								envelope.getScope() });
				monitor.add("Failed to update wires.",
						new IllegalStateException("Unknown payload type "
								+ envelope.getValue().getClass()));

			}
		} else {
			logger.error(bundleMarker,
					"Unsupported object={} only Envelope types are supported.",
					value.getClass());
		}

	}

	@Override
	public void producersConnected(Wire[] wires) {
		wiresConnected.set(wires != null ? wires.length : 0);
		if (wires == null || wires.length == 0) {
			logger.debug(bundleMarker, "{}: Not connected to any wires.", this);
			monitor.setProducersConnected(0);
		} else {

			for (Wire wire : wires) {
				logger.debug(bundleMarker, "{}: Connected to {}", this, wire
						.getProperties().get(WIREADMIN_PRODUCER_PID));

			}
			monitor.setProducersConnected(wires.length);
		}
	}

	void publish(String topicName, byte[] payload) {
		try {
			client.publish(topicName, 2, payload);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
