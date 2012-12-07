package com.verticon.tracker.irouter.premises.animal.test.system.internal;

import static com.verticon.tracker.irouter.premises.animal.test.system.internal.Test_PremisesAnimalProducer.bundleMarker;

import java.util.Arrays;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jconlon
 * 
 */
public class Catcher implements ICatcher, Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Catcher.class);

	private Envelope lastEnvelope = null;
	private int wiresConnected;

	@Override
	public void updated(Wire wire, Object in) {
		if (in instanceof Envelope) {
			this.lastEnvelope = (Envelope) in;
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {

		wiresConnected = wires != null ? wires.length : 0;
		// if(wiresConnected>0 && latch!=null){
		// logger.debug("Count down");
		// latch.countDown();
		// }
		logger.info(bundleMarker, "{} producers connected",
				wires != null ? Arrays.toString(wires) : 0);
	}

	@Override
	public Envelope getLastEnvelope() {
		return lastEnvelope;
	}

	@Override
	public void clear() {
		this.lastEnvelope = null;
	}

	@Override
	public int getNumberOfConnections() {
		return wiresConnected;
	}

}
