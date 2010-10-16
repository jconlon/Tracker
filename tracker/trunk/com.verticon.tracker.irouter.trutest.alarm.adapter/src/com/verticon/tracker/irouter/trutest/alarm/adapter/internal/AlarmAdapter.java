package com.verticon.tracker.irouter.trutest.alarm.adapter.internal;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * AlarmAdapter is a State Consumer and a TruTest Command producer. It consumes
 * States and adapts them to TruTest commands to turn on and off the alarm in a
 * TruTest Indicator.
 * 
 * Reception of a distinct state turns on the alarm, while reception of any
 * other state turns the alarm off.
 * 
 * 
 * @author jconlon
 * 
 */
public class AlarmAdapter implements Consumer, Producer, Monitorable {
	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String TIME_OF_LAST_ALARM = "producer.Last_Alarm_Sent";
	private static final String TOTAL_ALARMS_SENT = "producer.Total_Alarms_Sent";
	private static final String ALARM_DURATION = "alarm.duration";
	private static final String ALARM_INTERVAL = "alarm.interval";
	private static final String ALARM_STATE_NAME = "alarm.state.name";
	private static final String ALARM_STATE_VALUE = "alarm.state.value";

	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.alarm.adapter";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(AlarmAdapter.class);
	private Wire[] wires = new Wire[] {};
	private Map<String, Object> config = null;
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger totalCommands = new AtomicInteger(0);
	private volatile long lastAlarmTime = 0;
	private String alarmCommand;
	private ScheduledExecutorService scheduler = null;
	private ScheduledFuture<?> alarm = null;
	private State onState = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlarmAdapter [pid=" + getPid() + ", state=" + onState + "]";
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
		alarmCommand = buildAlarmCommand();
		buildStates();
		scheduler = Executors.newScheduledThreadPool(1);
	}

	/**
	 * {SABP500}\r\n
	 * 
	 * @return
	 */
	private String buildAlarmCommand() {
		StringBuilder buf = new StringBuilder("{SABP");
		buf.append(config.get(ALARM_DURATION)).append("}\r\n");
		return buf.toString();
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
		turnOffAlarm();
		scheduler.shutdownNow();
		scheduler = null;
		onState = null;
	}

	@Override
	public synchronized Object polled(Wire wire) {
		return alarmCommand;
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
			if (envelope.getValue() instanceof State) {
				processState((State) envelope.getValue());
			} else {
				logger.error(
						bundleMarker,
						"{} consumed unknown value={} from envelope outputScope={}",
						new Object[] { this, in,
								Arrays.toString(wire.getScope()) });
			}
		} else {
			logger.error(
					bundleMarker,
					"{} consumed unknown value={} from envelope outputScope={}",
					new Object[] { this, in, Arrays.toString(wire.getScope()) });
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} producersConnected with wires={}", this,
				Arrays.toString(wires));
		producersConnected.set(wires!=null?wires.length:0);
	}

	private void processState(State state) {
		logger.debug(bundleMarker, "{} processing state={}", this, state);
		if (onState.equals(state)) {
			turnOnAlarm();
		} else {
			turnOffAlarm();
		}

	}

	private void buildStates() {
		onState = new State((Integer) config.get(ALARM_STATE_VALUE),
				(String) config.get(ALARM_STATE_NAME));
	}

	private void turnOnAlarm() {
		if (alarm != null) {
			logger.debug(bundleMarker, "{} alarm is already on", this);
			return;
		}
		logger.debug(bundleMarker, "{} turning on alarm", this);
		lastAlarmTime = System.currentTimeMillis();
		totalCommands.incrementAndGet();
		Integer interval = (Integer) config.get(ALARM_INTERVAL);
		alarm = scheduler.scheduleAtFixedRate(new Alarm(), 0, interval,
				TimeUnit.SECONDS);
	}

	private void turnOffAlarm() {
		if (alarm != null) {
			alarm.cancel(true);
		} else {
			logger.debug(bundleMarker, "{} alarm is already off", this);
		}
	}

	private void produce() {
		if (wires != null) {

			logger.debug(bundleMarker, "{}: Producing {} for {} wires",
					new Object[] { this, alarmCommand, wires.length });

			for (Wire wire : wires) {
				wire.update(alarmCommand);
			}

		} else {
			logger.warn(bundleMarker,
					"{} defered sending {} because there are no wires", this,
					alarmCommand);
		}
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { CONNECTED_PRODUCERS_COUNT,
				CONNECTED_CONSUMERS_COUNT, TIME_OF_LAST_ALARM,
				TOTAL_ALARMS_SENT };
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
		} else if (TIME_OF_LAST_ALARM.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastAlarmTime == 0 ? new Date(lastAlarmTime).toString()
							: "");
		} else if (TOTAL_ALARMS_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalCommands.get());
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

		if (TOTAL_ALARMS_SENT.equals(name)) {
			totalCommands.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return "The number of connected consumer wires.";
		} else if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return "The number of producers connected to this adapter.";
		} else if (TIME_OF_LAST_ALARM.equals(name)) {
			return "The last time the alarm was given.";
		} else if (TOTAL_ALARMS_SENT.equals(name)) {
			return "The total number of alarms given.";
		}
		return null;
	}

	private class Alarm implements Runnable {
		@Override
		public void run() {
			produce();
		}
	}
}
