package com.verticon.tracker.store.mongodb.internal.irouter;

import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;

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

import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.store.mongodb.internal.Monitor;
import com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables;

public class MongoDBConsumer implements Monitorable, Consumer {



	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MongoDBConsumer.class);


	private final Monitor monitor;
	private final ProductHandler productHandler;
	
	
	public MongoDBConsumer(Monitor monitor,
			ProductHandler productHandler) {
		super();

		this.monitor = monitor;
		this.productHandler = productHandler;
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
					"Received envelope on wire scope={}, with envelope id={}, value type ={}",
					new Object[] {
							Arrays.toString(wire.getScope()),
							envelope.getIdentification(),
							envelope.getValue().getClass().getName() });
			if (envelope.getValue() != null) {
				if (envelope.getValue() instanceof Tag) {
					productHandler.handle((Tag) envelope.getValue());
				} else if (envelope.getValue() instanceof Animal) {
					Animal animal = (Animal) envelope.getValue();
					productHandler.handle(animal);
				} else if (envelope.getValue() instanceof Premises) {
					Premises premises = (Premises) envelope.getValue();
					productHandler.register(premises, null, null);
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
