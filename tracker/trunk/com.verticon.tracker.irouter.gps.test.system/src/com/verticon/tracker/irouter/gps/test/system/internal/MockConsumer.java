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
package com.verticon.tracker.irouter.gps.test.system.internal;

import static com.verticon.tracker.irouter.gps.test.system.internal.GPSSystemTest.bundleMarker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.nmea.AirMarPitchRoll;
import com.verticon.nmea.HeadingAndGroundSpeed;
import com.verticon.nmea.WeatherComposite;

/**
 * Mock consumer of Commands.
 * 
 * @author jconlon
 * 
 */
public class MockConsumer implements Consumer {

	private boolean connected = false;
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockConsumer.class);

	List<Position> receivedPositions = new ArrayList<Position>();
	List<WeatherComposite> receivedWeathers = new ArrayList<WeatherComposite>();
	List<AirMarPitchRoll> receivedOrientations = new ArrayList<AirMarPitchRoll>();
	List<HeadingAndGroundSpeed> receivedHeadings = new ArrayList<HeadingAndGroundSpeed>();
	int receivedMessages = 0;

	CountDownLatch latch = new CountDownLatch(1);


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
	}

	@Override
	public void updated(Wire wire, Object value) {
		if(value instanceof Envelope){
			Envelope env = (Envelope) value;
			receivedMessages++;
			// logger.info(bundleMarker,
			// "{} received envelope={} with contents={}", new Object[]{this,
			// env, env.getValue()});
			if(env.getValue() instanceof Position){
				Position p = (Position)env.getValue();
				receivedPositions.add(p);
				logger.info(bundleMarker,
						"{} received Position lat={} long={}", this, p
								.getLatitude().getValue(), p.getLongitude()
								.getValue());
				latch.countDown();
			} else if (env.getValue() instanceof WeatherComposite) {
				WeatherComposite p = (WeatherComposite) env.getValue();
				receivedWeathers.add(p);
				logger.info(bundleMarker, "{} received {}", this, p);
				latch.countDown();
			} else if (env.getValue() instanceof AirMarPitchRoll) {
				AirMarPitchRoll p = (AirMarPitchRoll) env.getValue();
				receivedOrientations.add(p);
				logger.info(bundleMarker, "{} received {}", this, p);
				latch.countDown();
			} else if (env.getValue() instanceof HeadingAndGroundSpeed) {
				HeadingAndGroundSpeed p = (HeadingAndGroundSpeed) env
						.getValue();
				receivedHeadings.add(p);
				logger.info(bundleMarker, "{} received {}", this, p);
				latch.countDown();

			}else{
				logger.error(bundleMarker, "{} received unknown product: {}",
						this, env.getValue());
			}
		}else{
			logger.error(bundleMarker, "{} received {} instead of an Envelope", this, value);
		}
		

	}

	@Override
	public void producersConnected(Wire[] wires) {
		if(wires==null || wires.length==0){
			logger.info(bundleMarker, "{} Producers Disconnected",
					this);
		}else{
			for (Wire wire : wires) {
				logger.debug(
						bundleMarker,
						"{} connected to {}",
						this,wire.getProperties().get(WireConstants.WIREADMIN_PRODUCER_PID));
			}
		}
//		logger.info(bundleMarker, "{} Producers connected",
//				Arrays.toString(wires));
		if(!connected && wires!=null && wires.length>0){
			connected = true;
			latch.countDown();
		}
	}
	
	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		for (Map.Entry<String, Object> entry : config.entrySet()) {
			logger.debug(bundleMarker, "{} property key={} value={}",
					new Object[]{this, entry.getKey(), entry.getValue()});
		}
		logger.debug(bundleMarker, "{}: Activated.", this);
		
	}

	void deactivate() {
		receivedOrientations.clear();
		receivedPositions.clear();
		receivedWeathers.clear();
	}

}
