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
/**
 * 
 */
package com.verticon.tracker.irouter.trutest.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.POLL_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.REQUEST_COMMAND;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.trutest.internal.Component.bundleMarker;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CONSUMER_SCOPE;
import static com.verticon.tracker.irouter.trutest.internal.Constants.NODE_LABEL;
import static com.verticon.tracker.irouter.trutest.internal.Constants.SET_RP_POLL_COMMAND_ID;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_OFF_ACK;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_ON_CRLF;
import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_FLAVORS;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_SCOPE;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.Utils;

/**
 * WireAdmin Consumer that consumes String commands writing commands to the
 * Tru-Test indicator. Sends a configured polling command to the indicator at a
 * configured period.
 * 
 * @author jconlon
 * 
 */
class CommandConsumer implements Consumer, Monitorable {
	
	private static final String WIRES_COUNT = "consumer.Connected_Producers";
	private static final String LAST_COMMANDS = "consumer.Last_Commands";
	
	private static final int RESET_INTERVAL_SECONDS = 10;
	private static final String[] INITIALIZE_COMMANDS = 
		new String[] {TURN_OFF_ACK, TURN_ON_CRLF, SET_RP_POLL_COMMAND_ID };


	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(CommandConsumer.class);


	private final IIndicator indicator;
	private final BlockingQueue<String[]> commandQueue;
	
	private ServiceRegistration serviceRegistration = null;
	private ScheduledFuture<?> pollingTask = null;
	private ScheduledFuture<?> writerFuture = null;
	
	private final AtomicInteger wiresConnected
    = new AtomicInteger(0);

	private String lastCommandsSent = null;
	
	/**
	 * 
	 * @param indicator context.
	 * @param commandQueue for injecting commands to send to the indicator.
	 */
	CommandConsumer(IIndicator indicator, BlockingQueue<String[]> commandQueue) {
		this.indicator = indicator;
		this.commandQueue = commandQueue;
	}

	@Override
	public String toString() {
		return "CommandConsumer [pid=" + indicator.getPid() + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#producersConnected(org.osgi.service
	 * .wireadmin.Wire[])
	 */
	@Override
	public void producersConnected(Wire[] wires) {
		wiresConnected.set(0);
		if (wires == null) {
			log.debug(bundleMarker,"{}: Not connected to any wires.", this);
		} else {
			HashSet<String> producers = new HashSet<String>();
			for (Wire wire : wires) {
				producers.add((String) wire.getProperties().get(
						WIREADMIN_PRODUCER_PID));
				wiresConnected.incrementAndGet();
			}
			
			log.debug(bundleMarker,"{}: Connected to {} wires, and {} producers={}", new Object[]{this,
						wires.length, producers.size(), producers});
			
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin.Wire, java.lang.Object)
	 */
	@Override
	public void updated(Wire arg0, Object in) {
		if (in instanceof String)
			processString((String) in);
		else
			processError(in);

	}

	/**
	 * Sends preliminary commands to the indicator.
	 * @throws InterruptedException
	 */
	void initialize() throws InterruptedException {
		log.debug(bundleMarker,"{}: Initializing.", this);
		commandQueue.put(INITIALIZE_COMMANDS);
		startPollingTask();
		startResettingTask();
	}

	/**
	 * Register as an OSGi service.
	 * @param bc
	 * @throws InterruptedException
	 */
	void register(BundleContext bc) throws InterruptedException {
		Hashtable<String, Object> regProps = new Hashtable<String, Object>();
		regProps.put(SERVICE_PID, indicator.getPid());
		regProps.put(WIREADMIN_CONSUMER_FLAVORS,
				new Class[] { String.class });
		regProps.put(TRACKER_WIRE_GROUP_NAME, indicator
				.getConfigurationString(TRACKER_WIRE_GROUP_NAME));
		regProps.put(CONNECTION_URI, indicator
				.getConfigurationString(CONNECTION_URI));
		regProps.put(NODE_LABEL, indicator.getConfigurationString(NODE_LABEL));
		regProps.put(WIREADMIN_CONSUMER_SCOPE, 
				indicator.getConfigurationStringArray(CONSUMER_SCOPE));
		serviceRegistration = bc.registerService(Consumer.class.getName(),
				this, regProps);

	}

	/**
	 * Shutdown and Unregister as an OSGi service
	 */
	void unRegister() {
		if (pollingTask != null) {
			pollingTask.cancel(true);
		}
		if (writerFuture != null) {
			writerFuture.cancel(true);
			writerFuture = null;
		}
		if (serviceRegistration != null) {
			try {
				serviceRegistration.unregister();
			} catch (Exception e) {
				//Ignore
			}
			serviceRegistration = null;
		}
		if(commandQueue.size()>1){
			log.debug(bundleMarker,"{}: Clearing commandQueue of {} commands", this, commandQueue.size());
			commandQueue.clear();
		}
	}

	/**
	 * Strings are considered to be an array of commands delimited by linefeeds
	 * with each command terminated with a cr. This command array will be
	 * submitted to the indicator via the commandQueue.
	 * 
	 * @param commands
	 */
	void processString(String commands) {
		try {
			lastCommandsSent=commands.replace('\n', ';');
			commandQueue.put(commands.split("\n"));
			if(commandQueue.size()>10){
				log.warn(bundleMarker,"{}: queue depth={}", this, commandQueue.size());
			}
		} catch (InterruptedException e) {
			// Restore the interrupted status
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Starts a polling task that will be canceled by {@link #unRegister()}.
	 */
	private void startPollingTask() {
		String command = indicator
				.getConfigurationString(REQUEST_COMMAND);
		command = Utils.fromAscii(command);
		SendPollingCommand sendPollingCommand = new SendPollingCommand(new String[] { command });
		long delay = indicator.getConfigurationLong(POLL_DELAY)
				.longValue();
		pollingTask = indicator.getScheduler().scheduleWithFixedDelay(sendPollingCommand, delay,
				delay, TimeUnit.MILLISECONDS);

	}
	
	/**
	 * TruTest indicator looses sync whenever it is powered down and back up.
	 * This is a workaround to resync the indicator.
	 * 
	 * See Ticket#474 for details
	 */
	private void startResettingTask() {
		SendPollingCommand sendPollingCommand = new SendPollingCommand(INITIALIZE_COMMANDS);
		
		writerFuture = indicator.getScheduler().scheduleWithFixedDelay(sendPollingCommand, RESET_INTERVAL_SECONDS,
				RESET_INTERVAL_SECONDS, TimeUnit.SECONDS);

	}

	private void processError(Object in) {
		log.error(bundleMarker,"{}: Sent unknown command {}.", this,in);
	}

	private final class SendPollingCommand implements Runnable {
		private final String[] command;

		SendPollingCommand(String[] command) {
			this.command = command;
		}

		@Override
		public void run() {
			try {
				
				if(commandQueue.size()>10){
					log.warn(bundleMarker,"{}: Abort sending poll command {} because queue depth={}", 
							new Object[]{this, command, commandQueue.size()});
				}else{
					commandQueue.put(command);
				}
			} catch (InterruptedException e) {
				// Restore the interrupted status
				Thread.currentThread().interrupt();
			}
		}

	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[]{WIRES_COUNT,LAST_COMMANDS};
	}

	@Override
	public StatusVariable getStatusVariable(String name)
	throws IllegalArgumentException {
		
		if (WIRES_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_GAUGE,
					wiresConnected.get()
					);
		}if (LAST_COMMANDS.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_DER,
					lastCommandsSent
					);
		}else{
			throw new IllegalArgumentException(
					"Invalid Status Variable name " + name);
		}
	}
	
	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {

		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {	
		if (WIRES_COUNT.equals(name)){
			return
			"The number of connected producers.";
		}if (LAST_COMMANDS.equals(name)){
			return "Last set of commands sent to the scalehead";
		}
		return null;
	}
}