package com.verticon.tracker.store.mongodb.internal.irouter;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;
import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.DEFAULT_ANIMAL;
import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.irouter.premises.common.api.EventCreationException;
import com.verticon.tracker.irouter.premises.common.api.PremisesIRouterUtils;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.TrackerStoreUtils;
import com.verticon.tracker.store.UpdateStats;
import com.verticon.tracker.store.mongodb.internal.Monitor;
import com.verticon.tracker.store.mongodb.internal.UpdateAndFind;

public class ProductHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ProductHandler.class);
	private final Monitor monitorable;
	private final UpdateAndFind updateAndFind;
	private final BlockingQueue<Envelope> queryQueue;


	private Authenticator authenticator;
	private Map<String, Object> config;


	public ProductHandler(Monitor monitorable, UpdateAndFind updateAndFind,
			BlockingQueue<Envelope> queryQueue) {
		this.monitorable = monitorable;
		this.updateAndFind = updateAndFind;
		this.queryQueue = queryQueue;
	}

	/**
	 * The envelope id must be a Long or String object as that will be used for
	 * the Tag id, the envelope scope is the OCD and the envelope contents is
	 * used to create the event.
	 * 
	 * @param envelope
	 * @throws IOException
	 * @throws EventCreationException
	 */
	void handle(final Envelope envelope) {
		String id = null;
		if (envelope.getIdentification() instanceof Long) {
			id = ((Long) envelope.getIdentification()).toString();
		} else if (envelope.getIdentification() instanceof String) {
			id = (String) envelope.getIdentification();
			if (id.endsWith("/Query")) {
				try {
					queryQueue.put(envelope);
					logger.debug(bundleMarker,
							"Put envelope with query topic={}, scope={} queue size={} value={}",
							new Object[] { envelope.getIdentification(),
									envelope.getScope(), queryQueue.size(),
									new String((byte[]) envelope.getValue()) });
				} catch (InterruptedException e) {
					logger.error(
							bundleMarker,
							"Failed to put envelope with query topic={}, scope={}",
							new Object[] { envelope.getIdentification(),
									envelope.getScope() });
					// Restore interrupt flag...
					Thread.currentThread().interrupt();
				}

				return;
			}else if(id.endsWith("/Register/EMF")) {
				logger.debug(bundleMarker,
						"Register Premises topic={}, scope={}",
						envelope.getIdentification(), envelope.getScope());
				Premises premises;
				try {
					premises = TrackerStoreUtils
							.toPremises(envelope.getValue());
					register(premises, id, envelope.getScope());
				} catch (IOException e) {
					logger.error(bundleMarker,
							"Failed to deserialize Premises.", e);
				}

				return;
			}else if(id.endsWith("/Events/EMF")) {
				logger.debug(bundleMarker,
						"Record events topic={}, scope={}",
						envelope.getIdentification(), envelope.getScope());
				Premises premises;
				try {
					premises = TrackerStoreUtils
							.toPremises(envelope.getValue());
					IUpdateStats stats = recordEvents(premises);
					// Create an envelope with the results
					String topicOut = id.replace("Events/EMF", "Response");
					Envelope recordResults = new BasicEnvelope(stats.toString()
							.getBytes(), topicOut, envelope.getScope());
					queryQueue.add(recordResults);

				} catch (IOException e) {
					logger.error(bundleMarker,
							"Failed to deserialize Premises.", e);
				}

				return;
			}
		}

		checkArgument(
				id != null,
				"Failed to handle a message identification. It is neither a Long or a String. Identification="
						+ envelope.getIdentification());
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(id);

		try {
			Event event = PremisesIRouterUtils.createEvent(updateAndFind,
					envelope);
			tag.getEvents().add(event);
			handle(tag);
		} catch (EventCreationException e) {
			String message = "Failed to create OCD for envelope =" + envelope;
			monitorable.add(message, e);
			logger.error(bundleMarker, message, e);
		}

	}

	void handle(Tag tag) {
		Animal animal = createDefaultAnimal(tag);
		try {

			record(animal);
		} catch (IOException e) {
			String message = "Failed to handle tag =" + tag;
			monitorable.add(message, e);
			logger.error(bundleMarker, message, e);
		}
	}

	private void record(Animal animal) throws IOException {
		checkHasRole(getURI());
		logger.debug(bundleMarker, "Recording animal id={}", animal.getId());
		IUpdateStats stats = updateAndFind.record(getURI(),
				newArrayList(animal));
		monitorable.add(stats);
	}

	void handle(Animal animal) {
		try {
			record(animal);
		} catch (IOException e) {
			String message = "Failed to handle " + animal.eClass().getName()
					+ " id=" + animal.getId();
			monitorable.add(message, e);
			logger.error(bundleMarker, message, e);
		}

	}

	private IUpdateStats recordEvents(Premises premises) {
		IUpdateStats stats = null;
		try {
			updateAndFind.checkForRegistratonMembership();
			stats = updateAndFind.recordAnimals(premises);
			monitorable.add(stats);
		} catch (Exception e) {
			String message = "Failed to recordEvents =" + premises.getUri();
			monitorable.add(message, e);
			logger.error(bundleMarker, message, e);
			stats = new UpdateStats();
			((UpdateStats) stats).addException(e);
		}
		return stats;
	}

	void register(Premises premises, String id, String scope) {
		try {
			updateAndFind.checkForRegistratonMembership();
			updateAndFind.register(premises);
			monitorable.incrementTotalPremisesRegisted();
			sendRegisterOK(id, scope);
		} catch (Exception e) {
			String message = "Failed to handle premises =" + premises.getUri();
			monitorable.add(message, e);
			logger.error(bundleMarker, message, e);
			sendRegisterException(e, id, scope);
		}
	}

	private void sendRegisterOK(String id, String scope) {
		if (isNullOrEmpty(id) || isNullOrEmpty(scope)) {
			logger.info(bundleMarker,
					"Not sending a response to the queryQuery because id or scope is empty");
			return;
		}
		String topicOut = id.replace("Register/EMF", "Response");
		Envelope recordResults = new BasicEnvelope("OK".getBytes(), topicOut,
				scope);
		queryQueue.add(recordResults);
	}

	private void sendRegisterException(Exception e, String id, String scope) {
		if (isNullOrEmpty(id) || isNullOrEmpty(scope)) {
			logger.info(bundleMarker,
					"Not sending a response to the queryQuery because id or scope is empty");
			return;
		}
		String topicOut = id.replace("Register/EMF", "Response");
		Envelope recordResults = new BasicEnvelope(e.getLocalizedMessage()
				.getBytes(),
				topicOut, scope);
		queryQueue.add(recordResults);
	}
	/**
	 * @param authenticator
	 *            the authenticator to set
	 */
	void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	/**
	 * @param authenticator
	 *            the authenticator to set
	 */
	void unsetAuthenticator(Authenticator authenticator) {
		this.authenticator = null;
	}

	void activate(Map<String, Object> config) {
		this.config = config;
	}

	void deactivate() {
		config = null;

	}

	private Animal createDefaultAnimal(Tag tag) {
		Integer defaultAnimalKey = com.verticon.tracker.store.TrackerStoreUtils
				.getConfigurationInteger(config.get(DEFAULT_ANIMAL.configID));
		Animal animal = com.verticon.tracker.store.TrackerStoreUtils.createDefaultAnimal(defaultAnimalKey);
		animal.getTags().add(tag);
		return animal;
	}

	private String getURI() {
		return (String) config.get(PREMISES_URI.configID);
	}


	private void checkAuthenticated() {
		boolean allowed = authenticator != null
				&& authenticator.isAuthenticatedUser();
		if (!allowed) {
			throw new SecurityException("User is not authenticated.");
		}
	}

	private void checkHasRole(String uri) {
		checkAuthenticated();
		if (!authenticator.hasRole(uri)) {
			throw new SecurityException(String.format(
					"User has no role authority to access %s premises.", uri));
		}
	}


}
