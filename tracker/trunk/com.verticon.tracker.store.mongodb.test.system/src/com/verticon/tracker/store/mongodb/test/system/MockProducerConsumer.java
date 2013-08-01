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
package com.verticon.tracker.store.mongodb.test.system;

import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.wireadmin.Consumer;
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
	private final Map<String, Object> consumedProducts = newHashMap();
	private IConsumerListener listener;
	private final AtomicInteger sentCount = new AtomicInteger();

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
		// wires!=null?Arrays.toString(wires):0);
				wires != null ? wires.length : 0);
	}

	/**
	 * Access point for injecting test receivedObjects
	 * 
	 * @param value
	 */
	@Override
	public void send(Object value) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value={}, No wires", value);
			return;
		}
		for (Wire wire : wires) {
			logger.debug(bundleMarker, "Sending {} to wirescope={}", value,
					Arrays.toString(wire.getScope()));
			wire.update(value);
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
		logger.debug(bundleMarker, "Updated {}", value);
		String scopes = Arrays.toString(wire.getScope());
		consumedProducts.put(scopes, value);
		if (listener != null) {
			listener.productConsumed();
		} else {
			logger.error(bundleMarker, "No listener");
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker,
				"{} producers connected to the mock consumer.",
				wires != null ? wires.length : 0);
	}

	@Override
	public void setListener(IConsumerListener listener) {
		this.listener = listener;
	}

	@Override
	public Map<String, Object> getConsumedProducts() {
		return consumedProducts;
	}

}
