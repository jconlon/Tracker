/**
 * 
 */
package com.verticon.tracker.irouter.measurement.event.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

/**
 * iRouter Transaction to Tracker Gateway that consumes Measurement, Position
 * and animal EID iRouter envelope products and on a trigger condition sends
 * these as separate Envelopes with ID and value as an EventAdmin Event to
 * Tracker a EventHandler to be converted on the receiving end into separtet
 * Tracker Events.
 * 
 * @author jconlon
 * 
 */
public class MeasurementEventConsumer extends AbstractTransactionHandler
		implements Consumer, Monitorable {
	private static final String IROUTER_PAYLOAD = "com.verticon.tracker.irouter.payload";
	private static final String EVENT_ADMIN_TOPIC = "com/verticon/tracker/event";
	private static final String WIRES_COUNT = "consumer.Connected_Wires";
	private static final String LAST_ID = "consumer.Last_Identification";
	private static final String LAST_SCOPE = "consumer.Last_Scope";
	private static final String LAST_VALUE_SENT = "consumer.Last_Measurement";
	private static final String TOTAL_VALUES_SENT = "consumer.Total_Measurements_Sent";
	private static final String CONNECTION_URI_STATUS_VAR = "consumer.Connection_URI";

	// configs
	private static final String TRIGGER_ON_ID_NAME = "triggeron.eid";
	private static final String CONTROL_STATE_NAME = "consumer.transaction.state";
	private static final String CONTROL_STATE_VALUE = "consumer.transaction.state.value";
	private static final String CONNECTION_URI = "connection.uri";
	private static final String ONLY_SEND_LAST_ENVELOPE = "onlysend.last.envelope";

	private final AtomicInteger wiresConnected = new AtomicInteger(0);
	private final AtomicInteger totalMeasurements = new AtomicInteger(0);
	private boolean triggerOnID = false;
	private boolean onlySendLastEnvelope = false;
	private Map<String, Object> config = null;
	private EventAdmin eventAdmin = null;
	private Envelope lastEnvelope = null;
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.event";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MeasurementEventConsumer.class);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	public MeasurementEventConsumer() {
		super(LoggerFactory.getLogger(MeasurementEventConsumer.class), null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MeasurementEventConsumer [config=" + config + "]";
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		this.config = config;
		log.debug(bundleMarker, "Activating...");
		for (Map.Entry<String, Object> entry : config.entrySet()) {
			log.debug(bundleMarker, "Property key={} value={}", entry.getKey(),
					entry.getValue());
		}
		this.triggerOnID = getConfigBoolean(TRIGGER_ON_ID_NAME);
		this.onlySendLastEnvelope = getConfigBoolean(ONLY_SEND_LAST_ENVELOPE);

		this.state = new State(getConfigInteger(CONTROL_STATE_VALUE),
				getConfigString(CONTROL_STATE_NAME));

	}

	private String getConfigString(String key) {
		return (String) config.get(key);
	}

	private Integer getConfigInteger(String key) {
		Object conf = config.get(key);
		if (conf instanceof String) {
			return new Integer((String) conf);
		}
		return (Integer) conf;
	}

	private Boolean getConfigBoolean(String key) {
		Object conf = config.get(key);
		if (conf == null) {
			return false;
		} else if (conf instanceof String) {
			return new Boolean((String) conf);
		}
		return (Boolean) conf;
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		this.config.clear();
		log.debug(bundleMarker, "deactivating...");
	}

	/**
	 * Declaratives Services service injection point
	 * 
	 * @param eventAdmin
	 */
	void setEventAdmin(EventAdmin eventAdminService) {
		this.eventAdmin = eventAdminService;
	}

	/**
	 * Declaratives Services service injection point .
	 * 
	 * @param eventAdmin
	 */
	void unsetEventAdmin(EventAdmin eventAdminService) {
		this.eventAdmin = null;
	}

	@Override
	public void updated(Wire wire, Object in) {
		log.debug(bundleMarker, "Invoked updated with value={}", in);
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			add(envelope);
		} else {
			log.error(bundleMarker,
					"Unknown object={} was received from wire scope={}", in,
					Arrays.toString(wire.getScope()));
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		log.debug(bundleMarker, "Invoked producerConnected with wires={}",
				Arrays.toString(wires));
		wiresConnected.set(wires != null ? wires.length : 0);
	}

	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}

	@Override
	protected void triggered() {
		List<Envelope> results = getEnvelopesForOutput();
		for (Envelope envelope : results) {
			output(envelope);
		}
	}

	private List<Envelope> getEnvelopesForOutput() {
		List<Envelope> results = new ArrayList<Envelope>();

		for (Envelope envelope : envelopes.values()) {
			if ((envelope.getValue() instanceof Measurement)
					|| (envelope.getValue() instanceof Position)) {
				if (envelope.getIdentification() instanceof String
						&& ((String) envelope.getIdentification()).trim()
								.length() > 1) {
					results.add(envelope);
				} else if (id != null) {
					results.add(addId(envelope, id));
				} else {
					logger.warn(
							bundleMarker,
							"{} deferred adding {} because the id was not set in this gateway or in the measurements envelope.",
							this, envelope);
				}
			}
		}
		Collections.sort(results, ENVELOPE_DATE_ORDER2);
		return results;
	}

	protected static final Comparator<Envelope> ENVELOPE_DATE_ORDER2 = new Comparator<Envelope>() {
		public int compare(Envelope e1, Envelope e2) {
			if (getTime(e1) < getTime(e2)) {
				return -1;// returning a negative integer, first argument is
							// less than second
			} else if (getTime(e1) == getTime(e2)) {
				return 0;// 0, equal to, or
			}
			return 1; // a positive integer depending on whether the , greater
						// than the second.
		}

		long getTime(Envelope e) {
			long result = 0;
			if (e.getValue() instanceof Position
					&& ((Position) e.getValue()).getLatitude() != null) {
				result = ((Position) e.getValue()).getLatitude().getTime();
			} else if (e.getValue() instanceof Measurement) {
				result = ((Measurement) e.getValue()).getTime();
			}
			return result;
		}
	};

	private static Envelope addId(Envelope envelope, Long id) {
		return new BasicEnvelope(envelope.getValue(), id.toString(),
				envelope.getScope());
	}

	/**
	 * Output the measurement as a MeasurementTransaction to the eventAdmin
	 * topic that is common to the iRouter and the Tracker
	 * 
	 * @param scope
	 * @param envelope
	 * @param id
	 */
	private void output(Envelope envelope) {
		Map<String, Object> table = new HashMap<String, Object>();
		table.put(IROUTER_PAYLOAD, envelope);
		table.put(Constants.BUNDLE_SYMBOLICNAME,
				FrameworkUtil.getBundle(this.getClass()).getSymbolicName());

		if (eventAdmin != null) {
			eventAdmin.postEvent(new Event(EVENT_ADMIN_TOPIC, table));
			int i = totalMeasurements.incrementAndGet();
			lastEnvelope = envelope;
			log.info(bundleMarker, "{} sent {} #{} to the event service",
					new Object[] { this, envelope, i });
		} else {
			log.warn(bundleMarker, "{} failed to find EventAdmin service", this);
		}
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { WIRES_COUNT, LAST_VALUE_SENT, LAST_ID,
				LAST_SCOPE, TOTAL_VALUES_SENT, CONNECTION_URI_STATUS_VAR };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (WIRES_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					wiresConnected.get());
		} else if (LAST_VALUE_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastEnvelope != null ? lastEnvelope.getValue().toString()
							: "");
		} else if (LAST_ID.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastEnvelope != null ? lastEnvelope.getIdentification()
							.toString() : "");

		} else if (LAST_SCOPE.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastEnvelope != null ? lastEnvelope.getScope() : "");
		} else if (TOTAL_VALUES_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalMeasurements.get());
		} else if (CONNECTION_URI_STATUS_VAR.equals(name)) {
			String uri = (String) config.get(CONNECTION_URI);
			return new StatusVariable(name, StatusVariable.CM_DER, uri);
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

		if (TOTAL_VALUES_SENT.equals(name)) {
			totalMeasurements.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if (WIRES_COUNT.equals(id)) {
			return "The number of connected wires.";
		} else if (LAST_VALUE_SENT.equals(id)) {
			return "The last measurement sent to the Tracker transaction editor.";
		} else if (LAST_ID.equals(id)) {
			return "The identification associated with the last measurement sent to the Tracker transaction editor.";
		} else if (LAST_SCOPE.equals(id)) {
			return "The scope of the last measurement sent to the Tracker transaction editor.";
		} else if (TOTAL_VALUES_SENT.equals(id)) {
			return "The total numver of measurements sent to the Tracker transaction editor.";
		} else if (CONNECTION_URI_STATUS_VAR.equals(id)) {
			return "The URI of the connected gateway.";
		}
		return null;
	}

	/**
	 * Overrides the superclass to add all Position and Measurement types of
	 * envelopes and to allow for triggering on eids.
	 * 
	 * @see com.verticon.tracker.irouter.common.AbstractTransactionHandler#add(org.osgi.service.wireadmin.Envelope)
	 */
	@Override
	public void add(Envelope envelope) {
		if ((envelope.getValue() instanceof State) && (!triggerOnID)) {
			if (state == null) {
				if (((State) envelope.getValue()).getValue() == 1) {
					forwardConditionMet();
				}
			} else if (state.equals(envelope.getValue())) {
				forwardConditionMet();
			}
		} else if (envelope.getValue() instanceof Long) {
			id = (Long) envelope.getValue();

			log.debug(bundleMarker(), "{} ID={}", this, id);
			if (triggerOnID) {
				forwardConditionMet();
			}
		} else if ((envelope.getValue() instanceof Measurement)
				|| (envelope.getValue() instanceof Position)) {

			if (onlySendLastEnvelope) {
				envelopes.clear();
				log.debug(
						bundleMarker(),
						"Adding last envelope -  id={}, scope={} value={}",
						new Object[] { id, envelope.getScope(),
								envelope.getValue() });
			} else {
				log.debug(
						bundleMarker(),
						"Adding to cached envelopes -  id={}, scope={}, value={}, cache size={}",
						new Object[] { id, envelope.getScope(),
								envelope.getValue(), envelopes.size() });
			}
			envelopes.put(envelope.getScope(), envelope);
		} else {
			log.warn(
					bundleMarker(),
					"id={}, scope={} has unsupported value of {}",
					new Object[] { id, envelope.getScope(), envelope.getValue() });
		}
	}

	private void forwardConditionMet() {
		triggered();
		envelopes.clear();
		id = null;
	}

}
