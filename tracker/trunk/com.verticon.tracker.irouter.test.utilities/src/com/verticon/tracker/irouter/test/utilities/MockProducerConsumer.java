/*******************************************************************************
 * Copyright (c) 2013 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.test.utilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Mock producer of Envelopes.
 * 
 * @author jconlon
 * 
 */
public class MockProducerConsumer implements Producer, Consumer,
		IProducerConsumer {

	static String PLUGIN_ID = "com.verticon.irouter.test.utilites";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MockProducerConsumer.class);

	private Wire[] wires = null;
	private final Map<String, Object> consumedProducts = new HashMap<String, Object>();
	private IConsumerListener listener;
	private final AtomicInteger sentCount = new AtomicInteger();
	private String name = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockProducerConsumer [" + name + "]";
	}

	@Override
	public Object polled(Wire wire) {
		return null;
	}

	/**
	 * The consumer will be the EcviMongoIRouterComponent Consumer
	 */
	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires = wires;
		logger.debug(bundleMarker, "{} {} Consumers connected", this,
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
			logger.error(bundleMarker, "{} Cant send value={}, No wires", this,
					value);
			return;
		}
		for (Wire wire : wires) {
			logger.info(bundleMarker, "{} Sending {} to wirescope={}", this,
					value,
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
		logger.info(bundleMarker, "{} Updated {}", this, value);
		String scope = Arrays.toString(wire.getScope());
		consumedProducts.put(scope, value);
		if (listener != null) {
			listener.productConsumed();
		} else {
			logger.error(bundleMarker, "{} No listener", this);
		}
	}

	/**
	 * The producer will be the EcviMongoIRouterComponent Producer which will
	 * send Response products
	 */
	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker,
				"{} {} producers connected to the mock consumer.", this,
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

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
