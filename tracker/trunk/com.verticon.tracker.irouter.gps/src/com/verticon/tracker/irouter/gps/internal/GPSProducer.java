/*******************************************************************************
 * Copyright (c) 2015 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.gps.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import org.osgi.service.io.ConnectorService;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.util.concurrent.AbstractCheckedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.verticon.nmea.AirMarPitchRoll;
import com.verticon.nmea.HeadingAndGroundSpeed;
import com.verticon.nmea.NMEAUtilities;
import com.verticon.nmea.WeatherComposite;

/**
 * 
 * GPSProducer manages connections to a gps device with a GPSProxy to produce
 * NMEA objects.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>ConnectorService</li>
 * <li>MonitorListener</li>
 * </ol>
 * 
 * @author jconlon
 * 
 */
public class GPSProducer implements Producer, Monitorable {

	private static final String PLUGIN_ID = "com.verticon.tracker.irouter.gps";
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	// Misc
	private static final DecimalFormat DECIMAL_FORMATER = new DecimalFormat(
			"##.#####");

	// Proxy futures
	private static ListeningExecutorService exec = null;
	private volatile AbstractCheckedFuture<Void, IOException> lfuture = null;
	private volatile GPSProxy proxy = null;

	private final Logger logger = LoggerFactory.getLogger(GPSProducer.class);

	// config
	private static final String CONNECTION_RETRY_DELAY = "connection.retry.seconds";
	private static final String PRODUCT_OUTPUT_RATE = "product.output.rate";
	private static final String PRODUCT_CONSOLIDATE_MESSAGE = "product.output.consolidate";
	private static final String CONNECTION_URI = "connection.uri";
	private static final String ALT_ERROR = "altitude.error";
	private static final String LONG_ERROR = "longitude.error";
	private static final String LAT_ERROR = "latitude.error";
	private static final Object PITCH_ERROR = "pitch.error";
	private static final Object ROLL_ERROR = "roll.error";
	private static final Object BAROMETRIC_PRESSURE_ERROR = "barometric.error";
	private static final Object AIRTEMP_ERROR = "airtemp.error";
	private static final Object WIND_DIRECTION_ERROR = "windDirection.error";
	private static final Object WIND_SPEED_ERROR = "windSpeed.error";

	private Map<String, Object> config = null;

	// stats
	private static final String CONNECTED_CONSUMERS = "producer.Connected_Consumers";
	private final AtomicInteger consumersConnected = new AtomicInteger(0);
	private static final String LAST_POSITION = "producer.Last_Position";
	private static final String TOTAL_POSITION_SENT = "producer.Total_Positions_Sent";
	private static final String LAST_POSITION_TIME = "producer.Last_Position_Time";
	final AtomicInteger totalPositions = new AtomicInteger(0);

	private static final String LAST_WEATHER = "producer.Last_Weather";
	private static final String TOTAL_WEATHER_SENT = "producer.Total_Weathers_Sent";
	private static final String LAST_WEATHER_TIME = "producer.Last_Weather_Time";
	final AtomicInteger totalWeathers = new AtomicInteger(0);

	private static final String LAST_ORIENTATION = "producer.Last_Orientation";
	private static final String TOTAL_ORIENTATION_SENT = "producer.Total_Orientations_Sent";
	private static final String LAST_ORIENTATION_TIME = "producer.Last_Orientation_Time";
	final AtomicInteger totalOrientations = new AtomicInteger(0);

	private static final String LAST_HEADING = "producer.Last_Heading";
	private static final String TOTAL_HEADING_SENT = "producer.Total_Heading_Sent";
	private static final String LAST_HEADING_TIME = "producer.Last_Heading_Time";
	final AtomicInteger totalHeadings = new AtomicInteger(0);

	private static final String LAST_ENVELOPE = "producer.Last_Composite";
	private static final String TOTAL_ENVELOPE_SENT = "producer.Total_Envelopes_Sent";
	private static final String LAST_ENVELOPE_TIME = "producer.Last_Envelopes_Time";
	final AtomicInteger totalEnvelopes = new AtomicInteger(0);

	private static final String CONNECTION_URI_STATUS_VAR = "producer.Connection_URI";

	private static final String CONNECTED = "producer.Is_Connected";
	private static final String CRC_ERRORS = "producer.CRC_Sentences";
	private final AtomicInteger totalCRCs = new AtomicInteger(0);
	private static final String INCOMPLETE_SENTENCES = "producer.Incomplete_Sentences";
	private final AtomicInteger totalIncompletes = new AtomicInteger(0);

	private final AtomicBoolean connected = new AtomicBoolean();
	private static final String[] VARS = new String[] { CONNECTED_CONSUMERS,
			LAST_POSITION, LAST_POSITION_TIME, TOTAL_POSITION_SENT,
			LAST_ORIENTATION, LAST_ORIENTATION_TIME, TOTAL_ORIENTATION_SENT,
			LAST_HEADING, LAST_HEADING_TIME, TOTAL_HEADING_SENT, LAST_ENVELOPE,
			LAST_ENVELOPE_TIME, TOTAL_ENVELOPE_SENT, LAST_WEATHER,
			LAST_WEATHER_TIME, TOTAL_WEATHER_SENT, CONNECTION_URI_STATUS_VAR,
			CONNECTED, INCOMPLETE_SENTENCES, CRC_ERRORS };

	// Injected service
	private ConnectorService connectorService = null;
	private MonitorListener monitorListener;

	private Wire[] wires = null;
	private String uri = null;
	private String producerScope = null;

	// Product
	@SuppressWarnings("unused")
	private volatile Envelope lastPositionEnvelope = null;
	@SuppressWarnings("unused")
	private volatile Envelope lastOrientationEnvelope = null;
	@SuppressWarnings("unused")
	private volatile Envelope lastWeatherEnvelope = null;
	@SuppressWarnings("unused")
	private volatile Envelope lastHeadingEnvelope = null;
	@SuppressWarnings("unused")
	private volatile Envelope lastEnvelope = null;

	private static final AtomicReferenceFieldUpdater<GPSProducer, Envelope> lastWeatherEnvelopeUpdater = AtomicReferenceFieldUpdater
			.newUpdater(GPSProducer.class, Envelope.class,
					"lastWeatherEnvelope");

	private static final AtomicReferenceFieldUpdater<GPSProducer, Envelope> lastPositionEnvelopeUpdater = AtomicReferenceFieldUpdater
			.newUpdater(GPSProducer.class, Envelope.class,
					"lastPositionEnvelope");

	private static final AtomicReferenceFieldUpdater<GPSProducer, Envelope> lastOrientationEnvelopeUpdater = AtomicReferenceFieldUpdater
			.newUpdater(GPSProducer.class, Envelope.class,
					"lastOrientationEnvelope");

	private static final AtomicReferenceFieldUpdater<GPSProducer, Envelope> lastHeadingEnvelopeUpdater = AtomicReferenceFieldUpdater
			.newUpdater(GPSProducer.class, Envelope.class,
					"lastHeadingEnvelope");

	private static final AtomicReferenceFieldUpdater<GPSProducer, Envelope> lastEnvelopeUpdater = AtomicReferenceFieldUpdater
			.newUpdater(GPSProducer.class, Envelope.class, "lastEnvelope");


	void setLastOrientationEnvelopeUpdater(Envelope envelope) {
		lastOrientationEnvelopeUpdater.set(this, envelope);
	}

	void setLastWeatherEnvelopeUpdater(Envelope envelope) {
		lastWeatherEnvelopeUpdater.set(this, envelope);
	}

	void setLastPositionEnvelopeUpdater(Envelope envelope) {
		lastPositionEnvelopeUpdater.set(this, envelope);
	}

	void setLastHeadingEnvelopeUpdater(Envelope envelope) {
		lastHeadingEnvelopeUpdater.set(this, envelope);
	}

	void setLastEnvelopeUpdater(Envelope envelope) {
		lastEnvelopeUpdater.set(this, envelope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GPSProducer [pid=" + getPid() + "]";
	}

	@Override
	public Object polled(Wire wire) {
		return lastEnvelopeUpdater.get(this);
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires = wires;
		consumersConnected.set(wires != null ? wires.length : 0);
		if (wires == null || wires.length == 0) {
			logger.info(bundleMarker, "{} consumers disconnected", this);
		} else {
			for (Wire wire : wires) {
				logger.info(
						bundleMarker,
						"{} connected to {}",
						this,
						wire.getProperties().get(
								WireConstants.WIREADMIN_CONSUMER_PID));
			}
		}
	}

	@Override
	public String[] getStatusVariableNames() {
		return VARS;
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					consumersConnected.get());

		} else if (LAST_POSITION.equals(name)) {
			Envelope env = lastPositionEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent a position");
			}
			Position pos = (Position) env.getValue();
			StringBuilder buf = new StringBuilder("lat=");
			buf.append(DECIMAL_FORMATER.format(NMEAUtilities.toDegrees(pos
					.getLatitude().getValue())));
			buf.append(" degrees, lon=");
			buf.append(DECIMAL_FORMATER.format(NMEAUtilities
					.toDegrees(NMEAUtilities.toDegrees(pos.getLongitude()
							.getValue()))));
			buf.append(" degrees, alt=");
			buf.append(pos.getAltitude().getValue());
			buf.append(" meters");
			return new StatusVariable(name, StatusVariable.CM_DER,
					buf.toString());

		} else if (LAST_POSITION_TIME.equals(name)) {
			Envelope env = lastPositionEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent an position");
			}
			Position pos = (Position) env.getValue();
			long time = pos.getLatitude().getTime();
			Date date = new Date(time);

			return new StatusVariable(name, StatusVariable.CM_DER,
					date.toString());

		} else if (TOTAL_POSITION_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalPositions.get());

		} else if (LAST_ORIENTATION.equals(name)) {
			Envelope env = lastOrientationEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent a orientation");
			}
			AirMarPitchRoll pitchAndRoll = (AirMarPitchRoll) env.getValue();

			return new StatusVariable(name, StatusVariable.CM_DER,
					pitchAndRoll.toString());

		} else if (LAST_ORIENTATION_TIME.equals(name)) {
			Envelope env = lastOrientationEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent an orientation");
			}
			AirMarPitchRoll pitchAndRole = (AirMarPitchRoll) env.getValue();
			return new StatusVariable(name, StatusVariable.CM_DER, pitchAndRole
					.getDate().toString());

		} else if (TOTAL_ORIENTATION_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalOrientations.get());

		} else if (LAST_HEADING.equals(name)) {
			Envelope env = lastHeadingEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent a heading");
			}
			HeadingAndGroundSpeed headingAndGroundSpeed = (HeadingAndGroundSpeed) env
					.getValue();

			return new StatusVariable(name, StatusVariable.CM_DER,
					headingAndGroundSpeed.toString());

		} else if (LAST_HEADING_TIME.equals(name)) {
			Envelope env = lastHeadingEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent an heading");
			}
			HeadingAndGroundSpeed headingAndGroundSpeed = (HeadingAndGroundSpeed) env
					.getValue();
			return new StatusVariable(name, StatusVariable.CM_DER,
					headingAndGroundSpeed.getDate().toString());

		} else if (TOTAL_HEADING_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalHeadings.get());

			// ///
		} else if (LAST_ENVELOPE.equals(name)) {
			Envelope env = lastEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent an Envelope");
			}
			NMEAComposite nmeaComposite = (NMEAComposite) env.getValue();

			return new StatusVariable(name, StatusVariable.CM_DER,
					nmeaComposite.toString());

		} else if (LAST_HEADING_TIME.equals(name)) {
			Envelope env = lastHeadingEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent an heading");
			}
			HeadingAndGroundSpeed headingAndGroundSpeed = (HeadingAndGroundSpeed) env
					.getValue();
			return new StatusVariable(name, StatusVariable.CM_DER,
					headingAndGroundSpeed.getDate().toString());

		} else if (TOTAL_HEADING_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalHeadings.get());

			// //

		} else if (LAST_WEATHER.equals(name)) {
			Envelope env = lastWeatherEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent a weather");
			}

			WeatherComposite wc = (WeatherComposite) env.getValue();

			return new StatusVariable(name, StatusVariable.CM_DER,
					wc.toString());

		} else if (LAST_WEATHER_TIME.equals(name)) {
			Envelope env = lastWeatherEnvelopeUpdater.get(this);
			if (env == null) {
				return new StatusVariable(name, StatusVariable.CM_DER,
						"never sent a weather condition");
			}
			WeatherComposite pos = (WeatherComposite) env.getValue();

			return new StatusVariable(name, StatusVariable.CM_DER, pos
					.getDate().toString());

		} else if (TOTAL_WEATHER_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalWeathers.get());

			// /

		} else if (CONNECTION_URI_STATUS_VAR.equals(name)) {
			String uri = (String) config.get(CONNECTION_URI);
			return new StatusVariable(name, StatusVariable.CM_DER, uri);

		} else if (CONNECTED.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					connected != null ? connected.get() : false);

		} else if (INCOMPLETE_SENTENCES.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalIncompletes.get());

		} else if (CRC_ERRORS.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalCRCs.get());

		} else {
			throw new IllegalArgumentException("Invalid Status Variable name "
					+ name);
		}
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		if (CONNECTED.equals(id)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean resetStatusVariable(String name)
			throws IllegalArgumentException {
		if (TOTAL_POSITION_SENT.equals(name)) {
			totalPositions.set(0);
			return true;
		} else if (INCOMPLETE_SENTENCES.equals(name)) {
			totalIncompletes.set(0);
			return true;
		} else if (CRC_ERRORS.equals(name)) {
			totalCRCs.set(0);
			return true;
		}

		return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS.equals(id)) {
			return "The number of connected wires.";
		} else if (LAST_POSITION.equals(id)) {
			return "The last measurement sent to the Tracker transaction editor.";
		} else if (LAST_POSITION_TIME.equals(id)) {
			return "The identification associated with the last measurement sent to the Tracker transaction editor.";
		} else if (TOTAL_POSITION_SENT.equals(id)) {
			return "The total numver of measurements sent to the Tracker transaction editor.";
		} else if (CONNECTION_URI_STATUS_VAR.equals(id)) {
			return "The URI of the connected gateway.";
		} else if (CONNECTED.equals(id)) {
			return "If there is a connection to the gps device.";
		} else if (INCOMPLETE_SENTENCES.equals(id)) {
			return "Sentences received from the GPS device that had required information missing.";
		} else if (CRC_ERRORS.equals(id)) {
			return "Sentences received from the GPS device that failed CRC error checking.";
		}
		return null;
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		if (exec != null) {
			shutdownAndCleanUp();
			logger.info(bundleMarker, "{}: Re-Activating proxy.", this);
		} else {
			logger.info(bundleMarker, "{}: Activating proxy.", this);
		}
		exec = MoreExecutors
				.listeningDecorator(Executors.newCachedThreadPool());
		uri = (String) config.get(CONNECTION_URI);
		checkNotNull(uri, "Connection URI cannot be null.");

		String[] scopes = (String[]) config
				.get(WireConstants.WIREADMIN_PRODUCER_SCOPE);
		checkNotNull(scopes, "Producer scope cannot be null.");

		checkState(scopes.length == 1,
				"Producer scope must be set to one scope.");
		producerScope = scopes[0];

		this.config = config;
		logger.debug(bundleMarker, "{} Activating...", this);
		for (Map.Entry<String, Object> entry : config.entrySet()) {
			logger.debug(bundleMarker, "{} property key={} value={}",
					new Object[] { this, entry.getKey(), entry.getValue() });
		}

		proxy = new GPSProxy(this);
		// submit();
		logger.debug(bundleMarker, "{}: Submitting proxy.", this);
		lfuture = new IOFuture(exec.submit(proxy));
		lfuture.addListener(monitoringListener, exec);
	}

	/**
	 * Called by deactivate or when there is a new configuration and the old
	 * connection must be terminated
	 */
	private void shutdownAndCleanUp() {
		if (lfuture != null) {
			lfuture.cancel(true);
		}
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
		uri = null;
		producerScope = null;
		proxy = null;
		lastPositionEnvelopeUpdater.set(this, null);
		consumersConnected.set(0);
		lfuture = null;
		exec = null;
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		logger.debug(bundleMarker, "deactivating...");
		shutdownAndCleanUp();

	}

	boolean getCompositeMessages() {
		Object o = config.get(PRODUCT_CONSOLIDATE_MESSAGE);
		if (o instanceof Boolean) {
			return (Boolean) o;
		} else if (o instanceof String) {
			return Boolean.getBoolean((String) o);
		}

		return false;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param connectorService
	 *            the connectorService to set
	 */
	void setConnectorService(ConnectorService connectorService) {
		this.connectorService = connectorService;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param connectorService
	 *            the connectorService to set
	 */
	void unsetConnectorService(ConnectorService connectorService) {
		this.connectorService = null;
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		this.monitorListener = monitorListener;
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		this.monitorListener = null;
	}

	void setConnectedStatusVariable(boolean connected) {
		logger.debug(bundleMarker, "{} connected status set to {}", this,
				connected);
		try {
			this.connected.set(connected);

			if (monitorListener != null) {
				monitorListener.updated(getPid(), getStatusVariable(CONNECTED));
			}
		} catch (IllegalArgumentException e) {
			// ignore
		}
	}

	void incrementCRCErrorStatusVariable() {
		this.totalCRCs.incrementAndGet();
	}

	void incrementIncompleteSentenceStatusVariable() {
		this.totalIncompletes.incrementAndGet();
	}

	/**
	 * @return the connectorService
	 */
	ConnectorService getConnectorService() {
		return connectorService;
	}

	/**
	 * 
	 * @return the uri
	 */
	String getUri() {
		return uri;
	}

	/**
	 * 
	 * @return output production rate
	 */
	long getOutputRate() {
		long result = 1;
		Object o = config.get(PRODUCT_OUTPUT_RATE);
		if (o != null) {
			if (o instanceof String) {
				return new Long((String) o);
			}
			if (o instanceof Float) {
				Float f = (Float) o;
				return f.longValue();
			}
			result = (Long) o;
		}
		return result;
	}

	/**
	 * 
	 * @return altitude error
	 */
	double getAltitudeError() {
		double result = Double.NaN;
		Object o = config.get(ALT_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;
	}

	/**
	 * 
	 * @return altitude error
	 */
	double getLongitudeError() {
		double result = Double.NaN;
		Object o = config.get(LONG_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;
	}

	/**
	 * 
	 * @return altitude error
	 */
	double getLatitudeError() {
		double result = Double.NaN;
		Object o = config.get(LAT_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;
	}

	/**
	 * 
	 * @return pitch error
	 */
	double getPitchError() {
		double result = Double.NaN;
		Object o = config.get(PITCH_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;
	}

	/**
	 * 
	 * @return pitch error
	 */
	double getRollError() {
		double result = Double.NaN;
		Object o = config.get(ROLL_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;
	}

	public double getBarometricPressureError() {
		double result = Double.NaN;
		Object o = config.get(BAROMETRIC_PRESSURE_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;
	}

	public double getAirTemperatureError() {
		double result = Double.NaN;
		Object o = config.get(AIRTEMP_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;
	}

	public double getWindDirectionError() {
		double result = Double.NaN;
		Object o = config.get(WIND_DIRECTION_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;

	}

	public double getWindSpeedError() {
		double result = Double.NaN;
		Object o = config.get(WIND_SPEED_ERROR);
		if (o != null) {
			if (o instanceof String) {
				return new Double((String) o);
			}
			result = (Double) o;
		}
		return result;
	}

	Envelope packageAndSend(Object o) {
		if (wires != null && wires.length > 0) {
			Envelope envelope = new BasicEnvelope(o, null, producerScope);
			logger.debug(bundleMarker, "{}: sending {}, to {} consumers",
					new Object[] { this, o, wires.length });

			for (Wire wire : wires) {
				wire.update(envelope);
			}
			lastEnvelopeUpdater.set(this, envelope);
			return envelope;

		} else {
			logger.warn(bundleMarker, "{}: No wires found. Aborted sending {}",
					this, o);
			return null;
		}

	}

	String getPid() {
		return config != null ? (String) config.get("service.pid") : "null";
	}

	private void resubmit() {
		logger.warn(bundleMarker, "{}: resubmit invoked", this);
		if (!Thread.currentThread().isInterrupted()) {
			long delay = getRetryDelay();
			try {
				logger.debug(
						bundleMarker,
						"{} waiting {} seconds before attempting a connection to the device.",
						this, delay);
				TimeUnit.SECONDS.sleep(delay);
			} catch (InterruptedException e) {
				logger.warn(
						bundleMarker,
						"{}: Thread is Interrupted. Defering resubmission of proxy.",
						this);
				Thread.currentThread().interrupt();
				return;
			}
		} else {
			logger.warn(
					bundleMarker,
					"{}: Thread is Interrupted. Defering resubmission of proxy.",
					this);
			Thread.currentThread().interrupt();
			return;
		}
		logger.debug(bundleMarker, "{}: resubmitting proxy.", this);
		lfuture = new IOFuture(exec.submit(proxy));
		lfuture.addListener(monitoringListener, exec);
	}

	private final Runnable monitoringListener = new Runnable() {
		private final String label = "GPS Device Monitor []";

		@Override
		public void run() {
			if (lfuture.isCancelled()) {
				logger.warn(
						bundleMarker,
						"{}: Defering resubmission of the proxy because it was canceled. ",
						label);
			} else {
				try {
					lfuture.checkedGet();
				} catch (IOException e) {
					logger.warn(bundleMarker, label + ": pid=" + getPid()
							+ " failed to connect to " + getUri(), e);
				}
				resubmit();
			}
		}
	};


	private class IOFuture extends AbstractCheckedFuture<Void, IOException> {

		protected IOFuture(ListenableFuture<Void> delegate) {
			super(delegate);
		}

		@Override
		protected IOException mapException(Exception e) {
			if (e instanceof IOException) {
				return (IOException) e;
			} else if (e instanceof ExecutionException) {
				ExecutionException exex = (ExecutionException) e;
				if (exex.getCause() instanceof IOException) {
					return (IOException) exex.getCause();
				} else {
					return new IOException(exex.getCause());
				}
			}
			return new IOException(e);
		}

	}

	private long getRetryDelay() {
		long result = 5;
		Object o = config.get(CONNECTION_RETRY_DELAY);
		if (o != null) {
			if (o instanceof String) {
				return new Long((String) o);
			}
			if (o instanceof Float) {
				Float f = (Float) o;
				return f.longValue();
			}
			result = (Long) o;
		}
		return result;
	}



}
