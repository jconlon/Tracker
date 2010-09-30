package com.verticon.tracker.irouter.wireadmin.test.system.internal;

import static com.verticon.tracker.irouter.wireadmin.test.system.internal.WireAdminSystemTest.bundleMarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock consumer of Strings or Envelopes  
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

	List<Measurement> measurements = new ArrayList<Measurement>();
	List<State> states = new ArrayList<State>();
	List<Long> longs = new ArrayList<Long>();
	List<String> strings = new ArrayList<String>();
	
    Wire[] wires = null;

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
				

			}else if (result instanceof Long) {
				
				longs.add((Long)result);
				

			}

		}else if (value instanceof String){
			strings.add((String) value);
		}

	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.info(bundleMarker, "{} producers connected", 
				Arrays.toString(wires));
		this.wires=wires;
	}

}
