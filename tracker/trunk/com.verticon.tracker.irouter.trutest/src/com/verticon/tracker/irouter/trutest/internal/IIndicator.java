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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
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
	void registerMonitorable();

	/**
	 * Unregister the service with the framework. Invoked by the connection task
	 * when a connection is terminated.
	 */
	void unregisterMonitorable();
	
	/**
	 * Number of records uploaded to the indicator
	 * @param upLoadedRecords
	 */
	void setUpLoadedRecords(int upLoadedRecords);
	
	/**
	 * Number of records downloaded to the indicator
	 * @param downLoadedRecords
	 */
	void setDownLoadedRecords(int downLoadedRecords);
	
	
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
	
	/**
	 * 
	 * Initialization was successful.
	 */
	void initialized();

    String[] getConfigurationStringArray(String key);
}
