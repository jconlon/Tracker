/**
 * 
 */
package com.verticon.tracker.store.mqtt.internal;

import static com.google.common.collect.Lists.newArrayList;
import static com.verticon.tracker.store.mqtt.internal.MQTTTrackerStore.bundleMarker;
import static com.verticon.tracker.store.mqtt.internal.StatusAndConfigVariables.DEFAULT_ANIMAL;
import static com.verticon.tracker.store.mqtt.internal.StatusAndConfigVariables.getPremisesURI;

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

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.TrackerStoreUtils;

/**
 * @author jconlon
 * 
 */
public class MQTTConsumer implements Monitorable, Consumer {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MQTTConsumer.class);

	private final MQTTTrackerStore mQTTTrackerStore;
	private final Monitor monitor;
	private Map<String, Object> config = null;

	/**
	 * 
	 */
	public MQTTConsumer(MQTTTrackerStore mQTTTrackerStore, Monitor monitor) {
		this.mQTTTrackerStore = mQTTTrackerStore;
		this.monitor = monitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin
	 * .Wire, java.lang.Object)
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
				if (envelope.getValue() instanceof Tag) {
					handle((Tag) envelope.getValue());
				} else if (envelope.getValue() instanceof Animal) {
					Animal animal = (Animal) envelope.getValue();
					handle(animal);
				} else if (envelope.getValue() instanceof Premises) {
					Premises premises = (Premises) envelope.getValue();
					register(premises, null, null);
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



	private void register(Premises premises, Object object, Object object2) {
		try {
			mQTTTrackerStore.register(premises);
			monitor.incrementTotalPremisesRegisted();
		} catch (Exception e) {
			String message = "Failed to handle premises =" + premises.getUri();
			monitor.add(message, e);
			logger.error(bundleMarker, message, e);
		}

	}

	private void handle(Animal animal) {
		try {
			record(animal);
		} catch (IOException e) {
			String message = "Failed to handle " + animal.eClass().getName()
					+ " id=" + animal.getId();
			monitor.add(message, e);
			logger.error(bundleMarker, message, e);
		}
	}

	private void handle(Tag tag) {
		Animal animal = createDefaultAnimal(tag);
		try {
			record(animal);
		} catch (IOException e) {
			String message = "Failed to handle tag =" + tag;
			monitor.add(message, e);
			logger.error(bundleMarker, message, e);
		}

	}

	private Animal createDefaultAnimal(Tag tag) {
		Integer defaultAnimalKey = TrackerStoreUtils
				.getConfigurationInteger(config.get(DEFAULT_ANIMAL.configID));
		Animal animal = TrackerStoreUtils.createDefaultAnimal(defaultAnimalKey);
		animal.getTags().add(tag);
		return animal;
	}

	private void record(Animal animal) throws IOException {
		logger.debug(bundleMarker, "Recording animal id={}", animal.getId());
		IUpdateStats stats = mQTTTrackerStore.record(getPremisesURI(config),
				newArrayList(animal));
		monitor.add(stats);
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
