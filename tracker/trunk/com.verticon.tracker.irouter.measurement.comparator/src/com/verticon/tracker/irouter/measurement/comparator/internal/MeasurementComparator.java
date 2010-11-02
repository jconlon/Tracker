package com.verticon.tracker.irouter.measurement.comparator.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * MeasurementComparator is a WireAdmin Measurement comparator.
 * 
 * The measurement arriving on the first configured consumer scope is compared
 * with the measurement arriving on the second configured consumer scope.
 * 
 * Produces a state with a negative integer, zero, or a positive integer if the
 * first measurement is less than, equal to, or greater than the second
 * measurement.
 * 
 * If the states are unequal or incompatible creates a state with an Integer.MIN
 * value.
 * 
 * @author jconlon
 * 
 */
public class MeasurementComparator implements Consumer, Producer, Monitorable {

	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String LAST_STATE_SENT = "producer.Last_State_Sent";
	private static final String TOTAL_STATES_SENT = "producer.Total_States_Sent";

	// private static enum Operation{ADD,SUBTRACT,DIVIDE,MULTIPLY};
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.comparator";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MeasurementComparator.class);
	private Wire[] wires = null;
	private Map<String, Object> config = null;
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger totalMeasurements = new AtomicInteger(0);
	private volatile Measurement firstMeasurement = null;
	private volatile Measurement secondMeasurement = null;

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		this.config = config;

		for (Map.Entry<String, Object> entry : config.entrySet()) {
			logger.debug(bundleMarker, "Property key={} value={}",
					entry.getKey(), entry.getValue());
		}
		logger.debug(bundleMarker, "Activating {}", this);
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		this.config.clear();
		logger.debug(bundleMarker, "deactivating {}", this);
	}

	@Override
	public synchronized Object polled(Wire wire) {
		return firstMeasurement;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "Invoked consumersConnected with wires={}",
				Arrays.toString(wires));
		this.wires = wires;
	}

	@Override
	public void updated(Wire wire, Object in) {
		logger.debug(bundleMarker, "Invoked updated with value={}", in);
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			if (envelope.getValue() instanceof Measurement) {
				compare((Measurement) envelope.getValue(), envelope.getScope());

			} else {
				logger.error(
						bundleMarker,
						"Unknown value={} was received from envelope outputScope={}",
						in, Arrays.toString(wire.getScope()));
			}
		} else {
			logger.error(bundleMarker,
					"Unknown object={} was received from wire outputScope={}",
					in, Arrays.toString(wire.getScope()));
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "Invoked producersConnected with wires={}",
				Arrays.toString(wires));
		producersConnected.set(wires!=null?wires.length:0);
	}

	/**
	 * Assign the measurement to first or second place based on the scope
	 * 
	 * @param m
	 * @param scope
	 */
	private void compare(Measurement m, String scope) {
		if (((String[]) config.get(WireConstants.WIREADMIN_CONSUMER_SCOPE))[0]
				.equals(scope)) {
			firstMeasurement = m;
		} else {
			secondMeasurement = m;
		}

		compare();
	}

	private synchronized void compare() {
		int value;
		if (firstMeasurement == null || secondMeasurement == null) {
			value = Integer.MIN_VALUE;
		} else {
			try {
				value = firstMeasurement.compareTo(secondMeasurement);
			} catch (ArithmeticException e) {
				value = Integer.MIN_VALUE;
			}
		}
		State s = new State(value, PLUGIN_ID, System.currentTimeMillis());
		produce(s);
	}

	private void produce(State measurement) {
		Envelope envelope;

		for (Wire wire : wires) {
			envelope = new BasicEnvelope(measurement, getPid(),
					getOutputScope());
			wire.update(envelope);
			totalMeasurements.incrementAndGet();
		}
	}

	private String getPid() {
		return (String) config.get("service.pid");
	}

	private String getOutputScope() {
		return ((String[]) config.get("wireadmin.producer.scope"))[0];
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { CONNECTED_PRODUCERS_COUNT,
				CONNECTED_CONSUMERS_COUNT, LAST_STATE_SENT, TOTAL_STATES_SENT };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					wires!=null?wires.length:0);
		} else if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					producersConnected.get());
		} else if (LAST_STATE_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					firstMeasurement != null ? firstMeasurement.toString() : "");
		} else if (TOTAL_STATES_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalMeasurements.get());
		} else {
			throw new IllegalArgumentException("Invalid Status Variable name "
					+ name);
		}
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String name)
			throws IllegalArgumentException {

		if (TOTAL_STATES_SENT.equals(name)) {
			totalMeasurements.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return "The number of connected consumer wires.";
		} else if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return "The number of producers connected to this converter.";
		} else if (LAST_STATE_SENT.equals(name)) {
			return "The last measurement sent to consumers.";
		} else if (TOTAL_STATES_SENT.equals(name)) {
			return "The total numver of measurements sent to consumers.";
		}
		return null;
	}
}
