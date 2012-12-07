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

import static com.google.common.collect.Lists.newArrayList;
import static com.verticon.tracker.irouter.bwcontrol.test.system.internal.BWControlSystemTest.bundleMarker;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;
import static com.verticon.tracker.irouter.bwcontrol.test.system.internal.BWControlSystemTest.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.Utils;

/**
 * Mock of a TruTest indicator receiving commands for display of text fields and turning on and off an alarm:
 * <ol>
 * <li>Blood weight field: {SXD19}%13%%10%{SXC16}%13%</li>
 * <li>TruTest scale head sending out measurements on the animal.weight scope and transaction states on the 
 * transaction.state scope</li>
 * </ol>
 * 
 * @author jconlon
 * 
 */
public class MockConsumer implements Consumer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockConsumer.class);

	List<Object> receivedObjects = new ArrayList<Object>();
	
	List<String> bwFieldValues = newArrayList();
	List<String> calcbwFieldValues = newArrayList();
	List<String> alarmCommands = newArrayList();

	CountDownLatch latch = new CountDownLatch(1);
	boolean started = false;
	
	Wire[] wires = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockConsumer []";
	}

	void setUpLatch(int count) {
		latch = new CountDownLatch(count);
		started=true;
	}

	@Override
	public void updated(Wire wire, Object value) {
		if(value instanceof String){
			String in = (String)value;
			if(in.startsWith(bwFieldHeader)){
				bwFieldValues.add(
						in.substring(bwFieldHeader.length()+1)
				);
			}else if(in.startsWith(calbwFieldHeader)){
				calcbwFieldValues.add(
						in.substring(calbwFieldHeader.length()+1)
				);
			}else{
				alarmCommands.add(in);
			}
		}
		receivedObjects.add(value);
		logger.info(bundleMarker, "Received {} from wirescope={}", value,
				wire.getScope());
		latch.countDown();

	}

	@Override
	public void producersConnected(Wire[] wires) {
		this.wires = wires;
		for (Wire wire : wires) {
			logger.debug(bundleMarker,"{}: Connected to {}",
					this, wire.getProperties().get(WIREADMIN_PRODUCER_PID));
		
		}
		if(wires!=null && wires.length>0 && !started){
			latch.countDown();
		}else{
			logger.debug(bundleMarker,"{}: Not connected to any wires.",
					this
			);
		}
	}
	
	private final String bwFieldHeader = Utils.fromAscii(BLOOD_WEIGHT_FIELD);
	private final String calbwFieldHeader = Utils.fromAscii(CALC_BW_FIELD);

}
