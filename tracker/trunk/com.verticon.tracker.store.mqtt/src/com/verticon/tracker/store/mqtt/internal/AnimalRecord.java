package com.verticon.tracker.store.mqtt.internal;

import static com.google.common.collect.Lists.newArrayList;
import static com.verticon.tracker.store.Query.LAST_PUB_QUERY_TEMPLATE;
import static com.verticon.tracker.store.mqtt.internal.MQTTTrackerStore.bundleMarker;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.bson.BSONObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.mongodb.util.JSON;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.TrackerStoreUtils;
import com.verticon.tracker.store.UpdateStats;

public class AnimalRecord {

	private static final Calendar beforeFirstCalendar;
	static {
		beforeFirstCalendar = GregorianCalendar.getInstance();
		beforeFirstCalendar.set(1776, 6, 4, 0, 0, 1);
	}
	private static final Date beforeFirstDate = beforeFirstCalendar.getTime();

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(AnimalRecord.class);

	private final Client client;
	private final BlockingQueue<MqttMessage> receiveQueue;
	private final AnimalFind animalFind;

	private int waitSecondsForResponse;

	public AnimalRecord(Client client, BlockingQueue<MqttMessage> receiveQueue,
			AnimalFind animalFind) {
		this.client = client;
		this.receiveQueue = receiveQueue;
		this.animalFind = animalFind;
	}

	public IUpdateStats record(Premises premises) throws IOException {
		String uri = premises.getUri();
		List<Animal> animals = premises.getAnimals();
		return record(uri, animals);
	}

	public IUpdateStats record(String uri, List<Animal> animals)
			throws IOException {
		// Find out the latest update
		Date lastUpdate = getLastPublishDate(uri);
		if (lastUpdate == null) {
			lastUpdate = beforeFirstDate;
			logger.debug(bundleMarker,
					"First time publishing, setting date to {}", lastUpdate);
		} else {
			logger.debug(bundleMarker, "Last publish date: {}", lastUpdate);
		}
		// Get all the animals that need to be processed
		Iterable<Animal> animalsWithNewAndUnpublishedEvents = Iterables.filter(
				animals,
				new TrackerStoreUtils.AnimalsWithNewAndUnpublishedEvents(
						lastUpdate));
		if (Iterables.isEmpty(animalsWithNewAndUnpublishedEvents)) {
			String message = String
					.format("There are no new animal events since last publish date: %s",
							lastUpdate);
			logger.debug(
					bundleMarker,
 message);
			UpdateStats result = new UpdateStats();
			result.setComment(message);
			return result;
		}

		try {

			return publishAnimalsAndEvents(uri, lastUpdate,
					animalsWithNewAndUnpublishedEvents);
		} catch (Exception e) {
			throw new IOException(
					"Failed to get repsonse for event recording of premises"
							+ uri, e);
		}
	}

	/**
	 * Query for the last date the premises animal histories were published.
	 * Query is in the form of a MongoDB aggregation string.
	 * 
	 * 
	 * @param uri
	 * @return
	 * @throws IOException
	 */
	private Date getLastPublishDate(String uri) throws IOException {
		Date result = null;
		String query = LAST_PUB_QUERY_TEMPLATE.replace(uri);
		String responseString = client.query(query);
		// System.out.println(responseString);
		BSONObject response = (BSONObject) JSON.parse(responseString);
		List<?> list = (List<?>) response.get("result");
		if (!list.isEmpty()) {
			response = (BSONObject) list.get(0);
			logger.debug(bundleMarker, "Last Publish Date Response: {}",
					response);
			// System.out.println(response);
			result = (Date) response.get("update");

		}
		return result;
	}

	private IUpdateStats publishAnimalsAndEvents(String uri, Date lastUpdate,
			Iterable<Animal> animalsWithNewAndUnpublishedEvents)
			throws IOException {
		Collection<Animal> copyOfAnimals = EcoreUtil
				.copyAll(newArrayList(animalsWithNewAndUnpublishedEvents));
		List<EObject> ocds = newArrayList();
		UpdateStats results = new UpdateStats();
		// Remove all the events that are older that the lastUpdate
		for (Animal animal : copyOfAnimals) {
			for (Tag tag : animal.getTags()) {
				Iterator<Event> i = tag.getEvents().iterator();
				while (i.hasNext()) {
					Event event = i.next();
					if (event.getDateTime().before(lastUpdate)) {
						i.remove();
					} else {
						results.eventsAdded(1);
						if (event instanceof GenericEvent) {
							GenericEvent ge = (GenericEvent) event;
							OCD ocd = ge.getOcd();
							ocds.add(ocd);
						}
					}

				}

			}
			if (animal.eventHistory().size() > 0) {
				results.animalsAdded(1);
			}

		}
		logger.debug(bundleMarker, "Preliminary expected stats: {}", results);

		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		premises.setUri(uri);
		premises.getAnimals().addAll(copyOfAnimals);
		List<EObject> list = newArrayList();

		list.add(premises);
		list.addAll(ocds);

		try {
			receiveQueue.clear();
			IMqttDeliveryToken token = client.publish(
					client.getAnimalRecordPublishTopic(), 2, list);
			token.waitForCompletion();
			MqttMessage responseMessage = receiveQueue.poll(
					waitSecondsForResponse, TimeUnit.SECONDS);
			if (responseMessage.getPayload() == null) {
				throw new IOException(
						"Record Animals Response payload was null. ");
			}
			String response = new String(responseMessage.getPayload());
			logger.debug(bundleMarker,
					"Record Animals Response payload was {}", response);
			IUpdateStats result = new UpdateStats(response);
			if (result.getExceptions().isEmpty()) {
				for (Animal animal : premises.getAnimals()) {
					animalFind.invalidateCacheEntry(animal);
				}
			}
			return result;

		} catch (InterruptedException e) {
			logger.error(bundleMarker,
					"Failed to record events " + premises.getUri(), e);
			// Restore the interrupted status
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			logger.error(bundleMarker,
					"Failed to record events " + premises.getUri(), e);
			throw new IOException(e);

		}
		return null;
	}

	void activate(Map<String, Object> config) {
		waitSecondsForResponse = StatusAndConfigVariables
				.getWaitSecondsForRespsonse(config);
	}

	void deactivate() {
		// DO nothing
	}

}
