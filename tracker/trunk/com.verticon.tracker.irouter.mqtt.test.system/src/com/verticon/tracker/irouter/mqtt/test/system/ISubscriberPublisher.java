package com.verticon.tracker.irouter.mqtt.test.system;

import java.util.Map;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public interface ISubscriberPublisher {

	public Map<String, MqttMessage> messages();

	void setListener(ISubscriberListener listener);

	void publish(String topic, byte[] payload) throws MqttPersistenceException,
			MqttException;
}