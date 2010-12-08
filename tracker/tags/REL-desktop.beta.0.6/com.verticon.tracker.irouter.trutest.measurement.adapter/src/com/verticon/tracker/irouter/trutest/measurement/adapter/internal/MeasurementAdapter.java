package com.verticon.tracker.irouter.trutest.measurement.adapter.internal;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * MeasurementAdapter is a Measurement Consumer and a TruTest Command producer .
 * It consumes Measurements and converts them into TruTest commands to display
 * the Measurement values in TruTest Indicator fields.
 * 
 * @author jconlon
 * 
 */
public class MeasurementAdapter implements Consumer, Producer, Monitorable {
	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String LAST_COMMANDS_SENT = "producer.Last_Commands_Sent";
	private static final String TOTAL_COMMANDS_SENT = "producer.Total_Commands_Sent";

	private static final String DESTINATION_FIELD = "destination.field";
	private static final String DESTINATIN_PORT = "destination.port";
	private static final String MIN_CHARACTERS = "minimuim.characters";
	private static final String PRESENTATION_UNITS = "presentation.units";
	private static final String DECIMAL_PLACES = "decimal.places";

	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.measurement.adapter";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MeasurementAdapter.class);
	private Wire[] wires = new Wire[] {};
	private Map<String, Object> config = null;
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger totalCommands = new AtomicInteger(0);
	private volatile String lastCommands = null;
	private String fieldID;
	private NumberFormat formatter;
	private Converter conversion;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MeasurementAdapter [pid=" + getPid() + "]";
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
		fieldID = buildFieldID();
		formatter = buildFormater();
		conversion = Converter.valueOf((String) config.get(PRESENTATION_UNITS));
	}

	/**
	 * {SXD28}\r\n{SXC26}\r
	 * 
	 * @return
	 */
	private String buildFieldID() {
		StringBuilder buf = new StringBuilder("{SXD");
		buf.append(config.get(DESTINATIN_PORT))
				.append(config.get(DESTINATION_FIELD)).append("}\r\n{SXC")
				.append(config.get(DESTINATIN_PORT))
				.append(config.get(MIN_CHARACTERS)).append("}\r\n");

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
	}

	@Override
	public synchronized Object polled(Wire wire) {
		return lastCommands;
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
				produce((Measurement) envelope.getValue());
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

	private void produce(Measurement measurement) {
		StringBuilder builder = new StringBuilder(fieldID);
		double value = conversion.convert(measurement);

		builder.append(formatter.format(value));
		builder.append("\r\n");
		String commands = builder.toString();

		if (wires != null) {
			if (!conversion.isCompatable(measurement)) {
				logger.error(
						bundleMarker,
						"{} failed to produce {} because it is not compatible with {}",
						new Object[] { this, measurement, conversion });
				return;
			}

			logger.debug("{}: Producing {} for {} wires", new Object[] { this,
					commands, wires.length });

			for (Wire wire : wires) {
				wire.update(commands);
			}
			lastCommands = commands;
			totalCommands.incrementAndGet();

		} else {
			logger.warn(bundleMarker,
					"{} defered sending {} because there are no wires", this,
					commands);
		}

	}

	/**
	 * Build a decimal formatter with a pattern where the total size of the
	 * pattern is the MIM_CHARACTERS the decimal point shoes DECIMAL_PLACES
	 * 
	 * ###.####
	 */
	private NumberFormat buildFormater() {
		StringBuilder builder = new StringBuilder();
		int decimalPlaces = getConfigurationInteger(DECIMAL_PLACES);

		int minDigits = getConfigurationInteger(MIN_CHARACTERS);

		int decimal = minDigits - 1 - decimalPlaces;
		int count = 0;
		while (count < minDigits) {
			if (count == decimal) {
				builder.append('.');
			} else {
				builder.append('0');
			}
			count++;
		}
		logger.debug(
				bundleMarker,
				"{} format min digits ={} decimal points={} pattern={}",
				new Object[] { this, minDigits, decimalPlaces,
						builder.toString() });
		return new DecimalFormat(builder.toString());
	}

	
	
	public Integer getConfigurationInteger(String key) {
		Object conf = config.get(key);
		if (conf instanceof String) {
			return new Integer((String) conf);
		}
		return (Integer) conf;
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { CONNECTED_PRODUCERS_COUNT,
				CONNECTED_CONSUMERS_COUNT, LAST_COMMANDS_SENT,
				TOTAL_COMMANDS_SENT };
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
		} else if (LAST_COMMANDS_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastCommands != null ? lastCommands.toString() : "");
		} else if (TOTAL_COMMANDS_SENT.equals(name)) {
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

		if (TOTAL_COMMANDS_SENT.equals(name)) {
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
			return "The number of producers connected to this converter.";
		} else if (LAST_COMMANDS_SENT.equals(name)) {
			return "The last measurement as adapted commands sent to consumers.";
		} else if (TOTAL_COMMANDS_SENT.equals(name)) {
			return "The total numver of measurement as adapted commands sent to consumers.";
		}
		return null;
	}
}
