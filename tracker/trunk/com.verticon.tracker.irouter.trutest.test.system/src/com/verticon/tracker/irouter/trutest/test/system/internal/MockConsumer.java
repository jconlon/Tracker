package com.verticon.tracker.irouter.trutest.test.system.internal;

import static com.verticon.tracker.irouter.trutest.test.system.internal.TruTestSystemTest.bundleMarker;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock consumer of Envelopes from a TruTest producer 
 * that contain Measurements, States and Longs. 
 * 
 * @author jconlon
 *
 */
public class MockConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockConsumer.class);


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
	public Wire[] wires = null;

	@Override
	public void updated(Wire wire, Object value) {
		logger.info(bundleMarker, "Updated value {}",
				value);
		if (value instanceof Envelope) {
			Object result = ((Envelope) value).getValue();
			if (result instanceof Measurement) {
				Measurement m = (Measurement) result;
				measurements.add(m);
				logger.info(bundleMarker, "Received measurement {}", 
						m.getValue());

			}else if (result instanceof State) {
				State m = (State) result;
				states.add(m);
				logger.info(bundleMarker, "Received state {}", 
						m.getValue());

			}else if (result instanceof Long) {
				
				longs.add((Long)result);
				logger.info(bundleMarker, "Received {} {}",
						result.getClass(), result);

			}

		}

	}

	@Override
	public void producersConnected(Wire[] wires) {
		this.wires=wires;
		if(wires==null || wires.length==0){
			logger.info(bundleMarker, "{} disconnected from all producers",this);
			return;
		}
		for (Wire wire : wires) {
			logger.info(bundleMarker, "{} connected to producer={}",
					this,wire.getProperties().get(WireConstants.WIREADMIN_PRODUCER_PID));
		}
	}

}
