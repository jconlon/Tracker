package com.verticon.tracker.irouter.eid.event.test.system.internal;

import static com.verticon.tracker.irouter.eid.event.test.system.internal.EIDEventProducerSystemTest.bundleMarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock consumer of Commands.
 * 
 * @author jconlon
 * 
 */
public class MockConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockConsumer.class);

	List<Long> receivedTags = new ArrayList<Long>();

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
	public void updated(Wire wire, Object in) {
		if(in instanceof Envelope){
			Envelope envelope = (Envelope)in;
			if(envelope.getValue() instanceof Long){
				Long value = (Long)envelope.getValue();
				receivedTags.add(value);
				logger.info(bundleMarker, "Received {} from wirescope={}", value,
						wire.getScope());
				latch.countDown();
			}
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.info(bundleMarker, "{} Producers connected",
				Arrays.toString(wires));
	}

}
