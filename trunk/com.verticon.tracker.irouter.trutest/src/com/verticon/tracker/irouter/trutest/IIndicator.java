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
package com.verticon.tracker.irouter.trutest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Model for the TruTest Indicator. Provides a Writer, Reader, PID,
 * configuration, executorService and a scheduledExecutorService.
 * 
 * @author jconlon
 * 
 */
public interface IIndicator {

	/**
	 * Register the service with the framework. Invoked by the connection task
	 * once a connection is established.
	 */
	void registerProducer();

	/**
	 * Unregister the service with the framework. Invoked by the connection task
	 * when a connection is terminated.
	 */
	void unregisterProducer();

	/**
	 * Register the service the with the framework. Invoked by the connection
	 * task once a connection is established.
	 * 
	 * @throws InterruptedException
	 */
	void registerConsumer() throws InterruptedException;

	/**
	 * Unregister service with the framework. Invoked by the connection task
	 * when a connection is terminated.
	 */
	void unregisterConsumer();

	Writer getWriter() throws IOException;

	BufferedReader getReader() throws IOException;

	/**
	 * 
	 * @param key
	 * @return a String from the configuration
	 */
	String getConfigurationString(String key);

	/**
	 * 
	 * @param key
	 * @return a Long from the configuration
	 */
	Long getConfigurationLong(String key);
	
	/**
	 * 
	 * @param key
	 * @return a Boolean from the configuration
	 */
	Boolean getConfigurationBoolean(String key);
	
	/**
	 * 
	 * @param key
	 * @return a Integer from the configuration
	 */
	Integer getConfigurationInteger(String key);

	/**
	 * 
	 * @param key
	 * @return value
	 */
	Double getConfigurationDouble(String key);

	/**
	 * 
	 * @return configAdmin persistent id of the indicator
	 */
	String getPid();

	/**
	 * 
	 * @return scheduler for any background pollers.
	 */
	ScheduledExecutorService getScheduler();
	
//	/**
//	 * 
//	 * Producer and Consumer Callable objects MUST be preceeded
//	 * with a separate initializing task.  Producer and Consumer
//	 * tasks can wait for this gate to open signifying the initialization
//	 * task is done.
//	 * @return startGate
//	 */
//	CountDownLatch getStartGate();
//	
//	/**
//	 * Producer and Consumer Callable objects MAY need to be followed
//	 * with a separate cleanup task.  Producer and Consumer
//	 * tasks can toggle this gate to signifying they are terminated 
//	 * and the cleanup task can proceed.
//	 * 
//	 * @return endGate
//	 */
//	CountDownLatch getEndGate();
//	
	/**
	 * 
	 * @return file to up load to the indicator at startup
	 */
	File getUpload();
	
	/**
	 * 
	 * @return file to down load from the indicator at startup
	 */
	File getDownload();
	
//	/**
//	 * 
//	 * @return directory where file synchronization takes place.
//	 */
//	File getSynchronizationDirectory();
	
	/**
	 * 
	 * Initialization was successful.
	 */
	void initialized();
}
