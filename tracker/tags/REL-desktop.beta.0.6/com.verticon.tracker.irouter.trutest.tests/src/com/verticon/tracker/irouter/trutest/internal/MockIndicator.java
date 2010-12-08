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
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CONSUME_COMMAND_DELAY;
import static com.verticon.tracker.irouter.trutest.internal.Constants.SEND_UNSTABLE_WEIGHTS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import javax.microedition.io.Connection;
import javax.microedition.io.StreamConnection;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.io.ConnectorService;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.connector.socket.SocketStreamConnection;
import com.verticon.tracker.irouter.common.IEnvelopeSender;
import com.verticon.tracker.irouter.trutest.internal.CommandConsumerCallable;
import com.verticon.tracker.irouter.trutest.internal.EnvelopeProducerCallable;
import com.verticon.tracker.irouter.trutest.internal.Indicator;
import com.verticon.tracker.irouter.trutest.internal.InitializerCallable;

class MockIndicator extends
			Indicator {
	
	/**
	 * slf4j Logger
	 */
	final Logger log = LoggerFactory.getLogger(MockIndicator.class);
		/**
		 * 
		 */
		final String uri;
		final MockConnectorService connectorService = new MockConnectorService();
		final StreamConnection sharedConnection ;
		final EnvelopeSender envelopeSender;
		final BlockingQueue<String[]> commandQueue;
		Integer displayDelay = 100;
		Boolean produceUnstableWeights= false;


		public MockIndicator(
				 
				String uri, 
				ExecutorService exec, 
				ScheduledExecutorService scheduler,
				BlockingQueue<String[]> commandQueue ) throws ConfigurationException, IOException {
			super("test", exec, scheduler,commandQueue);
			this.envelopeSender = new EnvelopeSender();
			this.uri = uri;
			this.sharedConnection = (StreamConnection) connectorService.open(uri,
					ConnectorService.READ_WRITE, true);
			this.commandQueue = commandQueue;
		}

		@Override
		public String toString() {
			return "IndicatorMockup";
		}
		
		int messageCount(){
			return envelopeSender.envelopes.size();
		}

		/**
		 * Override to prevent attempt to register the service with a framework
		 */
		@Override
		public void registerConsumer() throws InterruptedException {
			log.debug(this + " registeringConsumer()");
			initialize();//still need to initialize the mockIndicator
		}

		/**
		 * Override to prevent attempt to register the service with a framework
		 */
		@Override
		public void registerProducer() {
			log.debug(this + " registeringProducer() ");
		}
		
		/**
		 * Override to inject a envelopeSender and a commandQueue
		 * for sending commands and examining the output.
		 */
		@Override
		public Collection<Callable<Void>> getCallables() {
			log.debug(this + " getCallables called.");
			List<Callable<Void>> list = new ArrayList<Callable<Void>>();
			//These are the generic callables from this test class
//			list.add(new MockWritingCallable(this,commandQueue));
//			list.add(new MockReadingCallable(this));
			if(initialized){
				CountDownLatch startGate = new CountDownLatch(1);
				list.add(new EnvelopeProducerCallable(this, envelopeSender, startGate));
				list.add(new CommandConsumerCallable(this, commandQueue, startGate));
			}else{
				list.add(new InitializerCallable(this, null));
			}
			
			
//			list.add(new InitializerCallable(this));
//			//These are the real callables but with mock envelope Sender
//			list.add(new EnvelopeProducerCallable(this,envelopeSender));
//			//And a mock commandQueue 
//			list.add(new CommandConsumerCallable(this,commandQueue));
			return list;
		}
		
        /**
         * Don't have a real configuration use a URI and the defaults
         */
		@Override
		protected Object getConfiguration(String key) {
			if (key.equals(CONNECTION_URI)) {
				return uri;
			}else if(key.equals(CONSUME_COMMAND_DELAY)){
				return displayDelay;
			}else if(key.equals(SEND_UNSTABLE_WEIGHTS)){
				return produceUnstableWeights;	
			}else if(key.equals(TRACKER_WIRE_GROUP_NAME)){
				return "one";	
			
			} else {
				return DEFAULTS.get(key);
			} 
		}

		/**
		 * Must return the mock connectorService
		 */
		@Override
		public ConnectorService getConnectorService() throws IOException {
			return connectorService;
		}

		public void setBundleContext(BundleContext bundleContext) {
		}


		public BundleContext getBundleContext() {
			return null;
		}

		@Override
		public void setConfig(Dictionary<?, ?> config) throws ConfigurationException {
		}
		
		@Override
	    File getSynchronizationDirectory(){
			String syncDir = "testData";//getConfigurationString(DATA_SYNC_DIRECTORY);
			return new File(syncDir);
		}
		
		static class EnvelopeSender implements IEnvelopeSender{
			List<Envelope> envelopes = new ArrayList<Envelope>();
			
			@Override
			public void send(Envelope envelope) {
				envelopes.add(envelope);
			}
			
		}

		/*
		 * To mock the OSGi ConnectorService.
		 * 
		 *
		 */
		class MockConnectorService implements ConnectorService {

			private Connection connection = null;

			@Override
			public Connection open(String arg0) throws IOException {
				return null;
			}

			@Override
			public String toString() {
				return "MockConnectorService []";
			}

			@Override
			public Connection open(String arg0, int arg1) throws IOException {
				return null;
			}

			@Override
			public synchronized Connection open(String name, int arg1, boolean timeouts)
					throws IOException {

				if(connection == null){
					log.info(this+" Opening connection name="+name+" timeouts="+true);
					connection = new SocketStreamConnection(name, timeouts);
				}
				return connection;
			}

			@Override
			public DataInputStream openDataInputStream(String arg0)
					throws IOException {
				return null;
			}

			@Override
			public DataOutputStream openDataOutputStream(String arg0)
					throws IOException {
				return null;
			}

			@Override
			public InputStream openInputStream(String arg0) throws IOException {
				return null;
			}

			@Override
			public OutputStream openOutputStream(String arg0) throws IOException {
				return null;
			}

		}
	}