package com.verticon.tracker.irouter.mqtt.test.system;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.irouter.mqtt.test.system.Configurator.bundleMarker;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockSubscriberPublisher implements MqttCallback, ISubscriberPublisher {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockSubscriberPublisher.class);

	private MqttAsyncClient client = null;
	private MqttConnectOptions conOpt;
	private final Map<String, MqttMessage> messages = newHashMap();
	private ISubscriberListener listener;
	private final String TOPIC = "Agriculture/Premises/+/Response";// "AgriculturePremises/+/+/EMF";
	private Dictionary properties;

	void activate(ComponentContext context) throws Exception {
		properties = context.getProperties();

		String brokerUrl = Configurator.localProps
				.getProperty("connection.uri");

		createClient(brokerUrl,
				"verticon.com.testing", true,
				null, null);
		client.setCallback(this);
		IMqttToken token = client.connect(conOpt);
		token.waitForCompletion();
		client.subscribe(TOPIC, 2);
		logger.debug(bundleMarker, "Client {} subscribed to topic {}",
				client.getClientId(), TOPIC);
	}

	void deactivate() throws Exception {
		logger.debug(bundleMarker, "Deactivating.");
		if (client != null) {
			if (client.isConnected()) {
				IMqttToken discToken = client.disconnect();
				// logger.debug(bundleMarker,
				// "Waiting for disconnection of client.");
				// // discToken.waitForCompletion(10);
				logger.debug(bundleMarker, "Disconnected client.");
			}
			client.close();
			logger.debug(bundleMarker, "Closed client.");
		}

		listener = null;
		logger.debug(bundleMarker, "Deactivated.");
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.mqtt.test.system.ISubscriberPublisher#messages()
	 */
	@Override
	public Map<String, MqttMessage> messages() {
		return messages;
	}

	private void createClient(String brokerUrl, String clientId, boolean clean,
			String userName, String password) throws MqttException {

		checkNotNull(brokerUrl, "BrokerUrl can not be null");
		checkNotNull(clientId, "ClientId can not be null");
		// stores in a temporary directory... where messages
		// temporarily stored until the message has been delivered to the
		// server.
		// ..a real application ought to store them somewhere
		// where they are not likely to get deleted or tampered with
		String tmpDir = System.getProperty("java.io.tmpdir");
		MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(
				tmpDir + "/persist");

		// Construct the connection options object that contains connection
		// parameters
		// such as cleansession and LWAT
		conOpt = new MqttConnectOptions();
		conOpt.setCleanSession(clean);
		if (password != null) {
			conOpt.setPassword(password.toCharArray());
		}
		if (userName != null) {
			conOpt.setUserName(userName);
		}

		// Construct an MQTT blocking mode client
		client = new MqttAsyncClient(brokerUrl, clientId, dataStore);

		// Set this wrapper as the callback handlerMQTTBridgeProducer
		client.setCallback(this);

	}

	@Override
	public void connectionLost(Throwable e) {
		logger.error(bundleMarker, "MockSubscriberPublisher Connection Lost", e);

	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.mqtt.test.system.ISubscriberPublisher#messageArrived(java.lang.String, org.eclipse.paho.client.mqttv3.MqttMessage)
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message)
			throws Exception {

		if (topic.endsWith("Query")) {
			logger.info(bundleMarker,
					"Ignoring Query that arrived on topic {}", topic);

		// handleQuery(topic, message);
		// // } else if (topic.endsWith("Response")) {
		// // logger.info(bundleMarker, "Ignoring topic {}", topic);
		} else {
			logger.info(bundleMarker, "Message arrived on topic {}", topic);
			messages.put(topic, message);
			if (listener != null) {
				listener.messageArrived();
			}
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setListener(ISubscriberListener listener) {
		this.listener = listener;
	}

	private void handleQuery(String topic, MqttMessage message) {
		String query = new String(message.getPayload());

		byte[] payload;
		try {
			if (query.startsWith("{trackerStore")) {
				payload = handleTrackerStoreQuery(topic, query);
			} else if (query.startsWith("{aggregate")) {
				logger.debug(bundleMarker, "Handling update query: " + query);
				String response = "{'result' : [{"
						+ "'update' : ISODate('2012-10-08T22:36:39.046Z')"// '2012-10-08T22:36:39.046Z'"//
					+ "}],'ok' : 1}";
				payload = response.getBytes();
			} else {
				logger.error(bundleMarker, "Unknown query {}", query);
				return;
			}
			String responseTopic = topic.replace("Query", "Response");
			client.publish(responseTopic, payload, 2, false);
		} catch (Exception e) {
			logger.error(bundleMarker, "Failed to handle query " + query, e);

		}

	}

	byte[] handleTrackerStoreQuery(String topic, String query)
			throws IOException {
		logger.debug(bundleMarker, "Handling trackerStore query: " + query);
		// TODO Create the animal and return it as bytes
		// Animal animal = createAnimal();
		// return Utils.toPayload(animal);
		return "some animal".getBytes();

	}

	//
	// private Animal createAnimal() {
	// Tag tag = TrackerFactory.eINSTANCE.createTag();
	// tag.getEvents().add(TrackerFactory.eINSTANCE.createAnimalMissing());
	//
	// tag.getEvents().add(TrackerFactory.eINSTANCE.createPosition());
	// Animal animal = TrackerFactory.eINSTANCE.createSwine();
	// animal.getTags().add(tag);
	// animal.activeTag().setId(Test_IRouterMQTT_1.TAG_ID_1);
	// return animal;
	// }

	@Override
	public void publish(String topic, byte[] payload)
			throws MqttPersistenceException, MqttException {
		logger.debug(bundleMarker, "Publishing to topic={}", topic);
		client.publish(topic, payload, 2, false);

	}

}
