/**
 * 
 */
package com.verticon.tracker.irouter.premises.event.internal;

import static com.verticon.tracker.irouter.premises.common.api.PremisesIRouterUtils.prepareEnvelopesForOutput;
import java.util.Arrays;
import java.util.List;
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
import org.osgi.util.position.Position;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

/**
 * Consumes Measurement, Position and animal EID iRouter envelopes and on a
 * trigger condition re-produces these envelopes with identification of the
 * envelopes set to the Animal EID value.
 * 
 * @author jconlon
 * 
 */
public class EventTransactionConsumer extends AbstractTransactionHandler
		implements Consumer, Producer, Monitorable {

	static String PLUGIN_ID = "com.verticon.tracker.irouter.premises.event";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	// vars
	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String LAST_ID = "consumer.Last_Identification";
	private static final String LAST_SCOPE = "consumer.Last_Scope";
	private static final String LAST_EVENT_SENT = "consumer.Last_Event";
	private static final String TOTAL_EVENTS_SENT = "consumer.Total_Events_Sent";
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger consumersConnected = new AtomicInteger(0);
	private final AtomicInteger totalMeasurements = new AtomicInteger(0);
	private Envelope lastEnvelope = null;

	// configs
	private static final String TRIGGER_ON_ID_NAME = "triggeron.eid";
	private static final String CONTROL_STATE_NAME = "consumer.transaction.state";
	private static final String CONTROL_STATE_VALUE = "consumer.transaction.state.value";
	private static final String ONLY_SEND_LAST_ENVELOPE = "onlysend.last.envelope";
	private Map<String, Object> config = null;
	private boolean triggerOnID = false;
	private boolean onlySendLastEnvelope = false;

	// producer
	private final PremisesEventProducer transactionProducer = new PremisesEventProducer();

	public EventTransactionConsumer() {
		super(LoggerFactory.getLogger(EventTransactionConsumer.class), null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EventTransactionConsumer [config=" + config + "]";
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
	
	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		triggerOnID=false;
		onlySendLastEnvelope=false;
		state = null;
		log.debug(bundleMarker, "deactivating...");
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

	

	@Override
	public void updated(Wire wire, Object in) {

		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			log.debug(bundleMarker, "Consuming {} with envelope scope {}",
					envelope.getValue(), envelope.getScope());
			add(envelope);
		} else {
			log.error(bundleMarker,
					"Unknown object={} was received from wire scope={}", in,
					Arrays.toString(wire.getScope()));
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		log.debug(bundleMarker, "Invoked producersConnected with wires={}",
				Arrays.toString(wires));
		producersConnected.set(wires != null ? wires.length : 0);
	}

	@Override
	public Object polled(Wire wire) {
		return transactionProducer.polled(wire);
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		transactionProducer.consumersConnected(wires);
		log.debug(bundleMarker, "Invoked consumersConnected with wires={}",
				Arrays.toString(wires));
		consumersConnected.set(wires != null ? wires.length : 0);
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { CONNECTED_PRODUCERS_COUNT,
				CONNECTED_CONSUMERS_COUNT, LAST_EVENT_SENT, LAST_ID,
				LAST_SCOPE, TOTAL_EVENTS_SENT };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					producersConnected.get());
		} else if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					consumersConnected.get());
		} else if (LAST_EVENT_SENT.equals(name)) {
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
		} else if (TOTAL_EVENTS_SENT.equals(name)) {
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

		if (TOTAL_EVENTS_SENT.equals(name)) {
			totalMeasurements.set(0);
			return true;
		}
		// if (LAST_EVENT_SENT.equals(name)){
		// lastEnvelope = null;
		// return true;
		// }

		return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if (CONNECTED_PRODUCERS_COUNT.equals(id)) {
			return "The number of producer connected wires.";
		} else if (CONNECTED_CONSUMERS_COUNT.equals(id)) {
			return "The number of consumer connected wires.";
		} else if (LAST_EVENT_SENT.equals(id)) {
			return "The last measurement sent to the Tracker transaction editor.";
		} else if (LAST_ID.equals(id)) {
			return "The identification associated with the last measurement sent to the Tracker transaction editor.";
		} else if (LAST_SCOPE.equals(id)) {
			return "The scope of the last measurement sent to the Tracker transaction editor.";
		} else if (TOTAL_EVENTS_SENT.equals(id)) {
			return "The total numver of measurements sent to the Tracker transaction editor.";
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

			log.debug(bundleMarker(), "Set id={}",  id);
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

	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}

	@Override
	protected void triggered() {
		if(id==null){
			log.debug(bundleMarker,"Ignoring trigger because id is null.");
			return;
		}
		
		List<Envelope> results = prepareEnvelopesForOutput(envelopes.values(),
				id);
		log.debug(bundleMarker,"Forwarding {} envelopes with id={}.",  results.size(), id);
		for (Envelope envelope : results) {
			output(envelope);
		}
	}

	/**
	 * Output the event in an envelope that is tagged with the ID associated
	 * with the Transaction to the EventProducer
	 * 
	 * @param envelope
	 */
	private void output(Envelope envelope) {
		transactionProducer.produce(envelope);
		int i = totalMeasurements.incrementAndGet();
		lastEnvelope = envelope;
		log.info(bundleMarker,
				"Sent envelope #{} of type={} and id={} to the producer service with scope {}",
				new Object[] { i, envelope.getValue().getClass().getSimpleName(), id, envelope.getScope() });
	}

	private void forwardConditionMet() {
		triggered();
		envelopes.clear();
		id = null;
	}

}
