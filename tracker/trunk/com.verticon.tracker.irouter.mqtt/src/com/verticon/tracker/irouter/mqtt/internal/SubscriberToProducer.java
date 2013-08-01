package com.verticon.tracker.irouter.mqtt.internal;

import static com.verticon.tracker.irouter.mqtt.internal.MqttBridgeComponent.bundleMarker;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriberToProducer implements Producer, MqttCallback {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SubscriberToProducer.class);

	private final String scope;
	private final List<Wire> wires = new CopyOnWriteArrayList<Wire>();
	private final Monitor monitor;

	SubscriberToProducer(String scope, Monitor monitor) {
		super();
		this.scope = scope;
		this.monitor = monitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubscriberToProducer [scope=" + scope + "]";
	}

	@Override
	public Object polled(Wire wire) {
		return null;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires.clear();
		if (wires != null) {
			this.wires.addAll(Arrays.asList(wires));
			monitor.setConsumersConnected(wires.length);
		} else {
			monitor.setConsumersConnected(0);
		}
		if (this.wires.isEmpty()) {
			logger.debug(bundleMarker, "{}: Not connected to any wires.", this);
		} else {
			HashSet<String> consumers = new HashSet<String>();
			for (Wire wire : wires) {
				consumers.add((String) wire.getProperties().get(
						WIREADMIN_CONSUMER_PID));
			}

			logger.debug(bundleMarker,
					"{}: Connected to {} wires, and {} consumers={}",
					new Object[] { this, wires.length, consumers.size(),
							consumers });

		}
	}

	@Override
	public void connectionLost(Throwable cause) {
		logger.error(bundleMarker, "Connection lost", cause);
	}

	@Override
	public void messageArrived(String topic, MqttMessage message)
			throws Exception {

		logger.debug(bundleMarker, "Message arrived on topic={}", topic);
		if (!wires.isEmpty()) {
			Envelope envelope = new BasicEnvelope(message.getPayload(), topic,
					scope);
			logger.debug(bundleMarker,
					"Sending envelope, to {} wires, topic={} and scope={}",
					new Object[] { wires.size(), topic, scope });

			// Send to all wires
			for (Wire wire : wires) {
				if (Arrays.asList(wire.getScope()).contains(scope)) {
					wire.update(envelope);
				}

			}
		} else {
			logger.warn(bundleMarker,
					"No wires found. Aborted sending message.");
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		logger.debug(bundleMarker, "Delievery complete on topics {}",
				(Object[]) token.getTopics());
	}

}
