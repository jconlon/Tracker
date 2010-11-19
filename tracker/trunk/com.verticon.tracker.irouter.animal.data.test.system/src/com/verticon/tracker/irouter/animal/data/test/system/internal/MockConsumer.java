package com.verticon.tracker.irouter.animal.data.test.system.internal;

import static com.verticon.tracker.irouter.animal.data.test.system.internal.AnimalDataGatewaySystemTest.bundleMarker;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock consumer of Objects.
 * 
 * @author jconlon
 * 
 */
public class MockConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockConsumer.class);

	Object receivedObject = null;

	CountDownLatch latch = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockConsumer []";
	}

	void setUpLatch(int count) {
		latch = new CountDownLatch(count);
	}

	@Override
	public void updated(Wire wire, Object value) {
		receivedObject = value;
		logger.info(bundleMarker, "Received {} from wirescope={}", value,
				wire.getScope());
		latch.countDown();

	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.info(bundleMarker, "{} Producers connected",
				Arrays.toString(wires));
	}

}
