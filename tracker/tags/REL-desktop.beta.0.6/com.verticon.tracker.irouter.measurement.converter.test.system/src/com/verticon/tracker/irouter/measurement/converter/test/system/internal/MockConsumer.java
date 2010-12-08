package com.verticon.tracker.irouter.measurement.converter.test.system.internal;

import static com.verticon.tracker.irouter.measurement.converter.test.system.internal.MeasurementConverterSystemTest.bundleMarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock producer of Envelopes.
 * 
 * @author jconlon
 * 
 */
public class MockConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockConsumer.class);

	List<Envelope> envelopes = new ArrayList<Envelope>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockConsumer []";
	}

	@Override
	public void updated(Wire wire, Object value) {
		if (value instanceof Envelope) {
			envelopes.add((Envelope) value);
			logger.info(bundleMarker, "Received {} from wirescope={}", value,
					wire.getScope());
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.info(bundleMarker, "{} Producers connected",
				Arrays.toString(wires));
	}

}
