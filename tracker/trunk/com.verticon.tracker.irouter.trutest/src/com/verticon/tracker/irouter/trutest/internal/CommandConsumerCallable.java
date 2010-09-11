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
import static com.verticon.tracker.irouter.trutest.internal.Component.bundleMarker;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CONSUME_COMMAND_DELAY;

import java.io.IOException;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.Utils;

public class CommandConsumerCallable implements Callable<Void> {

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(CommandConsumerCallable.class);


	private final IIndicator indicator;
	private final BlockingQueue<String[]> commandQueue;
	private final int pause;
	private final String pid;
	private final String uri;
	private final CountDownLatch startGate;

	public CommandConsumerCallable(IIndicator indicator,
			BlockingQueue<String[]> commandQueue,CountDownLatch startGate) {
		super();
		this.indicator = indicator;
		this.commandQueue = commandQueue;
		this.pause = indicator.getConfigurationInteger(CONSUME_COMMAND_DELAY);
	    uri = indicator.getConfigurationString(CONNECTION_URI);
	    pid = indicator.getPid() ;
	    this.startGate = startGate;
	}

	@Override
	public String toString() {
		return "CommandConsumerCallable [uri=" + uri + ", pid="
				+ pid
				+ "]";
	}

	@Override
	public Void call() throws Exception {
		
		Writer out = null;
		String uri = null;
		try {
			log.debug(bundleMarker,"{}: Waiting for initialization task to complete.", this);
			startGate.await();
			log.debug(bundleMarker,"{}: Starting.", this);
			try {
				uri = indicator
						.getConfigurationString(CONNECTION_URI);
				out = indicator.getWriter();

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
			// Set up complete register the consumer before writing commands to
			// the indicator.
			indicator.registerConsumer();
			// Main command response loop
			while (!Thread.currentThread().isInterrupted()) {
				TimeUnit.MILLISECONDS.sleep(pause);
				String commands[] = commandQueue.take();
				for (String command : commands) {
					if (command != null && command.length() > 0) {
						if(!command.startsWith("{RP}")){
							log.debug(bundleMarker,"{}: Writing command={}", this,Utils.toAscii(command));
						}
						out.write(command);
						out.flush();
					}
				}

			}
		} catch (InterruptedException e) {
			 //Allow thread to exit
			 log.debug(bundleMarker,"{}: Interrupted.", this);
		} finally {
			log.debug(bundleMarker,"{}:Terminating.", this);
			indicator.unregisterConsumer();
			if (Thread.currentThread().isInterrupted()) {
				log.debug(bundleMarker,"{}: Cancelled.", this);
			}
			if (out != null) {
				log.debug(bundleMarker,"{}: Closing out.", this);
				out.close();
			}
			
			log.debug(bundleMarker,"{}: Terminated.", this);
			//Signal the cleanup task that this is terminated
//			indicator.getEndGate().countDown();
		}

		return null;
	}

}
