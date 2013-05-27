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

import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;

import java.util.concurrent.atomic.AtomicInteger;

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
public class MockProducer implements Producer, IController {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockProducer.class);

	private Wire[] wires = null;

	private final AtomicInteger sentCount = new AtomicInteger();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockProducer []";
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
					wire.getScope());
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

}
