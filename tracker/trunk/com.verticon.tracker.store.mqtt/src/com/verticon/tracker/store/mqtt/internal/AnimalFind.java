package com.verticon.tracker.store.mqtt.internal;

import static com.verticon.tracker.store.Query.RETRIEVE_ANIMAL_TEMPLATE;
import static com.verticon.tracker.store.mqtt.internal.MQTTTrackerStore.bundleMarker;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.verticon.tracker.Animal;
import com.verticon.tracker.store.TrackerStoreUtils;

public class AnimalFind {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(AnimalFind.class);
	private final BlockingQueue<MqttMessage> receiveQueue;
	private final Client client;
	private int waitSecondsForResponse;

	public AnimalFind(Client client, BlockingQueue<MqttMessage> receiveQueue) {
		this.client = client;
		this.receiveQueue = receiveQueue;

	}

	public Animal retrieveAnimal(String ain) {
		String query = RETRIEVE_ANIMAL_TEMPLATE.replace(ain);
		Optional<Animal> op;
		MqttMessage responseMessage = null;
		try {
			receiveQueue.clear();
			client.publish(client.getQueryTopic(), 2, query.getBytes());
			responseMessage = receiveQueue.poll(waitSecondsForResponse,
					TimeUnit.SECONDS);
			logger.debug(bundleMarker, "Received {} byte response.",
					responseMessage.getPayload().length);
			op = TrackerStoreUtils.getAnimal(responseMessage.getPayload());

		} catch (IOException e) {
			if (responseMessage != null && responseMessage.getPayload() != null) {
				throw new IllegalStateException(new String(
						responseMessage.getPayload()));
			}
			op = Optional.absent();
			logger.error(bundleMarker, "Unable to retreive Animal " + ain, e);
		} catch (Exception e) {
			op = Optional.absent();
			logger.error(bundleMarker, "Unable to retreive Animal " + ain, e);
		}

		logger.debug(bundleMarker, "Retreive animal {}", op);
		return op.orNull();
	}

	void invalidateCacheEntry(Animal animal) {
		// TODO
	}

	void activate(Map<String, Object> config) {
		waitSecondsForResponse = StatusAndConfigVariables
				.getWaitSecondsForRespsonse(config);
	}

	void deactivate() {
		// DO nothing
	}

}
