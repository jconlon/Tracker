package com.verticon.tracker.store.mqtt.internal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.verticon.tracker.store.mqtt.internal.MQTTTrackerStore.bundleMarker;
import static com.verticon.tracker.store.mqtt.internal.StatusAndConfigVariables.getServerName;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.ITrackerUpdate;
import com.verticon.tracker.store.IUpdateStats;

public class UpdateAndFind implements ITrackerUpdate, ITrackerFind {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(UpdateAndFind.class);

	BlockingQueue<MqttMessage> receiveQueue = new ArrayBlockingQueue<MqttMessage>(
			1);

	private final Client client = new Client(receiveQueue);

	private final AnimalFind animalFind = new AnimalFind(client, receiveQueue);
	private final AnimalRecord animalRecord = new AnimalRecord(client,
			receiveQueue, animalFind);
	// private final OCDFind oCDFind = new OCDFind(client);
	private final PremisesFind premisesFind = new PremisesFind(client,
			receiveQueue);
	private final MQTTTrackerStore mQTTTrackerStore;
	private int waitSecondsForResponse;

	UpdateAndFind(MQTTTrackerStore mQTTTrackerStore) {
		this.mQTTTrackerStore = mQTTTrackerStore;
	}

	@Override
	public void register(Premises premises) throws IOException {
		Premises targetPremises = EcoreUtil.copy(premises);
		targetPremises.getAnimals().clear();
		targetPremises.getUnAppliedTags().clear();
		logger.debug(bundleMarker, "Publishing Premises {} to topic {}",
				targetPremises.getUri(),
				client.getPremisesRegisterPublishTopic());
		try {
			receiveQueue.clear();
			IMqttDeliveryToken token = client
					.publish(client.getPremisesRegisterPublishTopic(), 2,
							targetPremises);
			token.waitForCompletion();
			MqttMessage responseMessage = receiveQueue.poll(
					waitSecondsForResponse, TimeUnit.SECONDS);
			if (responseMessage == null) {
				throw new IOException(
						"Registration request failed. There was no response to the registration request. ");
			}
			if (responseMessage.getPayload() == null) {
				throw new IOException(
						"Registration request failed. The response to the registration request was empty null.");
			}
			String response = new String(responseMessage.getPayload());
			if (response.equals("OK")) {
				return;
			}
			throw new IOException("Registration request failed. " + response);

		} catch (MqttException e) {
			logger.error(bundleMarker, "Failed to register premises "
					+ targetPremises.getUri(), e);
			throw new IOException(e);
		} catch (InterruptedException e) {
			logger.error(bundleMarker, "Failed to register premises "
					+ premises.getUri(), e);
			// Restore the interrupted status
			Thread.currentThread().interrupt();
		}
		premisesFind.invalidateCachedObject(targetPremises.getUri());

	}

	@Override
	public IUpdateStats recordAnimals(Premises premises) throws IOException {
		return animalRecord.record(premises);
	}

	@Override
	public IUpdateStats record(String uri, List<Animal> animals)
			throws IOException {
		return animalRecord.record(uri, animals);
	}

	@Override
	public Animal retrieveAnimal(String ain) {
		return animalFind.retrieveAnimal(ain);
	}

	@Override
	public Premises retrievePremises(String premisesUri) throws IOException {
		return premisesFind.find(premisesUri);
	}

	@Override
	public Premises retrievePremises(String premisesUri, String fromDate,
			String toDate) throws IOException {
		return premisesFind.find(premisesUri, fromDate, toDate);
	}

	/**
	 * 
	 * db.Premises.find( { "location.loc" : { $near :
	 * [-90.95048182270057,43.47622307339506,0 ] , $maxDistance : 1 } } )
	 * 
	 * 
	 * @param point
	 * @return Premises
	 * @throws IOException
	 */
	@Override
	public Premises retrievePremises(LongLatPoint point) throws IOException {
		return premisesFind.retrievePremises(point);
	}

	@Override
	public Premises retrievePremises(LongLatPoint point, String fromDate,
			String toDate) throws IOException {
		return premisesFind.retrievePremises(point, fromDate, toDate);
	}

	// @Override
	// public OCD find(String id) {
	// return oCDFind.find(id);
	// }

	@Override
	public String uri() {
		return getServerName(mQTTTrackerStore.getConfig());
	}

	@Override
	public Map<String, String> getPremisesNames(Set<String> uris) {
		return premisesFind.getPremisesNames(uris);
	}

	@Override
	public String query(String query) throws IOException {
		checkNotNull(query, "Query argument must not be null.");
		checkArgument(query.startsWith("{aggregate"),
				"Only aggregation commands are supported.");
		return client.query(query);
	}

	void activate(Map<String, Object> config) throws IOException {
		waitSecondsForResponse = StatusAndConfigVariables
				.getWaitSecondsForRespsonse(config);
		client.activate(config);
		// Create the connection
		premisesFind.activate(config);
		animalFind.activate(config);
		animalRecord.activate(config);
		// oCDFind.activate();
	}

	void deactivate() {
		animalFind.deactivate();
		// oCDFind.deactivate();
		premisesFind.deactivate();
		client.deactivate();
	}

}
