package com.verticon.tracker.store.mqtt.test.system;

import java.util.Map;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface ISubscriber {

	public Map<String, MqttMessage> messages();

	void setListener(ISubscriberListener listener);
}