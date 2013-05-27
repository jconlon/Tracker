package com.verticon.tracker.store.mongodb.internal.consumer;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;
import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.DEFAULT_ANIMAL;
import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.internal.consumer.MongoDBConsumer.bundleMarker;

import java.io.IOException;
import java.util.Map;

import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.irouter.premises.common.api.EventCreationException;
import com.verticon.tracker.irouter.premises.common.api.PremisesIRouterUtils;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.mongodb.internal.Monitor;
import com.verticon.tracker.store.mongodb.internal.UpdateAndFind;

public class ProductHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ProductHandler.class);
	private final Monitor monitorable;
	private final UpdateAndFind updateAndFind;


	private Authenticator authenticator;
	private Map<String, Object> config;


	public ProductHandler(Monitor monitorable, UpdateAndFind updateAndFind) {
		this.monitorable = monitorable;
		this.updateAndFind = updateAndFind;
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
		logger.debug(bundleMarker, "Handling id={}, value={}",
				envelope.getIdentification(), envelope.getValue());
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		String id = null;
		if (envelope.getIdentification() instanceof Long) {
			id = ((Long) envelope.getIdentification()).toString();
		} else if (envelope.getIdentification() instanceof String) {
			id = (String) envelope.getIdentification();
		}

		checkArgument(
				id != null,
				"Failed to handle a message identification. It is neither a Long or a String. Identification="
						+ envelope.getIdentification());
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
		Integer defaultAnimalKey = com.verticon.tracker.store.mongodb.internal.Utils.getConfigurationInteger(config
.get(DEFAULT_ANIMAL.configID));
		Animal animal = com.verticon.tracker.store.mongodb.internal.Utils.createDefaultAnimal(defaultAnimalKey);
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
