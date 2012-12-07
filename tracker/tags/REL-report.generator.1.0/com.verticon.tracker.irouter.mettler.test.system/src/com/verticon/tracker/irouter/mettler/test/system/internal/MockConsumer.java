package com.verticon.tracker.irouter.mettler.test.system.internal;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.verticon.tracker.irouter.mettler.test.system.internal.MettlerBalanceSystemTest.bundleMarker;

public class MockConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockConsumer.class);

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockConsumer [measurements=" + measurements.size() + "]";
	}

	public List<Measurement> measurements = new ArrayList<Measurement>();
	CountDownLatch receivedMeasurements = null;
	CountDownLatch start = new CountDownLatch(1);
	
	@Override
	public void updated(Wire wire, Object value) {
		if (value instanceof Envelope) {
			Object result = ((Envelope) value).getValue();
			if (result instanceof Measurement) {
				Measurement m = (Measurement) result;
				measurements.add(m);
				start.countDown();
				if(receivedMeasurements!=null){
					receivedMeasurements.countDown();
				}
				logger.info(bundleMarker, "{} received measurement {}", this,
						m.getValue());
			}

		}

	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.info(bundleMarker, "{} {} producers connected", this,
				Arrays.toString(wires));
	}

	void setUpLatch(int count){
		receivedMeasurements = new CountDownLatch(count);
	}
}
