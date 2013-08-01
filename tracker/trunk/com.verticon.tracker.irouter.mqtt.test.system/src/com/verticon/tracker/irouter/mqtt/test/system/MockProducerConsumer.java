/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.mqtt.test.system;

import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.irouter.mqtt.test.system.Configurator.bundleMarker;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock producer of Envelopes.
 * 
 * @author jconlon
 * 
 */
public class MockProducerConsumer implements Producer, Consumer, IProducerConsumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockProducerConsumer.class);

	private Wire[] wires = null;

	private final AtomicInteger sentCount = new AtomicInteger();
	
	private final Map<String, Object> consumedProducts = newHashMap();
	private IConsumerListener listener;

	void activate(ComponentContext context) throws Exception {

	}

	/**
	 * @return the consumedProducts
	 */
	@Override
	public Map<String, Object> getConsumedProducts() {
		return consumedProducts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockProducerConsumer []";
	}

	@Override
	public Object polled(Wire wire) {
		return null;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires = wires;
		logger.debug(bundleMarker, "{} Consumers connected",
				wires != null ? wires.length : 0);
	}

	/**
	 * Access point for injecting test mobjects
	 * 
	 * @param value
	 */
	@Override
	public void produce(String scope, String topic, byte[] payload) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value to topic={}, No wires", topic);
			return;
		}
		for (Wire wire : wires) {

			Envelope envelope = new BasicEnvelope(payload, topic, scope);
			logger.debug(
					bundleMarker,
					"Updating wire with envelope identification(topic)={} and scope={}",
					topic, Arrays.toString(wire.getScope()));
			wire.update(envelope);
			sentCount.incrementAndGet();
		}
	}

	@Override
	public boolean hasWires() {
		return wires != null;
	}

	@Override
	public int sentCount() {
		return sentCount.get();
	}

	@Override
	public void clearSendCount() {
		sentCount.set(0);

	}

	@Override
	public void updated(Wire wire, Object value) {
		String scopes = Arrays.toString(wire.getScope());
		consumedProducts.put(scopes,value);
		if (listener != null) {
			listener.productConsumed();
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker,"{} producers connected to the mock consumer.",wires.length);
	}

	@Override
	public void setListener(IConsumerListener listener) {
		this.listener = listener;
	}

}
