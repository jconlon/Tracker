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
package com.verticon.tracker.irouter.udp.test.system.internal;

import static com.verticon.tracker.irouter.udp.test.system.internal.UDPSystemTest.bundleMarker;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.nmea.AirMarPitchRoll;
import com.verticon.nmea.HeadingAndGroundSpeed;
import com.verticon.nmea.PositionWrapper;
import com.verticon.nmea.WeatherComposite;

/**
 * Mock consumer of Commands.
 * 
 * @author jconlon
 * 
 */
public class UDPServer implements Runnable {

	private static final int REQUIRED_MESSAGE_COUNT = 20;
	int port;
	int numberOfBytesSent = 0;

	public static enum NMEA {
		POSITION, WEATHER, PITCH_AND_ROLL, HEADING_AND_GROUNDSPEED, UNKNOWN
	}

	public static NMEA messageType(String message) {
		if (PositionWrapper.canCreateFrom(message)) {
			return NMEA.POSITION;
		} else if (WeatherComposite.canCreateFrom(message)) {
			return NMEA.WEATHER;
		} else if (AirMarPitchRoll.canCreateFrom(message)) {
			return NMEA.PITCH_AND_ROLL;
		} else if (HeadingAndGroundSpeed.canCreateFrom(message)) {
			return NMEA.HEADING_AND_GROUNDSPEED;
		} else {
			return NMEA.UNKNOWN;
		}
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(UDPServer.class);

	List<String> receivedPositions = new ArrayList<String>();
	List<String> receivedWeathers = new ArrayList<String>();
	List<String> receivedOrientations = new ArrayList<String>();
	List<String> receivedHeadingAndGroundSpeeds = new ArrayList<String>();
	int receivedMessages = 0;

	// latch will countdown to received messages
	CountDownLatch latch = new CountDownLatch(REQUIRED_MESSAGE_COUNT);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UDPServer []";
	}

	private void updated(String message) {

		receivedMessages++;
		System.out.printf("%s received [%s] %n", this, message);

		numberOfBytesSent = numberOfBytesSent + message.length();
		logger.info(bundleMarker, message);
		logger.info(bundleMarker, "   Message lenght=" + message.length()
				+ ", Total Bytes Sent=" + numberOfBytesSent);

		switch (messageType(message)) {
		case WEATHER:
			receivedWeathers.add(message);
			latch.countDown();
			logger.info(bundleMarker,
					receivedMessages + " weather("
					+ message.length() + ")" );
			break;
		case POSITION:
			receivedPositions.add(message);
			latch.countDown();
			logger.info(bundleMarker,
					receivedMessages + " position("
					+ message.length() + ")");
			break;
		case PITCH_AND_ROLL:
			receivedOrientations.add(message);
			latch.countDown();
			logger.info(bundleMarker, receivedMessages + " pitchAndRoll("
					+ message.length() + ")" );
			break;
		case HEADING_AND_GROUNDSPEED:
			receivedHeadingAndGroundSpeeds.add(message);
			latch.countDown();
			logger.info(bundleMarker, receivedMessages
					+ " headingAndGroundSpeed("
					+ message.length() + ")");
			break;
		default:
			logger.error(bundleMarker, "{} received unknown product: {}", this,
					message);
			logger.info(bundleMarker, receivedMessages + " UNKNOWN " + message);
			break;
		}

	}

	void reset() {
		receivedOrientations.clear();
		receivedPositions.clear();
		receivedWeathers.clear();
	}

	@Override
	public void run() {
		try {
			DatagramSocket serverSocket = new DatagramSocket(port);

			byte[] receiveData = new byte[1024];

			while (receivedMessages < REQUIRED_MESSAGE_COUNT) {

				receiveData = new byte[1024];

				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);

				serverSocket.receive(receivePacket);

				String message = new String(receivePacket.getData());

				updated(message.trim());
			}

			serverSocket.close();

		} catch (SocketException ex) {
			logger.error(bundleMarker, "UDP Port " + port + " is occupied.");

		} catch (IOException e) {
			logger.error(bundleMarker, "Server failed", e);
		}
	}

}
