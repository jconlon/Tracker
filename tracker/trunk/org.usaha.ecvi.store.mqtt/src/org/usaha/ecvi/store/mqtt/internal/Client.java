package org.usaha.ecvi.store.mqtt.internal;

import static com.verticon.tracker.irouter.mqtt.Topic.ECVI_TEMPLATE;
import static com.verticon.tracker.irouter.mqtt.Topic.RESPONSE_ECVI_TEMPLATE;
import static org.usaha.ecvi.store.mqtt.internal.MqttEcviStoreComponent.bundleMarker;
import static org.usaha.ecvi.store.mqtt.internal.StatusAndConfigVariables.getPassword;
import static org.usaha.ecvi.store.mqtt.internal.StatusAndConfigVariables.getPremisesURI;
import static org.usaha.ecvi.store.mqtt.internal.StatusAndConfigVariables.getServerName;
import static org.usaha.ecvi.store.mqtt.internal.StatusAndConfigVariables.getUserName;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
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


public class Client implements MqttCallback {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Client.class);
	private MqttAsyncClient client = null;
	private MqttConnectOptions conOpt;
	private final BlockingQueue<MqttMessage> receiveQueue;

	private String premisesURI;

	Client(BlockingQueue<MqttMessage> receiveQueue) {
		super();
		this.receiveQueue = receiveQueue;
	}

	/**
	 * @return the premisesRegisterPublishTopic
	 */
	String getEcviRecordPublishTopic() {
		return ECVI_TEMPLATE.replace(premisesURI);
	}

	void activate(Map<String, Object> config) throws IOException {
		premisesURI = getPremisesURI(config);

		try {
			createClient(getServerName(config), premisesURI, true, false,
					getUserName(config), getPassword(config));
			// Connect to the MQTT server
			logger.debug(bundleMarker, "Connecting to {} with client ID {}",
					client.getServerURI(), client.getClientId());

			IMqttToken token = client.connect(conOpt);
			token.waitForCompletion();
			logger.debug(bundleMarker, "Connected");
		} catch (MqttException e) {
			logger.error(bundleMarker, "Could not connect to "
					+ getServerName(config), e);
			throw new IOException(e);
		}

		try {
			client.subscribe(RESPONSE_ECVI_TEMPLATE.replace(premisesURI), 2);

		} catch (MqttException e) {
			logger.error(bundleMarker, "Could not subscribe to " + premisesURI,
					e);
			throw new IOException(e);
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
		client = null;
		conOpt = null;
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
		logger.error(bundleMarker, "Connection Lost", cause);

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
		try {
			receiveQueue.add(message);
		} catch (IllegalStateException e) {
			receiveQueue.clear();
			receiveQueue.add(message);
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		logger.debug(bundleMarker, "Delievery complete on topic={}",
				Arrays.toString(token.getTopics()));
	}

	IMqttDeliveryToken publish(String topicName, int qos, EObject eObject)
			throws MqttException, IOException {

		return publish(topicName, qos, toPayload(eObject));
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
	private IMqttDeliveryToken publish(String topicName, int qos, byte[] payload)
			throws MqttException {

		String time = new Timestamp(System.currentTimeMillis()).toString();
		logger.debug(bundleMarker, "Publishing at: {} to topic {}  qos {}",
				new Object[] { time, topicName, qos });

		return client.publish(topicName, payload, qos, false);

	}


	public static final byte[] toPayload(EObject eObject) throws IOException {
		Resource resource = new BinaryResourceImpl();
		resource.getContents().add(eObject);
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		resource.save(ba, null);
		return ba.toByteArray();
	}

	public static final byte[] toPayload(Collection<? extends EObject> eObjects)
			throws IOException {
		Resource resource = new BinaryResourceImpl();
		resource.getContents().addAll(eObjects);
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		resource.save(ba, null);
		return ba.toByteArray();
	}
}
