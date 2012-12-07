package com.verticon.tracker.irouter.premises.animal.test.system.internal;

import static com.verticon.tracker.irouter.premises.animal.test.system.internal.Test_PremisesAnimalProducer.bundleMarker;

import java.util.Arrays;

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
public class MockProducer implements Producer, IController {

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
		logger.info(bundleMarker, "{} consumers connected",
				wires != null ? Arrays.toString(wires) : 0);
	}

	/**
	 * Access point for injecting test receivedObjects
	 * 
	 * @param value
	 */
	@Override
	public void send(Object value) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value={}, No wires", value);
			return;
		}
		for (Wire wire : wires) {
			logger.info(bundleMarker, "Sending {} to wirescope={}", value,
					wire.getScope());
			wire.update(value);
		}
	}

	@Override
	public boolean hasWires() {
		return wires != null;
	}

}
