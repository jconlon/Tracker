package org.usaha.ecvi.store.mqtt.internal;

import static org.usaha.ecvi.store.mqtt.internal.StatusAndConfigVariables.getServerName;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.store.IEcviStore;

import com.google.common.collect.ImmutableList;


/**
 * A MQTT publisher
 * 
 * @author jconlon
 * 
 */
public class MqttEcviStoreComponent implements IEcviStore, Consumer, Monitorable {

	private static String PLUGIN_ID = "org.usaha.ecvi.store.mqtt";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		MqttEcviStoreComponent.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MqttEcviStoreComponent.class);
	private final BlockingQueue<MqttMessage> receiveQueue = new ArrayBlockingQueue<MqttMessage>(
			1);
	private final Client client = new Client(receiveQueue);
	private final Monitor monitor = new Monitor();
	private final MQTTConsumer consumer = new MQTTConsumer(this, monitor);
	private List<String> uris = null;
	private int waitSecondsForResponse;

	@Override
	public void record(Ecvi ecvi, String uri) throws IOException {
		logger.debug(bundleMarker, "Publishing Ecvi {} to topic {}",
				ecvi.getCviNumber(), client.getEcviRecordPublishTopic());
		Ecvi targetEcvi = EcoreUtil.copy(ecvi);
		try {
			receiveQueue.clear();
			IMqttDeliveryToken token = client.publish(
					client.getEcviRecordPublishTopic(), 2, targetEcvi);
			token.waitForCompletion();
			MqttMessage responseMessage = receiveQueue.poll(
					waitSecondsForResponse, TimeUnit.SECONDS);
			if (responseMessage == null) {
				throw new IOException(
						"Record request failed. There was no response to the record request.");
			}
			if (responseMessage.getPayload() == null) {
				throw new IOException(
						"Record request failed. The response to the record request was empty null.");
			}
			String response = new String(responseMessage.getPayload());
			if (response.equals("OK")) {
				monitor.incrementTotalEcviRecorded();
				return;
			}

			throw new IOException("Record request failed. " + response);

		} catch (MqttException e) {
			logger.error(bundleMarker,
					"Failed to record ecvi " + targetEcvi.getCviNumber(), e);
			monitor.incrementTotalExceptions();
			throw new IOException(e);
		} catch (InterruptedException e) {
			logger.error(bundleMarker,
					"Failed to record ecvi " + targetEcvi.getCviNumber(), e);
			// Restore the interrupted status
			monitor.incrementTotalExceptions();
			Thread.currentThread().interrupt();
		}

	}

	@Override
	public Iterable<String> getURIs() {
		return uris;
	}

	@Override
	public void updated(Wire wire, Object in) {
		consumer.updated(wire, in);
	}

	@Override
	public void producersConnected(Wire[] wires) {
		consumer.producersConnected(wires);
	}

	@Override
	public String[] getStatusVariableNames() {
		return monitor.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.getStatusVariable(id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return monitor.notifiesOnChange(id);
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.resetStatusVariable(id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return monitor.getDescription(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MqttEcviStoreComponent uris=" + (uris != null ? uris : "null");
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		monitor.setMonitorListener(monitorListener);
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		monitor.unsetMonitorListener(monitorListener);
	}

	void activate(Map<String, Object> config) throws IOException {
		waitSecondsForResponse = StatusAndConfigVariables
				.getWaitSecondsForRespsonse(config);
		uris = new ImmutableList.Builder<String>().add(getServerName(config))
				.build();
		client.activate(config);
		monitor.activate(config);
		consumer.activate(config);
	}

	void deactivate() {
		logger.debug(bundleMarker, "Deactivating");
		client.deactivate();
		consumer.deactivate();
		monitor.deactivate();
		uris = null;
	}

}
