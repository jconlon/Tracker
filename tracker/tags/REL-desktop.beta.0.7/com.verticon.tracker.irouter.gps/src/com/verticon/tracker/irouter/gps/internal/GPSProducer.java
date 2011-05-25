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
package com.verticon.tracker.irouter.gps.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * 
 * GPSProducer manages connections to a gps device with a GPSProxy to produce
 * Position objects.
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
	
	//Misc
	private static final DecimalFormat DECIMAL_FORMATER = new DecimalFormat("##.#####");
	//Degrees & Radians conversion
	private static final double PiOver180 = Math.PI / 180.0;


	// Proxy futures
	private static ExecutorService exec = Executors.newCachedThreadPool();
	// private volatile Future<Void> taskMonitorFuture;
	private volatile AbstractCheckedFuture<Void, IOException> lfuture = null;
	private volatile GPSProxy proxy = null;

	private final Logger logger = LoggerFactory.getLogger(GPSProducer.class);

	// config
	private static final String CONNECTION_RETRY_DELAY = "connection.retry.seconds";
	private static final String PRODUCT_OUTPUT_RATE = "product.output.rate";
	private static final String CONNECTION_URI = "connection.uri";
	private static final String ALT_ERROR = "altitude.error";
	private static final String LONG_ERROR = "longitude.error";
	private static final String LAT_ERROR = "latitude.error";
	
	private Map<String, Object> config = null;

	// stats
	private static final String CONNECTED_CONSUMERS = "producer.Connected_Consumers";
	private final AtomicInteger consumersConnected = new AtomicInteger(0);
	private static final String LAST_POSITION = "producer.Last_Position";
	private static final String TOTAL_POSITION_SENT = "producer.Total_Positions_Sent";
	private final AtomicInteger totalPositions = new AtomicInteger(0);
	private static final String CONNECTION_URI_STATUS_VAR = "producer.Connection_URI";
	private static final String LAST_POSITION_TIME = "producer.Last_Position_Time";
	private static final String CONNECTED = "producer.Is_Connected";
	private static final String CRC_ERRORS = "producer.CRC_Sentences";
	private final AtomicInteger totalCRCs = new AtomicInteger(0);
	private static final String INCOMPLETE_SENTENCECES = "producer.Incomplete_Sentences";
	private final AtomicInteger totalIncompletes = new AtomicInteger(0);
	
	private AtomicBoolean connected = new AtomicBoolean();
	private static final String[] VARS = new String[] { CONNECTED_CONSUMERS,
			LAST_POSITION, LAST_POSITION_TIME, TOTAL_POSITION_SENT,
			CONNECTION_URI_STATUS_VAR, CONNECTED, INCOMPLETE_SENTENCECES, CRC_ERRORS};

	// Injected service
	private ConnectorService connectorService = null;
	private MonitorListener monitorListener;

	private Wire[] wires = null;
	private String uri = null;
	private String producerScope = null;

	// Product
	@SuppressWarnings("unused")
	private volatile Envelope lastEnvelope = null;
	private static final AtomicReferenceFieldUpdater<GPSProducer, Envelope> lastEnvelopeUpdater = AtomicReferenceFieldUpdater
			.newUpdater(GPSProducer.class, Envelope.class, "lastEnvelope");

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
			Envelope env = lastEnvelopeUpdater.get(this);
			if(env ==null){
				return new StatusVariable(name, StatusVariable.CM_DER,"never sent an position");
			}
			Position pos = (Position)env.getValue();
			StringBuilder buf = new StringBuilder("lat=");
			buf.append(DECIMAL_FORMATER.format(toDegrees(pos.getLatitude().getValue())));
			buf.append(" degrees, lon=");
			buf.append(DECIMAL_FORMATER.format(toDegrees(toDegrees(pos.getLongitude().getValue()))));
			buf.append(" degrees, alt=");
			buf.append(pos.getAltitude().getValue());
			buf.append(" meters");
			return new StatusVariable(name, StatusVariable.CM_DER,
					buf.toString());
			
		} else if (LAST_POSITION_TIME.equals(name)) {
			Envelope env = lastEnvelopeUpdater.get(this);
			if(env ==null){
				return new StatusVariable(name, StatusVariable.CM_DER,"never sent an position");
			}
			Position pos = (Position)env.getValue();
			long time = pos.getLatitude().getTime();
			Date date = new Date(time);
			
			return new StatusVariable(name, StatusVariable.CM_DER,
					date.toString());

		} else if (TOTAL_POSITION_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalPositions.get());
		} else if (CONNECTION_URI_STATUS_VAR.equals(name)) {
			String uri = (String) config.get(CONNECTION_URI);
			return new StatusVariable(name, StatusVariable.CM_DER, uri);

		} else if (CONNECTED.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					connected != null?connected.get():false);
			
		} else if (INCOMPLETE_SENTENCECES.equals(name)) {
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
		}else if (INCOMPLETE_SENTENCECES.equals(name)) {
				totalIncompletes.set(0);
				return true;
		}else if (CRC_ERRORS.equals(name)) {
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
		} else if (INCOMPLETE_SENTENCECES.equals(id)) {
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
		Object o = config.get(CONNECTION_URI);
		checkNotNull(o, "Connection URI cannot be null.");
		uri = (String) o;

		o = config.get(WireConstants.WIREADMIN_PRODUCER_SCOPE);
		checkNotNull(o, "Producer scope cannot be null.");
		String[] scopes = (String[]) o;
		checkState(scopes.length == 1,
				"Producer scope must be set to one scope.");
		producerScope = scopes[0];

		uri = (String) config.get(CONNECTION_URI);
		this.config = config;
		logger.debug(bundleMarker, "{} Activating...", this);
		for (Map.Entry<String, Object> entry : config.entrySet()) {
			logger.debug(bundleMarker, "{} property key={} value={}",
					new Object[] { this, entry.getKey(), entry.getValue() });
		}
		proxy = new GPSProxy(this);
		// submit();
		logger.debug(bundleMarker, "{}: Submitting proxy.", this);
		Future<Void> future = exec.submit(proxy);
		lfuture = new IOFuture(Futures.makeListenable(future));
		lfuture.addListener(monitoringListener, exec);
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		logger.debug(bundleMarker, "deactivating...");
		lfuture.cancel(true);
		config.clear();
		uri = null;
		producerScope = null;
		proxy = null;
		lastEnvelopeUpdater.set(this, null);
		consumersConnected.set(0);

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
		this.connected.set(connected);

		if (monitorListener != null) {
			monitorListener.updated(getPid(), getStatusVariable(CONNECTED));
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
			if(o instanceof String){
				return new Long((String)o);
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
			if(o instanceof String){
				return new Double((String)o);
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
			if(o instanceof String){
				return new Double((String)o);
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
			if(o instanceof String){
				return new Double((String)o);
			}
			result = (Double) o;
		}
		return result;
	}

	/**
	 * Send a position to the consumers
	 * 
	 * @param position
	 */
	void send(Position position) {
		if (wires != null && wires.length > 0) {
			Envelope envelope = new BasicEnvelope(position, null, producerScope);
			logger.debug(bundleMarker,
					"{}: sending position={}, to {} consumers", new Object[] {
							this, position, wires.length });

			for (Wire wire : wires) {
				wire.update(envelope);
			}
			lastEnvelopeUpdater.set(this, envelope);
			totalPositions.incrementAndGet();
		} else {
			logger.warn(bundleMarker,
					"{}: No wires found. Aborted sending position={}", this,
					position);
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
		Future<Void> future = exec.submit(proxy);
		lfuture = new IOFuture(Futures.makeListenable(future));
		lfuture.addListener(monitoringListener, exec);
	}

	private final Runnable monitoringListener = new Runnable() {
		private String label = "GPS Device Monitor []";

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
					logger.warn(bundleMarker, label+": pid="+getPid()+" failed to connect to "+getUri(),
							 e);
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
			if(o instanceof String){
				return new Long((String)o);
			}
			result = (Long) o;
		}
		return result;
	}

	/**
	    * Convert degrees to radians.
	    * @param degrees
	    * @return radians
	    */
	   static double toRadians( double degrees )
	   {
	      return degrees * PiOver180;
	   }
	   
	   /**
	    * Convert radians to degrees.
	    * @param radians
	    * @return degrees
	    */
	   static double toDegrees( double radians )
	   {
	      return radians / PiOver180;
	   }
}
