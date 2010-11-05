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
package com.verticon.tracker.irouter.trutest.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.RESPONSE_PATTERN;
import static com.verticon.tracker.irouter.common.TrackerConstants.STABLE_WEIGHT_ERROR;
import static com.verticon.tracker.irouter.common.TrackerConstants.UNSTABLE_WEIGHT_ERROR;
import static com.verticon.tracker.irouter.trutest.internal.Component.bundleMarker;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ANIMAL_EID;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ANIMAL_WEIGHT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ENTER_KEY;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_STATE_ENTER_KEY_NAME;
import static com.verticon.tracker.irouter.trutest.internal.Constants.SEND_UNSTABLE_WEIGHTS;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.IEnvelopeSender;

public class EnvelopeProducerCallable implements Callable<Void> {

	private static final String INDICATOR_ACK = "^";
	private static final String BLANK_RESPONSE = "[]";
	private final Logger log = LoggerFactory
		.getLogger(EnvelopeProducerCallable.class);
	private final IIndicator indicator;
	private final IEnvelopeSender envelopeSender;
	private final Matcher matcher;
	private final double stableWeightError;
	private final double unStableWeightError;
	private final boolean produceUnstableWeights;
	private final String pid;
	private final String uri;
	private final CountDownLatch startGate;
	private Long lastEID = Long.valueOf(0);

	/**
	 * Constructs an envelopeProducer for the indicator.  The startGate is a latch
	 * to wait for the initializing task to complete.
	 * 
	 * @param indicator
	 * @param envelopeSender
	 * @param startGate
	 */
	public EnvelopeProducerCallable(IIndicator indicator,
			IEnvelopeSender envelopeSender,CountDownLatch startGate) {
		super();
		this.indicator = indicator;
		this.envelopeSender = envelopeSender;
		Pattern pattern = Pattern.compile(indicator
				.getConfigurationString(RESPONSE_PATTERN));
		stableWeightError= indicator.getConfigurationDouble(STABLE_WEIGHT_ERROR);
		unStableWeightError= indicator.getConfigurationDouble(UNSTABLE_WEIGHT_ERROR);
		matcher = pattern.matcher("");
		produceUnstableWeights= indicator.getConfigurationBoolean(SEND_UNSTABLE_WEIGHTS);
		pid = indicator.getPid();
		uri = indicator.getConfigurationString(CONNECTION_URI);
		this.startGate=startGate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnvelopeProducerCallable [uri=" + uri + ", pid="
				+ pid
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Void call() throws Exception {
		setConnectionStatusVariable(false);
		log.debug(bundleMarker,"{}: Waiting for initialization task to complete.", this);
		
		BufferedReader in = null;
		String uri = null;
		// There is a fixed 5 second timeout on socket if it blocking
		// waiting on a read. (there is no traffic)
		try {
//			indicator.getStartGate().await();
			log.debug("{}: Starting.", this);
			try {
				uri = indicator
						.getConfigurationString(CONNECTION_URI);
				in = indicator.getReader();
				setConnectionStatusVariable(true);
				startGate.countDown();
			} catch (NoRouteToHostException e){
				log.warn(bundleMarker,"{} :No Route to Host {} ", this, uri);
				throw e;
			} catch (UnknownHostException e) {
				log.warn(bundleMarker,"{} :Unknown Host {}", this, uri);
				throw e;
			} catch (ConnectException e) {
				log.warn(bundleMarker,"{} :Couldn't connect to: {} because {}", new Object[]{this, uri, e.getMessage()});
				throw e;
			} catch (IOException e) {
				log.warn(bundleMarker,"{} :Couldn't io exception connecting to: {} because {}", new Object[]{this, uri, e.getMessage()});
				throw e;
			}

			int timeouts = 0;
			// Preliminary housekeeping is done, register a service.
			indicator.registerProducer();
			// Main command response loop
			while (!Thread.currentThread().isInterrupted()) {

				try {
					process(in.readLine());
					timeouts=0;
				} catch (SocketTimeoutException e) {
					log.debug(bundleMarker,"{}: Timeout waiting for response to command.", this);
					timeouts++;
					if(timeouts>5){
						//More than 5 timeouts is considered a data connection failure.
						throw new IOException("Lost data connection to "+uri);
					}
					// this is normal

					// Typical reads will block waiting data, unless the timeout
					// flag is set on the socket. Without this flag set If there
					// is no
					// data to read the read will block awaiting data.
					// If this callable is then canceled through a thread
					// interruption
					// as is done by future.cancel(true) and exec.shutdownNow().
					// the while condition will not be hit, and the thread will
					// hangup
					// the shutdown or the future cancel. So we set the timeout
					// on the
					// socket to timeout on reads allowing the testing of the
					// condition
					// at the top of the loop. This way the interrupt condition
					// is detected
					// in a timely fashion.
				}
			}
		
		} finally {
			setConnectionStatusVariable(false);
			log.debug(bundleMarker,"{}: Terminating.", this);
			indicator.unregisterProducer();
			if (Thread.currentThread().isInterrupted()) {
				log.debug(bundleMarker,"{}: Task was cancelled.", this);
				
			}
			if (in != null) {
				log.debug(bundleMarker,"{}: Closing in.", this);
				
				in.close();
				in = null;
			}
			log.debug(bundleMarker,"{}: Terminated.", this);
			//Signal the cleanup task that this is terminated
//			indicator.getEndGate().countDown();
		}

		return null;
	}
	
	private void setConnectionStatusVariable(boolean connected){
		if(envelopeSender instanceof Indicator){
			((Indicator)envelopeSender).setConnectedStatusVariable(connected);
		}
	}

	/**
	 * Process the response from the indicator. Only interested in responses
	 * from the poll command sent out periodically by the CommandConsumer. Not
	 * all responses will be from the polling command. Ignore all others.
	 * 
	 * Method is declared package default because it is called by unit tests to
	 * test the regex.
	 * 
	 * @param response
	 * @throws IOException
	 */
	void process(String response) throws IOException {
		if (response == null) {
			throw new IOException("End of Stream");
		}

		matcher.reset(response.trim());
		if (matcher.matches()) {
			String rpResponse = matcher.group(1);
			log.debug(bundleMarker,"{}: Matched response {}",this,response.trim() );
			String[] rpResponses = rpResponse.split(",");
			for (String rp : rpResponses) {
				if (rp.length() < 3) {
					continue;
				}
				if (rp.startsWith("ID")) {
					log.debug(bundleMarker,"{}: ID fragment {}",this,rp.substring(2) );
					sendID(rp.substring(2));
				} else if (rp.startsWith("WR")) {
					log.debug(bundleMarker,"{}: WR fragment {}",this,rp.substring(2) );
					sendWeight(rp.substring(2), stableWeightError);
					sendRecord();
				} else if (rp.startsWith("WS")) {
					log.debug(bundleMarker,"{}: WS fragment {}",this,rp.substring(2) );
					sendWeight(rp.substring(2), stableWeightError);
				} else if (rp.startsWith("WL")) {
					log.debug(bundleMarker,"{}: WL fragment {}",this,rp.substring(2) );
					sendUnstableWeight(rp.substring(2));
				} else{
					log.debug(bundleMarker,"{}: Unknown fragment {}",this,rp );
				}
			}
		} else if(response.equals(BLANK_RESPONSE)){
//			log.debug("{}: response was empty",this);
		} else if(response.equals(INDICATOR_ACK)){
//			log.debug("{}: response was ack",this);
		} else {
			    
				log.debug(bundleMarker,"{}: response={} did not match filter {}",
										new Object[]{this,
										response,
										indicator.getConfigurationString(RESPONSE_PATTERN)});
			
		}

	}

	/**
	 * Send an EID as a Long in an Envelope.
	 * @param rp
	 */
	private void sendID(String rp) {
		if(indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_EID)==null){
			return;
		}
		try {
			lastEID = Long.parseLong(rp);
			Envelope envelope = new BasicEnvelope(lastEID,// value
					lastEID,// identification
					indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_EID)// scope
			);
			log.debug(bundleMarker,"{}: Producing Animal EID={}", this, lastEID);
			
			envelopeSender.send(envelope);
		} catch (NumberFormatException e) {
			// ignore
		}
	}

	private void sendWeight(String rp, double error) {
		try {
			double result = Double.parseDouble(rp);
			sendWeight(error, result);
		} catch (NumberFormatException e) {
			// ignore
		}
	}
	
	private void sendUnstableWeight(String rp) {
		try {
			double result = Double.parseDouble(rp);
			if(produceUnstableWeights || result == 0){
				sendWeight(unStableWeightError, result);
			}else{
				log.debug(bundleMarker,"{}: produceUnstableWeights=false, defer sending Animal Weight={}", this,
						result);
			}
			
		} catch (NumberFormatException e) {
			// ignore
		}
	}

	/**
	 * Sends animal weight as an Envelope identified with the eid
	 * @param error
	 * @param result
	 */
	private void sendWeight(double error, double result) {
		Measurement weight = new Measurement(result, error, Unit.kg, System
				.currentTimeMillis());
		Envelope envelope = new BasicEnvelope(weight,// value
				lastEID,// identification Ticket#641
				indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_WEIGHT)// scope
		);
		log.debug(bundleMarker,"{}: Producing Animal Weight={}", this,
					result);
		
		envelopeSender.send(envelope);
	}

	/**
	 * Send a State in an Envelope identified with the EID indicating an Enter
	 * key press.
	 */
	private void sendRecord() {
		State state = new State(1, 
				indicator.getConfigurationString(PRODUCER_STATE_ENTER_KEY_NAME), 
				System.currentTimeMillis());
		Envelope envelope = new BasicEnvelope(state,// value
				lastEID,// identification 
				indicator.getConfigurationString(PRODUCER_SCOPE_ENTER_KEY)// scope
		);
		log.debug(bundleMarker,"{}: Producing Animal record state.", this);
		
		envelopeSender.send(envelope);
		lastEID = Long.valueOf(0);
	}

}
