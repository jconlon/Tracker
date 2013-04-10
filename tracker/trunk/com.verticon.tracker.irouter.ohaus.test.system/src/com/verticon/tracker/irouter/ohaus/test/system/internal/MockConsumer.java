/**
 * 
 */
package com.verticon.tracker.irouter.ohaus.test.system.internal;

import static com.verticon.tracker.irouter.ohaus.test.system.internal.Configurator.bundleMarker;

import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jconlon
 *
 */
public class MockConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockConsumer.class);

	Object receivedObject = null;
	private final AtomicInteger counter = new AtomicInteger();

	int getCount() {
		return counter.get();
	}

	/* (non-Javadoc)
	 * @see org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin.Wire, java.lang.Object)
	 */
	@Override
	public void updated(Wire wire, Object value) {
		receivedObject = value;
		counter.incrementAndGet();
		if (value instanceof Envelope) {
			Envelope env = (Envelope) value;
			logger.debug(bundleMarker, "Received envelope scope={} value = {}",
					env.getScope(), env.getValue());
		} else {
			logger.warn(bundleMarker, "Received unknown value = {}", value);
		}

	}

	/* (non-Javadoc)
	 * @see org.osgi.service.wireadmin.Consumer#producersConnected(org.osgi.service.wireadmin.Wire[])
	 */
	@Override
	public void producersConnected(Wire[] wires) {

	}

}
