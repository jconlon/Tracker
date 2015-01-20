/*******************************************************************************
 * Copyright (c) 2011 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.udp.internal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.messaging.MessageAppender;

/**
 * Consumer of NMEA navigation objects Position, Weather and AirMarPitchRoll.
 * Extracts values and sends these to the UDPSender.
 * 
 * @author jconlon
 * 
 */
public class MessageConsumer implements Consumer, Monitorable {

	static final String POISON = "POISON";
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.udp";
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
	private static final String PREFIX = "udp.message.prefix";
	private static final String DELIMITER = "udp.message.delimiter";
	private static final String CONNECTION_URI = "connection.uri";

	// Status vars
	private static final String WIRES_COUNT = "consumer.Connected_Wires";
	private static final String LAST_VALUE_SENT = "consumer.Last_Message";
	private static final String LAST_TIME_SENT = "consumer.Last_Time_Sent";
	private static final String TOTAL_VALUES_SENT = "consumer.Total_Messages_Sent";
	private static final String CONNECTION_URI_STATUS_VAR = "consumer.Connection_URI";
	private static final String LAST_SCOPE = "consumer.Last_Scope";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<String>();
	private final AtomicInteger totalMeasurements = new AtomicInteger(0);
	private final AtomicInteger wiresConnected = new AtomicInteger(0);
	private String lastTime = null;
	private Envelope lastEnvelope = null;

	private ExecutorService exec;
	private String delimiter;
	private String uris;
	// private InetAddress address;
	// private int port;
	private String prefix;

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		if (exec != null) {
			deactivate();
			logger.info(bundleMarker, "{}: Re-Activating.", this);
		} else {
			logger.info(bundleMarker, "{}: Activating.", this);
		}
		exec = Executors.newSingleThreadExecutor();
		uris = (String) config.get(CONNECTION_URI);
		checkNotNull(uris, "Connection URI cannot be null.");

		prefix = (String) config.get(PREFIX);
		if (prefix == null) {
			prefix = "";
		}

		delimiter = (String) config.get(DELIMITER);
		if (delimiter == null) {
			delimiter = "";
		}
		String[] tokens = uris.split(":");
		checkArgument(tokens.length == 2, "Illegal connection uri format: "
				+ uris);

		logger.debug(bundleMarker, "{} executing UDPSender.", this);
		try {
			int port = Integer.parseInt(tokens[1]);
			exec.submit(new UDPSender(tokens[0], port, messageQueue, prefix));

		} catch (Exception e) {
			logger.error(bundleMarker,
					"Failed to connect. Check the uri parameter.", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageConsumer [delimiter=" + delimiter + ", uri=" + uris
				+ ", prefix=" + prefix + "]";
	}

	void deactivate() {
		messageQueue.add(POISON);
		if (exec != null) {
			exec.shutdown();
			try {
				boolean shutdownOk = exec
						.awaitTermination(10, TimeUnit.SECONDS);
				if (shutdownOk) {
					logger.info(bundleMarker, "Executor shutdown OK.");
				} else {
					logger.error(bundleMarker,
							"Failed to shutdown the executor.");
				}
			} catch (InterruptedException e) {
				// immediately re-interrupt the thread
				Thread.currentThread().interrupt();
				logger.warn(bundleMarker, "Interupted in executor shutdown.");
			}
		}

		exec = null;
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "Invoked producerConnected with wires={}",
				Arrays.toString(wires));
		wiresConnected.set(wires != null ? wires.length : 0);
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { WIRES_COUNT, LAST_VALUE_SENT, LAST_SCOPE,
				TOTAL_VALUES_SENT, CONNECTION_URI_STATUS_VAR, LAST_TIME_SENT };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (WIRES_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					wiresConnected.get());
		} else if (LAST_VALUE_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastEnvelope != null ? lastEnvelope.getValue().toString()
							: "");
		} else if (LAST_SCOPE.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastEnvelope != null ? lastEnvelope.getScope() : "");
		} else if (TOTAL_VALUES_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalMeasurements.get());
		} else if (CONNECTION_URI_STATUS_VAR.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER, uris);
		} else if (LAST_TIME_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER, lastTime);
		} else {
			throw new IllegalArgumentException("Invalid Status Variable name "
					+ name);
		}
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String name)
			throws IllegalArgumentException {

		if (TOTAL_VALUES_SENT.equals(name)) {
			totalMeasurements.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if (WIRES_COUNT.equals(id)) {
			return "The number of connected wires.";
		} else if (LAST_VALUE_SENT.equals(id)) {
			return "The last measurement sent to the UDP Host.";
		} else if (TOTAL_VALUES_SENT.equals(id)) {
			return "The total numver of measurements sent to the UDP Host.";
		} else if (LAST_SCOPE.equals(id)) {
			return "The scope of the last measurement sent to the Tracker transaction editor.";
		} else if (CONNECTION_URI_STATUS_VAR.equals(id)) {
			return "The URI of the connected UDP Host.";
		} else if (LAST_TIME_SENT.equals(id)) {
			return "Last time a measurement was sent.";
		}
		return null;
	}

	/**
	 * Consume Position, Weather and Orientation cik=<CIK>&<alias 1>=<value
	 * 1>&<alias 2...>=<value 2...>&<alias n>=<value n>
	 */
	@Override
	public void updated(Wire wire, Object value) {
		StringBuffer output = new StringBuffer();
		Envelope env = null;

		if (value instanceof Envelope) {
			env = (Envelope) value;
			Object payload = env.getValue();
			MessageAppender appender;
			if (payload instanceof MessageAppender) {
				appender = (MessageAppender) payload;
			} else {
				logger.error(bundleMarker, "{} received unknown product: {}",
						this, payload);
				return;
			}
			appender.appendMessage(output, delimiter);
			logger.info(bundleMarker, "{} received {}", this, appender);
			if (output.length() > 0) {
				messageQueue.add(output.toString());
				int i = totalMeasurements.incrementAndGet();
				lastEnvelope = env;
				lastTime = new Date().toString();
				logger.info(bundleMarker,
						"{} sent {} #{} to the event service", new Object[] {
								this, env, i });
			}

		} else {
			logger.error(bundleMarker, "{} received {} instead of an Envelope",
					this, value);
		}

	}

}
