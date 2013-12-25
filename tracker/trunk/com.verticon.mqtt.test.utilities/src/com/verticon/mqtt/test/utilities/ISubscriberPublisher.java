package com.verticon.mqtt.test.utilities;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public interface ISubscriberPublisher {

	void setListener(ISubscriberListener listener);

	void publish(String topic, byte[] payload) throws MqttPersistenceException,
			MqttException;
}