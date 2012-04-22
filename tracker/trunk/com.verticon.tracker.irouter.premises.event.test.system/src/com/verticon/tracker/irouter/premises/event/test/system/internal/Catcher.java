package com.verticon.tracker.irouter.premises.event.test.system.internal;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;

/**
 * 
 * @author jconlon
 * 
 */
public class Catcher implements ICatcher, Consumer {

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
