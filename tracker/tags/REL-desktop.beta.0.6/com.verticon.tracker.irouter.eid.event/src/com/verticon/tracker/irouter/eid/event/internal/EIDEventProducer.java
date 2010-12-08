package com.verticon.tracker.irouter.eid.event.internal;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
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
public class EIDEventProducer implements Producer, Monitorable, EventHandler {

	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String TIME_OF_LAST_EID = "producer.Last_EID_Send_Time";
	private static final String TOTAL_EID = "producer.Total_EIDs";
	private static final String LAST_EID = "producer.Last_EID";
	private static final String CONNECTION_URI_STATUS_VAR = "producer.Connection_URI";
	
	private static final String FILTER = "event.filter";
	private static final String PLUGIN_ID = "com.verticon.tracker.irouter.eid.event";
	private static final String EVENT_ADMIN_PROPERTY_ANIMAL_ID = "com.verticon.tracker.animal.id";
	private static final String EVENT_ADMIN_PROPERTY_READER_NAME = "com.verticon.tracker.reader.name";
	
	private static final String CONNECTION_URI = "connection.uri";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	private final Logger logger = LoggerFactory
			.getLogger(EIDEventProducer.class);
	private Wire[] wires = new Wire[] {};
	private Map<String, Object> config = null;
	private final AtomicInteger totalEIDs = new AtomicInteger(0);
	private volatile long lastEIDTime = 0;
	private String filter;
	private Long lastEID = Long.valueOf(0);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EIDEventProducer [pid=" + getPid() + ", filter=" + filter + "]";
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
		filter = (String) config.get(FILTER);
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
		filter = null;
	}

	@Override
	public synchronized Object polled(Wire wire) {
		return lastEID;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} consumersConnected with wires={}", this,
				Arrays.toString(wires));
		this.wires = wires;
	}

	private String getOutputScope() {
		return ((String[]) config.get("wireadmin.producer.scope"))[0];
	}

	private void produce(Long in) {
		if (wires != null) {
			Envelope envelope = new BasicEnvelope(in, getPid(),
					getOutputScope());
			logger.debug(bundleMarker, "{}: firing {} to {} wires",
					new Object[] { this, in, wires.length });

			for (Wire wire : wires) {
				wire.update(envelope);
			}
			totalEIDs.incrementAndGet();
			lastEIDTime = System.currentTimeMillis();
			lastEID = in;

		} else {
			logger.warn(bundleMarker,
					"{} defered firing {} because there are no wires", this, in);
		}
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] {
				CONNECTED_CONSUMERS_COUNT, 
				TIME_OF_LAST_EID,
				TOTAL_EID, LAST_EID,
				CONNECTION_URI_STATUS_VAR};
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					wires == null ? 0 : wires.length);
		} else if (LAST_EID.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER, lastEID);
		} else if (TIME_OF_LAST_EID.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastEIDTime == 0 ? new Date(lastEIDTime).toString() : "");
		} else if (TOTAL_EID.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalEIDs.get());
		} else if (CONNECTION_URI_STATUS_VAR.equals(name)){
			String uri = (String) config.get(CONNECTION_URI);
			return
			new StatusVariable(name,
					StatusVariable.CM_DER,
					uri
					);
			
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

		if (TOTAL_EID.equals(name)) {
			totalEIDs.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS_COUNT.equals(id)) {
			return "The number of connected consumer wires.";
		} else if (LAST_EID.equals(id)) {
			return "The last EID sent to consumers.";
		} else if (TIME_OF_LAST_EID.equals(id)) {
			return "The last time an EID was sent to consumers.";
		} else if (TOTAL_EID.equals(id)) {
			return "The total number of EIDs sent to consumers.";
		} else if (CONNECTION_URI_STATUS_VAR.equals(id)){
			return "The URI of the connected gateway.";
		}
		
		return null;
	}

	@Override
	public void handleEvent(Event event) {
		Long id = (Long) event.getProperty(EVENT_ADMIN_PROPERTY_ANIMAL_ID);
		logger.debug(bundleMarker, "{} handling id={} from={}", new Object[] {
				this, id, event.getProperty(EVENT_ADMIN_PROPERTY_READER_NAME) });
		produce(id);
	}

}
