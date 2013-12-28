package com.verticon.tracker.irouter.mqtt.internal;

import java.io.IOException;
import java.util.Map;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class MqttBridgeComponent implements Monitorable, Consumer, Producer {

	static String PLUGIN_ID = "com.verticon.tracker.irouter.mqtt";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	private final Monitor monitor = new Monitor();
	private final Client client = new Client(monitor);
	private final ConsumerToPublisher consumerToPublisher = new ConsumerToPublisher(
			client, monitor);


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

	@Override
	public Object polled(Wire wire) {
		// ignore
		return null;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		for (SubscriberToProducer subscriberToProducer : client.getSubcribersToProducers()
				.values()) {
			subscriberToProducer.consumersConnected(wires);
		}
		monitor.setConsumersConnected(wires != null ? wires.length : 0);
	}

	@Override
	public void updated(Wire wire, Object value) {
		consumerToPublisher.updated(wire, value);
	}

	@Override
	public void producersConnected(Wire[] wires) {
		consumerToPublisher.producersConnected(wires);
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 * @throws IOException
	 */
	void activate(Map<String, Object> config) throws IOException {
		monitor.activate(config);
		client.activate(config);

	}

	void deactivate() {
		client.deactivate();
	}

}
