package com.verticon.tracker.irouter.common;

import org.osgi.service.wireadmin.Envelope;

/**
 * Object to send Envelope output. Created as an aid for testing.
 * @author jconlon
 *
 */
public interface IEnvelopeSender {

	public abstract void send(Envelope envelope);

}