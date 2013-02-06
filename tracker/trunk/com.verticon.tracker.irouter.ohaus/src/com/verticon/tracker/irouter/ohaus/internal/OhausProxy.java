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
package com.verticon.tracker.irouter.ohaus.internal;


import static com.google.common.base.Preconditions.checkState;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getMinimumWeight;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getResponseDelayMilliSeconds;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getResponseRetriesBeforeAbort;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getScaleError;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getServicePid;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getURI;
import static com.verticon.tracker.irouter.ohaus.internal.OhausProducer.bundleMarker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.microedition.io.Connection;
import javax.microedition.io.InputConnection;
import javax.microedition.io.OutputConnection;

import org.osgi.service.io.ConnectorService;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Closeables;
import com.verticon.tracker.irouter.common.Utils;

/**
 * 
 * @author jconlon
 * 
 */
public class OhausProxy implements Callable<Void> {

	/**
	 * slf4j Logger
	 */
	final Logger log = LoggerFactory
			.getLogger(OhausProxy.class);


	private final OhausProducer ohausProducer;
	private final double minimumWeightThreshold;
	private final String uri;
	private final long responseDelay;
	private final int responseRetries;
	private final String pid;
	private double minimumWeightThresholdInKiloGrams;
	private final double scaleError;
	private boolean enabled = true;

	private MeasurementUnit measurementUnit;

	enum Command {
		STOP_SENDING("0P%13%%10%"), //
		PRINT_UNIT("PU%13%%10%"), //
		STABLE_PRINT("SP%13%%10%"), //
		EVERY_SECOND_PRINT("1P%13%%10%"), //
		POLL("IP%13%%10%");// Not used
		final String ascii;

		Command(String ascii) {
			this.ascii = ascii;
		}

		String fromAscii() {
			return ascii != null ? Utils.fromAscii(ascii) : null;
		}
	}

	/**
	 * Manages a connection to a balance. Continuously reads from a balance and
	 * outputs weight information.
	 * 
	 * @param ohausProducer
	 */
	public OhausProxy(OhausProducer ohausProducer) {
		super();
		this.ohausProducer = ohausProducer;
		Map<String, Object> config = ohausProducer.getConfig();
		uri = getURI(config);
		pid = getServicePid(config);
		minimumWeightThreshold = getMinimumWeight(config);
		scaleError = getScaleError(config);
		responseDelay = getResponseDelayMilliSeconds(config);
		responseRetries = getResponseRetriesBeforeAbort(config);
		log.debug(
				bundleMarker,
				"{} uri={}, minimumWeightThreshold={}, scaleError={}, responseDelay={}",
				new Object[] { this, uri, minimumWeightThreshold, scaleError,
						responseDelay });
	}

	@Override
	public String toString() {
		return "OhausProxy [pid=" + pid + "]";
	}

	@Override
	public Void call() throws Exception {
		Connection con = null;
		try {
			ohausProducer.getStatusMonitor().setConnectStatus(false);
			log.debug(bundleMarker, "{} Starting uri={} with responseDelay={}",
					new Object[] { this, uri, responseDelay });
			BufferedReader in = null;
			BufferedWriter out = null;
			boolean swallowExcetionsDuringClose = true;
			ConnectorService cs = ohausProducer.getConnectorService();
			con = cs.open(uri,
					ConnectorService.READ_WRITE, true);
			checkState(con != null,
					"ConnectionService could not create a connection");
			InputConnection ic = (InputConnection) con;
			OutputConnection oc = (OutputConnection) con;
			try {
				InputStream is = ic.openInputStream();
				in = new BufferedReader(new InputStreamReader(is));

				OutputStream outs = oc.openOutputStream();
				out = new BufferedWriter(new OutputStreamWriter(outs));

				log.debug(bundleMarker, "{} connected.", this);
				ohausProducer.getStatusMonitor().setConnectStatus(true);
				sendInitializationCommands(out, in);
				// long lastRead = System.currentTimeMillis();
				while (!Thread.currentThread().isInterrupted()) {

					String line;
					while ((in.ready()) && (line = in.readLine()) != null) {
						// long previousRead = lastRead;
						// long start = System.currentTimeMillis();
						handle(line);
						// lastRead = System.currentTimeMillis();
						// log.info(bundleMarker,
						// "Elapsed time for read={} between reads={}",
						// lastRead - start, lastRead - previousRead);
						TimeUnit.MILLISECONDS.sleep(990);
					}

				}
				swallowExcetionsDuringClose = false;
				log.debug(bundleMarker, "{} closing connection", this);
			} catch (InterruptedIOException e) {
				log.debug(bundleMarker, "{} interrupted connection", this);
			} finally {
				ohausProducer.getStatusMonitor().setConnectStatus(false);
				Closeables.close(in, swallowExcetionsDuringClose);
				Closeables.close(out, swallowExcetionsDuringClose);
				if (con != null) {
					con.close();// The connection must be closed to free the
								// port
					con = null;
					log.debug(bundleMarker,
							"{} closed connection in inner loop", this);
				}

			}
		} catch (Exception e) {
			log.warn(bundleMarker, this + " failed to connect", e);
			if (con != null) {
				con.close();// The connection must be closed to free the port
				con = null;
				log.debug(bundleMarker,
						"{} closed connection in exception catch", this);
			}
			throw e;
		} finally {
			if (con != null) {
				con.close();// The connection must be closed to free the port
				con = null;
				log.debug(bundleMarker, "{} closed connection in top loop",
						this);
			}
		}

		return null;
	}

	private void sendInitializationCommands(Writer out, BufferedReader in)
			throws IOException, InterruptedException {
		send(Command.STOP_SENDING, out, in);
		MeasurementUnit measurementUnit = getUnit(out, in);
		minimumWeightThresholdInKiloGrams = measurementUnit
				.convertToKilograms(minimumWeightThreshold);

		log.debug(bundleMarker, "Ohaus scale is configured for {}",
				measurementUnit);
		send(Command.STABLE_PRINT, out, in);
		send(Command.EVERY_SECOND_PRINT, out, in);
		this.measurementUnit = measurementUnit;
	}

	private void send(Command commandType, Writer out, BufferedReader in)
			throws IOException, InterruptedException {

		log.debug(bundleMarker, "{} Sending  command={}", this,
				commandType.ascii);
		out.write(commandType.fromAscii());
		out.flush();
		if (!acknowledge(getResponse(in, commandType))) {
			throw new IOException("failed to acknowledge command="
					+ commandType.ascii);
		}
	}

	private String getResponse(BufferedReader in, Command command)
			throws InterruptedException,
			IOException {
		int sleepCounter = 0;
		String result = null;
		while (!Thread.currentThread().isInterrupted()) {
			if (in.ready()) {
				result = in.readLine();
				break;
			} else {

				TimeUnit.MILLISECONDS.sleep(responseDelay);
				if (sleepCounter >= responseRetries) {
					log.debug(bundleMarker,
							"Timedout waiting for {} response reached max responseDelay of {} ms.",
							command, (responseRetries * responseDelay));
					// Reached max timeout waiting for data. Bail..
					throw new IOException(
							"failed to receive an acknowledge from the scale.");
				}
				sleepCounter++;
			}
			
		}
		return result;
	}

	private MeasurementUnit getUnit(Writer out, BufferedReader in) throws IOException,
			InterruptedException {

		log.debug(bundleMarker, "{} Sending  PU command={}", this,
				Command.PRINT_UNIT.ascii);
		out.write(Command.PRINT_UNIT.fromAscii());
		out.flush();
		String response = getResponse(in, Command.PRINT_UNIT);
		log.debug(bundleMarker, "{} Response from  PU command={}", this,
				Command.PRINT_UNIT.ascii);
		MeasurementUnit result = MeasurementUnit.getUnit(response.trim());
		log.info(bundleMarker, "Scale configured for: {}",
				result);
		return result;

	}

	private void handle(String response)
			throws InterruptedException, IOException {
		if (response == null) {
			throw new IOException("End of Stream");
		}
		
		Measurement measurement = createWeight(response);
		if (measurement != null) {
			log.info(bundleMarker, "Weight: {} {}", new Object[] { response,
					measurementUnit.key });
			ohausProducer.send(measurement);
			ohausProducer.getStatusMonitor().setLastStableScaleValue(
					String.format("%s %s", response, measurementUnit));
			enabled = false;
		}
	}

	private boolean acknowledge(String response) throws InterruptedException,
			IOException {
		if (response == null) {
			throw new IOException("End of Stream");
		}
		log.debug("{}: handling response={}", this,
				response != null ? Utils.toAscii(response) : "null");

		return response.startsWith("OK");
	}

	boolean exceedsThreshold(double kiloGrams) {
		return kiloGrams > minimumWeightThresholdInKiloGrams;
	}

	Measurement createWeight(String response) {
		if (response == null) {
			return null;
		}
		Double kiloGrams = null;
		try {

			kiloGrams = measurementUnit.convertToKiloGrams(response);
			if (kiloGrams == 0 || kiloGrams < 0) {
				if (!enabled) {
				enabled = true;
					log.info("Reset");
				}
				return null;
			}
			if (!enabled) {
				log.debug("{}: ignoring {}, waiting for reset", this, kiloGrams);
				return null;
			}
			if (!exceedsThreshold(kiloGrams)) {
				log.debug("{}: {} {} does not exceed threshold {}",
						new Object[] { this, response, measurementUnit,
								minimumWeightThreshold });
				return null;
			}

		} catch (NumberFormatException e) {
			log.error(bundleMarker, "Parse weight response "+response+" is not a number.");
			return null;
		}

		log.debug(bundleMarker, "Converted {} {} to {} kilograms",
				new Object[] { response, measurementUnit, kiloGrams });
		
		Measurement measurement = new Measurement(kiloGrams, scaleError,
				Unit.kg,
				System.currentTimeMillis());

		return measurement;
	}
}
