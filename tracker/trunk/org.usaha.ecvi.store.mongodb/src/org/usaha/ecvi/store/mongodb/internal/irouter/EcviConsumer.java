package org.usaha.ecvi.store.mongodb.internal.irouter;

import static org.usaha.ecvi.store.mongodb.internal.EcviMongoComponent.bundleMarker;

import java.util.Arrays;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Consumes Envelopes that are not null and sends these to the ProductHandler.
 * 
 * @author jconlon
 * 
 */
public class EcviConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(EcviConsumer.class);
	private final Monitor monitor;
	private final ProductHandler productHandler;

	public EcviConsumer(Monitor monitor, ProductHandler productHandler) {
		super();
		this.monitor = monitor;
		this.productHandler = productHandler;
	}

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
				productHandler.handle(envelope);

			} else {
				logger.warn(bundleMarker,
						"Null Envelope received from wire scope={}", in,
						Arrays.toString(wire.getScope()));
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

}
