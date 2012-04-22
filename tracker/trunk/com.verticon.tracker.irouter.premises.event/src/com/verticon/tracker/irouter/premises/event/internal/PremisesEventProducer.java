package com.verticon.tracker.irouter.premises.event.internal;

import static com.verticon.tracker.irouter.premises.event.internal.EventTransactionConsumer.bundleMarker;

import java.util.Arrays;

import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PremisesEventProducer implements Producer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(PremisesEventProducer.class);

	private Wire[] wires = new Wire[] {};
	private Envelope lastEnvelope = null;

	@Override
	public Object polled(Wire wire) {
		return lastEnvelope;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "Consumers connected with wires={}",
				Arrays.toString(wires));
		this.wires = wires;
	}

	Envelope produce(Envelope envelope) {
		this.lastEnvelope = envelope;

		if (wires != null) {

			logger.debug(bundleMarker,
					"Producing {} with scope {} to {} wires", new Object[] {
							envelope.getValue(), envelope.getScope(),
							wires.length });

			for (Wire wire : wires) {
				wire.update(envelope);
			}

		} else {
			logger.warn(bundleMarker,
					"Defered firing {} because there are no wires", envelope);
		}
		return this.lastEnvelope;
	}
}
