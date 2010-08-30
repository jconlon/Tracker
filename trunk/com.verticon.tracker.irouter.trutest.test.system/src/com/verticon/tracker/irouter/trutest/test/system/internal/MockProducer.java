package com.verticon.tracker.irouter.trutest.test.system.internal;

import static com.verticon.tracker.irouter.trutest.test.system.internal.TruTestSystemTest.bundleMarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock producer of Strings that are TruTest commands.
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
		return "MockConsumer []";
	}

	public List<Measurement> measurements = new ArrayList<Measurement>();
	public List<State> states = new ArrayList<State>();
	public List<Long> longs = new ArrayList<Long>();

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

	void send(String value) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value={}, No wires", value);
			return;
		}
		for (Wire wire : wires) {
			wire.update(value);
			logger.info(bundleMarker, "Sending {} to wirescope={}", value,
					wire.getScope());
		}
	}

}
