package com.verticon.tracker.irouter.measurement.event.test.system.internal;

import static com.verticon.tracker.irouter.measurement.event.test.system.internal.MeasurementEventConsumerSystemTest.bundleMarker;

import java.util.Arrays;

import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock producer of Envelopes.
 * 
 * @author jconlon
 * 
 */
public class MockProducer implements Producer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockProducer.class);

	private Wire[] wires = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockProducer []";
	}

	@Override
	public Object polled(Wire wire) {
		return null;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires = wires;
		logger.info(bundleMarker, "{} Consumers connected",
				Arrays.toString(wires));
	}

	/**
	 * Access point for injecting test envelopes
	 * @param envelope
	 */
	void send(Envelope envelope) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value={}, No wires", envelope);
			return;
		}
		for (Wire wire : wires) {
			logger.info(bundleMarker, "Sending {} to wirescope={}", envelope.getValue(),
					wire.getScope());
			wire.update(envelope);
			
		}
	}

}
