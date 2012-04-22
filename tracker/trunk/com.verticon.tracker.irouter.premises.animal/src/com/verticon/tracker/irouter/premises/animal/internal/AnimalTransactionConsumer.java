/**
 * 
 */
package com.verticon.tracker.irouter.premises.animal.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.verticon.tracker.irouter.premises.common.api.PremisesIRouterUtils.getXMIResource;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.osgi.util.measurement.State;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

/**
 * References an Animal template premises document; consumes Animal EID iRouter
 * envelopes and State products; and on a trigger condition produces an Envelope
 * with an Animal value with it's event history given the timestamp at
 * production and with an envelope identification set to the Animal EID value.
 * 
 * @author jconlon
 * 
 */
public class AnimalTransactionConsumer extends AbstractTransactionHandler
		implements Consumer, Producer, Monitorable {

	static String PLUGIN_ID = "com.verticon.tracker.irouter.premises.animal";
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
	private static final String LAST_ANIMAL_SENT = "consumer.Last_Animal";
	private static final String TOTAL_ANIMALS_SENT = "consumer.Total_Animals_Sent";
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger consumersConnected = new AtomicInteger(0);
	private final AtomicInteger totalAnimals = new AtomicInteger(0);
	private Envelope lastEnvelope = null;

	// configs
	private static final String ANIMAL_TEMPLATE_URI = "animal.template.uri";
	private static final String TRIGGER_ON_ID_NAME = "triggeron.eid";
	private static final String CONTROL_STATE_NAME = "consumer.transaction.state";
	private static final String CONTROL_STATE_VALUE = "consumer.transaction.state.value";
	private Map<String, Object> config = null;
	private boolean triggerOnID = false;
	private Animal animalTemplate = null;
	private String scope = null;

	// producer
	private final PremisesAnimalProducer transactionProducer = new PremisesAnimalProducer();

	public AnimalTransactionConsumer() {
		super(LoggerFactory.getLogger(AnimalTransactionConsumer.class), null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnimalTransactionConsumer [config=" + config + "]";
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
		this.animalTemplate = getAnimal(getConfigString(ANIMAL_TEMPLATE_URI));
		this.scope = getProducerScope();
		this.triggerOnID = getConfigBoolean(TRIGGER_ON_ID_NAME);

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
		this.config.clear();
		animalTemplate = null;
		log.debug(bundleMarker, "deactivating...");
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
		log.debug(bundleMarker, "{} producers connected",
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
		log.debug(bundleMarker, "{} consumers connected",
				Arrays.toString(wires));
		consumersConnected.set(wires != null ? wires.length : 0);
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { CONNECTED_PRODUCERS_COUNT,
				CONNECTED_CONSUMERS_COUNT, LAST_ANIMAL_SENT, LAST_ID,
				LAST_SCOPE, TOTAL_ANIMALS_SENT };
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
		} else if (LAST_ANIMAL_SENT.equals(name)) {
			Animal animal = null;
			if (lastEnvelope != null) {
				animal = (Animal) lastEnvelope.getValue();
			}

			return new StatusVariable(name, StatusVariable.CM_DER,
					animal != null ? animal.eClass().getName() : "");
		} else if (LAST_ID.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastEnvelope != null ? lastEnvelope.getIdentification()
							.toString() : "");

		} else if (LAST_SCOPE.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastEnvelope != null ? lastEnvelope.getScope() : "");
		} else if (TOTAL_ANIMALS_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalAnimals.get());

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
		if (TOTAL_ANIMALS_SENT.equals(name)) {
			totalAnimals.set(0);
			return true;
		}

		return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if (CONNECTED_PRODUCERS_COUNT.equals(id)) {
			return "The number of producer connected wires.";
		} else if (CONNECTED_CONSUMERS_COUNT.equals(id)) {
			return "The number of consumer connected wires.";
		} else if (LAST_ANIMAL_SENT.equals(id)) {
			return "The last measurement sent to the Tracker transaction editor.";
		} else if (LAST_ID.equals(id)) {
			return "The identification associated with the last measurement sent to the Tracker transaction editor.";
		} else if (LAST_SCOPE.equals(id)) {
			return "The scope of the last measurement sent to the Tracker transaction editor.";
		} else if (TOTAL_ANIMALS_SENT.equals(id)) {
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
		log.debug(bundleMarker,"Forwarding animal id={}.", id);
		Animal animal = EcoreUtil.copy(animalTemplate);
		animal.activeTag().setId(id.toString());
		for (Event event : animal.activeTag().getEvents()) {
			event.setDateTime(new Date());
		}
		
		output(animal);

	}

	private Animal getAnimal(String uri) {
		checkNotNull(uri);
		Resource resource = getXMIResource(uri);
		if (resource.getContents().isEmpty()
				|| !(resource.getContents().get(0) instanceof Animal)) {
			throw new IllegalStateException(
					"Could not find an animal template at " + uri);
		}
		return (Animal) resource.getContents().get(0);
	}

	private String getConfigString(String key) {
		return (String) config.get(key);
	}

	private String getProducerScope() {
		String[] scope = (String[]) config
				.get(WireConstants.WIREADMIN_PRODUCER_SCOPE);
		return scope[0];
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
	 * Output the event in an envelope that is tagged with the ID associated
	 * with the Transaction to the EventProducer
	 * 
	 * @param envelope
	 */
	private void output(Animal animal) {
		Envelope envelope = new BasicEnvelope(animal, id.toString(), scope);
		transactionProducer.produce(envelope);
		int i = totalAnimals.incrementAndGet();
		lastEnvelope = envelope;
		log.info(bundleMarker,
				"Sent animal #{} of type={} and id={} to the producer service with scope {}",
				new Object[] { i, animal.eClass().getName(), id, envelope.getScope() });
	}

	private void forwardConditionMet() {
		triggered();
		envelopes.clear();
		id = null;
	}

}
