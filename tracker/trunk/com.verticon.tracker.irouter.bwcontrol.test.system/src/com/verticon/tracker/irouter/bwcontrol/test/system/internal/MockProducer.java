/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.bwcontrol.test.system.internal;

import static com.verticon.tracker.irouter.bwcontrol.test.system.internal.BWControlSystemTest.bundleMarker;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;

import java.util.concurrent.CountDownLatch;

import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock of two sensors wired to the BWControl component under test:
 * <ol>
 * <li>Blood weight sensor sending out measurements on the blood.weight scope</li>
 * <li>TruTest scale head sending out measurements on the animal.weight scope and transaction states on the 
 * transaction.state scope</li>
 * </ol>
 * 
 * @author jconlon
 * 
 */
public class MockProducer implements Producer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockProducer.class);

	 Wire[] wires = null;
	 
	CountDownLatch latch = new CountDownLatch(1);
	boolean started = false;

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
		
		if(wires!=null && wires.length>0 && !started){
			latch.countDown();
		}else{
			logger.debug(bundleMarker,"{}: Not connected to any wires.",
					this
			);
		}
		for (Wire wire : wires) {
			logger.debug(bundleMarker,"{}: Connected to {}",
					this, wire.getProperties().get(WIREADMIN_CONSUMER_PID));
		
		}
	}

	/**
	 * Access point for injecting test receivedObjects
	 * @param value
	 */
	void send(Object value) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value={}, No wires", value);
			return;
		}
		for (Wire wire : wires) {
			logger.info(bundleMarker, "Sending {} to wirescope={}", value,
					wire.getScope());
			wire.update(value);
		}
	}

}
