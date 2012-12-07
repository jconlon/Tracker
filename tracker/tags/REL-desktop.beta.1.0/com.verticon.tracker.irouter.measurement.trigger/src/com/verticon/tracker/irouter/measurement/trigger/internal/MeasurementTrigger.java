package com.verticon.tracker.irouter.measurement.trigger.internal;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * MeasurementTrigger is a generic business logic Component Factory that creates
 * services to inspect measurements for conditions and produce a state if
 * specific conditions are met.
 * 
 * Two inspection conditions are supported:
 * <ol>
 * <li>Rising Threshold condition will send a trigger state when a sequence of
 * measurements pass through a range of values less than or equal to specified
 * low value up to a value equal to or greater than a specified high value.</li>
 * <li>Falling Threshold condition will send a trigger state when a sequence of
 * measurements pass through a range of values from greater than or equal to
 * specified high value back to a value equal to or less than a specified low
 * value.</li>
 * </ol>
 * 
 * The Trigger State will have the following attributes:
 * <ol>
 * <li>Name = com.verticon.tracker.irouter.measurement.trigger</li>
 * <li>Value 2</li>
 * </ol>
 * 
 * @author jconlon
 * 
 */
public class MeasurementTrigger implements Consumer, Producer, Monitorable {

	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String TIME_OF_LAST_TRIGGER = "producer.Last_Trigger";
	private static final String TOTAL_TRIGGER = "producer.Total_Triggers";
	private static final String LOW_VALUE = "value.low";
	private static final String HIGH_VALUE = "value.high";
	private static final String OPERATION_TYPE = "operation.type";

	static final int FIRE = 2;
	static final int ARMED = 1;
	static final int RESET = 0;
	static final State RESET_STATE = new State(RESET,
			MeasurementTrigger.PLUGIN_ID);
	static final State ARMED_STATE = new State(ARMED,
			MeasurementTrigger.PLUGIN_ID);
	static final State FIRE_STATE = new State(FIRE,
			MeasurementTrigger.PLUGIN_ID);
	static final String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.trigger";

	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MeasurementTrigger.class);
	private Wire[] wires = new Wire[] {};
	private Map<String, Object> config = null;
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger totalTriggers = new AtomicInteger(0);
	private volatile long lastTriggerTime = 0;
	private StateMachine stateMachine = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MeasurementTrigger [pid=" + getPid() + ", stateMachine="
				+ stateMachine + "]";
	}

	private String getPid() {
		return config != null ? (String) config.get("service.pid") : "null";
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		this.config = config;
		logger.debug(bundleMarker, "{} activating properties={}", this, config);
		stateMachine = buildState();
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
		stateMachine = null;
	}

	@Override
	public synchronized Object polled(Wire wire) {
		return lastTriggerTime;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} consumersConnected with wires={}", this,
				Arrays.toString(wires));
		this.wires = wires;
	}

	@Override
	public void updated(Wire wire, Object in) {
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			if (envelope.getValue() instanceof Measurement) {
				processMeasurement((Measurement) envelope.getValue());
			} else {
				logger.error(
						bundleMarker,
						"{} consumed unknown value={} from control scope={}",
						new Object[] { this, in,
								Arrays.toString(wire.getScope()) });
			}

		} else if (in instanceof Measurement) {
			processMeasurement((Measurement) in);
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} producersConnected with wires={}", this,
				Arrays.toString(wires));
		producersConnected.set(wires!=null?wires.length:0);
	}

	private void processMeasurement(Measurement measurement) {
		logger.debug(bundleMarker, "{} processing state={}", this, measurement);
		State state = stateMachine.processMeasurement(measurement);

		if (FIRE_STATE.equals(state)) {
			fire(state);
		}
	}

	private StateMachine buildState() {
		return StateMachine
				.getInstance((String) config.get(OPERATION_TYPE),
						getConfigurationDouble(LOW_VALUE),
						getConfigurationDouble(HIGH_VALUE));
	}

	
	private Double getConfigurationDouble(String key) {
		Object conf = config.get( key);
		if(conf instanceof String){
			return new Double((String)conf);
		}
		return (Double)conf;
	}
	
	private void fire(State in) {

		if (wires != null) {

			logger.debug(bundleMarker, "{}: firing {} to {} wires",
					new Object[] { this, in, wires.length });

			for (Wire wire : wires) {
				wire.update(in);
			}
			totalTriggers.incrementAndGet();
			lastTriggerTime = in.getTime();

		} else {
			logger.warn(bundleMarker,
					"{} defered firing {} because there are no wires", this, in);
		}
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { CONNECTED_PRODUCERS_COUNT,
				CONNECTED_CONSUMERS_COUNT, TIME_OF_LAST_TRIGGER, TOTAL_TRIGGER };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					wires == null ? 0 : wires.length);
		} else if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					producersConnected.get());
		} else if (TIME_OF_LAST_TRIGGER.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastTriggerTime == 0 ? new Date(lastTriggerTime).toString()
							: "");
		} else if (TOTAL_TRIGGER.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalTriggers.get());
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

		if (TOTAL_TRIGGER.equals(name)) {
			totalTriggers.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return "The number of connected consumer wires.";
		} else if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return "The number of producers connected to this flow terminator.";
		} else if (TIME_OF_LAST_TRIGGER.equals(name)) {
			return "The last time the flow was terminated.";
		} else if (TOTAL_TRIGGER.equals(name)) {
			return "The total number of flow terminations.";
		}
		return null;
	}

}
