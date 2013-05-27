package com.verticon.tracker.store.mongodb.internal.consumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Tag;
import com.verticon.tracker.store.mongodb.internal.Monitor;
import com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables;
import com.verticon.tracker.store.mongodb.internal.UpdateAndFind;

public class MongoDBConsumer implements Monitorable, Consumer {

	private static final String PLUGIN_ID = "com.verticon.tracker.store.mongodb.consumer";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MongoDBConsumer.class);


	private final Monitor monitor;
	private final ProductHandler productHandler;
	
	
	public MongoDBConsumer(UpdateAndFind trackerUpdate, Monitor monitor) {
		super();

		this.monitor = monitor;
		this.productHandler = new ProductHandler(monitor, trackerUpdate);
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

	@Override
	public void updated(Wire wire, Object in) {
		if (in instanceof Envelope) {
			monitor.incrementTotalProductsConsumed();
			Envelope envelope = (Envelope) in;
			logger.debug(
					bundleMarker,
					"Wire scope={} pid={} updated with object id={}, value={}",
					new Object[] {
							Arrays.toString(wire.getScope()),
							wire.getProperties().get(
									WireConstants.WIREADMIN_PID),
							envelope.getIdentification(), envelope.getValue() });
			if (envelope.getValue() != null) {
				if (envelope.getValue() instanceof Tag) {
					productHandler.handle((Tag) envelope.getValue());
				} else if (envelope.getValue() instanceof Animal) {
					Animal animal = (Animal) envelope.getValue();
					productHandler.handle(animal);
				} else {
					productHandler.handle(envelope);
				}
			}
		} else {
			logger.error(bundleMarker,
					"Unknown object={} was received from wire scope={}", in,
					Arrays.toString(wire.getScope()));
		}

	}

	@Override
	public void producersConnected(Wire[] wires) {
		monitor.setProducersConnected(wires != null ? wires.length : 0);
		monitor.update(monitor
						.getStatusVariable(StatusAndConfigVariables.PRODUCERS_CONNECTED.statusVarID));
		logger.debug(bundleMarker, "ProducerConnected with wires={}",
				Arrays.toString(wires));
	}



	/**
	 * @param authenticator
	 *            the authenticator to set
	 */
	public void setAuthenticator(Authenticator authenticator) {
		productHandler.setAuthenticator(authenticator);
	}

	/**
	 * @param authenticator
	 *            the authenticator to set
	 */
	public void unsetAuthenticator(Authenticator authenticator) {
		productHandler.unsetAuthenticator(authenticator);
	}



	/**
	 * Declaratives Services activation of instance.
	 * 
	 */
	public void activate(Map<String, Object> config) throws IOException {
		monitor.activate(config);
		productHandler.activate(config);
		logger.debug(bundleMarker, "Activated with config={}", config);
	}

	public void deactivate() {
		monitor.deactivate();
		productHandler.deactivate();
		logger.debug(bundleMarker, "Deactivated");
	}
}
