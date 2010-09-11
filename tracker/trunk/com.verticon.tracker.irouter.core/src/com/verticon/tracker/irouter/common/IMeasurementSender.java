package com.verticon.tracker.irouter.common;

import org.osgi.util.measurement.Measurement;

/**
 * Object to send Measurement output. Created as an aid for testing.
 * @author jconlon
 *
 */
public interface IMeasurementSender {

	public abstract void send(Measurement measurement);

}