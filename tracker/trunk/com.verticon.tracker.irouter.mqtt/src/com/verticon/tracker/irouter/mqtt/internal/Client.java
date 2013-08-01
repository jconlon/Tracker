package com.verticon.tracker.irouter.mqtt.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.irouter.mqtt.internal.MqttBridgeComponent.bundleMarker;
import static com.verticon.tracker.irouter.mqtt.internal.StatusAndConfigVariables.getClientID;
import static com.verticon.tracker.irouter.mqtt.internal.StatusAndConfigVariables.getPassword;
import static com.verticon.tracker.irouter.mqtt.internal.StatusAndConfigVariables.getServerName;
import static com.verticon.tracker.irouter.mqtt.internal.StatusAndConfigVariables.getUserName;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.verticon.tracker.irouter.mqtt.Utils;

public class Client implements MqttCallback {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Client.class);

	private MqttAsyncClient client = null;
	private MqttConnectOptions conOpt;
	private String clientId;
	private final Monitor monitor;

	Client(Monitor monitor) {
		super();
		this.monitor = monitor;
	}

	/**
	 * Maps topic keys to SubscriberToProducer objects
	 */
	private final Map<String, SubscriberToProducer> subcribersToProducers = newHashMap();


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + "]";
	}

	/**
	 * @return the subcribersToProducers
	 */
	Map<String, SubscriberToProducer> getSubcribersToProducers() {
		return subcribersToProducers;
	}

	void activate(Map<String, Object> config) throws IOException {
		clientId = getClientID(config);

		String brokerURI = getServerName(config);
		checkNotNull(brokerURI, "BrokerUrl can not be null");
		checkNotNull(clientId, "ClientId can not be null");

		try {
			createClient(brokerURI, clientId, true, false,
					getUserName(config), getPassword(config));
			// Connect to the MQTT server
			logger.debug(bundleMarker, "Connecting to {} with client ID {}",
					client.getServerURI(), client.getClientId());

			IMqttToken token = client.connect(conOpt);
			token.waitForCompletion();
			logger.debug(bundleMarker, "Connected");
			setUpSubscribers(config);
		} catch (MqttException e) {
			logger.error(bundleMarker, "Could not connect to "
					+ getServerName(config), e);
			throw new IOException(e);
		}


	}

	private void setUpSubscribers(Map<String, Object> config)
			throws IOException {
		// Get all the topics to subscribe to:
		Iterable<String> topics = StatusAndConfigVariables
				.getSubscriberTopics(config);
		Iterable<String> scopes = StatusAndConfigVariables
				.getProducerScopes(config);
		if (Iterables.size(topics) != Iterables.size(scopes)) {
			throw new IOException(
					"Topics and scopes must be contain the same number of names.");
		}
		int size = Iterables.size(topics);
		String topic, scope;
		for (int i = 0; i < size; i++) {
			topic = Iterables.get(topics, i);
			scope = Iterables.get(scopes, i);
			SubscriberToProducer sToP = new SubscriberToProducer(scope, monitor);
			subcribersToProducers.put(topic, sToP);
			try {
				subscribe(topic, sToP);
			} catch (MqttException e) {
				logger.error(bundleMarker, "Failed to subscribe to topic: "
						+ topic, e);
				throw new IOException(e);
			}
		}
	}

	void deactivate() {
		try {
			if (client != null) {
				// Disconnect the client
				IMqttToken discToken = client.disconnect(null, null);
				discToken.waitForCompletion(10);
				logger.debug(bundleMarker, "Disconnected");
				client.close();
			}
		} catch (MqttException e) {
			logger.error(bundleMarker, "Failed disconnection.", e);
		}
		subcribersToProducers.clear();
		client = null;
		conOpt = null;
	}
	
	private void subscribe(String topicFilter, Object context)
			throws MqttException {
		client.subscribe(topicFilter, 2, context, new IMqttActionListener() {

			@Override
			public void onSuccess(IMqttToken asyncActionToken) {
				logger.debug(bundleMarker, "Subscribed to topics: {}",
						Arrays.toString(asyncActionToken.getTopics()));
			}

			@Override
			public void onFailure(IMqttToken asyncActionToken,
					Throwable exception) {
				logger.error(bundleMarker, "Failed to subscribe to topics: {}",
						Arrays.toString(asyncActionToken.getTopics()));
			}

		});
	}

	/**
	 * Constructs an instance of the sample client wrapper
	 * 
	 * @param brokerUrl
	 *            the url of the server to connect to
	 * @param clientId
	 *            the client id to connect with
	 * @param clean
	 *            clear state at end of connection or not (durable or
	 *            non-durable subscriptions)
	 * @param quietMode
	 *            whether debug should be printed to standard out
	 * @param userName
	 *            the username to connect with
	 * @param password
	 *            the password for the user
	 * @throws MqttException
	 */
	private void createClient(String brokerUrl, String clientId, boolean clean,
			boolean quietMode, String userName, String password)
			throws MqttException {

		checkNotNull(brokerUrl, "BrokerUrl can not be null");
		checkNotNull(clientId, "ClientId can not be null");
		// stores in a temporary directory... where messages
		// temporarily stored until the message has been delivered to the
		// server.
		// ..a real application ought to store them somewhere
		// where they are not likely to get deleted or tampered with
		String tmpDir = System.getProperty("java.io.tmpdir");
		MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(
				tmpDir);

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

		// Set this wrapper as the callback handler
		client.setCallback(this);

	}

	@Override
	public void connectionLost(Throwable cause) {
		logger.error(bundleMarker, "Connection Lost", cause.getCause());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.paho.client.mqttv3.MqttCallback#messageArrived(java.lang.
	 * String, org.eclipse.paho.client.mqttv3.MqttMessage)
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message)
			throws Exception {
		logger.debug(bundleMarker, "Message arrived on topic={}", topic);

		for (String topicFilter : subcribersToProducers.keySet()) {
			if (Utils.matches(topic, topicFilter)) {

				subcribersToProducers.get(topicFilter).messageArrived(topic,
						message);
			}
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		logger.debug(bundleMarker, "Delievery complete on topic={}",
				Arrays.toString(token.getTopics()));
	}

	

	/**
	 * Publish / send a message to an MQTT server
	 * 
	 * @param topicName
	 *            the name of the topic to publish to
	 * @param qos
	 *            the quality of service to delivery the message at (0,1,2)
	 * @param payload
	 *            the set of bytes to send to the MQTT server
	 * @return
	 * @throws MqttException
	 */
	IMqttDeliveryToken publish(String topicName, int qos, byte[] payload)
			throws MqttException {

		// String time = new Timestamp(System.currentTimeMillis()).toString();
		logger.debug(bundleMarker, "Publishing to topic {}", topicName);

		return client.publish(topicName, payload, qos, false);

	}
}
