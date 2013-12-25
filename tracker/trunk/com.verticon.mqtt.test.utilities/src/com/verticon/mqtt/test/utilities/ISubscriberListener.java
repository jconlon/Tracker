package com.verticon.mqtt.test.utilities;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface ISubscriberListener {
	void messageArrived(String topic, MqttMessage message);
}
